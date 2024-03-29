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
                    <h4 class="title px-3">Summary</h4>
                </div>
                <div class="content">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
				  <li class="nav-item">
				    <a class="nav-link " id="appointment-tab" data-toggle="tab" href="#appointment" role="tab" aria-controls="appointment" aria-selected="true">Appointment</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" id="donation-tab" data-toggle="tab" href="#donation" role="tab" aria-controls="donation" aria-selected="false">Donation</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" id="omission-tab" data-toggle="tab" href="#omission" role="tab" aria-controls="omission" aria-selected="false">Omission</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link active" id="all-tab" data-toggle="tab" href="#all" role="tab" aria-controls="all" aria-selected="false">All</a>
				  </li>
				</ul>
				
				<div class="tab-content" id="myTabContent">
				  <div class="tab-pane fade" id="appointment" role="tabpanel" aria-labelledby="appointment-tab">
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
                            	<c:set var="analysis" value="${appointment.getAnalysis()}"/>
                            	
                            	<c:if test = "${ appointment.getState().equals('Pending') || appointment.getState().equals('Booked') || appointment.getState().equals('Arrived') }">
                                <tr>
                                    <td><img src="assets/icons/appointment-state/${appointment.getState()}.svg" width="20" title="${appointment.getState()}" alt="-"> <small>${appointment.getState()}</small></td>
                                    <td><img src="assets/icons/blood-type/${appointment.getDonationType()}.svg" width="15" title="${appointment.getDonationType()}" alt="-"> ${appointment.getDonationType()}</td>
                                    <td>${ appointment.getTime().substring(0, 13)}H</td>
                                    <td class="">
                                        <form  action="center/appointment" method="POST">
                                            <input type="hidden" name="id" value="${appointment.getId()}">
                                            <div class="btn-group btn-group-sm" role="group" aria-label="Basic example">
                                                <c:choose>
                                              		<c:when test="${ appointment.getState().equals('Pending')}">
                                              			<button type="submit" name="action" value="approve" class="btn btn-info">Approve</button>
                                                		<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#editAppointmentModal" data-id="${appointment.getId()}" data-type="${appointment.getDonationType()}" data-datetime="${appointment.getTime()}" >Reschedule</button>
													</c:when>
													<c:when test="${ appointment.getState().equals('Booked')}">
														<button type="submit" name="action" value="revoke" class="btn btn-danger btn-block">Revoke</button>
													</c:when>
													<c:when test="${ appointment.getState().equals('Arrived')}">
														<button type="submit" name="action" value="notify" class="btn btn-warning btn-block">Notify</button>
														<button type="submit" name="action" value="done" class="btn btn-sm btn-success">Done</button>
													</c:when>
												</c:choose>
                                            </div>
                                        </form>
                                    </td>
                                </tr>
                                </c:if>
                                </c:forEach>
                               
                            </tbody>
                        </table>
                    </div>
				  </div>
				  <div class="tab-pane fade" id="donation" role="tabpanel" aria-labelledby="donation-tab">
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
                            	<c:set var="analysis" value="${appointment.getAnalysis()}"/>
                            	<c:if test = "${ appointment.getState().equals('Fulfilled') }">
                                <tr>
                                    <td><img src="assets/icons/appointment-state/${appointment.getState()}.svg" width="20" title="${appointment.getState()}" alt="-"> <small>${appointment.getState()}</small></td>
                                    <td><img src="assets/icons/blood-type/${appointment.getDonationType()}.svg" width="15" title="${appointment.getDonationType()}" alt="-"> ${appointment.getDonationType()}</td>
                                    <td>${ appointment.getTime().substring(0, 13)}H</td>
                                    <td class="">
                                        <form  action="center/appointment" method="POST">
                                            <input type="hidden" name="id" value="${appointment.getId()}">
                                            <div class="btn-group btn-group-sm" role="group" aria-label="Basic example">
												<button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#AnalysisModal" 
													data-id="${analysis.getId()}"
													data-code="${analysis.getCode()}"
													data-date="${analysis.getDate()}"
													data-group="${donor.getGroup()}"
													data-comment="${analysis.getComment()}"
													data-results='${analysis.getResults()}'
												>Analysis</button>
												<input type="checkbox" disabled <c:if test = "${analysis.getCode() > ''}">checked</c:if>>
                                            </div>
                                        </form>
                                    </td>
                                </tr>
                                </c:if>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
				  </div>
				  <div class="tab-pane fade" id="omission" role="tabpanel" aria-labelledby="omission-tab">
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
                            	<c:set var="analysis" value="${appointment.getAnalysis()}"/>
                            	<c:if test = "${ appointment.getState().equals('Missed') || appointment.getState().equals('Canceled') || appointment.getState().equals('Rvoked') || appointment.getState().equals('Expired')}">
                                <tr>
                                    <td><img src="assets/icons/appointment-state/${appointment.getState()}.svg" width="20" title="${appointment.getState()}" alt="-"> <small>${appointment.getState()}</small></td>
                                    <td><img src="assets/icons/blood-type/${appointment.getDonationType()}.svg" width="15" title="${appointment.getDonationType()}" alt="-"> ${appointment.getDonationType()}</td>
                                    <td>${ appointment.getTime().substring(0, 13)}H</td>
                                    
                                </tr>
                                </c:if>
                                </c:forEach>
                               
                            </tbody>
                        </table>
                    </div>
				  </div>
				  <div class="tab-pane fade show active" id="all" role="tabpanel" aria-labelledby="all-tab">
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
                            	<c:set var="analysis" value="${appointment.getAnalysis()}"/>
                                <tr>
                                    <td><img src="assets/icons/appointment-state/${appointment.getState()}.svg" width="20" title="${appointment.getState()}" alt="-"> <small>${appointment.getState()}</small></td>
                                    <td><img src="assets/icons/blood-type/${appointment.getDonationType()}.svg" width="15" title="${appointment.getDonationType()}" alt="-"> ${appointment.getDonationType()}</td>
                                    <td>${ appointment.getTime().substring(0, 13)}H</td>
                                </tr>
                                </c:forEach>
                               
                            </tbody>
                        </table>
                    </div>
				  </div>
				
				</div>
				
                    
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card card-user py-3">
                <div class="content  px-2">
                    <div class="author "> 
                        <img class="avatar border-gray" src="assets/images/avatar-donor.png" alt="..."/>
                        <h4 class="title">
                        	${donor.getFirstName()} ${donor.getLastName()}
                        	<br><br>
                        	<strong class="text-danger">${donor.getGroup()}</strong>
                        </h4>
                    </div>
                    <hr>
                    <div class="content  px-3">
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
	                    <hr/>
		                 <div class="text-center">
		                     <button type="button" class="btn btn-danger btn-block" data-toggle="modal" data-target="#newAppointmentModal" data-whatever="Add new Appointment">New Appointment</button>
		                 </div>
	                 </div>
                </div>
            </div>
        </div>
    </div>

<div class="modal fade" id="AnalysisModal" tabindex="-1" role="dialog" aria-labelledby="AnalysisModalLabel"  aria-hidden="true" >
	<%@ include file="../appointment/analysis.modal.jsp"%>
</div>

<div class="modal fade" id="editAppointmentModal" tabindex="-1" role="dialog" aria-labelledby="editAppointmentModalLabel" aria-hidden="true">
	<%@ include file="../appointment/edit.modal.jsp"%>
</div>

<div class="modal fade" id="newAppointmentModal" tabindex="-1" role="dialog" aria-labelledby="newAppointmentModalLabel" aria-hidden="true">
	<%@ include file="../appointment/new.modal.jsp"%>
</div>
</c:set>
<%@ include file="../app.jsp"%>