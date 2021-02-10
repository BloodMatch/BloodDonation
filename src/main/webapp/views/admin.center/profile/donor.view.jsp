<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "pageName" scope = "session"> 
    home
</c:set>

<c:set var = "title" scope = "session"> 
    ${donor.getFirstName()} ${donor.getLastName()} - Donor
</c:set>

<c:set var = "content" scope = "session">
<h1>DONOR</h1>
  <div class="row">
        <div class="col-md-8">
            <div class="card">
                <div class="header">
                    <h4 class="title px-3">Donations Summary</h4>
                </div>
                <div class="content">
                    <div class="content  table-width">
                        <table class="table table-hover">
                            <thead>
                                <th>State</th>
                                <th>Donation Type</th>
                                <th>Date</th>
                                <th></th>
                            </thead>
                            <tbody>
                            	<c:set var="appointments" value="${donor.getAppointments()}"/>
                            	<c:forEach items="${appointments}" var="appointment">
                                <tr>
                                    <td><img src="assets/icons/appointment_state-${appointment.getState()}.svg" width="20" title="${appointment.getState()}" alt="-"> <small>${appointment.getState()}</small></td>
                                    <td><img src="assets/icons/blood_type-${appointment.getDonationType()}.svg" width="15" title="${appointment.getDonationType()}" alt="-"> ${appointment.getDonationType()}</td>
                                    <td>${ appointment.getTime()}</td>
                                    <td class="">
                                        <form  action="center/appointment" method="POST">
                                            <div class="btn-group btn-group-sm" role="group" aria-label="Basic example">
                                                <input type="hidden" name="id" value="${appointment.getId()}">
                                                <c:choose>
                                              		<c:when test="${ appointment.getState().equals('Pending')}">
                                              			<button type="submit" name="action" value="approve" class="btn btn-info">Approve</button>
                                                		<button type="submit" name="action" value="decline" class="btn btn-danger">Decline</button>
													</c:when>
													<c:when test="${ appointment.getState().equals('Booked')}">
														<button type="submit" name="action" value="revoke" class="btn btn-warning">Revoke</button>
													</c:when>
													<c:otherwise>
														..
													</c:otherwise>  
												</c:choose> 
                                                
                                            </div>
                                        </form>
                                    </td>
                                </tr>
                                </c:forEach>
                               
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card card-user">
                
                <div class="content  px-2">
                    <div class="author "> 
                        <img class="avatar border-gray" src="assets/images/avatar-donor.png" alt="..."/>
                        
                        <h4 class="title">
                        	${donor.getFirstName()} ${donor.getLastName()}
                        	<br/><br/>
                        	<strong>${donor.getGroup()}</strong>
                        </h4>
                    </div>
                    <hr>
                    <div class="row">
                            <div class="col-sm-3">
                                <img class="text-right" src="assets/icons/card.svg" width="18" title="city" alt="Cin">
                                
                            </div>
                            <div class="col-sm-8">
                                ${donor.getCin()}
                            </div>    
                    </div>
                    <div class="row">
                            <div class="col-sm-3">
                                <img class="text-right" src="assets/icons/email.svg" width="15" title="email" alt="Email">
                            </div>
                            
                            <div class="col-sm-8">
                                ${donor.getEmail()}
                            </div>    
                    </div>
                    <div class="row">
                            <div class="col-sm-3">
                                <img class="text-right" src="assets/icons/phone.svg" width="15" title="phone" alt="Phone">
                            </div>
                            <div class="col-sm-8">
                                ${donor.getPhone()}
                            </div>    
                    </div>
                    <div class="row">
                            <div class="col-sm-3">
                                <img class="text-right" src="assets/icons/gender.svg" width="20" title="gender" alt="Gender">
                            </div>
                            <div class="col-sm-8">
                                ${donor.getGender()}
                            </div>    
                    </div>
                    <div class="row">
                            <div class="col-sm-3">
                                <img class="text-right" src="assets/icons/location.svg" width="15" title="city" alt="City">
                            </div>
                            <div class="col-sm-8">
                                ${donor.getCity()}
                            </div>    
                    </div>
                    <div class="row">
                            <div class="col-sm-3">
                                <img class="text-right" src="assets/icons/zip-code.svg" width="20" title="city" alt="Zip Code">
                            </div>
                            <div class="col-sm-8">
                                ${donor.getZipCode()}
                            </div>    
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:set>


<%@ include file="../app.jsp"%>