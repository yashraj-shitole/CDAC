<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<jsp:useBean id="acb" class="com.sunbeam.beans.AddCandidateBean"/>

<jsp:setProperty name="acb" property="*"/>

<% acb.addCandidate(); %>
	<c:redirect url="result.jsp" />


</body>
</html>