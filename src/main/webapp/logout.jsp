<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>

<form action="${rootUrl}/donor/logout" method="POST" id="logout-form">
	<button class="dropdown-item" id="logout-btn" type="submit"><i class="fas fa-sign-out-alt"></i>logout</button>	
</form>

