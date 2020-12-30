<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "title" scope = "session"> 
    Gallery
</c:set>

<c:set var = "content" scope = "session"> 
        <h5>GALLERY</h5>
</c:set>

<c:remove var="other"/>

<%@ include file="layouts/app.view.jsp"%>