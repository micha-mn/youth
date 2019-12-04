package com.parth.portal.settings.authentication.twitter.web.internal.servlet.taglib;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.taglib.BaseJSPDynamicInclude;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "portal.settings.authentication.tabs.name=Twitter" }, service = {
		com.liferay.portal.kernel.servlet.taglib.DynamicInclude.class })
public class PortalSettingsTwitterAuthenticationDynamicInclude extends BaseJSPDynamicInclude {

	protected String getJspPath() {
		return "/dynamic_include/com.liferay.login.web/navigation/twitter.jsp";
	}

	protected Log getLog() {
		return _log;
	}

	@Reference(target = "(osgi.web.symbolicname=com.liferay.portal.settings.authentication.twitter.web)", unbind = "-")
	protected void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}
	
	private static final Log _log = LogFactoryUtil.getLog(PortalSettingsTwitterAuthenticationDynamicInclude.class);
}
