<%-- 
    Document   : addCategories
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Category</title>
        <style>
            form {
                width: 350px;
                margin-top: 15px;
            }
            label {
                display: block;
                margin-top: 10px;
                font-weight: bold;
            }
            input[type="text"] {
                width: 100%;
                padding: 6px;
                box-sizing: border-box;
            }
            .error {
                color: red;
                font-weight: bold;
            }
            button {
                margin-top: 15px;
                padding: 8px 16px;
            }
        </style>
    </head>
    <body>
        <h1>Add Category</h1>

        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
        <p class="error"><%= error %></p>
        <%
            }
        %>

        <form action="addCategories" method="post">
            <label for="id">ID</label>
            <input type="text" id="id" name="id"
                   value="<%= request.getAttribute("id") != null ? request.getAttribute("id") : "" %>" />

            <label for="name">Name</label>
            <input type="text" id="name" name="name"
                   value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : "" %>" />

            <button type="submit">Add</button>
        </form>

        <br/><br/>
        <a href="listCategories">Back to list</a>
    </body>
</html>
