package journey.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.google.gson.Gson;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import journey.constants.JourneyPortletKeys;
import vo.JourneyVO;

/**
 * @author user
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Journey", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + JourneyPortletKeys.JOURNEY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class JourneyPortlet extends MVCPortlet {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	List<JourneyVO> journeys = new ArrayList<JourneyVO>();
	JSONArray jsonArr = null;
	
	@Override
		public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			super.doView(renderRequest, renderResponse);
		}
	public JSONArray getData(String userId) throws IOException,PortletException, SQLException 
	 { 
		
		   try {
			   con = DataAccess.getUpgradeOptimizedConnection();
				st = con.createStatement();
				String selectSql = "select * from ( " 
						+ "SELECT journeyId, Title, ShortDescription, Date, Description, category, Pirvacy, tag, 'true' editable"
						+ " FROM journey where userId = " + userId
						+ " union "
						+ " select id journeyId, educationCategory Title, concat(degree,' in ',fieldOfStudy ) ShortDescription "
						+ " ,startYear Date,description Description, 1 category,1 Pirvacy,'' tag, 'false' editable "
						+ " from profileEducation where userId = " + userId + " and educateJourney = 'true'"
						+ " union " 
						+ " select id journeyId, title Title, concat(company,' | ',location ) ShortDescription, startDate Date, "
						+ " description Description,  5 category,1 Pirvacy,'' tag, 'false' editable "
						+ " from profileWorkExperience where userId = " + userId + " and workjourney = 'true'" 
						+ " union " 
						+ " select id journeyId,name Title,issuingOrganization ShortDescription,issueDate Date, '' Description,"
						+ " 2 category,1 Pirvacy,'' tag, 'false' editable "
						+ " from profileLicensesCertifications where userId = " + userId + " and certificatejourney = 'true'"
						+ ") t "
						+ " order by Date desc";
				System.out.println("selectSql :: " + selectSql);
				rs = st.executeQuery(selectSql);
				jsonArr = JSONFactoryUtil.createJSONArray();
				//System.out.println("jsonArr.length() : " + jsonArr.length());
				SimpleDateFormat sdt = new SimpleDateFormat("dd MMMM yyyy");
				while (rs.next())
				{
					SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat myFormat = new SimpleDateFormat("dd MMMM yyyy");
					String reformattedStr = "";
					try {

					    reformattedStr = myFormat.format(fromUser.parse(rs.getString(4)));
					} catch (ParseException e) {
					    e.printStackTrace();
					}
					JSONObject json = JSONFactoryUtil.createJSONObject();
					json.put("JourneyId", rs.getInt(1));
					json.put("Title", rs.getString(2));
					json.put("ShortDescription", rs.getString(3));
					json.put("Date",rs.getString(4));
					json.put("DateFormatted",reformattedStr);
					json.put("Description", rs.getString(5));
					json.put("Category", rs.getString(6));
					json.put("Pirvacy", rs.getInt(7));
					json.put("tag", rs.getString(8));
					json.put("editable", rs.getString(9));
					System.out.println("json : " + json.toString());
					jsonArr.put(json);
				}
		   }
		   catch (Exception e) {
			   e.printStackTrace();
		   }
		   finally {
			   con.close(); 
	  			 st.close();
			 DataAccess.cleanUp(con, st);
		   }
		return jsonArr;
	   }
	
	public void registerProfileToUser(JourneyVO vo) throws IOException,PortletException, SQLException 
	 {
		
		   try {
			
			if(vo.getOp().equalsIgnoreCase("add"))
			   {
	    	    con = DataAccess.getUpgradeOptimizedConnection();
				st = con.createStatement();
				
			String sqlSt =  " insert into journey("
					+ "journeyId,"
					+"Title,"
					+"ShortDescription,"
					+"Date,"
					+"Description,"
					+"Pirvacy,"
					+"tag,"
					+ "userId,"
					+"category)"
			 		+ "  select  coalesce((select max(journeyId)+1 from journey),1) "
			 		+ ",'"+ vo.getTitle()+"'"
			 		+ ",'"+ vo.getShortDescription()+"'"
	 				+ ",'"+ vo.getDate()+"'"
					+ ",'"+ vo.getDescription()+"'"
					+ ",'"+ vo.getPirvacy()+"'"
					+ ",'"+ vo.getTag()+"'"
					+ ",'"+ vo.getUserId()+"'"
					+ ",'"+ vo.getCategory()+"'";
			 		
			 		// + " from dual" ;
		
			 System.out.println("sqlQuery:: "+ sqlSt);
			 
			 st = con.createStatement();
			 st.executeUpdate(sqlSt);

			   }
			else if(vo.getOp().equalsIgnoreCase("search") && vo.getUserId().length() > 0)
			   {
					
			   }
			else if(vo.getOp().equalsIgnoreCase("update"))
			   {
				con = DataAccess.getUpgradeOptimizedConnection();
				st = con.createStatement();
				String sqlUpdate =  " update journey"
						+ "  set Title = " + "'"+ vo.getTitle() + "'"
						+ " ,ShortDescription = " + "'"+ vo.getShortDescription() + "'"
						+ " ,Date = " + "'"+ vo.getDate() + "'"
						+ " ,Description = " + "'"+ vo.getDescription() + "'"
						+ " ,Pirvacy = " + "'"+ vo.getPirvacy()+ "'"
						+ " ,tag = " + "'"+ vo.getTag()+ "'"
						+ " ,category = " + "'"+ vo.getCategory()+ "'"
						+ " where journeyId = " + vo.getJourneyId();
				st = con.createStatement();
				System.out.println("sqlUpdate : " + sqlUpdate);
				 st.executeUpdate(sqlUpdate);
			   }
			else if(vo.getOp().equalsIgnoreCase("delete"))
			   {
				con = DataAccess.getUpgradeOptimizedConnection();
				st = con.createStatement();
				String deleteSql = "delete from journey where journeyId = " + vo.getJourneyId();
				System.out.println("delete : " + deleteSql);
				st = con.createStatement();
				st.executeUpdate(deleteSql);
			   }
		   }catch(Exception ex) {
			  ex.printStackTrace(); 
		   }
		   finally {
			   con.close(); 
	  			 st.close();
			 DataAccess.cleanUp(con, st);
		   }
	 }
	@Override
	public void serveResource(ResourceRequest actionRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			
			Gson g = new Gson();
			Object obj1 = null;
			obj1 = actionRequest.getParameter("obj");
			System.out.println("obj1 : " + String.valueOf(obj1));
			JourneyVO vo = g.fromJson((String) obj1, JourneyVO.class);
			System.out.println("userId : " + vo.getUserId());
			if (vo.getUserId().length() > 0 && vo.getOp().equalsIgnoreCase("search"))
				getData(vo.getUserId());
		    else
		    	registerProfileToUser(vo);
			 
			//System.out.println(" to string : " + jsonArr.toString());

//			if (op.equalsIgnoreCase("add"))
			{
				
				/*
				 * byte[] bytes = pictureBlob.getBytes(); Blob blob = new
				 * javax.sql.rowset.serial.SerialBlob(bytes); journey.setPictureBlob(blob);
				 */
			} /*
				 * else if (op.equalsIgnoreCase("delete")) {
				 * JourneyLocalServiceUtil.deleteJourney(Integer.parseInt(journeyId)); } else if
				 * (op.equalsIgnoreCase("update")) { Journey journey =
				 * JourneyLocalServiceUtil.createJourney(Long.parseLong(journeyId));
				 * journey.setDescription(Description); journey.setTitle(Title); byte[] bytes =
				 * pictureBlob.getBytes(); Blob blob = new
				 * javax.sql.rowset.serial.SerialBlob(bytes); journey.setPictureBlob(blob);
				 * journey.setUserId(user.getUserId()); journey =
				 * JourneyLocalServiceUtil.updateJourney(journey); }
				 */
			//else if()

			PrintWriter writer = resourceResponse.getWriter();
//			System.out.println("getData().toString() : " + getData(vo.getUserId()).toString());
			writer.write(getData(vo.getUserId()).toString());

			super.serveResource(actionRequest, resourceResponse);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
