<%@ include file="/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import= "vo.ProfileVO"%>
<%@page import="ProfileMvcProtlet.portlet.ProfileMvcProtletPortlet"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

 <%

System.out.println("test fetet");
ProfileMvcProtletPortlet evt = new ProfileMvcProtletPortlet();
System.out.println("test jean");
ProfileVO pinfo = evt.getprofileInfo(Long.valueOf(renderRequest.getRemoteUser()));
ProfileVO pImage = evt.getprofileImage(Long.valueOf(renderRequest.getRemoteUser()));
String imageSrc="/o/new-misk-theme/images/profile/pic1.png";
if (pImage.getImage() != null)
   imageSrc = pImage.getImage();
String mobileNumber = "";
if(pinfo.getMobileno()!= null)
	mobileNumber = pinfo.getMobileno();
System.out.println("test micha");

%>

 <portlet:defineObjects />   
<liferay-portlet:resourceURL var="resourceUrl1" >
	<liferay-portlet:param name="param1" value="Value1"/>
</liferay-portlet:resourceURL>

<html>
<head>

 <style type="text/css">
 #header #logo img {
    right: 10%;
    position: absolute;
    z-index: 4;
    margin-top: 7rem;
    padding: 7%;
    margin: 0;
}
 .bg-light {
    background-color: #f8f9fa00!important;
}
 .container-menu {
    height: 110px;
    position: relative;
    background: url(/o/new-misk-theme/images/landing/topmenu.png);
    width: -webkit-fill-available;
}
 
 .fromTopIn
{
	transition: transform 1.0s ease, opacity 1.0s ease;
	
	transform: translate(0,0);
	opacity: 1.0;
}

.fromTopOut
{
	transition: transform 1.0s ease, opacity 1.0s ease;
	
	transform: translate(0,-10px);
	opacity: 0.0;
}

.fromBottomIn
{
	transition: transform 1.0s ease, opacity 1.0s ease;
	
	transform: translate(0,0);
	opacity: 1.0;
}

.fromBottomOut
{
	transition: transform 1.0s ease, opacity 1.0s ease;
	
	transform: translate(0,10px);
	opacity: 0.0;
}

.fromLeftIn
{
	transition: transform 1.0s ease, opacity 1.0s ease;
	
	transform: translate(0,0);
	opacity: 1.0;
}

.fromLeftOut
{
	transition: transform 1.0s ease, opacity 1.0s ease;
	
	transform: translate(-10px,0);
	opacity: 0.0;
}

.fromRightIn
{
	transition: transform 1.0s ease, opacity 1.0s ease;
	
	transform: translate(0,0);
	opacity: 1.0;
}

.fromRightOut
{
	transition: transform 1.0s ease, opacity 1.0s ease;
	
	transform: translate(10px, 0);
	opacity: 0.0;
}

.scaleUpIn
{
	transition: transform 1.0s ease, opacity 1.0s ease;
	
	transform: scale(1.0,1.0);
	opacity: 1.0;
}

.scaleUpOut
{
	transition: transform 1.0s ease, opacity 1.0s ease;
	
	transform: scale(1.3,1.3);
	opacity: 0.0;
}

.scaleDownIn
{
	transition: transform 1.0s ease, opacity 1.0s ease;
	
	transform: scale(1.0,1.0);
	opacity: 1.0;
}

.scaleDownOut
{
	transition: transform 1.0s ease, opacity 1.0s ease;
	
	transform: scale(0.7,0.7);
	opacity: 0.0;
}
 .title-pen {
  color: #333;
  font-family: "Coda", sans-serif;
  text-align: center;
}
.title-pen span {
  color: #55acee;
}

.user-profile {
  margin: auto;
    width: 100%;
  height: 28em;
background: url(/o/new-misk-theme/images/profile/bk1.png);
    background-size: cover;
    background-repeat: no-repeat;
}

.user-profile  .username {
    margin: auto;
    margin-top: -7.4em;
    margin-left: 9.8em;
    color: #fff;
    font-size: 1.53em;
    font-family: "Coda", sans-serif;
    font-weight: bold;
}
.user-profile  .bio {
    margin: auto;
    /* display: inline-block; */
    margin-left: 17.43em;
    color: #cacaca;
    font-size: .87em;
    font-family: "varela round", sans-serif;
}
.user-profile > .description {
  margin: auto;
  margin-top: 1.35em;
  margin-left: 17.43em;
  color: #cacaca;
  font-size: .87em;
  font-family: "varela round", sans-serif;
}
.user-profile > img.avatar {
    padding: .7em;
    margin-left: 1.3em;
    margin-top: 13.3em;
    height: 10.23em;
    width: 10.23em;
    border-radius: 18em;
}


.user-profile ul.data {
    margin: 2em auto;
    height: 3.70em;
  background: #4eb6b6;
  text-align: center;
  border-radius: 0 0 .3em .3em;
}
.user-profile li {
    margin: 0 auto;
  padding: 1.30em;
  width: 33.33334%;
  display: table-cell;
  text-align: center;
}

.user-profile span {
    font-family: "varela round", sans-serif;
    color: #e3eeee;
  white-space: nowrap;
  font-size: 1.27em;
  font-weight: bold;
}
.user-profile span:hover {
  color: #daebea;
}

footer > h1 {
  display: block;
  text-align: center;
  clear: both;
  font-family: "Coda", sans-serif;
  color: #343f3d;
  line-height: 6;
  font-size: 1.6em;
}
footer > h1 a {
  text-decoration: none;
  color: #ea4c89;
}
hr{
    border: none;
    margin-left: 12.8em;
    margin-top: -9.4em;
    border-left: 3px solid #909090;
    height: 10em;
    width: 1px;
}

.demopadding {

    margin-top: 1%;
    margin-left: 15.43em;
    width: 140px;
    text-align: center;
}
.icon {
    position:relative;
    text-align:center;
    width:0px;
    height:0px;
    padding:20px;
    border-top-right-radius:     20px;
    border-top-left-radius:     20px;
    border-bottom-right-radius: 20px;
    border-bottom-left-radius:     20px;
    -moz-border-radius:         20px 20px 20px 20px;
    -webkit-border-radius:         20px 20px 20px 20px;
    -khtml-border-radius:         20px 20px 20px 20px;     
    color:#FFFFFF;
}
.icon i {
    font-size:20px;
    position:absolute;
    left:9px;
    top:10px;
}
.icon.social {
    float:left;
    margin:0 5px 0 0;
    cursor:pointer;
    background:#fff ;
    color:#262626;
    transition: 0.5s;
    -moz-transition: 0.5s;
    -webkit-transition: 0.5s;
    -o-transition: 0.5s;     
}
.icon.social:hover {
    background:#262626 ;
    color:#6d6e71;
    transition: 0.5s;
    -moz-transition: 0.5s;
    -webkit-transition: 0.5s;
    -o-transition: 0.5s;
    -webkit-filter:    drop-shadow(0 1px 10px rgba(0,0,0,.8));
    -moz-filter:     drop-shadow(0 1px 10px rgba(0,0,0,.8));
    -ms-filter:         drop-shadow(0 1px 10px rgba(0,0,0,.8));
    -o-filter:         drop-shadow(0 1px 10px rgba(0,0,0,.8));
    filter:             drop-shadow(0 1px 10px rgba(0,0,0,.8));         
}
.icon.social.fb i {
    left:13px;
    top:10px;
}
.icon.social.tw i {
    left:11px;
}
.icon.social.in i {
    left:11px;
}

.btn-outline-primary {
    color: #ffffff;
    border-color: #ffffff;
}
.bg-light {
    background-color: #f8f9fa00!important;
}
.list-group-item {
    position: relative;
    display: block;
    padding: 0.5rem;
    margin-bottom: -1px;
    background-color: #fff;
    border: 0px solid rgba(0,0,0,.125);
}
.row.col-md-12.navigation {
    position: relative;
    top: 7%;
    z-index: 4;
}
.col-md-12.topHeadLinks1 {
    position: relative;
    visibility: hidden;
    padding: 0.5%;
    background: #fff;
    z-index: 3;
}
.navigation-wrap.bg-light.start-header.start-style {
    background: #ffffff00!important;
}
.card {
    position: relative;
    display: -ms-flexbox;
    display: flex;
    -ms-flex-direction: column;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    border: 1px solid rgba(0,0,0,.125);
    border-radius: .25rem;
    width: 96%;
    margin: 2%;
}
.navbar-nav {
    display: -ms-flexbox;
    display: flex;
    -ms-flex-direction: column;
    flex-direction: row;
    }
    button.btn.btn-outline-primary:hover {
    border: 1px solid;
    box-shadow: inset 0 0 20px rgba(255, 255, 255, 0.5), 0 0 20px rgba(255, 255, 255, 0.2);
    outline-color: rgba(255, 255, 255, 0);
    outline-offset: 15px;
    text-shadow: 1px 1px 2px #427388;
      color: #ffffff;
    border-color: #ffffff;
    background-color:#ffffff00;
    
    .questionmark {
    color: white;
    background-color: #43A2F3;
    border-radius:50%;
   
    padding-left:7px;
    padding-right:7px;
    padding-top:1px;
    padding-bottom:1px;
    
}
.invalid input:required:invalid {
    background: #BE4C54;
}

/* Mark valid inputs during .invalid state */
.invalid input:required:valid {
    background: #17D654 !important;
}

.bootstrap-tagsinput {
line-height:45px !important;
min-width:100% !important;
}
    .bootstrap-tagsinput .tag {
        background-color: #2191f1!important;
        color: white !important;
        padding: 5px !important;
        border-radius: 5px !important;
    }

.bootstrap-tagsinput .tag [data-role="remove"] {
        margin-left:0px!important;
        margin-right:5px !important;
            
 }

a.menu-nav {
    color: #b7b6b6 !important;
}
select {
text-transform:capitalize;
}


.cutombtn {
    background-color: #05C5FF;
    color: #fff;
    border-radius: 0 !important;
}

.card-header {
max-height:45px;
}
}

.img-fluid {
    width: 200px!important;
    border-radius: 50%;
    height: 200px!important;
    
}
<liferay-theme:defineObjects />



</style>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>

<portlet:defineObjects />
<theme:defineObjects />

 <link href="/o/new-misk-theme/css/bootstrap.min.css" rel="stylesheet" />
  <link href="/o/new-misk-theme/alerts/style-alert.css" rel="stylesheet" /> 
 </head>
<portlet:defineObjects />
<theme:defineObjects />

<% User userU = themeDisplay.getUser();  
System.out.println("userU:  "+userU);
System.out.println("userU.getFullName():  "+userU.getFullName());

String email = userU.getEmailAddress();
%>
<body> 
 <!-- Modal -->
  <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-header" style="background-image: linear-gradient(to right, #0061a5, #2b9b6e); color:white">
                        <b data-scroll="toggle(.fromLeftIn, .fromLeftOut)">Profile Info</b>
                    </div>
                    <div class="card-body">                        
                        <div class="row">
                            <div class="col-md-4">
                                <div class="card" data-scroll="toggle(.fromLeftIn, .fromLeftOut)">
                                    <div class="card-body text-center">
                                        <a href="#" id="profilepic" data-scroll="toggle(.fromLeftIn, .fromLeftOut)">
                                            <img src="<%=imageSrc%>" class="img-fluid" id="profileimage" />
                                        </a>
                                        <input type="file" id="profilepic_file" class="file-upload" style="display: none;" />
                                    
</div>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <div class="card" data-scroll="toggle(.fromLeftIn, .fromLeftOut)">
                                    <div class="card-header" style="background-image: linear-gradient(to right, #0061a5, #2b9b6e); color:white">
                                        <b>Edit Profile <a href="#" class="float-right text-white" data-toggle="modal" data-target="#editprofile" >+Edit</a></b>
                                    </div>
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <b><label id="userfullname"><%= userU.getFullName() %></label></b>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6 form-group">
                                                <label><b> User Id :</b></label>
                                                <label class="text-muted"><%=renderRequest.getRemoteUser()%></label>
                                            </div>
                                            <div class="col-md-6 form-group">
                                                <label><b>Date Of Joining :</b></label>
                                                <label class="text-muted">15/06/2019</label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6 form-group" style="margin-top: -10px;">
                                                <label><b> Email :</b></label>
                                                <label class="text-muted" id="useremail"><%=email%></label>
                                            </div>
                                            <div class="col-md-6 form-group" style="margin-top: -10px;">
                                                <label><b>Mobile :</b></label>
                                                <label class="text-muted" id="usermobileno"><%=mobileNumber%></label>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 text-center">
                                                <a href="#" data-toggle="modal" data-target="#editprofile" class="btn cutombtn">Edit Profile</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>



            <div class="row mt-2 pb-2">
                <div class="col-md-12">
                    <div class="card">
                    <div class="card-header" style="background-image: linear-gradient(to right, #0061a5, #2b9b6e); color:white">
                        <b data-scroll="toggle(.fromLeftIn, .fromLeftOut)">
                                Education
                            <a href="#" class="float-right text-white" data-toggle="modal" data-target="#addeducation" >+Add</a>
                            </b>
                        </div>
                    <div class="card-body" data-scroll="toggle(.fromLeftIn, .fromLeftOut)">
                        <div id="dveducationempty" class="text-center">
                            <img src="/o/new-misk-theme/images/profile/education.png" width="50px" height="50px" />
                                <p>All the Education Information will be show here...</p>
                            <p><a href="#" data-toggle="modal" data-target="#addeducation" class="card-link">Let's Go</a></p>
                            </div>
                            <div class="row mt-2" id="dveducation">
                                <div class="col-md-12">
                                    <table class="table" id="tbleducation">
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
            </div>

            <div class="row mt-2 pb-2">
                <div class="col-md-12">
                    <div class="card">
                    <div class="card-header" style="background-image: linear-gradient(to right, #0061a5, #2b9b6e); color:white">
                        <b data-scroll="toggle(.fromLeftIn, .fromLeftOut)"> Work  Experience <a href="#" class="float-right text-white" data-toggle="modal" data-target="#addworkexperience" >+Add</a></b>
                        </div>
                    <div class="card-body" data-scroll="toggle(.fromLeftIn, .fromLeftOut)">
                        <div id="workexperienceempty" class="text-center">
                            <img src="/o/new-misk-theme/images/profile/workexp.png" width="50px" height="50px" />
                                <p>All the Wor Experience information will be show here..</p>
                            <p><a href="#" data-toggle="modal" data-target="#addworkexperience" class="card-link">Let's Go</a></p>
                            </div>
                            <div class="row mt-2" id="dvworkexperience">
                                <div class="col-md-12">
                                    <table class="table" id="tblworkexperience">
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
            </div>
            <div class="row mt-2 pb-2">
                <div class="col-md-6">
                    <div class="card">
                    <div class="card-header" style="background-image: linear-gradient(to right, #0061a5, #2b9b6e); color:white">
                        <b data-scroll="toggle(.fromLeftIn, .fromLeftOut)"> Work Status <a href="#" class="float-right text-white" data-toggle="modal" data-target="#addworkstatus" >+Add</a></b>
                        </div>
                        <div class="card-body">
                        <div id="workstatusempty" data-scroll="toggle(.fromLeftIn, .fromLeftOut)">
                                <p>All the work status information will be show here..</p>
                            <p class="text-center"><a href="#" data-toggle="modal" data-target="#addworkstatus" class="card-link">Let's Go</a></p>
                            </div>
                            <div class="row mt-2" id="dvworkstatus">
                                <div class="col-md-12">
                                    <table class="table" id="tblworkstatus">
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
                <div class="col-md-6">
                    <div class="card">
                    <div class="card-header" style="background-image: linear-gradient(to right, #0061a5, #2b9b6e); color:white">
                        <b data-scroll="toggle(.fromLeftIn, .fromLeftOut)"> Licenses & Certifications <a href="#" class="float-right text-white" data-toggle="modal" data-target="#addlicenceandcertification" >+Add</a></b>
                        </div>
                        <div class="card-body">
                            <div id="licenceandcertificationempty" data-scroll="toggle(.fromLeftIn, .fromLeftOut)">
                                <p>All the Licenses and Certifications information will be show here...</p>
                                <p class="text-center"><a href="#" data-toggle="modal" data-target="#addlicenceandcertification" class="card-link">Let's Go</a></p>
                            </div>
                            <div class="row mt-2" id="dvLicensesandCertification">
                                <div class="col-md-12">
                                    <table class="table" id="tblLicensesandCertification">
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
            </div>

            <div class="row pt-2 pb-2">
                <div class="col-md-6">
                    <div class="card">
                    <div class="card-header" style="background-image: linear-gradient(to right, #0061a5, #2b9b6e); color:white">
                        <b data-scroll="toggle(.fromLeftIn, .fromLeftOut)"> Volunteer Experience <a href="#" class="float-right text-white" data-toggle="modal" data-target="#addvolunteerexperience" >+Add</a></b>
                        </div>
                    <div class="card-body" data-scroll="toggle(.fromLeftIn, .fromLeftOut)">
                            <div id="volunteerempty">
                                <p>All the Volunteer Experience information will be show here...</p>
                            <p class="text-center"><a href="#" data-toggle="modal" data-target="#addvolunteerexperience" class="card-link">Let's Go</a></p>
                            </div>
                            <div class="row mt-2" id="dvtblvolunteer">
                                <div class="col-md-12">
                                    <table class="table" id="tblvolunteer">
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
                <div class="col-md-6">
                    <div class="card">
                    <div class="card-header" style="background-image: linear-gradient(to right, #0061a5, #2b9b6e); color:white">
                        <b data-scroll="toggle(.fromLeftIn, .fromLeftOut)"> Skills <a href="#" class="float-right text-white" data-toggle="modal" data-target="#addskills" >+Add</a></b>
                        </div>
                    <div class="card-body" data-scroll="toggle(.fromLeftIn, .fromLeftOut)">
                            <div id="skillempty">
                                <p>All the Skills information will be show here...</p>
                            <p class="text-center"><a href="#" data-toggle="modal" data-target="#addskills" class="card-link">Let's Go</a></p>
                            </div>
                            <div class="row mt-2" id="dvskills">
                                <div class="col-md-12">
                                    <table class="table" id="tblskills">
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
            </div>



            <div class="row pt-2 pb-2">
                <div class="col-md-6">
                    <div class="card">
                    <div class="card-header" style="background-image: linear-gradient(to right, #0061a5, #2b9b6e); color:white">
                        <b data-scroll="toggle(.fromLeftIn, .fromLeftOut)"> Language <a href="#" class="float-right text-white" data-toggle="modal" data-target="#addlanguage" >+Add</a></b>
                        </div>
                    <div class="card-body" data-scroll="toggle(.fromLeftIn, .fromLeftOut)">
                            <div id="languageempty">
                                <p>If you know foreign languages, include them in this section.</p>
                            <p class="text-center"><a href="#" class="card-link" data-toggle="modal" data-target="#addlanguage">Let's Go</a></p>
                            </div>
                            <div class="row mt-2" id="dvlanguage">
                                <div class="col-md-12">
                                    <table class="table" id="tblLanguage">
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
                <div class="col-md-6">
                    <div class="card">
                    <div class="card-header" style="background-image: linear-gradient(to right, #0061a5, #2b9b6e); color:white">
                        <b data-scroll="toggle(.fromLeftIn, .fromLeftOut)">Honour & Awards <a href="#" class="float-right text-white" data-toggle="modal" data-target="#addhonorandaward" >+Add</a></b>
                        </div>
                    <div class="card-body" data-scroll="toggle(.fromLeftIn, .fromLeftOut)">
                            <div id="honorawardsempty">
                                <p>All the information for Honour & Awards will be shown here...</p>
                            <p class="text-center"><a href="#" class="card-link" data-toggle="modal" data-target="#addhonorandaward">Let's Go</a></p>
                            </div>
                            <div class="row mt-2" id="dvhonosrsandawards">
                                <div class="col-md-12">
                                    <table class="table" id="tblhonosrsandawards">
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
            </div>
            <div class="row pt-2 pb-2">

                <div class="col-md-6">
                    <div class="card">
                    <div class="card-header" style="background-image: linear-gradient(to right, #0061a5, #2b9b6e); color:white">
                        <b data-scroll="toggle(.fromLeftIn, .fromLeftOut)"> Job Wishlist <a href="#" class="float-right text-white" data-toggle="modal" data-target="#addjobwishlist" >+Add</a></b>
                        </div>
                    <div class="card-body" data-scroll="toggle(.fromLeftIn, .fromLeftOut)">
                            <div id="jobwishlistempty">
                                <p>All the information for jobwhish will be show here...</p>
                            <p class="text-center"><a href="#" class="card-link" data-toggle="modal" data-target="#addjobwishlist">Let's Go</a></p>
                            </div>
                            <div class="row mt-2" id="dvjobwishlist">
                                <div class="col-md-12">
                                    <table class="table" id="tbljobwishlist">
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
                <div class="col-md-6">
                    <div class="card">
                    <div class="card-header" style="background-image: linear-gradient(to right, #0061a5, #2b9b6e); color:white">
                        <b data-scroll="toggle(.fromLeftIn, .fromLeftOut)"> Intrest <a href="#" class="float-right text-white" data-toggle="modal" data-target="#addintrest" >+Add</a></b>
                        </div>
                    <div class="card-body" data-scroll="toggle(.fromLeftIn, .fromLeftOut)">
                            <div id="intrestempty">
                                <p>All the Intrest will be show here</p>
                            <p class="text-center"><a href="#" class="card-link" data-toggle="modal" data-target="#addintrest">Let's Go</a></p>
                            </div>
                            <div class="row mt-2" id="dvintrest">
                                <div class="col-md-12">
                                    <table class="table" id="tblintrest">
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
            </div>


            <div class="row pt-2 pb-2">
                <div class="col-md-6">
                    <div class="card">
                    <div class="card-header" style="background-image: linear-gradient(to right, #0061a5, #2b9b6e); color:white">
                        <b data-scroll="toggle(.fromLeftIn, .fromLeftOut)"> Projects <a href="#" class="float-right text-white" data-toggle="modal" data-target="#addproject" >+Add</a></b>
                        </div>
                    <div class="card-body" data-scroll="toggle(.fromLeftIn, .fromLeftOut)">
                            <div id="projectempty">
                                <p>All the worked project informatin will be show here..</p>
                            <p class="text-center"><a href="#" class="card-link" data-toggle="modal" data-target="#addproject">Let's Go</a></p>
                            </div>
                            <div class="row mt-2" id="dvprojects">
                                <div class="col-md-12">
                                    <table class="table" id="tblprojects">
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
                <div class="col-md-6">
                    <div class="card">
                    <div class="card-header" style="background-image: linear-gradient(to right, #0061a5, #2b9b6e); color:white">
                        <b data-scroll="toggle(.fromLeftIn, .fromLeftOut)"> Publication <a href="#" class="float-right text-white" data-toggle="modal" data-target="#addpublication" >+Add</a></b>
                        </div>
                    <div class="card-body" data-scroll="toggle(.fromLeftIn, .fromLeftOut)">
                            <div id="publicationempty">
                                <p>All the Publication informatin will be show here..</p>
                            <p class="text-center"><a href="#" class="card-link" data-toggle="modal" data-target="#addpublication">Let's Go</a></p>
                            </div>
                            <div class="row mt-2" id="dvpublication">
                                <div class="col-md-12">
                                    <table class="table" id="tblpublication">
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
            </div>
        </div>
    




    <!-- Modal -->

    <div class="modal fade" id="addeducation" tabindex="-1" role="dialog" aria-labelledby="addeducationLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                    <div class="modal-header text-white bg-info">
                    <b class="modal-title" id="addeducationLabel">
                        <label>Add Education</label>
                    </b>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmAddeducation" class="bootstrap-form needs-validation" novalidate>
                      <input type="hidden" id="educationId" name="educationId" value="0">  
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label>School /college/university Name</label><span class="text-danger">*</span>
                                <input type="text" name="university" id="university" class="form-control" placeholder="King Saudi University" required/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Degree</label><span class="text-danger">*</span>
                                <select name="degree" id="degree" class="form-control" required>
                                    <option value="">select</option>
                                    <option value="Master">Master</option>
                                    <option value="Bechlor">Bechlor</option>
                                    <option value="Post Graduation">Post Graduation</option>
                                </select>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Field of study</label><span class="text-danger">*</span>
                                <select name="fieldofstudy" id="fieldofstudy" class="form-control" required>
                                    <option value="">select</option>
                                    <option value="Agriculture">Agriculture</option>
                                    <option value="Computer Science">Computer Science</option>
                                    <option value="Mechanical Engineering">Mechanical Engineering</option>
                                </select>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <label>Start Year</label><span class="text-danger">*</span>
                                <input type="date" id="startyear" name="startyear" class="form-control" required/>
                            </div>
                            <div class="col-md-4 form-group">
                                <label>End Year</label><span class="text-danger">*</span>
                                <input type="date" id="endyear" name="endyear" class="form-control" required/>
                            </div>
                            <div class="col-md-4 form-group">
                                <label>Grade</label><span class="text-danger">*</span>
                                <select name="grade" id="grade" class="form-control" required>
                                    <option value="">select</option>
                                    <option value="From 50% To 59%">From 50% To 59%</option>
                                    <option value="From 60% To 69%">From 60% To 69%</option>
                                    <option value="From 70% To 79%">From 70% To 79%</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label>Description</label>
                                <textarea id="educationdescription" name="educationdescription" class="form-control" rows="5"></textarea>
                            </div>
                        </div>
                        <!-- <div class="row">
                            <div class="col-md-6 form-group">
                                <a id="uploadCerificate" class="btn btn-primary text-white">Upload Certificate</a>
                                <input type="file" id="uploadCerificate_file" style="display: none;" />
                            </div>
                        </div> -->

                        <div class="row pt-2">
                            <div class="col-md-6">
                                <button type="reset" class="btn btn-secondary float-left" data-dismiss="modal">Cancel</button>
                            </div>
                            <div class="col-md-6">
                                <!--<button type="submit" class="btn btn-primary float-right">Add</button>-->
                                <input  value="Add" type="button" onclick="saveToDatabase('addProfileInfo','frmAddeducation','addusereducation','#addeducation')" id="addusereducation" name="addusereducation"  class="btn btn-primary float-right">
                            </div>
                        </div>

                    </form>
                </div>

            </div>
        </div>
    </div>


    <div class="modal fade" id="editprofile" tabindex="-1" role="dialog" aria-labelledby="editprofileLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                    <div class="modal-header text-white bg-info">
                    <b class="modal-title" id="editprofileLabel">
                        <label>Edit Profile</label>
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
                                <label>Title</label><span class="text-danger">*</span>
                                <select id="title" name="title" class="form-control" required >
                                    <option value="">select</option>
                                    <option value="Mr.">Mr.</option>
                                    <option value="Ms.">Ms.</option>
                                    <option value="Doc.">Doc.</option>
                                    <option value="Prince.">Prince.</option>
                                    <option value="Princess.">Princess.</option>
                                </select>
                                <div class="invalid-feedback">
                                    Title Name is required.
                                </div>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>First Name</label><span class="text-danger">*</span>
                                <input type="text" name="firstname" id="firstname" class="form-control" placeholder="mustafa" required />
                                <div class="invalid-feedback">
                                    First Name is required.
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Father Name</label><span class="text-danger">*</span>
                                <input type="text" name="fathername" id="fathername" class="form-control" placeholder="mustafa" required />
                                <div class="invalid-feedback">
                                    Father Name is required.
                                </div>
                            </div>

                            <div class="col-md-6 form-group">
                                <label>Grandfather Name</label><span class="text-danger">*</span>
                                <input type="text" class="form-control" id="grandfathername" name="grandfathername" placeholder="nafees" required />
                                <div class="invalid-feedback">
                                    Grandfather Name is required.
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Family Name</label><span class="text-danger">*</span>
                                <input type="text" class="form-control" id="familyname" name="familyname" placeholder="nafees" required />
                                <div class="invalid-feedback">
                                    Family Name is required.
                                </div>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Email</label><span class="text-danger">*</span>
                                <input type="email" class="form-control" id="email" name="email" placeholder="demo@gmail.com" required />
                                <div class="invalid-feedback">
                                    Email is required.
                                </div>
                            </div>
                        </div>

                        <div class="row">
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
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Gender</label><span class="text-danger">*</span>
                                <select name="gender" id="gender" class="form-control" required>
                                    <option value="">select</option>
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                </select>
                                <div class="invalid-feedback">
                                    Gender is required.
                                </div>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Nationality </label><span class="text-danger">*</span>
                                <select name="region" id="region" class="form-control" required>
                                    <option value="">select</option>
                                    <option value="Suadi">Suadi</option>
                                    <option value="American">American</option>
                                    <option value="Lebnani">Lebnani</option>
                                </select>
                                <div class="invalid-feedback">
                                    Nationality is required.
                                </div>
                            </div>

                        </div>

                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>National ID </label><span class="text-danger">*</span>
                                <input type="number" id="nationalid" name="nationalid" class="form-control" required />
                                <div class="invalid-feedback">
                                    National ID is required.
                                </div>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Passport ID</label><span class="text-danger">*</span>
                                <input type="text" id="passportid" name="passportid" class="form-control" required />
                                <div class="invalid-feedback">
                                    Passport ID is required.
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Passport Expire Date</label><span class="text-danger">*</span>
                                <input type="date" name="passportexpiredate" id="passportexpiredate" class="form-control" required />
                                <div class="invalid-feedback">
                                    Passport Expire Date is required.
                                </div>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Date of Birth</label>
                                <input type="date" name="dateofbirth" id="dateofbirth" class="form-control" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <a id="passportscan" class="btn btn-primary text-white">Passport Scan</a>
                                <input type="file" id="passportscan_file" style="display: none;" />
                                <label id="passportscanfilename"></label>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Current Education/Training Status</label>
                                <select name="education" id="education" class="form-control">
                                    <option value="">select</option>
                                    <option value="1">School</option>
                                    <option value="2">University</option>
                                </select>
                            </div>
                        </div>

                        <div class="row mt-2 pb-2">
                            <div class="col-md-12">
                                <b>Address <span class="float-right questionmark" data-toggle="tooltip" title="show tooltip">?</span> </b>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <label>Country of Residence</label>
                                <select name="countryofresidence" id="countryofresidence" class="form-control">
                                    <option value="">select</option>
                                    <option value="Saudi Arabia">Saudi Arabia</option>
                                    <option value="United States">United States</option>
                                    <option value="lebanon">lebanon</option>
                                </select>
                            </div>
                            <div class="col-md-4 form-group">
                                <label>City of Residence</label>
                                <select name="cityofresidence" id="cityofresidence" class="form-control">
                                    <option value="">select</option>
                                    <option value="Riyadh">Riyadh</option>
                                    <option value="New York">New York</option>
                                    <option value="Beirut">Beirut</option>
                                </select>
                            </div>
                            <div class="col-md-4 form-group">
                                <label>National Address</label>
                                <input type="text" name="nationaladdress" id="nationaladdress" class="form-control" placeholder="National Address" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <label>Postal Code</label>
                                <input type="number" name="postalcode" id="postalcode" placeholder="12345" class="form-control" />
                            </div>
                            <div class="col-md-4 form-group">
                                <label>Street</label>
                                <input type="text" name="street" id="street" placeholder="Khurais" class="form-control" />
                            </div>
                            <div class="col-md-4 form-group">
                                <label>State</label>
                                <input type="text" name="state" id="state" placeholder="state" class="form-control" />
                            </div>
                        </div>

                        <div class="row mt-2 pb-2">
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
                      <!--      <div class="row">
                            <div class="col-md-6 form-group">
                                <a href="#" class="btn btn-outline-primary">Other</a>
                            </div>
                        </div> -->

                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label>Additional Info</label>
                                <textarea id="additionalinfo" name="additionalinfo" class="form-control" rows="5"></textarea>
                            </div>
                        </div>

                        <div class="row pt-2">
                            <div class="col-md-6">
                                <button type="reset" class="btn btn-secondary float-left" data-dismiss="modal">Cancel</button>
                            </div>
                            <div class="col-md-6">
                                <!--<button type="submit" class="btn btn-primary float-right">Update</button>-->
                                <input value="Update" type="button" onclick="saveToDatabase('addProfileInfo','frmeditprofile','saveGeneralInfo','#editprofile')" id="updateuserprofile" name="updateuserprofile" class="btn btn-primary float-right">
                            </div>
                        </div>

                    </form>
                </div>

            </div>
        </div>
    </div>

    <div class="modal fade" id="addworkstatus" tabindex="-1" role="dialog" aria-labelledby="addworkstatusLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                    <div class="modal-header text-white bg-info">
                    <b class="modal-title" id="addworkstatusLabel">
                        <label>Add Work Status</label>
                    </b>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmAddworkstatus" class="bootstrap-form needs-validation" novalidate>
                         <input type="hidden" id="workstatusId" name="workstatusId" value="0">
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Current Work Status</label><span class="text-danger">*</span>
                                <select name="currenworkstatus" id="currenworkstatus" class="form-control" required>
                                    <option value="">select</option>
                                    <option value="Student">Student</option>
                                    <option value="Employed">Employed</option>
                                </select>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Work Experience</label><span class="text-danger">*</span>
                                <select name="workexprience" id="workexprience" class="form-control" required>
                                    <option value="">select</option>
                                    <option value="Beginner">Beginner</option>
                                    <option value="Intermediate">Intermediate</option>
                                    <option value="Advanced">Advanced</option>
                                    <option value="Proficient">Proficient</option>
                                </select>
                            </div>
                        </div>
                        <div class="row pt-2">
                            <div class="col-md-6">
                                <button type="reset" class="btn btn-secondary float-left" data-dismiss="modal">Cancel</button>
                            </div>
                            <div class="col-md-6">
                                <!--<button type="submit" class="btn btn-primary float-right">Add</button>-->
                                <input value="Add" type="button" onclick="saveToDatabase('addProfileInfo','frmAddworkstatus','addWorkStatus','#addworkstatus')" id="adduserworkstatus" name="adduserworkstatus"  class="btn btn-primary float-right">
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
                    <div class="modal-header text-white bg-info">
                    <b class="modal-title" id="addworkexperienceLabel">
                        <label>Add Work Experience</label>
                    </b>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmaddworkexperience" class="bootstrap-form needs-validation" novalidate>
                    <input type="hidden" id="workexperienceId" name="workexperienceId" value="0">  
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Title</label><span class="text-danger">*</span>
                                <select name="jobtitle" id="jobtitle" class="form-control" required>
                                    <option value="">select</option>
                                    <option value="IT Manager">IT Manager</option>
                                    <option value="Sales Manager">Sales Manager</option>
                                    <option value="Administrator">Administrator</option>
                                </select>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Company</label><span class="text-danger">*</span>
                                <input type="text" id="company" name="company" class="form-control" required/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <label>Location</label><span class="text-danger">*</span>
                                <input type="text" id="location" name="location" class="form-control" required/>
                            </div>
                            <div class="col-md-4 form-group">
                                <label>Start Date</label><span class="text-danger">*</span>
                                <input type="date" id="workstartdate" name="workstartdate" class="form-control" required/>
                            </div>
                            <div class="col-md-4 form-group">
                                <label>End Date</label><span class="text-danger">*</span>
                                <input type="date" id="workendate" name="workendate" class="form-control" required/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <label>Description</label><span class="text-danger">*</span>
                                <textarea id="workdescription" name="workdescription" class="form-control" rows="5" required></textarea>
                            </div>
                        </div>


                        <div class="row pt-2">
                            <div class="col-md-6">
                                <button type="reset" class="btn btn-secondary float-left" data-dismiss="modal">Cancel</button>
                            </div>
                            <div class="col-md-6">
                                <!--<button type="submit" class="btn btn-primary float-right">Add</button>-->
                                 <input value="Add" type="button" onclick="saveToDatabase('addProfileInfo','frmaddworkexperience','addWorkExperience','#addworkexperience')" id="adduserworkexperience" name="adduserworkexperience" class="btn btn-primary float-right">
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
                        <label>Add Licenses & Certifications</label>
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
                                <label>Name</label><span class="text-danger">*</span>
                                <input type="text" name="licencename" id="licencename" class="form-control" required/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Issuing Organization </label><span class="text-danger">*</span>
                                <input type="text" name="issuingorganization" id="issuingorganization" class="form-control" required/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Issue Date</label>
                                <input type="date" name="issuedate" id="issuedate" class="form-control" />
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Expiration Date</label>
                                <input type="date" name="expiredate" id="expiredate" class="form-control" />
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Credential ID</label>
                                <input type="text" name="credentailid" id="credentailid" class="form-control" />
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Credential URL</label>
                                <input type="text" name="credentailurl" id="credentailurl" class="form-control" />
                            </div>
                        </div>

                        <div class="row">
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
                        </div>
                        <div class="row pt-2">
                            <div class="col-md-6">
                                <button type="reset" class="btn btn-secondary float-left" data-dismiss="modal">Cancel</button>
                            </div>
                            <div class="col-md-6">
                                <!--<button type="submit" class="btn btn-primary float-right">Update</button>-->
                               <input value="Add" type="button" onclick="saveToDatabase('addProfileInfo','frmlicenceandcertification','adduserlicenceandcertification','#addlicenceandcertification')" id="adduserlicenceandcertification" name="adduserlicenceandcertification" class="btn btn-primary float-right">
                            </div>
                        </div>

                    </form>
                </div>

            </div>
        </div>
    </div>

    <div class="modal fade" id="addvolunteerexperience" tabindex="-1" role="dialog" aria-labelledby="addvolunteerexperienceLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                    <div class="modal-header text-white bg-info">
                    <b class="modal-title" id="addvolunteerexperienceLabel">
                        <label>Add Volunteer Experience</label>
                    </b>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmAddvolunteerexp" class="bootstrap-form needs-validation" novalidate>
                     <input type="hidden" id="volunteerexpId" name="volunteerexpId" value="0">
                       <div class="row">
                            <div class="col-md-12 form-group">
                                <label>Organization</label><span class="text-danger">*</span>
                                <input type="text" id="volunteerorganizationname" name="volunteerorganizationname" class="form-control" required />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Role</label><span class="text-danger">*</span>
                                <input type="text" id="volunteerrole" name="volunteerrole" class="form-control" required/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Cause</label><span class="text-danger">*</span>
                                <input type="text" id="volunteercause" name="volunteercause" class="form-control" required/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Start date</label>
                                <input type="date" id="volunteerstartdate" name="volunteerstartdate" class="form-control" />
                            </div>
                            <div class="col-md-6 form-group">
                                <label>End date</label>
                                <input type="date" id="volunteerendate" name="volunteerendate" class="form-control" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label>Description</label>
                                <textarea name="volunteerdescription" id="volunteerdescription" class="form-control" rows="5"></textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="volunteercurrent" name="volunteercurrent">
                                        <label class="form-check-label" for="volunteercurrent">
                                            I am currently volunteering in this role
                                        </label>
                                    </div>
                                </div>
                            </div>

                        </div>

                        <div class="row pt-2">
                            <div class="col-md-6">
                                <button type="reset" class="btn btn-secondary float-left" data-dismiss="modal">Cancel</button>
                            </div>
                            <div class="col-md-6">
                                <input value="Add" type="button" onclick="saveToDatabase('addProfileInfo','frmAddvolunteerexp','adduservolunteerexperience','#addvolunteerexperience')" id="adduservolunteerexperience" name="adduservolunteerexperience" class="btn btn-primary float-right">
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
                    <div class="modal-header text-white bg-info">
                    <b class="modal-title" id="addlanguageLabel">
                        <label>Add Languages</label>
                    </b>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmAddLanguage" class="bootstrap-form needs-validation" novalidate>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Language</label><span class="text-danger">*</span>
                                <select name="language" id="language" class="form-control" required>
                                    <option value="">select</option>
                                    <option value="Arabic">Arabic</option>
                                    <option value="English">English</option>
                                    <option value="French">French</option>
                                </select>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Proficiency</label><span class="text-danger">*</span>
                                <select name="languageproficiency" id="languageproficiency" class="form-control" required>
                                    <option value="">select</option>
                                    <option value="Beginner">Beginner</option>
                                    <option value="Intermediate">Intermediate</option>
                                    <option value="Advanced">Advanced</option>
                                    <option value="Proficient">Proficient</option>
                                </select>
                            </div>
                        </div>

                        <div class="row pt-2">
                            <div class="col-md-6">
                                <button type="reset" class="btn btn-secondary float-left" data-dismiss="modal">Cancel</button>
                            </div>
                            <div class="col-md-6">
                                 <input value="Add" type="button" onclick="saveToDatabase('addProfileInfo','frmAddLanguage','addlanguage','#addlanguage')" id="addlangugae" name="addlangugae" class="btn btn-primary float-right">
                                <!--<button type="submit" class="btn btn-primary float-right">Add</button>-->
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
                    <div class="modal-header text-white bg-info">
                    <b class="modal-title" id="addskillsLabel">
                        <label>Add Skills</label>
                    </b>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmaddskills" class="bootstrap-form needs-validation" novalidate>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Skill</label><span class="text-danger">*</span>
                                <select id="skillname" name="skillname" class="form-control" required>
                                    <option value="">select</option>
                                    <option value="Analytical skills">Analytical skills</option>
                                    <option value="Communication skills">Communication skills</option>
                                    <option value="Computer skills">Computer skills</option>
                                </select>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Level</label><span class="text-danger">*</span>
                                <select id="skilllevel" name="skilllevel" class="form-control" required>
                                    <option value="">select</option>
                                    <option value="Beginner">Beginner</option>
                                    <option value="Intermediate">Intermediate</option>
                                    <option value="Advanced">Advanced</option>
                                    <option value="Proficient">Proficient</option>
                                </select>

                            </div>
                        </div>

                        <div class="row pt-2">
                            <div class="col-md-6">
                                <button type="reset" class="btn btn-secondary float-left" data-dismiss="modal">Cancel</button>
                            </div>
                            <div class="col-md-6">
                                <!--<button type="submit" class="btn btn-primary float-right">Add</button>-->
                                 <input value="Add" type="button" onclick="saveToDatabase('addProfileInfo','frmaddskills','addsuserkills','#addskills')" id="addsuserkills" name="addsuserkills" class="btn btn-primary float-right">
                            </div>
                        </div>

                    </form>
                </div>

            </div>
        </div>
    </div>



    <div class="modal fade" id="addproject" tabindex="-1" role="dialog" aria-labelledby="addprojectLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                    <div class="modal-header text-white bg-info">
                    <b class="modal-title" id="addprojectLabel">
                        <label>Add Project</label>
                    </b>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmaddproject" class="bootstrap-form needs-validation" novalidate>
                       <input type="hidden" id="projectId" name="projectId" value="0">  
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Project Name</label>
                                <input type="text" id="projectname" name="projectname" class="form-control" />
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Project URL</label>
                                <input type="text" id="projecturl" name="projecturl" class="form-control" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Start Date</label>
                                <input type="date" name="projectstartdate" id="projectstartdate" class="form-control" />
                            </div>
                            <div class="col-md-6 form-group">
                                <label>End Date</label>
                                <input type="date" name="projectenddate" id="projectenddate" class="form-control" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label>Description</label>
                                <textarea id="projectdescription" name="projectdescription" class="form-control" rows="5"></textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <div class="form-group">
                                    <div class="form-check">
                                        <input class="form-check-input" type="checkbox" id="projectcredentailnotexpire" name="projectcredentailnotexpire">
                                        <label class="form-check-label" for="projectcredentailnotexpire">
                                            I am currently working on this project
                                        </label>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="row pt-2">
                            <div class="col-md-6">
                                <button type="reset" class="btn btn-secondary float-left" data-dismiss="modal">Cancel</button>
                            </div>
                            <div class="col-md-6">
                                  <input value="Add" type="button" onclick="saveToDatabase('addProfileInfo','frmaddproject','adduserproject','#addproject')" id="adduserproject" name="adduserproject" class="btn btn-primary float-right">
                                <!--<button type="submit" class="btn btn-primary float-right">Add</button>-->
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
                    <div class="modal-header text-white bg-info">
                    <b class="modal-title" id="addhonorandawardLabel">
                        <label>Add Honour and Awards</label>
                    </b>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmhonor" class="bootstrap-form needs-validation" novalidate>
                      <input type="hidden" id="honorandawardId" name="honorandawardId" value="0">  
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
                            <div class="col-md-6">
                                <button type="reset" class="btn btn-secondary float-left" data-dismiss="modal">Cancel</button>
                            </div>
                            <div class="col-md-6">
                                <input value="Add" type="button" onclick="saveToDatabase('addProfileInfo','frmhonor','adduserhonorandaward','#addhonorandaward')" id="adduserhonorandaward" name="adduserhonorandaward" data-dismiss="modal" class="btn btn-primary float-right">
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
                    <div class="modal-header text-white bg-info">
                    <b class="modal-title" id="addintrestLabel">
                        <label>Add Intrest</label>
                    </b>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmAddIntrest" class="bootstrap-form needs-validation" novalidate>
                        <input type="hidden" id="intrestId" name="intrestId" value="0">  
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label>Intrest</label><span class="text-danger">*</span>
                                <input type="text" id="intrest" name="intrest" class="form-control" required/>
                            </div>
                        </div>
                        <div class="row pt-2">
                            <div class="col-md-6">
                                <button type="reset" class="btn btn-secondary float-left" data-dismiss="modal">Cancel</button>
                            </div>
                            <div class="col-md-6">
                               <input value="Add" type="button" onclick="saveToDatabase('addProfileInfo','frmAddIntrest','addnewintrest','#addintrest')" id="addnewintrest" name="addnewintrest" class="btn btn-primary float-right">
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
                    <div class="modal-header text-white bg-info">
                    <b class="modal-title" id="addjobwishlistLabel">
                        <label>Add Job Wishlist</label>
                    </b>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmAddJobWishList" class="bootstrap-form needs-validation" novalidate>
                        <div class="row">
                            <div class="col-md-12 form-group">
                                <label>Wishlist</label><span class="text-danger">*</span>
                                <select id="jobwishlist" name="jobwishlist" class="form-control" required>
                                    <option value="">select</option>
                                    <option value="Accountant">Accountant</option>
                                    <option value="Software Engineer">Software Engineer</option>
                                    <option value="Sales Manager">Sales Manager</option>
                                </select>
                            </div>
                        </div>
                        <div class="row pt-2">
                            <div class="col-md-6">
                                <button type="reset" class="btn btn-secondary float-left" data-dismiss="modal">Cancel</button>
                            </div>
                            <div class="col-md-6">
                                 <input value="Add" type="button" onclick="saveToDatabase('addProfileInfo','frmAddJobWishList','addnewjobwishlist','#addjobwishlist')" id="addnewjobwishlist" name="addnewjobwishlist" class="btn btn-primary float-right">
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>


    <div class="modal fade" id="addpublication" tabindex="-1" role="dialog" aria-labelledby="addpublicationLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                    <div class="modal-header text-white bg-info">
                    <b class="modal-title" id="addlanguageLabel">
                        <label>Add Publication</label>
                    </b>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="frmAddUserPublication" class="bootstrap-form needs-validation" novalidate>
                       <input type="hidden" id="publicationId" name="publicationId" value="0">  
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Publication Title</label><span class="text-danger">*</span>
                                <input type="text" name="publicationsubject" id="publicationsubject" class="form-control" />
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Publication Type</label><span class="text-danger">*</span>
                                <select name="publicationtype" id="publicationtype" class="form-control" required>
                                    <option value="">select</option>
                                    <option value="Social media and web pages">Social media and web pages</option>
                                    <option value="Newspapers">Newspapers</option>
                                    <option value="Conference proceedings">Conference proceedings</option>
                                    <option value="Magazines">Magazines</option>
                                    <option value="Scientific journals">Scientific journals</option>
                                    <option value="Reference works">Reference works</option>
                                    <option value="Books">Books</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group">
                                <label>Role</label><span class="text-danger">*</span>
                                <select name="publicationrole" id="publicationrole" class="form-control" required>
                                    <option value="">select</option>
                                    <option value="Main Author">Main Author</option>
                                    <option value="Content Writer">Content Writer</option>
                                    <option value="Designer">Designer</option>
                                </select>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>URL</label><span class="text-danger">*</span>
                                <input type="url" name="publicationurl" id="publicationurl" class="form-control" required/>
                            </div>
                            <div class="col-md-6 form-group">
                                <label>Date</label><span class="text-danger">*</span>
                                <input type="date" name="publishingdate" id="publishingdate" class="form-control" required/>
                            </div>
                        </div>

                        <div class="row pt-2">
                            <div class="col-md-6">
                                <button type="reset" class="btn btn-secondary float-left" data-dismiss="modal">Cancel</button>
                            </div>
                            <div class="col-md-6">
                                 <input value="Add" type="button" onclick="saveToDatabase('addProfileInfo','frmAddUserPublication','addluserpublication','#addpublication')" id="addluserpublication" name="addluserpublication" class="btn btn-primary float-right">
                                <!--<button type="submit" class="btn btn-primary float-right">Add</button>-->
                            </div>
                        </div>

                    </form>
                </div>

            </div>
        </div>
    </div>
        <script src="/o/new-misk-theme/js/from/jquery-3.3.1.min.js"></script>
        <script src="/o/new-misk-theme/js/from/bootstrap.min.js"></script>
        <script src="/o/new-misk-theme/js/from/popper.min.js"></script>
        <script src="/o/new-misk-theme/js/from/validator.js"></script>
        <script src="/o/new-misk-theme/js/from/bootstrap-tagsinput.js"></script>
        <script src="/o/new-misk-theme/js/from/jquery.dataTables.min.js"></script>
        <script src="/o/new-misk-theme/js/from/dataTables.bootstrap4.min.js"></script>
        <script src="/o/new-misk-theme/js/from/ScrollTrigger.js"></script>
        <script src="/o/new-misk-theme/alerts/sweet-alert.min.js"></script> 
           <script type="text/javascript">
           var oTableeducation = "";
           var oTableworkexp   = "";
           var oTable          = "";
           var oTablelicence   = "";
           var oTablevolunteer = "";
           var oTablehonor     = "";
           var oTableproject   = "";
           var oTablskills 	   = "";
           var oTablintrest    = "";
           var oTabljobwishlist= "";
           var oTablworkstatus = "";
           var oTablpublication= "";
           var obj             = {};
           
           $(document).ready(function () {
        		    obj = {};
                 	var section = "all";
                 	var action = "getProfileInfo";
                 	obj.userId = themeDisplay.getUserId();
        	    getprofileDetails('all','getProfileInfo',obj);
        	      
        	   
               $('#dveducation').css("display", "none");
               $('#dvlanguage').css("display", "none");

               $('#dvworkexperience').css("display", "none");
               $('#dvLicensesandCertification').css("display", "none");
               $('#dvhonosrsandawards').css("display", "none");
               $('#dvprojects').css("display", "none");
               $('#dvtblvolunteer').css("display", "none");
               $('#dvskills').css("display", "none");
               $('#dvintrest').css("display", "none");
               $('#dvjobwishlist').css("display", "none");

               $('#dvworkstatus').css("display", "none");
               $('#dvpublication').css("display", "none");


               $(function () {
                   $('[data-toggle="tooltip"]').tooltip()
               });
               $("#profilepic").click(function () {
                   $("input[id='profilepic_file']").click();
               });

               $("#profilepic_file").on('change', function () {
                   readURL(this);
               });

               var readURL = function (input) {
                   if (input.files && input.files[0]) {
                	   debugger;
                       //alert(input.files[0].name);
                       var reader = new FileReader();
                       reader.onload = function (e) {
                    	     $('#profileimage').attr('src', e.target.result);
                    	      obj = {};
                           obj.command = "saveProfileImage";
         	        	   obj.userId     =  themeDisplay.getUserId();
         	        	   obj.image = $("#profileimage")[0].src;
         	        	   var command = "saveProfileImage";
         	        	   var action = "addProfileInfo";
         	        	   
         	        	   saveProfileImage(obj,command,action);
         	        	   
                      
                        
                       }
                       reader.readAsDataURL(input.files[0]);
                   }
               }

               $("#uploadCerificate").click(function () {
                   $("input[id='uploadCerificate_file']").click();
               });

               $("#passportscan_file").on('change', function () {
                   GetPassportScanName(this);
               });
               var GetPassportScanName = function (input) {
                   if (input.files && input.files[0]) {
                       //alert(input.files[0].name);
                       // $('#passportscanfilename').val(input.files[0].name);
                       $('#passportscanfilename').text(input.files[0].name);
                   }
               }

               $("#passportscan").click(function () {
                   $("input[id='passportscan_file']").click();
               });

               $("#skills").tagsinput('items');



               $(function () {
                oTable = $('#tblLanguage').DataTable({
                       "pagingType": "full_numbers",
                       responsive: true,
                       paging: false,
                       bFilter: false,
                       bInfo: false

                   });

                   oTableeducation = $('#tbleducation').DataTable({
                       "pagingType": "full_numbers",
                       responsive: true,
                       paging: false,
                       bFilter: false,
                       bInfo: false
                   });

                   oTableworkexp = $('#tblworkexperience').DataTable({
                       "pagingType": "full_numbers",
                       responsive: true,
                       paging: false,
                       bFilter: false,
                       bInfo: false
                   });

                 oTablelicence = $('#tblLicensesandCertification').DataTable({
                       "pagingType": "full_numbers",
                       responsive: true,
                       paging: false,
                       bFilter: false,
                       bInfo: false
                   });

                  oTablevolunteer = $('#tblvolunteer').DataTable({
                       "pagingType": "full_numbers",
                       responsive: true,
                       paging: false,
                       bFilter: false,
                       bInfo: false
                   });

                  oTablehonor = $('#tblhonosrsandawards').DataTable({
                       "pagingType": "full_numbers",
                       responsive: true,
                       paging: false,
                       bFilter: false,
                       bInfo: false
                   });

                   oTableproject = $('#tblprojects').DataTable({
                       "pagingType": "full_numbers",
                       responsive: true,
                       paging: false,
                       bFilter: false,
                       bInfo: false
                   });

                  oTablskills = $('#tblskills').DataTable({
                       "pagingType": "full_numbers",
                       responsive: true,
                       paging: false,
                       bFilter: false,
                       bInfo: false
                   });
                   oTablintrest = $('#tblintrest').DataTable({
                       "pagingType": "full_numbers",
                       responsive: true,
                       paging: false,
                       bFilter: false,
                       bInfo: false
                   });

                   oTabljobwishlist = $('#tbljobwishlist').DataTable({
                       "pagingType": "full_numbers",
                       responsive: true,
                       paging: false,
                       bFilter: false,
                       bInfo: false
                   });

                   oTablworkstatus = $('#tblworkstatus').DataTable({
                       "pagingType": "full_numbers",
                       responsive: true,
                       paging: false,
                       bFilter: false,
                       bInfo: false
                   });

                   oTablpublication = $('#tblpublication').DataTable({
                       "pagingType": "full_numbers",
                       responsive: true,
                       paging: false,
                       bFilter: false,
                       bInfo: false
                   });
             
               });

           });
           
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
                          	success: function() {
                        
                          }
                     }
               });
        
           });
           }
           var educationrow = 0;
           
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
	                          debugger;
							 if (section == "all")
                              {
								  getEducationSaved(json);
								  getWorkexperienceSaved(json);
								  getuserworkstatus(json);
								  getLanguageSaved(json);
								  getuserkillsSaved(json);
								  getnewintrest(json);
								  getnewjobwishlist(json);
								  getProjectSaved(json);
								  getuserlicenceandcertification(json);
								  getuservolunteerexperience(json);
								  getuserhonorandaward(json);
								  getuserpublication(json);
                              }
								
	                         }
	                     }
	               });
	        
	           });
           }
           
           
           
           
           var publicationrow = 0;
           function getuserpublication(json){ 
              publicationrow = publicationrow + 1;
              for( var i = 0; i < json.profilePublication.length; i++)
              { 
	              $('#dvpublication').css("display", "");                  
	              var title = json.profilePublication[i].title;
	              var ptype = json.profilePublication[i].ptype;
	              var prole = json.profilePublication[i].prole;
	              var purl = json.profilePublication[i].purl;
	              var pdate = convert(json.profilePublication[i].pdate);
	              var id =  json.profilePublication[i].id;
	              var data = [
	                  '<div> <b>' + title + '<span class="float-right"><a data-id='+ id +' data-toggle="modal" data-target="#addpublication" href="#">'+
	                  '<i class="fa fa-pencil"></i></a><a onclick="deleteProfileRow(' + publicationrow + ',' + id + ',\'deleteUserPublication\',\'deleteData\',\'#tblpublication\')">'+
	                  '<img src="/o/new-misk-theme/images/profile/bin.png" style="margin-left:10px"/></a></span></b><p>'+ptype+'<br/>'+prole+'<br/>'+purl+'<br/>'+pdate+'</div>'
	              ];
	              oTablpublication.row.add(data).draw();
	              $('#publicationempty').css("display", "none");
           }
          }
           var intrestrow = 0;
           function getnewintrest(json){ 
               intrestrow = intrestrow + 1;
               for( var i = 0; i < json.profileIntrest.length; i++)
               { 
               $('#dvintrest').css("display", "");
               var title =  json.profileIntrest[i].title;
               var id =  json.profileIntrest[i].id;
               var data = [
                   '<div> <b>' + title + '<span class="float-right"><a data-toggle="modal" data-id=' + id + ' data-target="#addintrest" href="#">'+
                   '<i class="fa fa-pencil"></i></a><a onclick="deleteProfileRow(' + intrestrow + ',' + id + ',\'deleteIntrest\',\'deleteData\',\'#tblintrest\')">'+
                   '<img src="/o/new-misk-theme/images/profile/bin.png" style="margin-left:10px"/></a></span></b></div>'
               ];
               oTablintrest.row.add(data).draw();
               $('#intrestempty').css("display", "none");
               }
           }

           var honorrow = 0;
           function getuserhonorandaward(json){ 
                honorrow = honorrow + 1;
                for( var i = 0; i < json.ProfileHonourAndAwards.length; i++)
                { 
                $('#dvhonosrsandawards').css("display", "");
               var title = json.ProfileHonourAndAwards[i].title;
               var honorissuer = json.ProfileHonourAndAwards[i].honorissuer;
               var issuedate = convert(json.ProfileHonourAndAwards[i].issuedate);
               var id = json.ProfileHonourAndAwards[i].id;
               var data = [
                   '<div> <b>' + title + '<span class="float-right"><a data-toggle="modal" data-id=' + id + ' data-target="#addhonorandaward" href="#">'+
                   '<i class="fa fa-pencil"></i></a><a onclick="deleteProfileRow(' + honorrow + ',' + id + ',\'deleteHonorandAwardInfo\',\'deleteData\',\'#tblhonosrsandawards\')">'+
                   '<img src="/o/new-misk-theme/images/profile/bin.png" style="margin-left:10px"/></a></span></b><p><b>' + honorissuer + '</b><br/> ' + issuedate + '</p></div>'
               ];
               oTablehonor.row.add(data).draw();
               $('#honorawardsempty').css("display", "none");
                }
           }

           
           var volunteerrow = 0;
           function getuservolunteerexperience(json){ 
               volunteerrow = volunteerrow + 1;
               for( var i = 0; i < json.profileVolunteerExperience.length; i++)
               { 
               $('#dvtblvolunteer').css("display", "");
               var name =  json.profileVolunteerExperience[i].name;
               var role = json.profileVolunteerExperience[i].role;
               var cause = json.profileVolunteerExperience[i].cause;
               var startdate = convert(json.profileVolunteerExperience[i].startdate);
               var endate = convert(json.profileVolunteerExperience[i].endate);
               var id = json.profileVolunteerExperience[i].id;
               var data = [
                   '<div> <b>' + name + '<span class="float-right"><a data-id='+ id +' data-toggle="modal" data-target="#addvolunteerexperience" href="#">'
                   +'<i class="fa fa-pencil"></i></a><a onclick="deleteProfileRow(' +  volunteerrow + ',' + id + ',\'deleteVolunteerExperienceInfo\',\'deleteData\',\'#tblvolunteer\')">'
                   +'<img src="/o/new-misk-theme/images/profile/bin.png" style="margin-left:10px"/></a></span></b><p><b>' + cause + '</b><br/>' + role + '<br/> From : ' + startdate + '<br/> To : ' + endate + ' </p></div>'
               ];

               oTablevolunteer.row.add(data).draw();
               $('#volunteerempty').css("display", "none");
               }
           }

           var wishjoblistrow = 0;
           function getnewjobwishlist(json){ 
        	   wishjoblistrow = wishjoblistrow + 1;
        	   for( var i = 0; i < json.profileJobWishList.length; i++)
               {
	               $('#dvjobwishlist').css("display", "");
	               var jobwishlist = json.profileJobWishList[i].jobwishlist;
	               var id = json.profileJobWishList[i].id;
	               var data = [
	                   '<div> <b>' + jobwishlist + '<span class="float-right">'+
	                   '<a onclick="deleteProfileRow(' + wishjoblistrow + ',' + id + ',\'deleteWishJobListInfo\',\'deleteData\',\'#tbljobwishlist\')">'+
	                   '<img src="/o/new-misk-theme/images/profile/bin.png" style="margin-left:10px"/></a></span></b></div>'
	               ];
	               oTabljobwishlist.row.add(data).draw();
	               $('#jobwishlistempty').css("display", "none");
               }
           }
           var workstatusrow = 0;
           function getuserworkstatus(json){ 
               workstatusrow = workstatusrow + 1;
              
               for(var i = 0; i < json.profileWorkExperience.length; i++)
               { debugger;
	               var currentstatus = json.profileWorkExperience[i].currentWorkStatus;
	               var workexp = json.profileWorkExperience[i].workExperience;
	               var id = json.profileWorkExperience[i].id;
	               if(currentstatus != null)
	               {debugger;
	            	   $('#dvworkstatus').css("display", "");
	            	   var data = [
                    '<div> <b>' + currentstatus + '<span class="float-right"><a data-toggle="modal" data-id=' + id + ' data-target="#addworkstatus" href="#">'+
                    '<i class="fa fa-pencil"></i></a><a onclick="deleteProfileRow(' + workstatusrow + ',' + id + ',\'deleteWorkExperienceInfo\',\'deleteData\',\'#tblworkstatus\')">'+
                    '<img src="/o/new-misk-theme/images/profile/bin.png" style="margin-left:10px"/></a></span></b><p>' + workexp + '</p></div>'
                     ];
                     oTablworkstatus.row.add(data).draw();
                     $('#workstatusempty').css("display", "none");
	               }
            
               }
           }
           var certificationrow = 0;
           function getuserlicenceandcertification(json){
        	   for( var i = 0;i< json.profileLicensesCertifications.length; i++)
               {
        	   certificationrow = certificationrow + 1;
               $('#dvLicensesandCertification').css("display", "");
               var name = json.profileLicensesCertifications[i].title;
               var organization = json.profileLicensesCertifications[i].Iorganization;
               var d1 = new Date(json.profileLicensesCertifications[i].CreateDate);
               var d2 = new Date(json.profileLicensesCertifications[i].ExpirationDate);
               //var issuedate = $("#issuedate").val();
               //var expiredate = $("#expiredate").val();
               var d1fullyear = d1.getFullYear();
               var d2fullyear = d2.getFullYear();
               var id = json.profileLicensesCertifications[i].id;
               var data = [
                   '<div> <b>' + name + '<span class="float-right"><a data-toggle="modal" data-id='+ id +' data-target="#addlicenceandcertification" href="#"><i class="fa fa-pencil"></i></a>'+
                   '<a onclick="deleteProfileRow(' + certificationrow+ ',' + id + ',\'deleteLicenceAndCertificationInfo\',\'deleteData\',\'#tblLicensesandCertification\')">'+
                   '<img src="/o/new-misk-theme/images/profile/bin.png" style="margin-left:10px"/></a></span></b><p><b>' + organization + '</b><br/>Issue Year : ' + d1fullyear + '<br/> Expire Year : ' + d2fullyear + '</p></div>'
               ];
               oTablelicence.row.add(data).draw();
               $('#licenceandcertificationempty').css("display", "none");

            }
           }
           var lagrow = 0;
           	 function getLanguageSaved(json){
           	  for( var i = 0;i< json.profileLanguages.length; i++)
              {
           		 lagrow = lagrow + 1;
               $('#dvlanguage').css("display", "");
               var lan = json.profileLanguages[i].language;
               var profi = json.profileLanguages[i].proficiency;
               var id = json.profileLanguages[i].id;
               var data = [
                   '<div> <b>' + lan + '<span class="float-right">'+
                   '<a class="delete" onclick="deleteProfileRow(' + lagrow + ',' + id + ',\'deleteLanguageInfo\',\'deleteData\',\'#tblLanguage\')">'+
                   '<img src="/o/new-misk-theme/images/profile/bin.png" style="margin-left:10px"/></a></span></b> <p>' + profi + '</p></div>'
               ];
               oTable.row.add(data).draw();
               $('#languageempty').css("display", "none");

               }
           	 }
           	 var projectrow = 0;
        	function getProjectSaved(json){
              	  for( var i = 0;i< json.profileProjects.length; i++)
                 {
              	  debugger;
              	  projectrow = projectrow + 1;
                  $('#dvprojects').css("display", "");
                  var title = json.profileProjects[i].title;
                  var url = json.profileProjects[i].url;
                  var startdate = convert(json.profileProjects[i].startdate);
                  var endate = convert(json.profileProjects[i].endate);
                  var id = json.profileProjects[i].id;
                  var alldata = '<div><b>' + title + '<span class="float-right"><a data-toggle="modal" data-id=' + id + ' data-target="#addproject" href="#">'+
                  '<i class="fa fa-pencil"></i></a><a onclick="deleteProfileRow(' + projectrow  + ',' + id + ',\'deleteProjectInfo\',\'deleteData\',\'#tblprojects\')">'+
                  '<img src="/o/new-misk-theme/images/profile/bin.png" style="margin-left:10px"/></a></span></b><p> Start Date: ' + startdate + '<br/> End Date :' + endate + '<br/>' + url + '</p></div>';

                  var data = [
                      alldata
                  ];
                  oTableproject.row.add(data).draw();
                  $('#projectempty').css("display", "none");
                   }
              	 }
           function getEducationSaved(json)
           {
        	   for( var i =0;i< json.profileEducation.length; i++)
             { 
        	   educationrow = educationrow + 1;
               $('#dveducation').css("display", "");
               var univ =  json.profileEducation[i].educationCategory;
               var degree = json.profileEducation[i].degree;
               var field =  json.profileEducation[i].fieldOfStudy;
               var d1 = new Date(json.profileEducation[i].startYear);
               var d2 = new Date(json.profileEducation[i].endYear);
               var d1fullyear = d1.getFullYear();
               var d2fullyear = d2.getFullYear();
               var year = d2.getFullYear() - d1.getFullYear();
               var grade = json.profileEducation[i].grade;
               var id = json.profileEducation[i].id;
               var data = [
                   '<div>'+ 
	                   '<b>' + univ + '<span class="float-right">'+
		                   '<a data-toggle="modal" data-id= ' + id +  ' data-target="#addeducation" href="#">'+
		                   '<i class="fa fa-pencil"></i></a><a onclick="deleteProfileRow(' + educationrow + ',' + id + ',\'deleteEducationInfo\',\'deleteData\',\'#tbleducation\')">'+
		                   '<img src="/o/new-misk-theme/images/profile/bin.png" style="margin-left:10px"/></a></span>'+
	                   '</b>'+
	                   '<p><b>' + degree + '</b>'+
	                   '<br/>' + field +
	                   '<br/>' + grade +
	                   '<br/>Start Year: ' + d1fullyear +
	                   '<br/> End Date :' + d2fullyear + '</p>'+
                   '</div>'
               ];
               oTableeducation.row.add(data).draw();
               $('#dveducationempty').css("display", "none");
               //alert("registered SUccessfuly");
             }
           }
           var workexprow = 0;
           function getWorkexperienceSaved(json)
           {
        	   for( var i =0;i< json.profileWorkExperience.length; i++)
               { 
               workexprow = workexprow + 1;
              
               var company = json.profileWorkExperience[i].company;
               var location =json.profileWorkExperience[i].location;
               var jobtitle = json.profileWorkExperience[i].title;
               var d1 = new Date(json.profileWorkExperience[i].startDate);
               var d2 = new Date(json.profileWorkExperience[i].endDate);
               var year = d2.getFullYear() - d1.getFullYear();
               var d1fullyear = d1.getFullYear();
               var d2fullyear = d2.getFullYear();
               var id = json.profileWorkExperience[i].id;
               if (company != null)
               { $('#dvworkexperience').css("display", "");
            	   var data = [
                   '<div> <b>' + company + '<span class="float-right">'+
                   '<a data-toggle="modal" data-id=' + id + ' data-target="#addworkexperience" href="#">'+
                   '<i class="fa fa-pencil"></i></a><a onclick="deleteProfileRow(' + workexprow + ',' + id + ',\'deleteWorkExperienceInfo\',\'deleteData\',\'#tblworkexperience\')">'+
                   '<img src="/o/new-misk-theme/images/profile/bin.png" style="margin-left:10px"/></a></span></b><p><b>' + jobtitle + '</b><br/>From: ' + d1fullyear + '<br/> TO :' + d2fullyear + '<br/>' + location + '</p></div>'
                ];
               oTableworkexp.row.add(data).draw();
               $('#workexperienceempty').css("display", "none");
               }
              
              
               }
           }
           
           var skillrow = 0;
          	function getuserkillsSaved(json){
          		for( var i =0;i< json.profileUserkills.length; i++)
                { 
	               skillrow = skillrow + 1;
	               $('#dvskills').css("display", "");
	               var skillname = json.profileUserkills[i].skill;
	               var level = json.profileUserkills[i].level;
	               var id = json.profileUserkills[i].id;
	               var data = [
	                   '<div> <b>' + skillname + '<span class="float-right">'+
	                   '<a   onclick="deleteProfileRow(' + skillrow + ',' + id + ',\'deleteSkillsInfo\',\'deleteData\',\'#tblskills\')">'+
	                   '<img src="/o/new-misk-theme/images/profile/bin.png" style="margin-left:10px"/></a></span></b> <p>' + level + '</p></div>'
	               ];
	               oTablskills.row.add(data).draw();
	               $('#skillempty').css("display", "none");
                }
           }

           
           function deleteProfileRow(rowindex,id,command,action,tableId) {
        	  swal({
        			title: "Are you sure?",
        			text:  "You will not be able to recover this Record!",
        			type:  "warning",
        			showCancelButton: true,
        			confirmButtonColor: '#DD6B55',
        			confirmButtonText: 'Yes, delete it!',
        			closeOnConfirm: false,
        			//closeOnCancel: false
        		},
        		function(){
        			 debugger;
        			 obj = {};
                     obj.id = id;
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
      	                          	swal("Deleted!", "Your record has been deleted!", "success");
	      	                        index = parseInt(rowindex - 1);
	      	                        var oTable = $(tableId).DataTable();
	      	                        oTable.row(index).remove().draw();
      	                        
      	                          	}
      	                     }
      	               });
      	        
      	           });
        			
        			
        		});
        	   
           }
           
           function encodeImageFileAsURL(id) {
        	   debugger
        	   var filesSelected = document.getElementById(id).files;
        	   var srcData ="";
        	   if (filesSelected.length > 0) {
        	   var fileToLoad = filesSelected[0];

        	   var fileReader = new FileReader();

        	   fileReader.onload = function(fileLoadedEvent) {
        	   srcData = fileLoadedEvent.target.result; // <--- data: base64
               alert(srcData);

        	   }
        	   fileReader.readAsDataURL(fileToLoad);
        	   }
        	   
        	   alert(srcData);
        	   return srcData;

        	   }
           
           function saveToDatabase(action,formId,command,modalId)
           {debugger;
        	   <%
        	   int userId =-1;
        	   userId = Integer.parseInt(renderRequest.getRemoteUser());
        	   %>
        	   
        	   var allrequireFields = true;
        	   var formIdjquery = "#"+formId
        	   debugger;
        	   
		         $(formIdjquery).find('input , textarea, select').each(function(){
		        	    if($(this).prop('required')){
		        	    	 
		        	    	if(!this.value)
		        	    	{
		        	        alert(this.name + ' is required');
		        	    	allrequireFields=false;
		  		            return allrequireFields;
		        	    	}
		        	    	else
		        	    	 return allrequireFields;
		        	    	
		        	    } 
		        	});
		         
		      if(allrequireFields)   
		      {    obj = {};
		            var userId = <%=userId%>; 
		      	  obj.command = command;
	        	  obj.userId     =  userId;
		    	  $(modalId).modal('toggle');
		          $('.modal-backdrop').remove();
		          if (command == "saveGeneralInfo")
	        	   {
	        	  obj.profileId = $('#profileId').val();
	        	  obj.fatherName = $('#fathername').val();
	        	  obj.title= $('#title').val();
	        	  obj.firstname= $('#firstname').val();
	        	  obj.fathername= $('#fathername').val();
	        	  obj.grandfathername= $('#grandfathername').val();
	        	  obj.familyname= $('#familyname').val();
	        	  obj.email= $('#email').val();
	        	  obj.mobileno= $('#mobileno').val();
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
	        	  obj.state = $('#state').val()
	        	  obj.instagramlink = $('#instagramlink').val();
	        	  obj.facebooklink = $('#facebooklink').val();
	        	  obj.twitterlink = $('#twitterlink').val();
	        	  obj.linkedin = $('#linkedin').val();
	        	   }
	        	  else	
		        	  if (command == "addusereducation")
	        	   { /**   education section   **/
	        	  obj.university = $('#university').val();
	        	  obj.degree = $('#degree').val();
	        	  obj.fieldOfStudy = $('#fieldofstudy').val();
	        	  obj.startYear = $('#startyear').val();
	        	  obj.endYear = $('#endyear').val();
	        	  obj.educationdescription =  $('#educationdescription').val();
	        	  obj.educationdescription =  $('#educationdescription').val();
	        	  obj.grade = $('#grade').val();
	        	  obj.educationId = $('#educationId').val();
	        	  obj.uploadCerificate_file = setTimeout(encodeImageFileAsURL("uploadCerificate_file"), 30000);
	        	   }
	        	  else	
		        	  if (command == "addWorkExperience")
	        	   {   /**   work section   **/
	        	  obj.jobtitle = $('#jobtitle').val();
	        	  obj.company = $('#company').val();
	        	  obj.location = $('#location').val();
	        	  obj.workstartdate = $('#workstartdate').val();
	        	  obj.workendate = $('#workendate').val();
	        	  obj.workdescription = $('#workdescription').val();
	        	  obj.workexperienceId = $('#workexperienceId').val();
	        	   }
	        	  else	
		        	  if (command == "adduserlicenceandcertification")
	        	   { 
		          /**   Licenses & Certifications section   **/
	        	  obj.licencename= $('#licencename').val();
	        	  obj.licenceandcertificationId= $('#licenceandcertificationId').val();
	           	  obj.issuingorganization= $('#issuingorganization').val();
	           	  obj.issuedate= $('#issuedate').val();
	           	  obj.expiredate= $('#expiredate').val();
	           	  obj.credentailid= $('#credentailid').val();
	           	  obj.credentailurl= $('#credentailurl').val();
	           	  obj.credentailnotexpire= $('#credentailnotexpire').is(":checked");
	        	   }
	        	  else
	        		  if(command == "addWorkStatus")
	        	 {
	        			  obj.currenworkstatus = $('#currenworkstatus').val();
	    	        	  obj.workexprience = $('#workexprience').val();	 
	    	        	  obj.workstatusId = $('#workstatusId').val();
	        	 }
		         else	
			        if (command == "adduservolunteerexperience")
		         { 
	           	  obj.volunteerorganizationname= $('#volunteerorganizationname').val(); 
		          obj.volunteerrole= $('#volunteerrole').val(); 
		          obj.volunteercause= $('#volunteercause').val(); 
		          obj.volunteerstartdate= $('#volunteerstartdate').val(); 
		          obj.volunteerendate= $('#volunteerendate').val(); 
		          obj.volunteerdescription= $('#volunteerdescription').val(); 
		          obj.volunteercurrent= $('#volunteercurrent').is(":checked");
		          obj.volunteerexpId= $('#volunteerexpId').val(); 
		         }
		       else	
			     if (command == "addsuserkills")
		         { 
		          obj.skillname= $('#skillname').val(); 
		          obj.skilllevel= $('#skilllevel').val(); 
		         }
			     else
			      if(command == "addlanguage")
		          { /**   Languages section   **/
		          obj.language= $('#language').val(); 
		          obj.languageproficiency= $('#languageproficiency').val(); 
		          }
		         else
				   if(command == "adduserhonorandaward")
			       { /**   Honour and Awards section   **/
		          obj.honorandawardId= $('#honorandawardId').val(); 
		          obj.honorissuer= $('#honorissuer').val(); 
		          obj.honortitle = $('#honortitle').val(); 
		          obj.honorissuedate= $('#honorissuedate').val(); 
		          obj.issuedescription = $('#issuedescription').val(); 
			       }
				 else
				   if(command == "addnewjobwishlist")
			       {   /**   Job Wishlist section   **/
					   obj.jobwishlist = $('#jobwishlist').val(); 
			       }
		          else
				   if(command == "addnewintrest")
			       {  /**   intrest section   **/
		             obj.intrest = $('#intrest').val(); 
		             obj.intrestId = $('#intrestId').val(); 
			       }
				   else
					   if(command == "adduserproject")
				       {
		          /**   Project section   **/
		           obj.projectname = $('#projectname').val(); 
		           obj.projecturl = $('#projecturl').val(); 
		           obj.projectstartdate = $('#projectstartdate').val(); 
		           obj.projectenddate = $('#projectenddate').val(); 
		           obj.projectdescription = $('#projectdescription').val(); 
		           obj.credentailnotexpire =  $('#projectcredentailnotexpire').is(":checked");
		           obj.projectId =  $('#projectId').val();
				       }
					   else
						   if(command == "addluserpublication")
				          {/**   Publication section   **/
						   obj.publicationId = $('#publicationId').val(); 
				           obj.publicationsubject = $('#publicationsubject').val(); 
				           obj.publicationrole = $('#publicationrole').val(); 
				           obj.publicationtype = $('#publicationtype').val(); 
				           obj.publicationurl = $('#publicationurl').val(); 
				           obj.publishingdate = $('#publishingdate').val(); 
				          }
				      
	           
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
	                        
	                          swal({title: "Saved Successfully", text: "", type: "success"},
	                        		   function(){ 
	                        	           $(formIdjquery).trigger("reset");
	                        		       location.reload();
	                        		   }
	                        		);
	                          }
	                     }
	               });
	        
	           });
	           
	           
		    	 
	           }
           }
  
           function convert(str) {
        	   var date = new Date(str),
        	     mnth = ("0" + (date.getMonth() + 1)).slice(-2),
        	     day = ("0" + date.getDate()).slice(-2);
        	   return [date.getFullYear(), mnth, day].join("-");
        	 }
           
           $('#addvolunteerexperience').on('show.bs.modal', function(e) {
			 var Id = $(e.relatedTarget).data('id');
					if (Id != null)
					getProfileDetailById("volunteerexperience",Id);
				
        	});
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
           $('#addworkstatus').on('show.bs.modal', function(e) {
    			 var Id = $(e.relatedTarget).data('id');
    				 if (Id != null)	
  					getProfileDetailById("workstatus",Id);
    				
            	});
           $('#addlicenceandcertification').on('show.bs.modal', function(e) {
  			 var Id = $(e.relatedTarget).data('id');
  					if (Id != null)
					getProfileDetailById("licenceandcertification",Id);
  				
          	});
           
           $('#addhonorandaward').on('show.bs.modal', function(e) {
    			 var Id = $(e.relatedTarget).data('id');
    			   if (Id != null)	
  					getProfileDetailById("honorandaward",Id);
            	});
           $('#addintrest').on('show.bs.modal', function(e) {
  			   var Id = $(e.relatedTarget).data('id');
  			       if (Id != null)
					getProfileDetailById("intrest",Id);
          	});
           $('#addproject').on('show.bs.modal', function(e) {
    			 var Id = $(e.relatedTarget).data('id');
    			    if (Id != null)	
  					getProfileDetailById("project",Id);
            	});
           $('#addpublication').on('show.bs.modal', function(e) {
  			 var Id = $(e.relatedTarget).data('id');
  			        if (Id != null)
					getProfileDetailById("publication",Id);
          	});
           $('#editprofile').on('show.bs.modal', function(e) {
    			 var Id = <%=pinfo.getId()%>;
    			        if (Id != null)
  					getProfileDetailById("profileInfo",Id);
            	}); 
           
           function getProfileDetailById(section,id)
           {debugger;
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
	                          debugger;
	                          var json =  JSON.parse(this.get('responseData'));
	                          
	                          if (section == "profileInfo")
	                          	{ 
	                        	  $("#title").val(json._title);
	                        	  $("#firstname").val(json._firstName);
	                        	  $("#fathername").val(json._fatherName);
	                        	  $("#grandfathername").val(convert(json._grandfatherName));
	                        	  $("#familyname").val(json._familyName);
	                        	  $("#email").val(json._email);
	                        	  $("#mobileno").val(json._primaryMobileNo);
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
	                        	  $("#nationaladdress").val(json._nationalAddress);
	                        	  $("#cityofresidence").val(json._cityOfResidence);
	                        	  $("#nationaladdress").val(json._nationalAddress);
	                        	  $("#street").val(json._street);
	                        	  $("#state").val(json._state);
	                        	  $("#profileId").val(json._Id);
	                          	}
	                          else 
	                        	  if (section == "educations")
	                          	{ 
	                        	  $("#university").val(json._educationCategory);
	                        	  $("#degree").val(json._degree);
	                        	  $("#fieldofstudy").val(json._fieldOfStudy);
	                        	  $("#startyear").val(convert(json._startYear));
	                        	  $("#endyear").val(convert(json._endYear));
	                        	  $("#grade").val(json._grade);
	                        	  $("#educationdescription").val(json._description);
	                        	  $("#educationId").val(json._Id);
	                          	}
	                          else 
	                        	  if (section== "workexperience")
		                          	{ 
	                        		  $("#workexperienceId").val(json._Id);
	                        		  $("#jobtitle").val(json._title);
	                        		  $("#company").val(json._company);
	                        		  $("#location").val(json._location);
	                        		  $("#workstartdate").val(convert(json._startDate));
	                        		  $("#workendate").val(convert(json._endDate));
	                        		  $("#workdescription").val(json._description);
	                        		  
		                          	}
	                        	  else 
		                        	  if (section== "volunteerexperience")
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
		                        	  else 
			                        	  if (section== "workstatus")
				                          	{ 
				                        	  $("#workstatusId").val(json._Id);
			                        		  $("#currenworkstatus").val(json._currentWorkStatus);
			                        		  $("#workexprience").val(json._workExperience);
				                          	}
			                        	  else 
				                        	  if (section== "licenceandcertification")
					                          	{ 
					                        	  $("#licenceandcertificationId").val(json._Id);
					                        	  $("#licencename").val(json._name);
					                        	  $("#issuingorganization").val(json._issuingOrganization);
					                        	  $("#issuedate").val(convert(json._issueDate));
					                        	  $("#expiredate").val(convert(json._expirationDate));
					                        	  $("#credentailurl").val(json._credentialURL);
					                        	  $("#credentailid").val(json._credentialID);
					                        	  $("#credentailnotexpire").val(json._notExpire);
					                          	}
				                        	  else 
					                        	  if (section== "honorandaward")
						                          	{ 
						                        	  $("#honorandawardId").val(json._Id);
						                        	  $("#honorissuer").val(json._honorissuer);
						                        	  $("#honortitle").val(json._honortitle);
						                        	  $("#honorissuedate").val(convert(json._honorissuedate));
						                        	  $("#issuedescription").val(json._issuedescription);
						                          	}
					                        	  else 
						                        	  if (section== "intrest")
							                          	{ 
						                        		  $("#intrestId").val(json._Id);
						                        		  $("#intrest").val(json._intrest);
							                          	}
						                        	  else 
							                        	  if (section== "project")
								                          	{
							                        		  $("#projectId").val(json._Id);
							                        		  $("#projectname").val(json._projectName);
							                        		  $("#projecturl").val(json._projectURL);
							                        		  $("#projectstartdate").val(convert(json._startDate));
							                        		  $("#projectenddate").val(convert(json._endDate));
							                        		  $("#projectdescription").val(json._description);
							                        		  $("#credentailnotexpire").val(json._currentlyOnProject);
								                          	}
							                        	  else 
								                        	  if (section== "publication")
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
        </script>
 </body>


</html>
 