<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<h2>Voting Result</h2>
	<jsp:useBean id="rb" class="com.sunbeam.beans.ResultBean"/>
	${rb.fetchCandidates()}
	<c:forEach var="c" items="${rb.candList}">
		<div style="border: 1px solid black; width: 100%">
			Id: ${c.id}<br/>
			Name: ${c.name}<br/>
			Party: ${c.party}<br/>
			Votes: ${c.votes}<br/>
			<a href="fc?page=editcand&id=${c.id}">
				<img src="images/edit.png" alt="Edit" width="20" height="20"/>
			</a> | 
			<a href="fc?page=delcand&id=${c.id}">
				<img src="images/delete.png" alt="Delete" width="20" height="20"/>
			</a>
		</div>
		<br/>
	</c:forEach>
	<p>${param.msg}</p>
	<p>
	<a href="fc?page=logout">Sign Out</a>
	</p>	
</body>
</html>



