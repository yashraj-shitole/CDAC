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

<jsp:useBean id="voteresutlbean" class="com.sunbeam.beans.VoteResultBean" scope="application" />
<jsp:setProperty property="id" param="id" name="voteresutlbean"/>

	<c:choose>
		<c:when test="${user.status == 0}">
			
				<c:choose>
					<c:when test="${voteresutlbean.vote()}">
						<c:set var="user.status" value="${1}" scope="session"/>
						<h1>Vote Successful</h1>
						${loginBean.u.setStatus(1)}	
					</c:when>
					<c:otherwise>
						<h1>Your voting attempt failed.</h1>
					</c:otherwise>
				</c:choose>
		
		</c:when>
		<c:otherwise>
			<h1>You have already voted.</h1>
		</c:otherwise>
		
	</c:choose>


</body>
</html>