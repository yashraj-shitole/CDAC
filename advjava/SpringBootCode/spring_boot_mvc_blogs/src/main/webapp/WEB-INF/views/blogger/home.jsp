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

<header>
    <h1>Hello Blogger</h1>
</header>

<div class="container">



<div class="buttoncontainer">

    <c:url var="addBlog" value="/blogger/addblog" />
    <a href="${addBlog}">
    <div class="button">Add Blog</div>
    </a>



    <c:url var="addCategory" value="/categories/addcategory" />
    <a href="${addCategory}">
    <div class="button">Add Category</div>
    </a>

</div>

    <table border="1px" >
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Content</th>
                <th>Created On</th>
                <th>Updated On</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${blogs_list}" var="list">
                <tr>
                    <td>${list.getId()}</td>
                    <td>${list.getTitle()}</td>
                    <td>${list.getDescription()}</td>
                    <td>${list.getContent()}</td>
                    <td>${list.getCreatedOn()}</td>
                    <td>${list.getUpdatedOn()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
