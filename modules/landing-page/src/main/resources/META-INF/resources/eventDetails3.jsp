<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="landing.page.portlet.LandingPagePortlet"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.calendar.model.CalendarBooking"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%
String test;
String userId = renderRequest.getRemoteUser();
String eventId = "3402";
String loggedInUser = renderRequest.getRemoteUser();
//renderRequest.getParameter("calendarBookingId");
System.out.println("eventId "+eventId);
System.out.println("calendarBookingId "+renderRequest.getParameter("calendarBookingId"));
LandingPagePortlet evt = new LandingPagePortlet();
CalendarBooking  cb = evt.getEventDetails(renderRequest);
//int formId = evt.getFormAssociatedToTheEvent(Integer.parseInt(renderRequest.getParameter("calendarBookingId")));
int formId = 47806;
// String url = "http://localhost:8080/web/forms/shared/-/form/"+String.valueOf(formId)+"?eventId="+renderRequest.getParameter("calendarBookingId");
String url = "http://localhost:8080/web/forms/shared/-/form/"+String.valueOf(formId)+"?eventId="+renderRequest.getParameter("calendarBookingId");
System.out.println("formId: "+url);
//int formId = (int) CalendarBookingLocalServiceUtil.getCalendarBooking(Integer.parseInt(renderRequest.getParameter("calendarBookingId"))).getExpandoBridge().getAttribute("FormId");
System.out.println("formId: "+formId);

/* CalendarBooking event = evt.getEventDetails(renderRequest,Long.parseLong(eventId));

System.out.println("event.getTitleCurrentValue: "+event.getTitleCurrentValue());
System.out.println("event.getUserId():          "+event.getUserId());
System.out.println("event.getUserId():          "+event.getUserName());
System.out.println("event.getCompanyId:         "+event.getCompanyId());
System.out.println("event.getDuration:          "+event.getDuration());
System.out.println("event.getUserUuid:          "+event.getUserUuid());
System.out.println("event.getVEventUid():       "+event.getVEventUid());
System.out.println("event.getStatus()    :      "+event.getStatus()) ;
System.out.println("event.getStatusByUserName()    :      "+event.getStatusByUserName()) ;
System.out.println("event.getCalendar().getTimeZone()    :      "+event.getCalendar().getTimeZone()) ;
System.out.println("event.getDescription()    :      "+event.getDescription()) ;
System.out.println("event.getCalendar().getCreateDate()    :      "+event.getCalendar().getCreateDate()) ;
System.out.println("event.getCalendar().getLastPublishDate()    :      "+event.getCalendar().getLastPublishDate()) ;
System.out.println("event.getCalendarBookingId()    :      "+event.getCalendarBookingId()) ; */

%>

<html>

<head>
    <meta charset="utf-8" />
    <title>MISK</title>
 
    
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

        ::-webkit-input-placeholder { /* Edge */ color: #ffffff !important; }

        :-ms-input-placeholder { /* Internet Explorer 10-11 */ color: #ffffff !important; }

        ::placeholder { color: #ffffff !important; }

        .main-title { font-family: Montserrat-SemiBold; color: #042f3f; font-size: 24px; }
        .sub-title { color: #7DB72C; font-family: Montserrat-Regular; font-size: 16px; }
        .diescription-text { font-family: Montserrat-Regular; color: #042f3f; font-size: 16px; }
        .newsdatecolor { color: #ff8400 !important; }
        .newstextcolor { color: #3e3e3e !important; }
        .newsarrowcolor { color: #3e3e3e !important; }
        .top-image-margin { margin-top: 0px; box-shadow: 0px 14px 15px #002D4F21; max-width: 420px; min-width: 400px; min-height: 250px; max-height: 300px; }


        a.nav-link { text-decoration: none; color: #b1bec4 !important; font-family: Montserrat-Bold; font-size: 18px; }
        ul#topmenu.navbar-nav li.nav-item.active { border-bottom: 1px solid #ffffff; }
        .nav-pills .nav-link.active, .nav-pills .show > .nav-link { border-bottom: 3px solid #7db72c; border-bottom-width: 3px; color: #7db72c !important; background-color: transparent !important; font-family: Montserrat-Bold; font-size: 18px; border-radius: 0px !important }

        .navbar-nav .nav-item.active { border-bottom: 3px solid #7db72c; border-bottom-width: 3px; color: #7db72c !important; background-color: transparent !important; }
        .hrcustom { width: 40px !important; border-bottom: 1px solid #7db72c !important; margin-bottom: 25px !important;  }

        .container-menu { position: relative; background: url(/o/new-misk-theme/images/landing/topmenu.png); width: -webkit-fill-available; }
        body { background-color: #f8f9fa; font-family: Montserrat-Regular; }
        #event-detail { background-image: url('/o/new-misk-theme/images/eventListImages/whitebg.png'); background-repeat: no-repeat; padding: 25px; background-position-x: -30px; border-radius: 5px !important; position: relative; top: 35px; }

        .btn-green { background: #00aa60; color: #fff !important; padding-left: 20px; padding-right: 20px; }
        .btn-greentext { background: #fff; color: #afd189 !important; }

        .deadline-text { color: #042F3F4A; margin-top: 15px !important; margin-bottom: 20px !important; font-family: Montserrat-Regular; font-size: 16px; }
        .tab-boder-bottom { border-bottom: 1px solid #bbc6cb; }
        .title-text { font-family: Montserrat-SemiBold; color: #042F3F; font-size: 16px }
        .para-text { font-family: Montserrat-Regular; color: #042f3f; font-size: 16px; }
        newupdate-section { margin: 0 0 30px 0 }

        .card-footer { border-top: 0 !important; width: 100%; background-color: transparent !important; borer: 0; padding: 5px 15px 10px 0px; display: table }

        .newsarrowcolor { color: #3e3e3e !important; font-size: 12px !important; }
        .card-img-top { max-height: 240px }

        #createaccount-section { background-color: #7db72c; color: white; padding: 15px; }
        #createaccount-section h3 { font-family: Montserrat-SemiBold; color: white; font-size: 34px; }
        #createaccount-section p { font-family: Montserrat-Light; color: #d3e5c0; font-size: 16px; opacity: 0.8 }
        #createaccount-section label { font-family: Montserrat-Light; color: #eaf2e2; font-size: 12px; }
        .cutomtextbox { height: 25px !important; font-family: Montserrat-Light; color: #eaf2e2; font-size: 12px; }
        select.cutomtextbox option { color: #000 }
        .eventnews { max-height: 450px !important; }
        .eventnews .card-body { min-height: 170px; }
        .news-date { color: #ff8400; font-family: Montserrat-Regular; font-size: 14px; }
        .news-text { color: #3e3e3e; font-family: Montserrat-Regular; font-size: 20px; }
        .summary { padding-left: 20%; padding-top: 10%; }
        summary p, .footer-desc { font-family: Montserrat-light; }
        .image-container { max-width: 300px !important; max-height: 180px !important; overflow: hidden;}
        .image-container img { width: 276px; height: 170px; }

        #footer-section { background: #0ca2cd; background-image: none !important; padding-bottom: 0 !important }
        .col-md-12.footer-desc { font-size: 16px !important; line-height: 2 !important; color: ##cee4ee; font-family: Montserrat-Light; }
        .footerlink li a { color: #cee4ee !important }
        ul#myTab li { padding-right: 52px; padding-left: 30px; }
        .news-title-semi { margin: 0 !important; font-family: Montserrat-SemiBold; color: #042F3F; font-size: 34px; letter-spacing: 0; opacity: 1; }
        #AlleventTabContent img { box-shadow: 0px 13px 15px #002D4F21; }
        .portlet { margin-bottom: 0 !important }
        .highlisghts { font-family: Montserrat-Medium; color: #042F3F4A; font-size: 16px; }


        #header-section { background-size: 100% 100% !important; }

        /*end of header customization*/


        .container-fluid { padding-right: 0 !important; padding-left: 0 !important; }

        #intro-title { padding-top: 10% !important; margin-left: 10%; padding-bottom: 8%; }
            #intro-title h3 { font-family: Montserrat-Regular !important; font-size: 24px !important; color: #ffffff !important; }
            #intro-title h1 { font-family: Montserrat-Bold !important; font-size: 44px !important; color: #ffffff !important; padding-top: 15px; }

		/* TimeLine style */
		
		  .head-day-text { 
            font-family:Montserrat-SemiBold;
            font-size:25px;
           color: #042F3F9D;
        }
        .head-date-text { 
            font-family:Montserrat-Regular;
            font-size:20px;
            color: #7DB72C;
          
        }
        .brief-text { 
            font-family:Montserrat-Regular;
            color:#042F3F;
            font-size:16px;
        }
        .time-text { 

            font-family:Montserrat-Regular;
            color:#042F3F4A;
            font-size:16px;
        }
        
		/*end of timeline*/
		
		/*Accordin Style*/
		
		#accordion .card { 

            background-color:#f8f9fa !important;
            border:none !important;
            box-shadow:none !important;
        }
        
         #accordion .card-header { 
              background-color: #f8f9fa;
             border-bottom: 1px solid #bbc6cb !important;
             padding:0px !important;
             padding-bottom:20px !important;
        }
         #accordion .card-link { 
             text-decoration:none;
             font-size:18px;
             color:#042F3F !important;
             font-family:Montserrat-Medium;
             padding-left:20px;
        }
         #accordion .card-body {
             text-decoration:none;
             font-size:16px;
             color:#042F3F !important;
             font-family:Montserrat-Regular;
             border-bottom: 1px solid #eee !important;
        }
        .fa-chevron-down { 
            color:#818282;
            font-size: 15px;
        }
        
        .join-button-signin{
		top:25px !important;
		}
		.register-button-scroll {
    	margin: 0% 5%;
		}
        @media screen and (max-width: 1920px) {
            #intro-title { padding-top: 10% !important; margin-left: 10%; }
        }

        @media screen and (max-width: 1680px) {

            #intro-title { padding-top: 10% !important; margin-left: 10%; }
        }

        @media screen and (max-width: 1600px) {
            #intro-title { padding-top: 10% !important; margin-left: 9%; }
        }

        @media screen and (max-width: 1366px) {
            /* insert styles here */
            #intro-title { padding-top: 10% !important; margin-left: 9%; }
        }

        @media screen and (max-width: 1280px) {
            #intro-title { padding-top: 10% !important; margin-left: 5%; }
        }
        /* Create Section */

        select.selectrole { border: 0px solid #ffffff !important; border-bottom: 1px solid #ffffff !important; border-radius: 0; background-image: url(/o/new-misk-theme/images/eventListImages/icons8-expand-arrow-24.png) !important; background-repeat: no-repeat !important; background-position: right !important; width: 100%; font-family: Montserrat-Regular !important; font-size: 15px !important; background-color: transparent !important; color: #ffffff; font-size: 16px; height: 40px; box-shadow: none !important; }
        .selectrole > option { background-color: #ffffff; color: #898b8e; }

        .cutomtextbox { height: 40px !important; font-family: Montserrat-Regular; color: #eaf2e2; font-size: 15px; border-radius: 0px; background-color: transparent !important; padding: 10px; }
            .cutomtextbox:focus { box-shadow: none !important; }
        .btn-singin { color: white; border-color: white; padding-left: 45px !important; padding-right: 45px !important; padding-top: 7px !important; padding-bottom: 7px !important; font-family: Montserrat-Medium !important; font-size: 14px !important; }
        .btn-greentext { background: #fff; color: #afd189 !important; font-family: Montserrat-Medium; font-size: 14px; padding-left: 45px !important;; padding-right: 45px !important; padding-top: 7px !important; padding-bottom: 7px !important; }
        .whitebutton:hover { color: #898b8e; }
        /*end create section*/
        .event-detail-image { padding-top: 90%; position: relative; right: 150%; }

        @media screen and (max-width: 800px) {
            .social-media-icons { margin-top: -10px; margin-left: -15px; }
            section { padding: 0px 0; }
            #logoImg { display: none; }
            #header { padding-bottom: 5px; height: 0px; }
            .event-detail-image { padding-top: 0%; position: relative; right: 0%; }
            .top-image-margin { max-width: 100%; max-height: 100%; }
        }

        @media screen and (max-width: 1024px) and (min-width: 801px) {
            .social-media-icons { margin-top: -30px; margin-left: -15px; }
            section { padding: 0px 0; }
            #logoImg { display: none; }

            #header { padding-bottom: 5px; height: 0px; }
            .event-detail-image { padding-top: 0%; position: relative; right: 0%; }
            .top-image-margin { max-width: 100%; max-height: 100%; }
        }
    </style>
    <script>
        function openQuestioneer() {
            window.open("http://localhost:8080/web/forms/shared/-/form/<%=formId%>");
        }

        if (<%= loggedInUser %>== null )
        {
            var backOfferButton = document.getElementById('submitButtonId');
            backOfferButton.dataset.target = "#/c/portal/login";
        }

    </script>
</head>
<body>
    <div class="container-fluid">
    <div id="header-section">
     <div id="intro-title" class="container">
    <h3><span style="border-bottom:2px solid #eee;padding-bottom:15px;">Eve</span>nts</h3>
            <h1>We Bring Young Leaders Together</h1>
    </div>
     </div>
    <div id="event-detail-section" style="margin-top: -100px;"> 
        <div class="container" >
            <div class="row">
                <div class="col-md-10 pt-3">
                <div class="card" style="padding-top: 15px;padding-left: 15px; min-height: 560px;">
                <div class="card-body">                
                <p class="highlisghts">HIGHLIGHTS</p>               
                    <h3 class="main-title">
                       <%= cb.getTitleCurrentValue() %>                       
                    </h3>
                <p>
                <span style="margin-right: 5px !important">
                    <img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" alt="location marker" />
                </span> 
                <span class="sub-title">Riyadh, Saudi Arabia</span>
                </p>
                <div class="diescription-text" style="padding-right: 32%;">
                       <%= cb.getDescription()%> 
                                            
                </div>
                <p class="deadline-text">Deadline is July 26,2019</p>
                <p>
                        <a class="btn btn-green" id="submitButtonId" data-toggle="modal" data-target="#myform">Youth Registartion</a>

                        <a style="margin-left:3%;" class="btn btn-green" id="submitButtonId" data-toggle="modal" data-target="#myformSpeaker">Submit as Speaker</a>
                </p>
                </div>
                </div>
                </div>
                <div class="col-md-2">
                    <div class="event-detail-image">   
                    <!-- <img class="img-fluid rounded top-image-margin" src="<%= evt.getImageBybookingEvent(cb.getCalendarBookingId()) %>" /> -->                     
                        <img class="img-fluid rounded top-image-margin" src="/o/new-misk-theme/images/eventListImages/event-news-3.png" />
                    </div>
                </div>
            </div>
        </div>
     </div>
     
    
    <section id="other-section" class="container py-5">
        <div class="row">
            <div class="col-md-12 pt-2 tab-boder-bottom">
                <ul class="nav nav-pills" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="Allevent" data-toggle="tab" href="#AlleventTabContent" role="tab" aria-controls="AlleventTabContent" aria-selected="true">What do Startups get?</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="foryou" data-toggle="tab" href="#foryouTabContent" role="tab" aria-controls="foryouTabContent" aria-selected="true">Program timeline</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="thisWeekend" data-toggle="tab" href="#thisWeekendTabContent" role="tab" aria-controls="thisWeekendTabContent" aria-selected="true">Selection criteria</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="thismonth" data-toggle="tab" href="#thismonthTabContent" role="tab" aria-controls="thismonthTabContent" aria-selected="true">FAQs</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="tab-content pt-5" id="myTabContent">
                    <div class="tab-pane fade show active" id="AlleventTabContent" role="tabpanel" aria-labelledby="Allevent" style="padding-left:10%;padding-right:10%">
                        <div class="row p-2">
                            <div class="col-md-4">
                            <div class="image-container">
                            <img class="img-fluid" src="/o/new-misk-theme/images/eventListImages/Details-event-1.png" />
                            </div>                                
                            </div>
                            <div class="col-md-8 pl-5">
                                <div class="hrcustom"></div>
                                <div class="title-text">Knowledge</div>
                                <p class="para-text" >
                                    You'll  get access to mentors from the 500
                                    Startups global team and partners. Mentors will be
                                    available for 1:1 meetings and can share wisdom
                                    from the Silicon Valley enterprepreneurial experience.
                                </p>
                            </div>
                        </div>
                        <div class="row p-2">
                         <div class="col-md-4">
                            <div class="image-container">
                                <img class="img-fluid" src="/o/new-misk-theme/images/eventListImages/Details-event-2.png" />
                               </div>
                            </div>
                            <div class="col-md-8 pl-5">
                                <div class="hrcustom"></div>
                                <div class="title-text">Lectures</div>
                                <p class="para-text" >
                                    Lectures from members of the 500 and notable guests on
                                    marketing, monetization,production design and more
                                </p>
                            </div>                           
                        	</div>
                        <div class="row p-2">
                            <div class="col-md-4">
                            <div class="image-container">
                                <img class="img-fluid" src="/o/new-misk-theme/images/eventListImages/Details-event-3.png" />
                                </div>
                            </div>
                            <div class="col-md-8 pl-5">
                                <div class="hrcustom"></div>
                                <div class="title-text">Community</div>
                                <p class="para-text" >
                                    Work with your team as part of a carefully
                                    selected community of the awesome startups!.
                                </p>
                            </div>
                        </div>
                        <div class="row p-2">
                         <div class="col-md-4">
                            <div class="image-container">
                                <img class="img-fluid" src="/o/new-misk-theme/images/eventListImages/Details-event-4.png" />
                                </div>
                            </div>
                            <div class="col-md-8 pl-5">
                                <div class="hrcustom"></div>
                                <div class="title-text">Investment</div>
                                <p class="para-text" >
                                    $50K Investment per participating startup
                                    from 500 Falcons and possibly additional
                                    investment from affiliates.
                                </p>
                            </div>                           
                        </div>
                    </div>
                    <div class="tab-pane fade" id="foryouTabContent" role="tabpanel" aria-labelledby="foryou">
                    
                     <div id="timeline" class="container" style="padding-left:4%;padding-right:3%">
            <div class="row">
                <div class="col-md-6">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="head-day-text">Day 1</div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="head-date-text">Saturday, June 8</div>
                        </div>
                    </div>
                    <div class="row pt-3">
                        <div class="col-md-4">
                            <span class="time-text">10.00 AM</span>
                        </div>
                        <div class="col-md-8">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="brief-text">
                                        Register opens, Beverages served. Come Alone?
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row pt-3">
                        <div class="col-md-4">
                            <span class="time-text">12.00-2.00 PM</span>
                        </div>
                        <div class="col-md-8">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="brief-text">
                                        Use the opportunty to find a team!
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row pt-3">
                        <div class="col-md-4">
                            <span class="time-text">2.00 PM Lunch</span>
                        </div>
                        <div class="col-md-8">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="brief-text">
                                        HACKATHON KICK-OFF, Initial Pitches & Team Formation
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row pt-3">
                        <div class="col-md-4">
                            <span class="time-text">7.30 PM Dinner</span>
                        </div>
                        <div class="col-md-8">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="brief-text">
                                        Speed dating with Coaches & Hacking Kickoff
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>                
                <div class="col-md-6">
                    <div class="row">                      
                      <div class="col-md-12">
                      <div class="head-day-text">Day 2</div>
                      </div>
                      </div>
                      <div class="row">
                                <div class="col-md-12">
                                    <div class="head-date-text">Saturday, June 9</div>
                                </div>
                        </div>                      
                 
                    <div class="row pt-3">
                        <div class="col-md-4">
                            <span class="time-text">10.00 AM</span>
                        </div>
                        <div class="col-md-8">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="brief-text">
                                        Register opens, Beverages served. Come Alone?
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row pt-3">
                        <div class="col-md-4">
                            <span class="time-text">12.00-2.00 PM</span>
                        </div>
                        <div class="col-md-8">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="brief-text">
                                        Use the opportunty to find a team!
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row pt-3">
                        <div class="col-md-4">
                            <span class="time-text">2.00 PM Lunch</span>
                        </div>
                        <div class="col-md-8">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="brief-text">
                                        HACKATHON KICK-OFF, Initial Pitches & Team Formation
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row pt-3">
                        <div class="col-md-4">
                            <span class="time-text">7.30 PM Dinner</span>
                        </div>
                        <div class="col-md-8">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="brief-text">
                                        Speed dating with Coaches & Hacking Kickoff
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            

        </div>
                    
                    </div>
                    <div class="tab-pane fade" id="thisWeekendTabContent" role="tabpanel" aria-labelledby="thisWeekend">
                        <div class="row">
                            <div class="col-md-12 text-center">
                                <h3 class="text-warning">In Progress</h3>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="thismonthTabContent" role="tabpanel" aria-labelledby="thismonth" style="padding-left:10%;padding-right:10%">
                        
                             <div id="accordion">
                <div class="card">
                    <div class="card-header">
                        <a class="card-link" data-toggle="collapse" href="#collapseOne">
                            Arabic Greetings <span class="float-right pr-4"> <i class="fa fa-chevron-down"></i> </span>
                        </a>
                    </div>
                    <div id="collapseOne" class="collapse" data-parent="#accordion">
                        <div class="card-body">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
                            Cultural and Local Specificity <span class="float-right pr-4"> <i class="fa fa-chevron-down"></i> </span>
                        </a>
                    </div>
                    <div id="collapseTwo" class="collapse" data-parent="#accordion">
                        <div class="card-body">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">
                           Where to say <span class="float-right pr-4"> <i class="fa fa-chevron-down"></i> </span>
                        </a>
                    </div>
                    <div id="collapseThree" class="collapse" data-parent="#accordion">
                        <div class="card-body">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                        </div>
                    </div>
                </div>
                 <div class="card">
                    <div class="card-header">
                        <a class="collapsed card-link" data-toggle="collapse" href="#collapseFour">
                           Travel and Transportation <span class="float-right pr-4"> <i class="fa fa-chevron-down"></i> </span>
                        </a>
                    </div>
                    <div id="collapseFour" class="collapse" data-parent="#accordion">
                        <div class="card-body">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header">
                        <a class="collapsed card-link" data-toggle="collapse" href="#collapseFive">
                           What you need to Know <span class="float-right pr-4"> <i class="fa fa-chevron-down"></i> </span>
                        </a>
                    </div>
                    <div id="collapseFive" class="collapse" data-parent="#accordion">
                        <div class="card-body">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                        </div>
                    </div>
                </div>
            </div>
                       
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section id="newupdate-section" class="container-fluid mt-5">
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <h3 class="news-title-semi">News Updates</h3>
            </div>
        </div>
        </div>
        <div class="container mt-5 news-container">
            <div class="row">
                <div class="col-md-4">
                    <div class="card eventnews">
                        <img class="card-img-top img-responsive" src="/o/new-misk-theme/images/eventListImages/event-news-1.png" alt="Card image">
                        <div class="card-body">
                            <p><span class="news-date">08 Feb 2019</span></p>
                            <p class="news-text">
                                Accelerator youth training programme launches at The Warehouse
                            </p>
                        </div>
                        <div class="card-footer">
                            <a href="#">
                                <span class="pt-2 float-right">
                                    <i class="fa fa-arrow-right newsarrowcolor"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card eventnews">

                        <img class="card-img-top img-responsive" src="/o/new-misk-theme/images/eventListImages/event-news-2.png" alt="Card image">
                        <div class="card-body">
                            <p><span class="news-date">24 Aug 2018</span></p>
                            <p class="news-text">
                                New partnership to provide social record platform for young people
                            </p>
                        </div>
                        <div class="card-footer">
                            <a href="#">
                                <span class="pt-2 float-right">
                                    <i class="fa fa-arrow-right newsarrowcolor"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card eventnews">
                        <img class="card-img-top img-responsive" src="/o/new-misk-theme/images/eventListImages/event-news-3.png" alt="Card image">
                        <div class="card-body">
                            <p><span class="news-date">28 Nov 2018</span></p>
                            <p class="news-text">
                                Kiwi Social Network Embraced by Youth
                            </p>
                        </div>
                        <div class="card-footer">
                            <a href="#">
                                <span class="pt-2 float-right">
                                    <i class="fa fa-arrow-right newsarrowcolor"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="container-fluid" id="createaccount-section">       
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

                            <select class="form-control selectrole" id="role" name="role">
                                <option selected="selected" value="">Select your role</option>
                                <option value="">Role</option>
                                <option value="">Manager</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 form-group">                          
                            <input type="text" class="cutomtextbox" id="firstname" name="firstname" placeholder="Firt Name" autocomplete="nope" />
                        </div>
                        <div class="col-md-6 form-group">                          
                            <input type="text" class="cutomtextbox" id="lastname" name="lastname" placeholder="Last Name" autocomplete="nope" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group">                     
                            <input type="email" class="cutomtextbox" id="email" name="email" placeholder="Email"  autocomplete="nope" />
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
    </section>
    
   
</div>
    <div class="modal fade" id="myform" tabindex="-1" role="dialog" aria-labelledby="addlanguageLabel" aria-hidden="true">
     <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header text-white bg-info">
                    <h5 class="modal-title" id="addlanguageLabel">
                        <label>Apply For Event</label>
                    </h5>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <iframe frameborder="0" height="600px" src=<%=url%> width="100%">
                    </iframe>
                </div>

            </div>
        </div>
    </div>
</body>
</html>