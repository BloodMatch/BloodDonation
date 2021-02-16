<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>
<c:set var="title" scope="session">
	Profile
</c:set>

<c:set var ="content" scope="session">
	<section class="profile-section">
            <div class="profile-container">
                <div class="bg-profile"></div>
                <img class="rounded-circle z-depth-2 profile-dyapo" alt="50x50" src="${rootUrl}/assets/avatar.png" data-holder-rendered="true">
                <div class="profile-info">
                    <div class="bar"></div>
                    <div class="container">
                        <div class="row">
                           <h2>${user.firstName} ${user.lastName}</h2>
                           <div class="row mt-4 text-center">
                               <div class="col-sm-8">
                                    <h5 class="d-flex justify-content-between mb-5"> <i class="fas fa-id-card"></i> ${donor.cin } </h5>
                                    <h5 class="d-flex justify-content-between mb-5"> <i class="fas fa-at"></i> ${user.email } </h5>
                                    <h5 class="d-flex justify-content-between mb-5"> <i class="fas fa-phone-alt"></i> ${user.phone } </h5>
                                    <h5 class="d-flex justify-content-between mb-5"> <i class="fas fa-calendar-day"></i> ${donor.birthDay } </h5>
                                    <h5 class="d-flex justify-content-between mb-5"> <i class="fas fa-venus-mars"></i>
                                    	<c:choose>
							        		<c:when test="${donor.gender == 'M' }">
												Male
											</c:when>
											<c:when test="${donor.gender== 'F' }">
												Female
											</c:when>
										</c:choose>
                                    </h5>
                                    <h5 class="d-flex justify-content-between mb-5"> <i class="fas fa-map-marker-alt"></i> ${donor.city } </h5>
                                    <h5 class="d-flex justify-content-between mb-3"> <i class="fas fa-home"></i> ${donor.zipCode } </h5>
                               </div>
                               <div class="col-sm-4">
                                   <div class="row mb-5">
                                   		 <h5>
                                   		 	<i class="fas fa-tint text-danger"></i> ${donor.group }
                                   		 </h5>
                                   </div>
                                   <div class="row mb-5 justify-content-end">
                                   		<div class="col-10">
	                                   		<a href="${rootUrl}/donor/profile/edit" class="btn btn-success"><i class="fas fa-edit"></i> Edit profile</a>                                   		
                                   		</div>
                                   </div>
                                   <div class="row mb-5 justify-content-end">
                                   		<div class="col-10">
	                                   		<a href="${rootUrl}/donor/password" class="btn btn-primary"><i class="fas fa-key"></i> Change password</a>                                   		
                                   		</div>
                                   </div>
                               </div>
                           </div>
                        </div>
                    </div>
                </div>
            </div>
      </section>
</c:set>

<%@ include file="../layouts/app.view.jsp" %>