<%-- 
    Document   : inputPage
    Created on : 5 thg 6, 2026, 13:13:34
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
        <h1>Đây là trang include</h1>
        <%
            if (request.getParameter("x") != null){
            out.println("x= " + request.getParameter("x") + "<br/>");
            }
        %>
        y = <%=y%> <br/> 
    </body>
</html>