<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
</head>
<body>

<jsp:useBean id="registerBean" class="com.sunbeam.beans.RegisterBean"/>

<jsp:setProperty name="registerBean" property="*"/>

<% boolean isRegisterd=registerBean.registerUser(); %>

   <c:choose>
        <c:when test="${registerBean.registerUser()}">
            <h1>Successfully Registered</h1>
            
            <c:redirect url="index.jsp"/>
        </c:when>
        <c:otherwise>
            <h1>Registration Failed</h1>
        </c:otherwise>
    </c:choose>



</body>
</html>