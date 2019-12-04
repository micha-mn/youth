package com.liferay.portal.security.sso.linkedin.connect;

import com.liferay.portal.kernel.json.JSONObject;

public interface LinkedInConnect
{
    String getAccessToken(final long p0, final String p1);
    
    String getAccessTokenURL(final long p0);
    
    String getAppId(final long p0);
    
    String getAppSecret(final long p0);
    
    String getAuthURL(final long p0);
    
    JSONObject getGraphResources(final long p0, final String p1);
    
    String getGraphURL(final long p0);
    
    
    String getRedirectURL(final long p0);
    
    boolean isEnabled(final long p0);
}