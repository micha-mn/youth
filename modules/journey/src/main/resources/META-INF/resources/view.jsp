<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%-- <%@page import="basic.service.JourneyLocalServiceUtil"%> --%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="java.util.Enumeration"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%
String dateOfBirth = "";
%>

<% String baseUrl = renderResponse.encodeURL(renderRequest.getContextPath());
   String imageUrl = renderResponse.encodeURL(renderRequest.getContextPath()) + "/images/SVG-removebg-preview.png";
   String langId = themeDisplay.getLanguageId().equalsIgnoreCase("ar_SA")? "ar" : "en";

%>

<!-- <script src="https://code.jquery.com/jquery-1.9.1.js"></script> -->
<!-- <script src="https://code.jquery.com/ui/1.9.2/jquery-ui.js"></script> -->
  <script src="/o/new-misk-theme/js/editEvent/jquery-ui1.12.1.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<!--  <script src="/o/new-misk-theme/js/from/jquery-3.3.1.min.js"></script> -->
<% if(themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")) { %>
<link href="/o/new-misk-theme/css/landing/CustomStyle_Ar.css" rel="stylesheet" />
<% } else { %>
<link href="/o/new-misk-theme/css/landing/CustomStyle.css" rel="stylesheet" />
<% } %>
<script src="/o/new-misk-theme/js/landing/custom.js"></script> 
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/fontawesome.scss"> --%>
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> -->
<!-- <link  href="/o/new-misk-theme/css/font/font-awesome/font-awesome.min.css" rel="stylesheet"/> -->

<style>
.privacy-column.ar,
.pirvacy-title-div.ar,
.categoryClass.ar {
	direction: rtl;
}

#dialog-form div.row div.col-12.ar {
	direction: rtl;
}
#dialog-form{
	height: auto !important;
}

.description-p {
	word-wrap: break-word;
	overflow-wrap: break-word;
}
.privacy-column 
.icon-img-center {
    display: flex;
    justify-content: center;
    margin: auto;
    position: relative;
    top: 12px;
    /* width: 63%; */
    height: 25px;
}

.stock-images [type="radio"] + label div.image.selected-radio + span {
	color: rgba(12, 162, 205, 1);
}

div.image.selected-radio {
	color: rgba(12, 162, 205, 1);
}

.displayNone {
	display: none!important;
}

.stock-images .lexicon-icon {
	position: absolute;
    right: 16px;
    top: 8px;
    fill: rgba(12, 162, 205, 1);
}

.custom-design {
	border: 0px;
    background-repeat: no-repeat!important;
    background-position: center!important;
    height: 59px;
    background-size: 22%!important;
    background-image: url(/o/journey/images/0.svg);
    margin-top: 3%;
}

.div-green-dot {
	justify-content: center;
}
.div-green-dot span {
	    text-align: center;
    top: 3px;
    left: 3px;
    background: rgba(125, 183, 44, 1);
    border-radius: 50%;
    width: 17px;
    height: 17px;
}
.div.col-12:nth-child(1) {
	padding-top: 0%;
}

   .stock-images > div:not(:nth-child(1)):not(:last-child) {
    	margin: auto;
    padding: 0% 7.5px!important;
    }
.stock-images > div:nth-child(1).en,
.stock-images > div:nth-child(2).en,
.stock-images > div:nth-child(9).en,
.stock-images > div:nth-child(10).en {
	padding-left : 0%!important;
	padding-right: 7.5px!important;
}

.stock-images > div:nth-child(16).en,
.stock-images > div:nth-child(15).en,
.stock-images > div:nth-child(8).en,
.stock-images > div:nth-child(7).en {
	padding-right : 0%!important;
	padding-left: 7.5px!important; 
}


.stock-images col-3.s6.m3 {
	padding: 0% .25em;
}

.privacy-check {
    text-align: center;
    position: absolute;
    top: 0px;
    left: -5px;
    border-radius: 50%;
    width: 12px;
    height: 12px;
    top: 7px;
}

.privacy-check.ar {
	right: -5px;
}

.privacy-check svg {
    fill: white;
    width: 9px;
    height: 9px;
    bottom: 3px;
    position: relative;
    border: 1px solid transparent;
    border-radius: 50%;
}

.col-12 input, .col-12 textarea {
	opacity: .9;
    border: 1px solid rgba(228, 228, 228, 1);
    box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.04);
}

.button-div-css {
	display: flex;
	justify-content: center;
}

.button-div-css button:nth-child(2) span {
	opacity: .5;
}

.button-div-css button:nth-child(1) span {
	color: white;
}

#count_message {
	color: rgb(49,176,212);
}
/* Hide the browser's default radio button */

/* .container input { */
/*   position: absolute; */
/*   opacity: 0; */
/*   cursor: pointer; */
/* } */

/* Create a custom radio button */
.checkmark {
  position: absolute;
  top: 0;
  left: 0;
  height: 25px;
  width: 25px;
  background-color: #eee;
  border-radius: 50%;
}

/* On mouse-over, add a grey background color */
.container:hover input ~ .checkmark {
  background-color: #ccc;
}

/* When the radio button is checked, add a blue background */
.container input:checked ~ .checkmark {
  background-color: #2196F3;
}

/* Create the indicator (the dot/circle - hidden when not checked) */
.checkmark:after {
  content: "";
  position: absolute;
  display: none;
}

/* Show the indicator (dot/circle) when checked */
.container input:checked ~ .checkmark:after {
  display: block;
}

.container {
    padding-left: 3%!important;
    font-size: .8em!important;
}
    
label.container {
    opacity: .5;
}
    
/* Style the indicator (dot/circle) */
.checkmark:after {
    left: 11px;
    top: 7px;
    width: 5px;
    height: 10px;
    border: solid white;
    border-width: 0 3px 3px 0;
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    transform: rotate(45deg);
}


.dialog-button-custom-css {
	background-color: #00aa60 !important;
    border: 0 !important;
}
.dialog-custom-class {
	border: 0;
    background-color: rgba(0, 0, 0, 0);
    color: rgb(4,47,63);
    }
    
.dialog-custom-class.ar {
	direction: rtl;
}

.bg-transparent {
	background-color: transparent;
}

.title-span {
	font-size: 2rem;
	color: rgb(77,107,119);
}

.short-desription {
	font-size: 1rem;
	opacity: .5;
	overflow-wrap: break-word;
	word-wrap: break-word;
}

#Description.ar {
	text-align: right;
	width: 100%;
	padding: 5px 10px;
}

#Description.en {
	text-align: left;
	width: 100%;
	padding: 5px 10px;
}

#count_message {
	padding-top: 2%;
}
div.radio {
	margin: 10px 6px!important;
	width:100%;
}

div.col-12 input {
	padding: 1%;
}
html.rtl div.col-12 input {
	text-align: right;
}
div.col-12 {
	padding: 5px 0%;
}

.stock-images {
	padding : .25em 0%;
}
.stock-images .image:hover {
  opacity: 1;
}
.stock-images [type="radio"] {
  display: none;
}
.stock-images [type="radio"] + label {
    /* width: 150px; */
    width: 100%;
    height: 97px;
    /* padding: 0; */
    text-align: center;
    border: 1.5px solid;
    border-color: rgb(192,192,192, 0.4);
    border-radius: 5px;
}

.stock-images [type="radio"] + label span {
	color: gray;
	font-weight: 500;
	font-family: Montserrat Regular;
}

.label-checked {
  border: 1.5px solid rgba(12, 162, 205, 1)!important;
    border-radius: 5px
}

.tooltip {
	position: absolute;
	z-index: 1020;
	display: block;
	visibility: visible;
	padding: 5px;
	font-size: 11px;
	opacity: 0;
	filter: alpha(opacity = 0);
}


.tooltip.top {
	margin-top: -2px;
}

.tooltip.right {
	margin-left: 2px;
}

.tooltip.bottom {
	margin-top: 2px;
}

.tooltip.left {
	margin-left: -2px;
}

.tooltip.top .tooltip-arrow {
	bottom: 0;
	left: 0;
	margin-left: 0;
	border-left: 0 solid transparent;
	border-right: 5px solid transparent;
	border-top: 0 solid #000;
}

.tooltip.left .tooltip-arrow {
	bottom: 0;
	left: 0;
	margin-left: 0;
	border-left: 0 solid transparent;
	border-right: 5px solid transparent;
	border-top: 0 solid #000;
}

.tooltip.bottom .tooltip-arrow {
	bottom: 0;
	left: 0;
	margin-left: 0;
	border-left: 0 solid transparent;
	border-right: 5px solid transparent;
	border-top: 0 solid #000;
}

.tooltip.right .tooltip-arrow {
	bottom: 0;
	left: 0;
	margin-left: 0;
	border-left: 0 solid transparent;
	border-right: 5px solid transparent;
	border-top: 0 solid #000;
}

.tooltip-inner {
	width: 200px;
	padding: 3px 8px;
	color: #fff;
	text-align: center;
	text-decoration: none;
	background-color: #313131;
	-webkit-border-radius: 0px;
	-moz-border-radius: 0px;
	border-radius: 0px;
}

.tooltip-arrow {
	position: absolute;
	width: 0;
	height: 0;
}


form div.col-2 { 
	display: none; 
} 

div.col-12 input {
	width: 100%;
	border-radius: 4px;
}


.categoryClass {
	padding: 0% 0% 3%;
	color: rgb(4,47,63);
    font-weight: 700;
}

.date-form-control{
	border: 1px solid rgba(228, 228, 228, 1);
	border-radius: 4px;
	color: gray;
}

.ui-draggable .ui-dialog-titlebar{
	background: linear-gradient(to right, #0061a5, #279574) !important;
	color: #fff;
}

div.col-12 input {
    width: 100%;
    border-radius: 4px;
    font-family: Montserrat-Regular !important;
}	
.stock-images [type="radio"] + label span {
    color: gray;
    font-weight: 500;
    font-family: Montserrat-Regular;
}
.ui-widget.ui-widget-content {
    padding: 0;
    border: 0;
}
.pirvacy-title {font-family: Montserrat-Regular !important;}
.pirvacy-title-div {font-family: Montserrat-Regular !important; padding:10px 5px 0 5px}
div.radio {font-family: Montserrat-Regular !important;margin: 3px 6px 0px 6px !important}
.stock-images > div.col-4.s6.m3{padding: 0% 7.5px!important;}
.journey-container .timeline>li.timeline-inverted>.timeline-badge{z-index:0;}
.journey-container .timeline>li>.timeline-badge img{position: relative;bottom: 3px;}
</style>
<liferay-portlet:resourceURL var="resourceUrl1">
	<liferay-portlet:param name="param1" value="Value1" />
</liferay-portlet:resourceURL>
<div class="journey-container">
<div id="dialog-form" title="<liferay-ui:message key='CreateJourney' />">
	<form>
		<fieldset>
		<input type="hidden" name="baseUrl" id="baseUrl" value="<%=baseUrl %>">
		<div class="row" style="display:none;">
					<div class="col-2">
						<label for="journeyId">ID</label>
					</div>
					<div class="col-12 <%=langId%>">
						<input type="text" required name="journeyId" id="journeyId">
					</div>
				</div>
		
			<div class="row">
				<div class="col-12">
					<label for="Title"><liferay-ui:message key="Title" /></label>
				</div>
				<div class="col-12 <%=langId%>">
					<input type="text" required maxlength="70" name="Title" id="Title" placeholder="<liferay-ui:message key="Title" />">
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<label for="ShortDescription"><liferay-ui:message key="ShortDescription" /></label>
				</div>
				<div class="col-12 <%=langId%>">
					<input type="text" required name="ShortDescription" maxlength="70" id="ShortDescription" placeholder="<liferay-ui:message key="ShortDescription" />">
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<label for="Date"><liferay-ui:message key="Date" /></label>
				</div>
				<div class="col-12 <%=langId%>">
					<input type="date" required value="<%=dateOfBirth%>" name="Date" id="Date" class="date-form-control" placeholder="<liferay-ui:message key="Date" />" />
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<label for="Description"><liferay-ui:message key="Description" /></label>
				</div>
				<div class="col-12 <%=langId%>">
					<textarea value="" required maxlength="300" cols="50" rows="4" name="Description" id="Description" placeholder="<liferay-ui:message key="Description" />">
					</textarea>
					<h6 class="pull-right" id="count_message"></h6>
				</div>
			</div>
			<div class="col-md-12 categoryClass <%=langId%>">
				<span><liferay-ui:message key="Category" /></span>
			</div>
			<%-- <div class="row stock-images">
				<div class="col-3 s6 m3" id="test22"><input id="test0" name="category" type="radio" value="0" /><label for="test0">
	            	<div class="image" style="background-repeat: no-repeat!important; background-position: center!important; height: 65px; background-size: 42%!important; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/0.svg")%>)"></div><span><liferay-ui:message key="Employment" /></span>
	          </label><clay:icon symbol="check" />
	        </div>
	        <div class="col-3 s6 m3 displayNone" id="test33"><input id="test0" name="category" type="radio" value="0" /><label for="test0">
	            	<div class="image" style="background-repeat: no-repeat!important; background-position: center!important; height: 65px; background-size: 42%!important; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/0-selected.svg")%>)"></div><span><liferay-ui:message key="Employment" /></span>
	          </label><clay:icon symbol="check" />
	        </div>
	        <div class="col-3 s6 m3"><input id="test1" name="category" type="radio" value="1" /><label for="test1">
	            	<div class="image" style="background-repeat: no-repeat!important; background-position: center!important; height: 65px; background-size: 42%!important; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/1.svg")%>)"></div><span><liferay-ui:message key="Education" /></span>
	          </label><clay:icon symbol="check" />
	        </div>
	        <div class="col-3 s6 m3"><input id="test2" name="category" type="radio" value="2"/><label for="test2">
	            	<div class="image" style="background-repeat: no-repeat!important; background-position: center!important; height: 65px; background-size: 42%!important; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/2.svg")%>)"></div><span><liferay-ui:message key="Training" /></span>
	          </label><clay:icon symbol="check" />
	        </div>
	        <div class="col-3 s6 m3"><input id="test3" name="category" type="radio" value="3" /><label for="test3">
	            	<div class="image" style="background-repeat: no-repeat!important; background-position: center!important; height: 65px; background-size: 42%!important; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/3.svg")%>)"></div><span><liferay-ui:message key="Community" /></span>
	          </label><clay:icon symbol="check" />
	        </div>
	        </div> --%>
	        <div class="row stock-images">
				<div class="col-4 s6 m3" id="category-div-0"><input id="test0" name="category" type="radio" value="0" /><label for="test0">
	            	<div class="image" style="border: 0px; background-repeat: no-repeat!important; background-position: center!important; height: 59px; background-size: 22%!important; margin-top: 3%; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/0-gray.svg")%>)"></div><span><liferay-ui:message key="Employment" /></span>
	          </label>
	        </div>
	        <div class="col-4 s6 m3 displayNone" id="category-div-0-selected"><input id="test0" name="category" type="radio" value="0" /><label class="label-checked" for="test0">
	            	<div class="image selected-radio " style="border: 0px; background-repeat: no-repeat!important; background-position: center!important; height: 59px; background-size: 22%!important; margin-top: 3%; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/0-selected.svg")%>)"></div><span><liferay-ui:message key="Employment" /></span>
	          </label><clay:icon symbol="check" />
	        </div>
	        <div class="col-4 s6 m3" id="category-div-1"><input id="test1" name="category" type="radio" value="1" /><label for="test1">
	            	<div class="image" style="border: 0px; background-repeat: no-repeat!important; background-position: center!important; height: 59px; background-size: 22%!important; margin-top: 3%; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/1-gray.svg")%>)"></div><span><liferay-ui:message key="Education" /></span>
	          </label>
	        </div>
			<div class="col-4 s6 m3 displayNone" id="category-div-1-selected"><input id="test1" name="category" type="radio" value="1" /><label class="label-checked" for="test1">
	            	<div class="image selected-radio " style="border: 0px; background-repeat: no-repeat!important; background-position: center!important; height: 59px; background-size: 22%!important; margin-top: 3%; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/1-selected.svg")%>)"></div><span><liferay-ui:message key="Education" /></span>
	          </label><clay:icon symbol="check" />
	        </div>
	        <div class="col-4 s6 m3" id="category-div-2"><input id="test2" name="category" type="radio" value="2"/><label for="test2">
	            	<div class="image" style="border: 0px; background-repeat: no-repeat!important; background-position: center!important; height: 59px; background-size: 22%!important; margin-top: 3%; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/2-gray.svg")%>)"></div><span><liferay-ui:message key="Training" /></span>
	          </label>
	        </div>
			 <div class="col-4 s6 m3 displayNone" id="category-div-2-selected"><input id="test2" name="category" type="radio" value="2"/><label class="label-checked" for="test2">
	            	<div class="image selected-radio " style="border: 0px; background-repeat: no-repeat!important; background-position: center!important; height: 59px; background-size: 22%!important; margin-top: 3%; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/2-selected.svg")%>)"></div><span><liferay-ui:message key="Training" /></span>
	          </label><clay:icon symbol="check" />
	        </div>
	        </div>
			<div class="row stock-images">
			<div class="col-4 s6 m3" id="category-div-3"><input id="test3" name="category" type="radio" value="3" /><label for="test3">
	            	<div class="image" style="border: 0px; background-repeat: no-repeat!important; background-position: center!important; height: 59px; background-size: 22%!important; margin-top: 3%; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/3-gray.svg")%>)"></div><span><liferay-ui:message key="Community" /></span>
	          </label>
	        </div>
			<div class="col-4 s6 m3 displayNone" id="category-div-3-selected"><input id="test3" name="category" type="radio" value="3" /><label class="label-checked" for="test3">
	            	<div class="image selected-radio " style="border: 0px; background-repeat: no-repeat!important; background-position: center!important; height: 59px; background-size: 22%!important; margin-top: 3%; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/3-selected.svg")%>)"></div><span><liferay-ui:message key="Community" /></span>
	          </label><clay:icon symbol="check" />
	        </div>
	        <div class="col-4 s6 m3" id="category-div-4"><input id="test4" name="category" type="radio" value="4" /><label for="test4">
	            	<div class="image" style="border: 0px; background-repeat: no-repeat!important; background-position: center!important; height: 59px; background-size: 22%!important; margin-top: 3%; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/4-gray.svg")%>)"></div><span><liferay-ui:message key="Events" /></span>
	          </label>
	        </div>
			<div class="col-4 s6 m3 displayNone" id="category-div-4-selected"><input id="test4" name="category" type="radio" value="4" /><label class="label-checked" for="test4">
	            	<div class="image selected-radio " style="border: 0px; background-repeat: no-repeat!important; background-position: center!important; height: 59px; background-size: 22%!important; margin-top: 3%; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/4-selected.svg")%>)"></div><span><liferay-ui:message key="Events" /></span>
	          </label><clay:icon symbol="check" />
	        </div>
	        <div class="col-4 s6 m3" id="category-div-5"><input id="test5" name="category" type="radio" value="5" /><label for="test5">
	            	<div class="image" style="border: 0px; background-repeat: no-repeat!important; background-position: center!important; height: 59px; background-size: 22%!important; margin-top: 3%; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/5-gray.svg")%>)"></div><span><liferay-ui:message key="Projects" /></span>
	          </label>
	        </div>
			<div class="col-4 s6 m3 displayNone" id="category-div-5-selected"><input id="test5" name="category" type="radio" value="5" /><label class="label-checked" for="test5">
	            	<div class="image selected-radio " style="border: 0px; background-repeat: no-repeat!important; background-position: center!important; height: 59px; background-size: 22%!important; margin-top: 3%; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() +
"/images/5-selected.svg")%>)"></div><span><liferay-ui:message key="Projects" /></span>
	          </label><clay:icon symbol="check" />
	        </div>
<!-- 	        <div class="col-3 s6 m3" id="category-div-6"><input id="test6" name="category" type="radio" value="6" /><label for="test6"> -->
<%-- 	            	<div class="image" style="border: 0px; background-repeat: no-repeat!important; background-position: center!important; height: 59px; background-size: 22%!important; margin-top: 3%; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() + --%>
<%-- "/images/6-gray.svg")%>)"></div><span><liferay-ui:message key="MyInterests" /></span> --%>
<!-- 	          </label> -->
<!-- 	        </div> -->
<!-- 			<div class="col-3 s6 m3 displayNone" id="category-div-6-selected"><input id="test6" name="category" type="radio" value="6" /><label class="label-checked" for="test6"> -->
<%-- 	            	<div class="image selected-radio " style="border: 0px; background-repeat: no-repeat!important; background-position: center!important; height: 59px; background-size: 22%!important; margin-top: 3%; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() + --%>
<%-- "/images/6-selected.svg")%>)"></div><span><liferay-ui:message key="MyInterests" /></span> --%>
<%-- 	          </label><clay:icon symbol="check" /> --%>
<!-- 	        </div> -->
<!-- 	        <div class="col-3 s6 m3" id="category-div-7"><input id="test7" name="category" type="radio" value="7" /><label for="test7"> -->
<%-- 	            	<div class="image" style="border: 0px; background-repeat: no-repeat!important; background-position: center!important; height: 59px; background-size: 22%!important; margin-top: 3%; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() + --%>
<%-- "/images/7-gray.svg")%>"></div><span><liferay-ui:message key="Volounteering" /></span> --%>
<!-- 	          </label> -->
<!-- 	        </div> -->
<!-- 			<div class="col-3 s6 m3 displayNone" id="category-div-7-selected"><input id="test7" name="category" type="radio" value="7" /><label class="label-checked" for="test7"> -->
<%-- 	            	<div class="image selected-radio " style="border: 0px; background-repeat: no-repeat!important; background-position: center!important; height: 59px; background-size: 22%!important; margin-top: 3%; background: url(<%=renderResponse.encodeURL(renderRequest.getContextPath() + --%>
<%-- "/images/7-selected.svg")%>"></div><span><liferay-ui:message key="Volounteering" /></span> --%>
<%-- 	          </label><clay:icon symbol="check" /> --%>
<!-- 	        </div> -->
			</div>
			<div class="row">
				<div class="col-12">
					<label for="Tag"><liferay-ui:message key="Tag" /></label>
				</div>
				<div class="col-12 <%=langId%>">
					<input type="text" required maxlength="70" name="Tag" id="Tag" placeholder="<liferay-ui:message key="Tag" />">
				</div>
			</div>
			<div class="row">
				<div class="col-2">
					<label for="pic">Picture</label>
				</div>
				<!-- <div class="col-8">
					<input type="file" name="pic" id="pic" accept="image/*"
						onchange="addPicture()">
					<div id="uploadJourneyPic"></div>
				</div> -->
			</div>
			<div style="display:none" class="pirvacy-title-div <%=langId%>"><label><span class="pirvacy-title"><liferay-ui:message key="privacy" /></span></label></div>
			<div class="row privacy-column <%=langId%>" style="display:none">
				<div class="radio radio-1">	
				  <label class="container"><span class="privacy-check <%=langId%>"><clay:icon symbol="check" /></span><input type="radio" name="privacy" value="1" checked><liferay-ui:message key="public" /></label>
				</div>
				<div class="radio">
				  <label class="container"><span class="privacy-check <%=langId%>"><clay:icon symbol="check" /></span><input type="radio" name="privacy" value="2"><liferay-ui:message key="private" /></label>
				</div>
			</div>
			<!-- Allow form submission with keyboard without duplicating the dialog button -->
			<input type="submit" tabindex="-1"
				style="position: absolute; top: -1000px">
		</fieldset>
	</form>
</div>
<div id="participant-section">
<div id="intro-title" class="container">
            <h1 class="pb-1"><liferay-ui:message key='MyJourney' /></h1>
    </div>
</div>

<div id="main-container" class="container">
	<div class="text-center col-md-12" direction="ltr">
		<h1 id="timeline" class="<%=langId%>">
			 <a href="javascript:openDialog()"><img class="img-responsive img-plus" src="<%=imageUrl%>"></img></a><liferay-ui:message key="journeys" />
		</h1>
	</div>
	<ul class="timeline" id="timelineUl">

	</ul>
	<div class="row div-green-dot"><span class=""></span></div>
</div>

</div>

<%-- <div class="table-responsive">
  <table class="table table-striped">
    <thead>
      <tr>
        <th>#</th>
        <th><liferay-ui:message key="serviceName" /></th>
		<th><liferay-ui:message key="serviceAvailability" /></th>
		<th><liferay-ui:message key="serviceAccuracy" /></th>
      </tr>
    </thead>
    <tbody>
		<c:forEach items="${journies}" var="survey">
	      <tr>
	        <th scope="row">${survey.Title}</th>
	        <td>${survey.getShortDescription()}</td>
			<td>${survey.Date}</td>
	      </tr>
		</c:forEach>
    </tbody>
  </table> --%>

<script>
function EnglishToArabicNumerals(numberString) {
	 var arabicNumers= ['<liferay-ui:message key="arabicNumers0"/>',
		 '<liferay-ui:message key="arabicNumers1"/>',
		 '<liferay-ui:message key="arabicNumers2"/>',
		 '<liferay-ui:message key="arabicNumers3"/>',
		 '<liferay-ui:message key="arabicNumers4"/>',
		 '<liferay-ui:message key="arabicNumers5"/>',
		 '<liferay-ui:message key="arabicNumers6"/>',
		 '<liferay-ui:message key="arabicNumers7"/>',
		 '<liferay-ui:message key="arabicNumers8"/>',
		 '<liferay-ui:message key="arabicNumers9"/>'];
	 return numberString.replace(/[0-9]/g, function(w){
	  return arabicNumers[+w];
	 });
	}
function refreshCategory () {
	$('.stock-images [type="radio"] + label div.image:not(.selected-radio)').closest('.col-4.s6.m3').removeClass('displayNone');
	$('.stock-images [type="radio"] + label div.image.selected-radio').closest('.col-4.s6.m3').addClass('displayNone');
}
var text_max = 300;
$('#count_message').html('0 / ' + text_max);
$('#Description').keyup(function() {
  var text_length = $('#Description').val().length;
  var text_remaining = text_length + '/' + text_max;
  
  $('#count_message').html(text_remaining);
});
	var dialog;
	var form;
	var journeys = [];

	var categoryValues = [];
	categoryValues.push('Employment');
	categoryValues.push('Education');
	categoryValues.push('Training');
	categoryValues.push('Community');
	categoryValues.push('Events');
	categoryValues.push('Projects');
	categoryValues.push('My Interests');
	categoryValues.push('Volunteering');
	$(document).ready(function() {
		$('.stock-images [type="radio"] + label').click(function (){
			$('.stock-images [type="radio"] + label div.image:not(.selected-radio)').closest('.col-4.s6.m3').removeClass('displayNone');
			$('.stock-images [type="radio"] + label div.image.selected-radio').closest('.col-4.s6.m3').addClass('displayNone');
			console.log($(this).find('div.image:not(.selcted-radio)'));
			$(this).find('div.image:not(.selected-radio)').closest('.col-4.s6.m3').addClass('displayNone');
			console.log($(this).find('div.image:not(.selcted-radio)').closest('.col-4.s6.m3').find(' + div'));
			$(this).find('div.image:not(.selected-radio)').closest('.col-4.s6.m3').find(' + div').removeClass('displayNone');
		});
		if (themeDisplay.getLanguageId() == 'ar_SA')
		{
			langVar = 'ar'; 
		}
		else
		{
			langVar = 'en'; 
		}
		console.log('langVar : ' + langVar);
		$('.col-4.s6.m3').addClass(langVar);
		$('.privacy-column .radio').click(function (){
			$('input[name=privacy]:checked').closest('div.privacy-column').find('svg').css('background','white');
			$('input[name=privacy]:checked').closest('div.privacy-column').find('span').css('background','white');
			$('input[name=privacy]:checked').closest('div.privacy-column').find('span').css('border', '1px solid gray');
			//console.log('ll : ' + $('input[name=privacy]:checked').closest('span.privacy-check').find('svg').length);
			$('input[name=privacy]:checked').parent().find('svg').css('background','rgb(5,170,255)');
			$('input[name=privacy]:checked').parent().find('span').css('background','rgb(5,170,255)');
			$('input[name=privacy]:checked').parent().find('span').css('border','0px');
		});
		$('.my-dialog .ui-dialog').css('padding-top','5%');
		//$('#main-container').css('padding-top',$('.navigation.start-header.start-style').outerHeight());
		if (themeDisplay.getLanguageId() == 'ar_SA')
			{
				$('#Description').addClass('ar');
				//langClass = 'ar';
			}
			else
			{
				$('#Description').addClass('en');
				//langClass = 'en';
			}
		var journeySearch = {
				op : "search",
				userId: themeDisplay.getUserId(),
		}
		loadData(journeySearch);
			//console.log("document ready :: " + journeys.length);
		var my_posts = $("[rel=tooltip]");

		var size = $(window).width();
		for (i = 0; i < my_posts.length; i++) {
			the_post = $(my_posts[i]);

			if (the_post.hasClass('invert') && size >= 767) {
				the_post.tooltip({
					placement : 'left'
				});
				the_post.css("cursor", "pointer");
			} else {
				the_post.tooltip({
					placement : 'rigth'
				});
				the_post.css("cursor", "pointer");
			}
		}
		//console.log('journeyId : ' + $('#journeyId').val());
		dialog = $("#dialog-form").dialog({
			autoOpen : false,
			height : 1100,
			width : 650,
			modal : true,
			buttons : {
				submit : function() {
					if ((document.getElementById('journeyId').value) ==0) {
						addJourney();
					} else {
						updateJourney();
					}
				},
				"<liferay-ui:message key='cancel'/>" : function() {
					dialog.dialog("close");
				}
			},
			close : function() {
				form[0].reset();
				//document.getElementById('uploadJourneyPic').innerHTML = "";
			}
			, dialogClass: 'my-dialog'
		});
		$('.my-dialog .ui-dialog-titlebar-close.ui-corner-all').addClass('displayNone');
		//$('.my-dialog .ui-dialog-titlebar').append('<clay:icon symbol="times" />');
		/* $('.my-dialog .ui-icon.ui-icon-closethick').parent().click(function () {
			console.log("dialog close");
			dialog.dialog("close");
		}); */
		$('#dialog-form').css('display','none');

		form = dialog.find("form").on("submit", function(event) {
			event.preventDefault();
			if ((document.getElementById('journeyId').value) == 0) {
				addJourney();
			} else {
				updateJourney();
			}

		});

		$("#create-journey").button().on("click", function() {
			//$('.stock-images div.image').removeAttr('style');
			//$('.stock-images div.image').addClass('custom-design');
			refreshCategory();
			dialog.dialog("open");
		});
	});

	function openDialog() {
		$('.privacy-column div.radio-1 svg').css('background','rgb(5,170,255)');
		$('.privacy-column div.radio-1 span').css('background','rgb(5,170,255)');
		//$('.privacy-column div:nth-child(2) svg').css('background','white');
		$('.privacy-column div:nth-child(2) span').css('background','white');
		$('.privacy-column div:nth-child(2) span').css('border', '1px solid gray');
		$('#Description').val('');
		$('.my-dialog .ui-dialog-titlebar').addClass('dialog-custom-class');
		$('.my-dialog .ui-dialog-titlebar').addClass('<%=langId%>');
		$('.my-dialog .ui-dialog-title').html("<liferay-ui:message key='CreateJourney'/>");
		$('.my-dialog .ui-dialog-buttonpane').addClass('button-div-css');
		$('.my-dialog .ui-dialog-buttonpane div button:nth-child(1)').addClass('dialog-button-custom-css');
		$('.my-dialog .ui-dialog-buttonpane div button:nth-child(1) span').html("<liferay-ui:message key='CreateJourney'/>");
		//$('.stock-images div.image').removeAttr('style');
		//$('.stock-images div.image').addClass('custom-design');
		/* $('.stock-images [type="radio"] + label').click(function (){
			$('.stock-images [type="radio"]:checked + label div.image').removeClass('custom-design')
			console.log('aaaaaaaaaa');
			$('.stock-images [type="radio"]:checked + label div.image').css('background-image','url(/o/journey/images/0-selected.svg);');
			$('.stock-images [type="radio"]:checked + label div.image').css('background-repeat','no-repeat!important;');
			$('.stock-images [type="radio"]:checked + label div.image').css('background-position','center!important;');
			$('.stock-images [type="radio"]:checked + label div.image').css('height','59px;');
			$('.stock-images [type="radio"]:checked + label div.image').css('background-size','30%!important');
			
			$('.stock-images [type="radio"]:checked + label div.image').css('margin-top','3%!important;');
		}); */
		refreshCategory();
		dialog.dialog("open");
	}
	
	function checkFields() {
		var requiredFieldsMessage = "";
		$('#dialog-form input[required]:not(#journeyId),#dialog-form textarea[required]').each(function(){
			if ($(this).val() == '')
				{
					if (requiredFieldsMessage.length == 0)
						requiredFieldsMessage += "<liferay-ui:message key='requiredFieldsMessage'/>";
					requiredFieldsMessage += '\n' + $(this).attr('placeholder');
				}
			});
		if ($('.col-3.s6.m3:not([id*=-selected]):not(.displayNone)').length == 8)
			{
				if (requiredFieldsMessage.length == 0)
					requiredFieldsMessage += "<liferay-ui:message key='requiredFieldsMessage'/>";
				requiredFieldsMessage +='\n<liferay-ui:message key="Category" />';
			}
		return requiredFieldsMessage;
	}

	function addJourney() {
		//var pic = document.getElementById('uploadJourneyPic').innerHTML;
		var Title = document.getElementById('Title').value;
		var Description = document.getElementById('Description').value;
		var ShortDescription = document.getElementById('ShortDescription').value;
		var Date = document.getElementById('Date').value;
		var category = $('.stock-images [type="radio"]:checked').closest('.col-4.s6.m3').find('input[type=radio]').val();
		var Pirvacy = $('input[name=privacy]:checked').val();
		var tag = document.getElementById('Tag').value;
		var journey = {
			journeyId : (journeys.length) + 1,
			Title : Title.replace("'","''"),
			Description : Description.replace("'","''"),
			//picture : document.getElementById('pic1').src,
			ShortDescription : ShortDescription.replace("'","''"),
			Date : Date,
			category : category,
			Pirvacy : Pirvacy,
			tag : tag,
			userId: themeDisplay.getUserId(),
			op : "add"
		};
		//journeys.push(journey);
				
		if (checkFields().length == 0)
			{
				callServeResource('add', journey);
				dialog.dialog("close");
			}
		else
		swal(checkFields());

	}

	function refreshTimeline() {
		var langClass = "";
		////console.log('refreshTimeline');
		if (themeDisplay.getLanguageId() == 'ar_SA')
			{ 
				langClass = 'ar';
			}
			else
			{
				langClass = 'en';
			}
		var cls = '';
		$("#timelineUl").empty();
		//console.log("refreshTimeline : " + journeys.length);
		var arabicMonth = new Object();
			arabicMonth.January='<liferay-ui:message key="January"/>';
			arabicMonth.February='<liferay-ui:message key="February"/>';
			arabicMonth.March='<liferay-ui:message key="March"/>';
			arabicMonth.April='<liferay-ui:message key="April"/>';
			arabicMonth.May='<liferay-ui:message key="May"/>';
			arabicMonth.June='<liferay-ui:message key="June"/>';
			arabicMonth.July='<liferay-ui:message key="July"/>';
			arabicMonth.August='<liferay-ui:message key="August"/>';
			arabicMonth.September='<liferay-ui:message key="September"/>';
			arabicMonth.October='<liferay-ui:message key="October"/>';
			arabicMonth.November='<liferay-ui:message key="November"/>';
			arabicMonth.December='<liferay-ui:message key="December"/>';
		for (var i = 0; i < journeys.length; i++) {
			var obj = journeys[i];
			var privacyCssBackground = ((obj.Pirvacy == '1')?'bg-green':'bg-transparent');
			var topHTML = '<div class="col-md-12 top-header-journey">'
				+ '<span class="category-span">'
				+ categoryValues[obj.Category]
				+ '</span>'
				+ '<div class="privacy-edit col-md-6 col-xs-6">'
				+'<div class="editing-buttons">';
			if(obj.editable == 'true')	
			topHTML+='<a class="pull-right" href="javascript:deleteJourney('+ obj.JourneyId + ')"><clay:icon symbol="times" /></a>'
			        +'<a class="pull-right" href="javascript:editRow('+ obj.JourneyId + ')"><clay:icon symbol="pencil" /></a>';
				/* + '<a class="pull-right" href="javascript:deleteJourney('
				+ obj.JourneyId
				+ ')"><clay:icon symbol="times" /></a>' */
		    topHTML+='</div>'
				+ '<div class="privacy-div"><div class="privacy-span rounded border border-secondary ' +privacyCssBackground + '">'
				+ ((obj.Pirvacy == '1')?'<div class="privacy-icon-div ' + langClass + '">' + '<clay:icon symbol="view" />' + '</div>':'')
				+ '<div class="privacy-vaule-div">' + ((obj.Pirvacy == '1')?'<liferay-ui:message key="Public"/>':'<liferay-ui:message key="Private"/>') + '</div>'
				+ '</span></div>'
				+ '</div>'
				+ '</div>';
			if (langClass == 'ar')
			{
				cls = '<li>';
			}
			else
			{
				cls = '<li  class="timeline-inverted">';
			}
			$("#timelineUl")
					.append(
							cls
									+ '<div class="date-div ' + langClass + '"><span class="">'+eval('arabicMonth.'+obj.DateFormatted.split(' ')[1]) + '<br>' + EnglishToArabicNumerals(obj.DateFormatted.split(' ')[0]) + ', ' + EnglishToArabicNumerals(obj.DateFormatted.split(' ')[2]) + '</span></div><div class="timeline-badge primary"><div class="icon-img-center">'
									+'<img src = "' + $('#baseUrl').val() + '/images/' + obj.Category + '.svg"></img></div></div>'//<i class="glyphicon glyphicon-record" rel="tooltip" Title="'+obj.Title+'" id="'+obj.JourneyId+'"></i>
									+ '<div class="timeline-panel">'
									+ '<div class="timeline-heading">'
									+ topHTML
									+ '</div>'
									+ '<div class="timeline-footer">'
									/*+ '<a class="pull-right" href="javascript:deleteJourney('
									+ obj.JourneyId
									+ ')"><clay:icon symbol="times" /></a>'*/
									+ '<span class="title-span">' + obj.Title + '</span>'
									+ '<br><span class="short-desription">' + obj.ShortDescription + '</span>' +'</div>'
									+ '<div class="timeline-body">' + '<p class="description-p">'
									+ obj.Description + '</p> ' + '</div>'
									+ '</div>' + '</li>');
			if (themeDisplay.getLanguageId() == 'ar_SA')
			{
				$('li.timeline-inverted .timeline-badge.primary').addClass('badge-ar');
				
			}
			else
			{
				$('li.timeline-inverted .timeline-badge.primary').addClass('badge-en');
			}
		}
		$("#timelineUl").append(
				'<li class="clearfix" style="float: none;"></li>');
	}

	function addPicture() {
		var fieldName = 'pic';
		var tergetName = 'uploadJourneyPic';
		var filesSelected = document.getElementById(fieldName).files;
		if (filesSelected.length > 0) {
			var fileToLoad = filesSelected[0];
			var fileReader = new FileReader();
			fileReader.onload = function(fileLoadedEvent) {
				var srcData = fileLoadedEvent.target.result; // <--- data: base64
				var newImage = document.createElement('img');
				newImage.style.cssText = 'width:75px;height:75px;';
				newImage.setAttribute("id", "pic1");
				newImage.src = srcData;
				document.getElementById(tergetName).innerHTML = newImage.outerHTML;
			}
			fileReader.readAsDataURL(fileToLoad);
		}
	}

	function deleteRow() {
		try {
			var table = document.getElementById('journeys');
			var rowCount = table.rows.length;
			for (var i = 0; i < rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if (null != chkbox && true == chkbox.checked) {
					table.deleteRow(i);
					rowCount--;
					i--;
				}
			}
		} catch (e) {
			alert(e);
		}
	}

	function deleteJourney(journeyId) {
		swal({
					title: "<liferay-ui:message key='Areyousure'/>",
					text:  "<liferay-ui:message key='deleteConfirm'/>",
					type:  "warning",
					showCancelButton: true,
					cancelButtonText: "<liferay-ui:message key='cancel'/>",
					confirmButtonColor: '#DD6B55',
					confirmButtonText: "<liferay-ui:message key='Yesdeleteit'/>",
					closeOnConfirm: true,
				},
				function(){
		for (var i = 0; i < journeys.length; i++) {
			var journey = journeys[i];
			if (journey.JourneyId == journeyId) {
				var journey = {
						journeyId : journeyId,
						op : "delete",
						userId: themeDisplay.getUserId()
					};
				callServeResource('delete', journey);
				swal({title: "<liferay-ui:message key='Yourrecordhasbeendeleted'/>", text: "", type: "success"},
 		                        		   function(){
				journeys.splice(i, 1);
			});
				break;
			}
		}
		refreshTimeline();
				});
	}

	function updateJourney() {
		var journeyId = document.getElementById('journeyId').value;
		for (var i = 0; i < journeys.length; i++) {
			var obj = journeys[i];
			////console.log("obj.journeyId : " + obj.JourneyId);
			////console.log("journeyId : " + journeyId);
			if (obj.JourneyId == journeyId) {
				var picName='timeLinePicture'+obj.journeyId;				
				var journey = {
						journeyId : journeyId,
						Title : $('#Title').val().replace("'","''"),
						Description : $('#Description').val().replace("'","''"),
						//picture : document.getElementById('pic1').src,
						ShortDescription : $('#ShortDescription').val().replace("'","''"),
						Date : $('#Date').val(),
						category : $('.stock-images [type="radio"]:checked').val(),
						Pirvacy : $('input[name=privacy]:checked').val(),
						tag : obj.tag.replace("'","''"),
						userId: themeDisplay.getUserId(),
						op : "update"
					};
				//console.log('aaa : ' + $('input[name=privacy]:checked').val());
				if (checkFields().length == 0)
				{
					callServeResource('update', journey);
					dialog.dialog("close");
				}
				else
					swal(checkFields());
				//callServeResource('update', journey);
				//journeys[i] = journey;				
				break;
			}
		}
		//dialog.dialog("close");
	}

	function editRow(journeyId) {
		try {
			for (var i = 0; i < journeys.length; i++) {
				var obj = journeys[i];
				if (obj.JourneyId == journeyId) {
					$('input[id=journeyId]').val(obj.JourneyId);
					$('input[id=Title]').val(obj.Title);
					$('textarea[id=Description]').val(obj.Description);
					$('input[id=ShortDescription]').val(obj.ShortDescription);
					$('input[id=Date]').val(obj.Date);
					$('input[id=Tag]').val(obj.tag);
					console.log("obj.JourneyId : " + obj.JourneyId);
					$('#test'+obj.Category).prop("checked", true);
					if (obj.Pirvacy == '1')
						{
						$('.privacy-column div.radio-1 svg').css('background','rgb(5,170,255)');
						$('.privacy-column div.radio-1 span').css('background','rgb(5,170,255)');
						$('.privacy-column div:nth-child(2) svg').css('background','white');
						$('.privacy-column div:nth-child(2) span').css('background','white');
						$('.privacy-column div:nth-child(2) span').css('border', '1px solid gray');
						}
					else
						{
						$('.privacy-column div:nth-child(2) svg').css('background','rgb(5,170,255)');
						$('.privacy-column div:nth-child(2) span').css('background','rgb(5,170,255)');
						$('.privacy-column div:nth-child(1) svg').css('background','white');
						$('.privacy-column div:nth-child(1) span').css('background','white');
						$('.privacy-column div:nth-child(1) span').css('border', '1px solid gray');
						}
					var newImage = document.createElement('img');
					newImage.style.cssText = 'width:75px;height:75px;';
					newImage.setAttribute("id", "pic1");
					newImage.src = obj.picture;
					//document.getElementById("uploadJourneyPic").innerHTML = newImage.outerHTML;
					//console.log($(dialog));
					$('.my-dialog .ui-dialog-title').html("<liferay-ui:message key='updateJourney'/>");
					$('.my-dialog .ui-button-text').first().html("<liferay-ui:message key='updateJourney'/>");
					$('.my-dialog .ui-dialog-title').html("<liferay-ui:message key='updateJourney'/>");
					$('.my-dialog .ui-dialog-titlebar').addClass('dialog-custom-class');
					$('.my-dialog .ui-dialog-titlebar').addClass('<%=langId%>');
					/* $('.stock-images div.image').removeAttr('style');
					$('.stock-images div.image').addClass('custom-design'); */
					refreshCategory();
					console.log("test test");
					console.log($('input[id=test'+obj.Category+']').closest('.col-3.s6.m3'));
					$('input[id=test'+obj.Category+']').closest('.col-3.s6.m3').addClass('displayNone');
					console.log($('input[id=test'+obj.Category+']').closest('.col-3.s6.m3').find(' + div'));
					$('input[id=test'+obj.Category+']').closest('.col-3.s6.m3').find(' + div').removeClass('displayNone');
					/* $('#dialog-form').css('display','block');
					$('.my-dialog').css('display','block'); */
					$('.my-dialog .ui-dialog-buttonpane').addClass('button-div-css');
					$('.my-dialog .ui-dialog-buttonpane div button:nth-child(1)').addClass('dialog-button-custom-css');
					$('.my-dialog .ui-dialog-buttonpane div button:nth-child(1) span').html("<liferay-ui:message key='updateJourney'/>");
					dialog.dialog("open");
				}
			}
		} catch (e) {
			alert(e);
		}
	}
	
	function logObj (p){//console.log("p == " + p);
	for (var key in p) {
		  if (p.hasOwnProperty(key)) {
		    //console.log(key + " -> " + p[key]);
		  }
		}
	}

	function callServeResource(op, obj) {
		////console.log("title : " + obj["ShortDescription"]);
		var Title = obj["Title"];
		var Description = obj["Description"];
		var picture = obj["picture"];
		var journeyId = obj["journeyId"];
		var Date = obj["Date"];
		var ShortDescription = obj["ShortDescription"];
		var Category = obj["Category"];
		var Pirvacy = obj["Pirvacy"];
		var picture = obj["pictureBlob"];

		AUI().use('aui-io-request', function(A) {
			A.io.request('${resourceUrl1}', {
				method : 'post',
				data : {
					op : op,
					<portlet:namespace />Title : Title,
					<portlet:namespace />ShortDescription : ShortDescription,
					<portlet:namespace />Date : Date,
					<portlet:namespace />Description : Description,
					<portlet:namespace />Category : Category,
					<portlet:namespace />Pirvacy : Pirvacy,
					<portlet:namespace />pictureBlob : picture,
					<portlet:namespace />obj : JSON.stringify(obj),
				},
				on : {
					success : function() {
						var jsonObj = $.parseJSON(this.get('responseData'));
						//console.log(jsonObj);
						journeys= [];
						for (var i=0; i < jsonObj.length; i++)
						{
							var journey1 = new Object();
							////console.log(${journies}[i].JourneyId);
							journey1.JourneyId = jsonObj[i].JourneyId;
							journey1.Title = jsonObj[i].Title;
							journey1.ShortDescription = jsonObj[i].ShortDescription;
							journey1.Date = jsonObj[i].Date;
							journey1.Description = jsonObj[i].Description;
							journey1.Category = jsonObj[i].Category;
							journey1.Pirvacy = jsonObj[i].Pirvacy;
							journey1.tag = jsonObj[i].tag;
							journey1.editable = jsonObj[i].editable;
							//////console.log('journey : ' + ${journies}[i].JourneyId);
							journey1.DateFormatted = jsonObj[i].DateFormatted;
							journeys.push(journey1);
						}
						refreshTimeline();
					}
				}
			});

		});
	}
	
	function loadData(obj) {

		AUI().use('aui-io-request', function(A) {
			A.io.request('${resourceUrl1}', {
				method : 'post',
				async: false,
				data : {
					<portlet:namespace />obj : JSON.stringify(obj),
				},
				on : {
					success : function(data) {
						var jsonObj = $.parseJSON(this.get('responseData'));
						journeys=[];
						//console.log("jsonObj.length ::: " + jsonObj.length);
						for (var i=0; i < jsonObj.length; i++)
							{
							////console.log("l : " + ${journies.length()});
							var journey1 = new Object();
								journey1.JourneyId = jsonObj[i].JourneyId;
								journey1.Title = jsonObj[i].Title;
								journey1.ShortDescription = jsonObj[i].ShortDescription;
								journey1.Date = jsonObj[i].Date;
								journey1.Description = jsonObj[i].Description;
								journey1.Category = jsonObj[i].Category;
								journey1.Pirvacy = jsonObj[i].Pirvacy;
								journey1.tag = jsonObj[i].tag;
								journey1.editable = jsonObj[i].editable;
								journey1.DateFormatted = jsonObj[i].DateFormatted;
								//////console.log('journey : ' + jsonObj[i].JourneyId);
								journeys.push(journey1);
							}
						refreshTimeline();
					}
				}
			});

		});
	}
</script>