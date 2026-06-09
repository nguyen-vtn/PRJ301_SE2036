<%-- 
    Document   : login
    Created on : 29 thg 5, 2026, 13:54:06
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

        <div>Login form</div>
        <%
           //String error = request.getParameter("error");
           String error = (String) request.getAttribute("error");
           error = error == null ? "" : error;

           String username = request.getParameter("username");
           username = username == null ? "" : username;

           String password = request.getParameter("password");
           password = password == null ? "" : password;
        %>

        <p style="color: red"><%=error%></p><br/>

        <form action="login" method="post">
            Username:
            <input id="inputName" type="text" name="username" value="<%=username%>"><br/>

            Password:
            <input id="inputPass" type="password" name="password" value="<%=password%>"><br/>

            <input id="btnSubmit" type="submit" value="Login">
            <input id="btnReset" type="reset" value="Reset">
            <%@include file = "footer.jsp" %>
        </form>
    </body>
</html>