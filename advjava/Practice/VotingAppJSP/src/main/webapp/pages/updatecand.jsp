<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
	<jsp:useBean id="ucb" class="com.sunbeam.beans.UpdateCandidateBean"/>
	<jsp:setProperty name="ucb" property="*" />
	${ucb.updateCandidate()}
	<c:choose>
		<c:when test="${ucb.count == 1}">
			<jsp:forward page="result.jsp">
				<jsp:param name="msg" value="Candidate Updated Successfully." />
			</jsp:forward>
		</c:when>
		<c:otherwise>
			<jsp:forward page="result.jsp">
				<jsp:param name="msg" value="Candidate Update Failed." />
			</jsp:forward>		
		</c:otherwise>
	</c:choose>
</body>
</html>
