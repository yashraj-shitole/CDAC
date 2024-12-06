<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<jsp:useBean id="loginBean" class="com.sunbeam.beans.LoginBean" scope="application"/>

<jsp:setProperty property="email" param="email" name="loginBean"/>
<jsp:setProperty property="password" param="password" name="loginBean"/>
<% boolean isloggedin=loginBean.loggedIn(); %>

	 <c:choose>
        <c:when test="${loginBean.loggedIn()}">
            <c:set var="user" value="${loginBean.u}" scope="session"/>
            <h1>Successfully Logged In</h1>
            
            <c:redirect url="vote.jsp"/>
        </c:when>
        <c:otherwise>
            <h1>Login Failed</h1>
        </c:otherwise>
    </c:choose>
	
</body>
</html>