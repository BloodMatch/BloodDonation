<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>
<c:set var = "title" scope = "session"> 
    register
</c:set>

<c:set var = "content" scope = "session"> 
	<section class="registration-section mt-5">
		<div class="row justify-content-between">
			<div class="col-sm-6 d-none d-lg-block bg-register-page">
				<div class="container left-side">
					<div class="row">
						<blockquote class="blockquote">
							<p class="mb-0"> The Blood You Donate Gives Someone Another Chance At Life. 
								One Day That Someone May Be A Close Relative, 
								A Friend, A Loved One—Or Even You.</p>
						  </blockquote>
					</div>
					<div class="row">
						<p class="lead">Redcrossblood</p>
					</div>
				</div>
			</div>
			<div class="col-8 col-sm-10 col-md-8 col-lg-6 mt-4">
				<div class="container">
					<p class="text-muted steps">STEP 01/02 <br> <strong>Personal Info</strong></p>
				</div>
				<c:if test="${not empty user.errorMsg}"> 
					<div class="container">
	               		<div id="alertMsg" class="alert alert-danger alert-dismissible fade show" role="alert">
						  ${user.errorMsg}
						</div>
					</div>                	
               	</c:if>
				<div class="row justify-content-center align-items-center">
					<div class="col-sm-8">
						<h2>Register Donor Account!</h2>
						<div class="text-muted font-weight-lighter">For the purpose of industry regulation, your details are required.</div>
						<form action="${rootUrl}/register" method="POST">
							<div class="row">
								<div class="col-6">
									<div class="form-group mt-3">
										<label for="firstName">First Name <sapn class="text-danger">*</sapn></label>
										<input type="text" name="firstName" id="firstName" value="${user.rfirstName}" class="form-control" placeholder="First Name" required autofocus>		    
									</div>
								</div>
								<div class="col-6">
									<div class="form-group mt-3">
										<label for="lastName">Last Name<sapn class="text-danger">*</sapn></label>
										<input type="text" name="lastName" id="lastName" value="${user.rlastName}" class="form-control" placeholder="Last Name" required autofocus>		    
									</div>
								</div>
							</div>

							<div class="row my-3">
								<div class="form-group mt-3">
									<label for="email">Email address <sapn class="text-danger">*</sapn></label>
									<input type="email" name="email" id="email" value="${user.remail }" class="form-control" placeholder="Email address" required autofocus>		    
								</div>
							</div>
							<div class="row my-3">
								<div class="form-group mt-3">
									<label for="password">Create password <sapn class="text-danger">*</sapn></label>
									<input type="password" name="passwd" id="password" value="${user.rpassword }" class="form-control" placeholder="Password" required>		    
								</div>
							</div>
			
							<div class="row mt-3">
								<button class="btn btn-blood btn-lg btn-block" type="submit">Save & Continue</button>			    	
							</div>
						</form>
						<div class="text-center my-3">
							<p class="text-musted font-weight-lighter">Already have account ? <a href="#" class="text-decoration-none float-right">Login in</a></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</c:set>

<c:remove var="other"/>

<%@ include file="layouts/app.view.jsp"%>