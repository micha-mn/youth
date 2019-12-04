package editEvent.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import editEvent.constants.EditEventPortletKeys;
import editEvent.portlet.vo.AttributesVO;
import editEvent.portlet.vo.HighLightsVO;
import editEvent.portlet.vo.QuestionsAndAnswers;
import editEvent.portlet.vo.TimelineVO;
import editEvent.portlet.vo.UserVO;

/**
 * @author sha
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EditEvent",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EditEventPortletKeys.EDITEVENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EditEventPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			HttpServletRequest requestInsideThePortlet = PortalUtil.getHttpServletRequest(renderRequest);
			String eventID =  PortalUtil.getOriginalServletRequest(requestInsideThePortlet).getParameter("eventID");
			System.out.println("eventID" + eventID);
			CalendarBooking cb = null;
			cb = CalendarBookingLocalServiceUtil.getCalendarBooking(Long.parseLong(eventID));
			System.out.println("-title in reder-----"+cb.getTitleCurrentValue()+"----");
			System.out.println(cb.getExpandoBridge().getAttribute("Event Types", false));
			renderRequest.setAttribute("eventID",eventID);
			super.render(renderRequest, renderResponse);
		}catch(Exception e) {
			System.out.println("Exception occurred");
		}
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		CalendarBooking cb = null;
		JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
		JSONObject evAttObj,faqAttObj,speakerAttObj,itemAttObj,timelineObj,timelineObj1,badgeAttObj,editorAttObj,reviewerAttObj = null;
		Connection con = null;
		Statement st = null;
		String keyFAQs ,keySpeakers, keyItems,keyAttributes,keyTimeline,keyBadge,keyEditors,keyReviewers,keyEvntRev= "";
		String sqlStatement = "";
		String command = resourceRequest.getParameter("command");
		String calendarBookingId = resourceRequest.getParameter("calendarBookingId");
		String eventAttributes   = resourceRequest.getParameter("eventAttributes");
		String faqAttributes   = resourceRequest.getParameter("faqAttributes");
		String speakersAttributes   = resourceRequest.getParameter("speakersAttributes");
		String editorsAttributes   = resourceRequest.getParameter("editorsAttributes");
		String reviewersAttributes   = resourceRequest.getParameter("reviewersAttributes");
		String jsonStrItem   = resourceRequest.getParameter("jsonStrItem");
		String jsonStrtimeline   = resourceRequest.getParameter("jsonStrtimeline");
		String jsonidBadge   = resourceRequest.getParameter("jsonidBadge");
		
		System.out.println("command ==== " + command);
		System.out.println("calendarBookingId ==== " + calendarBookingId);
		
		if(Validator.isNotNull(command) && command.equals("doInsert"))
		{
			try 
			{
				con = DataAccess.getConnection();
			    st = con.createStatement();
			    System.out.println("jsonStrtimeline jsonStrtimeline "+jsonStrtimeline);
				if(jsonStrtimeline != null && !jsonStrtimeline.equals("") && !jsonStrtimeline.equals("]"))
				{
					JSONArray timelineAttArr = JSONFactoryUtil.createJSONArray(jsonStrtimeline);
					for(int i = 0; i < timelineAttArr.length(); i++) {
						timelineObj = timelineAttArr.getJSONObject(i);
						
						JSONArray timelinesArr = timelineObj.getJSONArray("timelines");
						System.out.println("nb === " + timelinesArr.length());
						for(int j = 0; j < timelinesArr.length(); j++) {
							timelineObj1 = timelinesArr.getJSONObject(j);

							sqlStatement = "insert into EventTimeline (id_,title,description,descriptionAr,eventstartday,eventendday,eventid) " 
								 + "select  coalesce(max(id_), 0)+1, '"+timelineObj.get("timelineType")+"','"
							     + timelineObj1.get("timelineDescription")+"','"
							     + timelineObj1.get("timelineDescriptionAr")
							     + "','" +timelineObj1.get("fromTime")+"','"+timelineObj1.get("toTime")
							     + "', "+calendarBookingId+" from EventTimeline";
							System.out.println("*************sqlStatement "+sqlStatement);
							 st.execute(sqlStatement);
						}
						con.close();
						st.close();
					}
				}
				
				if(eventAttributes != null && !eventAttributes.equals("") && !eventAttributes.equals("]"))
				{
					JSONArray eventAttArr = JSONFactoryUtil.createJSONArray(eventAttributes);
					System.out.println("eventAttArr ==== " + eventAttArr.length());
					for(int i = 0; i < eventAttArr.length(); i++) {
						evAttObj = eventAttArr.getJSONObject(i);
						
						sqlStatement = "insert into EventAttributes (id_,attributenumber,attributename,eventid) " 
									 + "select  coalesce(max(id_), 0)+1, '"+evAttObj.get("eventNumber")+"','"
									 +  evAttObj.get("eventName") +"', "+calendarBookingId+" from EventAttributes";
					
						st.execute(sqlStatement);
						con.close();
						st.close();
					}
				}
				
				if(faqAttributes!= null && !faqAttributes.equals("") && !faqAttributes.equals("]"))
				{
					faqAttributes = "[{" + URLEncoder.encode( faqAttributes, "UTF-8" ).replaceAll("%3A", ":").replaceAll("%22", "\"").replaceAll("%2C", ",")+ "}]";
					System.out.println("faqAttributes === " + faqAttributes);
					JSONArray faqArr = JSONFactoryUtil.createJSONArray(faqAttributes );
					for(int i = 0; i < faqArr.length(); i++) {
						faqAttObj = faqArr.getJSONObject(i);
						
						sqlStatement = "insert into EventFAQs (id_,question,questionAr,answer,answerAr,eventid) " 
//									 + "select  "+faqAttObj.get("key") +", '"+faqAttObj.get("question")+"','"
									 + "select  coalesce(max(id_), 0)+1, '"+URLDecoder.decode( faqAttObj.get("question")+"", "UTF-8" )+"','"
									 + URLDecoder.decode( faqAttObj.get("questionAr")+"", "UTF-8" )+"','"
									 + URLDecoder.decode( faqAttObj.get("response")+"", "UTF-8" )+"','"
									 + URLDecoder.decode( faqAttObj.get("responseAr")+"", "UTF-8" )+"', "
									 +calendarBookingId+" from EventFAQs";
						
						 st.execute(sqlStatement);
						 con.close();
						 st.close();
					}
				}
				if(speakersAttributes!= null && !speakersAttributes.equals("") && !speakersAttributes.equals("]"))
				{
					JSONArray speakersArr = JSONFactoryUtil.createJSONArray(speakersAttributes);
					for(int i = 0; i < speakersArr.length(); i++) {
						speakerAttObj = speakersArr.getJSONObject(i);
						System.out.println("userkey ==== "  + speakersArr);
						
//						sqlStatement = "insert into EventSpeakers (id_,position,userid,speakerimage,email,firstname,lastname,eventid,isNotificationSent,isNotifEnabled) " 
						sqlStatement = "insert into EventSpeakers (id_,position,userid,speakerimage,email,firstname,lastname,eventid,isNotificationSent,isNotifEnabled,nationality,speakerOrder) " 
								+ "select "+speakerAttObj.get("key")+",jobTitle,"+speakerAttObj.get("userId")+","
//								+ "select (select  coalesce(max(id_), 0)+1 from EventSpeakers ),jobTitle,"+speakerAttObj.get("userId")+","
								+ "'"+speakerAttObj.get("imgSpeakerBase64")+"',emailAddress,firstName,lastName," + calendarBookingId + ",'0','" + speakerAttObj.get("isNotifEnabled")+ "',"
								+ "(select data_ from ExpandoValue where columnId = (select columnId from ExpandoColumn where lower(name) = 'nationality') and classPK = "+ speakerAttObj.get("userId") +"), "
								+ speakerAttObj.get("speakerOrder")
//								+ "'"+speakerAttObj.get("imgSpeakerBase64")+"',emailAddress,firstName,lastName," + calendarBookingId + ",'0','" + speakerAttObj.get("isNotifEnabled")+ "'"
								+ " from User_ where userid =  " + speakerAttObj.get("userId") ;
						
						st.execute(sqlStatement);
						con.close();
						st.close();
					}
				}
				if(editorsAttributes!= null && !editorsAttributes.equals("") && !editorsAttributes.equals("]"))
				{
					JSONArray editorsArr = JSONFactoryUtil.createJSONArray(editorsAttributes);
					for(int i = 0; i < editorsArr.length(); i++) {
						editorAttObj = editorsArr.getJSONObject(i);
						
						sqlStatement = "insert into EventEditors (id_,position,userid,editorimage,email,firstname,lastname,eventid,isNotificationSent,isNotifEnabled,nationality) " 
								+ "select "+editorAttObj.get("key")+",jobTitle,"+editorAttObj.get("userId")+","
								+ "'"+editorAttObj.get("imgEditorBase64")+"',emailAddress,firstName,lastName," + calendarBookingId + ",'0','" + editorAttObj.get("isNotifEditorEnabled")+ "',"
								+ "(select data_ from ExpandoValue where columnId = (select columnId from ExpandoColumn where lower(name) = 'nationality') and classPK = "+ editorAttObj.get("userId") +") "
								+ " from User_ where userid =  " + editorAttObj.get("userId") ;
						System.out.println("editor insert ==== " + sqlStatement);
						
						st.execute(sqlStatement);
						con.close();
						st.close();
						
						User usr = UserLocalServiceUtil.getUser(Long.parseLong(editorAttObj.getString("userId")));
						RoleLocalServiceUtil.addUserRole(Long.parseLong(editorAttObj.getString("userId")), 
								RoleLocalServiceUtil.getRole(20101, "EventEditor").getRoleId());
						UserLocalServiceUtil.updateUser(usr);
					}
				}
				if(reviewersAttributes!= null && !reviewersAttributes.equals("") && !reviewersAttributes.equals("]"))
				{
					JSONArray reviewersArr = JSONFactoryUtil.createJSONArray(reviewersAttributes);
					for(int i = 0; i < reviewersArr.length(); i++) {
						reviewerAttObj = reviewersArr.getJSONObject(i);
						
						sqlStatement = "insert into EventReviewers (id_,position,userid,reviewerimage,email,firstname,lastname,eventid,isNotificationSent,nationality) " 
								+ "select "+reviewerAttObj.get("key")+",jobTitle,"+reviewerAttObj.get("userId")+","
								+ "'"+reviewerAttObj.get("imgReviewerBase64")+"',emailAddress,firstName,lastName," + calendarBookingId + ",'0', "
								+ "(select data_ from ExpandoValue where columnId = (select columnId from ExpandoColumn where lower(name) = 'nationality') and classPK = "+ reviewerAttObj.get("userId") +") "
								+ " from User_ where userid =  " + reviewerAttObj.get("userId") ;
						System.out.println("reviewer insert ==== " + sqlStatement);
						
						st.execute(sqlStatement);
						con.close();
						st.close();
						
						User usr = UserLocalServiceUtil.getUser(Long.parseLong(reviewerAttObj.getString("userId")));
						RoleLocalServiceUtil.addUserRole(Long.parseLong(reviewerAttObj.getString("userId")), 
								RoleLocalServiceUtil.getRole(20101, "EventEditor").getRoleId());
						UserLocalServiceUtil.updateUser(usr);
					}
				}
				if(jsonidBadge!= null && !jsonidBadge.equals("") && !jsonidBadge.equals("]"))
				{
					JSONArray badgesArr = JSONFactoryUtil.createJSONArray(jsonidBadge);
					for(int i = 0; i < badgesArr.length(); i++) {
						badgeAttObj = badgesArr.getJSONObject(i);
						sqlStatement = "delete from eventsBadgeImg where eventId = " + calendarBookingId;
						st.execute(sqlStatement);
						
						sqlStatement = "insert into eventsBadgeImg (id_,eventId,badgeImage) " 
								+ "select (select  coalesce(max(id_), 0)+1 from eventsBadgeImg ),"+ calendarBookingId +","
								+ "'"+badgeAttObj.get("imgBadgeBase64")+"' from dual " ;
						
						st.execute(sqlStatement);
						con.close();
						st.close();
					}
				}
				if(jsonStrItem!= null && !jsonStrItem.equals("") && !jsonStrItem.equals("]"))
				{
					JSONArray itemsArr = JSONFactoryUtil.createJSONArray(jsonStrItem);
					for(int i = 0; i < itemsArr.length(); i++) {
						itemAttObj = itemsArr.getJSONObject(i);
						
						sqlStatement = "insert into EventHighLights (id_, title, titleAr, description, descriptionAr,image, eventid) " 
									 + "select  coalesce(max(id_), 0)+1, '"+itemAttObj.get("title")+"','"
								     + itemAttObj.get("titleAr")+"', '"+itemAttObj.get("description")+"','"
								     + itemAttObj.get("descriptionAr")+"', '"+itemAttObj.get("imgItemBase64")+"',"
									 +calendarBookingId+" from EventHighLights";
						System.out.println("sqlStatement === " + sqlStatement);
						st.execute(sqlStatement);
						con.close();
						st.close();
					}
				}
//				printout.print(cb);
			} 
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		else if(command.equals("fillData")){
			try 
			{
				JSONObject json = JSONFactoryUtil.createJSONObject();
				
				sqlStatement = " select (select coalesce(max(id_), 0) from EventFAQs) as keyFAQs,"
						     + " (select coalesce(max(id_), 0) from EventSpeakers) as keySpeakers,"
						     + " (select coalesce(max(id_), 0) from EventEditors) as keyEditors,"
						     + " (select coalesce(max(id_), 0) from EventReviewers) as keyReviewers,"
						     + " (select count(1) from EventReviewers where eventId = "+ calendarBookingId +") as keyEvntRev,"
						     + " (select coalesce(max(id_), 0) from EventHighLights) as keyItems,"
						     + " (select coalesce(max(id_), 0) from EventAttributes) as keyAttributes,"
						     + " (select coalesce(max(id_), 0) from EventTimeline) as keyTimeline,"
						     + " (select coalesce(max(id_), 0) from eventsBadgeImg) as keyBadge"
						     + " from dual";
				con = DataAccess.getConnection();
				st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlStatement);
				
				while (rs.next()) 
				{
					keyFAQs = rs.getString("keyFAQs");
					keySpeakers = rs.getString("keySpeakers");
					keyEditors = rs.getString("keyEditors");
					keyReviewers = rs.getString("keyReviewers");
					keyEvntRev = rs.getString("keyEvntRev");
					keyItems = rs.getString("keyItems");
					keyAttributes = rs.getString("keyAttributes");
					keyTimeline = rs.getString("keyTimeline");
					keyBadge = rs.getString("keyBadge");
		            json.put("keyFAQs", keyFAQs);
		            json.put("keySpeakers", keySpeakers);
		            json.put("keyEditors", keyEditors);
		            json.put("keyReviewers", keyReviewers);
		            json.put("keyEvntRev", keyEvntRev);
		            json.put("keyItems", keyItems);
		            json.put("keyAttributes", keyAttributes);
		            json.put("keyTimeline", keyTimeline);
		            json.put("keyBadge", keyBadge);
				}
				
				QuestionsAndAnswers qaVO = null;
				List<QuestionsAndAnswers> questionsAndAnswersList = new ArrayList<QuestionsAndAnswers>();
				sqlStatement = "select id_,Question, QuestionAr, Answer, AnswerAr from EventFAQs"
						     + " where eventId = " + calendarBookingId;
				
				rs = st.executeQuery(sqlStatement);
				while (rs.next()) 
				{
					qaVO = new QuestionsAndAnswers();
					qaVO.setQuestion(rs.getString("Question"));
					qaVO.setQuestionAr(rs.getString("QuestionAr"));
					qaVO.setAnswer(rs.getString("Answer"));
					qaVO.setAnswerAr(rs.getString("AnswerAr"));
					qaVO.setId(rs.getString("id_"));
					questionsAndAnswersList.add(qaVO);
				}
				json.put("faqList", questionsAndAnswersList);
				System.out.println("questionsAndAnswersList === " + questionsAndAnswersList.size());
				
				sqlStatement = "select id_ ,title , titleAr, description, descriptionAr, image from EventHighLights "
						+ " where eventId = " + calendarBookingId;
				rs = st.executeQuery(sqlStatement);
				HighLightsVO hlVO = null;
				List<HighLightsVO> highLightsList = new ArrayList<HighLightsVO>();
				while (rs.next()) 
				{
					hlVO = new HighLightsVO();
					hlVO.setId(rs.getString("id_"));
					hlVO.setTitle(rs.getString("title"));
					hlVO.setTitleAr(rs.getString("titleAr"));
					hlVO.setDescription(rs.getString("description"));
					hlVO.setDescriptionAr(rs.getString("descriptionAr"));
					hlVO.setImage(rs.getBlob("Image"));
					highLightsList.add(hlVO);
				}
				json.put("itemsList", highLightsList);
				System.out.println("itemsList === " + highLightsList.size());
				
				sqlStatement = "select id_ ,attributenumber , attributename from EventAttributes "
						+ " where eventId = " + calendarBookingId;
				rs = st.executeQuery(sqlStatement);
				AttributesVO attrVO = null;
				List<AttributesVO> attributesList = new ArrayList<AttributesVO>();
				while (rs.next()) 
				{
					attrVO = new AttributesVO();
					attrVO.setId(rs.getString("id_"));
					attrVO.setAttributeNumber(rs.getString("attributenumber"));
					attrVO.setAttributeName(rs.getString("attributename"));
					attributesList.add(attrVO);
				}
				json.put("attributesList", attributesList);
				System.out.println("attributesList === " + attributesList.size());
				
				sqlStatement = "select id_ ,firstname, lastname,email,position,(select image from profileImage pi where pi.userid = es.userid ) image, "
						+ " userId, isNotifEnabled notif , speakerOrder sorder "
						+ " from EventSpeakers es where eventId = " + calendarBookingId;
				System.out.println("sqlStatement === 0 " + sqlStatement);
				rs = st.executeQuery(sqlStatement);
				UserVO userVO = null;
				List<UserVO> usersList = new ArrayList<UserVO>();
				String isNotifEnabled = "0";
				String speakerOrder = "0";
				while (rs.next()) 
				{
					isNotifEnabled = "0";
					speakerOrder = "0";
					userVO = new UserVO();
					userVO.setUserId(rs.getString("id_"));
					userVO.setFirstName(rs.getString("firstname"));
					userVO.setLastName(rs.getString("lastname"));
					userVO.setImage(rs.getString("image"));
					userVO.setEmail(rs.getString("email"));
					userVO.setPosition(rs.getString("position"));
					userVO.setSpeakerId(rs.getString("userId"));
					if(rs.getString("notif")!= null && !"".equals(rs.getString("notif")) && !"null".equals(rs.getString("notif")))
						isNotifEnabled = rs.getString("notif");
					if(rs.getString("sorder")!= null && !"".equals(rs.getString("sorder")) && !"null".equals(rs.getString("sorder")))
						speakerOrder = rs.getString("sorder");
					
					userVO.setIsNotifEnabled(isNotifEnabled);
					userVO.setSpeakerOrder(speakerOrder);
					usersList.add(userVO);
				}       
				json.put("usersList", usersList);
				System.out.println("usersList === " + usersList.size());
				
				sqlStatement = "select id_ ,firstname, lastname,email,position,(select image from profileImage pi where pi.userid = es.userid ) image "
						+ " from EventEditors es where eventId = " + calendarBookingId;
				rs = st.executeQuery(sqlStatement);
				UserVO editorVO = null;
				List<UserVO> editorList = new ArrayList<UserVO>();
				while (rs.next()) 
				{
					editorVO = new UserVO();
					editorVO.setUserId(rs.getString("id_"));
					editorVO.setFirstName(rs.getString("firstname"));
					editorVO.setLastName(rs.getString("lastname"));
					editorVO.setImage(rs.getString("image"));
					editorVO.setEmail(rs.getString("email"));
					editorVO.setPosition(rs.getString("position"));
					editorList.add(editorVO);
				}       
				json.put("editorList", editorList);
				System.out.println("editorList === " + editorList.size());
				
				sqlStatement = "select id_ ,firstname, lastname,email,position,(select image from profileImage pi where pi.userid = es.userid ) image "
						+ " from EventReviewers es where eventId = " + calendarBookingId;
				rs = st.executeQuery(sqlStatement);
				UserVO reviewerVO = null;
				List<UserVO> reviewerList = new ArrayList<UserVO>();
				while (rs.next()) 
				{
					reviewerVO = new UserVO();
					reviewerVO.setUserId(rs.getString("id_"));
					reviewerVO.setFirstName(rs.getString("firstname"));
					reviewerVO.setLastName(rs.getString("lastname"));
					reviewerVO.setImage(rs.getString("image"));
					reviewerVO.setEmail(rs.getString("email"));
					reviewerVO.setPosition(rs.getString("position"));
					reviewerList.add(reviewerVO);
				}       
				json.put("reviewerList", reviewerList);
				System.out.println("reviewerList === " + reviewerList.size());
				
				sqlStatement = "select id_ ,badgeImage image "
						+ " from eventsBadgeImg es where eventId = " + calendarBookingId;
				System.out.println("sqlStatement ==sss= " + sqlStatement);
				rs = st.executeQuery(sqlStatement);
				UserVO badgeVO = null;
				List<UserVO> badgeList = new ArrayList<UserVO>();
				while (rs.next()) 
				{
					badgeVO = new UserVO();
					badgeVO.setUserId(rs.getString("id_"));
					badgeVO.setImage(rs.getString("image"));
					badgeList.add(badgeVO);
				}       
				json.put("badgeList", badgeList);
				System.out.println("badgeList === " + badgeList.size());
				
				sqlStatement = "select id_,title,description,descriptionAr,eventstartday,eventendday "
						+ " from EventTimeline es where eventId = " + calendarBookingId;
				rs = st.executeQuery(sqlStatement);
				TimelineVO timelineVO = null;
				List<TimelineVO> timelineList = new ArrayList<TimelineVO>();
				while (rs.next()) 
				{
					timelineVO = new TimelineVO();
					timelineVO.setId(rs.getString("id_"));
					timelineVO.setTitle(rs.getString("title"));
					timelineVO.setDescription(rs.getString("description"));
					timelineVO.setDescriptionAr(rs.getString("descriptionAr"));
					timelineVO.setEventstartday(rs.getString("eventstartday"));
					timelineVO.setEventendday(rs.getString("eventendday"));
					timelineList.add(timelineVO);
				}
				json.put("timelineList", timelineList);
				System.out.println("timelineList === " + timelineList.size());
				
				con.close();
				st.close();
				PrintWriter printout = resourceResponse.getWriter();
				jsonArr.put(json);
				printout.print(jsonArr);
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		else if(command.equals("deleteItems") || command.equals("deleteAttributes") 
				|| command.equals("deleteSpeaker") ||command.equals("deleteFAQ") || command.equals("deleteTimeline")
				|| command.equals("deleteBadge") || command.equals("deleteEditor") || command.equals("deleteReviewer"))
		{
			String tableName = "";
			System.out.println("command ==== " + command);
			if(command.equals("deleteFAQ"))
				tableName = "EventFAQs";
			else if(command.equals("deleteItems"))
				tableName = "EventHighLights";
			else if(command.equals("deleteAttributes"))
				tableName = "EventAttributes";
			else if(command.equals("deleteSpeaker"))
				tableName = "EventSpeakers";
			else if(command.equals("deleteTimeline"))
				tableName = "EventTimeline";
			else if(command.equals("deleteBadge"))
				tableName = "eventsBadgeImg";
			else if(command.equals("deleteEditor"))
				tableName = "EventEditors";
			else if(command.equals("deleteReviewer"))
				tableName = "EventReviewers";
				
			try 
			{
				con = DataAccess.getConnection();
				st = con.createStatement();
				sqlStatement = "delete from "+ tableName +" where id_ ="+ faqAttributes + " and eventid = " + calendarBookingId;
				System.out.println("deleteTimeline === " + sqlStatement);
				st.execute(sqlStatement);
				con.close();
				st.close();
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		else if(command.equals("updateEvent"))
		{
			if(eventAttributes != null && !eventAttributes.equals("") && !eventAttributes.equals("]"))
			{
				try 
				{
					eventAttributes = "[{" + URLEncoder.encode( eventAttributes, "UTF-8" ).replaceAll("%3A", ":").replaceAll("%22", "\"").replaceAll("%2C", ",")+ "}]";
					JSONArray eventAttArr = JSONFactoryUtil.createJSONArray(eventAttributes);
					evAttObj = eventAttArr.getJSONObject(0);
					System.out.println("calendarBookingId ==== " + calendarBookingId);
					System.out.println("eventDescription ==== " + URLDecoder.decode(evAttObj.get("eventDescription")+"","UTF-8"));

					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
					Date fromDate = dateFormat.parse(URLDecoder.decode( evAttObj.get("from")+"", "UTF-8" ));
					Date toDate = dateFormat.parse(URLDecoder.decode( evAttObj.get("to")+"", "UTF-8" ));
					String subjectStr = URLDecoder.decode( evAttObj.get("subject")+"", "UTF-8" );
					
					CalendarBooking ca = CalendarBookingLocalServiceUtil.getCalendarBooking(Long.parseLong(calendarBookingId));
					
					String eventDesc = "";
					String eventDescAr = "";
					
					if(evAttObj.get("eventDescription") != null && !"".equals(evAttObj.get("eventDescription")+"") && !"null".equals(evAttObj.get("eventDescription")+"")) {
						String eventDescription = URLDecoder.decode(evAttObj.get("eventDescription")+"","UTF-8");
						eventDesc = eventDescription;
					}else {
						eventDesc = ca.getDescription(new Locale("en_US"));
					}
					if(evAttObj.get("eventDescriptionAr") != null && !"".equals(evAttObj.get("eventDescriptionAr")+"") && !"null".equals(evAttObj.get("eventDescriptionAr")+"")) {
						String eventDescription = URLDecoder.decode(evAttObj.get("eventDescriptionAr")+"","UTF-8");
						eventDescAr = eventDescription;
					}else {
						eventDescAr = ca.getDescription(new Locale("ar_SA"));
					}
					String eventTitleAr = "";

					if(evAttObj.get("subjectAr") != null && !"".equals(evAttObj.get("subjectAr")+"") && !"null".equals(evAttObj.get("subjectAr")+"")) {
						String subjectAr = URLDecoder.decode(evAttObj.get("subjectAr")+"","UTF-8");
						eventTitleAr = subjectAr;
					}else {
						eventTitleAr = ca.getTitle(new Locale("ar_SA"));
					}
					
					ca.setTitle("");
					ca.setDescription(""); 
					CalendarBookingLocalServiceUtil.updateCalendarBooking(ca);
					
					ca.setTitle(subjectStr, new Locale("en_US"));
					ca.setTitle(eventTitleAr, new Locale("ar_SA"));
					
					ca.setDescription(eventDesc, new Locale("en_US"));
					ca.setDescription(eventDescAr, new Locale("ar_SA"));
					
					
					ca.setStartTime(fromDate.getTime());
					ca.setEndTime(toDate.getTime());
					if(evAttObj.get("eventLocation") != null && !"null".equals(evAttObj.get("eventLocation")) &&  !"".equals(evAttObj.get("eventLocation")))
					{
						String eventLocationStr = URLDecoder.decode( evAttObj.get("eventLocation")+"", "UTF-8" );
						ca.setLocation(eventLocationStr);
					}
					ExpandoBridge expandoBridge = ca.getExpandoBridge();
					System.out.println(" ---------------------- awala ----------------------------");
					if(evAttObj.get("eventLocationAr") != null && !"null".equals(evAttObj.get("eventLocationAr")) &&  !"".equals(evAttObj.get("eventLocationAr")))
					{
						String LocationAr = URLDecoder.decode( evAttObj.get("eventLocationAr")+"", "UTF-8" );
						System.out.println(" ---------------------- nossa ----------------------------"+LocationAr);
						expandoBridge.setAttribute("locationAr", LocationAr);
					}
					System.out.println(" ---------------------- ekhera ----------------------------");
					if(evAttObj.get("image") != null && !"null".equals(evAttObj.get("image")) &&  !"".equals(evAttObj.get("image")))
					{
						expandoBridge.setAttribute("UploadImageId", URLDecoder.decode( evAttObj.get("image")+"", "UTF-8" ));
//						ca.setExpandoBridgeAttributes(expandoBridge);
					}
					if(evAttObj.get("pitch") != null && !"null".equals(evAttObj.get("pitch")) &&  !"".equals(evAttObj.get("pitch")))
					{
						String pitchStr = URLDecoder.decode( evAttObj.get("pitch")+"", "UTF-8" );
						expandoBridge.setAttribute("pitch", pitchStr);
					}
					if(evAttObj.get("pitchAr") != null && !"null".equals(evAttObj.get("pitchAr")) &&  !"".equals(evAttObj.get("pitchAr")))
					{
						String pitchStr = URLDecoder.decode( evAttObj.get("pitchAr")+"", "UTF-8" );
						expandoBridge.setAttribute("pitchAr", pitchStr);
					}
					if(evAttObj.get("deadline") != null && !"null".equals(evAttObj.get("deadline")) &&  !"".equals(evAttObj.get("deadline")))
					{
						String deadlineStr = URLDecoder.decode( evAttObj.get("deadline")+"", "UTF-8" );
						expandoBridge.setAttribute("RegistrationDeadline", deadlineStr);
					}
					if(evAttObj.get("eventLocationLink") != null && !"null".equals(evAttObj.get("eventLocationLink")) &&  !"".equals(evAttObj.get("eventLocationLink")))
					{
						String eventLocationLinkStr = URLDecoder.decode( evAttObj.get("eventLocationLink")+"", "UTF-8" );
						expandoBridge.setAttribute("Location link", eventLocationLinkStr);
					}
					if(evAttObj.get("showOnLandUp") != null && !"null".equals(evAttObj.get("showOnLandUp")) &&  !"".equals(evAttObj.get("showOnLandUp")))
					{
						String showOnLandUpStr = URLDecoder.decode( evAttObj.get("showOnLandUp")+"", "UTF-8" );
						expandoBridge.setAttribute("show on landing", showOnLandUpStr);
					}
					if(evAttObj.get("eventType") != null && !"null".equals(evAttObj.get("eventType")) &&  !"".equals(evAttObj.get("eventType")))
					{
						String eventTypeStr = URLDecoder.decode( evAttObj.get("eventType")+"", "UTF-8" );
						expandoBridge.setAttribute("Event Types", eventTypeStr);
					}

					CalendarBookingLocalServiceUtil.updateCalendarBooking(ca);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		else if(command.equals("updateSpeaker"))
		{
			if(speakersAttributes!= null && !speakersAttributes.equals("") && !speakersAttributes.equals("]"))
			{
				JSONArray speakersArr;
				
				try {
					con = DataAccess.getConnection();
				    st = con.createStatement();
					speakersArr = JSONFactoryUtil.createJSONArray(speakersAttributes);
					System.out.println("speakersArr ==== " + speakersArr);
					for(int i = 0; i < speakersArr.length(); i++) {
						speakerAttObj = speakersArr.getJSONObject(i);
						System.out.println("imgSpeakerBase64======" + speakerAttObj.get("imgSpeakerBase64"));
						System.out.println("imgSpeakerBase64===key===" + speakerAttObj.get("key"));
						
						sqlStatement = "update EventSpeakers set isNotifEnabled = '" + speakerAttObj.get("isNotifEnabled")+ "'";
						if(speakerAttObj.get("imgSpeakerBase64") != null && !"".equals(speakerAttObj.get("imgSpeakerBase64")) && !"null".equals(speakerAttObj.get("imgSpeakerBase64")))
							sqlStatement += " ,speakerimage = '"+speakerAttObj.get("imgSpeakerBase64")+"'";
						if(speakerAttObj.get("speakerOrder") != null && !"".equals(speakerAttObj.get("speakerOrder")) && !"null".equals(speakerAttObj.get("speakerOrder")))
							sqlStatement += " ,speakerOrder = "+speakerAttObj.get("speakerOrder");
						
						sqlStatement += " where id_ = " + speakerAttObj.get("key");
						System.out.println("update speaker ==== " +sqlStatement );
						st.execute(sqlStatement);
						con.close();
						st.close();
						
					}
				} 
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		super.serveResource(resourceRequest, resourceResponse);
	}
}