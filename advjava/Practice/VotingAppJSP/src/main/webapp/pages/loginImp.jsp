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
		<c:when test="${loginBean.u != null}">
			
			<c:choose>
				<c:when test="${loginBean.u.role == 'admin'}">
					<c:redirect url="result.jsp"/>	
						<c:set var="user" value="${loginBean.u}" scope="session"/>
					
				</c:when>
				
				<c:when test="${loginBean.u.role == 'voter'}">
					<c:redirect url="vote.jsp"/>
			            <c:set var="user" value="${loginBean.u}" scope="session"/>
					
				</c:when>
				
			</c:choose>
		</c:when>
		<c:otherwise>
			<h2>Login Failed</h2>
			<p>
			Invalid email or password.
			</p>
			<p>
			<a href="index.jsp">Login Again</a>
			</p>
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>