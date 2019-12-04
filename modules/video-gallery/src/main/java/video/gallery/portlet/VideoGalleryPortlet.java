package video.gallery.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import video.gallery.constants.VideoGalleryPortletKeys;

/**
 * @author pma
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=VideoGallery",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + VideoGalleryPortletKeys.VIDEOGALLERY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class VideoGalleryPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<FileEntry> fileEntries;
		List<String> videoUrls = new ArrayList<String>(),
				     videosDescription = new ArrayList<String>(),
				     videosTitle = new ArrayList<String>(),
				     videosDate = new ArrayList<String>();
		try {
			Folder folder = DLAppServiceUtil.getFolder(themeDisplay.getSiteGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "Videos");
			fileEntries = DLAppServiceUtil.getFileEntries(themeDisplay.getSiteGroupId(), folder.getFolderId());
			for (int i= 0; i< fileEntries.size(); i++)
			{
				videoUrls.add("/documents/"
							+ fileEntries.get(i).getRepositoryId() + "/"
							+ fileEntries.get(i).getFolderId() + "/"
							+ fileEntries.get(i).getTitle() + "/"
							+ fileEntries.get(i).getUuid() + "?t="
							+ fileEntries.get(i).getModifiedDate());
				videosDescription.add(fileEntries.get(i).getDescription());
				videosTitle.add(fileEntries.get(i).getTitle());
				System.out.println("title : " + fileEntries.get(i).getTitle());
				SimpleDateFormat myFormat = new SimpleDateFormat("dd MMMM yyyy");
				String videoDateString = "";
				System.out.println(fileEntries.get(i).getExpandoBridge().getAttribute("Video Display Date"));
				videoDateString = myFormat.format(fileEntries.get(i).getExpandoBridge().getAttribute("Video Display Date"));
				videosDate.add(videoDateString);
			}
			renderRequest.setAttribute("videoUrls", videoUrls);
			renderRequest.setAttribute("videosDescription",videosDescription);
			renderRequest.setAttribute("videosTitle", videosTitle);
			renderRequest.setAttribute("videosDate", videosDate);
			System.out.println("videosDate : " + videosDate.toString());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}
}