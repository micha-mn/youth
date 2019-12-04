package com.liferay.portal.security.sso.linkedin.connect.internal.auto.login;

import com.liferay.portal.kernel.exception.PortalException;
import javax.servlet.http.HttpSession;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.model.User;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Reference;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.security.sso.linkedin.connect.LinkedInConnect;
import com.liferay.portal.kernel.security.auto.login.AutoLogin;
import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.security.auto.login.BaseAutoLogin;

@Component(immediate = true, service = { AutoLogin.class })
public class LinkedInConnectAutoLogin extends BaseAutoLogin
{
    private LinkedInConnect _linkedinConnect;
    @Reference
    private Portal _portal;
    private UserLocalService _userLocalService;
    
    protected String[] doLogin(final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        final long companyId = this._portal.getCompanyId(request);
        if (!this._linkedinConnect.isEnabled(companyId)) {
            return null;
        }
        final User user = this.getUser(request, companyId);
        if (user == null) {
            return null;
        }
        final String[] credentials = { String.valueOf(user.getUserId()), user.getPassword(), Boolean.FALSE.toString() };
        return credentials;
    }
    
    protected User getUser(final HttpServletRequest request, final long companyId) throws PortalException {
        final HttpSession session = request.getSession();
        final String emailAddress = (String)session.getAttribute("LINKEDIN_USER_EMAIL_ADDRESS");
        if (Validator.isNotNull(emailAddress)) {
            session.removeAttribute("LINKEDIN_USER_EMAIL_ADDRESS");
            return this._userLocalService.getUserByEmailAddress(companyId, emailAddress);
        }
        return null;
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