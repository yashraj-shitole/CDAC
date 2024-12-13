<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Hello world</h1>


<c:url var="abc" value="/test/display" />
<a href="${abc}">LINK</a>


<c:url var="abc" value="/test/display2" />
<a href="${abc}">LINK 2</a>


<c:url var="abc" value="/categories/display" />
<a href="${abc}">LINK 2</a>

</body>
</html>