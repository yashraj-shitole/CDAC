<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Category</title>
</head>
<body>

<c:url var="addCategory" value="/categories/addcategory"/>

<form method="post"  action="${addCategory }">
<div>
	<label for="name">Add name</label>
	<input type="text" name="name">
	</div>

	<div>
	<label for="description">Add description</label>
	<input type="text" name="description">
	</div>
	
	<input type="submit" value="add category">
</form>

</body>
</html>