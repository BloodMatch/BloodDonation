<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>
<c:set var="title" scope="session">
	Menu
</c:set>

<c:set var ="content" scope="session">
    <section class="first-section">
    	<div class="container">
            <h2>Menu</h2>
            <div class="text-muted font-weight-lighter"> If all Eligibility Requirements Donation are Fulfilled you can Make your Schedule !</div>
            <hr>
        </div>
        <div class="container">
        	<c:if test="${not empty appoint.errorMsg}">
            	<div class="container">
         		<div class="row justify-content-center">
         			<div class="alert alert-danger" role="alert">
					  	${appoint.errorMsg} <a href="${rootUrl}/donor#requirements">About Requirements</a>
					</div>
         		</div>
         	</div>
            </c:if>
            <div class="row align-items-center">
                <div class="col-sm-12 col-md-6">
                    <div class="card mb-3 bg-gray border-0">
                        <div class="card-body">
                            <div class="row justify-content-center">
                                <div class="col-2">
                                    <i class="far fa-list-alt fa-3x blood-color"></i>
                                </div>
                                <div class="col-10">
                                    <h3> Start Your Test </h3>
                                    <p class="text-muted">Blood Donation Eligibility Requirements</p>
                                </div>
                            </div>
                            <a href="${rootUrl}/donor/requirements" class="btn stretched-link right"><i class="fas fa-angle-right"></i></a>
                        </div>
                    </div>
                    <div class="card mb-3 bg-gray border-0">
                        <div class="card-body">
                            <div class="row justify-content-center">
                                <div class="col-2">
                                    <i class="far fa-calendar-plus fa-3x blood-color"></i>
                                </div>
                                <div class="col-10">
                                    <h3> Schedule New Appointment  </h3>
                                    <p class="text-muted">Choose a time, location and donation type</p>
                                </div>
                            </div>
                            <a href="${rootUrl}/donor/schedule" class="btn stretched-link right"><i class="fas fa-angle-right"></i></a>
                        </div>
                    </div>
                    <div class="card bg-gray border-0">
                        <div class="card-body">
                            <div class="row justify-content-center">
                                <div class="col-2">
                                    <i class="fas fa-sliders-h fa-3x blood-color"></i>
                                </div>
                                <div class="col-10">
                                    <h3> Manage Appointment </h3>
                                    <p class="text-muted"> Reschedule, cancel </p>
                                </div>
                            </div>
                            <a href="${rootUrl}/donor/manage" class="btn stretched-link right"><i class="fas fa-angle-right"></i></a>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12 col-md-6">
                    <h2 class="text-center">Make your first Donation</h2>
                    <div class="card text-center bg-gray border-0" style="width: 100wh;">
                        <div class="card-body">
                          <h5 class="card-title">Each donation can impact up to three lives.</h5>
                          <p class="card-text text-muted font-weight-lighter">Every  seconds someone needs blood.</p>
                          <img src="${rootUrl}/assets/donor/firstDonation.svg" class="img-fluid" alt="Person donating blood">
                          <a href="${rootUrl}/donor/schedule" class="btn btn-lg btn-block my-3 btn-blood">Schedule NEW  APPOINTMENT</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="m-5">
        <div class="container">
	        <c:if test="${not empty appoint.id}">
	            <hr class="mb-5">
	            <div class="row">
	                <div class="col-sm-12 col-md-4">
	                    <h1>Your last donation</h1>
	                    <p class="text-muted"> ${appoint.time} </p>
	                </div>
	                <div class="col-sm-12 col-md-4">
	                    <div class="card">
	                        <div class="card-body">
	                            <div class="row text-center">
	                                <div class="col-12">
	                                    <h4><img src="${rootUrl}/assets/icons/blood-type/${appoint.donationType}.svg" width="15" title="${appoint.donationType}" alt="-"> ${appoint.donationType} </h4>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-sm-12 col-md-4">
	                    <div class="card">
	                        <div class="card-body">
	                            <div class="row justify-content-center">
	                                <div class="col-2">
	                                    <i class="fas fa-hospital blood-color fa-2x"></i>
	                                </div>
	                                <div class="col-10">
	                                    <h4> ${center.name} </h4>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
            </c:if>
            <hr class="mb-5">
            <div class="row">
                <div class="col-sm-12 col-md-6 d-flex justify-content-around">
                    <i class="fas fa-clock mr-4 fa-2x blood-color"></i> 
                    <h4>View Past Donations</h4>
                    <a href="${rootUrl}/donor/history"  class="btn btn-lg bg-gray"><i class="fas fa-angle-right fa-2x"></i></a>
                </div>
                <div class="col-sm-12 col-md-6 d-flex justify-content-around">
                    <i class="fas fa-hospital blood-color fa-2x"></i>
                    <h4>Centers Near To Me</h4>
                    <a href=""  class="btn btn-lg bg-gray"><i class="fas fa-angle-right fa-2x"></i></a>
                </div>
            </div>
        </div>
    </section>
</c:set>

<%@ include file="../layouts/app.view.jsp" %>