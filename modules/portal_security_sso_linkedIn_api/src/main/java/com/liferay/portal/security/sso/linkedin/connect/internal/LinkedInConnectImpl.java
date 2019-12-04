package com.liferay.portal.security.sso.linkedin.connect.internal;

import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.settings.SettingsLocator;
import com.liferay.portal.kernel.settings.CompanyServiceSettingsLocator;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import com.liferay.portal.kernel.util.Validator;
import javax.portlet.PortletRequest;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.json.JSONObject;
import java.io.OutputStream;
import com.liferay.portal.security.sso.linkedin.connect.configuration.LinkedInConnectConfiguration;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import org.osgi.service.component.annotations.Reference;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.log.Log;
import org.osgi.service.component.annotations.Component;
import com.liferay.portal.security.sso.linkedin.connect.LinkedInConnect;

@Component(configurationPid = { "com.liferay.portal.security.sso.linkedin.connect.configuration.LinkedInConnectConfiguration" }, immediate = true, service = { LinkedInConnect.class })
public class LinkedInConnectImpl implements LinkedInConnect
{
    private static final Log _log;
    private ConfigurationProvider _configurationProvider;
    @Reference
    private Portal _portal;
    
    @Override
    public String getAccessToken(final long companyId, final String code) {
        final LinkedInConnectConfiguration linkedinConnectConfiguration = this.getLinkedInConnectConfiguration(companyId);
        HttpsURLConnection con = null;
        try {
            final String url = linkedinConnectConfiguration.oauthTokenURL();
            final URL obj = new URL(url);
            con = (HttpsURLConnection)obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("Host", "www.linkedin.com");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            final String urlParameters = "grant_type=authorization_code&code=" + code + "&redirect_uri=" + linkedinConnectConfiguration.oauthRedirectURL() + "&client_id=" + linkedinConnectConfiguration.appId() + "&client_secret=" + linkedinConnectConfiguration.appSecret() + "";
            con.setDoOutput(true);
            final OutputStream os = con.getOutputStream();
            os.write(urlParameters.getBytes("UTF-8"));
            os.flush();
            os.close();
            final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            final StringBuffer response = new StringBuffer();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            final JSONObject jsonObj = JSONFactoryUtil.createJSONObject(response.toString());
            final String access_token = jsonObj.getString("access_token");
            return access_token;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            con.disconnect();
        }
        return null;
    }
    
    @Override
    public String getAccessTokenURL(final long companyId) {
        final LinkedInConnectConfiguration linkedinConnectConfiguration = this.getLinkedInConnectConfiguration(companyId);
        return linkedinConnectConfiguration.oauthTokenURL();
    }
    
    @Override
    public String getAppId(final long companyId) {
        final LinkedInConnectConfiguration linkedinConnectConfiguration = this.getLinkedInConnectConfiguration(companyId);
        return linkedinConnectConfiguration.appId();
    }
    
    @Override
    public String getAppSecret(final long companyId) {
        final LinkedInConnectConfiguration linkedinConnectConfiguration = this.getLinkedInConnectConfiguration(companyId);
        return linkedinConnectConfiguration.appSecret();
    }
    
    @Override
    public String getAuthURL(final long companyId) {
        final LinkedInConnectConfiguration linkedinConnectConfiguration = this.getLinkedInConnectConfiguration(companyId);
        return linkedinConnectConfiguration.oauthAuthURL();
    }
    
    @Override
    public JSONObject getGraphResources(final long companyId, final String accessToken) {
        try {
            final LinkedInConnectConfiguration linkedinConnectConfiguration = this.getLinkedInConnectConfiguration(companyId);
            final String linkedinProfileURL = linkedinConnectConfiguration.graphURL();
            final String url = linkedinProfileURL + "/me";
            final String emailUrl = linkedinProfileURL + "/emailAddress?q=members&projection=(elements*(handle~))";
            final String profileUrl = linkedinProfileURL + "/me?projection=(profilePicture(displayImage~:playableStreams))";
            final Http.Options liteUser = new Http.Options();
            liteUser.setPost(false);
            liteUser.setLocation(url);
            liteUser.addHeader("Authorization", "Bearer " + accessToken);
            final Http.Options emailOptions = new Http.Options();
            emailOptions.setPost(false);
            emailOptions.setLocation(emailUrl);
            emailOptions.addHeader("Authorization", "Bearer " + accessToken);
            final Http.Options profileOption = new Http.Options();
            profileOption.setPost(false);
            profileOption.setLocation(profileUrl);
            profileOption.addHeader("Authorization", "Bearer " + accessToken);
            final String liteUserJson = HttpUtil.URLtoString(liteUser);
            final String emailjson = HttpUtil.URLtoString(emailOptions);
            final String profileUrljson = HttpUtil.URLtoString(profileOption);
            final JSONObject liteUserJsonObject = JSONFactoryUtil.createJSONObject(liteUserJson);
            final JSONObject emailJsonObject = JSONFactoryUtil.createJSONObject(emailjson);
            final JSONObject profileUrlJsonObject = JSONFactoryUtil.createJSONObject(profileUrljson);
            final String userProfileUrl = profileUrlJsonObject.getJSONObject("profilePicture").getJSONObject("displayImage~").getJSONArray("elements").getJSONObject(1).getJSONArray("identifiers").getJSONObject(0).getString("identifier");
            final JSONObject userProfile = JSONFactoryUtil.createJSONObject();
            userProfile.put("id", liteUserJsonObject.getString("id"));
            userProfile.put("firstName", liteUserJsonObject.getString("localizedFirstName"));
            userProfile.put("lastName", liteUserJsonObject.getString("localizedLastName"));
            userProfile.put("emailAddress", emailJsonObject.getJSONArray("elements").getJSONObject(0).getJSONObject("handle~").getString("emailAddress"));
            userProfile.put("profileImageUrl", userProfileUrl);
            return userProfile;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public String getGraphURL(final long companyId) {
        final LinkedInConnectConfiguration linkedinConnectConfiguration = this.getLinkedInConnectConfiguration(companyId);
        return linkedinConnectConfiguration.graphURL();
    }
    
    
    @Override
    public String getRedirectURL(final long companyId) {
        final LinkedInConnectConfiguration linkedinConnectConfiguration = this.getLinkedInConnectConfiguration(companyId);
        return linkedinConnectConfiguration.oauthRedirectURL();
    }
    
    @Override
    public boolean isEnabled(final long companyId) {
        final LinkedInConnectConfiguration linkedinConnectConfiguration = this.getLinkedInConnectConfiguration(companyId);
        return linkedinConnectConfiguration.enabled();
    }
    
    protected LinkedInConnectConfiguration getLinkedInConnectConfiguration(final long companyId) {
        try {
            final LinkedInConnectConfiguration linkedinConnectCompanyServiceSettings = (LinkedInConnectConfiguration)this._configurationProvider.getConfiguration((Class)LinkedInConnectConfiguration.class, (SettingsLocator)new CompanyServiceSettingsLocator(companyId, "com.liferay.portal.security.sso.linkedin.connect.auth"));
            return linkedinConnectCompanyServiceSettings;
        }
        catch (ConfigurationException ce) {
            LinkedInConnectImpl._log.error((Object)"Unable to get LinkedIn Connect configuration", (Throwable)ce);
            return null;
        }
    }
    
    @Reference(unbind = "-")
    protected void setConfigurationProvider(final ConfigurationProvider configurationProvider) {
        this._configurationProvider = configurationProvider;
    }
    
    static {
        _log = LogFactoryUtil.getLog((Class)LinkedInConnectImpl.class);
    }
}