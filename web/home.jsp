<%-- 
    Document   : home
    Created on : 5 thg 6, 2026, 13:14:09
    Author     : VuongNguyen _ HE191013
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file = "menu.jsp" %>

        <%
            int y = 20;
        %>
        <h1>Đây là trang home.</h1>
        <%@include file="includePage.jsp" %>
        <p>
            Hello SE2036.

        </p>
        <%-- <jsp:include page="includePage.jsp" /> --%>
        <%@include file = "footer.jsp" %>


    </body>
</html>