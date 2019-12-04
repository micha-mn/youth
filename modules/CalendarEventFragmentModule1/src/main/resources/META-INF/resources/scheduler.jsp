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
<%@ page import="com.liferay.portal.kernel.dao.jdbc.DataAccess" %>
<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.Format" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQuery" %>
<style>
div > div.col-xs-5.form-inline.scheduler-base-views.yui3-widget.btn-group.btn-group-content > button {
    display: none;
}
div > div.portlet-content-container > div > div.container-fluid.calendar-portlet-column-parent > div > div > div > div > div.yui3-widget-bd {
    height: 0px!important;
    font-size: 0;
}
.portlet-layout .portlet .portlet-title-text {
    color: #6B6C7E;
    font-size: 0.875rem;
    font-weight: 600;
    line-height: 2.2;
    margin-bottom: 0;
    text-transform: uppercase;
}
.autofit-float.autofit-row.portlet-header {
    display: none;
}
</style>
<%
String activeView = ParamUtil.getString(request, "activeView", sessionClicksDefaultView);
long date = ParamUtil.getLong(request, "date", System.currentTimeMillis());
String editCalendarBookingURL = ParamUtil.getString(request, "editCalendarBookingURL");
String filterCalendarBookings = ParamUtil.getString(request, "filterCalendarBookings", null);
boolean hideAgendaView = ParamUtil.getBoolean(request, "hideAgendaView");
boolean hideDayView = ParamUtil.getBoolean(request, "hideDayView");
boolean hideMonthView = ParamUtil.getBoolean(request, "hideMonthView");
boolean hideWeekView = ParamUtil.getBoolean(request, "hideWeekView");
String permissionsCalendarBookingURL = ParamUtil.getString(request, "permissionsCalendarBookingURL");
boolean preventPersistence = ParamUtil.getBoolean(request, "preventPersistence");
boolean readOnly = ParamUtil.getBoolean(request, "readOnly");
boolean showAddEventBtn = ParamUtil.getBoolean(request, "showAddEventBtn");
boolean showSchedulerHeader = ParamUtil.getBoolean(request, "showSchedulerHeader", true);
String viewCalendarBookingURL = ParamUtil.getString(request, "viewCalendarBookingURL");
hideDayView = false;

//System.out.println("editCalendarBookingURL:: "+editCalendarBookingURL);
  
/*
java.sql.Connection con = null;
java.sql.Statement st = null;
String data_ = "";
int BUFFER_SIZE = 1024;
StringBuffer buffer = new StringBuffer();
int numRead ;

String sqlStatement = "";
String userId = request.getRemoteUser();
Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
List<CalendarBooking> cbLst = null;
String stratDate="",endDate="";

try
{
	 String stringdate ="";
     String startDate = "";
	 con = DataAccess.getConnection();
	 st = con.createStatement();
	 sqlStatement = "select starttime,"+
	                       " endtime,"+
	                         "status ,"+
			               " SUBSTRING_INDEX(LEFT(title, LOCATE('</Title>', title)-1),'>',-1) AS title "+
			          " from CalendarBooking ca where userId = "+userId;
	 java.sql.ResultSet rs = st.executeQuery(sqlStatement);
	 
	 JSONObject json = JSONFactoryUtil.createJSONObject();
	 JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
	 while (rs.next()) 
	 {
		 
		 
		 json.put("status",rs.getString("status"));
		 json.put("title",rs.getString("title"));
		 startDate = format.format(Long.valueOf(rs.getString("starttime")));
		 endDate = format.format(Long.valueOf(rs.getString("starttime")));
		 json.put("startDate",rs.getString("starttime"));
		 json.put("endDate",rs.getString("endtime"));
		 jsonArr.put(json);
     }
	 
	 System.out.println("getFetchSize:: "+jsonArr);
	 DynamicQuery dq = com.liferay.calendar.service.CalendarBookingLocalServiceUtil.dynamicQuery();
	 cbLst = (List) CalendarBookingLocalServiceUtil.dynamicQuery(dq,0,3);
	 System.out.println("cbLst.size(): "+cbLst.size());
	 
}
catch(Exception ex)
{
	ex.printStackTrace();
}*/



   
	




%>

<div class="calendar-portlet-wrapper" id="<portlet:namespace />scheduler"></div>

<%@ include file="/event_recorder.jspf" %>

<aui:script use="aui-toggler,liferay-calendar-list,liferay-scheduler,liferay-store,json">
	var calendarContainer = Liferay.component('<portlet:namespace />calendarContainer');

	var remoteServices = Liferay.component('<portlet:namespace />remoteServices');

	var showMoreStrings = {
		close: '<liferay-ui:message key="close" />',
		showMore: '<liferay-ui:message key="show-x-more" />'
	};

	<c:if test="<%= !hideDayView %>">
		window.<portlet:namespace />dayView = new Liferay.SchedulerDayView(
			{
				headerViewConfig: {
					eventsOverlayConstrain: '#p_p_id<portlet:namespace />',
					strings: showMoreStrings
				},
				height: 700,
				isoTime: <%= useIsoTimeFormat %>,
				readOnly: <%= readOnly %>,
				strings: {
					allDay: '<liferay-ui:message key="all-day" />'
				}
			}
		);
	</c:if>

	<c:if test="<%= !hideWeekView %>">
		window.<portlet:namespace />weekView = new Liferay.SchedulerWeekView(
			{
				headerViewConfig: {
					displayDaysInterval: A.DataType.DateMath.WEEK_LENGTH,
					eventsOverlayConstrain: '#p_p_id<portlet:namespace />',
					strings: showMoreStrings
				},
				height: 700,
				isoTime: <%= useIsoTimeFormat %>,
				readOnly: <%= readOnly %>,
				strings: {
					allDay: '<liferay-ui:message key="all-day" />'
				}
			}
		);
	</c:if>

	<c:if test="<%= !hideMonthView %>">
		window.<portlet:namespace />monthView = new Liferay.SchedulerMonthView(
			{
				eventsOverlayConstrain: '#p_p_id<portlet:namespace />',
				height: 'auto',
				isoTime: <%= useIsoTimeFormat %>,
				readOnly: <%= readOnly %>,
				strings: showMoreStrings
			}
		);
	</c:if>

	<c:if test="<%= !hideAgendaView %>">
		window.<portlet:namespace />agendaView = new Liferay.SchedulerAgendaView(
			{
				daysCount: 31,
				height: 700,
				isoTime: <%= useIsoTimeFormat %>,
				readOnly: <%= readOnly %>,
				strings: {
					noEvents: '<liferay-ui:message key="no-events" />'
				}
			}
		);
	</c:if>

	<c:if test="<%= !readOnly && (defaultCalendar != null) %>">
		var width = Math.min(Liferay.Util.getWindowWidth(), 550);

		window.<portlet:namespace />eventRecorder = new Liferay.SchedulerEventRecorder(
			{
				bodyTemplate: new A.Template(A.one('#<portlet:namespace />eventRecorderBodyTpl').html()),
				calendarContainer: calendarContainer,
				calendarId: <%= defaultCalendar.getCalendarId() %>,
				color: '<%= ColorUtil.toHexString(defaultCalendar.getColor()) %>',
				duration: <%= defaultDuration %>,
				editCalendarBookingURL: '<%= HtmlUtil.escapeJS(editCalendarBookingURL) %>',
				headerTemplate: new A.Template(A.one('#<portlet:namespace />eventRecorderHeaderTpl').html()),
				permissionsCalendarBookingURL: '<%= HtmlUtil.escapeJS(permissionsCalendarBookingURL) %>',
				popover: {
					width: width
				},
				portletNamespace: '<portlet:namespace />',
				remoteServices: remoteServices,
				showHeader: <%= showSchedulerHeader %>,
				strings: {
					'description-hint': '<liferay-ui:message key="description-hint" />'
				},
				viewCalendarBookingURL: '<%= HtmlUtil.escapeJS(viewCalendarBookingURL) %>'
			}
		);
	</c:if>

	var views = [];

	<c:if test="<%= !hideDayView %>">
		views.push(window.<portlet:namespace />dayView);
	</c:if>

	<c:if test="<%= !hideWeekView %>">
		views.push(window.<portlet:namespace />weekView);
	</c:if>

	<c:if test="<%= !hideMonthView %>">
		views.push(window.<portlet:namespace />monthView);
	</c:if>

	<c:if test="<%= !hideAgendaView %>">
		views.push(window.<portlet:namespace />agendaView);
	</c:if>

	window.<portlet:namespace />scheduler = new Liferay.Scheduler(
		{
			activeView: window['<portlet:namespace /><%= HtmlUtil.escapeJS(activeView) %>View'],
			boundingBox: '#<portlet:namespace />scheduler',
			calendarContainer: calendarContainer,

			<%
			java.util.Calendar nowJCalendar = CalendarFactoryUtil.getCalendar(userTimeZone);

			int nowYear = nowJCalendar.get(java.util.Calendar.YEAR);
			int nowMonth = nowJCalendar.get(java.util.Calendar.MONTH);
			int nowDay = nowJCalendar.get(java.util.Calendar.DAY_OF_MONTH);
			int nowHour = nowJCalendar.get(java.util.Calendar.HOUR_OF_DAY);
			int nowMinute = nowJCalendar.get(java.util.Calendar.MINUTE);
			%>

			currentTime: new Date(<%= nowYear %>, <%= nowMonth %>, <%= nowDay %>, <%= nowHour %>, <%= nowMinute %>),
			currentTimeFn: A.bind(remoteServices.getCurrentTime, remoteServices),

			<%
			java.util.Calendar dateJCalendar = CalendarFactoryUtil.getCalendar(userTimeZone);

			dateJCalendar.setTimeInMillis(date);

			int dateYear = dateJCalendar.get(java.util.Calendar.YEAR);
			int dateMonth = dateJCalendar.get(java.util.Calendar.MONTH);
			int dateDay = dateJCalendar.get(java.util.Calendar.DAY_OF_MONTH);
			%>

			date: new Date(<%= dateYear %>, <%= dateMonth %>, <%= dateDay %>),

			<c:if test="<%= !themeDisplay.isSignedIn() || ((defaultCalendar != null) && !CalendarPermission.contains(themeDisplay.getPermissionChecker(), defaultCalendar, CalendarActionKeys.MANAGE_BOOKINGS)) %>">
				disabled: true,
			</c:if>

			eventRecorder: window.<portlet:namespace />eventRecorder,
			eventsPerPage: <%= eventsPerPage %>,
			filterCalendarBookings: window['<%= HtmlUtil.escapeJS(filterCalendarBookings) %>'],
			firstDayOfWeek: <%= weekStartsOn %>,
			items: A.Object.values(calendarContainer.get('availableCalendars')),
			maxDaysDisplayed: <%= maxDaysDisplayed %>,
			portletNamespace: '<portlet:namespace />',
			preventPersistence: <%= preventPersistence %>,
			remoteServices: remoteServices,
			render: true,
			showAddEventBtn: <%= showAddEventBtn %>,
			showHeader: <%= showSchedulerHeader %>,
			strings: {
				agenda: '<liferay-ui:message key="agenda" />',
				day: '<liferay-ui:message key="day" />',
				month: '<liferay-ui:message key="month" />',
				today: '<liferay-ui:message key="today" />',
				week: '<liferay-ui:message key="week" />',
				year: '<liferay-ui:message key="year" />'
			},

			<%
			java.util.Calendar todayJCalendar = CalendarFactoryUtil.getCalendar(userTimeZone);

			int todayYear = todayJCalendar.get(java.util.Calendar.YEAR);
			int todayMonth = todayJCalendar.get(java.util.Calendar.MONTH);
			int todayDay = todayJCalendar.get(java.util.Calendar.DAY_OF_MONTH);
			%>

			todayDate: new Date(<%= todayYear %>, <%= todayMonth %>, <%= todayDay %>),
			views: views
		}
	);

	var destroySchedulers = function(event) {
		if (event.portletId === '<%= portletDisplay.getId() %>') {
			window.<portlet:namespace />scheduler.destroy();

			Liferay.detach('destroyPortlet', destroySchedulers);
		}
	};

	Liferay.on('destroyPortlet', destroySchedulers);
</aui:script>