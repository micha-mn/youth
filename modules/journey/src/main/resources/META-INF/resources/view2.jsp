<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="java.util.Enumeration"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>

<script src="https://code.jquery.com/jquery-1.9.1.js"></script>
<script src="https://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style>

.stock-images .image {
  opacity: 0.2;
  width: 100%;
  height: 160px;
  background-position: center center;
  background-color: gray;
}
.stock-images .image:hover {
  opacity: 1;
}
.stock-images [type="radio"] {
  display: none;
}
.stock-images [type="radio"] + label {
  width: 100%;
  height: 160px;
  padding: 0;
}
.stock-images [type="radio"]:not(:checked) + label .image {
  border: 5px solid white;
}
.stock-images [type="radio"]:checked + label .image {
  border: 5px solid aqua;
  opacity: 1;
}


.timeline {
	list-style: none;
	padding: 20px 0 20px;
	position: relative;
}

.timeline:before {
	top: 0;
	bottom: 0;
	position: absolute;
	content: " ";
	width: 3px;
	background-color: #eeeeee;
	left: 50%;
	margin-left: -1.5px;
}

.timeline>li {
	margin-bottom: 20px;
	position: relative;
	width: 50%;
	float: left;
	clear: left;
}

.timeline>li:before, .timeline>li:after {
	content: " ";
	display: table;
}

.timeline>li:after {
	clear: both;
}

.timeline>li:before, .timeline>li:after {
	content: " ";
	display: table;
}

.timeline>li:after {
	clear: both;
}

.timeline>li>.timeline-panel {
	width: 95%;
	float: left;
	border: 1px solid #d4d4d4;
	/*border-radius: 2px;*/
	/*padding: 20px;*/
	position: relative;
	-webkit-box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);
	box-shadow: 0 1px 6px rgba(0, 0, 0, 0.175);
}

.timeline>li>.timeline-panel:before {
	position: absolute;
	top: 26px;
	right: -15px;
	display: inline-block;
	border-top: 15px solid transparent;
	border-left: 15px solid #ccc;
	border-right: 0 solid #ccc;
	border-bottom: 15px solid transparent;
	content: " ";
}

.timeline>li>.timeline-panel:after {
	position: absolute;
	top: 27px;
	right: -14px;
	display: inline-block;
	border-top: 14px solid transparent;
	border-left: 14px solid #fff;
	border-right: 0 solid #fff;
	border-bottom: 14px solid transparent;
	content: " ";
}

.timeline>li>.timeline-badge {
	color: #fff;
	width: 24px;
	height: 24px;
	line-height: 50px;
	font-size: 1.4em;
	text-align: center;
	position: absolute;
	top: 16px;
	right: -12px;
	/*background-color: #999999;*/
	z-index: 100;
	/*
  border-top-right-radius: 50%;
  border-top-left-radius: 50%;
  border-bottom-right-radius: 50%;
  border-bottom-left-radius: 50%;
  */
}

.timeline>li.timeline-inverted>.timeline-panel {
	float: right;
}

.timeline>li.timeline-inverted>.timeline-panel:before {
	border-left-width: 0;
	border-right-width: 15px;
	left: -15px;
	right: auto;
}

.timeline>li.timeline-inverted>.timeline-panel:after {
	border-left-width: 0;
	border-right-width: 14px;
	left: -14px;
	right: auto;
}

.timeline-badge>a {
	color: #C5C7C5 !important;
}

.timeline-badge a:hover {
	color: #000 !important;
}

.timeline-title {
	margin-top: 0;
	color: inherit;
}

.timeline-body>p, .timeline-body>ul {
	padding: 20px;
	margin-bottom: 0;
}

.timeline-body>p+p {
	margin-top: 5px;
}

.timeline-footer {
	padding: 20px;
	background-color: #f4f4f4;
}

.timeline-footer>a {
	cursor: pointer;
	text-decoration: none;
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

.tooltip.in {
	/*opacity:0;
    filter:alpha(opacity=80);*/
	
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

.timeline>li.timeline-inverted {
	float: right;
	clear: right;
	margin-top: 30px;
	margin-bottom: 30px;
}

.timeline>li:nth-child(2) {
	margin-top: 60px;
}

.timeline>li.timeline-inverted>.timeline-badge {
	left: -12px;
}

@media ( max-width : 767px) {
	ul.timeline:before {
		left: 40px;
	}
	ul.timeline>li {
		margin-bottom: 20px;
		position: relative;
		width: 100%;
		float: left;
		clear: left;
	}
	ul.timeline>li>.timeline-panel {
		width: calc(100% - 90px);
		width: -moz-calc(100% - 90px);
		width: -webkit-calc(100% - 90px);
	}
	ul.timeline>li>.timeline-badge {
		left: 28px;
		margin-left: 0;
		top: 16px;
	}
	ul.timeline>li>.timeline-panel {
		float: right;
	}
	ul.timeline>li>.timeline-panel:before {
		border-left-width: 0;
		border-right-width: 15px;
		left: -15px;
		right: auto;
	}
	ul.timeline>li>.timeline-panel:after {
		border-left-width: 0;
		border-right-width: 14px;
		left: -14px;
		right: auto;
	}
	.timeline>li.timeline-inverted {
		float: left;
		clear: left;
		margin-top: 30px;
		margin-bottom: 30px;
	}
	.timeline>li.timeline-inverted>.timeline-badge {
		left: 28px;
	}
}
</style>
<liferay-portlet:resourceURL var="resourceUrl1">
	<liferay-portlet:param name="param1" value="Value1" />
</liferay-portlet:resourceURL>

<div id="dialog-form" title="<liferay-ui:message key='CreateJourney' />">
	<p class="validateTips">All form fields are required.</p>

	<form>
		<fieldset>
		<div class="row" style="display:none;">
					<div class="col-2">
						<label for="journeyId">ID</label>
					</div>
					<div class="col-8">
						<input type="text" name="journeyId" id="journeyId" value="0" readonly>
					</div>
				</div>
		
			<div class="row">
				<div class="col-2">
					<label for="Title"><liferay-ui:message key="Title" /></label>
				</div>
				<div class="col-8">
					<input type="text" name="Title" id="Title" value="0" readonly>
				</div>
			</div>
			<div class="row">
				<div class="col-2">
					<label for="ShortDescription"><liferay-ui:message key="ShortDescription" /></label>
				</div>
				<div class="col-8">
					<input type="text" name="ShortDescription" id="ShortDescription" value="0" readonly>
				</div>
			</div>
			<div class="row">
				<div class="col-2">
					<label for="Description"><liferay-ui:message key="Description" /></label>
				</div>
				<div class="col-8">
					<input type="text" name="Description" id="Description" value="0" readonly>
				</div>
			</div>
			<div class="row">
				<div class="col-2">
					<label for="Tag"><liferay-ui:message key="Tag" /></label>
				</div>
				<div class="col-8">
					<input type="text" name="Tag" id="Tag" value="0" readonly>
				</div>
			</div>
			<div class="row stock-images">
				<div class="col s6 m3"><input id="test0" name="category" type="radio" /><label for="test0">
	            	<div class="image" style="background-image: url(../images/1.svg)"></div>
	          </label>
	        </div>
	        <div class="col s6 m3"><input id="test1" name="category" type="radio" /><label for="test1">
	            	<div class="image" style="background-image: url(../images/2.svg)"></div>
	          </label>
	        </div>
	        <div class="col s6 m3"><input id="test2" name="category" type="radio" /><label for="test2">
	            	<div class="image" style="background-image: url(../images/3.png)"></div>
	          </label>
	        </div>
	        <div class="col s6 m3"><input id="test3" name="category" type="radio" /><label for="test3">
	            	<div class="image" style="background-image: url(../images/1.svg)"></div>
	          </label>
	        </div>
	        </div>
	        <div class="row stock-images">
	        <div class="col s6 m3"><input id="test4" name="category" type="radio" /><label for="test4">
	            	<div class="image" style="background-image: url(../images/2.svg)"></div>
	          </label>
	        </div>
	        <div class="col s6 m3"><input id="test5" name="category" type="radio" /><label for="test5">
	            	<div class="image" style="background-image: url(../images/3.png)"></div>
	          </label>
	        </div>
	        <div class="col s6 m3"><input id="test6" name="category" type="radio" /><label for="test6">
	            	<div class="image" style="background-image: url(../images/1.svg)"></div>
	          </label>
	        </div>
	        <div class="col s6 m3"><input id="test7" name="category" type="radio" /><label for="test7">
	            	<div class="image" style="background-image: url(../images/2.svg)"></div>
	          </label>
	        </div>
			</div>
			<div class="row">
				<div class="col-2">
					<label for="pic">Picture</label>
				</div>
				<div class="col-8">
					<input type="file" name="pic" id="pic" accept="image/*"
						onchange="addPicture()">
					<div id="uploadJourneyPic"></div>
				</div>
			</div>
			<div class="row">
				<div class="radio">
				  <label><input type="radio" name="privacy" value="0" checked><liferay-ui:message key="public" /></label>
				</div>
				<div class="radio">
				  <label><input type="radio" name="privacy" value="1"><liferay-ui:message key="private" /></label>
				</div>
			</div>
			<!-- Allow form submission with keyboard without duplicating the dialog button -->
			<input type="submit" tabindex="-1"
				style="position: absolute; top: -1000px">
		</fieldset>
	</form>
</div>


<div class="container">
	<div class="page-header text-center">
		<h1 id="timeline">
			Journeys <a href="javascript:openDialog()"><span
				class="glyphicon glyphicon-plus-sign"></span></a>
		</h1>
	</div>
	<ul class="timeline" id="timelineUl">

	</ul>
</div>





<script>
	var dialog;
	var form;
	var journeys = [];
	$(document).ready(function() {
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

		dialog = $("#dialog-form").dialog({
			autoOpen : false,
			height : 400,
			width : 650,
			modal : true,
			buttons : {
				"Create New Journey" : function() {
					if ((document.getElementById('journeyId').value) ==0) {
						addJourney();
					} else {
						updateJourney();
					}
				},
				Cancel : function() {
					dialog.dialog("close");
				}
			},
			close : function() {
				form[0].reset();
				document.getElementById('uploadJourneyPic').innerHTML = "";
			}
		});

		form = dialog.find("form").on("submit", function(event) {
			event.preventDefault();
			if ((document.getElementById('journeyId').value) ==0) {
				addJourney();
			} else {
				updateJourney();
			}

		});

		$("#create-journey").button().on("click", function() {
			dialog.dialog("open");
		});
	});

	function openDialog() {
		dialog.dialog("open");
	}

	function addJourney() {
		console.log("addJourney");
		var pic = document.getElementById('uploadJourneyPic').innerHTML;
		var Title = document.getElementById('Title').value;
		var Description = document.getElementById('Description').value;
		var ShortDescription = document.getElementById('ShortDescription');
		var Date = document.getElementById('Date');
		var category = document.getElementById('category');
		var Pirvacy = document.getElementById('Pirvacy');
		var journey = {
			journeyId : (journeys.length) + 1,
			Title : Title,
			Description : Description,
			picture : document.getElementById('pic1').src
			ShortDescription : ShortDescription,
			Date : Date,
			Category : category,
			ShortDescription : ShortDescription,
		};
		journeys.push(journey);
		refreshTimeline();
		callServeResource('add', journey);
		dialog.dialog("close");

	}

	function refreshTimeline() {
		var cls = '';
		$("#timelineUl").empty();
		for (var i = 0; i < journeys.length; i++) {
			var obj = journeys[i];
			if (i % 2 == 0) {
				cls = '<li>';
			} else {
				cls = '<li  class="timeline-inverted">';
			}
			$("#timelineUl")
					.append(
							cls
									+ '<div class="timeline-badge primary"><a><i class="glyphicon glyphicon-record" rel="tooltip" Title="'+obj["Title"]+'" id="'+obj["journeyId"]+'"></i></a></div>'
									+ '<div class="timeline-panel">'
									+ '<div class="timeline-heading">'
									+ '<img class="img-responsive" src="'+obj["picture"]+'" id="timeLinePicture'+obj["journeyId"]+'"/>'
									+ '</div>'
									+ '<div class="timeline-footer">'
									+ '<a class="pull-right" href="javascript:deleteJourney('
									+ obj["journeyId"]
									+ ')"><span class="glyphicon glyphicon-remove"></span></a>'
									+ '<a class="pull-right" href="javascript:editRow('
									+ obj["journeyId"]
									+ ')"><span class="glyphicon glyphicon-pencil"></span></a>'
									+ '<a>' + obj["Title"] + '</a>' + '</div>'
									+ '<div class="timeline-body">' + '<p>'
									+ obj["Description"] + '</p> ' + '</div>'
									+ '</div>' + '</li>');
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
		for (var i = 0; i < journeys.length; i++) {
			var journey = journeys[i];
			if (journey["journeyId"] == journeyId) {
				callServeResource('delete', journey);
				journeys.splice(i, 1);
				break;
			}
		}
		refreshTimeline();
	}

	function updateJourney() {
		var journeyId = document.getElementById('journeyId').value;
		for (var i = 0; i < journeys.length; i++) {
			var obj = journeys[i];
			if (obj["journeyId"] == journeyId) {
				var picName='timeLinePicture'+obj["journeyId"];				
				var journey = {
						journeyId : obj["journeyId"],
						Title : document.getElementById('Title').value,
						Description : document.getElementById('Description').value,
						picture : document.getElementById('pic1').src
					};
				callServeResource('update', journey);
				journeys[i] = journey;				
				break;
			}
		}
		refreshTimeline();
		dialog.dialog("close");
	}

	function editRow(journeyId) {
		try {
			for (var i = 0; i < journeys.length; i++) {
				var obj = journeys[i];
				if (obj["journeyId"] == journeyId) {
					document.getElementById('journeyId').value = obj["journeyId"];
					document.getElementById('Title').value = obj["Title"];
					document.getElementById('Description').value = obj["Description"];
					var newImage = document.createElement('img');
					newImage.style.cssText = 'width:75px;height:75px;';
					newImage.setAttribute("id", "pic1");
					newImage.src = obj["picture"];
					document.getElementById("uploadJourneyPic").innerHTML = newImage.outerHTML;
					dialog.dialog("open");
				}
			}
		} catch (e) {
			alert(e);
		}
	}

	function callServeResource(op, obj) {
		var Title = obj["Title"];
		var Description = obj["Description"];
		var picture = obj["picture"];
		var journeyId = obj["journeyId"];

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
				},
				on : {
					success : function(data) {
						console.log(data);
					}
				}
			});

		});
	}
</script>