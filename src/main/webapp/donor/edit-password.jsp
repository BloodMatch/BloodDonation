<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>
<c:set var="title" scope="session">
	Edit Password
</c:set>

<c:set var ="content" scope="session">
	<section class="profile-section">
            <div class="profile-container">
                <div class="bg-profile"></div>
                <img class="rounded-circle z-depth-2 profile-dyapo" alt="50x50" src="${rootUrl}/assets/avatar.png" data-holder-rendered="true">
                <div class="profile-info">
                    <div class="container">
                    	<h2>Edit Password</h2>
			            <hr>
			            <c:if test="${not empty user.errorMsg}"> 
	                		<div id="alertMsg" class="alert alert-danger alert-dismissible fade show" role="alert">
							  ${user.errorMsg}
							</div>                	
	                	</c:if>
			            <div class="alert alert-danger alert-dismissible fade hide" id="error" role="alert">
						  	<strong>Please enter compatible passwords ! </strong>
						</div> 
	                	<form action="${rootUrl}/donor/password" method="POST" id="changePassword">
                        <div class="row mt-3 justify-content-center">
                             <div class="col-sm-8">
                                 <div class="form-group">
									<label for="password"><i class="fas fa-key"></i> Current Password <sapn class="text-danger">*</sapn></label>
									<input class="form-control" id="password" name="password" type="password" required/>
                                 </div>
                            </div>
                        </div>
                        <div class="row mt-5 justify-content-center">
                             <div class="col-sm-8">
                                 <div class="form-group">
									<label for="newPassword"><i class="fas fa-key"></i> New Password <sapn class="text-danger">*</sapn></label>
									<input class="form-control" id="newPassword" name="newPassword" minlength="5"  type="password" required/>
                                 </div>
                            </div>
                        </div>
                        <div class="row mt-5 justify-content-center">
                             <div class="col-sm-8">
                                 <div class="form-group">
									<label for="confirm"><i class="fas fa-key"></i> Repeat Password <sapn class="text-danger">*</sapn></label>
									<input class="form-control" id="confirm" name="confirm" minlength="5" type="password" required/>
                                 </div>
                            </div>
                        </div>
                         <div class="row mt-5 justify-content-center">
                             <div class="col-sm-12 text-center">
								<input class="btn btn-success" id="submitBtn" value="Save" type="button"/>
                            </div>                            
                        </div>
                        </form>
                    </div>
                </div>
            </div>
            <script type="text/javascript" defer>
            	const form = document.getElementById("changePassword");
            	const submitBtn = document.getElementById("submitBtn"); 
            	const newPassword = document.getElementById("newPassword");
            	const confirm = document.getElementById("confirm");
            	const errorContainer = document.getElementById("error");
            	
            	submitBtn.addEventListener('click', function(){
            		if(confirm.value === newPassword.value){
            			form.submit();
            		}else{
            			errorContainer.classList.remove('hide');
            			errorContainer.classList.add('show');
            		}
            	})
            </script>
      </section>
</c:set>

<%@ include file="../layouts/app.view.jsp" %>