package com.liferay.portal.security.sso.twitter.connect.internal.module.configuration.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;

import org.osgi.service.component.annotations.Component;

@Component
public class TwitterConnectCompanyServiceConfigurationPidMapping implements ConfigurationPidMapping {
	public Class<?> getConfigurationBeanClass() {
		return com.liferay.portal.security.sso.twitter.connect.configuration.TwitterConnectConfiguration.class;
	}

	public String getConfigurationPid() {
		return "com.liferay.portal.security.sso.twitter.connect.auth";
	}
}
