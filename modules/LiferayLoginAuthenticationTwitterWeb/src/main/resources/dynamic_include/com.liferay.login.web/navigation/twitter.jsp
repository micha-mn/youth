<%@page import="com.liferay.portal.security.sso.twitter.connect.constants.TwitterConnectWebKeys"%>
<%@ include file="/dynamic_include/com.liferay.login.web/init.jsp" %>

<%
String outhUrl = (String)request.getAttribute(TwitterConnectWebKeys.TWITTER_OAUTH_LINK);
//String taglibOpenTwitterLoginWindow = "javascript:var twitterLoginWindow = window.open('" + outhUrl.toString() + "', 'twitter', 'align=center,directories=no,height=560,location=no,menubar=no,resizable=yes,scrollbars=yes,status=yes,toolbar=yes,width=1000'); void(''); twitterInLoginWindow.focus();";
String taglibOpenTwitterLoginWindow = "javascript: var win; var w = 972; var h = 660; var left = (screen.width/2)-(w/2); var top = (screen.height/2)-(h/2); win = window.open('"+outhUrl+"', 'Sign in with Twitter', 'status=1,width='+w+',height='+h+', top='+top+', left='+left);";
%>
<li class="" role="presentation">
<a href="<%=taglibOpenTwitterLoginWindow%>"><i class="icon-twitter" aria-hidden="true"></i> Twitter</a>
</li>