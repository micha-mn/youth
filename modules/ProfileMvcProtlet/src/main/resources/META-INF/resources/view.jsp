<%@ include file="/init.jsp" %>
 <%@page import= "vo.ProfileVO"%>
<%@page import="ProfileMvcProtlet.portlet.ProfileMvcProtletPortlet"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.dao.jdbc.DataAccess"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<script src="/o/new-misk-theme/js/landing/custom.js"></script> 
<script src="/o/new-misk-theme/alerts/sweet-alert.min.js"></script> 

<% if(themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")) { %>
<link href="/o/new-misk-theme/css/landing/CustomStyle_Ar.css" rel="stylesheet" />
<% } else { %>
<link href="/o/new-misk-theme/css/landing/CustomStyle.css" rel="stylesheet" />
<% } %>

<script type="text/javascript">
function showHideALert(msgText){
	$(".alertTextClass").html(msgText);
	var $div = $(".alertContainerClass");
	if($div.is(":visible")){return;}
	$div.show();
	setTimeout(function(){
		$div.hide();
	},2000);
}
</script>

<link href="/o/new-misk-theme/alerts/style-alert.css" rel="stylesheet" /> 
 <%
 int userId =-1;
	  HttpServletRequest requestInsideThePortlet = PortalUtil.getHttpServletRequest(renderRequest);
	  String userIdserver =  PortalUtil.getOriginalServletRequest(requestInsideThePortlet).getParameter("userId");
	  String fromScrn =  PortalUtil.getOriginalServletRequest(requestInsideThePortlet).getParameter("fromScrn");
	  System.out.println("-----UserId first in profile---0" + "----"+userIdserver);
 	if (userIdserver !=null)  
		userId=Integer.parseInt(userIdserver);
 	else
	   userId = Integer.parseInt(renderRequest.getRemoteUser());
 	
 String viewMode = "false";
 if(fromScrn != null && "forms".equals(fromScrn))
	 viewMode = "true";
 int currentYear = new Date().getYear()+1900;
 
  System.out.println("-----viewMode first in profile---0" + "----"+viewMode + "--currentYear--- " + currentYear);
 	
 System.out.println("test fetet");
ProfileMvcProtletPortlet evt = new ProfileMvcProtletPortlet();
 System.out.println("test jean");
 ProfileVO pinfo = evt.getprofileInfo(Long.valueOf(userId));
 ProfileVO pImage = evt.getprofileImage(Long.valueOf(userId));


 String imageSrc="/o/new-misk-theme/images/profile/pic1.png";
 if (pImage.getImage() != null)
    imageSrc = pImage.getImage();
String mobileNumber = "";
String mobileNumbercode = "";
if(pinfo.getMobileno()!= null)
{	
	mobileNumber = pinfo.getMobileno();
	mobileNumbercode = "+"+pinfo.getMobilenocode();
}
	  	
User usr = UserServiceUtil.getUserById(Long.parseLong(String.valueOf(userId)));
String dateOfBirth = "";
String dateOfJoin = "";
String email = "";
String title = "";
String firstName="";
String familyName="";
String currentPosition="";
String country="";
String about="";
String educationField="";
String universityGeneral="";
String loginUserId =String.valueOf(themeDisplay.getUserId());
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
if(pinfo.getDateofbirth() !=null)  	 
	dateOfBirth=pinfo.getDateofbirth();
else 
	dateOfBirth=dateFormat.format(usr.getBirthday());

if(pinfo.getEmail() !=null)  	
    email=pinfo.getEmail();
else 
    email=usr.getEmailAddress();

if (pinfo.getTitle()!=null)
   title=pinfo.getTitle();

if(pinfo.getFirstname() !=null)
	firstName = pinfo.getFirstname();
else
	firstName=usr.getFirstName();

if(pinfo.getFamilyname() !=null)
   familyName =pinfo.getFamilyname();
else
   familyName=usr.getLastName();

if(pinfo.getCurrentworkposition()!=null && pinfo.getCurrentworklocation()!=null  && !pinfo.getCurrentworkposition().isEmpty() && !pinfo.getCurrentworklocation().isEmpty())
	currentPosition=pinfo.getCurrentworkposition() +" at "+pinfo.getCurrentworklocation();

System.out.println("pinfo.getCountryofresidence() "+pinfo.getCountryofresidence());
if(pinfo.getCountryofresidence()!=null && pinfo.getCityofresidence()!=null && !pinfo.getCountryofresidence().isEmpty() && !pinfo.getCityofresidence().isEmpty())
   country=pinfo.getCountryofresidence()  +" ("+pinfo.getCityofresidence()+")";

if(pinfo.getAbout() != null)
	about=pinfo.getAbout();

if(pinfo.getEducationField() != null)
   educationField=pinfo.getEducationField();

if(pinfo.getUniversitygeneral() != null)
	universityGeneral = pinfo.getUniversitygeneral() ;

dateOfJoin = dateFormat.format(usr.getCreateDate());
%>
     	   
<portlet:renderURL var="editProfileURL">
 <portlet:param name="mvcPath" value="/editProfile.jsp"></portlet:param>
</portlet:renderURL>

<liferay-portlet:resourceURL var="resourceUrl1" >
	<liferay-portlet:param name="param1" value="Value1"/>
</liferay-portlet:resourceURL>
<html>
<head>
    <meta charset="utf-8" />
    <title>Profile</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <style>
		input#updateuserprofile {
		    margin-left: 15%;
		}

	   <% if(themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")) { %>
			section {
				    direction: rtl;
				}
				#banner-col1 .whyt-bg .profyl-desc .abt-profile {
				    float: right!important;
				    width: 95%;
				    margin-bottom: 25px;
				}
				section#header-section {
				    background-image: linear-gradient(to left, #0061a5, #279574) !important;
				}
				.popover {
				    position: absolute;
				    transform: translate3d(670px, 638px, 0px);
				    top: 0px;
				    right: 100%;
				    will-change: transform;
				    width: 100%;
				}
		<% } %>

 </style>
</head>
<body>
<div class="profile-page">
    <div class="profile-container-box">
       <section id="profile-header-section">    
           <div class="container">
            <div class="row main-header-box">
                <div class="col-md-4 ">
                    <div class="row">
                        <div class="col-md-12 text-center" >    
                            <% if("false".equals(viewMode)){ %>                
	                  		<a href="#" data-scroll="toggle(.fromLeftIn, .fromLeftOut)"><%} %>
                            	<img src="<%=imageSrc%>" class="img-fluid-profileImage" id="profileimage">
                            <% if("false".equals(viewMode)){ %></a><%} %>
                            <input type="file" id="profilepic_file" class="file-upload" style="display: none;">
							<span id="profilepic" style="cursor: pointer;"></span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 text-center pt-3" >
                            <h5><label id="lblfullname" class="profile-username-text"> <%=title%> <%=firstName%> <%=familyName%></label> </h5>
                            <p><label class="profile-username-position" id="lblcurrentposition"><%=currentPosition%></label>  </p>
                              <p class="text-white">
                               <%if(country != null && !"".equals(country)) {%>
                               <span style="margin-right: 5px !important">
                                  <svg xmlns="" xmlns:xlink="" version="1.1" id="Capa_1" x="0px" y="0px" viewBox="0 0 54.757 54.757" style="enable-background:new 0 0 54.757 54.757;" xml:space="preserve" width="16px" height="16px" class=""><g><path d="M40.94,5.617C37.318,1.995,32.502,0,27.38,0c-5.123,0-9.938,1.995-13.56,5.617c-6.703,6.702-7.536,19.312-1.804,26.952  L27.38,54.757L42.721,32.6C48.476,24.929,47.643,12.319,40.94,5.617z M27.557,26c-3.859,0-7-3.141-7-7s3.141-7,7-7s7,3.141,7,7  S31.416,26,27.557,26z" data-original="#000000" class="active-path" data-old_color="#000000" fill="#ffffff"/></g> </svg>
                                    </span>                                
                                <label class="profile-username-location" id="lblcurrentlocation"><%=country%></label>
                                <%} %>
                            </p>
                        </div>
                    </div>
                    <div class="row pt-2 pb-5">
                    	<!--<div class="col-md-12 text-center btn-lvl-up"><a href="#">Level Up</a></div> -->
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="card-about">
                    <div class="whyt-bg">
								<div class="profyl-desc">
								<% if("false".equals(viewMode)){ %>
								 <div class="edit-btn">
									<%--   <a href="${editProfileURL}" class="edyt display">edit</a>
									 --%>  
									  <a href="#" class="float-right display" data-toggle="modal" data-target="#editprofile" class="edyt display"><liferay-ui:message key="EditProfile" /></a>
								  </div>
								  <div class="edit-btn">
									  <a href="/web/guest/journey" class="float-right display" class="edyt display"><liferay-ui:message key="Journey" />  |  </a>
									</div>
								<%} %>	
									<div class="abt-profile">
										<h4><liferay-ui:message key="About" /></h4>
										<p class="about-intro">
										<%=about%>
										</p>
									</div>
								</div>
								<ul class="personal-detals">
									<li>
										<span><liferay-ui:message key="EducationField" /></span>
										<p><%=educationField%></p>
									</li>
									<li>
										<span><liferay-ui:message key="University" /></span>
										<p><%=universityGeneral%></p>
									</li>
									<li>
										<span><liferay-ui:message key="Email" /></span>
										<p><%=email%></p>
									</li>
									<li class="limargin">
										<span><liferay-ui:message key="DateOfJoining" /></span>
										<p><%=dateOfJoin%></p>
									</li>
									<li class="limargin">
										<span><liferay-ui:message key="DateOfBirth" /></span>
										<p><%=dateOfBirth%></p>
									</li>
									<li class="limargin">
										<span><liferay-ui:message key="Mobile" /></span>
										<p><%=mobileNumbercode%> <%=mobileNumber%></p>
									</li>
								</ul>
							</div>
                    </div>
                </div>
            </div>
            </div>
        </section>
        <section id="content-section">
         <div class="container">
            <div class="row">
                <div class="col-md-4 awards">
                    <div class="row nonSpeaker">
                        <div class="col-md-12 text-center">
                           <h4 style="margin: 1%; font-family: Montserrat; color: black;"><liferay-ui:message key="AchievementsAwards" /></h4>
                        </div>
                    </div>
                   <ul class="achievements" id="UlAchievementsAwards"></ul>
                    <div class="row pt-2 nonSpeaker">
<!--                         <div class="col-md-12 text-center" id="showMore"> -->
<!--                             <p><span><a href="#" class="show-more">show more</a></span></p> -->
<!--                         </div> -->
                        <div class="col-md-12 text-center" >
                            <p><span style= "font-size: 14px; color: rgb(51,166,100)" id="spanAchievements"></span></p>
                        </div>
                    </div>
<!--                     <div class="row pt-5"> -->
<!--                         <div class="col-md-12"> -->
<!--                             <div class="pb-3"> -->
<!--                             	<span class="left-title"><liferay-ui:message key="Certificates" /></span> -->
<%--                             <% if("false".equals(viewMode)){ %>	  --%>
<!--                             	<span><a href="#" class="display" data-toggle="modal" data-target="#addlicenceandcertification"><i class="fa fa-pencil"></i></a></span> -->
<%--                            	<%} %> --%>
<!--                           	</div> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                     <div class="row pt-2 pb-3"> -->
<!--                         <div class="col-md-12"> -->
<!--                             <div id="LicensesandCertificationempty" > -->
<!--                                 <p><liferay-ui:message key="AlltheCertificatesInformationwillbeshownhere" /></p> -->
<!--                             </div> -->
<!--                             <div id="dvLicensesandCertification"></div> -->
<!--                         </div> -->
<!--                     </div> -->
                      <div class="row pt-5">
                        <div class="col-md-12">
                            <div class="pb-3">
                            	<span class="left-title"><liferay-ui:message key="Skill" /></span>
                           	<% if("false".equals(viewMode)){ %>	 
                           		<span><a href="#" class="display" data-toggle="modal" data-target="#addskills"><i class="fa fa-pencil"></i></a></span>
                           	<%} %>
                        	</div>
                        </div>
                    </div>
                    <div class="row pt-2">
                        <div class="col-md-12">
                            <div id="skillempty"><p><liferay-ui:message key="AlltheInformationwillbeshownhere" /></p></div>
                            <div id="dvskills"></div>
                        </div>
                    </div>
                    <div class="row pt-5">
                        <div class="col-md-12">
                            <div class="pb-3"><span class="left-title"><liferay-ui:message key="Interest" /></span>
                            <% if("false".equals(viewMode)){ %>
                            	<span><a href="#" class="display" data-toggle="modal" data-target="#addintrest"><i class="fa fa-pencil"></i></a></span>
                            <%} %>
                            </div>
                        </div>
                    </div>
                    <div class="row pt-2">
                        <div class="col-md-12">
                            <div id="intrestempty" >
                                <p><liferay-ui:message key="AlltheIntrestwillbeshownhere"/></p>
                            </div>
                            <div id="dvintrest"></div>
                        </div>
                    </div>
                     <div class="row pt-2">
                        <div class="col-md-12">
                            <div class="pb-3 pt-3">
                            	<span class="left-title"><liferay-ui:message key="JobWishlist" /></span>
                            <% if("false".equals(viewMode)){ %>	 	
                            	<span><a href="#" class="display" data-toggle="modal" data-target="#addjobwishlist"><i class="fa fa-pencil"></i></a></span>
                           	<%} %>
                           	</div>
                        </div>
                    </div>
                    <div class="row pt-2">
                        <div class="col-md-12">
                            <div id="jobwishlistempty" >
                                <p><liferay-ui:message key="AlltheJobWishlistInformationwillbeshownhere"/></p>
                            </div>
                            <div id="dvjobwishlist"></div>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                <div class="row pt-3 margin-right">
                        <div class="col-md-12 profilecard p-0">
                            <div class="card-box p-0">
                                <div class="card-body">
                                  <h3 class="progress-title"><liferay-ui:message key="ProfileStrength" /><!-- <span>Intermediate</span> --></h3>
						            <div class="progress">
										<div class="bar popover-1" data-content=''>
											<div class="pending-progress-bar" style="width:14.28%;"></div>
											<div class="pending-progress-bar" style="width:14.28%;"></div>
											<div class="pending-progress-bar" style="width:14.28%;"></div>
											<div class="pending-progress-bar" style="width:14.28%;"></div>
											<div class="pending-progress-bar" style="width:14.28%;"></div>
											<div class="pending-progress-bar" style="width:14.28%;"></div>
											<div class="pending-progress-bar" style="width:14.28%;"></div>
										</div>
										<div class="pending-progress-intermediate">
											<i class="fa fa-check"></i>
										</div>
										<div class="pending-progress-all-star">
											<i class="fa fa-star"></i>
										</div>
						            </div>
                            	</div>
                        	</div>
                    	</div>
             	        <div class="row no-gutters margin-right quotes-div">
	                          <!--About - mission section-->
							<div class="sec-abtm">
								<div class="sec-abut">
	<%-- 							   <img src="${themeDisplay.getPathThemeRoot()}/images/profile/abouticon.png" class="img-fluid" /> --%>
	<!--                                <h5><liferay-ui:message key="AboutYouthHub" /></h5> -->
	<!-- 							   <p><liferay-ui:message key="youngLeader" /></p> -->
								</div>								
								<div class="sec-mision">
	<%-- 							   <img src="${themeDisplay.getPathThemeRoot()}/images/profile/missonicon.png" class="img-fluid" /> --%>
	<!--                                <h5><liferay-ui:message key="Mission" /></h5> -->
	<!-- 							   <p><liferay-ui:message key="OurMission" /></p> -->
								</div>
							</div>
	                    </div>
                        <div class="col-md-12 profilecard pt-3 p-0">
                            <div  id="cardeducation" class="card-box p-0">
                                <div class="card-body">
                                    <h5 class="titletextgreen"><liferay-ui:message key="Education" /> 
                                    <% if("false".equals(viewMode)){ %>	 
                                    <span><a href="#" class="display linkColor float-right" data-toggle="modal" data-target="#addeducation"><i class="fa fa-plus" aria-hidden="true"></i></a></span><%} %>
                                    </h5>
                                    <div id="dveducationempty" >
                                        <p><liferay-ui:message key="AlltheEducationInformationwillbeshownhere" /> </p>
                                    </div>
                                    <div id="dveducation">
                                        <ul id="educationList" class="educationList"></ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12 profilecard pt-3 p-0" >
                            <div id="cardCertificates" class="card-box p-0">
                                <div class="card-body">
                                    <h5 class="titletextgreen"><liferay-ui:message key="Certificates" />
                                    <% if("false".equals(viewMode)){ %>	 
                                    <span><a href="#" class="display linkColor float-right" data-toggle="modal" data-target="#addlicenceandcertification"><i class="fa fa-plus" aria-hidden="true"></i></a></span><%} %>
                                    </h5>
                                    <div id="LicensesandCertificationempty" >
                                        <p><liferay-ui:message key="AlltheCertificatesInformationwillbeshownhere" /></p>
                                    </div>
                                    <div id="dvcertificate" >
                                        <ul id="dvLicensesandCertification" class="educationList"></ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12 profilecard pt-3 p-0" >
                            <div id="cardexperience" class="card-box p-0">
                                <div class="card-body">
                                    <h5 class="titletextgreen"><liferay-ui:message key="Experience" />
                                    <% if("false".equals(viewMode)){ %>	 
                                    <span><a href="#" class="display linkColor float-right" data-toggle="modal" data-target="#addworkexperience"><i class="fa fa-plus" aria-hidden="true"></i></a></span><%} %>
                                    </h5>
                                    <div id="workexperienceempty" >
                                        <p><liferay-ui:message key="AlltheWorkExperienceinformationwillbeshownhere" /></p>
                                    </div>
                                    <div id="dvworkexperience" >
                                        <ul id="experienceList"></ul>
                                    </div>
                                </div>
                            </div>
                        </div>
<!--                     <div class="row" style="margin-right:40px !important;">
                        <div class="col-md-12  profilecard">
                            <div class="card" id="coverletter">
                                <div class="card-body">
                                    <h5 class="titletextgreen">CV/Cover Letter   <span><a href="#" class="btnedit float-right" data-toggle="modal" data-target="#addresume">Add</a></span></h5>
                                    <div id="resumeempty" >
                                        <p class="resumeempty-text" >
                                            This letter is to express my intrest in your posting on Dice.com for an experienced
                                            Software Developer. With a Bachelor's degree in Computer Science, Master's degree in information Technology, and hands-on experience using .Net language to create and implment software applications. I am confident i will be an asset to your organization.
                                        </p>
                                        <p ><label class="upload-resume-text">Upload Resume</label></p>
                                        <p >
                                            <a href="#" class="btn btn-attachment" data-toggle="modal" data-target="#addresume">Attachment</a>
                                        </p>
                                    </div>
                                    <div id="dvresume" >
                                        <div class="col-md-12">
                                            <table class="table" id="tblresume">
                                                <thead style="display:none">
                                                    <tr>
                                                        <th></th>
                                                    </tr>
                                                </thead>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>-->

                    <div class="col-md-12 p-0" style="display:none">
                        <div class="col-md-12 p-0 pb-4">
                                <div class="card-body">
                                    <h5 class="titletextgreen"><liferay-ui:message key="Testimonials" /><span><a href="#" class="display btnedit float-right" data-toggle="modal" data-target="#requesttestimonial">Add</a></span></h5>
                                    <div id="testimonialempty">
                                     <liferay-ui:message key="Allthetestimonialswillbeshownhere" /> 
                                    </div>
                                    <div id="dvtestimonial">
                                        <div id="myCarousel" class="carousel slide" data-ride="carousel">
                                            <!-- Indicators -->
                                            <ol class="carousel-indicators" id="testimonialindicator">
                                                <!--<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                                <li data-target="#myCarousel" data-slide-to="1"></li>
                                                <li data-target="#myCarousel" data-slide-to="2"></li>-->
                                            </ol>

                                            <!-- Wrapper for slides -->
                                            <div class="carousel-inner" id="testimonialitem">
                                                <!--<div class="carousel-item active">
                                                    <div class="row">
                                                        <div class="col-md-12 text-center">
                                                            <blockquote style="margin-left:50px !important;margin-right:50px !important">
                                                                <span class="text-muted " style="margin-top:50px !important">
                                                                    "It is clear many students want to get involved with this
                                                                    platform and understand the value it provides as they build
                                                                    their proÃƒÂ¯Ã‚Â¬Ã‚Âles and share who they are"
                                                                </span><br />
                                                            </blockquote>
                                                            <div id="photo" style="text-align: center">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row text-center">
                                                        <div class="col-md-3"></div>
                                                        <div class="col-md-3" style="padding:0px;margin-right:-20px !important"><img src="${themeDisplay.getPathThemeRoot()}/images/profile/t1.png" class="img-fluid rounded-circle" /></div>
                                                        <div class="col-md-3" style="padding:0px; margin-left:-20px !important; padding-top:25px !important;">
                                                            <p>
                                                                <span style="color:#009898; font-family:'myriadpro-light'"> Muhammad Salaam</span><br />
                                                                <span>HOD Te Reo Maori</span>
                                                            </p>
                                                        </div>
                                                        <div class="col-md-3"></div>
                                                    </div>
                                                </div>
                                                <div class="carousel-item">
                                                    <div class="row">
                                                        <div class="col-md-12 text-center">
                                                            <blockquote style="margin-left:50px !important;margin-right:50px !important">
                                                                <span class="text-muted " style="margin-top:50px !important">
                                                                    "It is clear many students want to get involved with this
                                                                    platform and understand the value it provides as they build
                                                                    their proÃƒÂ¯Ã‚Â¬Ã‚Âles and share who they are"
                                                                </span><br />

                                                            </blockquote>
                                                            <div id="photo" style="text-align: center">


                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row text-center">
                                                        <div class="col-md-3"></div>
                                                        <div class="col-md-3" style="padding:0px;margin-right:-20px !important"><img src="${themeDisplay.getPathThemeRoot()}/images/profile/t1.png" class="img-fluid rounded-circle" /></div>
                                                        <div class="col-md-3" style="padding:0px; margin-left:-20px !important; padding-top:25px !important;">
                                                            <p>
                                                                <span style="color:#009898; font-family:'myriadpro-light'"> Muhammad Salaam</span><br />
                                                                <span>HOD Te Reo Maori</span>
                                                            </p>
                                                        </div>
                                                        <div class="col-md-3"></div>
                                                    </div>
                                                </div>

                                                <div class="carousel-item">
                                                    <div class="row">
                                                        <div class="col-md-12 text-center">
                                                            <blockquote style="margin-left:50px !important;margin-right:50px !important">
                                                                <span class="text-muted " style="margin-top:50px !important">
                                                                    "It is clear many students want to get involved with this
                                                                    platform and understand the value it provides as they build
                                                                    their proÃƒÂ¯Ã‚Â¬Ã‚Âles and share who they are"
                                                                </span><br />

                                                            </blockquote>
                                                            <div id="photo" style="text-align: center">


                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="row text-center">
                                                        <div class="col-md-3"></div>
                                                        <div class="col-md-3" style="padding:0px;margin-right:-20px !important"><img src="${themeDisplay.getPathThemeRoot()}/images/profile/t1.png" class="img-fluid rounded-circle" /></div>
                                                        <div class="col-md-3" style="padding:0px; margin-left:-20px !important; padding-top:25px !important;">
                                                            <p>
                                                                <span style="color:#009898; font-family:'myriadpro-light'">Mustafa Nafees</span><br />
                                                                <span>Senior Software Engineer</span>
                                                            </p>
                                                        </div>
                                                        <div class="col-md-3"></div>
                                                    </div>
                                                </div>-->
                                            </div>

                                            <!-- Left and right controls -->
                                            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                                                <span class="glyphicon glyphicon-chevron-left"></span>
                                                <span class="sr-only">Previous</span>
                                            </a>
                                            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                                                <span class="glyphicon glyphicon-chevron-right"></span>
                                                <span class="sr-only">Next</span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
          </div>
        </section>
    </div>

    <!-- Modal -->
      <div class="modal fade" id="editprofile" tabindex="-1" role="dialog" aria-labelledby="editprofileLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                    <div class="modal-header text-white bg-info">
                    <b class="modal-title" id="editprofileLabel">
                        <label><liferay-ui:message key="EditProfile" /></label>
                    </b>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmeditprofile" class="bootstrap-form needs-validation" novalidate>
                       <input type="hidden" id="profileId" name="profileId" value="0">
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="Title" /></label><span class="text-danger">*</span>
                                <select id="title" name="title" class="form-control" required>
                                    <option value=""><liferay-ui:message key="select" /></option>
                                    <option value="Mr."><liferay-ui:message key="Mr" /></option>
                                    <option value="Ms."><liferay-ui:message key="Ms" /></option>
                                    <option value="Doc."><liferay-ui:message key="Doc" /></option>
                                    <option value="Prince."><liferay-ui:message key="Prince" /></option>
                                    <option value="Princess."><liferay-ui:message key="Princess" /></option>
                                </select>
                                <div class="invalid-feedback">
                                    Title Name is required.
                                </div>
                            </div>
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="FirstName" /></label><span class="text-danger">*</span>
                                <input type="text" maxlength="70" value=<%=firstName%> name="<liferay-ui:message key="FirstName" />" id="firstname" class="form-control" placeholder="First name" required />
                                <div class="invalid-feedback">
                                    First Name is required.
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="FatherName" /></label><span class="text-danger"></span>
                                <input type="text" maxlength="70" name="<liferay-ui:message key="FatherName" />" id="fatherName" class="form-control" placeholder="Father name"  />
                                <div class="invalid-feedback">
                                    Father Name is required.
                                </div>
                            </div>
                             <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="FamilyName" /></label><span class="text-danger">*</span>
                                <input type="text" maxlength="70" value=<%=familyName%> class="form-control" id="familyname" name="<liferay-ui:message key="FamilyName" />" placeholder="Family name" required />
                                <div class="invalid-feedback">
                                    Family Name is required.
                                </div>
                            </div>
                            <!--<div class="col-md-6 form-group">
                                <label>Grandfather Name</label><span class="text-danger">*</span>
                                <input type="text" class="form-control" id="grandfatherName" name="Grand father name" placeholder="Grand father name" required />
                                <div class="invalid-feedback">
                                    Grandfather Name is required.
                                </div>
                            </div> -->
                        </div>
                        <div class="row">
                           <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="MobileNo" /></label><span class="text-danger">*</span>
                           	<div class="mobileno-container">
                                <select name="<liferay-ui:message key="MobileNo" />" id="mobileno-code" class="form-control">
     	        					<option data-countryCode="GB" value="44" Selected><liferay-ui:message key="UK" /> (+44)</option>
								    <option data-countryCode="US" value="1"><liferay-ui:message key="USA" /> (+1)</option>
								    <option data-countryCode="DZ" value="213">Algeria (+213)</option>
									<option data-countryCode="AD" value="376">Andorra (+376)</option>
									<option data-countryCode="AO" value="244">Angola (+244)</option>
									<option data-countryCode="AI" value="1264">Anguilla (+1264)</option>
									<option data-countryCode="AG" value="1268">Antigua &amp; Barbuda (+1268)</option>
									<option data-countryCode="AR" value="54">Argentina (+54)</option>
									<option data-countryCode="AM" value="374">Armenia (+374)</option>
									<option data-countryCode="AW" value="297">Aruba (+297)</option>
									<option data-countryCode="AU" value="61">Australia (+61)</option>
									<option data-countryCode="AT" value="43">Austria (+43)</option>
									<option data-countryCode="AZ" value="994">Azerbaijan (+994)</option>
									<option data-countryCode="BS" value="1242">Bahamas (+1242)</option>
									<option data-countryCode="BH" value="973">Bahrain (+973)</option>
									<option data-countryCode="BD" value="880">Bangladesh (+880)</option>
									<option data-countryCode="BB" value="1246">Barbados (+1246)</option>
									<option data-countryCode="BY" value="375">Belarus (+375)</option>
									<option data-countryCode="BE" value="32">Belgium (+32)</option>
									<option data-countryCode="BZ" value="501">Belize (+501)</option>
									<option data-countryCode="BJ" value="229">Benin (+229)</option>
									<option data-countryCode="BM" value="1441">Bermuda (+1441)</option>
									<option data-countryCode="BT" value="975">Bhutan (+975)</option>
									<option data-countryCode="BO" value="591">Bolivia (+591)</option>
									<option data-countryCode="BA" value="387">Bosnia Herzegovina (+387)</option>
									<option data-countryCode="BW" value="267">Botswana (+267)</option>
									<option data-countryCode="BR" value="55">Brazil (+55)</option>
									<option data-countryCode="BN" value="673">Brunei (+673)</option>
									<option data-countryCode="BG" value="359">Bulgaria (+359)</option>
									<option data-countryCode="BF" value="226">Burkina Faso (+226)</option>
									<option data-countryCode="BI" value="257">Burundi (+257)</option>
									<option data-countryCode="KH" value="855">Cambodia (+855)</option>
									<option data-countryCode="CM" value="237">Cameroon (+237)</option>
									<option data-countryCode="CA" value="1">Canada (+1)</option>
									<option data-countryCode="CV" value="238">Cape Verde Islands (+238)</option>
									<option data-countryCode="KY" value="1345">Cayman Islands (+1345)</option>
									<option data-countryCode="CF" value="236">Central African Republic (+236)</option>
									<option data-countryCode="CL" value="56">Chile (+56)</option>
									<option data-countryCode="CN" value="86">China (+86)</option>
									<option data-countryCode="CO" value="57">Colombia (+57)</option>
									<option data-countryCode="KM" value="269">Comoros (+269)</option>
									<option data-countryCode="CG" value="242">Congo (+242)</option>
									<option data-countryCode="CK" value="682">Cook Islands (+682)</option>
									<option data-countryCode="CR" value="506">Costa Rica (+506)</option>
									<option data-countryCode="HR" value="385">Croatia (+385)</option>
									<option data-countryCode="CU" value="53">Cuba (+53)</option>
									<option data-countryCode="CY" value="90392">Cyprus North (+90392)</option>
									<option data-countryCode="CY" value="357">Cyprus South (+357)</option>
									<option data-countryCode="CZ" value="42">Czech Republic (+42)</option>
									<option data-countryCode="DK" value="45">Denmark (+45)</option>
									<option data-countryCode="DJ" value="253">Djibouti (+253)</option>
									<option data-countryCode="DM" value="1809">Dominica (+1809)</option>
									<option data-countryCode="DO" value="1809">Dominican Republic (+1809)</option>
									<option data-countryCode="EC" value="593">Ecuador (+593)</option>
									<option data-countryCode="EG" value="20">Egypt (+20)</option>
									<option data-countryCode="SV" value="503">El Salvador (+503)</option>
									<option data-countryCode="GQ" value="240">Equatorial Guinea (+240)</option>
									<option data-countryCode="ER" value="291">Eritrea (+291)</option>
									<option data-countryCode="EE" value="372">Estonia (+372)</option>
									<option data-countryCode="ET" value="251">Ethiopia (+251)</option>
									<option data-countryCode="FK" value="500">Falkland Islands (+500)</option>
									<option data-countryCode="FO" value="298">Faroe Islands (+298)</option>
									<option data-countryCode="FJ" value="679">Fiji (+679)</option>
									<option data-countryCode="FI" value="358">Finland (+358)</option>
									<option data-countryCode="FR" value="33">France (+33)</option>
									<option data-countryCode="GF" value="594">French Guiana (+594)</option>
									<option data-countryCode="PF" value="689">French Polynesia (+689)</option>
									<option data-countryCode="GA" value="241">Gabon (+241)</option>
									<option data-countryCode="GM" value="220">Gambia (+220)</option>
									<option data-countryCode="GE" value="7880">Georgia (+7880)</option>
									<option data-countryCode="DE" value="49">Germany (+49)</option>
									<option data-countryCode="GH" value="233">Ghana (+233)</option>
									<option data-countryCode="GI" value="350">Gibraltar (+350)</option>
									<option data-countryCode="GR" value="30">Greece (+30)</option>
									<option data-countryCode="GL" value="299">Greenland (+299)</option>
									<option data-countryCode="GD" value="1473">Grenada (+1473)</option>
									<option data-countryCode="GP" value="590">Guadeloupe (+590)</option>
									<option data-countryCode="GU" value="671">Guam (+671)</option>
									<option data-countryCode="GT" value="502">Guatemala (+502)</option>
									<option data-countryCode="GN" value="224">Guinea (+224)</option>
									<option data-countryCode="GW" value="245">Guinea - Bissau (+245)</option>
									<option data-countryCode="GY" value="592">Guyana (+592)</option>
									<option data-countryCode="HT" value="509">Haiti (+509)</option>
									<option data-countryCode="HN" value="504">Honduras (+504)</option>
									<option data-countryCode="HK" value="852">Hong Kong (+852)</option>
									<option data-countryCode="HU" value="36">Hungary (+36)</option>
									<option data-countryCode="IS" value="354">Iceland (+354)</option>
									<option data-countryCode="IN" value="91">India (+91)</option>
									<option data-countryCode="ID" value="62">Indonesia (+62)</option>
									<option data-countryCode="IR" value="98">Iran (+98)</option>
									<option data-countryCode="IQ" value="964">Iraq (+964)</option>
									<option data-countryCode="IE" value="353">Ireland (+353)</option>
									<option data-countryCode="IL" value="972">Israel (+972)</option>
									<option data-countryCode="IT" value="39">Italy (+39)</option>
									<option data-countryCode="JM" value="1876">Jamaica (+1876)</option>
									<option data-countryCode="JP" value="81">Japan (+81)</option>
									<option data-countryCode="JO" value="962">Jordan (+962)</option>
									<option data-countryCode="KZ" value="7">Kazakhstan (+7)</option>
									<option data-countryCode="KE" value="254">Kenya (+254)</option>
									<option data-countryCode="KI" value="686">Kiribati (+686)</option>
									<option data-countryCode="KP" value="850">Korea North (+850)</option>
									<option data-countryCode="KR" value="82">Korea South (+82)</option>
									<option data-countryCode="KW" value="965">Kuwait (+965)</option>
									<option data-countryCode="KG" value="996">Kyrgyzstan (+996)</option>
									<option data-countryCode="LA" value="856">Laos (+856)</option>
									<option data-countryCode="LV" value="371">Latvia (+371)</option>
									<option data-countryCode="LB" value="961">Lebanon (+961)</option>
									<option data-countryCode="LS" value="266">Lesotho (+266)</option>
									<option data-countryCode="LR" value="231">Liberia (+231)</option>
									<option data-countryCode="LY" value="218">Libya (+218)</option>
									<option data-countryCode="LI" value="417">Liechtenstein (+417)</option>
									<option data-countryCode="LT" value="370">Lithuania (+370)</option>
									<option data-countryCode="LU" value="352">Luxembourg (+352)</option>
									<option data-countryCode="MO" value="853">Macao (+853)</option>
									<option data-countryCode="MK" value="389">Macedonia (+389)</option>
									<option data-countryCode="MG" value="261">Madagascar (+261)</option>
									<option data-countryCode="MW" value="265">Malawi (+265)</option>
									<option data-countryCode="MY" value="60">Malaysia (+60)</option>
									<option data-countryCode="MV" value="960">Maldives (+960)</option>
									<option data-countryCode="ML" value="223">Mali (+223)</option>
									<option data-countryCode="MT" value="356">Malta (+356)</option>
									<option data-countryCode="MH" value="692">Marshall Islands (+692)</option>
									<option data-countryCode="MQ" value="596">Martinique (+596)</option>
									<option data-countryCode="MR" value="222">Mauritania (+222)</option>
									<option data-countryCode="YT" value="269">Mayotte (+269)</option>
									<option data-countryCode="MX" value="52">Mexico (+52)</option>
									<option data-countryCode="FM" value="691">Micronesia (+691)</option>
									<option data-countryCode="MD" value="373">Moldova (+373)</option>
									<option data-countryCode="MC" value="377">Monaco (+377)</option>
									<option data-countryCode="MN" value="976">Mongolia (+976)</option>
									<option data-countryCode="MS" value="1664">Montserrat (+1664)</option>
									<option data-countryCode="MA" value="212">Morocco (+212)</option>
									<option data-countryCode="MZ" value="258">Mozambique (+258)</option>
									<option data-countryCode="MN" value="95">Myanmar (+95)</option>
									<option data-countryCode="NA" value="264">Namibia (+264)</option>
									<option data-countryCode="NR" value="674">Nauru (+674)</option>
									<option data-countryCode="NP" value="977">Nepal (+977)</option>
									<option data-countryCode="NL" value="31">Netherlands (+31)</option>
									<option data-countryCode="NC" value="687">New Caledonia (+687)</option>
									<option data-countryCode="NZ" value="64">New Zealand (+64)</option>
									<option data-countryCode="NI" value="505">Nicaragua (+505)</option>
									<option data-countryCode="NE" value="227">Niger (+227)</option>
									<option data-countryCode="NG" value="234">Nigeria (+234)</option>
									<option data-countryCode="NU" value="683">Niue (+683)</option>
									<option data-countryCode="NF" value="672">Norfolk Islands (+672)</option>
									<option data-countryCode="NP" value="670">Northern Marianas (+670)</option>
									<option data-countryCode="NO" value="47">Norway (+47)</option>
									<option data-countryCode="OM" value="968">Oman (+968)</option>
									<option data-countryCode="PW" value="680">Palau (+680)</option>
									<option data-countryCode="PA" value="507">Panama (+507)</option>
									<option data-countryCode="PG" value="675">Papua New Guinea (+675)</option>
									<option data-countryCode="PY" value="595">Paraguay (+595)</option>
									<option data-countryCode="PE" value="51">Peru (+51)</option>
									<option data-countryCode="PH" value="63">Philippines (+63)</option>
									<option data-countryCode="PL" value="48">Poland (+48)</option>
									<option data-countryCode="PT" value="351">Portugal (+351)</option>
									<option data-countryCode="PR" value="1787">Puerto Rico (+1787)</option>
									<option data-countryCode="QA" value="974">Qatar (+974)</option>
									<option data-countryCode="RE" value="262">Reunion (+262)</option>
									<option data-countryCode="RO" value="40">Romania (+40)</option>
									<option data-countryCode="RU" value="7">Russia (+7)</option>
									<option data-countryCode="RW" value="250">Rwanda (+250)</option>
									<option data-countryCode="SM" value="378">San Marino (+378)</option>
									<option data-countryCode="ST" value="239">Sao Tome &amp; Principe (+239)</option>
									<option data-countryCode="SA" value="966">Saudi Arabia (+966)</option>
									<option data-countryCode="SN" value="221">Senegal (+221)</option>
									<option data-countryCode="CS" value="381">Serbia (+381)</option>
									<option data-countryCode="SC" value="248">Seychelles (+248)</option>
									<option data-countryCode="SL" value="232">Sierra Leone (+232)</option>
									<option data-countryCode="SG" value="65">Singapore (+65)</option>
									<option data-countryCode="SK" value="421">Slovak Republic (+421)</option>
									<option data-countryCode="SI" value="386">Slovenia (+386)</option>
									<option data-countryCode="SB" value="677">Solomon Islands (+677)</option>
									<option data-countryCode="SO" value="252">Somalia (+252)</option>
									<option data-countryCode="ZA" value="27">South Africa (+27)</option>
									<option data-countryCode="ES" value="34">Spain (+34)</option>
									<option data-countryCode="LK" value="94">Sri Lanka (+94)</option>
									<option data-countryCode="SH" value="290">St. Helena (+290)</option>
									<option data-countryCode="KN" value="1869">St. Kitts (+1869)</option>
									<option data-countryCode="SC" value="1758">St. Lucia (+1758)</option>
									<option data-countryCode="SD" value="249">Sudan (+249)</option>
									<option data-countryCode="SR" value="597">Suriname (+597)</option>
									<option data-countryCode="SZ" value="268">Swaziland (+268)</option>
									<option data-countryCode="SE" value="46">Sweden (+46)</option>
									<option data-countryCode="CH" value="41">Switzerland (+41)</option>
									<option data-countryCode="SI" value="963">Syria (+963)</option>
									<option data-countryCode="TW" value="886">Taiwan (+886)</option>
									<option data-countryCode="TJ" value="7">Tajikstan (+7)</option>
									<option data-countryCode="TH" value="66">Thailand (+66)</option>
									<option data-countryCode="TG" value="228">Togo (+228)</option>
									<option data-countryCode="TO" value="676">Tonga (+676)</option>
									<option data-countryCode="TT" value="1868">Trinidad &amp; Tobago (+1868)</option>
									<option data-countryCode="TN" value="216">Tunisia (+216)</option>
									<option data-countryCode="TR" value="90">Turkey (+90)</option>
									<option data-countryCode="TM" value="7">Turkmenistan (+7)</option>
									<option data-countryCode="TM" value="993">Turkmenistan (+993)</option>
									<option data-countryCode="TC" value="1649">Turks &amp; Caicos Islands (+1649)</option>
									<option data-countryCode="TV" value="688">Tuvalu (+688)</option>
									<option data-countryCode="UG" value="256">Uganda (+256)</option>
									<option data-countryCode="UA" value="380">Ukraine (+380)</option>
									<option data-countryCode="AE" value="971">United Arab Emirates (+971)</option>
									<option data-countryCode="UY" value="598">Uruguay (+598)</option>
									<option data-countryCode="UZ" value="7">Uzbekistan (+7)</option>
									<option data-countryCode="VU" value="678">Vanuatu (+678)</option>
									<option data-countryCode="VA" value="379">Vatican City (+379)</option>
									<option data-countryCode="VE" value="58">Venezuela (+58)</option>
									<option data-countryCode="VN" value="84">Vietnam (+84)</option>
									<option data-countryCode="VG" value="84">Virgin Islands - British (+1284)</option>
									<option data-countryCode="VI" value="84">Virgin Islands - US (+1340)</option>
									<option data-countryCode="WF" value="681">Wallis &amp; Futuna (+681)</option>
									<option data-countryCode="YE" value="969">Yemen (North)(+969)</option>
									<option data-countryCode="YE" value="967">Yemen (South)(+967)</option>
									<option data-countryCode="ZM" value="260">Zambia (+260)</option>
									<option data-countryCode="ZW" value="263">Zimbabwe (+263)</option>
                                </select>
                                <input type="number" class="form-control" id="mobileno" name="<liferay-ui:message key="MobileNo" />" placeholder="+967000000" onKeyPress="if(this.value.length==9) return false;" max="999999999"  required />
                                </div>
                                <div class="invalid-feedback">
                                    Mobile No is required.
                                </div>
                            </div>
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="Email" /></label><span class="text-danger">*</span>
                                <input type="email" class="form-control" maxlength="70" id="email" name="<liferay-ui:message key="Email" />" placeholder="demo@gmail.com" value="<%=email%>" required />
                                <div class="invalid-feedback">
                                    Email is required.
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="University" /></label><span class="text-danger"></span>
                                <input type="text" class="form-control" maxlength="70" id="universitygeneral" name="<liferay-ui:message key="University" />" placeholder="<liferay-ui:message key="School" />"  />
                                <div class="invalid-feedback">
                                    University is required.
                                </div>
                            </div>
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="EducationField" /></label><span class="text-danger"></span>
                               <!--  <input type="text" class="form-control" id="educationField" name="education Field" placeholder="Education Field"  /> -->
                                <select name="<liferay-ui:message key="EducationField" />" id="educationField" class="form-control" >
                                    <option value="">select</option>
                                  <option value="Agriculture">Agriculture</option>
									<option value="Architecture">Architecture</option>
									<option value="Cultural">Cultural</option>
									<option value="Aviation">Aviation</option>
									<option value="Biological and Biomedical Sciences">Biological and Biomedical Sciences</option>
									<option value="Business">Business</option>
									<option value="Communication">Communication</option>
									<option value="technicians and Support Services">technicians and Support Services</option>
									<option value="Computer and Information Sciences">Computer and Information Sciences</option>
									<option value="Construction Trades">Construction Trades</option>
									<option value="Education">Education</option>
									<option value="Engineering">Engineering</option>
									<option value="English Language">English Language</option>
									<option value="Foreign Languages">Foreign Languages</option>
									<option value="Health Professions">Health Professions</option>
									<option value="History">History</option>
									<option value="Homeland Security">Homeland Security</option>
									<option value="Human Services">Human Services</option>
									<option value="Legal Professions">Legal Professions</option>
									<option value="Liberal Arts">Liberal Arts</option>
									<option value="Library Science">Library Science</option>
									<option value="Mathematics and Statistics">Mathematics and Statistics</option>
									<option value="Technicians">Technicians</option>
									<option value="Military Technologies">Military Technologies</option>
									<option value="Interdisciplinary Studies">Interdisciplinary Studies</option>
									<option value="Natural Resources">Natural Resources</option>
									<option value="Fitness Studies">Fitness Studies</option>
									<option value="Philosophy">Philosophy</option>
									<option value="Physical Sciences">Physical Sciences</option>
									<option value="Precision Production">Precision Production</option>
									<option value="Psychology">Psychology</option>
									<option value="Science Technologies/technicians">Science Technologies/technicians</option>
									<option value="Social Sciences">Social Sciences</option>
									<option value="Transportation">Transportation</option>
                                </select>
                                <div class="invalid-feedback">
                                    Education Field is required.
                                </div>
                            </div>
                        </div>
                                 <div class="row">
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="Currentworkposition" /></label><span class="text-danger"></span>
                                <input type="text" class="form-control" maxlength="70" id="currentworkposition" name="<liferay-ui:message key="Currentworkposition" />" placeholder="Current work position"  />
                                <div class="invalid-feedback">
                                    Education Feild is required.
                                </div>
                            </div>
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="Currentworklocation" /></label><span class="text-danger"></span>
                                <input type="text" class="form-control" maxlength="70" id="currentworklocation" name="<liferay-ui:message key="Currentworklocation" />" placeholder="Current work location"  />
                                <div class="invalid-feedback">
                                    University is required.
                                </div>
                            </div>
                        </div>
                        <!-- <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Primary Mobile No</label><span class="text-danger">*</span>
                                <input type="number" class="form-control" id="mobileno" name="mobileno" placeholder="+967000000" required />
                                <div class="invalid-feedback">
                                    Primary Mobile No is required.
                                </div>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Secondary Mobile No</label>
                                <input type="number" class="form-control" id="mobileno2" name="mobileno2" placeholder="+967000000" />
                            </div>
                        </div> -->
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="Gender" /></label><span class="text-danger"></span>
                                <select name="<liferay-ui:message key="Gender" />" id="gender" class="form-control" >
                                    <option value="">select</option>
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                </select>
                                <div class="invalid-feedback">
                                    Gender is required.
                                </div>
                            </div>
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="Nationality" /> </label><span class="text-danger"></span>
                                <select name="<liferay-ui:message key="Nationality" />" id="region" class="form-control" >
                                    <option value="">select</option>
                                    <option value="afghan">Afghan</option>
									  <option value="albanian">Albanian</option>
									  <option value="algerian">Algerian</option>
									  <option value="american">American</option>
									  <option value="andorran">Andorran</option>
									  <option value="angolan">Angolan</option>
									  <option value="antiguans">Antiguans</option>
									  <option value="argentinean">Argentinean</option>
									  <option value="armenian">Armenian</option>
									  <option value="australian">Australian</option>
									  <option value="austrian">Austrian</option>
									  <option value="azerbaijani">Azerbaijani</option>
									  <option value="bahamian">Bahamian</option>
									  <option value="bahraini">Bahraini</option>
									  <option value="bangladeshi">Bangladeshi</option>
									  <option value="barbadian">Barbadian</option>
									  <option value="barbudans">Barbudans</option>
									  <option value="batswana">Batswana</option>
									  <option value="belarusian">Belarusian</option>
									  <option value="belgian">Belgian</option>
									  <option value="belizean">Belizean</option>
									  <option value="beninese">Beninese</option>
									  <option value="bhutanese">Bhutanese</option>
									  <option value="bolivian">Bolivian</option>
									  <option value="bosnian">Bosnian</option>
									  <option value="brazilian">Brazilian</option>
									  <option value="british">British</option>
									  <option value="bruneian">Bruneian</option>
									  <option value="bulgarian">Bulgarian</option>
									  <option value="burkinabe">Burkinabe</option>
									  <option value="burmese">Burmese</option>
									  <option value="burundian">Burundian</option>
									  <option value="cambodian">Cambodian</option>
									  <option value="cameroonian">Cameroonian</option>
									  <option value="canadian">Canadian</option>
									  <option value="cape verdean">Cape Verdean</option>
									  <option value="central african">Central African</option>
									  <option value="chadian">Chadian</option>
									  <option value="chilean">Chilean</option>
									  <option value="chinese">Chinese</option>
									  <option value="colombian">Colombian</option>
									  <option value="comoran">Comoran</option>
									  <option value="congolese">Congolese</option>
									  <option value="costa rican">Costa Rican</option>
									  <option value="croatian">Croatian</option>
									  <option value="cuban">Cuban</option>
									  <option value="cypriot">Cypriot</option>
									  <option value="czech">Czech</option>
									  <option value="danish">Danish</option>
									  <option value="djibouti">Djibouti</option>
									  <option value="dominican">Dominican</option>
									  <option value="dutch">Dutch</option>
									  <option value="east timorese">East Timorese</option>
									  <option value="ecuadorean">Ecuadorean</option>
									  <option value="egyptian">Egyptian</option>
									  <option value="emirian">Emirian</option>
									  <option value="equatorial guinean">Equatorial Guinean</option>
									  <option value="eritrean">Eritrean</option>
									  <option value="estonian">Estonian</option>
									  <option value="ethiopian">Ethiopian</option>
									  <option value="fijian">Fijian</option>
									  <option value="filipino">Filipino</option>
									  <option value="finnish">Finnish</option>
									  <option value="french">French</option>
									  <option value="gabonese">Gabonese</option>
									  <option value="gambian">Gambian</option>
									  <option value="georgian">Georgian</option>
									  <option value="german">German</option>
									  <option value="ghanaian">Ghanaian</option>
									  <option value="greek">Greek</option>
									  <option value="grenadian">Grenadian</option>
									  <option value="guatemalan">Guatemalan</option>
									  <option value="guinea-bissauan">Guinea-Bissauan</option>
									  <option value="guinean">Guinean</option>
									  <option value="guyanese">Guyanese</option>
									  <option value="haitian">Haitian</option>
									  <option value="herzegovinian">Herzegovinian</option>
									  <option value="honduran">Honduran</option>
									  <option value="hungarian">Hungarian</option>
									  <option value="icelander">Icelander</option>
									  <option value="indian">Indian</option>
									  <option value="indonesian">Indonesian</option>
									  <option value="iranian">Iranian</option>
									  <option value="iraqi">Iraqi</option>
									  <option value="irish">Irish</option>
									  <option value="israeli">Israeli</option>
									  <option value="italian">Italian</option>
									  <option value="ivorian">Ivorian</option>
									  <option value="jamaican">Jamaican</option>
									  <option value="japanese">Japanese</option>
									  <option value="jordanian">Jordanian</option>
									  <option value="kazakhstani">Kazakhstani</option>
									  <option value="kenyan">Kenyan</option>
									  <option value="kittian and nevisian">Kittian and Nevisian</option>
									  <option value="kuwaiti">Kuwaiti</option>
									  <option value="kyrgyz">Kyrgyz</option>
									  <option value="laotian">Laotian</option>
									  <option value="latvian">Latvian</option>
									  <option value="lebanese">Lebanese</option>
									  <option value="liberian">Liberian</option>
									  <option value="libyan">Libyan</option>
									  <option value="liechtensteiner">Liechtensteiner</option>
									  <option value="lithuanian">Lithuanian</option>
									  <option value="luxembourger">Luxembourger</option>
									  <option value="macedonian">Macedonian</option>
									  <option value="malagasy">Malagasy</option>
									  <option value="malawian">Malawian</option>
									  <option value="malaysian">Malaysian</option>
									  <option value="maldivan">Maldivan</option>
									  <option value="malian">Malian</option>
									  <option value="maltese">Maltese</option>
									  <option value="marshallese">Marshallese</option>
									  <option value="mauritanian">Mauritanian</option>
									  <option value="mauritian">Mauritian</option>
									  <option value="mexican">Mexican</option>
									  <option value="micronesian">Micronesian</option>
									  <option value="moldovan">Moldovan</option>
									  <option value="monacan">Monacan</option>
									  <option value="mongolian">Mongolian</option>
									  <option value="moroccan">Moroccan</option>
									  <option value="mosotho">Mosotho</option>
									  <option value="motswana">Motswana</option>
									  <option value="mozambican">Mozambican</option>
									  <option value="namibian">Namibian</option>
									  <option value="nauruan">Nauruan</option>
									  <option value="nepalese">Nepalese</option>
									  <option value="new zealander">New Zealander</option>
									  <option value="ni-vanuatu">Ni-Vanuatu</option>
									  <option value="nicaraguan">Nicaraguan</option>
									  <option value="nigerien">Nigerien</option>
									  <option value="north korean">North Korean</option>
									  <option value="northern irish">Northern Irish</option>
									  <option value="norwegian">Norwegian</option>
									  <option value="omani">Omani</option>
									  <option value="pakistani">Pakistani</option>
									  <option value="palauan">Palauan</option>
									  <option value="panamanian">Panamanian</option>
									  <option value="papua new guinean">Papua New Guinean</option>
									  <option value="paraguayan">Paraguayan</option>
									  <option value="peruvian">Peruvian</option>
									  <option value="polish">Polish</option>
									  <option value="portuguese">Portuguese</option>
									  <option value="qatari">Qatari</option>
									  <option value="romanian">Romanian</option>
									  <option value="russian">Russian</option>
									  <option value="rwandan">Rwandan</option>
									  <option value="saint lucian">Saint Lucian</option>
									  <option value="salvadoran">Salvadoran</option>
									  <option value="samoan">Samoan</option>
									  <option value="san marinese">San Marinese</option>
									  <option value="sao tomean">Sao Tomean</option>
									  <option value="saudi">Saudi</option>
									  <option value="scottish">Scottish</option>
									  <option value="senegalese">Senegalese</option>
									  <option value="serbian">Serbian</option>
									  <option value="seychellois">Seychellois</option>
									  <option value="sierra leonean">Sierra Leonean</option>
									  <option value="singaporean">Singaporean</option>
									  <option value="slovakian">Slovakian</option>
									  <option value="slovenian">Slovenian</option>
									  <option value="solomon islander">Solomon Islander</option>
									  <option value="somali">Somali</option>
									  <option value="south african">South African</option>
									  <option value="south korean">South Korean</option>
									  <option value="spanish">Spanish</option>
									  <option value="sri lankan">Sri Lankan</option>
									  <option value="sudanese">Sudanese</option>
									  <option value="surinamer">Surinamer</option>
									  <option value="swazi">Swazi</option>
									  <option value="swedish">Swedish</option>
									  <option value="swiss">Swiss</option>
									  <option value="syrian">Syrian</option>
									  <option value="taiwanese">Taiwanese</option>
									  <option value="tajik">Tajik</option>
									  <option value="tanzanian">Tanzanian</option>
									  <option value="thai">Thai</option>
									  <option value="togolese">Togolese</option>
									  <option value="tongan">Tongan</option>
									  <option value="trinidadian or tobagonian">Trinidadian or Tobagonian</option>
									  <option value="tunisian">Tunisian</option>
									  <option value="turkish">Turkish</option>
									  <option value="tuvaluan">Tuvaluan</option>
									  <option value="ugandan">Ugandan</option>
									  <option value="ukrainian">Ukrainian</option>
									  <option value="uruguayan">Uruguayan</option>
									  <option value="uzbekistani">Uzbekistani</option>
									  <option value="venezuelan">Venezuelan</option>
									  <option value="vietnamese">Vietnamese</option>
									  <option value="welsh">Welsh</option>
									  <option value="yemenite">Yemenite</option>
									  <option value="zambian">Zambian</option>
									  <option value="zimbabwean">Zimbabwean</option>
                                </select>
                                <div class="invalid-feedback">
                                    Nationality is required.
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="NationalID" /></label><span class="text-danger"></span>
                                <input type="number" id="nationalid" maxlength="70" name="<liferay-ui:message key="NationalID" />" class="form-control"  />
                                <div class="invalid-feedback">
                                    National ID is required.
                                </div>
                            </div>
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="PassportID" /></label><span class="text-danger"></span>
                                <input type="text" id="passportid" maxlength="20" name="<liferay-ui:message key="PassportID" />" class="form-control"  />
                                <div class="invalid-feedback">
                                    Passport ID is required.
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="PassportExpireDate" /></label><span class="text-danger"></span>
                                <input type="date" name="<liferay-ui:message key="PassportExpireDate" />" id="passportexpiredate" class="form-control"  />
                                <div class="invalid-feedback">
                                    Passport Expire Date is required.
                                </div>
                            </div>
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="DateofBirth" /></label>
                                <input type="date" value="<%=dateOfBirth%>" name="<liferay-ui:message key="DateofBirth" />" id="dateofbirth" class="form-control" required/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                              <!--   <a id="passportscan" class="btn btn-primary text-white">Passport Scan</a>
                                <input type="file" id="passportscan_file" style="display: none;" />
                                <label id="passportscanfilename"></label>
                            --> </div>
                          <!--   <div class="col-md-6 form-group">
                                <label>Current Education/Training Status</label>
                                <select name="education" id="education" class="form-control">
                                    <option value="">select</option>
                                    <option value="1">School</option>
                                    <option value="2">University</option>
                                </select>
                            </div> -->
                        </div>
                        <div class="row mt-2 pb-2">
                            <div class="col-md-12">
                                <b><liferay-ui:message key="Address" /> <span class="float-right questionmark" data-toggle="tooltip" title="show tooltip">?</span> </b>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <label><liferay-ui:message key="CountryofResidence" /></label><span class="text-danger"></span>
                                <select name="<liferay-ui:message key="CountryofResidence" />" id="countryofresidence" class="form-control" >
                                    <option value="">select</option>
                                   	<option value="Afghanistan">Afghanistan</option>
									<option value="Aland Islands">Ã…land Islands</option>
									<option value="Albania">Albania</option>
									<option value="Albania">Albania</option>
									<option value="American Samoa">American Samoa</option>
									<option value="Andorra">Andorra</option>
									<option value="Angola">Angola</option>
									<option value="Anguilla">Anguilla</option>
									<option value="Antarctica">Antarctica</option>
									<option value="Antigua and Barbuda">Antigua and Barbuda</option>
									<option value="Argentina">Argentina</option>
									<option value="Armenia">Armenia</option>
									<option value="Aruba">Aruba</option>
									<option value="Australia">Australia</option>
									<option value="Austria">Austria</option>
									<option value="Azerbaijan">Azerbaijan</option>
									<option value="Bahamas">Bahamas</option>
									<option value="Bahrain">Bahrain</option>
									<option value="Bangladesh">Bangladesh</option>
									<option value="Barbados">Barbados</option>
									<option value="Belarus">Belarus</option>
									<option value="Belgium">Belgium</option>
									<option value="Belize">Belize</option>
									<option value="Benin">Benin</option>
									<option value="Bermuda">Bermuda</option>
									<option value="Bhutan">Bhutan</option>
									<option value="Plurinational State of Bolivia ">Plurinational State of Bolivia </option>
									<option value="Bonaire, Sint Eustatius and Saba">Bonaire, Sint Eustatius and Saba</option>
									<option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
									<option value="Botswana">Botswana</option>
									<option value="Bouvet Island">Bouvet Island</option>
									<option value="Brazil">Brazil</option>
									<option value="British Indian Ocean Territory">British Indian Ocean Territory</option>
									<option value="Brunei Darussalam">Brunei Darussalam</option>
									<option value="Bulgaria">Bulgaria</option>
									<option value="Burkina Faso">Burkina Faso</option>
									<option value="Burundi">Burundi</option>
									<option value="Cambodia">Cambodia</option>
									<option value="Cameroon">Cameroon</option>
									<option value="Canada">Canada</option>
									<option value="Cape Verde">Cape Verde</option>
									<option value="Cayman Islands">Cayman Islands</option>
									<option value="Central African Republic">Central African Republic</option>
									<option value="Chad">Chad</option>
									<option value="Chile">Chile</option>
									<option value="China">China</option>
									<option value="Christmas Island">Christmas Island</option>
									<option value="Cocos (Keeling) Islands">Cocos (Keeling) Islands</option>
									<option value="Colombia">Colombia</option>
									<option value="Comoros">Comoros</option>
									<option value="Congo">Congo</option>
									<option value="Congo, the Democratic Republic of the">Congo, the Democratic Republic of the</option>
									<option value="Cook Islands">Cook Islands</option>
									<option value="Costa Rica">Costa Rica</option>
									<option value="Cote d'Ivoire">CÃ´te d'Ivoire</option>
									<option value="Croatia">Croatia</option>
									<option value="Cuba">Cuba</option>
									<option value="Curacao">Curacao</option>
									<option value="Cyprus">Cyprus</option>
									<option value="Czech Republic">Czech Republic</option>
									<option value="Denmark">Denmark</option>
									<option value="Djibouti">Djibouti</option>
									<option value="Dominica">Dominica</option>
									<option value="Dominican Republic">Dominican Republic</option>
									<option value="Ecuador">Ecuador</option>
									<option value="Egypt">Egypt</option>
									<option value="El Salvador">El Salvador</option>
									<option value="Equatorial Guinea">Equatorial Guinea</option>
									<option value="Eritrea">Eritrea</option>
									<option value="Estonia">Estonia</option>
									<option value="Ethiopia">Ethiopia</option>
									<option value="Falkland Islands (Malvinas)">Falkland Islands (Malvinas)</option>
									<option value="Faroe Islands">Faroe Islands</option>
									<option value="Fiji">Fiji</option>
									<option value="Finland">Finland</option>
									<option value="France">France</option>
									<option value="French Guiana">French Guiana</option>
									<option value="French Polynesia">French Polynesia</option>
									<option value="French Southern Territories">French Southern Territories</option>
									<option value="Gabon">Gabon</option>
									<option value="Gambia">Gambia</option>
									<option value="Georgia">Georgia</option>
									<option value="Germany">Germany</option>
									<option value="Ghana">Ghana</option>
									<option value="Gibraltar">Gibraltar</option>
									<option value="Greece">Greece</option>
									<option value="Greenland">Greenland</option>
									<option value="Grenada">Grenada</option>
									<option value="Guadeloupe">Guadeloupe</option>
									<option value="Guam">Guam</option>
									<option value="Guatemala">Guatemala</option>
									<option value="Guernsey">Guernsey</option>
									<option value="Guinea">Guinea</option>
									<option value="Guinea-Bissau">Guinea-Bissau</option>
									<option value="Guyana">Guyana</option>
									<option value="Haiti">Haiti</option>
									<option value="Heard Island and McDonald Islands">Heard Island and McDonald Islands</option>
									<option value="Holy See (Vatican City State)">Holy See (Vatican City State)</option>
									<option value="Honduras">Honduras</option>
									<option value="Hong Kong">Hong Kong</option>
									<option value="Hungary">Hungary</option>
									<option value="Iceland">Iceland</option>
									<option value="India">India</option>
									<option value="Indonesia">Indonesia</option>
									<option value="Iran, Islamic Republic of">Iran, Islamic Republic of</option>
									<option value="Iraq">Iraq</option>
									<option value="Ireland">Ireland</option>
									<option value="Isle of Man">Isle of Man</option>
									<option value="Israel">Israel</option>
									<option value="Italy">Italy</option>
									<option value="Jamaica">Jamaica</option>
									<option value="Japan">Japan</option>
									<option value="Jersey">Jersey</option>
									<option value="Jordan">Jordan</option>
									<option value="Kazakhstan">Kazakhstan</option>
									<option value="Kenya">Kenya</option>
									<option value="Kiribati">Kiribati</option>
									<option value="Korea, Democratic People's Republic of">Korea, Democratic People's Republic of</option>
									<option value="Korea, Republic of">Korea, Republic of</option>
									<option value="Kuwait">Kuwait</option>
									<option value="Kyrgyzstan">Kyrgyzstan</option>
									<option value="Lao People's Democratic Republic">Lao People's Democratic Republic</option>
									<option value="Latvia">Latvia</option>
									<option value="Lebanon">Lebanon</option>
									<option value="Lesotho">Lesotho</option>
									<option value="Liberia">Liberia</option>
									<option value="Libya">Libya</option>
									<option value="Liechtenstein">Liechtenstein</option>
									<option value="Lithuania">Lithuania</option>
									<option value="Luxembourg">Luxembourg</option>
									<option value="Macao">Macao</option>
									<option value="Macedonia, the former Yugoslav Republic of">Macedonia, the former Yugoslav Republic of</option>
									<option value="Madagascar">Madagascar</option>
									<option value="Malawi">Malawi</option>
									<option value="Malaysia">Malaysia</option>
									<option value="Maldives">Maldives</option>
									<option value="Mali">Mali</option>
									<option value="Malta">Malta</option>
									<option value="Marshall Islands">Marshall Islands</option>
									<option value="Martinique">Martinique</option>
									<option value="Mauritania">Mauritania</option>
									<option value="Mauritius">Mauritius</option>
									<option value="Mayotte">Mayotte</option>
									<option value="Mexico">Mexico</option>
									<option value="Micronesia, Federated States of">Micronesia, Federated States of</option>
									<option value="Moldova, Republic of">Moldova, Republic of</option>
									<option value="Monaco">Monaco</option>
									<option value="Mongolia">Mongolia</option>
									<option value="Montenegro">Montenegro</option>
									<option value="Montserrat">Montserrat</option>
									<option value="Morocco">Morocco</option>
									<option value="Mozambique">Mozambique</option>
									<option value="Myanmar">Myanmar</option>
									<option value="Namibia">Namibia</option>
									<option value="Nauru">Nauru</option>
									<option value="Nepal">Nepal</option>
									<option value="Netherlands">Netherlands</option>
									<option value="New Caledonia">New Caledonia</option>
									<option value="New Zealand">New Zealand</option>
									<option value="Nicaragua">Nicaragua</option>
									<option value="Niger">Niger</option>
									<option value="Nigeria">Nigeria</option>
									<option value="Niue">Niue</option>
									<option value="Norfolk Island">Norfolk Island</option>
									<option value="Northern Mariana Islands">Northern Mariana Islands</option>
									<option value="Norway">Norway</option>
									<option value="Oman">Oman</option>
									<option value="Pakistan">Pakistan</option>
									<option value="Palau">Palau</option>
									<option value="Palestinian Territory, Occupied">Palestinian Territory, Occupied</option>
									<option value="Panama">Panama</option>
									<option value="Papua New Guinea">Papua New Guinea</option>
									<option value="Paraguay">Paraguay</option>
									<option value="Peru">Peru</option>
									<option value="Philippines">Philippines</option>
									<option value="Pitcairn">Pitcairn</option>
									<option value="Poland">Poland</option>
									<option value="Portugal">Portugal</option>
									<option value="Puerto Rico">Puerto Rico</option>
									<option value="Qatar">Qatar</option>
									<option value="Reunion">Reunion</option>
									<option value="Romania">Romania</option>
									<option value="Russian Federation">Russian Federation</option>
									<option value="Rwanda">Rwanda</option>
									<option value="Saint BarthÃ©lemy">Saint BarthÃ©lemy</option>
									<option value="Saint Helena, Ascension and Tristan da Cunha">Saint Helena, Ascension and Tristan da Cunha</option>
									<option value="Saint Kitts and Nevis">Saint Kitts and Nevis</option>
									<option value="Saint Lucia">Saint Lucia</option>
									<option value="Saint Martin (French part)">Saint Martin (French part)</option>
									<option value="Saint Pierre and Miquelon">Saint Pierre and Miquelon</option>
									<option value="Saint Vincent and the Grenadines">Saint Vincent and the Grenadines</option>
									<option value="Samoa">Samoa</option>
									<option value="San Marino">San Marino</option>
									<option value="Sao Tome and Principe">Sao Tome and Principe</option>
									<option value="Saudi Arabia">Saudi Arabia</option>
									<option value="Senegal">Senegal</option>
									<option value="Serbia">Serbia</option>
									<option value="Seychelles">Seychelles</option>
									<option value="Sierra Leone">Sierra Leone</option>
									<option value="Singapore">Singapore</option>
									<option value="Sint Maarten (Dutch part)">Sint Maarten (Dutch part)</option>
									<option value="Slovakia">Slovakia</option>
									<option value="Slovenia">Slovenia</option>
									<option value="Solomon Islands">Solomon Islands</option>
									<option value="Somalia">Somalia</option>
									<option value="South Africa">South Africa</option>
									<option value="South Georgia and the South Sandwich Islands">South Georgia and the South Sandwich Islands</option>
									<option value="South Sudan">South Sudan</option>
									<option value="Spain">Spain</option>
									<option value="Sri Lanka">Sri Lanka</option>
									<option value="Sudan">Sudan</option>
									<option value="Suriname">Suriname</option>
									<option value="Svalbard and Jan Mayen">Svalbard and Jan Mayen</option>
									<option value="Swaziland">Swaziland</option>
									<option value="Sweden">Sweden</option>
									<option value="Switzerland">Switzerland</option>
									<option value="Syrian Arab Republic">Syrian Arab Republic</option>
									<option value="Taiwan, Province of China">Taiwan, Province of China</option>
									<option value="Tajikistan">Tajikistan</option>
									<option value="Tanzania, United Republic of">Tanzania, United Republic of</option>
									<option value="Thailand">Thailand</option>
									<option value="Timor-Leste">Timor-Leste</option>
									<option value="Togo">Togo</option>
									<option value="Tokelau">Tokelau</option>
									<option value="Tonga">Tonga</option>
									<option value="Trinidad and Tobago">Trinidad and Tobago</option>
									<option value="Tunisia">Tunisia</option>
									<option value="Turkey">Turkey</option>
									<option value="Turkmenistan">Turkmenistan</option>
									<option value="Turks and Caicos Islands">Turks and Caicos Islands</option>
									<option value="Tuvalu">Tuvalu</option>
									<option value="Uganda">Uganda</option>
									<option value="Ukraine">Ukraine</option>
									<option value="United Arab Emirates">United Arab Emirates</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="United States">United States</option>
									<option value="United States Minor Outlying Islands">United States Minor Outlying Islands</option>
									<option value="Uruguay">Uruguay</option>
									<option value="Uzbekistan">Uzbekistan</option>
									<option value="Vanuatu">Vanuatu</option>
									<option value="Venezuela, Bolivarian Republic of">Venezuela, Bolivarian Republic of</option>
									<option value="Viet Nam">Viet Nam</option>
									<option value="Virgin Islands, British">Virgin Islands, British</option>
									<option value="Virgin Islands, U.S.">Virgin Islands, U.S.</option>
									<option value="Wallis and Futuna">Wallis and Futuna</option>
									<option value="Western Sahara">Western Sahara</option>
									<option value="Yemen">Yemen</option>
									<option value="Zambia">Zambia</option>
									<option value="Zimbabwe">Zimbabwe</option>
                                </select>
                            </div>
                            <div class="col-md-4 form-group">
                                <label><liferay-ui:message key="CityofResidence" /></label><span class="text-danger"></span>
                                <input type="text" maxlength="70" name="<liferay-ui:message key="CityofResidence" />" id="cityofresidence" class="form-control" placeholder="City of residence" />
                            </div>
                             <div class="col-md-4 form-group">
                                <label><liferay-ui:message key="PostalCode" /></label>
                                <input type="number"  maxlength="70"  name="<liferay-ui:message key="PostalCode" />" id="postalcode" placeholder="xxx" class="form-control" />
                            </div>
                           <div class="col-md-4 form-group">
                                <label><liferay-ui:message key="NationalAddress" /></label>
                                <input type="text"  maxlength="70"  name="<liferay-ui:message key="NationalAddress" />" id="nationaladdress" class="form-control" placeholder="National Address" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <label><liferay-ui:message key="Street" /></label>
                                <input type="text" maxlength="70" name="<liferay-ui:message key="Street" />" id="street" placeholder="<liferay-ui:message key="Street" />" class="form-control" />
                            </div>
                            <div class="col-md-4 form-group">
                                <label><liferay-ui:message key="State" /></label>
                                <input type="text" maxlength="70"  name="<liferay-ui:message key="State" />" id="state" placeholder="<liferay-ui:message key="State" />" class="form-control" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label><liferay-ui:message key="About" /></label>
                                <textarea id="about" name="<liferay-ui:message key="About"/>" maxlength="300" class="form-control" rows="3"></textarea>
                            </div>
                        </div>
                       <!--  <div class="row mt-2 pb-2">
                            <div class="col-md-12">
                                <b>Communications Connections <span class="float-right questionmark" data-toggle="tooltip" title="show tooltip">?</span> </b>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Instagram Link</label>
                                <input type="url" name="instagramlink" id="instagramlink" class="form-control" placeholder="https://www.instagram.com/xxxxxx" />
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Facebook Link</label>
                                <input type="url" name="facebooklink" id="facebooklink" class="form-control" placeholder="https://www.facebook.com/xxxxxx" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Twitter Link</label>
                                <input type="url" name="twitterlink" id="twitterlink" class="form-control" placeholder="https://www.twitter.com/xxxxxx" />
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Linkedin Link</label>
                                <input type="url" name="linkedlink" id="linkedin" class="form-control" placeholder="https://www.linkedin.com/xxxxxx" />
                            </div>
                        </div>
                           <div class="row">
                            <div class="col-md-6 form-group">
                                <a href="#" class="btn btn-outline-primary">Other</a>
                            </div>
                        </div> -->
                        <div class="row pt-2">
                            <div class="col-md-3">
                               </div>
                            <div class="col-md-5">
			                    <div id="alertContainer" style="display:none; line-height: 0.7; text-align: center; font-size: small;" class="alert-notifications alertContainerClass">
								  	<div class="alert alert-success fade alert-dismissible show" role="alert">
										<span id="alertText" class="alertTextClass"></span>
									</div>
							    </div>    
                            </div>
                            <div class="col-md-4">
                                <!--<button type="submit" class="btn btn-primary float-right">Update</button>-->
                                <input value="Update" type="button" onclick="saveToDatabase('addProfileInfo','frmeditprofile','saveGeneralInfo','#editprofile')" id="updateuserprofile" name="updateuserprofile" class="btn btn-primary float-left">
                                <button type="reset" class="btn btn-secondary float-right" data-dismiss="modal"><liferay-ui:message key="Cancel" /></button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="addlicenceandcertification" tabindex="-1" role="dialog" aria-labelledby="" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                    <div class="modal-header text-white bg-info">
                    <b class="modal-title" id="addlicenceandcertificationLabel">
                        <label><liferay-ui:message key="AddLicensesCertifications" /></label>
                    </b>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmlicenceandcertification" class="bootstrap-form needs-validation" novalidate>
                      <input type="hidden" id="licenceandcertificationId" name="licenceandcertificationId" value="0">  
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="Name" /></label><span class="text-danger">*</span>
                                <input type="text"  maxlength="70" name="<liferay-ui:message key="Name" />" id="licencename" class="form-control" required/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="IssuingOrganization" /></label><span class="text-danger">*</span>
                                <input type="text"  maxlength="70"  name="<liferay-ui:message key="IssuingOrganization" />" id="issuingorganization" class="form-control" required/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="IssueDate" /></label><span class="text-danger">*</span>
                                <input type="date" name="<liferay-ui:message key="IssueDate" />" id="issuedate" class="form-control" required/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="ExpirationDate" /></label><span class="text-danger">*</span>
                                <input type="date" name="<liferay-ui:message key="ExpirationDate" />" id="expiredate" class="form-control" required/>
                            </div>
                        </div>

                        <div class="row">
                          <!--   <div class="col-md-6 form-group">
                                <label>Credential ID</label>
                                <input type="text" name="credentailid" id="credentailid" class="form-control" />
                            </div> -->
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="CredentialURL" /></label>
                                <input type="text"  maxlength="70" name="<liferay-ui:message key="CredentialURL" />" id="credentailurl" class="form-control" />
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="certificateJourney" name="Appear in journey">
                                        <label class="form-check-label" for="certificateJourney">
                                         <liferay-ui:message key="appearInJourney" />
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--<div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="credentailnotexpire" name="credentailnotexpire">
                                        <label class="form-check-label" for="credentailnotexpire">
                                            Not Expire
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div> -->
                        <div class="row pt-2">
                            <div class="col-md-3">
                              </div>
                            <div class="col-md-6">
			                    <div id="alertContainer" style="display:none; line-height: 0.7; text-align: center; font-size: small;" class="alert-notifications alertContainerClass">
								  	<div class="alert alert-success fade alert-dismissible show" role="alert">
										<span id="alertText" class="alertTextClass"></span>
									</div>
							    </div>    
							</div>                            
                            <div class="col-md-3">
                               <input value="<liferay-ui:message key="Add" />" type="button" onclick="saveToDatabase('addProfileInfo','frmlicenceandcertification','adduserlicenceandcertification','#addlicenceandcertification')" id="adduserlicenceandcertification" name="adduserlicenceandcertification" class="btn btn-primary addBtnProf float-left">
                               <button type="reset" class="btn btn-secondary float-right" data-dismiss="modal"><liferay-ui:message key="Cancel" /></button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="addeducation" tabindex="-1" role="dialog" aria-labelledby="addeducationLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header text-white modal-header-bg bg-info">
                    <h5 class="modal-title" id="addeducationLabel">
                        <label><liferay-ui:message key="AddEducation" /></label>
                    </h5>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmAddeducation" class="bootstrap-form needs-validation" novalidate>
                         <input type="hidden" id="educationId" name="educationId" value="0">  
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label><liferay-ui:message key="SchoolcollegeuniversityName" /></label><span class="text-danger">*</span>
                                <input type="text" maxlength="70"  name="<liferay-ui:message key="SchoolcollegeuniversityName" />" id="university" class="form-control" placeholder="University" required />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="Degree" /></label><span class="text-danger">*</span>
                                <select class="js-example-tags1 form-control" multiple="multiple" style="width:100%;" id="degree" name="<liferay-ui:message key="Degree" />" required>
                                    <option value="Doctor">Doctor</option>
                                    <option value="Master">Master</option>
                                    <option value="Bechlor">Bechlor</option>
                                    <option value="Post Graduation">Post Graduation</option>
                                </select>
                            </div>
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="Fieldofstudy" /></label><span class="text-danger">*</span>
                                <select class="js-example-tags1 form-control" multiple="multiple" style="width:100%;" id="fieldofstudy" name="<liferay-ui:message key="Fieldofstudy" />" required>
                                  <option value="Agriculture">Agriculture</option>
									<option value="Architecture">Architecture</option>
									<option value="Cultural">Cultural</option>
									<option value="Aviation">Aviation</option>
									<option value="Biological and Biomedical Sciences">Biological and Biomedical Sciences</option>
									<option value="Business">Business</option>
									<option value="Communication">Communication</option>
									<option value="technicians and Support Services">technicians and Support Services</option>
									<option value="Computer and Information Sciences">Computer and Information Sciences</option>
									<option value="Construction Trades">Construction Trades</option>
									<option value="Education">Education</option>
									<option value="Engineering">Engineering</option>
									<option value="English Language">English Language</option>
									<option value="Foreign Languages">Foreign Languages</option>
									<option value="Health Professions">Health Professions</option>
									<option value="History">History</option>
									<option value="Homeland Security">Homeland Security</option>
									<option value="Human Services">Human Services</option>
									<option value="Legal Professions">Legal Professions</option>
									<option value="Liberal Arts">Liberal Arts</option>
									<option value="Library Science">Library Science</option>
									<option value="Mathematics and Statistics">Mathematics and Statistics</option>
									<option value="Technicians">Technicians</option>
									<option value="Military Technologies">Military Technologies</option>
									<option value="Interdisciplinary Studies">Interdisciplinary Studies</option>
									<option value="Natural Resources">Natural Resources</option>
									<option value="Fitness Studies">Fitness Studies</option>
									<option value="Philosophy">Philosophy</option>
									<option value="Physical Sciences">Physical Sciences</option>
									<option value="Precision Production">Precision Production</option>
									<option value="Psychology">Psychology</option>
									<option value="Science Technologies/technicians">Science Technologies/technicians</option>
									<option value="Social Sciences">Social Sciences</option>
									<option value="Transportation">Transportation</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <label><liferay-ui:message key="StartYear" /></label><span class="text-danger">*</span>
<%--                                 <input type="date" id="startyear" name="<liferay-ui:message key="StartYear" />" class="form-control" required /> --%>
								<select name="<liferay-ui:message key="StartYear" />" id="startyear" class="form-control" required>
									<option value="">select</option>
								<% for(int i = currentYear; i >= 1900 ; i--){%>
									<option value="<%=i%>"><%=i%></option>
								<% }%>
								</select>
                            </div>
                            <div class="col-md-4 form-group">
                                <label><liferay-ui:message key="EndYear" /></label><span class="text-danger"></span>
<%--                                 <input type="date" id="endyear" name="<liferay-ui:message key="EndYear" />" class="form-control"  /> --%>
								<select name="<liferay-ui:message key="EndYear" />" id="endyear" class="form-control" required>
									<option value="">select</option>
								<% for(int i = (currentYear+7); i >= 1900 ; i--){%>
									<option value="<%=i%>"><%=i%></option>
								<% }%>
								</select>
                            </div>
                            <div class="col-md-4 form-group">
                                <label><liferay-ui:message key="Grade" /></label><span class="text-danger">*</span>
                                <input type="text" maxlength="70"  id="grade" name="<liferay-ui:message key="Grade" />" class="form-control" required />
<%--                                 <select name="<liferay-ui:message key="Grade" />" id="grade" class="form-control" required> --%>
<!--                                     <option value="">select</option> -->
<!--                                     <option value="From 50% To 59%">From 50% To 59%</option> -->
<!--                                     <option value="From 60% To 69%">From 60% To 69%</option> -->
<!--                                     <option value="From 70% To 79%">From 70% To 79%</option> -->
<!--                                 </select> -->
                            </div>
                        </div>
                        <div class="row">
<!--                             <div class="col-md-6"> -->
<!--                                 <div class="form-group"> -->
<!--                                     <div class="form-check"> -->
<!--                                         <input class="form-check-input" type="checkbox" id="educatetillnow" name="till now"> -->
<!--                                         <label class="form-check-label" for="educatetillnow"> -->
<!--                                            <liferay-ui:message key="Tillnow" /> -->
<!--                                         </label> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                             </div> -->
                            <div class="col-md-6">
                                <div class="form-group">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="educateJourney" name="Appear in journey">
                                        <label class="form-check-label" for="educateJourney">
                                           <liferay-ui:message key="appearInJourney" />
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label> <liferay-ui:message key="Description" /></label>
                                <textarea maxlength="600" id="educationdescription" name="educationdescription" class="form-control" rows="5"></textarea>
                            </div>
                        </div>
                       <!--  <div class="row">
                            <div class="col-md-6 form-group">
                                <a id="uploadCerificate" class="btn btn-primary text-white">Upload Certificate</a>
                                <input type="file" id="uploadCerificate_file" style="display: none;" />
                            </div>
                        </div>-->
                        <div class="row pt-2">
                            <div class="col-md-3">
                              </div>
                            <div class="col-md-6">
			                    <div id="alertContainer" style="display:none; line-height: 0.7; text-align: center; font-size: small;" class="alert-notifications alertContainerClass">
								  	<div class="alert alert-success fade alert-dismissible show" role="alert">
										<span id="alertText" class="alertTextClass"></span>
									</div>
							    </div>    
							</div>  
                            <div class="col-md-3">
                               <input value="<liferay-ui:message key="Add" />" type="button" onclick="saveToDatabase('addProfileInfo','frmAddeducation','addusereducation','#addeducation')" id="addusereducation" name="addusereducation" class="btn btn-primary addBtnProf float-left">
                               <button type="reset" class="btn btn-secondary float-right" data-dismiss="modal"><liferay-ui:message key="Cancel" /></button>
                             </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="addworkexperience" tabindex="-1" role="dialog" aria-labelledby="addworkexperienceLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header text-white modal-header-bg bg-info">
                    <h5 class="modal-title" id="addworkexperienceLabel">
                        <label> <liferay-ui:message key="AddWorkExperience" /></label>
                    </h5>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmaddworkexperience" class="bootstrap-form needs-validation" novalidate>
                        <input type="hidden" id="workexperienceId" name="workexperienceId" value="0">  
                          <div class="row">
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="Title" /></label><span class="text-danger">*</span>
                                <select class="js-example-tags1 form-control" multiple="multiple" style="width:100%;" id="jobtitle" name="<liferay-ui:message key="Title" />" required>
                                    <option value="Account Collector">Account Collector</option>
									<option value="Account Executive">Account Executive</option>
									<option value="Account Manager">Account Manager</option>
									<option value="Account Representative">Account Representative</option>
									<option value="Accountant">Accountant</option>
									<option value="Accounting Analyst">Accounting Analyst</option>
									<option value="Accounting Director">Accounting Director</option>
									<option value="Accounting Staff">Accounting Staff</option>
									<option value="Accounts Payable/Receivable Clerk">Accounts Payable/Receivable Clerk</option>
									<option value="Actor">Actor</option>
									<option value="Actuary">Actuary</option>
									<option value="Addiction Counselor">Addiction Counselor</option>
									<option value="Administrative Analyst">Administrative Analyst</option>
									<option value="Administrative Assistant">Administrative Assistant</option>
									<option value="Administrative Manager">Administrative Manager</option>
									<option value="Administrative Specialist">Administrative Specialist</option>
									<option value="Administrator">Administrator</option>
									<option value="Animal Breeder">Animal Breeder</option>
									<option value="Animal Control Officer">Animal Control Officer</option>
									<option value="Animal Shelter Board Member">Animal Shelter Board Member</option>
									<option value="Animal Shelter Manager">Animal Shelter Manager</option>
									<option value="Animal Shelter Volunteer">Animal Shelter Volunteer</option>
									<option value="Animal Shelter Worker">Animal Shelter Worker</option>
									<option value="Animal Trainer">Animal Trainer</option>
									<option value="Application Developer">Application Developer</option>
									<option value="Architect">Architect</option>
									<option value="Archivist">Archivist</option>
									<option value="Area Sales Manager">Area Sales Manager</option>
									<option value="Artificial Intelligence Engineer">Artificial Intelligence Engineer</option>
									<option value="Artist">Artist</option>
									<option value="Assistant Engineer">Assistant Engineer</option>
									<option value="Assistant Golf Professional">Assistant Golf Professional</option>
									<option value="Assistant Manager">Assistant Manager</option>
									<option value="Assistant Professor">Assistant Professor</option>
									<option value="Astronomer">Astronomer</option>
									<option value="Atmospheric Scientist">Atmospheric Scientist</option>
									<option value="Attorney">Attorney</option>
									<option value="Auditing Clerk">Auditing Clerk</option>
									<option value="Auditor">Auditor</option>
									<option value="B2B Sales Specialist">B2B Sales Specialist</option>
									<option value="Bank Teller">Bank Teller</option>
									<option value="Barber">Barber</option>
									<option value="Barista">Barista</option>
									<option value="Beautician">Beautician</option>
									<option value="Bellhop">Bellhop</option>
									<option value="Benefits Manager">Benefits Manager</option>
									<option value="Biological Engineer">Biological Engineer</option>
									<option value="Biologist">Biologist</option>
									<option value="Biostatistician">Biostatistician</option>
									<option value="Board of Directors">Board of Directors</option>
									<option value="Boilermaker">Boilermaker</option>
									<option value="Bookkeeper">Bookkeeper</option>
									<option value="Branch Manager">Branch Manager</option>
									<option value="Brand Manager">Brand Manager</option>
									<option value="Brand Strategist">Brand Strategist</option>
									<option value="Budget Analyst">Budget Analyst</option>
									<option value="Building Inspector">Building Inspector</option>
									<option value="Bus Driver">Bus Driver</option>
									<option value="Bus Person">Bus Person</option>
									<option value="Business Analyst">Business Analyst</option>
									<option value="Business Manager">Business Manager</option>
									<option value="C-Level or C-Suite.">C-Level or C-Suite.</option>
									<option value="CCOâ€”Chief Customer Officer">CCOâ€”Chief Customer Officer</option>
									<option value="CDOâ€”Chief Data Officer">CDOâ€”Chief Data Officer</option>
									<option value="CEO">CEO</option>
									<option value="CEOâ€”Chief Executive Officer">CEOâ€”Chief Executive Officer</option>
									<option value="CFOâ€”Chief Financial Officer">CFOâ€”Chief Financial Officer</option>
									<option value="CHROâ€”Chief Human Resources Officer">CHROâ€”Chief Human Resources Officer</option>
									<option value="CIOâ€”Chief Information Officer">CIOâ€”Chief Information Officer</option>
									<option value="CMOâ€”Chief Marketing Officer">CMOâ€”Chief Marketing Officer</option>
									<option value="CNA">CNA</option>
									<option value="COOâ€”Chief Operating Officer">COOâ€”Chief Operating Officer</option>
									<option value="CPOâ€”Chief Product Officer">CPOâ€”Chief Product Officer</option>
									<option value="CTOâ€”Chief Technology Officer">CTOâ€”Chief Technology Officer</option>
									<option value="Cab Driver">Cab Driver</option>
									<option value="Cafeteria Worker">Cafeteria Worker</option>
									<option value="Call Center Representative">Call Center Representative</option>
									<option value="Camera Operator">Camera Operator</option>
									<option value="Caregiver">Caregiver</option>
									<option value="Caretaker or House Sitter">Caretaker or House Sitter</option>
									<option value="Carpenter">Carpenter</option>
									<option value="Cashier">Cashier</option>
									<option value="Casino Host">Casino Host</option>
									<option value="Chef">Chef</option>
									<option value="Chemical Engineer">Chemical Engineer</option>
									<option value="Chemist">Chemist</option>
									<option value="Chief">Chief</option>
									<option value="Chief Engineer">Chief Engineer</option>
									<option value="Chief Executive Officer">Chief Executive Officer</option>
									<option value="Chief Information Officer (CIO)">Chief Information Officer (CIO)</option>
									<option value="Chief People Officer">Chief People Officer</option>
									<option value="Chief Robot Whisperer">Chief Robot Whisperer</option>
									<option value="Chief Technology Officer (CTO)">Chief Technology Officer (CTO)</option>
									<option value="Church Volunteer">Church Volunteer</option>
									<option value="Civil Engineer">Civil Engineer</option>
									<option value="Client Service Specialist">Client Service Specialist</option>
									<option value="Cloud Architect">Cloud Architect</option>
									<option value="Columnist">Columnist</option>
									<option value="Commercial Loan Officer">Commercial Loan Officer</option>
									<option value="Communications Director">Communications Director</option>
									<option value="Community Food Project Worker">Community Food Project Worker</option>
									<option value="Community Volunteer Jobs">Community Volunteer Jobs</option>
									<option value="Computer Animator">Computer Animator</option>
									<option value="Computer Programmer">Computer Programmer</option>
									<option value="Computer Scientist">Computer Scientist</option>
									<option value="Concierge">Concierge</option>
									<option value="Conservation Scientist">Conservation Scientist</option>
									<option value="Conservation Volunteer">Conservation Volunteer</option>
									<option value="Construction Worker">Construction Worker</option>
									<option value="Content Creator">Content Creator</option>
									<option value="Content Marketing Manager">Content Marketing Manager</option>
									<option value="Content Strategist">Content Strategist</option>
									<option value="Continuous Improvement Consultant">Continuous Improvement Consultant</option>
									<option value="Continuous Improvement Lead">Continuous Improvement Lead</option>
									<option value="Controller">Controller</option>
									<option value="Coordinator">Coordinator</option>
									<option value="Copy Editor">Copy Editor</option>
									<option value="Copywriter">Copywriter</option>
									<option value="Cosmetologist">Cosmetologist</option>
									<option value="Counselor">Counselor</option>
									<option value="Couples Counselor">Couples Counselor</option>
									<option value="Courier">Courier</option>
									<option value="Crane Operator">Crane Operator</option>
									<option value="Credit Authorizer">Credit Authorizer</option>
									<option value="Credit Counselor">Credit Counselor</option>
									<option value="Cruise Director">Cruise Director</option>
									<option value="Cruise Ship Attendant">Cruise Ship Attendant</option>
									<option value="Culture Operations Manager">Culture Operations Manager</option>
									<option value="Customer Care Associate">Customer Care Associate</option>
									<option value="Customer Service">Customer Service</option>
									<option value="Customer Service Manager">Customer Service Manager</option>
									<option value="Customer Support">Customer Support</option>
									<option value="Customer Support Representative">Customer Support Representative</option>
									<option value="Data Analyst">Data Analyst</option>
									<option value="Data Entry">Data Entry</option>
									<option value="Delivery Driver">Delivery Driver</option>
									<option value="Dental Hygienist">Dental Hygienist</option>
									<option value="DevOps Engineer">DevOps Engineer</option>
									<option value="Digital Marketing Manager">Digital Marketing Manager</option>
									<option value="Digital Overlord">Digital Overlord</option>
									<option value="Direct Salesperson">Direct Salesperson</option>
									<option value="Director">Director</option>
									<option value="Director">Director</option>
									<option value="Director of Bean Counting">Director of Bean Counting</option>
									<option value="Director of Ethical Hacking">Director of Ethical Hacking</option>
									<option value="Director of First Impressions">Director of First Impressions</option>
									<option value="Director of Inside Sales">Director of Inside Sales</option>
									<option value="Director of Maintenance">Director of Maintenance</option>
									<option value="Director of Photography">Director of Photography</option>
									<option value="Director of Storytelling">Director of Storytelling</option>
									<option value="Dispatcher for Trucks or Taxis">Dispatcher for Trucks or Taxis</option>
									<option value="Doctor">Doctor</option>
									<option value="Dog Walker / Pet Sitter">Dog Walker / Pet Sitter</option>
									<option value="Drafter">Drafter</option>
									<option value="Economist">Economist</option>
									<option value="Editor/Proofreader">Editor/Proofreader</option>
									<option value="Electrical Engineer">Electrical Engineer</option>
									<option value="Electrician">Electrician</option>
									<option value="Emergency Relief Worker">Emergency Relief Worker</option>
									<option value="Engineer">Engineer</option>
									<option value="Engineering Technician">Engineering Technician</option>
									<option value="Entertainment Specialist">Entertainment Specialist</option>
									<option value="Entrepreneur">Entrepreneur</option>
									<option value="Esthetician">Esthetician</option>
									<option value="Event Planner">Event Planner</option>
									<option value="Events Manager">Events Manager</option>
									<option value="Executive">Executive</option>
									<option value="Executive Assistant">Executive Assistant</option>
									<option value="Farm Worker">Farm Worker</option>
									<option value="Fast Food Worker">Fast Food Worker</option>
									<option value="File Clerk">File Clerk</option>
									<option value="Film Critic">Film Critic</option>
									<option value="Finance Director">Finance Director</option>
									<option value="Finance Manager">Finance Manager</option>
									<option value="Financial Analyst">Financial Analyst</option>
									<option value="Financial Planner">Financial Planner</option>
									<option value="Financial Services Representative">Financial Services Representative</option>
									<option value="Flight Attendant">Flight Attendant</option>
									<option value="Food Kitchen Worker">Food Kitchen Worker</option>
									<option value="Foreman">Foreman</option>
									<option value="Founder">Founder</option>
									<option value="Front Desk Associate">Front Desk Associate</option>
									<option value="Front Desk Manager">Front Desk Manager</option>
									<option value="Front-Line Employees">Front-Line Employees</option>
									<option value="Funeral Attendant">Funeral Attendant</option>
									<option value="Geological Engineer">Geological Engineer</option>
									<option value="Geologist">Geologist</option>
									<option value="Ghostwriter">Ghostwriter</option>
									<option value="Grant Writer">Grant Writer</option>
									<option value="Graphic Designer">Graphic Designer</option>
									<option value="Group Sales">Group Sales</option>
									<option value="Guidance Counselor">Guidance Counselor</option>
									<option value="HVAC Technician">HVAC Technician</option>
									<option value="Habitat for Humanity Builder">Habitat for Humanity Builder</option>
									<option value="Hair Stylist">Hair Stylist</option>
									<option value="Handyman">Handyman</option>
									<option value="Head">Head</option>
									<option value="Heavy Equipment Operator">Heavy Equipment Operator</option>
									<option value="Help Desk">Help Desk</option>
									<option value="Help Desk Worker/Desktop Support">Help Desk Worker/Desktop Support</option>
									<option value="Homeless Shelter Worker">Homeless Shelter Worker</option>
									<option value="Hospital Volunteer">Hospital Volunteer</option>
									<option value="Hotel Front Door Greeter">Hotel Front Door Greeter</option>
									<option value="Hotel Manager">Hotel Manager</option>
									<option value="Hotel Receptionist">Hotel Receptionist</option>
									<option value="Housekeeper">Housekeeper</option>
									<option value="Human Resources">Human Resources</option>
									<option value="IT Manager">IT Manager</option>
									<option value="IT Professional">IT Professional</option>
									<option value="Information Security Analyst">Information Security Analyst</option>
									<option value="Interior Designer">Interior Designer</option>
									<option value="Iron Worker">Iron Worker</option>
									<option value="Journalist">Journalist</option>
									<option value="Landscaping Assistant">Landscaping Assistant</option>
									<option value="Landscaping Worker">Landscaping Worker</option>
									<option value="Lead">Lead</option>
									<option value="Library Assistant">Library Assistant</option>
									<option value="Life Coach">Life Coach</option>
									<option value="Line Cook">Line Cook</option>
									<option value="Locksmith">Locksmith</option>
									<option value="Lodging Manager">Lodging Manager</option>
									<option value="Machinery Operator">Machinery Operator</option>
									<option value="Mail Carrier">Mail Carrier</option>
									<option value="Maintenance Engineer">Maintenance Engineer</option>
									<option value="Makeup Artist">Makeup Artist</option>
									<option value="Management Consultant">Management Consultant</option>
									<option value="Manager">Manager</option>
									<option value="Managers">Managers</option>
									<option value="Managing Member">Managing Member</option>
									<option value="Managing Partner">Managing Partner</option>
									<option value="Manicurist">Manicurist</option>
									<option value="Manufacturing Assembler">Manufacturing Assembler</option>
									<option value="Market Development Manager">Market Development Manager</option>
									<option value="Market Researcher">Market Researcher</option>
									<option value="Marketing Communications Manager">Marketing Communications Manager</option>
									<option value="Marketing Consultant">Marketing Consultant</option>
									<option value="Marketing Director">Marketing Director</option>
									<option value="Marketing Manager">Marketing Manager</option>
									<option value="Marketing Research Analyst">Marketing Research Analyst</option>
									<option value="Marketing Specialist">Marketing Specialist</option>
									<option value="Marketing Staff">Marketing Staff</option>
									<option value="Mason">Mason</option>
									<option value="Massage Therapy">Massage Therapy</option>
									<option value="Mathematician">Mathematician</option>
									<option value="Meals on Wheels Driver">Meals on Wheels Driver</option>
									<option value="Mechanic">Mechanic</option>
									<option value="Mechanical Engineer">Mechanical Engineer</option>
									<option value="Media Buyer">Media Buyer</option>
									<option value="Media Relations Coordinator">Media Relations Coordinator</option>
									<option value="Medical Administrator">Medical Administrator</option>
									<option value="Medical Laboratory Tech">Medical Laboratory Tech</option>
									<option value="Medical Researcher">Medical Researcher</option>
									<option value="Medical Transcriptionist">Medical Transcriptionist</option>
									<option value="Meeting Planner">Meeting Planner</option>
									<option value="Mental Health Counselor">Mental Health Counselor</option>
									<option value="Mentor">Mentor</option>
									<option value="Mining Engineer">Mining Engineer</option>
									<option value="Molecular Scientist">Molecular Scientist</option>
									<option value="Mortgage Loan Processor">Mortgage Loan Processor</option>
									<option value="Motion Picture Director">Motion Picture Director</option>
									<option value="Mover">Mover</option>
									<option value="Music Producer">Music Producer</option>
									<option value="Musician">Musician</option>
									<option value="Nail Technician">Nail Technician</option>
									<option value="Network Administrator">Network Administrator</option>
									<option value="Novelist/Writer">Novelist/Writer</option>
									<option value="Nuclear Engineer">Nuclear Engineer</option>
									<option value="Nurse">Nurse</option>
									<option value="Nurse Practitioner">Nurse Practitioner</option>
									<option value="Office Assistant">Office Assistant</option>
									<option value="Office Clerk">Office Clerk</option>
									<option value="Office Manager">Office Manager</option>
									<option value="Office Volunteer">Office Volunteer</option>
									<option value="Officer">Officer</option>
									<option value="Online ESL Instructor">Online ESL Instructor</option>
									<option value="Operations Analyst">Operations Analyst</option>
									<option value="Operations Assistant">Operations Assistant</option>
									<option value="Operations Coordinator">Operations Coordinator</option>
									<option value="Operations Director">Operations Director</option>
									<option value="Operations Manager">Operations Manager</option>
									<option value="Operations Professional">Operations Professional</option>
									<option value="Orderly">Orderly</option>
									<option value="Organizer">Organizer</option>
									<option value="Outside Sales Manager">Outside Sales Manager</option>
									<option value="Over the Phone Interpreter">Over the Phone Interpreter</option>
									<option value="Overseer">Overseer</option>
									<option value="Owner">Owner</option>
									<option value="Painter">Painter</option>
									<option value="Paralegal">Paralegal</option>
									<option value="Parking Attendant">Parking Attendant</option>
									<option value="Payroll Clerk">Payroll Clerk</option>
									<option value="Payroll Manager">Payroll Manager</option>
									<option value="Personal Assistant">Personal Assistant</option>
									<option value="Personal Trainer">Personal Trainer</option>
									<option value="Petroleum Engineer">Petroleum Engineer</option>
									<option value="Pharmacist">Pharmacist</option>
									<option value="Pharmacy Assistant">Pharmacy Assistant</option>
									<option value="Phlebotomist">Phlebotomist</option>
									<option value="Phone Sales Specialist">Phone Sales Specialist</option>
									<option value="Phone Survey Conductor">Phone Survey Conductor</option>
									<option value="Photographer">Photographer</option>
									<option value="Physical Therapist">Physical Therapist</option>
									<option value="Physical Therapy Assistant">Physical Therapy Assistant</option>
									<option value="Physicist">Physicist</option>
									<option value="Pipefitter">Pipefitter</option>
									<option value="Plant Engineer">Plant Engineer</option>
									<option value="Playwright">Playwright</option>
									<option value="Plumber">Plumber</option>
									<option value="Political Scientist">Political Scientist</option>
									<option value="Porter">Porter</option>
									<option value="Preschool Teacher">Preschool Teacher</option>
									<option value="President">President</option>
									<option value="Principal">Principal</option>
									<option value="Product Manager">Product Manager</option>
									<option value="Production Engineer">Production Engineer</option>
									<option value="Professor">Professor</option>
									<option value="Program Administrator">Program Administrator</option>
									<option value="Program Manager">Program Manager</option>
									<option value="Proposal Writer">Proposal Writer</option>
									<option value="Proprietor">Proprietor</option>
									<option value="Public Relations">Public Relations</option>
									<option value="Public Relations Specialist">Public Relations Specialist</option>
									<option value="Purchasing Staff">Purchasing Staff</option>
									<option value="Quality Control">Quality Control</option>
									<option value="Quality Control Coordinator">Quality Control Coordinator</option>
									<option value="Quality Engineer">Quality Engineer</option>
									<option value="Real Estate Broker">Real Estate Broker</option>
									<option value="Receptionist">Receptionist</option>
									<option value="Receptionist">Receptionist</option>
									<option value="Recruiter">Recruiter</option>
									<option value="Recyclables Collector">Recyclables Collector</option>
									<option value="Red Cross Volunteer">Red Cross Volunteer</option>
									<option value="Reiki Practitioner">Reiki Practitioner</option>
									<option value="Research Assistant">Research Assistant</option>
									<option value="Researcher">Researcher</option>
									<option value="Reservationist">Reservationist</option>
									<option value="Restaurant Chain Executive">Restaurant Chain Executive</option>
									<option value="Restaurant Manager">Restaurant Manager</option>
									<option value="Retail Worker">Retail Worker</option>
									<option value="Risk Manager">Risk Manager</option>
									<option value="Roofer">Roofer</option>
									<option value="SEO Manager">SEO Manager</option>
									<option value="SQL Developer">SQL Developer</option>
									<option value="Safety Engineer">Safety Engineer</option>
									<option value="Sales Analyst">Sales Analyst</option>
									<option value="Sales Associate">Sales Associate</option>
									<option value="Sales Engineer">Sales Engineer</option>
									<option value="Sales Manager">Sales Manager</option>
									<option value="Sales Representative">Sales Representative</option>
									<option value="Salon Manager">Salon Manager</option>
									<option value="School Bus Driver">School Bus Driver</option>
									<option value="School Counselor">School Counselor</option>
									<option value="School Volunteer">School Volunteer</option>
									<option value="Screenwriter">Screenwriter</option>
									<option value="Scrum Master">Scrum Master</option>
									<option value="Secretary">Secretary</option>
									<option value="Security Guard">Security Guard</option>
									<option value="Server">Server</option>
									<option value="Service Dog Trainer">Service Dog Trainer</option>
									<option value="Shareholders">Shareholders</option>
									<option value="Sheet Metal Worker">Sheet Metal Worker</option>
									<option value="Shelf Stocker">Shelf Stocker</option>
									<option value="Shipping and Receiving Staff">Shipping and Receiving Staff</option>
									<option value="Skin Care Specialist">Skin Care Specialist</option>
									<option value="Social Media Assistant">Social Media Assistant</option>
									<option value="Social Media Specialist">Social Media Specialist</option>
									<option value="Social Worker">Social Worker</option>
									<option value="Sociologist">Sociologist</option>
									<option value="Software Engineer">Software Engineer</option>
									<option value="Software Ninjaneer">Software Ninjaneer</option>
									<option value="Solar Photovoltaic Installer">Solar Photovoltaic Installer</option>
									<option value="Sound Engineer">Sound Engineer</option>
									<option value="Spa Manager">Spa Manager</option>
									<option value="Speech Pathologist">Speech Pathologist</option>
									<option value="Speechwriter">Speechwriter</option>
									<option value="Sports Volunteer">Sports Volunteer</option>
									<option value="Store Manager">Store Manager</option>
									<option value="Substitute Teacher">Substitute Teacher</option>
									<option value="Suicide Hotline Volunteer">Suicide Hotline Volunteer</option>
									<option value="Superintendent">Superintendent</option>
									<option value="Supervisor">Supervisor</option>
									<option value="Supervisors">Supervisors</option>
									<option value="Taper">Taper</option>
									<option value="Teacher">Teacher</option>
									<option value="Teaching Assistant">Teaching Assistant</option>
									<option value="Team Leader">Team Leader</option>
									<option value="Technical Specialist">Technical Specialist</option>
									<option value="Technical Support Specialist">Technical Support Specialist</option>
									<option value="Technical Writer">Technical Writer</option>
									<option value="Telemarketer">Telemarketer</option>
									<option value="Telephone Operator">Telephone Operator</option>
									<option value="Telework Nurse/Doctor">Telework Nurse/Doctor</option>
									<option value="Test Scorer">Test Scorer</option>
									<option value="Therapist">Therapist</option>
									<option value="Title Analyst">Title Analyst</option>
									<option value="Title Researcher">Title Researcher</option>
									<option value="Tow Truck Operator">Tow Truck Operator</option>
									<option value="Translator">Translator</option>
									<option value="Translator">Translator</option>
									<option value="Travel Agent">Travel Agent</option>
									<option value="Travel Nurse">Travel Nurse</option>
									<option value="Travel Writer">Travel Writer</option>
									<option value="Truck Driver">Truck Driver</option>
									<option value="Tutor/Online Tutor">Tutor/Online Tutor</option>
									<option value="UPS Driver">UPS Driver</option>
									<option value="UX Designer & UI Developer">UX Designer & UI Developer</option>
									<option value="VP of Miscellaneous Stuff">VP of Miscellaneous Stuff</option>
									<option value="Valet">Valet</option>
									<option value="Vehicle or Equipment Cleaner">Vehicle or Equipment Cleaner</option>
									<option value="Veterinary Assistant">Veterinary Assistant</option>
									<option value="Vice President of Marketing">Vice President of Marketing</option>
									<option value="Vice President of Operations">Vice President of Operations</option>
									<option value="Video Editor">Video Editor</option>
									<option value="Video Game Writer">Video Game Writer</option>
									<option value="Video or Film Producer">Video or Film Producer</option>
									<option value="Virtual Assistant">Virtual Assistant</option>
									<option value="Wait Staff Manager">Wait Staff Manager</option>
									<option value="Waiter/Waitress">Waiter/Waitress</option>
									<option value="Warehouse Worker">Warehouse Worker</option>
									<option value="Web Designer">Web Designer</option>
									<option value="Web Developer">Web Developer</option>
									<option value="Wedding Coordinator">Wedding Coordinator</option>
									<option value="Welder">Welder</option>
									<option value="Welding">Welding</option>
									<option value="Well Driller">Well Driller</option>
									<option value="Womenâ€™s Shelter Jobs">Womenâ€™s Shelter Jobs</option>
									<option value="Yoga Instructor">Yoga Instructor</option>
									<option value="Youth Volunteer">Youth Volunteer</option>
									<option value="Zoologist">Zoologist</option>
                                </select>
                            </div>
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="Company" /></label><span class="text-danger">*</span>
                                <input type="text" maxlength="70"  id="company" name="<liferay-ui:message key="Company" />" class="form-control" required />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="worktillnow" name="till now">
                                        <label class="form-check-label" for="worktillnow">
                                         <liferay-ui:message key="Tillnow" />
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <label><liferay-ui:message key="Location" /></label><span class="text-danger">*</span>
                                <input type="text"  maxlength="70"  id="location" name="<liferay-ui:message key="Location" />" class="form-control" required />
                            </div>
                            <div class="col-md-4 form-group">
                                <label><liferay-ui:message key="StartDate" /></label><span class="text-danger">*</span>
                                <input type="date" id="workstartdate" name="<liferay-ui:message key="StartDate" />" class="form-control" required/>
                            </div>
                            <div class="col-md-4 form-group">
                                <label><liferay-ui:message key="EndDate" /></label><span class="text-danger"></span>
                                <input type="date" id="workendate" name="<liferay-ui:message key="EndDate" />" class="form-control" />
                                <span id="presentSpan" style="display:none;"><liferay-ui:message key="Present" /></span>
                            </div>
                        </div>
                          <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="workJourney" name="Appear in journey">
                                        <label class="form-check-label" for="workJourney">
                                         <liferay-ui:message key="appearInJourney" />
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <label><liferay-ui:message key="Description" /></label>
                                <textarea maxlength="600" id="workdescription" name="workdescription" class="form-control" rows="5"></textarea>
                            </div>
                        </div>
                        <div class="row pt-2">
                            <div class="col-md-3">
                             </div>
                            <div class="col-md-6">
			                    <div id="alertContainer" style="display:none; line-height: 0.7; text-align: center; font-size: small;" class="alert-notifications alertContainerClass">
								  	<div class="alert alert-success fade alert-dismissible show" role="alert">
										<span id="alertText" class="alertTextClass"></span>
									</div>
							    </div>                            
                            </div>
                            <div class="col-md-3">
                                <!--<button type="submit" class="btn btn-primary float-right">Add</button>-->
                                <input value="<liferay-ui:message key="Add" />" type="button" onclick="saveToDatabase('addProfileInfo','frmaddworkexperience','addWorkExperience','#addworkexperience')" id="adduserworkexperience" name="adduserworkexperience" class="btn btn-primary addBtnProf float-left">
                                <button type="reset" class="btn btn-secondary float-right" data-dismiss="modal"><liferay-ui:message key="Cancel" /></button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="addresume" tabindex="-1" role="dialog" aria-labelledby="addresumeLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header text-white modal-header-bg bg-info">
                    <h5 class="modal-title" id="addresumeLabel">
                        <label>Add CV/Cover lette</label>
                    </h5>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmAddResume" class="bootstrap-form needs-validation" novalidate>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Title</label><span class="text-danger">*</span>
                                <input type="text" name="resumetitle" id="resumetitle" class="form-control" />
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Type</label><span class="text-danger">*</span>
                                <select name="resumetype" id="resumetype" class="form-control">
                                    <option value="">select</option>
                                    <option value="1">Resume</option>
                                    <option value="2">Cover Letter</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label>File Upload</label><span class="text-danger">*</span>
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" id="resumefile" name="resumefile">
                                    <label class="custom-file-label" for="customFile">Choose file</label>
                                </div>
                                <div class="help-block"><span class="text-danger">*</span>.doc,.docx,.pdf only</div>

                            </div>
                        </div>

                        <div class="row pt-2">
                            <div class="col-md-3">
                                 </div>
                            <div class="col-md-6">
			                    <div id="alertContainer" style="display:none; line-height: 0.7; text-align: center; font-size: small;" class="alert-notifications alertContainerClass">
								  	<div class="alert alert-success fade alert-dismissible show" role="alert">
										<span id="alertText" class="alertTextClass"></span>
									</div>
							    </div>    
							</div>  
                            <div class="col-md-3">
                                <a href="#" id="adduserresume" name="adduserresume" data-dismiss="modal" class="btn btn-outline-primary float-right">Save</a>
                               <button type="reset" class="btn btn-secondary float-left" data-dismiss="modal"><liferay-ui:message key="Cancel" /></button>
                          
                                <!--<button type="submit" class="btn btn-primary float-right">Add</button>-->
                            </div>
                        </div>

                    </form>
                </div>

            </div>
        </div>
    </div>



    <div class="modal fade" id="requesttestimonial" tabindex="-1" role="dialog" aria-labelledby="requesttestimonialLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header text-white modal-header-bg bg-info">
                    <h5 class="modal-title" id="requesttestimonialLabel">
                        <label><liferay-ui:message key="RequestTestimonial" /></label>
                    </h5>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmAddtestimonial" class="bootstrap-form needs-validation" novalidate>
                         <input type="hidden" id=testimonialproviderId name="testimonialproviderId" value="0">  
                            <div class="avatar-upload">
						        <div class="avatar-edit">
						            <input type='file' id="imageUpload" accept=".png, .jpg, .jpeg" />
						            <label for="imageUpload"></label>
						        </div>
						        <div class="avatar-preview">
						            <div id="imgPreview" style="background-image: url(/o/new-misk-theme/images/profile/pic1.png);">
						            <input type='hidden' id="imagePreview" value="" />
						            </div>
						        </div>
						    </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="Nameoftestimonialprovider" /></label><span class="text-danger">*</span>
                                <input type="text"  maxlength="70"  name="<liferay-ui:message key="Nameoftestimonialprovider" />" id="testimonialprovidername" class="form-control" />
                            </div>
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="Email" /></label><span class="text-danger">*</span>
                                <input type="email" maxlength="70" id="testimonialprovideremail" name="<liferay-ui:message key="Email" />" class="form-control" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="OrganisationsName" /></label><span class="text-danger">*</span>
                                <input type="text"  maxlength="70" id="testimonialprovideorganizationname" name="<liferay-ui:message key="OrganisationsName" />" class="form-control" />
                            </div>
                            <div class="col-md-6 form-group">
                                <label><liferay-ui:message key="ProvidersTitle" /></label><span class="text-danger">*</span>
                                <select id="testimonialprovidertitle" name="<liferay-ui:message key="ProvidersTitle" />" class="form-control">
                                    <option value="">select</option>
                                    <option value="Teacher">Teacher</option>
                                    <option value="Manager">Manager</option>
                                    <option value="Employer">Employer</option>
                                    <option value="Co-Worker">Co-Worker</option>
                                    <option value="Coach">Coach</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label><liferay-ui:message key="Privatemessagetoyourtestimonialprovider" /></label><span class="text-danger">*</span>
                                <textarea id="testimonialprivatemessage" maxlength="190" name="testimonialprivatemessage" class="form-control" rows="5"></textarea>
                            </div>

                        </div>

                        <div class="row pt-2">
                            <div class="col-md-3">
                             </div>
                            <div class="col-md-6">
			                    <div id="alertContainer" style="display:none; line-height: 0.7; text-align: center; font-size: small;" class="alert-notifications alertContainerClass">
								  	<div class="alert alert-success fade alert-dismissible show" role="alert">
										<span id="alertText" class="alertTextClass"></span>
									</div>
							    </div>    
							</div>  
                            <div class="col-md-3">
								<!--     <a href="#" id="addtestimonialrequest" name="addtestimonialrequest" data-dismiss="modal" class="btn btn-outline-primary float-right">Save</a> -->
                                <input value="<liferay-ui:message key="Add" />" type="button" onclick="saveToDatabase('addProfileInfo','frmAddtestimonial','addtestimonial','#requesttestimonial')" id="addtestimonialrequest" name="addtestimonialrequest" data-dismiss="modal" class="btn btn-primary float-left">
                                <button type="reset" class="btn btn-secondary float-right" data-dismiss="modal"><liferay-ui:message key="Cancel" /></button>
                           
                            </div>
                        </div>

                    </form>
                </div>

            </div>
        </div>
    </div>


    <div class="modal fade" id="addjobwishlist" tabindex="-1" role="dialog" aria-labelledby="addjobwishlistLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header text-white modal-header-bg bg-info">
                    <h5 class="modal-title" id="addjobwishlistLabel">
                        <label><liferay-ui:message key="AddJobWishlist" /></label>
                    </h5>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmAddJobWishList" class="bootstrap-form needs-validation" novalidate>
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label><liferay-ui:message key="Wishlist" /></label><span class="text-danger">*</span>
                                <select class="js-example-tags form-control" multiple="multiple" style="width:100%;" id="jobwishlist" name="<liferay-ui:message key="Wishlist" />" required>
                               		<option id='Accountants'>Accountants</option>
									<option id='Accounting Clerks'>Accounting Clerks</option>
									<option id='Accounts Clerks'>Accounts Clerks</option>
									<option id='Actors'>Actors</option>
									<option id='Actuaries'>Actuaries</option>
									<option id='Acupuncturists'>Acupuncturists</option>
									<option id='Administration Managers'>Administration Managers</option>
									<option id='Admissions Clerks'>Admissions Clerks</option>
									<option id='Advertising and Marketing Professionals'>Advertising and Marketing Professionals</option>
									<option id='Advertising Managers'>Advertising Managers</option>
									<option id='Advertising Specialists'>Advertising Specialists</option>
									<option id='Advertising, Public Relations and Sales Manager'>Advertising, Public Relations and Sales Manager</option>
									<option id='Aerobics Instructors'>Aerobics Instructors</option>
									<option id='Aeronautical Engineers'>Aeronautical Engineers</option>
									<option id='Aeroplane Pilots'>Aeroplane Pilots</option>
									<option id='Aerospace Engineers'>Aerospace Engineers</option>
									<option id='Aged and Disabled Carers'>Aged and Disabled Carers</option>
									<option id='Agricultural Consultants'>Agricultural Consultants</option>
									<option id='Agricultural Engineers'>Agricultural Engineers</option>
									<option id='Agricultural Scientists'>Agricultural Scientists</option>
									<option id='Agricultural Technicians'>Agricultural Technicians</option>
									<option id='Agronomists'>Agronomists</option>
									<option id='Air Traffic Controllers'>Air Traffic Controllers</option>
									<option id='Air Transport Professionals'>Air Transport Professionals</option>
									<option id='Aircraft Refuellers'>Aircraft Refuellers</option>
									<option id='Alternative Health Therapists'>Alternative Health Therapists</option>
									<option id='Ambulance Officers'>Ambulance Officers</option>
									<option id='Ambulance Officers and Paramedics'>Ambulance Officers and Paramedics</option>
									<option id='Amusement Centre Managers'>Amusement Centre Managers</option>
									<option id='Anaesthetic Technicians'>Anaesthetic Technicians</option>
									<option id='Anaesthetists'>Anaesthetists</option>
									<option id='Analyst Programmers'>Analyst Programmers</option>
									<option id='Animal Attendants and Trainers'>Animal Attendants and Trainers</option>
									<option id='Antique Dealers'>Antique Dealers</option>
									<option id='Apiarists'>Apiarists</option>
									<option id='Apparel Cutters'>Apparel Cutters</option>
									<option id='Applications Developers'>Applications Developers</option>
									<option id='Aquaculture Farmers'>Aquaculture Farmers</option>
									<option id='Aquaculture Workers'>Aquaculture Workers</option>
									<option id='Arborists'>Arborists</option>
									<option id='Archaeologists'>Archaeologists</option>
									<option id='Architects'>Architects</option>
									<option id='Architectural Draftspersons'>Architectural Draftspersons</option>
									<option id='Archivists'>Archivists</option>
									<option id='Armoured Car Escorts'>Armoured Car Escorts</option>
									<option id='Artistic Directors'>Artistic Directors</option>
									<option id='Arts Administrators and Managers'>Arts Administrators and Managers</option>
									<option id='Assembly Workers'>Assembly Workers</option>
									<option id='Assistants in Nursing'>Assistants in Nursing</option>
									<option id='Astronomers (Physicists)'>Astronomers (Physicists)</option>
									<option id='Athletes'>Athletes</option>
									<option id='Auctioneers'>Auctioneers</option>
									<option id='Auctioneers, and Stock and Station Agents'>Auctioneers, and Stock and Station Agents</option>
									<option id='Audiologists'>Audiologists</option>
									<option id='Australian Rules Footballers'>Australian Rules Footballers</option>
									<option id='Authors'>Authors</option>
									<option id='Authors, and Book and Script Editors'>Authors, and Book and Script Editors</option>
									<option id='Autoglaziers'>Autoglaziers</option>
									<option id='Automobile Drivers'>Automobile Drivers</option>
									<option id='Automotive Electricians'>Automotive Electricians</option>
									<option id='B'>B</option>
									<option id='Backhoe Operators'>Backhoe Operators</option>
									<option id='Bakers'>Bakers</option>
									<option id='Bakers and Pastrycooks'>Bakers and Pastrycooks</option>
									<option id='Bakery Assistants'>Bakery Assistants</option>
									<option id='Baking Factory Workers'>Baking Factory Workers</option>
									<option id='Bank Managers and Branch Managers'>Bank Managers and Branch Managers</option>
									<option id='Bank Tellers'>Bank Tellers</option>
									<option id='Bank Workers'>Bank Workers</option>
									<option id='Bar Attendants'>Bar Attendants</option>
									<option id='Bar Attendants and Baristas'>Bar Attendants and Baristas</option>
									<option id='Bar Usefuls and Bussers'>Bar Usefuls and Bussers</option>
									<option id='Barbers'>Barbers</option>
									<option id='Baristas'>Baristas</option>
									<option id='Barristers'>Barristers</option>
									<option id='Beauty Therapists'>Beauty Therapists</option>
									<option id='Bed and Breakfast Operators'>Bed and Breakfast Operators</option>
									<option id='Beef Cattle Farm Workers'>Beef Cattle Farm Workers</option>
									<option id='Beef Cattle Farmers'>Beef Cattle Farmers</option>
									<option id='Beekeepers'>Beekeepers</option>
									<option id='Betting Agency Counter Clerks'>Betting Agency Counter Clerks</option>
									<option id='Betting Agency Managers'>Betting Agency Managers</option>
									<option id='Betting Clerks'>Betting Clerks</option>
									<option id='Bicycle Mechanics'>Bicycle Mechanics</option>
									<option id='Binders, Finishers and Screen Printers'>Binders, Finishers and Screen Printers</option>
									<option id='Biochemists'>Biochemists</option>
									<option id='Biologists'>Biologists</option>
									<option id='Biomedical Engineers'>Biomedical Engineers</option>
									<option id='Biotechnologists'>Biotechnologists</option>
									<option id='Blacksmiths'>Blacksmiths</option>
									<option id='Blasting Workers'>Blasting Workers</option>
									<option id='Blood Collectors (Pathology Collectors)'>Blood Collectors (Pathology Collectors)</option>
									<option id='Boarding Kennel and Cattery Operators'>Boarding Kennel and Cattery Operators</option>
									<option id='Boat Builders and Repairers'>Boat Builders and Repairers</option>
									<option id='Boat Builders and Shipwrights'>Boat Builders and Shipwrights</option>
									<option id='Body Artists'>Body Artists</option>
									<option id='Boiler and Engine Operators'>Boiler and Engine Operators</option>
									<option id='Boilermakers'>Boilermakers</option>
									<option id='Boilermaker's Assistants'>Boilermaker's Assistants</option>
									<option id='Boners and Slicers'>Boners and Slicers</option>
									<option id='Book and Script Editors'>Book and Script Editors</option>
									<option id='Bookkeepers'>Bookkeepers</option>
									<option id='Bookmakers'>Bookmakers</option>
									<option id='Bookmaker's Clerks'>Bookmaker's Clerks</option>
									<option id='Botanists'>Botanists</option>
									<option id='Bouncers'>Bouncers</option>
									<option id='Branch Managers (Financial Services)'>Branch Managers (Financial Services)</option>
									<option id='Brewery Workers'>Brewery Workers</option>
									<option id='Bricklayers'>Bricklayers</option>
									<option id='Bricklayers and Stonemasons'>Bricklayers and Stonemasons</option>
									<option id='Bricklayer's Assistants'>Bricklayer's Assistants</option>
									<option id='Broadcast Transmitter Operators'>Broadcast Transmitter Operators</option>
									<option id='Brokers (Financial)'>Brokers (Financial)</option>
									<option id='Builder's Labourers'>Builder's Labourers</option>
									<option id='Building and Construction Managers'>Building and Construction Managers</option>
									<option id='Building and Engineering Technicians (not covered elsewhere)'>Building and Engineering Technicians (not covered elsewhere)</option>
									<option id='Building and Plumbing Labourers'>Building and Plumbing Labourers</option>
									<option id='Building Associates'>Building Associates</option>
									<option id='Building Certifiers'>Building Certifiers</option>
									<option id='Building Economists'>Building Economists</option>
									<option id='Building Estimators'>Building Estimators</option>
									<option id='Building Inspectors'>Building Inspectors</option>
									<option id='Building Insulation Installers'>Building Insulation Installers</option>
									<option id='Building Managers'>Building Managers</option>
									<option id='Building Surveyors'>Building Surveyors</option>
									<option id='Building Technicians'>Building Technicians</option>
									<option id='Bulk Materials Handling Plant Operators'>Bulk Materials Handling Plant Operators</option>
									<option id='Bulldozer Operators'>Bulldozer Operators</option>
									<option id='Bungy Jump Masters'>Bungy Jump Masters</option>
									<option id='Bus and Coach Drivers'>Bus and Coach Drivers</option>
									<option id='Bus Drivers'>Bus Drivers</option>
									<option id='Business Analysts (ICT)'>Business Analysts (ICT)</option>
									<option id='Business Brokers'>Business Brokers</option>
									<option id='Business Machine Mechanics'>Business Machine Mechanics</option>
									<option id='Business Managers'>Business Managers</option>
									<option id='Business Owners'>Business Owners</option>
									<option id='Business Services Managers'>Business Services Managers</option>
									<option id='Butchers and Smallgoods Makers'>Butchers and Smallgoods Makers</option>
									<option id='Buyers (Retail and Wool)'>Buyers (Retail and Wool)</option>
									<option id='Cabin Crew'>Cabin Crew</option>
									<option id='Cabinetmakers'>Cabinetmakers</option>
									<option id='Cablers (Data and Telecommunications)'>Cablers (Data and Telecommunications)</option>
									<option id='Cafe and Restaurant Managers'>Cafe and Restaurant Managers</option>
									<option id='Cafe Workers'>Cafe Workers</option>
									<option id='Cake Decorators (Pastrycooks)'>Cake Decorators (Pastrycooks)</option>
									<option id='Call Centre or Contact Centre Managers'>Call Centre or Contact Centre Managers</option>
									<option id='Call Centre or Contact Centre Operators'>Call Centre or Contact Centre Operators</option>
									<option id='Call Centre or Contact Centre Team Leaders'>Call Centre or Contact Centre Team Leaders</option>
									<option id='Call or Contact Centre Workers'>Call or Contact Centre Workers</option>
									<option id='Call, Contact Centre & Customer Service Managers'>Call, Contact Centre & Customer Service Managers</option>
									<option id='Camera Operators (Film, Television or Video)'>Camera Operators (Film, Television or Video)</option>
									<option id='Canvas and Leather Goods Makers'>Canvas and Leather Goods Makers</option>
									<option id='Canvas Goods Fabricators'>Canvas Goods Fabricators</option>
									<option id='Car Detailers'>Car Detailers</option>
									<option id='Car Mechanics'>Car Mechanics</option>
									<option id='Car Park Attendants'>Car Park Attendants</option>
									<option id='Car Parts & Accessories Fitters'>Car Parts & Accessories Fitters</option>
									<option id='Car Salespersons'>Car Salespersons</option>
									<option id='Caravan Park and Camping Ground Managers'>Caravan Park and Camping Ground Managers</option>
									<option id='Cardiac Technicians'>Cardiac Technicians</option>
									<option id='Cardiologists'>Cardiologists</option>
									<option id='Cardiothoracic Surgeons'>Cardiothoracic Surgeons</option>
									<option id='Careers Advisers'>Careers Advisers</option>
									<option id='Careers Counsellors'>Careers Counsellors</option>
									<option id='Carers (Aged and Disabled)'>Carers (Aged and Disabled)</option>
									<option id='Carers (Children)'>Carers (Children)</option>
									<option id='Caretakers'>Caretakers</option>
									<option id='Carpenters'>Carpenters</option>
									<option id='Carpenters and Joiners'>Carpenters and Joiners</option>
									<option id='Carpenter's Assistants'>Carpenter's Assistants</option>
									<option id='Carpet Cleaners'>Carpet Cleaners</option>
									<option id='Carpet Layers'>Carpet Layers</option>
									<option id='Cartographers'>Cartographers</option>
									<option id='Cash Van Salespersons'>Cash Van Salespersons</option>
									<option id='Cashiers'>Cashiers</option>
									<option id='Cement and Concrete Plant Workers'>Cement and Concrete Plant Workers</option>
									<option id='Cement Production Plant Operators'>Cement Production Plant Operators</option>
									<option id='Certifier (Building)'>Certifier (Building)</option>
									<option id='Charter and Tour Bus Drivers'>Charter and Tour Bus Drivers</option>
									<option id='Chauffeurs'>Chauffeurs</option>
									<option id='Checkout Operators'>Checkout Operators</option>
									<option id='Checkout Operators and Office Cashiers'>Checkout Operators and Office Cashiers</option>
									<option id='Checkout Supervisors'>Checkout Supervisors</option>
									<option id='Cheese Makers'>Cheese Makers</option>
									<option id='Chefs'>Chefs</option>
									<option id='Chemical and Materials Engineers'>Chemical and Materials Engineers</option>
									<option id='Chemical Engineers'>Chemical Engineers</option>
									<option id='Chemical Plant Operators'>Chemical Plant Operators</option>
									<option id='Chemical Plant Workers'>Chemical Plant Workers</option>
									<option id='Chemical Production Machine Operators'>Chemical Production Machine Operators</option>
									<option id='Chemical, Gas, Petroleum & Power Plant Operators'>Chemical, Gas, Petroleum & Power Plant Operators</option>
									<option id='Chemistry Technicians'>Chemistry Technicians</option>
									<option id='Chemists'>Chemists</option>
									<option id='Chemists, and Food and Wine Scientists'>Chemists, and Food and Wine Scientists</option>
									<option id='Chief Executives and Managing Directors'>Chief Executives and Managing Directors</option>
									<option id='Chief Financial Officer'>Chief Financial Officer</option>
									<option id='Chief Information Officers'>Chief Information Officers</option>
									<option id='Chief Operating Officer'>Chief Operating Officer</option>
									<option id='Child and Youth Residential Care Assistants'>Child and Youth Residential Care Assistants</option>
									<option id='Child Care Centre Managers'>Child Care Centre Managers</option>
									<option id='Child Care Workers'>Child Care Workers</option>
									<option id='Child Carers'>Child Carers</option>
									<option id='Chinese Medicine Practitioners'>Chinese Medicine Practitioners</option>
									<option id='Chiropractors'>Chiropractors</option>
									<option id='Chiropractors and Osteopaths'>Chiropractors and Osteopaths</option>
									<option id='Chocolate Packers'>Chocolate Packers</option>
									<option id='Choreographers'>Choreographers</option>
									<option id='Cinema and Theatre Managers'>Cinema and Theatre Managers</option>
									<option id='Cinematographers'>Cinematographers</option>
									<option id='Civil Celebrants'>Civil Celebrants</option>
									<option id='Civil Engineering Draftspersons'>Civil Engineering Draftspersons</option>
									<option id='Civil Engineering Draftspersons and Technicians'>Civil Engineering Draftspersons and Technicians</option>
									<option id='Civil Engineering Professionals'>Civil Engineering Professionals</option>
									<option id='Civil Engineering Technicians'>Civil Engineering Technicians</option>
									<option id='Civil Engineers'>Civil Engineers</option>
									<option id='Classified Advertising Clerks'>Classified Advertising Clerks</option>
									<option id='Clay Processing Factory Workers'>Clay Processing Factory Workers</option>
									<option id='Clay Products Machine Operators'>Clay Products Machine Operators</option>
									<option id='Clay, Concrete, Glass & Stone Machine Operators'>Clay, Concrete, Glass & Stone Machine Operators</option>
									<option id='Cleaners (Commercial)'>Cleaners (Commercial)</option>
									<option id='Cleaners (Domestic)'>Cleaners (Domestic)</option>
									<option id='Cleaners (not covered elsewhere)'>Cleaners (not covered elsewhere)</option>
									<option id='Clerical and Administrative Workers (not covered elsewhere)'>Clerical and Administrative Workers (not covered elsewhere)</option>
									<option id='Clerical and Office Support Workers (not covered elsewhere)'>Clerical and Office Support Workers (not covered elsewhere)</option>
									<option id='Clerks (Accounting)'>Clerks (Accounting)</option>
									<option id='Clerks (Betting)'>Clerks (Betting)</option>
									<option id='Clerks (Court and Legal)'>Clerks (Court and Legal)</option>
									<option id='Clerks (Filing and Registry)'>Clerks (Filing and Registry)</option>
									<option id='Clerks (General)'>Clerks (General)</option>
									<option id='Clerks (Human Resource)'>Clerks (Human Resource)</option>
									<option id='Clerks (Inquiry)'>Clerks (Inquiry)</option>
									<option id='Clerks (Insurance, Money Market and Statistical)'>Clerks (Insurance, Money Market and Statistical)</option>
									<option id='Clerks (Payroll)'>Clerks (Payroll)</option>
									<option id='Clerks (Purchasing and Supply Logistics)'>Clerks (Purchasing and Supply Logistics)</option>
									<option id='Clerks (Transport and Despatch)'>Clerks (Transport and Despatch)</option>
									<option id='Clerks of Court'>Clerks of Court</option>
									<option id='Climatologists (Meteorologists)'>Climatologists (Meteorologists)</option>
									<option id='Clinical Coders'>Clinical Coders</option>
									<option id='Clinical Haematologists'>Clinical Haematologists</option>
									<option id='Clinical Psychologists'>Clinical Psychologists</option>
									<option id='Clothing Patternmakers'>Clothing Patternmakers</option>
									<option id='Clothing Trades Workers'>Clothing Trades Workers</option>
									<option id='Club Managers'>Club Managers</option>
									<option id='Coaches (Sports)'>Coaches (Sports)</option>
									<option id='Commercial Cleaners'>Commercial Cleaners</option>
									<option id='Commercial Housekeepers'>Commercial Housekeepers</option>
									<option id='Commissioned Defence Force Officers'>Commissioned Defence Force Officers</option>
									<option id='Commissioned Fire Officers'>Commissioned Fire Officers</option>
									<option id='Commissioned Officers (Management)'>Commissioned Officers (Management)</option>
									<option id='Commissioned Police Officers'>Commissioned Police Officers</option>
									<option id='Commodities Traders'>Commodities Traders</option>
									<option id='Communications Managers'>Communications Managers</option>
									<option id='Communications Operators'>Communications Operators</option>
									<option id='Communications Technician'>Communications Technician</option>
									<option id='Communications Trades Workers'>Communications Trades Workers</option>
									<option id='Community Arts Workers'>Community Arts Workers</option>
									<option id='Community Health Worker'>Community Health Worker</option>
									<option id='Community Workers'>Community Workers</option>
									<option id='Company Secretaries'>Company Secretaries</option>
									<option id='Complementary Health Therapists'>Complementary Health Therapists</option>
									<option id='Composers'>Composers</option>
									<option id='Computer Network and Systems Engineers'>Computer Network and Systems Engineers</option>
									<option id='Computer Network Professionals'>Computer Network Professionals</option>
									<option id='Concierges (Hotel Service Managers)'>Concierges (Hotel Service Managers)</option>
									<option id='Concrete Batching Plant Operators'>Concrete Batching Plant Operators</option>
									<option id='Concrete Products Machine Operators'>Concrete Products Machine Operators</option>
									<option id='Concrete Pump Operators'>Concrete Pump Operators</option>
									<option id='Concreters'>Concreters</option>
									<option id='Conductors (Transport)'>Conductors (Transport)</option>
									<option id='Confectionery Makers'>Confectionery Makers</option>
									<option id='Conference and Event Organisers'>Conference and Event Organisers</option>
									<option id='Conservation Officers'>Conservation Officers</option>
									<option id='Conservators'>Conservators</option>
									<option id='Construction Estimators'>Construction Estimators</option>
									<option id='Construction Managers'>Construction Managers</option>
									<option id='Construction Plant Operators'>Construction Plant Operators</option>
									<option id='Construction Project Managers'>Construction Project Managers</option>
									<option id='Construction Riggers'>Construction Riggers</option>
									<option id='Construction Workers'>Construction Workers</option>
									<option id='Container Fillers'>Container Fillers</option>
									<option id='Contract Administrators'>Contract Administrators</option>
									<option id='Contract, Program and Project Administrators'>Contract, Program and Project Administrators</option>
									<option id='Conveyancers'>Conveyancers</option>
									<option id='Conveyancers and Legal Executives'>Conveyancers and Legal Executives</option>
									<option id='Cooks'>Cooks</option>
									<option id='Cooks (Fast Food)'>Cooks (Fast Food)</option>
									<option id='Copywriters'>Copywriters</option>
									<option id='Coremakers'>Coremakers</option>
									<option id='Corporate General Managers'>Corporate General Managers</option>
									<option id='Corporate Services Managers'>Corporate Services Managers</option>
									<option id='Corporate Treasurers'>Corporate Treasurers</option>
									<option id='Correctional Officers'>Correctional Officers</option>
									<option id='Cost Clerks'>Cost Clerks</option>
									<option id='Costume Designers (Fashion Designers)'>Costume Designers (Fashion Designers)</option>
									<option id='Cotton Growers'>Cotton Growers</option>
									<option id='Councillor'>Councillor</option>
									<option id='Counselling Psychologists (Other Psychologists)'>Counselling Psychologists (Other Psychologists)</option>
									<option id='Counsellors'>Counsellors</option>
									<option id='Couriers'>Couriers</option>
									<option id='Couriers and Postal Deliverers'>Couriers and Postal Deliverers</option>
									<option id='Court and Legal Clerks'>Court and Legal Clerks</option>
									<option id='Court Bailiffs and Sheriffs'>Court Bailiffs and Sheriffs</option>
									<option id='Court Clerks'>Court Clerks</option>
									<option id='Court Orderlies'>Court Orderlies</option>
									<option id='Crane Chasers'>Crane Chasers</option>
									<option id='Crane, Hoist and Lift Operators'>Crane, Hoist and Lift Operators</option>
									<option id='Creative Director (Advertising)'>Creative Director (Advertising)</option>
									<option id='Credit and Loans Officers'>Credit and Loans Officers</option>
									<option id='Criminologist (Other Social Professionals)'>Criminologist (Other Social Professionals)</option>
									<option id='Crop Farm Workers'>Crop Farm Workers</option>
									<option id='Crop Farmers'>Crop Farmers</option>
									<option id='Crossing Supervisors'>Crossing Supervisors</option>
									<option id='Croupiers'>Croupiers</option>
									<option id='Crowd Controllers'>Crowd Controllers</option>
									<option id='Curators'>Curators</option>
									<option id='Customer Service Managers'>Customer Service Managers</option>
									<option id='Customs Brokers'>Customs Brokers</option>
									<option id='Customs Officers'>Customs Officers</option>
									<option id='Dairy Cattle Farm Workers'>Dairy Cattle Farm Workers</option>
									<option id='Dairy Cattle Farmers'>Dairy Cattle Farmers</option>
									<option id='Dairy Products Makers'>Dairy Products Makers</option>
									<option id='Dance Teachers (Private Tuition)'>Dance Teachers (Private Tuition)</option>
									<option id='Dancers and Choreographers'>Dancers and Choreographers</option>
									<option id='Data Entry Operators'>Data Entry Operators</option>
									<option id='Database & Systems Administrators & ICT Security'>Database & Systems Administrators & ICT Security</option>
									<option id='Database Administrators'>Database Administrators</option>
									<option id='Dealers (Financial)'>Dealers (Financial)</option>
									<option id='Debt Collectors'>Debt Collectors</option>
									<option id='Deck and Fishing Hands'>Deck and Fishing Hands</option>
									<option id='Deck Hands'>Deck Hands</option>
									<option id='Deck Officers'>Deck Officers</option>
									<option id='Deer Farmers'>Deer Farmers</option>
									<option id='Defence Force Members - Other Ranks'>Defence Force Members - Other Ranks</option>
									<option id='Defence Force Senior Officers'>Defence Force Senior Officers</option>
									<option id='Delivery Drivers'>Delivery Drivers</option>
									<option id='Demonstrators (Sales)'>Demonstrators (Sales)</option>
									<option id='Dental Assistants'>Dental Assistants</option>
									<option id='Dental Hygienists'>Dental Hygienists</option>
									<option id='Dental Hygienists, Technicians and Therapists'>Dental Hygienists, Technicians and Therapists</option>
									<option id='Dental Practitioners'>Dental Practitioners</option>
									<option id='Dental Prosthetists'>Dental Prosthetists</option>
									<option id='Dental Specialists (including Orthodontists)'>Dental Specialists (including Orthodontists)</option>
									<option id='Dental Technicians'>Dental Technicians</option>
									<option id='Dental Therapists'>Dental Therapists</option>
									<option id='Dentists'>Dentists</option>
									<option id='Dermatologists'>Dermatologists</option>
									<option id='Designers (Fashion, Industrial and Jewellery)'>Designers (Fashion, Industrial and Jewellery)</option>
									<option id='Designers (Graphic and Web)'>Designers (Graphic and Web)</option>
									<option id='Designers (Interior)'>Designers (Interior)</option>
									<option id='Despatch Clerks'>Despatch Clerks</option>
									<option id='Despatching and Receiving Clerks'>Despatching and Receiving Clerks</option>
									<option id='Detailers'>Detailers</option>
									<option id='Detectives'>Detectives</option>
									<option id='Developer Programmers'>Developer Programmers</option>
									<option id='Development Managers'>Development Managers</option>
									<option id='Diagnostic and Interventional Radiologists'>Diagnostic and Interventional Radiologists</option>
									<option id='Die Setters'>Die Setters</option>
									<option id='Diesel Motor Mechanics'>Diesel Motor Mechanics</option>
									<option id='Dietitians'>Dietitians</option>
									<option id='Directors (Child Care)'>Directors (Child Care)</option>
									<option id='Directors (Film, Television, Radio or Stage)'>Directors (Film, Television, Radio or Stage)</option>
									<option id='Directors of Nursing'>Directors of Nursing</option>
									<option id='Disabilities Services Officers'>Disabilities Services Officers</option>
									<option id='Disabled Carers'>Disabled Carers</option>
									<option id='Disk Jockeys (Nightclub)'>Disk Jockeys (Nightclub)</option>
									<option id='Disk Jockeys (Radio)'>Disk Jockeys (Radio)</option>
									<option id='Dispensary Technicians'>Dispensary Technicians</option>
									<option id='Divers'>Divers</option>
									<option id='Diversional Therapists'>Diversional Therapists</option>
									<option id='Doctors (Generalists)'>Doctors (Generalists)</option>
									<option id='Dog and Horse Racing Officials'>Dog and Horse Racing Officials</option>
									<option id='Dog Handlers and Trainers'>Dog Handlers and Trainers</option>
									<option id='Dogmen (Crane Chasers)'>Dogmen (Crane Chasers)</option>
									<option id='Domestic Cleaners'>Domestic Cleaners</option>
									<option id='Domestic Housekeepers'>Domestic Housekeepers</option>
									<option id='Doorpersons and Luggage Porters'>Doorpersons and Luggage Porters</option>
									<option id='Door-to-door Salespersons'>Door-to-door Salespersons</option>
									<option id='Draftspersons (Civil Engineering)'>Draftspersons (Civil Engineering)</option>
									<option id='Draftspersons (Electrical Engineering )'>Draftspersons (Electrical Engineering )</option>
									<option id='Draftspersons (Electronic Engineering )'>Draftspersons (Electronic Engineering )</option>
									<option id='Draftspersons (Mechanical Engineering )'>Draftspersons (Mechanical Engineering )</option>
									<option id='Drainage, Sewerage and Stormwater Labourers'>Drainage, Sewerage and Stormwater Labourers</option>
									<option id='Drainers'>Drainers</option>
									<option id='Drama Teachers (Private Tuition)'>Drama Teachers (Private Tuition)</option>
									<option id='Dressmakers and Tailors'>Dressmakers and Tailors</option>
									<option id='Drillers'>Drillers</option>
									<option id='Driller's Assistants'>Driller's Assistants</option>
									<option id='Drillers, Miners and Shot Firers'>Drillers, Miners and Shot Firers</option>
									<option id='Drivers (Automobile)'>Drivers (Automobile)</option>
									<option id='Drivers (Bus and Coach)'>Drivers (Bus and Coach)</option>
									<option id='Drivers (Delivery)'>Drivers (Delivery)</option>
									<option id='Drivers (Forklift)'>Drivers (Forklift)</option>
									<option id='Drivers (Train and Tram)'>Drivers (Train and Tram)</option>
									<option id='Drivers (Truck)'>Drivers (Truck)</option>
									<option id='Driveway Attendants'>Driveway Attendants</option>
									<option id='Driving Instructors'>Driving Instructors</option>
									<option id='Drug and Alcohol Counsellors'>Drug and Alcohol Counsellors</option>
									<option id='Drycleaners'>Drycleaners</option>
									<option id='Ear, Nose and Throat Specialists'>Ear, Nose and Throat Specialists</option>
									<option id='Early Childhood (Pre-primary School) Teachers'>Early Childhood (Pre-primary School) Teachers</option>
									<option id='Earth Science Technicians'>Earth Science Technicians</option>
									<option id='Earthmoving Labourers'>Earthmoving Labourers</option>
									<option id='Earthmoving Plant Operators'>Earthmoving Plant Operators</option>
									<option id='Earthmoving Plant Operators (General)'>Earthmoving Plant Operators (General)</option>
									<option id='Ecologists (Environmental Scientists)'>Ecologists (Environmental Scientists)</option>
									<option id='Economists'>Economists</option>
									<option id='Editors (Book and Script)'>Editors (Book and Script)</option>
									<option id='Education Advisers'>Education Advisers</option>
									<option id='Education Advisers and Reviewers'>Education Advisers and Reviewers</option>
									<option id='Education Aides'>Education Aides</option>
									<option id='Education Managers (not covered elsewhere)'>Education Managers (not covered elsewhere)</option>
									<option id='Education Reviewers'>Education Reviewers</option>
									<option id='Educational Psychologists'>Educational Psychologists</option>
									<option id='Electorate Officers'>Electorate Officers</option>
									<option id='Electrical and Telecommunications Trades Assistants'>Electrical and Telecommunications Trades Assistants</option>
									<option id='Electrical Distribution Trades Workers'>Electrical Distribution Trades Workers</option>
									<option id='Electrical Engineering Draftspersons'>Electrical Engineering Draftspersons</option>
									<option id='Electrical Engineering Draftspersons, Technicians'>Electrical Engineering Draftspersons, Technicians</option>
									<option id='Electrical Engineering Technicians'>Electrical Engineering Technicians</option>
									<option id='Electrical Engineers'>Electrical Engineers</option>
									<option id='Electrical Linesworkers'>Electrical Linesworkers</option>
									<option id='Electricians'>Electricians</option>
									<option id='Electricians (General)'>Electricians (General)</option>
									<option id='Electricians (Special Class)'>Electricians (Special Class)</option>
									<option id='Electronic Engineering Draftspersons'>Electronic Engineering Draftspersons</option>
									<option id='Electronic Engineering Draftspersons, Technicians'>Electronic Engineering Draftspersons, Technicians</option>
									<option id='Electronic Engineering Technicians'>Electronic Engineering Technicians</option>
									<option id='Electronic Equipment Trades Workers'>Electronic Equipment Trades Workers</option>
									<option id='Electronic Instrument Trades Workers (General)'>Electronic Instrument Trades Workers (General)</option>
									<option id='Electronic Instrument Trades Workers (Special Class)'>Electronic Instrument Trades Workers (Special Class)</option>
									<option id='Electronics Engineers'>Electronics Engineers</option>
									<option id='Electronics Trades Workers'>Electronics Trades Workers</option>
									<option id='Electroplaters'>Electroplaters</option>
									<option id='Emergency Medicine Specialists'>Emergency Medicine Specialists</option>
									<option id='Emergency Service Workers'>Emergency Service Workers</option>
									<option id='Employment Consultants'>Employment Consultants</option>
									<option id='Endocrinologists'>Endocrinologists</option>
									<option id='Engineering Managers'>Engineering Managers</option>
									<option id='Engineering Patternmakers'>Engineering Patternmakers</option>
									<option id='Engineering Production Workers'>Engineering Production Workers</option>
									<option id='Engineering Professionals (not covered elsewhere)'>Engineering Professionals (not covered elsewhere)</option>
									<option id='Engineering Technologists'>Engineering Technologists</option>
									<option id='Engineers (Chemical and Material)'>Engineers (Chemical and Material)</option>
									<option id='Engineers (Civil)'>Engineers (Civil)</option>
									<option id='Engineers (Electrical)'>Engineers (Electrical)</option>
									<option id='Engineers (Electronics)'>Engineers (Electronics)</option>
									<option id='Engineers (Industrial, Mechanical & Production)'>Engineers (Industrial, Mechanical & Production)</option>
									<option id='Engineers (Mining)'>Engineers (Mining)</option>
									<option id='Engineers (Other)'>Engineers (Other)</option>
									<option id='Engineers (Telecommunications)'>Engineers (Telecommunications)</option>
									<option id='English as a Second Language Teachers'>English as a Second Language Teachers</option>
									<option id='Engravers'>Engravers</option>
									<option id='Enrolled and Mothercraft Nurses'>Enrolled and Mothercraft Nurses</option>
									<option id='Enrolled Nurses'>Enrolled Nurses</option>
									<option id='Entertainers and Variety Artists'>Entertainers and Variety Artists</option>
									<option id='Entertainment Centre Managers'>Entertainment Centre Managers</option>
									<option id='Environmental Consultants'>Environmental Consultants</option>
									<option id='Environmental Engineers'>Environmental Engineers</option>
									<option id='Environmental Health Officers'>Environmental Health Officers</option>
									<option id='Environmental Managers'>Environmental Managers</option>
									<option id='Environmental Research Scientists'>Environmental Research Scientists</option>
									<option id='Environmental Scientists'>Environmental Scientists</option>
									<option id='Equipment Hire Managers'>Equipment Hire Managers</option>
									<option id='Event Managers'>Event Managers</option>
									<option id='Event Organisers'>Event Organisers</option>
									<option id='Examination Supervisors'>Examination Supervisors</option>
									<option id='Excavator Operators'>Excavator Operators</option>
									<option id='Exercise Physiologists'>Exercise Physiologists</option>
									<option id='Exhaust and Muffler Repairers'>Exhaust and Muffler Repairers</option>
									<option id='Exporters'>Exporters</option>
									<option id='External Auditors'>External Auditors</option>
									<option id='Eye Specialists'>Eye Specialists</option>
									<option id='Eye Surgeon'>Eye Surgeon</option>
									<option id='Fabric and Textile Factory Workers'>Fabric and Textile Factory Workers</option>
									<option id='Facilities Administrators'>Facilities Administrators</option>
									<option id='Facilities Managers'>Facilities Managers</option>
									<option id='Factory Process Workers (not covered elsewhere)'>Factory Process Workers (not covered elsewhere)</option>
									<option id='Factory Workers (Food and Drink)'>Factory Workers (Food and Drink)</option>
									<option id='Factory Workers (Plastics and Rubber)'>Factory Workers (Plastics and Rubber)</option>
									<option id='Faculty Heads'>Faculty Heads</option>
									<option id='Family and Marriage Counsellors'>Family and Marriage Counsellors</option>
									<option id='Family Day Care Workers'>Family Day Care Workers</option>
									<option id='Family Support Workers'>Family Support Workers</option>
									<option id='Farm Workers (Crops)'>Farm Workers (Crops)</option>
									<option id='Farm Workers (Livestock)'>Farm Workers (Livestock)</option>
									<option id='Farm Workers (Mixed Crop and Livestock)'>Farm Workers (Mixed Crop and Livestock)</option>
									<option id='Farm, Forestry and Garden Workers (not covered elsewhere)'>Farm, Forestry and Garden Workers (not covered elsewhere)</option>
									<option id='Farmers (Aquaculture)'>Farmers (Aquaculture)</option>
									<option id='Farmers (Crops)'>Farmers (Crops)</option>
									<option id='Farmers (Livestock)'>Farmers (Livestock)</option>
									<option id='Farmers (Mixed Crop and Livestock)'>Farmers (Mixed Crop and Livestock)</option>
									<option id='Farriers'>Farriers</option>
									<option id='Fashion Designers'>Fashion Designers</option>
									<option id='Fashion, Industrial and Jewellery Designers'>Fashion, Industrial and Jewellery Designers</option>
									<option id='Fast Food Cooks'>Fast Food Cooks</option>
									<option id='Fencers'>Fencers</option>
									<option id='Fettlers'>Fettlers</option>
									<option id='Fibreglass Laminators'>Fibreglass Laminators</option>
									<option id='Fibrous Plasterers'>Fibrous Plasterers</option>
									<option id='Filing and Registry Clerks'>Filing and Registry Clerks</option>
									<option id='Film and Video Editors'>Film and Video Editors</option>
									<option id='Film Producers'>Film Producers</option>
									<option id='Film, Television, Radio and Stage Directors'>Film, Television, Radio and Stage Directors</option>
									<option id='Finance Brokers'>Finance Brokers</option>
									<option id='Finance Managers'>Finance Managers</option>
									<option id='Financial Brokers'>Financial Brokers</option>
									<option id='Financial Controllers'>Financial Controllers</option>
									<option id='Financial Dealers'>Financial Dealers</option>
									<option id='Financial Institution Branch Manager'>Financial Institution Branch Manager</option>
									<option id='Financial Investment Advisers'>Financial Investment Advisers</option>
									<option id='Financial Investment Advisers and Managers'>Financial Investment Advisers and Managers</option>
									<option id='Financial Investment Managers'>Financial Investment Managers</option>
									<option id='Financial Market Dealers'>Financial Market Dealers</option>
									<option id='Fire and Emergency Workers'>Fire and Emergency Workers</option>
									<option id='Fire Fighters'>Fire Fighters</option>
									<option id='Fire Protection Equipment Technicians'>Fire Protection Equipment Technicians</option>
									<option id='First Aid Trainers'>First Aid Trainers</option>
									<option id='Fisheries Officers'>Fisheries Officers</option>
									<option id='Fishing Guides'>Fishing Guides</option>
									<option id='Fishing Hands'>Fishing Hands</option>
									<option id='Fitness Centre Managers'>Fitness Centre Managers</option>
									<option id='Fitness Instructors'>Fitness Instructors</option>
									<option id='Fitter and Turners'>Fitter and Turners</option>
									<option id='Fitters (General)'>Fitters (General)</option>
									<option id='Fitter's Assistants'>Fitter's Assistants</option>
									<option id='Fitter-Welders'>Fitter-Welders</option>
									<option id='Fleet Managers'>Fleet Managers</option>
									<option id='Flight Attendants'>Flight Attendants</option>
									<option id='Floor Finishers'>Floor Finishers</option>
									<option id='Floor Tilers'>Floor Tilers</option>
									<option id='Florists'>Florists</option>
									<option id='Flower Growers'>Flower Growers</option>
									<option id='Flying Instructors'>Flying Instructors</option>
									<option id='Food and Beverage Attendants'>Food and Beverage Attendants</option>
									<option id='Food and Beverage Managers'>Food and Beverage Managers</option>
									<option id='Food and Drink Factory Workers'>Food and Drink Factory Workers</option>
									<option id='Food and Wine Scientists'>Food and Wine Scientists</option>
									<option id='Food Scientists'>Food Scientists</option>
									<option id='Food Technologists'>Food Technologists</option>
									<option id='Food Trades Assistants'>Food Trades Assistants</option>
									<option id='Footballers (Soccer, Rugby and AFL)'>Footballers (Soccer, Rugby and AFL)</option>
									<option id='Footwear Factory Workers'>Footwear Factory Workers</option>
									<option id='Footwear Production Machine Operators'>Footwear Production Machine Operators</option>
									<option id='Forensic Psychologists (Clinical Psychologists)'>Forensic Psychologists (Clinical Psychologists)</option>
									<option id='Forest Managers'>Forest Managers</option>
									<option id='Foresters'>Foresters</option>
									<option id='Forestry and Logging Workers'>Forestry and Logging Workers</option>
									<option id='Forestry Workers'>Forestry Workers</option>
									<option id='Forklift Drivers'>Forklift Drivers</option>
									<option id='Freight and Furniture Handlers'>Freight and Furniture Handlers</option>
									<option id='Freight Handlers (Rail or Road)'>Freight Handlers (Rail or Road)</option>
									<option id='Fruit and Nut Farm Workers'>Fruit and Nut Farm Workers</option>
									<option id='Fruit and Nut Growers'>Fruit and Nut Growers</option>
									<option id='Fruit and Nut Pickers'>Fruit and Nut Pickers</option>
									<option id='Fruit and Vegetable Factory Workers'>Fruit and Vegetable Factory Workers</option>
									<option id='Fruit and Vegetable Packers'>Fruit and Vegetable Packers</option>
									<option id='Funeral Directors'>Funeral Directors</option>
									<option id='Funeral Workers'>Funeral Workers</option>
									<option id='Funeral Workers (Other)'>Funeral Workers (Other)</option>
									<option id='Furniture Finishers'>Furniture Finishers</option>
									<option id='Furniture Removalist Drivers'>Furniture Removalist Drivers</option>
									<option id='Furniture Removalist's Assistants'>Furniture Removalist's Assistants</option>
									<option id='Futures Traders'>Futures Traders</option>
									<option id='Gallery and Museum Curators'>Gallery and Museum Curators</option>
									<option id='Gallery and Museum Guides'>Gallery and Museum Guides</option>
									<option id='Gallery and Museum Technicians'>Gallery and Museum Technicians</option>
									<option id='Gallery, Library and Museum Technicians'>Gallery, Library and Museum Technicians</option>
									<option id='Gallery, Museum and Tour Guides'>Gallery, Museum and Tour Guides</option>
									<option id='Game and Multimedia Developers'>Game and Multimedia Developers</option>
									<option id='Game Developers (Electronic)'>Game Developers (Electronic)</option>
									<option id='Gaming Workers'>Gaming Workers</option>
									<option id='Garbage Collectors'>Garbage Collectors</option>
									<option id='Garden and Nursery Labourers'>Garden and Nursery Labourers</option>
									<option id='Garden Labourers'>Garden Labourers</option>
									<option id='Gardeners'>Gardeners</option>
									<option id='Gardeners (General)'>Gardeners (General)</option>
									<option id='Gas and Petroleum Operators'>Gas and Petroleum Operators</option>
									<option id='Gas Plant Operators'>Gas Plant Operators</option>
									<option id='Gasfitters'>Gasfitters</option>
									<option id='Gastroenterologists'>Gastroenterologists</option>
									<option id='General Clerks'>General Clerks</option>
									<option id='General Managers'>General Managers</option>
									<option id='General Practitioners'>General Practitioners</option>
									<option id='General Practitioners and Resident Medical Officers'>General Practitioners and Resident Medical Officers</option>
									<option id='Genetic Counsellors (and Other Health Professionals not covered elsewhere)'>Genetic Counsellors (and Other Health Professionals not covered elsewhere)</option>
									<option id='Geographer (Other Social Professionals)'>Geographer (Other Social Professionals)</option>
									<option id='Geologists'>Geologists</option>
									<option id='Geologists, Geophysicists and Hydrogeologists'>Geologists, Geophysicists and Hydrogeologists</option>
									<option id='Geophysicists'>Geophysicists</option>
									<option id='Geotechnical Engineers'>Geotechnical Engineers</option>
									<option id='Glass Makers'>Glass Makers</option>
									<option id='Glass Processing Workers'>Glass Processing Workers</option>
									<option id='Glass Production Machine Operators'>Glass Production Machine Operators</option>
									<option id='Glaziers'>Glaziers</option>
									<option id='Goat Farmers'>Goat Farmers</option>
									<option id='Golfers'>Golfers</option>
									<option id='Grader Operators'>Grader Operators</option>
									<option id='Grain Mill Workers'>Grain Mill Workers</option>
									<option id='Grain, Oilseed and Pasture Farm Workers'>Grain, Oilseed and Pasture Farm Workers</option>
									<option id='Grain, Oilseed and Pasture Growers'>Grain, Oilseed and Pasture Growers</option>
									<option id='Grape Growers'>Grape Growers</option>
									<option id='Graphic and Web Designers, and Illustrators'>Graphic and Web Designers, and Illustrators</option>
									<option id='Graphic Designers'>Graphic Designers</option>
									<option id='Graphic Pre-press Trades Workers'>Graphic Pre-press Trades Workers</option>
									<option id='Greenkeepers'>Greenkeepers</option>
									<option id='Group Leaders (Child Care)'>Group Leaders (Child Care)</option>
									<option id='Guides (Outdoor Adventure)'>Guides (Outdoor Adventure)</option>
									<option id='Gunsmiths'>Gunsmiths</option>
									<option id='Gymnastics Coaches and Instructors'>Gymnastics Coaches and Instructors</option>
									<option id='Gynaecologist and Obstetricians'>Gynaecologist and Obstetricians</option>
									<option id='Hair and Beauty Salon Assistants'>Hair and Beauty Salon Assistants</option>
									<option id='Hair and Beauty Salon Managers'>Hair and Beauty Salon Managers</option>
									<option id='Hairdressers'>Hairdressers</option>
									<option id='Handypersons'>Handypersons</option>
									<option id='Hardware Technicians'>Hardware Technicians</option>
									<option id='Health and Welfare Services Managers'>Health and Welfare Services Managers</option>
									<option id='Health Diagnostic and Promotion Professionals (not covered elsewhere)'>Health Diagnostic and Promotion Professionals (not covered elsewhere)</option>
									<option id='Health Educator'>Health Educator</option>
									<option id='Health Information Managers'>Health Information Managers</option>
									<option id='Health Practice Managers'>Health Practice Managers</option>
									<option id='Health Promotion Officers'>Health Promotion Officers</option>
									<option id='Helicopter Pilots'>Helicopter Pilots</option>
									<option id='Herbalists (Western)'>Herbalists (Western)</option>
									<option id='Hide and Skin Processing Machine Operators'>Hide and Skin Processing Machine Operators</option>
									<option id='Hide and Skin Processing Workers'>Hide and Skin Processing Workers</option>
									<option id='High School Teacher (Secondary School)'>High School Teacher (Secondary School)</option>
									<option id='Historians'>Historians</option>
									<option id='Home Improvement Installers'>Home Improvement Installers</option>
									<option id='Homoeopaths'>Homoeopaths</option>
									<option id='Horse Breeders'>Horse Breeders</option>
									<option id='Horse Riding Coaches and Instructors'>Horse Riding Coaches and Instructors</option>
									<option id='Horse Trainers'>Horse Trainers</option>
									<option id='Horticultural Nursery Assistant'>Horticultural Nursery Assistant</option>
									<option id='Hospital orderlies'>Hospital orderlies</option>
									<option id='Hospital Pharmacists'>Hospital Pharmacists</option>
									<option id='Hospital Ward Clerks'>Hospital Ward Clerks</option>
									<option id='Hospitality Workers (not covered elsewhere)'>Hospitality Workers (not covered elsewhere)</option>
									<option id='Hospitality, Retail and Service Managers (not covered elsewhere)'>Hospitality, Retail and Service Managers (not covered elsewhere)</option>
									<option id='Hostel Parents'>Hostel Parents</option>
									<option id='Hotel and Motel Managers'>Hotel and Motel Managers</option>
									<option id='Hotel and Motel Receptionists'>Hotel and Motel Receptionists</option>
									<option id='Hotel Service Managers'>Hotel Service Managers</option>
									<option id='Housekeepers'>Housekeepers</option>
									<option id='Human Resource Advisers'>Human Resource Advisers</option>
									<option id='Human Resource Clerks'>Human Resource Clerks</option>
									<option id='Human Resource Managers'>Human Resource Managers</option>
									<option id='Human Resource Professionals'>Human Resource Professionals</option>
									<option id='Hunter-Trappers'>Hunter-Trappers</option>
									<option id='Hunting Guides'>Hunting Guides</option>
									<option id='Hydrogeologists'>Hydrogeologists</option>
									<option id='Hydrographers'>Hydrographers</option>
									<option id='ICT Account Managers'>ICT Account Managers</option>
									<option id='ICT Business Analysts'>ICT Business Analysts</option>
									<option id='ICT Business and Systems Analysts'>ICT Business and Systems Analysts</option>
									<option id='ICT Business Development Managers'>ICT Business Development Managers</option>
									<option id='ICT Customer Support Officers'>ICT Customer Support Officers</option>
									<option id='ICT Managers'>ICT Managers</option>
									<option id='ICT Project Managers'>ICT Project Managers</option>
									<option id='ICT Quality Assurance Engineers'>ICT Quality Assurance Engineers</option>
									<option id='ICT Sales Assistants'>ICT Sales Assistants</option>
									<option id='ICT Sales Professionals'>ICT Sales Professionals</option>
									<option id='ICT Sales Representatives'>ICT Sales Representatives</option>
									<option id='ICT Security Specialists'>ICT Security Specialists</option>
									<option id='ICT Support and Test Engineers'>ICT Support and Test Engineers</option>
									<option id='ICT Support Engineers'>ICT Support Engineers</option>
									<option id='ICT Support Technicians'>ICT Support Technicians</option>
									<option id='ICT Systems Test Engineers'>ICT Systems Test Engineers</option>
									<option id='ICT Trainers'>ICT Trainers</option>
									<option id='Illustrators (including Animators)'>Illustrators (including Animators)</option>
									<option id='Immigration Officers'>Immigration Officers</option>
									<option id='Importers and Exporters'>Importers and Exporters</option>
									<option id='Importers, Exporters and Wholesalers'>Importers, Exporters and Wholesalers</option>
									<option id='Import-Export Clerks'>Import-Export Clerks</option>
									<option id='Indigenous Health Workers'>Indigenous Health Workers</option>
									<option id='Industrial Designers'>Industrial Designers</option>
									<option id='Industrial Engineers'>Industrial Engineers</option>
									<option id='Industrial Pharmacists'>Industrial Pharmacists</option>
									<option id='Industrial Psychologist'>Industrial Psychologist</option>
									<option id='Industrial Spraypainters'>Industrial Spraypainters</option>
									<option id='Industrial, Mechanical and Production Engineers'>Industrial, Mechanical and Production Engineers</option>
									<option id='Information and Organisation Professionals (not covered elsewhere)'>Information and Organisation Professionals (not covered elsewhere)</option>
									<option id='Information Officers'>Information Officers</option>
									<option id='Inspectors and Regulatory Officers'>Inspectors and Regulatory Officers</option>
									<option id='Insulation and Home Improvement Installers'>Insulation and Home Improvement Installers</option>
									<option id='Insurance Agents'>Insurance Agents</option>
									<option id='Insurance Brokers'>Insurance Brokers</option>
									<option id='Insurance Consultants'>Insurance Consultants</option>
									<option id='Insurance Investigators'>Insurance Investigators</option>
									<option id='Insurance Investigators, Loss Adjusters and Risk Surveyors'>Insurance Investigators, Loss Adjusters and Risk Surveyors</option>
									<option id='Insurance Loss Adjusters'>Insurance Loss Adjusters</option>
									<option id='Insurance Risk Surveyors'>Insurance Risk Surveyors</option>
									<option id='Insurance, Money Market and Statistical Clerks'>Insurance, Money Market and Statistical Clerks</option>
									<option id='Integration Aides'>Integration Aides</option>
									<option id='Intellectual Property Lawyers'>Intellectual Property Lawyers</option>
									<option id='Intelligence and Policy Analysts'>Intelligence and Policy Analysts</option>
									<option id='Intelligence Officers'>Intelligence Officers</option>
									<option id='Intensive Care Ambulance Paramedics'>Intensive Care Ambulance Paramedics</option>
									<option id='Intensive Care Specialists'>Intensive Care Specialists</option>
									<option id='Interior Decorators'>Interior Decorators</option>
									<option id='Interior Designers'>Interior Designers</option>
									<option id='Internal Auditors'>Internal Auditors</option>
									<option id='Interpreters'>Interpreters</option>
									<option id='Interviewers (Surveys)'>Interviewers (Surveys)</option>
									<option id='Investment Advisers'>Investment Advisers</option>
									<option id='Ironers and Pressers'>Ironers and Pressers</option>
									<option id='Janitors'>Janitors</option>
									<option id='Jewellers'>Jewellers</option>
									<option id='Jewellery Designers'>Jewellery Designers</option>
									<option id='Jockeys'>Jockeys</option>
									<option id='Joiners'>Joiners</option>
									<option id='Journalists and Other Writers'>Journalists and Other Writers</option>
									<option id='Judges'>Judges</option>
									<option id='Judicial and Other Legal Professionals'>Judicial and Other Legal Professionals</option>
									<option id='Judicial and Other Legal Professionals (not covered elsewhere)'>Judicial and Other Legal Professionals (not covered elsewhere)</option>
									<option id='Kennel Hands'>Kennel Hands</option>
									<option id='Keyboard Operators'>Keyboard Operators</option>
									<option id='Kindergarten Teachers (Early Childhood)'>Kindergarten Teachers (Early Childhood)</option>
									<option id='Kitchenhands'>Kitchenhands</option>
									<option id='Knitting Machine Operators'>Knitting Machine Operators</option>
									<option id='Laboratory Managers'>Laboratory Managers</option>
									<option id='Labourers (Building and Plumbing)'>Labourers (Building and Plumbing)</option>
									<option id='Labourers (Garden and Nursery)'>Labourers (Garden and Nursery)</option>
									<option id='Labourers (not covered elsewhere)'>Labourers (not covered elsewhere)</option>
									<option id='Labourers (Paving and Surfacing)'>Labourers (Paving and Surfacing)</option>
									<option id='Labourers (Railway)'>Labourers (Railway)</option>
									<option id='Laggers'>Laggers</option>
									<option id='Land Economists'>Land Economists</option>
									<option id='Land Economists and Valuers'>Land Economists and Valuers</option>
									<option id='Landscape Architects'>Landscape Architects</option>
									<option id='Landscape Gardeners'>Landscape Gardeners</option>
									<option id='Laundry Workers'>Laundry Workers</option>
									<option id='Laundry Workers (General)'>Laundry Workers (General)</option>
									<option id='Law Clerks'>Law Clerks</option>
									<option id='Lawn Mowers'>Lawn Mowers</option>
									<option id='Leaflet and Newspaper Deliverers'>Leaflet and Newspaper Deliverers</option>
									<option id='Leather Goods Makers'>Leather Goods Makers</option>
									<option id='Lecturers and Tutors (University)'>Lecturers and Tutors (University)</option>
									<option id='Legal Clerks'>Legal Clerks</option>
									<option id='Legal Executives'>Legal Executives</option>
									<option id='Legal Secretaries'>Legal Secretaries</option>
									<option id='Legislators'>Legislators</option>
									<option id='Liaison Officers'>Liaison Officers</option>
									<option id='Librarians'>Librarians</option>
									<option id='Library Assistants'>Library Assistants</option>
									<option id='Library Technicians'>Library Technicians</option>
									<option id='Licensed Club Managers'>Licensed Club Managers</option>
									<option id='Life Science Technicians'>Life Science Technicians</option>
									<option id='Life Scientists'>Life Scientists</option>
									<option id='Lifeguards'>Lifeguards</option>
									<option id='Lift Mechanics'>Lift Mechanics</option>
									<option id='Light Technicians'>Light Technicians</option>
									<option id='Linemarkers'>Linemarkers</option>
									<option id='Linesmen'>Linesmen</option>
									<option id='Linespersons (Electrical)'>Linespersons (Electrical)</option>
									<option id='Linespersons (Telecommunications)'>Linespersons (Telecommunications)</option>
									<option id='Linguist (Other Social Professionals)'>Linguist (Other Social Professionals)</option>
									<option id='Livestock Farm Workers'>Livestock Farm Workers</option>
									<option id='Livestock Farmers'>Livestock Farmers</option>
									<option id='Loader Operators'>Loader Operators</option>
									<option id='Loans Officers'>Loans Officers</option>
									<option id='Local Government Legislators'>Local Government Legislators</option>
									<option id='Locksmiths'>Locksmiths</option>
									<option id='Logging Assistants'>Logging Assistants</option>
									<option id='Logging Plant Operators'>Logging Plant Operators</option>
									<option id='Logistics Clerks (Production Clerks)'>Logistics Clerks (Production Clerks)</option>
									<option id='Logistics Managers'>Logistics Managers</option>
									<option id='Loss Adjusters'>Loss Adjusters</option>
									<option id='Lotteries Agents'>Lotteries Agents</option>
									<option id='Machine Operators (Clay, Concrete, Glass & Stone)'>Machine Operators (Clay, Concrete, Glass & Stone)</option>
									<option id='Machine Operators (not covered elsewhere)'>Machine Operators (not covered elsewhere)</option>
									<option id='Machine Operators (Paper and Wood Processing)'>Machine Operators (Paper and Wood Processing)</option>
									<option id='Machine Operators (Plastics and Rubber Production)'>Machine Operators (Plastics and Rubber Production)</option>
									<option id='Machine Operators (Textile & Footwear Production)'>Machine Operators (Textile & Footwear Production)</option>
									<option id='Machine Shorthand Reporters'>Machine Shorthand Reporters</option>
									<option id='Machinists (Metal)'>Machinists (Metal)</option>
									<option id='Machinists (Sewing)'>Machinists (Sewing)</option>
									<option id='Machinists (Wood)'>Machinists (Wood)</option>
									<option id='Magistrates'>Magistrates</option>
									<option id='Mail Clerks'>Mail Clerks</option>
									<option id='Mail Sorters'>Mail Sorters</option>
									<option id='Maintenance Fitters (Fitters)'>Maintenance Fitters (Fitters)</option>
									<option id='Maintenance Planners'>Maintenance Planners</option>
									<option id='Make Up Artists'>Make Up Artists</option>
									<option id='Management Accountants'>Management Accountants</option>
									<option id='Management and Organisation Analysts'>Management and Organisation Analysts</option>
									<option id='Management Consultants'>Management Consultants</option>
									<option id='Managers (Advertising and Sales)'>Managers (Advertising and Sales)</option>
									<option id='Managers (Amusement, Fitness and Sports Centre)'>Managers (Amusement, Fitness and Sports Centre)</option>
									<option id='Managers (Cafe and Restaurant)'>Managers (Cafe and Restaurant)</option>
									<option id='Managers (Caravan Park and Camping Ground)'>Managers (Caravan Park and Camping Ground)</option>
									<option id='Managers (Child Care Centre)'>Managers (Child Care Centre)</option>
									<option id='Managers (Construction)'>Managers (Construction)</option>
									<option id='Managers (Corporate Services)'>Managers (Corporate Services)</option>
									<option id='Managers (Engineering)'>Managers (Engineering)</option>
									<option id='Managers (Finance)'>Managers (Finance)</option>
									<option id='Managers (Health and Welfare Services)'>Managers (Health and Welfare Services)</option>
									<option id='Managers (Hotel and Motel)'>Managers (Hotel and Motel)</option>
									<option id='Managers (Human Resources)'>Managers (Human Resources)</option>
									<option id='Managers (ICT)'>Managers (ICT)</option>
									<option id='Managers (Licenced Club)'>Managers (Licenced Club)</option>
									<option id='Managers (Non-school Education)'>Managers (Non-school Education)</option>
									<option id='Managers (Policy and Planning)'>Managers (Policy and Planning)</option>
									<option id='Managers (Production)'>Managers (Production)</option>
									<option id='Managers (Research and Development)'>Managers (Research and Development)</option>
									<option id='Managers (Retail)'>Managers (Retail)</option>
									<option id='Managers (Supply and Distribution)'>Managers (Supply and Distribution)</option>
									<option id='Managers (Transport Services)'>Managers (Transport Services)</option>
									<option id='Managing Directors'>Managing Directors</option>
									<option id='Manufacturers'>Manufacturers</option>
									<option id='Manufacturing Production Managers'>Manufacturing Production Managers</option>
									<option id='Marine Biologists'>Marine Biologists</option>
									<option id='Marine Engineers'>Marine Engineers</option>
									<option id='Marine Surveyors'>Marine Surveyors</option>
									<option id='Marine Transport Professionals'>Marine Transport Professionals</option>
									<option id='Market Research Analysts'>Market Research Analysts</option>
									<option id='Marketing Managers'>Marketing Managers</option>
									<option id='Marketing Specialists'>Marketing Specialists</option>
									<option id='Massage Therapists'>Massage Therapists</option>
									<option id='Master Fishers'>Master Fishers</option>
									<option id='Materials Engineers'>Materials Engineers</option>
									<option id='Materials Recyclers'>Materials Recyclers</option>
									<option id='Mathematicians'>Mathematicians</option>
									<option id='Meat Boners and Slicers'>Meat Boners and Slicers</option>
									<option id='Meat Boners and Slicers, and Slaughterers'>Meat Boners and Slicers, and Slaughterers</option>
									<option id='Meat Inspectors'>Meat Inspectors</option>
									<option id='Meat Packers'>Meat Packers</option>
									<option id='Meat Process Workers'>Meat Process Workers</option>
									<option id='Meat, Poultry and Seafood Process Workers'>Meat, Poultry and Seafood Process Workers</option>
									<option id='Mechanical Engineering Draftspersons'>Mechanical Engineering Draftspersons</option>
									<option id='Mechanical Engineering Draftspersons, Technicians'>Mechanical Engineering Draftspersons, Technicians</option>
									<option id='Mechanical Engineering Technicians'>Mechanical Engineering Technicians</option>
									<option id='Mechanical Engineers'>Mechanical Engineers</option>
									<option id='Mechanical Fitters (Fitters)'>Mechanical Fitters (Fitters)</option>
									<option id='Mechanic's Assistants'>Mechanic's Assistants</option>
									<option id='Mechatronics Engineers (Engineering Professionals not covered elsewhere)'>Mechatronics Engineers (Engineering Professionals not covered elsewhere)</option>
									<option id='Media Equipment Operators'>Media Equipment Operators</option>
									<option id='Media Producers'>Media Producers</option>
									<option id='Medical Administrators'>Medical Administrators</option>
									<option id='Medical Diagnostic Radiographers'>Medical Diagnostic Radiographers</option>
									<option id='Medical Imaging Professionals'>Medical Imaging Professionals</option>
									<option id='Medical Imaging Technologist'>Medical Imaging Technologist</option>
									<option id='Medical Laboratory Scientists'>Medical Laboratory Scientists</option>
									<option id='Medical Laboratory Technicians'>Medical Laboratory Technicians</option>
									<option id='Medical Oncologists'>Medical Oncologists</option>
									<option id='Medical Practitioners (Generalist)'>Medical Practitioners (Generalist)</option>
									<option id='Medical Practitioners (not covered elsewhere)'>Medical Practitioners (not covered elsewhere)</option>
									<option id='Medical Radiation Therapists'>Medical Radiation Therapists</option>
									<option id='Medical Receptionists'>Medical Receptionists</option>
									<option id='Medical Records Administrators'>Medical Records Administrators</option>
									<option id='Medical Technicians'>Medical Technicians</option>
									<option id='Members of Parliament'>Members of Parliament</option>
									<option id='Merchandisers'>Merchandisers</option>
									<option id='Metal Casting Trades Workers'>Metal Casting Trades Workers</option>
									<option id='Metal Casting, Forging & Finishing Trades'>Metal Casting, Forging & Finishing Trades</option>
									<option id='Metal Engineering Process Workers'>Metal Engineering Process Workers</option>
									<option id='Metal Fabricators'>Metal Fabricators</option>
									<option id='Metal Fitters and Machinists'>Metal Fitters and Machinists</option>
									<option id='Metal Machinists (First Class)'>Metal Machinists (First Class)</option>
									<option id='Metal Polishers'>Metal Polishers</option>
									<option id='Metallurgical and Materials Technicians'>Metallurgical and Materials Technicians</option>
									<option id='Metallurgists'>Metallurgists</option>
									<option id='Meteorologists'>Meteorologists</option>
									<option id='Meter Readers'>Meter Readers</option>
									<option id='Microbiologists'>Microbiologists</option>
									<option id='Middle School Teachers'>Middle School Teachers</option>
									<option id='Midwives'>Midwives</option>
									<option id='Migration Agents'>Migration Agents</option>
									<option id='Milliners'>Milliners</option>
									<option id='Mine Deputys'>Mine Deputys</option>
									<option id='Mine Managers'>Mine Managers</option>
									<option id='Miners'>Miners</option>
									<option id='Mining Engineer (excluding Petroleum)'>Mining Engineer (excluding Petroleum)</option>
									<option id='Mining Engineers'>Mining Engineers</option>
									<option id='Mining Support Workers'>Mining Support Workers</option>
									<option id='Ministers of Religion'>Ministers of Religion</option>
									<option id='Mixed Crop and Livestock Farm Workers'>Mixed Crop and Livestock Farm Workers</option>
									<option id='Mixed Crop and Livestock Farmers'>Mixed Crop and Livestock Farmers</option>
									<option id='Mixed Crop Farmers'>Mixed Crop Farmers</option>
									<option id='Mixed Livestock Farm Workers'>Mixed Livestock Farm Workers</option>
									<option id='Mixed Livestock Farmers'>Mixed Livestock Farmers</option>
									<option id='Mobile Plant Operators (not covered elsewhere)'>Mobile Plant Operators (not covered elsewhere)</option>
									<option id='Models'>Models</option>
									<option id='Models and Sales Demonstrators'>Models and Sales Demonstrators</option>
									<option id='Money Market Clerks'>Money Market Clerks</option>
									<option id='Mortgage Broker'>Mortgage Broker</option>
									<option id='Morticians'>Morticians</option>
									<option id='Motel Managers'>Motel Managers</option>
									<option id='Mothercraft Nurses'>Mothercraft Nurses</option>
									<option id='Motion Picture Projectionists'>Motion Picture Projectionists</option>
									<option id='Motor Mechanics'>Motor Mechanics</option>
									<option id='Motor Mechanics (General)'>Motor Mechanics (General)</option>
									<option id='Motor Vehicle and Caravan Salespersons'>Motor Vehicle and Caravan Salespersons</option>
									<option id='Motor Vehicle and Vehicle Parts Salespersons'>Motor Vehicle and Vehicle Parts Salespersons</option>
									<option id='Motor Vehicle Licence Examiners'>Motor Vehicle Licence Examiners</option>
									<option id='Motor Vehicle Parts and Accessories Fitters'>Motor Vehicle Parts and Accessories Fitters</option>
									<option id='Motor Vehicle Parts and Accessories Fitters (General)'>Motor Vehicle Parts and Accessories Fitters (General)</option>
									<option id='Motor Vehicle Parts Interpreters'>Motor Vehicle Parts Interpreters</option>
									<option id='Motorcycle Mechanics'>Motorcycle Mechanics</option>
									<option id='Mountain and Glacier Guides'>Mountain and Glacier Guides</option>
									<option id='Multimedia Designers'>Multimedia Designers</option>
									<option id='Multimedia Developers'>Multimedia Developers</option>
									<option id='Multimedia Specialists'>Multimedia Specialists</option>
									<option id='Multimedia Specialists and Web Developers'>Multimedia Specialists and Web Developers</option>
									<option id='Mushroom Pickers'>Mushroom Pickers</option>
									<option id='Music Directors'>Music Directors</option>
									<option id='Music Professionals'>Music Professionals</option>
									<option id='Music Teachers (Private Tuition)'>Music Teachers (Private Tuition)</option>
									<option id='Music, Dance, Drama, Play, Hypnotic, and Related Therapists'>Music, Dance, Drama, Play, Hypnotic, and Related Therapists</option>
									<option id='Musical Instrument Makers and Repairers'>Musical Instrument Makers and Repairers</option>
									<option id='Musicians'>Musicians</option>
									<option id='Mystery Shoppers'>Mystery Shoppers</option>
									<option id='Nail Technicians (Beauty Therapists)'>Nail Technicians (Beauty Therapists)</option>
									<option id='Nannies'>Nannies</option>
									<option id='Natural and Physical Science Professionals (not covered elsewhere)'>Natural and Physical Science Professionals (not covered elsewhere)</option>
									<option id='Natural Remedy Consultants'>Natural Remedy Consultants</option>
									<option id='Naturopaths'>Naturopaths</option>
									<option id='Naval Architects'>Naval Architects</option>
									<option id='Network Administrators'>Network Administrators</option>
									<option id='Network Analysts'>Network Analysts</option>
									<option id='Neurologists'>Neurologists</option>
									<option id='Neuropsychologists (Clinical Psychologists)'>Neuropsychologists (Clinical Psychologists)</option>
									<option id='Neurosurgeons'>Neurosurgeons</option>
									<option id='Newspaper and Periodical Editors'>Newspaper and Periodical Editors</option>
									<option id='Night Fillers'>Night Fillers</option>
									<option id='Noxious Weeds and Pest Inspectors'>Noxious Weeds and Pest Inspectors</option>
									<option id='Nuclear Medicine Technologists'>Nuclear Medicine Technologists</option>
									<option id='Nurse Educators'>Nurse Educators</option>
									<option id='Nurse Educators and Researchers'>Nurse Educators and Researchers</option>
									<option id='Nurse Managers'>Nurse Managers</option>
									<option id='Nurse Practitioners'>Nurse Practitioners</option>
									<option id='Nurse Researchers'>Nurse Researchers</option>
									<option id='Nursery Hands (Horticulture)'>Nursery Hands (Horticulture)</option>
									<option id='Nurserypersons'>Nurserypersons</option>
									<option id='Nurses (Dental)'>Nurses (Dental)</option>
									<option id='Nurses (Enrolled)'>Nurses (Enrolled)</option>
									<option id='Nurses (Registered)'>Nurses (Registered)</option>
									<option id='Nurses (Veterinary)'>Nurses (Veterinary)</option>
									<option id='Nursing Clinical Directors'>Nursing Clinical Directors</option>
									<option id='Nursing Support and Personal Care Workers'>Nursing Support and Personal Care Workers</option>
									<option id='Nursing Support Workers'>Nursing Support Workers</option>
									<option id='Nutrition Professionals'>Nutrition Professionals</option>
									<option id='Nutritionists'>Nutritionists</option>
									<option id='O'>O</option>
									<option id='Obstetricians and Gynaecologists'>Obstetricians and Gynaecologists</option>
									<option id='Occupational & Environmental Health Professionals'>Occupational & Environmental Health Professionals</option>
									<option id='Occupational Health and Safety Advisers'>Occupational Health and Safety Advisers</option>
									<option id='Occupational Psychologist'>Occupational Psychologist</option>
									<option id='Occupational Therapists'>Occupational Therapists</option>
									<option id='Oenologists'>Oenologists</option>
									<option id='Office Equipment Technician'>Office Equipment Technician</option>
									<option id='Office Managers'>Office Managers</option>
									<option id='Oher Financial Dealers'>Oher Financial Dealers</option>
									<option id='Oncologists (Medical)'>Oncologists (Medical)</option>
									<option id='Oncologists (Radiation)'>Oncologists (Radiation)</option>
									<option id='Operating Room Nurses'>Operating Room Nurses</option>
									<option id='Operating Theatre Technicians'>Operating Theatre Technicians</option>
									<option id='Operators (Switchboard)'>Operators (Switchboard)</option>
									<option id='Ophthalmologists'>Ophthalmologists</option>
									<option id='Optical Dispensers'>Optical Dispensers</option>
									<option id='Optical Mechanics'>Optical Mechanics</option>
									<option id='Optometrists'>Optometrists</option>
									<option id='Optometrists and Orthoptists'>Optometrists and Orthoptists</option>
									<option id='Oral Health Therapists (Dental Therapists)'>Oral Health Therapists (Dental Therapists)</option>
									<option id='Order Clerks'>Order Clerks</option>
									<option id='Orderlies (Hospital)'>Orderlies (Hospital)</option>
									<option id='Organisation and Methods Analysts'>Organisation and Methods Analysts</option>
									<option id='Organisational Psychologists'>Organisational Psychologists</option>
									<option id='Orthopaedic Surgeons'>Orthopaedic Surgeons</option>
									<option id='Orthoptists'>Orthoptists</option>
									<option id='Orthotists and Prosthetists'>Orthotists and Prosthetists</option>
									<option id='Osteopaths'>Osteopaths</option>
									<option id='Other Accommodation and Hospitality Managers'>Other Accommodation and Hospitality Managers</option>
									<option id='Other Actors, Dancers and Entertainers'>Other Actors, Dancers and Entertainers</option>
									<option id='Other Air Transport Professionals'>Other Air Transport Professionals</option>
									<option id='Other Animal Attendants and Trainers'>Other Animal Attendants and Trainers</option>
									<option id='Other Architectural, Building and Surveying Technicians'>Other Architectural, Building and Surveying Technicians</option>
									<option id='Other Automobile Drivers'>Other Automobile Drivers</option>
									<option id='Other Betting Clerks'>Other Betting Clerks</option>
									<option id='Other Building and Engineering Technicians'>Other Building and Engineering Technicians</option>
									<option id='Other Clay, Concrete, Glass and Stone Processing Machine Operators'>Other Clay, Concrete, Glass and Stone Processing Machine Operators</option>
									<option id='Other Cleaners'>Other Cleaners</option>
									<option id='Other Clerical & Administrative Workers'>Other Clerical & Administrative Workers</option>
									<option id='Other Clerical and Office Support Workers'>Other Clerical and Office Support Workers</option>
									<option id='Other Clothing Trades Workers'>Other Clothing Trades Workers</option>
									<option id='Other Construction and Mining Labourers'>Other Construction and Mining Labourers</option>
									<option id='Other Counsellors and Life Coaches'>Other Counsellors and Life Coaches</option>
									<option id='Other Crop Farm Workers'>Other Crop Farm Workers</option>
									<option id='Other Crop Farmers'>Other Crop Farmers</option>
									<option id='Other Education Managers'>Other Education Managers</option>
									<option id='Other Engineering Professionals'>Other Engineering Professionals</option>
									<option id='Other Environmental Scientists'>Other Environmental Scientists</option>
									<option id='Other Factory Process Workers'>Other Factory Process Workers</option>
									<option id='Other Farm, Forestry and Garden Workers'>Other Farm, Forestry and Garden Workers</option>
									<option id='Other Film, Television, Radio and Stage Directors'>Other Film, Television, Radio and Stage Directors</option>
									<option id='Other Financial Brokers'>Other Financial Brokers</option>
									<option id='Other Food and Drink Factory Workers'>Other Food and Drink Factory Workers</option>
									<option id='Other Food Trades Assistants'>Other Food Trades Assistants</option>
									<option id='Other Health and Welfare Services Managers'>Other Health and Welfare Services Managers</option>
									<option id='Other Health Diagnostic & Promotion Professionals'>Other Health Diagnostic & Promotion Professionals</option>
									<option id='Other Hospitality Workers'>Other Hospitality Workers</option>
									<option id='Other Hospitality, Retail and Service Managers'>Other Hospitality, Retail and Service Managers</option>
									<option id='Other ICT Managers'>Other ICT Managers</option>
									<option id='Other ICT Support and Test Engineers'>Other ICT Support and Test Engineers</option>
									<option id='Other ICT Support Technicians'>Other ICT Support Technicians</option>
									<option id='Other Information and Organisation Professionals'>Other Information and Organisation Professionals</option>
									<option id='Other Inspectors and Regulatory Officers'>Other Inspectors and Regulatory Officers</option>
									<option id='Other Legislators'>Other Legislators</option>
									<option id='Other Life Scientists'>Other Life Scientists</option>
									<option id='Other Livestock Farm Workers'>Other Livestock Farm Workers</option>
									<option id='Other Livestock Farmers'>Other Livestock Farmers</option>
									<option id='Other Machine Operators'>Other Machine Operators</option>
									<option id='Other Marine Transport Professionals'>Other Marine Transport Professionals</option>
									<option id='Other Medical Practitioners'>Other Medical Practitioners</option>
									<option id='Other Medical Technicians'>Other Medical Technicians</option>
									<option id='Other Metal Fitters and Machinists'>Other Metal Fitters and Machinists</option>
									<option id='Other Miscellaneous Labourers'>Other Miscellaneous Labourers</option>
									<option id='Other Mobile Plant Operators'>Other Mobile Plant Operators</option>
									<option id='Other Music Professionals'>Other Music Professionals</option>
									<option id='Other Natural and Physical Science Professionals'>Other Natural and Physical Science Professionals</option>
									<option id='Other Outdoor Adventure Guides'>Other Outdoor Adventure Guides</option>
									<option id='Other Packers'>Other Packers</option>
									<option id='Other Performing Arts Technicians'>Other Performing Arts Technicians</option>
									<option id='Other Personal Service Workers'>Other Personal Service Workers</option>
									<option id='Other Plastics and Rubber Production Machine Operators'>Other Plastics and Rubber Production Machine Operators</option>
									<option id='Other Practice Managers'>Other Practice Managers</option>
									<option id='Other Primary Products Inspectors'>Other Primary Products Inspectors</option>
									<option id='Other Private Tutors and Teachers'>Other Private Tutors and Teachers</option>
									<option id='Other Psychologists'>Other Psychologists</option>
									<option id='Other Sales Assistants and Salespersons'>Other Sales Assistants and Salespersons</option>
									<option id='Other Sales Representatives'>Other Sales Representatives</option>
									<option id='Other Sales Support Workers'>Other Sales Support Workers</option>
									<option id='Other Science Technicians'>Other Science Technicians</option>
									<option id='Other Security Workers'>Other Security Workers</option>
									<option id='Other Social Professionals'>Other Social Professionals</option>
									<option id='Other Software and Applications Programmers'>Other Software and Applications Programmers</option>
									<option id='Other Spatial Scientists'>Other Spatial Scientists</option>
									<option id='Other Special Education Teachers'>Other Special Education Teachers</option>
									<option id='Other Specialist Managers'>Other Specialist Managers</option>
									<option id='Other Specialist Physicians'>Other Specialist Physicians</option>
									<option id='Other Sports Coaches and Instructors'>Other Sports Coaches and Instructors</option>
									<option id='Other Sports Officials'>Other Sports Officials</option>
									<option id='Other Sportspersons'>Other Sportspersons</option>
									<option id='Other Stationary Plant Operators'>Other Stationary Plant Operators</option>
									<option id='Other Technical Sales Representatives'>Other Technical Sales Representatives</option>
									<option id='Other Technicians and Trades Workers'>Other Technicians and Trades Workers</option>
									<option id='Other Textile and Footwear Production Machine Operators'>Other Textile and Footwear Production Machine Operators</option>
									<option id='Other Travel Attendants'>Other Travel Attendants</option>
									<option id='Other Visual Arts or Crafts Professionals'>Other Visual Arts or Crafts Professionals</option>
									<option id='Other Wood Machinists and Wood Trades Workers'>Other Wood Machinists and Wood Trades Workers</option>
									<option id='Other Wood Processing Machine Operators'>Other Wood Processing Machine Operators</option>
									<option id='Otorhinolaryngologists'>Otorhinolaryngologists</option>
									<option id='Out of School Hours Care Workers'>Out of School Hours Care Workers</option>
									<option id='Outdoor Adventure Guides'>Outdoor Adventure Guides</option>
									<option id='Outdoor Adventure Instructors'>Outdoor Adventure Instructors</option>
									<option id='Packers'>Packers</option>
									<option id='Paediatric Surgeons'>Paediatric Surgeons</option>
									<option id='Paediatricians'>Paediatricians</option>
									<option id='Painters (Visual Arts)'>Painters (Visual Arts)</option>
									<option id='Painting Trades Workers'>Painting Trades Workers</option>
									<option id='Panelbeaters'>Panelbeaters</option>
									<option id='Paper and Pulp Mill Operators'>Paper and Pulp Mill Operators</option>
									<option id='Paper and Pulp Mill Workers'>Paper and Pulp Mill Workers</option>
									<option id='Paper and Wood Processing Machine Operators'>Paper and Wood Processing Machine Operators</option>
									<option id='Paper Products Machine Operators'>Paper Products Machine Operators</option>
									<option id='Paramedics (Ambulance)'>Paramedics (Ambulance)</option>
									<option id='Park Rangers'>Park Rangers</option>
									<option id='Parking Inspectors'>Parking Inspectors</option>
									<option id='Parole and Probation Officers'>Parole and Probation Officers</option>
									<option id='Passenger Coach Drivers'>Passenger Coach Drivers</option>
									<option id='Pastrycooks'>Pastrycooks</option>
									<option id='Pastrycook's Assistants'>Pastrycook's Assistants</option>
									<option id='Patent Attorneys (Intellectual Property Laywer)'>Patent Attorneys (Intellectual Property Laywer)</option>
									<option id='Patents Examiners'>Patents Examiners</option>
									<option id='Pathologists'>Pathologists</option>
									<option id='Pathology Collectors'>Pathology Collectors</option>
									<option id='Patient Services Assistants'>Patient Services Assistants</option>
									<option id='Patternmakers (Clothing)'>Patternmakers (Clothing)</option>
									<option id='Patternmakers (Engineering)'>Patternmakers (Engineering)</option>
									<option id='Paving and Surfacing Labourers'>Paving and Surfacing Labourers</option>
									<option id='Paving Plant Operators'>Paving Plant Operators</option>
									<option id='Payroll Clerks'>Payroll Clerks</option>
									<option id='Payroll Officers'>Payroll Officers</option>
									<option id='Performing Arts Technicians'>Performing Arts Technicians</option>
									<option id='Personal Assistants'>Personal Assistants</option>
									<option id='Personal Care Assistants'>Personal Care Assistants</option>
									<option id='Personal Care Consultants'>Personal Care Consultants</option>
									<option id='Personal Care Workers'>Personal Care Workers</option>
									<option id='Personal Service Workers (not covered elsewhere)'>Personal Service Workers (not covered elsewhere)</option>
									<option id='Personal Trainers'>Personal Trainers</option>
									<option id='Personnel Managers'>Personnel Managers</option>
									<option id='Personnel Officers'>Personnel Officers</option>
									<option id='Pest Controllers'>Pest Controllers</option>
									<option id='Pet Groomers'>Pet Groomers</option>
									<option id='Petroleum Engineers'>Petroleum Engineers</option>
									<option id='Petroleum Plant Operators'>Petroleum Plant Operators</option>
									<option id='Pharmacists'>Pharmacists</option>
									<option id='Pharmacy Sales Assistants'>Pharmacy Sales Assistants</option>
									<option id='Pharmacy Technicians'>Pharmacy Technicians</option>
									<option id='Phlebotomists (Pathology Collectors)'>Phlebotomists (Pathology Collectors)</option>
									<option id='Photographers'>Photographers</option>
									<option id='Photographer's Assistants'>Photographer's Assistants</option>
									<option id='Photographic Developers and Printers'>Photographic Developers and Printers</option>
									<option id='Physical Therapist'>Physical Therapist</option>
									<option id='Physicians'>Physicians</option>
									<option id='Physicists (including Astronomers)'>Physicists (including Astronomers)</option>
									<option id='Physiotherapists'>Physiotherapists</option>
									<option id='Piano Tuners'>Piano Tuners</option>
									<option id='Picture Framers'>Picture Framers</option>
									<option id='Pig Farmers'>Pig Farmers</option>
									<option id='Pilots (Air Transport)'>Pilots (Air Transport)</option>
									<option id='Planners (Urban and Regional)'>Planners (Urban and Regional)</option>
									<option id='Plant Mechanics (Fitters)'>Plant Mechanics (Fitters)</option>
									<option id='Plant Operators (Agricultural, Forestry & Horticul'>Plant Operators (Agricultural, Forestry & Horticul</option>
									<option id='Plant Operators (Earthmoving)'>Plant Operators (Earthmoving)</option>
									<option id='Plant Operators (Other Mobile)'>Plant Operators (Other Mobile)</option>
									<option id='Plant Operators (Stationary)'>Plant Operators (Stationary)</option>
									<option id='Plasterers'>Plasterers</option>
									<option id='Plastic and Reconstructive Surgeons'>Plastic and Reconstructive Surgeons</option>
									<option id='Plastic Cablemaking Machine Operators'>Plastic Cablemaking Machine Operators</option>
									<option id='Plastic Compounding and Reclamation Machine Operators'>Plastic Compounding and Reclamation Machine Operators</option>
									<option id='Plastic Surgeons'>Plastic Surgeons</option>
									<option id='Plastics and Rubber Factory Workers'>Plastics and Rubber Factory Workers</option>
									<option id='Plastics and Rubber Production Machine Operators'>Plastics and Rubber Production Machine Operators</option>
									<option id='Plastics Fabricators and Welders'>Plastics Fabricators and Welders</option>
									<option id='Plastics Factory Workers'>Plastics Factory Workers</option>
									<option id='Plastics Production Machine Operators (General)'>Plastics Production Machine Operators (General)</option>
									<option id='Plastics Technicians'>Plastics Technicians</option>
									<option id='Plumbers'>Plumbers</option>
									<option id='Plumbers (General)'>Plumbers (General)</option>
									<option id='Plumber's Assistants'>Plumber's Assistants</option>
									<option id='Plumbing Inspectors'>Plumbing Inspectors</option>
									<option id='Podiatrists'>Podiatrists</option>
									<option id='Police'>Police</option>
									<option id='Police Officers'>Police Officers</option>
									<option id='Policy Advisers'>Policy Advisers</option>
									<option id='Policy Analysts'>Policy Analysts</option>
									<option id='Policy and Planning Managers'>Policy and Planning Managers</option>
									<option id='Political Scientist (Other Social Professionals)'>Political Scientist (Other Social Professionals)</option>
									<option id='Porters'>Porters</option>
									<option id='Post Office Managers'>Post Office Managers</option>
									<option id='Postal Delivery Officers'>Postal Delivery Officers</option>
									<option id='Postal Sorting Officers'>Postal Sorting Officers</option>
									<option id='Potters and Ceramic Artists'>Potters and Ceramic Artists</option>
									<option id='Poultry Farm Workers'>Poultry Farm Workers</option>
									<option id='Poultry Farmers'>Poultry Farmers</option>
									<option id='Poultry Process Workers'>Poultry Process Workers</option>
									<option id='Powder Monkeys'>Powder Monkeys</option>
									<option id='Power Generation Plant Operators'>Power Generation Plant Operators</option>
									<option id='Practice Managers'>Practice Managers</option>
									<option id='Precision Instrument Makers and Repairers'>Precision Instrument Makers and Repairers</option>
									<option id='Precision Metal Trades Workers'>Precision Metal Trades Workers</option>
									<option id='Pre-press Trades Workers'>Pre-press Trades Workers</option>
									<option id='Preschool Aides'>Preschool Aides</option>
									<option id='Preschool Teachers (Early Childhood)'>Preschool Teachers (Early Childhood)</option>
									<option id='Presenters'>Presenters</option>
									<option id='Pressure Welders'>Pressure Welders</option>
									<option id='Primary Health Organisation Managers'>Primary Health Organisation Managers</option>
									<option id='Primary Products Inspectors'>Primary Products Inspectors</option>
									<option id='Primary School Teachers'>Primary School Teachers</option>
									<option id='Principals (School)'>Principals (School)</option>
									<option id='Print Finishers'>Print Finishers</option>
									<option id='Print Journalists'>Print Journalists</option>
									<option id='Printers'>Printers</option>
									<option id='Printer's Assistants'>Printer's Assistants</option>
									<option id='Printing Assistants and Table Workers'>Printing Assistants and Table Workers</option>
									<option id='Printing Machinists'>Printing Machinists</option>
									<option id='Printing Table Workers'>Printing Table Workers</option>
									<option id='Prison Officers'>Prison Officers</option>
									<option id='Private Investigators'>Private Investigators</option>
									<option id='Private Tutors and Teachers'>Private Tutors and Teachers</option>
									<option id='Probation Officers'>Probation Officers</option>
									<option id='Process Workers (Meat, Poultry and Seafood)'>Process Workers (Meat, Poultry and Seafood)</option>
									<option id='Process Workers (Metal Engineering)'>Process Workers (Metal Engineering)</option>
									<option id='Process Workers (Other Factory)'>Process Workers (Other Factory)</option>
									<option id='Process Workers (Timber and Wood)'>Process Workers (Timber and Wood)</option>
									<option id='Procurement Managers'>Procurement Managers</option>
									<option id='Procurement Officers'>Procurement Officers</option>
									<option id='Producers (Media)'>Producers (Media)</option>
									<option id='Product Assemblers'>Product Assemblers</option>
									<option id='Product Designers (Industrial)'>Product Designers (Industrial)</option>
									<option id='Product Examiners'>Product Examiners</option>
									<option id='Product Graders'>Product Graders</option>
									<option id='Product Quality Controllers'>Product Quality Controllers</option>
									<option id='Product Testers'>Product Testers</option>
									<option id='Production and Plant Engineers'>Production and Plant Engineers</option>
									<option id='Production Assistants (Film, Television, Radio or Stage)'>Production Assistants (Film, Television, Radio or Stage)</option>
									<option id='Production Clerks'>Production Clerks</option>
									<option id='Production Managers'>Production Managers</option>
									<option id='Production Managers (Forestry)'>Production Managers (Forestry)</option>
									<option id='Production Managers (Mining)'>Production Managers (Mining)</option>
									<option id='Production Recording Clerks'>Production Recording Clerks</option>
									<option id='Production Systems Workers (Engineering)'>Production Systems Workers (Engineering)</option>
									<option id='Program Administrators'>Program Administrators</option>
									<option id='Program and Project Administrators'>Program and Project Administrators</option>
									<option id='Program Directors (Television or Radio)'>Program Directors (Television or Radio)</option>
									<option id='Programmers'>Programmers</option>
									<option id='Project Administrators'>Project Administrators</option>
									<option id='Project Builders'>Project Builders</option>
									<option id='Project Coordinators'>Project Coordinators</option>
									<option id='Proof Readers'>Proof Readers</option>
									<option id='Property Managers'>Property Managers</option>
									<option id='Property Valuers'>Property Valuers</option>
									<option id='Prosthetists or Orthotists'>Prosthetists or Orthotists</option>
									<option id='Psychiatric Nurse'>Psychiatric Nurse</option>
									<option id='Psychiatrists'>Psychiatrists</option>
									<option id='Psychologists and Psychotherapists'>Psychologists and Psychotherapists</option>
									<option id='Psychotherapists'>Psychotherapists</option>
									<option id='Public Relations Managers'>Public Relations Managers</option>
									<option id='Public Relations Professionals'>Public Relations Professionals</option>
									<option id='Purchasing and Supply Logistics Clerks'>Purchasing and Supply Logistics Clerks</option>
									<option id='Purchasing Officers'>Purchasing Officers</option>
									<option id='Q'>Q</option>
									<option id='Quality Assurance Assessors'>Quality Assurance Assessors</option>
									<option id='Quality Assurance Managers'>Quality Assurance Managers</option>
									<option id='Quality Control Assessors'>Quality Control Assessors</option>
									<option id='Quantity Surveyors'>Quantity Surveyors</option>
									<option id='Quarantine Officers'>Quarantine Officers</option>
									<option id='R'>R</option>
									<option id='Radiation Oncologists'>Radiation Oncologists</option>
									<option id='Radiation Therapists (Medical)'>Radiation Therapists (Medical)</option>
									<option id='Radiator Repairers'>Radiator Repairers</option>
									<option id='Radio Despatchers'>Radio Despatchers</option>
									<option id='Radio Journalists'>Radio Journalists</option>
									<option id='Radio Presenters'>Radio Presenters</option>
									<option id='Radiocommunications Technicians'>Radiocommunications Technicians</option>
									<option id='Radiographers'>Radiographers</option>
									<option id='Railway Signal Operators'>Railway Signal Operators</option>
									<option id='Railway Station Managers'>Railway Station Managers</option>
									<option id='Railway Track Plant Operators'>Railway Track Plant Operators</option>
									<option id='Railway Track Workers'>Railway Track Workers</option>
									<option id='Railways Assistants'>Railways Assistants</option>
									<option id='Rangers'>Rangers</option>
									<option id='Real Estate Agency Principals'>Real Estate Agency Principals</option>
									<option id='Real Estate Agents'>Real Estate Agents</option>
									<option id='Real Estate Representatives'>Real Estate Representatives</option>
									<option id='Real Estate Sales Agents'>Real Estate Sales Agents</option>
									<option id='Receptionists'>Receptionists</option>
									<option id='Receptionists (General)'>Receptionists (General)</option>
									<option id='Records Managers'>Records Managers</option>
									<option id='Recreation Officers'>Recreation Officers</option>
									<option id='Recreational Therapists'>Recreational Therapists</option>
									<option id='Recruitment Consultants'>Recruitment Consultants</option>
									<option id='Recycling and Rubbish Collectors'>Recycling and Rubbish Collectors</option>
									<option id='Recycling Workers'>Recycling Workers</option>
									<option id='Referees (Sports)'>Referees (Sports)</option>
									<option id='Refrigeration Mechanics'>Refrigeration Mechanics</option>
									<option id='Refuge Workers'>Refuge Workers</option>
									<option id='Regional Education Managers'>Regional Education Managers</option>
									<option id='Registered Nurses'>Registered Nurses</option>
									<option id='Registered Nurses (Aged Care)'>Registered Nurses (Aged Care)</option>
									<option id='Registered Nurses (Child and Family Health)'>Registered Nurses (Child and Family Health)</option>
									<option id='Registered Nurses (Community Health)'>Registered Nurses (Community Health)</option>
									<option id='Registered Nurses (Critical Care and Emergency)'>Registered Nurses (Critical Care and Emergency)</option>
									<option id='Registered Nurses (Developmental Disability)'>Registered Nurses (Developmental Disability)</option>
									<option id='Registered Nurses (Disability and Rehabilitation)'>Registered Nurses (Disability and Rehabilitation)</option>
									<option id='Registered Nurses (Medical Practice)'>Registered Nurses (Medical Practice)</option>
									<option id='Registered Nurses (Medical)'>Registered Nurses (Medical)</option>
									<option id='Registered Nurses (Mental Health)'>Registered Nurses (Mental Health)</option>
									<option id='Registered Nurses (not covered elsewhere)'>Registered Nurses (not covered elsewhere)</option>
									<option id='Registered Nurses (Paediatrics)'>Registered Nurses (Paediatrics)</option>
									<option id='Registered Nurses (Perioperative)'>Registered Nurses (Perioperative)</option>
									<option id='Registered Nurses (Surgical)'>Registered Nurses (Surgical)</option>
									<option id='Regulatory Officers'>Regulatory Officers</option>
									<option id='Rehabilitation Counsellors'>Rehabilitation Counsellors</option>
									<option id='Reinforced Plastic and Composite Production Workers'>Reinforced Plastic and Composite Production Workers</option>
									<option id='Religious Assistants'>Religious Assistants</option>
									<option id='Renal Medicine Specialists'>Renal Medicine Specialists</option>
									<option id='Rental Salespersons'>Rental Salespersons</option>
									<option id='Research and Development Managers'>Research and Development Managers</option>
									<option id='Resident Medical Officers'>Resident Medical Officers</option>
									<option id='Residential Care Officers'>Residential Care Officers</option>
									<option id='Respiratory Medicine Physicians'>Respiratory Medicine Physicians</option>
									<option id='Restaurant Managers'>Restaurant Managers</option>
									<option id='Retail and Wool Buyers'>Retail and Wool Buyers</option>
									<option id='Retail Assistants'>Retail Assistants</option>
									<option id='Retail Buyers'>Retail Buyers</option>
									<option id='Retail Loss Prevention Officers'>Retail Loss Prevention Officers</option>
									<option id='Retail Managers'>Retail Managers</option>
									<option id='Retail Managers (General)'>Retail Managers (General)</option>
									<option id='Retail Pharmacists'>Retail Pharmacists</option>
									<option id='Retail Supervisors'>Retail Supervisors</option>
									<option id='Retirement Village Managers'>Retirement Village Managers</option>
									<option id='Rheumatologists'>Rheumatologists</option>
									<option id='Riggers (Construction)'>Riggers (Construction)</option>
									<option id='Road Roller Operators'>Road Roller Operators</option>
									<option id='Road Traffic Controllers'>Road Traffic Controllers</option>
									<option id='Roof Plumbers'>Roof Plumbers</option>
									<option id='Roof Tilers'>Roof Tilers</option>
									<option id='Rubber Factory Workers'>Rubber Factory Workers</option>
									<option id='Rubber Production Machine Operators'>Rubber Production Machine Operators</option>
									<option id='Rugby League Footballers'>Rugby League Footballers</option>
									<option id='Rugby Union Footballers'>Rugby Union Footballers</option>
									<option id='Safety Inspectors'>Safety Inspectors</option>
									<option id='Sail Makers'>Sail Makers</option>
									<option id='Sales Agents (Real Estate)'>Sales Agents (Real Estate)</option>
									<option id='Sales and Marketing Managers'>Sales and Marketing Managers</option>
									<option id='Sales Assistants (General)'>Sales Assistants (General)</option>
									<option id='Sales Assistants (ICT)'>Sales Assistants (ICT)</option>
									<option id='Sales Assistants (Pharmacy)'>Sales Assistants (Pharmacy)</option>
									<option id='Sales Assistants and Salespersons (not covered elsewhere)'>Sales Assistants and Salespersons (not covered elsewhere)</option>
									<option id='Sales Demonstrators'>Sales Demonstrators</option>
									<option id='Sales Managers'>Sales Managers</option>
									<option id='Sales Professionals (ICT)'>Sales Professionals (ICT)</option>
									<option id='Sales Representatives'>Sales Representatives</option>
									<option id='Sales Representatives (Building and Plumbing Supplies)'>Sales Representatives (Building and Plumbing Supplies)</option>
									<option id='Sales Representatives (Business Services)'>Sales Representatives (Business Services)</option>
									<option id='Sales Representatives (Industrial Products)'>Sales Representatives (Industrial Products)</option>
									<option id='Sales Representatives (Medical and Pharmaceutical Products)'>Sales Representatives (Medical and Pharmaceutical Products)</option>
									<option id='Sales Representatives (Motor Vehicle Parts and Accessories)'>Sales Representatives (Motor Vehicle Parts and Accessories)</option>
									<option id='Sales Representatives (Personal and Household Goods)'>Sales Representatives (Personal and Household Goods)</option>
									<option id='Sales Representatives (Technical)'>Sales Representatives (Technical)</option>
									<option id='Salespersons (Motor Vehicle and Vehicle Parts)'>Salespersons (Motor Vehicle and Vehicle Parts)</option>
									<option id='Salespersons (Tickets)'>Salespersons (Tickets)</option>
									<option id='Sand Blasters'>Sand Blasters</option>
									<option id='Saw Doctors'>Saw Doctors</option>
									<option id='Sawmill and Timber Yard Workers'>Sawmill and Timber Yard Workers</option>
									<option id='Sawmilling Operators'>Sawmilling Operators</option>
									<option id='Scaffolders'>Scaffolders</option>
									<option id='School Cleaners (Commercial Cleaners)'>School Cleaners (Commercial Cleaners)</option>
									<option id='School Counsellor'>School Counsellor</option>
									<option id='School Laboratory Technicians'>School Laboratory Technicians</option>
									<option id='School Principals'>School Principals</option>
									<option id='Science Technicians'>Science Technicians</option>
									<option id='Screen Printers'>Screen Printers</option>
									<option id='Scuba, Snorkelling and Dive instructors'>Scuba, Snorkelling and Dive instructors</option>
									<option id='Sculptors'>Sculptors</option>
									<option id='Seafood Packers'>Seafood Packers</option>
									<option id='Seafood Process Workers'>Seafood Process Workers</option>
									<option id='Secondary School Teachers'>Secondary School Teachers</option>
									<option id='Secretaries'>Secretaries</option>
									<option id='Secretaries (General)'>Secretaries (General)</option>
									<option id='Security Consultants'>Security Consultants</option>
									<option id='Security Officers'>Security Officers</option>
									<option id='Security Officers and Guards'>Security Officers and Guards</option>
									<option id='Security Specialists (ICT)'>Security Specialists (ICT)</option>
									<option id='Security Technicians (Electronic Equipment Trades Workers)'>Security Technicians (Electronic Equipment Trades Workers)</option>
									<option id='Senior Non-Commissioned Defence Force Officers'>Senior Non-Commissioned Defence Force Officers</option>
									<option id='Service Station Attendants'>Service Station Attendants</option>
									<option id='Sewing Machinists'>Sewing Machinists</option>
									<option id='Shearers'>Shearers</option>
									<option id='Shearing Shed Hands'>Shearing Shed Hands</option>
									<option id='Sheep Farm Workers'>Sheep Farm Workers</option>
									<option id='Sheep Farmers'>Sheep Farmers</option>
									<option id='Sheetmetal Trades Workers'>Sheetmetal Trades Workers</option>
									<option id='Shelf Fillers'>Shelf Fillers</option>
									<option id='Ship's Captains'>Ship's Captains</option>
									<option id='Ship's Engineers'>Ship's Engineers</option>
									<option id='Ship's Masters'>Ship's Masters</option>
									<option id='Ship's Officers'>Ship's Officers</option>
									<option id='Shipwrights'>Shipwrights</option>
									<option id='Shoemakers'>Shoemakers</option>
									<option id='Shop Managers'>Shop Managers</option>
									<option id='Shopfitters (Carpenter and Joiners)'>Shopfitters (Carpenter and Joiners)</option>
									<option id='Short Order Cooks'>Short Order Cooks</option>
									<option id='Shot Firers'>Shot Firers</option>
									<option id='Sign Erectors'>Sign Erectors</option>
									<option id='Signwriters'>Signwriters</option>
									<option id='Singers'>Singers</option>
									<option id='Slaughterers'>Slaughterers</option>
									<option id='Small Engine Mechanics'>Small Engine Mechanics</option>
									<option id='Small Offset Printers'>Small Offset Printers</option>
									<option id='Smallgoods Makers'>Smallgoods Makers</option>
									<option id='Snowsport Instructors'>Snowsport Instructors</option>
									<option id='Soccer Players (Footballers)'>Soccer Players (Footballers)</option>
									<option id='Social Professionals'>Social Professionals</option>
									<option id='Social Security Assessors'>Social Security Assessors</option>
									<option id='Social Workers'>Social Workers</option>
									<option id='Sociologist (Other Social Professionals)'>Sociologist (Other Social Professionals)</option>
									<option id='Software and Applications Programmers'>Software and Applications Programmers</option>
									<option id='Software Developers (in Developer Programmers)'>Software Developers (in Developer Programmers)</option>
									<option id='Software Engineers'>Software Engineers</option>
									<option id='Software Testers'>Software Testers</option>
									<option id='Soil Scientists'>Soil Scientists</option>
									<option id='Solicitors'>Solicitors</option>
									<option id='Solid Plasterers'>Solid Plasterers</option>
									<option id='Sonographers'>Sonographers</option>
									<option id='Sound Technicians'>Sound Technicians</option>
									<option id='Sous Chefs (Chefs)'>Sous Chefs (Chefs)</option>
									<option id='Spare Parts Interpreters'>Spare Parts Interpreters</option>
									<option id='Special Care Workers'>Special Care Workers</option>
									<option id='Special Education Teachers'>Special Education Teachers</option>
									<option id='Special Needs Teachers'>Special Needs Teachers</option>
									<option id='Specialist Managers (not covered elsewhere)'>Specialist Managers (not covered elsewhere)</option>
									<option id='Specialist Physicians'>Specialist Physicians</option>
									<option id='Specialist Physicians (General Medicine)'>Specialist Physicians (General Medicine)</option>
									<option id='Specimen Collectors'>Specimen Collectors</option>
									<option id='Speech Pathologists'>Speech Pathologists</option>
									<option id='Speech Therapist'>Speech Therapist</option>
									<option id='Sport Psychologists (Other Psychologists)'>Sport Psychologists (Other Psychologists)</option>
									<option id='Sports Administrators'>Sports Administrators</option>
									<option id='Sports Centre Managers'>Sports Centre Managers</option>
									<option id='Sports Coaches, Instructors and Officials'>Sports Coaches, Instructors and Officials</option>
									<option id='Sports Development Officers'>Sports Development Officers</option>
									<option id='Sports Physiotherapists'>Sports Physiotherapists</option>
									<option id='Sports Umpires'>Sports Umpires</option>
									<option id='Sportspersons'>Sportspersons</option>
									<option id='Spraypainters (Industrial)'>Spraypainters (Industrial)</option>
									<option id='Spraypainters (Vehicle)'>Spraypainters (Vehicle)</option>
									<option id='Stablehands'>Stablehands</option>
									<option id='Stage Managers'>Stage Managers</option>
									<option id='Stationary Plant Operators (not covered elsewhere)'>Stationary Plant Operators (not covered elsewhere)</option>
									<option id='Statistical Clerks'>Statistical Clerks</option>
									<option id='Statisticians'>Statisticians</option>
									<option id='Steel Fixers'>Steel Fixers</option>
									<option id='Sterilisation Technicians'>Sterilisation Technicians</option>
									<option id='Stevedores'>Stevedores</option>
									<option id='Stock and Station Agents'>Stock and Station Agents</option>
									<option id='Stock Clerks'>Stock Clerks</option>
									<option id='Stockbrokers'>Stockbrokers</option>
									<option id='Stone Processing Machine Operators'>Stone Processing Machine Operators</option>
									<option id='Stonemasons'>Stonemasons</option>
									<option id='Store Detectives'>Store Detectives</option>
									<option id='Storepersons'>Storepersons</option>
									<option id='Street Vendors'>Street Vendors</option>
									<option id='Street Vendors and Related Salespersons'>Street Vendors and Related Salespersons</option>
									<option id='Streetsweeper Operators'>Streetsweeper Operators</option>
									<option id='Structural Engineers'>Structural Engineers</option>
									<option id='Structural Steel and Welding Trades Workers'>Structural Steel and Welding Trades Workers</option>
									<option id='Structural Steel Construction Workers'>Structural Steel Construction Workers</option>
									<option id='Structural Steel Erectors'>Structural Steel Erectors</option>
									<option id='Student Counsellors'>Student Counsellors</option>
									<option id='Sugar Cane Growers'>Sugar Cane Growers</option>
									<option id='Sugar Mill Workers'>Sugar Mill Workers</option>
									<option id='Supervisors (Retail)'>Supervisors (Retail)</option>
									<option id='Supply and Distribution Managers'>Supply and Distribution Managers</option>
									<option id='Supply Chain Managers'>Supply Chain Managers</option>
									<option id='Supply, Distribution and Procurement Managers'>Supply, Distribution and Procurement Managers</option>
									<option id='Surgeons'>Surgeons</option>
									<option id='Surgeons (General)'>Surgeons (General)</option>
									<option id='Survey Interviewers'>Survey Interviewers</option>
									<option id='Surveying and Spatial Science Technicians'>Surveying and Spatial Science Technicians</option>
									<option id='Surveyors'>Surveyors</option>
									<option id='Surveyors and Spatial Scientists'>Surveyors and Spatial Scientists</option>
									<option id='Surveyor's Assistants'>Surveyor's Assistants</option>
									<option id='Swimming Coaches and Instructors'>Swimming Coaches and Instructors</option>
									<option id='Switchboard Operators'>Switchboard Operators</option>
									<option id='Systems Administrators'>Systems Administrators</option>
									<option id='Systems Analysts'>Systems Analysts</option>
									<option id='T'>T</option>
									<option id='TAFE Teacher'>TAFE Teacher</option>
									<option id='Tailors'>Tailors</option>
									<option id='Tanker Drivers'>Tanker Drivers</option>
									<option id='Tattoo Artists (Body Artists)'>Tattoo Artists (Body Artists)</option>
									<option id='Taxation Accountants'>Taxation Accountants</option>
									<option id='Taxation Inspectors'>Taxation Inspectors</option>
									<option id='Taxi Drivers'>Taxi Drivers</option>
									<option id='Teachers (Early Childhood)'>Teachers (Early Childhood)</option>
									<option id='Teachers (Middle School)'>Teachers (Middle School)</option>
									<option id='Teachers (Primary School)'>Teachers (Primary School)</option>
									<option id='Teachers (Private)'>Teachers (Private)</option>
									<option id='Teachers (Secondary School)'>Teachers (Secondary School)</option>
									<option id='Teachers (Special Education)'>Teachers (Special Education)</option>
									<option id='Teachers (Vocational Education)'>Teachers (Vocational Education)</option>
									<option id='Teachers' Aides'>Teachers' Aides</option>
									<option id='Teachers of English to Speakers of Other Languages'>Teachers of English to Speakers of Other Languages</option>
									<option id='Teachers of the Hearing Impaired'>Teachers of the Hearing Impaired</option>
									<option id='Teachers of the Sight Impaired'>Teachers of the Sight Impaired</option>
									<option id='Technical Cable Jointers'>Technical Cable Jointers</option>
									<option id='Technical Directors'>Technical Directors</option>
									<option id='Technical Sales Representatives'>Technical Sales Representatives</option>
									<option id='Technical Writers'>Technical Writers</option>
									<option id='Technicians (Agricultural)'>Technicians (Agricultural)</option>
									<option id='Technicians (Architectural, Building & Surveying)'>Technicians (Architectural, Building & Surveying)</option>
									<option id='Technicians (Civil Engineering)'>Technicians (Civil Engineering)</option>
									<option id='Technicians (Dental)'>Technicians (Dental)</option>
									<option id='Technicians (Electrical Engineering)'>Technicians (Electrical Engineering)</option>
									<option id='Technicians (Electronic Engineering)'>Technicians (Electronic Engineering)</option>
									<option id='Technicians (Gallery, Library and Museum)'>Technicians (Gallery, Library and Museum)</option>
									<option id='Technicians (ICT Support)'>Technicians (ICT Support)</option>
									<option id='Technicians (Mechanical Engineering)'>Technicians (Mechanical Engineering)</option>
									<option id='Technicians (Medical)'>Technicians (Medical)</option>
									<option id='Technicians (Other Building and Engineering)'>Technicians (Other Building and Engineering)</option>
									<option id='Technicians (Performing Arts)'>Technicians (Performing Arts)</option>
									<option id='Technicians (Science)'>Technicians (Science)</option>
									<option id='Technicians and Trades Workers (not covered elsewhere)'>Technicians and Trades Workers (not covered elsewhere)</option>
									<option id='Telecommunications Cable Jointers'>Telecommunications Cable Jointers</option>
									<option id='Telecommunications Engineering Professionals'>Telecommunications Engineering Professionals</option>
									<option id='Telecommunications Engineers'>Telecommunications Engineers</option>
									<option id='Telecommunications Field Engineers'>Telecommunications Field Engineers</option>
									<option id='Telecommunications Linesworkers'>Telecommunications Linesworkers</option>
									<option id='Telecommunications Network Engineers'>Telecommunications Network Engineers</option>
									<option id='Telecommunications Network Planners'>Telecommunications Network Planners</option>
									<option id='Telecommunications Technical Officers and Technologists'>Telecommunications Technical Officers and Technologists</option>
									<option id='Telecommunications Technical Specialists'>Telecommunications Technical Specialists</option>
									<option id='Telecommunications Technicians'>Telecommunications Technicians</option>
									<option id='Telecommunications Trades Workers'>Telecommunications Trades Workers</option>
									<option id='Telemarketers'>Telemarketers</option>
									<option id='Telephone Betting Clerks'>Telephone Betting Clerks</option>
									<option id='Telephone Operators'>Telephone Operators</option>
									<option id='Television Equipment Operators'>Television Equipment Operators</option>
									<option id='Television Journalists'>Television Journalists</option>
									<option id='Television Presenters'>Television Presenters</option>
									<option id='Tennis Coaches'>Tennis Coaches</option>
									<option id='Test Analysts (ICT)'>Test Analysts (ICT)</option>
									<option id='Textile & Footwear Production Machine Operators'>Textile & Footwear Production Machine Operators</option>
									<option id='Textile Dyeing and Finishing Machine Operators'>Textile Dyeing and Finishing Machine Operators</option>
									<option id='Textile, Clothing and Footwear Mechanics'>Textile, Clothing and Footwear Mechanics</option>
									<option id='Therapy Aides'>Therapy Aides</option>
									<option id='Thoracic Medicine Specialists'>Thoracic Medicine Specialists</option>
									<option id='Ticket Collectors and Ushers'>Ticket Collectors and Ushers</option>
									<option id='Ticket Salespersons'>Ticket Salespersons</option>
									<option id='Ticket Sellers'>Ticket Sellers</option>
									<option id='Tilers (Floor)'>Tilers (Floor)</option>
									<option id='Tilers (Roof)'>Tilers (Roof)</option>
									<option id='Tiler's Assistants'>Tiler's Assistants</option>
									<option id='Timber and Wood Process Workers'>Timber and Wood Process Workers</option>
									<option id='Toolmakers'>Toolmakers</option>
									<option id='Toolmakers and Engineering Patternmakers'>Toolmakers and Engineering Patternmakers</option>
									<option id='Tour Guides'>Tour Guides</option>
									<option id='Tourism and Travel Advisers'>Tourism and Travel Advisers</option>
									<option id='Tourist Information Officers'>Tourist Information Officers</option>
									<option id='Tow Truck Drivers'>Tow Truck Drivers</option>
									<option id='Train and Tram Drivers'>Train and Tram Drivers</option>
									<option id='Train Controllers'>Train Controllers</option>
									<option id='Train Drivers'>Train Drivers</option>
									<option id='Train Examiners'>Train Examiners</option>
									<option id='Trainers (Animal)'>Trainers (Animal)</option>
									<option id='Trainers (ICT)'>Trainers (ICT)</option>
									<option id='Training and Development Professionals'>Training and Development Professionals</option>
									<option id='Tram Drivers'>Tram Drivers</option>
									<option id='Translators'>Translators</option>
									<option id='Transport and Despatch Clerks'>Transport and Despatch Clerks</option>
									<option id='Transport Company Managers'>Transport Company Managers</option>
									<option id='Transport Conductors'>Transport Conductors</option>
									<option id='Transport Engineers'>Transport Engineers</option>
									<option id='Transport Operations Inspectors'>Transport Operations Inspectors</option>
									<option id='Transport Services Managers'>Transport Services Managers</option>
									<option id='Travel Agency Managers'>Travel Agency Managers</option>
									<option id='Travel Agents'>Travel Agents</option>
									<option id='Travel Attendants'>Travel Attendants</option>
									<option id='Travel Consultants'>Travel Consultants</option>
									<option id='Tree Fallers'>Tree Fallers</option>
									<option id='Tree Surgeons'>Tree Surgeons</option>
									<option id='Trekking Guides'>Trekking Guides</option>
									<option id='Tribunal Members'>Tribunal Members</option>
									<option id='Trimmers (Vehicle)'>Trimmers (Vehicle)</option>
									<option id='Trolley Collectors'>Trolley Collectors</option>
									<option id='Truck Drivers'>Truck Drivers</option>
									<option id='Truck Drivers (General)'>Truck Drivers (General)</option>
									<option id='Truck Driver's Offsiders'>Truck Driver's Offsiders</option>
									<option id='Trust Officers'>Trust Officers</option>
									<option id='Turf Growers'>Turf Growers</option>
									<option id='Tutors and Lecturers (University)'>Tutors and Lecturers (University)</option>
									<option id='Tutors and Teachers (Private)'>Tutors and Teachers (Private)</option>
									<option id='Typists'>Typists</option>
									<option id='Tyre Fitters'>Tyre Fitters</option>
									<option id='Undertakers'>Undertakers</option>
									<option id='Undertakers'>Undertakers</option>
									<option id='University Lecturers'>University Lecturers</option>
									<option id='University Lecturers and Tutors'>University Lecturers and Tutors</option>
									<option id='University Tutors'>University Tutors</option>
									<option id='Upholsterers'>Upholsterers</option>
									<option id='Urban and Regional Planners'>Urban and Regional Planners</option>
									<option id='Urologists'>Urologists</option>
									<option id='Ushers'>Ushers</option>
									<option id='Valuers'>Valuers</option>
									<option id='Vascular Surgeons'>Vascular Surgeons</option>
									<option id='Vegetable Farm Workers'>Vegetable Farm Workers</option>
									<option id='Vegetable Growers'>Vegetable Growers</option>
									<option id='Vegetable Pickers'>Vegetable Pickers</option>
									<option id='Vehicle and Vehicle Parts Salespersons'>Vehicle and Vehicle Parts Salespersons</option>
									<option id='Vehicle Assemblers'>Vehicle Assemblers</option>
									<option id='Vehicle Body Builders'>Vehicle Body Builders</option>
									<option id='Vehicle Body Builders and Trimmers'>Vehicle Body Builders and Trimmers</option>
									<option id='Vehicle Painters'>Vehicle Painters</option>
									<option id='Vehicle Parts and Accessories Fitters'>Vehicle Parts and Accessories Fitters</option>
									<option id='Vehicle Trimmers'>Vehicle Trimmers</option>
									<option id='Vending Machine Attendants'>Vending Machine Attendants</option>
									<option id='Veterinarians'>Veterinarians</option>
									<option id='Veterinary Nurses'>Veterinary Nurses</option>
									<option id='Video Editors'>Video Editors</option>
									<option id='Video Producers'>Video Producers</option>
									<option id='Vineyard Workers'>Vineyard Workers</option>
									<option id='Visual Arts and Crafts Professionals'>Visual Arts and Crafts Professionals</option>
									<option id='Visual Merchandisers'>Visual Merchandisers</option>
									<option id='Vocalists'>Vocalists</option>
									<option id='Vocational Education Teachers'>Vocational Education Teachers</option>
									<option id='Waiters'>Waiters</option>
									<option id='Waitresses'>Waitresses</option>
									<option id='Wall and Floor Tilers'>Wall and Floor Tilers</option>
									<option id='Ward Clerks'>Ward Clerks</option>
									<option id='Wardspersons'>Wardspersons</option>
									<option id='Warehouse Administrators'>Warehouse Administrators</option>
									<option id='Warehouse Assistants'>Warehouse Assistants</option>
									<option id='Waste Water and Water Plant Operators'>Waste Water and Water Plant Operators</option>
									<option id='Watch and Clock Makers and Repairers'>Watch and Clock Makers and Repairers</option>
									<option id='Water Inspectors'>Water Inspectors</option>
									<option id='Waterside Workers'>Waterside Workers</option>
									<option id='Weaving Machine Operators'>Weaving Machine Operators</option>
									<option id='Web Administrators'>Web Administrators</option>
									<option id='Web Designers'>Web Designers</option>
									<option id='Web Developers'>Web Developers</option>
									<option id='Web Masters'>Web Masters</option>
									<option id='Weighbridge Operators'>Weighbridge Operators</option>
									<option id='Weight Loss Consultants'>Weight Loss Consultants</option>
									<option id='Welders (First Class)'>Welders (First Class)</option>
									<option id='Welfare Centre Managers'>Welfare Centre Managers</option>
									<option id='Welfare Support Workers'>Welfare Support Workers</option>
									<option id='Welfare Workers'>Welfare Workers</option>
									<option id='Welfare, Recreation and Community Arts Workers'>Welfare, Recreation and Community Arts Workers</option>
									<option id='Whitewater Rafting Guides'>Whitewater Rafting Guides</option>
									<option id='Wholesalers'>Wholesalers</option>
									<option id='Window Cleaners'>Window Cleaners</option>
									<option id='Window Dressers'>Window Dressers</option>
									<option id='Wine Makers'>Wine Makers</option>
									<option id='Winery Cellar Hands'>Winery Cellar Hands</option>
									<option id='Wood and Wood Products Factory Workers'>Wood and Wood Products Factory Workers</option>
									<option id='Wood Machinists'>Wood Machinists</option>
									<option id='Wood Machinists and Other Wood Trades Workers'>Wood Machinists and Other Wood Trades Workers</option>
									<option id='Wood Processing Machine Operators'>Wood Processing Machine Operators</option>
									<option id='Wood Turners'>Wood Turners</option>
									<option id='Wool Buyers'>Wool Buyers</option>
									<option id='Wool Classers'>Wool Classers</option>
									<option id='Wool Handlers'>Wool Handlers</option>
									<option id='Word Processing Operators'>Word Processing Operators</option>
									<option id='Workplace Relations Advisers'>Workplace Relations Advisers</option>
									<option id='Writers (Authors)'>Writers (Authors)</option>
									<option id='Writers (Journalists and Others)'>Writers (Journalists and Others)</option>
									<option id='Yarn Carding and Spinning Machine Operators'>Yarn Carding and Spinning Machine Operators</option>
									<option id='Youth Workers'>Youth Workers</option>
									<option id='Zookeepers'>Zookeepers</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 form-group" id="intJobWishList"></div>
                        </div>
                        <div class="row pt-2">
                            <div class="col-md-3">
                               </div>
                            <div class="col-md-6">
			                    <div id="alertContainer" style="display:none; line-height: 0.7; text-align: center; font-size: small;" class="alert-notifications alertContainerClass">
								  	<div class="alert alert-success fade alert-dismissible show" role="alert">
										<span id="alertText" class="alertTextClass"></span>
									</div>
							    </div>    
							</div>  
                            <div class="col-md-3">
                                <input value="<liferay-ui:message key="Add" />" type="button" onclick="saveToDatabase('addProfileInfo','frmAddJobWishList','addnewjobwishlist','#addjobwishlist')" id="addnewjobwishlist" name="addnewjobwishlist" class="btn btn-primary addBtnProf float-left">
                                <button type="reset" class="btn btn-secondary float-right" data-dismiss="modal"><liferay-ui:message key="Cancel" /></button>
                           
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>

    <div class="modal fade" id="addintrest" tabindex="-1" role="dialog" aria-labelledby="addintrestLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header text-white modal-header-bg bg-info">
                    <h5 class="modal-title" id="addintrestLabel">
                        <label><liferay-ui:message key="AddIntrest" /></label>
                    </h5>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmAddIntrest" class="bootstrap-form needs-validation" novalidate>
                       <input type="hidden" id="intrestId" name="intrestId" value="0"> 
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label><liferay-ui:message key="Interest" /></label><span class="text-danger">*</span>
<!--                                 <input type="text" id="intrest" name="intrest" class="form-control" required /> -->
									<select class="js-example-tags form-control" multiple="multiple" style="width:100%;" id="intrest" name="<liferay-ui:message key="Interest" />" required>
									</select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 form-group" id="intDvIntrest"></div>
                        </div>
                        <div class="row pt-2">
                            <div class="col-md-3">
                              </div>
                            <div class="col-md-6">
			                    <div id="alertContainer" style="display:none; line-height: 0.7; text-align: center; font-size: small;" class="alert-notifications alertContainerClass">
								  	<div class="alert alert-success fade alert-dismissible show" role="alert">
										<span id="alertText" class="alertTextClass"></span>
									</div>
							    </div>    
							</div>  
                            <div class="col-md-3">
                               <input value="<liferay-ui:message key="Add" />" type="button" onclick="saveToDatabase('addProfileInfo','frmAddIntrest','addnewintrest','#addintrest')" id="addnewintrest" name="addnewintrest" class="btn btn-primary addBtnProf float-left">
                               <button type="reset" class="btn btn-secondary float-right" data-dismiss="modal"><liferay-ui:message key="Cancel" /></button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>

    <div class="modal fade" id="addskills" tabindex="-1" role="dialog" aria-labelledby="addskillsLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header text-white modal-header-bg bg-info">
                    <h5 class="modal-title" id="addskillsLabel">
                        <label><liferay-ui:message key="AddSkills" /></label>
                    </h5>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmaddskills" class="bootstrap-form needs-validation" novalidate>
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label><liferay-ui:message key="Skill" /></label><span class="text-danger">*</span>
									<select class="js-example-tags form-control" multiple="multiple"  style="width:100%;" id="skillname" name="<liferay-ui:message key="Skill" />" required>
	                                    <option id='Analytical'>Analytical</option>
										<option id='Communication'>Communication</option>
										<option id='Computer'>Computer</option>
										<option id='Conceptual'>Conceptual</option>
										<option id='Core Competencies'>Core Competencies</option>
										<option id='Creative thinking'>Creative thinking</option>
										<option id='Critical thinking'>Critical thinking</option>
										<option id='Decision-making'>Decision-making</option>
										<option id='Employability'>Employability</option>
										<option id='Interpersonal'>Interpersonal</option>
										<option id='Language'>Language</option>
										<option id='Management'>Management</option>
										<option id='Marketing'>Marketing</option>
										<option id='Microsoft Office'>Microsoft Office</option>
										<option id='Nursing'>Nursing</option>
										<option id='Organizational'>Organizational</option>
										<option id='Problem-solving'>Problem-solving</option>
										<option id='Project management'>Project management</option>
										<option id='Soft vs hard'>Soft vs hard</option>
										<option id='Soft'>Soft</option>
										<option id='Teamwork'>Teamwork</option>
										<option id='Technical'>Technical</option>
										<option id='Time management'>Time management</option>
										<option id='Transferable'>Transferable</option>
									</select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 form-group" id="intDvSkills"></div>
                        </div>
                        <div class="row pt-2">
                            <div class="col-md-3">
                              </div>
                            <div class="col-md-6">
			                    <div id="alertContainer" style="display:none; line-height: 0.7; text-align: center; font-size: small;" class="alert-notifications alertContainerClass">
								  	<div class="alert alert-success fade alert-dismissible show" role="alert">
										<span id="alertText" class="alertTextClass"></span>
									</div>
							    </div>    
							</div>  
                            <div class="col-md-3">
                                <!--<button type="submit" class="btn btn-primary float-right">Add</button>-->
                               <input value="<liferay-ui:message key="Add" />" type="button" onclick="saveToDatabase('addProfileInfo','frmaddskills','addsuserkills','#addskills')" id="addsuserkills" name="addsuserkills" class="btn btn-primary addBtnProf float-left">
                               <button type="reset" class="btn btn-secondary float-right" data-dismiss="modal"><liferay-ui:message key="Cancel" /></button>
                               </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="addhonorandaward" tabindex="-1" role="dialog" aria-labelledby="addhonorandawardLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header text-white modal-header-bg bg-info">
                    <h5 class="modal-title" id="addhonorandawardLabel">
                        <label>Add Honour and Awards</label>
                    </h5>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmhonor" class="bootstrap-form needs-validation" novalidate>
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label>Title</label>
                                <input type="text" id="honortitle" name="honortitle" class="form-control" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Issuer</label>
                                <input type="text" id="honorissuer" name="honorissuer" class="form-control" />
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Issue date</label>
                                <input type="date" id="honorissuedate" class="form-control" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label>Description</label>
                                <textarea id="issuedescription" name="hornordescrption" class="form-control" rows="5"></textarea>
                            </div>
                        </div>
                        <div class="row pt-2">
                            <div class="col-md-3">
                                <button type="reset" class="btn btn-secondary float-left" data-dismiss="modal"><liferay-ui:message key="Cancel" /></button>
                            </div>
                            <div class="col-md-6">
			                    <div id="alertContainer" style="display:none; line-height: 0.7; text-align: center; font-size: small;" class="alert-notifications alertContainerClass">
								  	<div class="alert alert-success fade alert-dismissible show" role="alert">
										<span id="alertText" class="alertTextClass"></span>
									</div>
							    </div>    
							</div>  
                            <div class="col-md-3">
                                <!--<input value="Add" type="button" onclick="saveToDatabase('addProfileInfo','frmhonor','adduserhonorandaward','#addhonorandaward')" id="adduserhonorandaward" name="adduserhonorandaward" data-dismiss="modal" class="btn btn-primary float-right">-->
                                <!--<a href="#" id="adduserhonorandaward" name="adduserhonorandaward" data-dismiss="modal" class="btn btn-outline-primary float-right">Save</a>-->
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

<div class="modal fade" id="addlanguage" tabindex="-1" role="dialog" aria-labelledby="addlanguageLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header text-white  modal-header-bg">
                    <h5 class="modal-title" id="addlanguageLabel">
                        <label>Add Languages</label>
                    </h5>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmAddLanguage" class="bootstrap-form needs-validation" novalidate>
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label>Language</label><span class="text-danger">*</span>
                                <select name="language" id="language" class="form-control">
                                    <option value="">select</option>
                                    <option value="Arabic">Arabic</option>
                                    <option value="English">English</option>
                                    <option value="French">French</option>
                                </select>
                            </div>                           
                        </div>
                        <div class="row pt-2">
                            <div class="col-md-3"></div>
                            <div class="col-md-6">
			                    <div id="alertContainer" style="display:none; line-height: 0.7; text-align: center; font-size: small;" class="alert-notifications alertContainerClass">
								  	<div class="alert alert-success fade alert-dismissible show" role="alert">
										<span id="alertText" class="alertTextClass"></span>
									</div>
							    </div>    
							</div>  
                            <div class="col-md-3">
                                <input value="<liferay-ui:message key="Add" />" type="button" onclick="saveToDatabase('addProfileInfo','frmAddLanguage','addlanguage','#addlanguage')" id="addlangugae" name="addlangugae" class="btn btn-primary float-left">  
                                <button type="reset" class="btn btn-secondary float-right" data-dismiss="modal"><liferay-ui:message key="Cancel" /></button>
                             </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
    <!--End of Modal-->
    <script src="${themeDisplay.getPathThemeRoot()}/js/select2.js"></script>
    <link href="${themeDisplay.getPathThemeRoot()}/css/select2.css" rel="stylesheet" /> 
    <script src="${themeDisplay.getPathThemeRoot()}/js/from/jquery.dataTables.min.js"></script>
    <script src="${themeDisplay.getPathThemeRoot()}/js/from/dataTables.bootstrap4.min.js"></script>
    <script type="text/javascript">
    var viewModeJS = "<%=viewMode%>";
    var logUserId = '<%=loginUserId%>' ;
    var userId = <%=userId%>;   
    var dis1 = document.getElementById("workendate");
    var dis2 = document.getElementById("worktillnow");
    
    dis1.onchange = function () {
      if (dis1.value !== "" || dis1.value.length > 0) {
        dis2.disabled = true;
      } else {
        dis2.disabled = false;
      }
    };

    dis2.onchange = function () {
      if ($('#worktillnow').is(":checked") !== false ) {
//         dis1.disabled = true;
        $("#workendate").css("display","none");
        $("#presentSpan").css("display","block");
      } else {
//         dis1.disabled = false;
        $("#workendate").css("display","block");
        $("#presentSpan").css("display","none");
      }
    };
    
//     var dis3 = document.getElementById("endyear");
//     var dis4 = document.getElementById("educatetillnow");
//     dis3.onchange = function () {
//       if (dis3.value !== "" || dis3.value.length > 0) {
//         dis4.disabled = true;
//       } else {
//         dis4.disabled = false;
//       }
//     };
//     dis4.onchange = function () {
//       if ($('#educatetillnow').is(":checked") !== false ) {
//         dis3.disabled = true;
//       } else {
//         dis3.disabled = false;
//       }
//     };
    
    $(document).ready(function () {
    	randomQuote("sec-abut");
    	randomQuote("sec-mision");
   	    $(".js-example-tags").select2({
    	  tags: true
    	});
   	    $(".js-example-tags1").select2({
    	  tags: true,
    	  maximumSelectionLength: 1
    	});
    	
        	maxLength(document.getElementById("about"));
        	maxLength(document.getElementById("educationdescription"));
         	maxLength(document.getElementById("workdescription"));
        	maxLength(document.getElementById("testimonialprivatemessage"));
        	maxLength(document.getElementById("firstname"));
        	maxLength(document.getElementById("fatherName"));
        	maxLength(document.getElementById("email"));
        	maxLength(document.getElementById("universitygeneral"));
        	maxLength(document.getElementById("currentworkposition"));
        	maxLength(document.getElementById("currentworklocation"));
        	maxLength(document.getElementById("nationalid"));
        	maxLength(document.getElementById("passportid"));
        	maxLength(document.getElementById("cityofresidence"));
        	maxLength(document.getElementById("postalcode"));
        	maxLength(document.getElementById("nationaladdress"));
        	maxLength(document.getElementById("street"));
        	maxLength(document.getElementById("state"));
        	maxLength(document.getElementById("licencename"));
        	maxLength(document.getElementById("issuingorganization"));
        	maxLength(document.getElementById("credentailurl"));
        	maxLength(document.getElementById("university"));
        	maxLength(document.getElementById("company"));
        	maxLength(document.getElementById("location"));
        	maxLength(document.getElementById("testimonialprovidername"));
        	maxLength(document.getElementById("testimonialprovideremail"));
        	maxLength(document.getElementById("testimonialprovideorganizationname"));
        	
        	if (userId != logUserId)
        	{   setTimeout(function(){ 
        		$('.display').css('display','none');
        		if($(".control-menu-icon.lfr-portal-tooltip.product-menu-toggle.sidenav-toggler.active.open").length > 0){
        			$(".control-menu-icon.lfr-portal-tooltip.product-menu-toggle.sidenav-toggler.active.open").click();
        		}
        		$("#ControlMenu.control-menu.control-menu-level-1.hidden-print").hide();
        		$("footer").hide();
        		$("div.container-menu").hide();
        	 }, 300);
        	  setTimeout(function(){ 
        		$('.display').css('display','none');
        		if($(".control-menu-icon.lfr-portal-tooltip.product-menu-toggle.sidenav-toggler.active.open").length > 0){
        			$(".control-menu-icon.lfr-portal-tooltip.product-menu-toggle.sidenav-toggler.active.open").click();
        		}
        		$("#ControlMenu.control-menu.control-menu-level-1.hidden-print").hide();
        		$("footer").hide();
        		$("div.container-menu").hide();
          	 }, 300);
        	}
        	 obj = {};
          	var section = "all";
          	var action = "getProfileInfo";
          	obj.userId = <%=userId%>; 
 	    	getprofileDetails('all','getProfileInfo',obj);
 	    
            var awardsdata = [
                { "title": "Achiever", "percentage": "99%" , "organization":"Youth HUB" },
                { "title": "Role Model", "percentage": "92%" , "organization":"Youth HUB" },
                { "title": "Seeker", "percentage": "79%" , "organization":"Youth HUB" },
                { "title": "Explorer", "percentage": "59%" , "organization":"Youth HUB"}
            ]

             $.each(awardsdata, function (i, item) {
                if (i == 0) {
                    $('#lblachieverpercentage').text(item.percentage)
                    $('#lblachievertitle').text(item.title);
                    $('#lblachieverorg').text(item.organization);
                                   
                }
                if (i == 1) {
                      $('#lblrolemodelpercentage').text(item.percentage)
                    $('#lblrolemodeltitle').text(item.title);
                    $('#lblrolemodelorg').text(item.organization);
                   
                }
                 if (i == 2) {
                    $('#lblseekerpercentage').text(item.percentage)
                     $('#lblseekertitle').text(item.title);
                      $('#lblseekerorg').text(item.organization);
                     
                 }
                   if (i == 3) {
                    $('#lblexplorepercentage').text(item.percentage)
                       $('#lblexplorertitle').text(item.title);
                        $('#lblexplorerorg').text(item.organization);
                }
             });

            var filepath;
            $('#dvskills').css("display", "none");
            $('#dvjobwishlist').css("display", "none");
            $('#dvaboutme').css("display", "none");
            $('#dveducation').css("display", "none");
            $('#dvworkexperience').css("display", "none");
            $('#dvresume').css("display", "none");
            $('#dvtestimonial').css("display", "none");
            $('#dvintrest').css("display", "none");
            $('#dvcertificate').css("display", "none");
            $('#dvlanguage').css("display", "none");
            
           var oTableresume = $('#tblresume').DataTable({
                "pagingType": "full_numbers",
                responsive: true,
                paging: false,
                bFilter: false,
                bInfo: false
            });

            var resumerow = 0;
            $('#adduserresume').on('click', function () {
            	if (userId != logUserId)
            		$('.display').css('display','none');
            	
            	resumerow = resumerow + 1;
                $('#dvresume').css("display", "");
                var title = $("#resumetitle").val();
                var rtype = $("#resumetype option:selected").text();
                var rfile = $("#resumefile").val().split("\\")[1];
                var data = [
                    '<h5 class="educationList-title">' + title + '<span class="float-right"><a class="display" data-toggle="modal" data-target="#addresume" href="#"><i class="fa fa-pencil"></i></a><a href="#"  onclick="deleteresume(' + resumerow + ')"><i class="fa fa-trash-o" style="margin-left:10px"></i></a></span></h5><p class="educationList-subtitle">' + rtype + '<br/> <a href="#"><i class="fa fa-file"></i>' + rfile + '</a></p>'
                ];
                oTableresume.row.add(data).draw();
                $('#resumeempty').css("display", "none");
            });
        });
        function getAchievmentAwards(json){
			if(json.profileAchievementsAndAwards.length > 0 )
			{
	        	if(json.profileAchievementsAndAwards[0].isSpeaker == "0")
	        	{
		        	 jQuery('#UlAchievementsAwards').html(''); 
		        	 jQuery('#spanAchievements').html(''); 
		        	 var cntr = json.profileAchievementsAndAwards[0].cntr;
		        	 if(cntr > 4 || cntr == 0){
		        	   $("#UlAchievementsAwards").append('<li><div class="img-achv"><svg xmlns="http://www.w3.org/2000/svg" width="34.426" height="34.414" viewBox="0 0 34.426 34.414"><defs><style>.a{fill:#fff;}</style></defs><path class="a" d="M29.386,5.088A17.214,17.214,0,0,0,1.021,23.1a.7.7,0,1,0,1.318-.475,15.813,15.813,0,1,1,26.336,5.519l-.1.107c-.059.063-.118.126-.18.188a15.832,15.832,0,0,1-22.364,0c-.033-.033-.065-.066-.1-.1,0-.065,0-.128,0-.191q0-.212.008-.422c0-.047.005-.093.008-.14,0-.093.009-.186.016-.279,0-.055.01-.11.015-.165.007-.083.014-.167.023-.25.006-.059.015-.117.022-.175.01-.079.019-.158.031-.236.009-.06.019-.119.029-.178.012-.076.025-.153.039-.229.011-.06.024-.12.036-.179s.03-.149.046-.224.028-.12.043-.18.035-.146.054-.218.033-.12.049-.179.04-.143.061-.214.037-.119.056-.178.045-.14.069-.21.041-.117.062-.176.05-.138.076-.207.045-.115.068-.173.055-.136.083-.2.049-.114.075-.171.059-.133.09-.2.053-.112.08-.168.064-.131.1-.2.057-.11.086-.164.069-.129.1-.193.06-.107.091-.16.074-.126.112-.189l.1-.157q.059-.093.119-.185t.1-.153c.041-.061.083-.121.126-.181s.071-.1.107-.149.088-.118.133-.176.074-.1.112-.144.093-.115.14-.172.077-.093.116-.14.1-.113.147-.169.08-.09.12-.135.1-.11.154-.164l.124-.13c.053-.054.107-.107.162-.16s.085-.083.128-.124.113-.1.17-.156.086-.079.13-.118.119-.1.179-.153c.044-.037.087-.075.132-.111.062-.051.126-.1.189-.149.044-.034.088-.07.132-.1.067-.051.135-.1.2-.148.043-.031.085-.063.128-.093.075-.053.152-.1.228-.154l.113-.076c.1-.065.2-.128.3-.189l.047-.029q.177-.106.359-.206l.126-.066c.08-.043.161-.086.243-.127.052-.026.106-.051.159-.077s.133-.065.2-.1a6.819,6.819,0,0,0,9.445,0,11.41,11.41,0,0,1,5.609,5.709.7.7,0,1,0,1.283-.564A12.631,12.631,0,0,0,22.871,16.8,6.836,6.836,0,0,0,17.214,6.119a.7.7,0,0,0,0,1.4A5.435,5.435,0,0,1,21.252,16.6h0a5.422,5.422,0,0,1-8.077,0h0a5.43,5.43,0,0,1,.211-7.507.7.7,0,0,0-.986-1,6.829,6.829,0,0,0-.846,8.7l-.02.011c-.055.027-.108.056-.162.084-.083.043-.166.086-.248.13-.058.032-.115.065-.172.1-.076.043-.153.086-.229.131l-.174.106c-.072.045-.145.089-.216.135s-.115.076-.173.114-.138.092-.207.14l-.171.121c-.067.048-.133.1-.2.145l-.167.128q-.1.075-.191.151l-.163.134q-.093.078-.185.157l-.158.139q-.09.081-.178.164l-.152.144c-.058.056-.116.113-.173.171s-.1.1-.146.147-.112.119-.168.178-.093.1-.139.151-.109.125-.164.187-.087.1-.13.151-.108.133-.162.2c-.04.05-.08.1-.12.149-.056.072-.111.146-.165.22-.034.046-.07.092-.1.138-.069.1-.136.193-.2.291l-.053.076q-.124.185-.241.374c-.027.044-.052.088-.079.132-.051.084-.1.168-.15.253-.03.053-.059.107-.089.161-.043.077-.085.154-.126.232-.03.058-.059.116-.089.175-.038.075-.076.15-.113.226-.029.06-.057.122-.085.183s-.069.15-.1.226-.053.126-.08.188-.063.151-.093.227-.05.128-.074.193-.057.153-.084.23-.046.131-.068.2-.051.155-.076.232-.041.133-.061.2-.046.157-.068.237-.037.134-.054.2-.04.16-.059.241-.032.134-.047.2-.035.164-.051.246-.027.135-.039.2c-.015.084-.029.168-.043.253-.011.067-.022.133-.032.2-.013.087-.023.175-.034.262-.008.065-.017.13-.024.195-.01.092-.018.184-.026.277-.005.062-.012.123-.016.185-.007.1-.012.207-.017.31,0,.051-.006.1-.008.154q-.008.233-.009.468c0,.169.006.329.013.506a.716.716,0,0,0,.016.119l0,.009a.691.691,0,0,0,.035.11l0,.011a.7.7,0,0,0,.053.1l.008.012a.713.713,0,0,0,.069.088l.005.006.092.1c.07.075.14.149.213.222a17.234,17.234,0,0,0,24.346,0c.073-.073.143-.147.213-.222l.092-.1a17.212,17.212,0,0,0-.3-24.025Z" transform="translate(0 -0.054)"/></svg></div><span>Youth Hub</span><p>'+Liferay.Language.get("Novice")+'</p></li>');
		        	 }
		        	 if(cntr > 9 || cntr == 0){
		          	   $("#UlAchievementsAwards").append('<li><div class="img-achv"><svg xmlns="http://www.w3.org/2000/svg" width="37.801" height="37.787" viewBox="0 0 37.801 37.787"><defs><style>.a{fill:#fff;}</style></defs><g transform="translate(57.836 -296.243)"><g transform="translate(-57.836 296.243)"><path class="a" d="M-42.817,710.732a.687.687,0,0,0,.647.739.821.821,0,0,0,.747-.713.687.687,0,0,0-.705-.681A.625.625,0,0,0-42.817,710.732Z" transform="translate(43.928 -679.464)"/><path class="a" d="M.139,303.626A2.4,2.4,0,0,0,.066,304c-.031.759.007,1.527-.092,2.277-.15,1.136-.35,2.269-.606,3.385a21.956,21.956,0,0,1-2.216,5.758c-.609,1.095-1.342,2.121-2.034,3.169a.592.592,0,0,0-.092.6,7.285,7.285,0,0,1,.362,3.282,7.646,7.646,0,0,1-2.028,4.671c-1.6,1.69-3.256,3.324-4.891,4.979a.8.8,0,0,1-1.246-.006c-1.729-1.775-3.512-3.5-5.234-5.279a1.168,1.168,0,0,0-1.151-.348c-.646.1-1.291.2-1.938.29-.527.077-1.054.159-1.583.217a1.057,1.057,0,0,1-1.12-.371,3.293,3.293,0,0,0-.342-.365c-.108.1-.2.192-.3.284-1.936,1.935-3.865,3.876-5.816,5.8a1.157,1.157,0,0,1-.76.321.834.834,0,0,1-.543-.45.627.627,0,0,1,.184-.731c.861-.848,1.71-1.707,2.565-2.561l3.62-3.615-3.74-3.739c-1.442,1.442-2.905,2.908-4.371,4.371a.678.678,0,0,1-1.2-.258.784.784,0,0,1,.3-.834q2.012-2.015,4.027-4.028c.087-.087.18-.169.345-.323-.144-.107-.266-.2-.394-.293a1.024,1.024,0,0,1-.406-1.069c.14-.994.289-1.987.431-2.981.057-.395.125-.79.145-1.187.006-.114-.12-.255-.217-.352-1.827-1.835-3.648-3.675-5.5-5.487a.785.785,0,0,1-.012-1.193c1.564-1.575,3.109-3.169,4.714-4.7a8.04,8.04,0,0,1,4.348-2.172,6.935,6.935,0,0,1,3.61.219c.614.237.962-.073,1.36-.362a21.418,21.418,0,0,1,5.535-2.976c1.248-.435,2.516-.832,3.8-1.144a21.5,21.5,0,0,1,2.837-.408c.812-.085,1.631-.134,2.448-.143.569-.006,1.14.079,1.709.13.533.047,1.07.072,1.6.161.879.148,1.753.329,2.624.52a.748.748,0,0,1,.559.655c.216,1.15.45,2.3.62,3.456.089.6.058,1.222.088,1.833a1.2,1.2,0,0,0,.072.26Zm-2.013-5.376c-1.437-.187-2.8-.44-4.167-.523a17.24,17.24,0,0,0-4.391.2c-1.181.234-2.376.426-3.532.755a19.929,19.929,0,0,0-5.347,2.363,37.313,37.313,0,0,0-3.316,2.4,18.721,18.721,0,0,0-2.054,2.043,27,27,0,0,0-1.735,2.151,22.516,22.516,0,0,0-2.867,5.468.506.506,0,0,0,.136.633q3.674,3.646,7.326,7.315,2.248,2.248,4.493,4.5a.394.394,0,0,0,.507.117c.751-.328,1.527-.6,2.265-.955a23.526,23.526,0,0,0,4.495-2.844,22.385,22.385,0,0,0,3.481-3.449,23.69,23.69,0,0,0,3.454-5.8,23.759,23.759,0,0,0,1.773-7.655,20.444,20.444,0,0,0-.071-2.979C-1.526,300.764-1.714,299.545-1.875,298.25Zm-21.931,4.3a6.575,6.575,0,0,0-3.455.1,7.216,7.216,0,0,0-3.139,1.891c-1.236,1.221-2.457,2.457-3.692,3.68a1,1,0,0,1-.313.159l3.924,3.923A24.615,24.615,0,0,1-23.805,302.546Zm17.631,17.62a24.643,24.643,0,0,1-9.769,6.686l3.839,3.836c.02-.017.068-.053.11-.095,1.307-1.307,2.635-2.594,3.91-3.931a9.276,9.276,0,0,0,1.241-1.693,6.217,6.217,0,0,0,.786-2.5A6.913,6.913,0,0,0-6.174,320.166Zm-22.6-3.953c-.027.12-.067.252-.086.386-.1.67-.214,1.338-.27,2.011-.021.255-.186.522.094.8,2.016,1.988,4.012,4,6.017,6,.073.073.18.175.259.166.719-.085,1.436-.188,2.152-.292.261-.038.52-.092.763-.135Z" transform="translate(37.662 -296.243)"/><path class="a" d="M-57.836,716.071c.13-.141.254-.288.39-.423q2.766-2.77,5.536-5.537a.711.711,0,0,1,1.17.076.753.753,0,0,1-.173.921q-2,2-4,4-.771.77-1.542,1.54c-.136.135-.282.26-.423.39h-.962Z" transform="translate(57.836 -679.245)"/><path class="a" d="M-42.817,710.732a.625.625,0,0,1,.689-.655.687.687,0,0,1,.705.681.821.821,0,0,1-.747.713A.687.687,0,0,1-42.817,710.732Z" transform="translate(43.928 -679.464)"/><path class="a" d="M181.97,415.169l1.976-7.38-7.38,1.973c.39.383.72.7,1.046,1.03a.7.7,0,0,1,.007,1.137q-1.659,1.661-3.32,3.321a.671.671,0,0,1-.832.145.608.608,0,0,1-.372-.72,1.264,1.264,0,0,1,.333-.54c.907-.923,1.827-1.833,2.784-2.788-.464-.45-.927-.885-1.372-1.338a.755.755,0,0,1-.025-1.177,1.705,1.705,0,0,1,.561-.232q4.656-1.247,9.315-2.486a.726.726,0,0,1,.77.182.76.76,0,0,1,.144.775c-.462,1.683-.9,3.372-1.354,5.059-.394,1.477-.806,2.949-1.179,4.432a.765.765,0,0,1-1.349.336c-.439-.45-.884-.893-1.341-1.355-.106.1-.2.189-.293.281q-2.51,2.51-5.021,5.019c-.495.493-1.128.348-1.241-.317a.976.976,0,0,1,.29-.706c1.465-1.5,2.954-2.972,4.435-4.454l1.177-1.177c.5-.5.785-.5,1.294.015C181.318,414.5,181.608,414.8,181.97,415.169Z" transform="translate(-155.995 -397.952)"/><path class="a" d="M140.207,548.813a.66.66,0,0,1-.709-.7.723.723,0,0,1,1.445.052A.687.687,0,0,1,140.207,548.813Z" transform="translate(-124.9 -528.855)"/></g></g></svg></div><span>Youth Hub</span><p>'+Liferay.Language.get("Beginner")+'</p></li>');
		          	 }
		        	 if(cntr > 13 || cntr == 0){
		          	   $("#UlAchievementsAwards").append('<li><div class="img-achv"><svg xmlns="http://www.w3.org/2000/svg" width="46.48" height="46.581" viewBox="0 0 46.48 46.581"><defs><style>.a{fill:#fff;}</style></defs><path class="a" d="M83.445,55.142a8.664,8.664,0,0,0-4.4-10.635l-.309-.746a.685.685,0,0,0-.37-.37.678.678,0,0,0-.523,0L71.774,45.9a2.143,2.143,0,0,0-1.159,2.8l.018.045L46.8,58.753a1.413,1.413,0,0,0-.765,1.846l.3.716-4.8,1.988-.017-.042a1.413,1.413,0,0,0-1.846-.765l-1.348.559a1.413,1.413,0,0,0-.764,1.846l2.232,5.389a1.411,1.411,0,0,0,1.846.765l1.348-.558a1.413,1.413,0,0,0,.765-1.846l-.018-.042,4.8-1.989.3.716a1.415,1.415,0,0,0,1.305.873,1.416,1.416,0,0,0,.544-.109l1.911-.8a.606.606,0,0,0,.212-.089l5.695-2.39a2.817,2.817,0,0,0,.255.269L45.512,88.9a.684.684,0,1,0,1.2.664l5.476-9.857h7.827v9.525a.684.684,0,0,0,1.368,0V79.71h7.827l5.476,9.857a.684.684,0,1,0,1.195-.664L62.646,65.087a2.866,2.866,0,0,0,.92-2.1c0-.1-.005-.2-.014-.29l10.953-4.6.017.04a2.142,2.142,0,0,0,2.8,1.159l6.064-2.512a.683.683,0,0,0,.37-.893ZM42.479,69.209a.043.043,0,0,1-.024.025l-1.348.558a.043.043,0,0,1-.035,0,.044.044,0,0,1-.025-.025l-2.232-5.389a.044.044,0,0,1,0-.035.041.041,0,0,1,.025-.025l1.347-.558a.047.047,0,0,1,.017,0,.045.045,0,0,1,.018,0,.047.047,0,0,1,.025.024l1.116,2.695L42.2,68.5h0l.279.673A.044.044,0,0,1,42.479,69.209Zm.723-1.863-.576-1.39-.575-1.389,4.8-1.989L48,65.357ZM82,49.511a7.277,7.277,0,0,1,.529,3.42l-2.573-6.213A7.281,7.281,0,0,1,82,49.511ZM50.145,66.838a.044.044,0,0,1-.035,0,.044.044,0,0,1-.025-.025l-1.4-3.369-.837-2.021h0l-.559-1.347a.049.049,0,0,1,0-.035.047.047,0,0,1,.028-.026l1.384-.581,2.825,6.822ZM62.2,62.983a1.5,1.5,0,1,1-1.5-1.5A1.506,1.506,0,0,1,62.2,62.983ZM52.944,78.342l6.994-12.59.073.019V78.342Zm15.5,0H61.379V65.771l.072-.019ZM63.091,61.4a2.87,2.87,0,0,0-5.2,2.184l-5.1,2.139L49.967,58.9l21.19-8.9,2.825,6.821ZM76.8,58.03a.776.776,0,0,1-1.012-.42l-3.907-9.432a.775.775,0,0,1,.419-1.012l5.432-2.25,4.5,10.864Z" transform="translate(-37.443 -43.339)"/></svg></div><span>Youth Hub</span><p>'+Liferay.Language.get("Seeker")+'</p></li>');
		          	 }
		        	 if(cntr != 0)
		        	 $("#spanAchievements").append('To achieve next: '+json.profileAchievementsAndAwards[0].description);
	       		}
	        	else{
	        		$(".nonSpeaker").hide();
	        	}
			}

			if(json.profileProgress.length > 0 )
			{
				 var objProg = {
	        		photos: json.profileProgress[0].photos,
	        		publicProfile: json.profileProgress[0].publicProfile,
	        		education: json.profileProgress[0].education,
	        		experience: json.profileProgress[0].experience,
	        		certificate: json.profileProgress[0].certificate,
	        		skills: json.profileProgress[0].skills,
	        		interest: json.profileProgress[0].interest
	        	}
				 
	        	var translation = [];
	        	translation["photos"] = "<liferay-ui:message key='Photo' />";
	        	translation["publicProfile"] = "<liferay-ui:message key='PublicProfile' />";
	        	translation["education"] = "<liferay-ui:message key='Education' />";
	        	translation["experience"] = "<liferay-ui:message key='Experience' />";
	        	translation["certificate"] = "<liferay-ui:message key='Certificates' />";
	        	translation["skills"] = "<liferay-ui:message key='Skill' />";
	        	translation["interest"] = "<liferay-ui:message key='Interest' />";
	        	$(".progress-bar").addClass("pending-progress-bar");
				$(".progress-bar").removeClass("progress-bar");
				$(".progress-intermediate").addClass("pending-progress-intermediate");
    			$(".progress-intermediate").removeClass("progress-intermediate");
    			$(".progress-all-star").addClass("pending-progress-all-star");
    			$(".progress-all-star").removeClass("progress-all-star");
        		var doneCount = 0;
        		var count = 0;
        		var step = "";
        		for(var keyProg in objProg) {
        			count++;
        			if(objProg[keyProg]==true){
        				step += "<div><i class='fa fa-check'></i>"+ translation[keyProg] + "</div>";
        				doneCount++;
        				$(".pending-progress-bar").eq(0).addClass("progress-bar");
        				$(".pending-progress-bar").eq(0).removeClass("pending-progress-bar");
        			}else{
        				step += "<div><i class='fa'></i>"+ translation[keyProg] + "</div>";
        			}
        		}
        		if(doneCount>=4){
        			$(".pending-progress-intermediate").addClass("progress-intermediate");
        			$(".pending-progress-intermediate").removeClass("pending-progress-intermediate");
        		}
        		if(count==doneCount){
        			$(".pending-progress-all-star").addClass("progress-all-star");
        			$(".pending-progress-all-star").removeClass("pending-progress-all-star");
        		}
        		$(".bar").attr("data-content","<div><h6><liferay-ui:message key='Stepscompleted' /></h6>"+step+"</div>");
        		$('.popover-1').popover({
        			trigger: "manual" ,
        			container: "body",
        			placement: "bottom",
        			html: true,
        			animation:false
        		}).on("mouseenter", function () {
        			var _this = this;
        			$(this).popover("show");
        			$(".popover").on("mouseleave", function () {
        				$(_this).popover('hide');
        			});
        		}).on("mouseleave", function () {
        			var _this = this;
        			setTimeout(function () {
        				if (!$(".popover:hover").length) {
        					$(_this).popover("hide");
        				}
        			}, 300);
        		});
			}
        }
        
        var testimonialrow = 0;
        function getTestimonialSaved(json)
        {
     	   for( var i =0;i< json.profileTestimonials.length; i++)
            { 
            testimonialrow = testimonialrow + 1;
            $('#dvtestimonial').css("display", "");
            var name = json.profileTestimonials[i].name;
            var organization = json.profileTestimonials[i].organization;
            var title = json.profileTestimonials[i].title;
            var message = json.profileTestimonials[i].message;
            var img = "/o/new-misk-theme/images/profile/blank.png";
            if (json.profileTestimonials[i].img != "")
                img = json.profileTestimonials[i].img;
            var id = json.profileTestimonials[i].id;
            
            var firstitemstring = '<div class="carousel-item active"><div class="row"><div class="col-md-12 text-center testi"><blockquote style="margin-left:50px !important;margin-right:50px !important"><a class="display" onclick="deleteProfileRow(' + 0 + ',' + id + ',\'deleteTestimonialInfo\',\'deleteData\',\'#test\')"><img src="/o/new-misk-theme/images/profile/bin.png" style="position: absolute;right: 5px;margin-top: 5px;cursor:pointer;"></a>';
            firstitemstring = firstitemstring + '<span class="testimonial-text" style="margin-top:50px !important"> "' + message + '"</span><br /></blockquote><div id="photo" style="text-align: center">';
            firstitemstring = firstitemstring + '</div></div></div><div class="row"><div class="col-md-5 text-right"><img src="' + img + '" class="img-fluid-testimo rounded-circle" /></div>';
            firstitemstring = firstitemstring + '<div class="col-md-7 text-left pt-3" ><p><span class="testimonial-provide-text">' + name + '</span><br />';
            firstitemstring = firstitemstring + '<span class="testimonial-organization-text">' + title + ' at ' + organization + '</span></p></div></div></div>';

            var itemstring = '<div class="carousel-item"><div class="row"><div class="col-md-12 text-center testi"><blockquote style="margin-left:50px !important;margin-right:50px !important"><a class="display" onclick="deleteProfileRow(' + 0 + ',' + id + ',\'deleteTestimonialInfo\',\'deleteData\',\'#test\')"><img src="/o/new-misk-theme/images/profile/bin.png" style="position: absolute;right: 5px;margin-top: 5px;cursor:pointer;"></a>';
            itemstring = itemstring + '<span class="testimonial-text" style="margin-top:50px !important"> "' + message + '"</span><br /></blockquote><div id="photo" style="text-align: center">';
            itemstring = itemstring + '</div></div></div><div class="row"><div class="col-md-5 text-right"><img src="' + img + '" class="img-fluid-testimo rounded-circle" /></div>';
            itemstring = itemstring + '<div class="col-md-7 text-left pt-3" ><p><span class="testimonial-provide-text">' + name + '</span><br />';
            itemstring = itemstring + '<span class="testimonial-organization-text">' + title + ' at ' + organization + '</span></p></div></div></div>';
            if (testimonialrow == 1) {
                $("#testimonialindicator").append('<li data-target="#myCarousel" data-slide-to="' + testimonialrow + '" class="active"></li>');
                $("#testimonialitem").append(firstitemstring);
            }
            else {
                $("#testimonialindicator").append('<li data-target="#myCarousel" data-slide-to="' + testimonialrow + '"></li>');
                $("#testimonialitem").append(itemstring);
            }

            $('#testimonialempty').css("display", "none");
        }
        }
        
        function maxLength(el) {    
        	return;
            if (!('maxLength' in el)) {
                var max = el.attributes.maxLength.value;
                el.onkeypress = function () {
                    if (this.value.length >= max) return false;
                };
            }
        }
        function inIframe () {
            try {
                return window.self !== window.top;
            } catch (e) {
                return true;
            }
        }
        $(function () {
            $('[data-toggle="tooltip"]').tooltip()
        });
        $("#profileimage").click(function () {
        	if(viewModeJS == "false")
            	$("input[id='profilepic_file']").click();
        });

        $("#profilepic_file").on('change', function () {
            readURL(this);
        });
        $("#imageUpload").change(function() {
            readURLTestimonial(this);
        });
        var readURL = function (input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function (e) {
             	     $('#profileimage').attr('src', e.target.result);
             	      obj = {};
                    obj.command = "saveProfileImage";
  	        	    obj.userId     =  <%=userId%>; 
  	        	    obj.image = $("#profileimage")[0].src;
  	        	    var command = "saveProfileImage";
  	        	    var action = "addProfileInfo";
  	        	   saveProfileImage(obj,command,action);
                }
                reader.readAsDataURL(input.files[0]);
            }
        }
        function readURLTestimonial(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function(e) {
                    $('#imgPreview').css('background-image', 'url('+e.target.result +')');
                    $('#imgPreview').hide();
                    $('#imgPreview').fadeIn(650);
                    $('#imgPreview input').val(e.target.result);
                }
                reader.readAsDataURL(input.files[0]);
            }
        }
      
        function saveProfileImage(obj,command,action)
        { 
     	   AUI().use('aui-io-request', function(A){
	            A.io.request('${resourceUrl1}', {
	                   method: 'post',
	                   data: {
	                	   <portlet:namespace />obj: JSON.stringify(obj),
	                	   <portlet:namespace />command: command,
	                	   <portlet:namespace />action: action,
	                	},
	                   on: {
	                       	success: function() { getprofileDetails("achievementsAndAwards","getProfileInfo",obj); }
	                  }
	            });
        	});
        }
        
        function deleteresume(rowindex) {
            index = parseInt(rowindex - 1);
            var oTable = $('#tblresume').DataTable();
            oTable.row(index).remove().draw();
        }
        function deleteProfileRow(rowindex,id,command,action,tableId) {
      	  swal({
      			title: "Are you sure?",
      			text:  "You will not be able to recover this Record!",
      			type:  "warning",
      			showCancelButton: true,
      			confirmButtonColor: '#DD6B55',
      			confirmButtonText: 'Yes, delete it!',
      			closeOnConfirm: true,
      			//closeOnCancel: false
      		},
      		function(){
      			   var userId = <%=userId%>; 
      			   obj = {};
                   obj.id = id;
                   obj.userId = userId;
            	   AUI().use('aui-io-request', function(A){
    	               A.io.request('${resourceUrl1}', {
    	                      method: 'post',
    	                      data: {
    	                       <portlet:namespace />obj: JSON.stringify(obj),
    	                   	   <portlet:namespace />command: command,
    	                   	   <portlet:namespace />action: action,
    	                      },
    	                      on: {
    	                          	success: function() {
//     	                          	 swal({title: "Your record has been deleted!", text: "", type: "success"},
//  		                        		   function(){
  	                          		if (command == "deleteIntrest")
                 		         	{
  	                          			jQuery('#dvintrest div').html(''); 
  	                          			jQuery('#intDvIntrest').html(''); 
                          		   		getprofileDetails('userIntrest','getProfileInfo',obj);
                 		         	}   
  	                          		else if (command == "deleteLicenceAndCertificationInfo")
	                 		        { 
  	                          			jQuery('#dvLicensesandCertification').html(''); 
	                          		    getprofileDetails('userLicensesandCertification','getProfileInfo',obj);
	                 		        } 
  	                          		else if (command == "deleteWishJobListInfo")
                          			{ 
	                          			jQuery('#dvjobwishlist').html(''); 
	                          			jQuery('#intJobWishList').html(''); 
                          		        getprofileDetails('userJobWishList','getProfileInfo',obj);
                 		            } 
   	                          		else if (command == "deleteEducationInfo")
	                          		{ 
   	                          			jQuery('#educationList').html(''); 
                           		        getprofileDetails('userEducationSaved','getProfileInfo',obj);
                 		            } 
   	                          		else if (command == "deleteWorkExperienceInfo")
                        			{ 
   	                          			jQuery('#experienceList').html(''); 
                         		        getprofileDetails('userWorkexperienceSaved','getProfileInfo',obj);
                         		    }
 	                          		else if (command == "deleteSkillsInfo")
                         			{  
 	                          			jQuery('#dvskills').html(''); 
 	                          			jQuery('#intDvSkills').html(''); 
                         		        getprofileDetails('userkills','getProfileInfo',obj);
                         		    }
 	                          		else if (command == "deleteTestimonialInfo")
	                          		{ 
 	                          		    jQuery('#testimonialindicator').html(''); 
 	                          			jQuery('#testimonialitem div').html('');
 	                          			getprofileDetails('userTestimonial','getProfileInfo',obj); 
	                 		        } 
//  		                        		   }
//  		                        		);
    	                          	}
    	                     }
    	               });
    	           });
      		});
         }
       
        function getprofileDetails(section,action,obj)
        {
     	   AUI().use('aui-io-request', function(A){
	               A.io.request('${resourceUrl1}', {
	                      method: 'post',
	                      data: {
	                       <portlet:namespace />obj: JSON.stringify(obj),
	                   	   <portlet:namespace />section: section,
	                   	   <portlet:namespace />action: action,
	                      },
	                      on: {
	                          	success: function() {
		                          var json =  JSON.parse(this.get('responseData'));
		                          
								 if (section == "all")
		                           {
										  getEducationSaved(json);
										  getWorkexperienceSaved(json);
										  getnewjobwishlist(json);
										  getnewintrest(json);
										  getnewlicense(json);
										  getuserkillsSaved(json);
										  getTestimonialSaved(json);
										  getAchievmentAwards(json);
		                           }
								 else if (section == "achievementsAndAwards")
								 {
									 getAchievmentAwards(json);
								 }
								 else if (section == "userIntrest")
								 {
									 getnewintrest(json);
									 getprofileDetails("achievementsAndAwards","getProfileInfo",obj);
								 }
								 else if (section == "userLicensesandCertification")
								 {
									 $('#addlicenceandcertification').modal("hide");
								     getnewlicense(json);
								     getprofileDetails("achievementsAndAwards","getProfileInfo",obj);
							     } 
								 else if (section == "userJobWishList")
								 {
									 getnewjobwishlist(json);
									 getprofileDetails("achievementsAndAwards","getProfileInfo",obj);
								 }
								 else if (section == "userEducationSaved")
								 {
									 $('#addeducation').modal("hide");
									 $("#degree").select2();
									 $("#fieldofstudy").select2();
								     getEducationSaved(json);
								     getprofileDetails("achievementsAndAwards","getProfileInfo",obj);
								 } 
								 else if (section == "userWorkexperienceSaved")
								 {
									 $('#addworkexperience').modal("hide");
									 $("#jobtitle").select2();
									 $("#workexperienceId").val('0');
									 getWorkexperienceSaved(json);
									 getprofileDetails("achievementsAndAwards","getProfileInfo",obj);
								 }
								 else if (section == "userTestimonial")
								 {
								     getTestimonialSaved(json);
								     getprofileDetails("achievementsAndAwards","getProfileInfo",obj);
								 }
								 else if (section == "userkills")
								 {
								     getuserkillsSaved(json);
								     getprofileDetails("achievementsAndAwards","getProfileInfo",obj);
								 }
	                         }
	                     }
	               });
	           });
        }
    	function getuserkillsSaved(json){
    		$('#dvskills').empty();
    		$('#intDvSkills').empty();
            $('#skillname').val("").trigger('change');
      		for( var i =0;i< json.profileUserkills.length; i++)
            { 
	            $('#dvskills').css("display", "");
	            var skillname = json.profileUserkills[i].skill;
	            var id = json.profileUserkills[i].id;
	            $("#dvskills").append('<label class="pillbutton2">' + skillname + '</label>');
	            $("#intDvSkills").append('<label class="pillbutton2">' + skillname + ' <a class="display internalSkillView" onclick="deleteProfileRow(' + 0 + ',' + id + ',\'deleteSkillsInfo\',\'deleteData\',\'#tblskills\')"><img src="/o/new-misk-theme/images/profile/bin.png" style="position: absolute;right: 8px;margin-top: 4px;"></a></label>');
           		$('#skillempty').css("display", "none");
            }
       }
    	
         var lagrow = 0;
      	 function getLanguageSaved(json){
      	 	for( var i = 0;i< json.profileLanguages.length; i++)
         	{
      		   lagrow = lagrow + 1;
	           $('#dvlanguage').css("display", "");
	           var lan = json.profileLanguages[i].language;               
	           $("#dvlanguage").append('<label class="pillbutton">' + lan + '</label>');
	           $('#languageempty').css("display", "none");
  			}
      	 }
      	 var intrestrow = 0;
         function getnewintrest(json){
         	intrestrow = intrestrow + 1;
	    	$('#dvintrest').empty();
	    	$('#intDvIntrest').empty();
            $('#intrest').val("").trigger('change');
            for( var i = 0; i < json.profileIntrest.length; i++)
            { 
	             $('#dvintrest').css("display", "");
	             var title =  json.profileIntrest[i].title;
	             var id =  json.profileIntrest[i].id;
	//              $("#dvintrest").append('<div class="row"><div class="col-md-12 pl-3"><label class="textone zerobottom interest">' + title + '</label><a class="display" style="    position: absolute;right: 33px;" data-id='+ id +' data-toggle="modal" data-target="#addintrest" href="#"><i class="fa fa-pencil"></i></a><a class="display" onclick="deleteProfileRow(' + 0 + ',' + id + ',\'deleteIntrest\',\'deleteData\',\'#dvintrest\')"><img src="/o/new-misk-theme/images/profile/bin.png" style="position: absolute;right: 8px;margin-top: 4px;"></a> </div></div>');
	             $("#dvintrest").append('<label class="pillbutton2"> ' + title + '</label>');
	             $("#intDvIntrest").append('<label class="pillbutton2"> ' + title + '<a class="display internalSkillView" onclick="deleteProfileRow(' + 0 + ',' + id + ',\'deleteIntrest\',\'deleteData\',\'#dvintrest\')"><img src="/o/new-misk-theme/images/profile/bin.png" style="position: absolute;right: 8px;margin-top: 4px;"></a></label>');
	             $('#intrestempty').css("display", "none");
             }
        }
    	 var licenserow = 0;
         function getnewlicense(json){ 
        	licenserow = licenserow + 1;
            for( var i = 0; i < json.profileLicensesCertifications.length; i++)
            {
	            $('#dvcertificate').css("display", "");
	            var title =  json.profileLicensesCertifications[i].title;
	            var id =  json.profileLicensesCertifications[i].id;
	            
	            var divVal = '<li><label class="educationList-title zerobottom">' + title + '</label>';
	             
	             if(viewModeJS == "false"){
	             divVal += '<a class="display margin-left-action" data-id='+ id +' data-toggle="modal" data-target="#addlicenceandcertification" href="#">'+
	             '<i class="fa fa-pencil"></i></a><a class="display" onclick="deleteProfileRow(' + 0 + ',' + id + ',\'deleteLicenceAndCertificationInfo\',\'deleteData\',\'#tblLicensesandCertification\')">'+
	             '<img src="/o/new-misk-theme/images/profile/bin.png" style="position: absolute;right: 0;" /></a>';
	             }
	             divVal += '<br /><span class="educationList-subtitle">' + json.profileLicensesCertifications[i].Iorganization + '</span>'+
	             '<br><span class="educationList-subtitle">'+json.profileLicensesCertifications[i].CreateDateFrm+'</span></li>';
	             
	            $("#dvLicensesandCertification").append(divVal);
	            $('#LicensesandCertificationempty').css("display", "none");
// 	            var divVal ='<label class="pillbutton">' + title ;
// 	            if(viewModeJS == "false"){
// 	            divVal += '<a class="display" style="padding-left: 5px;" data-id='+ id +' data-toggle="modal" data-target="#addlicenceandcertification" href="#">'+
// 	            '<i class="fa fa-pencil"></i></a><a class="display" onclick="deleteProfileRow(' + 0 + ',' + id + ',\'deleteLicenceAndCertificationInfo\',\'deleteData\',\'#tblLicensesandCertification\')">'+
// 	            '<img src="/o/new-misk-theme/images/profile/bin.png" style="margin-left:10px"/></a>';
// 	            }
// 	            divVal += '</label>'; 
            }
        }
         
        function getnewjobwishlist(json){
        	$('#dvjobwishlist').empty();
        	$('#intJobWishList').empty();
            $('#jobwishlist').val("").trigger('change');
            for( var i = 0; i < json.profileJobWishList.length; i++)
            {
       			$('#dvjobwishlist').css("display", "");
                var skillname = json.profileJobWishList[i].jobwishlist;
                var id = json.profileJobWishList[i].id;
                var divVal = '<label class="pillbutton2"> ' + skillname + '</label>'; 
                var intDivVal = '<label class="pillbutton2"> ' + skillname + '<a class="display internalView" onclick="deleteProfileRow(' + 0 + ',' + id + ',\'deleteWishJobListInfo\',\'deleteData\',\'#tbljobwishlist\')"><img src="/o/new-misk-theme/images/profile/bin.png" class="delete-btn"/></a> </label>';
                
                $("#dvjobwishlist").append(divVal);
                $("#intJobWishList").append(intDivVal);
                $('#jobwishlistempty').css("display", "none");
            }
           }
        function getEducationSaved(json)
        {
     	   for( var i =0;i< json.profileEducation.length; i++)
          { 
             $('#dveducation').css("display", "");
             var d2fullyear = "";
             var univ =  json.profileEducation[i].educationCategory;
             var degree = json.profileEducation[i].degree;
             var field =  json.profileEducation[i].fieldOfStudy;
             var d1 = new Date(json.profileEducation[i].startYear);
             var endDate = json.profileEducation[i].endYear;
             if (endDate!=null)
	         {  var d2 = new Date(json.profileEducation[i].endYear);
	            d2fullyear = d2.getFullYear();
             }
            else if (json.profileEducation[i].educatetillnow == "true") 
            	{ 
            	  d2fullyear = "Present";
            	}
           
             var d1fullyear = d1.getFullYear();
             var grade = json.profileEducation[i].grade;
             var id = json.profileEducation[i].id;
             var divVal = '<li><label class="educationList-title zerobottom">' + univ + '</label>';
             
             if(viewModeJS == "false"){
             divVal += '<a class="display margin-left-action" data-id='+ id +' data-toggle="modal" data-target="#addeducation" href="#">'+
             '<i class="fa fa-pencil"></i></a><a class="display" onclick="deleteProfileRow(' + 0 + ',' + id + ',\'deleteEducationInfo\',\'deleteData\',\'#tblpublication\')">'+
             '<img src="/o/new-misk-theme/images/profile/bin.png" style="position: absolute;right: 0;" /></a>';
             }
             
             divVal += '<br /><span class="educationList-subtitle">' + degree + ' in '+ field+ '</span><span class="spamdivider"></span><span class="educationList-subtitle">' + d1fullyear + ' - ' + d2fullyear + '</span> '+
             '<br><span class="educationList-subtitle">'+json.profileEducation[i].description+'</span></li>';
             
             $("#educationList").append(divVal);
// 	                  '<img src="/o/new-misk-theme/images/profile/bin.png" style="position: absolute;right: 0;" /></a>  <br /><span class="educationList-subtitle">' + degree + ' in '+ field+ '</span><br /><span class="educationList-subtitle">' + d1fullyear + ' - ' + d2fullyear + '</span> </li>');

             $('#dveducationempty').css("display", "none");
			}
         }
        function getWorkexperienceSaved(json)
        {
     	   for( var i =0;i< json.profileWorkExperience.length; i++)
            { 
     	    var d2fullyear="";
            var company = json.profileWorkExperience[i].company;
            var location =json.profileWorkExperience[i].location;
            var jobtitle = json.profileWorkExperience[i].title;
            var d1 = new Date(json.profileWorkExperience[i].startDate);
            var endDate = json.profileWorkExperience[i].endDate;
            if (endDate!=null)
	         {  var d2 = new Date(json.profileWorkExperience[i].endDate);
	            d2fullyear = d2.getFullYear();
             }
            else if (json.profileWorkExperience[i].worktillnow == "true") 
            	{ 
            	  d2fullyear = "Present";
            	}
            var d1fullyear = d1.getFullYear();
            var id = json.profileWorkExperience[i].id;

	            if (company != null)
	            { 
					$('#dvworkexperience').css("display", "");
					var divVal = '<li><label class="experienceList-title zerobottom">' + jobtitle ;
					if(json.profileWorkExperience[i].duration != null && json.profileWorkExperience[i].duration != "")
	                	divVal += ' - '+ json.profileWorkExperience[i].duration +' ' ;
					divVal += '</label>';
					
					if(viewModeJS == "false"){
						divVal +='<a class="display" style=" position: absolute; right: 45px;" data-id='+ id +' data-toggle="modal" data-target="#addworkexperience" href="#">'
						       + '<i class="fa fa-pencil"></i></a><a class="display" onclick="deleteProfileRow(' + 0 + ',' + id + ',\'deleteWorkExperienceInfo\',\'deleteData\',\'#dvworkexperience\')">'
						       + '<img src="/o/new-misk-theme/images/profile/bin.png" style="position: absolute;right: 20px;margin-top: 4px;" /></a> ';
					}
	                divVal +=' <br /><span class="experienceList-subtitle">' + company + '</span><span class="spamdivider"></span><span class="experienceList-subtitle">' + location + '</span> <span class="spamdivider"></span>' 
	                  +'<span class="experienceList-subtitle">'+ d1fullyear + ' - ' + d2fullyear ;
	                
                    divVal += '</span><br><span class="experienceList-subtitle">'+json.profileWorkExperience[i].description+'</span></li>';
	                  
		            $("#experienceList").append(divVal);
		            $('#workexperienceempty').css("display", "none");
				}
			}
         }
        
        $('#addeducation').on('show.bs.modal', function(e) {
 			 var Id = $(e.relatedTarget).data('id');
			 if (Id != null)
			 	getProfileDetailById("educations",Id);
         	});
        $('#addworkexperience').on('show.bs.modal', function(e) {
			 var Id = $(e.relatedTarget).data('id');
			 if (Id != null)	
				getProfileDetailById("workexperience",Id);
       	});
        $('#addlicenceandcertification').on('show.bs.modal', function(e) {
 			 var Id = $(e.relatedTarget).data('id');
			 if (Id != null)
				getProfileDetailById("licenceandcertification",Id);
        });
        $('#addintrest').on('show.bs.modal', function(e) {
		    var Id = $(e.relatedTarget).data('id');
	        if (Id != null)
				getProfileDetailById("intrest",Id);
       	});
        $('#editprofile').on('show.bs.modal', function(e) {
			 var Id = <%=pinfo.getId()%>;
			 if (Id != null)
				getProfileDetailById("profileInfo",Id);
       	}); 
        $('#addeducation').on('hidden.bs.modal', function(e) {
        	  $(this).find('#frmAddeducation')[0].reset();
        	});
        $('#addworkexperience').on('hidden.bs.modal', function(e) {
      	  $(this).find('#frmaddworkexperience')[0].reset();
      	});
        $('#addlicenceandcertification').on('hidden.bs.modal', function(e) {
      	  $(this).find('#frmlicenceandcertification')[0].reset();
      	});
        $('#addintrest').on('hidden.bs.modal', function(e) {
      	  $(this).find('#frmAddIntrest')[0].reset();
      	});
        function getProfileDetailById(section,id)
        {
     	   var action = "updateProfileRecord";
     	   AUI().use('aui-io-request', function(A){
	               A.io.request('${resourceUrl1}', {
	                      method: 'post',
	                      data: {
	                       <portlet:namespace />obj: JSON.stringify(obj),
	                   	   <portlet:namespace />section: section,
	                   	   <portlet:namespace />action: action,
	                   	   <portlet:namespace />id: id,
	                      },
	                      on: {
	                          	success: function() {
	                          
	                          var json =  JSON.parse(this.get('responseData'));
	                          if (section == "profileInfo")
	                          { 
	                        	  $("#title").val(json._title);
	                        	  $("#firstname").val(json._firstName);
	                        	  $("#fatherName").val(json._fatherName);
	                        	 // $("#grandfatherName").val(json._grandfatherName);
	                        	  $("#familyname").val(json._familyName);
	                        	  $("#email").val(json._email); 
	                        	  $("#educationField").val(json._educationField);
	                         	  $("#universitygeneral").val(json._universitygeneral);
	                         	  $("#about").val(json._about);
	                         	  $("#currentworkposition").val(json._currentworkposition);
	                         	  $("#currentworklocation").val(json._currentworklocation);
	                        	  $("#mobileno").val(json._primaryMobileNo);
	                        	  $("#mobileno-code").val(json._primaryMobileNoCode);
	                        	  $("#mobileno2").val(json._secondaryMobileNo);
	                        	  $("#gender").val(json._gender);
	                        	  $("#region").val(json._nationality);
	                        	  $("#nationalid").val(json._nationalId);
	                        	  $("#passportid").val(json._passportId);
	                        	  $("#passportexpiredate").val(convert(json._passportExpireDate));
	                        	  $("#dateofbirth").val(convert(json._dateOfBirth));
	                        	  $("#education").val(json._currentEducationTrainingStatus);
	                        	  $("#countryofresidence").val(json._countryOfResidence);
	                        	  $("#postalcode").val(json._postalCode);
	                        	  $("#cityofresidence").val(json._cityOfResidence);
	                        	  $("#street").val(json._street);
	                        	  $("#state").val(json._state);
	                        	  $("#profileId").val(json._Id);
	                          }
	                          else if (section == "educations")
	                          { 
	                        	  $("#university").val(json._educationCategory);
	                        	  var hasOption = $('#degree option[value="' + json._degree + '"]');
                        	      if (hasOption.length == 0) {
		                        	  $('#degree').append('<option value="'+json._degree+'">'+json._degree+'</option>');
                        	      }
	                        	  $('#degree').select2('val', [json._degree]);
	                        	  hasOption = $('#fieldofstudy option[value="' + json._fieldOfStudy + '"]');
                        	      if (hasOption.length == 0) {
		                        	  $('#fieldofstudy').append('<option value="'+json._fieldOfStudy+'">'+json._fieldOfStudy+'</option>');
                        	      }
	                        	  $('#fieldofstudy').select2('val', [json._fieldOfStudy]);
	                        	  $("#startyear").val(json._startYear);
	                        	  $("#endyear").val(json._endYear);
// 	                        	  $("#educatetillnow").prop('checked', (json._educatetillnow === 'true'));
	                        	  $("#educateJourney").prop('checked', (json._educateJourney === 'true'));
	                        	  $("#grade").val(json._grade);
	                        	  $("#educationdescription").val(json._description);
	                        	  $("#educationId").val(json._Id);
// 	                        	  var dis3 = document.getElementById("endyear");
// 	                        	  var dis4 = document.getElementById("educatetillnow");
// 	                        	  if (dis3.value !== "" || dis3.value.length > 0) {
// 	                        	        dis4.disabled = true;
// 	                        	      } else {
// 	                        	        dis4.disabled = false;
// 	                        	      }
// 	                        	  if ($('#educatetillnow').is(":checked") !== false ) {
// 	                        	        dis3.disabled = true;
// 	                        	      } else {
// 	                        	        dis3.disabled = false;
// 	                        	      }
	                          }
	                          else if (section== "workexperience")
                          	  { 
                        		  $("#workexperienceId").val(json._Id);
//                         		  $("#jobtitle").val(json._title);
								  var hasOption = $('#jobtitle option[value="' + json._title + '"]');
                        	      if (hasOption.length == 0) {
		                        	  $('#jobtitle').append('<option value="'+json._title+'">'+json._title+'</option>');
                        	      }
                        	  	  $('#jobtitle').select2('val', [json._title]);
                        		  $("#company").val(json._company);
                        		  $("#location").val(json._location);
                        		  $("#workstartdate").val(convert(json._startDate));
                        		  $('#worktillnow').prop('checked', (json._worktillnow === 'true'));
                        		  $('#workJourney').prop('checked', (json._workJourney === 'true'));
                        		  $("#workdescription").val(json._description);
                        		  var dis1 = document.getElementById("workendate");
                        		  var dis2 = document.getElementById("worktillnow");
	                        		    
                       		      if (dis1.value !== "" || dis1.value.length > 0) {
                       		      	dis2.disabled = true;
                       		      } else {
                       		        dis2.disabled = false;
                       		      }
                        		 
                       		      if ($('#worktillnow').is(":checked") !== false ) {
//                       		         dis1.disabled = true;
                       		        $("#workendate").css("display","none");
                       		        $("#presentSpan").css("display","block");
                       		      } else {
//                        		         dis1.disabled = false;
                       		        $("#workendate").css("display","block");
                       		        $("#presentSpan").css("display","none");
                       		        $("#workendate").val(convert(json._endDate));
                       		      }
		                          	}
	                        	  else if (section== "volunteerexperience")
			                          	{ 
			                        	  $("#volunteerorganizationname").val(json._organization);
			                        	  $("#volunteerrole").val(json._role);
			                        	  $("#volunteercause").val(json._cause);
			                        	  $("#volunteerstartdate").val(convert(json._createDate));
			                        	  $("#volunteerendate").val(convert(json._endDate));
			                        	  $("#volunteerdescription").val(json._description);
			                        	  $("#volunteercurrent").val(json._currentlyVolunteering);
			                        	  $("#volunteerexpId").val(json._Id);
			                          	}
		                        	  else if (section== "workstatus")
				                          	{ 
				                        	  $("#workstatusId").val(json._Id);
			                        		  $("#currenworkstatus").val(json._currentWorkStatus);
			                        		  $("#workexprience").val(json._workExperience);
				                          	}
			                        	  else if (section== "licenceandcertification")
					                          	{ 
					                        	  $("#licenceandcertificationId").val(json._Id);
					                        	  $("#licencename").val(json._name);
					                        	  $("#issuingorganization").val(json._issuingOrganization);
					                        	  $("#issuedate").val(convert(json._issueDate));
					                        	  $("#expiredate").val(convert(json._expirationDate));
					                        	  $("#credentailurl").val(json._credentialURL);
					                        	  $("#certificateJourney").prop('checked', (json._certificateJourney === 'true'));
					                        	//  $("#credentailid").val(json._credentialID);
					                        	  $("#credentailnotexpire").val(json._notExpire);
					                          	}
				                        	  else if (section== "honorandaward")
						                          	{ 
						                        	  $("#honorandawardId").val(json._Id);
						                        	  $("#honorissuer").val(json._honorissuer);
						                        	  $("#honortitle").val(json._honortitle);
						                        	  $("#honorissuedate").val(convert(json._honorissuedate));
						                        	  $("#issuedescription").val(json._issuedescription);
						                          	}
					                        	  else if (section== "intrest")
							                          	{ 
						                        		  $("#intrestId").val(json._Id);
						                        		  $("#intrest").val(json._intrest);
							                          	}
						                        	  else if (section== "project")
								                          	{
							                        		  $("#projectId").val(json._Id);
							                        		  $("#projectname").val(json._projectName);
							                        		  $("#projecturl").val(json._projectURL);
							                        		  $("#projectstartdate").val(convert(json._startDate));
							                        		  $("#projectenddate").val(convert(json._endDate));
							                        		  $("#projectdescription").val(json._description);
							                        		  $("#credentailnotexpire").val(json._currentlyOnProject);
								                          	}
							                        	  else if (section== "publication")
									                          	{
								                        		  $("#publicationId").val(json._Id);
								                        		  $("#publicationsubject").val(json._publicationTitle);
								                        		  $("#publicationtype").val(json._publicationType);
								                        		  $("#publicationrole").val(json._role);
								                        		  $("#publishingdate").val(convert(json._date));
								                        		  $("#publicationurl").val(json._url);
									                          	}
	                         }
	                     }
	               });
	           });
        }
        
        function randomQuote(divName) {
            $.ajax({
                url: "https://api.forismatic.com/api/1.0/?",
                dataType: "jsonp",
                data: "method=getQuote&format=jsonp&lang=en&jsonp=?",
                success: function (quoteData) {
					$("."+divName).html("");
					$("."+divName).append('<h5><i class="fa fa-quote-left"></i>'+quoteData.quoteText +'<i class="fa fa-quote-right"></i></h5><p>'+quoteData.quoteAuthor+'</p>');
                }
            });
        }
        
        function convert(str) {
     	   var date = new Date(str),
     	     mnth = ("0" + (date.getMonth() + 1)).slice(-2),
     	     day = ("0" + date.getDate()).slice(-2);
     	   return [date.getFullYear(), mnth, day].join("-");
     	 }
        
        function saveToDatabase(action,formId,command,modalId)
        {
     	   var allrequireFields = true;
     	   var formIdjquery = "#"+formId
        	if(command == "addWorkExperience"){
		        var workstartdate = new Date($('#workstartdate').val());
	   	        var workendate = new Date($('#workendate').val());
	   	        var todaydate = new Date();
	   	        
	   	        if(workstartdate.getTime() > todaydate.getTime()) {showHideALert("Start Date should be less then today"); allrequireFields = false;return;}
	   	        if(workendate.getTime() > todaydate.getTime()) {showHideALert("End Date should be less then then today"); allrequireFields = false; return;}
	   			if(workstartdate.getTime() > workendate.getTime()) {showHideALert("Start Date should be less then End Date"); allrequireFields = false; return;}
        	}else if(command == "addusereducation"){
   		        var startyear = $('#startyear').val();
   	   	        var endyear = $('#endyear').val();
   	   	        var todaydate = "<%=currentYear%>";
//     	   	    if(startyear > todaydate && startyear != "") {showHideALert("Start Year should be less then today"); allrequireFields = false;return;}
   	   	        if(endyear > todaydate && endyear != "") {showHideALert("End year should be less then this year"); allrequireFields = false; return;}
   	   			if(startyear > endyear && startyear != "" && endyear != "") {showHideALert("Start year should be less then End year"); allrequireFields = false; return;}
            }	
        	else if(command == "adduserlicenceandcertification"){
     		    var issuedate = new Date($('#issuedate').val());
     	   	    var expiredate = new Date($('#expiredate').val());
     	   	    var todaydate = new Date();
        	   	        
       	   	    if(issuedate.getTime() > todaydate.getTime()) {showHideALert("Issue Date should be less then today"); allrequireFields = false;return;}
//         	   	if(expiredate.getTime() > todaydate.getTime()) {showHideALert("End Date should be less then then today"); allrequireFields = false; return;}
       	   		if(issuedate.getTime() > expiredate.getTime()) {showHideALert("Issue Date should be less then Expiry Date"); allrequireFields = false; return;}
            }
     	  obj = {};
          var userId = <%=userId%>; 
          $(formIdjquery).find('input , textarea, select').each(function(){
        	    if($(this).prop('required')){
        	    	if(!this.value)
        	    	{
        	    		showHideALert(this.name + " <liferay-ui:message key='isrequired' />");
	        	        allrequireFields=false;
	  		            return allrequireFields;
        	    	}
        	    	else
        	    	 return allrequireFields;
        	    } 
          });
		         
		      if(allrequireFields)   
		      {  
		    	//  $(modalId).modal('toggle');
		        //  $('.modal-backdrop').remove();
		    	  obj.command = command;
	        	  obj.userId     = <%=userId%>; 
	        	  
	        	  if (command == "saveGeneralInfo")
	        	   {
	        	  obj.profileId = $('#profileId').val();
	        	  obj.title= $('#title').val();
	        	  obj.firstname= $('#firstname').val();
	        	  obj.fatherName= $('#fatherName').val();
	        	//  obj.grandfatherName= $('#grandfatherName').val();
	        	  obj.familyname= $('#familyname').val();
	        	  obj.email= $('#email').val();
	        	  obj.about= $('#about').val();
	        	  obj.educationField= $('#educationField').val();
	        	  obj.universitygeneral= $('#universitygeneral').val();
	        	  obj.currentworkposition= $('#currentworkposition').val();
	        	  obj.currentworklocation= $('#currentworklocation').val();
	        	  obj.mobileno= $('#mobileno').val();
	        	  obj.mobilenocode= $('#mobileno-code').val();
	        	  obj.mobileno2= $('#mobileno2').val();
	        	  obj.gender= $('#gender').val();
	        	  obj.region= $('#region').val();
	        	  obj.nationalid = $('#nationalid').val();
	        	  obj.passportid = $('#passportid').val();
	        	  obj.passportexpiredate = $('#passportexpiredate').val();
	        	  obj.dateofbirth = $('#dateofbirth').val(); 
	        	  obj.education = $('#education').val();
	        	  obj.countryofresidence = $('#countryofresidence').val();
	        	  obj.postalcode = $('#postalcode').val();
	        	  obj.cityofresidence = $('#cityofresidence').val();
	        	  obj.street = $('#street').val();
	        	  obj.state = $('#state').val();
	        	  obj.nationaladdress= $('#nationaladdress').val();
	        	  obj.instagramlink = $('#instagramlink').val();
	        	  obj.facebooklink = $('#facebooklink').val();
	        	  obj.twitterlink = $('#twitterlink').val();
	        	  obj.linkedin = $('#linkedin').val();
	        	   }
	        	  else if (command == "addusereducation")
	        	   { /**   education section   **/
		        	  obj.university = $('#university').val();
		        	  obj.degree = $('#degree').val();
		        	  obj.fieldOfStudy = $('#fieldofstudy').val();
		        	  obj.startYear = $('#startyear').val();
		        	  obj.endYear = $('#endyear').val();
		        	  obj.educatetillnow = false;//$('#educatetillnow').is(":checked");
		        	  obj.educateJourney = $('#educateJourney').is(":checked");
		        	  obj.educationdescription =  $('#educationdescription').val();
		        	  obj.educationdescription =  $('#educationdescription').val();
		        	  obj.grade = $('#grade').val();
		        	  obj.educationId = $('#educationId').val();
					  console.log(obj);
	        	   }
	        	  else if (command == "addWorkExperience")
	        	   {   /**   work section   **/
	        	  obj.jobtitle = $('#jobtitle').val();
	        	  obj.company = $('#company').val();
	        	  obj.location = $('#location').val();
	        	  obj.workstartdate = $('#workstartdate').val();
	        	  obj.workendate = $('#workendate').val();
	        	  obj.worktillnow = $('#worktillnow').is(":checked");
	        	  obj.workJourney = $('#workJourney').is(":checked");
	        	  obj.workdescription = $('#workdescription').val();
	        	  obj.currenworkstatus = $('#currenworkstatus').val();
	        	  obj.workexprience = $('#workexprience').val();
	        	  obj.workexperienceId = $('#workexperienceId').val();
	        	   }
		       else	if (command == "addsuserkills")
		         { 
		          obj.skillname= $('#skillname').val(); 
		          obj.skilllevel= $('#skilllevel').val(); 
		         }
			     else if(command == "addlanguage")
		          { /**   Languages section   **/
		          obj.language= $('#language').val(); 
		          obj.languageproficiency= $('#languageproficiency').val(); 
		          }
		         else if(command == "adduserhonorandaward")
			       { /**   Honour and Awards section   **/
		          obj.honorissuer= $('#honorissuer').val(); 
		          obj.honortitle = $('#honortitle').val(); 
		          obj.honorissuedate= $('#honorissuedate').val(); 
		          obj.issuedescription = $('#issuedescription').val(); 
			       }
				 else if(command == "addnewjobwishlist")
			       {   /**   Job Wishlist section   **/
					   obj.jobwishlist = $('#jobwishlist').val(); 
			       }
		          else if(command == "addnewintrest")
			       {  /**   intrest section   **/
		             obj.intrest = $('#intrest').val(); 
			         obj.intrestId =$('#intrestId').val();  
			       }
				   else if(command == "adduserproject")
				       {
		          /**   Project section   **/
		           obj.projectname = $('#projectname').val(); 
		           obj.projecturl = $('#projecturl').val(); 
		           obj.projectstartdate = $('#projectstartdate').val(); 
		           obj.projectenddate = $('#projectenddate').val(); 
		           obj.projectdescription = $('#projectdescription').val(); 
		           obj.credentailnotexpire =  $('#credentailnotexpire').val(); 
				       }
					   else if (command == "adduserlicenceandcertification")
			        	   { 
				          /**   Licenses & Certifications section   **/
			        	  obj.licencename= $('#licencename').val();
			        	  obj.licenceandcertificationId= $('#licenceandcertificationId').val();
			           	  obj.issuingorganization= $('#issuingorganization').val();
			           	  obj.issuedate= $('#issuedate').val();
			           	  obj.expiredate= $('#expiredate').val();
			           	 // obj.credentailid= $('#credentailid').val();
			           	  obj.certificateJourney= $('#certificateJourney').is(":checked");
			           	  obj.credentailurl= $('#credentailurl').val();
			           	 // obj.credentailnotexpire= $('#credentailnotexpire').is(":checked");
			        	   }
					   else if(command == "addluserpublication")
					          {/**   Publication section   **/
					           obj.publicationsubject = $('#publicationsubject').val(); 
					           obj.publicationrole = $('#publicationrole').val(); 
					           obj.publicationtype = $('#publicationtype').val(); 
					           obj.publicationurl = $('#publicationurl').val(); 
					           obj.publishingdate = $('#publishingdate').val(); 
					          }else if(command == "addtestimonial")
							          {/**   Publication section   **/
									   obj.testimonialproviderId = $('#testimonialproviderId').val(); 
									   obj.testimonialprovidername = $('#testimonialprovidername').val(); 
							           obj.testimonialprovideremail = $('#testimonialprovideremail').val(); 
							           obj.testimonialprovideorganizationname = $('#testimonialprovideorganizationname').val(); 
							           obj.testimonialprovidertitle = $('#testimonialprovidertitle').val(); 
							           obj.testimonialprivatemessage = $('#testimonialprivatemessage').val(); 
							           obj.imagePreview = $('#imagePreview').val(); 
							          }
	        	  
	        	 if (command == "addsuserkills" || command == "addnewjobwishlist" || command == "addnewintrest" 
	        			 || command == "addusereducation" || command == "addWorkExperience")
		         {
		        		  var arrayVal,arrayVal1;
		        		  if(command == "addsuserkills")
		        			  arrayVal  = obj.skillname;
		        		  if(command == "addnewjobwishlist")
		        			  arrayVal  = obj.jobwishlist;
		        		  if(command == "addnewintrest")
		        			  arrayVal  = obj.intrest;
		        		  if(command == "addusereducation"){
		        			  arrayVal  = obj.degree;
		        			  arrayVal1  = obj.fieldOfStudy;
		        		  }
		        		  if (command == "addWorkExperience")
		        			  arrayVal  = obj.jobtitle;
		        			  
		        		  for(var k = 0; k < arrayVal.length; k++){
		        		  	
			        		  if(command == "addsuserkills")
			        			  obj.skillname = arrayVal[k];
			        		  if(command == "addnewjobwishlist")
			        			  obj.jobwishlist = arrayVal[k];
			        		  if(command == "addnewintrest")
			        			  obj.intrest = arrayVal[k];
			        		  if(command == "addusereducation"){
			        			  obj.degree =arrayVal[k];
			        			  obj.fieldOfStudy =arrayVal1[k];
			        		  }
			        		  if(command == "addWorkExperience")
			        			  obj.jobtitle = arrayVal[k];
		        		  	
		        		  	 AUI().use('aui-io-request', function(A){
	        	   
	               A.io.request('${resourceUrl1}', {
	                      method: 'post',
	                      data: {
	                   	   <portlet:namespace />obj: JSON.stringify(obj),
	                   	   <portlet:namespace />command: command,
	                   	   <portlet:namespace />action: action,
	                   	},
	                      on: { 
	                    	  success: function() {
	                    		  if(this.get('responseData') == "0")
		                    		{
	                    			  showHideALert("Value already exists");
		                    		}
	                    		  else { 
	                    			  if (command == "addsuserkills")
                         			  { 
	                    				  jQuery('#dvskills').html(''); 
	                    				  jQuery('#intDvSkills').html(''); 
	                    				  $('#addskills').modal("hide");
	                          		      getprofileDetails('userkills','getProfileInfo',obj);
                          		      }
	                    			  else if (command == "addnewintrest")
	                 		          {
	                    				  jQuery('#dvintrest div').html(''); 
	                    				  jQuery('#intDvIntrest').html(''); 
	                    				  $('#addintrest').modal("hide");
		                          		  getprofileDetails('userIntrest','getProfileInfo',obj);
	                 		          }
	                    			  else if (command == "addnewjobwishlist")
                         			  { 
	                    				  jQuery('#dvjobwishlist').html(''); 
	                    				  $('#addjobwishlist').modal("hide");
                         		          getprofileDetails('userJobWishList','getProfileInfo',obj);
                		              }
	                    			  else{
	                    			  swal({title: "Saved Successfully", text: "", type: "success"},
	                    		  	   function(){
	                          			 if (command == "adduserlicenceandcertification")
	                          			 { 
	                          				 jQuery('#dvLicensesandCertification').html(''); 
	                          		         getprofileDetails('userLicensesandCertification','getProfileInfo',obj);
	                 		             } 
 	                          			 else if (command == "addusereducation")
 	                          			 { 
	                          				 jQuery('#educationList').html(''); 
	 	                          			 document.getElementById("endyear").disabled = false;
	 	                          			 getprofileDetails('userEducationSaved','getProfileInfo',obj);
 	                 		             } 
 	                          			 else if (command == "addWorkExperience")
 	                          			 { 
	                          				 jQuery('#experienceList').html(''); 
	                          				 $("#workendate").css("display","block");
	                          		         $("#presentSpan").css("display","none");
	 	                          			 document.getElementById("workendate").disabled = false; 
	 	                          			 getprofileDetails('userWorkexperienceSaved','getProfileInfo',obj);
 	                 		             }
 	                          			 else if (command == "addtestimonial")
 	                          			 { 
	                          				 jQuery('#testimonialindicator').html(''); 
 	                          			     jQuery('#testimonialitem div').html('');
 	                          		         getprofileDetails('userTestimonial','getProfileInfo',obj);
 	                 		             }
 	                          			 else if (command == "saveGeneralInfo"){ location.reload(); }
	                          	   });
	                    			  }//
	                    		   }//else
	                          }
	                     }
	               });
	           });//ajax
		        		  }//for
		         }
	        	 else{
	        	  
	           AUI().use('aui-io-request', function(A){
	               A.io.request('${resourceUrl1}', {
	                      method: 'post',
	                      data: {
	                   	   <portlet:namespace />obj: JSON.stringify(obj),
	                   	   <portlet:namespace />command: command,
	                   	   <portlet:namespace />action: action,
	                   	},
	                      on: { 
	                    	  success: function() {
	                    		  if(this.get('responseData') == "0")
		                    		{
	                    			  showHideALert("Value already exists");
		                    		}
	                    		  else {
	                    			  if (command == "addsuserkills")
                         			  { 
	                    				  jQuery('#dvskills').html(''); 
	                    				  jQuery('#intDvSkills').html(''); 
	                    				  $('#addskills').modal("hide");
	                          		      getprofileDetails('userkills','getProfileInfo',obj);
                          		      }
	                    			  else if (command == "addnewintrest")
	                 		          {
	                    				  jQuery('#dvintrest div').html(''); 
	                    				  $('#addintrest').modal("hide");
		                          		  getprofileDetails('userIntrest','getProfileInfo',obj);
	                 		          }
	                    			  else if (command == "addnewjobwishlist")
                         			  { 
	                    				  jQuery('#dvjobwishlist').html(''); 
	                    				  $('#addjobwishlist').modal("hide");
                         		          getprofileDetails('userJobWishList','getProfileInfo',obj);
                		              }
	                    			  else{
		                    			  swal({title: "Saved Successfully", text: "", type: "success"},
		                    		  	   function(){
		                          		   if (command == "adduserlicenceandcertification")
		                          		   { 
		                          			    jQuery('#dvLicensesandCertification').html(''); 
		                          		        getprofileDetails('userLicensesandCertification','getProfileInfo',obj);
		                 		           } 
		                          		   else if (command == "addusereducation")
 	                          			   { 
		                          			    jQuery('#educationList').html(''); 
 	                          		     	    getprofileDetails('userEducationSaved','getProfileInfo',obj);
 	                 		               } 
			 	                           else if (command == "addWorkExperience")
 	                          			   { 
			 	                        	    jQuery('#experienceList').html(''); 
 	                          		       		getprofileDetails('userWorkexperienceSaved','getProfileInfo',obj);
 	                 		               }
	 	                          		   else if (command == "addtestimonial")
			 	                           { 
 	                          					jQuery('#testimonialindicator').html(''); 
	 	                          			    jQuery('#testimonialitem div').html('');
	 	                          		        getprofileDetails('userTestimonial','getProfileInfo',obj);
			 	                 		   }
					 	                   else if (command == "saveGeneralInfo")
					 	                   {
										   		location.reload();
					 	                   }
		                          	   });
	                    			  }
	                          	   }
	                          }
	                     }
	               });
	           });//ajax
		      }//else
	           
	           $(formIdjquery).trigger("reset");
	           $("#imgPreview").attr("style","background-image: url(/o/new-misk-theme/images/profile/pic1.png);");
	           }
        }
    </script>
</body>
</html>