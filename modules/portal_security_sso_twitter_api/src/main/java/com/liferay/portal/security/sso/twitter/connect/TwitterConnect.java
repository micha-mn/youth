package com.liferay.portal.security.sso.twitter.connect;

public interface TwitterConnect {
	String getConsumerKey(long paramLong);

	String getConsumerKeySecret(long paramLong);

	String getCallbackURL(long paramLong);

	boolean isEnabled(long paramLong);
}
