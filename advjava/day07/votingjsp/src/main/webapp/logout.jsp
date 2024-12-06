<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
	<h2>Thank You</h2>
	<% session.invalidate(); %>
	
	<p>You are successfully logged out.</p>
	
	<p>
	<a href="index.jsp">Login Again</a>
	</p>
</body>
</html>
