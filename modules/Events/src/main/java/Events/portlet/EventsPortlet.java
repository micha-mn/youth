package Events.portlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

import Events.constants.EventsPortletKeys;

/**
 * @author eelia
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Events",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EventsPortletKeys.EVENTS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EventsPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
	
		PortletResponse portletResponse = (PortletResponse) renderRequest.getAttribute("javax.portlet.response");
		PortalUtil.getHttpServletResponse(portletResponse).sendRedirect("/home?p_p_id=landing_page_LandingPagePortlet_INSTANCE_PLNE3WnhuFLb&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&_landing_page_LandingPagePortlet_INSTANCE_PLNE3WnhuFLb_mvcPath=%2FlistEvent.jsp");
		super.doView(renderRequest, renderResponse);
	}
}