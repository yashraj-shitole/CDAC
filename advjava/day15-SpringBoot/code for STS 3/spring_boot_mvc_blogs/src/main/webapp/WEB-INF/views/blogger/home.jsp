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
<h5 align="center">${requestScope.mesg}</h5>
	<c:set var="user" value="${sessionScope.user_details}" />
	<h5 align="center">Welcome , ${user.role}</h5>
	<h5>Hello , ${user.firstName} ${user.lastName}</h5>
	<table style="background-color: lightgrey; margin: auto" border="1">
		<caption>Available Blog Posts</caption>
		<tr>
			<th>BlogPost ID</th>
			<th>Last Updated</th>
			<th>Title</th>
			<th>Description</th>
			<th>Action</th>
			<th>Action</th>
		</tr>
		<c:forEach var="post" items="${requestScope.posts}">
			<tr>
				<td>${post.id}</td>
				<td>${post.updatedOn}</td>
				<td>${post.title}</td>
				<td>${post.description}</td>

				<c:if test="${user.id eq post.blogger.id}">
					<c:url var="url" value="/blogger/delete?postId=${post.id}" />
					<c:url var="imgUrl" value="/images/delete.png" />
					<td><a href="${url}"><img src="${imgUrl}" width="20"
							height="20" /></a></td>
					<c:url var="url" value="/blogger/update?postId=${post.id}" />
					<td><a href="${url}">Update</a></td>
				</c:if>

			</tr>
		</c:forEach>
	</table>
	<h5>
		<c:url var="url" value="/users/logout" />
		<a href="${url}">Log Me Out</a>
	</h5>

</body>
</html>