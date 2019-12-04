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

input#_com_liferay_login_web_portlet_LoginPortlet_screenName,
input#_com_liferay_login_web_portlet_LoginPortlet_emailAddress,
input#_com_liferay_login_web_portlet_LoginPortlet_password1,
input#_com_liferay_login_web_portlet_LoginPortlet_password2,
input#_com_liferay_login_web_portlet_LoginPortlet_birthday,
select#_com_liferay_login_web_portlet_LoginPortlet_prefixValue,
input#_com_liferay_login_web_portlet_LoginPortlet_captchaText,
input#_com_liferay_login_web_portlet_LoginPortlet_firstName,
input#_com_liferay_login_web_portlet_LoginPortlet_middleName,
input#_com_liferay_login_web_portlet_LoginPortlet_lastName,
select#_com_liferay_login_web_portlet_LoginPortlet_male,
select#_com_liferay_login_web_portlet_LoginPortlet_suffixValue,
select#selectgender,
select#selectage,
input#countrycode,
input#phoneno,
select#country
{
    background: #ff000000;
    border-top: 0;
    border-left: 0;
    border-right: 0;
    border-radius: 0;
    color: white !important;
}
::-webkit-input-placeholder { /* Edge */
  color: white;
}

:-ms-input-placeholder { /* Internet Explorer 10-11 */
  color: white;
}


label.control-label {
    display: none;
}
::-webkit-input-placeholder { /* Edge */
 color: #ffffff!important;
}

:-ms-input-placeholder { /* Internet Explorer 10-11 */
  color: #ffffff!important;
}

::placeholder {
  color: #ffffff!important;
}
.help-block {
    color: #F44336;
    }
 


button.btn.colorfullbutton.signup {
    background-image: linear-gradient(223deg, #3bb78a, #00aed0), linear-gradient(to bottom, #00aa60, #00aa60);
    border: 0;
    padding-top: 2%;
    padding-right: 4%;
    padding-bottom: 2%;
    padding-left: 4%;
    margin-left: 3%;
}
button.btn.whitebutton.signin {
    width: 18%;
    height: 50px;
    border-radius: 5px;
    margin-top: 0%;
    margin-left: 3%;
    border: solid 2px #f8f9fa;
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
i.fa {
    padding: 5%;
}

/* header customization  */

         .start-header.scroll-on {background:#292929de !important;}
			.scroll-on {position:fixed !important; height:85px !important; width:100% !important; margin:0 !important}
			.scroll-on .navbar {padding:5px 1rem !important}
			.start-header {position:absolute; z-index:100  !important;margin:0 18%; width:75%;padding:15px 0;}
			.navigation-wrap{margin:0px !important;	width:100% !important;		}
			.col-md-12.topHeadLinks1 {padding-bottom:1% !important}
			#header #logo img {max-height:83px !important; position:inherit !important}
			.navbar {padding:10px 0 !important}

			@media all and (max-width: 1920px) and (min-width: 520px) {		  
		  .start-header {margin:0 6% !important; width:92% !important}		  
		  .upcoming-img {min-height:360px !important; max-height:370px !important}		  

		}
				  
		@media all and (max-width: 1366px) and (min-width: 520px) {
		 .start-header {margin:0% !important; width:100% !important}
		 
		}
		@media all and (min-width: 1367px)and (max-width: 1920px) {
		 .start-header {margin:0% !important; width:100% !important}
		 .start-header.scroll-on {margin:0% !important; width:100% !important; padding:0 !important}
		}
        @media all and (max-width: 1920px) and (min-width: 1367px) {
        .start-header {margin:0 6% !important; width:92% !important}
		.start-header.scroll-on {margin:0% !important; width:100% !important}
        }
        
		span.topHeadLinks{
		color:#ffffff !important;
		}
		a.join-button {position:relative; top:15px !important}	 
		a.join-button-signin{
		position:relative; top:15px !important
		}
		/*end of header section customization*/ 
		 #intro-title{
         padding-top:10% !important;
         margin-left:10%
         }
          #intro-title h3{
         font-family: Montserrat-Regular!important;
         font-size:24px !important;
         color:#ffffff !important;   
         }
        .section-bgcolor{
         background-color:#f8f9fa !important;
         }
         #createaccount-section{
        	 margin-left:9%;        	 
         }
         #createaccount-section h3 { font-family: Montserrat-SemiBold; color: white; }
        #createaccount-section p { font-family: Montserrat-Light; color: #ffffff; font-size: 12px; }
        #createaccount-section label { 
            font-family: Montserrat-Regular; 
            color: #eaf2e2; 
            font-size: 16px; 
            } 
            
         
         #header-section {
    		background-image: url(/o/new-misk-theme/images/landing/SingUp-bg.jpg);
    		background-repeat: no-repeat;
    		color: white;
    		background-size: 100% 100%;
		}
         .form-control{
         	/*border-bottom: 1px solid #bfbfbf;*/
         	border-bottom: 2px solid #e1ece8 !important;
         	font-family: Montserrat-Regular !important;
         	font-size:15px !important;          	  	
         	height: 60px !important;
         	color:#ffffff !important;
         }
         .button-holder{
         text-align: left;
         }
         .portlet-icon-back{
   		display: none !important;
   		}
   		.register-button-scroll{
   			margin: 10px 5px;
   		}
   		#register-form{
   		padding-top:7%;
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
       
       .whitebutton{
       	padding-left: 45px;
    	padding-right: 45px;
    	padding-top: 7px;
    	padding-bottom: 7px;
    	font-family:Montserrat-Medium;
    	font-size:14px;
        }
        select.customselect { border-bottom: 2px solid #e1ece8 !important; 
        border-radius: 0; 
        color: #fffff; background-color: transparent;
        width: 100%;
    	min-height: 40px;
    	background-image: url(/o/new-misk-theme/images/landing/icons8-expand-arrow-16.png) !important; 
    	background-repeat: no-repeat !important;    
    	background-position: right !important;
        }
        
        .select-country {
        border-bottom: 3px solid #b4cdc7 !important; 
        border-radius: 0; 
        color: #fffff; 
        background-color: transparent;
        width: 100%;
    	min-height: 40px;
    	background-image: url(/o/new-misk-theme/images/landing/icons8-expand-arrow-16.png) !important; 
    	background-repeat: no-repeat !important;    
    	background-position: right !important;
        }
        .customtextbox { border-bottom: 2px solid #e1ece8 !important;  border-radius: 0; color: #ffffff; background-color: transparent;}
        
        .text-thin-boder{
        border-bottom: 1px solid #e0eae8 !important; border-radius: 0; color: #ffffff; background-color: transparent;
        }        
        .form-group-item{
        	height: 70px;       	
        }
        .form-control, .customselect
        {height: 40px !important;       }
        .phonetextbox { border-bottom: 3px solid #b4cdc7 !important; border-radius: 0; color: #ffffff; background-color: transparent;}
        
		.customselect>option{
		background-color:#ffffff;
		color:#898b8e;
		}
		.select-country>option{
		background-color:#ffffff;
		color:#898b8e;
		}
		.rounded-social-buttons .circle-button{
		padding-top:2px;
		}
	
		.form-control:focus{box-shadow: none !important;}
		.help-block {
    		color: limegreen !important;
		}
		.whitebutton:hover{
		color:#898b8e;
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
	#logoImg{
	display:none;
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
	#logoImg{
	display:none;
	}    	
		
	#header {
    padding-bottom: 5px;
    height: 0px; 
		
		}
	
</style>

<%
String redirect = ParamUtil.getString(request, "redirect");

String openId = ParamUtil.getString(request, "openId");
boolean male = ParamUtil.getBoolean(request, "male", true);

Calendar birthdayCalendar = CalendarFactoryUtil.getCalendar();

birthdayCalendar.set(Calendar.MONTH, Calendar.JANUARY);
birthdayCalendar.set(Calendar.DATE, 1);
birthdayCalendar.set(Calendar.YEAR, 1970);

renderResponse.setTitle(LanguageUtil.get(request, "create-account"));
%>

<c:if test="<%= Validator.isNotNull(openId) %>">
	<div class="alert alert-info">
		<liferay-ui:message arguments="<%= openId %>" key="you-are-about-to-create-an-account-with-openid-x" translateArguments="<%= false %>" />
	</div>
</c:if>

<portlet:actionURL name="/login/create_account" secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="createAccountURL" windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>">
	<portlet:param name="mvcRenderCommandName" value="/web/guest/what-we-offer?p_p_id=com_liferay_login_web_portlet_LoginPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Fcreate_account" />
</portlet:actionURL>

 <div class="container-fluid section-bgcolor p-0">
 <div id="header-section">    
<section id="createaccount-section" >
<div class="row pb-5" id="register-form">
 <div class="col-md-4">
                    <div class="h-50 d-flex justify-content-center flex-column" style="padding-left: 10%; margin-top: 15%;">
                        <h3>
                            Become Future Ready.<br />
                            Right here. Right now.
                        </h3>
                        <p>Start on the path to your future, join <br />Youth Hub today.</p>
                    </div>
   </div>
   <div class="col-md-8">
   <div class="row" style="padding-top: 5%;padding-right: 10% !important;">
   <div class="col-md-12">             
	<aui:form action="<%= createAccountURL %>" method="post" name="fm">
	<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="openId" type="hidden" value="<%= openId %>" />

	<liferay-ui:error exception="<%= AddressCityException.class %>" message="please-enter-a-valid-city" />
	<liferay-ui:error exception="<%= AddressStreetException.class %>" message="please-enter-a-valid-street" />
	<liferay-ui:error exception="<%= AddressZipException.class %>" message="please-enter-a-valid-postal-code" />
	<liferay-ui:error exception="<%= CaptchaConfigurationException.class %>" message="a-captcha-error-occurred-please-contact-an-administrator" />
	<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
	<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-create-user-account-because-the-maximum-number-of-users-has-been-reached" />
	<liferay-ui:error exception="<%= ContactBirthdayException.class %>" message="please-enter-a-valid-birthday" />
	<liferay-ui:error exception="<%= ContactNameException.MustHaveFirstName.class %>" message="please-enter-a-valid-first-name" />
	<liferay-ui:error exception="<%= ContactNameException.MustHaveLastName.class %>" message="please-enter-a-valid-last-name" />
	<liferay-ui:error exception="<%= ContactNameException.MustHaveValidFullName.class %>" message="please-enter-a-valid-first-middle-and-last-name" />
	<liferay-ui:error exception="<%= DuplicateOpenIdException.class %>" message="a-user-with-that-openid-already-exists" />
	<liferay-ui:error exception="<%= EmailAddressException.class %>" message="please-enter-a-valid-email-address" />

	<liferay-ui:error exception="<%= GroupFriendlyURLException.class %>">

		<%
		GroupFriendlyURLException gfurle = (GroupFriendlyURLException)errorException;
		%>

		<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.DUPLICATE %>">
			<liferay-ui:message key="the-screen-name-you-requested-is-associated-with-an-existing-friendly-url" />
		</c:if>
	</liferay-ui:error>

	<liferay-ui:error exception="<%= NoSuchCountryException.class %>" message="please-select-a-country" />
	<liferay-ui:error exception="<%= NoSuchListTypeException.class %>" message="please-select-a-type" />
	<liferay-ui:error exception="<%= NoSuchRegionException.class %>" message="please-select-a-region" />
	<liferay-ui:error exception="<%= PhoneNumberException.class %>" message="please-enter-a-valid-phone-number" />
	<liferay-ui:error exception="<%= PhoneNumberExtensionException.class %>" message="please-enter-a-valid-phone-number-extension" />
	<liferay-ui:error exception="<%= RequiredFieldException.class %>" message="please-fill-out-all-required-fields" />
	<liferay-ui:error exception="<%= TermsOfUseException.class %>" message="you-must-agree-to-the-terms-of-use" />
	<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeDuplicate.class %>" message="the-email-address-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="please-enter-an-email-address" />
	<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBePOP3User.class %>" message="the-email-address-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeReserved.class %>" message="the-email-address-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= UserEmailAddressException.MustNotUseCompanyMx.class %>" message="the-email-address-you-requested-is-not-valid-because-its-domain-is-reserved" />
	<liferay-ui:error exception="<%= UserEmailAddressException.MustValidate.class %>" message="please-enter-a-valid-email-address" />
	<liferay-ui:error exception="<%= UserIdException.MustNotBeNull.class %>" message="please-enter-a-user-id" />
	<liferay-ui:error exception="<%= UserIdException.MustNotBeReserved.class %>" message="the-user-id-you-requested-is-reserved" />

	<liferay-ui:error exception="<%= UserPasswordException.MustBeLonger.class %>">

		<%
		UserPasswordException.MustBeLonger upe = (UserPasswordException.MustBeLonger)errorException;
		%>

		<liferay-ui:message arguments="<%= String.valueOf(upe.minLength) %>" key="that-password-is-too-short" translateArguments="<%= false %>" />
	</liferay-ui:error>

	<liferay-ui:error exception="<%= UserPasswordException.MustComplyWithModelListeners.class %>" message="that-password-is-invalid-please-enter-a-different-password" />

	<liferay-ui:error exception="<%= UserPasswordException.MustComplyWithRegex.class %>">

		<%
		UserPasswordException.MustComplyWithRegex upe = (UserPasswordException.MustComplyWithRegex)errorException;
		%>

		<liferay-ui:message arguments="<%= HtmlUtil.escape(upe.regex) %>" key="that-password-does-not-comply-with-the-regular-expression" translateArguments="<%= false %>" />
	</liferay-ui:error>

	<liferay-ui:error exception="<%= UserPasswordException.MustMatch.class %>" message="the-passwords-you-entered-do-not-match" />
	<liferay-ui:error exception="<%= UserPasswordException.MustNotBeNull.class %>" message="the-password-cannot-be-blank" />
	<liferay-ui:error exception="<%= UserPasswordException.MustNotBeTrivial.class %>" message="that-password-uses-common-words-please-enter-a-password-that-is-harder-to-guess-i-e-contains-a-mix-of-numbers-and-letters" />
	<liferay-ui:error exception="<%= UserPasswordException.MustNotContainDictionaryWords.class %>" message="that-password-uses-common-dictionary-words" />
	<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeDuplicate.class %>" focusField="screenName" message="the-screen-name-you-requested-is-already-taken" />
	<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNull.class %>" focusField="screenName" message="the-screen-name-cannot-be-blank" />
	<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNumeric.class %>" focusField="screenName" message="the-screen-name-cannot-contain-only-numeric-values" />
	<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeReserved.class %>" message="the-screen-name-you-requested-is-reserved" />
	<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeReservedForAnonymous.class %>" focusField="screenName" message="the-screen-name-you-requested-is-reserved-for-the-anonymous-user" />
	<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeUsedByGroup.class %>" focusField="screenName" message="the-screen-name-you-requested-is-already-taken-by-a-site" />
	<liferay-ui:error exception="<%= UserScreenNameException.MustProduceValidFriendlyURL.class %>" focusField="screenName" message="the-screen-name-you-requested-must-produce-a-valid-friendly-url" />

	<liferay-ui:error exception="<%= UserScreenNameException.MustValidate.class %>" focusField="screenName">

		<%
		UserScreenNameException.MustValidate usne = (UserScreenNameException.MustValidate)errorException;
		%>

		<liferay-ui:message key="<%= usne.screenNameValidator.getDescription(locale) %>" />
	</liferay-ui:error>

	<liferay-ui:error exception="<%= WebsiteURLException.class %>" message="please-enter-a-valid-url" />

	<c:if test='<%= SessionMessages.contains(request, "openIdUserInformationMissing") %>'>
		<div class="alert alert-info">
			<liferay-ui:message key="you-have-successfully-authenticated-please-provide-the-following-required-information-to-access-the-portal" />
		</div>
	</c:if>

	<aui:model-context model="<%= Contact.class %>" />

	<aui:fieldset column="<%= true %>">
		<aui:col width="<%= 50 %>">
	
<!-- 
				<select  class="form-control" id="_com_liferay_login_web_portlet_LoginPortlet_prefixValue" name="_com_liferay_login_web_portlet_LoginPortlet_prefixValue">
				 <option class="" value="" style="color:#000">
				  Select your Title
				  </option>
					<option class="" value="Dr">
				    	Dr
					</option>
				    <option class="" value="Mr">
						Mr
					</option>
				    <option class="" value="Ms">
				    	Ms
					</option>
				    <option class="" value="Mrs">
				    	Mrs
					</option>
				</select> -->
				<div class="form-group-item">
				<input  style="margin-top: 5%;" placeholder="First Name" class="field form-control lfr-input-text error-field" id="_com_liferay_login_web_portlet_LoginPortlet_firstName" name="_com_liferay_login_web_portlet_LoginPortlet_firstName" style="" type="text" value="" maxlength="75" aria-describedby="" aria-required="true" aria-errormessage="_com_liferay_login_web_portlet_LoginPortlet_firstNameHelper" aria-invalid="true">
		       </div>
		       
		        <c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_MALE) %>">
				<%-- <aui:select label="gender" name="male" placeholder="Gender">
					<aui:option label="male" value="1" />
					<aui:option label="female" selected="<%= !male %>" value="0" />
				</aui:select> --%>
				  <select id="_com_liferay_login_web_portlet_LoginPortlet_male" name="_com_liferay_login_web_portlet_LoginPortlet_male" class="form-control customselect">
                                            <option value="" selected="selected">Gender</option>
                                            <option value="1">Male</option>
                                            <option value="0">Female</option>
                                  
                                        </select>
			</c:if>
		        
			<!-- <liferay-ui:user-name-fields /> -->
		</aui:col>

		<aui:col width="<%= 50 %>">
		      <div class="form-group-item">
		        <input  style="margin-top: 5%;" placeholder="Last Name" class="field form-control lfr-input-text error-field" id="_com_liferay_login_web_portlet_LoginPortlet_lastName" name="_com_liferay_login_web_portlet_LoginPortlet_lastName" style="" type="text" value="" maxlength="75" aria-describedby="" aria-required="true" aria-errormessage="_com_liferay_login_web_portlet_LoginPortlet_lastNameHelper" aria-invalid="true">
			    </div>
			        
			<c:choose>
				<c:when test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_BIRTHDAY) %>">
					<aui:input name="birthday" value="<%= birthdayCalendar %>" placeholder="Birthday"/>
				</c:when>
				<c:otherwise>
					<aui:input name="birthdayMonth" type="hidden" value="<%= Calendar.JANUARY %>" />
					<aui:input name="birthdayDay" type="hidden" value="1" />
					<aui:input name="birthdayYear" type="hidden" value="1970" />
				</c:otherwise>
			</c:choose>
			</aui:col> 
			<aui:col width="<%= 100 %>">   
			
			<%
			Boolean autoGenerateScreenName = PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE);
			%>

			<c:if test="<%= !autoGenerateScreenName %>">
				<aui:input autoFocus="<%= true %>" model="<%= User.class %>" name="screenName">

					<%
					ScreenNameValidator screenNameValidator = ScreenNameValidatorFactory.getInstance();
					%>

					<c:if test="<%= Validator.isNotNull(screenNameValidator.getAUIValidatorJS()) %>">
						<aui:validator errorMessage="<%= screenNameValidator.getDescription(locale) %>" name="custom">
							<%= screenNameValidator.getAUIValidatorJS() %>
						</aui:validator>
					</c:if>
				</aui:input>
			</c:if>
			
				<aui:input autoFocus="<%= autoGenerateScreenName %>" model="<%= User.class %>" name="emailAddress" placeholder="Email Address">
					<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_EMAIL_ADDRESS_REQUIRED) %>">
						<aui:validator name="required" />
					</c:if>
				</aui:input>
			</aui:col> 
			<aui:col width="<%= 50 %>">   
			<c:if test="<%= PropsValues.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD %>">
				<aui:input label="password" name="password1" size="30" type="password" value="" placeholder="Password">
					<aui:validator name="required" />
				</aui:input>
<!-- 
				<aui:input label="enter-again" name="password2" size="30" type="password" value=""  placeholder="Confirm Password">
					<aui:validator name="equalTo">
						'#<portlet:namespace />password1'
					</aui:validator>

					<aui:validator name="required" />
				</aui:input> -->
			</c:if>

			
			<c:if test="<%= captchaConfiguration.createAccountCaptchaEnabled() %>">
				<portlet:resourceURL id="/login/captcha" var="captchaURL" />

				<liferay-captcha:captcha
					url="<%= captchaURL %>"
				/>
			</c:if>
		</aui:col>
		<aui:col width="<%= 50 %>">   
			<c:if test="<%= PropsValues.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD %>">
				<!-- <aui:input label="password" name="password1" size="30" type="password" value="" placeholder="Password">
					<aui:validator name="required" />
				</aui:input> -->

				<aui:input label="enter-again" name="password2" size="30" type="password" value=""  placeholder="Confirm Password">
					<aui:validator name="equalTo">
						'#<portlet:namespace />password1'
					</aui:validator>

					<aui:validator name="required" />
				</aui:input>
			</c:if>

			
		</aui:col>
			<div class="row col-md-12" style="padding:0;">
	<div class="col-md-2">
	<div class="form-group-item">
	<input type="text" placeholder="+966" id="countrycode" name="countrycode" class="form-control phonetextbox">
	</div>
	</div>
	<div class="col-md-3">
	<div class="form-group-item">
	<input type="text" placeholder="Phone" id="phoneno" name="phoneno" class="form-control phonetextbox">
	</div>
	</div>
	<div class="col-md-7">
	<div class="form-group-item">
				<select id="country" name="country" class="form-control select-country">
                                            <option value="" selected="selected">Country</option>
                                            <option value="1">Saudi Arab</option>
                                            <option value="2">USA</option>
                                  
                                        </select>
		 </div>
	</div>
	</div>
	 <div class="row">
                        <div class="col-md-12" style="padding-left:4%">
                             <div class="checkbox-container">
                             <span style="position: relative;top:-2px;">
                                    I accept Youth Hub Terms & Conditions  <span style="border-left:1px solid #ffffff;padding-right: 2px;"></span>    Privacy policy.</span>
                                    <input type="checkbox" id="credentailnotexpire" name="credentailnotexpire">
                                    <label class="checkmark" for="credentailnotexpire">
                                    </label>
                                </div>
                        </div>
       </div>
	</aui:fieldset>
<script>
$('#fromAccount').submit(function() {
	 alert(123)
	var obj={};
	//obj.userId=themeDisplay.getUserId();
	obj.firstname=$("#_com_liferay_login_web_portlet_LoginPortlet_firstName").val();
	var section="test";
	var action="addProfileInfo";
	   AUI().use('aui-io-request', function(A){
           A.io.request('http://localhost:8888/web/guest/profile?p_p_id=ProfileMvcProtlet_ProfileMvcProtletPortlet_INSTANCE_6ck03yXoc6QF&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&_ProfileMvcProtlet_ProfileMvcProtletPortlet_INSTANCE_6ck03yXoc6QF_param1=Value1&_ProfileMvcProtlet_ProfileMvcProtletPortlet_INSTANCE_6ck03yXoc6QF_mvcPath=%2FeditProfile.jsp', {
                  method: 'post',
                  data: {
                   _ProfileMvcProtlet_ProfileMvcProtletPortlet_INSTANCE_6ck03yXoc6QF_obj: JSON.stringify(obj),
               	   _ProfileMvcProtlet_ProfileMvcProtletPortlet_INSTANCE_6ck03yXoc6QF_section: section,
               	   _ProfileMvcProtlet_ProfileMvcProtletPortlet_INSTANCE_6ck03yXoc6QF_action: action,
                  },
                  on: {
                      	success: function() {
                      		 alert(456)
                      var json =  JSON.parse(this.get('responseData'));
                      debugger;
					 if (section == "all")
                      {
						  getEducationSaved(json);
						  getWorkexperienceSaved(json);
						  getLanguageSaved(json);
						  getuserkillsSaved(json);
                      }
						
                      }
                 }
           });
    
       });
});
</script>
      <div class="row">
        <div class="col-md-12">
        <aui:button-row>
		<span> <button onclick="location.href='/c/portal/login?p_l_id=17'" class="btn whitebutton">Sign In </button></span>
		
		<span><button  type="submit" class="btn btnsingup bg-white" style="margin-left: 15px;">Sign Up</button> </span>
	</aui:button-row>
 
      </div>
      </div>
                   <div class="row">
                   <div class="col-md-12">
                  <span>OR</span> 
                   </div>
                   </div>
                     <div class="row pt-2">
                      <div class="col-md-3">
                      
                      <span style="margin-left: 15px;">Sign in with</span> 
                      </div>
                       <div class="col-md-9">
                        <div class="rounded-social-buttons">
                        <div class="social-media-icons">
                        <span><a class="circle-button facebook" href="#"></a></span>
                        <span style="margin-left: -17px;"><a class="circle-button twitter" href="#"></a></span>
                        <span style="margin-left: -17px;"><a class="circle-button linkedin" href="#"></a></span>                                                         
                        </div>                                         
                     </div>
                      </div>
                     </div>
	
</aui:form>
</div>
</div>
</div>
</div>

 </section>
 </div>
 </div>
<%-- <%@ include file="/navigation.jspf" %> --%>