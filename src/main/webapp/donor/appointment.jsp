<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>
<c:set var="title" scope="session">
	Schedule Appointment
</c:set>

<c:set var ="content" scope="session">
    <section class="first-section">
        <div class="container">
            <h2>Schedule New Appointment </h2>
            <div class="text-muted font-weight-lighter">Choose a time, location and donation type</div>
            <hr>
            <div class="row justify-content-around">
                <div class="col-sm-12 col-md-4">
                    <form action="">
                        <h3>Refine Search</h3>
                        <div class="card bg-gray border-0">
                            <div class="card-body p-4">
                                <p class="lead"> Date Range  <sapn class="text-danger">*</sapn></p>
                                <div class="custom-control custom-radio">
                                    <input type="radio" id="today" name="option" class="custom-control-input">
                                    <label class="custom-control-label" for="today">Today</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input type="radio" id="nextDays" name="option" class="custom-control-input">
                                    <label class="custom-control-label" for="nextDays">Next 14 Days</label>
                                </div>
                                <div class="custom-control custom-radio mb-3">
                                    <input type="radio" id="between" name="option" class="custom-control-input">
                                    <label class="custom-control-label" for="between">Choose My Dates</label>
                                </div>
                                <div class="form-group">
                                    <label for="fromDate">From</label>
                                    <input type="date" class="form-control" id="fromDate" name="fromDate">
                                </div>
                                <div class="form-group">
                                    <label for="toDate">To</label>
                                    <input type="date" class="form-control" id="toDate" name="toDate">
                                </div>
                            </div>
                        </div>
                        <div class="card bg-gray border-0 mt-1">
                            <div class="card-body p-4">
                                <div class="form-group">
                                    <label for="group">Donation Type <sapn class="text-danger">*</sapn></label>
                                    <select name="group" class="form-control form-control-lg" id="group">
                                        <option selected>Please select type</option>
                                        <option value="Plazma">Plasma</option>
                                        <option value="Red blood cells">Red blood cells</option>
                                        <option value="Platelets">Platelets</option>
                                        <option value="Blood">Whole blood donation</option>
                                    </select> 
                                </div>
                            </div>
                        </div>
                        <div class="row text-center my-5">
                            <div class="col-sm-6">
                                <button class="btn appointement-btn btn-lg">Refine Results</button>
                            </div>
                            <div class="col-sm-6">
                                <button class="btn appointement-btn btn-lg">Refine Results</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-sm-12 col-md-6">
                    <h3>Center Near To Me</h3>
                    <div class="container">
                        <div class="card mb-3">
                            <div class="card-body">
                                <div class="d-flex justify-content-around">
                                    <h4>Center Rabat Agdal</h4>
                                    <button class="btn appointement-btn">Schedule now</button>
                                </div>
                                <div class="my-3">
                                    <p class="lead"> Adresse adresse ad adres  12, Agdal,  adresse ad adres  12, Agdal, dsfsdfsdfsdfsdfsdfd fsd 
                                        10100, Rabat.</p>
                                </div>
                                <hr>
                                <p class="blood-color"> Friday, 12 Ferbruary 2021 | 08:00 PM - 12:30 PM </p>
                            </div>
                        </div>

                        <div class="card">
                            <div class="card-body">
                                <div class="d-flex justify-content-around">
                                    <h4>Center Rabat Agdal</h4>
                                    <button class="btn appointement-btn">Schedule now</button>
                                </div>
                                <div class="my-3">
                                    <p class="lead"> Adresse adresse ad adres  12, Agdal,  adresse ad adres  12, Agdal, dsfsdfsdfsdfsdfsdfd fsd 
                                        10100, Rabat.</p>
                                </div>
                                <hr>
                                <p class="blood-color"> Friday, 12 Ferbruary 2021 | 08:00 PM - 12:30 PM </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</c:set>

<%@ include file="../layouts/app.view.jsp" %>