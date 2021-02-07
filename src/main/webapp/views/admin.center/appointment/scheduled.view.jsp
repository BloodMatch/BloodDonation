<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "pageName" scope = "session"> 
    appointment
</c:set>

<c:set var = "title" scope = "session"> 
    Appointment
</c:set>

<c:set var = "content" scope = "session"> 
  <h1>Scheduled</h1>
   <div class="card">
   	<c:choose>  
   		<c:when test="${ appointmentsList.size() > 0 }">
	   		<div class="header">
		        <h4 class="title">Schduled Donation/Appointments</h4>
		        <p class="category">Here is a subtitle for this table</p>
		    </div>
		    <div class="content table-responsive table-width">
		    	<form id="scheduled-appointments" action="center/appointment" method="POST"></form>
		        <table class="table table-hover">
		            <thead>
		            	<th>
							<input type="checkbox" form="scheduled-appointments" title="Select all" name="all" value="1">
						</th>
		            	<th>Doanation Type</th>
		            	<th>Date/Time</th>
		                <th>Donor</th>
		                <th>    
		                	<div class="btn-group btn-group-sm" role="group" aria-label="Basic example">
			                	<button type="submit" form="scheduled-appointments" title="Revoke all" name="action" value="revokeAll" class="btn btn-danger">Revoke</button>
		                	</div>
		                </th>
		            </thead>
		            <tbody>
		             	<%--<c:forEach var = "i" begin = "1" end = "5">--%>
		             	<c:forEach items="${appointmentsList}" var="appointment">
		             	<c:set var="donor" value="${appointment.getDonor()}"/>
		                <tr>
		                	<td>
								<input form="scheduled-appointments" type="checkbox" name="ids" value="${appointment.getId()}" >
		                	</td>
		                	
		                	<td>${appointment.getDonationType()}</td>
		                	<td>${appointment.getTime()}</td>
		                    <td><a href="center/account/donor?id=${appointment.getDonorId()}">${donor.getFirstName()} ${donor.getLastName() }</a></td>
		                    
		                    <td>
		                        <form  action="center/appointment" method="POST">
			                        <div class="btn-group btn-group-sm" role="group" aria-label="Basic example">
										<input type="hidden" name="id" value="${appointment.getId()}">
			                            <button type="submit" name="action" value="revoke" class="btn btn-danger">Revoke</button>
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
				<h4 class="title text-center"> <i class="fas fa-exclamation-circle"></i> No scheduled appointment!</h4>
			</c:otherwise>  
		</c:choose> 
	</div>
						
</c:set>


<%@ include file="../app.jsp"%>