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
	
	
	<div style="display: flex; align-items: center; justify-content: center; flex-direction: column;">
	<h2>Voting Result</h2>
	<jsp:useBean id="rb" class="com.sunbeam.beans.ResultBean"/>
	${rb.fetchCandidates()}
	
	
	<table border="1" cellspacing="0" cellpadding="5">
    <thead>
        <tr>
            <th>Name</th>
            <th>Party</th>
            <th>Votes</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="c" items="${rb.candList}">
            <tr>
                <td>${c.name}</td>
                <td>${c.party}</td>
                <td>${c.votes}</td>
                <td>
                    <!-- Edit Action -->
                    <a href="editcand.jsp?id=${c.id}">
                        <img src="images/edit.png" alt="Edit" width="20" height="20" />
                    </a>
                    <!-- Delete Action -->
                    <a href="delete.jsp?id=${c.id}">
                        <img src="images/delete.png" alt="Delete" width="20" height="20" />
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>


	<p>${param.msg}</p>

	<div style="display: flex; align-items: center; justify-content: center; gap:50px">
		
		<a style="text-decoration: none; color: black;" href="logout.jsp">
			<div style="padding: 10px;border: 1px solid black; border-radius: 25px;">
				Sign Out
			</div>
		</a>
		
		<a style="text-decoration: none; color: black;" href="addCandidateForm.jsp">
			<div style="padding: 10px;border: 1px solid black; border-radius: 25px;">
				Add Candidate	
			</div>
		</a>
	</div>
</div>
</body>
</html>



