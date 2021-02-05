<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "pageName" scope = "session"> 
    home
</c:set>

<c:set var = "title" scope = "session"> 
    home
</c:set>

<c:set var = "content" scope = "session"> 
  <h1>CENTER</h1>
</c:set>


<%@ include file="layouts/app.layout.jsp"%>