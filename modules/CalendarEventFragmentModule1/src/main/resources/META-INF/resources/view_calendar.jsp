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
<%-- 
<%@ page import="com.liferay.portal.kernel.dao.jdbc.DataAccess" %>
<%@ page import="java.util.Date" %>
--%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.liferay.portal.kernel.dao.jdbc.DataAccess"%>
<%@ page
	import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.Disjunction"%>

<%@ page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@ page import="java.text.Format"%>
<%@ page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>

<link
	href="/o/new-misk-theme/css/font/font-awesome/font-awesome.min.css"
	rel="stylesheet" />
<link href="/o/new-misk-theme/css/landing/CustomStyle.css" rel="stylesheet" />
<head>
<style>
</style>
<link href="/o/new-misk-theme/alerts/style-alert.css" rel="stylesheet" />
<script src="/o/new-misk-theme/alerts/sweet-alert.min.js"></script>
<script src="/o/new-misk-theme/js/landing/custom.js"></script>
</head>
<body>
	<div class="manage-calendar container-fluid">
		<div id="participant-section">
			<div id="intro-title" class="container">
				<h3>
					<span style="border-bottom: 2px solid #eee; padding-bottom: 15px;">Eve</span>nts
				</h3>
				<h1>Manage</h1>
			</div>
		</div>
		<%
			String activeView = ParamUtil.getString(request, "activeView", sessionClicksDefaultView);
			long date = ParamUtil.getLong(request, "date", System.currentTimeMillis());

			JSONArray groupCalendarsJSONArray = CalendarUtil.toCalendarsJSONArray(themeDisplay, groupCalendars);
			JSONArray userCalendarsJSONArray = CalendarUtil.toCalendarsJSONArray(themeDisplay, userCalendars);
			JSONArray otherCalendarsJSONArray = CalendarUtil.toCalendarsJSONArray(themeDisplay, otherCalendars);

			boolean columnOptionsVisible = GetterUtil
					.getBoolean(SessionClicks.get(request, "com.liferay.calendar.web_columnOptionsVisible", "true"));
		%>

		<aui:script
			use="liferay-calendar-container,liferay-calendar-remote-services,liferay-component">
	Liferay.component(
		'<portlet:namespace />calendarContainer',
		function() {
			var calendarContainer = new Liferay.CalendarContainer(
				{
					groupCalendarResourceId: <%=groupCalendarResource.getCalendarResourceId()%>,

					<c:if test="<%=userCalendarResource != null%>">
						userCalendarResourceId: <%=userCalendarResource.getCalendarResourceId()%>,
					</c:if>

					namespace: '<portlet:namespace />'
				}
			);

			var destroyInstance = function(event) {
				if (event.portletId === '<%=portletDisplay.getId()%>') {
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
					namespace: '<portlet:namespace />',
					userId: themeDisplay.getUserId()
				}
			);

			var destroyInstance = function(event) {
				if (event.portletId === '<%=portletDisplay.getId()%>') {
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

		<aui:container cssClass="calendar-portlet-column-parent">
			<aui:row>
				<c:if test="<%=!displaySchedulerOnly%>">
					<aui:col
						cssClass='<%="calendar-portlet-column-options "
									+ (columnOptionsVisible ? StringPool.BLANK : "hide")%>'
						id="columnOptions" span="<%=3%>">
						<div class="calendar-portlet-mini-calendar"
							id="<portlet:namespace />miniCalendarContainer"></div>

						<div id="<portlet:namespace />calendarListContainer">
							<div class="calendar-portlet-list">
								<c:if test="<%=themeDisplay.isSignedIn() && showUserEvents%>">
									<div
										class="calendar-portlet-list-header toggler-header-expanded">
										<span class="calendar-portlet-list-arrow"></span> <span
											class="calendar-portlet-list-text"><liferay-ui:message
												key="my-calendars" /></span>
									</div>

									<c:if test="<%=userCalendarResource != null%>">
										<span class="calendar-list-item-arrow calendar-resource-arrow"
											data-calendarResourceId="<%=userCalendarResource.getCalendarResourceId()%>"
											tabindex="0"><i class="icon-caret-down"></i></span>
									</c:if>
								</c:if>

								<div class="calendar-portlet-calendar-list"
									id="<portlet:namespace />myCalendarList"></div>
							</div>

							<div class="calendar-portlet-list">
								<c:if test="<%=showSiteCalendars%>">
									<div
										class="calendar-portlet-list-header toggler-header-expanded">
										<span class="calendar-portlet-list-arrow"></span> <span
											class="calendar-portlet-list-text"><liferay-ui:message
												arguments="<%=new String[]{groupCalendarResource.getName(locale)}%>"
												key="x-calendars" /></span>
									</div>

									<c:if
										test="<%=CalendarResourcePermission.contains(permissionChecker,
											groupCalendarResource, CalendarActionKeys.ADD_CALENDAR)%>">
										<span class="calendar-list-item-arrow calendar-resource-arrow"
											data-calendarResourceId="<%=groupCalendarResource.getCalendarResourceId()%>"
											tabindex="0"><i class="icon-caret-down"></i></span>
									</c:if>

									<div class="calendar-portlet-calendar-list"
										id="<portlet:namespace />siteCalendarList"></div>
								</c:if>
							</div>

							<div class="calendar-portlet-list">
								<c:if test="<%=themeDisplay.isSignedIn()%>">
									<div
										class="calendar-portlet-list-header toggler-header-expanded">
										<span class="calendar-portlet-list-arrow"></span> <span
											class="calendar-portlet-list-text"><liferay-ui:message
												key="other-calendars" /></span>
									</div>

									<div class="calendar-portlet-calendar-list"
										id="<portlet:namespace />otherCalendarList">
										<input class="calendar-portlet-add-calendars-input"
											id="<portlet:namespace />addOtherCalendar"
											placeholder="<liferay-ui:message key="add-other-calendars" />"
											type="text" />
									</div>
								</c:if>
							</div>
						</div>
					</aui:col>
				</c:if>

				<aui:col cssClass="calendar-portlet-column-grid" id="columnGrid"
					span="<%=(columnOptionsVisible && !displaySchedulerOnly) ? 9 : 12%>">
					<c:if test="<%=!displaySchedulerOnly%>">
						<div class="calendar-portlet-column-toggler"
							id="<portlet:namespace />columnToggler">
							<i
								class="<%=columnOptionsVisible ? "icon-caret-left" : "icon-caret-right"%>"
								id="<portlet:namespace />columnTogglerIcon"></i>
						</div>
					</c:if>

					<liferay-util:include page="/scheduler.jsp"
						servletContext="<%=application%>">
						<liferay-util:param name="activeView" value="<%=activeView%>" />
						<liferay-util:param name="date"
							value="<%=String.valueOf(date)%>" />

						<portlet:renderURL var="editCalendarBookingURL"
							windowState="<%=LiferayWindowState.POP_UP.toString()%>">
							<portlet:param name="mvcPath" value="/edit_calendar_booking.jsp" />
							<portlet:param name="activeView" value="{activeView}" />
							<portlet:param name="allDay" value="{allDay}" />
							<portlet:param name="calendarBookingId"
								value="{calendarBookingId}" />
							<portlet:param name="calendarId" value="{calendarId}" />
							<portlet:param name="date" value="{date}" />
							<portlet:param name="endTimeDay" value="{endTimeDay}" />
							<portlet:param name="endTimeHour" value="{endTimeHour}" />
							<portlet:param name="endTimeMinute" value="{endTimeMinute}" />
							<portlet:param name="endTimeMonth" value="{endTimeMonth}" />
							<portlet:param name="endTimeYear" value="{endTimeYear}" />
							<portlet:param name="instanceIndex" value="{instanceIndex}" />
							<portlet:param name="startTimeDay" value="{startTimeDay}" />
							<portlet:param name="startTimeHour" value="{startTimeHour}" />
							<portlet:param name="startTimeMinute" value="{startTimeMinute}" />
							<portlet:param name="startTimeMonth" value="{startTimeMonth}" />
							<portlet:param name="startTimeYear" value="{startTimeYear}" />
							<portlet:param name="titleCurrentValue"
								value="{titleCurrentValue}" />
						</portlet:renderURL>

						<liferay-util:param name="editCalendarBookingURL"
							value="<%=editCalendarBookingURL%>" />

						<liferay-util:param name="hideAgendaView"
							value="<%=String.valueOf(!showAgendaView)%>" />
						<liferay-util:param name="hideDayView"
							value="<%=String.valueOf(!showDayView)%>" />
						<liferay-util:param name="hideWeekView"
							value="<%=String.valueOf(!showWeekView)%>" />
						<liferay-util:param name="hideMonthView"
							value="<%=String.valueOf(!showMonthView)%>" />
						<liferay-util:param name="readOnly"
							value="<%=Boolean.FALSE.toString()%>" />

						<liferay-security:permissionsURL
							modelResource="<%=CalendarBooking.class.getName()%>"
							modelResourceDescription="{modelResourceDescription}"
							resourceGroupId="{resourceGroupId}"
							resourcePrimKey="{resourcePrimKey}"
							var="permissionsCalendarBookingURL"
							windowState="<%=LiferayWindowState.POP_UP.toString()%>" />

						<liferay-util:param name="permissionsCalendarBookingURL"
							value="<%=permissionsCalendarBookingURL%>" />

						<liferay-util:param name="showAddEventBtn"
							value="<%=String.valueOf((defaultCalendar != null) && CalendarPermission
									.contains(permissionChecker, defaultCalendar, CalendarActionKeys.MANAGE_BOOKINGS))%>" />
						<liferay-util:param name="showSchedulerHeader"
							value="<%=String.valueOf(displaySchedulerHeader)%>" />

						<portlet:renderURL var="viewCalendarBookingURL"
							windowState="<%=LiferayWindowState.POP_UP.toString()%>">
							<portlet:param name="mvcPath" value="/view_calendar_booking.jsp" />
							<portlet:param name="calendarBookingId"
								value="{calendarBookingId}" />
							<portlet:param name="instanceIndex" value="{instanceIndex}" />
						</portlet:renderURL>

						<liferay-util:param name="viewCalendarBookingURL"
							value="<%=viewCalendarBookingURL%>" />
					</liferay-util:include>
				</aui:col>
			</aui:row>
		</aui:container>



		<script src="/o/new-misk-theme/js/from/jquery.dataTables.min.js"></script>
		<script src="/o/new-misk-theme/js/from/dataTables.bootstrap4.min.js"></script>

		<!-- Custom code start parth -->
		<liferay-portlet:resourceURL var="getCustomCalendarBookingsURL">
		</liferay-portlet:resourceURL>
		<!-- Custom code end parth -->

		<div id="<portlet:namespace />message"></div>
		<%
			String q = "-1";
			List<CalendarBooking> cbLst = null;
			JSONArray jsonArr;
			jsonArr = JSONFactoryUtil.createJSONArray();
			JSONObject json = JSONFactoryUtil.createJSONObject();
			String userId = request.getRemoteUser();
			Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
			int STATUS_APPROVED = 0;
			int STATUS_DENIED = 4;
			int STATUS_DRAFT = 2;
			int STATUS_EXPIRED = 3;
			int STATUS_IN_TRASH = 8;
			int STATUS_INACTIVE = 5;
			int STATUS_INCOMPLETE = 6;
			int STATUS_PENDING = 1;
			HashMap h = new HashMap<>();
			h.put(0, "approved");
			h.put(4, "denied");
			h.put(2, "draft");
			// h.put(3, "EXPIRED");
			h.put(3, "closed");
			h.put(5, "inactive");
			h.put(1, "pending");
			h.put(6, "incomplete");
			h.put(8, "in_trash");

			Connection con = null;
			Statement st = null;
			con = DataAccess.getConnection();
			st = con.createStatement();
			try {
				int indexT1 = 0;
				int indexT2 = 0;
				String titleString = "", Title = "";
				/*
				com.liferay.portal.kernel.dao.orm.Property statusProperty = com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status");
				DynamicQuery dq = com.liferay.calendar.service.CalendarBookingLocalServiceUtil.dynamicQuery();
				dq.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("userId").eq(Long.valueOf(userId)));
				Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
				disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(1));
				disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(2));
				disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(0));
				disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(3));
				disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(4));
				disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(5));
				disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(6));
				dq.add(disjunction);
				dq.addOrder(com.liferay.portal.kernel.dao.orm.OrderFactoryUtil.desc("calendarBookingId"));
				cbLst = (List) CalendarBookingLocalServiceUtil.dynamicQuery(dq,0,100);
				System.out.println("FROM View size calendar.jsp: "+cbLst.size());
				for(CalendarBooking event:cbLst)
				{
					System.out.println("11");
					json = JSONFactoryUtil.createJSONObject();
					json.put("eventId",event.getCalendarBookingId());
					json.put("endDate",format.format(Long.valueOf(event.getEndTime())))  ;
					json.put("startDate",format.format(Long.valueOf(event.getStartTime())));
					json.put("status",h.get(event.getStatus()));
					
					if(event.getTitle() == null || event.getTitle()== "")
						json.put("eventTitle",Title);
					else
					{
						titleString = event.getTitle();
						indexT1 = titleString.indexOf("<Title");
						titleString = titleString.substring(indexT1,titleString.length());
						titleString = titleString.replace("</Title></root>","</Title></root>"); 
						indexT2 = titleString.indexOf(">");
						Title = titleString.substring(indexT2+1,titleString.length());
						json.put("eventTitle",Title);
					}
					jsonArr.put(json);
				}
				*/
				String sqlTxt = " select tab.calendarbookingId ,canEdit" + " from ( select g1.calendarbookingId  ,"
						+ "COALESCE((select 1 " + " from EventEditors s " + " where s.userId  =" + userId
						+ "  and s.eventId = g1.calendarbookingId " + "   and not exists(select 1 "
						+ " from EventReviewers s " + " where s.userId = " + userId
						+ " and s.eventId = g1.calendarbookingId)" + " ),0) as canEdit" + "  from CalendarBooking g1"
						+ " where g1.userId = " + userId + "    and g1.status in(1,2,0,3,4,5,6) " + " union "
						+ " select g2.calendarbookingId  ," + "COALESCE((select 1 " + " from EventEditors s "
						+ " where s.userId  =" + userId + "  and s.eventId = g2.calendarbookingId "
						+ "   and not exists(select 1 " + " from EventReviewers s " + " where s.userId = " + userId
						+ " and s.eventId = g2.calendarbookingId)" + " ),0) as canEdit" + " from CalendarBooking g2 "
						+ " where EXISTS(select 1 " + "     from EventEditors r "
						+ "   where r.eventId = g2.calendarBookingId " + "      and r.userId = " + userId + ") "
						+ " and g2.status in(1,2,0,3,4,5,6)" + " union " + " select g2.calendarbookingId  ,"
						+ "COALESCE((select 1 " + " from EventEditors s " + " where s.userId  =" + userId
						+ "  and s.eventId = g2.calendarbookingId " + "   and not exists(select 1 "
						+ " from EventReviewers s " + " where s.userId = " + userId
						+ " and s.eventId = g2.calendarbookingId)" + " ),0) as canEdit" + " from CalendarBooking g2 "
						+ " where EXISTS(select 1 " + "     from EventReviewers r "
						+ "   where r.eventId = g2.calendarBookingId " + "      and r.userId = " + userId + ") "
						+ " and g2.status in(1,2,0,3,4,5,6)" + "     )tab " + " order by tab.calendarbookingId desc";

				System.out.println("manageEvent sqlTxt :: " + sqlTxt);
				ResultSet rs = st.executeQuery(sqlTxt);
				CalendarBooking cl;
				while (rs.next()) {
					String evId = rs.getString("calendarbookingId");
					cl = CalendarBookingLocalServiceUtil.getCalendarBooking(Long.valueOf(evId));
					json = JSONFactoryUtil.createJSONObject();
					json.put("eventId", cl.getCalendarBookingId());
					json.put("endDate", format.format(Long.valueOf(cl.getEndTime())));
					json.put("startDate", format.format(Long.valueOf(cl.getStartTime())));
					json.put("status", h.get(cl.getStatus()));
					json.put("canEdit", rs.getString("canEdit"));
					if (cl.getTitle() == null || cl.getTitle() == "")
						json.put("eventTitle", Title);
					else {
						titleString = cl.getTitle();
						indexT1 = titleString.indexOf("<Title");
						titleString = titleString.substring(indexT1, titleString.length());
						titleString = titleString.replace("</Title></root>", "</Title></root>");
						indexT2 = titleString.indexOf(">");
						Title = titleString.substring(indexT2 + 1, titleString.length());
						json.put("eventTitle", Title);
					}
					jsonArr.put(json);
				}
				System.out.println("manageEvent sqlTxt :: " + sqlTxt);
				DataAccess.cleanUp(con, st);
			} catch (Exception ex) {
				DataAccess.cleanUp(con, st);
				ex.printStackTrace();
			}
		%>
		<div class="loader" id="Loader"></div>
		<script>
			//Custom Code start Parth
			function callCustomServeResource(eventId, command) {
				AUI()
						.use(
								'aui-io-request',
								function(A) {
									A.io
											.request(
													'${getCustomCalendarBookingsURL}',
													{
														method : 'post',
														data : {
															<portlet:namespace />resourceID : "getCustomCalendarBooking",
															<portlet:namespace />userId : themeDisplay
																	.getUserId(),
															<portlet:namespace />command : command,
															<portlet:namespace />calendarBookingId : eventId,
														},
														on : {
															success : function() {
																/* debugger;
																console.log(this.get('responseData'));
																var x = document.getElementById("Loader");
																x.style.display = "none";
																table.clear();
																table.rows.add(JSON.parse(this.get('responseData')));
																table.draw();   */

																var responseData = JSON
																		.parse(this
																				.get('responseData'));
																table = $(
																		'#tblparticipants')
																		.DataTable(
																				{
																					data : responseData,
																					"columns" : [
																							{
																								data : "eventId"
																							},
																							{
																								data : "eventTitle"
																							},
																							{
																								data : "startDate"
																							},
																							{
																								data : "endDate"
																							},
																							{
																								data : "status"
																							},
																							{
																								data : "canEdit",
																								"visible" : false
																							},
																							,
																							{
																								title : "Manage",
																								"mRender" : function(
																										data,
																										type,
																										row) {

																									var eventId = row.eventId;
																									var canEdit = row.canEdit;
																									if (canEdit != 1) {
																										return '<a style = "padding:4%;" onclick="EditEvent('
																												+ eventId
																												+ ');return false;" data-toggle="tooltip" title="Edit" class=""><i class="fa fa-edit"></i></a>'
																												+ '<a style = "padding:4%;" onclick="DeleteEvent('
																												+ eventId
																												+ ');return false;" data-toggle="tooltip" title="Delete"><i class="fa fa-trash-o"></i></a> '
																												+ '<a style = "padding:4%;" onclick="closeEvent('
																												+ eventId
																												+ ');return false;" data-toggle="tooltip" title="close"><i class="fa fa-close"></i></a> '
																												+ '<a style = "padding:4%;" onclick="manageEvent('
																												+ eventId
																												+ ');return false;" data-toggle="tooltip" title="Manage Event Attendee"><i class="fa fa-close"></i></a> ';
																									} else {
																										return '<a style = "padding:4%;" onclick="EditEvent('
																												+ eventId
																												+ ');return false;" data-toggle="tooltip" title="Edit" class=""><i class="fa fa-edit"></i></a>'
																												+ '<a style = "padding:4%;" onclick="DeleteEvent('
																												+ eventId
																												+ ');return false;" data-toggle="tooltip" title="Delete"><i class="fa fa-trash-o"></i></a> '
																												+ '<a style = "padding:4%;" onclick="closeEvent('
																												+ eventId
																												+ ');return false;" data-toggle="tooltip" title="close"><i class="fa fa-close"></i></a> ';

																									}
																								}
																							} ],

																				});

															}
														}
													});
								});
			}
			//Custom Code end Parth
			$(document)
					.ready(
							function() {
								var jsonArrr = [];
								//callServeResource(1,"loadData")
								debugger;
								var data1 = [ {
									"eventId" : "001",
									"eventTitle" : "Event Title One",
									"startDate" : "Mostafa",
									"endDate" : "Mostafa",
									"status" : "Mostafa"
								} ];

								table = $('#tblparticipants')
										.DataTable(
												{
													data :
		<%=jsonArr%>
			,
													"oLanguage" : {
														"sSearch" : "",
														"sLengthMenu" : "_MENU_"
													},
													"bInfo" : false,
													"columns" : [
															{
																data : "eventId"
															},
															{
																data : "eventTitle"
															},
															{
																data : "startDate"
															},
															{
																data : "endDate"
															},
															{
																data : "status",
																className : "status-column"
															},
															{
																data : "canEdit",
																"visible" : false
															},
															{
																title : "Manage",
																className : "manage-column",
																"mRender" : function(
																		data,
																		type,
																		row) {

																	var eventId = row.eventId;
																	var canEdit = row.canEdit;

																	if (canEdit != 1) {
																		return '<a onclick="EditEvent('
																				+ eventId
																				+ ');return false;" data-toggle="tooltip" title="Edit" class="pr-3"><i class="fa fa-pencil"></i></a>'
																				+ '<a onclick="DeleteEvent('
																				+ eventId
																				+ ');return false;" data-toggle="tooltip" title="Delete" class="pr-3"><i class="fa fa-trash-o"></i></a> '
																				+ '<a style = "padding:4%;" onclick="closeEvent('
																				+ eventId
																				+ ');return false;" data-toggle="tooltip" title="close"><i class="fa fa-close"></i></a> '
																				+ '<a style = "padding:4%;" onclick="manageEvent('
																				+ eventId
																				+ ');return false;" data-toggle="tooltip" title="Manage Event Attendee"><i class="fa fa-users"></i></a> ';
																	} else {
																		return '<a onclick="EditEvent('
																				+ eventId
																				+ ');return false;" data-toggle="tooltip" title="Edit" class="pr-3"><i class="fa fa-pencil"></i></a>'
																				+ '<a onclick="DeleteEvent('
																				+ eventId
																				+ ');return false;" data-toggle="tooltip" title="Delete" class="pr-3"><i class="fa fa-trash-o"></i></a> '
																				+ '<a style = "padding:4%;" onclick="closeEvent('
																				+ eventId
																				+ ');return false;" data-toggle="tooltip" title="close"><i class="fa fa-close"></i></a> ';
																	}
																}
															} ],

												});
								$(
										'<div class="pull-left">'
												+ '<select id="ddlstatusfil" class="ml-2 custom-select custom-select-sm form-control form-control-sm widht-150">'
												+ '<option value=" ">All</option>'
												+ '<option value="1">APPROVED</option>'
												+ '<option value="2">REJECTED</option>'
												+ '<option value="3">PENDING</option>'
												+ '<option value="4">DRAFT</option>'
												+

												'</select>' + '</div>')
										.appendTo(
												"#tblparticipants_wrapper .dataTables_length");

								$("#tblparticipants_length label").addClass(
										"pull-left");

								$("#tblparticipants_filter input").attr(
										"placeholder", " Search ");

								var getColor = function(text) {
									text = $.trim(text).toUpperCase();
									if (text === "APPROVED")
										return '#33a664';
									if (text === "PENDING")
										return '#ff8400';
									if (text === "REJCTED")
										return '#ff007c';
									//return "";
								};

								$('td').each(function(i, td) {
									var color = getColor($(td).html());
									$(td).css({
										"color" : color
									});
								});

								$(function() {
									$('[data-toggle="tooltip"]').tooltip()
								});

								$('#tblparticipants').on('draw.dt', function() {
									$('td').each(function(i, td) {
										debugger;
										var color = getColor($(td).html());
										$(td).css({
											"color" : color
										});
									});

								});

								function loadData() {
									callserverRessource(1, "loadData")
									return data;
								}

								$('#ddlstatusfil').on(
										'change',
										function() {
											var Otable = $('#tblparticipants')
													.DataTable();
											var optionSelected = $(this).find(
													"option:selected");
											var valueSelected = optionSelected
													.val();
											var textSelected = optionSelected
													.text();
											//alert(valueSelected);
											// alert(textSelected);
											if (textSelected == "All") {

												textSelected = "";
											}
											Otable.columns(4).search(
													textSelected).draw();
										});

							});
			var table;

			function EditEvent(eventId) {
				var src = "/web/guest/editevent?eventID=" + eventId
				document.getElementById("srcId").src = src;
				debugger;
				$('#myform').modal('show');
				//window.open("/web/guest/profile?userId=123");
				// window.open("https://webserver-miskfoundation-dev.lfr.cloud/web/guest/manage-events?p_p_id=com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_vtIFYYNsqzER&p_p_lifecycle=0&p_p_state=pop_up&p_p_mode=view&_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_vtIFYYNsqzER_mvcPath=%2Fedit_calendar_booking.jsp&_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_vtIFYYNsqzER_calendarBookingId="+eventId)
				//window.open("http://localhost:8080/web/guest/manage-events?p_p_id=com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_azxU6w2dpCR7&p_p_lifecycle=0&p_p_state=pop_up&p_p_mode=view&_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_azxU6w2dpCR7_mvcPath=%2Fedit_calendar_booking.jsp&_com_liferay_calendar_web_portlet_CalendarPortlet_INSTANCE_azxU6w2dpCR7_calendarBookingId="+eventId);
			}

			function SendInvitationToSpeakers(eventId) {
				alert("sending inviation ...");
			}

			function DeleteEvent(calendarBookingId) {

				swal({
					title : "Are you sure you want to delete this record?",
					text : "",
					type : "warning",
					showCancelButton : true,
					confirmButtonColor : '#DD6B55',
					confirmButtonText : 'Yes, delete it!',
					closeOnConfirm : true,
				//closeOnCancel: false
				}, function() {
					var x = document.getElementById('Loader');
					x.style.display = "block";
					debugger;
					callServeResource(calendarBookingId, "deleteEvent");
				});

			}

			function manageEvent(calendarBookingId) {
				var src = "/web/guest/my-event?eventID=" + calendarBookingId;
				window.open(src, "_self");
			}
			function closeEvent(calendarBookingId) {
				debugger;

				swal({
					title : "Are you sure you want to close this record?",
					text : "",
					type : "warning",
					showCancelButton : true,
					confirmButtonColor : '#DD6B55',
					confirmButtonText : 'Yes, close it!',
					closeOnConfirm : true,
				//closeOnCancel: false
				}, function() {
					var x = document.getElementById('Loader');
					x.style.display = "block";
					debugger;
					callServeResource(calendarBookingId, "closeEvent");
				});
			}

			// localhost
			/* 
			 function callServeResource(calendarBookingId,action)
			 {
			 debugger;
			 AUI().use('aui-io-request', function(A){
			 A.io.request('http://localhost:8080/web/guest/silentpage?p_p_id=he2Portlet_He2Portlet_INSTANCE_o0reU6oKD9qQ&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&_he2Portlet_He2Portlet_INSTANCE_o0reU6oKD9qQ_param1=Value1', {
			 method: 'post',
			 data: {
			 _he2Portlet_He2Portlet_INSTANCE_o0reU6oKD9qQ_command: action,
			 _he2Portlet_He2Portlet_INSTANCE_o0reU6oKD9qQ_calendarBookingId: calendarBookingId,
			 _he2Portlet_He2Portlet_INSTANCE_o0reU6oKD9qQ_userId: themeDisplay.getUserId()
			 },
			 on: {
			 success: function() 
			 {
			 var x = document.getElementById("Loader");
			 x.style.display = "none";
			 table.clear();
			 table.rows.add(JSON.parse(this.get('responseData')));
			 table.draw(); 

			 }
			 }
			 });
			
			 });
			
			 }  */

			//misk
			function callServeResource(calendarBookingId, action) {
				debugger;
				AUI()
						.use(
								'aui-io-request',
								function(A) {
									A.io
											.request(
													'https://webserver-miskfoundation-dev.lfr.cloud/silentpage1?p_p_id=he2Portlet_He2Portlet_INSTANCE_o0reU6oKD9qQ&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_cacheability=cacheLevelPage&_he2Portlet_He2Portlet_INSTANCE_o0reU6oKD9qQ_param1=Value1',
													{
														method : 'post',
														data : {
															_he2Portlet_He2Portlet_INSTANCE_o0reU6oKD9qQ_command : action,
															_he2Portlet_He2Portlet_INSTANCE_o0reU6oKD9qQ_calendarBookingId : calendarBookingId,
															_he2Portlet_He2Portlet_INSTANCE_o0reU6oKD9qQ_userId : themeDisplay
																	.getUserId()
														},
														on : {
															success : function() {
																var x = document
																		.getElementById("Loader");
																x.style.display = "none";
																table.clear();
																table.rows
																		.add(JSON
																				.parse(this
																						.get('responseData')));
																table.draw();

															}
														}
													});

								});

			}
		</script>
		<div class="container">
			<div class="row">

				<div class="col-md-12">
					<c:if test="<%=!displaySchedulerOnly%>">
						<%@ include file="/view_calendar_menus.jspf"%>
					</c:if>
					<div class="table-responsive">
						<table class="table" id="tblparticipants">
							<thead>
								<tr>
									<th>#</th>
									<th>Event Title</th>
									<th>Start Date</th>
									<th>End Date</th>
									<th>Status</th>
									<th></th>
									<th style='width: 25%;'></th>
								</tr>
							</thead>
							<tbody>

							</tbody>
						</table>
					</div>
				</div>

			</div>
		</div>


		<div class="modal fade" id="myform" tabindex="-1" role="dialog"
			aria-labelledby="addlanguageLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg" role="document">
				<div class="modal-content">
					<div class="modal-header text-white bg-info">
						<h5 class="modal-title" id="addlanguageLabel">
							<label>Edit Event</label>
						</h5>
						<button type="reset" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<iframe frameborder="0" height="600px" id="srcId" src=""
							width="100%"> </iframe>
					</div>

				</div>
			</div>
		</div>


		<aui:script
			use="liferay-calendar-list,liferay-scheduler,liferay-store,liferay-calendar-util">
	Liferay.CalendarUtil.USER_CLASS_NAME_ID = <%=PortalUtil.getClassNameId(User.class)%>;

	var calendarContainer = Liferay.component('<portlet:namespace />calendarContainer');

	var syncCalendarsMap = function() {
		var calendarLists = [];

		<c:if
				test="<%=themeDisplay.isSignedIn() || (groupCalendarResource != null)%>">
			calendarLists.push(window.<portlet:namespace />myCalendarList);
		</c:if>

			<c:if test="<%=themeDisplay.isSignedIn()%>">
			calendarLists.push(window.<portlet:namespace />otherCalendarList);
		</c:if>

			<c:if test="<%=showSiteCalendars%>">
			calendarLists.push(window.<portlet:namespace />siteCalendarList);
		</c:if>

		calendarContainer.syncCalendarsMap(calendarLists);
	};

	window.<portlet:namespace />syncCalendarsMap = syncCalendarsMap;

	window.<portlet:namespace />calendarLists = {};

	<c:if
				test="<%=themeDisplay.isSignedIn() || (groupCalendarResource != null)%>">
		window.<portlet:namespace />myCalendarList = new Liferay.CalendarList(
			{
				after: {
					calendarsChange: syncCalendarsMap,
					'scheduler-calendar:visibleChange': function(event) {
					syncCalendarsMap();

						<portlet:namespace />refreshVisibleCalendarRenderingRules();
					}
				},
				boundingBox: '#<portlet:namespace />myCalendarList',

				<%
				updateCalendarsJSONArray(request, userCalendarsJSONArray);
			%>

				calendars: <%=userCalendarsJSONArray%>,
				scheduler: <portlet:namespace />scheduler,
				showCalendarResourceName: false,
				simpleMenu: window.<portlet:namespace />calendarsMenu,
				visible: <%=!displaySchedulerOnly && themeDisplay.isSignedIn()%>
			}
		).render();

		<c:if test="<%=userCalendarResource != null%>">
			window.<portlet:namespace />calendarLists['<%=userCalendarResource.getCalendarResourceId()%>'] = window.<portlet:namespace />myCalendarList;
		</c:if>
			</c:if>

			<c:if test="<%=themeDisplay.isSignedIn()%>">
		window.<portlet:namespace />otherCalendarList = new Liferay.CalendarList(
			{
				after: {
					calendarsChange: function(event) {
						syncCalendarsMap();
						<portlet:namespace />scheduler.load();

						var calendarIds = A.Array.invoke(event.newVal, 'get', 'calendarId');

						Liferay.Store('com.liferay.calendar.web_otherCalendars', calendarIds.join());
					},
					'scheduler-calendar:visibleChange': function(event) {
						syncCalendarsMap();
						<portlet:namespace />refreshVisibleCalendarRenderingRules();
					}
				},
				boundingBox: '#<portlet:namespace />otherCalendarList',

				<%
				updateCalendarsJSONArray(request, otherCalendarsJSONArray);
			%>

				calendars: <%=otherCalendarsJSONArray%>,
				scheduler: <portlet:namespace />scheduler,
				simpleMenu: window.<portlet:namespace />calendarsMenu,
				visible: <%=!displaySchedulerOnly%>
			}
		).render();
	</c:if>

			<c:if test="<%=showSiteCalendars%>">
		window.<portlet:namespace />siteCalendarList = new Liferay.CalendarList(
			{
				after: {
					calendarsChange: syncCalendarsMap,
					'scheduler-calendar:visibleChange': function(event) {
						syncCalendarsMap();

						<portlet:namespace />refreshVisibleCalendarRenderingRules();
					}
				},
				boundingBox: '#<portlet:namespace />siteCalendarList',

				<%
				updateCalendarsJSONArray(request, groupCalendarsJSONArray);
			%>

				calendars: <%=groupCalendarsJSONArray%>,
				scheduler: <portlet:namespace />scheduler,
				showCalendarResourceName: false,
				simpleMenu: window.<portlet:namespace />calendarsMenu,
				visible: <%=!displaySchedulerOnly%>
			}
		).render();

		window.<portlet:namespace />calendarLists['<%=groupCalendarResource.getCalendarResourceId()%>'] = window.<portlet:namespace />siteCalendarList;
	</c:if>

	syncCalendarsMap();

	A.each(
		calendarContainer.get('availableCalendars'),
		function(item, index) {
			item.on(
				{
					'visibleChange': function(event) {
						var instance = this;

						var calendar = event.currentTarget;

						Liferay.Store('com.liferay.calendar.web_calendar' + calendar.get('calendarId') + 'Visible', event.newVal);
					}
				}
			);
		}
	);
</aui:script>

		<aui:script
			use="aui-base,aui-datatype,liferay-calendar-session-listener">
	window.<portlet:namespace />refreshSchedulerEventTooltipTitle = function(schedulerEvent) {
		schedulerEvent.get('node').attr('title', A.Lang.String.unescapeHTML(schedulerEvent.get('content')));
	};

	<portlet:namespace />scheduler.after(
		['scheduler-events:load'],
		function(event) {
			event.currentTarget.eachEvent(<portlet:namespace />refreshSchedulerEventTooltipTitle);
		}
	);

	<portlet:namespace />scheduler.load();

	var calendarContainer = Liferay.component('<portlet:namespace />calendarContainer');

	new Liferay.CalendarSessionListener(
		{
			calendars: calendarContainer.get('availableCalendars'),
			scheduler: <portlet:namespace />scheduler
		}
	);
</aui:script>

		<aui:script>
	var destroyMenus = function(event) {
		if (window.<portlet:namespace />calendarListsMenu) {
			window.<portlet:namespace />calendarListsMenu.destroy();
		}

		if (window.<portlet:namespace />colorPicker) {
			window.<portlet:namespace />colorPicker.destroy();
		}

		var myCalendarList = window.<portlet:namespace />myCalendarList;
		var otherCalendarList = window.<portlet:namespace />otherCalendarList;
		var siteCalendarList = window.<portlet:namespace />siteCalendarList;

		if (myCalendarList && myCalendarList.simpleMenu) {
			myCalendarList.simpleMenu.destroy();
			myCalendarList.destroy();
		}

		if (otherCalendarList && otherCalendarList.simpleMenu) {
			otherCalendarList.simpleMenu.destroy();
			otherCalendarList.destroy();
		}

		if (siteCalendarList && siteCalendarList.simpleMenu) {
			siteCalendarList.simpleMenu.destroy();
			siteCalendarList.destroy();
		}

		Liferay.detach('<%=portletDisplay.getId()%>:portletRefreshed', destroyMenus);
		Liferay.detach('destroyPortlet', destroyMenus);
	};
	Liferay.on('<%=portletDisplay.getId()%>:portletRefreshed', destroyMenus);
	Liferay.on('destroyPortlet', destroyMenus);
</aui:script>

		<%!protected void updateCalendarsJSONArray(HttpServletRequest request, JSONArray calendarsJSONArray) {
		for (int i = 0; i < calendarsJSONArray.length(); i++) {
			JSONObject jsonObject = calendarsJSONArray.getJSONObject(i);

			long calendarId = jsonObject.getLong("calendarId");

			jsonObject.put("color", GetterUtil.getString(SessionClicks.get(request,
					"com.liferay.calendar.web_calendar" + calendarId + "Color", jsonObject.getString("color"))));
			jsonObject.put("visible", GetterUtil.getBoolean(
					SessionClicks.get(request, "com.liferay.calendar.web_calendar" + calendarId + "Visible", "true")));
		}
	}%>
	</div>
</body>
