<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate List</title>
</head>
<body>
	<h2>Candidate List</h2>
	<jsp:useBean id="clb" class="com.sunbeam.beans.CandidateListBean"/>
	${clb.fetchCandidates()}
	<form method="post" action="fc?page=vote">
		<c:forEach var="c" items="${clb.candList}">
			<input type="radio" name="candidate" value="${c.id}"/> ${c.name} - ${c.party} <br/>
		</c:forEach>	
		<br/>
		<input type="submit" value="Vote"/>
	</form>
</body>
</html>