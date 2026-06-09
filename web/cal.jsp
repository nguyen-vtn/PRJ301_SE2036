<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Double result = (Double) request.getAttribute("result");
    String error = (String) request.getAttribute("error");
    String op = (String) request.getAttribute("op");
    String x = request.getParameter("x");
    String y = request.getParameter("y");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file = "menu.jsp" %>
        <h1>Calculate</h1>
        <form action="calJsp" method="post"><br/>
            X = <input id="x" name="x" type="text"/><br/><br>
            Y = <input id="y" name="y" type="text"/><br/><br>
            <select name="operator">
                <option value="add">Add (+)</option>
                <option value="sub">Subtract (-)</option>
                <option value="mul">Multiply (*)</option>
                <option value="div">Divide (/)</option>
            </select><br/><br>
            <input type="submit" value="Calculate">
        </form>
        <%
            if (result != null) {
        %>

        <h3>
            <%= x%> <%= op%> <%= y%> = <%= result%>
        </h3>

        <%
            }
        %>

        <%
            if (error != null) {
        %>

        <p style="color:red">
            <%= error%>
        </p>

        <%
            }
        %>
        <%@include file = "footer.jsp" %>
    </body>
</html>
