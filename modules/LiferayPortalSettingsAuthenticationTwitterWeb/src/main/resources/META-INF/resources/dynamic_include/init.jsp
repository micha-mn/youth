<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil" %>
<%@page import="com.liferay.portal.kernel.settings.CompanyServiceSettingsLocator" %>
<%@page import="com.liferay.portal.kernel.settings.ParameterMapSettingsLocator" %>
<%@page import="com.liferay.portal.kernel.util.Portal" %>
<%@page import="com.liferay.portal.kernel.util.Validator" %>
<%@page import="com.liferay.portal.security.sso.twitter.connect.configuration.TwitterConnectConfiguration" %>
<%@page import="com.liferay.portal.security.sso.twitter.connect.constants.TwitterConnectConstants" %>

<%@ page import="javax.portlet.ActionRequest" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />
<%
PortletURL portletURL = renderResponse.createRenderURL();
String currentURL = portletURL.toString();
%>