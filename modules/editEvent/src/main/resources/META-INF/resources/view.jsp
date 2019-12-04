<%@ include file="/init.jsp" %>
<%@page import="com.liferay.calendar.model.CalendarBooking"%>
<%@page import="com.liferay.calendar.service.CalendarBookingLocalServiceUtil"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.dao.jdbc.DataAccess"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@page import="com.liferay.dynamic.data.mapping.model.DDMFormInstance"%>
<%@page import="com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <link href="/o/new-misk-theme/css/editEvent/jquery.searchableSelect.css" rel="stylesheet" type="text/css">
  <link href="/o/new-misk-theme/css/editEvent/jquery-ui1.12.1.css" rel="stylesheet" type="text/css">
  <script src="/o/new-misk-theme/js/editEvent/jquery.searchableSelect.js"></script>
  <script src="/o/new-misk-theme/js/editEvent/jquery-ui1.12.1.js"></script>
  <script src="/o/new-misk-theme/js/editEvent/bootstrap-datetimepicker.js"></script>
  <link href="/o/new-misk-theme/css/editEvent/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
  
  <liferay-portlet:resourceURL var="resourceUrl" />
  <%
    String startDate1="",endDate1="",deadline1="";
    String startDate2="",endDate2="",deadline2="";
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");

    DateFormat dateFormat2 = new SimpleDateFormat("dd MMMM yyyy - hh:mm a");
    System.out.println("eventId : "+ renderRequest.getAttribute("eventID"));
	CalendarBooking cb = CalendarBookingLocalServiceUtil.getCalendarBooking(Long.parseLong(renderRequest.getAttribute("eventID").toString()));
// 	System.out.println("EventTypes" + cb.getExpandoBridge().getAttribute("Event Types", false));

	startDate1 = dateFormat.format(Long.valueOf(cb.getStartTime()));
	endDate1   = dateFormat.format(Long.valueOf(cb.getEndTime()));
	
	long groupId = themeDisplay.getSiteGroupId();
	List<DDMFormInstance> formNameList = DDMFormInstanceLocalServiceUtil.getFormInstances(groupId);
	
	startDate2 = dateFormat2.format(Long.valueOf(cb.getStartTime()));
	endDate2   = dateFormat2.format(Long.valueOf(cb.getEndTime()));
	
	if(cb.getExpandoBridge().getAttribute("RegistrationDeadline", false) != null)
	{
		Date deadlindate = new Date(cb.getExpandoBridge().getAttribute("RegistrationDeadline", false).toString());
		deadline1 = dateFormat.format(Long.valueOf(deadlindate.getTime()));
		deadline2 = dateFormat2.format(Long.valueOf(deadlindate.getTime()));
		System.out.println(" ==deadline1== " + deadline1 + " ======== " + deadline2);
	}
	System.out.println("LanguageId ==== " + cb.getDefaultLanguageId());
	String eventDesc = cb.getDescription("en_us");
	String eventDescAr = cb.getDescription("ar_sa");
	String eventTitleAr = cb.getTitle("ar_sa");
  %>
<script>
var cntr = 0; //getmax id existing
var cntrItem = 0;
var cntrSpeaker = 0;
var cntrEditor = 0;
var cntrReviewer = 0;
var cntrKeyEvntRev = 0;
var cntrBadge = 0;
var cntrkeyTimeline = 0;
var cntrTimelineIntern = 2;
var cntrFaq = 0;
var counter = 0;
var obj             = {};
var speakerSave = true;
var editableSpeaker = 0;

var calendarBookingID = <%=renderRequest.getAttribute("eventID") %>;

$( document ).ready(function() {
	callServeResource(calendarBookingID,"fillData");
	fillEventData();
	
    $('#addAttribute').click(function () {
        $('#dialog1').dialog("open");
    });
	
    $('#addItem').click(function () {
        $('#dialog2').dialog("open");
    });
	
    $('#addSpeaker').click(function () {
    	speakerSave = true;
    	if(!$("#dialog3 .searchable-select").is(":visible")){$("#dialog3 .searchable-select").show();}
    	$("#speakerUser").val('');
    	$("#speakerOrder").val('');
    	$("#imgSpeakerBase64").val('');
    	$("#isNotifEnabled").prop('checked', false);
        $('#dialog3').dialog("open");
    });
	
    $('#addFaq').click(function () {
        $('#dialog4').dialog("open");
    });
	
    $('#addTimeline').click(function () {
        $('#dialog5').dialog("open");
    });
	
    $('#addBadge').click(function () {
        $('#dialog6').dialog("open");
    });
	
    $('#addEditor').click(function () {
        $('#dialog7').dialog("open");
    });
	
    $('#addReviewer').click(function () {
    	if(cntrKeyEvntRev> 0) {	swal("You can add only one reviewer!");return;}
        $('#dialog8').dialog("open");
    });
	
    $('#addTimelineRow').click(function () {
    	
		$("#timelineDivs").append('<div id="timeline'+cntrTimelineIntern+'" class="timelineRow"><i class="fa fa-remove iclass removeTimeline" aria-hidden="true" id="'+cntrTimelineIntern+'" onclick="removeinternalTimeline(this)"></i>'
	        +'<div class="controls input-append form-control date form_datetime datePickerClass"  data-date-format="dd MM yyyy - HH:ii p" data-link-field="fromTime'+cntrTimelineIntern+'">'
	        +'<input size="16" type="text" value="" class="datePickerInput" readonly placeholder="From Time">'
	        +'<span class="add-on"><i class="icon-remove"></i></span>'
	        +'<span class="add-on"><i class="icon-th"></i></span>'
	        +'</div>'
	        +'<input type="hidden" id="fromTime'+cntrTimelineIntern+'" value="" required name="From Time"/>'
				
	        +'<div class="controls input-append form-control date form_datetime datePickerClass timelineAddedRow"  data-date-format="dd MM yyyy - HH:ii p" data-link-field="toTime'+cntrTimelineIntern+'">'
	        +'<input size="16" type="text" value="" class="datePickerInput" readonly placeholder="To Time">'
	        +'<span class="add-on"><i class="icon-remove"></i></span>'
	        +'<span class="add-on"><i class="icon-th"></i></span>'
	        +'</div>'
	        +'<input type="hidden" id="toTime'+cntrTimelineIntern+'" value="" required name="To Time"/>'
	        +'<input type="text" class="datePickerClass form-control timelineAddedRow" id="timelineDescription'+cntrTimelineIntern+'" placeholder="Description" name = "Description" required>'
	        +'<input type="text" class="datePickerClass form-control timelineAddedRow" id="timelineDescriptionAr'+cntrTimelineIntern+'" placeholder="DescriptionAr" name = "DescriptionAr">'
	        +'</div>'
		);
		
	    $('.form_datetime').datetimepicker({
	        //language:  'fr',
	        weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			forceParse: 0,
	        showMeridian: 1
	    });
	    
		cntrTimelineIntern++;
    });
    
	$( "#dialog1" ).dialog({
	    modal: true,
	    autoOpen: false,
	    height: 250,
	    width: 400,
	    buttons: [
        { text: "Save"  , click: function () 
        	{
	        	var attrNumber = $("#attributeNb").val(); 
	        	var attrName = $("#attributeName").val();
	        	
	        	var allrequireFields = true;
	        	$("#dialog1").find('input , textarea, select').each(function(){
	        	    if($(this).prop('required')){
	        	    	 
	        	    	if(!this.value)
	        	    	{
	        	    	showHideALertReq(this.name + ' is required','#dialog1');
	        	    	
	        	    	allrequireFields=false;
	  		            return allrequireFields;
	        	    	}
	        	    	else
	        	    	 return allrequireFields;
	        	    	
	        	    } 
	        	});
	        	
	        	if(allrequireFields)
	    		{
	        		cntr++;
	        		var id = cntr;
	    			$("#eventAttributesDiv").append(
	    				  	'<div id="div'+id+'" class="form-group addedDivs">'
	    				   +'<i class="fa fa-remove iclass" aria-hidden="true" id="'+ id +'" onclick="removeThisDiv(this);"></i>'
	    				   +'<input type="text" class="form-control" id="attributeNb'+id+'"   value="' + attrNumber + '" disabled>'
	    				   +'<input type="text" class="form-control" id="attributeName'+id+'" value="' + attrName + '" disabled>'
	    				   +'</div>'
	    			);
	    			
	    			$("#attributeNb").val('');
	    			$("#attributeName").val('');
	    			$( this ).dialog( "close" );
	    			
	    			var jsonStrAttr = '[{"key":"'+id+'","eventNumber":"'+ $("#attributeNb"+id).val()+'","eventName":"'+$("#attributeName"+id).val()+'"}]';
	    			
	    			callServeResource(calendarBookingID,"doInsert",jsonStrAttr);
	    			showHideALert();
	    		}
        	}, class:"btn-save"},
//         { text: "Save"  , click: function () { alert("save") ;}, class:"btn-save", style:"color:Red" },
        { text: "Cancel", click: function () 
			{ 
	        	$("#attributeNb").val('');
				$("#attributeName").val('');
	            $( this ).dialog( "close" );
			}, class:"btn-cancel"}
        ]
	});
    
	$( "#dialog2" ).dialog({
	    modal: true,
	    autoOpen: false,
	    height: 455,
	    width: 500,
	    buttons: [
	        { text: "Save"  , click: function () 
	        	{ 
		        	var itemTitle = $("#itemTitle").val(); 
		        	var itemTitleAr = $("#itemTitleAr").val(); 
		        	var itemDescription = $("#itemDescription").val();
		        	var itemDescriptionAr = $("#itemDescriptionAr").val();
		        	
		        	var allrequireFields = true;
		        	$("#dialog2").find('input , textarea, select').each(function(){
		        	    if($(this).prop('required')){
		        	    	 
		        	    	if(!this.value)
		        	    	{
		        	    	showHideALertReq(this.name + ' is required','#dialog2');
		        	        
		        	    	allrequireFields=false;
		  		            return allrequireFields;
		        	    	}
		        	    	else
		        	    	 return allrequireFields;
		        	    } 
		        	});
	
	        		if(allrequireFields)
	        		{
		        		cntrItem++;
		        		var idItem = cntrItem;
		        		
	        			$("#eventItemsDiv").append(
	        				  	'<div id="divItem'+idItem+'" class="form-group addedDivs">'
	        				   +'<i class="fa fa-remove iclass" aria-hidden="true" id="'+ idItem +'" onclick="removeThisItem(this);"></i>'
	        				   +'<input type="text" class="form-control" id="itemTitle'+idItem+'"   value="' + itemTitle + '" disabled>'
	        				   +'<input type="text" class="form-control" id="itemTitleAr'+idItem+'"   value="' + itemTitleAr + '" disabled>'
	        				   +'<input type="text" class="form-control" id="itemDescription'+idItem+'" value="' + itemDescription + '" disabled>'
	        				   +'<input type="text" class="form-control" id="itemDescriptionAr'+idItem+'" value="' + itemDescriptionAr + '" disabled>'
	        				   +'<input type="text" id="imgItemBase64'+idItem+'" style="display: none;">'
	        				   +'</div>'
	        			);
	        			$("#imgItemBase64"+idItem).val($("#imgItemBase64").val());
	        			$("#itemTitle").val('');
	        			$("#itemTitleAr").val('');
	        			$("#itemDescription").val('');
	        			$("#itemDescriptionAr").val('');
	        			document.getElementById("previewItemImgId").innerHTML = "";
	        			$("#itemImageId").val('');
	        			$("#imgItemBase64").val('');
	        			$( this ).dialog( "close" );
	        			
	        			var jsonStrItem = '[{"key":"'+idItem+'","title":"'+ $("#itemTitle"+idItem).val()+'","titleAr":"'+ $("#itemTitleAr"+idItem).val()
	        				+'","description":"'+$("#itemDescription"+idItem).val()+'","descriptionAr":"'+$("#itemDescriptionAr"+idItem).val()
	        				+'","imgItemBase64":"'+$("#imgItemBase64"+idItem).val()+'"}]';
	        			callServeResource(calendarBookingID,"doInsert",null,null,null,jsonStrItem);
	        			showHideALert();
	        		}
	        	}, class:"btn-save"},
	        { text: "Cancel", click: function () 
        		{ 
		        	$("#itemTitle").val('');
		        	$("#itemTitleAr").val('');
	    			$("#itemDescription").val('');
	    			$("#itemDescriptionAr").val('');
	    			document.getElementById("previewItemImgId").innerHTML = "";
	    			$("#itemImageId").val('');
	    			$("#imgItemBase64").val('');
		            $( this ).dialog( "close" );
        		}, class:"btn-cancel"}
        ]
	});
	
	$( "#dialog3" ).dialog({
	    modal: true,
	    autoOpen: false,
	    height: 455,
	    width: 500,
	    buttons: [
	        { text: "Save"  , click: function () 
	        	{ 
		        	var speakerUser = $("#speakerUser").val();
		        	var speakerOrder = $("#speakerOrder").val();
		        	var speakerUserName = $("#speakerUser option:selected" ).text();
		        	var isNotifEnabled = "0";
		        	if($("#isNotifEnabled").prop("checked"))
		        		isNotifEnabled = "1";
		        	var allrequireFields = true;
		        	$("#dialog3").find('input , textarea, select').each(function(){
		        	    if($(this).prop('required')){
		        	    	if(!this.value && (speakerSave || (!speakerSave && this.name !='Image')))
		        	    	{
		        	    	showHideALertReq(this.name + ' is required',"#dialog3");
		        	       
		        	    	allrequireFields=false;
		  		            return allrequireFields;
		        	    	}
		        	    	else
		        	    	 return allrequireFields;
		        	    } 
		        	});
		        	
	        		if(allrequireFields)
	        		{
	 	        		var zOrder = 0;
	 	        		if(speakerOrder != null && speakerOrder != "" && speakerOrder != "null")
	 	        			zOrder = speakerOrder;
	 	        		
	        			if(speakerSave)
	        			{
		         			cntrSpeaker++;
		 	        		var idSpeaker = cntrSpeaker;
		 	        		var value = speakerUserName.trim();
		 	        		
		 	        		if($("#speakerUser option:selected" ).attr("position")){
			 	        		var positionVal = $("#speakerUser option:selected" ).attr("position");
			 	        		if(positionVal != null && positionVal != "" && positionVal != "null")
		 	        				value += ' ('+$("#speakerUser option:selected" ).attr("position")+')';
		 	        		}
		 	        		if($("#speakerUser option:selected" ).attr("email"))
		 	        		value += ' - '+$("#speakerUser option:selected" ).attr("email");
		 	        		
		 	        		$("#eventSpeakerDiv").append(
		         				  	'<div id="divSpeaker'+idSpeaker+'" class="form-group addedDivs" '
		        				   +' speakerOrder="'+ zOrder +'" speakerId="'+ speakerUser +'" isNotifEnabled="'+ isNotifEnabled +'" >'
		         				   +'<i class="fa fa-remove iclass" aria-hidden="true" id="'+ idSpeaker +'" onclick="removeThisSpeaker(this);"></i>'
		         				   +'<i class="fa fa-edit iclassEd" aria-hidden="true" id="'+ idSpeaker +'" onclick="editThisSpeaker(this);"></i>'
		         				   +'<input type="text" class="form-control" id="speakerName'+idSpeaker+'" value="' + value +'" disabled="disabled">'
		//          				   +'<input type="text" class="form-control" id="speakerDescription'+idSpeaker+'" value="' + speakerDescription + '">'
		         				   +'<input type="text" id="imgSpeakerBase64'+idSpeaker+'" style="display: none;">'
		         				   +'</div>'
		         			);
		 	        		
		         			$("#imgSpeakerBase64"+idSpeaker).val($("#imgSpeakerBase64").val());
		         			$("#speakerImageId").val('');
		         			$("#speakerName").val('');
		    				$("#speakerUser").val('');
		         			document.getElementById("previewSpeakerImgId").innerHTML = ""; 
		         			$("#imgSpeakerBase64").val('');
		         			$( this ).dialog( "close" );
	         			
	        				var jsonStrSpeaker = '[{"key":"'+idSpeaker+'","userId":"'+ speakerUser +'","isNotifEnabled":"'+isNotifEnabled+'","speakerOrder":"'+ zOrder +'","imgSpeakerBase64":"'+$("#imgSpeakerBase64"+idSpeaker).val()+'"}]';
	        				callServeResource(calendarBookingID,"doInsert",null,null,jsonStrSpeaker);
	        			}
	        			else{
	        				var jsonStrSpeaker = '[{"key":"'+editableSpeaker+'","userId":"'+ speakerUser +'","isNotifEnabled":"'+isNotifEnabled+'","speakerOrder":"'+ zOrder +'","imgSpeakerBase64":"'+$("#imgSpeakerBase64").val()+'"}]';
	        				callServeResource(calendarBookingID,"updateSpeaker",null,null,jsonStrSpeaker);
	        				speakerSave = true;
	        				$("#speakerImageId").val('');
	        				document.getElementById("previewSpeakerImgId").innerHTML = ""; 
		         			$("#imgSpeakerBase64").val('');
		         			$("#dialog3 .searchable-select").show();
		         			$("#divSpeaker"+editableSpeaker).attr("speakerorder",zOrder);
		         			$("#divSpeaker"+editableSpeaker).attr("isnotifenabled",isNotifEnabled);
		         			editableSpeaker = 0;
		         			$( this ).dialog( "close" );
	        			}
	        			showHideALert();
	        		}
	        	}, class:"btn-save"},
	        { text: "Cancel", click: function () 
        		{ 
		        	$("#speakerName").val('');
					$("#speakerUser").val('');
	    			$("#speakerImageId").val('');
	    			document.getElementById("previewSpeakerImgId").innerHTML = "";
	     			$("#imgSpeakerBase64").val('');
		            $( this ).dialog( "close" );
        		}, class:"btn-cancel"}
        ]
	});
    
	$( "#dialog4" ).dialog({
	    modal: true,
	    autoOpen: false,
	    height: 355,
	    width: 500,
	    buttons: [
	        { text: "Save"  , click: function () 
	        	{ 
		        	var faqQuestion = $("#faqQuestion").val(); 
		        	var faqQuestionAr = $("#faqQuestionAr").val(); 
		        	var faqResponse = $("#faqResponse").val();
		        	var faqResponseAr = $("#faqResponseAr").val();
		        	
		        	var allrequireFields = true;
		        	$("#dialog4").find('input , textarea, select').each(function(){
		        	    if($(this).prop('required')){
		        	    	 
		        	    	if(!this.value)
		        	    	{
		        	    	showHideALertReq(this.name + ' is required','#dialog4');
		        	       
		        	    	allrequireFields=false;
		  		            return allrequireFields;
		        	    	}
		        	    	else
		        	    	 return allrequireFields;
		        	    } 
		        	});
		        	
		        	if(allrequireFields)
	        		{
		        		cntrFaq++;
		        		var id = cntrFaq;
	        			$("#eventFaqDiv").append(
	        				  	'<div id="divFaq'+id+'" class="form-group addedDivs">'
	        				   +'<i class="fa fa-remove iclass" aria-hidden="true" id="'+ id +'" onclick="removeFaqDiv(this);"></i>'
	        				   +'<input type="text" class="form-control" id="faqQuestion'+id+'"   value="' + faqQuestion + '" disabled>'
	        				   +'<input type="text" class="form-control" id="faqQuestionAr'+id+'"   value="' + faqQuestionAr + '" disabled>'
	        				   +'<textarea class="form-control" rows="5" id="faqResponse'+id+'" disabled></textarea>'
	        				   +'<textarea class="form-control" rows="5" id="faqResponseAr'+id+'" disabled></textarea>'
	//         				   +'<input type="text" class="form-control" id="faqResponse'+id+'" value="' + faqResponse + '">'
	        				   +'</div>'
	        			);
	        			
	        			$("#faqQuestion").val('');
	        			$("#faqQuestionAr").val('');
	        			$("#faqResponse").val('');
	        			$("#faqResponseAr").val('');
	        			$("#faqResponse"+id).val(faqResponse);
	        			$("#faqResponseAr"+id).val(faqResponseAr);
	        			$( this ).dialog( "close" );
	        			
	        			var jsonStrFAQ = '"key":"'+id+'","question":"'
	        			+ $("#faqQuestion"+id).val()+'","questionAr":"'
	        			+ $("#faqQuestionAr"+id).val()+'","response":"'
	        			+ $("#faqResponse"+id).val()+'","responseAr":"'
	        			+$("#faqResponseAr"+id).val()+'"';
	        			callServeResource(calendarBookingID,"doInsert",null,jsonStrFAQ);
	        			showHideALert();
	        		}
	        	}, class:"btn-save"},
	        { text: "Cancel", click: function () 
        		{ 
		        	$("#faqQuestion").val('');
		        	$("#faqQuestionAr").val('');
	    			$("#faqResponse").val('');
	    			$("#faqResponseAr").val('');
		            $( this ).dialog( "close" );
        		}, class:"btn-cancel"}
        ]
	});
    
	$( "#dialog5" ).dialog({
	    modal: true,
	    autoOpen: false,
	    height: 355,
	    width: 770,
	    buttons: [
	        { text: "Save"  , click: function () 
	        	{
					var timelineType = $("#timelineType").val(); 
	        	
		        	var allrequireFields = true;
		        	$("#dialog5").find('input , textarea, select').each(function(){
		        	    if($(this).prop('required')){
		        	    	 
		        	    	if(!this.value)
		        	    	{
		        	    		showHideALertReq(this.name + ' is required','#dialog5');
			        	        
			        	    	allrequireFields=false;
			  		            return allrequireFields;
		        	    	}
		        	    	else
		        	    	 return allrequireFields;
		        	    } 
		        	});
		        	if(allrequireFields)
	        		{
		        		
		        		cntrkeyTimeline++;
		        		counter = 0;
		        		var id = cntrkeyTimeline;
		        		
		        		var jsonStrtimeline = '[{"key":"'+id+'","timelineType":"'+ $("#timelineType").val()+'","timelines":[';
						var timelineStr = '';
		        		
			        	$("#timelineDivs").find('input').each(function(){
			        	    if($(this).prop('id')){
			        	   		if($(this).prop('id').includes("fromTime"))
		        	   			{
			        	   			var dkey = eval(id+counter);
									timelineStr += '<div id="divTimeline'+dkey+'" class="form-group addedDivs">'
									+'<i class="fa fa-remove iclass" aria-hidden="true" id="'+dkey+'" onclick="removeTimeline(this);"></i>'
									+ $("#timelineType").val() +'<br>'
									+ $("#fromTime"+eval($(this).prop('id').substring($(this).prop('id').indexOf("fromTime")+8))).val() + ' - ' 
									+ $("#toTime"+eval($(this).prop('id').substring($(this).prop('id').indexOf("fromTime")+8))).val() + ': '
									+ $("#timelineDescription"+eval($(this).prop('id').substring($(this).prop('id').indexOf("fromTime")+8))).val() + ' - ' 
									+ $("#timelineDescriptionAr"+eval($(this).prop('id').substring($(this).prop('id').indexOf("fromTime")+8))).val()
									+'</div>';
									counter++;	
			        	   			jsonStrtimeline+='{"fromTime":"'+this.value+'",';
		        	   			}
			        	   		if($(this).prop('id').includes("toTime"))
			        	   			jsonStrtimeline+='"toTime":"'+this.value+'",';
			        	   		
			        	   		if($(this).prop('id').includes("timelineDescriptionAr")){
			        	   			jsonStrtimeline+='"timelineDescriptionAr":"'+this.value+'"},';
			        	   		}else if($(this).prop('id').includes("timelineDescription"))
			        	   			jsonStrtimeline+='"timelineDescription":"'+this.value+'",';
			        	    } 
			        	});
			        	
			        	jsonStrtimeline = jsonStrtimeline.substring(0,jsonStrtimeline.length-1) + ']}]';
	        			callServeResource(calendarBookingID,"doInsert",null,null,null,null,jsonStrtimeline);
	        			showHideALert();
	        			$("#eventTimelineDiv").append(timelineStr);
	        			
	        			$("#timelineType").val('');
	        			$("#timelineDescription1").val('');
	        			$("#timelineDescriptionAr1").val('');
	        			$("#fromTime1").val('');
	        			$("#fromdate1").val('');
	        			$("#toTime1").val('');
	        			$("#todate1").val('');
	        			$( this ).dialog( "close" );
	        			
			        	$("#timelineDivs").find('input').each(function(){
			        	    if($(this).prop('id')){
			        	   		if($(this).prop('id').includes("fromTime"))
		        	   			{
			        	   			var kk = $(this).prop('id').substring($(this).prop('id').indexOf("fromTime")+8);
			        	   			if(kk != '1')
			        	   				$("#timeline"+kk).remove();
		        	   			}
			        	    }
			        	});
	        		}
	        	}, class:"btn-save"},
	        { text: "Cancel", click: function () 
        		{ 
	    			$("#timelineType").val('');
	    			$("#timelineDescription1").val('');
	    			$("#timelineDescriptionAr1").val('');
	    			$("#fromTime1").val('');
	    			$("#fromdate1").val('');
	    			$("#toTime1").val('');
	    			$("#todate1").val('');
	        		$( this ).dialog( "close" );
	        		
		        	$("#timelineDivs").find('input').each(function(){
		        	    if($(this).prop('id')){
		        	   		if($(this).prop('id').includes("fromTime"))
	        	   			{
		        	   			var kk = $(this).prop('id').substring($(this).prop('id').indexOf("fromTime")+8);
		        	   			if(kk != '1')
		        	   				$("#timeline"+kk).remove();
	        	   			}
		        	    }
		        	});
        		}, class:"btn-cancel"}
        ]
	});
	
	$( "#dialog6" ).dialog({
	    modal: true,
	    autoOpen: false,
	    height: 455,
	    width: 500,
	    buttons: [
	        { text: "Save"  , click: function () 
	        	{ 
		        	var allrequireFields = true;
		        	$("#dialog6").find('input , textarea, select').each(function(){
		        	    if($(this).prop('required')){
		        	    	 
		        	    	if(!this.value)
		        	    	{
		        	    	showHideALertReq(this.name + ' is required','#dialog6');
		        	 
		        	    	allrequireFields=false;
		  		            return allrequireFields;
		        	    	}
		        	    	else
		        	    	 return allrequireFields;
		        	    } 
		        	});
		        	
	        		if(allrequireFields)
	        		{
	        			cntrBadge++;
	 	        		var idBadge = cntrBadge;
	 	        		document.getElementById("eventBadgeDiv").innerHTML = ""; 
	 	        		$("#eventBadgeDiv").append(
	         				  	'<div id="divBadge'+idBadge+'" class="form-group addedDivs badgePic">'
	         				   +'<i class="fa fa-remove iclass" aria-hidden="true" id="'+ idBadge +'" onclick="removeThisBadge(this);"></i>'
	         				   +'<img src="'+ $("#imgBadgeBase64").val() +'" style="width: 360px;">'
	         				   +'<input type="text" id="imgBadgeBase64'+idBadge+'" style="display: none;">'
	         				   +'</div>'
	         			);
	 	        		
	         			$("#imgBadgeBase64"+idBadge).val($("#imgBadgeBase64").val());
	         			$("#badgeImageId").val('');
	         			document.getElementById("previewBadgeImgId").innerHTML = ""; 
	         			$("#imgBadgeBase64").val('');
	         			$( this ).dialog( "close" );
	         			
	        			var jsonidBadge = '[{"key":"'+idBadge+'","imgBadgeBase64":"'+$("#imgBadgeBase64"+idBadge).val()+'"}]';
	        			callServeResource(calendarBookingID,"doInsert",null,null,null,null,null,jsonidBadge);
	        			showHideALert();
	        		}
	        	}, class:"btn-save"},
	        { text: "Cancel", click: function () 
        		{ 
	    			$("#badgeImageId").val('');
	    			document.getElementById("previewBadgeImgId").innerHTML = "";
	     			$("#imgBadgeBase64").val('');
		            $( this ).dialog( "close" );
        		}, class:"btn-cancel"}
        ]
	});
	
	$( "#dialog7" ).dialog({
	    modal: true,
	    autoOpen: false,
	    height: 455,
	    width: 500,
	    buttons: [
	        { text: "Save"  , click: function () 
	        	{ 
		        	var editorUser = $("#editorUser").val();
		        	var editorUserName = $("#editorUser option:selected" ).text();
		        	var isNotifEditorEnabled = "0";
	// 	        	if($("#isNotifEditorEnabled").prop("checked"))
	// 	        		isNotifEditorEnabled = "1";
		        	var allrequireFields = true;
		        	$("#dialog7").find('input , textarea, select').each(function(){
		        	    if($(this).prop('required')){
		        	    	 
		        	    	if(!this.value)
		        	    	{
		        	    	showHideALertReq(this.name + ' is required','#dialog7');
		        	     
		        	    	allrequireFields=false;
		  		            return allrequireFields;
		        	    	}
		        	    	else
		        	    	 return allrequireFields;
		        	    } 
		        	});
		        	
	        		if(allrequireFields)
	        		{
	        			cntrEditor++;
	 	        		var idEditor = cntrEditor;
	 	        		var value = editorUserName.trim();
	 	        		
	 	        		if($("#editorUser option:selected" ).attr("position")){
		 	        		var positionVal = $("#editorUser option:selected" ).attr("position");
		 	        		if(positionVal != null && positionVal != "" && positionVal != "null")
	 	        				value += ' ('+$("#editorUser option:selected" ).attr("position")+')';
	 	        		}
	 	        		if($("#editorUser option:selected" ).attr("email"))
	 	        		value += ' - '+$("#editorUser option:selected" ).attr("email");
	 	        		
	 	        		$("#eventEditorDiv").append(
	         				  	'<div id="divEditor'+idEditor+'" class="form-group addedDivs">'
	         				   +'<i class="fa fa-remove iclass" aria-hidden="true" id="'+ idEditor +'" onclick="removeThisEditor(this);"></i>'
	         				   +'<input type="text" class="form-control" id="editorName'+ idEditor +'" value="' + value +'" disabled="disabled">'
	         				   +'<input type="text" id="imgEditorBase64'+idEditor+'" style="display: none;">'
	         				   +'</div>'
	         			);
	 	        		
	         			$("#imgEditorBase64"+idEditor).val($("#imgEditorBase64").val());
	         			$("#editorImageId").val('');
	         			document.getElementById("previewEditorImgId").innerHTML = ""; 
	         			$("#imgEditorBase64").val('');
	         			$( this ).dialog( "close" );
	         			
	        			var jsonStrEditor = '[{"key":"'+idEditor+'","userId":"'+ editorUser +'","isNotifEditorEnabled":"'+isNotifEditorEnabled+'","imgEditorBase64":"'+$("#imgEditorBase64"+idEditor).val()+'"}]';
	        			callServeResource(calendarBookingID,"doInsert",null,null,null,null,null,null,jsonStrEditor);
	        			showHideALert();
	        		}
	        	}, class:"btn-save"},
	        { text: "Cancel", click: function () 
        		{ 
		        	$("#editorName").val('');
	    			$("#editorDescription").val('');
	    			$("#editorImageId").val('');
	    			document.getElementById("previewEditorImgId").innerHTML = "";
	     			$("#imgEditorBase64").val('');
		            $( this ).dialog( "close" );
        		}, class:"btn-cancel"}
        ]
	});
	
	$( "#dialog8" ).dialog({
	    modal: true,
	    autoOpen: false,
	    height: 455,
	    width: 500,
	    buttons: [
	        { text: "Save"  , click: function () 
	        	{ 
		        	var reviewerUser = $("#reviewerUser").val();
		        	var reviewerUserName = $("#reviewerUser option:selected" ).text();
		        	var allrequireFields = true;
		        	$("#dialog8").find('input , textarea, select').each(function(){
		        	    if($(this).prop('required')){
		        	    	 
		        	    	if(!this.value)
		        	    	{
		        	    	showHideALertReq(this.name + ' is required','#dialog8');
		        	 
		        	    	allrequireFields=false;
		  		            return allrequireFields;
		        	    	}
		        	    	else
		        	    	 return allrequireFields;
		        	    } 
		        	});
		        	
	        		if(allrequireFields)
	        		{
	        			cntrReviewer++;
	 	        		var idReviewer = cntrReviewer;
	 	        		var value = reviewerUserName.trim();
	 	        		
	 	        		if($("#reviewerUser option:selected" ).attr("position")){
		 	        		var positionVal = $("#reviewerUser option:selected" ).attr("position");
		 	        		if(positionVal != null && positionVal != "" && positionVal != "null")
	 	        				value += ' ('+$("#reviewerUser option:selected" ).attr("position")+')';
	 	        		}
	 	        		if($("#reviewerUser option:selected" ).attr("email"))
	 	        		value += ' - '+$("#reviewerUser option:selected" ).attr("email");
	 	        		
	 	        		$("#eventReviewerDiv").append(
	         				  	'<div id="divReviewer'+idReviewer+'" class="form-group addedDivs">'
	         				   +'<i class="fa fa-remove iclass" aria-hidden="true" id="'+ idReviewer +'" onclick="removeThisReviewer(this);"></i>'
	         				   +'<input type="text" class="form-control" id="reviewerName'+ idReviewer +'" value="' + value +'" disabled="disabled">'
	         				   +'<input type="text" id="imgReviewerBase64'+idReviewer+'" style="display: none;">'
	         				   +'</div>'
	         			);
	 	        		
	         			$("#imgReviewerBase64"+idReviewer).val($("#imgReviewerBase64").val());
	         			$("#reviewerImageId").val('');
	         			document.getElementById("previewReviewerImgId").innerHTML = ""; 
	         			$("#imgReviewerBase64").val('');
	         			$( this ).dialog( "close" );
	         			
	        			var jsonStrReviewer = '[{"key":"'+idReviewer+'","userId":"'+ reviewerUser +'","imgReviewerBase64":"'+$("#imgReviewerBase64"+idReviewer).val()+'"}]';
	        			callServeResource(calendarBookingID,"doInsert",null,null,null,null,null,null,null,jsonStrReviewer);
	        			cntrKeyEvntRev++;
	        			showHideALert();
	        		}
	        	}, class:"btn-save"},
	        { text: "Cancel", click: function () 
        		{ 
		        	$("#reviewerName").val('');
	    			$("#reviewerDescription").val('');
	    			$("#reviewerImageId").val('');
	    			document.getElementById("previewReviewerImgId").innerHTML = "";
	     			$("#imgReviewerBase64").val('');
		            $( this ).dialog( "close" );
        		}, class:"btn-cancel"}
        ]
	});
	
	});
	
	function removeThisDiv(elem){
		$("#div"+elem.id).remove();
		callServeResource(calendarBookingID,"deleteAttributes",null,elem.id);
		showHideALert();
	}
	
	function removeThisItem(elem){
		$("#divItem"+elem.id).remove();
		callServeResource(calendarBookingID,"deleteItems",null,elem.id);
		showHideALert();
	}
	
	function removeThisSpeaker(elem){
		$("#divSpeaker"+elem.id).remove();
		callServeResource(calendarBookingID,"deleteSpeaker",null,elem.id);
		showHideALert();
	}
	
	function removeThisBadge(elem){
		$("#divBadge"+elem.id).remove();
		callServeResource(calendarBookingID,"deleteBadge",null,elem.id);
		showHideALert();
	}
	
	function removeThisEditor(elem){
		$("#divEditor"+elem.id).remove();
		callServeResource(calendarBookingID,"deleteEditor",null,elem.id);
		showHideALert();
	}
	
	function removeThisReviewer(elem){
		$("#divReviewer"+elem.id).remove();
		callServeResource(calendarBookingID,"deleteReviewer",null,elem.id);
		cntrKeyEvntRev--;
		showHideALert();
	}
	
	function removeFaqDiv(elem){
		$("#divFaq"+elem.id).remove();
		callServeResource(calendarBookingID,"deleteFAQ",null,elem.id);
		showHideALert();
	}
	
	function removeTimeline(elem){
		$("#divTimeline"+elem.id).remove();
		callServeResource(calendarBookingID,"deleteTimeline",null,elem.id);
		showHideALert();
	}
	
	function removeinternalTimeline(elem){
		$("#timeline"+elem.id).remove();
	}
	
	function editThisSpeaker(elem){
		speakerSave = false;
		editableSpeaker = elem.id;
		$("#speakerUser").val($("#divSpeaker"+elem.id).attr("speakerid"));
		$("#dialog3 .searchable-select").hide();
    	$("#speakerOrder").val($("#divSpeaker"+elem.id).attr("speakerorder"));
    	if( $("#divSpeaker"+elem.id).attr("isnotifenabled")== "1")
   			$("#isNotifEnabled").prop('checked', true);
		
		$('#dialog3').dialog("open");
	}
	
	
	function Submit(){
		var subject 	= $("#eventTitle").val();
		var subjectAr   = $("#eventTitleAr").val();
		var pitch 		= $("#eventPitch").val();
		var pitchAr 	= $("#eventPitchAr").val();
		var from 		= $("#eventStart").val();
		var deadline 	= $("#eventDeadline").val();
		var to 			= $("#eventEnd").val();
		var eventImgBase64 		= $("#eventImgBase64").val();
		var eventLocation 		= $("#eventLocation").val();
		var eventLocationAr		= $("#eventLocationAr").val();
		var eventLocationLink 	= $("#eventLocationLink").val();
		var eventDescription 	= $("#eventDescription").val();
		var eventDescriptionAr 	= $("#eventDescriptionAr").val();
		var eventType 			= $("#eventType").val();
    	var showOnLandUp 		= "false";
    	
    	if($("#ShowOnLand").prop("checked"))
    		showOnLandUp = "true";
		
		var allrequireFields1 = true;
		var allrequireFields2 = true;
		var allrequireFields3 = true;
    	$("#updateDiv1").find('input , textarea, select').each(function(){
    	    if($(this).prop('required')){
    	    	if(!this.value)
    	    	{
    	    		showHideALertReq(this.name + ' is required','#update-btn');
    	    		allrequireFields1=false;
		            return allrequireFields1;
    	    	}
    	    	else
    	    	 return allrequireFields1;
    	    } 
    	});
    	
    	$("#updateDiv2").find('input , textarea, select').each(function(){
    	    if($(this).prop('required')){
    	    	if(!this.value)
    	    	{
    	    		showHideALertReq(this.name + ' is required','#update-btn');
    	    		allrequireFields2=false;
		            return allrequireFields2;
    	    	}
    	    	else
    	    	 return allrequireFields2;
    	    } 
    	});
    	$("#updateDiv3").find('input , textarea, select').each(function(){
    	    if($(this).prop('required')){
    	    	if(!this.value)
    	    	{
    	    		showHideALertReq(this.name + ' is required','#update-btn');
    	    		allrequireFields3=false;
		            return allrequireFields3;
    	    	}
    	    	else
    	    	 return allrequireFields3;
    	    } 
    	});
    	
    	if(allrequireFields1 && allrequireFields2 && allrequireFields3){
			var jsonStrAttr = '"subject":"'+subject+'","pitch":"'+pitch+'","from":"'+ from+'","to":"'+to+'"';
			if(subjectAr != null && subjectAr != "")
				jsonStrAttr += ',"subjectAr":"'+subjectAr+'"'
			if(pitchAr != null && pitchAr != "")
				jsonStrAttr += ',"pitchAr":"'+pitchAr+'"'
			if(eventImgBase64 != null && eventImgBase64 != "")
				jsonStrAttr += ',"image":"'+eventImgBase64+'"'
			if(deadline != null && deadline != "")
				jsonStrAttr += ',"deadline":"'+deadline+'"'
			if(eventLocation != null && eventLocation != "")
				jsonStrAttr += ',"eventLocation":"'+eventLocation+'"'
			if(eventLocationAr != null && eventLocationAr != "")
				jsonStrAttr += ',"eventLocationAr":"'+eventLocationAr+'"'
			if(eventLocationLink != null && eventLocationLink != "")
				jsonStrAttr += ',"eventLocationLink":"'+eventLocationLink+'"'
			if(eventType != null && eventType != "")
				jsonStrAttr += ',"eventType":"'+eventType+'"'
			if(eventDescription != null && eventDescription != "")
				jsonStrAttr += ',"eventDescription":"'+eventDescription+'"'
			if(eventDescriptionAr != null && eventDescriptionAr != "")
				jsonStrAttr += ',"eventDescriptionAr":"'+eventDescriptionAr+'"'
			jsonStrAttr +=',"showOnLandUp":"'+showOnLandUp+'"';
			callServeResource(calendarBookingID,"updateEvent",jsonStrAttr);
			showHideALert();
    	}
	}
	
    function previewFile(obj1,obj2,obj3)
    {
        var filesSelected = document.getElementById(obj1).files;
        if (filesSelected.length > 0) {
	      var fileToLoad = filesSelected[0]	;
	      var fileReader = new FileReader();
	
	      fileReader.onload = function(fileLoadedEvent) {
		       var srcData = fileLoadedEvent.target.result; // <--- data: base64
		       var newImage = document.createElement('img');
		       newImage.setAttribute("id", "imageId1");
		       newImage.src = srcData;
		       document.getElementById(obj2).innerHTML = newImage.outerHTML;
		       $("textarea[name$=_ExpandoAttribute--UploadImageId--]").val(srcData);
		       $("#"+obj3).val(srcData);
	      }
	      fileReader.readAsDataURL(fileToLoad);
      }
	}
	
    function previewEventFile(obj1,obj2,obj3)
    {
        var filesSelected = document.getElementById(obj1).files;
        if (filesSelected.length > 0) {
	      var fileToLoad = filesSelected[0]	;
	      var fileReader = new FileReader();
	
	      fileReader.onload = function(fileLoadedEvent) {
		       var srcData = fileLoadedEvent.target.result; // <--- data: base64
			   $("#"+obj2).attr("src", srcData);
		       $("textarea[name$=_ExpandoAttribute--UploadImageId--]").val(srcData);
		       $("#"+obj3).val(srcData);
	      }
	      fileReader.readAsDataURL(fileToLoad);
      }
	}
	
    function callServeResource(calendarBookingId,command,eventAttributes,faqAttributes,speakersAttributes,jsonStrItem,jsonStrtimeline,jsonidBadge,editorsAttributes,reviewersAttributes)
    {
        AUI().use('aui-io-request', function(A){
            A.io.request('${resourceUrl}', {
            	method: 'post',
                   data: {
                	   <portlet:namespace />command           : command,
                	   <portlet:namespace />calendarBookingId : calendarBookingId,
                	   <portlet:namespace />eventAttributes   : eventAttributes,
                	   <portlet:namespace />faqAttributes     : faqAttributes,
                	   <portlet:namespace />speakersAttributes: speakersAttributes,
                	   <portlet:namespace />jsonStrItem       : jsonStrItem,
                	   <portlet:namespace />jsonStrtimeline   : jsonStrtimeline,
                	   <portlet:namespace />jsonidBadge       : jsonidBadge,
                	   <portlet:namespace />editorsAttributes : editorsAttributes,
                	   <portlet:namespace />reviewersAttributes : reviewersAttributes,
                   },
                   on: {
                       	success: function() {
    						var data = JSON.parse(this.get('responseData'));
    						
    						$(data).each(function(index, value){
    							if(value.keyFAQs!= '')
    								cntrFaq = value.keyFAQs;
    							
    							if(value.keySpeakers!= '')
    								cntrSpeaker = value.keySpeakers;
    							
    							if(value.keyItems!= '')
    								cntrItem = value.keyItems;
    							
    							if(value.keyAttributes!= '')
    								cntr = value.keyAttributes;
    							
    							if(value.keyTimeline!= '')
    								cntrkeyTimeline = value.keyTimeline;
    							
    							if(value.keyBadge!= '')
    								cntrBadge = value.keyBadge;
    							
    							if(value.keyEditors!= '')
    								cntrEditor = value.keyEditors;
    							
    							if(value.keyReviewers!= '')
    								cntrReviewer = value.keyReviewers;
    							
    							if(value.keyEvntRev!= '')
    								cntrKeyEvntRev = value.keyEvntRev;
    							
    							if(value.faqList!= null && value.faqList != '' &&value.faqList.length > 0)
   								{
    								for(var j = 0 ; j < value.faqList.length ; j++)
   									{
    				        			$("#eventFaqDiv").append(
    				        				  	'<div id="divFaq'+value.faqList[j].id+'" class="form-group addedDivs">'
    				        				   +'<i class="fa fa-remove iclass" aria-hidden="true" id="'+ value.faqList[j].id +'" onclick="removeFaqDiv(this);"></i>'
    				        				   +'<input type="text" class="form-control" id="faqQuestion'+value.faqList[j].id+'" value="' + value.faqList[j].question + '" disabled>'
    				        				   +'<input type="text" class="form-control" id="faqQuestionAr'+value.faqList[j].id+'" value="' + value.faqList[j].questionAr + '" disabled>'
    				        				   +'<textarea class="form-control" rows="5" id="faqResponse'+value.faqList[j].id+'" disabled></textarea>'
    				        				   +'<textarea class="form-control" rows="5" id="faqResponseAr'+value.faqList[j].id+'" disabled></textarea>'
    				        				   +'</div>'
    				        			);
    				        			
    				        			$("#faqResponse"+value.faqList[j].id).val(value.faqList[j].answer);
    				        			$("#faqResponseAr"+value.faqList[j].id).val(value.faqList[j].answerAr);
   									}
   								}
    							
    							if(value.itemsList!= null && value.itemsList != '' &&value.itemsList.length > 0)
   								{
    								for(var j = 0 ; j < value.itemsList.length ; j++)
   									{
    				        			$("#eventItemsDiv").append(
    				        				  	'<div id="divItem'+value.itemsList[j].id+'" class="form-group addedDivs">'
    				        				   +'<i class="fa fa-remove iclass" aria-hidden="true" id="'+ value.itemsList[j].id +'" onclick="removeThisItem(this);"></i>'
    				        				   +'<input type="text" class="form-control" id="itemTitle'+value.itemsList[j].id+'"   value="' + value.itemsList[j].title + '" disabled>'
    				        				   +'<input type="text" class="form-control" id="itemTitleAr'+value.itemsList[j].id+'"   value="' + value.itemsList[j].titleAr + '" disabled>'
    				        				   +'<input type="text" class="form-control" id="itemDescription'+value.itemsList[j].id+'" value="' + value.itemsList[j].description + '" disabled>'
    				        				   +'<input type="text" class="form-control" id="itemDescriptionAr'+value.itemsList[j].id+'" value="' + value.itemsList[j].descriptionAr + '" disabled>'
    				        				   +'<input type="text" id="imgItemBase64'+value.itemsList[j].id+'" style="display: none;">'
    				        				   +'</div>'
    				        			);
   									}
   								}
    							
    							if(value.attributesList!= null && value.attributesList != '' &&value.attributesList.length > 0)
   								{
    								for(var j = 0 ; j < value.attributesList.length ; j++)
   									{
    				        			$("#eventAttributesDiv").append(
    				        				  	'<div id="div'+value.attributesList[j].id+'" class="form-group addedDivs">'
    				        				   +'<i class="fa fa-remove iclass" aria-hidden="true" id="'+ value.attributesList[j].id +'" onclick="removeThisDiv(this);"></i>'
    				        				   +'<input type="text" class="form-control" id="attributeNb'+value.attributesList[j].id+'"   value="' + value.attributesList[j].attributeNumber + '" disabled>'
    				        				   +'<input type="text" class="form-control" id="attributeName'+value.attributesList[j].id+'" value="' + value.attributesList[j].attributeName + '" disabled>'
    				        				   +'</div>'
    				        			);
   									}
   								}
    							
    							if(value.usersList!= null && value.usersList != '' &&value.usersList.length > 0)
   								{
    								var valueName = '';
    								for(var j = 0 ; j < value.usersList.length ; j++)
   									{
    									valueName = value.usersList[j].firstName +' '+ value.usersList[j].lastName; 
    				 	        		if(value.usersList[j].position)
    				 	        			valueName += ' ('+value.usersList[j].position+')';
    				 	        		if(value.usersList[j].email)
    				 	        			valueName += ' - '+ value.usersList[j].email;
    				 	        		
    				 	        		$("#eventSpeakerDiv").append(
    				         				  	'<div id="divSpeaker'+value.usersList[j].userId+'" class="form-group addedDivs" ' 
    				         				   +' speakerOrder="'+value.usersList[j].speakerOrder+'" speakerId="'+value.usersList[j].speakerId+'" isNotifEnabled="'+value.usersList[j].isNotifEnabled+'" >'
    				         				   +'<i class="fa fa-remove iclass" aria-hidden="true" id="'+ value.usersList[j].userId +'" onclick="removeThisSpeaker(this);"></i>'
    				         				   +'<i class="fa fa-edit iclassEd" aria-hidden="true" id="'+ value.usersList[j].userId +'" onclick="editThisSpeaker(this);"></i>'
    				         				   +'<input type="text" class="form-control" id="speakerName'+value.usersList[j].userId+'" value="'+ valueName +'" disabled="disabled">'
    				         				   +'<input type="text" id="imgSpeakerBase64'+value.usersList[j].userId+'" style="display: none;">'//
    				         				   +'</div>'
    				         			);
   									}
   								}
    							
    							if(value.badgeList!= null && value.badgeList != '' &&value.badgeList.length > 0)
   								{
    								for(var j = 0 ; j < value.badgeList.length ; j++)
   									{
    				 	        		$("#eventBadgeDiv").append(
    				         				  	'<div id="divBadge'+value.badgeList[j].userId+'" class="form-group addedDivs badgePic">'
    				         				   +'<i class="fa fa-remove iclass" aria-hidden="true" id="'+ value.badgeList[j].userId +'" onclick="removeThisBadge(this);"></i>'
    				         				   +'<img src="'+ value.badgeList[j].image +'" style="width: 360px;">'
    				         				   +'<input type="text" id="imgBadgeBase64'+value.badgeList[j].userId+'" style="display: none;">'
    				         				   +'</div>'
    				         			);
   									}
   								}
    							
    							if(value.timelineList!= null && value.timelineList != '' &&value.timelineList.length > 0)
   								{
    								for(var j = 0 ; j < value.timelineList.length ; j++)
   									{
    				 	        		$("#eventTimelineDiv").append(
    										'<div id="divTimeline'+value.timelineList[j].id+'" class="form-group addedDivs">'
   										   +'<i class="fa fa-remove iclass" aria-hidden="true" id="'+value.timelineList[j].id+'" onclick="removeTimeline(this);"></i>'
   										   + value.timelineList[j].title +'<br>'
   										   + value.timelineList[j].eventstartday + ' - ' + value.timelineList[j].eventendday + ': '+ value.timelineList[j].description
   										   +'</div>'
    				         			);
   									}
   								}
    							
    							if(value.editorList!= null && value.editorList != '' &&value.editorList.length > 0)
   								{
    								var valueName = '';
    								for(var j = 0 ; j < value.editorList.length ; j++)
   									{
    									valueName = value.editorList[j].firstName +' '+ value.editorList[j].lastName; 
    				 	        		if(value.editorList[j].position)
    				 	        			valueName += ' ('+value.editorList[j].position+')';
    				 	        		if(value.editorList[j].email)
    				 	        			valueName += ' - '+ value.editorList[j].email;
    				 	        		
    				 	        		$("#eventEditorDiv").append(
    				         				  	'<div id="divEditor'+value.editorList[j].userId+'" class="form-group addedDivs">'
    				         				   +'<i class="fa fa-remove iclass" aria-hidden="true" id="'+ value.editorList[j].userId +'" onclick="removeThisEditor(this);"></i>'
    				         				   +'<input type="text" class="form-control" id="editorName'+value.editorList[j].userId+'" value="'+ valueName +'" disabled="disabled">'
    				         				   +'<input type="text" id="imgEditorBase64'+value.editorList[j].userId+'" style="display: none;">'//
    				         				   +'</div>'
    				         			);
   									}
   								}
    							
    							if(value.reviewerList!= null && value.reviewerList != '' &&value.reviewerList.length > 0)
   								{
    								var valueName = '';
    								for(var j = 0 ; j < value.reviewerList.length ; j++)
   									{
    									valueName = value.reviewerList[j].firstName +' '+ value.reviewerList[j].lastName; 
    				 	        		if(value.reviewerList[j].position)
    				 	        			valueName += ' ('+value.reviewerList[j].position+')';
    				 	        		if(value.reviewerList[j].email)
    				 	        			valueName += ' - '+ value.reviewerList[j].email;
    				 	        		
    				 	        		$("#eventReviewerDiv").append(
    				         				  	'<div id="divReviewer'+value.reviewerList[j].userId+'" class="form-group addedDivs">'
    				         				   +'<i class="fa fa-remove iclass" aria-hidden="true" id="'+ value.reviewerList[j].userId +'" onclick="removeThisReviewer(this);"></i>'
    				         				   +'<input type="text" class="form-control" id="reviewerName'+value.reviewerList[j].userId+'" value="'+ valueName +'" disabled="disabled">'
    				         				   +'<input type="text" id="imgReviewerBase64'+value.reviewerList[j].userId+'" style="display: none;">'//
    				         				   +'</div>'
    				         			);
   									}
   								}
    						});
                  		}
            		}
        	});
    	});
    }

    function fillEventData(){
    	$("#eventTitle").val("<%= cb.getTitle("en_us") %>");
    	
    	<% if(eventTitleAr != null && !"".equals(eventTitleAr) && !"null".equals(eventTitleAr)){ %>
		$("#eventTitleAr").val("<%= eventTitleAr %>");
		<% }  
    	if(cb.getExpandoBridge().getAttribute("pitch") != null && !"".equals(cb.getExpandoBridge().getAttribute("pitch"))){%>
    		$("#eventPitch").val("<%= cb.getExpandoBridge().getAttribute("pitch").toString() %>");
    	<% } 
    	if(cb.getExpandoBridge().getAttribute("pitchAr") != null && !"".equals(cb.getExpandoBridge().getAttribute("pitchAr"))){%>
			$("#eventPitchAr").val("<%= cb.getExpandoBridge().getAttribute("pitchAr").toString() %>");
		<% }
    	 Object[] a = (Object[]) CalendarBookingLocalServiceUtil.getCalendarBooking(cb.getCalendarBookingId()).getExpandoBridge().getAttribute("show on landing");
   	     Object obj = a[0];
   	     String showOnLanding = obj.toString();
   	 
    		if(showOnLanding != null 
    				&& ("true".equals(showOnLanding)||( "</br>".equals(showOnLanding)))
    				)
    		{%>
    			$("#ShowOnLand").prop('checked', true);
    	 <% }%>

    	 <% 
    		
    	 if(eventDesc != null && !"".equals(eventDesc) && !"null".equals(eventDesc)){
    	 %>
	    	 $("#eventDescription").val("<%=URLDecoder.decode(URLEncoder.encode(eventDesc,"UTF-8").replaceAll("%0A","~A1C~"),"UTF-8")%>");
	    	 var div = document.createElement("div");
	    	 div.innerHTML = $("#eventDescription").val().replace(new RegExp(/~A1C~/g), "\n");
	    	 var text = div.textContent || div.innerText || "";
	    	 $("#eventDescription").val(text);
    	 <%}
			
    	 	if(eventDescAr != null && !"".equals(eventDescAr) && !"null".equals(eventDescAr)){
    	 %>
	    	 $("#eventDescriptionAr").val("<%=URLDecoder.decode(URLEncoder.encode(eventDescAr,"UTF-8").replaceAll("%0A","~A1C~"),"UTF-8")%>");
	    	 var div = document.createElement("div");
	    	 div.innerHTML = $("#eventDescriptionAr").val().replace(new RegExp(/~A1C~/g), "\n");
	    	 var text = div.textContent || div.innerText || "";
	    	 $("#eventDescriptionAr").val(text);
    	 <%}%>
    }
    
    function testRequired(divName){
    	var allrequireFields = true;
    	$("#" + divName).find('input , textarea, select').each(function(){
    	    if($(this).prop('required')){
    	    	if(!this.value)
    	    	{
    	        alert(this.name + ' is required');
    	    	allrequireFields=false;
		            return allrequireFields;
    	    	}
    	    	else
    	    	 return allrequireFields;
    	    } 
    	});
    }
    
    function validate(evt) {
  		var theEvent = evt || window.event;

  	    if (theEvent.type === 'paste') {
  	   		// Handle paste
  	    	key = event.clipboardData.getData('text/plain');
  	    } 
  	    else 
  	    {
	  	    // Handle key press
	  	    var key = theEvent.keyCode || theEvent.which;
	  	    key = String.fromCharCode(key);
  	    }
  	    var regex = /[0-9]|\./;
  	    if( !regex.test(key) ) {
  	    	theEvent.returnValue = false;
  	    	if(theEvent.preventDefault) theEvent.preventDefault();
  	    }
   	}
    
    function showHideALert(){
    	var $div = $("#alertContainer");
    	if($div.is(":visible")){return;}
    	$div.show();
    	setTimeout(function(){
    		$div.hide();
    	},1000);
    }
</script>

<style type="text/css">

nav{display: none !important}
.form-control{color: #444 !important}
#ControlMenu{display: none !important;}


@font-face { font-family: 'Montserrat-SemiBold'; src: url('/o/new-misk-theme/fonts/Montserrat-SemiBold.otf'); }
		@font-face { font-family: 'Montserrat-Light'; src: url('/o/new-misk-theme/fonts/Montserrat-Light.otf'); }
		@font-face { font-family: 'Montserrat-Regular'; src: url('/o/new-misk-theme/fonts/Montserrat-Regular.otf'); }
		@font-face { font-family: 'Montserrat-Bold'; src: url('/o/new-misk-theme/fonts/Montserrat-Bold.otf'); }
		@font-face { font-family: 'Montserrat-Medium'; src: url('/o/new-misk-theme/fonts/Montserrat-Medium.otf'); }


 .ui-dialog-titlebar {
    background-color: #ffffff;
    color: #929292;
    border: 0;
    border-bottom: 1px solid #dee2e6;
    border-radius: 0;
    width: 94%;
    margin: 0 15px 0 15px;
 }
 .ui-state-default, .ui-widget-content .ui-state-default, .ui-widget-header .ui-state-default, .ui-button, html .ui-button.ui-state-disabled:hover, html .ui-button.ui-state-disabled:active {
    border: 0px solid #c5c5c5;
    background: #ffffff;
    font-weight: normal;
    color: #454545;
 }
		
 .iclass {position: absolute;left: 97%;}
 .iclassEd {position: absolute; left: 97%; bottom: 10px;}
 img#imageId1 {max-height: 230px;max-width: 550px;}
 .addedDivs{background-color: #e9ecef; padding: 10px;border-radius: 0.25rem;}
 .img-rounded{width:100%;}
 .invalid input:required:invalid {background: #BE4C54;}
 .datePickerClass{width: 31%; display: inline-flex; padding: 1px;}
 .datePickerInput{width:100%;border-color: transparent;}
 .timelineRow{padding:2px;}
 .timelineAddedRow{margin-left: 7px;}
 .badgePic{width:375px;}

/* Mark valid inputs during .invalid state */
.invalid input:required:valid {
    background: #17D654 !important;
}

.alert-notifications-fixed {
    bottom: 24rem;
}
/*  20191106*/


.title-level1{
color:#042f3f !important;
font-family: 'Montserrat-SemiBold';
font-size:16 !important;
}
 body{
 font-family:Montserrat-Regular;
 }
 .fa-remove{
 color:#d42f2f;
 }
 .form-control:disabled, .form-control[readonly]
 {
 background-color:#ffffff;
 }
 /* The container */
.check-container {
  display: block;
  position: relative;
  padding-left: 35px;
  margin-bottom: 12px;
  cursor: pointer;
  font-size: 16px;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

.check-Speaker {
  display: block;
  position: relative;
  cursor: pointer;
  font-size: 16px;
  margin-top: 10px;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* Hide the browser's default checkbox */
.check-container input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
  height: 0;
  width: 0;
}

/* Create a custom checkbox */
.checkmark {
  position: absolute;
  top: 0;
  left: 0;
  height: 20px;
  width: 20px;
  background-color: #eee;
}

/* On mouse-over, add a grey background color */
.check-container:hover input ~ .checkmark {
  background-color: #ccc;
}

/* When the checkbox is checked, add a blue background */
.check-container input:checked ~ .checkmark {
  background-color: #2196F3;
}

/* Create the checkmark/indicator (hidden when not checked) */
.checkmark:after {
  content: "";
  position: absolute;
  display: none;
}

/* Show the checkmark when checked */
.check-container input:checked ~ .checkmark:after {
  display: block;
}

/* Style the checkmark/indicator */
.check-container .checkmark:after {
  left: 6px;
  top: 3px;
  width: 5px;
  height: 10px;
  border: solid white;
  border-width: 0 3px 3px 0;
  -webkit-transform: rotate(45deg);
  -ms-transform: rotate(45deg);
  transform: rotate(45deg);
}
.btn-submit {   
    background: #ff9900;
    color: #fff;
    padding: 11px 29px;
    display: table;
    margin: 0;
    font-family: Montserrat-Medium;
    font-size: 14px !important;
    
}
.btn-submit:hover{
color:#eee;
}

#ShowOnLand{width: 15px; height: 25px; opacity: inherit;}
#isNotifEnabled{width: 15px; opacity: inherit;}
.btn-save, .btn-save:hover {color: white; background: #00AA60!important;border: 0px;}
.btn-cancel, .btn-cancel:hover {color: #FFF; background-color: #6c757d!important; border-color: #6c757d;border: 0px;}
.ui-button:hover {
    background: white;
    border: 0px;
}

.checkmark{
	background-color: #238f79 !important;
}
#ShowOnLand{
	display: none;
}
</style>

<form id="editEventForm">
<div class="container h-100">
   <div class="row align-items-center h-100">
     <div class="col-12 mx-auto">
		  <div class="form-group" id="updateDiv1">
				<label for="eventTitle">
					<liferay-ui:message key='event-title' />
				</label>
				<input type="text" class="form-control" id="eventTitle" required name="Title" placeholder="<liferay-ui:message key='event-title' />">
			</div>
			<div class="form-group" id="updateDiv2">
				<label for="eventTitleAr">
					<liferay-ui:message key='event-title-arabic' />
				</label>
				<input type="text" class="form-control" id="eventTitleAr" required name="Title" placeholder="<liferay-ui:message key='event-title-arabic' />">
			</div>
			<div class="form-group" id="updateDiv3">
				<label for="eventPitch">
					<liferay-ui:message key='event-pitch' />
				</label>
				<input type="text" class="form-control" id="eventPitch" required name="Title" placeholder="<liferay-ui:message key='event-pitch' />">
			</div>
			<div class="form-group" id="updateDiv4">
				<label for="eventPitchAr">
					<liferay-ui:message key='event-pitch-arabic' />
				</label>
				<input type="text" class="form-control" id="eventPitchAr" required name="Title" placeholder="<liferay-ui:message key='event-pitch-arabic' />">
			</div>
		  <div class="form-group">
		  <label for="eventType"><liferay-ui:message key='event-type' /></label>
		  	<input type="hidden" value="<%=cb.getExpandoBridge().getAttribute("Event Types") %>" name="EventTypes"/>
		    <select class="form-control" id="eventType">
		    	<option value="" selected disabled><liferay-ui:message key='event-type-message' /></option>
		    	<option value="Course">Course</option>
		    	<option value="Hackathon">Hackathon</option>
		    	<option value="Forum">Forum</option>
		    	<option value="Conference">Conference</option>
		    	<option value="Seminar">Seminar</option>
		    </select>
		  </div>   
		  <div class="form-group">
		    <aui:select name="event-form" cssClass="form-id form-control" id="eventForm">
			   <aui:option disabled="true" selected="true" value=""><liferay-ui:message key='event-form-message' /></aui:option>
			   <% 
			   for (DDMFormInstance ddmFormInstance : formNameList) {
				   if(ddmFormInstance.getUserId() == themeDisplay.getUserId()){
				   		String name = ddmFormInstance.getName(Locale.US);
				   		String id = String.valueOf(ddmFormInstance.getFormInstanceId());
				   		boolean select=false;
						if(Validator.isNotNull(cb.getExpandoBridge().getAttribute("FormId")))
				   			select=id.equals(cb.getExpandoBridge().getAttribute("FormId"));
			   %>
			   <c:if test="<%=select %>">
			   	<aui:option value="<%= id %>"  selected="true"><%= name %></aui:option>
			   </c:if>
			   <c:if test="<%=!select %>">
			   	<aui:option value="<%= id %>" ><%= name %></aui:option>
			   </c:if>
			   <% } %>
			   <% } %>
			</aui:select>
		  </div>
		  <div class="form-group">
		  <label for="eventImageId"><liferay-ui:message key='event-image' /></label>
	   	  <div class="custom-file">
    		<input type="file" class="custom-file-input" name="pic" id="eventImageId" accept="image/*" onchange="previewEventFile('eventImageId','eventImg','eventImgBase64')" value="Upload Event image">
    		<label class="custom-file-label" for="customFile">Choose Image</label>
  			</div>
  			<div class="pt-3">	   		
		  	<img id="eventImg" src="<%=cb.getExpandoBridge().getAttribute("uploadimageid") %>" class="img-rounded" alt="Event Image" />
		  	<input type="hidden" id="eventImgBase64" value=""/>
			</div>
		  </div>
		  <div class="form-group" id="updateDiv2">
			<lable>Event Start</lable>
<%-- 		  	<input type="text" class="form-control" id="eventStart" value="Starts On <%= startDate1 %>" disabled="disabled"> --%>
	            <div class="controls input-append form-control date form_datetime"  data-date-format="dd MM yyyy - HH:ii p" data-link-field="eventStart">
	            	<input size="16" type="text" value="<%=startDate2 %>" class="datePickerInput" readonly placeholder="From Time" id="fromdateevnt">
	                <span class="add-on"><i class="icon-remove"></i></span>
					<span class="add-on"><i class="icon-th"></i></span>
	            </div>
				<input type="hidden" id="eventStart" value="<%= startDate1 %>" required name="From Time"/>
					
		  </div>
		  <div class="form-group" id="updateDiv3">
			 <lable>Event End</lable>
<%-- 		  	<input type="text" class="form-control" id="eventEnd" value="Ends On <%= endDate1 %>" disabled="disabled"> --%>
	            <div class="controls input-append form-control date form_datetime"  data-date-format="dd MM yyyy - HH:ii p" data-link-field="eventEnd">
	            	<input size="16" type="text" value="<%= endDate2 %>" class="datePickerInput" readonly placeholder="To Time" id="todateevnt">
	                <span class="add-on"><i class="icon-remove"></i></span>
					<span class="add-on"><i class="icon-th"></i></span>
	            </div>
				<input type="hidden" id="eventEnd" value="<%= endDate1 %>" required name="To Time"/>
		  </div>
		  <div class="form-group" id="updateDiv2">
			<lable>Event Deadline</lable>
	            <div class="controls input-append form-control date form_datetime"  data-date-format="dd MM yyyy - HH:ii p" data-link-field="eventDeadline">
	            	<input size="16" type="text" value="<%=deadline2 %>" class="datePickerInput" readonly placeholder="Deadline Time" id="deadlinedateevnt">
	                <span class="add-on"><i class="icon-remove"></i></span>
					<span class="add-on"><i class="icon-th"></i></span>
	            </div>
				<input type="hidden" id="eventDeadline" value="<%= deadline1 %>" required name="Deadline Time"/>
		  </div>
		  
 		  <p class="title-level1 pt-2">Event Description</p>
		  <div class="form-group">
	      	<textarea class="form-control" rows="8" id="eventDescription"></textarea>
		  </div> 
		  <p class="title-level1 pt-2">Event Description Arabic</p>
		  <div class="form-group">
	      	<textarea class="form-control" rows="8" id="eventDescriptionAr"></textarea>
		  </div> 
		  
		  <p class="title-level1 pt-2">EVENT ATTRIBUTES <span class="float-right" > <a class="btn btn-outline-secondary btn-sm" id="addAttribute"> <i class="fa fa-plus " aria-hidden="true" ></i> Add</a></span></p>
		  <div id="dialog1"  class="form-group" title="Attributes" style="display:none">
			<div>
		   		<input type="text" class="form-control" id="attributeNb" name="Attribute Number" placeholder="Attribute Number" required onkeypress="validate(event)">
				</div>
		   		<div class="pt-2">
		   		<input type="text" class="form-control" id="attributeName" name="Attribute Name" placeholder="Attribute Name" required>
			</div>
		  </div>  
		  <div id="eventAttributesDiv"></div>

		  <p class="title-level1 pt-2">EVENT HIGHLIGHTS <span class="float-right"> <a class="btn btn-outline-secondary btn-sm" id="addItem"><i class="fa fa-plus" aria-hidden="true"></i> Add</a></span></p>
  		  <div id="dialog2"  class="form-group" title="Items" style="display:none">
			<div>
		   		<input type="text" class="form-control" id="itemTitle" placeholder="Title" name="Title" required>
		   		<input type="text" class="form-control" id="itemTitleAr" placeholder="TitleAr" name="TitleAr">
				</div>
		   		<div class="pt-2">
		   		<input type="text" class="form-control" id="itemDescription" placeholder="Description" name="Description" required>
		   		<input type="text" class="form-control" id="itemDescriptionAr" placeholder="DescriptionAr" name="DescriptionAr">
		   		<input type="text" id="imgItemBase64" style="display: none;" name="Image" required>
		   		</div>
		   		<div class="pt-2">
		   		<div class="custom-file">
    			<input type="file" class="custom-file-input" name="pic" id="itemImageId" accept="image/*" onchange="previewFile('itemImageId','previewItemImgId','imgItemBase64')" value="Upload item image" >
    			<label class="custom-file-label" for="customFile">Choose Image</label>
  				</div>
		   		
                </div>
                <div class="pt-2">
                <div id="previewItemImgId" class="imgwrap"></div>
                </div>
		  </div>   
		  <div id="eventItemsDiv"></div>

		  <p class="title-level1 pt-2">SPEAKERS <span class="float-right"> <a class="btn btn-outline-secondary btn-sm" id="addSpeaker"> <i class="fa fa-plus" aria-hidden="true"></i> Add</a></span> </p>
  		  <div id="dialog3"  class="form-group" title="Speakers" style="display:none">
				<input type="text" id="imgSpeakerBase64"  style="display: none;" name="Image" required>
			    <div class="pt-2">
			    <div class="custom-file">
	    			<input type="file" class="custom-file-input" name="pic" id="speakerImageId" accept="image/*" onchange="previewFile('speakerImageId','previewSpeakerImgId','imgSpeakerBase64')" value="Upload Speaker image">
	    			<label class="custom-file-label" for="customFile">Choose file</label>
  				</div>
  				<label class="check-Speaker">Send Invitations 
		  			<input type="checkbox" id="isNotifEnabled">
<!-- 		 			 <span class="checkmark"></span> -->
				</label>
				<input type="text" class="form-control" id="speakerOrder" placeholder="Order" name="Order" onkeypress="validate(event)">
  				</div>
  				<div class="pt-2">
			    <select class="form-control" id="speakerUser" required name="Speaker">
			    	<option value="">Choose a speaker</option>
			    <%
			    	String sqlStatement = "select userId,firstName, lastName,emailaddress,jobtitle,"
			    	+"(select image from profileImage pi where pi.userid = u.userid ) image from User_ u";
   					Connection con = DataAccess.getConnection();;
   					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(sqlStatement);
					int i = 0;
					while (rs.next()) 
					{	
						if(i == 0 ){
			    %>
				    	<%}
						i++;%>
			    	<option value="<%=rs.getString("userId")%>" name="<%=rs.getString("image")%>" email="<%=rs.getString("emailaddress")%>" position="<%=rs.getString("jobtitle")%>">
			    		<%=rs.getString("firstName") + " "+ rs.getString("lastName")%>
		    		</option>
			    <%  } 
			    
			    con.close();
				st.close();
				%>
			     </select>
			    </div>
  				<div class="pt-2">
                <div id="previewSpeakerImgId" class="imgwrap"></div>
                </div>
		  </div>  
		  <div id="eventSpeakerDiv"></div>
		  
		  <p class="title-level1 pt-2">FAQ <span class="float-right"> <a class="btn btn-outline-secondary btn-sm" id="addFaq"> <i class="fa fa-plus" aria-hidden="true"></i> Add</a></span> </p>
  		  <div id="dialog4"  class="form-group" title="FAQ" style="display:none">
				<div>
		   		<input type="text" class="form-control" id="faqQuestion" placeholder="Question" name = "Question" required>
		   		<input type="text" class="form-control" id="faqQuestionAr" placeholder="QuestionAr" name = "QuestionAr" required>
				</div>
		   		<div class="pt-2">
				<textarea class="form-control" rows="5" id="faqResponse" placeholder="Answer" name= "Answer" required></textarea>
				<textarea class="form-control" rows="5" id="faqResponseAr" placeholder="AnswerAr" name= "AnswerAr" required></textarea>
			</div>
		  </div>  
		  <div id="eventFaqDiv"></div>
		  
		  <p class="title-level1 pt-2">EVENT TIMELINE <span class="float-right"> <a class="btn btn-outline-secondary btn-sm" id="addTimeline"> <i class="fa fa-plus" aria-hidden="true"></i> Add</a></span></p>
  		  <div id="dialog5"  class="form-group" title="Timeline" style="display:none">
  		  	<select class="form-control" id="timelineType" required name="Type">
		    	<option value="" selected disabled>Timeline Type</option>
		    	<option value="Day 1">Day 1</option>
		    	<option value="Day 2">Day 2</option>
		    	<option value="Day 3">Day 3</option>
		    	<option value="Day 4">Day 4</option>
		    	<option value="Day 5">Day 5</option>
		    	<option value="Day 6">Day 6</option>
		    </select>
		   	
            <div id="timelineDivs" class="pt-2">
	            <div id="timeline1" class="timelineRow"><i class="fa fa-plus iclass" aria-hidden="true" id="addTimelineRow"></i>
		            <div class="controls input-append form-control date form_datetime datePickerClass"  data-date-format="dd MM yyyy - HH:ii p" data-link-field="fromTime1">
		            	<input size="16" type="text" value="" class="datePickerInput" readonly placeholder="From Time" id="fromdate1">
		                <span class="add-on"><i class="icon-remove"></i></span>
						<span class="add-on"><i class="icon-th"></i></span>
		            </div>
					<input type="hidden" id="fromTime1" value="" required name="From Time"/>
					
		            <div class="controls input-append form-control date form_datetime datePickerClass"  data-date-format="dd MM yyyy - HH:ii p" data-link-field="toTime1">
		            	<input size="16" type="text" value="" class="datePickerInput" readonly placeholder="To Time" id="todate1">
		                <span class="add-on"><i class="icon-remove"></i></span>
						<span class="add-on"><i class="icon-th"></i></span>
		            </div>
					<input type="hidden" id="toTime1" value="" required name="To Time"/>
					<input type="text" class="datePickerClass form-control" id="timelineDescription1" placeholder="Description" name = "Description" required>
					<input type="text" class="datePickerClass form-control" id="timelineDescriptionAr1" placeholder="DescriptionAr" name = "DescriptionAr">
				</div>
			</div>
				
		  </div>  
		  <div id="eventTimelineDiv"></div>
		  
		  <p class="title-level1 pt-2">EVENT BADGE<span class="float-right"> <a class="btn btn-outline-secondary btn-sm" id="addBadge"> <i class="fa fa-plus" aria-hidden="true"></i> Add</a></span> </p>
  		  <div id="dialog6"  class="form-group" title="Badge" style="display:none">
				<input type="text" id="imgBadgeBase64"  style="display: none;" name="Image" required>
			    <div class="pt-2">
				    <div class="custom-file">
		    			<input type="file" class="custom-file-input" name="pic" id="badgeImageId" accept="image/*" onchange="previewFile('badgeImageId','previewBadgeImgId','imgBadgeBase64')" value="Upload Badge image">
		    			<label class="custom-file-label" for="customFile">Choose file</label>
	  				</div>
  				</div>
  				<div class="pt-2">
                	<div id="previewBadgeImgId" class="imgwrap"></div>
                </div>
		  </div>  
		  <div id="eventBadgeDiv"></div>
		  
		  <p class="title-level1 pt-2">EDITORS <span class="float-right"> <a class="btn btn-outline-secondary btn-sm" id="addEditor"> <i class="fa fa-plus" aria-hidden="true"></i> Add</a></span> </p>
  		  <div id="dialog7"  class="form-group" title="Editors" style="display:none">
				<input type="text" id="imgEditorBase64"  style="display: none;" name="Image" >
			    <div class="pt-2"  style="display:none;">
			    <div class="custom-file">
	    			<input type="file" class="custom-file-input" name="pic" id="editorImageId" accept="image/*" onchange="previewFile('editorImageId','previewEditorImgId','imgEditorBase64')" value="Upload Editor image">
	    			<label class="custom-file-label" for="customFile">Choose file</label>
  				</div>
<!--   				<label class="check-Speaker">Send Invitations  -->
<!-- 		  			<input type="checkbox" id="isNotifEditorEnabled"> -->
<!-- 				</label> -->
  				</div>
  				<div class="pt-2">
			    <select class="form-control" id="editorUser" required name="Editor">
			    <%
			    	sqlStatement = "select userId,firstName, lastName,emailaddress,jobtitle,"
			    	+"(select image from profileImage pi where pi.userid = u.userid ) image from User_ u";
					con = DataAccess.getConnection();;
					st = con.createStatement();
					rs = st.executeQuery(sqlStatement);
					i = 0;
					while (rs.next()) 
					{	
						if(i == 0 ){
			    %>
				    	<%}
						i++;%>
			    	<option value="<%=rs.getString("userId")%>" name="<%=rs.getString("image")%>" email="<%=rs.getString("emailaddress")%>" position="<%=rs.getString("jobtitle")%>">
			    		<%=rs.getString("firstName") + " "+ rs.getString("lastName")%>
		    		</option>
			    <%  } 
			    
			    con.close();
				st.close();
				%>
			     </select>
			    </div>
  				<div class="pt-2">
                <div id="previewEditorImgId" class="imgwrap"></div>
                </div>
		  </div>  
		  <div id="eventEditorDiv"></div>
		  
		  <p class="title-level1 pt-2">REVIEWERS <span class="float-right"> <a class="btn btn-outline-secondary btn-sm" id="addReviewer"> <i class="fa fa-plus" aria-hidden="true"></i> Add</a></span> </p>
  		  <div id="dialog8"  class="form-group" title="Reviewers" style="display:none">
				<input type="text" id="imgReviewerBase64"  style="display: none;" name="Image" >
			    <div class="pt-2"  style="display:none;">
			    <div class="custom-file">
	    			<input type="file" class="custom-file-input" name="pic" id="reviewerImageId" accept="image/*" onchange="previewFile('reviewerImageId','previewReviewerImgId','imgReviewerBase64')" value="Upload Reviewer image">
	    			<label class="custom-file-label" for="customFile">Choose file</label>
  				</div>
  				</div>
  				<div class="pt-2">
			    <select class="form-control" id="reviewerUser" required name="Reviewer">
			    <%
			    	sqlStatement = "select userId,firstName, lastName,emailaddress,jobtitle,"
			    	+"(select image from profileImage pi where pi.userid = u.userid ) image from User_ u";
					con = DataAccess.getConnection();;
					st = con.createStatement();
					rs = st.executeQuery(sqlStatement);
					i = 0;
					while (rs.next()) 
					{	
						if(i == 0 ){
			    %>
				    	<%}
						i++;%>
			    	<option value="<%=rs.getString("userId")%>" name="<%=rs.getString("image")%>" email="<%=rs.getString("emailaddress")%>" position="<%=rs.getString("jobtitle")%>">
			    		<%=rs.getString("firstName") + " "+ rs.getString("lastName")%>
		    		</option>
			    <%  } 
			    
			    con.close();
				st.close();
				%>
			     </select>
			    </div>
  				<div class="pt-2">
                <div id="previewReviewerImgId" class="imgwrap"></div>
                </div>
		  </div>  
		  <div id="eventReviewerDiv"></div>
		  
		  <p class="title-level1 pt-2">LOCATION</p>
		  <div class="form-group">
			<div>
		  	<input type="text" class="form-control" id="eventLocation" placeholder="Location" value="<%= cb.getLocation() %>">
			</div>
		<div class="pt-2">
		  	<input type="text" class="form-control" id="eventLocationAr" placeholder="Location Arabic" value="<%= cb.getExpandoBridge().getAttribute("locationAr") %>">
			</div>
		  <div class="pt-2">
		  	<input type="text" class="form-control" id="eventLocationLink" placeholder="Location Link" value="<%= cb.getExpandoBridge().getAttribute("Location link")%>">
			</div>
			<div class="pt-2">
			<label class="check-container">Show on landing page
  			<input type="checkbox" id="ShowOnLand">
 			 <span class="checkmark"></span>
			</label>
			</div>
		  </div>
<!-- 		  <div class="form-group"></div> -->
  		  <div id="update-btn">
  		  <button type="button" class="btn btn-submit" onclick="Submit();">Update</button>
  		  </div>
<!--   		  <button type="button" class="btn btn-default">Save as Draft</button> -->
		  <div id="alertContainer" style="display:none;" class="alert-notifications alert-notifications-fixed">
		  	<div class="alert alert-success fade alert-dismissible show" role="alert">
		  		<button class="btn close btn-unstyled" aria-label="Close" type="button">
		  			<svg class="lexicon-icon lexicon-icon-times" focusable="false" role="presentation" viewBox="0 0 512 512">
						<path class="lexicon-icon-outline" d="M295.781 256l205.205-205.205c10.998-10.998 10.998-28.814 0-39.781-10.998-10.998-28.815-10.998-39.781 0l-205.205 205.205-205.205-205.238c-10.966-10.998-28.814-10.998-39.781 0-10.998 10.998-10.998 28.814 0 39.781l205.205 205.238-205.205 205.205c-10.998 10.998-10.998 28.815 0 39.781 5.467 5.531 12.671 8.265 19.874 8.265s14.407-2.734 19.907-8.233l205.205-205.238 205.205 205.205c5.5 5.5 12.703 8.233 19.906 8.233s14.407-2.734 19.906-8.233c10.998-10.998 10.998-28.815 0-39.781l-205.238-205.205z"></path>
					</svg>
				</button>
				<span class="alert-indicator">
					<svg class="lexicon-icon lexicon-icon-check-circle-full" focusable="false" role="presentation" viewBox="0 0 512 512">
						<path class="lexicon-icon-outline" d="M484.1,139.7c-54.4,62.6-167,190-203.8,233c-5.9,6.8-14.6,11.2-24.3,11.2c-8.8,0-16.8-3.6-22.6-9.4c-45.3-45.3-50.7-50.7-96-96c-5.8-5.8-9.4-13.8-9.4-22.6c0-17.7,14.3-32,32-32c8.8,0,16.8,3.6,22.6,9.4c35.6,35.6,46.6,46.6,71.6,71.6c47-54.8,150.9-171.7,192.5-219.7C399.8,32.9,331.8,0,256,0C114.6,0,0,114.6,0,256s114.6,256,256,256s256-114.6,256-256C512,214.1,501.9,174.6,484.1,139.7z"></path>
					</svg>
				</span>
				<strong class="lead">Success:</strong>Your request completed successfully.
			</div>
		   </div>
  		</div>
	</div>
  </div>
</form>

<script>
function showHideALertReq(msgText,section){
	debugger;
	$(section).append("<div id='alertContainerRequired_"+section.replace('#', '')+"' style='display:none; line-height: 0.7; text-align: center; position: absolute; bottom: 0px; font-size: small;' class='alert-notifications alertContainerClass'>"+
  	        "<div class='alert alert-success fade alert-dismissible show' role='alert'>"+
		       "<span id='alertText' class='alertTextClass'>"+msgText+"</span></div></div>")
	//$(".alertTextClass").html(msgText);
	var alertId="#alertContainerRequired_"+section.replace('#', '');
	var $div   = $(alertId);
	if($div.is(":visible")){return;}
	$div.show();
	setTimeout(function(){
		$div.hide();
	},2000);
}
	$( document ).ready(function() {
		//console.log($('#EventTypes').val());
		if($(".control-menu-icon.lfr-portal-tooltip.product-menu-toggle.sidenav-toggler.active.open").length > 0){
			$(".control-menu-icon.lfr-portal-tooltip.product-menu-toggle.sidenav-toggler.active.open").click();
		}
		$("#ControlMenu.control-menu.control-menu-level-1.hidden-print").hide();
// 		$("#alertContainer").hide();
		$("footer").hide();
		$("div.container-menu").hide();
	    $('.form_datetime').datetimepicker({
	        //language:  'fr',
	        weekStart: 1,
	        todayBtn:  1,
			autoclose: 1,
			todayHighlight: 1,
			startView: 2,
			forceParse: 0,
	        showMeridian: 1
	    });
	    
		$(function(){$('#speakerUser').searchableSelect();});
		$(function(){$('#editorUser').searchableSelect();});
		$(function(){$('#reviewerUser').searchableSelect();});
	
		<%
			if(cb.getExpandoBridge().getAttribute("Event Types") != null && !"".equals(cb.getExpandoBridge().getAttribute("Event Types"))){
				Object[] evntType = (Object[]) cb.getExpandoBridge().getAttribute("Event Types");
				System.out.println("evntType.length ==== " + evntType.length);
// 				if(evntType != null && evntType.length>0) 
// 				{
					// System.out.println("evntType.length 1");
					//String eventTypes = evntType[0].toString(); 
					//System.out.println("evntType.length3: "+eventTypes);
 					%>  
<%-- 					 $("#eventType").val("<%=eventTypes%>"); --%>
		<%		} 
// 			}
 		%> 
		
<%-- 	  	<% --%>
	  		//if(cb.getExpandoBridge().getAttribute("FormId") != null && !"".equals(cb.getExpandoBridge().getAttribute("FormId"))){
			//	Object[] evntForm = (Object[]) cb.getExpandoBridge().getAttribute("FormId");
			//	System.out.println("evntForm.length ==== " + evntForm.length);
			//	if(evntForm.length>0) 
// 				{
					// Object obj = evntForm[0]; 
					// String eventForms = obj.toString(); %> 
					// $("#eventForm").val("<=eventForms>");
<%-- 					$("#eventForm").val("<%=123%>"); --%>
<%-- 		<%		} --%>
			//}
<%-- 		%> --%>
	
	});
</script>