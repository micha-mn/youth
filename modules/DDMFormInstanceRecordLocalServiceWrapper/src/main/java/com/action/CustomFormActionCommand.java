package com.action;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.dynamic.data.mapping.form.values.factory.DDMFormValuesFactory;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceSettings;
import com.liferay.dynamic.data.mapping.model.DDMFormSuccessPageSettings;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordService;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordVersionLocalService;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordVersionLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceService;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalServiceUtil;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet",
		"mvc.command.name=addFormInstanceRecord", "service.ranking:Integer=110" }, service = MVCActionCommand.class)
public class CustomFormActionCommand extends BaseMVCActionCommand{

	@Override     
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
		
		
		
		PortletSession portletSession = actionRequest.getPortletSession();

		long groupId = ParamUtil.getLong(actionRequest, "groupId");

		if (groupId == 0) {
			groupId = GetterUtil.getLong(
				portletSession.getAttribute("GROUP_ID"));
		}

		long formInstanceId = ParamUtil.getLong(
			actionRequest, "formInstanceId");

		if (formInstanceId == 0) {
			formInstanceId = GetterUtil.getLong(
				portletSession.getAttribute("DYNAMIC_DATA_MAPPING_FORM_INSTANCE_ID"));
		}

		DDMFormInstance ddmFormInstance =
			_ddmFormInstanceService.getFormInstance(formInstanceId);

		validateCaptcha(actionRequest, ddmFormInstance);

		DDMForm ddmForm = getDDMForm(ddmFormInstance);

		DDMFormValues ddmFormValues = _ddmFormValuesFactory.create(
			actionRequest, ddmForm);

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);


		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			DDMFormInstanceRecord.class.getName(), actionRequest);

		DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion =
			_ddmFormInstanceRecordVersionLocalService.
				fetchLatestFormInstanceRecordVersion(
					themeDisplay.getUserId(), formInstanceId,
					ddmFormInstance.getVersion(),
					WorkflowConstants.STATUS_DRAFT);

		DDMFormInstanceRecord ddmFormInstanceRecord;

		if (ddmFormInstanceRecordVersion == null) {
			ddmFormInstanceRecord =
				_ddmFormInstanceRecordService.addFormInstanceRecord(
					groupId, formInstanceId, ddmFormValues, serviceContext);

		}else {
			ddmFormInstanceRecord =
				_ddmFormInstanceRecordService.updateFormInstanceRecord(
					ddmFormInstanceRecordVersion.getFormInstanceRecordId(),
					false, ddmFormValues, serviceContext);
		}

		//Custom code start
		System.out.println(actionRequest.getAttributeNames());
		String eventId = ParamUtil.get(actionRequest, "eventId", StringPool.BLANK);
		System.out.println("arrived to ddm eventId  " + eventId);
		System.out.println("arrived to ddm FormInstanceRecordId"+ddmFormInstanceRecord.getFormInstanceRecordId());
		System.out.println("arrived to ddm UserId " + ddmFormInstanceRecord.getUserId());
		java.sql.Connection con = null;
		java.sql.Statement st = null;
		 System.out.println(serviceContext.getAttributes());
		 Map<String, Serializable> m = serviceContext.getAttributes();
		 String formId = (String) m.get("formInstanceId");
		 System.out.println("----formId: ----"+formId);
		long instanceRecordId = ddmFormInstanceRecord.getFormInstanceRecordId();
		System.out.println(ddmFormInstanceRecord.getFormInstanceRecordId());
		System.out.println("ddmFormInstanceRecord.getFormInstanceId()"+ddmFormInstanceRecord.getFormInstanceId());
		System.out.println("before try");
		ddmFormInstanceRecordVersion = DDMFormInstanceRecordVersionLocalServiceUtil.getFormInstanceRecordVersion(ddmFormInstanceRecord.getFormInstanceRecordId(),
				ddmFormInstanceRecord.getVersion());
		
		try
		{
			/*System.out.println(1111);
		    con = DataAccess.getConnection();
		    System.out.println(2222);
		    st = con.createStatement();
		    System.out.println(3333);*/
		    // UserLocalServiceUtil.getUser(userId);
		    //userFormEventServiceBuilder e;
		    //formEventUserTable
		    /*formeventusertableLocalServiceUtil frm = new formeventusertableLocalServiceUtil();
		    frm.a*/
			
			System.out.println("-------------CustomFormCommandAction-----------");
		    User us = UserLocalServiceUtil.getUser(ddmFormInstanceRecord.getUserId());
		    System.out.println("User:: "+us);
		    String name = us.getFirstName()+" "+us.getLastName();
			/*
			 * System.out.println("name:: "+name); formeventusertableLocalServiceUtil frm =
			 * new formeventusertableLocalServiceUtil(); System.out.println("User:: "+us);
			 * formeventusertable f = frm.createformeventusertable(1);
			 * f.setEventId(eventId);
			 * f.setUserId(String.valueOf(ddmFormInstanceRecord.getUserId()));
			 * System.out.println("ddmFormInstanceRecord.getUserId():: "
			 * +ddmFormInstanceRecord.getUserId()); f.setFormId(formId);
			 * f.setDdmFormInstanceId(String.valueOf(instanceRecordId));
			 * System.out.println("User:: "+us); f.setStatusCol("pending"); f.setUuid(name);
			 * f.setDdmFormInstanceRecordVersionId(String.valueOf(ddmFormInstanceRecord.
			 * getFormInstanceRecordVersion().getFormInstanceRecordVersionId()))
			 */
		    
		    
		    
		    
		        
		    
		    System.out.println("after add into formeventusertable");
		    //send mail to the user that submitterd the form
		    String sqlStatement =  "insert into formeventusertable(ID,userID,eventId,ddmformInstanceId,formId,ddmforminstancerecordversionid,"+
                                                                   "statuscol,uuid_,ddmforminstancerecordversion)"+
		                            "select  coalesce((select max(ID)+1 from formeventusertable),1) ,"
                                            +String.valueOf(ddmFormInstanceRecord.getUserId())+", "
		                                    + eventId+" , "
		                                    + String.valueOf(instanceRecordId) +" , "
		                                    + formId +" , "
		                                    +String.valueOf(ddmFormInstanceRecord.getFormInstanceRecordVersion().getFormInstanceRecordVersionId())+", "
		                                    + "'pending'"+", "
		                                    + "'"+ name       +"',"
		                                    + String.valueOf(ddmFormInstanceRecord.getFormInstanceRecordVersion().getFormInstanceRecordVersionId())
		                            +" from dual ";
		                               
		    System.out.println(":: query bfr submission:: "+sqlStatement);
		    con = DataAccess.getConnection();
		    System.out.println(2222);
		    st = con.createStatement();
		    st.executeUpdate(sqlStatement);
		    System.out.println(4444);
		    con.close();
		    System.out.println(5555);
		    
		    getMailTemplates(us.getFullName(),us.getEmailAddress(),eventId);
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
		//TODO write custom code here to save the data.
		
		
		//TODO write custom code to save the data into the custom table.
		//Custom code end
		if (SessionErrors.isEmpty(actionRequest)) {
			DDMFormInstanceSettings formInstanceSettings =
				ddmFormInstance.getSettingsModel();

			String redirectURL = formInstanceSettings.redirectURL();

			if (Validator.isNotNull(redirectURL)) {
				portletSession.setAttribute("DYNAMIC_DATA_MAPPING_FORM_INSTANCE_ID",
					formInstanceId);
				portletSession.setAttribute("GROUP_ID", groupId);

				sendRedirect(actionRequest, actionResponse, redirectURL);
			}
			else {
				DDMFormSuccessPageSettings ddmFormSuccessPageSettings =
					ddmForm.getDDMFormSuccessPageSettings();

				if (ddmFormSuccessPageSettings.isEnabled()) {
					String portletId = _portal.getPortletId(actionRequest);

					SessionMessages.add(
						actionRequest,
						portletId.concat(
							SessionMessages.
								KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE));
				}
			}
		}
	}
	
	public String getMailTemplates(String fullName, String userMail,String eventId) {
		String messageBody = "";
		try {
			List<com.liferay.dynamic.data.mapping.model.DDMStructure> ddmStructureList = DDMStructureLocalServiceUtil
					.getStructures();
			String[] structureKeyArray = null;
			for (com.liferay.dynamic.data.mapping.model.DDMStructure ddmStructure : ddmStructureList) {
				System.out.println("ddmStructure.getName(\"en_US\") "+ddmStructure.getName("en_US"));
				if (ddmStructure.getName("en_US").equalsIgnoreCase("applyMessageSuccess")) {
					System.out.println("insideIf");
					structureKeyArray = new String[] { ddmStructure.getStructureKey() };
					break;
				}
				
			}
			JournalArticleLocalServiceUtil.getStructureArticles(structureKeyArray).parallelStream()
					.filter(predicate -> predicate.getStatus() == WorkflowConstants.STATUS_APPROVED)
					.forEach(journalArticle -> {
						try {
							System.out.println("inside parallel stream");
							if (JournalArticleLocalServiceUtil.isLatestVersion(journalArticle.getGroupId(),
									journalArticle.getArticleId(), journalArticle.getVersion())) {
								if (Validator.isNotNull(journalArticle)) {
									Document document = SAXReaderUtil.read(journalArticle.getContentByLocale("en_US"));
									System.out.println(document.selectSingleNode(
											"/root/dynamic-element[@name='appliedToEvent']/dynamic-content[@language-id='en_US']")
											.getText());
									sendMailToUser(fullName ,eventId ,userMail, true, document.selectSingleNode(
											"/root/dynamic-element[@name='appliedToEvent']/dynamic-content[@language-id='en_US']")
											.getText());
								}
								return;
							}
						} catch (PortalException | DocumentException e) {
							e.getMessage();
						}
					});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return messageBody;
	}
	
	public void sendMailToUser(String fullName, String eventId ,String mail, boolean isAccepted, String messageBody) {
		System.out.println("sending mail start");
		InternetAddress fromAddress = null;
		String toEmailAddress = mail;
		String[] toEmailArray = toEmailAddress.split(",");
		CalendarBooking obj;
		InternetAddress[] toAddress = new InternetAddress[toEmailArray.length];
		for (int i = 0; i < toEmailArray.length; i++) {
			try {
				toAddress[i] = new InternetAddress(toEmailArray[i]);
			} catch (AddressException e) {
				System.err.println("Address Exception occured while retrive toAddress : " + e);
			}
		}

		try {
			obj = (CalendarBooking) CalendarBookingLocalServiceUtil.getCalendarBooking(Long.parseLong(eventId));
			messageBody = messageBody.replace("User",fullName).replace("eventName",obj.getTitle("en_us"));
			fromAddress = new InternetAddress("mmiskfoundation@gmail.com");
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

	protected DDMForm getDDMForm(DDMFormInstance ddmFormInstance)
		throws PortalException {

		DDMStructure ddmStructure = ddmFormInstance.getStructure();

		return ddmStructure.getDDMForm();
	}

	protected boolean isEmailNotificationEnabled(
			DDMFormInstance ddmFormInstance)
		throws PortalException {

		DDMFormInstanceSettings formInstanceSettings =
			ddmFormInstance.getSettingsModel();

		return formInstanceSettings.sendEmailNotification();
	}


	@Reference(unbind = "-")
	protected void setDDMFormInstanceRecordService(
		DDMFormInstanceRecordService ddmFormInstanceRecordService) {

		_ddmFormInstanceRecordService = ddmFormInstanceRecordService;
	}

	@Reference(unbind = "-")
	protected void setDDMFormInstanceService(
		DDMFormInstanceService ddmFormInstanceService) {

		_ddmFormInstanceService = ddmFormInstanceService;
	}

	@Reference(unbind = "-")
	protected void setDDMFormValuesFactory(
		DDMFormValuesFactory ddmFormValuesFactory) {

		_ddmFormValuesFactory = ddmFormValuesFactory;
	}

	protected void validateCaptcha(
			ActionRequest actionRequest, DDMFormInstance ddmFormInstance)
		throws Exception {

		DDMFormInstanceSettings formInstanceSettings =
			ddmFormInstance.getSettingsModel();

		if (formInstanceSettings.requireCaptcha()) {
			try {
				CaptchaUtil.check(actionRequest);
			}
			catch (CaptchaTextException cte) {
				SessionErrors.add(
					actionRequest, CaptchaTextException.class.getName());

				throw cte;
			}
		}
	}


	private DDMFormInstanceRecordService _ddmFormInstanceRecordService;

	@Reference
	private DDMFormInstanceRecordVersionLocalService
		_ddmFormInstanceRecordVersionLocalService;

	private DDMFormInstanceService _ddmFormInstanceService;
	private DDMFormValuesFactory _ddmFormValuesFactory;

	@Reference
	private Portal _portal;
	
}
