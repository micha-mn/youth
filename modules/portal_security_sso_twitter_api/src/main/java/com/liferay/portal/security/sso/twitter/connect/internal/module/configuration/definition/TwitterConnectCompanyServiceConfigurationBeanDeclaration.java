package com.liferay.portal.security.sso.twitter.connect.internal.module.configuration.definition;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

@Component
public class TwitterConnectCompanyServiceConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {
	public Class<?> getConfigurationBeanClass() {
		return com.liferay.portal.security.sso.twitter.connect.configuration.TwitterConnectConfiguration.class;
	}
}
