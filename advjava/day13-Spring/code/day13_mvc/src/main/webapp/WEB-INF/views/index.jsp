<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<h4>Welcome to Spring MVC!</h4>
	<h5>
		<c:url var="abc" value="/test/test1" />
		<a href="${abc}">Test Model And View</a>
	</h5>
</body>
</html>