<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>

<!--  <link  href="/o/new-misk-theme/css/font/font-awesome/font-awesome.min.css" rel="stylesheet"/> -->
<!-- <link href="/o/new-misk-theme/css/landing/landing.css" rel="stylesheet" />  -->
<!-- <link href="/o/new-misk-theme/css/landing/animate.css" rel="stylesheet" /> -->
<% if(themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")) { %>
<link href="/o/new-misk-theme/css/landing/CustomStyle_Ar.css" rel="stylesheet" />
<% } else { %>
<link href="/o/new-misk-theme/css/landing/CustomStyle.css" rel="stylesheet" />
<% } %>

<script src="/o/new-misk-theme/js/landing/jquery.counterup.min.js"></script>
<script src="/o/new-misk-theme/js/landing/scrollreveal.min.js"></script>
<script src="/o/new-misk-theme/js/landing/imgfix.min.js"></script>
<script src="/o/new-misk-theme/js/landing/wow.min.js"></script>
<script src="/o/new-misk-theme/js/landing/custom.js"></script>


<style>
		
<% if(themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")) { %>
.row {
	direction:rtl;
}
<% } %>


	
</style>


<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">

		<%
		String signedInAs = HtmlUtil.escape(user.getFullName());

		if (themeDisplay.isShowMyAccountIcon() && (themeDisplay.getURLMyAccount() != null)) {
			String myAccountURL = String.valueOf(themeDisplay.getURLMyAccount());

			signedInAs = "<a class=\"signed-in\" href=\"" + HtmlUtil.escape(myAccountURL) + "\">" + signedInAs + "</a>";
		}
		%>

		<liferay-ui:message arguments="<%= signedInAs %>" key="you-are-signed-in-as-x" translateArguments="<%= false %>" />
	</c:when>
	<c:otherwise>
		<%
		String formName = "loginForm";

		if (windowState.equals(LiferayWindowState.EXCLUSIVE)) {
			formName += "Modal";
		}

		String redirect = ParamUtil.getString(request, "redirect");

		String login = (String)SessionErrors.get(renderRequest, "login");

// 		if (Validator.isNull(login)) {
// 			login = LoginUtil.getLogin(request, "login", company);
// 		}
		login= "";

		String password = StringPool.BLANK;
		boolean rememberMe = ParamUtil.getBoolean(request, "rememberMe");

		if (Validator.isNull(authType)) {
			authType = company.getAuthType();
		}
		%>
		

<div class="container-fluid section-bgcolor p-0 login-container">
 <div id="global-header-section-login-register">    
<div id="createaccount-section" class="container" >
<div class="row pb-5" id="register-form">
 <div class="col-md-6">
                     <div class="h-50 d-flex justify-content-center flex-column">
                        <h3>
                        <liferay-ui:message key="DreamBelieveBuild" />
                        </h3>
                        <p> <liferay-ui:message key="EverythingYouCanImagine" /> <br /> <liferay-ui:message key="YouthHubToday" /></p>
                    </div>
   </div>
   <div class="col-md-6 pr-0">
   <div class="row">
   <div class="col-md-12 pr-0">
		<div class="login-container">		
			<portlet:actionURL name="/login/login" secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="loginURL">
				<portlet:param name="mvcRenderCommandName" value="/login/login" />
			</portlet:actionURL>

			<aui:form action="<%= loginURL %>" autocomplete='<%= PropsValues.COMPANY_SECURITY_LOGIN_FORM_AUTOCOMPLETE ? "on" : "off" %>' cssClass="sign-in-form" method="post" name="<%= formName %>" onSubmit="event.preventDefault();" validateOnBlur="<%= false %>">
				<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
				<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
				<aui:input name="doActionAfterLogin" type="hidden" value="<%= portletName.equals(PortletKeys.FAST_LOGIN) ? true : false %>" />

				<div class="inline-alert-container lfr-alert-container"></div>

				<liferay-util:dynamic-include key="com.liferay.login.web#/login.jsp#alertPre" />

				<c:choose>
					<c:when test='<%= SessionMessages.contains(request, "forgotPasswordSent") %>'>
						<div class="alert alert-success">
							<liferay-ui:message key="your-request-completed-successfully" />
						</div>
					</c:when>
					<c:when test='<%= SessionMessages.contains(request, "userAdded") %>'>
                                            
                                            
						<%
						String userEmailAddress = (String)SessionMessages.get(request, "userAdded");
						%>

						<div class="alert alert-success">
							<liferay-ui:message key="thank-you-for-creating-an-account" />
						</div>
					</c:when>
					<c:when test='<%= SessionMessages.contains(request, "userPending") %>'>

						<%
						String userEmailAddress = (String)SessionMessages.get(request, "userPending");
						%>

						<div class="alert alert-success">
							<liferay-ui:message arguments="<%= HtmlUtil.escape(userEmailAddress) %>" key="thank-you-for-creating-an-account.-you-will-be-notified-via-email-at-x-when-your-account-has-been-approved" translateArguments="<%= false %>" />
						</div>
					</c:when>
				</c:choose>

				<liferay-ui:error exception="<%= AuthException.class %>" message="authentication-failed" />
				<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-log-in-because-the-maximum-number-of-users-has-been-reached" />
				<liferay-ui:error exception="<%= CookieNotSupportedException.class %>" message="authentication-failed-please-enable-browser-cookies" />
				<liferay-ui:error exception="<%= NoSuchUserException.class %>" message="authentication-failed" />
				<liferay-ui:error exception="<%= PasswordExpiredException.class %>" message="your-password-has-expired" />
				<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="please-enter-an-email-address" />
				<liferay-ui:error exception="<%= UserLockoutException.LDAPLockout.class %>" message="this-account-is-locked" />

				<liferay-ui:error exception="<%= UserLockoutException.PasswordPolicyLockout.class %>">

					<%
					UserLockoutException.PasswordPolicyLockout ule = (UserLockoutException.PasswordPolicyLockout)errorException;
					%>

					<c:choose>
						<c:when test="<%= ule.passwordPolicy.isRequireUnlock() %>">
							<liferay-ui:message key="this-account-is-locked" />
						</c:when>
						<c:otherwise>

							<%
							Format dateFormat = FastDateFormatFactoryUtil.getDateTime(FastDateFormatConstants.SHORT, FastDateFormatConstants.LONG, locale, TimeZone.getTimeZone(ule.user.getTimeZoneId()));
							%>

							<liferay-ui:message arguments="<%= dateFormat.format(ule.user.getUnlockDate()) %>" key="this-account-is-locked-until-x" translateArguments="<%= false %>" />
						</c:otherwise>
					</c:choose>
				</liferay-ui:error>

				<liferay-ui:error exception="<%= UserPasswordException.class %>" message="authentication-failed" />
				<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNull.class %>" message="the-screen-name-cannot-be-blank" />

				<liferay-util:dynamic-include key="com.liferay.login.web#/login.jsp#alertPost" />

				<aui:fieldset  style="padding-top: 4%;">

					<%
					String loginLabel = null;

					if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
						loginLabel = "email-address";
					}
					else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
						loginLabel = "screen-name";
					}
					else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
						loginLabel = "id";
					}
					%>

					<aui:input autoFocus="<%= windowState.equals(LiferayWindowState.EXCLUSIVE) || windowState.equals(WindowState.MAXIMIZED) %>" cssClass="clearable" placeholder="<%= loginLabel %>" name="login" showRequiredLabel="<%= false %>" type="text" value="<%= login %>">
						<aui:validator name="required" />

						<c:if test="<%= authType.equals(CompanyConstants.AUTH_TYPE_EA) %>">
							<aui:validator name="email" />
						</c:if>
					</aui:input>

					<aui:input name="password" showRequiredLabel="<%= false %>" placeholder="Password" type="password" value="<%= password %>" cssClass="clearable">
						<aui:validator name="required" />
					</aui:input>

					<span id="<portlet:namespace />passwordCapsLockSpan" style="display: none;"><liferay-ui:message key="caps-lock-is-on" /></span>
				
                   <c:if test="<%= company.isAutoLogin() && !PropsValues.SESSION_DISABLED %>">
						<aui:input checked="<%= rememberMe %>" name="rememberMe" type="checkbox" /> 
			       </c:if>     	     
				</aui:fieldset>
			<aui:button-row>
					<span> <button type="submit" class="btn whitebutton"><liferay-ui:message key="SignIn" /> </button></span>		
					<span><a href="/web/guest/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&amp;p_p_lifecycle=0&amp;p_p_state=maximized&amp;p_p_mode=view&amp;saveLastPath=false&amp;_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Fcreate_account" class="btn whitebutton"><liferay-ui:message key="SignUp" /></a></span>
				</aui:button-row>
				
			<div class="row">
                   <div>
                  <span><liferay-ui:message key="OR" /></span> 
                   </div>
                   </div>
                     <div class="row pt-2">
                      <div class="col-md-4 p-0 col-xs-5">
                      
                      <span><liferay-ui:message key="SignInWith" /></span> 
                      </div>
                       <div class="col-md-8 col-xs-7">
                        <div class="rounded-social-buttons">
                        <div class="social-media-icons">
                        <span><a class="circle-button facebook"  href="javascript:var facebookConnectLoginWindow = window.open('https%3A%2F%2Fgraph.facebook.com%2Foauth%2Fauthorize%3Fclient_id%3D2522240661337976%26redirect_uri%3Dhttps%253A%252F%252Fwebserver-miskfoundation-dev.lfr.cloud%252Fc%252Fportal%252Ffacebook_connect_oauth%26scope%3Demail%26state%3D%257B%2522redirect%2522%253A%2522https%253A%252F%252Fwebserver-miskfoundation-dev.lfr.cloud%252Fweb%252Fguest%252Fhome%253Fp_p_id%253Dcom_liferay_login_web_portlet_LoginPortlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dpop_up%2526p_p_mode%253Dview%2526_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName%253D%25252Flogin%25252Flogin_redirect%2522%252C%2522stateNonce%2522%253A%2522HuG5q9mA%2522%257D', 'facebook', 'align=center,directories=no,height=560,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=1000'); void(''); facebookConnectLoginWindow.focus();" target="_self" class=" lfr-icon-item taglib-icon" id="_com_liferay_login_web_portlet_LoginPortlet_facebook____" role="menuitem"></a></span>
                        <span><a class="circle-button google" href="javascript:var googleLoginWindow = window.open('/c/portal/google_login?cmd=login', 'google', 'align=center,directories=no,height=560,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=1000'); void(''); googleLoginWindow.focus();" target="_self" class=" lfr-icon-item taglib-icon" id="_com_liferay_login_web_portlet_LoginPortlet_ctvk____" role="menuitem"></a></span>                                                         
                        <span><a class="circle-button twitter" id="_com_liferay_login_web_portlet_LoginPortlet_twitter____" href=""></a></span>
                        <span><a class="circle-button linkedin" href="#"></a></span>
                        </div>                                         
                     </div>
                      </div>
                     </div>
			</aui:form>

			<%@ include file="/navigation.jspf" %>
		</div>
		</div>
		</div>
		</div>
	</div>
</div>
</div>
</div>
<script>
$( document ).ready(function() {
  $("#_com_liferay_login_web_portlet_LoginPortlet_facebook____").attr("href", $("a",$(".taglib-icon-list").find("li")[0]).attr('href')); 
  $("#_com_liferay_login_web_portlet_LoginPortlet_twitter____").attr("href", $("a",$(".taglib-icon-list").find("li")[2]).attr('href')); 
});
</script>

		<aui:script sandbox="<%= true %>">
			var form = document.getElementById('<portlet:namespace /><%= formName %>');

			if (form) {
				form.addEventListener(
					'submit',
					function(event) {
						<c:if test="<%= Validator.isNotNull(redirect) %>">
							var redirect = form.querySelector('#<portlet:namespace />redirect');

							if (redirect) {
								var redirectVal = redirect.getAttribute('value');

								redirect.setAttribute('value', redirectVal + window.location.hash);
							}
						</c:if>

						submitForm(form);
					}
				);

				var password = form.querySelector('#<portlet:namespace />password');

				if (password) {
					password.addEventListener(
						'keypress',
						function(event) {
							Liferay.Util.showCapsLock(event, '<portlet:namespace />passwordCapsLockSpan');
						}
					);
				}
			}
		</aui:script>
	</c:otherwise>
</c:choose>