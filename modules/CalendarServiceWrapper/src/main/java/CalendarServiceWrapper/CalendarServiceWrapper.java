package CalendarServiceWrapper;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.CalendarBookingLocalServiceWrapper;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.SAXReaderUtil;


import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Component;

/**
 * @author parth
 */
@Component(immediate = true, property = {}, service = ServiceWrapper.class)
public class CalendarServiceWrapper extends CalendarBookingLocalServiceWrapper {

	public CalendarServiceWrapper() {
		super(null);
	}

    @Override
    public CalendarBooking updateStatus(long userId, long calendarBookingId, int status, ServiceContext serviceContext)
    		throws PortalException 
    {
    	// TODO Auto-generated method stub
    	CalendarBooking calendarBooking= super.updateStatus(userId, calendarBookingId, status, serviceContext);
    	
    	if(WorkflowConstants.LABEL_APPROVED.equals(WorkflowConstants.getStatusLabel(status))) {
    		
    		System.out.println("MEthod called for the approved events 123" + calendarBooking);
    		// retrieve structure key for FAQ structure
    		List<com.liferay.dynamic.data.mapping.model.DDMStructure> ddmStructureList = DDMStructureLocalServiceUtil
    				.getStructures();
    		String[] structureKeyArray = null;
    		for (com.liferay.dynamic.data.mapping.model.DDMStructure ddmStructure : ddmStructureList) {
    			if (ddmStructure.getName("en_US").equalsIgnoreCase("speaker Invitation")) {
    				structureKeyArray = new String[] { ddmStructure.getStructureKey() };
    				break;
    			}
    		}
    		JournalArticleLocalServiceUtil.getStructureArticles(structureKeyArray).parallelStream()
    				.filter(predicate -> predicate.getStatus() == WorkflowConstants.STATUS_APPROVED)
    				.forEach(journalArticle -> {
    					try {
    						if (JournalArticleLocalServiceUtil.isLatestVersion(journalArticle.getGroupId(),
    								journalArticle.getArticleId(), journalArticle.getVersion())) {
    							if (Validator.isNotNull(journalArticle)) {
    								com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(journalArticle.getContentByLocale("en_US"));
    								String message = document.selectSingleNode(
    										"/root/dynamic-element[@name='speakerInvitation']/dynamic-content[@language-id='en_US']")
    										.getText();
    								sendMail(message,String.valueOf(calendarBookingId));
    							}
    							return;
    						}
    					} 
    					catch (PortalException | DocumentException e) 
    					{
    						e.getMessage();
    					}
    				});
    				
    	}
    	
    	return calendarBooking;
    }
    
    
    public static List<String> sendMailNotification(String calendarBookingId)
    {
    	JSONArray jsonArr = null;
    	java.sql.Connection con = null;
		java.sql.Statement st = null;
    	Object a = null;
    	String emailRecipient = "";
    	String speakername = "";
    	String concatString = "";
    	List<String> emailList = new ArrayList<String>();
    	try 
    	{
    		
	        con = DataAccess.getConnection();
	    	st = con.createStatement();
	    	String sqlStatement = "	select eventid, \n" + 
					    			"      isNotificationSent, \n" + 
					    			"      email, \n" + 
					    			"      userId, \n "
					    			+ " concat(firstName,concat(' ',lastName)) as SpeakerName" + 
					    			" from eventSpeakers "+
					    		   " Where eventid = " +calendarBookingId +" and isNotifEnabled = 1";
	    	System.out.println("sqlStatement: "+sqlStatement);
	    	java.sql.ResultSet rs = st.executeQuery(sqlStatement);
	    	while (rs.next()) 
	    	{
	    		speakername    = rs.getString("SpeakerName");
	    		emailRecipient = rs.getString("email");
	    		concatString  = speakername+"cutM"+emailRecipient;
	    		emailList.add(concatString);
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
    	return emailList;
    }

	
    
    /**
	 * Sending a mail.
	 * 
	 * @param body
	 */
	public static void sendMail(String body,String calendarBookingId) 
	{
		CalendarBooking ca = null;
		String speakerName = "";
		String speakerEmailAddress="";
		String replaceInBody = "";
		replaceInBody = body;
		try 
		{
			ca = CalendarBookingLocalServiceUtil.getCalendarBooking(Long.valueOf(calendarBookingId));
		} 
		catch (NumberFormatException e1) 
		{
			e1.printStackTrace();
		} 
		catch (PortalException e1) 
		{
			e1.printStackTrace();
		}
		List<String> lst = sendMailNotification(calendarBookingId);
		String[] speakerData = new String[2];
		String stringBuf = null;
		 stringBuf = replaceInBody;
		for(String l: lst)
		{
			    replaceInBody = stringBuf;
			    speakerData = l.split("cutM");
			    speakerName = speakerData[0];
			    speakerEmailAddress = speakerData[1];
				InternetAddress fromAddress = null;
				// String toEmailAddress = "parth.pancholi.23@gmail.com";
				String toEmailAddress = speakerEmailAddress;
				String[] toEmailArray = toEmailAddress.split(",");
				InternetAddress[] toAddress = new InternetAddress[toEmailArray.length];
				replaceInBody = replaceInBody.replace("calendarBookingIdd",calendarBookingId);
				System.out.println("*****************speakerName :"+speakerName);
				replaceInBody = replaceInBody.replace("speakerr",speakerName);
				for (int i = 0; i < toEmailArray.length; i++) 
				{
					try 
					{
						toAddress[i] = new InternetAddress(toEmailArray[i]);
					} 
					catch (AddressException e) 
					{
						System.err.println("Address Exception occured while retrive toAddress : " + e);
					}
				}
		
				
				try 
				{
					System.out.println("sending invitation to speaker : "+speakerName +"having email: "+toAddress+" for the event : "+ca.getTitleCurrentValue() );
					fromAddress = new InternetAddress("jean.e.saade@gmail.com");
					MailMessage mailMessage = new MailMessage();
					mailMessage.setTo(toAddress);
					mailMessage.setFrom(fromAddress);
					mailMessage.setSubject("test");
					mailMessage.setBody(replaceInBody);
					mailMessage.setHTMLFormat(true);
					MailServiceUtil.sendEmail(mailMessage);
					System.out.println("Mail Send Successfully .....!!!!!");
					replaceInBody = null;
				/*
				 * update eventspeakers set isNotificationSent = 1 where email =
				 * 'j.saade@everteam-gs.com' and eventId = ;
				 */
					
					
				} 
				catch (AddressException e) 
				{
					e.printStackTrace();
					System.err.println("Mail Send Error :" + e);
				}
			}
	}
}