<%@ include file="/init.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>

<link href="/o/new-misk-theme/css/font/font-awesome/font-awesome.min.css" rel="stylesheet" />
<link href="/o/new-misk-theme/images/loader.gif" rel="stylesheet" />

<style>
button.btn.btn-primary.calendar-add-event-btn {
    background-image: linear-gradient(223deg, #3bb78a, #00aed0), linear-gradient(to bottom, #0ca2cd, #0ca2cd);
    border: 0;
}
.scheduler-base-nav-date.hidden {
    font-size: 0;
}
div > div.col-xs-7.scheduler-base-controls > div:nth-child(2) {
    display: none;
}
div#tblparticipants_filter {
    float: right;
}
.pagination {
    position: relative!important;
    right: 20px;
    top: 50%;
    transform: translateY(-50%);
    font-size: 1.4em;
    z-index: 10;
    display: flex!important;
}
.table-striped tbody tr:nth-of-type(odd) td{
 background-color: #F2F2F2;
    background: #FAFBFC;  
    height: 30px
} 
.table-striped tbody tr:nth-of-type(odd) th {
    background-color: #F2F2F2;
    background: #FAFBFC;  
    height: 50px;
}

.table td {
    border-bottom-width: 1px;
    border-left-width: 0;
    border-right-width: 0;
    border-top-width: 1px;
    border-color: #E6EAEE;
    border-style: solid;
    position: relative;
    vertical-align: middle !important;
}
.table td {
    padding-left:10px !important;
    padding-right:10px !important;
    vertical-align: middle!important;
    padding-top: 0px !important;
    padding-bottom: 0px !important;
    height: 30px;
    border-top: 1px solid #E6EAEE;
}
.table th {
    padding: 10px !important;;
    vertical-align: middle!important;
    height: 50px;
    border-top: 1px solid #E6EAEE;
}
.table {
    width: 100% !important;
    margin-bottom: 1rem;
    color: #212529;
    background: #fff;
    /* max-width: 1000px; */
    width: 96%;
    border: 1px solid #E6EAEE;
    border-radius: 3.25%!important;
}
.table thead th {
    font-size: 0.9rem;
    color: rgba(53, 64, 82, 0.5);
    text-transform: uppercase;
    font-weight: 600;  	
    font-family: Montserrat-Regular;
    vertical-align: middle!important;
}
	.table-wrapper .btn.btn-primary:hover {
		background: #03a3e7;
	}
	.table-title .btn {		
		font-size: 13px;
		border: none;
	}
	.table-title .btn i {
		float: left;
		font-size: 21px;
		margin-right: 5px;
	}
	.table-title .btn span {
		float: left;
		margin-top: 2px;
	}
	.table-title {
		color: #fff;
		background: #4b5366;		
		padding: 16px 25px;
		margin: -20px -25px 10px;
		border-radius: 3px 3px 0 0;
    }
    .table-title h2 {
		margin: 5px 0 0;
		font-size: 24px;
	}
	.show-entries select.form-control {        
        width: 60px;
		margin: 0 5px;
	}
	.table-filter .filter-group {
        float: right;
		margin-left: 15px;
    }
	.table-filter input, .table-filter select {
		height: 34px;
		border-radius: 3px;
		border-color: #ddd;
        box-shadow: none;
	}
	.table-filter {
		padding: 5px 0 15px;
		border-bottom: 1px solid #e9e9e9;
		margin-bottom: 5px;
	}
	.table-filter .btn {
		height: 34px;
	}
	.table-filter label {
		font-weight: normal;
		margin-left: 10px;
	}
	.table-filter select, .table-filter input {
		display: inline-block;
		margin-left: 5px;
	}
	.table-filter input {
		width: 200px;
		display: inline-block;
	}
	.filter-group select.form-control {
		width: 110px;
	}
	.filter-icon {
		float: right;
		margin-top: 7px;
	}
	.filter-icon i {
		font-size: 18px;
		opacity: 0.7;
	}	
    table.table tr th, table.table tr td {
        border-color: #e9e9e9;
		padding: 12px 15px;
		vertical-align: middle;
    }
	table.table tr th:first-child {
		width: 60px;
	}
	table.table tr th:last-child {
		width: 80px;
	}
    table.table-striped tbody tr:nth-of-type(odd) {
    	background-color: #fcfcfc;
	}
	table.table-striped.table-hover tbody tr:hover {
		background: #f5f5f5;
	}
    table.table th i {
        font-size: 13px;
        margin: 0 5px;
        cursor: pointer;
    }	
	table.table td a {
		font-weight: bold;
		color: #566787;
		display: inline-block;
		text-decoration: none;
	}
	table.table td a:hover {
		color: #2196F3;
	}
	table.table td a.view {        
		width: 30px;
		height: 30px;
		color: #2196F3;
		border: 2px solid;
		border-radius: 30px;
		text-align: center;
    }
    table.table td a.view i {
        font-size: 22px;
		margin: 2px 0 0 1px;
    }   
	table.table .avatar {
		border-radius: 50%;
		vertical-align: middle;
		margin-right: 10px;
	}
	.status {
		font-size: 30px;
		margin: 2px 2px 0 0;
		display: inline-block;
		vertical-align: middle;
		line-height: 10px;
	}
    .text-success {
        color: #10c469;
    }
    .text-info {
        color: #62c9e8;
    }
    .text-warning {
        color: #FFC107;
    }
    .text-danger {
        color: #ff5b5b;
    }
    .pagination {
        float: right;
        margin: 15px 0 5px;
    }
    .pagination li a {
        border: none;
        font-size: 15px;
        min-width: 30px;
        min-height: 30px;
        color: #999;
        margin: 0 2px;
        line-height: 30px;
        border-radius: 2px !important;
        text-align: center;
        padding: 0 6px;
    }
    .pagination li a:hover {
        color: #666;
    }	
    .pagination li.active a {
        background: #03A9F4;
    }
    .pagination li.active a:hover {        
        background: #0397d6;
    }
	.pagination li.disabled i {
        color: #ccc;
    }
    .pagination li i {
        font-size: 16px;
        padding-top: 6px
    }
    .hint-text {
        float: left;
        margin-top: 10px;
        font-size: 13px;
    } 
    .pagination a:after {
    display:none !important;    
    
}

.table-striped thead th{    
	
    color:#7db72c !important;
    }
  




.modal-header{
background-image: linear-gradient(223deg, #3bb78a, #00aed0), linear-gradient(to bottom, #0ca2cd, #0ca2cd);
color:#ffffff ;
}
.popuptdable{

}
#participant-section{
/*background-color: #4a4b54;*/
background-image: linear-gradient(to right, #0061a5, #279574);
min-height: 250px;

}

.popuptbale.table tr th:first-child{
    width:auto !important;
 }
 
 #tblparticipants_filter input{
 	border: none;
    border-bottom: 1px solid #ced4da;
 }
   #tblparticipants_filter label{
 	font-size: 15px;
    text-align: center;
 }
 #tblparticipants_length  label{
 	font-size: 15px;
    
 } 
 .dataTables_length select{
     width: 100px !important;
 }
 
 .start-header{
 padding-top:30px !important;
 }
 .dataTables_paginate{
 float:left;
 }
 .footer-desc{
  font-size: 16px !important; 
  font-family: Montserrat-Light;
 }
 
 
 /*
profile css modal
*/
@media (min-width: 992px)
{
.modal-lg, .modal-xl {
max-width: 1202px !important;
}
label {
max-width: 85%;
}
}
.modal-body {
padding:0 !important;
}

div#Loader {
    margin-left: 45%;
    z-index: 427;
    background: url(/o/new-misk-theme/images/loader.gif);
    background-repeat: no-repeat;
    height: 54px;
    background-size: 50px;
    position: relative;
    top: 145px;
    display:none;
}
/*
profile css modal
*/

</style>

<script src="/o/new-misk-theme/js/from/jquery.dataTables.min.js"></script>
<script src="/o/new-misk-theme/js/from/dataTables.bootstrap4.min.js"></script>

<liferay-portlet:resourceURL var="resourceUrl" />
<%
Object testObj = renderRequest.getAttribute("originalList");
JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
jsonArr =(JSONArray) testObj;
System.out.println(jsonArr);
//Code changes for the reviewer Comments start
boolean isReviewerEventRole=request.isUserInRole("reviewerEvent");
//Code changes for the reviewer Comments end
System.out.println("jsonArr: " + jsonArr);
%>
<script>
var datatable;
$(document).ready(function() {
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
                  return '<a style = "padding:4%;" href="#" onclick="displaySubmittedData('+formId+","+userId+",'"+uuid+"',"+groupId+","+ddmFormInstanceId+","+eventId+","+reviewerId+",'"+status+"'"+');return false;" data-toggle="tooltip" title="show submission and approve" class=""><i class="fa fa-eye"></i></a>'+
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
<body>
<div class="container-fluid">
	  <div id="participant-section">
	   </div>
		<div class="table-responsive pt-5">
		<div class="loader"  id="Loader"></div>
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
						<th style='width: 13%;' >Reviewer Comments</th>
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

<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog  modal-lg" >
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Questioner Form Approval</h4>
        </div>
        <div class="modal-body">
          <div class="table-responsive tabledata  ">
	<table class="table table-striped">
		<thead>
			<tr>
				<th style='width: 100%;'>Question & Answers</th>
			</tr>
		</thead>
		<tbody class="displayformdata">
		</tbody>
	</table>
		<textarea rows="3" cols="90" id="dataReviewerComments" placeholder="Please enter the review comments here" name="reviewerComments"></textarea>
</div>
        </div>
        <div class="modal-footer">
          <input type="hidden" id="datacontentId" value="">
          <input type="hidden" id="datakaleoInstanceTokenId" value="">
          <input type="hidden" id="datauserId" value="">
          <input type="hidden" id="datarecordVersionId" value="">
		  <input type="hidden" id="eventId" value="">
		  
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          <c:if test="<%=request.isUserInRole("Administrator") || request.isUserInRole("adminByDep1") || request.isUserInRole("adminDep2")%>" >
          </c:if>
          
	              <input type="submit" value="send to review" onclick="sendToReview()" id="review" name="review-button" class="btn btn-primary">
		          <input type="submit" value="aprove" id="submit" onclick="callToAprove()" name="Approve submission" class="btn btn-primary">
		          <input type="submit" value="reject" id="reject" name="reject submission" onclick="callReject()" class="btn btn-warning">
          
          
	          <input type="submit" value="approve by reviewer" id="submitReviewer" onclick="approveByReviewer()" name="Approve submission" class="btn btn-primary">
	          <input type="submit" value="reject by reviewer" id="rejectReviewer" name="reject submission" onclick="rejectByReviewer()" class="btn btn-warning">
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
<script type="text/javascript">

function openProfile(locationLink) 
{
	debugger;
	var locationLink1 = "/web/guest/profile?userId="+locationLink;
  //  $(".modal-body #srcId").val( locationLink );
	// $('#myModal').modal('show') ;
	document.getElementById("srcId").src=locationLink1;
	$('#profilemodal').modal('show') ;
}


function sendToReview(){
	debugger;
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
						debugger;
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
                   		debugger;
                   		reviewerUserId = this.get('responseData');
                   }
              }
        });
 
    });
}

function approveByReviewer()
{
	debugger;
	var datacontentId = document.getElementById("datacontentId").value;
	var datauserId = document.getElementById("datauserId").value;
	var datarecordVersionId = document.getElementById("datarecordVersionId").value;
	var dataReviewerComments = document.getElementById("dataReviewerComments").value;
	var eventId = document.getElementById("eventId").value;
	//var reviewerUserId = '${themeDisplay.getUserId()}';
	getEventReviewer(eventId);
	
	var groupId = '${themeDisplay.getSiteGroupId()}';
	AUI().use('aui-io-request', function(A){
        A.io.request('${resourceUrl}', {
        	method: 'post',
               data: {
            	   <portlet:namespace />submitterUserId  : datauserId,
            	   <portlet:namespace />recordID         : datacontentId,
            	   <portlet:namespace />userId           : reviewerUserId,
            	   <portlet:namespace />recordVersionId  : datarecordVersionId,
            	   <portlet:namespace />reviewerComments : dataReviewerComments,
            	   <portlet:namespace />eventId : eventId,
            	   <portlet:namespace />groupId : groupId,
            	   <portlet:namespace />action : "approvedbyreveiewer",            	   
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

function rejectByReviewer(){
	debugger;
	var datacontentId = document.getElementById("datacontentId").value;
	var datauserId = document.getElementById("datauserId").value;
	var datarecordVersionId = document.getElementById("datarecordVersionId").value;
	var dataReviewerComments = document.getElementById("dataReviewerComments").value;
	var eventId = document.getElementById("eventId").value;
	// var reviewerUserId = '${themeDisplay.getUserId()}';
	getEventReviewer(eventId);
	var groupId = '${themeDisplay.getSiteGroupId()}';
	AUI().use('aui-io-request', function(A){
        A.io.request('${resourceUrl}', {
        	method: 'post',
               data: {
            	   <portlet:namespace />submitterUserId  : datauserId,
            	   <portlet:namespace />recordID: datacontentId,
            	   <portlet:namespace />userId : reviewerUserId,
            	   <portlet:namespace />recordVersionId : datarecordVersionId,
            	   <portlet:namespace />reviewerComments : dataReviewerComments,
            	   <portlet:namespace />groupId : groupId,       
            	   <portlet:namespace />eventId : eventId,   
            	   <portlet:namespace />action : "rejectedbyreveiewer",            	   
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

var x = document.getElementById('Loader');
function approveRecordFromGrid(eventId,userId,ddmFormInstanceId,reviewerId)
{
	debugger;
    x.style.display = "block";
    if(reviewerId == "-1")
   	{
    	approveByReviewer();
   	}
    else
    {
	   ApproveRejectFromGrid(eventId,userId,"ApproveRejectRecordFromGrid","Approved");
    }
}

function rejectRecordFromGrid(eventId,userId,ddmFormInstanceId,reviewerId)
{
	debugger;
	 x.style.display = "block";
	 if(reviewerId == "-1")
   	 {
		 rejectByReviewer();
   	 }
     else
     {
    	ApproveRejectFromGrid(eventId,userId,"ApproveRejectRecordFromGrid","Rejected")
     }
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
	debugger;
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
	 
}
function callReject()
{
        debugger;
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
}
function testPath(formId)
{
	callServeResource(formId,"path",0,0,0)
}

//var displatButton="";
function displaySubmittedData(formId,userId,uuid,groupId,ddmFormInstanceId,eventId,reviewerId,status)
{
	debugger;
	
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
	debugger;
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
                   		debugger;
						var data = JSON.parse(this.get('responseData'));
						console.log(data);
						$(".displayformdata").html("");
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
									$(".displayformdata").append("<tr><td>"+ data[index].email +"</td><td class="+data[index].recordVersionId+" ></td></tr>");
								}else{
									$(".displayformdata").append("<tr><td>"+ data[index].email +"</td></tr>");
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
	debugger;
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
                   		debugger;
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