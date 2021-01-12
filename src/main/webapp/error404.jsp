<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "title" scope = "session"> 
    404
</c:set>

<c:set var = "content" scope = "session"> 
        <section class="mt-5 center-content">
        	<div class="container">
        		<h1> Error 404</h1>
        		<a class="btn btn-success btn-lg" href="${rootUrl}">Go Back</a>
        	</div>
        </section>
</c:set>

<c:remove var="other"/>

<%@ include file="layouts/app.view.jsp"%>