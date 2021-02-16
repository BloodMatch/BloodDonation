<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "pageName" scope = "session"> 
    appointment
</c:set>

<c:set var = "title" scope = "session"> 
    Appointment
</c:set>

<c:set var = "content" scope = "session"> 
  <h1>Scheduled</h1>
  <div class="row">
    <div class="col-md-7">
   <div class="card">
   	<c:choose>  
   		<c:when test="${ bookedAppointmentsList.size() > 0 }">
	   		<div class="header">
		        <h4 class="title px-3">Schduled Donation/Appointments</h4>
		        <p class="category px-4">...</p>
		    </div>
		    <div class="content table-responsive table-width">
		    	<form id="scheduled-appointments" action="center/appointment" method="POST"></form>
		        <table class="table table-hover">
		            <thead>
		            	<th></th>
		            	<th>Doanation Type</th>
		            	<th>Date/Time</th>
		                <th>Donor</th>
		                <th>    
			                <button type="submit" form="scheduled-appointments" title="Revoke all" name="action" value="revokeAll" class="btn btn-sm btn-danger">Revoke</button>
		                </th>
		            </thead>
		            <tbody>
		             	<%--<c:forEach var = "i" begin = "1" end = "5">--%>
		             	<c:forEach items="${bookedAppointmentsList}" var="appointment">
		             	<c:set var="donor" value="${appointment.getDonor()}"/>
		                <tr>
		                	<td>
								<input form="scheduled-appointments" type="checkbox" name="ids" value="${appointment.getId()}" >
		                	</td>
		                	
		                	<td><img src="assets/icons/blood-type/${appointment.getDonationType()}.svg" width="15" title="${appointment.getDonationType()}" alt="-"> ${appointment.getDonationType()}</td>
		                	<td>${appointment.getTime().substring(0, 13)}H</td>
		                    <td><a href="center/profile/donor?Did=${appointment.getDonorId()}">${donor.getFirstName()} ${donor.getLastName() }</a></td>
		                    
		                    <td>
		                        <form  action="center/appointment" method="POST">
										<input type="hidden" name="id" value="${appointment.getId()}">
			                            <button type="submit" name="action" value="revoke" class="btn btn-sm btn-danger">Revoke</button>
		                       	</form>
		                    </td>
		                </tr>
		                </c:forEach>
		            </tbody>
		        </table>
	    	</div>
	    </c:when>  
	        <c:otherwise>  
				<h4 class="title text-center"> <i class="fa fa-exclamation-circle"></i> No more scheduled appointment!</h4>
			</c:otherwise>  
		</c:choose> 
		</div>
		</div>
		
		
		
		
		<div class="col-md-5">
   <div class="card">
   	<c:choose>  
   		<c:when test="${ arrivedAppointmentsList.size() > 0 }">
	   		<div class="header">
		        <h4 class="title px-3">Today's Appointments</h4>
		        <p class="category px-4">...</p>
		    </div>
		    <div class="content table-responsive table-width">
		    	<form id="scheduled-appointments" action="center/appointment" method="POST"></form>
		        <table class="table table-hover">
		            <thead>
		            	<th></th>
		            	<th>Doanation Type</th>
		                <th>Donor</th>
		                <th>    
			                <button type="submit" form="scheduled-appointments" title="Done all" name="action" value="doneAll" class="btn btn-sm btn-success">Done</button>
		                </th>
		            </thead>
		            <tbody>
		             	<%--<c:forEach var = "i" begin = "1" end = "5">--%>
		             	<c:forEach items="${arrivedAppointmentsList}" var="appointment">
		             	<c:set var="donor" value="${appointment.getDonor()}"/>
		                <tr>
		                	<td>
								<input form="scheduled-appointments" type="checkbox" name="ids" value="${appointment.getId()}" >
		                	</td>
		                	<td><img src="assets/icons/blood-type/${appointment.getDonationType()}.svg" width="15" title="${appointment.getDonationType()}" alt="-"> ${appointment.getDonationType()}</td>
		                    <td><a href="center/profile/donor?Did=${appointment.getDonorId()}">${donor.getFirstName()} ${donor.getLastName() }</a></td>
		                    <td>
		                        <form  action="center/appointment" method="POST">
										<input type="hidden" name="id" value="${appointment.getId()}">
			                            <button type="submit" name="action" value="done" class="btn btn-sm btn-success">Done</button>
		                       	</form>
		                    </td>
		                </tr>
		                </c:forEach>
		            </tbody>
		        </table>
	    	</div>
	    </c:when>  
	        <c:otherwise>  
				<h4 class="title text-center"> <i class="fa fa-exclamation-circle"></i> No scheduled appointments for today!</h4>
			</c:otherwise>  
		</c:choose> 
		</div>
		</div>
		
		
		
	</div>
						
</c:set>


<%@ include file="../app.jsp"%>