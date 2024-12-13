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
	<c:set var="user" value="....." />
	<h5 align="center">${requestScope.message}</h5>
	<h5>Hello ${user.role} , ${user.firstName} ${user.lastName}</h5>
	<table style="background-color: lightgrey; margin: auto" border="1">
		<caption>All Blog Posts</caption>
		<tr>
			<th>BlogPost ID</th>
			<th>Last Updated</th>
			<th>Title</th>
			<th>Description</th>
			<th>Action</th>
			<th>Action</th>
		</tr>
		<c:forEach var="post" items="add here">
			<tr>
				<td>...</td>
				<td>...</td>
				<td>...</td>
				<td>...</td>
				<c:choose>
					<c:when test="...">
						<td><a href="Delete Link"></a></td>
						<td><a href="Update Link" /></a></td>
					</c:when>
				</c:choose>
			</tr>
		</c:forEach>
	</table>
	<h5>
		<c:url var="url" value="/user/logout" />
		<a href="${url}">Log Me Out</a>
	</h5>

</body>
</html>