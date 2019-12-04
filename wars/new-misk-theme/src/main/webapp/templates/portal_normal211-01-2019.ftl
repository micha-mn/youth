<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key=" lang.dir" />" lang="${w3c_language_id}">

<head>

    <!-- <title>${the_title} - ${company_name}</title> -->
    <title>Youth HUB</title>
  
    <meta content="initial-scale=1.0, width=device-width" , charset="utf-8" name="viewport" />

    <@liferay_util["include"] page=top_head_include />
    <link href="/o/new-misk-theme/alerts/style-alert.css" rel="stylesheet" /> 
	<script src="/o/new-misk-theme/alerts/sweet-alert.min.js"></script>
      
</head>
<style>
/*Footer*/

.foot {
    background: #033553;
     padding: 60px 0 40px;
}

.foot h3 {
    color: #fff;
        font-size: 18px;
        font-weight: 600;
}

.foot p {
    color: #fff;
    font-size: 14px;
}

.foot a {
    color: #fff;
    font-size: 14px;
}

ul#list {
    padding: 0;
}

ul#list li {
    color: #fff;
    list-style: none;
    padding: 15px 0 11px 0;
}

p#misk {
    width: 90%;
}


input#email {
    margin: 16px 0 25px 0;
    padding: 8px 42px 8px 18px;
    border-radius: 5px;
    font-size: 14px;
    font-weight: 400;
}

#sub {
    border: 3px solid;
    background: #033553;
    padding: 6px 25px;
    border-color: #88a0ae;
    color: #fff;
    max-width: 46%;
    border-radius: 5px;
}
.foot form input {
    float: left;
    width: 100%;
    max-width: 70%;
}
img#foot-logo {
    padding: 0px 0 15px 0;
}

.last {
       padding: 45px 0px 0px 0px;
}


.chckbxs {
    display: block;
    position: relative;
    padding-left: 35px;
    margin-bottom: 00;
    cursor: pointer;
    font-size: 22px;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    font-size: 14px;
    color: #fff;

}

form.singup span .chckbxs input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
  height: 0;
  width: 0;
}


form.singup span .checkmark {
    position: absolute;
    top: -1px;
    left: 0;
    height: 22px;
    width: 22px;
    background-color: transparent;
    border: 2px solid;
        margin: 0;
}

.chckbxs:hover input ~ .checkmark {
  background-color: #ccc;
}

.chckbxs input:checked ~ .checkmark {
    background-color: #033553;
    border-color: transparent;
}


.checkmark:after {
  content: "";
  position: absolute;
  display: none;
}


.chckbxs input:checked ~ .checkmark:after {
  display: block;
}

.chckbxs .checkmark:after {
    left: 7px;
    top: 3px;
    width: 5px;
    height: 10px;
    border: solid #7db62c;
    border-width: 0 3px 3px 0;
  -webkit-transform: rotate(45deg);
  -ms-transform: rotate(45deg);
  transform: rotate(45deg);
}
.footer-top {
    background: #7db62c;
    padding: 60px 0;
    margin: 115px 0 0;
}

form.singup {
    float: left;
    width: 100%;
}

form.singup span {
    float: left;
    width: 100%;
    margin-bottom: 25px;
}

form.singup span input,form.singup span select {
    width: 100%;
    float: left;
    padding: 8px 14px;
    color: #fff;
    background: transparent;
    border: 0;
    border-bottom: 1px solid #fff;
}

form.singup span input::placeholder {
    color: #fff;
}

form.singup span.halfwd {
    max-width: 47%;
}

form.singup .margnrg {
    margin-right: 37px;
}
.textcnter {
    display: flex;
    flex-direction: column;
    justify-content: center;
    color: #fff;
}
form.singup .btnn {
    border: 3px solid;
    background: transparent;
    padding: 6px 40px;
    border-color: #fff;
    color: #fff;
    border-radius: 5px;
    margin-right: 24px;
}

form.singup .btnn:hover {
    background: #ffffff;
    color: #7db62c;
}

form.singup span input:focus, form.singup span select:focus {
    outline-color: #fff;
}

section.test-main {
    text-align: center;
    padding: 100px 0;
    overflow: hidden;
}
.test-main .owl-carousel .owl-stage-outer{
     overflow: initial;
}
section.test-main h2 {
    margin-bottom: 50px;
}

section.test-main .testt {
      padding: 85px 120px;
    background-color: rgb(255, 255, 255);
    box-shadow: 0px 38px 77px 0px rgba(0, 45, 79, 0.13);
    color: #929292;
    margin: 8px 45px;
}

.imgttes {
    display: flex;
    align-items: center;
    justify-content: center;
    text-align: left;
}

.imgttes h4 {
    font-size: 16px;
    color: #19a4ce;
    margin-left: 18px;
}
.owl-carousel .owl-item .imgttes img {
    width: auto;
}
.imgttes span {font-size: 12px;color: #929292;display: table;}
.owl-nav {
    display: none;
}

.owl-dots span {
    background: #83cbe1;
    width: 16px;
    height: 16px;
    float: left;
    border-radius: 50px;
    margin: 0 4px;
}

.owl-dots {
    position: absolute;
    bottom: -70px;
    left: 0;
    right: 0;
}

.owl-dots .active span {
    width: 20px;
    height: 20px;
    background: #0ca2cd;
}
/*Footer*/

</style>
<body class="${css_class}">

    <@liferay_ui["quick-access"] contentId="#main-content" />

    <@liferay_util["include"] page=body_top_include />

    <@liferay.control_menu />

    <div class="container-fluid" id="wrapper">
        <header id="header">
            <div class="container-menu">
               
                <div class="navigation start-header start-style">
                    <div class="row">
                        <div class="col-md-2 text-center">
                            <div id="logo" class="pull-right">
                                <a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments=" ${site_name}" key="go-to-x" />">
                                <!-- <img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" /> -->
                                <img id="logoImg" alt="${logo_description}" src="${site_logo}" />
                                </a>

                                <!-- <#if show_site_name>
                    <span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
                        ${site_name}
                    </span>
                </#if> -->
                            </div>
                        </div>
                        <div class="col-md-7 nav-resp">
                            <#if has_navigation && is_setup_complete>
                                <#include "${full_templates_path}/navigation.ftl" />
                            </#if>
                        </div>
                                              
                        <#if !is_signed_in>
                            <div class="col-md-3 nav-resp">
                                <div id="register-button">
                                    <a href="/web/guest/what-we-offer?p_p_id=com_liferay_login_web_portlet_LoginPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Fcreate_account" class="join-button">REGISTER</a>
                                             
	                                <a class="join-button-signin" data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" style="">
	                                    <span class="topHeadLinks">
	                                        <!-- <@liferay.language key="LoginMessage" /> -->
	                                        Login
	                                    </span>
	                                    <i class="fa fa-user" aria-hidden="true"></i>
	                                </a>
                                
                                </div>
                            </div>
                        </#if>
                    </div>
                </div>
            </div>
            <!-- 	<#if !is_signed_in>

                    <a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>

            </#if> -->
        </header>

        <div id="content">
            <h1 class="hide-accessible">${the_title}</h1>

            <#if selectable>
                <@liferay_util["include"] page=content_include />
                <#else>
                    ${portletDisplay.recycle()}

                    ${portletDisplay.setTitle(the_title)}

                    <@liferay_theme["wrap-portlet"] page="portlet.ftl">
                        <@liferay_util["include"] page=content_include />
                        </@>
            </#if>
        </div>
<footer>
		<div class="foot" style=" background: #033553;
						 		  padding: 60px 0 40px;">
			<div class="container">
				<div class="row">
					<div class="col-xl-4 col-md-4">
						<img src="/o/new-misk-theme/landingPage/images/logo.png" id="foot-logo">
						<p id="misk">Misk Global Forum brings young leaders, creators and thinkers together with established global innovators to explore, experience and experiment with ways to meet the challenge of change.</p>
					</div>

					<div class="col-xl-2 col-md-3">
						<h3>Quick Links</h3>
						<ul id="list">
							<li><a href="#">Events</a></li>
							<li><a href="#">Discover</a></li>
							<li><a href="#">Training</a></li>
						</ul>
					</div>


					<div class="col-xl-2 col-md-2">
						<h3>About</h3>
						<ul id="list">
							<li><a href="#">News</a></li>
							<li><a href="#">Who we Are</a></li>
							<li><a href="#">What we Offer</a></li>
							<li><a href="#">Contact Us</a></li>
						</ul>
					</div>

					<div class="col-xl-4 col-md-3">
						<h3>Subscribe to Our Newsletter</h3>
							<form>
								<input type="text" name="Enter" placeholder="Enter Email Address" id="email">
								<input  id="sub" type="submit" value="Subscribe">
							</form>						
					</div>
				</div>

				<div class="last">	
					<div class="row">
						<div class="col-xl-6 col-md-6">
							<p>Copyright © 2019 Misk Global Forum All Rights Reserved.</p>
						</div>	

						<div class="col-xl-3 col-md-2">
							<a href="#">PRIVACY</a>
						</div>
						<div class="col-xl-3 col-md-4">	
							<a href="#">TERMS & CONDITIONS</a>
						</div>				
					</div>
				</div>	
			</div>
		</div>
		
	</footer>
    </div>

    <@liferay_util["include"] page=body_bottom_include />

    <@liferay_util["include"] page=bottom_include />

</body>

</html>