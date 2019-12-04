<%@ include file="/init.jsp"%>
<style>
	div#myVideo {display: flex; flex-wrap: wrap; box-shadow: 0px 6px 25px 0px rgba(0, 0, 0, 0.07);}
	.video-thumb{padding: 15px;}
	.video-title {text-align: center; color: #00aa60; font-size: 18px;}
</style>
<link href="/o/new-misk-theme/css/landing/CustomStyle.css" rel="stylesheet" />
<script src="/o/new-misk-theme/js/landing/custom.js"></script>

<portlet:renderURL var="renderAction">
    <portlet:param name="mvcPath" value="/newsDetails.jsp"></portlet:param>
    <portlet:param name="newsId" value="0"></portlet:param>
</portlet:renderURL>

<div class="container-fluid news-container">
	<div id="global-header-section">
		<div id="intro-title" class="container">
			<h1>
				<span><liferay-ui:message key='News' /></span>
			</h1>
			<br>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<c:forEach var="i" begin="0" end="${newsTitle.size() - 1}">
				<div class="col-xl-4 col-12 col-md-6">
					<div class="news-boxes">
						<a href="${renderAction}&<portlet:namespace />uuId=${newsUUID.get(i)}">
							<div class="news-boxes">
								<img src="${newsUrls.get(i)}"/>
								<p>${newsDate.get(i)}</p>
								<h4>${newsTitle.get(i)}</h4>
	<%-- 							<p>${newsDescription.get(i)}</p> --%>
	<%-- 							<p>${newsLocation.get(i)}</p> --%>
							</div>
						</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>