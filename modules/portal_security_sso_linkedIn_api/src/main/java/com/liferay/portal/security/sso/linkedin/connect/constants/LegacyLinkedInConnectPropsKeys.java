package com.liferay.portal.security.sso.linkedin.connect.constants;

public class LegacyLinkedInConnectPropsKeys
{
    public static final String APP_ID = "linkedin.connect.app.id";
    public static final String APP_SECRET = "linkedin.connect.app.secret";
    public static final String AUTH_ENABLED = "linkedin.auth.enabled";
    public static final String[] LINKEDIN_CONNECT_KEYS;
    public static final String GRAPH_URL = "linkedin.connect.graph.url";
    public static final String OAUTH_AUTH_URL = "linkedin.connect.oauth.auth.url";
    public static final String OAUTH_REDIRECT_URL = "linkedin.connect.oauth.redirect.url";
    public static final String OAUTH_TOKEN_URL = "linkedin.connect.oauth.token.url";
    
    static {
        LINKEDIN_CONNECT_KEYS = new String[] { "linkedin.auth.enabled", "linkedin.connect.app.id", "linkedin.connect.app.secret", "linkedin.connect.graph.url", "linkedin.connect.oauth.auth.url", "linkedin.connect.oauth.redirect.url", "linkedin.connect.oauth.token.url" };
    }
}