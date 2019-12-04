package forms.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMContent;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion;
import com.liferay.dynamic.data.mapping.service.DDMContentLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordVersionLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.service.UserServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceTokenLocalServiceUtil;

import basic.model.formeventusertable;

/**
 * @author Parth
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=forms Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + forms.constants.FormsPortletKeys.FORMS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class FormsPortlet extends MVCPortlet {
	private final static Log _log = LogFactoryUtil.getLog(FormsPortlet.class.getClass());

	private UserNotificationEventLocalService _userNotificationEventLocalService;

	@Reference(unbind = "-")
	protected void setGroupLocalService(UserNotificationEventLocalService userNotificationEventLocalService) {
		_userNotificationEventLocalService = userNotificationEventLocalService;
	}

	private static void getListingForReviewer(JSONArray jsonArr, long groupId) {
		try {
			Connection con = null;
			Statement st = null;
			con = DataAccess.getConnection();
			st = con.createStatement();
			List<formeventusertable> formUserSubmissionList = null;
			//Code changes for the reviewer Comments start
			String sqlStatement = "select uuid_,ID,userId,ddmFormInstanceId,ddmFormInstanceRecordVersionId,formId,statusCol,reviewerUserId,reviewerComments,eventId\n"
					+ " from  formeventusertable ft where statusCol = \"sent for review\";";
			//Code changes for the reviewer Comments end
			ResultSet rs = st.executeQuery(sqlStatement);
			while (rs.next()) {
				JSONObject json = JSONFactoryUtil.createJSONObject();
				json.put("EventTitle", CalendarBookingLocalServiceUtil.getCalendarBooking(rs.getLong("eventId"))
						.getTitleCurrentValue());
				json.put("formId", rs.getString("formId"));
				json.put("Status", rs.getString("statusCol"));
				json.put("SubmitUserId", rs.getString("userId"));
				json.put("ddmFormInstanceId", rs.getString("ddmFormInstanceId"));
				json.put("groupId", groupId);
				json.put("EventId", rs.getString("eventId"));
				json.put("SubmitUserName", rs.getString("uuid_"));
				json.put("uuid", "123");
				//Code changes for the reviewer Comments start
				json.put("reviewerUserId",Validator.isNotNull(rs.getString("reviewerUserId")) ? rs.getString("reviewerUserId") : "");
				json.put("reviewerComments",Validator.isNotNull(rs.getString("reviewerComments")) ? rs.getString("reviewerComments") : "");
				//Code changes for the reviewer Comments end
				
				jsonArr.put(json);
			}
			con.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exception occurs" + e.getLocalizedMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet#render(javax.
	 * portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		HttpServletRequest requestInsideThePortlet = PortalUtil.getHttpServletRequest(renderRequest);
		String eventIdParam =  PortalUtil.getOriginalServletRequest(requestInsideThePortlet).getParameter("eventID");
		System.out.println("-----eventId render FormsPortlet---0" + "----"+eventIdParam);

		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long loggedInUserId = themeDisplay.getUserId();
		// TODO check if the user is of type reviewEvent role.
		JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
		boolean isReviewerEventRole = false;
		try {
			isReviewerEventRole = RoleLocalServiceUtil.hasUserRoles(loggedInUserId, themeDisplay.getCompanyId(),
					new String[] { "reviewerEvent" }, false);
		} catch (PortalException e) {
			e.printStackTrace();
			System.out.println("Exception while fetching the role of the user" + e.getLocalizedMessage());
		}
		if (isReviewerEventRole) {
			// TODO get all the data that is in the send to review status present.
			getListingForReviewer(jsonArr, themeDisplay.getSiteGroupId());
			renderRequest.setAttribute("originalList", jsonArr);
			super.render(renderRequest, renderResponse);
		} else {

			// Get calendar events that are created by current user
			Calendar calendar = CalendarLocalServiceUtil.fetchGroupCalendar(themeDisplay.getCompanyId(),
					themeDisplay.getSiteGroupId(), "Liferay");
			System.out.println("claendarID" + calendar.getCalendarId());
			System.out.println("Calendar Name " + calendar.getNameCurrentValue());
			List<CalendarBooking> calendarBookings = new ArrayList<>();
			Map<Long, String> formAttribute = new HashMap<>();
			Map<String, CalendarBooking> actionMap = new HashMap<>();
			CalendarBookingLocalServiceUtil.getCalendarBookings(calendar.getCalendarId(), new int[] {

					WorkflowConstants.STATUS_APPROVED }).stream()
					.filter(predicate -> predicate.getUserId() == themeDisplay.getUserId()).forEach(action -> {
						actionMap.put(String.valueOf(action.getCalendarBookingId()), action);
						System.out.println("the calendarBookingId : " + action.getCalendarBookingId());
						action.setTitle(action.getTitleCurrentValue());
						calendarBookings.add(action);
						formAttribute.put(Long.valueOf(action.getCalendarBookingId()),
								(String) action.getExpandoBridge().getAttribute("formId"));

					});

			System.out.println("----------FormsPortlet------------");

			
			Connection con = null;
			try {
				String ddmFormInstanceId = "", userId = "", userName = "";
				String status = "";
				
				Statement st = null;
				con = DataAccess.getConnection();
				st = con.createStatement();
				List<formeventusertable> cbLst = null;

				//Code changes for the reviewer Comments start
				String sqlStatement = " select ID"
						+ "                   ,ft.userId"
						+ "                   ,ft.eventId"
						+ "                   ,ft.ddmFormInstanceId"
						+ "                   ,ft.statusCol"
						+ "                   ,ft.reviewerUserId"
						+ "                   ,ft.reviewerComments "
						+ "                   ,ft.uuid_"
						+"                    ,coalesce((select userId "
						+ "                               from EventReviewers ed"
						+ "                              where ed.userId =" + String.valueOf(loggedInUserId)
	                    + "                                and ed.eventId = ft.eventId),-1) as reviewerId"
	                    +"                     ,coalesce((select userId "
	                    + "                                from EventEditors ed"
						+ "                               where ed.userId =" + String.valueOf(loggedInUserId)
	                    + "                                 and ed.eventId = ft.eventId"
	                    + "                                 limit 1 ),-1) as editorId"
						+ "                   ,(select coalesce(gender,'Male') \r\n" 
						+ "                         from profileInfo o \r\n" 
						+ "                        where o.userId = ft.userId"
						+ "                         limit 1 ) as gender "
						+"                     ,(select coalesce(currentWorkPosition,'') "  
						+"                          from profileInfo o \r\n" 
						+"                         where o.userId = ft.userId"
						+ "                       limit 1 ) as currentWorkPosition "
						+"                      ,(select year(sysdate())-coalesce(year(dateofbirth),0)\r\n"  
						+"                          from profileInfo o "  
						+"                         where o.userId = ft.userId"
						+ "                       limit 1 ) as age "
						+ "              from  formeventusertable ft  "
						+ "              where (exists(select 1 "
						+ "                             from CalendarBooking u "
						+ "                            where u.userId = " + String.valueOf(loggedInUserId)
					    + "                              and ft.eventId = u.calendarBookingId) "
					    + "                       OR "
					    + "                      exists(select 1"
					    + "                               from EventReviewers ed"
					    + "                              where ed.userId =" + String.valueOf(loggedInUserId)
					    + "                                 and ed.eventId = ft.eventId"
					    + "                                 and (ft.statusCol = 'rejected by reviewer' or ft.statusCol = 'approved by reviewer' or ft.statusCol =  'sent for review')))"
						+ "                and ft.eventId = "+eventIdParam;
				
				
				//Code changes for the reviewer Comments end

				System.out.println("formsPortlet:  sqlQuery:: " + sqlStatement);
				ResultSet rs = st.executeQuery(sqlStatement);
				CalendarBooking obj;
				String formId = "";
				String eventTitle = "";
				String SubmitUserId = "";
				String eventId = "";
				while (rs.next()) {
					System.out.println("11111111");
					CalendarBooking ca = CalendarBookingLocalServiceUtil.getCalendarBooking(Long.parseLong(rs.getString("eventId")));
					System.out.println("2222");
					/*
					if (ca.getUserId() != loggedInUserId)
						continue;
						*/
					System.out.println("33333");
					ddmFormInstanceId = rs.getString("ddmFormInstanceId");
					System.out.println("4444444");
					SubmitUserId = rs.getString("userId");
					System.out.println("555555");
					eventId = String.valueOf(ca.getCalendarBookingId());
					System.out.println("6666666666");
					userName = rs.getString("uuid_");
					System.out.println("7777777");
					status = rs.getString("statusCol");
					System.out.println("88888888");
					formId = rs.getString("ddmFormInstanceId");
					eventTitle = ca.getTitleCurrentValue();
					JSONObject json = JSONFactoryUtil.createJSONObject();
					json.put("EventTitle", ca.getTitleCurrentValue() /* obj.getTitleCurrentValue() */);
					json.put("EventId", eventId);
					json.put("SubmitUserId", SubmitUserId);
					json.put("SubmitUserName", userName);
					json.put("ddmFormInstanceId", formId);
					json.put("formId", formId);
					json.put("Status", status);
					json.put("uuid", 123);
					json.put("groupId", themeDisplay.getSiteGroupId());
					//Code changes for the reviewer Comments start
					json.put("reviewerUserId",Validator.isNotNull(rs.getString("reviewerUserId")) ? rs.getString("reviewerUserId") : "");
					json.put("reviewerId",Validator.isNotNull(rs.getString("reviewerId")) ? rs.getString("reviewerId") : "");
					json.put("reviewerComments",Validator.isNotNull(rs.getString("reviewerComments")) ? rs.getString("reviewerComments") : "");
					json.put("gender",Validator.isNotNull(rs.getString("gender")) ? rs.getString("gender") : "");
					json.put("currentWorkPosition",Validator.isNotNull(rs.getString("currentWorkPosition")) ? rs.getString("currentWorkPosition") : "");
					json.put("age",Validator.isNotNull(rs.getString("age")) ? rs.getString("age") : "");
					//Code changes for the reviewer Comments end
					jsonArr.put(json);
				}
				con.close();
				st.close();
			} catch (Exception ex) 
			{
				ex.printStackTrace();
			}
			finally
			{
				DataAccess.cleanUp(con);
			}

			renderRequest.setAttribute("originalList", jsonArr);
			renderRequest.setAttribute("calendarBookings", calendarBookings);
			renderRequest.setAttribute("formAttribute", formAttribute);
			super.render(renderRequest, renderResponse);
		}
	}

	
	public String getMailTemplates(String userMail, boolean isApproved, String eventId, String userName) {
		String messageBody = "";
		try {
			String messageName="";
			System.out.println("userMail "+ userMail + " isApproved "+isApproved);
			List<com.liferay.dynamic.data.mapping.model.DDMStructure> ddmStructureList = DDMStructureLocalServiceUtil
					.getStructures();
			String[] structureKeyArray = null;
			for (com.liferay.dynamic.data.mapping.model.DDMStructure ddmStructure : ddmStructureList) {
				if (ddmStructure.getName("en_US").equalsIgnoreCase("Email Template") && isApproved ==  true) 
				{
					structureKeyArray = new String[] { ddmStructure.getStructureKey() };
					break;
				}
				if (ddmStructure.getName("en_US").equalsIgnoreCase("Email Template") && isApproved ==  false) {
					structureKeyArray = new String[] { ddmStructure.getStructureKey() };
					break;
				}
			}
			
			
			if(isApproved ==  true)
			{   System.out.println("Approved");
				JournalArticleLocalServiceUtil.getStructureArticles(structureKeyArray).parallelStream()
				.filter(predicate -> predicate.getStatus() == WorkflowConstants.STATUS_APPROVED)
				.forEach(journalArticle -> {
					try {
						if (JournalArticleLocalServiceUtil.isLatestVersion(journalArticle.getGroupId(),
								journalArticle.getArticleId(), journalArticle.getVersion())) {
							if (Validator.isNotNull(journalArticle)) {
								Document document = SAXReaderUtil.read(journalArticle.getContentByLocale("en_US"));
								
								System.out.println("getMailTemplates:: userMail"+userMail+" message: "+document.selectSingleNode(
										"/root/dynamic-element[@name='emailTemplate']/dynamic-content[@language-id='en_US']")
										.getText());
								sendMailToUser(userName ,eventId, userMail, true, document.selectSingleNode(
										"/root/dynamic-element[@name='emailTemplate']/dynamic-content[@language-id='en_US']")
										.getText());
							
								
							}
							return;
						}
					} catch (PortalException | DocumentException e) {
						e.getMessage();
					}
				});
			}
			
			
			
			if(!isApproved)
			{  System.out.println("Rejected");
			
				JournalArticleLocalServiceUtil.getStructureArticles(structureKeyArray).parallelStream()
				.filter(predicate -> predicate.getStatus() == WorkflowConstants.STATUS_APPROVED)
				.forEach(journalArticle -> {
					try {
						if (JournalArticleLocalServiceUtil.isLatestVersion(journalArticle.getGroupId(),
								journalArticle.getArticleId(), journalArticle.getVersion())) {
							if (Validator.isNotNull(journalArticle)) {
								Document document = SAXReaderUtil.read(journalArticle.getContentByLocale("en_US"));
								System.out.println("getMailTemplates:: userMail"+userMail+" message: "+document.selectSingleNode(
										"/root/dynamic-element[@name='emailTemplate']/dynamic-content[@language-id='en_US']")
										.getText());
								sendMailToUser(userName , eventId, userMail, false, document.selectSingleNode(
										"/root/dynamic-element[@name='emailTemplate']/dynamic-content[@language-id='en_US']")
										.getText());
							}
							return;
						}
					} catch (PortalException | DocumentException e) {
						e.getMessage();
					}
				});
			}
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return messageBody;
	}

	public void sendMailToUser(String userName, String eventId, String mail, boolean isAccepted, String messageBody) {
		InternetAddress fromAddress = null;
		System.out.println("new mail");
		String status="rejected";
		String toEmailAddress = mail;
		String[] toEmailArray = toEmailAddress.split(",");
		CalendarBooking obj;
		InternetAddress[] toAddress = new InternetAddress[toEmailArray.length];
		for (int i = 0; i < toEmailArray.length; i++) {
			try {
				toAddress[i] = new InternetAddress(toEmailArray[i]);
				if (isAccepted)
					status="approved";
				messageBody = messageBody.replace("status",status);
			} catch (AddressException e) {
				System.err.println("Address Exception occured while retrive toAddress : " + e);
			}
		}

		try {
			System.out.println("....................................eventId : "+eventId);
			obj = (CalendarBooking) CalendarBookingLocalServiceUtil.getCalendarBooking(Long.parseLong(eventId));
			messageBody = messageBody.replace("User",userName).replace("status",status).replace("eventName",obj.getTitle("en_us"));
			System.out.println("messageBody : "+messageBody);
			fromAddress = new InternetAddress("jean.e.saade@gmail.com");
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(toAddress);
			mailMessage.setFrom(fromAddress);
			mailMessage.setSubject("test");
			mailMessage.setBody(messageBody);
			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
			System.out.println("Mail Send Successfully .....!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Mail Send Error :" + e);
		}
	}

	public JSONArray reloadMyEvent(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String eventId) {
		List<CalendarBooking> calendarBookings = new ArrayList<>();
		Map<Long, String> formAttribute = new HashMap<>();
		Map<String, CalendarBooking> actionMap = new HashMap<>();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long loggedInUserId = themeDisplay.getUserId();
		// Get calendar events that are created by current user
		Calendar calendar = CalendarLocalServiceUtil.fetchGroupCalendar(themeDisplay.getCompanyId(),
				themeDisplay.getSiteGroupId(), "Liferay");
		JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
		CalendarBookingLocalServiceUtil.getCalendarBookings(calendar.getCalendarId(), new int[] {

				WorkflowConstants.STATUS_APPROVED }).stream()
				.filter(predicate -> predicate.getUserId() == themeDisplay.getUserId()).forEach(action -> {
					actionMap.put(String.valueOf(action.getCalendarBookingId()), action);
					System.out.println("the calendarBookingId : " + action.getCalendarBookingId());
					action.setTitle(action.getTitleCurrentValue());
					calendarBookings.add(action);
					formAttribute.put(Long.valueOf(action.getCalendarBookingId()),
							(String) action.getExpandoBridge().getAttribute("formId"));
					// List<DDMFormInstanceRecord> fromInstances =
					// DDMFormInstanceRecordLocalServiceUtil.getFormInstanceRecords(Long.parseLong((String)
					// action.getExpandoBridge().getAttribute("formId")));

				});

		String ddmFormInstanceId = "", userId = "", userName = "";
		String status = "";
		java.sql.Connection con = null;
		java.sql.Statement st = null;
		try {
			
			con = DataAccess.getConnection();
			st = con.createStatement();
			
			//Code changes for the reviewer Comments start
			String sqlStatement = " select (select concat(e.firstname,concat(' ',e.lastname)) "
					+ "                       from User_ e " + "       "
					+ "                      where e.userId = ft.userId) as username,"
					+ "                    ft.ddmFormInstanceId, " 
					+ "                    ft.userId, " 
					+ "                    ft.statusCol, "
					+ "                    ft.reviewerUserId, "
					+ "                    ft.reviewerComments, " 
					+ "                    ft.uuid_ ,"
					+ "                    ft.eventId " + " "
					+"                    ,coalesce((select userId "
					+ "                               from EventReviewers ed"
					+ "                              where ed.userId =" + String.valueOf(loggedInUserId)
                    + "                                and ed.eventId = ft.eventId),-1) as reviewerId"
                    +"                     ,coalesce((select userId "
                    + "                                from EventEditors ed"
					+ "                               where ed.userId =" + String.valueOf(loggedInUserId)
                    + "                                 and ed.eventId = ft.eventId"
                    + "                                 limit 1),-1) as editorId"
					+ "                   ,(select coalesce(o.gender,'Male') \r\n" 
					+ "                         from profileInfo o \r\n" 
					+ "                        where o.userId = ft.userId"
					+ "                            limit 1) as gender "
					+"                     ,(select coalesce(o.currentWorkPosition,'') "  
					+"                          from profileInfo o \r\n" 
					+"                         where o.userId = ft.userId"
					+ "                          limit 1 ) as currentWorkPosition "
					+"                      ,(select year(sysdate())-coalesce(year(o.dateofbirth),0)\r\n"  
					+"                          from profileInfo o "  
					+"                         where o.userId = ft.userId"
					+ "                         limit 1 ) as age "
					+ "              from  formeventusertable ft " + " "
					+ "              where exists(select 1 "
				    + "                             from CalendarBooking u " 
					+ "                            where u.userId = " + String.valueOf(loggedInUserId)
				    + "                              and ft.eventId = u.calendarBookingId"
				    + "                                 OR  "  
				    +"                      exists(select 1"
				    +"                               from EventReviewers ed"
				    +"                              where ed.userId =" + String.valueOf(loggedInUserId)
				    +"                                 and ed.eventId = ft.eventId" 
				    +"                                 and (ft.statusCol = 'rejected by reviewer' or ft.statusCol = 'approved by reviewer' or ft.statusCol =  'sent for review')))"
				    +"                       and ft.eventId = "+eventId;
			//Code changes for the reviewer Comments end
			

			System.out.println("reloadMyEvent:  sqlQuery:: " + sqlStatement);
			java.sql.ResultSet rs = st.executeQuery(sqlStatement);
			CalendarBooking obj;
			while (rs.next()) {
				obj = (CalendarBooking) CalendarBookingLocalServiceUtil.getCalendarBooking(Long.parseLong(rs.getString("eventId")));
				ddmFormInstanceId = rs.getString("ddmFormInstanceId");
				userId = rs.getString("userId");
				userName = rs.getString("userName");
				status = rs.getString("statusCol");
				JSONObject json = JSONFactoryUtil.createJSONObject();
				json.put("EventTitle", obj.getTitleCurrentValue());
				json.put("EventId", rs.getString("eventId"));
				json.put("SubmitUserId", userId);
				json.put("SubmitUserName", userName);
				json.put("ddmFormInstanceId", ddmFormInstanceId);
				json.put("formId", (String) obj.getExpandoBridge().getAttribute("formId"));
				json.put("Status", status);
				json.put("uuid", rs.getString("uuid_"));
				json.put("groupId", themeDisplay.getSiteGroupId());
				//Code changes for the reviewer Comments start
				json.put("reviewerUserId",Validator.isNotNull(rs.getString("reviewerUserId")) ? rs.getString("reviewerUserId") : "");
				json.put("reviewerId",Validator.isNotNull(rs.getString("reviewerId")) ? rs.getString("reviewerId") : "");
				json.put("reviewerComments",Validator.isNotNull(rs.getString("reviewerComments")) ? rs.getString("reviewerComments") : "");
				json.put("gender",Validator.isNotNull(rs.getString("gender")) ? rs.getString("gender") : "");
				json.put("currentWorkPosition",Validator.isNotNull(rs.getString("currentWorkPosition")) ? rs.getString("currentWorkPosition") : "");
				json.put("age",Validator.isNotNull(rs.getString("age")) ? rs.getString("age") : "");
				//Code changes for the reviewer Comments end
				jsonArr.put(json);
			}
			con.close();
			st.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			DataAccess.cleanUp(con);
		}
		return jsonArr;
	}


	
	public String getEventReviewer(String eventId) 
	{
		java.sql.Connection con = null;
		java.sql.Statement st = null;
		String speakerId = "-1";
		try 
		{
			con = DataAccess.getConnection();
			st = con.createStatement();
			String sqlStatement = "select userId from EventReviewers where eventId = "+eventId;
			java.sql.ResultSet rs = st.executeQuery(sqlStatement);
			CalendarBooking obj;
			System.out.println("getReviewerUserId::sql "+sqlStatement);
			while (rs.next()) 
			{
				speakerId = rs.getString("userId");
			}
			System.out.println("getReviewerUserId::speakerId:: "+speakerId);
			DataAccess.cleanUp(con, st);
		}
		catch(Exception ex)
		{
			DataAccess.cleanUp(con, st);
			ex.printStackTrace();
		}
		finally
		{
			DataAccess.cleanUp(con, st);
		}
		return speakerId;
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String command = resourceRequest.getParameter("command");
		System.out.println("command:---: "+command);
		System.out.println(".getParameter(\"Id\"):---: "+resourceRequest.getParameter("Id"));
		System.out.println(".getParameter(\"Id\"):---: "+resourceRequest.getParameter("Id"));
		System.out.println(".getParameter(\"recordID\"):---: "+resourceRequest.getParameter("recordID"));
		
		// System.exit(0);
		java.sql.Connection con = null;
		if (Validator.isNotNull(resourceRequest.getParameter("action"))
				&& "getEventReviewer".equals(resourceRequest.getParameter("action"))) 
		{
			try
			{
				String eventId = resourceRequest.getParameter("eventId");
				String reviewerId = getEventReviewer(eventId);
				PrintWriter printout = resourceResponse.getWriter();
				printout.print(reviewerId);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		/*send to reviewer*/
		else
		if(Validator.isNotNull(resourceRequest.getParameter("action"))
				&& "sendToReview".equals(resourceRequest.getParameter("action"))) 
		{
			String recordVersionId = resourceRequest.getParameter("recordVersionId");
			String recordID = resourceRequest.getParameter("recordID");
			String eventId = resourceRequest.getParameter("eventId");
			System.out.println("serve resource for send to review called." + recordVersionId + ":" + recordID+" eventId: "+eventId);
			try {
				
				java.sql.Statement st = null;
				con = DataAccess.getConnection();
				st = con.createStatement();
				String sqlStatement = "update formeventusertable set statusCol = 'sent for review' "
						+ "   where ddmFormInstanceRecordVersionId = '" + recordVersionId+"'";
				System.out.println("sqlStatement: " + sqlStatement);
				st.executeUpdate(sqlStatement);
				con.close();
				st.close();
				JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
				jsonArr = reloadMyEvent(resourceRequest, resourceResponse,eventId);
//				resourceRequest.setAttribute("originalList", jsonArr);
				PrintWriter printout = resourceResponse.getWriter();
				System.out.println(jsonArr);
				printout.print(jsonArr);
				DataAccess.cleanUp(con);
			} catch (Exception e) {
				e.printStackTrace();
				DataAccess.cleanUp(con);
				System.out.println("Exception occurred while update of the record to sent to review " + e);
				PrintWriter printout = resourceResponse.getWriter();
				printout.print("failure");
			}
			super.serveResource(resourceRequest, resourceResponse);
		}   
		/*approved or rejected by reveiwer*/
		else if (Validator.isNotNull(resourceRequest.getParameter("action"))
				&& ("approvedbyreveiewer".equals(resourceRequest.getParameter("action"))
						|| "rejectedbyreveiewer".equals(resourceRequest.getParameter("action")))) 
		{
			String eventId = resourceRequest.getParameter("eventId");
			String recordVersionId = resourceRequest.getParameter("recordVersionId");
			String recordID = resourceRequest.getParameter("recordID");
			String reviewerComments = resourceRequest.getParameter("reviewerComments");
			String reviewerUserId = resourceRequest.getParameter("userId");
			String status = "rejectedbyreveiewer".equals(resourceRequest.getParameter("action")) ? "rejected by reviewer"
					: "approved by reviewer";
			
			//user who submitted the questioneer
			String submitterUserId = resourceRequest.getParameter("submitterUserId");
			
			
			
			String groupId = resourceRequest.getParameter("groupId");
			System.out.println("serve resource for rejectedbyreveiewer." + recordVersionId + ":" + recordID + ":"
					+ reviewerComments);
			try {
				String userId = resourceRequest.getParameter("userId");
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("userId", resourceRequest.getParameter("userId"));
				jsonObject.put("title", "Form Submission Approved.");
				jsonObject.put("senderName", "Admin");
				jsonObject.put("notificationMessage",
						"Your entries for the event has been approved successfully by admin.");
				
				//send notification
				/*
				_userNotificationEventLocalService.addUserNotificationEvent(
						Long.parseLong(submitterUserId),
						SendNotificationToUserHandler.PORTLET_ID, (new Date()).getTime(),
						UserNotificationDeliveryConstants.TYPE_WEBSITE,
						Long.parseLong(submitterUserId), jsonObject.toString(), false,
						new ServiceContext());
						*/
				 System.out.println("reviewer:: before getting the user to get mail");
				 User usr = UserServiceUtil.getUserById(Long.parseLong(userId));
					System.out.println("reviewer:: after getting the user to get mail");
				 boolean approved = true;
				 if(("rejectedbyreveiewer").equalsIgnoreCase(status)) 
					 approved =false;
				 //send mail
				 getMailTemplates(usr.getEmailAddress(), approved, eventId,usr.getFullName());
				 
				 
				
				java.sql.Statement st = null;
				con = DataAccess.getConnection();
				st = con.createStatement();
				
				/*
				 * String sqlStatement = "update formeventusertable set statusCol = '" + status
				 * + "', reviewerComments= '" + reviewerComments + "'" +
				 * "   where ddmFormInstanceRecordVersionId = '" + recordVersionId + "' ";
				 */
				
				String sqlStatement = "update formeventusertable set statusCol = '" + status + "', reviewerComments= '"
						+ reviewerComments + "'"
						+ "   where userId = '" + userId + "' and eventId = "+eventId;
				
				
				System.out.println("sqlStatement: " + sqlStatement);
				st.executeUpdate(sqlStatement);
				con.close();
				st.close();
				
				JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
				jsonArr = reloadMyEvent(resourceRequest, resourceResponse,eventId);
//				resourceRequest.setAttribute("originalList", jsonArr);
				PrintWriter printout = resourceResponse.getWriter();
				System.out.println(jsonArr);
				printout.print(jsonArr);
				DataAccess.cleanUp(con);
			} catch (Exception e) 
			{
				e.printStackTrace();
				System.out.println("Exception occurred while update of the record to sent to review " + e);
				PrintWriter printout = resourceResponse.getWriter();
				printout.print("failure");
				DataAccess.cleanUp(con);
			}
			finally
			{
				DataAccess.cleanUp(con);
			}
			super.serveResource(resourceRequest, resourceResponse);
		} 
		else 
		{

			
			
			/*
			 * if(Validator.isNotNull(command) && command.equals("reloadMyEvent")) {
			 * JSONArray jsonArr = JSONFactoryUtil.createJSONArray(); jsonArr =
			 * reloadMyEvent(resourceRequest,resourceResponse);
			 * resourceRequest.setAttribute("originalList", jsonArr); PrintWriter printout =
			 * resourceResponse.getWriter(); printout.print(jsonArr);
			 * super.serveResource(resourceRequest, resourceResponse); } else
			 */
			if (Validator.isNotNull(command) && command.equals("getObjectData")) {
				System.out.println("command:---: return responsed data to admin");
				Map<String, String> dataMap;
				List<Map<String, String>> dataList = new ArrayList<>();
				try {
					String formId = resourceRequest.getParameter("Id");
					String userId = resourceRequest.getParameter("userId");
					String uuId = resourceRequest.getParameter("uuid");
					String groupId = resourceRequest.getParameter("groupId");
					String eventId = resourceRequest.getParameter("eventId");
					String ddmFormInstanceId = resourceRequest.getParameter("ddmFormInstanceId");

					
					System.out.println("=====formId=========::  "+formId);
					System.out.println("=====userId=========::  "+userId);
					System.out.println("=====uuId=========::    "+uuId);
					System.out.println("=====groupId=========:: "+groupId);
					System.out.println("=====formId=========::  "+ddmFormInstanceId);
					
					DDMFormInstanceRecord df1 = DDMFormInstanceRecordLocalServiceUtil
							.getDDMFormInstanceRecord(Long.parseLong(ddmFormInstanceId));
					DDMContent ddmContent = DDMContentLocalServiceUtil.getContent(df1.getStorageId());
					System.out.println("MICHA:: "+DDMContentLocalServiceUtil.getDDMContent(df1.getStorageId()).getData());
					System.out.println("after formId:: ");
					/*
					 * List<DDMFormInstanceRecord> df1 =
					 * DDMFormInstanceRecordLocalServiceUtil.getFormInstanceRecords(Long.parseLong(
					 * formId),Long.parseLong(userId),0,1,null); DDMFormInstanceRecord df
					 * =df1.get(0); dataMap = new HashMap<String, String>(); DDMContent ddmContent =
					 * DDMContentLocalServiceUtil.getContent(df.getStorageId());
					 */
					long structureId=DDMFormInstanceLocalServiceUtil.getDDMFormInstance(df1.getFormInstanceId()).getStructureId();
					String data = ddmContent.getData();
					System.out.println("-----------::---------- "+data);
					JSONArray jsonArray = JSONFactoryUtil.createJSONObject(data).getJSONArray("fieldValues");
					for (int i = 0; i < jsonArray.length(); i++) {
						System.out.println("inside forrrr ");
						dataMap = new HashMap<String, String>();
						JSONObject dataJson = jsonArray.getJSONObject(i);
						System.out.println(dataJson);
						JSONObject value = JSONFactoryUtil.createJSONObject(dataJson.getString("value"));
						String question = DDMStructureLocalServiceUtil.getDDMStructure(structureId).getFieldLabel((String) dataJson.get("name"), "en_US");
						//String question = (String) dataJson.get("name");
						String fieldValue = value.getString("en_US");
						System.out.println("quesrionsssss:: ");
						System.out.println(question);

						dataMap.put("Question: ", question);
						dataMap.put("email", question + "  :  " + fieldValue);
						dataMap.put("contentId", String.valueOf(ddmContent.getContentId()));
						dataMap.put("userId", String.valueOf(df1.getUserId()));
						dataMap.put("formData", dataJson.getString("name") + " : " + fieldValue);
						List<KaleoInstanceToken> kaleoInstanceTokens = KaleoInstanceTokenLocalServiceUtil
								.getKaleoInstanceTokens(-1, -1);
						DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion = DDMFormInstanceRecordVersionLocalServiceUtil
								.getFormInstanceRecordVersion(df1.getFormInstanceRecordId(), df1.getVersion());
						dataMap.put("recordVersionId",
								String.valueOf(ddmFormInstanceRecordVersion.getFormInstanceRecordVersionId()));
						dataMap.put("status", String.valueOf(ddmFormInstanceRecordVersion.getStatus()));
						dataMap.put("eventId", eventId);
						dataList.add(dataMap);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				resourceRequest.setAttribute("data", dataList);
				PrintWriter printout = resourceResponse.getWriter();
				printout.print(JSONFactoryUtil.createJSONArray(dataList).toJSONString());
				super.serveResource(resourceRequest, resourceResponse);
			} /* will not be used path methods */
			else if (Validator.isNotNull(resourceRequest.getParameter("Id"))) {
				List<Map<String, String>> dataList = new ArrayList<>();
				Map<String, String> dataMap;
				List<DDMFormInstanceRecord> fromInstances = DDMFormInstanceRecordLocalServiceUtil
						.getFormInstanceRecords(Long.parseLong(resourceRequest.getParameter("Id")));
				for (DDMFormInstanceRecord ddmFormInstanceRecord : fromInstances) {
					try {
						dataMap = new HashMap<String, String>();
						DDMContent ddmContent = DDMContentLocalServiceUtil
								.getContent(ddmFormInstanceRecord.getStorageId());
						String data = ddmContent.getData();
						JSONArray jsonArray = JSONFactoryUtil.createJSONObject(data).getJSONArray("fieldValues");
						for (int i = 0; i < jsonArray.length(); i++) {
							dataMap = new HashMap<String, String>();
							JSONObject dataJson = jsonArray.getJSONObject(i);
							JSONObject value = JSONFactoryUtil.createJSONObject(dataJson.getString("value"));
							String fieldValue = value.getString("en_US");
							dataMap.put("email", fieldValue);
							dataMap.put("contentId", String.valueOf(ddmContent.getContentId()));
							dataMap.put("userId", String.valueOf(ddmFormInstanceRecord.getUserId()));
							dataMap.put("formData", dataJson.getString("name") + " : " + fieldValue);
							List<KaleoInstanceToken> kaleoInstanceTokens = KaleoInstanceTokenLocalServiceUtil
									.getKaleoInstanceTokens(-1, -1);
							DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion = DDMFormInstanceRecordVersionLocalServiceUtil
									.getFormInstanceRecordVersion(ddmFormInstanceRecord.getFormInstanceRecordId(),
											ddmFormInstanceRecord.getVersion());
							dataMap.put("recordVersionId",
									String.valueOf(ddmFormInstanceRecordVersion.getFormInstanceRecordVersionId()));
							dataMap.put("status", String.valueOf(ddmFormInstanceRecordVersion.getStatus()));
							dataList.add(dataMap);
						}
					} catch (PortalException e) {
						e.printStackTrace();
					}
				}
				resourceRequest.setAttribute("data", dataList);
				PrintWriter printout = resourceResponse.getWriter();
				printout.print(JSONFactoryUtil.createJSONArray(dataList).toJSONString());
				super.serveResource(resourceRequest, resourceResponse);
			} else /* for aproval or reject */
			if (Validator.isNotNull(resourceRequest.getParameter("recordID"))) {
				try {
					String status = resourceRequest.getParameter("status");
					String eventId = resourceRequest.getParameter("eventId");
					System.out.println("before sending mail and going to approve");
					System.out.println("after sending mail");
					String userId = resourceRequest.getParameter("userId");
					String recordVersionId = resourceRequest.getParameter("recordVersionId");

					System.out.println("for aproval or reject  userId:: " + userId + "------recordVersionId: " + recordVersionId+"----eventId: "+eventId);
					System.out.println("aproval flow1");
					DDMFormInstanceRecord ddmFormInstanceRecord = DDMFormInstanceRecordLocalServiceUtil.updateStatus(
							Long.parseLong(resourceRequest.getParameter("userId")),
							Long.parseLong(resourceRequest.getParameter("recordVersionId")),
							WorkflowConstants.STATUS_APPROVED, null);
					System.out.println("aproval flow2");

					// TODO send user notification for successfull implementation.
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put("userId", resourceRequest.getParameter("userId"));
					
					if(("Approved").equalsIgnoreCase(status))
					{
						jsonObject.put("title", "Form Submission Approved.");
						jsonObject.put("notificationMessage", "Your entries for the event has been approved successfully by admin.");
					}
					else
					{
						jsonObject.put("title", "Form Submission Rejected.");
						jsonObject.put("notificationMessage", "Your entries for the event has been Rejected.");
					}
					
					jsonObject.put("senderName", "Admin");
					
					_log.info("Notification to be send");
					System.out.println("aproval flow3");

					_userNotificationEventLocalService.addUserNotificationEvent(
							Long.parseLong(resourceRequest.getParameter("userId")),
							SendNotificationToUserHandler.PORTLET_ID, (new Date()).getTime(),
							UserNotificationDeliveryConstants.TYPE_WEBSITE,
							Long.parseLong(resourceRequest.getParameter("userId")), jsonObject.toString(), false,
							new ServiceContext());
					 User usr = UserServiceUtil.getUserById(Long.parseLong(resourceRequest.getParameter("userId")));
					 
					 boolean approved = false;
					 if(("Approved").equalsIgnoreCase(status)) 
						 approved =true;
					 //send mail
					 System.out.println("before sending the mail");
					 getMailTemplates(usr.getEmailAddress(), approved, eventId,usr.getFullName());
					 
					_log.info("Notification done");
					System.out.println("aproval flow4");
					java.sql.Statement st = null;

					System.out.println("aproval flow5");
					con = DataAccess.getConnection();
					st = con.createStatement();
					System.out.println("ijaaaaaaa");
					String sqlStatement = "update formeventusertable set statusCol = '"+status+"'"
							+ "   where ddmFormInstanceRecordVersionId = '" + recordVersionId+"'";
					System.out.println("sqlStatement: " + sqlStatement);
					st.executeUpdate(sqlStatement);
					con.close();
					st.close();
					JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
					jsonArr = reloadMyEvent(resourceRequest, resourceResponse, eventId);
					System.out.println("after aproval:jsonArr  " + jsonArr);
					resourceRequest.setAttribute("originalList", jsonArr);
					System.out.println("aproval flow6");
					PrintWriter printout = resourceResponse.getWriter();
					printout.print(jsonArr);
					DataAccess.cleanUp(con, st);
					// printout.print("{\"status\":\"success\"}");
				} catch (/* NumberFormatException | PortalException e | */Exception e) {
					DataAccess.cleanUp(con);
					e.printStackTrace();
					PrintWriter printout = resourceResponse.getWriter();
					printout.print("{\"status\":\"failure\"}");
				}
				super.serveResource(resourceRequest, resourceResponse);
			}else /* for aproval or reject from grid record*/
				if (Validator.isNotNull(resourceRequest.getParameter("command"))&& command.equalsIgnoreCase("ApproveRejectRecordFromGrid")) 
				{
					String status = resourceRequest.getParameter("status");
					String eventId = resourceRequest.getParameter("eventId");
					String userId = resourceRequest.getParameter("userId");
					System.out.println("---ApproveRejectRecordFromGrid------status:: "+status+"-------eventId: "+eventId+"---userId: "+userId);
					try    
					{
						con = DataAccess.getConnection();
						java.sql.Statement st = null;
						st = con.createStatement();
						System.out.println("ijaaaaaaa");
						String sqlStatement = "update formeventusertable "
								+ "               set statusCol = '"+status+"'"
								         + "    where eventId = '" + eventId+"'"
								         	+ "   and userId = "+userId;
						System.out.println("sqlStatement: " + sqlStatement);
						st.executeUpdate(sqlStatement);
						con.close();
						st.close();
						JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
						jsonArr = reloadMyEvent(resourceRequest, resourceResponse, eventId);
						System.out.println("after aproval:jsonArr  " + jsonArr);
						resourceRequest.setAttribute("originalList", jsonArr);
						System.out.println("aproval flow6");
						PrintWriter printout = resourceResponse.getWriter();
						printout.print(jsonArr);
					}
					catch(Exception ex)
					{
						DataAccess.cleanUp(con);
						ex.printStackTrace();
					}
					
				}
			
		}
	}
}