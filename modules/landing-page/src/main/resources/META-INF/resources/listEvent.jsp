<!DOCTYPE html>
<%@ include file="/init.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="landing.page.portlet.LandingPagePortlet"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.calendar.model.CalendarBooking"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="javax.portlet.PortletSession"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<html>
<head>
    <meta charset="utf-8" />
    <title>YouthHUb Events</title>
   
    <link  href="/o/new-misk-theme/css/font/font-awesome/font-awesome.min.css" rel="stylesheet"/>
<link href="/o/new-misk-theme/css/landing/landing.css" rel="stylesheet" /> 
<link href="/o/new-misk-theme/css/landing/animate.css" rel="stylesheet" />

<% if(themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")) { %>
<link href="/o/new-misk-theme/css/landing/CustomStyle_Ar.css" rel="stylesheet" />
<% } else { %>
<link href="/o/new-misk-theme/css/landing/CustomStyle.css" rel="stylesheet" />
<% } %>
<link href="/o/new-misk-theme/css/landing/animate.css" rel="stylesheet" />
<script src="/o/new-misk-theme/js/landing/jquery.counterup.min.js"></script>
<script src="/o/new-misk-theme/js/landing/scrollreveal.min.js"></script>
<script src="/o/new-misk-theme/js/landing/imgfix.min.js"></script>
<script src="/o/new-misk-theme/js/landing/wow.min.js"></script>
<script src="/o/new-misk-theme/js/landing/custom.js"></script>

<style>
    <% if(themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")) { %>
			.control-menu-level-1 { 
			    background-image: none;
			    background-color: transparent;
			    color: #869CAD;
			    height: 0px;
			     width: 194px;
		         margin-left: 70%;
			} 
		<% } else { %> 
			.control-menu-level-1 { 
			background-color: transparent;
		    color: #869CAD;
		    height: 0px;
		    width: 194px;
		    margin-left: 70%;
			} 
		<% } %>
		
		  <% if(renderRequest.getRemoteUser() != null) { %>
		  .has-control-menu .affix, .has-control-menu #wrapper {
			    margin-top: 0;
			}

			.language-dropdown {
			margin-left: 83%;
			margin-top: 8px;
			cursor: pointer;
			font-size: 20px;
			}
			
		<% 
		if(themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")) { %>
		.control-menu-level-1 {
			    background-image: none;
			    background-color: transparent;
			    color: #869CAD;
			    height: 0px;
			    width: 305px;
			    margin-left: 9%;
			}
			
			.tools-control-group {
			    min-width: 0;
			}
				
		<%   } 
		}%>
		
			<% if(themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")) { %>
	.row {
		direction:rtl;
	}
	<% } %>
</style>
</head>

<portlet:renderURL var="renderAction">
    <portlet:param name="mvcPath" value="/eventDetails.jsp"></portlet:param>
    <portlet:param name="eventId" value="34202"></portlet:param>
</portlet:renderURL>

<body>
<%
LandingPagePortlet evt = new LandingPagePortlet();
boolean isFromSearch=false;
List <CalendarBooking> cbLst1= null;
%>

                <script>
                var commingFromSearch = false;   
                var reachedId = 0;
                var start=0;
                var end = 6;
                var fromJSS=false;
                function reloadData(obj)
                {
                	commingFromSearch = true;
                	var selectText = $('#selectionTypeId').find(":selected").val();
                	var inputCriteria = $("#textSearchId").val();
                	var searchdate = $("#searchdate").val();
                	var locationSearchTxt = $("#locationSearchTxt").val();
                	callServeResource(selectText,inputCriteria,"registerEvent",start,end,searchdate,locationSearchTxt);
                	/* debugger;
                	 $('#rec-box').empty().append(($('#rec1').contents().clone());
                	document.getElementById("divViewOne").innerHTML = "<h2>hullo</h2>"; */
                	// $( "#firstSectionDivId" ).load(window.location.href + " #firstSectionDivId" );
                }
                
                function showMoredata()
                {
                	var selectText = $('#selectionTypeId').find(":selected").val();
                	var inputCriteria = $("#textSearchId").val();
                	var searchdate = $("#searchdate").val();
                	var locationSearchTxt = $("#locationSearchTxt").val();
                	debugger;
                	//start = end;
                	end = end +6;
                	callServeResource(selectText,inputCriteria,"registerEvent",start,end,searchdate,locationSearchTxt);
                }
                
                function openLocation(locationLink) 
                {
                	var newWin=window.open(locationLink);
                	//document.getElementById("srcId").src=locationLink;
                	//$('#myformLocation').modal('show') ;
                }
                </script>

    <div class="container-fluid bgcolor">
     <div id="global-header-section">
    <div id="intro-title" class="container">
    <h3><span style="border-bottom:2px solid #eee;padding-bottom:40px; width: 3%; position: absolute; "></span><liferay-ui:message key="Events" /></h3>
            <h1><liferay-ui:message key="WeBringYoungLeadersTogether" /></h1>
    </div>
    
        <section id="event-search">
            <div class="container">            
                <div class="row">
                    <div class="col-md-12 pt-5 p-0">
                        <div class="filter-top cardshadow">
                            <div class="card-body">
                                <div class="row">                                
                                    <div class="col-md-6 col-sm-6 col-xs-12 form-group col-lg-2">
                                        <select id="selectionTypeId" name="eventname" id="searchType" class="form-control customtextbox">
                                            <option value="Search Type"><liferay-ui:message key="SearchType" /></option>
                                            <option value="Course"><liferay-ui:message key="Course" /></option>
                                            <option value="Hackathon"><liferay-ui:message key="Hackathon" /></option>
                                            <option value="Forum"><liferay-ui:message key="Forum" /></option>
                                            <option value="Conference"><liferay-ui:message key="Conference" /></option>
                                            <option value="Seminar"><liferay-ui:message key="Seminar" /></option>
                                        </select>
                                    </div>
                                     <div class="col-md-6 col-sm-6 col-xs-12 form-group col-lg-3">                                        
                                      <input type="month" id="searchdate" name="searchdate" placeholder="Month year" class="form-control"/>
                                     </div>
                                     <div class="col-md-6 col-sm-6 col-xs-12 form-group col-lg-3">                                  
                                      <input type="text"  id="textSearchId" placeholder="<liferay-ui:message key="Searchcriteria" />" class="form-control searchtextbox">
                                     </div>
                                     <div class="col-md-6 col-sm-6 col-xs-12 form-group col-lg-2">                                        
                                      <input type="text"  id="locationSearchTxt" placeholder="<liferay-ui:message key="Locationcriteria" />" class="form-control searchtextbox">
                                     </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12 form-group col-lg-2">
                                        <button class="btn btn-block btnbg" onclick="reloadData(this)">
                                          <liferay-ui:message key="Search" />  
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
         </div>
        <section id="swicher-section">
        <div class="container">
        <div class="row">
        <div class="col-md-12 text-right pt-1">
        <a id="firstTimeLine">
        <img src="/o/new-misk-theme/images/eventListImages/swicher-1-1.png" id="timelinefirst-swicher1-1" style="display:none"  />
        <img src="/o/new-misk-theme/images/eventListImages/swicher-1.png" id="timelinefirst-swicher1"  />
        
          </a>
        <a  id="secondTimeLine"> 
        <img src="/o/new-misk-theme/images/eventListImages/swicher-2-1.png" id="timelinewto-switche2-1" />
        <img src="/o/new-misk-theme/images/eventListImages/swicher-2.png" id="timelinewto-switche2" style="display:none"  />  
        
        </a>
        </div>
        </div>
        </div>
        </section>
        <section id="timeline" class="container pt-2" style="display:none">
        <div id="firstSectionDivId">
            <%
            DateFormatSymbols dfs = new DateFormatSymbols();
            String[] months = dfs.getMonths();
            
            Calendar c = Calendar.getInstance(); 
            String img="";
            String imageSrc="/o/new-misk-theme/images/landing/no-image-available.png";
            renderRequest.setAttribute("start","0");
            renderRequest.setAttribute("end","6");
            String userId = renderRequest.getRemoteUser();
            //themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            /* if(fromJSS == true)
            {
            	renderRequest.setAttribute("fromSearch",true);
            } */
            List <CalendarBooking> cbLst ;
            
/*             if(portletSession.getAttribute("test") != null)
            {
            	cbLst = portletSession.getAttribute("test");
            }
            else */
            
            if((portletSession.getAttribute("objArray") != null &&  ((List <CalendarBooking>)  portletSession.getAttribute("objArray")).size() > 0)
            	|| (portletSession.getAttribute("fromSearch") != null)
                			 )
            {    
            	System.out.println("---:1111111111: reloadscdacdsvdData 12 ");
            	System.out.println("---:1111111111: reloadscdacdsvdData 1111 " + portletSession.getAttribute("objArray"));
            	cbLst = (List <CalendarBooking>)  portletSession.getAttribute("objArray");
            	System.out.println("---:1111111111: reloadscdacdsvdData 33 ");
//             	System.out.println("---:1111111111: reloadscdacdsvdData 1111 " + cbLst);
            }
            else
                cbLst = evt.getCalendarBooking(renderRequest,"0","6");
                String description;
                String title;
                String owner;
                String startDate;
                long calendarBookingId;
                int mYear = 0;
                int mMonth = 0;  
                int mDay = 0  ; 
                int hr = 0    ;  
                int min = 0; 
                //int sec = c.get(Calendar.SECOND);
                DateFormat dateFormat1 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
                DateFormat dateFormat2 = new SimpleDateFormat("yyyy-mm-dd");
                DateFormat dateFormat3 = new SimpleDateFormat("hh:mm");
                DateFormat dateFormat4 = new SimpleDateFormat("mm");
                DateFormat dateFormat5 = new SimpleDateFormat("yyyy");
                String month="";
                String date="";
                String time="";
                String year="";
                int i=0;
                String mMonthF="";
                String mDayFS="";
                String hrF="";
                String minF="";
                String mDayFE = "";
                String location="";
                String eventTypes = "";
                String mdarResult1="";
                String cssClassType="bookmarkCourse2";
//                 System.out.println("---:1111111111: reloadscdacdsvdData 1111 123 " + cbLst);
                for(CalendarBooking calendarBookings1 : cbLst)
                {
                	 System.out.println("---:1111111111: reloadscdacdsvdData 1111 A");
                	// System.out.println("---: " + calendarBookings1.getExpandoBridge().getAttribute("Event Types"));
                	 //String eventTypes = (String) calendarBookings1.getExpandoBridge().getAttribute("Event Types");
                	 Object[] a = (Object[]) calendarBookings1.getExpandoBridge().getAttribute("Event Types"); 
                	 System.out.println("---:1111111111: reloadscdacdsvdData 1111 C");
                	 if(a.length>0) 
                	 {
                		 Object obj = a[0]; 
                		 eventTypes = obj.toString(); 
                		 //System.out.println("---:obj: " + obj);
                		 //System.out.println("---:obj.toString():----" + eventTypes +"---------------");


                         if(eventTypes == "Course"  || eventTypes.equalsIgnoreCase("Course"))
                         {
                        	 cssClassType = "bookmarkCourse2";
                        	 System.out.println("---:Course");
                         }
                         else if(eventTypes == "Hackathon" || eventTypes.equalsIgnoreCase("Hackathon"))
                         {
                        	 cssClassType = "bookmarkHackathon";
                        	 System.out.println("---:Hackathon");
                         }
                         else if (eventTypes == "Forum" || eventTypes.equalsIgnoreCase("Forum"))
                         {
                        	 cssClassType = "bookmarkForum2";
                        	 System.out.println("---:Forum");
                         }
                         else if (eventTypes == "Conference" || eventTypes.equalsIgnoreCase("Conference"))
                         {
                        	 cssClassType = "bookmarkConference";
                        	 System.out.println("---:Conference");
                         }
                         else if (eventTypes == "Seminar" || eventTypes.equalsIgnoreCase("Conference"))
                         {
                        	 cssClassType = "bookmarkSemininar";
                        	 System.out.println("---:Seminar");
                         }
                	 }
                	
                	c.setTimeInMillis(calendarBookings1.getStartTime());
                	mMonth =  c.get(Calendar.MONTH);
                	mYear = c.get(Calendar.YEAR);
                	mDay = c.get(Calendar.DAY_OF_MONTH);
                	hr = c.get(Calendar.HOUR);
                	min  = c.get(Calendar.MINUTE);
                	
                	 mMonthF = String.format("%02d", mMonth);
                	 System.out.println("---mMonthF:  " + DateFormatSymbols.getInstance(themeDisplay.getLocale()).getMonths()[Integer.parseInt(mMonthF)]);
                	 mDayFS = String.format("%02d", mDay);
                	 hrF = String.format("%02d", hr);
                	 minF = String.format("%02d", min);
                
                	c.setTimeInMillis(calendarBookings1.getEndTime());
                	int mMonthE =  c.get(Calendar.MONTH);
                	String mMonthEF = String.format("%02d", mMonthE);
                	 System.out.println("---mMonthEF:  " + mMonthEF);
                	int mDayy = c.get(Calendar.DAY_OF_MONTH);
                	 mDayFE = String.format("%02d", mDayy);
                	 System.out.println("---ListEvent:: : mDayFS  " + mDayFS+"----mDayFE: "+mDayFE);
                	 mdarResult1 = "";
                	 /* if(mDayFS.equalsIgnoreCase(mDayFE))
                	 {
                		 System.out.println("---ListEvent:: : inside If  ");
                		 mdarResult1 = mDayFS;
                	 }
                	 else
                	 {
                		 System.out.println("---ListEvent:: : else If  ");
                		 mdarResult1 = mDayFS +" - "+mDayFE;
                	 } */
                	 System.out.println("---ListEvent:: : out mDayFS  " + mdarResult1);
	                description = calendarBookings1.getDescription(themeDisplay.getLocale().toString().toLowerCase()).replaceAll("<p>", "").replaceAll("</p>","");
	                owner = calendarBookings1.getUserName();
// 	                title = calendarBookings1.getTitleCurrentValue();
	                title = calendarBookings1.getTitle(themeDisplay.getLocale().toString().toLowerCase()).replaceAll("<p>", "").replaceAll("</p>","");
	                month = dateFormat4.format(Long.valueOf(calendarBookings1.getStartTime()));
	                date = dateFormat2.format(Long.valueOf(calendarBookings1.getStartTime()));
	                time = dateFormat3.format(Long.valueOf(calendarBookings1.getStartTime()));
	                startDate = dateFormat1.format(Long.valueOf(calendarBookings1.getStartTime()));
	                calendarBookingId = calendarBookings1.getCalendarBookingId() ;
	                location = calendarBookings1.getLocation();
	                if(themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar"))
	                	location = calendarBookings1.getExpandoBridge().getAttribute("locationAr")!= null ? calendarBookings1.getExpandoBridge().getAttribute("locationAr").toString() : "" ;

	                img = evt.getImageBybookingEvent(calendarBookings1.getCalendarBookingId());
	        		if(img=="" || img==null || img=="null")
	        			img = imageSrc;
                %>
              
                <div class="row pb-5" id="divViewOne">
                    <div class="text-right col-md-3  pr-5 pt-4">
                        <span class="datecard">
                            <%= (mMonthEF.equalsIgnoreCase(mMonthF))?DateFormatSymbols.getInstance(themeDisplay.getLocale()).getMonths()[Integer.parseInt(mMonthF)]:DateFormatSymbols.getInstance(themeDisplay.getLocale()).getMonths()[Integer.parseInt(mMonthF)].substring(0, 3)+"-"+DateFormatSymbols.getInstance(themeDisplay.getLocale()).getMonths()[Integer.parseInt(mMonthEF)].substring(0, 3)%> 
                              <br />
                            <%=(!mMonthEF.equalsIgnoreCase(mMonthF))? mDayFS+"th-"+ mDayFE+"th, "+mYear:(mDayFS.equalsIgnoreCase(mDayFE))?mDayFE+"th, "+mYear:mDayFS+"th-"+ mDayFE+"th, "+mYear%>
                            <br />
                               
                        </span>
                    </div>
                    <div class="col-md-9 eventcard">
                        <span class="timeline-circle">
                            <span class="inner-circle">&nbsp;</span>
                        </span>
                        <div class="card timeline-card">
                            <div class="<%=cssClassType%>">
                                <p class="ribbontext"><liferay-ui:message key="<%=eventTypes%>" /></p>
                            </div>                           
                            <a href="#"> <img class="card-img-top" src=<%=img%> alt="Event Image" /></a>
                            <div class="card-body">
                                <h3 class="limited-title-text"><%=title%></h3>
                                <div>
                                <a class="event-list-location" onclick="openLocation(<%="'"+calendarBookings1.getExpandoBridge().getAttribute("Location link").toString()+"'"%>)" >
                                      <span class="locator-img">
                                    <img src="/o/new-misk-theme/images/eventListImages/map-marker-alt.png" alt="location marker" />
                                    </span> 
                                   <span class="timeline-subtitle"> <%=location%></span> 
                                   </a>
                                </div>
                            </div>
                            <div class="card-ft">
                                <span class="float-right pb-2"><a href="${renderAction}&<portlet:namespace />calendarBookingId=<%=calendarBookingId%>" id="_com_liferay_login_web_portlet_LoginPortlet_fcka" class="card-footer-link"><liferay-ui:message key="EventDetails" /></a> </span>
                            </div>
                        </div>

                    </div>
                </div>
                <%
                }
                %>
           </div>
                <div class="row pt-3">
                    <div class="col-md-12 text-center">
                         <a class="card-link  location-link"  onclick="showMoredata()"><liferay-ui:message key="ShowMore" /></a>
                    </div>

                </div>
        </section>

        <section id="timeline2" class="container pt-2">
            <div id="secondSectionDivId" class="card-group">
                <%
                
                renderRequest.setAttribute("start","0");
                renderRequest.setAttribute("end","6");
                 month = "";
                 date = "";
                 time="";
                 year="";
                //themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
               /*  if(request.getAttribute("cbLst")==null)
                	cbLst = evt.getCalendarBooking(renderRequest);
                else 
                	cbLst = request.getAttribute("cbLst"); */
                //cbLst = evt.getCalendarBooking(renderRequest);

                i=0;
               String monthSmal = "";

                for(CalendarBooking calendarBookings1 : cbLst)
                {
                	Object[] a = (Object[]) calendarBookings1.getExpandoBridge().getAttribute("Event Types"); 
               	 
               	 if(a.length>0) 
               	 {
               		 Object obj = a[0]; 
               		 eventTypes = obj.toString(); 

               		 if(eventTypes == "Course"  || eventTypes.equalsIgnoreCase("Course"))
                     {
                    	 cssClassType = "bookmarkCourse2";
                    	 System.out.println("---:Course");
                     }
                     else if(eventTypes == "Hackathon" || eventTypes.equalsIgnoreCase("Hackathon"))
                     {
                    	 cssClassType = "bookmarkHackathon";
                    	 System.out.println("---:Hackathon");
                     }
                     else if (eventTypes == "Forum" || eventTypes.equalsIgnoreCase("Forum"))
                     {
                    	 cssClassType = "bookmarkForum2";
                    	 System.out.println("---:Forum");
                     }
                     else if (eventTypes == "Conference" || eventTypes.equalsIgnoreCase("Conference"))
                     {
                    	 cssClassType = "bookmarkConference";
                    	 System.out.println("---:Conference");
                     }
                     else if (eventTypes == "Seminar" || eventTypes.equalsIgnoreCase("Conference"))
                     {
                    	 cssClassType = "bookmarkSemininar";
                    	 System.out.println("---:Seminar");
                     }
               	 }
                	c.setTimeInMillis(calendarBookings1.getStartTime());
                	mMonth =  c.get(Calendar.MONTH);
                	mYear = c.get(Calendar.YEAR);
                	mDay = c.get(Calendar.DAY_OF_MONTH);
                	hr = c.get(Calendar.HOUR);
                	min  = c.get(Calendar.MINUTE);
                	
                    
                     if (mMonth >= 0 && mMonth <= 11 ) {
                    	// monthSmal = months[mMonth];
                    	 monthSmal = DateFormatSymbols.getInstance(themeDisplay.getLocale()).getMonths()[mMonth];
                     }
                	 mMonthF = String.format("%02d", mMonth);
                	 mDayFS = String.format("%02d", mDay);
                	 hrF = String.format("%02d", hr);
                	 minF = String.format("%02d", min);
                
                	c.setTimeInMillis(calendarBookings1.getEndTime());
                	int mMonthEE =  c.get(Calendar.MONTH);
                	String mMonthEF = String.format("%02d", mMonthEE);
                    int mDayF = c.get(Calendar.DAY_OF_MONTH);
                	String mDayFForm = String.format("%02d", mDayF);
                	 
                	 
	                i++;
	                startDate = dateFormat1.format(Long.valueOf(calendarBookings1.getStartTime()));
	                description = calendarBookings1.getDescription(themeDisplay.getLocale().toString().toLowerCase()).replaceAll("<p>", "").replaceAll("</p>","");
	                owner = calendarBookings1.getUserName();
	                title = calendarBookings1.getTitle(themeDisplay.getLocale().toString().toLowerCase()).replaceAll("<p>", "").replaceAll("</p>","");
	                year = dateFormat5.format(Long.valueOf(calendarBookings1.getStartTime()));
	                month = dateFormat4.format(Long.valueOf(calendarBookings1.getStartTime()));
	                date = dateFormat2.format(Long.valueOf(calendarBookings1.getStartTime()));
	                time = dateFormat3.format(Long.valueOf(calendarBookings1.getStartTime()));
	                startDate = dateFormat1.format(Long.valueOf(calendarBookings1.getStartTime()));
	                calendarBookingId = calendarBookings1.getCalendarBookingId() ;
	                location = calendarBookings1.getLocation();
	                if(themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar"))
	                	location = calendarBookings1.getExpandoBridge().getAttribute("locationAr")!= null ? calendarBookings1.getExpandoBridge().getAttribute("locationAr").toString() : "" ;

                %>

                <div class="col-md-6 col-sm-12" id="divViewTwo">
					<div class="event-card">
						<div class="<%=cssClassType%>">
							<p class="ribbontext"><liferay-ui:message key="<%=eventTypes%>" /></p>
						</div>


						<div class="row  pt-3">
							<div class="col-md-3">
								<div class="datecard-bg">
									<div class="text-center">
										<span class="month-text"> <%= (mMonthEF.equalsIgnoreCase(mMonthF))?DateFormatSymbols.getInstance(themeDisplay.getLocale()).getMonths()[Integer.parseInt(mMonthF)]:DateFormatSymbols.getInstance(themeDisplay.getLocale()).getMonths()[Integer.parseInt(mMonthF)].substring(0, 3)+"-"+DateFormatSymbols.getInstance(themeDisplay.getLocale()).getMonths()[Integer.parseInt(mMonthEF)].substring(0, 3)%>
										</span><br /> <span class="dates-text"><%=(mDayFS.equalsIgnoreCase(mDayFForm))?mDayFS: mDayFS +" - "+mDayFForm%></span><br />
										<span class="year-text"><%=mYear %></span>
									</div>
								</div>
							</div>
							<div class="col-md-9 pr-5" style="margin-top: 14px;">
								<span class="small-date"><%=monthSmal%> <%=mDayFS %>, <%=mYear %></span>
								<h3 class="timeline2-limited-title-text">
									<%=title%>
								</h3>
								<p>
									<a class="location-url"
										onclick="openLocation(<%="'"+calendarBookings1.getExpandoBridge().getAttribute("Location link").toString()+"'"%>)">
										<span class="locator-img"> <img
											src="/o/new-misk-theme/images/eventListImages/map-marker-alt.png"
											alt="location marker" />
									</span> <span class="timeline2-timeline-subtitle"><%=location%></span>
									</a>
								</p>
								<div class="pt-2 event-description">
									<%=description%>
									</p>
								</div>

							</div>

						<div class="card-footer">
							<div class="col-md-12 text-center pb-2">
								<hr />
								<a
									href="${renderAction}&<portlet:namespace />calendarBookingId=<%=calendarBookingId%>"
									id="_com_liferay_login_web_portlet_LoginPortlet_fcka"
									class="card-footer-link"><liferay-ui:message key="EventDetails" /></a>
							</div>
						</div>
					</div>
				</div>
				</div>
                

                <%
                }
                %>
            </div>
             <div class="row pt-3">
                    
                    <div class="col-md-12 text-center">
                        <a class="card-link  location-link"  onclick="showMoredata()"><liferay-ui:message key="ShowMore" /></a>
                    </div>
                   
                </div>
        </section>

        <section id="newupdate-section" class="mt-5">
        	<%@ include file="/news.jsp" %>
    	</section>
    
 <!--    <section class="container-fluid" id="createaccount-section">
        <div class="container">
            <div class="row py-5">
                <div class="col-md-5">
                    <div class="summary">
                        <h3>
                            Becom Future Ready.<br />
                            Right here. Right now.
                        </h3>
                        <p>Start on the path to your best future,<br /> join Youth Hub today.</p>
                    </div>
                </div>
                <div class="col-md-7">
                    <div class="row">
                        <div class="col-md-12 form-group">

                            <select type="text" class="form-control selectrole" id="role" name="role">
                                <option selected="true" value="">Select your role</option>
                                <option value="">Role</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 form-group">                           
                            <input type="text" class="cutomtextbox" id="firstname" name="firstname" placeholder="First Name" />
                        </div>
                        <div class="col-md-6 form-group">                          
                            <input type="text" class="cutomtextbox" id="lastname" name="lastname" placeholder="Last Name" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group">                         
                            <input type="email" class="cutomtextbox" id="email" name="email" placeholder="Email" />
                        </div>

                    </div>
                    <div class="row py-2">
                        <div class="col-md-12">
                           <div class="checkbox-container">
                                    I accept Youth Hub Terms & Conditions   <span style="border-left:1px solid #ffffff;padding-right: 2px;"></span>   Privacy policy.
                                    <input type="checkbox" id="credentailnotexpire" name="credentailnotexpire">
                                    <label class="checkmark" for="credentailnotexpire">
                                    </label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <button class="btn btn-singin">Sign In</button> 
                            <span style="padding-left: 3%;">
                            <button class="btn btn-greentext">Sign Up</button></span>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section> -->
    </div>
    <portlet:defineObjects />   
<liferay-portlet:resourceURL var="resourceUrl1" >
	<liferay-portlet:param name="param1" value="Value1"/>
</liferay-portlet:resourceURL>
    
    <script>
       $(document).ready(function(){
    	  
      
       $("#firstTimeLine").click(function(){
    	   $("#timeline").css("display","");
    	   $("#timeline2").css("display","none");
    	   $("#timelinefirst-swicher1-1").css("display","");
    	   $("#timelinefirst-swicher1").css("display","none");
    	   $("#timelinewto-switche2").css("display","");
    	   $("#timelinewto-switche2-1").css("display","none");
    	   
    	   
    	 });
       $("#secondTimeLine").click(function(){
    	   $("#timeline2").css("display","");
    	   $("#timeline").css("display","none");
    	   $("#timelinewto-switche2-1").css("display","");
    	   $("#timelinewto-switche2").css("display","none");
    	   $("#timelinefirst-swicher1").css("display","");
    	   $("#timelinefirst-swicher1-1").css("display","none");    	  
    	 });
       
       });

       
       
       function callServeResource(type,criteria,command,start,end,searchdate,locationSearchTxt)
       {
           AUI().use('aui-io-request', function(A){
               A.io.request('${resourceUrl1}', {
                      method: 'post',
                      data: {
                   		    <portlet:namespace />command: command,
                   		    <portlet:namespace />type: type,
                   			<portlet:namespace />criteria: criteria,
                   			<portlet:namespace />start: start,
                   			<portlet:namespace />end: end,
                   			<portlet:namespace />searchdate: searchdate,
                   			<portlet:namespace />locationSearchTxt: locationSearchTxt
                            },
                      on: {
                          	 success: function() 
                          	 {
                          		//reachedId = reachedId+6;
                          		$( "#firstSectionDivId" ).load(window.location.href + " #firstSectionDivId" );
//                           		$( "#secondSectionDivId" ).load(window.location.href + " #secondSectionDivId" );
                          		$( "#timeline2" ).load(window.location.href + " #secondSectionDivId" );
                             }
                     }
               });
        
           });
       }
       
       
    </script>
</body>
</html>

<div class="modal fade" id="myformLocation" tabindex="-1" role="dialog" aria-labelledby="addlanguageLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header text-white bg-info">
                    <h5 class="modal-title" id="addlanguageLabel">
                        <label>Event Location</label>
                    </h5>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <iframe frameborder="0" height="480px" id="srcId" src="" width="100%" allowfullscreen>
                    </iframe>
                </div>

            </div>
        </div>
    </div>