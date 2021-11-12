<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "pageName" scope = "session"> 
    appointment
</c:set>

<c:set var = "title" scope = "session"> 
    Appointment
</c:set>

<c:set var = "content" scope = "session"> 
  <h1>Pending</h1>
   <div class="card">
   	<c:choose>
   		<c:when test="${ appointmentsList.size() > 0 }">
	   		<div class="header">
		        <h4 class="title  px-3">Pendding Donation/Appointments</h4>
		        <p class="category px-4">...</p>
		    </div>
		    <div class="content table-responsive table-width">
		    	<form id="peneding-appointments" action="center/appointment" method="POST"></form>
		        <table class="table table-hover">
		            <thead>
		            	<th>
						</th>
		            	<th>Doanation Type</th>
		            	<th>Date/Time</th>
		                <th>Donor</th>
		                <th>    
		                	<div class="btn-group btn-group-sm" role="group" aria-label="Basic example">
			                	<button type="submit" form="peneding-appointments" title="Approve all" name="action" value="approveAll" class="btn btn-primary btn-block">Approve all selected</button>
		                	</div>
		                </th>
		            </thead>
		            <tbody>
		             	<%--<c:forEach var = "i" begin = "1" end = "5">--%>
		             	<c:forEach items="${appointmentsList}" var="appointment">
		             	<c:set var="donor" value="${appointment.getDonor()}"/>
		                <tr>
		                	<td>
								<input form="peneding-appointments" type="checkbox" name="ids" value="${appointment.getId()}" >
		                	</td>
		                	
		                	<td><img src="assets/icons/blood-type/${appointment.getDonationType()}.svg" width="15" title="${appointment.getDonationType()}" alt="-"> ${appointment.getDonationType()}</td>
		                	<td>${appointment.getTime().substring(0, 13)}H</td>
		                    <td><a  class="btn-lg" href="center/profile/donor?Did=${appointment.getDonorId()}">${donor.getFirstName()} ${donor.getLastName()}</a></td>
		                    
		                    <td>
		                        <form  action="center/appointment" method="POST">
		                        	<input type="hidden" name="id" value="${appointment.getId()}">
			                        <div class="btn-group btn-group-sm" role="group" aria-label="Basic example">
			                            <button type="submit" name="action" value="approve" class="btn btn-primary">Approve</button>
			                            <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#editAppointmentModal" data-id="${appointment.getId()}" data-type="${appointment.getDonationType()}" data-datetime="${appointment.getTime()}" >Reschedule</nutton>
			                        </div>
		                       	</form>
		                    </td>
		                </tr>
		                </c:forEach>
		            </tbody>
		        </table>
	    	</div>
	    </c:when>  
	        <c:otherwise>
				<h4 class="title text-center"> <i class="fa fa-exclamation-circle"></i> No more pending appointment!</h4>
			</c:otherwise>  
		</c:choose> 
	</div>
						
<div class="modal fade" id="editAppointmentModal" tabindex="-1" role="dialog" aria-labelledby="editAppointmentModalLabel" aria-hidden="true">
	<%@ include file="edit.modal.jsp"%>
</div>

</c:set>

<%@ include file="../app.jsp"%>