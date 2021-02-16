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
	        <div class="container">
	            <div class="row text-center">
	                <div class="col-sm-12 col-md-4">
	                    <p class="blood-color"> ${appoint.time} </p>
	                </div>
	                <div class="col-sm-12 col-md-4">
	                    ${appoint.donationType}
	                </div>
	                <div class="col-sm-12 col-md-4">
	                    <p class="text-right">Pending <i class="far fa-clock"></i></p>
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
	            <hr>
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