<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>

	<div style="display: flex; align-items: center; justify-content: center; flex-direction: column;">

	<h2>Thank You</h2>
	<% session.invalidate(); %>
	
	<p>You are successfully logged out.</p>
	
	<p>
	<a href="http://localhost:8080/VotingAppJSP/">Login Again</a>
	</p>
	</div>
</body>
</html>
