<%@ include file="/init.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.calendar.model.CalendarBooking"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>

<script src="/o/misk-theme/js/from/jquery.dataTables.min.js"></script>
<script src="/o/misk-theme/js/from/dataTables.bootstrap4.min.js"></script>
<link href="/o/misk-theme/css/bootstrap.min.css" rel="stylesheet" />
<link href="/o/misk-theme/css/landing/CustomStyle.css" rel="stylesheet" /> 

<%
Object obj = renderRequest.getAttribute("calendarBookings");
Object testObj = renderRequest.getAttribute("originalList");
List<CalendarBooking> calendarBookings = new ArrayList<>();
ArrayList<CalendarBooking> t_arraylist =(ArrayList) obj;
JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
jsonArr =(JSONArray) testObj;
%>

<script>


$(document).ready(function() {
	
$('#tblparticipants').DataTable({
    data:  <%=jsonArr%> ,
    "columns": [
    	 { data: "EventId" },
    	 { data: "EndDate" },
          { data: "SubmitUserId" },
         { data: "SubmitUserName" },
          { data: "StartDate" }, 
          { data: "formId" },
          { data: "EventTitle" },
		  
          {
              title: "Manage",
              "mRender": function (data, type, row) {
            	 var formId = row.formId;
            	 var userId = row.SubmitUserId;
            	  /* i think jarabta i=jit ma2touchi
            	  '<a style = "padding:4%;" href="#" onclick="displaySubmittedData('+row+');return false;" data-toggle="tooltip" title="show submission and approve" class=""><i class="fa fa-eye"></i></a>'+
                  '<a style = "padding:4%;" href="#" onclick="showProfile();return false;" data-toggle="tooltip" title="show Profile"><i class="fa fa-user"></i></a> ';
            	  */
                  return '<a style = "padding:4%;" href="#" onclick="displaySubmittedData('+formId+","+userId+');return false;" data-toggle="tooltip" title="show submission and approve" class=""><i class="fa fa-eye"></i></a>'+
                         '<a style = "padding:4%;" href="#" onclick="showProfile();return false;" data-toggle="tooltip" title="show Profile"><i class="fa fa-user"></i></a> ';
              }
          }
    ],
   
		
}); 


$(function () {
    $('[data-toggle="tooltip"]').tooltip()
});

}); 

function displaySubmittedData(formId,userId)
{
	callServeResource(formId,userId);
}
function showProfile()
{
	alert("show profile");
}



</script>
<style>
button.event-btn {     
    margin-left: 2%;
    padding: 1%;
    border: 0;
    background-image: linear-gradient(223deg, #3bb78a, #00aed0), linear-gradient(to bottom, #0ca2cd, #0ca2cd);
}
</style>
<liferay-portlet:resourceURL var="resourceUrl" />

<div class="table-responsive">
	<table class="table table-striped" id="tblparticipants">
		<thead>
			<tr>  
				<th>#</th>
				<th>End Date</th>
				<th>SubmitUserId</th>
				<th>SubmitUserName</th>
				<th>StartDate</th>
				<th>Form Id</th>
				<th>Event Title</th>
				<th></th>
			</tr>
		</thead>
		<tbody>

		</tbody>
	</table>
</div>

	<%-- <div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>#</th>
				<th>Event Name</th>
				<th>Start Time</th>
				<th>End Time</th>
				<th>Title</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${calendarBookings}" var="calendarBooking">
				<tr>
					<th scope="row">${calendarBooking.calendarBookingId}</th>
					<td>${calendarBooking.title}</td>
					<td>${startDateHash.get(calendarBooking.calendarBookingId)}</td>
					<td>${endDateHash.get(calendarBooking.calendarBookingId)}</td>
					<td>${calendarBooking.title}</td>
					<td><button
							onclick="callServeResource(${formAttribute.get(calendarBooking.calendarBookingId)})"
							class="btn btn-primary calendar-add-event-btn event-btn" >Show Event form data</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div> --%>
<br />
<hr>
<br />








<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Modal Header</h4>
        </div>
        <div class="modal-body">
          <div class="table-responsive tabledata  hidden">
	<table class="table table-striped">
		<thead>
			<tr>
			    <th>user</th>
				<th>Question & Answers</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody class="displayformdata">
		</tbody>
	</table>
</div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>


<script type="text/javascript">
function callServeResource(formID,userId){
    AUI().use('aui-io-request', function(A){
        A.io.request('${resourceUrl}', {
        	method: 'post',
               data: {
            	   <portlet:namespace />Id: formID,
            	   <portlet:namespace />userId: userId,
               },
               on: {
                   	success: function() {
						var data = JSON.parse(this.get('responseData'));
						console.log(data);
						$(".displayformdata").html("");
						$(".tabledata").show();
						if(data.length === 0){
							$(".displayformdata").append("<tr><td> No form data present </td></tr>");
						}
						$(data).each(function(index, value){
							if(!value.formData == ''){
								if(data[index].status === "1"){
									$(".displayformdata").append("<tr>"+
											                        "<td>"+ data[index].userName +"</td>"+					
											                        "<td>"+ data[index].formData +"</td>"+
																	"<td class="+data[index].recordVersionId+" >"+
																	"<button class=\"btn btn-primary calendar-add-event-btn event-btn\"  onclick=\"approveRecord("+data[index].contentId+","+data[index].kaleoInstanceTokenId+","+data[index].userId+","+data[index].recordVersionId+","+"'Approved'"+")\">Approved</button>"+
																	"<button class=\"btn btn-primary calendar-add-event-btn event-btn\"  onclick=\"approveRecord("+data[index].contentId+","+data[index].kaleoInstanceTokenId+","+data[index].userId+","+data[index].recordVersionId+","+"'Reject'"+")\">Reject</button>"+
																	"<button class=\"btn btn-primary calendar-add-event-btn event-btn\"  onclick=\"window.location.href='/profile&userFromEvent=48515'\">Show Profile</button>"+
																	"</td></tr>");
								}else{
									$(".displayformdata").append("<tr>"+
						                                "<td>"+ data[index].userName +"</td>"+ 
						                                "<td>"+ data[index].formData +"</td></tr>");
								}
								$("#myModal").modal();
							}					
						});
              		}
        		}
 
    	});
	});
}
function approveRecord(recordID, kaleoInstanceTokenId, userId,recordVersionId,status){
    AUI().use('aui-io-request', function(A){
        A.io.request('${resourceUrl}', {
        	method: 'post',
               data: {
            	   <portlet:namespace />recordID: recordID,
            	   <portlet:namespace />kaleoInstanceTokenId : kaleoInstanceTokenId,
            	   <portlet:namespace />userId : userId,
            	   <portlet:namespace />recordVersionId : recordVersionId,
            	   <portlet:namespace />status : status,
               },
               on: {
                   	success: function() {
					var data = JSON.parse(this.get('responseData'));
					if(data.status == "success"){
						$("."+recordVersionId).hide();
					}
                   }
              }
        });
 
    });
} 
</script> 
<div class="modal fade" id="myformSpeaker" tabindex="-1" role="dialog" aria-labelledby="addlanguageLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                    <div class="modal-header text-white bg-info">
                    <h5 class="modal-title" id="addlanguageLabel">
                        <label>Apply For Event</label>
                    </h5>
                    <button type="reset" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                   <tbody class="displayformdata">
		           </tbody>
                 </iframe>
                </div>

            </div>
        </div>
    </div>