<%@page import="com.liferay.portal.kernel.util.URLCodec"%>
<%@ include file="/com.liferay.login.web/init.jsp" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.security.sso.linkedin.connect.constants.LinkedInConnectWebKeys"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>

<portlet:renderURL var="loginRedirectURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="mvcRenderCommandName" value="/login/login_redirect" />
</portlet:renderURL>

<%
String linkedinAuthRedirectURL = (String)request.getAttribute(LinkedInConnectWebKeys.LINKEDIN_AUTH_REDIRECT_URL);
String linkedinAuthURL = (String)request.getAttribute(LinkedInConnectWebKeys.LINKEDIN_AUTH_URL);
String linkedinAppId = (String)request.getAttribute(LinkedInConnectWebKeys.LINKEDIN_APP_ID);
String state = String.valueOf(Math.random());

//linkedinAuthRedirectURL = HttpUtil.addParameter(linkedinAuthRedirectURL, "redirect", loginRedirectURL);

linkedinAuthURL = HttpUtil.addParameter(linkedinAuthURL, "response_type", "code");
linkedinAuthURL = HttpUtil.addParameter(linkedinAuthURL, "client_id", linkedinAppId);
linkedinAuthURL = HttpUtil.addParameter(linkedinAuthURL, "redirect_uri", linkedinAuthRedirectURL);
linkedinAuthURL = HttpUtil.addParameter(linkedinAuthURL, "scope", "r_liteprofile%20r_emailaddress");
linkedinAuthURL = HttpUtil.addParameter(linkedinAuthURL, "state", state);

//String taglibOpenLinkedInLoginWindow = "javascript:var linkedInLoginWindow = window.open('" + linkedinAuthURL.toString() + "', 'linkedin', 'align=center,directories=no,height=560,location=no,menubar=no,resizable=yes,scrollbars=yes,status=yes,toolbar=yes,width=1000'); void(''); linkedInLoginWindow.focus();";
String taglibOpenLinkedInLoginWindow = "javascript: var win; var w = 972; var h = 660; var left = (screen.width/2)-(w/2); var top = (screen.height/2)-(h/2); win = window.open('"+linkedinAuthURL.toString()+"', 'Sign in with LinkedIn', 'status=1,width='+w+',height='+h+', top='+top+', left='+left);";
%>

<li class="" role="presentation">
<a href="<%=taglibOpenLinkedInLoginWindow%>"><i class="fa fa-linkedin" aria-hidden="true"></i> LinkedIn</a>
</li>