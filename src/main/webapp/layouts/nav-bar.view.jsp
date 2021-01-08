<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:set var="guestNav" scope="session">
	<ul class="navbar-nav">
		<li class="nav-item hovred">
			<a class="nav-link text-white" href="${rootUrl}/home">Home</a>
		</li>
		
		<li class="nav-item hovred">
			<a class="nav-link text-white" href="${rootUrl}/faq">FAQ</a>
		</li>
		
		<li class="nav-item hovred">
			<a class="nav-link text-white" href="${rootUrl}/about">About</a>
		</li>
	</ul>
	
	<ul class="navbar-nav">
		<li class="nav-item">
			<a class="btn btn-outline-signIn text-white" href="${rootUrl}/login">Sign in</a>
		</li>
		
		<li class="nav-item">
			<a class="btn btn-signUp text-white" href="${rootUrl }/register">Sign up</a>
		</li>
	</ul>
</c:set>

<c:set var="donorNav" scope="session">
	<ul class="navbar-nav">
		<li class="nav-item hovred">
			<a class="nav-link text-white" href="${rootUrl}/home">Appointments</a>
		</li>
		
		<li class="nav-item hovred">
			<a class="nav-link text-white" href="${rootUrl}/faq">Analyses</a>
		</li>
		
		<li class="nav-item hovred">
			<a class="nav-link text-white" href="${rootUrl}/about">We Need Blood</a>
		</li>
	</ul>
	
	<ul class="navbar-nav">
		<li class="nav-item">
			<a class="btn text-white" href="">${sessionScope.isLoged.firstName} ${sessionScope.isLoged.lastName}</a>
		</li>
		
		<li class="nav-item">
			<a class="btn text-white" href="">${sessionScope.isLoged.role}</a>
		</li>
		<li class="nav-item">
			<%@ include file="../logout.jsp"%>
		</li>
	</ul>
</c:set>

<c:set var="adminNav" scope="session">
	<ul class="navbar-nav">
		<li class="nav-item hovred">
			<a class="nav-link text-white" href="${rootUrl}/home">Appointments</a>
		</li>
		
		<li class="nav-item hovred">
			<a class="nav-link text-white" href="${rootUrl}/faq">Hospitals</a>
		</li>
		
		<li class="nav-item hovred">
			<a class="nav-link text-white" href="${rootUrl}/about">...</a>
		</li>
	</ul>
	
	<ul class="navbar-nav">
		<li class="nav-item">
			<a class="btn text-white" href="">${sessionScope.isLoged.firstName} ${sessionScope.isLoged.lastName}</a>
		</li>
		
		<li class="nav-item">
			<a class="btn text-white" href="">${sessionScope.isLoged.role}</a>
		</li>
		<li class="nav-item">
			<%@ include file="../logout.jsp"%>
		</li>
	</ul>
</c:set>

<header>
    <nav class="navbar navbar-expand-lg navbar-light fixed-top layout-color">
        <div class="container-fluid">
           	<a class="navbar-brand white" href="${rootUrl}/home">
                <img src="./assets/Site-logo.svg" alt="Blood Donation Logo" class="logo"/>
            </a>
          
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mobile" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse justify-content-between" id="mobile">
			<c:choose>
        		<c:when test="${sessionScope.isLoged == null }">
					${guestNav}
				</c:when>
				<c:when test="${sessionScope.isLoged.role == 'donor' }">
					${donorNav}
				</c:when>
				<c:when test="${sessionScope.isLoged.role == 'admin' }">
					${adminNave}
				</c:when>
			</c:choose>
			</div>
        </div>
    </nav>
</header>