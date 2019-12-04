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

 <link  href="/o/new-misk-theme/css/font/font-awesome/font-awesome.min.css" rel="stylesheet"/>
<link href="/o/new-misk-theme/css/landing/landing.css" rel="stylesheet" /> 
<link href="/o/new-misk-theme/css/landing/CustomStyle.css" rel="stylesheet" />
<link href="/o/new-misk-theme/css/landing/animate.css" rel="stylesheet" />

<script src="/o/new-misk-theme/js/landing/jquery.counterup.min.js"></script>
<script src="/o/new-misk-theme/js/landing/scrollreveal.min.js"></script>
<script src="/o/new-misk-theme/js/landing/imgfix.min.js"></script>
<script src="/o/new-misk-theme/js/landing/wow.min.js"></script>
<script src="/o/new-misk-theme/js/landing/custom.js"></script>


<style>
		@font-face { font-family: 'Montserrat-SemiBold'; src: url('/o/new-misk-theme/fonts/Montserrat-SemiBold.otf'); }
		@font-face { font-family: 'Montserrat-Light'; src: url('/o/new-misk-theme/fonts/Montserrat-Light.otf'); }
		@font-face { font-family: 'Montserrat-Regular'; src: url('/o/new-misk-theme/fonts/Montserrat-Regular.otf'); }
		@font-face { font-family: 'Montserrat-Bold'; src: url('/o/new-misk-theme/fonts/Montserrat-Bold.otf'); }
		@font-face { font-family: 'Montserrat-Medium'; src: url('/o/new-misk-theme/fonts/Montserrat-Medium.otf'); }

<% if(themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")) { %>
.row {
	direction:rtl;
}
<% } %>

#createaccount-section input:-webkit-autofill,#createaccount-section input:-webkit-autofill:hover,#createaccount-section input:-webkit-autofill:focus,#createaccount-section textarea:-webkit-autofill,#createaccount-section textarea:-webkit-autofill:hover,#createaccount-section textarea:-webkit-autofill:focus,#createaccount-section select:-webkit-autofill,#createaccount-section select:-webkit-autofill:hover,#createaccount-section select:-webkit-autofill:focus 
{
-webkit-text-fill-color: white !important;
-webkit-box-shadow: 0 0 0px 1000px transparent inset !important;
transition: background-color 5000s ease-in-out 0s !important;
background-color: transparent !important;
}

 #createaccount-section ::-webkit-input-placeholder { /* Edge */
 			color: #fff !important;
			}

	#createaccount-section :-ms-input-placeholder { /* Internet Explorer 10-11 */
  	color: #fff  !important;
	}

	#createaccount-section ::placeholder {
 	color: #fff !important;
	}	


.start-header.scroll-on {padding:0 6% !important}

.google-icon:hover
{fill:#000;
}
.portlet {
    margin-bottom: 0;
    }
.icon-monospaced, .icon-monospaced[class^="icon-"], .icon-monospaced[class*=" icon-"] {
    z-index:5;
    position: absolute;
    }
.sign-btn {
    background-image: linear-gradient(223deg, #3bb78a, #00aed0), linear-gradient(to bottom, #ffffff, #ffffff);
    border: 0;
    /* padding: 3%; */
    padding-top: 2%;
    padding-right: 4%;
    padding-bottom: 2%;
    padding-left: 4%;
}
/*
input#_com_liferay_login_web_portlet_LoginPortlet_login {
    background: #ff000000;
    border-top: 0;
    border-left: 0;
    border-right: 0;
    border-radius: 0;
    color: white;
} 
input#_com_liferay_login_web_portlet_LoginPortlet_password {
    background: #ff000000;
    border-top: 0;
    border-left: 0;
    border-right: 0;
    border-radius: 0;
    color: white;
}
 */
.modal-header {
	display: -ms-flexbox;
    display: flex;
    -ms-flex-align: start;
    align-items: flex-start;
    -ms-flex-pack: justify;
    justify-content: space-between;
    padding: 1rem 1rem;
    border-top-left-radius: .3rem;
    border-top-right-radius: .3rem;
}
.text-gray {
    color: #929292!important;
}
.bg-info {
   	background-image: linear-gradient(to right, #0061a5, #279574) !important;
}
.close {
	font-size: 2.5rem;
    font-weight: 100;
    color: #fff!important;
    opacity:1;
}
label.control-label {
    display: none;
}

button.btn.btncustom {
    font-size: 0.8rem;
    font-weight: bold;
    width: 23%;
    padding-top: 2%;
    padding-right: 4%;
    padding-bottom: 2%;
    padding-left: 2%;
    margin-right: 3%;
}
i.fa {
    padding: 5%;
}

		
		#intro-title{
         padding-top:10% !important;
         margin-left:10%
         }
          #intro-title h3{
         font-family: Montserrat-Regular!important;
         font-size:24px !important;
         color:#ffffff !important;   
         }
       
         
         #header-section {
    		background-image: url(/o/new-misk-theme/images/landing/SingUp-bg.jpg);
    		background-repeat: no-repeat;
    		color: white;
    		background-size: 100% 100%;
		}
		   #createaccount-section{
        	 margin-left:9%;        	 
         }
         #createaccount-section h3 { font-family: Montserrat-SemiBold; color: white; font-size:32px }
        #createaccount-section p { font-family: Montserrat-Light; color: #ffffff; font-size: 14px; }
        #createaccount-section label { 
            font-family: Montserrat-Regular; 
            color: #eaf2e2; 
            font-size: 16px; 
            } 
            
         .taglib-text { color: #05aaff; text-decoration: underline;  }
         .input-checkbox-wrapper{
         color:#bfbfbf !important;
         }
        
  
        
         .register-button-scroll{
          margin:0px 5px !important;
         }
         .loginimage{
         	height: 100%;
    		width: 100%;
         }
         #login-logo{
         text-align: center;
    	padding-top: 15px;
         }
         .card-body{
         padding: 25px 10px !important;
         }
         .btncustom:hover{
         color:#d3e5c0 !important;
         }
         .portlet-icon-back{
   		display: none !important;
   		}
   		 .section-bgcolor{
         background-color:#f8f9fa !important;
         }
         #register-form{
   		padding-top:7%;
   		}
   		 .whitebutton{
       	padding-left: 45px;
    	padding-right: 45px;
    	padding-top: 7px;
    	padding-bottom: 7px;
    	font-family:Montserrat-Medium;
    	font-size:14px;
        }
        .whitebutton:hover{
		color:#3a635f !important;
		background:#ffffff !important;
		}
		.btnsingup {
    font-family:Montserrat-Medium;
    font-size:14px;
    color:#3a635f !important;
    padding-left:45px !important;;
    padding-right:45px !important;
    padding-top:7px !important;
    padding-bottom:7px !important;
    }
    
    .form-control{
    		border:none !important;         	
         	border-bottom: 2px solid #e1ece8 !important;
         	font-family: Montserrat-Regular !important;
         	font-size:15px !important;          	  	
         	height: 40px !important;
         	color:#ffffff !important;
         	background-color: transparent !important;
         	border-radius: 0px
         }
		.form-control:focus{box-shadow: none !important;
		background-color: transparent !important;
		}
		.help-block {
    		color: limegreen !important;
		}
	.taglib-icon-list{
	display:none;
	}
	  /* Check Box Conatiner*/
        .checkbox-container { display: block; position: relative; padding-left: 25px; margin-bottom: 12px; cursor: pointer; font-size: 16px; user-select: none; font-family: Montserrat-Light; color: #ffffff; font-size: 14px; }
            /* Hide the browser's default checkbox */
        .checkbox-container input { position: absolute; opacity: 0; cursor: pointer; height: 0; width: 0; }

        /* Create a custom checkbox */
        .checkmark { position: absolute; top: 0; left: 0; height: 15px; width: 15px; background-color: transparent !important; border: 1px solid white; border-radius: 0px;}
        .checkmark:after { content: ""; position: absolute; display: none; }
        .checkbox-container input:checked ~ .checkmark:after { display: block; }
        .checkbox-container .checkmark:after { left: 5px; top: 1px; width: 5px; height: 10px; border: solid white; border-width: 0 3px 3px 0; -webkit-transform: rotate(45deg); -ms-transform: rotate(45deg); transform: rotate(45deg); }
		.flyer {position: relative !important; right:70px}
        /* End of check box*/
        .button-holder {
    	margin: 15px 0;
	}
	.social-media-icons{
	margin-top:-40px;
	margin-left: -45px;
	}
	
	@media  screen and (max-width: 800px) {
   	.social-media-icons{
		margin-top:-10px;
		margin-left: -15px;		
	}
	section {
    padding: 0px 0;
	}
	
	#header {
    padding-bottom: 5px;
    height: 0px; 
	}    	
	}
	@media  screen and (max-width: 1024px) and (min-width: 801px) {
   		.social-media-icons{
		margin-top:-30px;
		margin-left: -15px;
		}
		section {
    padding: 0px 0;
	}
	    	
		
	#header {
    padding-bottom: 5px;
    height: 0px; 
		
		}
		}
	
	/* 20191102 */
		@media all and (max-width: 1920px) and (min-width: 520px) {		  
				  .start-header {padding: 0 6% 0 6%!important; width:98% ;}		  
		 .start-header.scroll-on {margin:0% !important; width:100% !important; padding:0 6%!important}
		}
				  
		@media all and (max-width: 1366px) and (min-width: 520px) {
		 .start-header {margin:0% !important; width:98% ;}
		  
		 
		}
		@media all and (min-width: 1367px)and (max-width: 1920px) {
		 .start-header {margin:0% !important; width:98%;}
		 .start-header.scroll-on {margin:0% !important; width:100% !important; padding:0 !important}
		
		}
        @media all and (max-width: 1920px) and (min-width: 1367px) {
        		  .start-header {padding: 0 6% 0 6%!important; width:98% ;}		
		.start-header.scroll-on {margin:0% !important; width:100% !important}		  
        }
	 @media (max-width: 768px)
	{
	.start-header {
     padding: 0px  !important;
	}
	#register-form{
	padding-top: 45%;
	}
	.join-button-signin{
	padding-right:0px !important;
	padding-left:3% !important;
	}
	.whitebutton{
	margin-top:10px;
	}
	}
	
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

		if (Validator.isNull(login)) {
			login = LoginUtil.getLogin(request, "login", company);
		}

		String password = StringPool.BLANK;
		boolean rememberMe = ParamUtil.getBoolean(request, "rememberMe");

		if (Validator.isNull(authType)) {
			authType = company.getAuthType();
		}
		%>
		

<div class="container-fluid section-bgcolor p-0">
 <div id="header-section">    
<div id="createaccount-section" >
<div class="row pb-5" id="register-form">
 <div class="col-md-5">
                     <div class="h-50 d-flex justify-content-center flex-column" style="padding-left: 10%; margin-top: 15%;">
                        <h3>
                        <liferay-ui:message key="DreamBelieveBuild" />
                        </h3>
                        <p> <liferay-ui:message key="EverythingYouCanImagine" /> <br /> <liferay-ui:message key="YouthHubToday" /></p>
                    </div>
   </div>
   <div class="col-md-7">
   <div class="row" style="padding-top: 5%;padding-right: 10% !important;">
   <div class="col-md-12">
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
                      <div class="col-md-3">
                      
                      <span><liferay-ui:message key="SignInWith" /></span> 
                      </div>
                       <div class="col-md-9">
                        <div class="rounded-social-buttons">
                        <div class="social-media-icons">
                        <span><a class="circle-button facebook"  href="javascript:var facebookConnectLoginWindow = window.open('https%3A%2F%2Fgraph.facebook.com%2Foauth%2Fauthorize%3Fclient_id%3D2522240661337976%26redirect_uri%3Dhttps%253A%252F%252Fwebserver-miskfoundation-dev.lfr.cloud%252Fc%252Fportal%252Ffacebook_connect_oauth%26scope%3Demail%26state%3D%257B%2522redirect%2522%253A%2522https%253A%252F%252Fwebserver-miskfoundation-dev.lfr.cloud%252Fweb%252Fguest%252Fhome%253Fp_p_id%253Dcom_liferay_login_web_portlet_LoginPortlet%2526p_p_lifecycle%253D0%2526p_p_state%253Dpop_up%2526p_p_mode%253Dview%2526_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName%253D%25252Flogin%25252Flogin_redirect%2522%252C%2522stateNonce%2522%253A%2522HuG5q9mA%2522%257D', 'facebook', 'align=center,directories=no,height=560,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=1000'); void(''); facebookConnectLoginWindow.focus();" target="_self" class=" lfr-icon-item taglib-icon" id="_com_liferay_login_web_portlet_LoginPortlet_rjus____" role="menuitem"></a></span>
                        <span style="margin-left: -17px;"><a class="circle-button google" href="javascript:var googleLoginWindow = window.open('/c/portal/google_login?cmd=login', 'google', 'align=center,directories=no,height=560,location=no,menubar=no,resizable=yes,scrollbars=yes,status=no,toolbar=no,width=1000'); void(''); googleLoginWindow.focus();" target="_self" class=" lfr-icon-item taglib-icon" id="_com_liferay_login_web_portlet_LoginPortlet_ctvk____" role="menuitem"></a></span>                                                         
                        <span style="margin-left: -17px;"><a class="circle-button twitter" href="#"></a></span>
                        <span style="margin-left: -17px;"><a class="circle-button linkedin" href="#"></a></span>
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