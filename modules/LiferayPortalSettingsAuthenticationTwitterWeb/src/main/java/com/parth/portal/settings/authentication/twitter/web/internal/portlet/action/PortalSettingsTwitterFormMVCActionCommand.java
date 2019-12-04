package com.parth.portal.settings.authentication.twitter.web.internal.portlet.action;

import com.github.scribejava.apis.TwitterApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.oauth.OAuth10aService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.settings.portlet.action.BasePortalSettingsFormMVCActionCommand;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@SuppressWarnings("deprecation")
@Component(immediate = true, property = {
		"javax.portlet.name=com_liferay_portal_settings_web_portlet_PortalSettingsPortlet",
		"mvc.command.name=/portal_settings/twitter_connect_custom" }, service = {
				com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand.class })
public class PortalSettingsTwitterFormMVCActionCommand extends BasePortalSettingsFormMVCActionCommand{
	protected void doValidateForm(ActionRequest actionRequest, ActionResponse actionResponse) {
	    boolean twitterEnabled = getBoolean(actionRequest, "enabled");
	    String consumerKey = getString(actionRequest, "consumerKey");
	    String consumerKeySecret = getString(actionRequest, "consumerKeySecret");
	    String callbackURL = getString(actionRequest, "oauthCallbackURL");
	    
	    if (!twitterEnabled) {
	      return;
	    }
	    if (Validator.isNull(consumerKey)) {
	      SessionErrors.add(actionRequest, "consumerKeyNull");
	    }
	    
	    if (Validator.isNull(consumerKeySecret)) {
	      SessionErrors.add(actionRequest, "consumerKeySecretNull");
	    }
	    
	    if (Validator.isNotNull(callbackURL) && !Validator.isUrl(callbackURL)) {
	      SessionErrors.add(actionRequest, "twitterCallbackURLInvalid");
	    }
	    if (Validator.isNotNull(consumerKey) && Validator.isNotNull(consumerKeySecret)) {
	    	final OAuth10aService service = new ServiceBuilder(consumerKey)
	                .apiSecret(consumerKeySecret).callback(callbackURL)
	                .build(TwitterApi.instance());
	    	try {
	    		final OAuth1RequestToken requestToken =service.getRequestToken();
				System.out.println(requestToken);
				System.out.println("Now go and authorize ScribeJava here:");
		        System.out.println(service.getAuthorizationUrl(requestToken));
		        System.out.println("And paste the verifier here");
		        System.out.print(">>");
			} catch (IOException | InterruptedException | ExecutionException e) {
				SessionErrors.add(actionRequest, "twitterUnauthorized");
			}
	    } 
	  }

	  protected String getParameterNamespace() { return "twitter--"; }
	  
	  protected String getSettingsId() { return "com.liferay.portal.security.sso.twitter.connect.auth"; }
}
