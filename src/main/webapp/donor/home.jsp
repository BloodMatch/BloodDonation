<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var="title" scope="session">
	Donneur
</c:set>

<c:set var ="content" scope="session">
	<section  class="first-section">
		<div class="container">
			<h2>Hey ${user.firstName} welcome back !</h2>			
		</div>
	</section>
	
</c:set>

<%@ include file="../layouts/app.view.jsp" %>