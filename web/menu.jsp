<%-- 
    Document   : menu
    Created on : 5 thg 6, 2026, 13:33:35
    Author     : VuongNguyen _ HE191013
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/myStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id ="menu">
            <a href="<%=request.getContextPath()%>/login.jsp">Login</a>
            <a href="<%=request.getContextPath()%>/cal.jsp">Calculate</a>
            <a href="<%=request.getContextPath()%>/home.jsp">Home</a>
            <a href="<%=request.getContextPath()%>/listStudent">List Student</a>

        </div>

    </body>
</html>