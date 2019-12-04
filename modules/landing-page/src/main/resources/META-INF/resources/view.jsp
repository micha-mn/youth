<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.LayoutLocalService"%>
<%@page import="java.util.ArrayList"%>
<html>

<%@ include file="/init.jsp" %>  
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="landing.page.portlet.LandingPagePortlet"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.calendar.model.CalendarBooking"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="com.liferay.calendar.service.CalendarBookingLocalServiceUtil"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>
<%@page import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@ page import="com.liferay.journal.model.JournalArticleDisplay" %>
 
<%@ page import="javax.portlet.RenderRequest" %>
<%@ page import="com.liferay.document.library.kernel.model.DLFileEntry" %>

<%@ page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.xml.Node" %>

<%@ page import="com.liferay.portal.kernel.xml.Document" %>
<%@ page import="com.liferay.portal.kernel.xml.SAXReaderUtil" %>

<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>

  <%@ page import="com.liferay.journal.util.comparator.ArticleDisplayDateComparator" %>
  
  
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<!--  <link href="/o/new-misk-theme/css/bootstrap.min.css" rel="stylesheet" /> -->
<link  href="/o/new-misk-theme/css/font/font-awesome/font-awesome.min.css" rel="stylesheet"/>
<link href="/o/new-misk-theme/css/landing/landing.css" rel="stylesheet" /> 

<link href="/o/new-misk-theme/css/landing/animate.css" rel="stylesheet" />

<script src="/o/new-misk-theme/js/landing/jquery.counterup.min.js"></script>
<script src="/o/new-misk-theme/js/landing/scrollreveal.min.js"></script>
<script src="/o/new-misk-theme/js/landing/imgfix.min.js"></script>
<script src="/o/new-misk-theme/js/landing/wow.min.js"></script>
<script src="/o/new-misk-theme/js/landing/custom.js"></script> 

        <script src="/o/new-misk-theme/js/from/popper.min.js"></script>
<% 
            
			//osaid 20191022
			//main intro section:    
			String mainIntroTitle = "mainIntroTitle";
			String mainIntroSubTitle = "mainIntroSubTitle";
			String mainIntroDesc = "mainIntroDesc";
			
			
			System.out.println("1111111");
			ThemeDisplay themeDisplay1 = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			JournalArticle mainIntroDocumentJournalArticle = JournalArticleLocalServiceUtil.getLatestArticleByUrlTitle(themeDisplay1.getScopeGroupId(), "main_introduction", 0);
			String mainIntroContent  = mainIntroDocumentJournalArticle.getContentByLocale(themeDisplay1.getLanguageId());
			System.out.println("22222");
		    Document  mainIntroDocument = SAXReaderUtil.read(mainIntroContent);
		    System.out.println("22222a");
	   	    Node mainIntroTitleNode = mainIntroDocument.selectSingleNode("/root/dynamic-element[@name='mainIntroTitle']/dynamic-content");
	   	    System.out.println("22222b");
		    mainIntroTitle = mainIntroTitleNode.getText();
		    System.out.println("3333");

		    Node mainIntroSubTitleNode = mainIntroDocument.selectSingleNode("/root/dynamic-element[@name='mainIntroSubTitle']/dynamic-content");
		    System.out.println("33aa");
		 	mainIntroSubTitle = mainIntroSubTitleNode.getText();
		 	System.out.println("33aamainIntroSubTitle:: "+mainIntroSubTitle);
		 	 System.out.println("33bb");
		 	System.out.println("33aa mainIntroDocument:: "+mainIntroDocument);
		 	Node mainIntroDescriptionNode = mainIntroDocument.selectSingleNode("/root/dynamic-element[@name='mainIntroDescription']/dynamic-content");
		 	 System.out.println("33cc");
		 	mainIntroDesc = mainIntroDescriptionNode.getText();

		 	System.out.println("444444");
			// aboutUsAndMission
			
			 JournalArticle aboutUsAndMissionJournalArticle = JournalArticleLocalServiceUtil.getLatestArticleByUrlTitle(themeDisplay1.getScopeGroupId(), "aboutusandmission", 0);
			 String aboutUsAndMissionContent  = aboutUsAndMissionJournalArticle.getContentByLocale(themeDisplay1.getLanguageId());
			 Document  aboutUsAndMissiondocument = SAXReaderUtil.read(aboutUsAndMissionContent);
					 
			 Node aboutUsNode = aboutUsAndMissiondocument.selectSingleNode("/root/dynamic-element[@name='aboutUsDescription']/dynamic-content");
			 String aboutUsDesc = aboutUsNode.getText();
			 
			 Node missionNode = aboutUsAndMissiondocument.selectSingleNode("/root/dynamic-element[@name='MissionDescription']/dynamic-content");
			 String MissionDesc = missionNode.getText();
			 System.out.println("5555555555");
			 
			 // websitebenefits
			 String websiteBenefitsImg1 = "";
			 String websiteBenefitsImg2 = "";
			 String websiteBenefitsImg3 = "";
			 String websiteBenefitsImg4 = "";
			 
			 String websitebenefitsTitle1 = "";
			 String websitebenefitsTitle2 = "";
			 String websitebenefitsTitle3 = "";
			 String websitebenefitsTitle4 = "";
			 
			 System.out.println("666666666");
			 String websitebenefitsDesc1 = "";
			 String websitebenefitsDesc2 = "";
			 String websitebenefitsDesc3 = "";
			 String websitebenefitsDesc4 = "";
			 
			 System.out.println("777777");
			 
			 			for (int i=1; i <5;i++){
			 				 System.out.println("777777a");
			 				 JournalArticle websitebenefitsJournalArticle = JournalArticleLocalServiceUtil.getLatestArticleByUrlTitle(themeDisplay1.getScopeGroupId(), "websitebenifit_"+i, 0);
			 				 System.out.println("777777b");
			 				 String websitebenefitsContent  = websitebenefitsJournalArticle.getContentByLocale(themeDisplay1.getLanguageId());
			 				 System.out.println("777777c");
			 	 			 Document  websitebenefitsdocument = SAXReaderUtil.read(websitebenefitsContent);
			 	 			 System.out.println("777777d");
			 				 Node imageNode = websitebenefitsdocument.selectSingleNode("/root/dynamic-element[@name='Image']/dynamic-content");
			 				 System.out.println("777777e");
			 				 String imageJsonData = imageNode.getText();
			 				 System.out.println("777777f");
			 			     JSONObject imagejsonObject = JSONFactoryUtil.createJSONObject(imageJsonData) ;
			 			     System.out.println("777777k");
			 			     DLFileEntry imageFolderData = DLFileEntryLocalServiceUtil.getDLFileEntry( imagejsonObject.getLong("fileEntryId"));
			 	 			
			 			    System.out.println("777777X");
			 			     
			 				 Node imageTitleNode = websitebenefitsdocument.selectSingleNode("/root/dynamic-element[@name='Title']/dynamic-content");
			 				 System.out.println("777777V");
			 				 
			 				 
			 				 
			 				 Node imageDescNode = websitebenefitsdocument.selectSingleNode("/root/dynamic-element[@name='Description']/dynamic-content");
			 			
			 				 System.out.println("777777h");
			 				 
			 			     switch(i) {
			 			    case 1:
			 			          websiteBenefitsImg1 = "/documents/"+imageFolderData.getRepositoryId()+"/"+imageFolderData.getFolderId()+"/"+imageFolderData.getFileName();
			 			          websitebenefitsTitle1 = imageTitleNode.getText();
			 			          websitebenefitsDesc1 = imageDescNode.getText();
			 			       break;
			 			    case 2:
				 			       websiteBenefitsImg2 = "/documents/"+imageFolderData.getRepositoryId()+"/"+imageFolderData.getFolderId()+"/"+imageFolderData.getFileName();
				 			       websitebenefitsTitle2 = imageTitleNode.getText();
				 			       websitebenefitsDesc2 = imageDescNode.getText();
				 			       break;
			 			    case 3:
				 			       websiteBenefitsImg3 = "/documents/"+imageFolderData.getRepositoryId()+"/"+imageFolderData.getFolderId()+"/"+imageFolderData.getFileName();
				 			       websitebenefitsTitle3 = imageTitleNode.getText();
				 			       websitebenefitsDesc3 = imageDescNode.getText();
				 			       break;
			 			    case 4:
				 			       websiteBenefitsImg4 = "/documents/"+imageFolderData.getRepositoryId()+"/"+imageFolderData.getFolderId()+"/"+imageFolderData.getFileName();
				 			       websitebenefitsTitle4 = imageTitleNode.getText();
				 			       websitebenefitsDesc4 = imageDescNode.getText();
				 			        break;
			 			     }
			 			}
			 			
			 			System.out.println("888888888");
						// upcomingEvents
				
			 			JournalArticle landingvideostructureJournalArticle = JournalArticleLocalServiceUtil.getLatestArticleByUrlTitle(themeDisplay1.getScopeGroupId(), "landingvideo", 0);
						 String landingvideostructureContent  = landingvideostructureJournalArticle.getContentByLocale(themeDisplay1.getLanguageId());
						 Document  landingvideodocument = SAXReaderUtil.read(landingvideostructureContent);
								 
						 Node urlVideoNode = landingvideodocument.selectSingleNode("/root/dynamic-element[@name='UploadVideo']/dynamic-content");
						 String urlVideo = urlVideoNode.getText();
						 
						 System.out.println("9999");			 		
			 JournalArticle dynamicnumberstructureJournalArticle = JournalArticleLocalServiceUtil.getLatestArticleByUrlTitle(themeDisplay1.getScopeGroupId(), "dynamicnumberstructure", 0);
			 String dynamicnumberstructureContent  = dynamicnumberstructureJournalArticle.getContentByLocale(themeDisplay1.getLocale().toString());
			 Document  dynamicnumberdocument = SAXReaderUtil.read(dynamicnumberstructureContent);
					 
			 Node number1Node = dynamicnumberdocument.selectSingleNode("/root/dynamic-element[@name='number1']/dynamic-content");
			 String youth = number1Node.getText();
			
			 Node number2Node = dynamicnumberdocument.selectSingleNode("/root/dynamic-element[@name='number2']/dynamic-content");
			 String MonthlyActiveMembers = number2Node.getText();
			 
			 Node number3Node = dynamicnumberdocument.selectSingleNode("/root/dynamic-element[@name='number3']/dynamic-content");
			 String ImproveattitudeofYouth = number3Node.getText();
			 
			 Node text1Node = dynamicnumberdocument.selectSingleNode("/root/dynamic-element[@name='Text1']/dynamic-content");
			 String text1 = text1Node.getText();
			
			 Node text2Node = dynamicnumberdocument.selectSingleNode("/root/dynamic-element[@name='Text2']/dynamic-content");
			 String text2 = text2Node.getText();
			 
			 Node text3Node = dynamicnumberdocument.selectSingleNode("/root/dynamic-element[@name='Text3']/dynamic-content");
			 String text3 = text3Node.getText();
			 
			 
			 JournalArticle howItWorkSectionstructureJournalArticle = JournalArticleLocalServiceUtil.getLatestArticleByUrlTitle(themeDisplay1.getScopeGroupId(), "howItWorkSection", 0);
			 String howItWorkSectionstructureContent  = howItWorkSectionstructureJournalArticle.getContentByLocale(themeDisplay1.getLocale().toString());
			 Document howItWorkSectionsdocument = SAXReaderUtil.read(howItWorkSectionstructureContent);
					 
			 Node howItWorksNode = howItWorkSectionsdocument.selectSingleNode("/root/dynamic-element[@name='HowItWorks1']/dynamic-content");
			 String howItWorks = howItWorksNode.getText();
			
			 Node createYourProfileNode = howItWorkSectionsdocument.selectSingleNode("/root/dynamic-element[@name='CreateYourProfile']/dynamic-content");
			 String createYourProfile = createYourProfileNode.getText();
			 
			 Node registerForProgramsNode = howItWorkSectionsdocument.selectSingleNode("/root/dynamic-element[@name='RegisterForPrograms']/dynamic-content");
			 String registerForPrograms = registerForProgramsNode.getText();
			 
			 Node manageYourJourneyNode = howItWorkSectionsdocument.selectSingleNode("/root/dynamic-element[@name='ManageYourJourney']/dynamic-content");
			 String manageYourJourney = manageYourJourneyNode.getText();
			 
			 
					 JournalArticle upcommingevent_1JournalArticle = JournalArticleLocalServiceUtil.getLatestArticleByUrlTitle(themeDisplay1.getScopeGroupId(), "upcommingevent_1", 0);
					 String upcommingevent_1Content  = upcommingevent_1JournalArticle.getContentByLocale(themeDisplay1.getLocale().toString());
					 Document  upcommingevent_1document = SAXReaderUtil.read(upcommingevent_1Content);
							 
					 Node upcommingevent_1TitleNode = upcommingevent_1document.selectSingleNode("/root/dynamic-element[@name='Title']/dynamic-content");
					 String upcommingevent_1Title = upcommingevent_1TitleNode.getText();
					 
					 Node upcommingevent_1DescNode = upcommingevent_1document.selectSingleNode("/root/dynamic-element[@name='Description']/dynamic-content");
					 String upcommingevent_1Desc = upcommingevent_1DescNode.getText();
					 
					 
					 System.out.println("99999999999");
					 JournalArticle upcommingevent_2JournalArticle = JournalArticleLocalServiceUtil.getLatestArticleByUrlTitle(themeDisplay1.getScopeGroupId(), "upcommingevent_2", 0);
		 String upcommingevent_2Content  = upcommingevent_2JournalArticle.getContentByLocale(themeDisplay1.getLocale().toString());
		 Document  upcommingevent_2document = SAXReaderUtil.read(upcommingevent_2Content);
				 
		 Node upcommingevent_2TitleNode = upcommingevent_2document.selectSingleNode("/root/dynamic-element[@name='Title']/dynamic-content");
		 String upcommingevent_2Title = upcommingevent_2TitleNode.getText();
		 
		 Node upcommingevent_2DescNode = upcommingevent_2document.selectSingleNode("/root/dynamic-element[@name='Description']/dynamic-content");
		 String upcommingevent_2Desc = upcommingevent_2DescNode.getText();
		 
		 System.out.println("1a1a1a1a1a1a");
		 
		 JournalArticle upcommingevent_3JournalArticle = JournalArticleLocalServiceUtil.getLatestArticleByUrlTitle(themeDisplay1.getScopeGroupId(), "upcommingevent_3", 0);
		String upcommingevent_3Content  = upcommingevent_3JournalArticle.getContentByLocale(themeDisplay1.getLocale().toString());
		Document  upcommingevent_3document = SAXReaderUtil.read(upcommingevent_3Content);

		Node upcommingevent_3TitleNode = upcommingevent_3document.selectSingleNode("/root/dynamic-element[@name='Title']/dynamic-content");
		String upcommingevent_3Title = upcommingevent_3TitleNode.getText();

		Node upcommingevent_3DescNode = upcommingevent_3document.selectSingleNode("/root/dynamic-element[@name='Description']/dynamic-content");
		String upcommingevent_3Desc = upcommingevent_3DescNode.getText();

		 System.out.println("1b1b1b1b");
		//Testimonial
		 int articlesCount = JournalArticleLocalServiceUtil.getArticlesCount(themeDisplay1.getScopeGroupId());
		List<JournalArticle> jl  = JournalArticleLocalServiceUtil.getStructureArticles(themeDisplay1.getScopeGroupId(), "43541",0,articlesCount,new ArticleDisplayDateComparator());
		/* 
		 String testomonialDiv = "";
		 ArrayList<String> displayedArticles = new ArrayList<String>();

		 	for (JournalArticle journalArticleObj : jl) {
		 		
				if (!displayedArticles.contains(journalArticleObj.getUrlTitle())){
					displayedArticles.add( journalArticleObj.getUrlTitle());
				 JournalArticle journalArticle = JournalArticleLocalServiceUtil.getLatestArticleByUrlTitle(themeDisplay1.getScopeGroupId(), journalArticleObj.getUrlTitle(), 0);
 				String  Content  = journalArticle.getContentByLocale(themeDisplay1.getLocale().toString());
				Document   document = SAXReaderUtil.read(Content);
		 

				 Node imageNode = document.selectSingleNode("/root/dynamic-element[@name='TestimonialImage']/dynamic-content");
				 String imageJsonData = imageNode.getText();
			
			     JSONObject imagejsonObject = JSONFactoryUtil.createJSONObject(imageJsonData) ;
			     DLFileEntry imageFolderData = DLFileEntryLocalServiceUtil.getDLFileEntry( imagejsonObject.getLong("fileEntryId"));
					
				 Node descriptionNode = document.selectSingleNode("/root/dynamic-element[@name='Description']/dynamic-content");
				 Node nameNode = document.selectSingleNode("/root/dynamic-element[@name='Name']/dynamic-content");
				 Node departmentNode = document.selectSingleNode("/root/dynamic-element[@name='Department']/dynamic-content");
				 Node companyNode = document.selectSingleNode("/root/dynamic-element[@name='company']/dynamic-content");

				 
			     
			     
			      String imgsrc = "/documents/"+imageFolderData.getRepositoryId()+"/"+imageFolderData.getFolderId()+"/"+imageFolderData.getFileName();
				  String description = descriptionNode.getText();
				  String name = nameNode.getText();
				  String department = departmentNode.getText();
				  String company1 = companyNode.getText();
				  
				  
				    testomonialDiv +=   "<div class='testt'>"
							  +"	<p>"+description+"</p>"
							  +"	<div class='imgttes'>"
							  +"		<img src='"+imgsrc+"'>"
							  +"		<h4>"+name+"<span>"+department+",<br>dddd</span></h4>"
						 		
							  +"	</div>"
							  +"</div>" ;
						  
						  
						  

		 	}
 

			} */
/* 

ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY); */
List <JournalArticle> jsList = JournalArticleLocalServiceUtil.getArticles();
for(JournalArticle jaInstance:jsList)
{
	jaInstance.getContentByLocale(themeDisplay1.getLocale().toString());
	jaInstance.getArticleImageURL(themeDisplay);
	//syso
}

Calendar c = Calendar.getInstance(); 
String test;
String userId = renderRequest.getRemoteUser();
//themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
/* System.out.println("themeDisplay.getPathThemeRoot():  "+themeDisplay.getPathThemeRoot());
System.out.println("themeDisplay.getPathThemeCss() :  "+ themeDisplay.getPathThemeCss());
System.out.println("themeDisplay.getPathThemeRoot():  "+themeDisplay.getPathThemeRoot());
System.out.println("userId                         :  "+renderRequest.getRemoteUser()); */
LandingPagePortlet evt = new LandingPagePortlet();
/* renderRequest.setAttribute("start","0");
renderRequest.setAttribute("end","100"); */
List <CalendarBooking> cbLst = evt.getCalendarBooking(renderRequest, "0", "6");
CalendarBooking event1 = null,event2=null,event3=null,event4=null;
String titleEvent1="",titleEvent2="",titleEvent3="",titleEvent4="" ;
String createDateEvnt1 = "",createDateEvnt2 = "",createDateEvnt3 = "",createDateEvnt4 = "";
String imageEvent1="",imageEvent2="",imageEvent3="",imageEvent4="";
String startDate1="",endDate1="",startDate2="",endDate2="",startDate3="",endDate3="",startDate4="",endDate4="";
String descriptionEvent1="",descriptionEvent2="",descriptionEvent3="",descriptionEvent4="";
DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
String img1="",img2="",img3="", img4="";
String location1="",location2="",location3="",location4="";

String imageSrc="/o/new-misk-theme/images/landing/no-image-available.png";

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
String mMonthF="";
String mDayFS="";
String hrF="";
String minF="";
String mDayFE = "";

int mYear1=0;       
String mDayFS1="";         
String mMonthF1="";       
String hrF1="";       
String minF1="";  

int mYear2=0;       
String mDayFS2="";         
String mMonthF2="";       
String hrF2="";       
String minF2="";     

int mYear3=0;       
String mDayFS3="";         
String mMonthF3="";       
String hrF3="";       
String minF3="";     

int mYear4=0;       
String mDayFS4="";         
String mMonthF4="";       
String hrF4="";       
String minF4=""; 

String isToDisplay ="";

int i = 1;

String calendarBookingId1="";
String calendarBookingId2="";
String calendarBookingId3="";
String calendarBookingId4="";
String href1="";
String href2="";
String href3="";
String href4="";
System.out.println("-------event.size()--------  "+cbLst.size());
img1 = imageSrc;
img2 = imageSrc;
img3 = imageSrc;
img4 = imageSrc;
for(CalendarBooking event:cbLst)
{  
	c.setTimeInMillis(event.getStartTime());
	mMonth =  c.get(Calendar.MONTH);
	mYear = c.get(Calendar.YEAR);
	mDay = c.get(Calendar.DAY_OF_MONTH);
	hr = c.get(Calendar.HOUR);
	min  = c.get(Calendar.MINUTE);
	
	 mMonthF = String.format("%02d", mMonth);
	 mDayFS = String.format("%02d", mDay);
	 hrF = String.format("%02d", hr);
	 minF = String.format("%02d", min);

	 c.setTimeInMillis(event.getEndTime());
	 mDay = c.get(Calendar.DAY_OF_MONTH);
	 mDayFE = String.format("%02d", mDay);

	 
	 
	 
	  System.out.println("---EventId: ----"+event.getCalendarBookingId()+"--\n\nCalendarBookingLocalServiceUtil.getCalendarBooking(event.getCalendarBookingId()).getExpandoBridge()---: "+CalendarBookingLocalServiceUtil.getCalendarBooking(event.getCalendarBookingId()).getExpandoBridge());
	  System.out.println("---EventId: ----"+event.getCalendarBookingId()+"---themeDisplay1--: "+themeDisplay1+"--themeDisplay1.getLocale()::--"+themeDisplay1.getLocale());
	  System.out.println("---EventId: ----"+event.getCalendarBookingId()+"---themeDisplay1.getLocale().toString()--: "+themeDisplay1.getLocale().toString());
	  
	  
	 
	/*  Object[] a = (Object[]) CalendarBookingLocalServiceUtil.getCalendarBooking(event.getCalendarBookingId()).getExpandoBridge().getAttribute("show on landing");
	 String showOnLanding = (a==null?"true":a[0].toString());
	
	 if(a==null)
	 {
		 System.out.println("---EventId: -show on landing-coming null--"+event.getCalendarBookingId());
		 
	 }
	 if(showOnLanding == "false" || "false".equals(showOnLanding))
	 {
		 System.out.println("---COntinue----");
		 continue;
	 }  */
	 
	 
	// System.out.println("eventTitle: "+ event.getTitle(themeDisplay1.getLocale().toString().toLowerCase())+"show on landing:: "+showOnLanding);
 	 if(i==1) 
 	 {
 		System.out.println("------enterHere-"+i);
 		i++;
 		 mYear1 = c.get(Calendar.YEAR);
 		System.out.println("-------event.size()1--------  ");
 		 mDayFS1 = String.format("%02d", mDay);
 		 mMonthF1 = String.format("%02d", mMonth);
 		 hrF1 = String.format("%02d", hr);
 		 minF1 = String.format("%02d", min);
 		System.out.println("-------event.size()2--------  ");
 		 
		event1 = event;
		calendarBookingId1 = String.valueOf(event.getCalendarBookingId());
		//System.out.println("-------event.size()3--------  ");
		location1 = event.getLocation();
		if(themeDisplay1.getLocale().getLanguage().equalsIgnoreCase("ar"))
		  location1 = event.getExpandoBridge().getAttribute("locationAr")!= null ? event.getExpandoBridge().getAttribute("locationAr").toString() : "" ;
		//System.out.println("-------event.size()4--------  ");
		titleEvent1 = event.getTitle(themeDisplay1.getLocale().toString().toLowerCase());
		System.out.println("-------event.sikkkkkkkkkkkkkkkkkkze()5--------  "+themeDisplay1.getLocale());
		createDateEvnt1 = dateFormat.format(event.getCalendar().getCreateDate());
		//System.out.println("-------event.size()6--------  ");
		descriptionEvent1 = event.getDescription(themeDisplay1.getLocale().toString().toLowerCase()).replaceAll("<p>", "").replaceAll("</p>","");
		if(!descriptionEvent1.isEmpty() && descriptionEvent1!=null &&  descriptionEvent1.length()>135)
		descriptionEvent1 = descriptionEvent1.substring(0,135) + "...";
		//System.out.println("-------event.size()7--------  ");
		img1 = evt.getImageBybookingEvent(event1.getCalendarBookingId());
		//System.out.println("-------event.size()8--------  ");
		//System.out.println("------img1-"+img1);
		//System.out.println("------titleEvent1-"+titleEvent1);
		//System.out.println("------createDateEvnt1-"+createDateEvnt1);
		// System.out.println("------descriptionEvent1-"+descriptionEvent1);
		if(img1=="" || img1==null || img1=="null")
			img1 = imageSrc;
		startDate1 = dateFormat.format(Long.valueOf(event.getStartTime()));
		endDate1          = dateFormat.format(Long.valueOf(event.getStartTime()));
		if(event.getExpandoBridge().getAttribute("Location link") != null)
		href1 = "'"+event.getExpandoBridge().getAttribute("Location link").toString()+"'";
 	 }
 	 else
 	if(i==2)  
 	{
 		//System.out.println("------enterHere-"+i);
 		i++;
 		 mYear2 = c.get(Calendar.YEAR);
		 mDayFS2 = String.format("%02d", mDay);
		 mMonthF2 = String.format("%02d", mMonth);
		 hrF2 = String.format("%02d", hr);
		 minF2 = String.format("%02d", min);
		 
		event2 = event;
		calendarBookingId2 = String.valueOf(event.getCalendarBookingId());
		location2 = event.getLocation();
		if(themeDisplay1.getLocale().getLanguage().equalsIgnoreCase("ar"))
		 	location2 = event.getExpandoBridge().getAttribute("locationAr")!= null ? event.getExpandoBridge().getAttribute("locationAr").toString() : "" ;
		titleEvent2 = event.getTitle(themeDisplay1.getLocale().toString().toLowerCase());
		descriptionEvent2 = event.getDescription(themeDisplay1.getLocale().toString().toLowerCase()).replaceAll("<p>", "").replaceAll("</p>","");
		if(!descriptionEvent2.isEmpty() && descriptionEvent2!=null &&  descriptionEvent2.length()>135 )
		descriptionEvent2 = descriptionEvent2.substring(0,135) + "...";
		img2 = evt.getImageBybookingEvent(event2.getCalendarBookingId());
		if(img2=="" || img2==null || img2=="null")
			img2 = imageSrc;
		startDate2 = dateFormat.format(Long.valueOf(event.getStartTime()));
		endDate2          = dateFormat.format(Long.valueOf(event.getStartTime()));
		if(event.getExpandoBridge().getAttribute("Location link") != null)
		href2 = "'"+event.getExpandoBridge().getAttribute("Location link").toString()+"'";
 	}
 	else
 	if(i==3)
 	{
 		System.out.println("------enterHere-"+i);
 		i++;
 		 mYear3 = c.get(Calendar.YEAR);
		 mDayFS3 = String.format("%02d", mDay);
		 mMonthF3 = String.format("%02d", mMonth);
		 hrF3 = String.format("%02d", hr);
		 minF3 = String.format("%02d", min);
		 
		 
		event3 = event; 
		calendarBookingId3 = String.valueOf(event.getCalendarBookingId());
		location3 = event.getLocation();
		if(themeDisplay1.getLocale().getLanguage().equalsIgnoreCase("ar"))
			location3 = event.getExpandoBridge().getAttribute("locationAr")!= null ? event.getExpandoBridge().getAttribute("locationAr").toString() : "" ;
		titleEvent3 = event.getTitle(themeDisplay1.getLocale().toString().toLowerCase());
		descriptionEvent3 = event.getDescription(themeDisplay1.getLocale().toString().toLowerCase()).replaceAll("<p>", "").replaceAll("</p>","");
		if(!descriptionEvent3.isEmpty() && descriptionEvent3!=null &&  descriptionEvent3.length()>135 )
		descriptionEvent3 = descriptionEvent3.substring(0,135)  + "...";
		img3 = evt.getImageBybookingEvent(event3.getCalendarBookingId());
		if(img3=="" || img3==null || img3=="null")
			img3 = imageSrc;
		startDate3 = dateFormat.format(Long.valueOf(event.getStartTime()));
		endDate3          = dateFormat.format(Long.valueOf(event.getStartTime()));
		if(event.getExpandoBridge().getAttribute("Location link") != null)
		href3 = "'"+event.getExpandoBridge().getAttribute("Location link").toString()+"'";
 	}
 	else
 	 	if(i==4)
 	 	{
 	 		System.out.println("------enterHere-"+i);
 	 		i++;
 	 		 mYear4 = c.get(Calendar.YEAR);
 			 mDayFS4 = String.format("%02d", mDay);
 			 mMonthF4 = String.format("%02d", mMonth);
 			 hrF4 = String.format("%02d", hr);
 			 minF4 = String.format("%02d", min);
 			 
 			 
 			event4 = event; 
 			calendarBookingId4 = String.valueOf(event.getCalendarBookingId());
 			location4 = event.getLocation();
 			if(themeDisplay1.getLocale().getLanguage().equalsIgnoreCase("ar"))
 				location4 = event.getExpandoBridge().getAttribute("locationAr") != null ? event.getExpandoBridge().getAttribute("locationAr").toString() : "" ;
 			titleEvent4 = event.getTitle(themeDisplay1.getLocale().toString().toLowerCase());
 			descriptionEvent4 = event.getDescription(themeDisplay1.getLocale().toString().toLowerCase()).replaceAll("<p>", "").replaceAll("</p>","");
 			if(!descriptionEvent4.isEmpty() && descriptionEvent4!=null &&  descriptionEvent4.length()>135)
 			descriptionEvent4 = descriptionEvent4.substring(0,135) + "...";
 			img4 = evt.getImageBybookingEvent(event4.getCalendarBookingId());
 			if(img4=="" || img4==null || img4=="null")
 				img4 = imageSrc;
 			startDate4 = dateFormat.format(Long.valueOf(event.getStartTime()));
 			endDate4         = dateFormat.format(Long.valueOf(event.getStartTime()));
 			if(event.getExpandoBridge().getAttribute("Location link") != null)
 			href4 = "'"+event.getExpandoBridge().getAttribute("Location link").toString()+"'";
 	 	}
	if(i > 4)
	{
		 System.out.println("---break----");
		break;
	}
}
System.out.println("landing userId  111111"+ userId);

User userU = themeDisplay.getUser();   //haydi bitjib object luser
String userId1 = renderRequest.getRemoteUser();  // iza not null yi3ni logged in lka2anou is logged in

//System.out.println("landing userId1:  "+userId1);
//System.out.println("landing userU:  "+userU);

boolean seeLanding = true;
if(userId1 != null)        // iza manu null yi3ni fi 7ada feyit
{
	List<Role> l = userU.getRoles();    // jibit listit roles tab3oulou
	for (Role lr : l)
	{
		//System.out.println("---lr.getDescriptionCurrentValue()----: " + lr.getDescriptionCurrentValue());
		if(lr.getDescriptionCurrentValue()!= null && lr.getDescriptionCurrentValue().toLowerCase().contains("admin"))     // iza fchhiem roale aaaaaamin rolet hiyi admin ma lezim ychuf landing iza logged infhmetaaa
		{    
			//System.out.println("---lr.getDescriptionCurrentValue() IF----: ");
			seeLanding = false;
			break;
		}
	}
}


System.out.println("userU ::  "+userU);
System.out.println("userId::  "+userId1);

	//if(UserLocalServiceUtil.hasRoleUser(Long.valueOf("35099"), Long.valueOf(userId)))
boolean b=true;	
if("null".equals(userId) || "null".equals(userId) )
{
	//System.out.println("landing userId  is null");
}


System.out.println("landing userId:: "+userId);
if(userId == null)
{
	userId ="1111";
}
if(userId != "1111")
{
//	System.out.println("landing Long.valueOf(userId):: "+Long.valueOf(userId));
//	System.out.println("landing roles of userId:: "+UserLocalServiceUtil.getUser(Long.valueOf(userId)).getRoles());
}
//if(userId != "1111" && UserLocalServiceUtil.getUser(Long.valueOf(userId)) != null && UserLocalServiceUtil.getUser(Long.valueOf(userId)).getRoles().size() > 0)
//	for(int j = 0; j<UserLocalServiceUtil.getUser(Long.valueOf(userId)).getRoles().size();j++ )
	{
		
		 /*  System.out.println("UserLocalServiceUtil.getUser(Long.valueOf(userId)).getRoles().get(1).getName(): "+UserLocalServiceUtil.getUser(Long.valueOf(userId)).getRoles().get(j).getName());
	      if(UserLocalServiceUtil.getUser(Long.valueOf(userId)).getRoles().get(j).getName().toLowerCase().contains("admin")
					||
					UserLocalServiceUtil.getUser(Long.valueOf(userId)).getRoles().get(j).getName().toLowerCase().contains("power")	
					||
					UserLocalServiceUtil.getUser(Long.valueOf(userId)).getRoles().get(j).getName().toLowerCase().contains("owner"))
				{
	    	  		b = false;
	    	  		break;
				} */
	
	}
		
		if(!seeLanding)
	{
	
	
	%>
	
<!--  <link href="/o/new-misk-theme/css/bootstrap.min.css" rel="stylesheet" /> -->
<link  href="/o/new-misk-theme/css/font/font-awesome/font-awesome.min.css" rel="stylesheet"/>
<link href="/o/new-misk-theme/css/landing/landing.css" rel="stylesheet" /> 
<link href="/o/new-misk-theme/css/landing/animate.css" rel="stylesheet" />

<script src="/o/new-misk-theme/js/landing/jquery.counterup.min.js"></script>
<script src="/o/new-misk-theme/js/landing/scrollreveal.min.js"></script>
<script src="/o/new-misk-theme/js/landing/imgfix.min.js"></script>
<script src="/o/new-misk-theme/js/landing/wow.min.js"></script>
<script src="/o/new-misk-theme/js/landing/custom.js"></script> 
	
		<style>
		.row {
    margin-right: 0px!important;
    margin-left: 0px!important; 
}
		@font-face { font-family: 'Montserrat-SemiBold'; src: url('/o/new-misk-theme/fonts/Montserrat-SemiBold.otf'); }
		@font-face { font-family: 'Montserrat-Light'; src: url('/o/new-misk-theme/fonts/Montserrat-Light.otf'); }
		@font-face { font-family: 'Montserrat-Regular'; src: url('/o/new-misk-theme/fonts/Montserrat-Regular.otf'); }
		@font-face { font-family: 'Montserrat-Bold'; src: url('/o/new-misk-theme/fonts/Montserrat-Bold.otf'); }
		@font-face { font-family: 'Montserrat-Medium'; src: url('/o/new-misk-theme/fonts/Montserrat-Medium.otf'); }
		
		@media (max-width: 1920px) and (min-width: 1367px)
		{.start-header
				 { padding: 0 0% 0 7%!important;
				    width: 100%!important;
				 }
		     }
		.container-menu {
			    /* margin-top: 4.2%; */
			    height: 100px;
			    position: relative;
			    background: url(/o/new-misk-theme/images/landing/topmenu.png);
			    width: -webkit-fill-available;
			    /*top: 24px;*/
			}
		
		.portlet-topper{display:none}
		.fixed-top{position:inherit !important ;background: #033553; background-image: linear-gradient(#033553, #00121d);}
		#content{margin-top: 55px;}
		
		.welcome-admin {
			    color: #20b3a9;
			    font-size: 2rem;
			    font-weight: 700;
			    padding: 10%;
			    text-align: center;
			    text-transform: none;
			}
		.container-menu {
		    position: relative;
		    background: url(/o/new-misk-theme/images/landing/topmenu.png);
		    width: -webkit-fill-available;
		}
		
		<% if(!request.isUserInRole("reviewerEvent") ){ %>
				.control-menu-level-1 {
				    background-color: transparent;
				    color: #869CAD;
				    background-image: none !important;
				}
				
				.container-menu {
				    margin-top: -55px;
				    height: 160px;
				    position: relative;
				    background: url(/o/new-misk-theme/images/landing/topmenu.png);
				    width: -webkit-fill-available;
				    /* top: 24px; */
				}
				
				.tools-control-group > .control-menu-nav {
				display:none;
				}
				
				.navigation.start-header.start-style {
				    top: 50px;
				}
		<%}%>

		</style>
		<div class="welcome-admin">
		<h1> Welcome to Misk YouthHub!
		</h1>
		</div>
		
	<% }

	else {%>

<portlet:defineObjects />   
<liferay-portlet:resourceURL var="resourceUrl1" >
	<liferay-portlet:param name="param1" value="Value1"/>
</liferay-portlet:resourceURL>

<portlet:renderURL var="renderAction">
<portlet:param name="mvcPath" value="/listEvent.jsp"></portlet:param>
</portlet:renderURL>

<portlet:renderURL var="renderAction1">
    <portlet:param name="mvcPath" value="/eventDetails.jsp"></portlet:param>
</portlet:renderURL>

<link  href="/o/new-misk-theme/css/font/font-awesome/font-awesome.min.css" rel="stylesheet"/>
<link href="/o/new-misk-theme/css/landing/landing.css" rel="stylesheet" /> 
<link href="/o/new-misk-theme/css/landing/animate.css" rel="stylesheet" />

<script src="/o/new-misk-theme/js/landing/jquery.counterup.min.js"></script>
<script src="/o/new-misk-theme/js/landing/scrollreveal.min.js"></script>
<script src="/o/new-misk-theme/js/landing/imgfix.min.js"></script>
<script src="/o/new-misk-theme/js/landing/wow.min.js"></script>
<script src="/o/new-misk-theme/js/landing/custom.js"></script> 


<link rel="stylesheet" href="/o/new-misk-theme/landingPage/css/owl.carousel.css"/>
<link rel="stylesheet" href="/o/new-misk-theme/landingPage/css/owl.theme.css"/>
<% if(themeDisplay1.getLocale().getLanguage().equalsIgnoreCase("ar")) { %>
<link rel="stylesheet" href="/o/new-misk-theme/landingPage/css/styleAr.css">
<link href="/o/new-misk-theme/css/landing/CustomStyle_Ar.css" rel="stylesheet" />
<% } else { %>
<link rel="stylesheet" href="/o/new-misk-theme/landingPage/css/style.css">
<link href="/o/new-misk-theme/css/landing/CustomStyle.css" rel="stylesheet" />
<% } %>
<script src="/o/new-misk-theme/landingPage/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="/o/new-misk-theme/landingPage/js/owl.carousel.js"></script>
<script src="/o/new-misk-theme/landingPage/js/owl.autoplay.js"></script>

<style>
 <% if(themeDisplay1.getLocale().getLanguage().equalsIgnoreCase("ar")) { %>
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
			.language-dropdown {
			margin-left: 83%;
			margin-top: 8px;
			cursor: pointer;
			font-size: 20px;
			}
			
		<% 
		if(themeDisplay1.getLocale().getLanguage().equalsIgnoreCase("ar")) { %>
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
		
		
				<% if(themeDisplay1.getLocale().getLanguage().equalsIgnoreCase("en")) { %>
		a.join-button { margin-right: 2%; font-family: Montserrat;
  font-size: 14px;
  font-weight: 500;
  font-stretch: normal;
  font-style: normal;
  line-height: 1.21;
  letter-spacing: normal;
  text-align: left;
  color: #ffffff;}
		<%}%>
</style>

<script>

jQuery(document).ready(function(){
	var owl = $('.owl-carousel');
	owl.owlCarousel({
		<% if(themeDisplay1.getLocale().getLanguage().equalsIgnoreCase("ar")) { %> rtl:true,<%}%>
	    items:1,
	    loop:true,
	    margin:10,
	    autoplay:true,
	    autoplayTimeout:2500,
	    nav:true,
	    autoplayHoverPause:true

	});

	

	$(".event1-description").text(function(index, currentText) {
		  var maxLength = 100;
		  if(currentText.length >= maxLength) {
		    return currentText.substr(0, maxLength) + "...";
		  } else {
		    return currentText
		  } 
		});
	
	$(".event2-description").text(function(index, currentText) {
		  var maxLength = 100;
		  if(currentText.length >= maxLength) {
		    return currentText.substr(0, maxLength) + "...";
		  } else {
		    return currentText
		  } 
		});
	$(".event3-description").text(function(index, currentText) {
		  var maxLength = 100;
		  if(currentText.length >= maxLength) {
		    return currentText.substr(0, maxLength) + "...";
		  } else {
		    return currentText
		  } 
		});
	$(".event4-description").text(function(index, currentText) {
		  var maxLength = 100;
		  if(currentText.length >= maxLength) {
		    return currentText.substr(0, maxLength) + "...";
		  } else {
		    return currentText
		  } 
		});
	});



new WOW().init();
function openQuestioneer(locationLink) 
{
	debugger;
  //  $(".modal-body #srcId").val( locationLink );
	// $('#myModal').modal('show') ;
	//document.getElementById("srcId").src=locationLink;
	//$('#myform').modal('show') ;
	var newWin=window.open(locationLink);
}

function callServeResource(obj)
{
	var userId = obj.getAttribute("userid");
	debugger;
    AUI().use('aui-io-request', function(A){
        A.io.request('${resourceUrl1}', {
               method: 'post',
               data: {
            		   <portlet:namespace />command: "registerEvent"
                     },
               on: {
                   	 success: function() 
                   	 {
                     // alert(this.get('responseData'));
                     alert("registered SUccessfuly");
                   }
              }
        });
 
    });
}

var a = 0;
$(window).scroll(function() {

	if ( $('#counter').offset()!=null)
		{
  var oTop = $('#counter').offset().top - window.innerHeight;
  if (a == 0 && $(window).scrollTop() > oTop) {
    $('.count').each(function() {
      var $this = $(this),
        countTo = $this.attr('data-count');
      $({
        countNum: $this.text()
      }).animate({
          countNum: countTo
        },

        {

          duration: 2000,
          easing: 'swing',
          step: function() {
            $this.text(Math.floor(this.countNum));
          },
          complete: function() {
            $this.text(this.countNum);
            //alert('finished');
          }

        });
    });
    a = 1;
  }
		}
});

</script>
           
		
		
		
		<div id="header-section" class="landing-page-container">
          <div class="container" id="intro">
              <div class="row" id="banner-col1">
					<div class="col-xl-9 p-0">
						<span><%=mainIntroTitle %></span>
						<h2><%=mainIntroSubTitle %></h2>
						<p>
							<%=mainIntroDesc%>
						</p>
						<a href="/web/guest/video" class="btnn btn-discvr"><liferay-ui:message key="DiscoverMore" /></a>
					</div>
					<div class="col-xl-5">
						
					</div>
				</div>
				<a id="AboutUsDiscover_URL">
				<div class="row" id="abt-us">
					<div class="col-xl-6 col-lg-6 p-0">
						<h4><liferay-ui:message key="AboutUs" /></h4>
						<p><%=aboutUsDesc %></p>
					</div>
					<div class="col-xl-6 col-lg-6 p-0">
						<h4><liferay-ui:message key="Mission" /></h4>
						<p><%=MissionDesc %></p>
					</div>
				</div>
				</a>
            </div>            
        </div>
      <section class="sec-1">
			<div class="container">
				<div class="row">
					<div class="col-xl-3 col-12 col-md-6 col-lg-3 col-sm-12 col-xs-12 highlights">
						<div class="srvcs">
							<img src=<%=websiteBenefitsImg1 %> style="height:229px">
							<div class="detayls">
								<h3> <%=websitebenefitsTitle1%></h3>
								<p><%=websitebenefitsDesc1%> </p>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-12 col-md-6 col-lg-3 col-sm-12 col-xs-12 highlights">
						<div class="srvcs">
							<img src=<%=websiteBenefitsImg2 %> style="height:229px">
							<div class="detayls">
								<h3><%=websitebenefitsTitle2%></h3>
								<p><%=websitebenefitsDesc2%></p>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-12 col-md-6 col-lg-3 col-sm-12 col-xs-12 m-ipad highlights">
						<div class="srvcs">
							<img src=<%=websiteBenefitsImg3 %> style="height:229px">
							<div class="detayls">
								<h3><%=websitebenefitsTitle3%></h3>
								<p><%=websitebenefitsDesc3%> </p>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-12 col-md-6 col-lg-3 col-sm-12 col-xs-12 m-ipad highlights">
						<div class="srvcs"> 
							<img src=<%=websiteBenefitsImg4 %> style="height:229px">
							<div class="detayls">
								<h3><%=websitebenefitsTitle4%></h3>
								<p><%=websitebenefitsDesc4%> </p>
							</div>
						</div>
					</div>

				</div>
			</div>
		</section>
		<a id="Discover_URL">
		<section class="sec-2 titlee">
			<div class="container">
				<div class="row">
					<div class="col-xl-12 col-12">
						<h2><liferay-ui:message key="HowitWorks" /></h2>
						<p><%=howItWorks%></p>
					</div>
				</div>
				<div class="row how-it-works">
					<div class="col-xl-5 txt-sec col-12 col-md-5">
						<div class="regstr-sec2">
							<h3><liferay-ui:message key="CreateYourProfile" /></h3>
							<p><%=createYourProfile%></p>
							<a href="/web/guest/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Fcreate_account" class="btnn"><liferay-ui:message key="RegisterNow" /></a>
						</div>
					</div>
					<div class="col-xl-7 col-12 col-md-7">
						<div class="rgstr-farm">
							<div class="imeg">
								<img src="/o/new-misk-theme/landingPage/images/asd.png">
							</div>
							<div class="forrm">
								<div class="logo-green"></div>
								<form class="de-form">
								<fieldset>
									<input type="text" name="name" placeholder="<liferay-ui:message key="Name" />" disabled="disabled">
									<input type="email" name="email" placeholder="<liferay-ui:message key="Email" />" disabled="disabled">
									<!-- <input type="submit" name="synup" value="Sign up">  -->
									<a href="/web/guest/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Fcreate_account"  id="synup" class="synup"><liferay-ui:message key="SignUp" /></a>
									</fieldset>
									
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<section class="sec-3 titlee">
			<div class="container">
				<div class="row">
					<div class="col-xl-6 col-12 col-md-7">
						<div class="progrms">
							<a>
								<h5><%=upcommingevent_1Title %></h5>
								<p><%=upcommingevent_1Desc %></p>
							</a>
							<a class="middle-item">
								<h5><%=upcommingevent_2Title %></h5>
								<p><%=upcommingevent_2Desc %></p>
							</a>
							<a>
								<h5><%=upcommingevent_3Title %> </h5>
								<p><%=upcommingevent_3Desc %></p>
							</a>
						</div>
					</div>
					<div class="col-xl-5 txt-sec col-12 col-md-5">
						<div class="regstr-sec2">
							<h3><liferay-ui:message key="RegisterYourPrograms" /></h3>
							<p><%=registerForPrograms%></p>
							<a href="/web/guest/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Fcreate_account" class="btnn"><liferay-ui:message key="RegisterNow" /></a>
						</div>
					</div>
				</div>
			</div>
		</section>
		<section class="sec-2 titlee">
			<div class="container">
				<div class="row">
					<div class="col-xl-5 txt-sec col-12 col-md-5">
						<div class="regstr-sec2">
							<h3><liferay-ui:message key="ManageYourJourney" /></h3>
							<p><%=manageYourJourney%></p>
							<a href="/web/guest/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Fcreate_account" class="btnn"><liferay-ui:message key="RegisterNow" /></a>
						</div>
					</div>
					<div class="col-xl-7 col-12 col-md-7">
						<div class="logo-journey"></div>
					</div>
				</div>
			</div>
		</section>
		
		
 		<section class="counter">
			<div class="container">
				<div class="row">
					<div class="col-xl-4 col-md-4">
						<div class="countar">
						<h4 class="numbr countr-1"><%=youth%></h4>
						<p class="typ"><%=text1%></p>
						</div>
					</div>
					<div class="col-xl-4 countr-2 col-md-4">
						<div class="countar">
						<h4 class="numbr"><%=MonthlyActiveMembers%></h4>
						<p class="typ"><%=text2%><br></p>
						</div>
					</div>
					<div class="col-xl-4 col-md-4">
						<div class="countar">
						<h4 class="numbr"><%=ImproveattitudeofYouth%></h4>
						<p class="typ"><%=text3%><br></p>
						</div>
					</div>
				</div>
			</div>
		</section>
 
		<section class="video-sec" id="video">
			<div class="container">
				<div class="row">
					<div class="col-xl-12 col-12 col-md-12">
						<video width="100%" height="600px" controls>
 							 <source src=<%=urlVideo%> type="video/mp4">
 							 Your browser does not support HTML5 video.
						</video>
					</div>
				</div>
			</div>
		</section>
		<a id="Events_URL"></a>
		<section class="sec-events titlee">
			<div class="container">
				<div class="row">
					<div class="col-xl-12 col-12 col-md-12">
						<h2><liferay-ui:message key="UpcomingEvents" /></h2>
					</div>
				</div>
				<div class="row">
					<div class="col-xl-6 col-12 col-md-6 col-lg-6 m-ipad">
						<div class="eventt">
							<div class="evnt-img">
								<a href="${renderAction1}&<portlet:namespace />calendarBookingId=<%=calendarBookingId1%>">
									<img class="img-event" src=<%=img1%> style="height: 240px;">
								</a>
							</div>
							
							<div class="evnt-txt" style="min-height: 240px; padding-top: 7px;">
								<a href="${renderAction1}&<portlet:namespace />calendarBookingId=<%=calendarBookingId1%>"><span class="date-tym"><%=mYear1%>-<%=mMonthF1%>-<%=mDayFS1%></span></a>
								<a href="${renderAction1}&<portlet:namespace />calendarBookingId=<%=calendarBookingId1%>">
										<h4><%=titleEvent1%></h4></a>
								<a href="${renderAction1}&<portlet:namespace />calendarBookingId=<%=calendarBookingId1%>"><div class="block-ellipsis" style="min-height: 120px; "><%=descriptionEvent1%></div></a>
								<span class="location" style="width: 285px;">
										<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="Capa_1" x="0px" y="0px" viewBox="0 0 54.757 54.757" style="margin-right: 2%;enable-background:new 0 0 54.757 54.757; margin-top: 4px;" xml:space="preserve" width="16px" height="16px" class=""><g><path d="M40.94,5.617C37.318,1.995,32.502,0,27.38,0c-5.123,0-9.938,1.995-13.56,5.617c-6.703,6.702-7.536,19.312-1.804,26.952  L27.38,54.757L42.721,32.6C48.476,24.929,47.643,12.319,40.94,5.617z M27.557,26c-3.859,0-7-3.141-7-7s3.141-7,7-7s7,3.141,7,7  S31.416,26,27.557,26z" data-original="#000000" class="active-path" data-old_color="#000000" fill="#929292"></path></g> </svg>
										<a class="location-link" style="display: contents;" onclick="openQuestioneer(<%=href1%>)"><%=location1%></a></span>
							</div>
						</div>
					</div>
					<div class="col-xl-6 col-12 col-md-6 col-lg-6 m-ipad">
						<div class="eventt">
							<div class="evnt-img">
									<a href="${renderAction1}&<portlet:namespace />calendarBookingId=<%=calendarBookingId2%>">
									<img class="img-event" src=<%=img2%> style="height: 223px;">
									</a>
							</div>
							<div class="evnt-txt" style="min-height: 223px; padding-top: 7px;">
								<a href="${renderAction1}&<portlet:namespace />calendarBookingId=<%=calendarBookingId2%>"><span class="date-tym"><%=mYear2%>-<%=mMonthF2%>-<%=mDayFS2%></span></a>
								<a href="${renderAction1}&<portlet:namespace />calendarBookingId=<%=calendarBookingId2%>">
										<h4><%=titleEvent2%></h4></a>
									<a href="${renderAction1}&<portlet:namespace />calendarBookingId=<%=calendarBookingId2%>"><div class="block-ellipsis" style="min-height: 120px; "><%=descriptionEvent2%></div></a>
								<span class="location" style="width: 285px;">
										<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="Capa_1" x="0px" y="0px" viewBox="0 0 54.757 54.757" style="margin-right: 2%;enable-background:new 0 0 54.757 54.757; margin-top: 4px;" xml:space="preserve" width="16px" height="16px" class=""><g><path d="M40.94,5.617C37.318,1.995,32.502,0,27.38,0c-5.123,0-9.938,1.995-13.56,5.617c-6.703,6.702-7.536,19.312-1.804,26.952  L27.38,54.757L42.721,32.6C48.476,24.929,47.643,12.319,40.94,5.617z M27.557,26c-3.859,0-7-3.141-7-7s3.141-7,7-7s7,3.141,7,7  S31.416,26,27.557,26z" data-original="#000000" class="active-path" data-old_color="#000000" fill="#929292"></path></g> </svg>
										<a  class="location-link"  style="display: contents;" onclick="openQuestioneer(<%=href2%>)"><%=location2%></a></span>
							</div>
						</div>
					</div>
				</div>
				<div class="row" id="event-rw">
					<div class="col-xl-6 col-12 col-md-6 col-lg-6 m-ipad">
						<div class="eventt">
							<div class="evnt-img">
									<a href="${renderAction1}&<portlet:namespace />calendarBookingId=<%=calendarBookingId3%>">
									<img class="img-event" src=<%=img3%> style="height: 223px;">
									</a>
							</div>
							<div class="evnt-txt" style="min-height: 223px; padding-top: 7px;">
								<a href="${renderAction1}&<portlet:namespace />calendarBookingId=<%=calendarBookingId3%>"><span class="date-tym"><%=mYear3%>-<%=mMonthF3%>-<%=mDayFS3%></span></a>
								<a href="${renderAction1}&<portlet:namespace />calendarBookingId=<%=calendarBookingId3%>">
										<h4><%=titleEvent3%></h4></a>
								<a href="${renderAction1}&<portlet:namespace />calendarBookingId=<%=calendarBookingId3%>"><div class="block-ellipsis" style="min-height: 120px; "><%=descriptionEvent3%></div></a>
								<span class="location"style="width: 285px;">
										<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="Capa_1" x="0px" y="0px" viewBox="0 0 54.757 54.757" style="margin-right: 2%;enable-background:new 0 0 54.757 54.757; margin-top: 4px;" xml:space="preserve" width="16px" height="16px" class=""><g><path d="M40.94,5.617C37.318,1.995,32.502,0,27.38,0c-5.123,0-9.938,1.995-13.56,5.617c-6.703,6.702-7.536,19.312-1.804,26.952  L27.38,54.757L42.721,32.6C48.476,24.929,47.643,12.319,40.94,5.617z M27.557,26c-3.859,0-7-3.141-7-7s3.141-7,7-7s7,3.141,7,7  S31.416,26,27.557,26z" data-original="#000000" class="active-path" data-old_color="#000000" fill="#929292"></path></g> </svg>
										<a class="location-link"   style="display: contents;" onclick="openQuestioneer(<%=href3%>)"><%=location3%></a></span>
							</div>
						</div>
					</div>
						<div class="col-xl-6 col-12 col-md-6 col-lg-6 m-ipad">
						<div class="eventt">
							<div class="evnt-img">
									<a href="${renderAction1}&<portlet:namespace />calendarBookingId=<%=calendarBookingId4%>">
									<img class="img-event" src=<%=img4%> style="height: 223px;">
									</a>
							</div>
							<div class="evnt-txt" style="min-height: 223px; padding-top: 7px;">
								<a href="${renderAction1}&<portlet:namespace />calendarBookingId=<%=calendarBookingId4%>"><span class="date-tym"><%=mYear4%>-<%=mMonthF4%>-<%=mDayFS4%></span></a>
								<a href="${renderAction1}&<portlet:namespace />calendarBookingId=<%=calendarBookingId4%>">
										<h4><%=titleEvent4%></h4></a>
								<a href="${renderAction1}&<portlet:namespace />calendarBookingId=<%=calendarBookingId4%>">	<div class="block-ellipsis" style="min-height: 120px; "><%=descriptionEvent4%></div></a>
								<span class="location" style="width: 285px;">
										<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="Capa_1" x="0px" y="0px" viewBox="0 0 54.757 54.757" style="margin-right: 2%;enable-background:new 0 0 54.757 54.757; margin-top: 4px;" xml:space="preserve" width="16px" height="16px" class=""><g><path d="M40.94,5.617C37.318,1.995,32.502,0,27.38,0c-5.123,0-9.938,1.995-13.56,5.617c-6.703,6.702-7.536,19.312-1.804,26.952  L27.38,54.757L42.721,32.6C48.476,24.929,47.643,12.319,40.94,5.617z M27.557,26c-3.859,0-7-3.141-7-7s3.141-7,7-7s7,3.141,7,7  S31.416,26,27.557,26z" data-original="#000000" class="active-path" data-old_color="#000000" fill="#929292"></path></g> </svg>
										<a class="location-link"   style="display: contents;" onclick="openQuestioneer(<%=href4%>)"><%=location4%></a></span>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xl-12 col-12 col-md-12 text-center mt-0 mb-5">
						<a href="${renderAction}"><liferay-ui:message key="ShowAllEvents" /></a>
					</div>
				</div>
			</div>
		</section> 
		<section class="test-main">
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
							<h2 class="testimonial-heading"><liferay-ui:message key="Testimonial" /></h2>		
						<div id="owl-example" class="owl-carousel">
							
							
									<%
					
		 			 for(int j=1;j<4;j++){
		 				JournalArticle testimonialsJournalArticle = JournalArticleLocalServiceUtil.getLatestArticleByUrlTitle(themeDisplay1.getScopeGroupId(), "testimonial-structure-"+j, 0);
		 				String testimonialsContent  = testimonialsJournalArticle.getContentByLocale(themeDisplay1.getLanguageId());
		 	 			Document testimonialsDocument = SAXReaderUtil.read(testimonialsContent);
		 				Node testimonialsNode = testimonialsDocument.selectSingleNode("/root/dynamic-element[@name='Image']/dynamic-content");
		 				String testimonialsImageJsonData = testimonialsNode.getText();
		 			    JSONObject testimonialsImagejsonObject = JSONFactoryUtil.createJSONObject(testimonialsImageJsonData) ;
		 			    DLFileEntry imageFolderDataTestimonials = DLFileEntryLocalServiceUtil.getDLFileEntry( testimonialsImagejsonObject.getLong("fileEntryId"));
		 				Node testimonialsDescNode = testimonialsDocument.selectSingleNode("/root/dynamic-element[@name='TestimonialText']/dynamic-content");
		 				Node testimonialsNameNode = testimonialsDocument.selectSingleNode("/root/dynamic-element[@name='Name']/dynamic-content");
		 				Node testimonialsPositionNode = testimonialsDocument.selectSingleNode("/root/dynamic-element[@name='Position']/dynamic-content");
		 				Node testimonialsLocationNode = testimonialsDocument.selectSingleNode("/root/dynamic-element[@name='Location']/dynamic-content");
		 			    String testimonialsImage = "/documents/"+imageFolderDataTestimonials.getRepositoryId()+"/"+imageFolderDataTestimonials.getFolderId()+"/"+imageFolderDataTestimonials.getFileName();
		 			%>
							
							<div class="testt">
								<p class="testimonial-paragraph">"<%=testimonialsDescNode.getText()%>"</p>
								<div class="imgttes">
									<img style="width:120px;height:120px;border-radius:70px;" src=<%=testimonialsImage%>>
									<h4><%=testimonialsNameNode.getText()%><span><%=testimonialsPositionNode.getText()%><br><%=testimonialsLocationNode.getText()%></span></h4>
									
								</div>
							</div>
							<%}	%> 	 
						</div>
					</div>
				</div>
			</div>
		</section> 
		
		<a id="News_URL"></a>
		<section class="sec-5 titlee" style="margin-bottom:5%">
			<%@ include file="/news.jsp" %>
		</section>
<%-- 		<section class="footer-top" id="footer-top">
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
                    <div class="row row-check py-2">
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
   
        </html>	
        
        
        <% } %> 
<!-- <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        Modal Header
        <div class="modal-header">
          <h4 class="modal-title">Modal Heading</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        Modal body
        <div class="modal-body">
          <iframe src="https://www.google.com/maps/embed?pb=!1m10!1m8!1m3!1d116862.54554679655!2d90.40409584970706!3d23.749000170125925!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sbd!4v1550040341458" width="100%" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
        </div>
        
        Modal footer
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div> -->
  
  
  
<div class="modal fade" id="myform" tabindex="-1" role="dialog" aria-labelledby="addlanguageLabel" aria-hidden="true">
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
