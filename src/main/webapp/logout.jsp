<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<li class="nav-item">
	<form action="${rootUrl}/logout" method="POST"	id="logout-form">
		<a class="nav-link text-white" id="logout-btn" href="${rootUrl}/logout">logout</a>	
	</form>
</li>

<script>
	const btnLogout = document.getElementById('logout-btn');
	btnLogout.addEventListener('click', function(event){
		event.preventDefault();
		document.getElementById('logout-form').submit();
	})
</script>

