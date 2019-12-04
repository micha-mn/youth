package com.liferay.portal.security.sso.twitter.connect.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta.AD;
import aQute.bnd.annotation.metatype.Meta.OCD;

@ExtendedObjectClassDefinition(category = "sso")
@OCD(id = "com.liferay.portal.security.sso.twitter.connect.configuration.TwitterConnectConfiguration", localization = "content/Language", name = "twitter-connect-configuration-name")
public interface TwitterConnectConfiguration {

	@AD(deflt = "false", required = false)
	boolean enabled();

	@AD(name = "consumer-key", required = false)
	String consumerKey();

	@AD(name = "consumer-key-secret", required = false)
	String consumerKeySecret();

	@AD(deflt = "http://localhost:8080/c/portal/twitter_connect_oauth", name = "callback-url", required = false)
	String oauthCallbackURL();
}
