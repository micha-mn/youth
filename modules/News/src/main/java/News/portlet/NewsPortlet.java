package News.portlet;

import News.constants.NewsPortletKeys;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;

/**
 * @author sha
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=News",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + NewsPortletKeys.NEWS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NewsPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<FileEntry> fileEntries;
		List<String> newsTitle = new ArrayList<String>(),
				     newsDescription = new ArrayList<String>(),
		    		 newsUrls = new ArrayList<String>(),
		    		 newsLocation = new ArrayList<String>(),
		    		 newsUUID = new ArrayList<String>(),
				     newsDate = new ArrayList<String>();
		try {
			Folder folder = DLAppServiceUtil.getFolder(themeDisplay.getSiteGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "News");
			fileEntries = DLAppServiceUtil.getFileEntries(themeDisplay.getSiteGroupId(), folder.getFolderId());
			for (int i= 0; i< fileEntries.size(); i++)
			{
				newsUrls.add("/documents/"
						+ fileEntries.get(i).getRepositoryId() + "/"
						+ fileEntries.get(i).getFolderId() + "/"
						+ fileEntries.get(i).getTitle() + "/"
						+ fileEntries.get(i).getUuid() + "?t="
						+ fileEntries.get(i).getModifiedDate());
//				newsDescription.add(fileEntries.get(i).getDescription());
//				newsTitle.add(fileEntries.get(i).getTitle());
				
				SimpleDateFormat myFormat = new SimpleDateFormat("dd MMMM yyyy");
				String newsDateString = "";
				String newsTitleStr = "";
				String newsDescriptionStr = "";
				String newsLocationStr = "";
				newsDateString = myFormat.format(fileEntries.get(i).getExpandoBridge().getAttribute("Video Display Date"));
				newsDate.add(newsDateString);
				newsUUID.add(fileEntries.get(i).getUuid());
				
				HashMap<String, String> location = (HashMap<String, String>)fileEntries.get(i).getExpandoBridge().getAttribute("Location");
				for (Map.Entry loc : location.entrySet()) {
					if(loc.getKey().toString().equals(themeDisplay.getLanguageId()))
						newsLocationStr = loc.getValue().toString();
		        }
				newsLocation.add(newsLocationStr);
				
				HashMap<String, String> description = (HashMap<String, String>)fileEntries.get(i).getExpandoBridge().getAttribute("Description");
				for (Map.Entry desc : description.entrySet()) {
					if(desc.getKey().toString().equals(themeDisplay.getLanguageId()))
						newsDescriptionStr = desc.getValue().toString();
				}
				newsDescription.add(newsDescriptionStr);
				
				HashMap<String, String> title = (HashMap<String, String>)fileEntries.get(i).getExpandoBridge().getAttribute("Title");
				for (Map.Entry ttl : title.entrySet()) {
					if(ttl.getKey().toString().equals(themeDisplay.getLanguageId()))
						newsTitleStr=ttl.getValue().toString();
				}
				newsTitle.add(newsTitleStr);
			
			}
			
			renderRequest.setAttribute("newsUUID", newsUUID);
			renderRequest.setAttribute("newsUrls", newsUrls);
			renderRequest.setAttribute("newsTitle", newsTitle);
			renderRequest.setAttribute("newsDescription",newsDescription);
			renderRequest.setAttribute("newsLocation", newsLocation);
			renderRequest.setAttribute("newsDate", newsDate);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}
}