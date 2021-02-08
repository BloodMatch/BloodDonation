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
	
	<section class="mt-4">
		<div class="container">
			<h2>Hey ${user.firstName} welcome back !</h2>			
		</div>
	</section>
</c:set>

<%@ include file="../layouts/app.view.jsp" %>