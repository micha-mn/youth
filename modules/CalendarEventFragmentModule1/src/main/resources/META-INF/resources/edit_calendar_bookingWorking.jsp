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
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.liferay.dynamic.data.mapping.model.DDMFormInstance"%>
<%@page import="com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil"%>
<%@page import="java.util.Locale"%>

<script src="/o/new-misk-theme/js/from/jquery.dataTables.min.js"></script>
<script src="/o/new-misk-theme/js/from/dataTables.bootstrap4.min.js"></script>

<style>

.form-control {
    background-color: #ffffff;
    background-clip: border-box;
    border-color: #ced4da;
    border-bottom-width: 0.0625rem;
    border-left-width: 0.0625rem;
    border-right-width: 0.0625rem;
    border-top-width: 0.0625rem;
    height: 2.375rem;
    border-left: 0;
    border-top: 0;
    border-right: 0;
    border-radius: 0;
    padding: 0.1%;
    min-width: 0;
}
.control-label{
text-transform: capitalize !important;
font-size:15px;
padding-bottom:5px;
}
/* label {
    display: inline-block;
    margin-bottom: 0;
    color: #a5a5a5;
} */


.imgwrap {
    background-color: #fff;
    width: fit-content;
    display: inline-block;
    padding: 8px;
    position: relative;
    border-radius: 2px;
    box-shadow: 0px 0px 7px 2px rgba(0, 0, 0, 0.1);
}
img#imageId1 {
    max-height: 230px;
    max-width: 550px;
}


.col-md-12.table {
    display: flex;
    border: 1px solid #c1c1c1;
    border-left: 0;
    border-right: 0;
    border-bottom: 0;
    border-radius: 0.25%;
    margin-top: 2%;
    padding:0;
    padding-top: 2%;
    
}
.add-delete-btn { 
    margin: 2%;
    padding-top: 3%;
    width: 90%;
    padding-bottom: 3%;
}

#calendarBookingDetailsPanelContent > div > div.taglib-custom-attributes-list > div:nth-child(1) > label
{
 font-size: 1rem;
}
input[type='checkbox']{
    margin: 25px 2px;
}

.btn-info {
    color: #fff !important;
    background-color: #17a2b8 !important;
    border-color: #17a2b8 !important;
   
}

/* table desing */

.table {
    width: 100% !important;
    margin-bottom: 1rem;
    color: #212529;
    background: #fff;
    /* max-width: 1000px; */
    width: 96%;
    border: 1px solid #E6EAEE;
    border-radius: 3.25%!important;
}

.table th {
    padding: 10px !important;;
    vertical-align: middle!important;
    height: 50px;
    border-top: 1px solid #E6EAEE;
    text-transform: uppercase;
    font-weight: 600;  	
    font-family: Montserrat-Regular;
    vertical-align: middle!important;
}

.table-striped thead th{    
	
    color:#7db72c !important;
    }


.table-striped input[type='text']
{
	width: 100%;
    border: 0px;
    background-color: #edf9f0;
    height: 35px;
    color: #8d9194;
    padding: 5px;
    font-size: 15px;
    font-family: Montserrat-Regular;
}
.table-striped tbody tr:nth-of-type(odd) td{
 background-color: #F2F2F2;
    background: #FAFBFC;  
    height: 30px
} 

/*end of table design*/
.checkbox-label{
padding-right: 15px;
top: -2px;
position: relative;
}

#upload_button {
  display: inline-block;
}

.reminder-type{
	padding-top: 15px !important; 
}
.reminder-value{
    margin-left: 15px;
    margin-right: 15px;
    padding: 4px;
}
.reminder-duration
{
padding: 5px;
margin-top: 10px;
}

/* .taglib-custom-attributes-list{
display:none;
}
#upload_button input[type=file] {
  display:none;
}
div > div.taglib-custom-attributes-list > div:nth-child(4) > label {
    font-size: 1rem;
}
div > div.taglib-custom-attributes-list > div:nth-child(4) > label:nth-child(3) {
    font-size: 0;
}
div > div.taglib-custom-attributes-list > div > label {
    font-size: 0;
    height: 0;
}
div > div.taglib-custom-attributes-list > div > textarea {
    height: 0 !important;
    font-size: 0;
}
#Content > div > div.form-group.form-inline.input-boolean-wrapper {
    display: none;
}
.lfr-ddm-field-group.lfr-ddm-field-group-inline.field-wrapper.calendar-portlet-recurrence-container {
    display: none;
}

div#calendarBookingInvitationPanelHeader {
    display: none;
}

div#_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_PfOEREvdCGVQ_inputPermissionsTable {
    display: none;
} */
</style>


<!-- custom Code start jean-->
<%
long groupId = themeDisplay.getSiteGroupId();
List<DDMFormInstance> formNameList = DDMFormInstanceLocalServiceUtil.getFormInstances(groupId);
%>
<!-- custom Code end -->


<%
String activeView = ParamUtil.getString(request, "activeView", defaultView);

TimeZone calendarBookingTimeZone = userTimeZone;

boolean allDay = BeanParamUtil.getBoolean(calendarBooking, request, "allDay");

if (allDay) {
	calendarBookingTimeZone = utcTimeZone;
}

java.util.Calendar defaultStartTimeJCalendar = CalendarFactoryUtil.getCalendar(calendarBookingTimeZone);

defaultStartTimeJCalendar.add(java.util.Calendar.HOUR, 1);

defaultStartTimeJCalendar.set(java.util.Calendar.MINUTE, 0);

long date = ParamUtil.getLong(request, "date", defaultStartTimeJCalendar.getTimeInMillis());

long calendarBookingId = BeanPropertiesUtil.getLong(calendarBooking, "calendarBookingId");

int instanceIndex = BeanParamUtil.getInteger(calendarBooking, request, "instanceIndex");

long calendarId = BeanParamUtil.getLong(calendarBooking, request, "calendarId", defaultCalendar.getCalendarId());

long startTime = BeanPropertiesUtil.getLong(calendarBooking, "startTime", defaultStartTimeJCalendar.getTimeInMillis());

java.util.Calendar startTimeJCalendar = JCalendarUtil.getJCalendar(startTime, calendarBookingTimeZone);

int startTimeYear = ParamUtil.getInteger(request, "startTimeYear", startTimeJCalendar.get(java.util.Calendar.YEAR));
int startTimeMonth = ParamUtil.getInteger(request, "startTimeMonth", startTimeJCalendar.get(java.util.Calendar.MONTH));
int startTimeDay = ParamUtil.getInteger(request, "startTimeDay", startTimeJCalendar.get(java.util.Calendar.DAY_OF_MONTH));
int startTimeHour = ParamUtil.getInteger(request, "startTimeHour", startTimeJCalendar.get(java.util.Calendar.HOUR_OF_DAY));
int startTimeMinute = ParamUtil.getInteger(request, "startTimeMinute", startTimeJCalendar.get(java.util.Calendar.MINUTE));

int startTimeAmPm = ParamUtil.getInteger(request, "startTimeAmPm");

if (startTimeAmPm == java.util.Calendar.PM) {
	startTimeHour += 12;
}

startTimeJCalendar = CalendarFactoryUtil.getCalendar(startTimeYear, startTimeMonth, startTimeDay, startTimeHour, startTimeMinute, 0, 0, calendarBookingTimeZone);

startTimeJCalendar.setFirstDayOfWeek(weekStartsOn + 1);

startTime = startTimeJCalendar.getTimeInMillis();

java.util.Calendar defaultEndTimeJCalendar = (java.util.Calendar)startTimeJCalendar.clone();

defaultEndTimeJCalendar.add(java.util.Calendar.MINUTE, defaultDuration);

long endTime = BeanPropertiesUtil.getLong(calendarBooking, "endTime", defaultEndTimeJCalendar.getTimeInMillis());

java.util.Calendar endTimeJCalendar = JCalendarUtil.getJCalendar(endTime, calendarBookingTimeZone);

int endTimeYear = ParamUtil.getInteger(request, "endTimeYear", endTimeJCalendar.get(java.util.Calendar.YEAR));
int endTimeMonth = ParamUtil.getInteger(request, "endTimeMonth", endTimeJCalendar.get(java.util.Calendar.MONTH));
int endTimeDay = ParamUtil.getInteger(request, "endTimeDay", endTimeJCalendar.get(java.util.Calendar.DAY_OF_MONTH));
int endTimeHour = ParamUtil.getInteger(request, "endTimeHour", endTimeJCalendar.get(java.util.Calendar.HOUR_OF_DAY));
int endTimeMinute = ParamUtil.getInteger(request, "endTimeMinute", endTimeJCalendar.get(java.util.Calendar.MINUTE));

int endTimeAmPm = ParamUtil.getInteger(request, "endTimeAmPm");

if (endTimeAmPm == java.util.Calendar.PM) {
	endTimeHour += 12;
}

endTimeJCalendar = CalendarFactoryUtil.getCalendar(endTimeYear, endTimeMonth, endTimeDay, endTimeHour, endTimeMinute, 0, 0, calendarBookingTimeZone);

endTimeJCalendar.setFirstDayOfWeek(weekStartsOn + 1);

endTime = endTimeJCalendar.getTimeInMillis();

long firstReminder = BeanParamUtil.getLong(calendarBooking, request, "firstReminder");
String firstReminderType = BeanParamUtil.getString(calendarBooking, request, "firstReminderType", CalendarServiceConfigurationValues.CALENDAR_NOTIFICATION_DEFAULT_TYPE.name());
long secondReminder = BeanParamUtil.getLong(calendarBooking, request, "secondReminder");
String secondReminderType = BeanParamUtil.getString(calendarBooking, request, "secondReminderType", CalendarServiceConfigurationValues.CALENDAR_NOTIFICATION_DEFAULT_TYPE.name());

JSONArray acceptedCalendarsJSONArray = JSONFactoryUtil.createJSONArray();
JSONArray declinedCalendarsJSONArray = JSONFactoryUtil.createJSONArray();
JSONArray maybeCalendarsJSONArray = JSONFactoryUtil.createJSONArray();
JSONArray pendingCalendarsJSONArray = JSONFactoryUtil.createJSONArray();

boolean approved = false;
boolean hasChildCalendarBookings = false;
boolean hasWorkflowDefinitionLink = false;
boolean invitable = true;
boolean masterBooking = true;
Recurrence recurrence = null;
boolean recurring = false;

Calendar calendar = CalendarServiceUtil.fetchCalendar(calendarId);

if (calendarBooking != null) {
	acceptedCalendarsJSONArray = CalendarUtil.toCalendarBookingsJSONArray(themeDisplay, CalendarBookingServiceUtil.getChildCalendarBookings(calendarBooking.getParentCalendarBookingId(), WorkflowConstants.STATUS_APPROVED));
	declinedCalendarsJSONArray = CalendarUtil.toCalendarBookingsJSONArray(themeDisplay, CalendarBookingServiceUtil.getChildCalendarBookings(calendarBooking.getParentCalendarBookingId(), WorkflowConstants.STATUS_DENIED));
	maybeCalendarsJSONArray = CalendarUtil.toCalendarBookingsJSONArray(themeDisplay, CalendarBookingServiceUtil.getChildCalendarBookings(calendarBooking.getParentCalendarBookingId(), CalendarBookingWorkflowConstants.STATUS_MAYBE));

	List<CalendarBooking> pendingCalendarBookings = new ArrayList<CalendarBooking>();

	pendingCalendarBookings.addAll(CalendarBookingServiceUtil.getChildCalendarBookings(calendarBooking.getParentCalendarBookingId(), WorkflowConstants.STATUS_PENDING));
	pendingCalendarBookings.addAll(CalendarBookingServiceUtil.getChildCalendarBookings(calendarBooking.getParentCalendarBookingId(), WorkflowConstants.STATUS_DRAFT));
	pendingCalendarBookings.addAll(CalendarBookingServiceUtil.getChildCalendarBookings(calendarBooking.getParentCalendarBookingId(), CalendarBookingWorkflowConstants.STATUS_MASTER_PENDING));

	pendingCalendarsJSONArray = CalendarUtil.toCalendarBookingsJSONArray(themeDisplay, pendingCalendarBookings);

	if (calendarBooking.isMasterBooking()) {
		List<CalendarBooking> childCalendarBookings = CalendarBookingServiceUtil.getChildCalendarBookings(calendarBooking.getParentCalendarBookingId());

		if (childCalendarBookings.size() > 1) {
			hasChildCalendarBookings = true;
		}
	}
	else {
		invitable = false;
		masterBooking = false;
	}

	if (calendarBooking.isRecurring()) {
		recurring = true;
	}

	recurrence = calendarDisplayContext.getLastRecurrence(calendarBooking);

	recurrence = RecurrenceUtil.inTimeZone(recurrence, startTimeJCalendar, calendarBookingTimeZone);

	approved = calendarBooking.isApproved();

	calendar = calendarBooking.getCalendar();

	CalendarResource calendarResource = calendar.getCalendarResource();

	hasWorkflowDefinitionLink = WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), calendarResource.getGroupId(), CalendarBooking.class.getName());
}
else if (calendar != null) {
	JSONObject calendarJSONObject = CalendarUtil.toCalendarJSONObject(themeDisplay, calendar);

	CalendarResource calendarResource = calendar.getCalendarResource();

	if (calendar.getUserId() == themeDisplay.getUserId()) {
		acceptedCalendarsJSONArray.put(calendarJSONObject);
	}
	else {
		pendingCalendarsJSONArray.put(calendarJSONObject);
	}

	hasWorkflowDefinitionLink = WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), calendarResource.getGroupId(), CalendarBooking.class.getName());
}

long[] groupIds = null;

if (showUserEvents) {
	groupIds = ArrayUtil.append(user.getGroupIds(), new long[] {user.getGroupId(), scopeGroupId});
}
else {
	groupIds = ArrayUtil.append(user.getGroupIds(), new long[] {scopeGroupId});
}

List<Calendar> manageableCalendars = CalendarServiceUtil.search(themeDisplay.getCompanyId(), groupIds, null, null, true, QueryUtil.ALL_POS, QueryUtil.ALL_POS, new CalendarNameComparator(true), CalendarActionKeys.MANAGE_BOOKINGS);

CalendarResource guestCalendarResource = CalendarResourceUtil.fetchGuestCalendarResource(themeDisplay.getCompanyId());

if (guestCalendarResource != null) {
	manageableCalendars.remove(guestCalendarResource.getDefaultCalendar());
}

long[] otherCalendarIds = StringUtil.split(SessionClicks.get(request, "com.liferay.calendar.web_otherCalendars", StringPool.BLANK), 0L);

for (long otherCalendarId : otherCalendarIds) {
	Calendar otherCalendar = CalendarServiceUtil.fetchCalendar(otherCalendarId);

	if (otherCalendar == null) {
		continue;
	}

	CalendarResource otherCalendarResource = otherCalendar.getCalendarResource();

	if (otherCalendarResource.isActive() && !manageableCalendars.contains(otherCalendar) && CalendarPermission.contains(themeDisplay.getPermissionChecker(), otherCalendar, CalendarActionKeys.MANAGE_BOOKINGS)) {
		manageableCalendars.add(otherCalendar);
	}
}

Iterator<Calendar> manageableCalendarsIterator = manageableCalendars.iterator();

while (manageableCalendarsIterator.hasNext()) {
	Calendar curCalendar = manageableCalendarsIterator.next();

	if (!CalendarServiceUtil.isManageableFromGroup(curCalendar.getCalendarId(), themeDisplay.getScopeGroupId())) {
		manageableCalendarsIterator.remove();
	}
}
%>
<SCRIPT language="javascript">
$(document).ready(function () {
	var coursesFieldName=document.querySelector('[id$="_Courses"]').id;
	var courses=document.getElementById(coursesFieldName);
	var coursesJSON=JSON.parse(courses.value);
	var table1 = document.getElementById('dataTable');
	
	for (var i = 0; i < coursesJSON.length; i++) {
		var row = table1.insertRow(i+1);
		var obj = coursesJSON[i];
		
        var cell1 = row.insertCell(0);
        var element1 = document.createElement("input");
        element1.type = "checkbox";
        element1.name="chkbox[]";
        cell1.appendChild(element1);

        //var cell2 = row.insertCell(1);
        //cell2.innerHTML = obj["id"];

        var cell3 = row.insertCell(1);
        var element2 = document.createElement("input");
        element2.type = "text";
        element2.name = "courseTitle";
        element2.setAttribute("onchange","checkRow('dataTable','Courses')");
        element2.style.cssText='width:100%;border: 0;';
        element2.value=obj["title"];
        cell3.appendChild(element2);
        
        var cell4 = row.insertCell(2);
        var element3 = document.createElement("input");
        element3.type = "text";
        element3.name = "courseDesc";
        element3.setAttribute("onchange","checkRow('dataTable','Courses')");
        element3.style.cssText='width:100%;border: 0;';
        element3.value=obj["description"];
        cell4.appendChild(element3);
    }
	
	var numberFieldName=document.querySelector('[id$="_Numbers"]').id;
	var numbers=document.getElementById(numberFieldName);
	var numbersJSON=JSON.parse(numbers.value);
	var table2 = document.getElementById('numberDataTable');
	
	for (var i = 0; i < numbersJSON.length; i++) {
		var row = table2.insertRow(i+1);
		var obj = numbersJSON[i];
		
        var cell1 = row.insertCell(0);
        var element1 = document.createElement("input");
        element1.type = "checkbox";
        element1.name="chkbox[]";
        cell1.appendChild(element1);

        //var cell2 = row.insertCell(1);
        //cell2.innerHTML = obj["id"];

        var cell3 = row.insertCell(1);
        var element2 = document.createElement("input");
        element2.type = "text";
        element2.name = "courseTitle";
        element2.setAttribute("onchange","checkRow('numberDataTable','Numbers')");
        element2.style.cssText='width:100%;border: 0;';
        element2.value=obj["title"];
        cell3.appendChild(element2);
        
        var cell4 = row.insertCell(2);
        var element3 = document.createElement("input");
        element3.type = "text";
        element3.name = "courseDesc";
        element3.setAttribute("onchange","checkRow('numberDataTable','Numbers')");
        element3.style.cssText='width:100%;border: 0;';
        element3.value=obj["description"];
        cell4.appendChild(element3);
    }
	var subitemsFieldName=document.querySelector('[id$="_SubItems"]').id;
	var subitems=document.getElementById(subitemsFieldName);
	var subitemsJSON=JSON.parse(subitems.value);
	var table3 = document.getElementById('subItemsDataTable');
	for (var i = 0; i < subitemsJSON.length; i++) {		
		var obj = subitemsJSON[i];
		var index = parseInt(obj["id"]);
		if(index === (i+1)){
			var row = table3.rows[index];
        	row.cells[0].childNodes[0].checked = false; 
        	row.cells[1].getElementsByTagName('input')[0].value = obj["title"];
        	row.cells[2].getElementsByTagName('input')[0].value = obj["description"];        	
        	var imageName='subItemImagePreview'+index;
        	var fieldName='subItemImage'+index;
        	var newImage = document.createElement('img');
        	var tergetName='SubItemImageField'+index;
    		var imageFieldName=document.querySelector('[id$="_'+tergetName+'"]').id;
			newImage.style.cssText='width:75px;height:75px;';
			newImage.setAttribute("id", "imageId1");        	
        	newImage.src = document.getElementById(imageFieldName).value;
        	newImage.setAttribute('onclick','previewImage("'+index+'","SubItem")');
        	document.getElementById(imageName).innerHTML = newImage.outerHTML;
        	document.getElementById(fieldName).style.display = 'none';
        	var trName = "subItemRow" + index;
			document.getElementById(trName).style.display = 'table-row';
		}		
    }
	var speakersFieldName=document.querySelector('[id$="_Speakers"]').id;
	var speakers=document.getElementById(speakersFieldName);
	var speakersJSON=JSON.parse(speakers.value);
	var table4 = document.getElementById('speakersDataTable');
	for (var i = 0; i < speakersJSON.length; i++) {		
		var obj = speakersJSON[i];
		var index = parseInt(obj["id"]);
		if(index === (i+1)){
			var row = table4.rows[index];
        	row.cells[0].childNodes[0].checked = false; 
        	row.cells[1].getElementsByTagName('input')[0].value = obj["title"];
        	row.cells[2].getElementsByTagName('input')[0].value = obj["description"];   
        	row.cells[3].getElementsByTagName('input')[0].value = obj["email"];
        	var imageName='speakerImagePreview'+index;
        	var fieldName='speakerImage'+index;
        	var newImage = document.createElement('img');
        	var tergetName='SpeakerImageField'+index;
    		var imageFieldName=document.querySelector('[id$="_'+tergetName+'"]').id;
			newImage.style.cssText='width:75px;height:75px;';
			newImage.setAttribute("id", "imageId1");        	
        	newImage.src = document.getElementById(imageFieldName).value;
        	newImage.setAttribute('onclick','previewImage("'+index+'","Speaker")');
        	document.getElementById(imageName).innerHTML = newImage.outerHTML;
        	document.getElementById(fieldName).style.display = 'none';
        	var trName = "speakerRow" + index;
			document.getElementById(trName).style.display = 'table-row';
		}		
    }
	
	
	var hidedFields=[];
	hidedFields.push(coursesFieldName);
	hidedFields.push(numberFieldName);
	hidedFields.push(subitemsFieldName);
	hidedFields.push(speakersFieldName);
	document.getElementById(coursesFieldName).style.display = 'none';
	document.getElementById(numberFieldName).style.display = 'none';
	document.getElementById(subitemsFieldName).style.display = 'none';
	document.getElementById(speakersFieldName).style.display = 'none';
	for (var i = 1; i <= 5; i++) {
		var tergetName='SubItemImageField'+i;
		var imageFieldName=document.querySelector('[id$="_'+tergetName+'"]').id;
		document.getElementById(imageFieldName).style.display = 'none';
		hidedFields.push(imageFieldName);
	}
	
	for (var i = 1; i <= 5; i++) {
		var tergetName='SpeakerImageField'+i;
		var imageFieldName=document.querySelector('[id$="_'+tergetName+'"]').id;
		document.getElementById(imageFieldName).style.display = 'none';
		hidedFields.push(imageFieldName);
	}

/* 	var labels = document.getElementsByTagName('LABEL');
	for (var i = 0; i < labels.length; i++) {
	    if (labels[i].htmlFor != '' && hidedFields.includes(labels[i].htmlFor)) {
	    	labels[i].style.display = 'none';         
	    }
	} */
});
	
	function addRowImage(index,mainFieldName,rowName){
		var fieldName=rowName + 'Image'+ index;
		var imageName=rowName + 'ImagePreview' + index;
		var tergetName=mainFieldName + 'ImageField' + index;
		var filesSelected = document.getElementById(fieldName).files;
		if (filesSelected.length > 0) {
			var fileToLoad = filesSelected[0];
			var fileReader = new FileReader();
			fileReader.onload = function(fileLoadedEvent) {
				var srcData = fileLoadedEvent.target.result; // <--- data: base64
				var newImage = document.createElement('img');
				newImage.style.cssText='width:75px;height:75px;';
				newImage.setAttribute("id", "imageId1");
				newImage.src = srcData;
				newImage.setAttribute('onclick','previewImage("'+index+'","'+mainFieldName+'")');
				document.getElementById(imageName).innerHTML = newImage.outerHTML;
				var imageFieldName=document.querySelector('[id$="_'+tergetName+'"]').id;
				document.getElementById(imageFieldName).value = srcData;
			}
			fileReader.readAsDataURL(fileToLoad);
		}
		document.getElementById(fieldName).style.display = 'none';
	}

	function checkRow(tableID,fieldName){
		var myRows = [];
		var fieldId = document.querySelector('[id$="_'+fieldName+'"]').id;
		var table = document.getElementById(tableID);
		for (var i = 1, row; row = table.rows[i]; i++) {
			myRows.push('{"id":"'+i+'","title":"'+row.cells[1].getElementsByTagName('input')[0].value+'","description":"'+row.cells[2].getElementsByTagName('input')[0].value+'"}')
		}
		var field=document.getElementById(fieldId);
		field.value='['+myRows+']';
	}
	
    function addRow(tableID,fieldName) {
	
        var table = document.getElementById(tableID);

        var rowCount = table.rows.length-1;
        var row = table.insertRow(rowCount+1);

        var cell1 = row.insertCell(0);
        var element1 = document.createElement("input");
        element1.type = "checkbox";
        element1.name="chkbox[]";
        cell1.appendChild(element1);

        //var cell2 = row.insertCell(1);
       // cell2.innerHTML = rowCount + 1;

        var cell3 = row.insertCell(1);
        var element2 = document.createElement("input");
        element2.type = "text";
        element2.setAttribute("onchange","checkRow('"+tableID+"','"+fieldName+"')");
        if(tableID=='dataTable')
        	{
        element2.setAttribute("placeholder"," Course Title ");
        	}
        else if(tableID=='numberDataTable')
        	{
        	element2.setAttribute("placeholder"," Number ");
        	}
        element2.style.cssText='width:100%;border: 0;';
        cell3.appendChild(element2);
        
        var cell4 = row.insertCell(2);
        var element3 = document.createElement("input");
        element3.type = "text";
        element3.setAttribute("onchange","checkRow('"+tableID+"','"+fieldName+"')");
        element3.setAttribute("placeholder"," Description ");
        element3.style.cssText='width:100%;border: 0;';
        cell4.appendChild(element3);
        
    }

    function deleteRow(tableID,fieldName) {
        try {     
	        var table = document.getElementById(tableID);
	        var rowCount = table.rows.length;	
	        for(var i=0; i<rowCount; i++) {
	            var row = table.rows[i];
	            var chkbox = row.cells[0].childNodes[0];
	            if(null != chkbox && true == chkbox.checked) {
	            	table.deleteRow(i);
	                rowCount--;
	                i--;
	            }
	        }
	        checkRow(tableID,fieldName);
        }catch(e) {
            alert(e);
        }
    }
    
    function hideRow(tableID,mainFieldName,rowName) {
        try {
	        var table = document.getElementById(tableID);
	        var rowCount = table.rows.length;	
	        for(var i=0; i<rowCount; i++) {
	            var row = table.rows[i];
	            var chkbox = row.cells[0].childNodes[0];
	            if(null != chkbox && true == chkbox.checked) {
	            	var trName = rowName+"Row" +i;
	            	document.getElementById(trName).style.display = 'none';
	            	var row = table.rows[i];
	            	row.cells[0].childNodes[0].checked = false; 
	            	row.cells[1].getElementsByTagName('input')[0].value = "";
	            	row.cells[2].getElementsByTagName('input')[0].value = "";
	            	var imageName=rowName + 'ImagePreview' + i;
	            	var fieldName=rowName + 'Image' + i;
	            	document.getElementById(imageName).innerHTML = "";
	            	document.getElementById(fieldName).style.display = 'block';
	            }
	        }
	        checkShowedRow(tableID,mainFieldName,rowName);
        }catch(e) {
            alert(e);
        }
    }
    
    function showRow(tableID,fieldName,rowName) {
    	try {
	        var table = document.getElementById(tableID);
	        var rowCount = table.rows.length;
	        for(var i=1; i<rowCount; i++) {
	        	var trName = rowName+"Row" +i;
	        	if(document.getElementById(trName).style.display === 'none'){
	        		document.getElementById(trName).style.display = 'table-row';
	        		break;
	        	}
	        }
    	}catch(e) {
            alert(e);
        }
    }
    
    function checkShowedRow(tableID,fieldName,rowName){
		var myRows = [];
		var fieldId = document.querySelector('[id$="_'+fieldName+'"]').id;
		var table = document.getElementById(tableID);
		for (var i = 1, row; row = table.rows[i]; i++) {
			var trName = rowName+"Row" +i;
        	if(document.getElementById(trName).style.display === 'none'){
        		continue;
        	}
        	if(fieldName=='Speakers'){
        		myRows.push('{"id":"'+i+'","title":"'+row.cells[1].getElementsByTagName('input')[0].value+'","description":"'+row.cells[2].getElementsByTagName('input')[0].value+'","email":"'+row.cells[3].getElementsByTagName('input')[0].value+'"}');
        	}else{
				myRows.push('{"id":"'+i+'","title":"'+row.cells[1].getElementsByTagName('input')[0].value+'","description":"'+row.cells[2].getElementsByTagName('input')[0].value+'"}');
        	}
		}
		var field=document.getElementById(fieldId);
		field.value='['+myRows+']';
	}
    
    function previewImage(index,fieldName){
    	var tergetName=fieldName+'ImageField'+index;
    	var imageFieldName=document.querySelector('[id$="_'+tergetName+'"]').id;
    	var srcData = document.getElementById(imageFieldName).value;
		var newImage = document.createElement('img');
		newImage.setAttribute("id", "imageId1");
		newImage.src = srcData;
		document.getElementById(fieldName+"ImagePreview").innerHTML = newImage.outerHTML;
	}

</SCRIPT>

<aui:script use="liferay-calendar-container,liferay-calendar-remote-services,liferay-component">

	Liferay.component(
		'<portlet:namespace />calendarContainer',
		function() {
			var calendarContainer = new Liferay.CalendarContainer(
				{
					groupCalendarResourceId: <%= groupCalendarResource.getCalendarResourceId() %>,

					<c:if test="<%= userCalendarResource != null %>">
						userCalendarResourceId: <%= userCalendarResource.getCalendarResourceId() %>,
					</c:if>

					namespace: '<portlet:namespace />'
				}
			);

			var destroyInstance = function(event) {
				if (event.portletId === '<%= portletDisplay.getId() %>') {
					calendarContainer.destroy();

					Liferay.component('<portlet:namespace />calendarContainer', null);
					Liferay.detach('destroyPortlet', destroyInstance);
				}
			};

			Liferay.on('destroyPortlet', destroyInstance);

			return calendarContainer;
		}
	);

	Liferay.component(
		'<portlet:namespace />remoteServices',
		function() {
			var remoteServices = new Liferay.CalendarRemoteServices(
				{
					invokerURL: themeDisplay.getPathContext() + '/api/jsonws/invoke',
					namespace: '<portlet:namespace />'
				}
			);

			var destroyInstance = function(event) {
				if (event.portletId === '<%= portletDisplay.getId() %>') {
					remoteServices.destroy();

					Liferay.component('<portlet:namespace />remoteServices', null);

					Liferay.detach('destroyPortlet', destroyInstance);
				}
			};

			Liferay.on('destroyPortlet', destroyInstance);

			return remoteServices;
		}
	);
</aui:script>

<liferay-portlet:actionURL name="updateFormCalendarBooking" var="updateFormCalendarBookingURL" />

<aui:form action="<%= updateFormCalendarBookingURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "updateCalendarBooking();" %>'>
	<aui:input name="mvcPath" type="hidden" value="/edit_calendar_booking.jsp" />

	<liferay-portlet:renderURL var="redirectURL">
		<liferay-portlet:param name="mvcPath" value="/edit_calendar_booking.jsp" />
		<liferay-portlet:param name="calendarBookingId" value="<%= String.valueOf(calendarBookingId) %>" />
	</liferay-portlet:renderURL>
	
	<aui:input name="redirect" type="hidden" value="<%= calendarDisplayContext.getEditCalendarBookingRedirectURL(request, redirectURL) %>" />
	<aui:input name="calendarBookingId" type="hidden" value="<%= calendarBookingId %>" />
	<aui:input name="instanceIndex" type="hidden" value="<%= instanceIndex %>" />
	<aui:input name="childCalendarIds" type="hidden" />
	<aui:input name="reinvitableCalendarIds" type="hidden" />
	<aui:input name="allFollowing" type="hidden" />
	<aui:input name="updateCalendarBookingInstance" type="hidden" />
	<aui:input name="workflowAction" type="hidden" value="<%= WorkflowConstants.ACTION_PUBLISH %>" />

	<div class="lfr-form-content">
		<liferay-ui:error exception="<%= CalendarBookingDurationException.class %>" message="please-enter-a-start-date-that-comes-before-the-end-date" />
		<liferay-ui:error exception="<%= CalendarBookingRecurrenceException.class %>" message="the-last-repeating-date-should-come-after-the-event-start-date" />

		<liferay-asset:asset-categories-error />

		<liferay-asset:asset-tags-error />

		<aui:model-context bean="<%= calendarBooking %>" model="<%= CalendarBooking.class %>" />

		<aui:fieldset markupView="lexicon">
			<aui:input defaultLanguageId="<%= themeDisplay.getLanguageId() %>" name="title" />

        <!-- custom Code start jean-->
		<aui:select name="questionnaire" cssClass="form-id" onChange="changeform(this)">
		   <% 
		   for (DDMFormInstance ddmFormInstance : formNameList) {
			   if(ddmFormInstance.getUserId() == themeDisplay.getUserId()){
			   		String name = ddmFormInstance.getName(Locale.US);
			   		String id = String.valueOf(ddmFormInstance.getFormInstanceId());
		   %>
		   <aui:option value="<%= id %>"><%= name %></aui:option>
		   <% } %>
		   <% } %>
		</aui:select>
		
		<aui:select name="speaker questionnaire" cssClass="form-id" onChange="changeform(this)">
		   <% 
		   for (DDMFormInstance ddmFormInstance : formNameList) {
			   if(ddmFormInstance.getUserId() == themeDisplay.getUserId()){
			   		String name = ddmFormInstance.getName(Locale.US);
			   		String id = String.valueOf(ddmFormInstance.getFormInstanceId());
		   %>
		   <aui:option value="<%= id %>"><%= name %></aui:option>
		   <% } %>
		   <% } %>
		</aui:select>
		
		<br/>
		
		<div id="upload_button">
    	<label>
     		<input type="file" name="pic" id="ipoadImageId" accept="image/*" onchange="previewFile()" value="upload Main Event Image">
      		<span class="btn btn-secondary">Upload Main Event Image...</span>
    	</label>
  		</div>
  
		 
                
          <div id="previewImgId" class="imgwrap"></div>
         <div>
  <input type="checkbox" id="showHorizontallayer1" name="showHorizontallayer1"
         >
  <label for="showHorizontallayer1" class="checkbox-label">Show Horizontal 1 Event one</label>
    <input type="checkbox" id="showHorizontallayer2" name="showHorizontallayer1"
         >
  <label for="showHorizontallayer2" class="checkbox-label">Show Horizontal layer two</label>
      <input type="checkbox" id="showVertical" name="showHorizontallayer1"
         >
  <label for="showVertical" class="checkbox-label">Show Vertical</label>
</div>

		<!-- custom Code end -->

			<div style="display:block" class="<%= allDay ? "allday-class-active" : "" %>" id="<portlet:namespace />startDateContainer">
				<aui:input ignoreRequestValue="<%= true %>" label="starts" name="startTime" timeFormat="<%= timeFormat %>" value="<%= startTimeJCalendar %>" />
			</div>

			<div style="display:block" class="<%= allDay ? "allday-class-active" : "" %>" id="<portlet:namespace />endDateContainer">
				<aui:input ignoreRequestValue="<%= true %>" label="ends" name="endTime" timeFormat="<%= timeFormat %>" value="<%= endTimeJCalendar %>" />
			</div>

			<aui:input style="display:none" checked="<%= allDay %>" name="allDay" />

			<aui:field-wrapper cssClass="calendar-portlet-recurrence-container" inlineField="<%= true %>" label="">
				<aui:input checked="<%= recurring %>" name="repeat" type="checkbox" />

				<a class="calendar-portlet-recurrence-summary" href="javascript:;" id="<portlet:namespace />summary"></a>
			</aui:field-wrapper>
			<br />
 
			<br />

			<aui:button cssClass="btn btn-info btn-sm" name="addCourseButton" type="button"
				value="Add Course" onClick="addRow('dataTable','Courses')" />
			<aui:button cssClass="btn btn-default btn-sm" name="deleteCourseButton" type="button"
				value="Delete Course" onClick="deleteRow('dataTable','Courses')" />


			<br />
			<br />

			<table id="dataTable" width="100%" class="table table-striped">
				<thead>
					<tr>
						<th></th>
						<th>Course Title</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>

				</tbody>
			</TABLE>

			<br />

			<aui:button cssClass="btn btn-info btn-sm" name="addNumberButton" type="button"
				value="Add Number" onClick="addRow('numberDataTable','Numbers')" />
			<aui:button cssClass="btn btn-default btn-sm" name="deleteNumberButton" type="button"
				value="Delete Number"
				onClick="deleteRow('numberDataTable','Numbers')" />


			<br />
			<br />

			<TABLE id="numberDataTable" width="100%" class="table table-striped"> 
				<thead>
					<tr>
						<th></th>
						<th>Number</th>
						<th>Description</th>
					</tr>
				</thead>
				<tbody>

				</tbody>
			</TABLE>
			<br />
			<br />
			<aui:button cssClass="btn btn-info btn-sm" name="addSubItemButton" type="button"
				value="Add SubItem" onClick="showRow('subItemsDataTable','SubItems','subItem')" />
			<aui:button cssClass="btn btn-default btn-sm" name="deleteSubItemButton" type="button"
				value="Delete SubItem" onClick="hideRow('subItemsDataTable','SubItems','subItem')" />
			<br />
			<br />
			<table id="subItemsDataTable" width="100%" class="table table-striped">
				<thead>
					<tr>
						<th></th>
						<th>Item</th>
						<th>Description</th>
						<th>Image</th>
					</tr>
				</thead>
				<tbody>
					<tr id="subItemRow1">
						<td><input type="checkbox" ></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('subItemsDataTable','SubItems','subItem')" placeholder="Item" ></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('subItemsDataTable','SubItems','subItem')" placeholder="Description"></td>
						<td>
							<input type="file" name="pic" id="subItemImage1" accept="image/*" onchange="addRowImage('1','SubItem','subItem')">
							<div id="subItemImagePreview1" class="imgwrap"></div>
						</td>
					</tr>
					<tr id="subItemRow2" style='display:none'>
						<td><input type="checkbox" ></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('subItemsDataTable','SubItems','subItem')" placeholder="Item" ></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('subItemsDataTable','SubItems','subItem')" placeholder="Description"></td>
						<td>
							<input type="file" name="pic" id="subItemImage2" accept="image/*" onchange="addRowImage('2','SubItem','subItem')">
							<div id="subItemImagePreview2" class="imgwrap"></div>
						</td>
					</tr>
					<tr id="subItemRow3" style='display:none'>
						<td><input type="checkbox" ></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('subItemsDataTable','SubItems','subItem')" placeholder="Item"></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('subItemsDataTable','SubItems','subItem')" placeholder="Description"></td>
						<td>
							<input type="file" name="pic" id="subItemImage3" accept="image/*" onchange="addRowImage('3','SubItem','subItem')">
							<div id="subItemImagePreview3" class="imgwrap"></div>
						</td>
					</tr>
					<tr id="subItemRow4" style='display:none'>
						<td><input type="checkbox" ></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('subItemsDataTable','SubItems','subItem')" placeholder="Item" ></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('subItemsDataTable','SubItems','subItem')" placeholder="Description"></td>
						<td>
							<input type="file" name="pic" id="subItemImage4" accept="image/*" onchange="addRowImage('4','SubItem','subItem')">
							<div id="subItemImagePreview4" class="imgwrap"></div>
						</td>
					</tr>
					<tr id="subItemRow5" style='display:none'>
						<td><input type="checkbox" ></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('subItemsDataTable','SubItems','subItem')" placeholder="Item" ></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('subItemsDataTable','SubItems','subItem')" placeholder="Description"></td>
						<td>
							<input type="file" name="pic" id="subItemImage5" accept="image/*" onchange="addRowImage('5','SubItem','subItem')">
							<div id="subItemImagePreview5" class="imgwrap"></div>
						</td>
					</tr>
				</tbody>
			</table>
			<br />
			<br />
			
			<div id="SubItemImagePreview" class="imgwrap"></div>
			
			<br />
			<br />
			<aui:button cssClass="btn btn-info btn-sm" name="addSpeakerButton" type="button"
				value="Add Speaker" onClick="showRow('speakersDataTable','Speakers','speaker')" />
			<aui:button cssClass="btn btn-default btn-sm" name="deleteSpeakerButton" type="button"
				value="Delete Speaker" onClick="hideRow('speakersDataTable','Speakers','speaker')" />
			<br />
			<br />
			<table id="speakersDataTable" width="100%" class="table table-striped">
				<thead>
					<tr>
						<th></th>
						<th>Speaker</th>
						<th>Description</th>
						<th>Email</th>
						<th>Image</th>
					</tr>
				</thead>
				<tbody>
					<tr id="speakerRow1">
						<td><input type="checkbox" ></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('speakersDataTable','Speakers','speaker')" placeholder="Speaker"></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('speakersDataTable','Speakers','speaker')" placeholder="Description"></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('speakersDataTable','Speakers','speaker')"  placeholder="Email"></td>
						<td>
							<input type="file" name="pic" id="speakerImage1" accept="image/*" onchange="addRowImage('1','Speaker','speaker')">
							<div id="speakerImagePreview1" class="imgwrap"></div>
						</td>
					</tr>
					<tr id="speakerRow2" style='display:none'>
						<td><input type="checkbox" ></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('speakersDataTable','Speakers','speaker')" placeholder="Speaker"></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('speakersDataTable','Speakers','speaker')" placeholder="Description"></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('speakersDataTable','Speakers','speaker')" placeholder="Email"></td>
						<td>
							<input type="file" name="pic" id="speakerImage2" accept="image/*" onchange="addRowImage('2','Speaker','speaker')">
							<div id="speakerImagePreview2" class="imgwrap"></div>
						</td>
					</tr>
					<tr id="speakerRow3" style='display:none'>
						<td><input type="checkbox" ></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('speakersDataTable','Speakers','speaker')" placeholder="Speaker"></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('speakersDataTable','Speakers','speaker')" placeholder="Description"></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('speakersDataTable','Speakers','speaker')" placeholder="Email"></td>
						<td>
							<input type="file" name="pic" id="speakerImage3" accept="image/*" onchange="addRowImage('3','Speaker','speaker')">
							<div id="speakerImagePreview3" class="imgwrap"></div>
						</td>
					</tr>
					<tr id="speakerRow4" style='display:none'>
						<td><input type="checkbox" ></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('speakersDataTable','Speakers','speaker')" placeholder="Speaker"></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('speakersDataTable','Speakers','speaker')" placeholder="Description"></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('speakersDataTable','Speakers','speaker')" placeholder="Email"></td>
						<td>
							<input type="file" name="pic" id="speakerImage4" accept="image/*" onchange="addRowImage('4','Speaker','speaker')">
							<div id="speakerImagePreview4" class="imgwrap"></div>
						</td>
					</tr>
					<tr id="speakerRow5" style='display:none'>
						<td><input type="checkbox" ></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('speakersDataTable','Speakers','speaker')" placeholder="Speaker"></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('speakersDataTable','Speakers','speaker')" placeholder="Description"></td>
						<td><input type="text" style='width:100%;border: 0;' onchange="checkShowedRow('speakersDataTable','Speakers','speaker')" placeholder="Email"></td>
						<td>
							<input type="file" name="pic" id="speakerImage5" accept="image/*" onchange="addRowImage('5','Speaker','speaker')">
							<div id="speakerImagePreview5" class="imgwrap"></div>
						</td>
					</tr>
				</tbody>
			</table>
			<br />
			<br />
			
			<div id="SpeakerImagePreview" class="imgwrap"></div>
			
			<!-- end amr customization -->
			
			
			<aui:input defaultLanguageId="<%= themeDisplay.getLanguageId() %>" name="description" />
		</aui:fieldset>

		<aui:fieldset markupView="lexicon">
			<liferay-ui:panel-container
				extended="<%= true %>"
				id="calendarBookingDetailsPanelContainer"
				persistState="<%= true %>"
			>
				<liferay-ui:panel
					collapsible="<%= true %>"
					defaultState="closed"
					extended="<%= false %>"
					id="calendarBookingDetailsPanel"
					markupView="lexicon"
					persistState="<%= true %>"
					title="details"
				>
					<aui:select label="calendar" name="calendarId">

						<%
						for (Calendar curCalendar : manageableCalendars) {
							if ((calendarBooking != null) && (curCalendar.getCalendarId() != calendarId) && (CalendarBookingLocalServiceUtil.getCalendarBookingsCount(curCalendar.getCalendarId(), calendarBooking.getParentCalendarBookingId()) > 0)) {
								continue;
							}

							CalendarResource curCalendarResource = curCalendar.getCalendarResource();

							String calendarName = curCalendar.getName(locale);
							String calendarResourceName = curCalendarResource.getName(locale);

							if (!calendarName.equals(calendarResourceName)) {
								calendarName = calendarResourceName + StringPool.SPACE + StringPool.DASH + StringPool.SPACE + calendarName;
							}
						%>

							<aui:option selected="<%= curCalendar.getCalendarId() == calendarId %>" value="<%= curCalendar.getCalendarId() %>"><%= HtmlUtil.escape(calendarName) %></aui:option>

						<%
						}
						%>

					</aui:select>

					<aui:input name="location" />
					
					<aui:input name="LocationLink" />

					<liferay-expando:custom-attributes-available
						className="<%= CalendarBooking.class.getName() %>">
						<liferay-expando:custom-attribute-list
							className="<%= CalendarBooking.class.getName() %>"
							classPK="<%= (calendarBooking != null) ? calendarBooking.getCalendarBookingId() : 0 %>"
							editable="<%= true %>"
							label="<%= true %>"
						/>
					</liferay-expando:custom-attributes-available>

                 
					<%-- <c:if test="<%= calendarBooking == null %>">
						<aui:field-wrapper label="permissions">
							<liferay-ui:input-permissions
								modelName="<%= CalendarBooking.class.getName() %>"
							/>
						</aui:field-wrapper>
					</c:if> --%>
				</liferay-ui:panel>

				<liferay-ui:panel
					collapsible="<%= true %>"
					defaultState="closed"
					extended="<%= false %>"
					id="calendarBookingInvitationPanel"
					markupView="lexicon"
					persistState="<%= true %>"
					title="invitations"
				>
					<c:if test="<%= invitable %>">
						<aui:input inputCssClass="calendar-portlet-invite-resources-input" label="" name="inviteResource" placeholder="add-people-sites-rooms" type="text" />

						<div class="separator"><!-- --></div>
					</c:if>

					<aui:row cssClass="calendar-booking-invitations">
						<aui:col width="<%= (calendarBooking != null) ? 25 : 33 %>">
							<label class="field-label">
								<liferay-ui:message key="pending[calendar]" /> (<span id="<portlet:namespace />pendingCounter"><%= pendingCalendarsJSONArray.length() %></span>)
							</label>

							<div class="calendar-portlet-calendar-list" id="<portlet:namespace />calendarListPending"></div>
						</aui:col>

						<aui:col width="<%= (calendarBooking != null) ? 25 : 33 %>">
							<label class="field-label">
								<liferay-ui:message key="accepted" /> (<span id="<portlet:namespace />acceptedCounter"><%= acceptedCalendarsJSONArray.length() %></span>)
							</label>

							<div class="calendar-portlet-calendar-list" id="<portlet:namespace />calendarListAccepted"></div>
						</aui:col>

						<aui:col width="<%= (calendarBooking != null) ? 25 : 33 %>">
							<label class="field-label">
								<liferay-ui:message key="declined" /> (<span id="<portlet:namespace />declinedCounter"><%= declinedCalendarsJSONArray.length() %></span>)
							</label>

							<div class="calendar-portlet-calendar-list" id="<portlet:namespace />calendarListDeclined"></div>
						</aui:col>

						<c:if test="<%= calendarBooking != null %>">
							<aui:col width="<%= 25 %>">
								<label class="field-label">
									<liferay-ui:message key="maybe" /> (<span id="<portlet:namespace />maybeCounter"><%= maybeCalendarsJSONArray.length() %></span>)
								</label>

								<div class="calendar-portlet-calendar-list" id="<portlet:namespace />calendarListMaybe"></div>
							</aui:col>
						</c:if>

						<aui:col width="<%= 100 %>">
							<div class="calendar-portlet-list-header toggler-header-collapsed" id="<portlet:namespace />checkAvailability">
								<span class="calendar-portlet-list-arrow"></span>

								<span class="calendar-portlet-list-text"><liferay-ui:message key="resources-availability" /></span>
							</div>

							<div class="calendar-portlet-availability">
								<div class="toggler-content-collapsed" id="<portlet:namespace />schedulerContainer">
									<div id="<portlet:namespace />message"></div>

									<liferay-util:include page="/scheduler.jsp" servletContext="<%= application %>">
										<liferay-util:param name="activeView" value="<%= activeView %>" />
										<liferay-util:param name="date" value="<%= String.valueOf(startTime) %>" />
										<liferay-util:param name="filterCalendarBookings" value='<%= renderResponse.getNamespace() + "filterCalendarBookings" %>' />
										<liferay-util:param name="hideAgendaView" value="<%= Boolean.TRUE.toString() %>" />
										<liferay-util:param name="hideMonthView" value="<%= Boolean.TRUE.toString() %>" />
										<liferay-util:param name="preventPersistence" value="<%= Boolean.TRUE.toString() %>" />
										<liferay-util:param name="readOnly" value="<%= Boolean.TRUE.toString() %>" />
									</liferay-util:include>
								</div>
							</div>
						</aui:col>
					</aui:row>
				</liferay-ui:panel>

				<liferay-ui:panel
					collapsible="<%= true %>"
					defaultState="closed"
					extended="<%= false %>"
					id="calendarBookingReminderPanel"
					markupView="lexicon"
					persistState="<%= true %>"
					title="reminders"
				>
					<div class="calendar-booking-reminders" id="<portlet:namespace />reminders"></div>
				</liferay-ui:panel>
<!-- stopped by jean -->
<%-- 				<liferay-ui:panel
					collapsible="<%= true %>"
					defaultState="closed"
					extended="<%= false %>"
					id="calendarBookingCategorizationPanel"
					markupView="lexicon"
					persistState="<%= true %>"
					title="categorization"
				>
					<liferay-asset:asset-categories-selector
						className="<%= CalendarBooking.class.getName() %>"
						classPK="<%= calendarBookingId %>"
					/>

					<liferay-asset:asset-tags-selector
						className="<%= CalendarBooking.class.getName() %>"
						classPK="<%= calendarBookingId %>"
					/>
				</liferay-ui:panel> --%>
				
                <!-- stopped by jean -->
				 <liferay-ui:panel
					collapsible="<%= true %>"
					defaultState="closed"
					extended="<%= false %>"
					id="calendarBookingAssetLinksPanel"
					markupView="lexicon"
					persistState="<%= true %>"
					title="related-assets"
				>
					<liferay-asset:input-asset-links
						className="<%= CalendarBooking.class.getName() %>"
						classPK="<%= calendarBookingId %>"
					/>
				</liferay-ui:panel> 
				
			</liferay-ui:panel-container>
		</aui:fieldset>

		<%@ include file="/calendar_booking_recurrence_container.jspf" %>
	</div>

	<aui:button-row cssClass="d-block">
		<div class="alert alert-info <%= (hasWorkflowDefinitionLink && approved) ? StringPool.BLANK : "hide" %>" id="<portlet:namespace />approvalProcessAlert">
			<liferay-ui:message arguments="<%= ResourceActionsUtil.getModelResource(locale, CalendarBooking.class.getName()) %>" key="this-x-is-approved.-publishing-these-changes-will-cause-it-to-be-unpublished-and-go-through-the-approval-process-again" translateArguments="<%= false %>" />
		</div>

		<%
		String publishButtonLabel = "publish";

		if (hasWorkflowDefinitionLink) {
			publishButtonLabel = "submit-for-publication";
		}
		%>

		<aui:button cssClass="ml-0" name="publishButton" type="submit" value="<%= publishButtonLabel %>" />

		<aui:button name="saveButton" primary="<%= false %>" type="submit" value="save-as-draft" />

		<%-- <c:if test="<%= calendarBooking != null %>">
			<liferay-security:permissionsURL
				modelResource="<%= CalendarBooking.class.getName() %>"
				modelResourceDescription="<%= calendarBooking.getTitle(locale) %>"
				redirect="<%= redirectURL %>"
				resourceGroupId="<%= calendarBooking.getGroupId() %>"
				resourcePrimKey="<%= String.valueOf(calendarBooking.getCalendarBookingId()) %>"
				var="permissionsCalendarBookingURL"
			/>

			<aui:button href="<%= permissionsCalendarBookingURL %>" value="permissions" />
		</c:if> --%>
	</aui:button-row>
</aui:form>

<aui:script>
 
 
 
 <portlet:defineObjects />   
<liferay-portlet:resourceURL var="resourceUrl1" >
	<liferay-portlet:param name="param1" value="Value1"/>
</liferay-portlet:resourceURL>


    function previewFile()
    {
		debugger;
        var filesSelected = document.getElementById("ipoadImageId").files;
         if (filesSelected.length > 0) {
      var fileToLoad = filesSelected[0];

      var fileReader = new FileReader();

      fileReader.onload = function(fileLoadedEvent) {
        var srcData = fileLoadedEvent.target.result; // <--- data: base64

        var newImage = document.createElement('img');
        newImage.setAttribute("id", "imageId1");
        newImage.src = srcData;
        //alert(srcData);
        document.getElementById("previewImgId").innerHTML = newImage.outerHTML;
       // $("input[name$='_ExpandoAttribute--UploadImageId--']").val(document.getElementById("previewImgId").innerHTML);
       
       $("textarea[name$=_ExpandoAttribute--UploadImageId--]").val(srcData);
			   
      // document.getElementById("_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_vtIFYYNsqzER_eada___UploadImageId").value = srcData;
      //   $('[id^=UploadImageId]').value =srcData;
      //   $("input[name$=_ExpandoAttribute--UploadImageId--]").value = srcData;
      
   //   $("input[name$=_ExpandoAttribute--UploadImageId--]").value = srcData ;
     
     
      }
      fileReader.readAsDataURL(fileToLoad);
      }
	}
	
	function base64ToArrayBuffer(base64) 
	{
	debugger;
	    var binaryString = window.atob(base64);
	    var binaryLen = binaryString.length;
	    var bytes = new Uint8Array(binaryLen);
	    for (var i = 0; i < binaryLen; i++) {
	       var ascii = binaryString.charCodeAt(i);
	       bytes[i] = ascii;
	    }
	    return bytes;
	 }

	function <portlet:namespace />filterCalendarBookings(calendarBooking) {
		return calendarBooking.calendarBookingId !== '<%= calendarBookingId %>';
	}

	function <portlet:namespace />resolver(data) {
		var A = AUI();

		var answers = data.answers;

		if (!answers.cancel) {
			A.one('#<portlet:namespace />allFollowing').val(!!answers.allFollowing);
			A.one('#<portlet:namespace />updateCalendarBookingInstance').val(!!answers.updateInstance);

			submitForm(document.<portlet:namespace />fm);
		}
	}

	Liferay.provide(
		window,
		'<portlet:namespace />updateCalendarBooking',
		function() {
			var A = AUI();

			<c:if test="<%= invitable %>">
				var calendarContainer = Liferay.component('<portlet:namespace />calendarContainer');

				var childCalendarIds = A.Object.keys(calendarContainer.get('availableCalendars'));

				var calendarId = A.one('#<portlet:namespace />calendarId').val();

				A.Array.remove(childCalendarIds, A.Array.indexOf(childCalendarIds, calendarId));

				A.one('#<portlet:namespace />childCalendarIds').val(childCalendarIds.join(','));

				A.one('#<portlet:namespace />reinvitableCalendarIds').val(<portlet:namespace />reinvitableCalendarIds.join(','));
			</c:if>

			Liferay.CalendarMessageUtil.promptSchedulerEventUpdate(
				{
					calendarName: '<%= HtmlUtil.escapeJS(calendar.getName(locale)) %>',
					hasChild: <%= hasChildCalendarBookings %>,
					masterBooking: <%= masterBooking %>,
					recurring: <%= recurring %>,
					resolver: <portlet:namespace />resolver
				}
			);
		},
		['liferay-calendar-message-util', 'json']
	);

	Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />title);

	<%
	String titleCurrentValue = ParamUtil.getString(request, "titleCurrentValue");
	%>

	<c:if test="<%= Validator.isNotNull(titleCurrentValue) && ((calendarBooking == null) || !Objects.equals(titleCurrentValue, calendarBooking.getTitle(locale))) %>">
		document.<portlet:namespace />fm.<portlet:namespace />title.value = '<%= HtmlUtil.escapeJS(titleCurrentValue) %>';
		document.<portlet:namespace />fm.<portlet:namespace />title_<%= themeDisplay.getLanguageId() %>.value = '<%= HtmlUtil.escapeJS(titleCurrentValue) %>';
	</c:if>
</aui:script>

<aui:script use="json,liferay-calendar-date-picker-sanitizer,liferay-calendar-interval-selector,liferay-calendar-interval-selector-scheduler-event-link,liferay-calendar-list,liferay-calendar-recurrence-util,liferay-calendar-reminders,liferay-calendar-simple-menu,liferay-calendar-util">
	var calendarContainer = Liferay.component('<portlet:namespace />calendarContainer');

	var defaultCalendarId = <%= calendarId %>;

	var scheduler = window.<portlet:namespace />scheduler;

	A.one('#<portlet:namespace />saveButton').on(
		'click',
		function() {
			A.one('#<portlet:namespace />workflowAction').val('<%= WorkflowConstants.ACTION_SAVE_DRAFT %>');
		}
	);

	A.one('#<portlet:namespace />publishButton').on(
		'click',
		function() {
			A.one('#<portlet:namespace />workflowAction').val('<%= WorkflowConstants.ACTION_PUBLISH %>');
		}
	);

	var syncCalendarsMap = function() {
		calendarContainer.syncCalendarsMap(
			[
				window.<portlet:namespace />calendarListAccepted,
				window.<portlet:namespace />calendarListDeclined,

				<c:if test="<%= calendarBooking != null %>">
					window.<portlet:namespace />calendarListMaybe,
				</c:if>

				window.<portlet:namespace />calendarListPending
			]
		);

		A.each(
			calendarContainer.get('availableCalendars'),
			function(item, index) {
				item.set('disabled', true);
			}
		);
	};

	var calendarsMenu = calendarContainer.getCalendarsMenu(
		{
			content: '#<portlet:namespace />schedulerContainer',
			defaultCalendarId: defaultCalendarId,
			header: '#<portlet:namespace />checkAvailability',
			invitable: <%= invitable %>,
			scheduler: scheduler
		}
	);

	window.<portlet:namespace />calendarListPending = new Liferay.CalendarList(
		{
			after: {
				calendarsChange: function(event) {
					var instance = this;

					A.one('#<portlet:namespace />pendingCounter').html(event.newVal.length);

					syncCalendarsMap();

					scheduler.load();
				},
				'scheduler-calendar:visibleChange': syncCalendarsMap
			},
			boundingBox: '#<portlet:namespace />calendarListPending',
			calendars: <%= pendingCalendarsJSONArray %>,
			scheduler: <portlet:namespace />scheduler,
			simpleMenu: calendarsMenu,
			strings: {
				emptyMessage: '<liferay-ui:message key="no-pending-invites" />'
			}
		}
	).render();

	window.<portlet:namespace />calendarListAccepted = new Liferay.CalendarList(
		{
			after: {
				calendarsChange: function(event) {
					var instance = this;

					A.one('#<portlet:namespace />acceptedCounter').html(event.newVal.length);

					syncCalendarsMap();

					scheduler.load();
				},
				'scheduler-calendar:visibleChange': syncCalendarsMap
			},
			boundingBox: '#<portlet:namespace />calendarListAccepted',
			calendars: <%= acceptedCalendarsJSONArray %>,
			scheduler: <portlet:namespace />scheduler,
			simpleMenu: calendarsMenu,
			strings: {
				emptyMessage: '<liferay-ui:message key="no-accepted-invites" />'
			}
		}
	).render();

	window.<portlet:namespace />reinvitableCalendarIds = [];

	window.<portlet:namespace />calendarListDeclined = new Liferay.CalendarList(
		{
			after: {
				calendarRemoved: function(event) {
					var calendar = event.calendar;

					if (calendar) {
						var calendarId = calendar.get('calendarId');

						window.<portlet:namespace />reinvitableCalendarIds.push(calendarId);
					}
				},
				calendarsChange: function(event) {
					var instance = this;

					A.one('#<portlet:namespace />declinedCounter').html(event.newVal.length);

					syncCalendarsMap();

					scheduler.load();
				},
				'scheduler-calendar:visibleChange': syncCalendarsMap
			},
			boundingBox: '#<portlet:namespace />calendarListDeclined',
			calendars: <%= declinedCalendarsJSONArray %>,
			scheduler: <portlet:namespace />scheduler,
			simpleMenu: calendarsMenu,
			strings: {
				emptyMessage: '<liferay-ui:message key="no-declined-invites" />'
			}
		}
	).render();

	<c:if test="<%= calendarBooking != null %>">
		window.<portlet:namespace />calendarListMaybe = new Liferay.CalendarList(
			{
				after: {
					calendarsChange: function(event) {
						var instance = this;

						A.one('#<portlet:namespace />maybeCounter').html(event.newVal.length);

						syncCalendarsMap();

						scheduler.load();
					},
					'scheduler-calendar:visibleChange': syncCalendarsMap
				},
				boundingBox: '#<portlet:namespace />calendarListMaybe',
				calendars: <%= maybeCalendarsJSONArray %>,
				scheduler: <portlet:namespace />scheduler,
				simpleMenu: calendarsMenu,
				strings: {
					emptyMessage: '<liferay-ui:message key="no-outstanding-invites" />'
				}
			}
		).render();
	</c:if>

	syncCalendarsMap();

	new Liferay.DatePickerSanitizer(
		{
			datePickers: [
				Liferay.component('<portlet:namespace />endTimeDatePicker'),
				Liferay.component('<portlet:namespace />endTimeDatePicker')
			],
			defaultDate: new Date(<%= endTimeYear %>, <%= endTimeMonth %>, <%= endTimeDay %>, <%= endTimeHour %>, <%= endTimeMinute %>),
			maximumDate: new Date(2099, 11, 31, 23, 59, 59, 999),
			minimumDate: new Date(0)
		}
	);

	var intervalSelector = new Liferay.IntervalSelector(
		{
			endDatePicker: Liferay.component('<portlet:namespace />endTimeDatePicker'),
			endTimePicker: Liferay.component('<portlet:namespace />endTimeTimeTimePicker'),
			startDatePicker: Liferay.component('<portlet:namespace />startTimeDatePicker'),
			startTimePicker: Liferay.component('<portlet:namespace />startTimeTimeTimePicker')
		}
	);

	var placeholderSchedulerEvent = new Liferay.SchedulerEvent(
		{
			borderColor: '#000',
			borderStyle: 'dashed',
			borderWidth: '2px',
			color: '#F8F8F8',
			content: '',
			editingEvent: true,
			endDate: new Date(<%= endTimeYear %>, <%= endTimeMonth %>, <%= endTimeDay %>, <%= endTimeHour %>, <%= endTimeMinute %>),
			preventDateChange: true,
			scheduler: scheduler,
			startDate: new Date(<%= startTimeYear %>, <%= startTimeMonth %>, <%= startTimeDay %>, <%= startTimeHour %>, <%= startTimeMinute %>)
		}
	);

	new Liferay.IntervalSelectorSchedulerEventLink(
		{
			intervalSelector: intervalSelector,
			schedulerEvent: placeholderSchedulerEvent
		}
	);

	scheduler.after(
		'*:load',
		function(event) {
			scheduler.addEvents(placeholderSchedulerEvent);

			scheduler.syncEventsUI();
		}
	);

	<c:if test="<%= invitable %>">
		var manageableCalendars = {};

		<%= CalendarUtil.toCalendarsJSONArray(themeDisplay, manageableCalendars) %>.forEach(
			function(item, index) {
				manageableCalendars[item.calendarId] = item;
			}
		);

		A.one('#<portlet:namespace />calendarId').on(
			'valueChange',
			function(event) {
				var calendarId = parseInt(event.target.val(), 10);

				var calendar = manageableCalendars[calendarId];

				[
					<portlet:namespace />calendarListAccepted,
					<portlet:namespace />calendarListDeclined,

					<c:if test="<%= calendarBooking != null %>">
						<portlet:namespace />calendarListMaybe,
					</c:if>

					<portlet:namespace />calendarListPending
				].forEach(
					function(calendarList) {
						calendarList.remove(calendarList.getCalendar(calendarId));
						calendarList.remove(calendarList.getCalendar(defaultCalendarId));
					}
				);

				<portlet:namespace />calendarListPending.add(calendar);

				defaultCalendarId = calendarId;

				if (calendar.hasWorkflowDefinitionLink) {
					A.one('#<portlet:namespace />approvalProcessAlert').toggleClass('hide', <%= !approved %>);
					A.one('#<portlet:namespace />publishButton').setContent('<%= HtmlUtil.escapeJS(LanguageUtil.get(request, "submit-for-publication")) %>');
				}
				else {
					A.one('#<portlet:namespace />approvalProcessAlert').toggleClass('hide', true);
					A.one('#<portlet:namespace />publishButton').setContent('<%= HtmlUtil.escapeJS(LanguageUtil.get(request, "publish")) %>');
				}
			}
		);

		var inviteResourcesInput = A.one('#<portlet:namespace />inviteResource');

		<liferay-portlet:resourceURL copyCurrentRenderParameters="<%= false %>" id="calendarResources" var="calendarResourcesURL" />

		calendarContainer.createCalendarsAutoComplete(
			'<%= calendarResourcesURL %>',
			inviteResourcesInput,
			function(event) {
				var calendar = event.result.raw;

				calendar.disabled = true;

				addToList(calendar);

				inviteResourcesInput.val('');
			}
		);

		var addToList = function(calendar) {
			if (calendar.classNameId == <%= ClassNameLocalServiceUtil.getClassNameId(CalendarResource.class) %>) {
				var remoteServices = Liferay.component('<portlet:namespace />remoteServices');

				remoteServices.hasExclusiveCalendarBooking(
					calendar.calendarId,
					placeholderSchedulerEvent.get('startDate'),
					placeholderSchedulerEvent.get('endDate'),
					function(result) {
						if (result) {
							<portlet:namespace />calendarListDeclined.add(calendar);
						}
						else {
							<portlet:namespace />calendarListPending.add(calendar);
						}
					}
				);
			}
			else {
				<portlet:namespace />calendarListPending.add(calendar);
			}
		};
	</c:if>

	window.<portlet:namespace />reminders = new Liferay.Reminders(
		{
			portletNamespace: '<portlet:namespace />',
			render: '#<portlet:namespace />reminders',
			values: [
				{
					interval: <%= firstReminder %>,
					type: '<%= HtmlUtil.escapeJS(firstReminderType) %>'
				},
				{
					interval: <%= secondReminder %>,
					type: '<%= HtmlUtil.escapeJS(secondReminderType) %>'
				}
			]
		}
	);

	var allDayCheckbox = A.one('#<portlet:namespace />allDay');

	<%
	defaultEndTimeJCalendar = (java.util.Calendar)defaultStartTimeJCalendar.clone();

	defaultEndTimeJCalendar.add(java.util.Calendar.MINUTE, defaultDuration);
	%>

	allDayCheckbox.after(
		'click',
		function() {
			var endDateContainer = A.one('#<portlet:namespace />endDateContainer');
			var startDateContainer = A.one('#<portlet:namespace />startDateContainer');

			var endTimeHours;
			var endTimeMinutes;
			var startTimeHours;
			var startTimeMinutes;

			var checked = allDayCheckbox.get('checked');

			if (checked) {
				placeholderSchedulerEvent.set('allDay', true);

				startTimeHours = 0;
				startTimeMinutes = 0;
				endTimeHours = 23;
				endTimeMinutes = 59;
			}
			else {
				placeholderSchedulerEvent.set('allDay', false);

				endDateContainer.show();

				startTimeHours = <%= defaultStartTimeJCalendar.get(java.util.Calendar.HOUR_OF_DAY) %>;
				startTimeMinutes = <%= defaultStartTimeJCalendar.get(java.util.Calendar.MINUTE) %>;
				endTimeHours = <%= defaultEndTimeJCalendar.get(java.util.Calendar.HOUR_OF_DAY) %>;
				endTimeMinutes = <%= defaultEndTimeJCalendar.get(java.util.Calendar.MINUTE) %>;
			}

			updateTimePickersValues(startTimeHours, startTimeMinutes, endTimeHours, endTimeMinutes);

			endDateContainer.toggleClass('allday-class-active', checked);
			startDateContainer.toggleClass('allday-class-active', checked);

			scheduler.syncEventsUI();
		}
	);

	var updateTimePickersValues = function(startTimeHours, startTimeMinutes, endTimeHours, endTimeMinutes) {
		var endDatePicker = intervalSelector.get('endDatePicker');
		var startDatePicker = intervalSelector.get('startDatePicker');

		var endDate = endDatePicker.getDate();
		var startDate = startDatePicker.getDate();

		startDate.setHours(startTimeHours);
		startDate.setMinutes(startTimeMinutes);

		endDate.setHours(endTimeHours);
		endDate.setMinutes(endTimeMinutes);

		intervalSelector.setDuration(endDate.valueOf() - startDate.valueOf());

		var endTimePicker = intervalSelector.get('endTimePicker');
		var startTimePicker = intervalSelector.get('startTimePicker');

		startTimePicker.selectDates([startDate]);
		endTimePicker.selectDates([endDate]);
	};

	scheduler.load();
</aui:script>

<!-- custom Code start jean -->
<script>
function changeform()
{
	debugger;
	console.log($(".form-control.form-id").val());
	$("input[name$=_ExpandoAttribute--FormId--]").val($(".form-control.form-id").val());
	console.log($("input[name$=_ExpandoAttribute--FormId--]").val());
// 	$("input[name$='_ExpandoAttribute--FormId--']").val($(".Form-id").val());
}

function changeImage()
{
	debugger;
	var newImage = document.createElement('img');
    newImage.setAttribute("id", "imageId1");
    newImage.src  = $("textarea[name$=_ExpandoAttribute--UploadImageId--]").val();
    document.getElementById("previewImgId").innerHTML = newImage.outerHTML;
}

$( document ).ready(function() 
{
	debugger;
	
	     $("input[name$='ExpandoAttribute--FormId--']").css("display","none");
	     
	     $("textarea[name$='<portlet:namespace />location']").css("height","30px");
	     
	     /* $('label[for ="_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_PfOEREvdCGVQ_cclo___UploadImageId"]').css("display","none");
	     $('input[name ="_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_PfOEREvdCGVQ_ExpandoAttribute--Location Text--"]').css("display","none");
	     $('textarea[name ="_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_PfOEREvdCGVQ_ExpandoAttribute--UploadImageId--"]').css("display","none");
	     
	     $('select[name ="_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_PfOEREvdCGVQ_calendarId"]').css("display","none");
	     $('label[for ="_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_PfOEREvdCGVQ_calendarId"]').css("display","none");
	     $('a[aria-controls ="calendarBookingDetailsPanelContent"]').css("display","none"); */
	     
	   /*   $('input[name ="_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_PfOEREvdCGVQ_ExpandoAttributeName--show on landing--"]').css("display","block");
	     
	     
	     $('input[name ="_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_PfOEREvdCGVQ_ExpandoAttributeName--show on landing--"]')[0].type="label";
	    */  
	   /*   $("#calendarBookingInvitationPanel").css("display","none");
	     $("#calendarBookingReminderPanel").css("display","none"); */
	     $("#calendarBookingAssetLinksPanel").css("display","none");
	     //$("#_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_PfOEREvdCGVQ_scch___Numbers").css("display","none")
	     
	debugger;
		if($("input[name$='_ExpandoAttribute--FormId--']").val() == "")
			changeform();
		else
		{
			$(".form-id").val($("input[name$='_ExpandoAttribute--FormId--']").val());
		}
		//_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_PfOEREvdCGVQ_eada___UploadImageId
		//_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_PfOEREvdCGVQ_eada___UploadImageId
		//if(document.getElementById("_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_vtIFYYNsqzER_eada___UploadImageId").value != "")
			if($("textarea[name$=_ExpandoAttribute--UploadImageId--]").val()!="") 
			     changeImage();

			$("input:radio").on('click', function() {
				  // in the handler, 'this' refers to the box clicked on
				  var $box = $(this);
				  if ($box.is(":checked")) {
				    // the name of the box is retrieved using the .attr() method
				    // as it is assumed and expected to be immutable
				    var group = "input:radio[name='showHorizontallayer1']";
				    // the checked state of the group/box on the other hand will change
				    // and the current value is retrieved using .prop() method
				    $(group).prop("checked", false);
				    $box.prop("checked", true);
				  } else {
				    $box.prop("checked", false);
				  }
				});
		
	
});
</script>
<!-- custom Code end -->