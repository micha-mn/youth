package com.deltafixes.login.authentication.linkedin.connect.web.internal.servlet.taglib;

import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Reference;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContext;
import com.liferay.portal.security.sso.linkedin.connect.LinkedInConnect;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.servlet.taglib.BaseDynamicInclude;

@Component(immediate = true, service = { DynamicInclude.class })
public class LinkedInConnectNavigationPreDynamicInclude extends BaseDynamicInclude
{
    private static final String _JSP_PATH = "/com.liferay.login.web/linkedin.jsp";
    private static final Log _log;
    private LinkedInConnect _linkedinConnect;
    private ServletContext _servletContext;
    
    public void include(final HttpServletRequest request, final HttpServletResponse response, final String key) throws IOException {
        final String strutsAction = ParamUtil.getString(request, "struts_action");
        final ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
        if (strutsAction.startsWith("/login/linkedin_connect") || !this._linkedinConnect.isEnabled(themeDisplay.getCompanyId())) {
            return;
        }
        
        final String linkedinAuthRedirectURL = this._linkedinConnect.getRedirectURL(themeDisplay.getCompanyId());
        request.setAttribute("LINKEDIN_AUTH_REDIRECT_URL", (Object)linkedinAuthRedirectURL);
        final String linkedinAuthURL = this._linkedinConnect.getAuthURL(themeDisplay.getCompanyId());
        request.setAttribute("LINKEDIN_AUTH_URL", (Object)linkedinAuthURL);
        final String linkedinAppId = this._linkedinConnect.getAppId(themeDisplay.getCompanyId());
        request.setAttribute("LINKEDIN_APP_ID", (Object)linkedinAppId);
        final RequestDispatcher requestDispatcher = this._servletContext.getRequestDispatcher("/com.liferay.login.web/linkedin.jsp");
        try {
            requestDispatcher.include((ServletRequest)request, (ServletResponse)response);
        }
        catch (ServletException se) {
            LinkedInConnectNavigationPreDynamicInclude._log.error((Object)"Unable to include JSP /com.liferay.login.web/linkedin.jsp", (Throwable)se);
            throw new IOException("Unable to include JSP /com.liferay.login.web/linkedin.jsp", (Throwable)se);
        }
    }
    
    public void register(final DynamicInclude.DynamicIncludeRegistry dynamicIncludeRegistry) {
        dynamicIncludeRegistry.register("com.liferay.login.web#/navigation.jsp#pre");
    }
    
    @Reference(unbind = "-")
    protected void setLinkedInConnect(final LinkedInConnect linkedinConnect) {
        this._linkedinConnect = linkedinConnect;
    }
    
    @Reference(target = "(osgi.web.symbolicname=com.liferay.login.authentication.linkedin.web)", unbind = "-")
    protected void setServletContext(final ServletContext servletContext) {
        this._servletContext = servletContext;
    }
    
    static {
        _log = LogFactoryUtil.getLog((Class)LinkedInConnectNavigationPreDynamicInclude.class);
    }
}