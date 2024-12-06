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
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Party</th>
				<th>Votes</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${rb.candList}">
				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>
					<td>${c.party}</td>
					<td>${c.votes}</td>
					<td>
						<a href="fc?page=editcand&id=${c.id}">
							<img src="images/edit.png" alt="Edit" width="20" height="20"/>
						</a>
						<a href="fc?page=delcand&id=${c.id}">
							<img src="images/delete.png" alt="Delete" width="20" height="20"/>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>${param.msg}</p>
	<p>
	<a href="fc?page=logout">Sign Out</a>
	</p>	
</body>
</html>



