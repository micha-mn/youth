<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/dynamic_include/init.jsp" %>

<%
TwitterConnectConfiguration twitterConnectConfiguration = ConfigurationProviderUtil.getConfiguration(TwitterConnectConfiguration.class, new ParameterMapSettingsLocator(request.getParameterMap(), "twitter--", new CompanyServiceSettingsLocator(company.getCompanyId(), TwitterConnectConstants.SERVICE_NAME)));

boolean authEnabled = twitterConnectConfiguration.enabled();
String consumerKey = twitterConnectConfiguration.consumerKey();
String consumerKeySecret = twitterConnectConfiguration.consumerKeySecret();
String callbackUrl = twitterConnectConfiguration.oauthCallbackURL();

%>

<liferay-ui:error key="twitterCallbackURLInvalid" message="the-twitter-callback-url-invalid" />
<liferay-ui:error key="consumerKeyNull" message="twitter-consumer-key-null" />
<liferay-ui:error key="consumerKeySecretNull" message="twitter-consumer-key-secret-null" />
<liferay-ui:error key="twitterUnauthorized" message="twitter-unauthorized" />


<aui:fieldset>
	<aui:input name="<%= ActionRequest.ACTION_NAME %>" type="hidden" value="/portal_settings/twitter_connect_custom" />

	<aui:input label="enabled" name="twitter--enabled" type="checkbox" value="<%= authEnabled %>" />
	
	<aui:input cssClass="lfr-input-text-container" label="consumer-key" name="twitter--consumerKey" type="text" value="<%= consumerKey %>" />

	<aui:input cssClass="lfr-input-text-container" label="consumer-key-secret" name="twitter--consumerKeySecret" type="password" value="<%= consumerKeySecret %>" />

	<aui:input cssClass="lfr-input-text-container" label="callback-url" name="twitter--oauthCallbackURL" type="text" value="<%= callbackUrl %>" />
	
	<aui:button-row>
		<aui:button onClick='<%= renderResponse.getNamespace() + "testTwitterSettings();" %>' value="test-configuration" />
	</aui:button-row>

</aui:fieldset>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />testTwitterSettings',
		function() {
			var A = AUI();

			var data = {};

			data.<portlet:namespace />twitterKey = document.<portlet:namespace />fm['<portlet:namespace />twitter--consumerKey'].value;
			data.<portlet:namespace />twitterSecret = document.<portlet:namespace />fm['<portlet:namespace />twitter--consumerKeySecret'].value;
			data.<portlet:namespace />callbackURL = document.<portlet:namespace />fm['<portlet:namespace />twitter--oauthCallbackURL'].value;

			var url = '<portlet:renderURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>"><portlet:param name="mvcRenderCommandName" value="/portal_settings/test_twitter" /></portlet:renderURL>';

			var dialog = Liferay.Util.Window.getWindow(
				{
					dialog: {
						destroyOnHide: true
					},
					title: 'Test Twitter Configuration'
				}
			);

			dialog.plug(
				A.Plugin.IO,
				{
					data: data,
					uri: url
				}
			);
		},
		['aui-io-plugin-deprecated', 'aui-io-request', 'liferay-util-window']
	);
</aui:script>