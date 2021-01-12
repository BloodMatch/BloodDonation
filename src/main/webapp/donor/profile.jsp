<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>
<c:set var="title" scope="session">
	Profile
</c:set>

<c:set var ="content" scope="session">
	<section>
		<div class="container">
			${donor.cin} ${rootUrl}
		</div>
	</section>
</c:set>

<%@ include file="../layouts/app.view.jsp" %>