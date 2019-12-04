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
                        <div class="col-md-7">
                            <#if has_navigation && is_setup_complete>
                                <#include "${full_templates_path}/navigation.ftl" />
                            </#if>
                        </div>
                                              
                        <#if !is_signed_in>
                            <div class="col-md-3">
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

        <!-- <footer id="footer" role="contentinfo">
            <p class="powered-by">
                <@liferay.language key="powered-by" /> <a href="http://www.liferay.com" rel="external">Liferay new theme</a>
            </p>
        </footer> -->
        <section id="footer-section" class="py-5" style="background-repeat: no-repeat;
														color: white;
														padding-bottom: 2%!important;
														width: 100%;
														height: 100%;
														padding-right: 8%;
   														padding-left: 8%;
														background-color: #0ca2cd;">
            <footer>
                <div class="row">
                    <div class="col-md-5">
                    <!--updated on 20191016 removed the width of the image -->
                        <img src="${themeDisplay.getPathThemeRoot()}/images/landing/Logo.png" class="img-fluid"  style="margin-left: 15px;" />
                    </div>
                    <div class="col-md-2" style="padding-top: 4%;font-family: Montserrat-Light;
    														font-size: 15px;font-weight: bold;">Quick Links</div>
                    <div class="col-md-2" style="padding-top: 4%;font-family: Montserrat-Light;
    														font-size: 15px;font-weight: bold;">About</div>
                    <div class="col-md-2" style="padding-top: 4%; font-family: Montserrat-Regular;
                                                 font-size: 18px;">Subscribe to our Newsletter</div>
                </div>
                <div class="row">
                    <div class="col-md-5">
                        <div class="row">
                            <div class="col-md-12 footer-desc">
                                Misk Global Forum brings young leaders,  creators and thinkers together with established global innovators to explore, experience and experiment with ways to meet the challenge of change.

                                <div class="rounded-social-buttons">
                                    <a class="circle-button facebook" href="#"></a>
                                    <a class="circle-button twitter" href="#"></a>
                                    <a class="circle-button instagram" href="#"></a>
                                    <a class="circle-button linkedin" href="#"></a>
                                </div>

                            </div>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <div class="row">
                            <ul id="footerlink">
                                <li>
                                    <a href="#">Events</a>
                                </li>
                                <li>
                                    <a href="#"></a>
                                </li>
                                <li>
                                    <a href="#">Discover</a>
                                </li>
                                <li>
                                    <a href="#"></a>
                                </li>
                                <li>
                                    <a href="#">Trainings</a>
                                </li>

                            </ul>
                        </div>

                    </div>
                    <div class="col-md-2">
                        <div class="row">
                            <ul id="footerlink">
                                <li>
                                    <a href="#">News</a>
                                </li>
                                <li>
                                    <a href="#"></a>
                                </li>
                                <li>
                                    <a href="#">Who we Are</a>
                                </li>
                                <li>
                                    <a href="#"></a>
                                </li>
                                <li>
                                    <a href="#">What we Offer</a>
                                </li>
                                <li>
                                    <a href="#"></a>
                                </li>
                                <li>
                                    <a href="#">Contact us </a>
                                </li>
                            </ul>
                        </div>

                    </div>
                    <div class="col-md-3">
                        <div class="row">
                            <div class="col-md-12">
                                <p style="font-family: Montserrat;
										  font-size: 1.1rem;
										  font-weight: 500;
										  font-style: normal;
										  font-stretch: normal;
										  line-height: 1.48;
										  letter-spacing: normal;
										  text-align: left;
										  padding-top: 3%;
										  "></p>
                                <p>
                                    <input type="email" placeholder="Enter email address" class="form-control footer-subscribe" disabled />

                                </p>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="row text-center">
                    <div class="col-md-7 footer-text">
                        Copyright 2019 Misk Global Forum. All rights reserved.
                    </div>
                    <div class="col-md-1 footer-text">
                        PRIVACY
                    </div>
                    <div class="col-md-4 footer-text">
                        TERMS &amp; CONDITIONS
                    </div>
                </div>
            </footer>
        </section>
    </div>

    <@liferay_util["include"] page=body_bottom_include />

    <@liferay_util["include"] page=bottom_include />

</body>

</html>