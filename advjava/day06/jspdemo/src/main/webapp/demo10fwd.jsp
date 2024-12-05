<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forwarding</title>
</head>
<body>
	<h2>Forwarded Page</h2>
	<p>
		The request is forwarded from demo10.jsp to this page.
	</p>
	<p>
		Roll: <%= request.getParameter("roll") %> <br/><br/>
		Name: <%= request.getParameter("sname") %> <br/><br/>
		Course: <%= request.getParameter("course") %> <br/><br/>
	</p>
</body>
</html>