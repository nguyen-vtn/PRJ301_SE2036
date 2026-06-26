<%-- 
    Document   : updateCategories
    Created on : 26 thg 6, 2026, 13:50:17
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
        <h1>Update Categories</h1>
        <%
            Categories c = (Category)request.getAttribute("Categories");
            if (c==null){
            response.sendRedirect("listCategories");
            }
            else {
            ArrayList<String> error = (ArrayList<String>request.getAttribute("error"));
            if (error != null && error.size()>0){
            for (String e : error){
        %>
        <p style="color: red"><%=e%></p>
        <%
        }
        }
        %>
        <form id ="formUpdate" action="updateCategories" method="post">
            <table>
                <tr>
                    <td>ID: </td>
                    <td><input readonly type="number" name="id" value="<%c.getId()%>"/></td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td><input request type="text" name="name" value="<%=c.getName()%>"/></td>
                </tr>
            </table>
            <input type="submit" name="Update"/>
        </form>
        }
        %>
    </body>
</html>