<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>
<c:set var="title" scope="session">
	Edit Profile
</c:set>

<c:set var ="content" scope="session">
	<section class="profile-section">
            <div class="profile-container">
                <div class="bg-profile"></div>
                <img class="rounded-circle z-depth-2 profile-dyapo" alt="50x50" src="${rootUrl}/assets/avatar.png" data-holder-rendered="true">
                <div class="profile-info">
                    <div class="container">
                    	<h2>Edit profile</h2>
                    	<div class="text-muted font-weight-lighter">Some profile informations can be changed only by contacting administrator</div>
			            <hr>
			            <c:if test="${not empty user.errorMsg}"> 
	                		<div id="alertMsg" class="alert alert-danger alert-dismissible fade show" role="alert">
							  ${user.errorMsg}
							</div>                	
	                	</c:if>
	                	<form action="${rootUrl}/donor/profile/edit" method="POST">
                        <div class="row mt-5">
                            <div class="col-md-4 col-sm-6">
                                 <div class="form-group">
									<label for="cin"><i class="fas fa-id-card"></i> Cin </label>
									<input class="form-control" placeholder="${donor.cin}" disabled/>
                                 </div>
                            </div>
                             <div class="col-md-4 col-sm-6">
                                 <div class="form-group">
									<label for="firstName">First Name <sapn class="text-danger">*</sapn></label>
									<input class="form-control" id="firstName" name="firstName" value="${user.firstName}" type="text" required/>
                                 </div>
                            </div>
                             <div class="col-md-4 col-sm-6">
                                 <div class="form-group">
									<label for="lastName">Last Name <sapn class="text-danger">*</sapn></label>
									<input class="form-control" id="lastName" name="lastName" value="${user.lastName}" type="text" required/>
                                 </div>
                            </div>
                        </div>
                        <div class="row mt-5">
                            <div class="col-md-4 col-sm-6">
                                 <div class="form-group">
									<label for="group"><i class="fas fa-tint text-danger"></i> Blood Type </label>
									<input class="form-control" placeholder="${donor.group}" disabled/>
                                 </div>
                            </div>
                             <div class="col-md-4 col-sm-6">
                                 <div class="form-group">
									<label for="email"><i class="fas fa-at"></i> Email <sapn class="text-danger">*</sapn></label>
									<input class="form-control" id="email" name="email" value="${user.email}" type="email" required/>
                                 </div>
                            </div>
                             <div class="col-md-4 col-sm-6">
                                 <div class="form-group">
									<label for="phone"><i class="fas fa-phone-alt"></i> phone <sapn class="text-danger">*</sapn></label>
									<input class="form-control" id="phone" name="phone" value="${user.phone}" type="tel" required/>
                                 </div>
                            </div>
                        </div>
                        <div class="row mt-5">
                            <div class="col-md-4 col-sm-6">
                                 <div class="form-group">
									<label for="birthday"><i class="fas fa-calendar-day"></i> Birthday <sapn class="text-danger">*</sapn></label>
									<input class="form-control" id="birthday" name="birthday" value="${donor.birthDay}" type="date" required/>
                                 </div>
                            </div>
                             <div class="col-md-4 col-sm-6">
                                 <div class="form-group">
									<label for="city"><i class="fas fa-map-marker-alt"></i> City <sapn class="text-danger">*</sapn></label>
									<input class="form-control" id="city" name="city" value="${donor.city}" type="text" required/>
                                 </div>
                            </div>
                             <div class="col-md-4 col-sm-6">
                                 <div class="form-group">
									<label for="zipCode"><i class="fas fa-home"></i> Zip code <sapn class="text-danger">*</sapn></label>
									<input class="form-control" id="zipCode" name="zipCode" value="${donor.zipCode}" type="number" required/>
                                 </div>
                            </div>
                        </div>
                        <hr>
                         <div class="row justify-content-between">
                         	<div class="col-md-2 col-sm-6 text-center">
                                 <a href="${rootUrl}/donor/profile" class="btn btn-light">Cancel</a>
                            </div>
                             <div class="col-md-2 col-sm-6 text-center">
								<input class="btn btn-success" value="Save" type="submit"/>
                            </div>                            
                        </div>
                        </form>
                    </div>
                </div>
            </div>
      </section>
</c:set>

<%@ include file="../layouts/app.view.jsp" %>