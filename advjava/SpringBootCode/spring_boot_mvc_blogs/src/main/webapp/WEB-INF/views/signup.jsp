<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url var="url" value="/users/register"/>

	<form action="${url}" method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Enter First Name</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			
			<tr>
				<td>Enter Last Name</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>Enter User Email</td>
				<td><input type="email" name="email" /></td>
			</tr>
			
			<tr>
				<td>Enter date of birth in format YYYY-MM-DD</td>
				<td><input type="text" name="dob" /></td>
			</tr>
			
			<tr>
				<td>Enter registration amount</td>
				<td><input type="number" name="amount" /></td>
			</tr>
			<tr>
				<td>Enter address</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Signup" /></td>
			</tr>
			
			
		</table>
		

	</form>

</body>
</html>