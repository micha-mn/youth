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

<%@ include file="/init.jsp"%>

<link
	href="/o/new-misk-theme/css/font/font-awesome/font-awesome.min.css"
	rel="stylesheet" />
<%
	if (themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")) {
%>
<link href="/o/new-misk-theme/css/landing/CustomStyle_Ar.css"
	rel="stylesheet" />
<%
	} else {
%>
<link href="/o/new-misk-theme/css/landing/CustomStyle.css"
	rel="stylesheet" />
<%
	}
%>

<script src="/o/new-misk-theme/js/landing/jquery.counterup.min.js"></script>
<script src="/o/new-misk-theme/js/landing/scrollreveal.min.js"></script>
<script src="/o/new-misk-theme/js/landing/imgfix.min.js"></script>
<script src="/o/new-misk-theme/js/landing/wow.min.js"></script>
<script src="/o/new-misk-theme/js/landing/custom.js"></script>
<script src="/o/new-misk-theme/js/landing/countries.min.js"></script>
<style>
<%if (themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")) {%> .row { direction:rtl;
	
}
<%}%>
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

<c:if test="<%=Validator.isNotNull(openId)%>">
	<div class="alert alert-info">
		<liferay-ui:message arguments="<%=openId%>"
			key="you-are-about-to-create-an-account-with-openid-x"
			translateArguments="<%=false%>" />
	</div>
</c:if>

<portlet:actionURL name="/login/create_account"
	secure="<%=PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure()%>"
	var="createAccountURL"
	windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
	<portlet:param name="mvcRenderCommandName"
		value="/login/create_account" />
</portlet:actionURL>

<div
	class="container-fluid section-bgcolor p-0 create-account-container">
	<div id="global-header-section-login-register">
		<section id="createaccount-section" class="container">
			<div class="row pb-5" id="register-form">
				<div class="col-md-4 p-0">
					<div class="h-50 d-flex justify-content-center flex-column">
						<h3>
							<h3>
								<liferay-ui:message key="DreamBelieveBuild" />
							</h3>
							<p>
								<liferay-ui:message key="EverythingYouCanImagine" />
								<br />
								<liferay-ui:message key="YouthHubToday" />
							</p>
					</div>
				</div>
				<div class="col-md-8">
					<div class="row">
						<div class="col-md-12">
							<aui:form action="<%=createAccountURL%>" method="post"
								name="fm">
								<aui:input name="saveLastPath" type="hidden"
									value="<%=false%>" />
								<aui:input name="<%=Constants.CMD%>" type="hidden"
									value="<%=Constants.ADD%>" />
								<aui:input name="redirect" type="hidden" value="<%=redirect%>" />
								<aui:input name="openId" type="hidden" value="<%=openId%>" />

								<liferay-ui:error exception="<%=AddressCityException.class%>"
									message="please-enter-a-valid-city" />
								<liferay-ui:error
									exception="<%=AddressStreetException.class%>"
									message="please-enter-a-valid-street" />
								<liferay-ui:error exception="<%=AddressZipException.class%>"
									message="please-enter-a-valid-postal-code" />
								<liferay-ui:error
									exception="<%=CaptchaConfigurationException.class%>"
									message="a-captcha-error-occurred-please-contact-an-administrator" />
								<liferay-ui:error exception="<%=CaptchaTextException.class%>"
									message="text-verification-failed" />
								<liferay-ui:error
									exception="<%=CompanyMaxUsersException.class%>"
									message="unable-to-create-user-account-because-the-maximum-number-of-users-has-been-reached" />
								<liferay-ui:error
									exception="<%=ContactBirthdayException.class%>"
									message="please-enter-a-valid-birthday" />
								<liferay-ui:error
									exception="<%=ContactNameException.MustHaveFirstName.class%>"
									message="please-enter-a-valid-first-name" />
								<liferay-ui:error
									exception="<%=ContactNameException.MustHaveLastName.class%>"
									message="please-enter-a-valid-last-name" />
								<liferay-ui:error
									exception="<%=ContactNameException.MustHaveValidFullName.class%>"
									message="please-enter-a-valid-first-middle-and-last-name" />
								<liferay-ui:error
									exception="<%=DuplicateOpenIdException.class%>"
									message="a-user-with-that-openid-already-exists" />
								<liferay-ui:error exception="<%=EmailAddressException.class%>"
									message="please-enter-a-valid-email-address" />

								<liferay-ui:error
									exception="<%=GroupFriendlyURLException.class%>">

									<%
										GroupFriendlyURLException gfurle = (GroupFriendlyURLException) errorException;
									%>

									<c:if
										test="<%=gfurle.getType() == GroupFriendlyURLException.DUPLICATE%>">
										<liferay-ui:message
											key="the-screen-name-you-requested-is-associated-with-an-existing-friendly-url" />
									</c:if>
								</liferay-ui:error>

								<liferay-ui:error
									exception="<%=NoSuchCountryException.class%>"
									message="please-select-a-country" />
								<liferay-ui:error
									exception="<%=NoSuchListTypeException.class%>"
									message="please-select-a-type" />
								<liferay-ui:error exception="<%=NoSuchRegionException.class%>"
									message="please-select-a-region" />
								<liferay-ui:error exception="<%=PhoneNumberException.class%>"
									message="please-enter-a-valid-phone-number" />
								<liferay-ui:error
									exception="<%=PhoneNumberExtensionException.class%>"
									message="please-enter-a-valid-phone-number-extension" />
								<liferay-ui:error
									exception="<%=RequiredFieldException.class%>"
									message="please-fill-out-all-required-fields" />
								<liferay-ui:error exception="<%=TermsOfUseException.class%>"
									message="you-must-agree-to-the-terms-of-use" />
								<liferay-ui:error
									exception="<%=UserEmailAddressException.MustNotBeDuplicate.class%>"
									message="the-email-address-you-requested-is-already-taken" />
								<liferay-ui:error
									exception="<%=UserEmailAddressException.MustNotBeNull.class%>"
									message="please-enter-an-email-address" />
								<liferay-ui:error
									exception="<%=UserEmailAddressException.MustNotBePOP3User.class%>"
									message="the-email-address-you-requested-is-reserved" />
								<liferay-ui:error
									exception="<%=UserEmailAddressException.MustNotBeReserved.class%>"
									message="the-email-address-you-requested-is-reserved" />
								<liferay-ui:error
									exception="<%=UserEmailAddressException.MustNotUseCompanyMx.class%>"
									message="the-email-address-you-requested-is-not-valid-because-its-domain-is-reserved" />
								<liferay-ui:error
									exception="<%=UserEmailAddressException.MustValidate.class%>"
									message="please-enter-a-valid-email-address" />
								<liferay-ui:error
									exception="<%=UserIdException.MustNotBeNull.class%>"
									message="please-enter-a-user-id" />
								<liferay-ui:error
									exception="<%=UserIdException.MustNotBeReserved.class%>"
									message="the-user-id-you-requested-is-reserved" />

								<liferay-ui:error
									exception="<%=UserPasswordException.MustBeLonger.class%>">

									<%
										UserPasswordException.MustBeLonger upe = (UserPasswordException.MustBeLonger) errorException;
									%>

									<liferay-ui:message
										arguments="<%=String.valueOf(upe.minLength)%>"
										key="that-password-is-too-short"
										translateArguments="<%=false%>" />
								</liferay-ui:error>

								<liferay-ui:error
									exception="<%=UserPasswordException.MustComplyWithModelListeners.class%>"
									message="that-password-is-invalid-please-enter-a-different-password" />

								<liferay-ui:error
									exception="<%=UserPasswordException.MustComplyWithRegex.class%>">

									<%
										UserPasswordException.MustComplyWithRegex upe = (UserPasswordException.MustComplyWithRegex) errorException;
									%>

									<liferay-ui:message
										arguments="<%=HtmlUtil.escape(upe.regex)%>"
										key="that-password-does-not-comply-with-the-regular-expression"
										translateArguments="<%=false%>" />
								</liferay-ui:error>

								<liferay-ui:error
									exception="<%=UserPasswordException.MustMatch.class%>"
									message="the-passwords-you-entered-do-not-match" />
								<liferay-ui:error
									exception="<%=UserPasswordException.MustNotBeNull.class%>"
									message="the-password-cannot-be-blank" />
								<liferay-ui:error
									exception="<%=UserPasswordException.MustNotBeTrivial.class%>"
									message="that-password-uses-common-words-please-enter-a-password-that-is-harder-to-guess-i-e-contains-a-mix-of-numbers-and-letters" />
								<liferay-ui:error
									exception="<%=UserPasswordException.MustNotContainDictionaryWords.class%>"
									message="that-password-uses-common-dictionary-words" />
								<liferay-ui:error
									exception="<%=UserScreenNameException.MustNotBeDuplicate.class%>"
									focusField="screenName"
									message="the-screen-name-you-requested-is-already-taken" />
								<liferay-ui:error
									exception="<%=UserScreenNameException.MustNotBeNull.class%>"
									focusField="screenName"
									message="the-screen-name-cannot-be-blank" />
								<liferay-ui:error
									exception="<%=UserScreenNameException.MustNotBeNumeric.class%>"
									focusField="screenName"
									message="the-screen-name-cannot-contain-only-numeric-values" />
								<liferay-ui:error
									exception="<%=UserScreenNameException.MustNotBeReserved.class%>"
									message="the-screen-name-you-requested-is-reserved" />
								<liferay-ui:error
									exception="<%=UserScreenNameException.MustNotBeReservedForAnonymous.class%>"
									focusField="screenName"
									message="the-screen-name-you-requested-is-reserved-for-the-anonymous-user" />
								<liferay-ui:error
									exception="<%=UserScreenNameException.MustNotBeUsedByGroup.class%>"
									focusField="screenName"
									message="the-screen-name-you-requested-is-already-taken-by-a-site" />
								<liferay-ui:error
									exception="<%=UserScreenNameException.MustProduceValidFriendlyURL.class%>"
									focusField="screenName"
									message="the-screen-name-you-requested-must-produce-a-valid-friendly-url" />

								<liferay-ui:error
									exception="<%=UserScreenNameException.MustValidate.class%>"
									focusField="screenName">

									<%
										UserScreenNameException.MustValidate usne = (UserScreenNameException.MustValidate) errorException;
									%>

									<liferay-ui:message
										key="<%=usne.screenNameValidator.getDescription(locale)%>" />
								</liferay-ui:error>

								<liferay-ui:error exception="<%=WebsiteURLException.class%>"
									message="please-enter-a-valid-url" />

								<c:if
									test='<%=SessionMessages.contains(request, "openIdUserInformationMissing")%>'>
									<div class="alert alert-info">
										<liferay-ui:message
											key="you-have-successfully-authenticated-please-provide-the-following-required-information-to-access-the-portal" />
									</div>
								</c:if>

								<aui:model-context model="<%=Contact.class%>" />

								<aui:fieldset column="<%=true%>">

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
										<div class="form-group-item mb-3 col-md-6">
											<input tabindex="3" 
												placeholder="<liferay-ui:message key="FirstName" />"
												class="field form-control lfr-input-text error-field"
												id="_com_liferay_login_web_portlet_LoginPortlet_firstName"
												name="_com_liferay_login_web_portlet_LoginPortlet_firstName"
												style="" type="text" value="" maxlength="75"
												aria-describedby="" aria-required="true"
												aria-errormessage="_com_liferay_login_web_portlet_LoginPortlet_firstNameHelper"
												aria-invalid="true" autocomplete="nope">
										</div>

										
										<div class="form-group-item mb-3 col-md-6">
											<input tabindex="3" 
												placeholder="<liferay-ui:message key="LastName" />"
												class="field form-control lfr-input-text error-field"
												id="_com_liferay_login_web_portlet_LoginPortlet_lastName"
												name="_com_liferay_login_web_portlet_LoginPortlet_lastName"
												style="" type="text" value="" maxlength="75"
												aria-describedby="" aria-required="true"
												aria-errormessage="_com_liferay_login_web_portlet_LoginPortlet_lastNameHelper"
												aria-invalid="true" autocomplete="nope">
										</div>
										
										<c:if
											test="<%=PrefsPropsUtil.getBoolean(company.getCompanyId(),
									PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_MALE)%>">
											<%-- <aui:select label="gender" name="male" placeholder="Gender">
					<aui:option label="male" value="1" />
					<aui:option label="female" selected="<%= !male %>" value="0" />
				</aui:select> --%>		<div class="form-group-item mb-3 col-md-6">
											<select tabindex="4"
												id="_com_liferay_login_web_portlet_LoginPortlet_male"
												name="_com_liferay_login_web_portlet_LoginPortlet_male"
												class="form-control customselect" autocomplete="nope">
												<option value="" selected="selected"><liferay-ui:message
														key="Gender" /></option>
												<option value="1"><liferay-ui:message key="Male" /></option>
												<option value="0"><liferay-ui:message key="Female" /></option>
											</select>
										</div>
										</c:if>


										<div class="form-group-item mb-3 col-md-6">
										<c:choose>
											<c:when
												test="<%=PrefsPropsUtil.getBoolean(company.getCompanyId(),
										PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_KERNEL_MODEL_CONTACT_BIRTHDAY)%>">
												<aui:input tabindex="4" name="birthday"
													value="<%=birthdayCalendar%>" placeholder="Birthday" />
											</c:when>
											<c:otherwise>
												<aui:input tabindex="4" name="birthdayMonth" type="hidden"
													value="<%=Calendar.JANUARY%>" />
												<aui:input tabindex="4" name="birthdayDay" type="hidden"
													value="1" />
												<aui:input tabindex="4" name="birthdayYear" type="hidden"
													value="1970" />
											</c:otherwise>
										</c:choose>
										</div>

										<%
											Boolean autoGenerateScreenName = PrefsPropsUtil.getBoolean(company.getCompanyId(),
																PropsKeys.USERS_SCREEN_NAME_ALWAYS_AUTOGENERATE);
										%>

										<c:if test="<%=!autoGenerateScreenName%>">
											<aui:input autoFocus="<%=true%>" model="<%=User.class%>"
												name="screenName">

												<%
													ScreenNameValidator screenNameValidator = ScreenNameValidatorFactory.getInstance();
												%>

												<c:if
													test="<%=Validator.isNotNull(screenNameValidator.getAUIValidatorJS())%>">
													<aui:validator
														errorMessage="<%=screenNameValidator.getDescription(locale)%>"
														name="custom">
														<%=screenNameValidator.getAUIValidatorJS()%>
													</aui:validator>
												</c:if>
											</aui:input>
										</c:if>

										<div class="form-group-item mb-3 col-md-12">
											<aui:input tabindex="4"
												autoFocus="<%=autoGenerateScreenName%>"
												model="<%=User.class%>" name="emailAddress"
												placeholder="EmailAddress" autocomplete="nope">
												<c:if
													test="<%=PrefsPropsUtil.getBoolean(company.getCompanyId(),
											PropsKeys.USERS_EMAIL_ADDRESS_REQUIRED)%>">
													<aui:validator name="required" />
												</c:if>
											</aui:input>
										</div>
										
										<c:if
											test="<%=PropsValues.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD%>">
											<div class="form-group-item mb-3 col-md-6">
											<aui:input tabindex="4" label="password" name="password1"
												size="30" type="password" value="" placeholder="Password">
												<aui:validator name="required" />
											</aui:input>
											</div>
											<!-- 
				<aui:input label="enter-again" name="password2" size="30" type="password" value=""  placeholder="Confirm Password">
					<aui:validator name="equalTo">
						'#<portlet:namespace />password1'
					</aui:validator>

					<aui:validator name="required" />
				</aui:input> -->
										</c:if>


										<c:if
											test="<%=captchaConfiguration.createAccountCaptchaEnabled()%>">
											<portlet:resourceURL id="/login/captcha" var="captchaURL" />

											<liferay-captcha:captcha url="<%=captchaURL%>" />
										</c:if>
										<c:if
											test="<%=PropsValues.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD%>">
											<!-- <aui:input label="password" name="password1" size="30" type="password" value="" placeholder="Password">
					<aui:validator name="required" />
				</aui:input> -->
										<div class="form-group-item mb-3 col-md-6">
											<aui:input tabindex="4" label="enter-again" name="password2"
												size="30" type="password" value=""
												placeholder="ConfirmPassword">
												<aui:validator name="equalTo">
						'#<portlet:namespace />password1'
					</aui:validator>

												<aui:validator name="required" />
											</aui:input>
											</div>
										</c:if>


									<div class="row col-md-12 p-0">
										<div class="col-md-2 phone-input">
											<div class="form-group-item">
												<input tabindex="4" type="number" placeholder="+966"
													id="countrycode" name="countrycode"
													class="form-control phonetextbox">
											</div>
										</div>
										<div class="col-md-4 phone-input">
											<div class="form-group-item">
												<input tabindex="4" type="number"
													placeholder="<liferay-ui:message key="Phone" />"
													onKeyPress="if(this.value.length==9) return false;"
													max="999999999" id="phoneno" name="phoneno"
													class="form-control phonetextbox">
											</div>
										</div>
										<div class="col-md-6 phone-input">
											<div class="form-group-item">
												<select tabindex="4" id="country" name="country"
													class="form-control select-country">
													<option value="" selected="selected"><liferay-ui:message
															key="Country" /></option>
												</select>
												<script type="text/javascript">
													var country_element = document
															.getElementById('country');

													document
															.addEventListener(
																	"load",
																	populateCountries(country_element));
												</script>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12" style="padding-left: 4%">
											<div class="checkbox-container">
												<span
													style="position: relative; top: -2px; width: 400px; display: inline-block"
													data-toggle="modal" data-target="#privacymodal"> <liferay-ui:message
														key="IAcceptYouthHubTerms" /></span> <input tabindex="4"
													type="checkbox" id="credentailnotexpire"
													name="credentailnotexpire"> <label
													class="checkmark" for="credentailnotexpire"></label>
											</div>
										</div>
									</div>
								</aui:fieldset>
								<script>
									// if (navigator.userAgent.toLowerCase().indexOf("chrome") >= 0)
									// {
									//     var _interval = window.setInterval(function ()
									//     {
									//         var autofills = $('input:-webkit-autofill');
									//         if (autofills.length > 0)
									//         {
									//             window.clearInterval(_interval); // stop polling
									//             autofills.each(function()
									//             {
									//                 var clone = $(this).clone(true, true);
									//                 $(this).after(clone).remove();
									//             });
									//         }
									//     }, 20);
									// }
									$('#fromAccount')
											.submit(
													function() {
														var obj = {};
														//obj.userId=themeDisplay.getUserId();
														obj.firstname = $(
																"#_com_liferay_login_web_portlet_LoginPortlet_firstName")
																.val();
														var section = "test";
														var action = "addProfileInfo";
														AUI()
																.use(
																		'aui-io-request',
																		function(
																				A) {
																			A.io
																					.request(
																							'http://localhost:8888/web/guest/profile?p_p_id=ProfileMvcProtlet_ProfileMvcProtletPortlet_INSTANCE_6ck03yXoc6QF&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&_ProfileMvcProtlet_ProfileMvcProtletPortlet_INSTANCE_6ck03yXoc6QF_param1=Value1&_ProfileMvcProtlet_ProfileMvcProtletPortlet_INSTANCE_6ck03yXoc6QF_mvcPath=%2FeditProfile.jsp',
																							{
																								method : 'post',
																								data : {
																									_ProfileMvcProtlet_ProfileMvcProtletPortlet_INSTANCE_6ck03yXoc6QF_obj : JSON
																											.stringify(obj),
																									_ProfileMvcProtlet_ProfileMvcProtletPortlet_INSTANCE_6ck03yXoc6QF_section : section,
																									_ProfileMvcProtlet_ProfileMvcProtletPortlet_INSTANCE_6ck03yXoc6QF_action : action,
																								},
																								on : {
																									success : function() {
																										var json = JSON
																												.parse(this
																														.get('responseData'));
																										if (section == "all") {
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
											<span> <a tabindex="4"
												href="/c/portal/login?p_l_id=17" class="btn whitebutton"><liferay-ui:message
														key="SignIn" /> </a></span>

											<span><button tabindex="4" id="submitBtn"
													type="submit" class="btn whitebutton" disabled="disabled">
													<liferay-ui:message key="SignUp" />
												</button> </span>
										</aui:button-row>

									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<span><liferay-ui:message key="OR" /></span>
									</div>
								</div>
								<div class="row pt-2">
									<div class="col-md-4 col-xs-5">

										<span style="vertical-align: sub;"><liferay-ui:message
												key="SignInWith" /></span>
									</div>
									<div class="col-md-8 col-xs-7">
										<div class="rounded-social-buttons">
											<div class="social-media-icons">
												<span><a tabindex="4" class="circle-button facebook"
													href="/c/portal/login"
													target="_self" class=" lfr-icon-item taglib-icon"
													id="_com_liferay_login_web_portlet_LoginPortlet_facebook____"
													role="menuitem"></a></span> <span><a tabindex="4"
													class="circle-button google"
													href="/c/portal/login"
													target="_self" class=" lfr-icon-item taglib-icon"
													id="_com_liferay_login_web_portlet_LoginPortlet_ctvk____"
													role="menuitem"></a></span> <span><a tabindex="4"
													class="circle-button twitter" id="_com_liferay_login_web_portlet_LoginPortlet_twitter____" href="/c/portal/login"></a></span> <span><a
													class="circle-button linkedin" href="#"></a></span>
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
<script>
$( document ).ready(function() {
	$("#_com_liferay_login_web_portlet_LoginPortlet_facebook____").attr("href", $("a",$(".taglib-icon-list").find("li")[0]).attr('href')); 
	 $("#_com_liferay_login_web_portlet_LoginPortlet_twitter____").attr("href", $("a",$(".taglib-icon-list").find("li")[2]).attr('href')); 
	$("#_com_liferay_login_web_portlet_LoginPortlet_emailAddress").attr("tabindex","4");
	$("#_com_liferay_login_web_portlet_LoginPortlet_birthday").attr("tabindex","4");
	$("#_com_liferay_login_web_portlet_LoginPortlet_birthday").val("");
	
    $('#credentailnotexpire').change(function() {
	    if (!$('#credentailnotexpire').prop('checked'))
	      $("#submitBtn").attr("disabled","disabled");
	    else
	      $("#submitBtn").removeAttr("disabled");
    });
});
</script>