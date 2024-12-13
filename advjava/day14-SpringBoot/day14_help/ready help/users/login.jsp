<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignIn Page</title>
</head>

<body>
	<h5 align="center" style="color: red;">${requestScope.message}</h5>
	<spring:url var="url" value="/users/login" />
	<form action="${url}" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter User Email</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>