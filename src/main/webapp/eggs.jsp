<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "title" scope = "session"> 
    eggs
</c:set>

<c:set var = "content" scope = "session"> 
        EGGG
</c:set>

<c:remove var="other"/>

<%@ include file="layouts/app.view.jsp"%>