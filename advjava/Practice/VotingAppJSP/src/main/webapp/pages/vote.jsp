<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vote</title>
</head>
<body>

<jsp:useBean id="cndidateListBean" class="com.sunbeam.beans.CandidateListBean" scope="application"/>


<h1><c:out value="${sessionScope.user.getFirstName()}"/></h1>

<h3>Role: <c:out value="${sessionScope.user.getRole()}" /></h3>

<h1>Vote</h1>

<form method="post" action="">

<c:forEach items="${cndidateListBean.candidateList()}" var="item">
    <input type="radio" name="vote"> ${item.getName()} | ${item.getParty()}<br>
</c:forEach>


</form>
	
      

</body>
</html>