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
	<script src="/o/new-misk-theme/js/landing/custom.js"></script> 
      
</head>
<style>
/*Footer*/



</style>
<body class="${css_class}" >

    <@liferay_ui["quick-access"] contentId="#main-content" />

    <@liferay_util["include"] page=body_top_include />

    <@liferay.control_menu />

    <div class="container-fluid" id="wrapper">
    
    
    
    <nav class="navbar navbar-expand-sm navbar-dark fixed-top">
      <div class="container">
       
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${site_default_url}">
          		<div class="logo-black" id="logoImgg" alt="${logo_description}" ></div>
          </a>
        
        <div id="navbar" class="navbar-collapse collapse navbar-nav">
          <#if has_navigation && is_setup_complete>
            <#include "${full_templates_path}/navigation.ftl" />
          </#if>
          <ul class="nav navbar-nav navbar-right">
          <#if !is_signed_in>
            <li><a href="/web/guest/home?p_p_id=com_liferay_login_web_portlet_LoginPortlet&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view&saveLastPath=false&_com_liferay_login_web_portlet_LoginPortlet_mvcRenderCommandName=%2Flogin%2Fcreate_account" class="join-button"><@liferay.language key="Register" /></a></li>
            <li>
				<a class="join-button-signin" data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" style="">
	                <span class="topHeadLinks">
	                   <@liferay.language key="LoginMessage" />  
	                </span>
	                <i class="fa fa-user" aria-hidden="true"></i>
	            </a>
			</li>
          </#if>
            <li class=""><span class="btn btn-lang"><a id="lang_selector" lang="en"><span style="color:white"><@liferay.language key="LanguageChange" /></span></a></span></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    
    
    
    
    
    
    
    
        

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
		<div class="foot" style="background: #033553;background-image: linear-gradient(#033553, #00121d);padding:50px 0 20px;">
			<div class="container">
				<div class="row">
					<div class="col-xl-4 col-md-4">
						<div class="logo-black" id="foot-logo"  ></div>
						<p id="misk"><@liferay.language key="MiskGlobalForumText" /></p>
					</div>

					<div class="col-xl-2 col-md-3">
						<h3><@liferay.language key="QuickLinks" /></h3>
						<ul id="list">
							<li><a href="/web/guest/home?p_p_id=landing_page_LandingPagePortlet_INSTANCE_PLNE3WnhuFLb&amp;p_p_lifecycle=0&amp;p_p_state=normal&amp;p_p_mode=view&amp;_landing_page_LandingPagePortlet_INSTANCE_PLNE3WnhuFLb_mvcPath=%2FlistEvent.jsp"><@liferay.language key="Events" /></a></li>
							<li><a href="/web/guest/news"><@liferay.language key="News" /></a></li>
						</ul>
					</div>


					<div class="col-xl-2 col-md-2">
						<h3><@liferay.language key="About" /></h3>
						<ul id="list">
							<li><a href="/web/guest/aboutus"><@liferay.language key="WhoWeAre" /></a></li>
							<li><a href="/web/guest/contactus"><@liferay.language key="ContactUs" /></a></li> 
						</ul>
					</div>

					<div class="col-xl-4 col-md-3">
						<h3><@liferay.language key="SubscribeOurNewsletter" /></h3>
							<form>
							<div class="row">
							<div class="col-md-12">
							<input type="email" name="Enter" placeholder="<@liferay.language key="EmailAddress" />" id="email" disabled>
							</div>
							</div>
								<div class="row">
							<div class="col-md-12 pt-2 pt-sm-4">
								<input  id="sub" type="submit" value="<@liferay.language key="Subscribe" />" disabled>
								</div>
							</div>
							</form>						
					</div>
				</div>

				<div class="last">	
					<div class="row">
                        <div class="col-xl-8 col-md-8 copyright" >
                            <p><@liferay.language key="CopyrightMiskGlobal" /></p> 
						</div>

						<div class="col-xl-3 col-md-4">	
							<a style="font-size:14px" data-toggle="modal" data-target="#privacymodal" href="#privacymodal"><@liferay.language key="TERMS&CONDITIONS" /></a>
						</div>				
					</div>
				</div>	
			</div>
		</div>
		
	</footer>
    </div>

    <@liferay_util["include"] page=body_bottom_include />

    <@liferay_util["include"] page=bottom_include />
<div class="modal fade" id="privacymodal" tabindex="-1" role="dialog" aria-labelledby="addlanguageLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header text-white bg-info">
                    <h5 class="modal-title" id="addlanguageLabel">
                        <label>Privacy</label>
                    </h5>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
               <div class="modal-body" style=" max-height: calc(100vh - 210px); overflow-y: auto;">
    <p><b>Ownership of Site; Agreement to Terms of Use</b></p>
    <p>
       
            These Terms and Conditions of Use (the "Terms of Use") apply to the Misk Youth Hub web site located at
            <a href="http://www.misk.org.sa/youthhub">www.misk.org.sa/youthhub</a>. The Site is the property of Misk Foundation. BY USING THE SITE, YOU AGREE TO THESE TERMS OF USE; IF YOU DO NOT AGREE, DO NOT USE THE SITE.
    </p>
    <p>Misk Foundation reserves the right, at its sole discretion, to change, modify, add or remove portions of these Terms of Use, at any time. It is your responsibility to check these Terms of Use periodically for changes. Your continued use of the Site following the posting of changes will mean that you accept and agree to the changes. As long as you comply with these Terms of Use, Misk Foundation grants you a personal, non-exclusive, non-transferable, limited privilege to enter and use the Site.</span></p>
    <p>Accounts, Passwords and Security</p>
    <p>>Certain features or services offered on or through the Site may require you to open an account (including setting up a Misk ID and password). You are entirely responsible for maintaining the confidentiality of the information you hold for your account, including your password, and for any and all activity that occurs under your account as a result of your failing to keep this information secure and confidential.</p>
    <p>Privacy</p>
    <p>>Misk&apos;s Privacy Policy applies to use of this Site, and its terms are made a part of these Terms of Use by this reference.</p>
    <p>Disclaimers</p>
    <p>>MISK DOES NOT PROMISE THAT THE SITE OR ANY CONTENT, SERVICE OR FEATURE OF THE SITE WILL BE ERROR-FREE OR UNINTERRUPTED, OR THAT ANY DEFECTS WILL BE CORRECTED, OR THAT YOUR USE OF THE SITE WILL PROVIDE SPECIFIC RESULTS. THE SITE AND ITS CONTENT ARE DELIVERED ON AN "AS-IS" AND "AS-AVAILABLE" BASIS. ALL INFORMATION PROVIDED ON THE SITE IS SUBJECT TO CHANGE WITHOUT NOTICE. MISK CANNOT ENSURE THAT ANY FILES OR OTHER DATA YOU DOWNLOAD FROM THE SITE WILL BE FREE OF VIRUSES OR CONTAMINATION OR DESTRUCTIVE FEATURES. MISK DISCLAIMS ALL WARRANTIES, EXPRESS OR IMPLIED, INCLUDING ANY WARRANTIES OF ACCURACY, NON-INFRINGEMENT, MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. MISK DISCLAIMS ANY AND ALL LIABILITY FOR THE ACTS, OMISSIONS AND CONDUCT OF ANY THIRD PARTIES IN CONNECTION WITH OR RELATED TO YOUR USE OF THE SITE AND/OR ANY MISK SERVICES. YOU ASSUME TOTAL RESPONSIBILITY FOR YOUR USE OF THE SITE AND ANY LINKED SITES. YOUR SOLE REMEDY AGAINST MISK FOR DISSATISFACTION WITH THE SITE OR ANY CONTENT IS TO STOP USING THE SITE OR ANY SUCH CONTENT. THIS LIMITATION OF RELIEF IS A PART OF THE BARGAIN BETWEEN THE PARTIES.</p>
    <p>>The above disclaimer applies to any damages, liability or injuries caused by any failure of performance, error, omission, interruption, deletion, defect, delay in operation or transmission, computer virus, communication line failure, theft or destruction of or unauthorized access to, alteration of, or use, whether for breach of contract, tort, negligence or any other cause of action.</p>
    <p>>Misk reserves the right to do any of the following, at any time, without notice: (1) to modify, suspend or terminate operation of or access to the Site, or any portion of the Site, for any reason; (2) to modify or change the Site, or any portion of the Site, and any applicable policies or terms; and (3) to interrupt the operation of the Site, or any portion of the Site, as necessary to perform routine or non-routine maintenance, error correction, or other changes.</p>
    <p>Limitation of Liability</p>
    <p>>Except where prohibited by law, in no event will Misk be liable to you for any indirect, consequential, exemplary, incidental or punitive damages, including lost profits, even if Misk has been advised of the possibility of such damages.</span></p>
    <p>Violation of These Terms of Use</p>
    <p>>Misk may disclose any information we have about you (including your identity) if we determine that such disclosure is necessary in connection with any investigation or complaint regarding your use of the Site, or to identify, contact or bring legal action against someone who maybe causing injury to or interference with (either intentionally or unintentionally) Misk&apos;s rights or property, or the rights or property of visitors to or users of the Site, including Misk&apos;s users. Misk reserves the right at all times to disclose any information that Misk deems necessary to comply with any applicable law, regulation, legal process or governmental request.</p>
    <p>Governing Law; Dispute Resolution</p>
    <p>>You agree that all matters relating to your access to or use of the Site, including all disputes, will be governed by the laws of Kingdom of Saudi Arabia.</p>
    <p>Feedback and Information</p>	
    <p>>Any feedback you provide at this site shall be deemed to be non-confidential. Misk shall be free to use such information on an unrestricted basis.</p>

</div>

            </div>
        </div>
    </div>
</body>

</html>