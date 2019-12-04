package com.deltafixes.login.authentication.linkedin.connect.web.internal.portlet.action;

import com.liferay.portal.kernel.model.UserGroupRole;
import java.util.Calendar;
import com.liferay.portal.kernel.model.Contact;
import java.util.List;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import java.io.InputStream;
import java.awt.image.BufferedImage;
import com.liferay.portal.kernel.util.FileUtil;
import java.io.FileInputStream;
import java.awt.image.RenderedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.portlet.PortletMode;
import java.util.Locale;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import org.osgi.service.component.annotations.Activate;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import javax.portlet.PortletModeException;
import java.io.IOException;
import javax.portlet.WindowStateException;
import javax.print.DocFlavor.BYTE_ARRAY;
import javax.portlet.PortletURL;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.model.User;
import javax.servlet.http.HttpSession;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Reference;
import com.liferay.portal.kernel.util.Portal;
import java.util.Map;
import com.liferay.portal.security.sso.linkedin.connect.LinkedInConnect;
import com.liferay.portal.kernel.struts.StrutsAction;
import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.struts.BaseStrutsAction;

@Component(immediate = true, property = { "/common/referer_jsp.jsp=/common/referer_jsp.jsp", "path=/portal/linkedin_connect_oauth", "portlet.login.login=portlet.login.login", "portlet.login.update_account=portlet.login.update_account" }, service = { StrutsAction.class })
public class LinkedInConnectAction extends BaseStrutsAction
{
    private LinkedInConnect _linkedinConnect;
    private final Map<String, String> _forwards;
    @Reference
    private Portal _portal;
    private UserLocalService _userLocalService;
    
    public LinkedInConnectAction() {
        this._forwards = new HashMap<String, String>();
    }
    
    public String execute(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
    	System.out.println("111111111111111111111111111111111111111111111111111111111111111111111111");
        final ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
        if (!this._linkedinConnect.isEnabled(themeDisplay.getCompanyId())) {
            throw new PrincipalException.MustBeEnabled(themeDisplay.getCompanyId(), new String[] { LinkedInConnect.class.getName() });
        }
        final HttpSession session = request.getSession();
        final String code = ParamUtil.getString(request, "code");
        final String token = this._linkedinConnect.getAccessToken(themeDisplay.getCompanyId(), code);
        if (!Validator.isNotNull(token)) {
            return this._forwards.get("/common/referer_jsp.jsp");
        }
        final User user = this.setLinkedinCredentials(session, themeDisplay.getCompanyId(), token);
        if (user != null && user.getStatus() == 6) {
            this.redirectUpdateAccount(request, response, user);
            return null;
        }
        this.sendLoginRedirect(request, response);
        return null;
    }
    
    private void sendLoginRedirect(final HttpServletRequest request, final HttpServletResponse response) throws WindowStateException, IOException, PortletModeException {
    	System.out.println("22222222222222222222222222222");
        final PortletURL portletURL = (PortletURL)PortletURLFactoryUtil.create(request, "com_liferay_login_web_portlet_LoginPortlet", "RENDER_PHASE");
        portletURL.setParameter("mvcRenderCommandName", "/login/login_redirect");
        portletURL.setWindowState(LiferayWindowState.POP_UP);
        response.sendRedirect(portletURL.toString());
    }
    
    private User setLinkedinCredentials(final HttpSession session, final long companyId, final String token) throws Exception {
    	System.out.println("3333333333333333333333333333333333333");
        final JSONObject jsonObject = this._linkedinConnect.getGraphResources(companyId, token);
        if (jsonObject == null || jsonObject.getJSONObject("error") != null) {
            return null;
        }
        User user = null;
        final String linkedInId = jsonObject.getString("id");
        final String emailAddress = jsonObject.getString("emailAddress");
        if (user == null && Validator.isNotNull(emailAddress)) {
            user = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, emailAddress);
            if (user != null && user.getStatus() != 6) {
                session.setAttribute("LINKEDIN_USER_EMAIL_ADDRESS", (Object)emailAddress);
            }
        }
        if (user != null) {
            if (user.getStatus() == 6) {
                session.setAttribute("LINKEDIN_INCOMPLETE_USER_ID", (Object)Long.valueOf(linkedInId));
                user.setEmailAddress(jsonObject.getString("emailAddress"));
                user.setFirstName(jsonObject.getString("firstName"));
                user.setLastName(jsonObject.getString("lastName"));
                return user;
            }
            user = this.updateUser(user, jsonObject);
        }
        else {
            user = this.addUser(session, companyId, jsonObject);
        }
        return user;
    }
    
    @Activate
    protected void activate(final Map<String, Object> properties) {
    	System.out.println("5555555555555555");
        this._forwards.put("/common/referer_jsp.jsp", GetterUtil.getString((Object)properties, "/common/referer_jsp.jsp"));
        this._forwards.put("portlet.login.login", GetterUtil.getString((Object)properties, "portlet.login.login"));
        this._forwards.put("portlet.login.update_account", GetterUtil.getString((Object)properties, "portlet.login.update_account"));
    }
    
    protected User addUser(final HttpSession session, final long companyId, final JSONObject jsonObject) throws Exception {
    	System.out.println("66666666666666");
        final long creatorUserId = 0L;
        final boolean autoPassword = true;
        final String password1 = "";
        final String password2 = "";
        final boolean autoScreenName = true;
        final String screenName = "";
        final String emailAddress = jsonObject.getString("emailAddress");
        final long facebookId = 0L;
        final String openId = "";
        final Locale locale = LocaleUtil.getDefault();
        final String firstName = jsonObject.getString("firstName");
        final String middleName = "";
        final String lastName = jsonObject.getString("lastName");
        final int prefixId = 0;
        final int suffixId = 0;
        final boolean male = true;
        final int birthdayMonth = 0;
        final int birthdayDay = 1;
        final int birthdayYear = 1970;
        final String jobTitle = "";
        final long[] groupIds = null;
        final long[] organizationIds = null;
        final long[] roleIds = null;
        final long[] userGroupIds = null;
        final boolean sendEmail = true;
        final ServiceContext serviceContext = new ServiceContext();
        User user = this._userLocalService.addUser(creatorUserId, companyId, autoPassword, password1, password2, autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName, middleName, lastName, (long)prefixId, (long)suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail, serviceContext);
        user = this._userLocalService.updateLastLogin(user.getUserId(), user.getLoginIP());
        user = this._userLocalService.updatePasswordReset(user.getUserId(), false);
        user = this._userLocalService.updateEmailAddressVerified(user.getUserId(), true);
        session.setAttribute("LINKEDIN_USER_EMAIL_ADDRESS", (Object)emailAddress);
        this.profileUploader(user.getUserId(), jsonObject);
        return user;
    }
    
    protected void redirectUpdateAccount(final HttpServletRequest request, final HttpServletResponse response, final User user) throws Exception {
        final PortletURL portletURL = (PortletURL)PortletURLFactoryUtil.create(request, "com_liferay_login_web_portlet_LoginPortlet", "RENDER_PHASE");
        portletURL.setParameter("saveLastPath", Boolean.FALSE.toString());
        portletURL.setParameter("mvcRenderCommandName", "/login/associate_linkedin_user");
        portletURL.setParameter("redirect", ParamUtil.getString(request, "redirect"));
        portletURL.setParameter("userId", String.valueOf(user.getUserId()));
        portletURL.setParameter("emailAddress", user.getEmailAddress());
        portletURL.setParameter("firstName", user.getFirstName());
        portletURL.setParameter("lastName", user.getLastName());
        portletURL.setPortletMode(PortletMode.VIEW);
        portletURL.setWindowState(LiferayWindowState.POP_UP);
        response.sendRedirect(portletURL.toString());
    }
    
    protected void profileUploader(final long userId, final JSONObject userDetail) throws Exception {
        final URL url = new URL(userDetail.getString("profileImageUrl"));
        final BufferedImage img = ImageIO.read(url);
        final File file = new File(userDetail.getString("id") + ".jpg");
        ImageIO.write(img, "jpg", file);
        final InputStream is = new FileInputStream(file);
        final byte[] bytes = FileUtil.getBytes(is);
        try {
            UserLocalServiceUtil.updatePortrait(userId, bytes);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Reference(unbind = "-")
    protected void setLinkedInConnect(final LinkedInConnect linkedinConnect) {
    	System.out.println("setUserLocalService:     555555555555555");
    	System.out.println("bbbbbbbbbbbbbbbbbbfvfv");
        this._linkedinConnect = linkedinConnect;
    }
    
    @Reference(unbind = "-")
    protected void setUserLocalService(final UserLocalService userLocalService) {
    	System.out.println("setUserLocalService:     123");
        this._userLocalService = userLocalService;
    }
    
    protected User updateUser(final User user, final JSONObject jsonObject) throws Exception {
        final String emailAddress = jsonObject.getString("emailAddress");
        final String firstName = jsonObject.getString("firstName");
        final String lastName = jsonObject.getString("lastName");
        if (emailAddress.equals(user.getEmailAddress()) && firstName.equals(user.getFirstName()) && lastName.equals(user.getLastName())) {
            return user;
        }
        final Contact contact = user.getContact();
        final Calendar birthdayCal = CalendarFactoryUtil.getCalendar();
        birthdayCal.setTime(contact.getBirthday());
        final int birthdayMonth = birthdayCal.get(2);
        final int birthdayDay = birthdayCal.get(5);
        final int birthdayYear = birthdayCal.get(1);
        final long[] groupIds = null;
        final long[] organizationIds = null;
        final long[] roleIds = null;
        final List<UserGroupRole> userGroupRoles = null;
        final long[] userGroupIds = null;
        final ServiceContext serviceContext = new ServiceContext();
        if (!StringUtil.equalsIgnoreCase(emailAddress, user.getEmailAddress())) {
            UserLocalServiceUtil.updateEmailAddress(user.getUserId(), "", emailAddress, emailAddress);
        }
        UserLocalServiceUtil.updateEmailAddressVerified(user.getUserId(), true);
        
        return UserLocalServiceUtil.updateUser(user.getUserId(), "", "","", false, user.getReminderQueryQuestion(), user.getReminderQueryAnswer(), user.getScreenName(), emailAddress, user.getFacebookId(), user.getOpenId(), false, new byte[6 / 2], user.getLanguageId(), user.getTimeZoneId(), user.getGreeting(), user.getComments(), firstName, user.getMiddleName(), lastName, contact.getPrefixId(), contact.getSuffixId(), true, birthdayMonth, birthdayDay, birthdayYear, contact.getSmsSn(), contact.getFacebookSn(), contact.getJabberSn(), contact.getSkypeSn(), contact.getTwitterSn(), contact.getJobTitle(), groupIds, organizationIds, roleIds, userGroupRoles, userGroupIds, serviceContext);
       }
}