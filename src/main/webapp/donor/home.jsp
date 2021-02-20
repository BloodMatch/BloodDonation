<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>
<c:set var="title" scope="session">
	Donneur
</c:set>

<c:set var ="content" scope="session">
	<section id="home-donor">
		<div class="container">
			<div class="row justify-content-end">
				<div class="col-sm-12">
					<h1 class="text-white"><strong>GIVE BLOOD</strong></h1>
					<a href="${rootUrl}/donor/menu" class="btn btn-lg appointement-btn mt-3"> Schedule NEW  APPOINTMENT</a>
				</div>
			</div>
		</div>
	</section>
	
	<section class="mt-5">
		<div class="container my-5">
			<h1 class="text-center"> General Information </h1>
			<hr>
			<div class="row my-5 justify-content-center">
				<div class="col-sm-2 col-md-4 col-lg-3">
					<div class="card" style="width: 18rem; height: 23rem;">
					  <img src="assets/donor/home/Blood.jpg" class="card-img-top" alt="About Blood">
					  <div class="card-body">
					    <h5 class="card-title text-center">Learn About Blood</h5>
					    <p class="card-text">Discover blood facts and statistics, and what happens to donated blood.</p>
					    <a href="#" class="btn appointement-btn">Go somewhere</a>
					  </div>
					</div>
				</div>
				<div class="col-sm-2 col-md-4 col-lg-3">
					<div class="card" style="width: 18rem; height: 23rem;">
					  <img src="${rootUrl}/assets/donor/home/Requirements.jpg" class="card-img-top" alt="Requirements for Donation">
					  <div class="card-body">
					    <h5 class="card-title text-center">Eligibility Requirements</h5>
					    <p class="card-text">Learn more about the eligibility requirements for donating blood.</p>
					    <a href="#" class="btn appointement-btn mt-4">Go somewhere</a>
					  </div>
					</div>
				</div>
				<div class="col-sm-2 col-md-4 col-lg-3">
					<div class="card" style="width: 18rem; height: 23rem;">
					  <img src="${rootUrl}/assets/donor/home/Process.jpg" class="card-img-top" alt="Donation Process">
					  <div class="card-body">
					    <h5 class="card-title text-center">Donation Process</h5>
					    <p class="card-text">Learn more about how you can host a blood drive in your area..</p>
					    <a href="#" class="btn appointement-btn mt-4">Go somewhere</a>
					  </div>
					</div>
				</div>
				<div class="col-sm-2 col-md-4 col-lg-3">
					<div class="card" style="width: 18rem; height: 23rem;">
					  <img src="${rootUrl}/assets/donor/home/Contact.jpg" class="card-img-top" alt="Contact Center">
					  <div class="card-body">
					    <h5 class="card-title text-center">Contact Blood Services</h5>
					    <p class="card-text">We'd love to hear from you. Use the form in the link below to contact us.</p>
					    <a href="#" class="btn appointement-btn">Go somewhere</a>
					  </div>
					</div>
				</div>
			</div>			
		</div>
	</section>
</c:set>

<%@ include file="../layouts/app.view.jsp" %>