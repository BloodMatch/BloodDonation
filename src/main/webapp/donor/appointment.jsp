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
                    <form action="${rootUrl}/donor/schedule" method="POST">
                        <h3>Refine Search</h3>
                        <div class="card bg-gray border-0">
                            <div class="card-body p-4">
                                <p class="lead"> Date Range  <sapn class="text-danger">*</sapn></p>
                                <div id="radioBox">
	                                <div class="custom-control custom-radio">
	                                    <input type="radio" id="today" name="option" value="today" class="custom-control-input" checked>
	                                    <label class="custom-control-label" for="today">Today</label>
	                                </div>
	                                <div class="custom-control custom-radio mb-3">
	                                    <input type="radio" id="dateRadioBox" name="option" value="date" class="custom-control-input">
	                                    <label class="custom-control-label" for="dateRadioBox">Choose My Dates</label>
	                                </div>
	                            </div>
                                <div class="form-group">
                                    <label for="donationDate">Date</label>
                                    <input type="date" class="form-control" id="donationDate" name="donationDate" value="${appoint.dateFiltred}" disabled>
                                </div>
                                <div class="form-group">
                                    <label for="city">City</label>
                                    <select class="form-control form-control-lg" name="city" id="city">
                                        <option value="${donor.city}" selected>${donor.city}</option>
                                        <c:forEach items="${appoint.cities}" var="city">
                                        	<option value="${city}">${city}</option>
                                        </c:forEach>
                                    </select> 
                                </div>
                            </div>
                        </div>
                        <div class="row text-center my-5">
                            <div class="col-sm-6">
                                <button class="btn appointement-btn btn-lg" type="submit">Refine Results</button>
                            </div>
                            <div class="col-sm-6">
                                <button class="btn appointement-btn btn-lg" id="clearForm">Reset Filters</button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-sm-12 col-md-6">
                    <h3>Center Near To Me</h3>
                    <div class="container mb-3">
                    	<div class="row">
                    		<form action="${rootUrl}/donor/schedule/save" method="POST" id="scheduleForm">
	                    		<div class="card bg-gray border-0 mt-1">
		                            <div class="card-body p-4"> 
		                                <div class="form-group">
		                                    <label for="donationType">Donation Type <sapn class="text-danger">*</sapn></label>
		                                    <select name="donationType" class="form-control form-control-lg" id="donationType">
		                                        <option value="Plazma">AB Plasma</option>
		                                        <option value="Red blood cells">Platelets</option>
		                                        <option value="Platelets">Power Red</option>
		                                        <option value="Blood" selected>Blood</option>
		                                    </select> 
		                                </div>
		                                <div class="form-group">
		                                    <input class="form-control form-control-lg" name="centerId" id="centerId" type="hidden">
		                                </div>
		                                 <div class="form-group">
		                                    <input class="form-control form-control-lg" name="donationDate" value="${appoint.dateFiltred }"  type="hidden">
		                                </div>
		                            </div>
		                        </div>
	                        </form>
                    	</div>
                    </div>
                    <div class="container mb-5" id="schedule">
                    	<c:choose>
			        		<c:when test="${ appoint.availableCenters.size() != 0 }">
								<c:forEach items="${appoint.availableCenters}" var="center">
		                    		 <div class="card mb-3" id="${center.id}">
			                            <div class="card-body">
			                                <div class="d-flex justify-content-between">
			                                    <h4>${center.name}</h4>
			                                    <button class="btn appointement-btn submitSchedule">Schedule now</button>
			                                </div>
			                                <div class="my-3">
			                                    <p class="lead"> ${center.address }</p>
			                                    <div class="row justify-content-between">
			                                    	<div class="col-4"><i class="fas fa-phone-alt"></i> ${center.email }</div>
			                                    	<div class="col-4"><i class="fas fa-at"></i> ${center.phone1 }</div>
			                                    	<div class="col-4"><i class="fas fa-at"></i> ${center.phone2 }</div>
			                                    </div>
			                                </div>
			                                <hr>
			                                <p class="blood-color"> ${appoint.dateFiltred } | 09:00 PM - 12:00 PM  and 14:00 PM - 17:00 PM</p>
			                            </div>
			                        </div>
		                    	</c:forEach>
							</c:when>
							<c:otherwise>
								<div class="alert alert-danger mt-5" role="alert">
								   No Appointments are Available, Please choose an other Date !
								</div>
							</c:otherwise>
						</c:choose>
                    	
                    </div>
                </div>
            </div>
        </div>
    </section>
     <script>
      	const radioDate = document.getElementById('radioBox');
      	const dateRadioBox = document.getElementById('dateRadioBox');
      	const input = document.getElementById('donationDate');
      	
     	// container
      	const schedule = document.getElementById('schedule');
      	// form
      	const form = document.getElementById('scheduleForm');
      	const center = document.getElementById('centerId');
      	
      	input.addEventListener('change', function(){
      		form.elements[2].value = input.value;
      	})
      	
    	// disable enable input date if checked
      	radioDate.addEventListener('click', function(e){
      		if(e.target.getAttribute('name') === 'option'){
      			if(dateRadioBox.checked){
      				input.removeAttribute('disabled');
          		}else{
          			form.elements[2].value = "";
          			input.setAttribute('disabled', true);
          		}
      		}
      	});
      	
      	
      	schedule.addEventListener('click', function(e){
      		if(e.target.classList.contains("submitSchedule")){
      			center.value = e.target.parentElement.parentElement.parentElement.id;
      			form.submit();
      		}
      	})
      	
      	
      </script>
</c:set>

<%@ include file="../layouts/app.view.jsp" %>