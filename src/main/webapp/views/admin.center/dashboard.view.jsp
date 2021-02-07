<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>

<c:set var = "pageName" scope = "session"> 
    dashboard
</c:set>

<c:set var = "title" scope = "session"> 
    Dashboard
</c:set>

<c:set var = "content" scope = "session"> 
  <h1>DashBoard</h1>
</c:set>


<%@ include file="app.jsp"%>