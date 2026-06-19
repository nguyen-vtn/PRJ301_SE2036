<%-- 
    Document   : listCategories
    Created on : Jun 16, 2026, 4:33:19 PM
    Author     : LENOVO
--%>

<%@page import="java.util.Map"%>
<%@page import="model.Categories"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Categories List</title>
        <style>
            table {
                width: 50%;
                border-collapse: collapse;
                margin-top: 15px;
            }
            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }
            th {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <h1>Categories List</h1>

        <%
            Map<Integer, Categories> listC = (Map<Integer, Categories>) request.getAttribute("listC");
        %>

        <%
            if (listC == null || listC.isEmpty()) {
        %>

        <h3 style="color: red;">No categories data found!</h3>

        <%
            } else {
        %>

        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Action</th>
            </tr>

            <%
                for (Categories c : listC.values()) {
            %>

            <tr>
                <td><%= c.getId() %></td>
                <td><%= c.getName() %></td>
                <td>
                    <a href="#"><input type="button" value="Delete"/></a>
                    <a href="updateCategories?id=<%= c.getId() %>">
                        <input type="button" value="Edit"/>
                    </a>
                </td>
            </tr>

            <%
                }
            %>

        </table>

        <%
            }
        %>

        <br/>

        <a href="addCategories.jsp">
            <input type="button" value="Add Categories"/>
        </a>

        <br/><br/>

        <%@ include file="footer.jsp" %>

    </body>
</html>