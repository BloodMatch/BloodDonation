<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "pageName" scope = "session"> 
    appointment
</c:set>

<c:set var = "title" scope = "session"> 
    Appointment
</c:set>

<c:set var = "content" scope = "session"> 
  <h1>Donations</h1>
   <div class="card">
   	<c:choose>
   		<c:when test="${ appointmentsList.size() > 0 }">
	   		<div class="header">
		        <h4 class="title  px-3">Pendding Donation/Appointments</h4>
		        <p class="category px-4">Here is a subtitle for this table</p>
		    </div>
		    <div class="content table-responsive table-width">
		    	<form id="peneding-appointments" action="center/appointment" method="POST"></form>
		        <table class="table table-hover">
		            <thead>
		            	<th>Doanation Type</th>
		            	<th>Date/Time</th>
		                <th>Donor</th>
		                <th>Group</th>
		                <th>Analysis</th>
		            </thead>
		            <tbody>
		             	<%--<c:forEach var = "i" begin = "1" end = "5">--%>
		             	<c:forEach items="${appointmentsList}" var="appointment">
		             	<c:set var="donor" value="${appointment.getDonor()}"/>
		                <tr>
		                	<td><img src="assets/icons/blood-type/${appointment.getDonationType()}.svg" width="15" title="${appointment.getDonationType()}" alt="-"> ${appointment.getDonationType()}</td>
		                	<td>${appointment.getTime()}</td>
		                    <td><a class="btn-lg" href="center/profile/donor?Did=${appointment.getDonorId()}">${donor.getFirstName()} ${donor.getLastName()}</a></td>
		                	<td><strong><c:out value="${donor.getGroup()}" default="-"/></strong></td>
		                    <td><a class="btn-lg" href="center/appointment/analysis?id=${appointment.getDonorId()}">View analysis</a></td>
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
</c:set>


<%@ include file="../app.jsp"%>