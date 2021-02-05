<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="root" value="${pageContext.request.contextPath}/" />
<html>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>${title} page</title>
        <base href="${root}" />
        <%@ include file="header.layout.jsp"%>
    </head>
	
	<body>
    <div class="wrapper">
        <!-- SideBar -->
       	<%@ include file="side-bar.layout.jsp"%>
        <!-- End SideBar -->

        <div class="main-panel">
            <!-- Navbar -->
            <%@ include file="nav-bar.layout.jsp"%>
            <!-- End Navbar -->

            <!-- Content -->
            <div class="content">
                <div class="container-fluid">
                    <div class="section">
                        ${content}
                    </div>
                </div>
            </div>
            <!-- End Content -->

            <!-- Footer -->
           	<%@ include file="footer.layout.jsp"%>
            <!-- End Footer -->

        </div>

    </div>

</body>

</html>