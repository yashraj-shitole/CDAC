<%@ page language="java" %>
<%@ page contentType="text/html" import="java.util.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hello</title>
</head>
<body>
    <!-- HTML comment -->
    <%-- JSP comment --%>
    <%!
        int count = 0; // fields
        // methods
        public void jspInit() {
            System.out.println("jspInit() called...");
        }
        public void jspDestroy() {
            System.out.println("jspDestroy() called...");
        }
    %>
    <h1>Hello JSP!</h1>
    <% 
        Date now = new Date();
        out.println(now.toString());
    %>
    <% count++; %>
    <h3>Count = <%= count %></h3>
</body>
</html>
