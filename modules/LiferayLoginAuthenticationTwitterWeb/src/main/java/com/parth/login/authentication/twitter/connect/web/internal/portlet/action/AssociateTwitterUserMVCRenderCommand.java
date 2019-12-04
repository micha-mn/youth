package com.parth.login.authentication.twitter.connect.web.internal.portlet.action;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.security.sso.twitter.connect.TwitterConnect;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "javax.portlet.name=com_liferay_login_web_portlet_FastLoginPortlet",
		"javax.portlet.name=com_liferay_login_web_portlet_LoginPortlet",
		"mvc.command.name=/login/associate_twitter_user" }, service = { MVCRenderCommand.class })
public class AssociateTwitterUserMVCRenderCommand implements MVCRenderCommand {
	private TwitterConnect _twitterConnect;
	private UserLocalService _userLocalService;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");

		if (!this._twitterConnect.isEnabled(themeDisplay.getCompanyId())) {
			throw new PortletException(new PrincipalException.MustBeEnabled(themeDisplay

					.getCompanyId(), new String[] { TwitterConnect.class.getName() }));
		}

		long twitterIncompleteUserId = ParamUtil.getLong(renderRequest, "userId");

		if (twitterIncompleteUserId != 0L) {
			User user = this._userLocalService.fetchUser(twitterIncompleteUserId);

			return renderUpdateAccount(renderRequest, user);
		}
		return "/login.jsp";
	}

	protected String renderUpdateAccount(PortletRequest portletRequest, User user) throws PortletException {
		portletRequest.setAttribute("selUser", user);

		return "/update_account.jsp";
	}

	@Reference(unbind = "-")
	protected void setTwitterConnect(TwitterConnect twitterConnect) {
		this._twitterConnect = twitterConnect;
	}

	@Reference(unbind = "-")
	protected void setUserLocalService(UserLocalService userLocalService) {
		this._userLocalService = userLocalService;
	}

}
