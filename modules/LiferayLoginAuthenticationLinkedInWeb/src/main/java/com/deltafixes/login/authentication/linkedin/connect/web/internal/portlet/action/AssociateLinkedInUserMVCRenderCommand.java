package com.deltafixes.login.authentication.linkedin.connect.web.internal.portlet.action;

import org.osgi.service.component.annotations.Reference;
import com.liferay.portal.kernel.model.User;
import javax.portlet.PortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.portlet.PortletException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import javax.portlet.RenderResponse;
import javax.portlet.RenderRequest;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.security.sso.linkedin.connect.LinkedInConnect;
import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

@Component(immediate = true, property = { "javax.portlet.name=com_liferay_login_web_portlet_FastLoginPortlet", "javax.portlet.name=com_liferay_login_web_portlet_LoginPortlet", "mvc.command.name=/login/associate_linkedin_user" }, service = { MVCRenderCommand.class })
public class AssociateLinkedInUserMVCRenderCommand implements MVCRenderCommand
{
    private LinkedInConnect _linkedinConnect;
    private UserLocalService _userLocalService;
    
    public String render(final RenderRequest renderRequest, final RenderResponse renderResponse) throws PortletException {
    	System.out.println("1111111111");
        final ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
        if (!this._linkedinConnect.isEnabled(themeDisplay.getCompanyId())) {
            throw new PortletException((Throwable)new PrincipalException.MustBeEnabled(themeDisplay.getCompanyId(), new String[] { LinkedInConnect.class.getName() }));
        }
        final long linkedinIncompleteUserId = ParamUtil.getLong((PortletRequest)renderRequest, "userId");
        if (linkedinIncompleteUserId != 0L) {
            final User user = this._userLocalService.fetchUser(linkedinIncompleteUserId);
            return this.renderUpdateAccount((PortletRequest)renderRequest, user);
        }
        return "/login.jsp";
    }
    
    protected String renderUpdateAccount(final PortletRequest portletRequest, final User user) throws PortletException {
    	System.out.println("22222222222222");
        portletRequest.setAttribute("selUser", (Object)user);
        return "/update_account.jsp";
    }
    
    @Reference(unbind = "-")
    protected void setLinkedInConnect(final LinkedInConnect linkedinConnect) {
        this._linkedinConnect = linkedinConnect;
    }
    
    @Reference(unbind = "-")
    protected void setUserLocalService(final UserLocalService userLocalService) {
        this._userLocalService = userLocalService;
    }
}