<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Blog Contents</title>
</head>

<body>
	<spring:url var="url" value="/bloggers/update_blog" />
	<form action="${url}" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Blog Post ID</td>
				<td><input type="number" name="id" value="${blog.id}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Update Blog Contents</td>
				<td><textarea cols="40" rows="10" name="content">${blog.content}</textarea></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update Blog Contents" /></td>
			</tr>
		</table>
	</form>
</body>
</html>