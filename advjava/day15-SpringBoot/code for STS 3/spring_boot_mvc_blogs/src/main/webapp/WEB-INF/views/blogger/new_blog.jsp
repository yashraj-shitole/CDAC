<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Blog Page</title>
</head>

<body>
	<h5 align="center" style="color: red;">${requestScope.message}</h5>

	<form:form method="post" modelAttribute="blogPost">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Choose Blog Post Category</td>
				<td><form:select path="blogCategory">
						<form:options  itemLabel="categoryName" itemValue="id" items="${requestScope.all_categories}" />
					</form:select>
			</tr>
			<tr>
				<td>Enter Title</td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>Enter Description</td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td>Enter Content</td>
				<td><form:textarea path="content" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create New Blog" /></td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>