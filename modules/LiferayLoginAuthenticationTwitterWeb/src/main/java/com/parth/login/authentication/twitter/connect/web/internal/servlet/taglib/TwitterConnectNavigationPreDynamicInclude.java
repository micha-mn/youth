package com.parth.login.authentication.twitter.connect.web.internal.servlet.taglib;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.taglib.BaseJSPDynamicInclude;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.sso.twitter.connect.TwitterConnect;
import com.liferay.portal.security.sso.twitter.connect.constants.TwitterConnectWebKeys;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

@Component(immediate = true, service = { DynamicInclude.class })
public class TwitterConnectNavigationPreDynamicInclude extends BaseJSPDynamicInclude {
	@Override
	public void include(HttpServletRequest request, HttpServletResponse response, String key) throws IOException {
		String strutsAction = ParamUtil.getString(request, "struts_action");

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		if (strutsAction.startsWith("/login/twitter_connect")
				|| !_twitterConnect.isEnabled(themeDisplay.getCompanyId())) {
			return;
		}

		String consumerKey = _twitterConnect.getConsumerKey(themeDisplay.getCompanyId());
		String secretKey = _twitterConnect.getConsumerKeySecret(themeDisplay.getCompanyId());
		String callbackURL = _twitterConnect.getCallbackURL(themeDisplay.getCompanyId()).toString();

		if (Validator.isNull(consumerKey) || Validator.isNull(secretKey) || Validator.isNull(callbackURL)) {
			_log.info("No twitter configurations found!");
			return;
		}

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(secretKey);

		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		RequestToken requestToken = null;
		try {
			requestToken = twitter.getOAuthRequestToken(callbackURL);

			if (Validator.isNotNull(requestToken)) {
				request.setAttribute(TwitterConnectWebKeys.TWITTER_OAUTH_LINK, requestToken.getAuthenticationURL());

				HttpSession session = request.getSession(true);
				session.setAttribute(TwitterConnectWebKeys.TWITTER_J, twitter);
				session.setAttribute(TwitterConnectWebKeys.TWITTER_J_REQ_TOKEN, requestToken);
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}

		super.include(request, response, key);
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register("com.liferay.login.web#/navigation.jsp#pre");
	}

	@Override
	protected String getJspPath() {
		return "/dynamic_include/com.liferay.login.web/navigation/twitter.jsp";
	}

	@Override
	protected Log getLog() {
		return _log;
	}

	@Override
	@Reference(target = "(osgi.web.symbolicname=com.liferay.login.authentication.twitter.web)", unbind = "-")
	protected void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

	private static final Log _log = LogFactoryUtil.getLog(TwitterConnectNavigationPreDynamicInclude.class.getClass());

	@Reference
	private TwitterConnect _twitterConnect;

}
