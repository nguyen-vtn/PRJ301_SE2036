<%-- 
    Document   : first
    Created on : 29 thg 5, 2026, 13:10:30
    Author     : VuongNguyen _ HE191013
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>

<!DOCTYPE html>

<%!  
    // chỉ khai báo
    int count = 0;

    public double tinhTong(double x, double y){
         return x+y; 
    }

    // count = tinhTong(10,2.3); -> Lỗi vì đây không phải lệnh khai báo
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            int x = 10;
            x++;
            out.println("x = " + x + "<br/>");

            count++;
            out.println("count = " + count + "<br/>");

            Date d = new Date();
            out.println("Hom nay la: " + d + "<br/>");

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            out.println("Hom nay la: " + dateFormat.format(d) + "<br/>");
        %>

        <!-- 
        Đây là comment html
        <%
            x = x+10;
        %>
        -->

        <%--
        Đây là comment jsp
        <%
        x = x+10
        --%>

        x = <%=x%> <br/>
        Tổng của 2.5 và 3.5 bằng <%=tinhTong(2.5,3.5)%> <br/>
    </body>
</html>