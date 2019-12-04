package forms.portlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.print.attribute.Size2DSyntax;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.calendar.constants.CalendarConstants;
import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.model.CalendarBookingConstants;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMContent;
import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion;
import com.liferay.dynamic.data.mapping.service.DDMContentLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordVersionLocalServiceUtil;
import forms.constants.FormsPortletKeys;
import forms.vo.EventsAttendeesVO;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceTokenLocalServiceUtil;

/**
 * @author Parth
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=forms Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FormsPortletKeys.FORMS, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class FormsPortlet2 extends MVCPortlet {
	//private final static Log _log = LogFactoryUtil.getLog(FormsPortlet.class.getClass());

	private UserNotificationEventLocalService _userNotificationEventLocalService;

	@Reference(unbind = "-")
	protected void setGroupLocalService(UserNotificationEventLocalService userNotificationEventLocalService) {
		_userNotificationEventLocalService = userNotificationEventLocalService;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet#render(javax.
	 * portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException 
	{
		//_log.info("render called.");
		try
		{
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//Get calendar events that are created by current user
		Calendar calendar = CalendarLocalServiceUtil.fetchGroupCalendar(themeDisplay.getCompanyId(),themeDisplay.getSiteGroupId(), "Liferay");
		System.out.println("claendarID" + calendar.getCalendarId());
		System.out.println("Calendar Name " + calendar.getNameCurrentValue());
		List<CalendarBooking> calendarBookings = new ArrayList<>();
		List<EventsAttendeesVO> eventsAttendeeslst = new ArrayList<>();
		EventsAttendeesVO evtVO = new EventsAttendeesVO();
		Map<Long, String> formAttribute = new HashMap<>();
		Map<Long, String> startDateHash = new HashMap<>();
		Map<Long, String> endDateHash   = new HashMap<>();
		String jsonStr = "";
		CalendarBookingLocalServiceUtil.getCalendarBookings(calendar.getCalendarId(), new int [] 
		{
			
			WorkflowConstants.STATUS_APPROVED}).stream().filter(predicate -> predicate.getUserId() == themeDisplay.getUserId()).forEach(action ->{
			
			List<Map<String, String>> submitionUser = returnSubmittedAnswers( (String) action.getExpandoBridge().getAttribute("formId"),String.valueOf(action.getCalendarBookingId()));	
			action.setTitle(action.getTitleCurrentValue());
			boolean b = false;
			calendarBookings.add(action);
			JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
		    
			System.out.println("(action.getTitleCurrentValue():"+action.getTitleCurrentValue()+"\n\n\n");
			for (Map su : submitionUser)
		    {
				b = checkIfUserAssignedToEvents(su.get("userId").toString(),  String.valueOf(action.getCalendarBookingId()));
				System.out.println("su.get(\"userId\").toString(): "+su.get("userName").toString()+"--b: "+b);
				JSONObject json = JSONFactoryUtil.createJSONObject();
				if(b)
				{  
		           json.put("EventTitle", action.getTitleCurrentValue());
		           json.put("EventId", String.valueOf(action.getCalendarBookingId()));
		           json.put("EndDate", convertLongToDate(action.getEndTime()));
		           json.put("SubmitUserId", su.get("userId").toString());
		           json.put("SubmitUserName", su.get("userName").toString());
		           json.put("StartDate", convertLongToDate(action.getStartTime()));
		           json.put("formId", (String) action.getExpandoBridge().getAttribute("formId"));
	               jsonArr.put(json);
				}
				else
					{
					
					};
				System.out.println("\n\n");
			}
			
		    
		    
			/*System.out.println("***********"+action.getCalendarBookingId()+"**********");
			System.out.println("***********"+action.getExpandoBridge().getAttribute("formId")+"**********");
			System.out.println("***********"+convertLongToDate(action.getStartTime())+"**********");
			System.out.println("***********"+convertLongToDate(action.getEndTime())+"**********");
			System.out.println("*****jsonArr.length:: ******"+jsonArr.length()+"**********");*/
			
			
			renderRequest.setAttribute("originalList",jsonArr);
			formAttribute.put(Long.valueOf(action.getCalendarBookingId()), (String) action.getExpandoBridge().getAttribute("formId"));
			startDateHash.put(Long.valueOf(action.getCalendarBookingId()),convertLongToDate(action.getStartTime()));
			endDateHash.put(Long.valueOf(action.getCalendarBookingId()),convertLongToDate(action.getEndTime()));
		});
	    
		renderRequest.setAttribute("calendarBookings", calendarBookings);
		renderRequest.setAttribute("formAttribute", formAttribute);
		renderRequest.setAttribute("startDateHash", startDateHash);
		renderRequest.setAttribute("endDateHash", endDateHash);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
 
		
		super.render(renderRequest, renderResponse);
	}
	
	
	public List<Map<String, String>> returnSubmittedAnswers(String formID,String calendarBookingId)
	{
		List<DDMFormInstanceRecord> fromInstances = DDMFormInstanceRecordLocalServiceUtil
				.getFormInstanceRecords(Long.parseLong(formID));
		Map<String, String> dataMap;
		JSONObject value;
		List<Map<String, String>> dataList = new ArrayList<>();
		for (DDMFormInstanceRecord ddmFormInstanceRecord : fromInstances) 
		{
			try 
			{
				DDMContent ddmContent = DDMContentLocalServiceUtil.getContent(ddmFormInstanceRecord.getStorageId());
				String data = ddmContent.getData();
				JSONArray jsonArray = JSONFactoryUtil.createJSONObject(data).getJSONArray("fieldValues");
//				System.out.println("jsonArray"+jsonArray.toString());
				for (int i = 0; i < jsonArray.length(); i++) 
				{
					dataMap = new HashMap<String, String>();
					dataMap.put("userId", String.valueOf(ddmFormInstanceRecord.getUserId()));
					dataMap.put("userName", ddmFormInstanceRecord.getUserName());
					dataList.add(dataMap);
					continue;
				}
			} 
			catch (PortalException e) 
			{
				e.printStackTrace();
			}
	   }
		return dataList;
	}
	
	public boolean checkIfUserAssignedToEvents(String userId,String calendarBookingId)
	{
		 boolean res = true;
		 java.sql.Connection con = null;
		 java.sql.Statement st = null;
		 java.sql.ResultSet rs = null;
		 String cnt = "0";
		try
		{
			 con = DataAccess.getConnection();
			 st = con.createStatement();
			 String sqlStatement = "select count(1) cnt from eventUserAssignee where userId ="+userId+ " and "
			 		+ " eventId = "+calendarBookingId;
			// System.out.println("checkIfUserAssignedToEvents  sqlStatement: "+sqlStatement);
			 rs = st.executeQuery(sqlStatement);
			 while (rs.next()) 
			 {
				 cnt = rs.getString("cnt");
		     }
			if(cnt.equals("0"))
				res  = false;
			con.close();
			rs.close();
		}
		catch(Exception ex)
		{
			try 
			{
				con.close();
				rs.close();
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
		finally
		{
			try {
				con.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
	
	public String convertLongToDate(long l)
	{
		String stringdate = "";
		try
		{
		Date date ;
	    Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
		stringdate = format.format(l);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return stringdate;
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet#serveResource(
	 * javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		JSONObject value;
		if (Validator.isNotNull(resourceRequest.getParameter("Id"))) 
		{
			List<Map<String, String>> dataList = new ArrayList<>();
			Map<String, String> dataMap;
		/*	List<DDMFormInstanceRecord> fromInstances1 = DDMFormInstanceRecordLocalServiceUtil
					.getFormInstanceRecords(Long.parseLong(resourceRequest.getParameter("Id")));*/ //stopped by me
			List<DDMFormInstanceRecord> fromInstances = DDMFormInstanceRecordLocalServiceUtil.getFormInstanceRecords(Long.parseLong(resourceRequest.getParameter("Id")),Long.parseLong(resourceRequest.getParameter("userId")),0,1,null);
			//System.out.println("fromInstances.size :"+fromInstances.size());
			
			for (DDMFormInstanceRecord ddmFormInstanceRecord : fromInstances) {
				try {
					DDMContent ddmContent = DDMContentLocalServiceUtil.getContent(ddmFormInstanceRecord.getStorageId());
					String data = ddmContent.getData();
					JSONArray jsonArray = JSONFactoryUtil.createJSONObject(data).getJSONArray("fieldValues");
					// System.out.println("jsonArray"+jsonArray.toString());
					for (int i = 0; i < jsonArray.length(); i++) {
						dataMap = new HashMap<String, String>();
						JSONObject dataJson = null;
						dataJson = jsonArray.getJSONObject(i);
						 value = JSONFactoryUtil.createJSONObject(dataJson.getString("value"));
						String fieldValue = value.getString("en_US");
						
						dataMap.put("formData", dataJson.getString("name") + " : " + fieldValue);
						dataMap.put("contentId", String.valueOf(ddmContent.getContentId()));
						
						dataMap.put("userId", String.valueOf(ddmFormInstanceRecord.getUserId()));
						dataMap.put("userName", ddmFormInstanceRecord.getUserName());
						List<KaleoInstanceToken> kaleoInstanceTokens = KaleoInstanceTokenLocalServiceUtil
								.getKaleoInstanceTokens(-1, -1);
						DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion = DDMFormInstanceRecordVersionLocalServiceUtil
								.getFormInstanceRecordVersion(ddmFormInstanceRecord.getFormInstanceRecordId(),
										ddmFormInstanceRecord.getVersion());
						dataMap.put("recordVersionId",
								String.valueOf(ddmFormInstanceRecordVersion.getFormInstanceRecordVersionId()));
						dataMap.put("status", String.valueOf(ddmFormInstanceRecordVersion.getStatus()));
						for (KaleoInstanceToken kaleoInstanceToken : kaleoInstanceTokens) {
							if (kaleoInstanceToken.getClassPK() == DDMFormInstanceRecordVersionLocalServiceUtil
									.getFormInstanceRecordVersion(ddmFormInstanceRecord.getFormInstanceRecordId(),
											ddmFormInstanceRecord.getVersion())
									.getFormInstanceRecordVersionId()) {
							}
						}
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
		} 
		else if (Validator.isNotNull(resourceRequest.getParameter("recordID"))) 
		{
			try {
				if (resourceRequest.getParameter("status").equalsIgnoreCase("Approved"))
				{DDMFormInstanceRecord ddmFormInstanceRecord = DDMFormInstanceRecordLocalServiceUtil.updateStatus(
						Long.parseLong(resourceRequest.getParameter("userId")),
						Long.parseLong(resourceRequest.getParameter("recordVersionId")),
						WorkflowConstants.STATUS_APPROVED, null);
				}
				else if (resourceRequest.getParameter("status").equalsIgnoreCase("Rejcet"))
					{DDMFormInstanceRecord ddmFormInstanceRecord = DDMFormInstanceRecordLocalServiceUtil.updateStatus(
							Long.parseLong(resourceRequest.getParameter("userId")),
							Long.parseLong(resourceRequest.getParameter("recordVersionId")),
							WorkflowConstants.STATUS_DENIED, null);
					}
				// TODO send user notification for successfull implementthat mean ation.
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("userId", resourceRequest.getParameter("userId"));
				jsonObject.put("title", "Form Submission "+resourceRequest.getParameter("status")+".");
				jsonObject.put("senderName", "Admin");
				jsonObject.put("notificationMessage",
						"Your entries for the event has been "+resourceRequest.getParameter("status")+" by admin.");
				//_log.info("Notification to be send");
				_userNotificationEventLocalService.addUserNotificationEvent(Long.parseLong(resourceRequest.getParameter("userId")),
						SendNotificationToUserHandler.PORTLET_ID, (new Date()).getTime(),
						UserNotificationDeliveryConstants.TYPE_WEBSITE,
						Long.parseLong(resourceRequest.getParameter("userId")), jsonObject.toString(), false, new ServiceContext());
				//_log.info("Notification done");
				PrintWriter printout = resourceResponse.getWriter();
				printout.print("{\"status\":\"success\"}");
			} catch (NumberFormatException | PortalException e) {
				e.printStackTrace();
				PrintWriter printout = resourceResponse.getWriter();
				printout.print("{\"status\":\"failure\"}");
			}
			super.serveResource(resourceRequest, resourceResponse);
		}
	}
}