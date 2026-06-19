<%-- 
    Document   : addCategories
    Created on : 19 thg 6, 2026, 13:48:19
    Author     : VuongNguyen _ HE191013
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Categories</title>
    </head>
    <body>

        <h1>Add Categories</h1>

        <%
            ArrayList<String> error = (ArrayList<String>) request.getAttribute("error");

            if (error != null) {
                for (String e : error) {
        %>

        <p style="color:red"><%=e%></p>

        <%
                }
            }

            String id = request.getParameter("id");
            String name = request.getParameter("name");

            id = (id == null) ? "" : id;
            name = (name == null) ? "" : name;
        %>

        <form action="addCategories">
            <table>

                <tr>
                    <td>ID:</td>
                    <td>
                        <input type="number" min="1" id="id" name="id" value="<%=id%>"/>
                    </td>
                </tr>

                <tr>
                    <td>Name:</td>
                    <td>
                        <input type="text" id="name" name="name" value="<%=name%>"/>
                    </td>
                </tr>

                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="Add"/>
                        <input type="reset" value="Reset"/>
                    </td>
                </tr>

            </table>
        </form>

    </body>
</html>