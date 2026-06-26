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

        <%-- Chuyển thẻ script vào trong thẻ head cho đúng chuẩn HTML --%>
        <script type="text/javascript">
            function confirmDelete(id) {
                if (confirm("Do you really want to delete the categories with id = '" + id + "'?")) {
                    window.location = "deleteCategories?id=" + id;
                }
            }
        </script>

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

        <%-- Bổ sung hiển thị thông báo lỗi khi xóa thất bại (ví dụ: dính khóa ngoại) --%>
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
        <h3 style="color: red;"><%= error %></h3>
        <%
            }
        %>

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
                    <%-- Nút Delete: Dùng hàm confirmDelete bằng JavaScript --%>
                    <a href="#" onclick="confirmDelete('<%= c.getId() %>')">
                        <input type="button" value="Delete"/>
                    </a>

                    <%-- Nút Edit: Bỏ thẻ <a> bọc ngoài, dùng trực tiếp onclick chuyển hướng --%>
                    <input type="button" value="Edit" onclick="window.location.href = 'UpdateCategories?id=<%= c.getId() %>'"/>
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

        <%-- Nút Add Categories: Bỏ thẻ <a> bọc ngoài, dùng trực tiếp onclick chuyển hướng --%>
        <input type="button" value="Add Categories" onclick="window.location.href = 'addCategories.jsp'"/>

        <br/><br/>

        <%@ include file="footer.jsp" %>

    </body>
</html>