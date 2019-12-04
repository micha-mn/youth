package contact.us.form.portlet;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

import VO.contactUsVO;
import contact.us.form.constants.ContactUsFormPortletKeys;

/**
 * @author pma
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ContactUsForm",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ContactUsFormPortletKeys.CONTACTUSFORM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ContactUsFormPortlet extends MVCPortlet {
	Connection con = null;
	Statement st = null;
	
	/*
	 * @Override public void serveResource(ResourceRequest resourceRequest,
	 * ResourceResponse resourceResponse) throws IOException, PortletException {
	 * 
	 * try { CaptchaUtil.serveImage(resourceRequest, resourceResponse); } catch
	 * (Exception e) { System.out.println(e.getMessage()); } }
	 */
	
	public void sendMail(contactUsVO contactUs, String fromEmailAddress, Long companyId) {
		try 
		{
			InternetAddress fromAddress = null;
			List<InternetAddress> toAddress = new ArrayList();
			fromAddress = new InternetAddress(fromEmailAddress);
			Role role = RoleLocalServiceUtil.getRole(companyId, "contact US Admins");
			List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
			System.out.println("users.size() : " + users.size());
			for (int i =0; i< users.size(); i++)
			{
				MailMessage mailMessage = new MailMessage();
				  mailMessage.setTo(new InternetAddress(users.get(i).getEmailAddress()));
				  mailMessage.setFrom(fromAddress);
				  mailMessage.setSubject("New Contact Us form Submitted");
				  mailMessage.setBody("<h2>You received a contact Us form "
							  		+ "<br>" + contactUs.getSubject()
							  		+ "<br>from</h2>"
						  			 + "<h3>" + contactUs.getName() + " - " + contactUs.getEmail() + "</h3>"
						  			 + contactUs.getAddress()
						  			 + "<br>with the following message<br>" + contactUs.getMessage() 
						             );
				  mailMessage.setHTMLFormat(true);
				  MailServiceUtil.sendEmail(mailMessage);
			}
			
			
			
			/**
			 * PMA
			 * toAddress to be changed to be dynamic with contact us admins
			 */
			 
			System.out.println("Mail Send Successfully .....!!!!!");
		/*
		 * update eventspeakers set isNotificationSent = 1 where email =
		 * 'j.saade@everteam-gs.com' and eventId = ;
		 */
			
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.err.println("Mail Send Error :" + e);
		}
	}
	
	@ProcessAction(name = "addcontactUSForm")
	public void addBook(ActionRequest actionRequest,ActionResponse actionResponse) throws SystemException, CaptchaException, SQLException {
		/*
		 * try {
		 */
//			CaptchaUtil.check(actionRequest);
			try
			{
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				
				String name = ParamUtil.getString(actionRequest, "person-name");
				String email = ParamUtil.getString(actionRequest, "person-email");
				String address = ParamUtil.getString(actionRequest, "person-address");
				String subject = ParamUtil.getString(actionRequest, "form-subject");
				String message = ParamUtil.getString(actionRequest, "form-message");
				
				contactUsVO contactObj = new contactUsVO();
				contactObj.setName(name);
				contactObj.setAddress(address);
				contactObj.setEmail(email);
				contactObj.setSubject(subject);
				contactObj.setMessage(message);
				contactObj.setAddress(address);
				
				con = DataAccess.getUpgradeOptimizedConnection();
				st = con.createStatement();
				
				String sqlSt =  " insert into contactus("
						+"idcontactUs,"
						+ "name,"
						+"email,"
						+"address,"
						+"subject,"
						+"message)"
				 		+ "  select  coalesce((select max(idcontactUs)+1 from contactus),1) "
				 		+ ",'"+ name+"'"
				 		+ ",'"+ email +"'"
		 				+ ",'"+ address +"'"
						+ ",'"+ subject +"'"
						+ ",'"+ message +"'";
				 		
				 		// + " from dual" ;
			
				 System.out.println("sqlQuery:: "+ sqlSt);
				 
				 st = con.createStatement();
				 st.executeUpdate(sqlSt);
				 
				 long companyId = themeDisplay.getCompanyId();
				 javax.portlet.PortletPreferences serverPortletPreferences = PrefsPropsUtil.getPreferences();
		         Map<String, String[]> serverPortletPreferencesMap = serverPortletPreferences.getMap();
		         String emailAddress = serverPortletPreferencesMap.get(PropsKeys.MAIL_SESSION_MAIL_SMTP_USER)[0];
			        
				 sendMail(contactObj, emailAddress, companyId);
				 String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
	            themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	            
	            System.out.println("themeDisplay.getLayout().getPlid() -==== "+themeDisplay.getLayout().getPlid());
	            System.out.println("PortletRequest.RENDER_PHASE -==== "+PortletRequest.RENDER_PHASE);
	        
	            PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),portletName,themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
	            redirectURL.setParameter("jspPage", "/view.jsp");
	            actionResponse.sendRedirect(redirectURL.toString());
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			catch (SQLException sqlE)
			{
				sqlE.printStackTrace();
			}
			finally
			{
				con.close(); 
	  			 st.close();
			 DataAccess.cleanUp(con, st);
			}
		/*}
		catch (CaptchaException e)
		{
				if (
						 e instanceof CaptchaConfigurationException ||
						 e instanceof CaptchaTextException) {

					SessionErrors.add(actionRequest, e.getClass(), e);
				}
				else {
					throw e;
				}
		}*/
	}
}