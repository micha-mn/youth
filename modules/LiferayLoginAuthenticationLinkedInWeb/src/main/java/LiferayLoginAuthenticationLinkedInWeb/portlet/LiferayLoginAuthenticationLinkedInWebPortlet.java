package LiferayLoginAuthenticationLinkedInWeb.portlet;

import LiferayLoginAuthenticationLinkedInWeb.constants.LiferayLoginAuthenticationLinkedInWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
		"javax.portlet.display-name=LiferayLoginAuthenticationLinkedInWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LiferayLoginAuthenticationLinkedInWebPortletKeys.LIFERAYLOGINAUTHENTICATIONLINKEDINWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LiferayLoginAuthenticationLinkedInWebPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		System.out.println("111111111 LiferayLoginAuthenticationLinkedInWebPortlet   111111111111");
		super.doView(renderRequest, renderResponse);
	}
}