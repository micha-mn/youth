<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.journal.model.JournalArticle"%>
<%@page import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.xml.Document" %>
<%@ page import="com.liferay.portal.kernel.xml.SAXReaderUtil" %>
<%@ page import="com.liferay.portal.kernel.xml.Node" %>
<%@ page import="com.liferay.document.library.kernel.model.DLFileEntry" %>
<%@ page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil" %>
<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.jdbc.DataAccess"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<%
	ThemeDisplay themeDisplayNews = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
%>
		<div class="container">
			<div class="row pt-5">
				<div class="col-xl-12 col-12 col-md-12 mb-3">
					<h2><liferay-ui:message key="NewsUpdates" /></h2>
				</div>
			</div>
			<div class="row">
				<%
				JournalArticle newsJournalArticle = null;
				 String articleId = "0";
				 Connection conDet = DataAccess.getConnection();;
				 Statement stDet = conDet.createStatement();
				 ResultSet rsDet = stDet.executeQuery("select articleId from JournalArticle  where DDMStructureKey = " +
				 	" (select structureKey from DDMStructure where lower(name) like '%newsstructure%') order by id_ desc  limit 3");
				 while (rsDet.next()) 
				 {
					articleId = rsDet.getString("articleId");
					System.out.println("articleId ========== " + articleId);
	 				newsJournalArticle = JournalArticleLocalServiceUtil.getLatestArticle(themeDisplayNews.getScopeGroupId(), articleId);
	 				String newsContent  = newsJournalArticle.getContentByLocale(themeDisplayNews.getLanguageId());
	 	 			Document newsDocument = SAXReaderUtil.read(newsContent);
	 				Node newsNode = newsDocument.selectSingleNode("/root/dynamic-element[@name='Image']/dynamic-content");
	 				String newsImageJsonData = newsNode.getText();
	 			    JSONObject newsImagejsonObject = JSONFactoryUtil.createJSONObject(newsImageJsonData) ;
	 			    DLFileEntry imageFolderDataNews = DLFileEntryLocalServiceUtil.getDLFileEntry( newsImagejsonObject.getLong("fileEntryId"));
	 				Node newsDateNode = newsDocument.selectSingleNode("/root/dynamic-element[@name='Date']/dynamic-content");
	 				Node newsDescNode = newsDocument.selectSingleNode("/root/dynamic-element[@name='NewsDescription']/dynamic-content");
	 				Node newsPageNode = newsDocument.selectSingleNode("/root/dynamic-element[@name='LinkToPage']/dynamic-content");
	 			    String newsImage = "/documents/"+imageFolderDataNews.getRepositoryId()+"/"+imageFolderDataNews.getFolderId()+"/"+imageFolderDataNews.getFileName();
 			       	String[] newsPageNodeArr = newsPageNode.getText().split("@");
	 			    boolean isPrivate = newsPageNodeArr[1].equalsIgnoreCase("private")? true:false;
	 			    String urlNews =  LayoutLocalServiceUtil.getLayout(Long.valueOf(newsPageNodeArr[2]), isPrivate, Long.valueOf(newsPageNodeArr[0])).getFriendlyURL();
	 			%>
	 				
	 			<div class="col-xl-4 col-12 col-md-6 col-sm-12 col-xs-12">
					<a href=<%=urlNews %>>
						<div class="news-boxes">
							<img src=<%=newsImage%>>
							<p><%= newsDateNode.getText() %></p>
							<h4><%= newsDescNode.getText() %></h4>
<%-- 							<i class="fa <liferay-ui:message key="EventArrow" />"></i> --%>
						</div>
					</a>
				</div>	
	 				
	 		<%}
			
	    		conDet.close();
				stDet.close();
			%> 
			</div>
		</div>
