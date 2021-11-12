<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "pageName" scope = "session"> 
    index
</c:set>

<c:set var = "title" scope = "session"> 
    index
</c:set>

<c:set var = "content" scope = "session"> 
  <h1>INDEX</h1>
</c:set>


<%@ include file="app.jsp"%>