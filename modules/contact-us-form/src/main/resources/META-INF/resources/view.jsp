<%@
page import="com.liferay.portal.kernel.captcha.CaptchaConfigurationException" %><%@
page import="com.liferay.portal.kernel.captcha.CaptchaTextException" %><%@
taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>
<%@ page import="com.liferay.captcha.configuration.CaptchaConfiguration" %>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<script src="/o/new-misk-theme/js/landing/custom.js"></script> 
<%@ include file="/init.jsp" %>

<% if(themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")) { %>
<link href="/o/new-misk-theme/css/landing/CustomStyle_Ar.css" rel="stylesheet" />
<% } else { %>
<link href="/o/new-misk-theme/css/landing/CustomStyle.css" rel="stylesheet" />
<% } %>


<style>
	.fixed-top{
		z-index: 9 !Important;
	}
</style>


<portlet:resourceURL var="captchaURL"/>
<portlet:actionURL  var="validateURL" name="validateCaptcha"/>

<portlet:actionURL name="addcontactUSForm" var="addContactURL">
	</portlet:actionURL>

<%-- <liferay-ui:error exception="<%= CaptchaConfigurationException.class %>" message="a-captcha-error-occurred-please-contact-an-administrator" />
<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" /> --%>
<aui:form cssClass="formClass" name="fm" action="<%=addContactURL.toString()%>" method="post" autocomplete="off">
	
	<div id="global-header-section">
		<div id="intro-title" class="container">
			<h2>
				<span><liferay-ui:message key='contact-us' /></span>
				<p class="underline"></p>
			</h2>
			<h3>
				<span>&nbsp;</span>
			</h3>
			<br>
		</div>
	</div>
	
	
	
	<liferay-ui:error exception="<%= CaptchaConfigurationException.class %>" message="a-captcha-error-occurred-please-contact-an-administrator" />
	<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
	<div class="col-md-12 main-div-form">
		<div class="contact-us">
	<div class="row information">
		<div class="col-md-12 information-title">
			<h5><liferay-ui:message key="Lets-Connect" /></h5>
		</div>
<!-- 		<div class="col-md-4"> -->
<!-- 			<i class="fa fa-map-marker green"></i> -->
<!-- 			<p>7259 Salah Ad Din Al Ayyubi</p> -->
<!-- 			<p>Rd Al Zahra Dist - Unit No</p> -->
<!-- 			<p>8722 Riyadh 12811 - 2071</p> -->
<!-- 			<p>Kingdom of Saudi Arabia</p> -->
<!-- 		</div> -->
<!-- 		<div class="col-md-4"> -->
<!-- 			<i class="fa fa-phone blue"></i> -->
<!-- 			<p>+966 11 208 6050</p> -->
<!-- 			<p>+966 11 208 6051</p> -->
<!-- 			<p>+966 11 208 6053</p> -->
<!-- 		</div> -->
		<div class="col-md-12">
			<i class="fa fa-envelope orange"></i>
			<p>hello@miskhub.com</p>
			<p>support@miskhub.com</p>
		</div>
	</div>
	<div class="row contact-form">
		<div class="col-md-12">
			<form action="/action_page.php">
				<div class="form-group">
					<label><liferay-ui:message key="person-name" /></label>
					<aui:input maxlength="70"placeholder="person-name" name="person-name" type="text" label="" cssClass="form-control person-name" >
						<aui:validator name="required" />
						<aui:validator name="required" />
					</aui:input>
				</div>
				<div class="form-group">
					<label><liferay-ui:message key="person-email" /></label>
					<aui:input maxlength="70"placeholder="person-email" name="person-email" type="email" label="" cssClass="form-control person-email" >
						<aui:validator name="email"/>
						<aui:validator name="required" />
					</aui:input>
				</div>
				<div class="form-group">
					<label><liferay-ui:message key="person-address" /></label>
					<aui:input maxlength="70"placeholder="person-address" name="person-address" type="text" label="" cssClass="form-control person-address" >
						<aui:validator name="required" />
					</aui:input>
				</div>
				<div class="form-group">
					<label><liferay-ui:message key="form-subject" /></label>
					<aui:input maxlength="70"placeholder="form-subject" name="form-subject" type="text" label="" cssClass="form-control form-subject" >
						<aui:validator name="required" />
					</aui:input>
				</div>
				<div class="form-group">
					<label><liferay-ui:message key="form-message" /></label>
					<aui:input maxlength="600"type="textarea" name="form-message" placeholder="form-message">
						<aui:validator name="required" />
					</aui:input>
				</div>
				<aui:button-row>
					<aui:button cssClass='submitFormButton btn-submit' name='addBook' type='submit' value='submitFormButton'  />
				</aui:button-row>
			</form>
		</div>
	</div>
<!-- 	<div class="row contact-map"> -->
<!-- 		<iframe height="500" id="gmap_canvas" src="https://maps.google.com/maps?q=comptechco&t=&z=13&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe> -->
<!-- 	</div> -->
	<div class="row contact-follow">
		<div class="col-md-12 follow-title">
			<h5><liferay-ui:message key="Follow-Us-On" /></h5>
		</div>
		<div class="col-md-4">
			<a href="https://www.facebook.com/Misk-Foundation-1627099104168308" target="_blank">
				<img src="/o/new-misk-theme/images/c-facebook-icon.png">
				<p>@miskyouthhub</p>
			</a>
		</div>
		<div class="col-md-4">
			<a href="https://www.instagram.com/MISKKSA/" target="_blank">
				<img src="/o/new-misk-theme/images/c-instagram-icon.png">
				<p>@miskyouthhub</p>
			</a>
		</div>
		<div class="col-md-4">
			<a href="https://twitter.com/MiskKSA" target="_blank">
				<img src="/o/new-misk-theme/images/c-twitter-icon.png">
				<p>@miskyouthhub</p>
			</a>
		</div>
	</div>
</div>
	</div>
</aui:form>