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
            if(list == null || list.sie() == 0{
            out.println("Empty list of Students <br/>")
            } else {
        %>
        <table border="1px solid black">
            <tr>
                <td>ID</td>
                <td>Name</td>

                <td>GPA</td>
                <%
                    for (Student s:List){
                %>
            <tr>
                <td><%=s.getId()%></td>
                <td><%=s.getName()%></td>

                <td><%=s.getGpa()%></td>

            </tr>
            <%
            }

        </tr>
    </table>

    }
    for (Student s : list){
    out.println(s + "<br/>");
    }
    %>
    <%@include file="footer.jsp" %>

</body>
</html>