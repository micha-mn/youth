package portal_security_sso_linkedIn_api.portlet;

import portal_security_sso_linkedIn_api.constants.Portal_security_sso_linkedIn_apiPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author jsa
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Portal_security_sso_linkedIn_api",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + Portal_security_sso_linkedIn_apiPortletKeys.PORTAL_SECURITY_SSO_LINKEDIN_API,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class Portal_security_sso_linkedIn_apiPortlet extends MVCPortlet {
}