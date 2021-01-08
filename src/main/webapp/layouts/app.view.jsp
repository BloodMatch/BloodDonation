<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>${title} page</title>
        <%@ include file="header.view.jsp"%>
    </head>
	<body>
		<c:set var="rootUrl" value="${pageContext.request.contextPath}"/>
	    <%@ include file="nav-bar.view.jsp"%>
	    <main>
			
			${content}
			
		</main>
	    <%@ include file="footer.view.jsp"%>
	</body>
</html>