<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>
<c:set var = "title" scope = "session"> 
    login
</c:set>

<c:set var = "content" scope = "session"> 
         
	<section class="login-section">
        <div class="container mt-5">
            <div class="row justify-content-around login-container">
                <div class="col-sm-4 d-none d-lg-block bg-login-page">
                    <!-- bg image -->
                </div>
                <div class="col-8 col-sm-10 col-md-8 col-lg-5">
                	<c:if test="${user.error}"> 
                		<div id="alertMsg" class="alert alert-danger alert-dismissible fade show" role="alert">
						  ${user.errorMsg}
						</div>                	
                	</c:if>
                    <div class="row">
                        <div class="text-muted font-weight-lighter">Hey dear Blood Donor, Welcome back!</div>
                        <h2>Login to your account</h2>
                        <form action="${rootUrl}/login" method="POST">
                            <div class="row my-3">
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" name="email" id="email" value="${user.email}" class="form-control" placeholder="Email address" required autofocus>		    
                                </div>
                            </div>
                            <div class="row my-3">
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" name="passwd" id="password" class="form-control" placeholder="Password" required>		    
                                </div>
                            </div>
            
                            <div class="row justify-content-between my-3">
                                <div class="col-sm-6">
                                    <div class="checkbox">
                                        <label>
                                          <input type="checkbox" name="rememberme" value="remember-me"> Remember me
                                        </label>
                                    </div>		
                                </div>
                                <div class="col-sm-6 go-right">
                                    <a class="text-decoration-none" href="#forgotPassword!">Forgot Password ?</a>
                                </div>
                            </div>
                            <div class="row">
                                <button class="btn btn-blood btn-lg btn-block" type="submit">Login now</button>			    	
                            </div>
                        </form>
                        <div class="text-center my-3">
                            <p class="text-musted font-weight-lighter">Dont have an account ? <a href="#" class="text-decoration-none float-right">Register Now</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</section>
    
</c:set>

<%@ include file="layouts/app.view.jsp"%>