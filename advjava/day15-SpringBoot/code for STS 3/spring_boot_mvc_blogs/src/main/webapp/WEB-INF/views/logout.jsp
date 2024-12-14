<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h5>Hello , ${requestScope.details.firstName}
		${requestScope.details.lastName}</h5>
	<h6>You have logged out n will be be redirected to login page
		shortly....</h6>
</body>
</html>