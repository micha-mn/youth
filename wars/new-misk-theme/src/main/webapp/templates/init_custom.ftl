<#assign langDir = languageUtil.get(locale, "lang.dir") />

<#if langDir == "rtl">
<#assign ulpadding = "3%"
		 ulDir = "ltr"
		 langStylecss= "langStyleAR"
		 logostyle="image-index-logo-ar"
		 footerStyle="img-gs-footer-ar"
		 positionLogo = "-30%"
 />
<#else>
<#assign ulpadding = "-3%"
		 ulDir = "rtl"
		 langStylecss= "langStyleEN"
		 logostyle="image-index-logo-en"
		 footerStyle="img-gs-footer-en"
		 positionLogo = "80%"
 />
</#if>