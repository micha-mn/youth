<%@ include file="/init.jsp"%>
<style>
div#myVideo {
	display: flex;
	flex-wrap: wrap;
	box-shadow: 0px 6px 25px 0px rgba(0, 0, 0, 0.07);
}
.video-thumb{
    padding: 15px;
}
.video-title {
    text-align: center;
    color: #00aa60;
    font-size: 18px;
}
</style>

<link href="/o/new-misk-theme/css/landing/CustomStyle.css" rel="stylesheet" />
<script src="/o/new-misk-theme/js/landing/custom.js"></script>

<!-- <div id="myVideo">&nbsp;</div> -->
<div class="container-fluid news-container">
	<div id="global-header-section">
		<div id="intro-title" class="container">
			<h1>
				<span><liferay-ui:message key='YouthHubVideosLibrary' /></span>
			</h1>
			<br>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<c:forEach var="i" begin="0" end="${videoUrls.size() - 1}">
				<div class="col-xl-6 col-12 col-md-6">
					<div class="news-boxes">
						<div class="video-container">
							<video width="100%" controls="">
								<source src="${videoUrls.get(i)}" type="video/mp4">
							</video>
						</div>
						<div class="video-title">${videosTitle.get(i)}</div>
						<p>${videosDate.get(i)}<p>
						<h4>${videosDescription.get(i)}</h4>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>