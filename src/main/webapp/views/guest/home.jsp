<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>
<c:set var = "title" scope = "session"> 
    Home
</c:set>

<c:set var = "content" scope = "session"> 
		<section id="home-section">
			<div class="container">
                <div class="col-sm-4">
                    <h1 class="text-white"><strong>BLOOD <br> DONATION</strong></h1>
                    <p class="lead text-white">Give Blood <i class="fas fa-tint text-white"></i> Save Live</p>
                </div>
	          <c:choose>
	           <c:when test="${empty sessionScope.isLoged}">
	                <div class="d-flex">
	                       <a class="btn btn-landing-blood btn-lg" href="${rootUrl}/login">Sign in</a>
	                       <a class="btn btn-outline-landing-blood btn-lg" href="${rootUrl}/register">Sign up</a>
	                </div>
               </c:when>
               <c:otherwise>
	                 <div>
	                     <a class="btn btn-landing-blood btn-lg" href="${rootUrl}/${sessionScope.isLoged.role}/home">Dashboard</a>
	                </div>
               </c:otherwise>
             </c:choose>	
	        </div>
		</section>
        <section class="mt-5">
        	<div class="container">
        		<div class="row">
        			<div class="col-sm-4">
        				<div class="card mb-3">
						  
						  <div class="card-body">
						    <h5 class="card-title">Card title</h5>
						    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
						    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
						  </div>
						</div>
        			</div>
        			<div class="col-sm-4">
        				<div class="card mb-3">
						  
						  <div class="card-body">
						    <h5 class="card-title">Card title</h5>
						    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
						    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
						  </div>
						</div>
        			</div>
        			<div class="col-sm-4">
        				<div class="card mb-3">
						  
						  <div class="card-body">
						    <h5 class="card-title">Card title</h5>
						    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
						    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
						  </div>
						</div>
        			</div>
        		</div>
        	</div>
        </section>
        
        <section class="mt-5 bg-coled-blood">
        	<div class="container">
        		<div class="row">
        			<div class="col-sm-6">
        				
						<!-- image -->
        			</div>
        			
        			<div class="col-sm-6 py-3">
        				<h2>Contact Us</h2>
        				<div class="container">
	        				<div class="form-group">
							    <label for="email">Adresse mail</label>
							    <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="exemple@exp.com">
							 </div>        				
	        				
							 <div class="from-group">
							 	 <label for="message">Message</label>
							  	<textarea class="form-control" id="message"  rows="text" cols=""></textarea>						 
							 </div>        				
        				</div>
        			</div>
        		</div>
        	</div>
        </section>
</c:set>

<%@ include file="../app.jsp"%>