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
<%@page import="com.liferay.portal.kernel.dao.jdbc.DataAccess"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.Date"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<%
Calendar c = Calendar.getInstance();
String test;
String startDate="";
String endDate="";
String userId = renderRequest.getRemoteUser();
String eventId = renderRequest.getParameter("calendarBookingId");
String loggedInUser = renderRequest.getRemoteUser();

//renderRequest.getParameter("calendarBookingId");
System.out.println("eventId "+eventId);
System.out.println("calendarBookingId "+renderRequest.getParameter("calendarBookingId"));
LandingPagePortlet evt = new LandingPagePortlet();
CalendarBooking  cb = evt.getEventDetails(renderRequest);
long longStartTime = cb.getStartTime();
long longEndtime = cb.getEndTime();
SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
startDate = dateFormat.format(longStartTime);
endDate = dateFormat.format(longEndtime);
int status = cb.getStatus();
//JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
//List<SpeakerVO>  objlst =evt.getSpeakersMetada(cb);
List<SpeakerNVO>  objlst =evt.getSpeakersNMetada(cb);
/* boolean isSPeaker = false;
for(SpeakerNVO sp:objlst)
{
	if(sp.getUserId().equalsIgnoreCase(loggedInUser))
	{
		System.out.println("it is a speaker");
		isSPeaker = true;
		break;
	}
} 
System.out.println("it is a speaker isSPeaker: "+isSPeaker);
*/
String deadLineDate = "";
if(cb.getExpandoBridge().getAttribute("RegistrationDeadline", false) != null && !"".equals(cb.getExpandoBridge().getAttribute("RegistrationDeadline", false).toString())
   && !"null".equals(cb.getExpandoBridge().getAttribute("RegistrationDeadline", false).toString()))
{
	Date deadlindate = new Date(cb.getExpandoBridge().getAttribute("RegistrationDeadline", false).toString());
	DateFormat formatDeadline = new SimpleDateFormat("MMMM dd, yyyy");
	deadLineDate = formatDeadline.format(Long.valueOf(deadlindate.getTime()));
	System.out.println("==deadline1== " + deadLineDate + " ======== " );
}
String eventType = "", firstEventType = "", secondEventType = "";
if(cb.getExpandoBridge().getAttribute("Event Types", false) != null && !"".equals(cb.getExpandoBridge().getAttribute("Event Types", false).toString())
   && !"null".equals(cb.getExpandoBridge().getAttribute("Event Types", false).toString()))
{
	Object[] evntType = (Object[]) cb.getExpandoBridge().getAttribute("Event Types");
	if(evntType!= null && evntType.length>0) 
	{
		 eventType = evntType[0].toString(); 
	}
	System.out.println("==eventType== " + eventType + " ======== " );
}

// List<TimeLineVO>  objlstTl =evt.getTimeLineMetada(cb);
List<TimeLinedayObject>  objlstTl =evt.getTimeLineMetada(cb);
List<QuestionsAndAnswers>  objlstQA =evt.getQuestionsAndAnswersMetada(cb);
List<HighLightsVO>  objlstHL =evt.getHighLightsNMetada(cb);
System.out.println("-------event Details:----objlst.size()----:: "+objlst.size()+"---timeline size:: "+objlstTl.size());
int formId = evt.getFormAssociatedToTheEvent(Integer.parseInt(renderRequest.getParameter("calendarBookingId"))/* ,isSPeaker */);
System.out.println("formId:::  "+formId);
// String url = "https://webserver-miskfoundation-dev.lfr.cloud/web/forms/shared/-/form/"+String.valueOf(formId)+"?eventId="+renderRequest.getParameter("calendarBookingId");
String url = themeDisplay.getPortalURL()+"/web/forms/shared/-/form/"+String.valueOf(formId)+"?eventId="+renderRequest.getParameter("calendarBookingId");
// String url = "http://misk.comptechco.com/web/forms/shared/-/form/"+String.valueOf(formId)+"?eventId="+renderRequest.getParameter("calendarBookingId");
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
 if(themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar"))
	location = cb.getExpandoBridge().getAttribute("locationAr")!= null ? cb.getExpandoBridge().getAttribute("locationAr").toString() : "" ;
	
 
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
 

 boolean userAlreadyApplied = evt.checkIfUserAlreadyAppliedForTheEvent(userId,eventId);

 System.out.println("-------event Details:--------month  "+mMonth+"---"+mMonthF+"--year-"+mYear+"--location: "+location+" startMonth: "+startMonthName+"--endMonthName--: "+endMonthName);
%>


<portlet:defineObjects />   
<liferay-portlet:resourceURL var="resourceUrl1" >
	<liferay-portlet:param name="param1" value="Value1"/>
</liferay-portlet:resourceURL>

<html>

<head>
    <meta charset="utf-8" />
    <title>MISK</title>
      
 <link  href="/o/new-misk-theme/css/font/font-awesome/font-awesome.min.css" rel="stylesheet"/>
<link href="/o/new-misk-theme/css/landing/landing.css" rel="stylesheet" /> 
<link href="/o/new-misk-theme/css/landing/animate.css" rel="stylesheet" />


<% if(themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")) { %>
<link href="/o/new-misk-theme/css/landing/CustomStyle_Ar.css" rel="stylesheet" />
<% } else { %>
<link href="/o/new-misk-theme/css/landing/CustomStyle.css" rel="stylesheet" />
<% } %>


<script src="/o/new-misk-theme/js/html2canvas.js"></script>
<script src="/o/new-misk-theme/js/landing/jquery.counterup.min.js"></script>
<script src="/o/new-misk-theme/js/landing/scrollreveal.min.js"></script>
<script src="/o/new-misk-theme/js/landing/imgfix.min.js"></script>
<script src="/o/new-misk-theme/js/landing/wow.min.js"></script>
<script src="/o/new-misk-theme/js/landing/custom.js"></script>


    <style>
<%
if (themeDisplay.getLocale ().getLanguage ().equalsIgnoreCase ("ar")) {
	%> .control-menu-level-1 { background-image:none;
	background-color: transparent;
	color: #869CAD;
	height: 0px;
	width: 194px;
	margin-left: 70%;
}

<%
}
else { %> .control-menu-level-1 { background-color:transparent;
	color: #869CAD;
	height: 0px;
	width: 194px;
	margin-left: 70%;
}

<%
}
%>
<%
if (renderRequest.getRemoteUser () != null ) { %> .has-control-menu
	.affix, .has-control-menu #wrapper { margin-top:0;
	
}

.language-dropdown {
	margin-left: 83%;
	margin-top: 8px;
	cursor: pointer;
	font-size: 20px;
}

<%
if (themeDisplay.getLocale ().getLanguage ().equalsIgnoreCase ("ar")) {
	%> .control-menu-level-1 { background-image:none;
	background-color: transparent;
	color: #869CAD;
	height: 0px;
	width: 305px;
	margin-left: 9%;
}

.tools-control-group {
	min-width: 0;
}

<%
}
}
%>
		
		<% if(themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")) { %>
		.row {
			direction:rtl;
		}
		#event-detail {
		    background-image: url(/o/new-misk-theme/images/eventListImages/whitebg.png);
		    background-repeat: no-repeat;
		    padding: 25px;
		    background-position-x: 150px;
		    background-size: cover;
		    border-radius: 5px !important;
		    position: relative;
		    top: 35px;
		}
		
		
		.news-boxes img {
		    width: 100%;
		    float: left;
		}
		
		.news-boxes p {
		    width: 100%;
		    float: left;
		    margin: 30px 0px 6px 0px;
		    padding: 0px 35px;
		    font-size: 12px;
		    color: #ff8400;
		    font-weight: 600;
		}
		
		.news-boxes h4 {
		    width: 100%;
		    float: left;
		    padding: 0px 35px;
		    font-size: 18px;
		    font-weight: 400;
		    min-height: 100px;
		    line-height: 1.4;
		}
		
		.news-boxes a {
		    float: right;
		    padding: 0px 300px 0px 0px;
		    color: #666666;
		}
		
		.news-boxes {
		    width: 100%;
		    float: left;
		    margin: 20px 0px;
		    padding: 0px 0px 20px 0px;
		    background: #fff;
		    box-shadow: 0px 38px 77px 0px rgba(0, 45, 79, 0.13);
		}

		<% } else {%>
		
			 #event-detail { 
			 background-image: url('/o/new-misk-theme/images/eventListImages/whitebg.png'); 
			 background-repeat: no-repeat; 
			 padding: 25px; 
			 background-position-x: -30px;
	         border-radius: 5px !important; 
	         position: relative;
	    	 top: 35px;
	         }
	         
	         
.news-boxes img {
    width: 100%;
    float: left;
}

.news-boxes p {
    width: 100%;
    float: left;
    margin: 30px 0px 6px 0px;
    padding: 0px 35px;
    font-size: 12px;
    color: #ff8400;
    font-weight: 600;
}

.news-boxes h4 {
    width: 100%;
    float: left;
    padding: 0px 35px;
    font-size: 18px;
    font-weight: 400;
    min-height: 100px;
    line-height: 1.4;
}

.news-boxes a {
    float: right;
    padding: 0px 35px;
    color: #666666;
}

.news-boxes {
    width: 100%;
    float: left;
    margin: 20px 0px;
    padding: 0px 0px 20px 0px;
    background: #fff;
    box-shadow: 0px 38px 77px 0px rgba(0, 45, 79, 0.13);
}

<%
}
%>

.text-gray {
    color: white !important;
}
.modal-header button.close {
    font-size: 2.5rem !important;
}


</style>
    
    <script>
    var isAppl = false;
    $(document).ready(function () {
    	$("#myform").on('shown.bs.modal', function(){
    		try{
    			var frame = top.document.getElementById("myform").getElementsByTagName("iframe")[0];
    			var btn = frame.contentWindow.document.querySelector(".btn-primary[type='submit']");
    			$(btn).css("background","#00aa60").css("border-color","#00aa60");
    			var label = frame.contentWindow.document.querySelector(".required-warning");
    			$(label).css("padding","0");
    			
    		}catch(e){}
    	});
    $('#myform').on('hidden.bs.modal', function(e) 
    {
	      debugger;
	 	  checkIfUserApplied(<%=userId%>,<%=eventId%>,"checkIfUserAlreadyAppliedForTheEvent");
	 	  if(isAppl)
	 	  {
	 	   	   $("#submitButtonId").hide();
	 	  }
  	}); 
    			    
    	
    $("#alertContainerapplied").hide();
    $("#alertContainerbadge").hide();
    $("#alertContainerlogin").hide();
    $("#alertContainerclosed").hide();
      
      $("#printBadgeId").on('click', function() {
		    if (<%= loggedInUser %>== null )
	    	{
	    		alert("user not logged in");
	        	return;
	    	}
	    	else
	   		{
		 		var element = $("#badgePrint");
	        	$('#printBadge').show();
			    html2canvas(element, {
	            onrendered: function(canvas) { 
						var myImage = canvas.toDataURL("image/png");
						var newWin=window.open('','Print-Window');
						newWin.document.open();
						newWin.document.write('<html><body onload="window.print()"><img id="Image" src="' + myImage + '" style="width:60%;height:80%"></img></body></html>');
						newWin.document.close();
						setTimeout(function(){$('#printBadge').hide();newWin.close();},10);
		            }
				}); 
	   		}
// 			$('#printBadge').modal('show') ;
	    }); 
    <%
    boolean checkIfUserHasBadge = evt.checkIfUserHasBadge(userId,eventId);
    boolean checkIfUserIsSpeaker = evt.checkIfUserIsSpeaker(userId,eventId);
	%>
	
    
	if(isApplied)
	{
		$("#submitButtonId").css("display","none");
	}
    });
       var isApplied = <%=userAlreadyApplied%>;
     //  var isAppliedNow = false;
        function openQuestioneer() 
        { 
        	debugger;
         	if (<%= loggedInUser %>== null )
        	{
			window.open("/web/guest/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Flogin","_self");																																																											  
        		// showHideALert("#alertContainerlogin");
            	return;
        	}
         	
        	if(<%= status %>== 3 )
       		{
        		showHideALert("#alertContainerclosed");
            	return;
       		}
       
        	if(!<%=checkIfUserHasBadge %> && !<%=checkIfUserIsSpeaker %>)
       		{
        		//showHideALert("#alertContainerbadge");
        		swal("Please update your Profile page information to get your first badge!");
            	return;
       		}
        	else
        		/* if(isApplied || isAppliedNow)
       			{
        			showHideALert("#alertContainerapplied");
                	return;
       			}
        		else */
        			{
        			     // isAppliedNow =  true;
        			      $('#myform').modal('show') ;
        			}
        }
       
        

       if (<%= loggedInUser %>== null )
        {
            var backOfferButton = document.getElementById('submitButtonId');
            backOfferButton.dataset.target = "#/c/portal/login";
        } 
        
       function showHideALert(alertDiv)
       {
	       	debugger;
	       	var $div = $(alertDiv);
	       	if($div.is(":visible")){return;}
	       	$div.show();
	       	setTimeout(function(){
	       		$div.hide();
	       	},2000);
       }
       function openLocation(locationLink) 
       {
       	debugger;
         //  $(".modal-body #srcId").val( locationLink );
       	// $('#myModal').modal('show') ;
      // 	document.getElementById("srcId").src=locationLink;
      // 	$('#myformLocation').modal('show') ;
       	var newWin=window.open(locationLink);
       }
       
       function previewEventFile()
       {
           var filesSelected = document.getElementById("eventImgeId").files;
           if (filesSelected.length > 0) {
   	      var fileToLoad = filesSelected[0]	;
   	      var fileReader = new FileReader();
   	
   	      fileReader.onload = function(fileLoadedEvent) {
   		       var srcData = fileLoadedEvent.target.result; // <--- data: base64
   			   $("#profilePic").attr("src", srcData);
   		       $("textarea[name$=_ExpandoAttribute--UploadImageId--]").val(srcData);
   	      }
   	      fileReader.readAsDataURL(fileToLoad);
         }
   	}
       
       function checkIfUserApplied(userId,eventId,command)
       {
       //	var userId = obj.getAttribute("userid");
       	debugger;
           AUI().use('aui-io-request', function(A){
               A.io.request('${resourceUrl1}', {
                      method: 'post',
                      data: {
                   		   <portlet:namespace />command: command,
                   		   <portlet:namespace />userId: userId,
                   		   <portlet:namespace />eventId: eventId
                            },
                      on: {
                          	 success: function() 
                          	 {
                          		 debugger;
                          		isAppl = this.get('responseData');
                             }
                     }
               });
        
           });
       }

    </script>
    <style data-senna-track="temporary" type="text/css">

		#accordion .card { /* background-color: #f8f9fa !important; */ border: none !important; box-shadow: none !important; }
			  
  
  
				 

        #accordion .card-header { background-color: #f8f9fa; border-bottom: 1px solid #bbc6cb !important; padding: 0px !important; padding-bottom: 20px !important; }
        #accordion .card-link { text-decoration: none; font-size: 18px; color: #042F3F !important; font-family: Montserrat-Medium; padding-left: 20px; }
        #accordion .card-body { text-decoration: none; font-size: 16px; color: #042F3F !important; font-family: Montserrat-Regular; border-bottom: 0px solid #eee !important; }
        .fa-chevron-down { color: #818282; font-size: 15px; }
		.card-body { border-bottom: 0px !important; }
		
		
		#CoachAndJudgesTabContent .card2 { border: none; color: #042F3F; }
		#CoachAndJudgesTabContent { padding-left:5%; padding-right:5%; }
		#coach2-card-one:hover, #coach2-card-one:focus 		{ color: #ffffff; background: transparent linear-gradient(144deg, #31A466 0%, #0061A5 100%, #33A664 100%) 0% 0% no-repeat padding-box; box-shadow: 0px 24px 36px #002D4F0D; border-radius: 3px; opacity: 1; cursor: hand; }
	    #coach2-card-two:hover, #coach2-card-two:focus 		{ color: #ffffff; background: transparent linear-gradient(144deg, #31A466 0%, #0061A5 100%, #33A664 100%) 0% 0% no-repeat padding-box; box-shadow: 0px 24px 36px #002D4F0D; border-radius: 3px; opacity: 1; cursor: hand; }
	    #coach2-card-three:hover, #coach2-card-three:focus 	{ color: #ffffff; background: transparent linear-gradient(144deg, #31A466 0%, #0061A5 100%, #33A664 100%) 0% 0% no-repeat padding-box; box-shadow: 0px 24px 36px #002D4F0D; border-radius: 3px; opacity: 1; cursor: hand; }
	    #coach2-card-four:hover, #coach2-card-four:focus 	{ color: #ffffff; background: transparent linear-gradient(144deg, #31A466 0%, #0061A5 100%, #33A664 100%) 0% 0% no-repeat padding-box; box-shadow: 0px 24px 36px #002D4F0D; border-radius: 3px; opacity: 1; cursor: hand; }
		.coach2-name { font-family: Montserrat-SemiBold; font-size: 16px; }
		.coach2-name:hover, .coach2-name:focus { color: #ffffff; }
		.coach2-location { font-family: Montserrat-SemiBold; font-size: 16px; color: #042F3F4A; overflow-wrap: break-word;}
		.coach2-position { font-family: Montserrat-Regular; font-size: 13px; }
		.coach2-position:hover, .coach-position:focus { color: #ffffff; }
		 h3 { font-family: Montserrat-SemiBold; color: #042F3F; font-size: 34px; }
		 #CoachAndJudgesTabContent .p-4 { width: 22%; float: left; background-color: white; min-height: 350px; }
		 #CoachAndJudgesTabContent .p-4 img { width: 100%; }
		 .card2-body { text-align: center; padding-top: 20px; }
		 
		 .event-highlights-row { padding-bottom: 40px; }
	</style>
</head>
<body>
    <div class="container-fluid">
    <div class="sub-header-section">
     <div id="intro-title" class="container">
    <h3><span style="border-bottom:2px solid #eee;padding-bottom:40px; width: 2%; position: absolute; ">
    <% 
    	if(eventType!= null && !"".equals(eventType) && !"null".equals(eventType))
    	{
    		firstEventType = eventType.substring(0,3);
    		secondEventType = eventType.substring(3);
    		System.out.println(eventType + " / " + firstEventType + " / " + secondEventType);
    	}
    %>
    </span><liferay-ui:message key="<%=eventType%>" /></h3>
<!--     <h3><span style="border-bottom:2px solid #eee;padding-bottom:15px;">Eve</span>nt Type</h3> -->
    <h1 id="pitchHeader">
    	<% 
    	String name= "pitch";
    	if (themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar"))
    		name="pitchAr";
    	
    		String sqlStatement = "select data_ from ExpandoValue where columnId = " 
    		+ " (select columnId from ExpandoColumn where lower(name) = '"+name+"')" 
    		+ " and classPK = " + eventId;
				Connection con = DataAccess.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlStatement);
				
				while (rs.next()) 
				{
					if(rs.getString("data_") != null && !"".equals(rs.getString("data_")) && !"null".equals(rs.getString("data_")))
					{%>
			    		<%=rs.getString("data_")%>
			<%
					}
				}
    		con.close();
			st.close();
    		%>
   	</h1>
    </div>
    <div id="event-detail-section"> 
        <div class="container">
            <div class="row" id="event-detail">
                <div class="col-md-8 pb-3">
<!--                 <p class="highlisghts">HIGHLIGHTS</p> -->
                    <h3 class="main-title">
                        <%= cb.getTitle(themeDisplay.getLocale().toString().toLowerCase()).replaceAll("<p>", "").replaceAll("</p>","") %>
                    </h3>
					<a class="location-url" onclick="openLocation(<%="'"+cb.getExpandoBridge().getAttribute("Location link").toString()+"'"%>)" >																											  
	                    <p>
		                    <span class="locator-image">
		                    <img src="/o/new-misk-theme/images/eventListImages/map-marker-green.png" alt="location marker" />
		                     </span> 
		                    <span class="sub-title sub-title-location"><%=location%></span>
<%-- 		                    <span class="sub-title"><%=startMonthName%>-<%=endMonthName%> 2019, <%=location%></span> --%>
	                    </p>
			     	</a>
                    <div class="diescription-text">
                         <%= cb.getDescription(themeDisplay.getLocale().toString().toLowerCase()).replaceAll("<p>", "").replaceAll("</p>","")%>                        
                    </div>
                    <p class="deadline-text"><liferay-ui:message key="StartDate" />: <%=startDate%> | <liferay-ui:message key="EndDate" /> : <%=endDate%> </p>
                    <p class="deadline-text"><liferay-ui:message key="RegistrationDeadline" /><%=deadLineDate%></p>
                    
                        <%if(userAlreadyApplied==false) {%>
                        <a class="btn btn-green" id="submitButtonId" data-toggle="modal" onclick="openQuestioneer()"><liferay-ui:message key="Register" /></a>
                        <%}%>
                        
                        <%if(evt.checkIfPrintBadgeEnabled(eventId, userId)==true) {%>
                        <a class="btn btn-green" id="printBadgeId" data-toggle="modal">Print Badge</a>
<!--                         <label class="btn btn-green" style="margin: 1px;"> -->
<!--                         <input type="file" name="pic" id="eventImgeId" accept="image/*" onchange="previewEventFile();" style="display: none;"> -->
<!--                          Badge image -->
<!-- 						</label> -->
                        <% }%>
                    
                </div>
                <div class="col-md-4 ">
                    <div class="d-flex align-items-center outbox-image">                        
                        <img class="img-fluid rounded top-image-margin detailtopimg" src="<%= evt.getImageBybookingEvent(cb.getCalendarBookingId()) %>" />
                    </div>
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
                        <a class="nav-link active" id="Allevent" data-toggle="tab" href="#AlleventTabContent" role="tab" aria-controls="AlleventTabContent" aria-selected="true"><liferay-ui:message key="EventHighlights" /></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="foryou" data-toggle="tab" href="#foryouTabContent" role="tab" aria-controls="foryouTabContent" aria-selected="true"><liferay-ui:message key="Timeline" /></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="CoachAndJudges" data-toggle="tab" href="#CoachAndJudgesTabContent" role="tab" aria-controls="CoachAndJudgesTabContent" aria-selected="true"><liferay-ui:message key="Speakers" /></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="thismonth" data-toggle="tab" href="#thismonthTabContent" role="tab" aria-controls="thismonthTabContent" aria-selected="true"><liferay-ui:message key="FAQs" /></a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="tab-content pt-5" id="myTabContent">
                    <div class="tab-pane fade show active" id="AlleventTabContent" role="tabpanel" aria-labelledby="Allevent">
                        <%
                    int ik=1;
                    for(HighLightsVO sp :objlstHL)
					{    
                    	
                    	int blobLength = (int) sp.getImage().length();  
                    	byte[] blobAsBytes = sp.getImage().getBytes(1, blobLength);
        				String blobString = new String(blobAsBytes);
        				//System.out.println(blobString);
							%>
	                        <div class="row event-highlights-row">
                            <div class="col-md-4">
                            <div class="image-container">
                           <%--  <img class="img-fluid" src=<%=evt.getSpeakersImage(Long.valueOf(renderRequest.getParameter("calendarBookingId")),"SpeakerImageField"+ii) %> /> --%>
                           <img class="img-fluid" src=<%=blobString %> />
                            </div>                                
                            </div>
                            <div class="col-md-8 pl-5">
                            <%System.out.println("samir ============= sp.getTitlear()" + sp.getTitleAr()); %>
                            <%System.out.println("samir ============= sp.getTitle()" + sp.getTitle()); %>
                             <div class="hrcustom"></div>
                                <div class="title-text"><%=themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")? sp.getTitleAr():sp.getTitle() %></div>
                                <p class="para-text">
                                    <%=themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")?sp.getDescriptionAr():sp.getDescription() %>
                                </p>
                            </div>
                        </div>
                        <%
                    	
                    	ik++;
					 }
                    %>
                    </div>
                    

                    <div class="tab-pane fade" id="foryouTabContent" role="tabpanel" aria-labelledby="foryou">

                    <div id="timeline" class="container" style="padding-left:4%;padding-right:3%">
                          <%
                    int ijk=0;
                    for(TimeLinedayObject sp :objlstTl)
					{ 
                    	String title = sp.getTitle();
                    	String dateDescription = sp.getDateDescription();
                    	List<EventTimeDescripiton> eventTimeDescripitonList = new ArrayList<EventTimeDescripiton>();
                    	eventTimeDescripitonList = sp.getEventTimeDescription();
                    	System.out.println("-------Title:--------:  "+title+ "dateDescription: "+dateDescription);
                
                        	  %>
                          
		                    <div class="row timelineDisplay">
				                     <div class="col-md-12">
				                     <div class="row">
				                        <div class="col-md-12">
				                            <div class="head-day-text"><%=sp.getTitle() %></div>
				                        </div>
				                    </div>
				                    <div class="row">
				                        <div class="col-md-12">
				                            <div class="head-date-text"><%=dateDescription %></div>
				                        </div>
				                    </div>
				                    <% 
				                    for(EventTimeDescripiton spp :eventTimeDescripitonList)
                    	            {
                    		        System.out.println("-------date:--------:  "+spp.getDate()+ " timelineDesciption: "+ spp.getTimeLineDescription());%>
				                    <div class="row pt-3">
				                        <div class="col-md-4">
				                            <span class="time-text"><%=spp.getDate() %></span>
				                        </div>
				                        <div class="col-md-8">
				                            <div class="row">
				                                <div class="col-md-12">
				                                    <div class="brief-text">
				                                        <%=themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")?spp.getTimeLineDescriptionAr():spp.getTimeLineDescription() %>
				                                    </div>
				                                </div>
				                            </div>
				                        </div>
				                    </div>
				                    <% }  ijk=ijk+1;%>
				                    
				
				                </div>    
				                  
				                            
					
		            </div>
		            	<% 
						
									}
				                   %>

                   </div>
                   </div>
          
                    <div class="tab-pane fade" id="CoachAndJudgesTabContent" role="tabpanel" aria-labelledby="CoachAndJudges">
                    <%
                    int ii=1;
                    for(SpeakerNVO sp :objlst)
					{    
                    	
                    	//Convert Byte Array into String
        				// int blobLength = (int) rs.getBlob("speakerImage").length();  
                    	//byte[] blobAsBytes = rs.getBlob("speakerImage").getBytes(1, blobLength);
                    	int blobLength = (int) sp.getSpeakerImage().length();  
                    	byte[] blobAsBytes = sp.getSpeakerImage().getBytes(1, blobLength);
        				String blobString = new String(blobAsBytes);
        				//System.out.println(blobString);
																  
						//SpeakerImageField1
						System.out.println("speakers::fname  "+sp.getFirstName()+"--lastName:: -: "+sp.getLastName()+"--position:: -: "+sp.getPosition()+"----nationality: "+sp.getNationality());
						%>
						<div class="card2 p-4 mr-3" id="coach2-card-one">
		                    <img class="card2-img-top" src=<%=blobString %> />
		                    <div class="card2-body">     
		                    
		                        <div class="coach2-name"><%=sp.getFirstName()+"  "+sp.getLastName() %></div>
		                     <%--    <div class="coach2-location block-ellipsis"><span title="<%=sp.getEmailAddress() %>"><%=sp.getEmailAddress() %></span></div> --%>
		                        <div class="coach2-position"><span <% if((sp.getPosition()!= null && !"".equals(sp.getPosition()) && !"null".equals(sp.getPosition()))) {%> title="<%=sp.getPosition() %>" <%} %>><%=(sp.getPosition()!= null && !"".equals(sp.getPosition()) && !"null".equals(sp.getPosition()))?sp.getPosition():"" %></span></div>
			                    <div class="coach2-position"><span <% if((sp.getNationality()!= null && !"".equals(sp.getNationality()) && !"null".equals(sp.getNationality()))) {%> title="<%=sp.getNationality() %>" <%} %>><%=(sp.getNationality()!= null && !"".equals(sp.getNationality()) && !"null".equals(sp.getNationality()))?sp.getNationality():"" %></span></div>
		                    </div>
		                </div>
                       <%
                    	ii++;
					 }
                    %>

                    </div>
                    <div class="tab-pane fade" id="thismonthTabContent" role="tabpanel" aria-labelledby="thismonth">
				                          <div id="accordion">
				                             <%
				                             int il =0;
                    for(QuestionsAndAnswers tl :objlstQA)
					{    
                    	il  = il+1;
							//system.out.println("speakers::fname  "+tl.getFirstName()+"--lastName:: -: "+sp.getLastName()+"--position:: -: "+sp.getPosition()+"----nationality: "+sp.getNationality());
							%>
				                <div class="card">
				                    <div class="card-header">
				                        <a class="card-link" data-toggle="collapse" href="#collapse<%=il%>">
				                            <%=themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")?tl.getQuestionAr():tl.getQuestion() %> <span class="float-right pr-4"> <i class="fa fa-chevron-down"></i> </span>
				                        </a>
				                        <div id="collapse<%=il%>" class="collapse" data-parent="#accordion">
					                        <div class="card-body">
					                            <%=themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")?tl.getAnswerAr():tl.getAnswer() %>
					                        </div>
					                    </div>
				                    </div>
				                </div>
				                 <%
                    	}
                        %>
				                
				            </div>      
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section id="newupdate-section" class="container-fluid mt-5">
    	<%@ include file="/news.jsp" %>
    </section>
<%--     <section class="container-fluid" id="createaccount-section">
			<div class="container">
				<div class="row">
					<div class="col-xl-5 col-lg-5 col-md-12 col-12 textcnter">
						<h3><liferay-ui:message key="BecomeFutureReadyRightHere" /></h3>
						<p><liferay-ui:message key="StartOnThePathToYourBestFuture" /></p>
					</div>
					<div class="col-xl-7 col-lg-7 col-md-12 col-12">
						<form class="singup">
						
						     <div class="row">
                        <div class="col-md-12 form-group">

                            <select class="form-control selectrole" id="role" name="role">
                                <option selected="selected" value=""  disabled="disabled"><liferay-ui:message key="SelectYourRole" /></option>
                                <option value=""  disabled="disabled"><liferay-ui:message key="Role" /></option>
                                <option value=""  disabled="disabled"><liferay-ui:message key="Manager" /></option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 form-group">                          
													 
                            <input type="text" class="cutomtextbox" id="firstname" name="firstname" placeholder="<liferay-ui:message key="FirstName" />" autocomplete="nope"  disabled="disabled"/>
                        </div>
                        <div class="col-md-6 form-group">                          
                            <input type="text" class="cutomtextbox" id="lastname" name="lastname" placeholder="<liferay-ui:message key="LastName" />" autocomplete="nope"  disabled="disabled"/>
																							   
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 form-group">                     
                            <input type="email" class="cutomtextbox" id="email" name="email" placeholder="<liferay-ui:message key="Email" />"  autocomplete="nope"  disabled="disabled"/>
																									
                        </div>

                    </div>
                    <div class="row py-2">
                        <div class="col-md-12">
							  
                           <div class="checkbox-container">
                                     <liferay-ui:message key="IAcceptYouth" /><span style="border-left:1px solid #ffffff;padding-right: 2px;"></span>   <liferay-ui:message key="PrivacyPolicy" />
                                    <input type="checkbox" id="credentailnotexpire" name="credentailnotexpire">
                                    <label class="checkmark" for="credentailnotexpire">
                                    </label>
                            </div>
							
                        </div>
                    </div>
                     <div class="row">
                        <div class="col-md-12">
                            <a href="/web/guest/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Flogin" class="btn btn-singin"><liferay-ui:message key="SignIn" /></a> 
                            
                            <a href="/web/guest/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Fcreate_account" class="btn btn-singin"><liferay-ui:message key="SignUp" /></a>
                        </div>
                    </div>                  
						
						</form>
					</div>
				</div>
			</div>
    </section> --%>
</div>
<div id="alertContainerapplied" style="display:none;" class="alert-notifications alert-notifications-fixed">
		  	<div class="alert alert-success fade alert-dismissible show" role="alert">
		  		<button class="btn close btn-unstyled" aria-label="Close" type="button">
		  			<svg class="lexicon-icon lexicon-icon-times" focusable="false" role="presentation" viewBox="0 0 512 512">
						<path class="lexicon-icon-outline" d="M295.781 256l205.205-205.205c10.998-10.998 10.998-28.814 0-39.781-10.998-10.998-28.815-10.998-39.781 0l-205.205 205.205-205.205-205.238c-10.966-10.998-28.814-10.998-39.781 0-10.998 10.998-10.998 28.814 0 39.781l205.205 205.238-205.205 205.205c-10.998 10.998-10.998 28.815 0 39.781 5.467 5.531 12.671 8.265 19.874 8.265s14.407-2.734 19.907-8.233l205.205-205.238 205.205 205.205c5.5 5.5 12.703 8.233 19.906 8.233s14.407-2.734 19.906-8.233c10.998-10.998 10.998-28.815 0-39.781l-205.238-205.205z"></path>
					</svg>
				</button>
				<span class="alert-indicator">
					<svg class="lexicon-icon lexicon-icon-check-circle-full" focusable="false" role="presentation" viewBox="0 0 512 512">
						<path class="lexicon-icon-outline" d="M484.1,139.7c-54.4,62.6-167,190-203.8,233c-5.9,6.8-14.6,11.2-24.3,11.2c-8.8,0-16.8-3.6-22.6-9.4c-45.3-45.3-50.7-50.7-96-96c-5.8-5.8-9.4-13.8-9.4-22.6c0-17.7,14.3-32,32-32c8.8,0,16.8,3.6,22.6,9.4c35.6,35.6,46.6,46.6,71.6,71.6c47-54.8,150.9-171.7,192.5-219.7C399.8,32.9,331.8,0,256,0C114.6,0,0,114.6,0,256s114.6,256,256,256s256-114.6,256-256C512,214.1,501.9,174.6,484.1,139.7z"></path>
					</svg>
				</span>
				User already apply for this event.
			</div>
</div>
<div id="alertContainerbadge" style="display:none;" class="alert-notifications alert-notifications-fixed">
		  	<div class="alert alert-success fade alert-dismissible show" role="alert">
		  		<button class="btn close btn-unstyled" aria-label="Close" type="button">
		  			<svg class="lexicon-icon lexicon-icon-times" focusable="false" role="presentation" viewBox="0 0 512 512">
						<path class="lexicon-icon-outline" d="M295.781 256l205.205-205.205c10.998-10.998 10.998-28.814 0-39.781-10.998-10.998-28.815-10.998-39.781 0l-205.205 205.205-205.205-205.238c-10.966-10.998-28.814-10.998-39.781 0-10.998 10.998-10.998 28.814 0 39.781l205.205 205.238-205.205 205.205c-10.998 10.998-10.998 28.815 0 39.781 5.467 5.531 12.671 8.265 19.874 8.265s14.407-2.734 19.907-8.233l205.205-205.238 205.205 205.205c5.5 5.5 12.703 8.233 19.906 8.233s14.407-2.734 19.906-8.233c10.998-10.998 10.998-28.815 0-39.781l-205.238-205.205z"></path>
					</svg>
				</button>
				<span class="alert-indicator">
					<svg class="lexicon-icon lexicon-icon-check-circle-full" focusable="false" role="presentation" viewBox="0 0 512 512">
						<path class="lexicon-icon-outline" d="M484.1,139.7c-54.4,62.6-167,190-203.8,233c-5.9,6.8-14.6,11.2-24.3,11.2c-8.8,0-16.8-3.6-22.6-9.4c-45.3-45.3-50.7-50.7-96-96c-5.8-5.8-9.4-13.8-9.4-22.6c0-17.7,14.3-32,32-32c8.8,0,16.8,3.6,22.6,9.4c35.6,35.6,46.6,46.6,71.6,71.6c47-54.8,150.9-171.7,192.5-219.7C399.8,32.9,331.8,0,256,0C114.6,0,0,114.6,0,256s114.6,256,256,256s256-114.6,256-256C512,214.1,501.9,174.6,484.1,139.7z"></path>
					</svg>
				</span>
				No Badge for this user, fill your information.
			</div>
		   </div>
 <div id="alertContainerlogin" style="display:none;" class="alert-notifications alert-notifications-fixed">
		  	<div class="alert alert-success fade alert-dismissible show" role="alert">
		  		<button class="btn close btn-unstyled" aria-label="Close" type="button">
		  			<svg class="lexicon-icon lexicon-icon-times" focusable="false" role="presentation" viewBox="0 0 512 512">
						<path class="lexicon-icon-outline" d="M295.781 256l205.205-205.205c10.998-10.998 10.998-28.814 0-39.781-10.998-10.998-28.815-10.998-39.781 0l-205.205 205.205-205.205-205.238c-10.966-10.998-28.814-10.998-39.781 0-10.998 10.998-10.998 28.814 0 39.781l205.205 205.238-205.205 205.205c-10.998 10.998-10.998 28.815 0 39.781 5.467 5.531 12.671 8.265 19.874 8.265s14.407-2.734 19.907-8.233l205.205-205.238 205.205 205.205c5.5 5.5 12.703 8.233 19.906 8.233s14.407-2.734 19.906-8.233c10.998-10.998 10.998-28.815 0-39.781l-205.238-205.205z"></path>
					</svg>
				</button>
				<span class="alert-indicator">
					<svg class="lexicon-icon lexicon-icon-check-circle-full" focusable="false" role="presentation" viewBox="0 0 512 512">
						<path class="lexicon-icon-outline" d="M484.1,139.7c-54.4,62.6-167,190-203.8,233c-5.9,6.8-14.6,11.2-24.3,11.2c-8.8,0-16.8-3.6-22.6-9.4c-45.3-45.3-50.7-50.7-96-96c-5.8-5.8-9.4-13.8-9.4-22.6c0-17.7,14.3-32,32-32c8.8,0,16.8,3.6,22.6,9.4c35.6,35.6,46.6,46.6,71.6,71.6c47-54.8,150.9-171.7,192.5-219.7C399.8,32.9,331.8,0,256,0C114.6,0,0,114.6,0,256s114.6,256,256,256s256-114.6,256-256C512,214.1,501.9,174.6,484.1,139.7z"></path>
					</svg>
				</span>
				<strong class="lead">User must login</strong>in order to proceed.
			</div>
		   </div>
 <div id="alertContainerclosed" style="display:none;" class="alert-notifications alert-notifications-fixed">
		  	<div class="alert alert-success fade alert-dismissible show" role="alert">
		  		<button class="btn close btn-unstyled" aria-label="Close" type="button">
		  			<svg class="lexicon-icon lexicon-icon-times" focusable="false" role="presentation" viewBox="0 0 512 512">
						<path class="lexicon-icon-outline" d="M295.781 256l205.205-205.205c10.998-10.998 10.998-28.814 0-39.781-10.998-10.998-28.815-10.998-39.781 0l-205.205 205.205-205.205-205.238c-10.966-10.998-28.814-10.998-39.781 0-10.998 10.998-10.998 28.814 0 39.781l205.205 205.238-205.205 205.205c-10.998 10.998-10.998 28.815 0 39.781 5.467 5.531 12.671 8.265 19.874 8.265s14.407-2.734 19.907-8.233l205.205-205.238 205.205 205.205c5.5 5.5 12.703 8.233 19.906 8.233s14.407-2.734 19.906-8.233c10.998-10.998 10.998-28.815 0-39.781l-205.238-205.205z"></path>
					</svg>
				</button>
				<span class="alert-indicator">
					<svg class="lexicon-icon lexicon-icon-check-circle-full" focusable="false" role="presentation" viewBox="0 0 512 512">
						<path class="lexicon-icon-outline" d="M484.1,139.7c-54.4,62.6-167,190-203.8,233c-5.9,6.8-14.6,11.2-24.3,11.2c-8.8,0-16.8-3.6-22.6-9.4c-45.3-45.3-50.7-50.7-96-96c-5.8-5.8-9.4-13.8-9.4-22.6c0-17.7,14.3-32,32-32c8.8,0,16.8,3.6,22.6,9.4c35.6,35.6,46.6,46.6,71.6,71.6c47-54.8,150.9-171.7,192.5-219.7C399.8,32.9,331.8,0,256,0C114.6,0,0,114.6,0,256s114.6,256,256,256s256-114.6,256-256C512,214.1,501.9,174.6,484.1,139.7z"></path>
					</svg>
				</span>
				The registration is closed.
			</div>
</div>
    <div class="modal fade" id="myform" tabindex="-1" role="dialog" aria-labelledby="addlanguageLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header text-gray bg-info">
                    <h5 class="modal-title" id="addlanguageLabel">
                        <label><liferay-ui:message key="Register" /></label>
                    </h5>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <iframe frameborder="0" height="515px" src=<%=url%> width="100%">
                    </iframe>
                </div>

            </div>
        </div>
    </div>
    <div class="modal fade" id="printBadge" tabindex="-1" role="dialog" aria-labelledby="addlanguageLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
<!--                 <div class="modal-header text-gray bg-info"> -->
<!--                     <h5 class="modal-title" id="addlanguageLabel"> -->
<!--                         <label>Print Badge</label> -->
<!--                     </h5> -->
<!--                     <button type="reset" class="close" data-dismiss="modal" aria-label="Close"> -->
<!--                         <span aria-hidden="true">&times;</span> -->
<!--                     </button> -->
<!-- 	                 <input type="button" id="btnPrint" value="Print" onclick="printDiv();"> -->
<!--                 </div> -->
                <div class="modal-body"  id="badgePrint">
					<div class="ev-wrapper" id="badgeContent">
							<% 
								if(loggedInUser != null && !"".equals(loggedInUser) && !"null".equals(loggedInUser))
								{
							    	sqlStatement = "select firstName, lastName,emailaddress,jobtitle,"
							    	+" (select image from profileImage pi where pi.userid = u.userid ) image,"
					    			+" (select badgeImage from eventsBadgeImg pi where pi.eventId =  "+renderRequest.getParameter("calendarBookingId")+") evimage,"
							    	+" (select count(1) from EventSpeakers where userid  = "+loggedInUser+" and eventid = "+renderRequest.getParameter("calendarBookingId")+") type "
							    	+" from User_ u where userId = " + loggedInUser;
									con = DataAccess.getConnection();;
									st = con.createStatement();
									rs = st.executeQuery(sqlStatement);
									String typePer = "SPEAKER";
									String classes = "ev-main ";
									
									while (rs.next()) 
									{
										if(rs.getString("type").toString().equals("0"))
										{
											typePer = "ATTENDEE";
											classes += " event-2";
										}

							%>
						<div class="<%= classes %>">
							<header>
<!-- 								<img src="data:image/png;base64,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"> -->
								<h1><%= cb.getTitleCurrentValue() %></h1>
							</header>
							<div class="img-m">
								<img src="<%=rs.getString("image")%>" id="profilePic">
							</div>
							
							<div class="txt-ev">
								<h3><%= typePer %></h3>
								<h2><%=rs.getString("firstName")%></h2>
								<h1><%=rs.getString("lastName")%></h1>
								<%if(rs.getString("jobtitle") != null && !"".equals(rs.getString("jobtitle")) && !"null".equals(rs.getString("jobtitle"))) {%>
									<h4 id="badgeHideH4"><%=rs.getString("jobtitle")%></h4>
								<%} %>
<!-- 								<h5 id="badgeHideH5">Everteam Global Services</h5> -->
							</div>

							<div class="ev-footer">
								<div class="qr-cod">
									<img src="data:image/png;base64,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">
								</div>
								<div class="logo-ev">
									<%if(rs.getString("evimage") != null && !"".equals(rs.getString("evimage")) && !"null".equals(rs.getString("evimage"))){ %>
 										<img class="eventImgBadge" src="<%=rs.getString("evimage")%>">
 									<%} %> 
								</div>
							</div>
							<%
									}
								    con.close();
									st.close();
								}
							%>							
						</div>
					</div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
<div class="modal fade" id="myformLocation" tabindex="-1" role="dialog" aria-labelledby="addlanguageLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header text-gray bg-info">
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