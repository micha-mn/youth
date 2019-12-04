package com.parth.login.authentication.twitter.connect.web.internal.portlet.action;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.struts.StrutsAction;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.sso.twitter.connect.TwitterConnect;
import com.liferay.portal.security.sso.twitter.connect.constants.TwitterConnectWebKeys;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

@Component(immediate = true, property = { "path=/portal/twitter_connect_oauth" }, service = { StrutsAction.class })
public class TwitterConnectAction implements StrutsAction {
	private TwitterConnect _twitterConnect;
	private final Map<String, String> _forwards;
	private UserLocalService _userLocalService;
	@Reference
	private Portal _portal;

	public TwitterConnectAction() {
		this._forwards = new HashMap<String, String>();
	}

	@Override
	public String execute(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		final ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
		final HttpSession session = request.getSession(true);
		if (!this._twitterConnect.isEnabled(themeDisplay.getCompanyId())) {
			throw new PrincipalException.MustBeEnabled(themeDisplay.getCompanyId(),
					new String[] { TwitterConnect.class.getName() });
		}
		Twitter twitter = (Twitter) session.getAttribute("equinox.http.com.liferay.login.webTWITTER_J");
		RequestToken requestToken = (RequestToken) session
				.getAttribute("equinox.http.com.liferay.login.webTWITTER_J_REQ_TOKEN");
		if (Validator.isNull(twitter) && Validator.isNull(requestToken)) {
			twitter = (Twitter) session.getAttribute("equinox.http.login-webTWITTER_J");
			requestToken = (RequestToken) session.getAttribute("equinox.http.login-webTWITTER_J_REQ_TOKEN");
		}
		final AccessToken accessToken = this.getTwitterAccessToken(twitter, requestToken, request);
		if (!Validator.isNotNull(accessToken)) {
			return this._forwards.get("/common/referer_jsp.jsp");
		}
		final User user = this.setTwitterCredentials(session, themeDisplay.getCompanyId(), accessToken);
		if (user != null && user.getStatus() == 6) {
			this.redirectUpdateAccount(request, response, user);
			return null;
		}
		this.sendLoginRedirect(request, response);
		return null;
	}

	private AccessToken getTwitterAccessToken(final Twitter twitter, final RequestToken requestToken,
			final HttpServletRequest request) throws TwitterException {
		final String verifier = request.getParameter("oauth_verifier");
		final AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, verifier);
		request.getSession().removeAttribute(TwitterConnectWebKeys.TWITTER_J_REQ_TOKEN);
		return accessToken;
	}

	private void sendLoginRedirect(final HttpServletRequest request, final HttpServletResponse response)
			throws WindowStateException, IOException {
		final PortletURL portletURL = PortletURLFactoryUtil.create(request,
				"com_liferay_login_web_portlet_LoginPortlet", "RENDER_PHASE");
		portletURL.setParameter("mvcRenderCommandName", "/login/login_redirect");
		portletURL.setWindowState(LiferayWindowState.POP_UP);
		response.sendRedirect(portletURL.toString());
	}

	private User setTwitterCredentials(final HttpSession session, final long companyId, final AccessToken accessToken)
			throws Exception {
		final JSONObject jsonObject = this.getUserResources(accessToken, companyId);
		if (jsonObject == null || jsonObject.getJSONObject("error") != null) {
			return null;
		}
		User user = null;
		final String twitterId = jsonObject.getString("userId");
		final String emailAddress = jsonObject.getString("emailAddress");
		final String screenName = jsonObject.getString("screenName");
		if (user == null && Validator.isNotNull(emailAddress)) {
			user = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, emailAddress);
			if (user != null && user.getStatus() != 6) {
				session.setAttribute(TwitterConnectWebKeys.TWITTER_USER_EMAIL_ADDRESS, emailAddress);
				session.setAttribute(TwitterConnectWebKeys.TWITTER_USER_SCREENNAME, screenName);
			}
		} else if (user == null && Validator.isNotNull(screenName)) {
			user = UserLocalServiceUtil.fetchUserByScreenName(companyId, screenName);
			if (user != null && user.getStatus() != 6) {
				session.setAttribute(TwitterConnectWebKeys.TWITTER_USER_SCREENNAME, screenName);
			}
		}
		if (user != null) {
			if (user.getStatus() == 6) {
				session.setAttribute("TWITTER_INCOMPLETE_USER_ID", Long.valueOf(twitterId));
				user.setEmailAddress(jsonObject.getString("emailAddress"));
				user.setFirstName(jsonObject.getString("firstName"));
				user.setLastName(jsonObject.getString("lastName"));
				return user;
			}
			user = this.updateUser(user, jsonObject);
		} else {
			user = this.addUser(session, companyId, jsonObject);
		}
		return user;
	}

	private JSONObject getUserResources(final AccessToken accessToken, final long companyId) throws TwitterException {
		final ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(this._twitterConnect.getConsumerKey(companyId))
				.setOAuthConsumerSecret(this._twitterConnect.getConsumerKeySecret(companyId))
				.setOAuthAccessToken(accessToken.getToken()).setOAuthAccessTokenSecret(accessToken.getTokenSecret())
				.setIncludeEmailEnabled(true);
		final TwitterFactory tf = new TwitterFactory(cb.build());
		final Twitter twitterUser = tf.getInstance();
		final twitter4j.User user = twitterUser.verifyCredentials();
		final String[] name = user.getName().split(" ");
		final JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("emailAddress", user.getEmail());
		jsonObject.put("screenName", user.getScreenName());
		jsonObject.put("firstName", name[0]);
		jsonObject.put("lastName",
				name.length > 1 && Validator.isNotNull(name[1]) && !name[1].isEmpty() ? name[1] : name[0]);
		jsonObject.put("profileImageUrl", user.getProfileImageURL());
		return jsonObject;
	}

	@Activate
	protected void activate(final Map<String, Object> properties) {
		this._forwards.put("/common/referer_jsp.jsp", GetterUtil.getString(properties, "/common/referer_jsp.jsp"));
		this._forwards.put("portlet.login.login", GetterUtil.getString(properties, "portlet.login.login"));
		this._forwards.put("portlet.login.update_account",
				GetterUtil.getString(properties, "portlet.login.update_account"));
	}

	protected User addUser(final HttpSession session, final long companyId, final JSONObject jsonObject)
			throws Exception {
		final long creatorUserId = 0L;
		final boolean autoPassword = true;
		final String password1 = "";
		final String password2 = "";
		final boolean autoScreenName = false;
		final String screenName = jsonObject.getString("screenName");
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
		User user = this._userLocalService.addUser(creatorUserId, companyId, autoPassword, password1, password2,
				autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName, middleName, lastName,
				prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds,
				roleIds, userGroupIds, sendEmail, serviceContext);
		user = this._userLocalService.updateLastLogin(user.getUserId(), user.getLoginIP());
		user = this._userLocalService.updatePasswordReset(user.getUserId(), false);
		user = this._userLocalService.updateEmailAddressVerified(user.getUserId(), true);
		session.setAttribute(TwitterConnectWebKeys.TWITTER_USER_EMAIL_ADDRESS, emailAddress);
		session.setAttribute(TwitterConnectWebKeys.TWITTER_USER_SCREENNAME, screenName);
		this.profileUploader(user.getUserId(), screenName, jsonObject);
		return user;
	}

	protected void redirectUpdateAccount(final HttpServletRequest request, final HttpServletResponse response,
			final User user) throws Exception {
		final PortletURL portletURL = PortletURLFactoryUtil.create(request,
				"com_liferay_login_web_portlet_LoginPortlet", "RENDER_PHASE");
		portletURL.setParameter("saveLastPath", Boolean.FALSE.toString());
		portletURL.setParameter("mvcRenderCommandName", "/login/associate_twitter_user");
		portletURL.setParameter("redirect", ParamUtil.getString(request, "redirect"));
		portletURL.setParameter("userId", String.valueOf(user.getUserId()));
		portletURL.setParameter("emailAddress", user.getEmailAddress());
		portletURL.setParameter("firstName", user.getFirstName());
		portletURL.setParameter("lastName", user.getLastName());
		portletURL.setPortletMode(PortletMode.VIEW);
		portletURL.setWindowState(LiferayWindowState.POP_UP);
		response.sendRedirect(portletURL.toString());
	}

	@Reference(unbind = "-")
	protected void setTwitterConnect(final TwitterConnect twitterConnect) {
		this._twitterConnect = twitterConnect;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(final UserLocalService userLocalService) {
		this._userLocalService = userLocalService;
	}

	protected User updateUser(final User user, final JSONObject jsonObject) throws Exception {
		final String emailAddress = jsonObject.getString("emailAddress");
		final String firstName = jsonObject.getString("firstName");
		final String lastName = jsonObject.getString("lastName");
		final String screenName = jsonObject.getString("screenName");
		if (emailAddress.equals(user.getEmailAddress()) && firstName.equals(user.getFirstName())
				&& lastName.equals(user.getLastName()) && screenName.equals(user.getScreenName())) {
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
		return UserLocalServiceUtil.updateUser(user.getUserId(), "", "", "", false, user.getReminderQueryQuestion(),
				user.getReminderQueryAnswer(), user.getScreenName(), emailAddress, user.getFacebookId(),
				user.getOpenId(), false, null, user.getLanguageId(), user.getTimeZoneId(), user.getGreeting(),
				user.getComments(), firstName, user.getMiddleName(), lastName, contact.getPrefixId(),
				contact.getSuffixId(), true, birthdayMonth, birthdayDay, birthdayYear, contact.getSmsSn(),
				contact.getFacebookSn(), contact.getJabberSn(), contact.getSkypeSn(), contact.getTwitterSn(),
				contact.getJobTitle(), groupIds, organizationIds, roleIds, userGroupRoles, userGroupIds,
				serviceContext);
	}

	protected void profileUploader(final long userId, final String screenName, final JSONObject userDetail)
			throws Exception {
		final URL url = new URL(userDetail.getString("profileImageUrl"));
		final BufferedImage img = ImageIO.read(url);
		final File file = new File(userDetail.getString("screenName") + ".png");
		ImageIO.write(img, "png", file);
		final InputStream is = new FileInputStream(file);
		final byte[] bytes = FileUtil.getBytes(is);
		try {
			UserLocalServiceUtil.updatePortrait(userId, bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
