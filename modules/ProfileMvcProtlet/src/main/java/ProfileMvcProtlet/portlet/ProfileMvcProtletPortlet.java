package ProfileMvcProtlet.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import org.osgi.service.component.annotations.Component;
import com.google.gson.Gson;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import ProfileMvcProtlet.constants.ProfileMvcProtletPortletKeys;
import vo.ProfileVO;

/**
 * @author mns
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ProfileMvcProtlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ProfileMvcProtletPortletKeys.PROFILEMVCPROTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProfileMvcProtletPortlet extends MVCPortlet {
	PrintWriter writer = null;
	JSONObject array = JSONFactoryUtil.createJSONObject();
    JSONArray    profileEducationArray = null
				,profileWorkExperienceArray = null
				,profileInfoArray = null
				,profileSocialMediaArray = null
				,profileLicensesCertificationsArray = null
				,profileVolunteerExperienceArray = null
				,profileskillsArray = null
				,profileLanguagesArray = null
				,profileIntrestArray = null
				,profileJobWishListArray = null
				,profileProjectArray = null
				,profilePublicationArray = null
				,ProfileHonourAndAwardsArray = null
				,profileTestimonialsArray = null
				,profileAchievementsAndAwards = null
                ,profileProgress = null;
	
	public void CustomRenderMethod(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException, PortletException {
	     String nameofjsp = ParamUtil.getString(actionRequest, "nameofjsp");
	     if(nameofjsp.equalsIgnoreCase("editProfile")){
	    	 actionResponse.setRenderParameter("mvcPath","editProfile.jsp");
	     }   
	}
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException 
    {	HttpServletRequest requestInsideThePortlet = PortalUtil.getHttpServletRequest(renderRequest);
		String userId =  PortalUtil.getOriginalServletRequest(requestInsideThePortlet).getParameter("userId");
		System.out.println("-----UserId first in profile---0" + "----"+userId);
		
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
	}
	
	public String registerProfileToUser(ProfileVO vo) throws IOException,PortletException, SQLException 
	 {
		   Connection con = null;
			Statement st = null;
			String s="1";
		
		   try {
			con = DataAccess.getUpgradeOptimizedConnection(); 
			
			if(vo.getCommand().equalsIgnoreCase("saveprofileImage"))
			   {
				String sqlQuery =" delete from profileImage where userId = " + vo.getUserId();
		    	 
		    	 
		    	    con = DataAccess.getUpgradeOptimizedConnection();
					st = con.createStatement();
					st.executeUpdate(sqlQuery);
					
				String sqlSt =  " insert into profileImage(uuid_, id_,"
					    + "                image,"
				 		+ "                userId  )"
				 		+ "  select  coalesce((select max(id_)+1 from profileImage),1) "
				 		+ ", coalesce((select max(id_)+1 from profileImage),1) "
				 		+ ",'"+ vo.getImage()+"'"
				 		+ ",'"+ vo.getUserId()+"'";
				 		// + " from dual" ;
			
				 System.out.println("sqlQuery:: "+ sqlSt);
				 
				 st = con.createStatement();
				 st.executeUpdate(sqlSt);
			   }
			else 
				if(vo.getCommand().equalsIgnoreCase("saveGeneralInfo"))
			   {
				 if(Long.valueOf(vo.getProfileId()) <= 0)
					   { 
				  String sqlSt =  " insert into profileInfo(uuid_, id_,"
								+ "				   title,"
						 		+ "                firstName, "
						 		+ "                fatherName ,  "
						 	//	+ "                grandfatherName    ,  "
						 		+ "                familyName,  "
						 		+ "                email      , "
						 		+ "                educationField      , "
						 		+ "                universitygeneral      , "
						 		+ "                primaryMobileNo  ,   "
						 	//	+ "				   secondaryMobileNo,"
						 		+ "                gender, "
						 		+ "                about, "
						 		+ "                nationality ,  "
						 	//	+ "                nationalId    ,  "
						 	//	+ "                passportId,  "
						 	//	+ "                passportExpireDate      , "
						 		+ "                dateOfBirth  ,   "
						 	//	+ "				   currentEducationTrainingStatus,"
						 		+ "                countryOfResidence, "
						 		+ "                cityOfResidence ,  "
						 		+ "                nationalAddress    ,  "
						 		+ "                postalCode,  "
						 		+ "                street      , "
						 		+ "                state_  ,   "
						 		+ "                currentworkposition      , "
						 		+ "                currentworklocation  ,   "
						 		+ "                primaryMobileNoCode  ,   "
						 		+ "                userId  )"
						 		+ "  select  coalesce((select max(id_)+1 from profileInfo),1)"
						 		+ ", coalesce((select max(id_)+1 from profileInfo),1) "
						 		+ ",'"+ vo.getTitle()+"'"
						 		+ ",'"+ vo.getFirstname()+"'"
						 		+ ",'"+ vo.getFatherName()+"'"
						 	//	+ ",'"+ vo.getGrandfathername()+"'"
						 		+ ",'"+ vo.getFamilyname()+"'"
						 		+ ",'"+ vo.getEmail()+"'"
				 				+ ",'"+ vo.getEducationField()+"'"
		 						+ ",'"+ vo.getUniversitygeneral()+"'"
						 		+ ",'"+ vo.getMobileno()+"'"
				 			//	+ ",'"+ vo.getMobileno2()+"'"
						 		+ ",'"+ vo.getGender()+"'"
						 		+ ",'"+ vo.getAbout()+"'"
						 		+ ",'"+ vo.getCountryofresidence()+"'"
						 	//	+ ",'"+ vo.getNationalid()+"'"
						 	//	+ ",'"+ vo.getPassportid()+"'"
						 	//	+ ",'"+ vo.getPassportexpiredate()+"'"
						 		+ ",'"+ vo.getDateofbirth()+"'"
				 			//	+ ",'"+ vo.getEducation()+"'"
						 		+ ",'"+ vo.getCityofresidence()+"'"
						 		+ ",'"+ vo.getNationaladdress()+"'"
						 		+ ",'"+ vo.getPostalcode()+"'"
						 		+ ",'"+ vo.getStreet()+"'"
						 		+ ",'"+ vo.getRegion()+"'"
						 		+ ",'"+ vo.getState()+"'"
						 		+ ",'"+ vo.getCurrentworkposition()+"'"
						 		+ ",'"+ vo.getCurrentworklocation()+"'"
				 				+ ",'"+ vo.getMobilenocode()+"'"
						 		+ ",'"+ vo.getUserId()+"'";
						 		// + " from dual" ;
					
			 System.out.println("sqlQuery:: "+ sqlSt);
			 
			 st = con.createStatement();
			 st.executeUpdate(sqlSt);
			
					   }
				 else
				 {
					String sqlSt = "UPDATE profileInfo " + 
								   "  SET  userId = " + vo.getUserId() + 
								   "      ,title = '"+ vo.getTitle() + "'" + 
								   "      ,firstName = '"+ vo.getFirstname().replaceAll("'", "''")   + "'" + 
								   "      ,fatherName = '"+ vo.getFatherName().replaceAll("'", "''")   + "'" + 
								//   "      ,grandfatherName = '"+ vo.getGrandfathername()  + "'" + 
								   "      ,familyName = '"+ vo.getFamilyname().replaceAll("'", "''")   + "'" + 
								   "      ,email = '"+ vo.getEmail().replaceAll("'", "''")   + "'" + 
								   "      ,universitygeneral = '"+ vo.getUniversitygeneral().replaceAll("'", "''")   + "'" + 
								   "      ,educationField = '"+ vo.getEducationField()  + "'" + 
								   "      ,primaryMobileNo = '"+ vo.getMobileno() + "'" +  
								   "      ,primaryMobileNoCode = '"+ vo.getMobilenocode() + "'" +
								//   "      ,secondaryMobileNo = '"+ vo.getMobileno2() + "'" + 
								   "      ,gender = '"+ vo.getGender()  + "'" + 
								   "      ,about = '"+ vo.getAbout().replaceAll("'", "''") + "'" + 
								   "      ,nationality = '"+ vo.getRegion()  + "'" ;
					if(vo.getNationalid()!=null && !"".equals(vo.getNationalid()))
					{
						sqlSt += "      ,nationalId = '"+ vo.getNationalid()  + "'" ;
					}
					if(vo.getPassportid()!=null && !"".equals(vo.getPassportid()))
					{
						sqlSt += "      ,passportId = '"+ vo.getPassportid()  + "'"  ;
					}
					if(vo.getPassportexpiredate()!=null && !"".equals(vo.getPassportexpiredate()))
					{
						sqlSt += "      ,passportExpireDate = '"+ vo.getPassportexpiredate()  + "'";
					}
								  
					sqlSt +=	   "      ,nationalAddress = '"+ vo.getNationaladdress()  + "'" + 
								   "      ,dateOfBirth = '"+ vo.getDateofbirth() + "'" +  
								 //  "      ,currentEducationTrainingStatus = '"+ vo.getEducation() + "'" + 
								   "      ,countryOfResidence = '"+ vo.getCountryofresidence()  + "'" + 
								   "      ,cityOfResidence = '"+ vo.getCityofresidence()  + "'" + 
								   "      ,postalCode = '"+ vo.getPostalcode()  + "'" + 
								   "      ,street = '"+ vo.getStreet()  + "'" + 
								   "      ,state_ = '"+ vo.getState()  + "'" +  
								   "      ,currentworkposition = '"+ vo.getCurrentworkposition()  + "'" + 
								   "      ,currentworklocation = '"+ vo.getCurrentworklocation()  + "'" + 
								   " WHERE Id_ = "+vo.getProfileId();
			   
					   System.out.println("sqlQuery:: "+ sqlSt);
						 
					   st = con.createStatement();
					   st.executeUpdate(sqlSt);
				 }
			   }
			else 
		  if(vo.getCommand().equalsIgnoreCase("addusereducation"))
			   {
				   System.out.println("vo.getEducationId() : "+ vo.getEducationId());
				   if(Long.valueOf(vo.getEducationId()) <= 0)
				   {    
					String sqlSt =  " insert into  profileEducation(uuid_, id, degree,"
						 		+ "                description, "
						 		+ "                educationCategory ,  "
						 		+ "                endYear    ,  "
						 		+ "                educatetillnow    ,  "
						 		+ "                educateJourney    ,  "
						 		+ "                fieldOfStudy,  "
						 		+ "                grade      , "
						 		+ "                startYear  ,   "
						 		+ "                userId  )"
						 		+ " select  coalesce((select max(id)+1 from profileEducation),1)"
						 		+ ", coalesce((select max(id)+1 from profileEducation),1) "
						 		+ ",'"+ vo.getDegree()+"'"
						 		+ ",'"+ vo.getEducationdescription().replaceAll("'", "''")+"'"
						 		+ ",'"+ vo.getUniversity().replaceAll("'", "''")+"'";
						 	if(vo.getendYear().isEmpty())
						 		sqlSt += ","+ null;
						 			else
						 		sqlSt += ",'"+ vo.getendYear()+"'";
						 sqlSt +=  ",'"+ vo.getEducatetillnow()+"'"	
						 		+ ",'"+ vo.getEducateJourney()+"'"
						 		+ ",'"+ vo.getfieldOfStudy()+"'"
						 		+ ",'"+ vo.getGrade()+"'"
						 		+ ",'"+ vo.getstartYear()+"'"
						 		+ ",'"+ vo.getUserId()+"'";
						 		// + " from dual" ;
					
					 System.out.println("sqlQuery:: "+ sqlSt);
					 
					
					 st = con.createStatement();
					 st.executeUpdate(sqlSt);
				   }
				   else
				   {   
					   String sqlSt =  "UPDATE profileEducation " + 
									   "  SET  userId = " + vo.getUserId() + 
									   "      ,educationCategory = '"+ vo.getUniversity().replaceAll("'", "''") + "'" + 
									   "      ,degree = '"+ vo.getDegree()  + "'" + 
									   "      ,fieldOfStudy = '"+ vo.getfieldOfStudy()  + "'" + 
									   "      ,startYear = '"+ vo.getstartYear()  + "'" ;
									   if(!vo.getendYear().isEmpty())
											 sqlSt +=  "      ,endYear = '"+ vo.getendYear()  + "'"; 
									   else
											 sqlSt +=  "      ,endYear = null"; 
							  sqlSt += "      ,educatetillnow = '"+ vo.getEducatetillnow()  + "'" + 
									   "      ,educateJourney = '"+ vo.getEducateJourney()  + "'" + 
									   "      ,grade = '"+ vo.getGrade()  + "'" + 
									   "      ,description = '"+ vo.getEducationdescription().replaceAll("'", "''")  + "'" +  
									   " WHERE Id = "+vo.getEducationId();
					   
					   System.out.println("sqlQuery:: "+ sqlSt);
						 
					   st = con.createStatement();
					   st.executeUpdate(sqlSt);
					
				   }
			   }  
		       else
				   if(vo.getCommand().equalsIgnoreCase("addWorkExperience"))
				   {  
					   
					   if(Long.valueOf(vo.getWorkexperienceId()) <= 0)
					   { 
						   
							String sqlSt =  " insert into profileWorkExperience(uuid_, id,"
									    + "                company,"
								 		+ "                title, "
								 		+ "                startDate ,  "
								 		+ "                endDate    ,  "
								 		+ "                worktillnow    ,  "
								 		+ "                workJourney    ,  "
								 		+ "                description,  "
								 		+ "                location      , "
								 		+ "                userId  )"
								 		+ " select  coalesce((select max(id)+1 from profileWorkExperience),1)"
								 		+ ", coalesce((select max(id)+1 from profileWorkExperience),1) "
								 		+ ",'"+ vo.getCompany().replaceAll("'", "''")+"'"
								 		+ ",'"+ vo.getJobtitle()+"'"
								 		+ ",'"+ vo.getWorkstartdate()+"'";
								 		if(vo.getWorkendate().isEmpty())
								 		sqlSt += ","+ null;
								 			else
								 		sqlSt += ",'"+ vo.getWorkendate()+"'";
								 		
								  sqlSt += ",'"+ vo.getWorktillnow()+"'"
								 		+ ",'"+ vo.getWorkJourney().replaceAll("'", "''")+"'"
						 				+ ",'"+ vo.getWorkdescription().replaceAll("'", "''")+"'"
								 		+ ",'"+ vo.getLocation().replaceAll("'", "''")+"'"
								 		+ ",'"+ vo.getUserId()+"'";
								 		// + " from dual" ;
							
							 System.out.println("sqlQuery:: "+ sqlSt);
							 
							 st = con.createStatement();
							 st.executeUpdate(sqlSt);
						
					   }
					   else
					   {
						   String sqlSt =  "UPDATE profileWorkExperience " + 
								   "       SET  userId = " + vo.getUserId() + 
								   "      ,company = '"+ vo.getCompany().replaceAll("'", "''") + "'" + 
								   "      ,title = '"+ vo.getJobtitle()  + "'" + 
								   "      ,startDate = '"+ vo.getWorkstartdate()  + "'" ; 
						   
									if(!vo.getWorkendate().isEmpty())
										 sqlSt +=  "      ,endDate = '"+ vo.getWorkendate()  + "'"; 
									else
										 sqlSt +=  "      ,endDate = null"; 
						  sqlSt += "      ,worktillnow = '"+ vo.getWorktillnow()  + "'" + 
								   "      ,workJourney = '"+ vo.getWorkJourney().replaceAll("'", "''")  + "'" + 
								   "      ,description = '"+ vo.getWorkdescription().replaceAll("'", "''")  + "'" + 
								   "      ,location = '"+ vo.getLocation().replaceAll("'", "''")  + "'" + 
								   " WHERE Id = "+vo.getWorkexperienceId();
				   
				   System.out.println("sqlQuery ssss :: "+ sqlSt);
					 
				   st = con.createStatement();
				   st.executeUpdate(sqlSt);
				     }
						   
				   }
				   else
					   if(vo.getCommand().equalsIgnoreCase("addWorkStatus"))
					   {
						   if(Long.valueOf(vo.getWorkstatusId()) <= 0)
						   { 
								String sqlSt =  " insert into profileWorkExperience(uuid_, id,"
											    + "                currentWorkStatus,"
										 		+ "                workExperience,"
										 		+ "                userId  )"
										 		+ "  select  coalesce((select max(id)+1 from profileWorkExperience),1) "
										 		+ ", coalesce((select max(id)+1 from profileWorkExperience),1) "
										 		+ ",'"+ vo.getCurrenworkstatus()+"'"
										 		+ ",'"+ vo.getWorkexprience()+"'"
										 		+ ",'"+ vo.getUserId()+"'";
										 		// + " from dual" ;
									
							 System.out.println("sqlQuery:: "+ sqlSt);
							 
							 st = con.createStatement();
							 st.executeUpdate(sqlSt);
						   }
						   else {
							   String sqlSt =  "UPDATE profileWorkExperience " + 
									   "       SET  userId = " + vo.getUserId() + 
									   "      ,currentWorkStatus = '"+ vo.getCurrenworkstatus() + "'" + 
									   "      ,workExperience = '"+ vo.getWorkexprience()  + "'" + 
									   " WHERE Id = "+vo.getWorkstatusId();
					   
					   System.out.println("sqlQuery:: "+ sqlSt);
						 
					   st = con.createStatement();
					   st.executeUpdate(sqlSt);
						
						   }
					   }else
							  if(vo.getCommand().equalsIgnoreCase("addlanguage"))
							   {
										String sqlSt =  " insert into profileLanguages(uuid_, id,"
											    + "                language,"
										 		+ "                proficiency,"
										 		+ "                userId  )"
										 		+ "  select  coalesce((select max(id)+1 from profileLanguages),1) "
										 		+ ", coalesce((select max(id)+1 from profileLanguages),1) "
										 		+ ",'"+ vo.getLanguage()+"'"
										 		+ ",'"+ vo.getLanguageproficiency()+"'"
										 		+ ",'"+ vo.getUserId()+"'";
										 		// + " from dual" ;
									
										 System.out.println("sqlQuery:: "+ sqlSt);
										 
										 st = con.createStatement();
										 st.executeUpdate(sqlSt);
								
							   }
							  else
								   if(vo.getCommand().equalsIgnoreCase("addsuserkills"))
								   {
										String sqlSt =  " insert into profileskills(uuid_, id,"
											    + "                skill,"
										 		//+ "                level,"
										 		+ "                userId  )"
										 		+ "  select  coalesce((select max(id)+1 from profileskills),1) "
										 		+ ", coalesce((select max(id)+1 from profileskills),1) "
										 		+ ",'"+ vo.getSkillname().replaceAll("'", "''")+"'"
										 		//+ ",'"+ vo.getSkilllevel()+"'"
										 		+ ",'"+ vo.getUserId()+"'"
										 		+"WHERE NOT EXISTS \r\n" + 
										 		"  (SELECT 1 FROM profileskills s WHERE skill='"+ vo.getSkillname().replaceAll("'", "''")+"'"
										 				+ " and s.userId = '"+ vo.getUserId()+"')";
										 		// + " from dual" ;
									
										 System.out.println("sqlQuery:: "+ sqlSt);
										 
										 st = con.createStatement();
										int i = st.executeUpdate(sqlSt);
										s = String.valueOf(i);
									
								   }
								   else
										  if(vo.getCommand().equalsIgnoreCase("addnewintrest"))
										   {
											  if(Long.valueOf(vo.getIntrestId()) <= 0)
											   { 
													String sqlSt =  " insert into profileIntrest(uuid_, id,"
														    + "                intrest,"
													 		+ "                userId  )"
													 		+ "  select  coalesce((select max(id)+1 from profileIntrest ),1) "
													 		+ ", coalesce((select max(id)+1 from profileIntrest ),1) "
													 		+ ",'"+ vo.getIntrest().replaceAll("'", "''")+"'"
													 		+ ",'"+ vo.getUserId()+"'"
											 				+ " where not exists (SELECT 1 FROM profileIntrest s "
											 				+ "        WHERE intrest='"+ vo.getIntrest().replaceAll("'", "''")+"'"
															 				+ " and s.userId = '"+ vo.getUserId()+"')";
													 		// + " from dual" ;
												
													 System.out.println("sqlQuery:: "+ sqlSt);
													 
													 st = con.createStatement();
													 st.executeUpdate(sqlSt);
											   }
											  else {
												  
												   String sqlSt =  "UPDATE profileIntrest " + 
														   "       SET  userId = " + vo.getUserId() + 
														   "      ,intrest = '"+ vo.getIntrest().replaceAll("'", "''") + "'" + 
														   " WHERE Id = "+vo.getIntrestId();
										   
												   System.out.println("sqlQuery:: "+ sqlSt);
													 
												   st = con.createStatement();
												   st.executeUpdate(sqlSt);
											  }
										   } 
										  else
											  if(vo.getCommand().equalsIgnoreCase("addnewjobwishlist"))
												   {
													String sqlSt =  " insert into ProfileJobWishList(uuid_, id,"
														    + "                jobwishlist,"
													 		+ "                userId  )"
													 		+ "  select  coalesce((select max(id)+1 from ProfileJobWishList ),1) "
													 		+ ", coalesce((select max(id)+1 from ProfileJobWishList ),1) "
													 		+ ",'"+ vo.getJobwishlist().replaceAll("'", "''")+"'"
													 		+ ",'"+ vo.getUserId()+"'"
													+"WHERE NOT EXISTS \r\n" + 
											 		"  (SELECT 1 FROM ProfileJobWishList s WHERE s.jobwishlist='"+ vo.getJobwishlist().replaceAll("'", "''")+"'"
									 				+ " and s.userId = '"+ vo.getUserId()+"')"; 		
													// + " from dual" ;
												
													 System.out.println("sqlQuery:: "+ sqlSt);
													 
													 st = con.createStatement();
													 int i = st.executeUpdate(sqlSt);
														 s = String.valueOf(i);
													  
												   } 
											  else
														  if(vo.getCommand().equalsIgnoreCase("adduserproject"))
														   {
															  if(Long.valueOf(vo.getProjectId()) <= 0)
															   {
																  String sqlSt  = " insert into profileProject(uuid_, id,"
																			    + "                projectName,"
																			    + "                projectURL,"
																			    + "                startDate,"
																			    + "                endDate,"
																			    + "                description,"
																			    + "                currentlyOnProject,"  
																			    + "                userId  )"
																		 		+ "  select  coalesce((select max(id)+1 from profileProject ),1) "
																		 		+ ", coalesce((select max(id)+1 from profileProject ),1) "
																		 		+ ",'"+ vo.getProjectname()+"'"
																		 		+ ",'"+ vo.getProjecturl()+"'"
																		 		+ ",'"+ vo.getProjectstartdate()+"'"
																		 		+ ",'"+ vo.getProjectenddate()+"'"
																		 		+ ",'"+ vo.getProjectdescription()+"'"
																		 		+ ",'"+ vo.getCredentailnotexpire()+"'"
																		 		+ ",'"+ vo.getUserId()+"'";
																		 		// + " from dual" ;
																
																	 System.out.println("sqlQuery:: "+ sqlSt);
																	 
																	 st = con.createStatement();
																	 st.executeUpdate(sqlSt);
																	 
															   }
															  else {
																  String sqlSt =  "UPDATE profileProject " + 
																		   "       SET  userId = " + vo.getUserId() + 
																		   "      ,projectName = '"+ vo.getProjectname() + "'" + 
																		   "      ,projectURL = '"+ vo.getProjecturl() + "'" + 
																		   "      ,startDate = '"+ vo.getProjectstartdate() + "'" + 
																		   "      ,endDate = '"+ vo.getProjectenddate() + "'" + 
																		   "      ,description = '"+ vo.getProjectdescription() + "'" + 
																		   "      ,currentlyOnProject = '"+ vo.getCredentailnotexpire() + "'" +
																		   " WHERE Id = "+vo.getProjectId();
														   
																   System.out.println("sqlQuery:: "+ sqlSt);
																	 
																   st = con.createStatement();
																   st.executeUpdate(sqlSt);
															  }
														   } 
														  else
															   if(vo.getCommand().equalsIgnoreCase("adduserlicenceandcertification"))
															   {
																   System.out.println("**********"+vo.getLicenceandcertificationId()+"*********");
																   if(Long.valueOf(vo.getLicenceandcertificationId()) <= 0)
																   {
																	   String sqlSt  = " insert into profileLicensesCertifications(uuid_, id,"
																			    + "                name,"
																			    + "                issuingOrganization,"
																			    + "                issueDate,"
																			    + "                expirationDate,"
																			 //   + "                credentialID,"
																			    + "                credentialURL,"  
																			    + "                certificateJourney,"  
																			   // + "                notExpire,"  
																			    + "                userId  )"
																		 		+ "  select  coalesce((select max(id)+1 from profileLicensesCertifications ),1) "
																		 		+ ", coalesce((select max(id)+1 from profileLicensesCertifications ),1) "
																		 		+ ",'"+ vo.getLicencename().replaceAll("'", "''")+"'"
																		 		+ ",'"+ vo.getIssuingorganization().replaceAll("'", "''")+"'"
																		 		+ ",'"+ vo.getIssuedate()+"'"
																		 		+ ",'"+ vo.getExpiredate()+"'"
																		 	//	+ ",'"+ vo.getCredentailid()+"'"
																		 		+ ",'"+ vo.getCredentailurl().replaceAll("'", "''")+"'"
																		 		+ ",'"+ vo.getCertificateJourney().replaceAll("'", "''")+"'"
																		 	//	+ ",'"+ vo.getCredentailnotexpire()+"'"
																		 		+ ",'"+ vo.getUserId()+"'";
																		 		// + " from dual" ;
																
																	 System.out.println("sqlQuery:: "+ sqlSt);
																	 
																	 st = con.createStatement();
																	 st.executeUpdate(sqlSt);
																   }
																   else {
																	   
																	   String sqlSt = " UPDATE profileLicensesCertifications " + 
																			   "        SET  userId = " + vo.getUserId() + 
																			   "       ,name = '"+ vo.getLicencename().replaceAll("'", "''") + "'" + 
																			   "       ,issuingOrganization = '"+ vo.getIssuingorganization().replaceAll("'", "''") + "'" + 
																			   "       ,issueDate = '"+ vo.getIssuedate() + "'" + 
																			   "       ,expirationDate = '"+ vo.getExpiredate() + "'" + 
																			  // "       ,credentialID = '"+ vo.getCredentailid() + "'" + 
																			   "       ,credentialURL = '"+ vo.getCredentailurl().replaceAll("'", "''") + "'" +
																			   "       ,certificateJourney = '"+ vo.getCertificateJourney().replaceAll("'", "''") + "'" +
																			//   "       ,notExpire = '"+ vo.getCredentailnotexpire() + "'" +
																			   " WHERE Id = "+vo.getLicenceandcertificationId();
															   
																	   System.out.println("sqlQuery:: "+ sqlSt);
																		 
																	   st = con.createStatement();
																	   st.executeUpdate(sqlSt);   
																   }
															   }
															   else
																   if(vo.getCommand().equalsIgnoreCase("adduservolunteerexperience"))
																   {
																	   if(Long.valueOf(vo.getVolunteerexpId()) <= 0)
																	   { 
																		 String sqlSt = " insert into profileVolunteerExperience(uuid_, id,"
																				    + "                organization,"
																				    + "                role,"
																				    + "                cause,"
																				    + "                startDate,"
																				    + "                endDate,"
																				    + "                description,"  
																				    + "                currentlyVolunteering,"  
																				    + "                userId  )"
																			 		+ "  select  coalesce((select max(id)+1 from profileVolunteerExperience ),1) "
																			 		+ ", coalesce((select max(id)+1 from profileVolunteerExperience ),1) "
																			 		+ ",'"+ vo.getVolunteerorganizationname()+"'"
																			 		+ ",'"+ vo.getVolunteerrole()+"'"
																			 		+ ",'"+ vo.getVolunteercause()+"'"
																			 		+ ",'"+ vo.getVolunteerstartdate()+"'"
																			 		+ ",'"+ vo.getVolunteerendate()+"'"
																			 		+ ",'"+ vo.getVolunteerdescription()+"'"
																			 		+ ",'"+ vo.getVolunteercurrent()+"'"
																			 		+ ",'"+ vo.getUserId()+"'";
																			 		// + " from dual" ;
																	
																		 System.out.println("sqlQuery:: "+ sqlSt);
																		 
																		 st = con.createStatement();
																		 st.executeUpdate(sqlSt);
																		}
																	   else
																	   {
																		   
																		   String sqlSt = " UPDATE profileVolunteerExperience " + 
																				   "        SET  userId = " + vo.getUserId() + 
																				   "       ,organization = '"+ vo.getVolunteerorganizationname() + "'" + 
																				   "       ,role = '"+ vo.getVolunteerrole() + "'" + 
																				   "       ,cause = '"+ vo.getVolunteercause() + "'" + 
																				   "       ,startDate = '"+ vo.getVolunteerstartdate() + "'" + 
																				   "       ,endDate = '"+ vo.getVolunteerendate() + "'" + 
																				   "       ,description = '"+ vo.getVolunteerdescription() + "'" +
																				   "       ,currentlyVolunteering = '"+ vo.getVolunteercurrent() + "'" +
																				   " WHERE Id = "+vo.getVolunteerexpId();
																   
																		   System.out.println("sqlQuery:: "+ sqlSt);
																			 
																		   st = con.createStatement();
																		   st.executeUpdate(sqlSt);  
																	   }
																   } else
																		  if(vo.getCommand().equalsIgnoreCase("adduserhonorandaward"))
																		   {
																			  if(Long.valueOf(vo.getHonorandawardId()) <= 0)
																			   {
																				  
																					 String sqlSt = " insert into ProfileHonourAndAwards(uuid_, id,"
																							    + "                honortitle,"
																							    + "                honorissuer,"
																							    + "                honorissuedate,"
																							    + "                issuedescription,"
																							    + "                userId  )"
																						 		+ "  select  coalesce((select max(id)+1 from ProfileHonourAndAwards ),1) "
																						 		+ ", coalesce((select max(id)+1 from ProfileHonourAndAwards ),1) "
																						 		+ ",'"+ vo.getHonortitle()+"'"
																						 		+ ",'"+ vo.getHonorissuer()+"'"
																						 		+ ",'"+ vo.getHonorissuedate()+"'"
																						 		+ ",'"+ vo.getIssuedescription()+"'"
																						 		+ ",'"+ vo.getUserId()+"'";
																						 		// + " from dual" ;
																				
																					 System.out.println("sqlQuery:: "+ sqlSt);
																					 
																					 st = con.createStatement();
																					 st.executeUpdate(sqlSt);
																			   } else
																			   {
																				   String sqlSt = " UPDATE ProfileHonourAndAwards " + 
																						   "        SET  userId = " + vo.getUserId() + 
																						   "       ,honortitle = '"+ vo.getHonortitle() + "'" + 
																						   "       ,honorissuer = '"+ vo.getHonorissuer() + "'" + 
																						   "       ,honorissuedate = '"+ vo.getHonorissuedate() + "'" + 
																						   "       ,issuedescription = '"+ vo.getIssuedescription() + "'" + 
																						   "   WHERE Id = "+vo.getHonorandawardId();
																		   
																				   System.out.println("sqlQuery:: "+ sqlSt);
																					 
																				   st = con.createStatement();
																				   st.executeUpdate(sqlSt);  
																			   }
																			  
																		   }  else
																				  if(vo.getCommand().equalsIgnoreCase("addtestimonial"))
																				   {
																					  if(Long.valueOf(vo.getTestimonialproviderId()) <= 0)
																					   {
																							 String sqlSt = " insert into ProfileTestimonial(uuid_, id_,"
																									    + "                testimonialprovidername,"
																									    + "                testimonialprovideremail,"
																									    + "                testimonialprovorgname,"
																									    + "                testimonialprovidertitle,"
																									    + "                testimonialprivatemessage,"
																									    + "                imagePreview,"
																									    + "                userId  )"
																								 		+ "  select  coalesce((select max(id_)+1 from ProfileTestimonial ),1) "
																								 		+ ", coalesce((select max(id_)+1 from ProfileTestimonial ),1) "
																								 		+ ",'"+ vo.getTestimonialprovidername().replaceAll("'", "''")+"'"
																								 		+ ",'"+ vo.getTestimonialprovideremail().replaceAll("'", "''")+"'"
																								 		+ ",'"+ vo.getTestimonialprovideorganizationname().replaceAll("'", "''")+"'"
																								 		+ ",'"+ vo.getTestimonialprovidertitle()+"'"
																						 				+ ",'"+ vo.getTestimonialprivatemessage().replaceAll("'", "''")+"'"
																								 		+ ",'"+ vo.getImagePreview()+"'"
																								 		+ ",'"+ vo.getUserId()+"'";
																								 		// + " from dual" ;
																						
																							 System.out.println("sqlQuery:: "+ sqlSt);
																							 
																							 st = con.createStatement();
																							 st.executeUpdate(sqlSt);
																					   } else
																					   {
																						   String sqlSt = " UPDATE ProfileTestimonial " + 
																								   "        SET  userId = " + vo.getUserId() + 
																								   "       ,testimonialprovidername = '"+ vo.getTestimonialprovidername().replaceAll("'", "''") + "'" + 
																								   "       ,testimonialprovideremail = '"+ vo.getTestimonialprovideremail().replaceAll("'", "''") + "'" + 
																								   "       ,testimonialprovorgname = '"+ vo.getTestimonialprovideorganizationname().replaceAll("'", "''") + "'" + 
																								   "       ,testimonialprovidertitle = '"+ vo.getTestimonialprovidertitle() + "'" + 
																								   "       ,testimonialprivatemessage = '"+ vo.getTestimonialprivatemessage().replaceAll("'", "''") + "'" + 
																								   "       ,imagePreview = '"+ vo.getImagePreview() + "'" + 
																								   "   WHERE Id_ = "+vo.getTestimonialproviderId();
																				   
																						   System.out.println("sqlQuery:: "+ sqlSt);
																							 
																						   st = con.createStatement();
																						   st.executeUpdate(sqlSt);  
																					   }
																					  
																				   } else
																				  if(vo.getCommand().equalsIgnoreCase("addluserpublication"))
																				   {
																					  if(Long.valueOf(vo.getPublicationId()) <= 0)
																					   {

																							 String sqlSt = " insert into profilePublication(uuid_, id,"
																									    + "                publicationTitle,"
																									    + "                publicationType,"
																									    + "                role,"
																									    + "                url,"
																									    + "                date_,"
																									    + "                userId  )"
																								 		+ "  select  coalesce((select max(id)+1 from profilePublication ),1) "
																								 		+ ", coalesce((select max(id)+1 from profilePublication ),1) "
																								 		+ ",'"+ vo.getPublicationsubject()+"'"
																								 		+ ",'"+ vo.getPublicationtype()+"'"
																								 		+ ",'"+ vo.getPublicationrole()+"'"
																								 		+ ",'"+ vo.getPublicationurl()+"'"
																								 		+ ",'"+ vo.getPublishingdate()+"'"
																								 		+ ",'"+ vo.getUserId()+"'";
																								 		// + " from dual" ;
																						
																							 System.out.println("sqlQuery:: "+ sqlSt);
																							 
																							 st = con.createStatement();
																							 st.executeUpdate(sqlSt);
																				   }else
																				   {
																					   String sqlSt =  " UPDATE profilePublication " + 
																									   "        SET  userId = " + vo.getUserId() + 
																									   "       ,publicationTitle = '"+ vo.getPublicationsubject() + "'" + 
																									   "       ,publicationType = '"+ vo.getPublicationtype() + "'" + 
																									   "       ,role = '"+ vo.getPublicationrole() + "'" + 
																									   "       ,date_ = '"+ vo.getPublishingdate() + "'" + 
																									   "   WHERE Id = "+vo.getPublicationId();
																			   
																					   System.out.println("sqlQuery:: "+ sqlSt);
																						 
																					   st = con.createStatement();
																					   st.executeUpdate(sqlSt);  
																				
																				   }
																				   
																				   }
										   
		   }  catch (Exception e) {
				e.printStackTrace();
			}
		   finally
		   {         con.close(); 
		  			 st.close();
					 DataAccess.cleanUp(con, st);
					 
			   
		   }
		   return s;
	 }
	
	public void getUserProfileDetails(String section,long userId)
	{ 
		
		array = JSONFactoryUtil.createJSONObject();
		 if(section.equalsIgnoreCase("all") || "achievementsAndAwards".equalsIgnoreCase(section))
		   {
			 System.out.println("-- getUserProfileDetails:: ");
			   array.put("profileEducation", getProfileEducationInfo(userId));
			   array.put("profileWorkExperience", getProfileWorkExperienceInfo(userId));
			  // array.put("profileLanguages", getprofileLanguagesInfo(userId)); 
			   array.put("profileUserkills", getprofileUserkillsInfo(userId)); 
			   array.put("profileIntrest",getprofileIntrestInfo(userId));
			   array.put("profileJobWishList",getprofileJobWishListInfo(userId));  
			   //array.put("profileProjects",getprofileProjectInfo(userId));
			   array.put("profileLicensesCertifications",getprofileLicensesCertificationsInfo(userId));
			   array.put("profileTestimonials",getprofileTestimonialsInfo(userId)); 
			   array.put("profileAchievementsAndAwards", getBadgeInformation(String.valueOf(userId)));
			   array.put("profileProgress", getProgressInformation(String.valueOf(userId)));
			  // array.put("profileVolunteerExperience",getprofileVolunteerExperienceInfo(userId));
			 //  array.put("ProfileHonourAndAwards",getProfileHonourAndAwardsInfo(userId));
			//   array.put("profilePublication",getprofilePublicationInfo(userId));
		   }
		 else 
	    	  if(section.equalsIgnoreCase("achievementsAndAwards"))
			   {
	    		  array.put("profileAchievementsAndAwards", getBadgeInformation(String.valueOf(userId)));
	    		  array.put("profileProgress", getProgressInformation(String.valueOf(userId)));
			   }
		    else 
		    	  if(section.equalsIgnoreCase("userIntrest"))
				   {
		    		  array.put("profileIntrest",getprofileIntrestInfo(userId));
				   } else 
				    	  if(section.equalsIgnoreCase("userLicensesandCertification"))
						   {
				    		  array.put("profileLicensesCertifications",getprofileLicensesCertificationsInfo(userId));
						   }
				    	   else 
						    	  if(section.equalsIgnoreCase("userjobwishlist"))
								   {
						    		  array.put("profileJobWishList",getprofileJobWishListInfo(userId));  
								   } else 
								    	  if(section.equalsIgnoreCase("userEducationSaved"))
										   {
								    		  array.put("profileEducation", getProfileEducationInfo(userId));
										   }else 
										    	  if(section.equalsIgnoreCase("userWorkexperienceSaved"))
												   {
										   		     array.put("profileWorkExperience", getProfileWorkExperienceInfo(userId));
												   } else 
												    	  if(section.equalsIgnoreCase("userkills"))
														   {
												    		   array.put("profileUserkills", getprofileUserkillsInfo(userId)); 
														   } else 
														    	  if(section.equalsIgnoreCase("userTestimonial"))
																   {
														    			 array.put("profileTestimonials",getprofileTestimonialsInfo(userId)); 
																   }
System.out.println("************** array"+array);
	}
	public String returnImagetestimo(String testId)
	{
		String s= "";
		return s;
		
	}
	public JSONArray getprofileTestimonialsInfo(Long userId)
	{
		   Connection con = null;
	    	Statement st = null;
	    	profileTestimonialsArray = JSONFactoryUtil.createJSONArray();
	    	
			try {
				 String sqlQuery = " select * "
					 		+ "            from ProfileTestimonial "
					 		+ "  where userId = " + userId +" and id_ = 11 " ;

					con = DataAccess.getUpgradeOptimizedConnection();
					st = con.createStatement();
					ResultSet rs = st.executeQuery(sqlQuery);
					
						   while (rs.next()) 
						   {
							   JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
							   jsonObject.put("name", rs.getString("testimonialprovidername"));
							   jsonObject.put("organization", rs.getString("testimonialprovorgname"));
							   jsonObject.put("title", rs.getString("testimonialprovidertitle"));
							   jsonObject.put("message", rs.getString("testimonialprivatemessage"));
							   jsonObject.put("img", rs.getString("imagePreview"));
							   jsonObject.put("id", rs.getString("id_"));
							   profileTestimonialsArray.put(jsonObject);
							}
						     con.close(); 
				  			 st.close();  
			 }  catch (Exception e) {
					e.printStackTrace();
				}
			   finally
			   {         
						 DataAccess.cleanUp(con, st);
			   }
			 return profileTestimonialsArray;
	}
	public JSONArray getprofilePublicationInfo(Long userId)
	{   Connection con = null;
    	Statement st = null;
    	profilePublicationArray = JSONFactoryUtil.createJSONArray();
    	
		try {
			 String sqlQuery = " select * "
				 		+ "            from profilePublication "
				 		+ "  where userId = " + userId  ;

				con = DataAccess.getUpgradeOptimizedConnection();
				st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlQuery);
				
					   while (rs.next()) 
					   {
						   JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
						   jsonObject.put("title", rs.getString("publicationTitle"));
						   jsonObject.put("ptype", rs.getString("publicationType"));
						   jsonObject.put("prole", rs.getString("role"));
						   jsonObject.put("purl", rs.getString("url"));
						   jsonObject.put("pdate", rs.getString("date_"));
						   jsonObject.put("id", rs.getString("id"));
						   profilePublicationArray.put(jsonObject);
						}
					     con.close(); 
			  			 st.close();  
		 }  catch (Exception e) {
				e.printStackTrace();
			}
		   finally
		   {         
					 DataAccess.cleanUp(con, st);
		   }
		 return profilePublicationArray;
	}
	public JSONArray getProfileHonourAndAwardsInfo(Long userId)
	{  	Connection con = null;
        Statement st = null;
        ProfileHonourAndAwardsArray = JSONFactoryUtil.createJSONArray();
		 try {
			 
			 String sqlQuery = " select * "
				 		+ "            from ProfileHonourAndAwards "
				 		+ "  where userId = " + userId  ;

				con = DataAccess.getUpgradeOptimizedConnection();
				st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlQuery);
				
					   while (rs.next()) 
					   {
						   JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
						   jsonObject.put("title", rs.getString("honortitle"));
						   jsonObject.put("honorissuer", rs.getString("honorissuer"));
						   jsonObject.put("issuedate", rs.getString("honorissuedate"));
						   jsonObject.put("id", rs.getString("id"));
						   ProfileHonourAndAwardsArray.put(jsonObject);
						}
					   con.close(); 
			  			 st.close();  
		  }  catch (Exception e) {
				e.printStackTrace();
			}
		   finally
		   {         
					 DataAccess.cleanUp(con, st);
		   }
		 return ProfileHonourAndAwardsArray;
	}
	public JSONArray getprofileVolunteerExperienceInfo(Long userId)
	{  	Connection con = null;
        Statement st = null;
        profileVolunteerExperienceArray = JSONFactoryUtil.createJSONArray();
		 try {
			 String sqlQuery = " select * "
				 		+ "            from profileVolunteerExperience "
				 		+ "  where userId = " + userId  ;

				con = DataAccess.getUpgradeOptimizedConnection();
				st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlQuery);
				
					   while (rs.next()) 
					   {
						   JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
						   jsonObject.put("currentlyVolunteering", rs.getString("currentlyVolunteering"));
						   jsonObject.put("name", rs.getString("organization"));
						   jsonObject.put("role", rs.getString("role"));
						   jsonObject.put("cause", rs.getString("cause"));
						   jsonObject.put("startdate", rs.getString("startDate"));
						   jsonObject.put("endate", rs.getString("endDate"));
						   jsonObject.put("description", rs.getString("description"));
						   jsonObject.put("id", rs.getString("id"));
						   profileVolunteerExperienceArray.put(jsonObject);
						}

					   con.close(); 
			  		   st.close();  
		 }  catch (Exception e) {
				e.printStackTrace();
			}
		   finally
		   {         
					 DataAccess.cleanUp(con, st);
		   }
		 return profileVolunteerExperienceArray;
	}
	public JSONArray getprofileLicensesCertificationsInfo(Long userId)
	{    	Connection con = null;
		    Statement st = null;
		    DateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
		    String pattern = "yyyy-MM-dd";
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		    profileLicensesCertificationsArray = JSONFactoryUtil.createJSONArray();
		 try {
		String sqlQuery = " select * from profileLicensesCertifications "
				 		+ "  where userId = " + userId + " order by issueDate desc ";

				con = DataAccess.getUpgradeOptimizedConnection();
				st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlQuery);
				
					   while (rs.next()) 
					   {
						   JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
						   //jsonObject.put("userId", e.getUserId());
						   jsonObject.put("title", rs.getString("name"));
						   jsonObject.put("Iorganization", rs.getString("issuingOrganization"));
						   jsonObject.put("CredentialID", rs.getString("credentialID"));
						   jsonObject.put("CredentialUrl", rs.getString("credentialURL"));
						   jsonObject.put("certificateJourney", rs.getString("certificateJourney"));
						   jsonObject.put("ExpirationDate", rs.getString("expirationDate"));
						   Date date = simpleDateFormat.parse(rs.getString("issueDate").substring(0,10));
						   jsonObject.put("CreateDate", rs.getString("issueDate"));
						   jsonObject.put("CreateDateFrm", formatter.format(date.getTime()));
						   jsonObject.put("id", rs.getString("id"));
						   profileLicensesCertificationsArray.put(jsonObject);
						}
			   
					   con.close(); 
			  			 st.close();  
		 }  catch (Exception e) {
				e.printStackTrace();
			}
		   finally
		   {         
					 DataAccess.cleanUp(con, st);
		   }
		 return profileLicensesCertificationsArray;
	}
	public JSONArray getprofileProjectInfo(Long userId)
	{  	Connection con = null;
        Statement st = null;
        profileProjectArray = JSONFactoryUtil.createJSONArray();
       try {
    	   
    	   String sqlQuery = " select * "
			 		+ "            from profileProject "
			 		+ "  where userId = " + userId  ;

			con = DataAccess.getUpgradeOptimizedConnection();
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sqlQuery);
			
				   while (rs.next()) 
				   {
					   JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
					   //jsonObject.put("userId", e.getUserId());
					   jsonObject.put("title", rs.getString("projectName"));
					   jsonObject.put("url", rs.getString("projectURL"));
					   jsonObject.put("startdate", rs.getString("startDate"));
					   jsonObject.put("endate", rs.getString("endDate"));
					   jsonObject.put("id", rs.getString("id"));
					   profileProjectArray.put(jsonObject);
					}
			
				   con.close(); 
		  			 st.close();  
	 }  catch (Exception e) {
			e.printStackTrace();
		}
	   finally
	   {         
				 DataAccess.cleanUp(con, st);
	   }
	  return profileProjectArray;
	}
	public JSONArray getprofileJobWishListInfo(Long userId)
	{
		Connection con = null;
        Statement st = null;
        profileJobWishListArray = JSONFactoryUtil.createJSONArray();
		try {
			  String sqlQuery = " select * "
				 		+ "            from ProfileJobWishList "
				 		+ "  where userId = " + userId  ;

				con = DataAccess.getUpgradeOptimizedConnection();
				st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlQuery);
				
					   while (rs.next()) 
					   {
						   JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
						   //jsonObject.put("userId", e.getUserId());
						   jsonObject.put("jobwishlist", rs.getString("jobwishlist"));
						   jsonObject.put("id", rs.getString("id"));
						   profileJobWishListArray.put(jsonObject);
						}
					   
					   con.close(); 
			  			 st.close();  
		 }  catch (Exception e) {
				e.printStackTrace();
			}
		   finally
		   {         
					 DataAccess.cleanUp(con, st);
		   }
		return profileJobWishListArray;
	}
	public JSONArray getprofileIntrestInfo(Long userId)
	{   Connection con = null;
        Statement st = null;
    	profileIntrestArray = JSONFactoryUtil.createJSONArray();
		try {
		    String sqlQuery = " select * "
					 		+ "            from profileIntrest "
					 		+ "  where userId = " + userId  ;
System.out.println("**************** sqlQuery : "+sqlQuery);
					con = DataAccess.getUpgradeOptimizedConnection();
					st = con.createStatement();
					ResultSet rs = st.executeQuery(sqlQuery);
					
						   while (rs.next()) 
						   {
							   JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
							   //jsonObject.put("userId", e.getUserId());
							   jsonObject.put("title", rs.getString("intrest"));
							   jsonObject.put("id", rs.getString("id"));
							   profileIntrestArray.put(jsonObject);
							}
		
						   con.close(); 
				  			 st.close();  
			 }  catch (Exception e) {
					e.printStackTrace();
				}
			   finally
			   {         
						 DataAccess.cleanUp(con, st);
			   }
		 return profileIntrestArray;
	}
	public JSONArray getprofileUserkillsInfo(Long userId)
	{  	Connection con = null;
	    Statement st = null;
	    profileskillsArray = JSONFactoryUtil.createJSONArray();
		 try {
			 
			   String sqlQuery =  " select * "
				 		+ "            from profileskills "
				 		+ "  where userId = " + userId  ;

				con = DataAccess.getUpgradeOptimizedConnection();
				st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlQuery);
				
					   while (rs.next()) 
					   {
						   JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
						   //jsonObject.put("userId", e.getUserId());
						   jsonObject.put("skill", rs.getString("skill"));
						   //jsonObject.put("level", rs.getString("level"));
						   jsonObject.put("id", rs.getString("id"));
						   profileskillsArray.put(jsonObject);
						}
			 
					   con.close(); 
			  			 st.close();  
		 }  catch (Exception e) {
				e.printStackTrace();
			}
		   finally
		   {         
					 DataAccess.cleanUp(con, st);
		   }
	  return profileskillsArray;
	}
	public JSONArray getprofileLanguagesInfo(Long userId)
	{     
		Connection con = null;
		Statement st = null;
		profileLanguagesArray = JSONFactoryUtil.createJSONArray();
		   try {
			   String sqlQuery =  " select * "
						 		+ "            from profileLanguages "
						 		+ "  where userId = " + userId  ;
		 
         con = DataAccess.getUpgradeOptimizedConnection();
		 st = con.createStatement();
		 ResultSet rs = st.executeQuery(sqlQuery);
	 
			   while (rs.next()) 
			   {
				   JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				   //jsonObject.put("userId", e.getUserId());
				   jsonObject.put("language", rs.getString("language"));
				   jsonObject.put("proficiency", rs.getString("proficiency"));
				   jsonObject.put("id", rs.getString("id"));
				   profileLanguagesArray.put(jsonObject);
				}
			   
			   con.close(); 
	  			 st.close();  
			}  catch (Exception e) {
					e.printStackTrace();
				}
			 finally
			 {         
						 DataAccess.cleanUp(con, st);
			 }
		   return profileLanguagesArray;
		
	}
	
	public JSONArray getProfileEducationInfo(Long userId)
	{     
		Connection con = null;
		Statement st = null;
		   profileEducationArray = JSONFactoryUtil.createJSONArray();
		   try {
		 String sqlQuery =" select * "
				 		+ " from profileEducation "
				 		+ " where userId = " + userId  
				 		+ " order by startYear desc";
		 
         con = DataAccess.getUpgradeOptimizedConnection();
		 st = con.createStatement();
		 ResultSet rs = st.executeQuery(sqlQuery);
	 
			   while (rs.next()) 
			   {
				   JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				   //jsonObject.put("userId", e.getUserId());
				   jsonObject.put("degree", rs.getString("degree"));
				   jsonObject.put("description", rs.getString("description"));
				   jsonObject.put("educationCategory",rs.getString("educationCategory"));
				   jsonObject.put("endYear", rs.getString("endYear"));
				   jsonObject.put("educatetillnow", rs.getString("educatetillnow"));
				   jsonObject.put("educateJourney", rs.getString("educateJourney"));
				   jsonObject.put("fieldOfStudy",rs.getString("fieldOfStudy"));
				   jsonObject.put("grade", rs.getString("grade"));
				   jsonObject.put("startYear",rs.getString("startYear"));
				   jsonObject.put("userName", rs.getString("userName"));
				   jsonObject.put("id", rs.getString("id"));
				   profileEducationArray.put(jsonObject);
				}
			
			   con.close(); 
	  			 st.close();  
				}  catch (Exception e) {
						e.printStackTrace();
					}
				 finally
				 {         
							 DataAccess.cleanUp(con, st);
				 }
		   return profileEducationArray;
		
	}
	public JSONArray getProfileWorkExperienceInfo(Long userId)
	{
		Connection con = null;
		Statement st = null;
		 
		//List<profileWorkExperience> workexperiences = profileWorkExperienceLocalServiceUtil.getprofileWorkExperienceByUserId(userId);
		   profileWorkExperienceArray = JSONFactoryUtil.createJSONArray();
		   try {
			   
			   String sqlQuery =" select * "
				 		+ "            from profileWorkExperience "
				 		+ "  where userId = " + userId  + " order by startDate desc";

				con = DataAccess.getUpgradeOptimizedConnection();
				st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlQuery);
				LocalDate startDate, endDate = null; 
				Date today = null;
				Period period = null;
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String str = "";
				int nbMonth = 0;
				
				  while (rs.next()) 
				  {
					   JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
					   jsonObject.put("userId", rs.getString("userId"));
					   jsonObject.put("currentWorkStatus", rs.getString("currentWorkStatus"));
					   jsonObject.put("description", rs.getString("description"));
					   jsonObject.put("endDate", rs.getString("endDate"));
					   jsonObject.put("worktillnow", rs.getString("worktillnow"));
					   jsonObject.put("workJourney", rs.getString("workJourney"));
					   jsonObject.put("startDate", rs.getString("startDate"));
					   jsonObject.put("location", rs.getString("location"));
					   jsonObject.put("userName", rs.getString("userName"));
					   jsonObject.put("workExperience", rs.getString("workExperience"));
					   jsonObject.put("company", rs.getString("company"));
					   jsonObject.put("title", rs.getString("title"));
					   jsonObject.put("id", rs.getString("id"));
						   
				       startDate = LocalDate.parse(rs.getString("startDate").substring(0,10));
				       endDate = null; 
				       if(rs.getString("worktillnow").equals("true")) {
				    	   today = new Date();
				    	   endDate = LocalDate.parse(formatter.format(today)); 
				       }
				       else {
				    	   endDate = LocalDate.parse(rs.getString("endDate").substring(0,10)); 
				       }
				       period = Period.between(startDate, endDate); 
					   str = "";
					   if(period.getYears() > 0)
						   str += period.getYears() + " Year(s) ";
					   
					   if(period.getDays() > 20) { nbMonth = (period.getMonths()+1) ;}
					   else { 
						   if(period.getMonths() > 0) { nbMonth = period.getMonths();}
						   else { nbMonth = period.getMonths(); }
					   }
					   if(nbMonth > 0)
						   str += nbMonth + " Month(s) ";
					   jsonObject.put("duration", str);
					   profileWorkExperienceArray.put(jsonObject);
				}
		  
			  con.close(); 
			  st.close();  
			}  catch (Exception e) {
				e.printStackTrace();
			}
			finally
			{         
				 DataAccess.cleanUp(con, st);
			}
		return  profileWorkExperienceArray;
	}
	
	public ProfileVO getprofileInfo(Long userId)
	{  
		ProfileVO f=null;
		Connection con = null;
		Statement st = null;
	    SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	    SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
//	    Date date = null;
		 try {    
			 
			 System.out.println("test " +userId);
		// info = profileInfoLocalServiceUtil.getProfileInfoByUserId(userId);
			 f = new ProfileVO();
			 System.out.println(1111111);
		     con = DataAccess.getUpgradeOptimizedConnection();
			 st = con.createStatement();
			 User usr = UserServiceUtil.getUserById(Long.parseLong(String.valueOf(userId)));
			 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			 String sqlQuery = "insert into profileInfo(uuid_ ,id_,companyId,userId,firstName,fatherName,familyName,title,email,primaryMobileNo,"
			 		 + " dateOfBirth)" 
//			 		 + " isEmailVerified,isMobileVerified,dateOfBirth)" 
					 + " select (select coalesce(max(id_), 0)+1 from profileInfo), (select coalesce(max(id_), 0)+1 from profileInfo), companyId, userId, firstName, "
					 + " middleName,lastName,jobTitle,emailAddress,null,'"+dateFormat.format(usr.getBirthday())+"' " 
//					 + " middleName,lastName,jobTitle,emailAddress,null,'true','true','"+dateFormat.format(usr.getBirthday())+"' " 
					 + " from User_ where userId = " + userId
					 + " and not exists (select 1 from profileInfo where userId = "+userId+")";
			 System.out.println(sqlQuery);
			 st.execute(sqlQuery);
			 
			 sqlQuery =  " select * from profileInfo where userId = " + userId  ;

				ResultSet rs = st.executeQuery(sqlQuery);
			 //List<profileInfo> info =profileInfoLocalServiceUtil.getProfileInfoByUserId(userId);
				 while (rs.next()) 
				 {	
				 f.setId(Long.valueOf(rs.getString("id_")));
				 f.setTitle(rs.getString("title"));
				 f.setFirstname(rs.getString("firstName"));
				 f.setFamilyname(rs.getString("familyName"));
				 if(rs.getString("dateOfBirth") != null && !"".equals(rs.getString("dateOfBirth")+"") && !"null".equals(rs.getString("dateOfBirth")+""))
					 f.setDateofbirth(dt1.format(dt.parse(rs.getString("dateOfBirth"))));
				 f.setEmail(rs.getString("email"));
				 f.setAbout(rs.getString("about"));
				 f.setEducationField(rs.getString("educationField"));
				 f.setUniversitygeneral(rs.getString("universitygeneral"));
				 f.setMobileno(rs.getString("primaryMobileNo"));
				 f.setMobilenocode(rs.getString("primaryMobileNoCode"));
				 f.setCityofresidence(rs.getString("cityOfResidence"));
				 f.setCurrentworkposition(rs.getString("currentworkposition"));
				 f.setCurrentworklocation(rs.getString("currentworklocation"));
				 f.setCountryofresidence(rs.getString("countryOfResidence"));
				}
				
		 System.out.println("test daharet "+ f.getFirstname());
		   con.close(); 
			 st.close();  
			}  catch (Exception e) {
				e.printStackTrace();
			}
			finally
			{         
					 DataAccess.cleanUp(con, st);
			}
	  return f;
	}
	
	public ProfileVO getprofileImage(Long userId)
	{  
		ProfileVO f=null;
		Connection con = null;
		Statement st = null;
		 try {
			 System.out.println("test " +userId);
		// info = profileInfoLocalServiceUtil.getProfileInfoByUserId(userId);
			 f = new ProfileVO();
			 System.out.println(1111111);
			 
			  String sqlQuery =  " select * "
				 		+ "            from profileImage "
				 		+ "  where userId = " + userId  ;
			    con = DataAccess.getUpgradeOptimizedConnection();
				st = con.createStatement();
				ResultSet rs = st.executeQuery(sqlQuery);
			 //List<profileInfo> info =profileInfoLocalServiceUtil.getProfileInfoByUserId(userId);
				 while (rs.next()) 
				 {	
				 f.setUserId(Long.valueOf(rs.getString("userId")));
				 f.setImage(rs.getString("image"));
				}
				
		 System.out.println("test daharet "+ f.getFirstname());
		   con.close(); 
			 st.close();  
			}  catch (Exception e) {
				e.printStackTrace();
			}
			finally
			{         
					 DataAccess.cleanUp(con, st);
			}
	  return f;
	}
	public void deleteProfileInfo (String deleteCommad,long id)
	{
		Connection con = null;
		Statement st = null;
		String sqlQuery = "";
     try { 
    	 if (deleteCommad.equalsIgnoreCase("deleteEducationInfo"))
			 sqlQuery =" delete from profileEducation where id = " + id;
    	 else  
    		 if (deleteCommad.equalsIgnoreCase("deleteWorkExperienceInfo"))
		     sqlQuery =" delete from profileWorkExperience where id = " + id;
    	     else
 	 			if (deleteCommad.equalsIgnoreCase("deleteLanguageInfo"))
 	 			  sqlQuery =" delete from profileLanguages where id = " + id; 
 	 			 else
 	 	 			if (deleteCommad.equalsIgnoreCase("deleteSkillsInfo"))
 	 	 			  sqlQuery =" delete from profileskills where id = " + id;
 	 	 			else
 	 	 				if (deleteCommad.equalsIgnoreCase("deleteLicenceAndCertificationInfo"))
 	 	 				  sqlQuery =" delete from profileLicensesCertifications where id = " + id;
 	 	 				else
 	 	 	 				if (deleteCommad.equalsIgnoreCase("deleteVolunteerExperienceInfo"))
 	 	 	 				  sqlQuery =" delete from profileVolunteerExperience where id = " + id;
 	 	 	 				else
 	 	 	 				if (deleteCommad.equalsIgnoreCase("deleteHonorandAwardInfo"))
 	 	 	 				  sqlQuery =" delete from ProfileHonourAndAwards where id = " + id;
 	 	 	 				else
 	 	 	 					if (deleteCommad.equalsIgnoreCase("deleteWishJobListInfo"))
 	 	 	 					  sqlQuery =" delete from ProfileJobWishList where id = " + id;
 	 	 	 					else
 	 	 	 						if (deleteCommad.equalsIgnoreCase("deleteIntrest"))
 	 	 	 						  sqlQuery =" delete from profileIntrest where id = " + id;
 	 	 	 						else
 	 	 	 							if (deleteCommad.equalsIgnoreCase("deleteUserPublication"))
 	 	 	 							  sqlQuery =" delete from profilePublication where id = " + id;
 	 	 	 							else
 	 	 	 								if (deleteCommad.equalsIgnoreCase("deleteProjectInfo"))
 	 	 	 								  sqlQuery =" delete from profileProject where id = " + id;
 	 	 	 								else 
 	 	 	 								if (deleteCommad.equalsIgnoreCase("deleteTestimonialInfo"))
 	 	 	 	 								  sqlQuery =" delete from ProfileTestimonial where id_ = " + id;
    	 
    	 
    	    con = DataAccess.getUpgradeOptimizedConnection();
			st = con.createStatement();
			st.executeUpdate(sqlQuery);
			
			     con.close(); 
	  			 st.close();  
			}  catch (Exception e) {
					e.printStackTrace();
				}
			 finally
			 {         
						 DataAccess.cleanUp(con, st);
			 }


	}
	public JSONObject getUserProfileRecordById(String section, long id)
	{   Gson g = new Gson(); 
	    String jsonResult = "";
		Connection con = null;
		Statement st = null;
		JSONObject jsonObject = null;
		try {
			
			if(section.equalsIgnoreCase("educations"))
			   {
				 String sqlQuery =" select * "
						 		+ " from profileEducation "
						 		+ "  where id = " + id  ;

                    con = DataAccess.getUpgradeOptimizedConnection();
                    st = con.createStatement();
                    ResultSet rs = st.executeQuery(sqlQuery);
               	 
     			   while (rs.next()) 
     			   {
     				   jsonObject = JSONFactoryUtil.createJSONObject();
     				   jsonObject.put("_degree", rs.getString("degree"));
     				   jsonObject.put("_description", rs.getString("description"));
     				   jsonObject.put("_fieldOfStudy",rs.getString("fieldOfStudy"));
     				   jsonObject.put("_educationCategory",rs.getString("educationCategory"));
     				   jsonObject.put("_endYear", rs.getString("endYear"));
     				   jsonObject.put("_educatetillnow", rs.getString("educatetillnow"));
     				   jsonObject.put("_educateJourney", rs.getString("educateJourney"));
     				   jsonObject.put("_fieldOfStudy",rs.getString("fieldOfStudy"));
     				   jsonObject.put("_grade", rs.getString("grade"));
     				   jsonObject.put("_startYear",rs.getString("startYear"));
     				   jsonObject.put("_Id", rs.getString("id"));
     				}
     			
                    
				//profileEducation pe = profileEducationLocalServiceUtil.getprofileEducation(id);
				//jsonResult = g.toJson(jsonObject);
				System.out.println("**************** jsonObject : "+jsonObject);
			   	}
			else 
				if(section.equalsIgnoreCase("workexperience"))
				   {
					 String sqlQuery =" select * "
						 		+ " from profileWorkExperience "
						 		+ "  where id = " + id  ;

		                 con = DataAccess.getUpgradeOptimizedConnection();
		                 st = con.createStatement();
		                 ResultSet rs = st.executeQuery(sqlQuery);
		            	 
		  			   while (rs.next()) 
		  			   {
		  				   jsonObject = JSONFactoryUtil.createJSONObject();
		  				   jsonObject.put("_company", rs.getString("company"));
		  				   jsonObject.put("_description", rs.getString("description"));
		  				   jsonObject.put("_location",rs.getString("location"));
		  				   jsonObject.put("_title",rs.getString("title"));
		  				   jsonObject.put("_company", rs.getString("company"));
		  				   jsonObject.put("_startDate",rs.getString("startDate"));
		  				   jsonObject.put("_endDate", rs.getString("endDate"));
		  				   jsonObject.put("_worktillnow", rs.getString("worktillnow"));
		  				   jsonObject.put("_workJourney", rs.getString("workJourney"));
		  				   jsonObject.put("_Id", rs.getString("id"));
		  				}
				   	}
				    else 
						if(section.equalsIgnoreCase("workstatus"))
						   {
							 String sqlQuery =" select * "
								 		+ " from profileWorkExperience "
								 		+ "  where id = " + id  ;

				                 con = DataAccess.getUpgradeOptimizedConnection();
				                 st = con.createStatement();
				                 ResultSet rs = st.executeQuery(sqlQuery);
				            	 
				  			   while (rs.next()) 
				  			   {
				  				   jsonObject = JSONFactoryUtil.createJSONObject();
				  				   jsonObject.put("_currentWorkStatus", rs.getString("currentWorkStatus"));
				  				   jsonObject.put("_workExperience", rs.getString("workExperience"));
				  				   jsonObject.put("_company", rs.getString("company"));
				  				   jsonObject.put("_Id", rs.getString("id"));
				  				}
						   	}
						    else 
								if(section.equalsIgnoreCase("intrest"))
								   {
									
									 String sqlQuery =" select * "
										 		+ " from profileIntrest "
										 		+ "  where id = " + id  ;

						                 con = DataAccess.getUpgradeOptimizedConnection();
						                 st = con.createStatement();
						                 ResultSet rs = st.executeQuery(sqlQuery);
						            	 
						  			   while (rs.next()) 
						  			   {
						  				   jsonObject = JSONFactoryUtil.createJSONObject();
						  				   jsonObject.put("_intrest", rs.getString("intrest"));
						  				   jsonObject.put("_Id", rs.getString("id"));
						  				}
								   	}
								    else 
										if(section.equalsIgnoreCase("project"))
										   {

											 String sqlQuery =" select * "
												 		+ " from profileProject "
												 		+ "  where id = " + id  ;

								                 con = DataAccess.getUpgradeOptimizedConnection();
								                 st = con.createStatement();
								                 ResultSet rs = st.executeQuery(sqlQuery);
								            	 
								  			   while (rs.next()) 
								  			   {
								  				   jsonObject = JSONFactoryUtil.createJSONObject();
								  				   jsonObject.put("_projectName", rs.getString("projectName"));
								  				   jsonObject.put("_projectURL", rs.getString("projectURL"));
								  				   jsonObject.put("_startDate", rs.getString("startDate"));
								  				   jsonObject.put("_endDate", rs.getString("endDate"));
								  				   jsonObject.put("_description", rs.getString("description"));
								  				   jsonObject.put("_currentlyOnProject", rs.getString("currentlyOnProject"));
								  				   jsonObject.put("_Id", rs.getString("id"));
								  				}
											
										   	}
										else 
											if(section.equalsIgnoreCase("licenceandcertification"))
											   {
												
												 String sqlQuery =" select * "
													 		+ " from profileLicensesCertifications "
													 		+ "  where id = " + id  ;

									                 con = DataAccess.getUpgradeOptimizedConnection();
									                 st = con.createStatement();
									                 ResultSet rs = st.executeQuery(sqlQuery);
									            	 
									  			   while (rs.next()) 
									  			   {
									  				   jsonObject = JSONFactoryUtil.createJSONObject();
									  				   jsonObject.put("_name", rs.getString("name"));
									  				   jsonObject.put("_issuingOrganization", rs.getString("issuingOrganization"));
									  				   jsonObject.put("_issueDate", rs.getString("issueDate"));
									  				   jsonObject.put("_expirationDate", rs.getString("expirationDate"));
									  				   //jsonObject.put("_credentialID", rs.getString("credentialID"));
									  				   jsonObject.put("_credentialURL", rs.getString("credentialURL"));
									  				   jsonObject.put("_certificateJourney", rs.getString("certificateJourney"));
									  				   jsonObject.put("_notExpire", rs.getString("notExpire"));
									  				   jsonObject.put("_Id", rs.getString("id"));
									  				}
												
											   	}
											else
												if(section.equalsIgnoreCase("volunteerexperience"))
											   {
													 String sqlQuery =" select * "
														 		+ " from profileVolunteerExperience "
														 		+ "  where id = " + id  ;

										                 con = DataAccess.getUpgradeOptimizedConnection();
										                 st = con.createStatement();
										                 ResultSet rs = st.executeQuery(sqlQuery);
										            	 
										  			   while (rs.next()) 
										  			   {
										  				   jsonObject = JSONFactoryUtil.createJSONObject();
										  				   jsonObject.put("_organization", rs.getString("organization"));
										  				   jsonObject.put("_role", rs.getString("role"));
										  				   jsonObject.put("_cause", rs.getString("cause"));
										  				   jsonObject.put("_startDate", rs.getString("startDate"));
										  				   jsonObject.put("_endDate", rs.getString("endDate"));
										  				   jsonObject.put("_description", rs.getString("description"));
										  				   jsonObject.put("_currentlyVolunteering", rs.getString("currentlyVolunteering"));
										  				   jsonObject.put("_Id", rs.getString("id"));
										  				}
													
											   	}
												else 
													if(section.equalsIgnoreCase("honorandaward"))
													   {
														 String sqlQuery =" select * "
															 		+ " from ProfileHonourAndAwards "
															 		+ "  where id = " + id  ;

											                 con = DataAccess.getUpgradeOptimizedConnection();
											                 st = con.createStatement();
											                 ResultSet rs = st.executeQuery(sqlQuery);
											            	 
											  			   while (rs.next()) 
											  			   {
											  				   jsonObject = JSONFactoryUtil.createJSONObject();
											  				   jsonObject.put("_honortitle", rs.getString("honortitle"));
											  				   jsonObject.put("_honorissuer", rs.getString("honorissuer"));
											  				   jsonObject.put("_honorissuedate", rs.getString("honorissuedate"));
											  				   jsonObject.put("_issuedescription", rs.getString("issuedescription"));
											  				   jsonObject.put("_Id", rs.getString("id"));
											  				}
													   	}	
													    else 
															if(section.equalsIgnoreCase("publication"))
															   {
																	String sqlQuery =" select * "
																	 		+ " from profilePublication "
																	 		+ "  where id = " + id  ;
	
													                 con = DataAccess.getUpgradeOptimizedConnection();
													                 st = con.createStatement();
													                 ResultSet rs = st.executeQuery(sqlQuery);
													            	 
													  			   while (rs.next()) 
													  			   {
													  				   jsonObject = JSONFactoryUtil.createJSONObject();
													  				   jsonObject.put("_publicationTitle", rs.getString("publicationTitle"));
													  				   jsonObject.put("_publicationType", rs.getString("publicationType"));
													  				   jsonObject.put("_role", rs.getString("role"));
													  				   jsonObject.put("_url", rs.getString("url"));
													  				   jsonObject.put("_date", rs.getString("date_"));
													  				   jsonObject.put("_Id", rs.getString("id"));
													  				}

															   	} else 
																	if(section.equalsIgnoreCase("profileInfo"))
																	   {
																			String sqlQuery =" select * "
																			 		+ " from profileInfo "
																			 		+ "  where id_ = " + id  ;
			
															                 con = DataAccess.getUpgradeOptimizedConnection();
															                 st = con.createStatement();
															                 ResultSet rs = st.executeQuery(sqlQuery);
															            	 
															  			   while (rs.next()) 
															  			   {
															  				   jsonObject = JSONFactoryUtil.createJSONObject();
															  				   jsonObject.put("_title", rs.getString("title"));
															  				   jsonObject.put("_firstName", rs.getString("firstName"));
															  				   jsonObject.put("_fatherName", rs.getString("fatherName"));
															  				 //  jsonObject.put("_grandfatherName", rs.getString("grandfatherName"));
															  				   jsonObject.put("_familyName", rs.getString("familyName"));
															  				   jsonObject.put("_email", rs.getString("email"));
															  				   jsonObject.put("_about", rs.getString("about"));
															  			       jsonObject.put("_universitygeneral", rs.getString("universitygeneral"));
															  				   jsonObject.put("_educationField", rs.getString("educationField"));
															  				   jsonObject.put("_primaryMobileNo", rs.getString("primaryMobileNo"));
															  				 jsonObject.put("_primaryMobileNoCode", rs.getString("primaryMobileNoCode"));
															  				//   jsonObject.put("_secondaryMobileNo", rs.getString("secondaryMobileNo"));
															  				   jsonObject.put("_gender", rs.getString("gender"));
															  				   jsonObject.put("_nationality", rs.getString("nationality"));
															  				   jsonObject.put("_nationalId", rs.getString("nationalId"));
															  				   jsonObject.put("_passportId", rs.getString("passportId"));
															  				   jsonObject.put("_passportExpireDate", rs.getString("passportExpireDate"));
															  				   jsonObject.put("_dateOfBirth", rs.getString("dateOfBirth"));
															  				//   jsonObject.put("_currentEducationTrainingStatus", rs.getString("currentEducationTrainingStatus"));
															  				   jsonObject.put("_countryOfResidence", rs.getString("countryOfResidence"));
															  				   jsonObject.put("_cityOfResidence", rs.getString("cityOfResidence"));
															  				   jsonObject.put("_nationalAddress", rs.getString("nationalAddress"));
															  				   jsonObject.put("_postalCode", rs.getString("postalCode"));
															  				   jsonObject.put("_street", rs.getString("street"));
															  				   jsonObject.put("_state", rs.getString("state_"));
															  				   jsonObject.put("_currentworkposition", rs.getString("currentworkposition"));
															  				   jsonObject.put("_currentworklocation", rs.getString("currentworklocation"));
															  				   jsonObject.put("_Id", rs.getString("id_"));
															  				}

																	   	}
			
			
		
			     con.close(); 
	  			 st.close();  
				}  catch (Exception e) {
						e.printStackTrace();
					}
				 finally
				 {         
							 DataAccess.cleanUp(con, st);
				 }
		return jsonObject;
	}
	
	public JSONArray getBadgeInformation(String userId) 
	{
		try 
		{  
			System.out.println("getBadgeInformation: "+userId);
			profileAchievementsAndAwards = JSONFactoryUtil.createJSONArray();
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		   //jsonObject.put("userId", e.getUserId());
		  
			Map<String, String> columnsVerifications = new HashMap<String, String>();
			columnsVerifications.put("0", " ");
			// Novice
			columnsVerifications.put("1", "Full Name");
			columnsVerifications.put("2", "Verified Email Address");
			columnsVerifications.put("3", "Verified Phone Number");
			columnsVerifications.put("4", "Date Of Birth");
			// Beginner
			columnsVerifications.put("5", "National Address");
			columnsVerifications.put("6", "Education");
			columnsVerifications.put("7", "Work experience");
			columnsVerifications.put("8", "Skillset");
			columnsVerifications.put("9", "Certificates");
			// Seeker      
			
			columnsVerifications.put("10", "Job Wishlist");
			columnsVerifications.put("11", "Choose Industry");
			columnsVerifications.put("12", "Write a summary");
			columnsVerifications.put("13", "Social Media account");
			
			
			System.out.println("query badges==== before query:: ");																				   
			
			String query= "select (select count(1) from EventSpeakers where userid = " + userId + ") isSpeaker,"
					+ " (case when (firstName is not null and fatherName is not null and familyName is not null) then 1 else 0 end ) col1, "
					+ " (case when email is not null then 1 else 0 end) col2 , "
					+ " (case when primaryMobileNo is not null then 1 else 0 end) col3, "
					+ " (case when dateOfBirth is not null then 1 else 0 end) col4, "
						+ " (case when nationalAddress is not null then 1 else 0 end) col5, "
						+ " (case when (select count(1) from profileEducation pe where pe.userid = pi.userid ) = 0 then 0 else 1 end ) col6, "
						+ " (case when (select count(1) from profileWorkExperience pw where pw.userid = pi.userid ) = 0 then 0 else 1 end ) col7, "
						+ " (case when (select count(1) from profileskills ps where ps.userid = pi.userid ) = 0 then 0 else 1 end ) col8, "
//					+ " 1 col8, "
						+ " (case when (select count(1) from profileLicensesCertifications pl where pl.userid = pi.userid ) = 0 then 0 else 1 end ) col9, "
						+ " (case when (select count(1) from ProfileJobWishList pj where pj.userid = pi.userid ) = 0 then 0 else 1 end ) col10, "
						+ " 1 col11, 1 col12, 1 col13 " // 
		//				+ " (case when (select count(1) from profilesocialmedia pj where pj.userid = pi.userid ) = 0 then 0 else 1 end ) col13 "
					+ " from profileInfo pi" 
					+ " where pi.userid = " + userId;
			
			System.out.println("query badges====  query:: "+query);
			
			Connection con = DataAccess.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			int cntr = 0;
			System.out.println("query badges==== " + query);
			int colCount = rs.getMetaData().getColumnCount();
			
			while (rs.next()) 
			{
				
			    for (int col=1; col < colCount; col++) 
			    {
					if(rs.getInt("col"+col) == 0)
					{
						cntr = col;
						break;
					}
			    }
			    jsonObject.put("isSpeaker", rs.getString("isSpeaker"));
			    System.out.println("isSpeaker ======= " + rs.getString("isSpeaker"));															  
																			
			}	
			 jsonObject.put("cntr", cntr);
			 jsonObject.put("description", columnsVerifications.get(cntr+""));
			 profileAchievementsAndAwards.put(jsonObject);
			
		    con.close();
			st.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return profileAchievementsAndAwards;
	}
	
	public JSONArray getProgressInformation(String userId) 
	{
		try 
		{  
			System.out.println("getProgressInformation before query:: "+userId);
			profileProgress = JSONFactoryUtil.createJSONArray();
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			
			String query= "select (case when (select count(1) from profileimage pe where pe.userId = pi.userid) > 0 then true else false end ) photos, " + 
					"(case when (title is not null and title <> '' and firstName is not null and firstName <> '' and fatherName is not null " + 
					"and fatherName <> '' and familyName is not null and familyName <> '' and primaryMobileNo is not null " + 
					"and primaryMobileNo <> '' and email is not null and email <> '' and universitygeneral is not null and universitygeneral <> '' " + 
					"and educationField is not null and educationField <> '' and currentworkposition is not null and currentworkposition <> '' " + 
					"and currentworklocation is not null and currentworklocation <> '' and gender is not null and gender <> '' " + 
					"and nationality is not null and nationality <> '' and nationalId is not null and nationalId <> '' and passportId is not null " + 
					"and passportId <> '' and passportExpireDate is not null and dateOfBirth is not null " + 
					"and countryOfResidence is not null and countryOfResidence <> '' and cityOfResidence is not null " + 
					"and cityOfResidence <> '' and postalCode is not null and postalCode <> '' and nationalAddress is not null and nationalAddress <> '' " + 
					"and street is not null and street <> '' and state_ is not null and state_ <> '' and about is not null " + 
					"and about <> '') then true else false end) publicProfile  , " + 
					"(case when (select count(1) from profileEducation pe where pe.userid = pi.userid ) > 1 then true else false end ) education, " + 
					"(case when (select count(1) from profileWorkExperience pe where pe.userid = pi.userid ) > 1 then true else false end ) experience, " + 
					"(case when (select count(1) from profileLicensesCertifications pe where pe.userid = pi.userid ) > 1 then true else false end ) certificate, " + 
					"(case when (select count(1) from profileskills pe where pe.userid = pi.userid ) > 1 then true else false end ) skills, " + 
					"(case when (select count(1) from profileIntrest pe where pe.userId = pi.userid ) > 3 then true else false end ) interest " + 
					"from profileInfo pi where pi.userid = " + userId;
			
			System.out.println("getProgressInformation====  query:: "+query);
			
			Connection con = DataAccess.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			String photos = "",publicProfile = "",education="",experience="",certificate="",skills="",interest="";
			
			while (rs.next()) 
			{
				photos = rs.getString("photos");
				publicProfile = rs.getString("publicProfile");
				education = rs.getString("education");
				experience = rs.getString("experience");
				certificate = rs.getString("certificate");
				skills = rs.getString("skills");
				interest = rs.getString("interest");
				System.out.println("photos==== "+ photos + "/interest ==== " + interest);
				jsonObject.put("photos", photos);
				jsonObject.put("publicProfile", publicProfile);
				jsonObject.put("education", education);
				jsonObject.put("experience", experience);
				jsonObject.put("certificate", certificate);
				jsonObject.put("skills", skills);
				jsonObject.put("interest", interest);
			}	
			System.out.println("jsonObject ============= " + jsonObject.toString());
			profileProgress.put(jsonObject);
			con.close();
			st.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return profileProgress;
	}
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException 
	{
		try
		{
			
			System.out.println("profile server ressources");
			
			Object obj1 = null;
			String userAction =resourceRequest.getParameter("action"); 
			String userId1 =resourceRequest.getParameter("userId");
			/*
			 * if(userAction.equalsIgnoreCase("all")) { obj1 = "{'userId':'20129'}"; } else
			 * {
			 */
            	obj1 = resourceRequest.getParameter("obj");
           // }
            
			System.out.println("obj1: "+String.valueOf(obj1));
			Gson g = new Gson(); 
			ProfileVO vo = g.fromJson((String) obj1, ProfileVO.class);
			writer = resourceResponse.getWriter();
			System.out.println(1111111);
			System.out.println("*********** userAction : "+ userAction);
			if (userAction.equalsIgnoreCase("all"))
			 {
					long userId =Long.valueOf(userId1);
					String section = resourceRequest.getParameter("section"); 
					System.out.println("--section ---:"+section+"---:userId:---"+userId);
					getUserProfileDetails(section,userId);
					System.out.println("---section-----:: "+section);
					System.out.println("array : "+ array.toString());
					writer.write(array.toString());
			}
			else
			if (userAction.equalsIgnoreCase("addProfileInfo"))
			   { writer.write(registerProfileToUser(vo));
				}
			else 
				if (userAction.equalsIgnoreCase("getAchievementsAndAwards"))
				   {
					getBadgeInformation(String.valueOf(vo.getUserId())) ;
					writer.write(array.toString());
					}
				else 
				if(userAction.equalsIgnoreCase("getProfileInfo"))
					{
					long userId =Long.valueOf(vo.getUserId());  
					String section = resourceRequest.getParameter("section"); 
					getUserProfileDetails(section,userId);
					System.out.println("---section-----:: "+section);
					System.out.println("array : "+ array.toString());
					writer.write(array.toString());
					}
				else 
					if(userAction.equalsIgnoreCase("updateProfileRecord"))
					{
					 String section = resourceRequest.getParameter("section"); 
					 String id = resourceRequest.getParameter("id"); 
					
					 writer.write(getUserProfileRecordById(section, Long.valueOf(id)).toString());
					}
				else 
					if(userAction.equalsIgnoreCase("deleteData"))
					{
						String deletecommand =  resourceRequest.getParameter("command"); 
						long id =Long.valueOf(vo.getId());  
						deleteProfileInfo(deletecommand,id);
					}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			
		}
	}
	

	
}
