package com.liferay.portal.security.sso.twitter.connect.internal.web.portlet.path;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "auth.public.path=/portal/twitter_connect_oauth" }, service = {
		Object.class })
public class AuthPublicPath {

}
