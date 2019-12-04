package com.liferay.portal.security.sso.twitter.connect.internal.auto.login;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auto.login.BaseAutoLogin;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.sso.twitter.connect.TwitterConnect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = { com.liferay.portal.kernel.security.auto.login.AutoLogin.class })
public class TwitterConnectAutoLogin extends BaseAutoLogin {
	private TwitterConnect _twitterConnect;
	@Reference
	private Portal _portal;
	private UserLocalService _userLocalService;

	protected String[] doLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long companyId = this._portal.getCompanyId(request);

		if (!this._twitterConnect.isEnabled(companyId)) {
			return null;
		}

		User user = getUser(request, companyId);

		if (user == null) {
			return null;
		}

		String[] credentials = new String[3];

		credentials[0] = String.valueOf(user.getUserId());
		credentials[1] = user.getPassword();
		credentials[2] = Boolean.FALSE.toString();

		return credentials;
	}

	protected User getUser(HttpServletRequest request, long companyId) throws PortalException {
		HttpSession session = request.getSession();
		String emailAddress = (String) session.getAttribute("TWITTER_USER_EMAIL_ADDRESS");
		String screenName = (String) session.getAttribute("TWITTER_USER_SCREENNAME");

		if (Validator.isNotNull(emailAddress)) {
			session.removeAttribute("TWITTER_USER_EMAIL_ADDRESS");

			return this._userLocalService.getUserByEmailAddress(companyId, emailAddress);
		}

		if (Validator.isNotNull(screenName)) {
			return this._userLocalService.getUserByScreenName(companyId, screenName);
		}
		return null;
	}

	@Reference(unbind = "-")
	protected void setTwitterInConnect(TwitterConnect twitterConnect) {
		this._twitterConnect = twitterConnect;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		this._userLocalService = userLocalService;
	}
}
