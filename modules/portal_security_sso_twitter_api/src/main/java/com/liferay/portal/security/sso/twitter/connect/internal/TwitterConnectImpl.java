package com.liferay.portal.security.sso.twitter.connect.internal;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.settings.CompanyServiceSettingsLocator;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.security.sso.twitter.connect.TwitterConnect;
import com.liferay.portal.security.sso.twitter.connect.configuration.TwitterConnectConfiguration;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(configurationPid = "com.liferay.portal.security.sso.twitter.connect.configuration.TwitterConnectConfiguration", immediate = true, service = TwitterConnect.class)
public class TwitterConnectImpl implements TwitterConnect {
	@Override
	public boolean isEnabled(long companyId) {
		TwitterConnectConfiguration twitterConnectConfiguration = getTwitterConnectConfiguration(companyId);
		return twitterConnectConfiguration.enabled();
	}

	@Override
	public String getConsumerKey(long companyId) {
		TwitterConnectConfiguration twitterConnectConfiguration = getTwitterConnectConfiguration(companyId);
		return twitterConnectConfiguration.consumerKey();
	}

	@Override
	public String getConsumerKeySecret(long companyId) {
		TwitterConnectConfiguration twitterConnectConfiguration = getTwitterConnectConfiguration(companyId);
		return twitterConnectConfiguration.consumerKeySecret();
	}

	@Override
	public String getCallbackURL(long companyId) {
		TwitterConnectConfiguration twitterConnectConfiguration = getTwitterConnectConfiguration(companyId);
		return twitterConnectConfiguration.oauthCallbackURL();
	}

	protected TwitterConnectConfiguration getTwitterConnectConfiguration(long companyId) {
		try {
			return (TwitterConnectConfiguration) this._configurationProvider
					.getConfiguration(TwitterConnectConfiguration.class, new CompanyServiceSettingsLocator(companyId,
							"com.liferay.portal.security.sso.twitter.connect.auth"));

		} catch (ConfigurationException ce) {
			_log.error("Unable to get Twitter Connect configuration", ce);

			return null;
		}
	}

	@Reference(unbind = "-")
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
		this._configurationProvider = configurationProvider;
	}

	private static final Log _log = LogFactoryUtil.getLog(TwitterConnectImpl.class);
	private ConfigurationProvider _configurationProvider;
	@Reference
	private Portal _portal;
}
