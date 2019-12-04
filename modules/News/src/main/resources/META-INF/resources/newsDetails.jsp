<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ include file="/init.jsp"%>
<%@page import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.Folder"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="java.text.SimpleDateFormat"%>


<style>
	div#myVideo {display: flex; flex-wrap: wrap; box-shadow: 0px 6px 25px 0px rgba(0, 0, 0, 0.07);}
	.video-thumb{padding: 15px;}
	.video-title {text-align: center; color: #00aa60; font-size: 18px;}
</style>
<link href="/o/new-misk-theme/css/landing/CustomStyle.css" rel="stylesheet" />
<script src="/o/new-misk-theme/js/landing/custom.js"></script>

<%
	ThemeDisplay newsDetDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	Folder folderDet = DLAppServiceUtil.getFolder(newsDetDisplay.getSiteGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "News");
	String uuId = renderRequest.getParameter("uuId");
	String newsLocation = "";
	String newsDescription = "";
	String newsTitle = "";

	FileEntry fnd = DLAppServiceUtil.getFileEntryByUuidAndGroupId(uuId, newsDetDisplay.getSiteGroupId());
	if(fnd != null){
		String imgURL = "/documents/" + fnd.getRepositoryId() + "/" + fnd.getFolderId() + "/"
				+ fnd.getTitle() + "/" + fnd.getUuid() + "?t=" + fnd.getModifiedDate();
		
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MMMM yyyy");
		String newsDateString = "";
		newsDateString = myFormat.format(fnd.getExpandoBridge().getAttribute("Video Display Date"));
		
		HashMap<String, String> location = (HashMap<String, String>)fnd.getExpandoBridge().getAttribute("Location");
		for (Map.Entry loc : location.entrySet()) {
			if(loc.getKey().toString().equals(newsDetDisplay.getLanguageId()))
				newsLocation = (loc.getValue().toString());
        }
		HashMap<String, String> description = (HashMap<String, String>)fnd.getExpandoBridge().getAttribute("Description");
		for (Map.Entry desc : description.entrySet()) {
			if(desc.getKey().toString().equals(newsDetDisplay.getLanguageId()))
				newsDescription = (desc.getValue().toString());
		}
		HashMap<String, String> title = (HashMap<String, String>)fnd.getExpandoBridge().getAttribute("Title");
		for (Map.Entry ttl : title.entrySet()) {
			if(ttl.getKey().toString().equals(newsDetDisplay.getLanguageId()))
				newsTitle= (ttl.getValue().toString());
		}
%>
		<div class="container-fluid news-container">
			<div id="global-header-section">
				<div id="intro-title" class="container">
					<h1>
						<span><%=newsTitle%></span>
					</h1>
					<br>
				</div>
			</div>
			<div id="myVideo" class="container pt-3 pb-3">
				<div class="row">
					<img src="<%=imgURL%>">
					<h3><%=newsLocation%></h3>
					<h3><%=newsDateString%></h3>
					<h4><%=newsDescription%></h4>
				</div>
			</div>
		</div>
<% } %>