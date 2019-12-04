package landing.page.portlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import basic.model.formeventusertable;
import landing.page.constants.LandingPagePortletKeys;
import landing.page.portlet.vo.EventTimeDescripiton;
import landing.page.portlet.vo.HighLightsVO;
import landing.page.portlet.vo.QuestionsAndAnswers;
import landing.page.portlet.vo.SpeakerNVO;
import landing.page.portlet.vo.SpeakerVO;
import landing.page.portlet.vo.TimeLineVO;
import landing.page.portlet.vo.TimeLinedayObject;

/**
 * @author jsa
 */    
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=LandingPage", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + LandingPagePortletKeys.LANDINGPAGE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class LandingPagePortlet extends MVCPortlet {

	/*
	 * @Override public void doView(RenderRequest renderRequest, RenderResponse
	 * renderResponse) throws IOException, PortletException {
	 * 
	 * String pageParam = renderRequest.getParameter("pageParam");
	 * 
	 * if(pageParam != null){ include(renderRequest, renderResponse,pageParam);
	 * }else{ super.doView(renderRequest, renderResponse); } }
	 */

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		/*
		 * ThemeDisplay themeDisplay = (ThemeDisplay)
		 * renderRequest.getAttribute(WebKeys.THEME_DISPLAY); long loggedInUserId =
		 * themeDisplay.getUserId(); Long groupId =
		 * themeDisplay.getLayout().getGroupId(); try {
		 * System.out.println("-----landing----"+loggedInUserId);
		 * System.out.println("-----landing----: "+groupId);
		 * if(themeDisplay.isSignedIn()) {
		 * System.out.println(UserLocalServiceUtil.getUser(loggedInUserId).getRoles().
		 * size());
		 * System.out.println(UserLocalServiceUtil.getUser(loggedInUserId).getRoles().
		 * get(0).getName());
		 * System.out.println(UserLocalServiceUtil.getUser(loggedInUserId).getRoles().
		 * get(1).getName()); } } catch(Exception ex) { ex.printStackTrace(); }
		 */
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
	}

	public boolean checkIfUserAlreadyAppliedForTheEvent(String userId, String calendarBookingId)
	{
		boolean isApplied = false;
		Connection con = null;
		Statement st = null;
		 System.out.println("---checkIfUserAlreadyAppliedForTheEvent------");
		try
		{
			
			con = DataAccess.getConnection();
			st = con.createStatement();
			List<formeventusertable> formUserSubmissionList = null;
			//Code changes for the reviewer Comments start
			String sqlStatement = "select count(1) cnt"
					+              " from  formeventusertable ft "
					+ "              where  userId = "+userId +
					                 " and eventId = "+calendarBookingId ;
			//Code changes for the reviewer Comments end
			System.out.println("---checkIfUserAlreadyAppliedForTheEvent------sqlstat: "+sqlStatement);
			ResultSet rs = st.executeQuery(sqlStatement);
			while (rs.next()) 
			{
				
				 String count = rs.getString("cnt");
				 System.out.println("checkIfUserAlreadyAppliedForTheEvent:: "+count);
				 if(Integer.parseInt(count)>0)
				 {
					 isApplied = true;
				 }
			}
		}
		catch(Exception ex)
		{
			isApplied = false;
			ex.printStackTrace();
		}
		finally
		{
			DataAccess.cleanUp(con);
		}
		
		return isApplied;
	}
	

	public boolean checkIfUserIsSpeaker(String userId, String calendarBookingId)
	{
		boolean isSpeaker = false;
		Connection con = null;
		Statement st = null;
		int cnt = 0;
		System.out.println("---checkIfUserHasBadge------");
		try
		{
			con = DataAccess.getConnection();
			st = con.createStatement();

			String sqlStatement = "select 1 as cnt from EventSpeakers es where es.userid = "+userId;

			System.out.println("---checkIfUserIsSpeaker------sqlstat: "+sqlStatement);
			ResultSet rs = st.executeQuery(sqlStatement);
			while (rs.next()) 
			{
				 cnt = rs.getInt("cnt");
				 isSpeaker = true;
			}
			DataAccess.cleanUp(con,st,rs);
		}
		catch(Exception ex)
		{
			isSpeaker = false;
			DataAccess.cleanUp(con,st);
			ex.printStackTrace();
		}
		finally
		{
			DataAccess.cleanUp(con,st);
		}
		return isSpeaker;
	}
	
	public boolean checkIfUserHasBadge(String userId, String calendarBookingId)
	{
		boolean hasBadge = false;
		Connection con = null;
		Statement st = null;
		int cnt = 0;
		System.out.println("---checkIfUserHasBadge------");
		try
		{
			con = DataAccess.getConnection();
			st = con.createStatement();

			String sqlStatement = "select (tbl.col1  + tbl.col2 + tbl.col3 + tbl.col4) cnt from " + 
					"(select (case when (firstName is not null and fatherName is not null and familyName is not null) then 1 else 0 end ) col1, " + 
					"(case when email is not null then 1 else 0 end) col2 , " + 
					"(case when primaryMobileNo is not null then 1 else 0 end) col3, " + 
					"(case when dateOfBirth is not null then 1 else 0 end) col4 " + 
					"from profileInfo pi where pi.userid = "+userId +
					" and not exists (select 1 from EventSpeakers es where es.userid = "+userId+")" +
					") tbl " ;

			System.out.println("---checkIfUserHasBadge------sqlstat: "+sqlStatement);
			ResultSet rs = st.executeQuery(sqlStatement);
			while (rs.next()) 
			{
				 cnt = rs.getInt("cnt");
				 System.out.println("checkIfUserHasBadge:: "+cnt);
				 if(cnt == 4)
				 {
					 hasBadge = true;
				 }
			}
			DataAccess.cleanUp(con,st,rs);
		}
		catch(Exception ex)
		{
			hasBadge = false;
			DataAccess.cleanUp(con,st);
			ex.printStackTrace();
		}
		finally
		{
			DataAccess.cleanUp(con,st);
		}
		return hasBadge;
	}
	
	public int getFormAssociatedToTheEvent(int calendarBookingId) {
		int i = 0;
		System.out.println("getFormAssociatedToTheEvent:: calendarBookingId:: " + calendarBookingId);
		java.sql.Connection con = null;
		java.sql.Statement st = null;
		String data_ = "";
		InputStream in = null;
		int BUFFER_SIZE = 1024;
		StringBuffer buffer = new StringBuffer();
		int fromId = 0;
		int numRead;
		byte[] arr = new byte[BUFFER_SIZE];
		try {
			/*
			 * System.out.println("---- getImageBybookingEvent --- "); con =
			 * DataAccess.getConnection(); st = con.createStatement(); String columnId ="";
			 * data_ = ""; String sqlStatement =
			 * "select columnId from expandocolumn where name = 'FormId'";
			 * java.sql.ResultSet rs = st.executeQuery(sqlStatement); while (rs.next()) {
			 * columnId = rs.getString("columnId"); } sqlStatement =
			 * "select data_ from expandovalue " + " where classNameId = '25802' " +
			 * "  and classPk = "+String.valueOf(calendarBookingId)+" and columnId = "
			 * +35954columnId; System.out.println("sqlStatement:: "+sqlStatement); rs =
			 * st.executeQuery(sqlStatement); while (rs.next()) { fromId =
			 * Integer.parseInt(rs.getString("data_")); }
			 */

			//Calendar calendar = CalendarLocalServiceUtil.fetchGroupCalendar(themeDisplay.getCompanyId(),themeDisplay.getSiteGroupId(), "Liferay");
			//System.out.println("claendarID" + calendar.getCalendarId());
			
			if (CalendarBookingLocalServiceUtil.getCalendarBooking(calendarBookingId) != null
					&& CalendarBookingLocalServiceUtil.getCalendarBooking(calendarBookingId).getExpandoBridge() != null
					&& CalendarBookingLocalServiceUtil.getCalendarBooking(calendarBookingId).getExpandoBridge()
							.getAttribute("formId") != null)
				i = Integer.parseInt((String) CalendarBookingLocalServiceUtil.getCalendarBooking(calendarBookingId)
						.getExpandoBridge().getAttribute("FormId"));
			
			System.out.println("getFormAssociatedToTheEvent before return FORMID: " + i);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return /* fromId */ i;
	}

	public List<CalendarBooking> getCalendarBooking(RenderRequest renderRequest,String start,String end) {
		List<CalendarBooking> cbLst = new ArrayList<CalendarBooking>();
		List<CalendarBooking> cbLstToAdd = new ArrayList<CalendarBooking>();
		/*
		 * String start = (String) (renderRequest.getAttribute("start")); String end =
		 * (String) (renderRequest.getAttribute("end"));
		 */
		if(start == null)
			return cbLst;
		System.out.println("start:: "+start);
		String searchValue = (String) (renderRequest.getAttribute("searchValue"));
		String searchCritertiria = (String) (renderRequest.getAttribute("searchCritertiria"));
		System.out.println("-----getCalendarBooking------searchValue---------: "+searchValue+"--------:: searchCritertiria: "+searchCritertiria+
				"--------:: start: "+start+"--------:: end: "+end);
		
		String showOnLanding = "false";
		try {
			DynamicQuery dq = com.liferay.calendar.service.CalendarBookingLocalServiceUtil.dynamicQuery();
			Property statusProperty = PropertyFactoryUtil.forName("status");
			dq.add(statusProperty.eq(WorkflowConstants.STATUS_APPROVED));
			dq.addOrder(OrderFactoryUtil.desc("createDate"));
			cbLst = (List) CalendarBookingLocalServiceUtil.dynamicQuery(dq, Integer.parseInt(start),Integer.parseInt(end));
			
			//System.out.println("SIZE::   " + cbLst.size());
			// get the list to remove
			//System.out.println("-----------::--------");

			//for (CalendarBooking event : cbLst) 
			{
				//Object[] locationLink = (Object[]) CalendarBookingLocalServiceUtil.getCalendarBooking(event.getCalendarBookingId()).getExpandoBridge().getAttribute("Location link");
				//System.out.println("link Object:: "+ locationLink.length);
				//Object obj = locationLink[0];
				//String link = obj.toString();
				// System.out.println(CalendarBookingLocalServiceUtil.getCalendarBooking(event.getCalendarBookingId()).getExpandoBridge().getAttribute("Location link").toString());
				//System.out.println("event.getCalendarBookingId:: " + event.getCalendarBookingId());

				/*
				 * Object[] a = (Object[])
				 * CalendarBookingLocalServiceUtil.getCalendarBooking(event.getCalendarBookingId
				 * ()).getExpandoBridge().getAttribute("show on landing"); if(a.length>0) {
				 * Object obj = a[0]; showOnLanding = obj.toString(); showOnLanding = "true"; }
				 * System.out.println("-------showOnLanding--------  "+showOnLanding);
				 * if(showOnLanding == "true" || "true".equals(showOnLanding)) {
				 * cbLstToAdd.add(event); } else {
				 * System.out.println("removed: "+event.getTitleCurrentValue()); }
				 */
			}
			System.out.println("-----getCalendarBooking------cbLst.size()---------: "+cbLst.size());

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
		return cbLst;
	}

	public String getSpeakersImage(long eventId,String expandFieldDescription) 
	{
		String data =""; 
		try 
		{ 
			//System.out.println("getSpeakersImage:: eventId:: "+eventId+"---expandFieldDescription:: "+expandFieldDescription);
		//	System.out.println(CalendarBookingLocalServiceUtil.getCalendarBooking(eventId).getExpandoBridge().getAttribute(expandFieldDescription));
			data = (String) CalendarBookingLocalServiceUtil.getCalendarBooking(eventId).getExpandoBridge().getAttribute(expandFieldDescription); 
			//System.out.println("getSpeakersImage:: data:: "+data);
		 } 
		  catch (PortalException e)
		  { 
			  e.printStackTrace();
		  }
		return data;
	}
	
    public List<SpeakerVO> getSpeakersMetada(CalendarBooking ca) 
    {
    	JSONArray jsonArr = null;
    	List<SpeakerVO> participantJsonList = null;
    	Object a = null;
    	try 
    	{
    		System.out.println(CalendarBookingLocalServiceUtil.getCalendarBooking(ca.getCalendarBookingId()).getExpandoBridge().getAttribute("Speakers"));
    		a = (Object) CalendarBookingLocalServiceUtil.getCalendarBooking(ca.getCalendarBookingId()).getExpandoBridge().getAttribute("Speakers");
    		if(a!=null) 
    		{
			  String speakerMetadata = a.toString();
			  System.out.println("getSpeakersMetada speakerMetadata:: "+speakerMetadata);
			  ObjectMapper mapper = new ObjectMapper();
			  try {
				participantJsonList = mapper.readValue(speakerMetadata, new TypeReference<List<SpeakerVO>>(){});
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 // jsonArr = JSONFactoryUtil.createJSONArray();
			 // jsonArr = (JSONArray) a;
			 // System.out.println("getSpeakersMetada jsonArr:: "+jsonArr);
    		}
		} catch (PortalException e) 
    	{
			e.printStackTrace();
		}
		return participantJsonList;
	}
    
    public List<SpeakerNVO> getSpeakersNMetada(CalendarBooking ca) 
    {
    	JSONArray jsonArr = null;
    	List<SpeakerNVO> participantJsonList = new ArrayList<SpeakerNVO>();
    	java.sql.Connection con = null;
		java.sql.Statement st = null;
		SpeakerNVO spVO = null;
    	Object a = null;
    	try 
    	{
    		con = DataAccess.getConnection();
			st = con.createStatement();
			String columnId = "";
			String sqlStatement = "select position , " + 
									"     nationality ," + 
									"     speakerImage ,"
									+ "   firstName, "
									+ "   lastName, "
									+ "   email, "
									+ "   speakerOrder " + 
									"from EventSpeakers "
					+ " where EventId = " +ca.getCalendarBookingId() 
					+ " order by IFNULL(speakerOrder,0) asc ";
			System.out.println("sqlStatement: "+sqlStatement);
			java.sql.ResultSet rs = st.executeQuery(sqlStatement);
			while (rs.next()) 
			{
				spVO = new SpeakerNVO();
				spVO.setNationality(rs.getString("nationality"));
				spVO.setPosition(rs.getString("position"));
				spVO.setSpeakerImage(rs.getBlob("speakerImage"));
				//spVO.setSpeakerImageString(rs.getString("speakerImage"));
				spVO.setFirstName(rs.getString("firstName"));
				spVO.setLastName(rs.getString("lastName"));
				spVO.setEmailAddress(rs.getString("email"));
				participantJsonList.add(spVO);
				//release the blob and free up memory. (since JDBC 4.0)
				//blob.free();
				//System.out.println( Base64.getEncoder().encode(blobAsBytes));
				//Base64.getEncoder().encode(buffer);
			}
    		
		} catch (Exception e) 
    	{
			e.printStackTrace();
		}
    	finally
    	{
    		DataAccess.cleanUp(con);
    	}
		return participantJsonList;
	}
    
    public static Calendar mysqlDateTimeToCalendar(String dateString)
	{
		try
		{
			//in my case I hade an . in the end of the date String.
			if (dateString.indexOf(".") > -1) {
				dateString = dateString.substring(0, dateString.indexOf("."));
			}
 			StringTokenizer tokenizer = new StringTokenizer(dateString," ");

			String datePart = tokenizer.nextToken();
			String timePart = tokenizer.nextToken();

			tokenizer = new StringTokenizer(datePart,"-");
			String year = tokenizer.nextToken();
			String month = tokenizer.nextToken();
			String day = tokenizer.nextToken();

			tokenizer = new StringTokenizer(timePart,":");
			String hours = tokenizer.nextToken();
			String minutes = tokenizer.nextToken();
			String seconds = tokenizer.nextToken();

			Calendar date = Calendar.getInstance();
			date.set(Calendar.YEAR, Integer.parseInt(year));
			date.set(Calendar.MONTH, Integer.parseInt(month));
			date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
			date.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours));
			date.set(Calendar.MINUTE, Integer.parseInt(minutes));
			
			date.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours));
			date.set(Calendar.MINUTE, Integer.parseInt(minutes));
			date.set(Calendar.SECOND, Integer.parseInt(seconds));
			// System.out.println("calendar:--"+date.getTime());
			/*
			 * System.out.println("calendar:--getDate---"+date.getTime().getDate());
			 * System.out.println("calendar:--getMonth---"+date.getTime().getMonth());
			 * System.out.println("calendar:--getHours---"+date.getTime().getHours());
			 * System.out.println("calendar:--getMinutes---"+date.getTime().getMinutes());
			 * System.out.println("calendar:--getYear---"+date.getTime().getYear());
			 * System.out.println("calendar:--day of weekr---"+date.get(Calendar.DAY_OF_WEEK
			 * ));
			 */
			//System.out.println("calendar:--name of day---"+days[date.get(Calendar.DAY_OF_WEEK)-1]);
			return date;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

    public List<TimeLinedayObject> getTimeLineMetada(CalendarBooking ca) 
    {
    	JSONArray jsonArr = null;
    	List<TimeLinedayObject> timeLinedayObjectList = new ArrayList<TimeLinedayObject>();
    	List<EventTimeDescripiton> eventTimeDescripitonList = new ArrayList<EventTimeDescripiton>();
    	java.sql.Connection con = null;
		java.sql.Statement st = null;
		TimeLineVO tlVO = null;
    	Object a = null;
    	HashMap<String, String> eventDay = new HashMap<String, String>();
    	String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    	 DateFormatSymbols dfs = new DateFormatSymbols();
    	String[] months = dfs.getMonths();
    	try 
    	{
    		con = DataAccess.getConnection();
			st = con.createStatement();
			String sqlStatement = "Select TAB.* FROM("
					+ "                select  (@row_number:=@row_number + 1) AS num, "
					+ "                   Title , \r\n" + 
									"     Description ,\r\n" + 
									"     DescriptionAr ,\r\n" + 
									"     EventStartDay ,\r\n"+
									"     EventEndDay ,\r\n"+
									"DAY(EventStartDay) as da," 
									+ "   EventId "
									+ "from EventTimeline,"
									+ " (SELECT @row_number:=0) AS t"
					              + " where EventId = "+ca.getCalendarBookingId()
					              + " order by EventStartDay asc)TAB "
					           + "  order by TAB.Title"/* +ca.getCalendarBookingId() */;
			System.out.println("sqlStatement: "+sqlStatement);
			java.sql.ResultSet rs = st.executeQuery(sqlStatement);
			Calendar c = Calendar.getInstance(); 
			HashMap<String, TimeLinedayObject> hashDay = new HashMap<String, TimeLinedayObject>();
			
			EventTimeDescripiton eventTimeDescripiton=  new EventTimeDescripiton();
			TimeLinedayObject tl = new TimeLinedayObject();
			
			
			int i = 0;
			int id = 0;
			while (rs.next()) 
			{
				Calendar startDate = mysqlDateTimeToCalendar(rs.getString("EventStartDay"));
				Calendar endDate = mysqlDateTimeToCalendar(rs.getString("EventEndDay"));
				String title = rs.getString("Title");
				String description = rs.getString("Description");
				String descriptionAr = rs.getString("DescriptionAr");
				String dateDescription = days[startDate.get(Calendar.DAY_OF_WEEK)-1]+", "+months[startDate.getTime().getMonth()]+" "+rs.getString("da");
				int startDate1=startDate.getTime().getMinutes();
				int endDate1=endDate.getTime().getMinutes();
				System.out.println("--"+rs.getString("EventStartDay").split(" ")[0]+"---:: "+startDate.DAY_OF_MONTH);
				String startDate1s = String.valueOf(startDate1);
				String endDate1s = String.valueOf(endDate1);

				System.out.println("startDate1s:: "+startDate1s+"--------: "+endDate1s);
				startDate1s = (startDate1s.length()==1)?"00":startDate1s;
				endDate1s = (endDate1s.length()==1)?"00":endDate1s;
				System.out.println("startDate1s11:: "+startDate1s+"---11-----: "+endDate1s);
				// String date = String.valueOf(startDate.getTime().getHours())+":"+startDate.getTime().getMinutes()+" - " + String.valueOf(endDate.getTime().getHours())+":"+endDate.getTime().getMinutes();
				String date = String.valueOf(startDate.getTime().getHours())+":"+startDate1s+" - " + String.valueOf(endDate.getTime().getHours())+":"+endDate1s;
				

				System.out.println(title);
				System.out.println(dateDescription);
				System.out.println(date);
				if(hashDay.containsKey(rs.getString("Title")))
				{
					eventTimeDescripiton = null;
					eventTimeDescripiton=  new EventTimeDescripiton();
					System.out.println("contain key: "+description);
					eventTimeDescripiton.setDate(date);
					eventTimeDescripiton.setTimeLineDescription(description);
					eventTimeDescripiton.setTimeLineDescriptionAr(descriptionAr);
					tl = hashDay.get(title);
					eventTimeDescripitonList = new ArrayList<EventTimeDescripiton>();
					eventTimeDescripitonList = tl.getEventTimeDescription();
					eventTimeDescripitonList.add(eventTimeDescripiton);
					tl.setEventTimeDescription(eventTimeDescripitonList);
					//hashDay.remove(rs.getString("Title"));
					//hashDay.put(title, tl);
					for(EventTimeDescripiton el:tl.getEventTimeDescription())
					{
						System.out.println(el.getTimeLineDescription());
					}
				}
				else
				{
					System.out.println(" not contain key: "+description);
					tl = new TimeLinedayObject();
					tl.setTitle(title);
					tl.setDateDescription(dateDescription);
					eventTimeDescripiton=  new EventTimeDescripiton();
					eventTimeDescripiton.setDate(date);
					eventTimeDescripiton.setTimeLineDescription(description);
					eventTimeDescripiton.setTimeLineDescriptionAr(descriptionAr);
					eventTimeDescripitonList = new ArrayList<EventTimeDescripiton>();
					eventTimeDescripitonList.add(eventTimeDescripiton);
					tl.setEventTimeDescription(eventTimeDescripitonList);
					hashDay.put(title, tl);
				}
				if(timeLinedayObjectList.contains(tl))
					timeLinedayObjectList.remove(tl);
				timeLinedayObjectList.add(tl);
			}
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	finally
    	{
    		DataAccess.cleanUp(con);
    	}
    	return timeLinedayObjectList;
    }
    
    public List<QuestionsAndAnswers> getQuestionsAndAnswersMetada(CalendarBooking ca) 
    {
    	JSONArray jsonArr = null;
    	List<QuestionsAndAnswers> questionsAndAnswersList = new ArrayList<QuestionsAndAnswers>();
    	java.sql.Connection con = null;
		java.sql.Statement st = null;
		QuestionsAndAnswers qaVO = null;
    	Object a = null;
    	try 
    	{
    		con = DataAccess.getConnection();
			st = con.createStatement();
			String sqlStatement = "select Question , QuestionAr," + 
									"     Answer, AnswerAr "
									+ "from EventFAQs"
					              + " where eventId = "+ca.getCalendarBookingId();
			System.out.println("sqlStatement: "+sqlStatement);
			java.sql.ResultSet rs = st.executeQuery(sqlStatement);
			while (rs.next()) 
			{
				qaVO = new QuestionsAndAnswers();
				qaVO.setQuestion(rs.getString("Question"));
				qaVO.setAnswer(rs.getString("Answer"));
				qaVO.setQuestionAr(rs.getString("QuestionAr"));
				qaVO.setAnswerAr(rs.getString("AnswerAr"));
				questionsAndAnswersList.add(qaVO);
			}
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	finally
    	{
    		DataAccess.cleanUp(con);
    	}
    	return questionsAndAnswersList;
    }
    
    public List<HighLightsVO> getHighLightsNMetada(CalendarBooking ca) 
    {
    	JSONArray jsonArr = null;
    	List<HighLightsVO> highLightsList = new ArrayList<HighLightsVO>();
    	java.sql.Connection con = null;
		java.sql.Statement st = null;
		HighLightsVO hlVO = null;
    	Object a = null;
    	try 
    	{
    		con = DataAccess.getConnection();
			st = con.createStatement();
			String columnId = "";
			String sqlStatement = "select title , titleAr," + 
									"     description, descriptionAr,"
									+ "   image " + 
									"from EventHighLights"
					+ " where eventId = " +ca.getCalendarBookingId() ;
			System.out.println("sqlStatement: "+sqlStatement);
			java.sql.ResultSet rs = st.executeQuery(sqlStatement);
			while (rs.next()) 
			{
				hlVO = new HighLightsVO();
				hlVO.setTitle(rs.getString("title"));
				hlVO.setTitleAr(rs.getString("titleAr"));
				hlVO.setDescription(rs.getString("description"));
				hlVO.setDescriptionAr(rs.getString("descriptionAr"));
				hlVO.setImage(rs.getBlob("Image"));
				highLightsList.add(hlVO);
			}
    		
		} catch (Exception e) 
    	{
			e.printStackTrace();
		}
    	finally
    	{
    		DataAccess.cleanUp(con);
    	}
		return highLightsList;
	}
	
    
	public CalendarBooking getEventDetails(RenderRequest renderRequest) {

		System.out.println(
				"CalendarBooking getEventDetails: " + Long.parseLong(renderRequest.getParameter("calendarBookingId")));
		CalendarBooking cb = null;
		long i;
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {

			cb = com.liferay.calendar.service.CalendarBookingLocalServiceUtil
					.getCalendarBooking(Long.parseLong(renderRequest.getParameter("calendarBookingId")));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return cb;
	}

	public String getImageBybookingEvent(long primaryCalendarBookingId)
			throws IOException, PortletException, SQLException {
		/*System.out.println("primaryCalendarBookingId:: " + primaryCalendarBookingId);
		java.sql.Connection con = null;
		java.sql.Statement st = null;
		String data_ = "";
		InputStream in = null;
		int BUFFER_SIZE = 1024;
		StringBuffer buffer = new StringBuffer();
		int numRead;
		byte[] arr = new byte[BUFFER_SIZE];
		try {
			System.out.println();

			System.out.println(CalendarBookingLocalServiceUtil.getCalendarBooking(primaryCalendarBookingId)
					.getExpandoBridge().getAttribute("uploadimageid"));

//			 System.out.println("---- getImageBybookingEvent --- ");
			con = DataAccess.getConnection();
			st = con.createStatement();
			String columnId = "";
			data_ = "";
			String sqlStatement = "select columnId from expandocolumn where name = 'Uploadimageid'";
			java.sql.ResultSet rs = st.executeQuery(sqlStatement);
			while (rs.next()) {
				columnId = rs.getString("columnId");
			}
			sqlStatement = "select data_ from expandovalue " + " where classNameId = '25802' " + "  and classPk = "
					+ String.valueOf(primaryCalendarBookingId) + " and columnId = " + 35914 columnId ;
			rs = st.executeQuery(sqlStatement);
//			 System.out.println("----"+sqlStatement);

			while (rs.next()) {
				in = rs.getAsciiStream("data_");

			}
			if (in == null)
				return "";
			numRead = in.read(arr);

			while (numRead != -1) {
				buffer.append(new String(arr, 0, numRead));
				numRead = in.read(arr);
			}

//			 System.out.println("-------data----------");
			// System.out.println(data_);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			st.close();
			con.close();
		}*/
		
		  String data =""; try 
		  {
		   data = (String)
		    CalendarBookingLocalServiceUtil.getCalendarBooking(primaryCalendarBookingId).
		   getExpandoBridge().getAttribute("UploadImageId"); 
		  } 
		  catch (PortalException e)
		  { // TODO Auto-generated catch block e.printStackTrace(); }
		 System.out.println("data:::::::::::::"+data);
		  }
		 
		return data;
	}
	
	public List<CalendarBooking> getCalendarBookingRefresh(String criteria, String value,String start, String end,String searchdate,String locationSearchTxt) {
		List<CalendarBooking> cbLst = new ArrayList<CalendarBooking>();
		List<CalendarBooking> cbLstToAdd = new ArrayList<CalendarBooking>();

		if(start == null)
			return cbLst;
		System.out.println("start:: "+start);
		String searchValue = value;
		String searchCritertiria = criteria;
		System.out.println("----getCalendarBookingRefresh-------searchValue---------: "+searchValue+"--------:: searchCritertiria: "+searchCritertiria+"--start--: "+start+"--end--: "+end);
		
		String showOnLanding = "false";
		try {
				System.out.println("-----------getCalendarBookingRefresh---------");
				DynamicQuery dq = com.liferay.calendar.service.CalendarBookingLocalServiceUtil.dynamicQuery();
				Property statusProperty = PropertyFactoryUtil.forName("status");
				Property titlePropertyFactoryUtil = PropertyFactoryUtil.forName("title");
				//Property locationProperty = PropertyFactoryUtil.forName("location");
				dq.add(statusProperty.eq(WorkflowConstants.STATUS_APPROVED));
			/*
			 * if(criteria!= null && criteria.equalsIgnoreCase("Event Subject")) {
			 * System.out.println("subject criteria::---"+'"'+"%"+value+"%"+'"'+"----");
			 * dq.add(titlePropertyFactoryUtil.like("test event 7%")); }
			 */
			/*
			 * if(criteria!= null && criteria.equalsIgnoreCase("Event Location")) {
			 * System.out.println("location criteria::---"+'"'+"%"+value+"%"+'"'+"----");
			 * dq.add(PropertyFactoryUtil.forName("location").like('"'+value+"%"+'"')); }
			 */
			/*
			 * if(criteria!= null && criteria.equalsIgnoreCase("Event Description")) {
			 * System.out.println("Description criteria::---"+'"'+"%"+value+"%"+'"'+"----");
			 * dq.add(PropertyFactoryUtil.forName("description").like('"'+"%"+value+"%"+'"')
			 * ); }
			 */
				dq.addOrder(OrderFactoryUtil.desc("createDate"));
				cbLst = (List) CalendarBookingLocalServiceUtil.dynamicQuery(dq, Integer.parseInt(start),Integer.parseInt(end));
				System.out.println("-------getCalendarBookingRefresh---------cbLst.size()-----------:: "+ cbLst.size());
				String eventTypes = "";
				
				if(criteria!= null && !"Search Type".equalsIgnoreCase(criteria))//value
//					if(criteria!= null && value != null && criteria.equalsIgnoreCase("Event Type"))
				{
					System.out.println("event type criteria::---:"+criteria);
					for (CalendarBooking event : cbLst) 
					{
							Object[] a = (Object[]) event.getExpandoBridge().getAttribute("Event Types");
							if(a.length>0) 
				           	{
				           		 Object obj = a[0]; 
				           		 eventTypes = obj.toString(); 
				           		 if(eventTypes.equalsIgnoreCase(criteria))
				           		 {
				           			cbLstToAdd.add(event);
				           		 }
							}
					}
			    }
				
//				if(criteria!= null && value != null && criteria.equalsIgnoreCase("Event Subject"))
//				{
//					String subject = "";
//					System.out.println("Event Subject\" criteria::---:"+value);
//					for (CalendarBooking event : cbLst) 
//					{
//						    subject = event.getTitleCurrentValue();
//							if(subject != null) 
//				           	{
//				           		 if(subject.toLowerCase().contains(value.toLowerCase()))
//				           		 {
//				           			cbLstToAdd.add(event);
//				           		 }
//							}
//					}
//			    }
				
//				if(criteria!= null && value != null && criteria.equalsIgnoreCase("Event Location"))
//				{
//					String location = "";
//					System.out.println("Event Location criteria::---:"+value);
//					for (CalendarBooking event : cbLst) 
//					{
//						    location = event.getLocation();
//							if(location != null) 
//				           	{
//				           		 if(location.toLowerCase().contains(value.toLowerCase()))
//				           		 {
//				           			cbLstToAdd.add(event);
//				           		 }
//							}
//					}
//			    }
				
				if(value != null && !"".equals(value))
//					if(criteria!= null && value != null && criteria.equalsIgnoreCase("Event Description")) Event Subject
				{
					String description = "";
					String subject = "";
					System.out.println("Event Description criteria::---:"+value);
					if(cbLstToAdd.size()>0) {
						cbLst = new ArrayList<CalendarBooking>();
						cbLst.addAll(cbLstToAdd);
						cbLstToAdd = new ArrayList<CalendarBooking>();
					}
					System.out.println("********************************======="+cbLst.size());
					System.out.println("********************************======="+cbLstToAdd.size());
					for (CalendarBooking event : cbLst) 
					{
					    description = event.getDescriptionCurrentValue();
					    subject = event.getTitleCurrentValue();
						if(description != null) 
			           	{
			           		 if(description.toLowerCase().contains(value.toLowerCase()))
			           		 {
			           			cbLstToAdd.add(event);
			           			continue;
			           		 }
						}
						if(subject != null) 
			           	{
			           		 if(subject.toLowerCase().contains(value.toLowerCase()))
			           		 {
			           			cbLstToAdd.add(event);
			           			continue;
			           		 }
						}
					}
					System.out.println("********************************======="+cbLst.size());
					System.out.println("********************************======="+cbLstToAdd.size());
			    }
				
				
				if(locationSearchTxt != null && !"".equals(locationSearchTxt)) 
				{
					String location = "";
					System.out.println("locationSearchTxt criteria::---:"+locationSearchTxt);
					if(cbLstToAdd.size()>0) {
						cbLst = new ArrayList<CalendarBooking>();
						cbLst.addAll(cbLstToAdd);
						cbLstToAdd = new ArrayList<CalendarBooking>();
					}
					System.out.println("********************************======="+cbLst.size());
					System.out.println("********************************======="+cbLstToAdd.size());
					
					for (CalendarBooking event : cbLst) 
					{
					    location = event.getLocation();
					    System.out.println("location ============ " + location);
						if(location != null && !"".equals(location)) {
							if(location.toLowerCase().contains(locationSearchTxt.toLowerCase()))
			           		{
			           			cbLstToAdd.add(event);
			           		}
						}						
					}
				}
				
				if(searchdate != null && !"".equals(searchdate))
				{
					if(cbLstToAdd.size()>0) {
						cbLst = new ArrayList<CalendarBooking>();
						cbLst.addAll(cbLstToAdd);
						cbLstToAdd = new ArrayList<CalendarBooking>();
					}
					
					System.out.println("searchdate ========= " + searchdate);
					String[] date1 = searchdate.split("-");
					String year = date1[0];
					String month = date1[1];
//					Date rr = new SimpleDateFormat("yyyy-MM-dd").parse(searchdate);
					System.out.println("year =="+year+"==month=== " + month);
//					long dateEvt = 0;
					for (CalendarBooking event : cbLst) 
					{
						Date startDate = new Date(event.getStartTime());
						if(((startDate.getYear()+1900) == Integer.parseInt(year)) && ((startDate.getMonth()+1) >= Integer.parseInt(month))) 
						{
							System.out.println("startDate ========= "  + Integer.parseInt(year) + "/" + startDate.getYear());
							System.out.println("startDate ========= "  + Integer.parseInt(month)+ "/" + (startDate.getMonth()+1));
							cbLstToAdd.add(event);
						}
					}
				}
				System.out.println("cbLstToAdd ======== " + cbLstToAdd.size());

				if((criteria == null || "Search Type".equalsIgnoreCase(criteria)) && (locationSearchTxt == null || "".equalsIgnoreCase(locationSearchTxt))  
						&& (value == null || "".equalsIgnoreCase(value)) && (searchdate == null || "".equalsIgnoreCase(searchdate)))
				{
					cbLstToAdd = (List) CalendarBookingLocalServiceUtil.dynamicQuery(dq, Integer.parseInt(start),Integer.parseInt(end));
				}
				System.out.println("cbLstToAdd aaaaa======== " + cbLstToAdd.size());

				//JournalArticleLocalServiceUtil.getLatestArticleByUrlTitle()
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
		return cbLstToAdd;
	}
	
	public boolean checkIfPrintBadgeEnabled(String eventId, String userId)
	{
		boolean isEnabled   = false;
		java.sql.Connection con = null;
		java.sql.Statement st = null;
	    String sqlStat = "select count(1) cnt " + 
				    		"from formeventusertable " + 
				    		"where userId = " + userId +
				    		" and eventId = " + eventId +
				    		" and lower(statusCol) like('%approved%')";
    	
		try
		{
			con = DataAccess.getConnection();
			st = con.createStatement();
			java.sql.ResultSet rs = st.executeQuery(sqlStat);
			while (rs.next()) 
			{
				int count = rs.getInt("cnt");
				if(count>0)
				{
					isEnabled = true;
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			
		}
		return isEnabled;
		
		
	}
		

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {

			String command = resourceRequest.getParameter("command");
			String type = resourceRequest.getParameter("type");
			String criteria = resourceRequest.getParameter("criteria");
			String searchdate = resourceRequest.getParameter("searchdate");
			String locationSearchTxt = resourceRequest.getParameter("locationSearchTxt");
			System.out.println("serveResource : eventList: " + command);
			System.out.println(resourceRequest.getParameter("command"));
			String start = resourceRequest.getParameter("start");
			String end = resourceRequest.getParameter("end");
			String userId = resourceRequest.getParameter("userId");
			String eventId = resourceRequest.getParameter("eventId");
			
			
			if(command != null && command.equalsIgnoreCase("checkIfUserAlreadyAppliedForTheEvent"))
			{
				boolean isApplied = checkIfUserAlreadyAppliedForTheEvent(userId, eventId);
				resourceRequest.getPortletSession().setAttribute("isApplied", isApplied);
				PrintWriter printout = resourceResponse.getWriter();
				printout.print(isApplied);
			}
			else
			{
				 System.out.println("-----------criteria---------: "+criteria+"--------:: type: "+type+"--start--: "+start+"--end--: "+end); 
				 List<CalendarBooking> cbLstToRefresh = new ArrayList<CalendarBooking>();
				 cbLstToRefresh = getCalendarBookingRefresh(type, criteria,start,end,searchdate,locationSearchTxt) ;
				 System.out.println("cbLstToRefresh.size():: "+cbLstToRefresh.size());
				 resourceRequest.getPortletSession().setAttribute("objArray", cbLstToRefresh);
				 resourceRequest.getPortletSession().setAttribute("fromSearch", "true");
				 JSONObject json = JSONFactoryUtil.createJSONObject();
				 JSONArray jsonArr = JSONFactoryUtil.createJSONArray(); 
				 PrintWriter printout = resourceResponse.getWriter();
				 printout.print(cbLstToRefresh);
			}
			 
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
