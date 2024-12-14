<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddBlog</title>
</head>
<body>

<c:url var="addBlog" value="/blogger/addblog" />

<form action="${addBlog}" method="post">
	
	<div style="display: flex; flex-direction:column; align-items: center; justify-content: center; padding: 20px; gap:20px;">
	
	<div style="display: flex;flex-direction:column; align-items: flex-start; justify-content: flex-start; gap:20px">
	<div>
	<label for="title">Add Title</label>
	<input type="text" name="title">
	</div>

	<div>
	<label for="content">Add content</label>
	<input type="text" name="content">
	</div>
	
	<div>
	<label for="description">Add description</label>
	<input type="text" name="description">
	</div>	
	
	<div>
	<label for="categoryId">Category id</label>
	<input type="number" name="categoryId">
	 </div>
	 	
	<div>
	<label for="uderId">User id</label>
	<input type="number" name="userId">
	 </div>	

	</div>
	
	<div>
	<input type="submit" value="Add blog">
	 </div>	

	</div>
	
	
	
	
</form>

</body>
</html>