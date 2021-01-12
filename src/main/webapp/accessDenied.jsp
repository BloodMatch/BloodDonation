<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "title" scope = "session"> 
    Access Denied
</c:set>

<c:set var = "content" scope = "session"> 
        <section id="home-section">
        	<div class="container text-center">
        		<h1 class="text-danger">Access Denied</h1>
        		<a class="btn btn-blood btn-lg" href="${rootUrl}">Go Back</a>
        	</div>
        </section>
</c:set>

<c:remove var="other"/>

<%@ include file="layouts/app.view.jsp"%>