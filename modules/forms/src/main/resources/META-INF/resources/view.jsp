<%@ include file="/init.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>

<link href="/o/new-misk-theme/css/font/font-awesome/font-awesome.min.css" rel="stylesheet" />
<link href="/o/new-misk-theme/images/loader.gif" rel="stylesheet" />

<link href="/o/new-misk-theme/css/landing/CustomStyle.css" rel="stylesheet" />
<script src="/o/new-misk-theme/js/landing/custom.js"></script>

<script src="/o/new-misk-theme/js/from/jquery.dataTables.min.js"></script>
<script src="/o/new-misk-theme/js/from/dataTables.bootstrap4.min.js"></script>

<liferay-portlet:resourceURL var="resourceUrl" />
<%
String eventTit = "";
Object testObj = renderRequest.getAttribute("originalList");
JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
jsonArr =(JSONArray) testObj;
JSONObject json = JSONFactoryUtil.createJSONObject();
json = jsonArr.getJSONObject(0);
System.out.println(jsonArr);
//Code changes for the reviewer Comments start
boolean isReviewerEventRole=request.isUserInRole("reviewerEvent");
//Code changes for the reviewer Comments end
System.out.println("jsonArr: " + jsonArr);
//if(json.get("EventTitle")!= null && json.get("EventTitle").toString()!=null )
//eventTit = json.get("EventTitle").toString() ;
%>
<script>

var datatable;
$(document).ready(function() {
	maxLength(document.getElementById("dataReviewerComments"));
	$("#success-alert").hide();	
	$("#fail-alert").hide();
	 datatable = $('#tblparticipants').DataTable({
    data:  <%=jsonArr%> ,
    "oLanguage": { "sSearch": "" , "sLengthMenu":"_MENU_"},
    "bInfo" : false,
    "columns": [
    	{ data: "EventId" ,"visible": false},
    	 { data: "EventTitle" ,"visible": false},
    	 { data: "SubmitUserName" },
    	 { data: "Status" },
    	 { data: "formId","visible": false },
          { data: "SubmitUserId" ,"visible": false},
         { data: "ddmFormInstanceId" ,"visible": false},
         { data: "uuid" ,"visible": false},
         { data: "groupId" ,"visible": false},
         //Code changes for the reviewer Comments start
         { data: "reviewerComments" , "visible":<%=!isReviewerEventRole%> },
         { data: "reviewerId","visible": false},
         { data: "gender" },
         { data: "currentWorkPosition" },
         { data: "age" },
         //Code changes for the reviewer Comments end          
		  
          {
              title: "Manage",
              "mRender": function (data, type, row) {
            	 var formId = row.formId;
            	 var userId = row.SubmitUserId;
            	 var uuid   = row.uuid;
            	 var groupId = row.groupId;
            	 var ddmFormInstanceId = row.ddmFormInstanceId;
            	 var porfileLink = row.SubmitUserId
            	 var eventId = row.EventId;
            	 var display ="";
            	 var status=row.Status;
            	 if(status == "Approved" || status == "Rejected" || status == "rejected by reviewer" || status == "approved by reviewer" )
           		{
           			display = "none";
           		}
            	 
            	 var reviewerId = row.reviewerId;     
                  return '<a style = "padding:4%;" onclick="displaySubmittedData('+formId+","+userId+",'"+uuid+"',"+groupId+","+ddmFormInstanceId+","+eventId+","+reviewerId+",'"+status+"'"+');return false;" data-toggle="tooltip" title="show submission and approve" class=""><i class="fa fa-eye"></i></a>'+
                         '<a style = "padding:4%;" onclick="openProfile(' + porfileLink + ');return false;" data-toggle="tooltip" title="show Profile"><i class="fa fa-user"></i></a> '+
                         '<a style = "padding:4%;display:'+display+'" onclick="approveRecordFromGrid(' + eventId +","+userId+","+ddmFormInstanceId+","+reviewerId +');return false;" data-toggle="tooltip" title="Approve"><i class="fa fa-check"></i></a> '+
                         '<a style = "padding:4%;display:'+display+'" onclick="rejectRecordFromGrid(' + eventId +","+userId+","+ddmFormInstanceId+","+reviewerId +');return false;" data-toggle="tooltip" title="Reject"><i class="fa fa-times"></i></a> ';
              }
          }
    ],
   
		
}); 

$("#tblparticipants_filter input").attr("placeholder", " Search ");
$(function () {
    $('[data-toggle="tooltip"]').tooltip()
});

//onclick="showProfile()
 
}); 


function showProfile()
{
	alert("show profile");
}

</script>
<style>
.btn-sendToReview {
    background: #ff8400;
    color: #fff;
    text-transform: uppercase;
    font-family: montserrat-light;
    padding: 1% 2%;
    font-size: 0.9rem;
}
.btn-approve {
    background: #7db72c;
    color: #fff;
    text-transform: uppercase;
    font-family: montserrat-light;
    padding: 1% 2%;
    font-size: 0.9rem;
}
.fade-navy {
    transition: opacity 0.15s linear;
    background: rgba(30, 68, 83, 0.82);
}
.btn-approve:hover{
    font-family: montserrat;
    color: #fff;
}
 .btn-reject:hover{
    font-family: montserrat;
    color: red;
}
 .btn-sendToReview:hover{
    font-family: montserrat;
    color: #fff;
}
.btn-reject {
    background: #fff;
    border: 1px solid #000;
    color: #b32323;
    text-transform: uppercase;
    font-family: montserrat;
    font-weight: 600;
    padding: 1% 2%;
    font-size: 0.9rem;
}
.btn-group{
    float: right;
    right: -425px
}
table {
    border-spacing: 0px 8px;
}
</style>
<body>
<div class="container-fluid manage-calendar">
	 <div id="participant-section">
		<div id="intro-title" class="container">
		    <h3><span style="border-bottom:2px solid #eee;padding-bottom:15px;">Eve</span>nts</h3>
		            <h1><%=eventTit %></h1>
		    </div>
		</div>
		<div class="table-responsive pt-5">
		<div class="loader"  id="Loader"></div>
		  <div class="container">
			<table class="table table-striped" id="tblparticipants">
				<thead>
					<tr>  
						<th>#</th>
						<th  style='width: 20%;' >Event Title</th>
						<th  style='width: 15%;' >Attendee</th>
						<th  style='width: 7%;' >Status</th>
						<th>formId</th>
						<th>SubmitUserId</th>
						<th>ddmFormInstanceId</th>
						<th>uuid</th>
						<th>GroupId</th>
						<th style='width: 20%;' >Reviewer Comments</th>
						<th style='width: 13%;' >Reviewer Id</th>
						<th style='width: 4%;' >Gender</th>
                        <th style='width: 20%;' >Current Work Position</th>
                        <th style='width: 4%;'>Age</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
		
				</tbody>
			</table>
		</div>
     </div>
<div class="alert alert-success" id="success-alert">
  <button type="button" class="close" data-dismiss="alert">x</button>
  <strong>Success! </strong> user Registerd successfully, Notification sent.
</div>
<div class="alert alert-success" id="review-success-alert" style="display: none;">
  <button type="button" class="close" data-dismiss="alert">x</button>
  Submission has been assigned to the reviewer role for the workflow process
</div>
<div class="alert alert-success" style="display: none;" id="reviewer-approvereject-success-alert">
  <button type="button" class="close" data-dismiss="alert">x</button>
  Your submission for the review of the event submission has been updated successfully
</div>

<div class="alert alert-dark" id="fail-alert">
  <button type="button" class="close" data-dismiss="alert">x</button>
  <strong>! </strong> User will not Registered.
</div>

<div class="modal fade fade-navy" id="myModal" role="dialog">
    <div class="modal-dialog  modal-lg" >
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal"><svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="Layer_1" x="0px" y="0px" viewBox="0 0 492 492" style="enable-background:new 0 0 492 492;" xml:space="preserve" width="28px" height="24px" class=""><g><g>
	<g>
		<path d="M464.344,207.418l0.768,0.168H135.888l103.496-103.724c5.068-5.064,7.848-11.924,7.848-19.124    c0-7.2-2.78-14.012-7.848-19.088L223.28,49.538c-5.064-5.064-11.812-7.864-19.008-7.864c-7.2,0-13.952,2.78-19.016,7.844    L7.844,226.914C2.76,231.998-0.02,238.77,0,245.974c-0.02,7.244,2.76,14.02,7.844,19.096l177.412,177.412    c5.064,5.06,11.812,7.844,19.016,7.844c7.196,0,13.944-2.788,19.008-7.844l16.104-16.112c5.068-5.056,7.848-11.808,7.848-19.008    c0-7.196-2.78-13.592-7.848-18.652L134.72,284.406h329.992c14.828,0,27.288-12.78,27.288-27.6v-22.788    C492,219.198,479.172,207.418,464.344,207.418z" data-original="#000000" class="active-path" data-old_color="#000000" fill="#B6C3C7"/>
	</g>
</g></g> </svg></button>
          <h4 class="modal-title">Event Registration</h4>
        </div>
        <div class="modal-body" style=" max-height: calc(100vh - 210px); overflow-y: auto;">
          <div class="tabledata-questioner">
	<table class="table-questioner">
		<tbody class="displayformdata">
				<th style='width: 100%; color:#042f3f; font-family: montserrat-light;'>Question & Answers</th>
		</tbody>
	</table>
		<textarea rows="3" maxlength="190" cols="90" id="dataReviewerComments" placeholder="Please enter the review comments here" name="reviewerComments"></textarea>
</div>
        </div>
        <div class="modal-footer">
          <input type="hidden" id="datacontentId" value="">
          <input type="hidden" id="datakaleoInstanceTokenId" value="">
          <input type="hidden" id="datauserId" value="">
          <input type="hidden" id="datarecordVersionId" value="">
		  <input type="hidden" id="eventId" value="">
		  
          <c:if test="<%=request.isUserInRole("Administrator") || request.isUserInRole("adminByDep1") || request.isUserInRole("adminDep2")%>" >
          </c:if>
          
	              <input type="submit" value="send to review" onclick="sendToReview()" id="review" name="review-button" class="btn btn-sendToReview">
		          <input type="submit" value="aprove" id="submit" onclick="callToAprove()" name="Approve submission" class="btn btn-approve">
		          <input type="submit" value="reject" id="reject" name="reject submission" onclick="callReject()" class="btn btn-reject">
          
          
	          <input type="submit" value="approve" id="submitReviewer" onclick="approveByReviewer()" name="Approve submission" class="btn btn-primary">
	          <input type="submit" value="reject" id="rejectReviewer" name="reject submission" onclick="rejectByReviewer()" class="btn btn-warning">
	      <c:if test="<%=request.isUserInRole("reviewerEvent") %>">
          </c:if> 
        </div>
      </div>
      
    </div>
  </div>
  
  
  
  
      <div class="modal fade" id="profilemodal" tabindex="-1" role="dialog" aria-labelledby="profilemodal" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                    <div class="modal-header text-white bg-info">
                    <b class="modal-title" id="addeducationLabel">
                        <label>Profile Info</label>
                    </b>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <iframe frameborder="0" height="540px" id = "srcId" src="" width="100%"></iframe>
                </div>

            </div>
        </div>
    </div>
  
  
	<%-- <div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>Event Name</th>
				<th>Start Time</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${calendarBookings}" var="calendarBooking">
				<tr>
					<th scope="row">${calendarBooking.calendarBookingId}</th>
					<td>${calendarBooking.title}</td>
					<td>${calendarBooking.startTime}</td>
					<td>${calendarBooking.endTime}</td>
					<td><button
							onclick="testPath(${formAttribute.get(calendarBooking.calendarBookingId)})"
							class="primary-button ">Show Event form data</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div> --%>
<br />
<hr>
<br />
<!-- <div class="table-responsive tabledata  hidden">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>email</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody class="displayformdata">
		</tbody>
	</table>
</div> -->
</div>
</body>
<% String hosturl = themeDisplay.getPortalURL();%>
<script type="text/javascript">
var x = document.getElementById('Loader');
function maxLength(el) {    
	return;
    if (!('maxLength' in el)) {
        var max = el.attributes.maxLength.value;
        el.onkeypress = function () {
            if (this.value.length >= max) return false;
        };
    }
}
function openProfile(locationLink) 
{
	debugger;
	var hostname = '<%=hosturl%>';
	var locationLink1 = hostname+"/web/guest/profile?userId="+locationLink;
  //  $(".modal-body #srcId").val( locationLink );
	// $('#myModal').modal('show') ;
	document.getElementById("srcId").src=locationLink1;
	window.open(locationLink1);
	//$('#profilemodal').modal('show') ;
}


function sendToReview(){
	var datacontentId = document.getElementById("datacontentId").value;
	var datauserId = document.getElementById("datauserId").value;
	var datarecordVersionId = document.getElementById("datarecordVersionId").value;
	var eventId = document.getElementById("eventId").value;
	AUI().use('aui-io-request', function(A){
        A.io.request('${resourceUrl}', {
        	method: 'post',
               data: {
            	   <portlet:namespace />recordID: datacontentId,
            	   <portlet:namespace />userId : datauserId,
            	   <portlet:namespace />recordVersionId : datarecordVersionId,
            	   <portlet:namespace />eventId : eventId,
            	   <portlet:namespace />action : "sendToReview",            	   
               },
               on: {
                   	success: function() {
						console.log(this.get('responseData'));
						datatable.clear();
						datatable.rows.add(JSON.parse(this.get('responseData')));
						datatable.draw();
						$('#myModal').modal("hide");
						$("#review-success-alert").fadeTo(2000, 500).slideUp(500, function() {
					    	$("#review-success-alert").slideUp(500);
						});
                   }
              }
        });
 
    });
}
var reviewerUserId ="";

function getEventReviewer(eventId)
{
	AUI().use('aui-io-request', function(A){
        A.io.request('${resourceUrl}', {
        	method: 'post',
               data: {
            	   <portlet:namespace />eventId : eventId,
            	   <portlet:namespace />action : "getEventReviewer"      	   
               },
               on: {
                   	success: function() {
                   		reviewerUserId = this.get('responseData');
                   }
              }
        });
 
    });
}

function approveByReviewer(userId,eventId)
{
	swal({
		title: "Are you sure?",
		text:  "",
		type:  "warning",
		showCancelButton: true,
		confirmButtonColor: '#7db72c',
		confirmButtonText: 'Yes, Approve!',
		closeOnConfirm: true,
		//closeOnCancel: false
	},
	function(){
				var datacontentId = document.getElementById("datacontentId").value;
				var datauserId = document.getElementById("datauserId").value;
				var datarecordVersionId = document.getElementById("datarecordVersionId").value;
				var dataReviewerComments = document.getElementById("dataReviewerComments").value;
				
				if (eventId==null)
				eventId = document.getElementById("eventId").value;
				
				if (userId==null)
					userId = document.getElementById("datauserId").value;
				
				//var reviewerUserId = '${themeDisplay.getUserId()}';
				// getEventReviewer(eventId);
				
				var groupId = '${themeDisplay.getSiteGroupId()}';
				AUI().use('aui-io-request', function(A){
			        A.io.request('${resourceUrl}', {
			        	method: 'post',
			               data: {
			            	   <portlet:namespace />submitterUserId  : datauserId,
			            	   <portlet:namespace />recordID         : datacontentId,
			            	   <portlet:namespace />userId           : userId,
			            	   <portlet:namespace />recordVersionId  : datarecordVersionId,
			            	   <portlet:namespace />reviewerComments : dataReviewerComments,
			            	   <portlet:namespace />eventId : eventId,
			            	   <portlet:namespace />groupId : groupId,
			            	   <portlet:namespace />action : "approvedbyreveiewer",            	   
			               },
			               on: {
			                   	success: function() {
									console.log(this.get('responseData'));
									setTimeout(function(){ x.style.display = "none"; }, 500);
									datatable.clear();
									datatable.rows.add(JSON.parse(this.get('responseData')));
									datatable.draw();
									$('#myModal').modal("hide");
									$("#review-success-alert").fadeTo(2000, 500).slideUp(500, function() {
									   	$("#review-success-alert").slideUp(500);
									});
			                   }
			              }
			        });
			 
			    });
	   });
}

function approveByReviewerGrid(userId,eventId)
{
	
	var datacontentId = document.getElementById("datacontentId").value;
	var datauserId = document.getElementById("datauserId").value;
	var datarecordVersionId = document.getElementById("datarecordVersionId").value;
	var dataReviewerComments = document.getElementById("dataReviewerComments").value;
	
	if (eventId==null)
	eventId = document.getElementById("eventId").value;
	
	if (userId==null)
		userId = document.getElementById("datauserId").value;
	
	//var reviewerUserId = '${themeDisplay.getUserId()}';
	// getEventReviewer(eventId);
	
	var groupId = '${themeDisplay.getSiteGroupId()}';
	AUI().use('aui-io-request', function(A){
        A.io.request('${resourceUrl}', {
        	method: 'post',
               data: {
            	   <portlet:namespace />submitterUserId  : datauserId,
            	   <portlet:namespace />recordID         : datacontentId,
            	   <portlet:namespace />userId           : userId,
            	   <portlet:namespace />recordVersionId  : datarecordVersionId,
            	   <portlet:namespace />reviewerComments : dataReviewerComments,
            	   <portlet:namespace />eventId : eventId,
            	   <portlet:namespace />groupId : groupId,
            	   <portlet:namespace />action : "approvedbyreveiewer",            	   
               },
               on: {
                   	success: function() {
						console.log(this.get('responseData'));
						setTimeout(function(){ x.style.display = "none"; }, 500);
						datatable.clear();
						datatable.rows.add(JSON.parse(this.get('responseData')));
						datatable.draw();
						$('#myModal').modal("hide");
						$("#review-success-alert").fadeTo(2000, 500).slideUp(500, function() {
						   	$("#review-success-alert").slideUp(500);
						});
                   }
              }
        });
 
    });
	   
}


function rejectByReviewer(userId,eventId){
	swal({
		title: "Are you sure?",
		text:  "",
		type:  "warning",
		showCancelButton: true,
		confirmButtonColor: '#DD6B55',
		confirmButtonText: 'Yes, Reject!',
		closeOnConfirm: true,
		//closeOnCancel: false
	},
	function(){
					var datacontentId = document.getElementById("datacontentId").value;
					var datauserId = document.getElementById("datauserId").value;
					var datarecordVersionId = document.getElementById("datarecordVersionId").value;
					var dataReviewerComments = document.getElementById("dataReviewerComments").value;
					
					if (eventId==null)
						eventId = document.getElementById("eventId").value;
						
					if (userId==null)
						userId = document.getElementById("datauserId").value;
						
				
					// var reviewerUserId = '${themeDisplay.getUserId()}';
					//getEventReviewer(eventId);
					var groupId = '${themeDisplay.getSiteGroupId()}';
					AUI().use('aui-io-request', function(A){
				        A.io.request('${resourceUrl}', {
				        	method: 'post',
				               data: {
				            	   <portlet:namespace />submitterUserId  : datauserId,
				            	   <portlet:namespace />recordID: datacontentId,
				               	   <portlet:namespace />userId           : userId,
				            	   <portlet:namespace />recordVersionId : datarecordVersionId,
				            	   <portlet:namespace />reviewerComments : dataReviewerComments,
				            	   <portlet:namespace />groupId : groupId,       
				            	   <portlet:namespace />eventId : eventId,   
				            	   <portlet:namespace />action : "rejectedbyreveiewer",            	   
				               },
				               on: {
				                   	success: function() {
										console.log(this.get('responseData'));
										setTimeout(function(){ x.style.display = "none"; }, 500);
										datatable.clear();
										datatable.rows.add(JSON.parse(this.get('responseData')));
										datatable.draw();
										$('#myModal').modal("hide");
										$("#review-success-alert").fadeTo(2000, 500).slideUp(500, function() {
										   	$("#review-success-alert").slideUp(500);
										});
				                   	}
				              }
				        });
				 
				    });
	 });
}

function rejectByReviewerGrid(userId,eventId){
	
		var datacontentId = document.getElementById("datacontentId").value;
		var datauserId = document.getElementById("datauserId").value;
		var datarecordVersionId = document.getElementById("datarecordVersionId").value;
		var dataReviewerComments = document.getElementById("dataReviewerComments").value;
		
		if (eventId==null)
			eventId = document.getElementById("eventId").value;
			
		if (userId==null)
			userId = document.getElementById("datauserId").value;
			
	
		// var reviewerUserId = '${themeDisplay.getUserId()}';
		//getEventReviewer(eventId);
		var groupId = '${themeDisplay.getSiteGroupId()}';
		AUI().use('aui-io-request', function(A){
	        A.io.request('${resourceUrl}', {
	        	method: 'post',
	               data: {
	            	   <portlet:namespace />submitterUserId  : datauserId,
	            	   <portlet:namespace />recordID: datacontentId,
	               	   <portlet:namespace />userId           : userId,
	            	   <portlet:namespace />recordVersionId : datarecordVersionId,
	            	   <portlet:namespace />reviewerComments : dataReviewerComments,
	            	   <portlet:namespace />groupId : groupId,       
	            	   <portlet:namespace />eventId : eventId,   
	            	   <portlet:namespace />action : "rejectedbyreveiewer",            	   
	               },
	               on: {
	                   	success: function() {
							console.log(this.get('responseData'));
							setTimeout(function(){ x.style.display = "none"; }, 500);
							datatable.clear();
							datatable.rows.add(JSON.parse(this.get('responseData')));
							datatable.draw();
							$('#myModal').modal("hide");
							$("#review-success-alert").fadeTo(2000, 500).slideUp(500, function() {
							   	$("#review-success-alert").slideUp(500);
							});
	                   	}
	              }
	        });
	 
	    });
}
function approveRecordFromGrid(eventId,userId,ddmFormInstanceId,reviewerId)
{
	swal({
		title: "Are you sure?",
		text:  "",
		type:  "warning",
		showCancelButton: true,
		confirmButtonColor: '#7db72c',
		confirmButtonText: 'Yes, Approve!',
		closeOnConfirm: true,
		//closeOnCancel: false
	},
	function(){
		debugger;
		    x.style.display = "block";
		    if(reviewerId != "-1")
		   	{
		    	approveByReviewerGrid(userId,eventId);
		   	}
		    else
		    {
			   ApproveRejectFromGrid(eventId,userId,"ApproveRejectRecordFromGrid","Approved");
		    }
	});
}

function rejectRecordFromGrid(eventId,userId,ddmFormInstanceId,reviewerId)
{
	swal({
		title: "Are you sure?",
		text:  "",
		type:  "warning",
		showCancelButton: true,
		confirmButtonColor: '#DD6B55',
		confirmButtonText: 'Yes, Reject!',
		closeOnConfirm: true,
		//closeOnCancel: false
	},
	function(){
			 x.style.display = "block";
			 if(reviewerId != "-1")
		   	 {
				 rejectByReviewerGrid(userId,eventId);
		   	 }
		     else
		     {
		    	ApproveRejectFromGrid(eventId,userId,"ApproveRejectRecordFromGrid","Rejected")
		     }
	});
}

function ApproveRejectFromGrid(eventId,userId,command,status)
{      
	debugger;
    AUI().use('aui-io-request', function(A){
        A.io.request('${resourceUrl}', {
        	method: 'post',
               data: {
            	   <portlet:namespace />eventId         : eventId,
            	   <portlet:namespace />command    : command,
            	   <portlet:namespace />userId     : userId,
            	   <portlet:namespace />status     : status
               },
               on: {
                   	success: function() 
                   	{
                   		setTimeout(function(){ x.style.display = "none"; }, 500);
						var data = JSON.parse(this.get('responseData'));
						datatable.clear();
						datatable.rows.add(JSON.parse(this.get('responseData')));
						datatable.draw(); 
              		}
        		}
 
    	});
	});
}



function callToAprove()
{
	  swal({
			title: "Are you sure?",
			text:  "",
			type:  "warning",
			showCancelButton: true,
			confirmButtonColor: '#7db72c',
			confirmButtonText: 'Yes, Approve!',
			closeOnConfirm: true,
			//closeOnCancel: false
		},
		function(){
			var datacontentId = document.getElementById("datacontentId").value;
			var datakaleoInstanceTokenId = document.getElementById("datakaleoInstanceTokenId").value;
			var datauserId = document.getElementById("datauserId").value;
			var datarecordVersionId = document.getElementById("datarecordVersionId").value;
			var datarecordVersionId = document.getElementById("datarecordVersionId").value;
			var eventId = document.getElementById("eventId").value;
			//return;
			rejectApproveRecord(datacontentId,datakaleoInstanceTokenId,datauserId,datarecordVersionId,"Approved",eventId);
			 $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
			      $("#success-alert").slideUp(500);
			    });
			 setTimeout(function() {
				 $('#myModal').modal("hide");
				  }, 500);
		});
}
function callReject()
{
	swal({
			title: "Are you sure?",
			text:  "",
			type:  "warning",
			showCancelButton: true,
			confirmButtonColor: '#DD6B55',
			confirmButtonText: 'Yes, Reject!',
			closeOnConfirm: true,
			//closeOnCancel: false
		},
		function(){
        var datacontentId = document.getElementById("datacontentId").value;
		var datakaleoInstanceTokenId = document.getElementById("datakaleoInstanceTokenId").value;
		var datauserId = document.getElementById("datauserId").value;
		var datarecordVersionId = document.getElementById("datarecordVersionId").value;
		var eventId = document.getElementById("eventId").value;
		rejectApproveRecord(datacontentId,datakaleoInstanceTokenId,datauserId,datarecordVersionId,"Rejected",eventId);
		 $("#fail-alert").fadeTo(2000, 500).slideUp(500, function() {
		      $("#fail-alert").slideUp(500);
		    });
		 setTimeout(function() {
			 $('#myModal').modal("hide");
			  }, 500);
		});
}
function testPath(formId)
{
	callServeResource(formId,"path",0,0,0)
}

//var displatButton="";
function displaySubmittedData(formId,userId,uuid,groupId,ddmFormInstanceId,eventId,reviewerId,status)
{
	
	var display = "block";
	var displaySendToReview = "block"
	var displayReviewer = "block";
	var displayEventAdmin = "none";
	// || status =="sent for review"
	if(status == "Approved" || status == "Rejected" || status == "rejected by reviewer" || status == "approved by reviewer" )
	{
		display = "none";
		displayReviewer = "none";
		displaySendToReview = "none";
	}
	else
		{
		    if(reviewerId != "-1")
			{
		    	display = "none";
		    	displayReviewer = "block";
			}
		}
	
	if(status == "sent for review")
	{
		displaySendToReview = "none";
	}
	
	if(reviewerId == "-1")
	{
		displayReviewer   = "none";
		displayEventAdmin = "block";
	}
	
	$("#submit").css("display",display);
	$("#reject").css("display",display);
	$("#submitReviewer").css("display",displayReviewer);
	$("#rejectReviewer").css("display",displayReviewer);
	$("#dataReviewerComments").css("display",displayReviewer);
	$("#review").css("display",displaySendToReview);
	
	callServeResource(formId,"getObjectData",userId,uuid,groupId,ddmFormInstanceId,eventId);
	$("#myModal").modal();
}


function callServeResource(formID,command,userId,uuid,groupId,ddmFormInstanceId,eventId)
{
    AUI().use('aui-io-request', function(A){
        A.io.request('${resourceUrl}', {
        	method: 'post',
               data: {
            	   <portlet:namespace />Id                   : formID,
            	   <portlet:namespace />command              : command,
            	   <portlet:namespace />userId               : userId,
            	   <portlet:namespace />uuid                 : uuid,
            	   <portlet:namespace />groupId              : groupId,
            	   <portlet:namespace />ddmFormInstanceId    : ddmFormInstanceId,
            	   <portlet:namespace />eventId              : eventId,
               },
               on: {
                   	success: function() {
						var data = JSON.parse(this.get('responseData'));
						console.log(data);
						$(".displayformdata").html("<th style='width: 50%;color: #042f3f;font-family: montserrat-light;'>Question & Answers</th>");
						$(".tabledata").show();
						if(data.length === 0){
							$(".displayformdata").append("<tr><td> No form data present </td></tr>");
						}
						$(data).each(function(index, value){
							if(!value.email == ''){
								if(data[index].status === "1")
								{
									document.getElementById("datacontentId").value = data[index].contentId;
									document.getElementById("datakaleoInstanceTokenId").value = data[index].kaleoInstanceTokenId;
									document.getElementById("datauserId").value = data[index].userId;
									document.getElementById("datarecordVersionId").value = data[index].recordVersionId;
									document.getElementById("eventId").value = data[index].eventId;
								$(".displayformdata").append("<tr class='tr-style'><td width='50%' style='padding: 2%; color: #4d4d4d; border-top-left-radius:5px;border-bottom-left-radius:5px;'>"+ data[index].email.split("  :  ")[0] 
																                     +"</td><td width='50%'  color: #4d4d4d; style='padding: 2%;font-family: montserrat-light;border-top-right-radius:5px;border-bottom-right-radius:5px;'>"+ data[index].email.split("  :  ")[1] +"</td>" //"</tr>");
																                     +"<td style='background: white;' class="+data[index].recordVersionId+" ></td></tr>");
								}else{
									$(".displayformdata").append("<tr class='tr-style'><td width='50%' style='padding: 2%; color: #4d4d4d; border-top-left-radius:5px;border-bottom-left-radius:5px;'>"+ data[index].email.split("  :  ")[0] 
				                     +"</td><td width='50%'  color: #4d4d4d; style='padding: 2%;font-family: montserrat-light;border-top-right-radius:5px;border-bottom-right-radius:5px;'>"+ data[index].email.split("  :  ")[1] +"</td></tr>");
								}
							}					
						});
              		}
        		}
 
    	});
	});
}

function rejectApproveRecord(recordID, kaleoInstanceTokenId, userId,recordVersionId,status,eventId)
{
    AUI().use('aui-io-request', function(A){
        A.io.request('${resourceUrl}', {
        	method: 'post',
               data: {
            	   <portlet:namespace />recordID: recordID,
            	   <portlet:namespace />kaleoInstanceTokenId : kaleoInstanceTokenId,
            	   <portlet:namespace />userId : userId,
            	   <portlet:namespace />recordVersionId : recordVersionId,
            	   <portlet:namespace />status : status,
            	   <portlet:namespace />eventId : eventId,
               },
               on: {
                   	success: function() {
				/* 	// var data = JSON.parse(this.get('responseData'));
					$('#tblparticipants').clear();
					//datatable.clear();
					$('#tblparticipants').rows.add(JSON.parse(this.get('responseData')));
					$('#tblparticipants').draw(); */
					
					var data = JSON.parse(this.get('responseData'));
					datatable.clear();
					datatable.rows.add(JSON.parse(this.get('responseData')));
					datatable.draw(); 
					
                   }
              }
        });
 
    });
} 
</script> 