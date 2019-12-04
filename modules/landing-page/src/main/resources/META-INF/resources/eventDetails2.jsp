<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="landing.page.portlet.LandingPagePortlet"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.calendar.model.CalendarBooking"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="landing.page.portlet.vo.SpeakerVO"%>
<%@page import="landing.page.portlet.vo.SpeakerNVO"%>
<%@page import="landing.page.portlet.vo.TimeLineVO"%>
<%@page import="landing.page.portlet.vo.QuestionsAndAnswers"%>
<%@page import="landing.page.portlet.vo.HighLightsVO"%>
<%@page import="landing.page.portlet.vo.TimeLinedayObject"%>
<%@page import="landing.page.portlet.vo.EventTimeDescripiton"%>
<%@page import="java.util.ArrayList"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%
Calendar c = Calendar.getInstance();
String test;
String userId = renderRequest.getRemoteUser();
String eventId = "3402";
String loggedInUser = renderRequest.getRemoteUser();
//renderRequest.getParameter("calendarBookingId");
System.out.println("eventId "+eventId);
System.out.println("calendarBookingId "+renderRequest.getParameter("calendarBookingId"));
LandingPagePortlet evt = new LandingPagePortlet();
CalendarBooking  cb = evt.getEventDetails(renderRequest);
//JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
//List<SpeakerVO>  objlst =evt.getSpeakersMetada(cb);
List<SpeakerNVO>  objlst =evt.getSpeakersNMetada(cb);
// List<TimeLineVO>  objlstTl =evt.getTimeLineMetada(cb);
List<TimeLinedayObject>  objlstTl =evt.getTimeLineMetada(cb);
List<QuestionsAndAnswers>  objlstQA =evt.getQuestionsAndAnswersMetada(cb);
List<HighLightsVO>  objlstHL =evt.getHighLightsNMetada(cb);
System.out.println("-------event Details:----objlst.size()----:: "+objlst.size()+"---timeline size:: "+objlstTl.size());
int formId = evt.getFormAssociatedToTheEvent(Integer.parseInt(renderRequest.getParameter("calendarBookingId")));
System.out.println("formId:::  "+formId);
//String url = "https://webserver-miskfoundation-dev.lfr.cloud/web/forms/shared/-/form/"+String.valueOf(formId)+"?eventId="+renderRequest.getParameter("calendarBookingId");
String url = "http://localhost:8080/web/forms/shared/-/form/"+String.valueOf(formId)+"?eventId="+renderRequest.getParameter("calendarBookingId");

//int formId = (int) CalendarBookingLocalServiceUtil.getCalendarBooking(Integer.parseInt(renderRequest.getParameter("calendarBookingId"))).getExpandoBridge().getAttribute("FormId");
System.out.println("formId: "+formId);

int mYear = 0;
int mMonth = 0;  
int eMonth = 0; 
int mDay = 0  ; 
int hr = 0    ;  
int min = 0; 
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

c.setTimeInMillis(cb.getStartTime());
mMonth =  c.get(Calendar.MONTH);
mYear = c.get(Calendar.YEAR);
mDay = c.get(Calendar.DAY_OF_MONTH);
hr = c.get(Calendar.HOUR);
min  = c.get(Calendar.MINUTE);

 mMonthF = String.format("%02d", mMonth);
 mDayFS = String.format("%02d", mDay);
 hrF = String.format("%02d", hr);
 minF = String.format("%02d", min);
// ----------------------------------------------------------------
 c.setTimeInMillis(cb.getEndTime());
 mDay = c.get(Calendar.DAY_OF_MONTH);
 mDayFE = String.format("%02d", mDay);
 location = cb.getLocation();
 String startMonthName="";
 String endMonthName="";
 DateFormatSymbols dfs = new DateFormatSymbols();
 String[] months = dfs.getMonths();
 if (mMonth >= 0 && mMonth <= 11 ) {
	 startMonthName = months[mMonth];
 }
 if (eMonth >= 0 && eMonth <= 11 ) {
	 endMonthName = months[mMonth];
 }
 
 System.out.println("-------event Details:--------month  "+mMonth+"---"+mMonthF+"--year-"+mYear+"--location: "+location+" startMonth: "+startMonthName+"--endMonthName--: "+endMonthName);
%>

<html>

<head>
    <meta charset="utf-8" />
    <title>MISK</title>


    <link href="/o/new-misk-theme/css/font/font-awesome/font-awesome.min.css" rel="stylesheet" />
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






        .newsarrowcolor { color: #3e3e3e !important; }



        a.nav-link { text-decoration: none; color: #b1bec4 !important; font-family: Montserrat-Bold; font-size: 18px; }
        ul#topmenu.navbar-nav li.nav-item.active { border-bottom: 1px solid #ffffff; }
        .nav-pills .nav-link.active, .nav-pills .show > .nav-link { border-bottom: 3px solid #7db72c; border-bottom-width: 3px; color: #7db72c !important; background-color: transparent !important; font-family: Montserrat-Bold; font-size: 18px; border-radius: 0px !important }

        .navbar-nav .nav-item.active { border-bottom: 3px solid #7db72c; border-bottom-width: 3px; color: #7db72c !important; background-color: transparent !important; }
        .hrcustom { width: 40px !important; border-bottom: 1px solid #7db72c !important; margin-bottom: 25px !important; }

        .container-menu { position: relative; background: url(/o/new-misk-theme/images/landing/topmenu.png); width: -webkit-fill-available; }
        body { background-color: #f8f9fa; font-family: Montserrat-Regular; }


        .btn-green { background: #00aa60; color: #fff !important; padding-left: 20px; padding-right: 20px; }
        .btn-greentext { background: #fff; color: #afd189 !important; }


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

        .eventnews { max-height: 450px !important; }
            .eventnews .card-body { min-height: 170px; }
        .news-date { color: #ff8400; font-family: Montserrat-Regular; font-size: 14px; }
        .news-text { color: #3e3e3e; font-family: Montserrat-Regular; font-size: 20px; }
        .summary { padding-left: 20%; padding-top: 10%; }
        summary p, .footer-desc { font-family: Montserrat-light; }
        .image-container { max-width: 300px !important; max-height: 180px !important; overflow: hidden; }


        #footer-section { background: #0ca2cd; background-image: none !important; padding-bottom: 0 !important }
        .col-md-12.footer-desc { font-size: 16px !important; line-height: 2 !important; color: ##cee4ee; font-family: Montserrat-Light; }
        .footerlink li a { color: #cee4ee !important }

        .news-title-semi { margin: 0 !important; font-family: Montserrat-SemiBold; color: #042F3F; font-size: 34px; letter-spacing: 0; opacity: 1; }

        .portlet { margin-bottom: 0 !important }



        #header-section { background-size: 100% 100% !important; }

        /*end of header customization*/


        .container-fluid { padding-right: 0 !important; padding-left: 0 !important; }

        #intro-title { padding-top: 10% !important; margin-left: 10%; padding-bottom: 8%; }
            #intro-title h3 { font-family: Montserrat-Regular !important; font-size: 24px !important; color: #ffffff !important; }
            #intro-title h1 { font-family: Montserrat-Bold !important; font-size: 44px !important; color: #ffffff !important; padding-top: 15px; }

        /* Detial Section  */

        .swal-button { background: #00AE8D !important; }
        .swal-button { padding: 3px 24px; }

        button.button.orange { background-color: #FDB253; }
        small { font-size: 1.1rem; line-height: inherit; }
        blockquote { margin: 4.2rem 0; padding-left: 4.2rem; position: relative; }
            blockquote:before { content: "\201C"; font-size: 10rem; line-height: 0px; margin: 0; color: rgba(0, 0, 0, 0.2); font-family: Montserrat-Regular; position: absolute; top: 3.6rem; left: 0; }
            blockquote p { font-family: Montserrat-Regular; padding: 0; font-size: 2.2rem; line-height: 1.75; }
            blockquote cite { display: block; font-family: Montserrat-Regular; font-size: 1.4rem; font-style: normal; line-height: 1.714; }
                blockquote cite:before { content: "\2014 \0020"; }
                blockquote cite a, blockquote cite a:visited { color: #373737; border: none; }
        abbr { font-family: Montserrat-Regular; font-variant: small-caps; text-transform: lowercase; letter-spacing: .05rem; color: #2b2b2b; }
        var, kbd, samp, code, pre { font-family: Montserrat-Regular }
        pre { padding: 2.4rem 3rem 3rem; background: #EAEAEA; margin: 4.2rem 0; }
        code { font-size: 1.4rem; margin: 0 .2rem; padding: .3rem .6rem; white-space: nowrap; background: #EAEAEA; }
        pre > code { display: block; white-space: pre; line-height: 2; padding: 0; margin: 0; }
        pre.prettyprint > code { border: none; }
        del { text-decoration: line-through; }
        abbr[title], dfn[title] { border-bottom: 1px dotted; cursor: help; }
        mark { background: #FFF49B; color: #000; }
        hr { border: solid #c2c2c2; border-width: 1px 0 0; clear: both; margin: 2.4rem 0 1.5rem; height: 0; }

        /* -------------------------------------------------------------------
        * Lists - (_document-setup.scss)
        * ------------------------------------------------------------------- */

        .Carousel_row { width: 100%; height: 470px; /* background-color: pink */ }
        .carousel_inner_event_2 { padding: 10px 10px 20px 10px; box-sizing: border-box }
        .carousel_slider { width: 100%; height: 470px; }
        .wrapper_block { height: 470px; }
        .white_block { width: 50%; height: 470px; background-color: white; float: left; left: 0 !important; bottom: 0 !important; border-radius: 4px; box-shadow: 0px 3px 5px #bbb; box-sizing: border-box; color: #042f3f !important; text-align: left; padding: 3% 7% 3% 5%;  }



            .white_block p { margin-top: 15px; }
            .white_block span img { vertical-align: middle; line-height: 0; }
        .top_event_img { width: 55%; height: 400px; right: 0 !important; border-radius: 4px; box-shadow: 0px 3px 5px #bbb; display: block; position: absolute; z-index: 10; margin-top: 25px; /* position: absolute; */ }
        .btn_misk { background-color: #00aa60; font-size: 1.6rem !important; border: #00aa60; min-width: 80px; transition: background-color ease 1s; }
            .btn_misk:hover { background-color: #00c46f; }
        .carousel_event_2 { right: 0 !important; left: 15% !important; }

        .carousel_event_2 li { text-indent: 0 !important; color: #042F3F4A !important; background-color: transparent; height: 5px; font-size: 12px; opacity: 1 !important;  font-family: Montserrat-Medium; }
        .carousel_event_2 li.active { font-size: 16px; color: #00AA60 !important; font-family: Montserrat-Medium; }
        .a_event_2 { z-index: 10; top: 465px !important; bottom: 12px !important; width: 20px; }
        .a_event_right_2 { justify-content: right; right: 10px !important; }
        .a_event_left_2 { left: 95% !important; }
        .right_arrow { background: url('/o/new-misk-theme/images/eventListImages/arrow-right.svg') no-repeat !important; }
        .left_arrow { background: url('/o/new-misk-theme/images/eventListImages/arrow-left.svg') no-repeat !important; }

        .second_container_event_2 { margin-top: 60px; text-align: center; }
            .second_container_event_2 h2 { font-family: Montserrat-SemiBold; font-size: 34px; color: #042F3F; }

        .courses_coursel { width: 100%; min-height: 370px; margin-top: 20px; }
        .carousel_slider_courses { width: 100%; min-height: 370px; }
        .carousel_wrapper_block { height: 370px; }
        .carousel_white_block { width: 80%; height: 370px; margin: 0 auto; border-radius: 4px; box-shadow: 0px 3px 5px #bbb; left: 0 !important; right: 0 !important; background-color: white; box-sizing: border-box; color: #042f3f !important; text-align: left; padding: 3% 3% 3% 25%;  top: 10px }
            .carousel_white_block h3 { font-weight: bold; }


            .carousel_white_block p { margin-top: 15px; }
            .carousel_white_block span img { vertical-align: middle; line-height: 0; }
        .courses_left_img { width: 30%; height: 360px; left: 0 !important; top: 0px !important; border-radius: 4px; box-shadow: 0px 3px 5px #bbb; display: block; position: absolute; z-index: 10; }
        .carousel_courses_2 { position: absolute; top: 360px; margin-left: 2% !important; }
            .carousel_courses_2 li { background-color: #b1bec4 !important; height: 2px; opacity: 1 !important; width: 40px; }
                .carousel_courses_2 li.active { background-color: #00c46f !important; }

        .carousel_white_block.carousel_padding { padding: 3% 25% 3% 3%; }
        .courses_right_img { width: 30%; height: 360px; right: 0 !important; top: 0px !important; border-radius: 4px; box-shadow: 0px 3px 5px #bbb; display: block; position: absolute; z-index: 10; }

        .carousel_courses_2_2 { position: absolute; top: 360px; margin-left: -41% !important; }
            .carousel_courses_2_2 li { background-color: #b1bec4 !important; height: 2px; opacity: 1 !important; width: 40px; }
                .carousel_courses_2_2 li.active { background-color: #00c46f !important; }

        .highlight-text { font-family: Montserrat-Medium; color: #042F3F4A; font-size: 16px; }
        .main-title { font-family: Montserrat-SemiBold; color: #042f3f; font-size: 24px; }
        .sub-title { color: #7DB72C; font-family: Montserrat-Regular; font-size: 16px; }
        .discription-text { font-family: Montserrat-Regular; color: #042f3f; font-size: 16px; }
		
		ul.carousel-indicators.carousel_event_2 li{
			width: 0px;
    		height: 0px;
    		border-radius: 0 !important;
    		background-color: transparent !important;
    		padding-left:5%;
		}
		.carousel-indicators {
    		bottom: 0px;
		}
		.join-button-signin{
		top:25px !important;
		}
		.register-button-scroll {
    	margin: 0% 5%;
		}
        @media only screen and (max-width:1210px) {
            .a_event_left_2 { left: 94% !important; }
            .carousel_courses_2 { margin-left: 5% !important; }
            .carousel_courses_2_2 { margin-left: -38% !important; }
        }

        @media only screen and (max-width:1003px) {
            .a_event_left_2 { left: 92% !important; }
            .carousel_event_2 { left: 19% !important; }
            .carousel_white_block { width: 95%; padding: 3% 3% 3% 32%; }
                .carousel_white_block.carousel_padding { padding: 3% 32% 3% 3%; }
            .carousel_courses_2 { margin-left: 11% !important; }
            .carousel_courses_2_2 { margin-left: -44% !important; }
        }

        @media only screen and (max-width:780px) {
            .white_block { display: block !important; }
            .Carousel_row { margin-left: 0 !important; margin-right: 0 !important; }
            .white_block p { display: none; }
            .white_block { width: 100%; padding: 5% 5% 5% 5%; }
            .button_responsive { display: block; margin-top: 15px; }
            .carousel_event_2 { left: 0% !important; }
            .top_event_img { width: 80%; height: 250px; left: 0; margin: 0 auto; margin-top: 170px; }
            .a_event_2 { display: none; }
            .carousel_white_block { display: block !important; width: 100%; padding: 5% 5% 5% 5%; }
                .carousel_white_block.carousel_padding { padding: 5% 5% 5% 5%; }

                .carousel_white_block p { display: none; }
            .courses_coursel { margin-left: 0 !important; margin-right: 0 !important; }
            .courses_left_img, .courses_right_img { width: 80%; height: 200px; top: 140px !important; margin: 0 auto; left: 0 !important; right: 0 !important }
            .carousel_courses_2 { margin-right: 0 !important; margin-left: 0 !important; }
            .carousel_courses_2_2 { margin-left: 0 !important; margin-right: 0 !important; }
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


        @media screen and (max-width: 800px) {
            .social-media-icons { margin-top: -10px; margin-left: -15px; }
            section { padding: 0px 0; }
            #logoImg { display: none; }
            #header { padding-bottom: 5px; height: 0px; }
        }

        @media screen and (max-width: 1024px) and (min-width: 801px) {
            .social-media-icons { margin-top: -30px; margin-left: -15px; }
            section { padding: 0px 0; }
            #logoImg { display: none; }

            #header { padding-bottom: 5px; height: 0px; }
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
        <div id="event-detail-section" class="container" style="margin-top: -100px;">
            <div class="row Carousel_row">
                <div class="col-md-12">
                    <div id="demo" class="carousel slide carousel_slider" data-ride="carousel">

                        <!-- Indicators -->
                        <ul class="carousel-indicators carousel_event_2">
                            <li data-target="#demo" data-slide-to="0" class="active">01</li>
                            <li data-target="#demo" data-slide-to="1">02</li>
                            <li data-target="#demo" data-slide-to="2">03</li>
                        </ul>

                        <!-- The slideshow -->
                        <div class="carousel-inner carousel_inner_event_2">
                            <div class="carousel-item active wrapper_block">
                                <div class="carousel-caption d-none d-md-block white_block">
                                    <div class="highlight-text">HIGHLIGHTS</div>
                                    <div class="main-title"> Misk 501 AcceleratorProgram</div>
                                    <div>   <span class="pr-1"> <img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" alt="location marker" /></span> <span class="sub-title"> Riyadh, Jeddah, AL-Akbar </span> </div>
                                    <p class="discription-text pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric characters.
                                    </p>
                                    <div class="pt-3">
                                    <input class="btn btn-green" type="button" value="Join" />
                                    </div>                                    
                                </div>
                                <div class="top_event_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-1.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>

                            <div class="carousel-item  wrapper_block">
                                <div class="carousel-caption d-none d-md-block white_block">
                                    <div class="highlight-text">HIGHLIGHTS</div>
                                    <div class="main-title"> Misk 502 AcceleratorProgram</div>
                                    <div>
                                        <span class="pr-1">
                                            <img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" alt="location marker" />
                                        </span>  <span class="sub-title">Riyadh, Jeddah, AL-Akbar</span>
                                    </div>
                                    <p class="discription-text pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric characters.
                                    </p>
                                    <div class="pt-3">
                                    <input class="btn btn-green" type="button" value="Join" />
                                    </div>                                    
                                </div>
                                <div class="top_event_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-2.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>

                            <div class="carousel-item  wrapper_block">
                                <div class="carousel-caption d-none d-md-block white_block">
                                    <div class="highlight-text">HIGHLIGHTS</div>
                                    <div class="main-title"> Misk 503 AcceleratorProgram</div>
                                    <div>
                                        <span class="pr-1">
                                            <img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" alt="location marker" />
                                        </span>  <span class="sub-title"> Riyadh, Jeddah, AL-Akbar</span> </div>
                                    <p class="discription-text pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric characters.
                                    </p>
                                    <div class="pt-3">
                                    <input class="btn btn-green" type="button" value="Join" />
                                    </div>
                                    
                                </div>
                                <div class="top_event_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-3.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>

                        </div>


                        <!-- Left and right controls -->
                        <a class="carousel-control-prev a_event_2 a_event_left_2" href="#demo" data-slide="prev">
                            <span class="carousel-control-prev-icon left_arrow"></span>
                        </a>
                        <a class="carousel-control-next a_event_2 a_event_right_2" href="#demo" data-slide="next">
                            <span class="carousel-control-next-icon right_arrow"></span>
                        </a>
                    </div>
                </div>
            </div>
        </div>



        <section id="other-section" class="container py-5">
            <div class="container second_container_event_2">
                <h2>Courses</h2>

                <div class="row courses_coursel">
                    <div id="demo1" class="carousel slide carousel_slider_courses" data-ride="carousel">

                        <!-- Indicators -->
                        <ul class="carousel-indicators carousel_courses_2">
                            <li data-target="#demo1" data-slide-to="0" class="active"></li>
                            <li data-target="#demo1" data-slide-to="1" class=""></li>
                            <li data-target="#demo1" data-slide-to="2" class=""></li>
                            <li data-target="#demo1" data-slide-to="3" class=""></li>

                        </ul>

                        <!-- The slideshow -->
                        <div class="carousel-inner carousel_inner_event_2">

                            <div class="carousel-item active carousel_wrapper_block">
                                <div class="carousel-caption d-none d-md-block carousel_white_block">
                                    <div class="highlight-text">HIGHLIGHTS</div>
                                    <div class="main-title">Misk 504 AcceleratorProgram</div>
                                    <div> <span class="pr-1"><img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" /> </span> <span class="sub-title">Riyadh, Jeddah, AL-Akbar</span></div>
                                    <p class="discription-text pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric characters.
                                    </p>
                                </div>
                                <div class="courses_left_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-3.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>

                            <div class="carousel-item  carousel_wrapper_block">
                                <div class="carousel-caption d-none d-md-block carousel_white_block">
                                    <div class="highlight-text">HIGHLIGHTS</div>
                                    <div class="main-title">Misk 505 AcceleratorProgram</div>
                                    <div> <span class="pr-1"><img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" /></span> <span class="sub-title"> Riyadh, Jeddah, AL-Akbar </span></div>
                                    <p class="discription-text pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric characters.
                                    </p>
                                </div>
                                <div class="courses_left_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-1.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>

                            <div class="carousel-item  carousel_wrapper_block">
                                <div class="carousel-caption d-none d-md-block carousel_white_block">
                                    <div class="highlight-text">HIGHLIGHTS</div>
                                    <div class="main-title">Misk 506 AcceleratorProgram</div>
                                    <div> <span class="pr-1"><img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" /> </span> <span class="sub-title">Riyadh, Jeddah, AL-Akbar</span></div>
                                    <p class="discription-text pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric charactersces.
                                    </p>
                                </div>
                                <div class="courses_left_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-2.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>

                            <div class="carousel-item  carousel_wrapper_block">
                                <div class="carousel-caption d-none d-md-block carousel_white_block">
                                    <div class="highlight-text">HIGHLIGHTS</div>
                                    <div class="main-title">Misk 507 AcceleratorProgram</div>
                                    <div><span class="pr-1"><img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" /></span>  <span class="sub-title"> Riyadh, Jeddah, AL-Akbar</span></div>
                                    <p class="discription-text pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric charactersvices.
                                    </p>
                                </div>
                                <div class="courses_left_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-4.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row courses_coursel">
                    <div id="demo2" class="carousel slide carousel_slider_courses" data-ride="carousel">

                        <!-- Indicators -->
                        <ul class="carousel-indicators carousel_courses_2_2">
                            <li data-target="#demo2" data-slide-to="0" class="active"></li>
                            <li data-target="#demo2" data-slide-to="1" class=""></li>
                            <li data-target="#demo2" data-slide-to="2" class=""></li>
                            <li data-target="#demo2" data-slide-to="3" class=""></li>

                        </ul>

                        <!-- The slideshow -->
                        <div class="carousel-inner carousel_inner_event_2">

                            <div class="carousel-item active carousel_wrapper_block">
                                <div class="carousel-caption d-none d-md-block carousel_white_block carousel_padding ">
                                    <div>HIGHLIGHTS</div>
                                    <div>Misk 500 AcceleratorProgram</div>
                                   <div><span class="pr-1"><img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" /> </span> <span class="sub-title"> Riyadh, Jeddah, AL-Akbar</span></div>
                                     <p class="discription-text pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric characters.
                                    </p>
                                </div>
                                <div class="courses_right_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-3.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>



                            <div class="carousel-item  carousel_wrapper_block">
                                <div class="carousel-caption d-none d-md-block carousel_white_block carousel_padding">
                                    <div>HIGHLIGHTS</div>
                                    <div>Misk 500 AcceleratorProgram</div>
                                   <div> <span class="pr-1"><img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" /> </span>  <span class="sub-title"> Riyadh, Jeddah, AL-Akbar</span></div>
                                    <p class="discription-text pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric character.
                                    </p>
                                </div>
                                <div class="courses_right_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-1.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>

                            <div class="carousel-item  carousel_wrapper_block">
                                <div class="carousel-caption d-none d-md-block carousel_white_block carousel_padding">
                                    <div>HIGHLIGHTS</div>
                                    <div>Misk 500 AcceleratorProgram</div>
                                  <div><span class="pr-1"><img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" /> </span> <span class="sub-title"> Riyadh, Jeddah, AL-Akbar</span></div>
                                   <p class="discription-text pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric characters.
                                    </p>
                                </div>
                                <div class="courses_right_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-2.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>

                            <div class="carousel-item  carousel_wrapper_block">
                                <div class="carousel-caption d-none d-md-block carousel_white_block carousel_padding">
                                    <div>HIGHLIGHTS</div>
                                    <div>Misk 500 AcceleratorProgram</div>
                                  <div><span class="pr-1"><img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" /></span><span class="sub-title">Riyadh, Jeddah, AL-Akbar</span></div>
                                   <p class="discription-text pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric characters.
                                    </p>
                                </div>
                                <div class="courses_right_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-4.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row courses_coursel">
                    <div id="demo3" class="carousel slide carousel_slider_courses" data-ride="carousel">

                        <!-- Indicators -->
                        <ul class="carousel-indicators carousel_courses_2">
                            <li data-target="#demo3" data-slide-to="0" class="active"></li>
                            <li data-target="#demo3" data-slide-to="1" class=""></li>
                            <li data-target="#demo3" data-slide-to="2" class=""></li>
                            <li data-target="#demo3" data-slide-to="3" class=""></li>

                        </ul>

                        <!-- The slideshow -->
                        <div class="carousel-inner carousel_inner_event_2">

                            <div class="carousel-item active carousel_wrapper_block">
                                <div class="carousel-caption d-none d-md-block carousel_white_block">
                                    <div class="highlight-text">HIGHLIGHTS</div>
                                    <div class="main-title">Misk 500 AcceleratorProgram</div>
                                    <div> <span class="pr-1"><img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" /> </span> <span class="sub-title"> Riyadh, Jeddah, AL-Akbar </span></div>
                                    <p class="discription-tex pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric characters.
                                    </p>
                                </div>
                                <div class="courses_left_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-3.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>
                            <div class="carousel-item  carousel_wrapper_block">
                                <div class="carousel-caption d-none d-md-block carousel_white_block">
                                    <div class="highlight-text">HIGHLIGHTS</div>
                                    <div class="main-title">Misk 500 AcceleratorProgram</div>
                                    <div> <span class="pr-1"><img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" /> </span> <span class="sub-title"> Riyadh, Jeddah, AL-Akbar </span></div>
                                    <p class="discription-tex pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric characters.
                                    </p>
                                </div>
                                <div class="courses_left_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-1.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>

                            <div class="carousel-item  carousel_wrapper_block">
                                <div class="carousel-caption d-none d-md-block carousel_white_block">
                                    <div class="highlight-text">HIGHLIGHTS</div>
                                    <div class="main-title">Misk 500 AcceleratorProgram</div>
                                    <div> <span class="pr-1"><img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" /> </span> <span class="sub-title"> Riyadh, Jeddah, AL-Akbar </span></div>
                                    <p class="discription-tex pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric characters.
                                    </p>
                                </div>
                                <div class="courses_left_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-2.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>

                            <div class="carousel-item  carousel_wrapper_block">
                                <div class="carousel-caption d-none d-md-block carousel_white_block">
                                    <div class="highlight-text">HIGHLIGHTS</div>
                                    <div class="main-title">Misk 500 AcceleratorProgram</div>
                                    <div> <span class="pr-1"><img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" /> </span> <span class="sub-title"> Riyadh, Jeddah, AL-Akbar </span></div>
                                    <p class="discription-tex pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric characters.
                                    </p>
                                </div>
                                <div class="courses_left_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-4.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row courses_coursel">
                    <div id="demo4" class="carousel slide carousel_slider_courses" data-ride="carousel">

                        <!-- Indicators -->
                        <ul class="carousel-indicators carousel_courses_2_2">
                            <li data-target="#demo4" data-slide-to="0" class="active"></li>
                            <li data-target="#demo4" data-slide-to="1" class=""></li>
                            <li data-target="#demo4" data-slide-to="2" class=""></li>
                            <li data-target="#demo4" data-slide-to="3" class=""></li>

                        </ul>

                        <!-- The slideshow -->
                        <div class="carousel-inner carousel_inner_event_2">

                            <div class="carousel-item active carousel_wrapper_block">
                                <div class="carousel-caption d-none d-md-block carousel_white_block carousel_padding ">
                                    <div class="highlight-text">HIGHLIGHTS</div>
                                    <div class="main-title">Misk 500 AcceleratorProgram</div>
                                    <div> <span class="pr-1"><img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" /> </span> <span class="sub-title"> Riyadh, Jeddah, AL-Akbar </span></div>
                                    <p class="discription-tex pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric characters.
                                    </p>
                                </div>
                                <div class="courses_right_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-3.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>



                            <div class="carousel-item  carousel_wrapper_block">
                                <div class="carousel-caption d-none d-md-block carousel_white_block carousel_padding">
                                    <div class="highlight-text">HIGHLIGHTS</div>
                                    <div class="main-title">Misk 500 AcceleratorProgram</div>
                                    <div> <span class="pr-1"><img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" /> </span> <span class="sub-title"> Riyadh, Jeddah, AL-Akbar </span></div>
                                    <p class="discription-tex pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric characters.
                                    </p>
                                </div>
                                <div class="courses_right_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-1.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>

                            <div class="carousel-item  carousel_wrapper_block">
                                <div class="carousel-caption d-none d-md-block carousel_white_block carousel_padding">
                                    <div class="highlight-text">HIGHLIGHTS</div>
                                    <div class="main-title">Misk 500 AcceleratorProgram</div>
                                    <div> <span class="pr-1"><img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" /> </span> <span class="sub-title"> Riyadh, Jeddah, AL-Akbar </span></div>
                                    <p class="discription-tex pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric characters.
                                    </p>
                                </div>
                                <div class="courses_right_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-2.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
                            </div>

                            <div class="carousel-item  carousel_wrapper_block">
                                <div class="carousel-caption d-none d-md-block carousel_white_block carousel_padding">
                                    <div class="highlight-text">HIGHLIGHTS</div>
                                    <div class="main-title">Misk 500 AcceleratorProgram</div>
                                    <div> <span class="pr-1"><img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" /> </span> <span class="sub-title"> Riyadh, Jeddah, AL-Akbar </span></div>
                                    <p class="discription-tex pt-3">
                                        Text messaging, or texting, is the act of composing and sending electronic messages, typically consisting of alphabetic and numeric characters, between two or more users of mobile devices, desktops/laptops, or other type of compatible computer.
                                        typically consisting of alphabetic and numeric characters.
                                    </p>
                                </div>
                                <div class="courses_right_img" style="background:url('/o/new-misk-theme/images/eventListImages/event-detail2-4.jpg') no-repeat;background-size:cover;" alt="Los Angeles"></div>
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
                            <input type="email" class="cutomtextbox" id="email" name="email" placeholder="Email" autocomplete="nope" />
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
                                <button class="btn btn-greentext">Sign Up</button>
                            </span>
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