package he2Portlet.portlet;

import he2Portlet.constants.He2PortletKeys;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.osgi.service.component.annotations.Component;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
/**
 * @author jsa
 */
@Component(  
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=He2",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + He2PortletKeys.HE2,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class He2Portlet extends MVCPortlet 
{
	
	

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException 
	{
		System.out.println("h2servletPortlet : ");
		Connection con = null;
		Statement st = null;
		String sqlStatement = "";
		
		List<CalendarBooking> cbLst = null;
		JSONArray jsonArr;
		jsonArr = JSONFactoryUtil.createJSONArray();
		JSONObject json = JSONFactoryUtil.createJSONObject();
		Map map = new HashMap();
		 
		 map.put(0, "approved");
		 map.put(4, "denied");
		 map.put(2, "draft");
		 //map.put(3, "EXPIRED");
		 map.put(3, "closed");
		 map.put(8, "trash");
		 map.put(5, "inactive");
		 map.put(6, "incomplete");
		 map.put(1, "pending");
		try
		{	
			String command             = resourceRequest.getParameter("command");
			String calendarBookingId   = resourceRequest.getParameter("calendarBookingId");
			String userId              = resourceRequest.getParameter("userId");
			int indexT1=0;
			int indexT2=0;
			String titleString="",Title="";
			Format format = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
			
			System.out.println("userId: "+userId);
			System.out.println("calendarBookingId: "+calendarBookingId);
			if(command.equalsIgnoreCase("deleteEvent"))
			{
				con = DataAccess.getConnection();
			    st = con.createStatement();
			    
				CalendarBooking cb = CalendarBookingLocalServiceUtil.getCalendarBooking(Long.valueOf(calendarBookingId));
				CalendarBookingLocalServiceUtil.moveCalendarBookingToTrash(Long.valueOf(userId), cb);
				System.out.println("let move it to the trash");
				System.out.println("command: "+command);
				System.out.println("calendarBookingId: "+cb.getTitle());
				System.out.println("userId: "+userId);

				/*
				DynamicQuery dq = com.liferay.calendar.service.CalendarBookingLocalServiceUtil.dynamicQuery();
				dq.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("userId").eq(Long.valueOf(userId)));
				Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(1));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(2));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(0));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(3));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(4));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(5));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(6));
			    
			    
			    
			    dq.add(disjunction);
				dq.addOrder(com.liferay.portal.kernel.dao.orm.OrderFactoryUtil.desc("calendarBookingId"));
				cbLst = (List) CalendarBookingLocalServiceUtil.dynamicQuery(dq,0,100);
				System.out.println("FROM View \n\n\n\n: "+cbLst);
				
				
				for(CalendarBooking event:cbLst)
				{
					 json = JSONFactoryUtil.createJSONObject();
					 json.put("eventId", event.getCalendarBookingId());
					 json.put("eventTitle", event.getTitleCurrentValue());
					 json.put("startDate", new SimpleDateFormat("MM/dd/yyyy").format(new Date(event.getStartTime())));
					 json.put("endDate", new SimpleDateFormat("MM/dd/yyyy").format(new Date(event.getEndTime())));
					 json.put("status", map.get(event.getStatus()));
					 jsonArr.put(json);
				}
				*/
				
				String sqlTxt =" select tab.calendarbookingId, canEdit "+
						" from ( select g1.calendarbookingId "+
						"COALESCE((select 1 "+ 
				          " from EventEditors s "+
				         " where s.userId  ="+userId+ 
				          "  and s.eventId = g1.calendarbookingId "+
				      "   and not exists(select 1 "+
				                        " from EventReviewers s "+
						                " where s.userId = "+userId+
						                 " and s.eventId = g1.calendarbookingId)"+
				   " ),0) as canEdit" +
							     "  from CalendarBooking g1"+
							   " where g1.userId = "+userId+
							  "    and g1.status in(1,2,0,3,4,5,6) "+
							" union all "+
							" select g2.calendarbookingId ,"+
							"COALESCE((select 1 "+ 
					          " from EventEditors s "+
					         " where s.userId  ="+userId+ 
					          "  and s.eventId = g1.calendarbookingId "+
					      "   and not exists(select 1 "+
					                        " from EventReviewers s "+
							                " where s.userId = "+userId+
							                 " and s.eventId = g1.calendarbookingId)"+
					   " ),0) as canEdit" +
							  " from CalendarBooking g2 "+
							  " where EXISTS(select 1 "+
							           "     from EventEditors r "+
							            "   where r.eventId = g2.calendarBookingId "+
							           "      and r.userId = "+userId+") "+
							           " and g2.status in(1,2,0,3,4,5,6)"+
							            "     )tab "+
							          " order by tab.calendarbookingId desc";
				ResultSet rs = st.executeQuery(sqlTxt);
				CalendarBooking cl ;
				
				while (rs.next()) 
				{
					String evId = rs.getString("calendarbookingId");
					cl = CalendarBookingLocalServiceUtil.getCalendarBooking(Long.valueOf(evId));
					json = JSONFactoryUtil.createJSONObject();
					json.put("eventId",cl.getCalendarBookingId());
					json.put("endDate",format.format(Long.valueOf(cl.getEndTime())))  ;
					json.put("startDate",format.format(Long.valueOf(cl.getStartTime())));
					json.put("status",map.get(cl.getStatus()));
					json.put("canEdit",rs.getString("canEdit"));
					
					if(cl.getTitle() == null || cl.getTitle()== "")
						json.put("eventTitle",Title);
					else
					{
						titleString = cl.getTitle();
						indexT1 = titleString.indexOf("<Title");
						titleString = titleString.substring(indexT1,titleString.length());
						titleString = titleString.replace("</Title></root>","</Title></root>"); 
						indexT2 = titleString.indexOf(">");
						Title = titleString.substring(indexT2+1,titleString.length());
						json.put("eventTitle",Title);
					}
					jsonArr.put(json);
				}
				DataAccess.cleanUp(con, st);
			}
			
			if(command.equalsIgnoreCase("closeEvent"))
			{
				con = DataAccess.getConnection();
			    st = con.createStatement();
				/*
				 * sqlStatement =
				 * "update calendarbooking set status = 3 where calendarbookingId = "
				 * +calendarBookingId; st.executeUpdate(sqlStatement);
				 */
				
				System.out.println("let move it to close");
				System.out.println("command: "+command);
				System.out.println("userId: "+userId);
				
				CalendarBooking ca = CalendarBookingLocalServiceUtil.getCalendarBooking(Long.parseLong(calendarBookingId));
				ca.setStatus(3);
				CalendarBookingLocalServiceUtil.updateCalendarBooking(ca);
				
				

				/*
				DynamicQuery dq = com.liferay.calendar.service.CalendarBookingLocalServiceUtil.dynamicQuery();
				dq.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("userId").eq(Long.valueOf(userId)));
				Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(1));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(2));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(0));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(3));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(4));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(5));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(6));
			    dq.add(disjunction);
				dq.addOrder(com.liferay.portal.kernel.dao.orm.OrderFactoryUtil.desc("calendarBookingId"));
				cbLst = (List) CalendarBookingLocalServiceUtil.dynamicQuery(dq,0,100);
				System.out.println("FROM View \n\n\n\n: "+cbLst);
				
				
				for(CalendarBooking event:cbLst)
				{
					 json = JSONFactoryUtil.createJSONObject();
					 json.put("eventId", event.getCalendarBookingId());
					 json.put("eventTitle", event.getTitleCurrentValue());
					 json.put("startDate", new SimpleDateFormat("MM/dd/yyyy").format(new Date(event.getStartTime())));
					 json.put("endDate", new SimpleDateFormat("MM/dd/yyyy").format(new Date(event.getEndTime())));
					 json.put("status", map.get(event.getStatus()));
					 jsonArr.put(json);
				}
				*/
				String sqlTxt =" select tab.calendarbookingId ,canEdit"+
						" from ( select g1.calendarbookingId  ,"+
						"COALESCE((select 1 "+ 
				          " from EventEditors s "+
				         " where s.userId  ="+userId+ 
				          "  and s.eventId = g1.calendarbookingId "+
				      "   and not exists(select 1 "+
				                        " from EventReviewers s "+
						                " where s.userId = "+userId+
						                 " and s.eventId = g1.calendarbookingId)"+
				   " ),0) as canEdit" +
							     "  from CalendarBooking g1"+
							   " where g1.userId = "+userId+
							  "    and g1.status in(1,2,0,3,4,5,6) "+
							" union all "+
							" select g2.calendarbookingId ,"+
							"COALESCE((select 1 "+ 
					          " from EventEditors s "+
					         " where s.userId  ="+userId+ 
					          "  and s.eventId = g2.calendarbookingId "+
					      "   and not exists(select 1 "+
					                        " from EventReviewers s "+
							                " where s.userId = "+userId+
							                 " and s.eventId = g2.calendarbookingId)"+
					   " ),0) as canEdit" +
							  " from CalendarBooking g2 "+
							  " where EXISTS(select 1 "+
							           "     from EventEditors r "+
							            "   where r.eventId = g2.calendarBookingId "+
							           "      and r.userId = "+userId+") "+
							           " and g2.status in(1,2,0,3,4,5,6)"+
							            "     )tab "+
							          " order by tab.calendarbookingId desc";
				ResultSet rs = st.executeQuery(sqlTxt);
				CalendarBooking cl ;
				
				while (rs.next()) 
				{
					String evId = rs.getString("calendarbookingId");
					cl = CalendarBookingLocalServiceUtil.getCalendarBooking(Long.valueOf(evId));
					json = JSONFactoryUtil.createJSONObject();
					json.put("eventId",cl.getCalendarBookingId());
					json.put("endDate",format.format(Long.valueOf(cl.getEndTime())))  ;
					json.put("startDate",format.format(Long.valueOf(cl.getStartTime())));
					json.put("status",map.get(cl.getStatus()));
					json.put("canEdit",rs.getString("canEdit"));
					
					if(cl.getTitle() == null || cl.getTitle()== "")
						json.put("eventTitle",Title);
					else
					{
						titleString = cl.getTitle();
						indexT1 = titleString.indexOf("<Title");
						titleString = titleString.substring(indexT1,titleString.length());
						titleString = titleString.replace("</Title></root>","</Title></root>"); 
						indexT2 = titleString.indexOf(">");
						Title = titleString.substring(indexT2+1,titleString.length());
						json.put("eventTitle",Title);
					}
					jsonArr.put(json);
				}
				DataAccess.cleanUp(con, st);
			}
			if(command.equalsIgnoreCase("loadData"))
			{

				/*
				DynamicQuery dq = com.liferay.calendar.service.CalendarBookingLocalServiceUtil.dynamicQuery();
				dq.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("userId").eq(Long.valueOf(userId)));
				Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(1));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(2));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(0));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(3));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(4));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(5));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(6));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(7));
			    disjunction.add(com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil.forName("status").eq(8));
			    dq.add(disjunction);
				dq.addOrder(com.liferay.portal.kernel.dao.orm.OrderFactoryUtil.desc("calendarBookingId"));
				cbLst = (List) CalendarBookingLocalServiceUtil.dynamicQuery(dq,0,100);
				System.out.println("FROM View \n\n\n\n: "+cbLst);
				
				
				for(CalendarBooking event:cbLst)
				{
					 json = JSONFactoryUtil.createJSONObject();
					 json.put("eventId", event.getCalendarBookingId());
					 json.put("eventTitle", event.getTitleCurrentValue());
					 json.put("startDate", new SimpleDateFormat("MM/dd/yyyy").format(new Date(event.getStartTime())));
					 json.put("endDate", new SimpleDateFormat("MM/dd/yyyy").format(new Date(event.getEndTime())));
					 json.put("status", map.get(event.getStatus()));
					 jsonArr.put(json);
				}
				*/
				
				String sqlTxt =" select tab.calendarbookingId ,canEdit"+
						" from ( select g1.calendarbookingId ,"+
						"COALESCE((select 1 "+ 
				          " from EventEditors s "+
				         " where s.userId  ="+userId+ 
				          "  and s.eventId = g1.calendarbookingId "+
				      "   and not exists(select 1 "+
				                        " from EventReviewers s "+
						                " where s.userId = "+userId+
						                 " and s.eventId = g1.calendarbookingId)"+
				   " ),0) as canEdit" +
							     "  from CalendarBooking g1"+
							   " where g1.userId = "+userId+
							  "    and g1.status in(1,2,0,3,4,5,6) "+
							" union all "+
							" select g2.calendarbookingId ,"+
							"COALESCE((select 1 "+ 
					          " from EventEditors s "+
					         " where s.userId  ="+userId+ 
					          "  and s.eventId = g2.calendarbookingId "+
					      "   and not exists(select 1 "+
					                        " from EventReviewers s "+
							                " where s.userId = "+userId+
							                 " and s.eventId = g2.calendarbookingId)"+
					   " ),0) as canEdit" +
							  " from CalendarBooking g2 "+
							  " where EXISTS(select 1 "+
							           "     from EventEditors r "+
							            "   where r.eventId = g2.calendarBookingId "+
							           "      and r.userId = "+userId+") "+
							           " and g2.status in(1,2,0,3,4,5,6)"+
							            "     )tab "+
							          " order by tab.calendarbookingId desc";
				ResultSet rs = st.executeQuery(sqlTxt);
				CalendarBooking cl ;
				
				while (rs.next()) 
				{
					String evId = rs.getString("calendarbookingId");
					cl = CalendarBookingLocalServiceUtil.getCalendarBooking(Long.valueOf(evId));
					json = JSONFactoryUtil.createJSONObject();
					json.put("eventId",cl.getCalendarBookingId());
					json.put("endDate",format.format(Long.valueOf(cl.getEndTime())))  ;
					json.put("startDate",format.format(Long.valueOf(cl.getStartTime())));
					json.put("status",map.get(cl.getStatus()));
					json.put("canEdit",rs.getString("canEdit"));
					
					if(cl.getTitle() == null || cl.getTitle()== "")
						json.put("eventTitle",Title);
					else
					{
						titleString = cl.getTitle();
						indexT1 = titleString.indexOf("<Title");
						titleString = titleString.substring(indexT1,titleString.length());
						titleString = titleString.replace("</Title></root>","</Title></root>"); 
						indexT2 = titleString.indexOf(">");
						Title = titleString.substring(indexT2+1,titleString.length());
						json.put("eventTitle",Title);
					}
					jsonArr.put(json);
				}
				DataAccess.cleanUp(con, st);
				
			}
			
			PrintWriter writer = resourceResponse.getWriter();
			//System.out.println("array : "+ array.toString());
			//jsonArr = (JSONArray) cbLst;
			System.out.println("jsonArr : "+ jsonArr);
			System.out.println("jsonArr.toString() : "+ jsonArr.toString());
			
			
			writer.write(jsonArr.toString());
			super.serveResource(resourceRequest, resourceResponse);
			
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
	}
}