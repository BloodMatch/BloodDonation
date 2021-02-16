<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:set var = "pageName"> 
    dashboard
</c:set>

<c:set var = "title"> 
    Dashboard
</c:set>

<c:set var = "content"> 
  	<div class="row">
	    <div class="col-md-12">
	        <%@ include file="counter.component.jsp"%>
	    </div>
	    <div class="col-md-5">
	    	<%@ include file="task.component.jsp"%>
	    </div>
	    <div class="col-md-7">
	        <%@ include file="other.component.jsp"%>
		</div>
	</div>
</c:set>


<%@ include file="../app.jsp"%>