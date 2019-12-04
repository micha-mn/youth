<%@ include file="/init.jsp"%>

<%
	String startDir = "left";
	String endDir = "right";
	if (themeDisplay.getLocale().getLanguage().equalsIgnoreCase("ar")) {
		startDir = "right";
		endDir = "left";
%>
<link href="/o/new-misk-theme/css/landing/CustomStyle_Ar.css"
	rel="stylesheet" />
<%
	} else {
		
%>
<link href="/o/new-misk-theme/css/landing/CustomStyle.css"
	rel="stylesheet" />
<%
	}
%>
<link  href="/o/new-misk-theme/css/font/font-awesome/font-awesome.min.css" rel="stylesheet"/>
<script src="/o/new-misk-theme/js/landing/custom.js"></script>


<style type="text/css">
</style>
<div class="aboutus-container">
	<div id="participant-section">
		<div class="container" id="intro-title">
			<h2 class="h3-title-first">
				<span><liferay-ui:message key='intro-title' /></span>
				<p class="underline"></p>
			</h2>

			<h3 class="h3-title-second">
				<span><liferay-ui:message key='intro-title-second' /></span>
			</h3>
		</div>

		<div class="header-bottom col-md-9">
			<div class="img-king"></div>
		</div>
	</div>

	<div class="about-us-text col-md-9">
		<div class="first-section-inner-div col-md col-xl-6 pb-5">
			<span class="first-text"><liferay-ui:message key='section-4' /></span>
			<div class="first-text font-weight-bold">
				<i class="fa fa-quote-<%=startDir %>"></i>
				<liferay-ui:message key='section-4-2' />
				<i class="fa fa-quote-<%= endDir %>"></i>
			</div>

			<div class="row green-dot-seperator-start div-flex-center">
				<span class="green-dot"> </span>
			</div>

			<div class="green-dot-seperator-div">&nbsp;</div>

			<div class="row green-dot-seperator div-flex-center">
				<span class="green-dot-end"> </span>
			</div>
			<span class="second-text"><liferay-ui:message key='section-1' /></span>
		</div>

	</div>


		<div class="col-md-12 goals-div">
			<div class="row white-dot-seperator-start div-flex-center">
				<span class="white-dot"> </span>
			</div>

			<div class="white-dot-seperator-div">&nbsp;</div>

			<div class="white-dot-seperator div-flex-center">
				<span class="white-dot-end"> </span>
			</div>

			<div class="col-md-6 col-lg-7 fifth-text-div">
				<span class="fifth-text-span"><liferay-ui:message
						key='section-3-title' /></span>
			</div>

			<div class="col-md-10 six-text-div">
				<span class="six-text-span"><liferay-ui:message
						key='section-3-title-second' /> </span>
			</div>

			<div class="col-md-6 col-lg-6 types-div three-icons-div">
				<div class="col-md-4 principle-unit-container">
					<span class="principle-unit-span"> </span>

					<div class="principle-icon-img-center">
						<span class="principle-unit-span"><img
							src="/o/new-misk-theme/aboutUs/documents/commitment.svg" /></span>
					</div>
					<span class="principle-unit-span"> </span>

					<div class="col-md-3 text-container">
						<a href="#"><span class="principale-icon-type-text"><liferay-ui:message
									key='section-3-button-1-title' /> </span></a>
					</div>
				</div>

				<div class="col-md-4 principle-unit-container">
					<span class="principle-unit-span"> </span>

					<div class="principle-icon-img-center">
						<span class="principle-unit-span"><img
							src="/o/new-misk-theme/aboutUs/documents/Group 15178.svg" /></span>
					</div>
					<span class="principle-unit-span"> </span>

					<div class="col-md-3 text-container">
						<a href="#"><span class="principale-icon-type-text"><liferay-ui:message
									key='section-3-button-2-title' /></span></a>
					</div>
				</div>

				<div class="col-md-4 principle-unit-container">
					<span class="principle-unit-span"> </span>

					<div class="principle-icon-img-center">
						<span class="principle-unit-span"><img
							src="/o/new-misk-theme/aboutUs/documents/Group 15188.svg" /></span>
					</div>
					<span class="principle-unit-span"> </span>

					<div class="col-md-3 text-container">
						<a href="#"><span class="principale-icon-type-text"><liferay-ui:message
									key='section-3-button-3-title' /></span></a>
					</div>
				</div>
			</div>

			<div class="col-md-6 col-lg-7 seven-text-div">
				<span class="seven-text-span"><liferay-ui:message
						key='section-3-buttom-title' /></span>
			</div>
		</div>

		<div class="col-md-12 final-div div-flex-center about-us-text">
			<div class="col-md-9">
			<div class="white-dot-seperator-start div-flex-center">
				<span class="white-dot"> </span>
			</div>

			<div class="white-dot-seperator-div">&nbsp;</div>

			<div class="white-dot-seperator div-flex-center">
				<span class="white-dot-end"> </span>
			</div>

			<div class="col-md-8 col-lg-8 eight-text-div">
				<span class="eight-text-span"><liferay-ui:message
						key='section-2' /></span>
			</div>
			<div class="third-text-div div-flex-center">
				<span class="third-text"><liferay-ui:message
						key='section-2-button-title' /></span>
			</div>

			<div class="col-md-12 col-lg-8 types-div div-flex-center">
				<div class="col-md-3 type-unit-container">
					<div class="col-md-12 type-unit type-1">
						<div class="icon-img-center">
							<img src="/o/new-misk-theme/aboutUs/documents/mortarboard.svg" />
						</div>
					</div>

					<div class="col-md-3 text-container">
						<a href="#"><span class="icon-type-text"><liferay-ui:message
									key='section-2-button-1-title' /></span></a>
					</div>
				</div>

				<div class="col-md-3 type-unit-container">
					<div class="col-md-12 type-unit type-1">
						<div class="icon-img-center">
							<img src="/o/new-misk-theme/aboutUs/documents/network.svg" />
						</div>
					</div>

					<div class="col-md-3 text-container">
						<a href="#"><span class="icon-type-text"><liferay-ui:message
									key='section-2-button-2-title' /></span></a>
					</div>
				</div>

				<div class="col-md-3 type-unit-container">
					<div class="col-md-12 type-unit type-1">
						<div class="icon-img-center">
							<img src="/o/new-misk-theme/aboutUs/documents/history.svg" />
						</div>
					</div>

					<div class="col-md-3 text-container">
						<a href="#"><span class="icon-type-text"><liferay-ui:message
									key='section-2-button-3-title' /></span></a>
					</div>
				</div>

				<div class="col-md-3 type-unit-container">
					<div class="col-md-12 type-unit type-1">
						<div class="icon-img-center">
							<img src="/o/new-misk-theme/aboutUs/documents/innovation.svg" />
						</div>
					</div>

					<div class="col-md-3 text-container">
						<a href="#"><span class="icon-type-text"><liferay-ui:message
									key='section-2-button-4-title' /></span></a>
					</div>
				</div>
			</div>

			<div class="col-md-8 forth-text-div">
				<span class="forth-text-span"><liferay-ui:message
						key='section-2-buttom-title' /></span>
			</div>
			</div>
		</div>

</div>