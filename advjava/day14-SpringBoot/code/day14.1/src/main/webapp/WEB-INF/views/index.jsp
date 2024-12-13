<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Welcome 2 Spring MVC !</h3>
	<h4>
		<c:url var="abc" value="/test/display" />
		<a href="${abc}">Test Model And View</a>
	</h4>
	<h4>
		<c:url var="abc" value="/test/display2" />
		<a href="${abc}">Test Model Map</a>
	</h4>
	<h4>
		<c:url var="abc" value="/categories/display" />
		<a href="${abc}">List All Categories</a>
	</h4>
</body>
</html>