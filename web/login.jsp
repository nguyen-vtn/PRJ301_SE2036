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
        <form action="login" method="post">
            Username:
            <input type="text" name="username"><br/>

            Password:
            <input type="password" name="password"><br/>

            <input type="submit" value="Login">
            <input type="reset" value="Reset">
    </form>
</body>
</html>