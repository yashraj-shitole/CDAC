<!DOCTYPE html>
<%@page import="java.util.Date"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dynamic</title>
</head>
<body>
	<h1>Hello JSP!</h1>
	<%-- scriptlet: contains java statements --%>
	<% Date now = new Date(); %>
	<p>
	<% out.println(now.toString()); %>
	</p>
	<%-- expression: java expression evaluates to some value
		and its result is added in generated response 
	--%>
	<p>
	<%= now.toString() %>
	</p>
</body>
</html>