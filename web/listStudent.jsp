<%-- 
    Document   : listStudent
    Created on : 5 thg 6, 2026, 14:19:02
    Author     : VuongNguyen _ HE191013
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Student"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>List Student</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <h2>Student List</h2>
        <%
            ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("listS");
            for (Student s : list){
            out.println(s + "<br/>");
            }
        %>
        <%@include file="footer.jsp" %>

    </body>
</html>