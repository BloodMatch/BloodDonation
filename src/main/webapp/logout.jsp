<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>

<form action="${rootUrl}/logout" method="GET"	id="logout-form">
	<a class="dropdown-item" id="logout-btn" href="${rootUrl}/logout"><i class="fas fa-sign-out-alt"></i>logout</a>	
</form>

<script>
	const btnLogout = document.getElementById('logout-btn');
	btnLogout.addEventListener('click', function(event){
		event.preventDefault();
		document.getElementById('logout-form').submit();
	})
</script>

