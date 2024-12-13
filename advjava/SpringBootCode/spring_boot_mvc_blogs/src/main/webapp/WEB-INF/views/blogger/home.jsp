<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blogs</title>
</head>
<body>

<h1>HELLO BLOGGER</h1>
<c:url var="addBlog" value="/blogger/addblog" />
<a href="${addBlog }">Add blog</a>

<c:url var="addCategory" value="/categories/addcategory" />
<a href="${addCategory}">Add category</a>

</body>
</html>