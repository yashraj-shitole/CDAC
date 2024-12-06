<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote</title>
</head>
<body>
	<h2>Voting Status</h2>
	<jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean"/>
	<jsp:setProperty name="vb" property="candId" param="candidate"/>
	<jsp:setProperty name="vb" property="userId" value="${lb.user.id}"/>
	<c:choose>
		<c:when test="${lb.user.status == 0}">
			${vb.vote()}
			<c:choose>
				<c:when test="${vb.success}">
					<p>You have successfully voted.</p>
					${lb.user.setStatus(1)}
				</c:when>
				<c:otherwise>
					<p>Your voting attempt failed.</p>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<p>You have already voted.</p>
		</c:otherwise>
	</c:choose>
	<p>
	<a href="fc?page=logout">Sign Out</a>
	</p>
</body>
</html>