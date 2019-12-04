package com.liferay.portal.security.sso.linkedin.connect.internal.module.configuration.definition;

import com.liferay.portal.security.sso.linkedin.connect.configuration.LinkedInConnectConfiguration;
import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

@Component
public class LinkedInConnectCompanyServiceConfigurationBeanDeclaration implements ConfigurationBeanDeclaration
{
    public Class<?> getConfigurationBeanClass() {
        return LinkedInConnectConfiguration.class;
    }
}