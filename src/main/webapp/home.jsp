<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "title" scope = "session"> 
    Home
</c:set>

<c:set var = "content" scope = "session"> 
        <h5>HOME</h5>
</c:set>

<c:set var = "other" scope = "session"> 
    <h6>
    	Blabla
    	Other other
    </h6>
</c:set>

<%@ include file="layouts/app.view.jsp"%>