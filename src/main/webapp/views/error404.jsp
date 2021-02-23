<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "title" scope = "session"> 
    404
</c:set>

<c:set var = "content" scope = "session"> 
        <br/>
        <h1>404 Error...</h1>
        <div class="starter-template text-center py-5 px-3">
		    <h1>Page Not Found</h1>
		    <p class="lead">The page you are looking for doesn't exist or an other error occured.</p>
		    <p class="">Go back, or head over to <a href="">blood-donation.ma</a> to choose a new direction</p>
		  </div>
</c:set>

<c:remove var="other"/>

<%@ include file="../layouts/app.view.jsp"%>