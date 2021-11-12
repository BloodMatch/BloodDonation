<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>
<c:set var="title" scope="session">
	Manage Appointment
</c:set>

<c:set var ="content" scope="session">
    <section class="first-section">
        <div class="container">
            <h2>Manage Appointment </h2>
            <div class="text-muted font-weight-lighter">Reschedule, cancel</div>
            <hr>
        </div>
        <c:if test="${not empty appoint}">
        	<c:if test="${not empty appoint.errorMsg}">
            	<div class="container">
	         		<div class="row justify-content-center">
	         			<div class="alert alert-danger" role="alert">
						  	${appoint.errorMsg}
						</div>
	         		</div>
         		</div>
            </c:if>
	        <div class="container">
	            <div class="row text-center">
	                <div class="col-sm-12 col-md-4">
	                    <p class="blood-color lead"> ${appoint.date} ${appoint.time} </p>
	                </div>
	                <div class="col-sm-12 col-md-4">
	                    <img src="${rootUrl}/assets/icons/blood-type/${appoint.donationType}.svg" width="15" title="${appoint.donationType}" alt="-"> <span class="lead"> ${appoint.donationType} </span>
	                </div>
	                <div class="col-sm-12 col-md-4">
	                    <p class="lead text-right"> 
							<c:choose>
                             	<c:when test="${appoint.state == 'Pending' }">
                             	 	<i class="fas fa-circle"></i>
                             	</c:when>
                             	<c:when test="${appoint.state == 'Canceled' }">
                             		<i class="fas fa-circle text-danger"></i>
                             	</c:when>
                             	<c:when test="${appoint.state == 'Fulfilled' }">
                             		<i class="fas fa-circle text-success"></i>
                             	</c:when>
                             	<c:when test="${appoint.state == 'Arrived' }">
                             		<i class="fas fa-circle text-primary"></i>
                             	</c:when>
                             	<c:when test="${appoint.state == 'Booked' }">
                             		<i class="fas fa-circle text-warning"></i>
                             	</c:when>
                             </c:choose>
                             ${appoint.state}
						 </p>
	                </div>
	            </div>
	        </div>
	        <div class="container">
	            <div class="row align-items-center">
	                <div class="col-sm-12 col-md-8">
	                    <div class="card p-3">
	                        <div class="card-body">
	                            <div class="row align-items-center">
	                                <div class="col-1">
	                                    <i class="fas fa-hospital blood-color fa-3x"></i>
	                                </div>
	                                <div class="col-7">
	                                    <h4> ${center.name } </h4>
	                                    <p class="lead text-left"> ${center.address} </p>
	                                </div>
	                                <div class="col-3">
	                                    <p><i class="fas fa-at"></i> ${center.email}</p>
	                                    <p><i class="fas fa-phone-alt"></i> ${center.phone1}</p>
	                                    <p><i class="fas fa-phone-alt"></i> ${center.phone2}</p>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                <div class="col-sm-12 col-md-4">
	                    <form action="${rootUrl}/donor/schedule/cancal" method="Post">
	                        <div class="card bg-gray border-0 mb-3">
	                            <div class="card-body text-center">
	                                <h1 class="display-1">${appoint.daysLeft}</h1>
	                                <p class="text-muted">Days left</p>
	                            </div>
	                            <input type="hidden" name="appointId" value="${appoint.id }">
	                            <button type="submit" class="btn btn-block btn-blood mt-3">Cancel Appointment </button>
	                        </div>  
	                    </form>
	                </div>
	            </div>
	        </div>
         <div class="container mt-5">
       		<h3>Reschedule your Appointment </h3>
       		<hr>
         	<form action="${rootUrl}/donor/reschedule" method="POST" id="form">
         		<div class="row justify-content-around align-items-center mt-4">
		         	<input type="hidden" name="appointId" value="${appoint.id}" required class="form-control"/>         			
	         		<div class="col-sm-3">
	         			<div class="form-group">
		         			<label for="date">Date <span class="text-danger">*</span></label>
		         			<input type="date" name="date" id="date" value="${appoint.date}" required class="form-control"/>         			
	         			</div>
	         		</div>
	         		<div class="col-sm-3">
	         			<div class="form-group">
		         			<label for="time">Time <span class="text-danger">*</span></label>
		         			<input type="time" name="time" id="time" value="${appoint.time }" required class="form-control"/>         			
	         				<span class="text-danger d-none">Not a valid time (09:00-12:00 | 14:00-18:00)</span>
	         			</div>
	         			<script>
	         				const time = document.getElementById('time');
	         				const form = document.getElementById('form');
	         				time.addEventListener('change', function(){
	         					time.value = time.value.split(':')[0]+':00:00';
	         				});
	         				
	         				form.addEventListener('submit', function(e){
	         					e.preventDefault();
	         					let hour = time.value.split(':')[0];
	         					if((hour>8 && hour<12) || (hour>13 && hour<18)){
	         						time.nextElementSibling.classList.add('d-none');
	         						form.submit();
	         					}else{
	         						time.nextElementSibling.classList.remove('d-none');
	         					}
	         				});
	         				
	         			</script>
	         		</div>
	         		<div class="col-sm-3">
	         			<div class="form-group">
		         			<input type="submit" value="submit" class="btn px-5 appointement-btn"/>        			
	         			</div>
	         		</div>         	
         		</div>
         	</form>
         </div>
         </c:if>
         <c:if test="${empty appoint}">
         	<div class="container">
         		<div class="row justify-content-center">
         			<div class="alert alert-danger" role="alert">
					  	No Appointment scheduled to Manage ! 
					</div>
         		</div>
         	</div>
         </c:if>
         <div class="container m-5">
             <div class="row justify-content-center">
                 <div class="col-sm-12 col-md-6 d-flex justify-content-around">
                     <i class="fas fa-clock mr-4 fa-2x blood-color"></i> 
                     <h3>View Past Donations</h3>
                     <a href="${rootUrl}/donor/history"  class="btn bg-gray"><i class="fas fa-angle-down fa-2x"></i></a>
                 </div>
             </div>
         </div>
    </section>
</c:set>

<%@ include file="../layouts/app.view.jsp" %>