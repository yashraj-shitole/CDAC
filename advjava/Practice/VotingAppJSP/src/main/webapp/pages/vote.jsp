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

	<div style="display: flex; align-items: center; justify-content: center; flex-direction: column;">


<h1><c:out value="${sessionScope.user.getFirstName()}"/></h1>

<h3>Role: <c:out value="${sessionScope.user.getRole()}" /></h3>

<h1>Vote</h1>

<form method="post" action="voteresult.jsp">
    <table border="1" cellspacing="0" cellpadding="5">
        <thead>
            <tr>
                <th>Select</th>
                <th>Candidate Name</th>
                <th>Party</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${cndidateListBean.candidateList()}" var="item">
                <tr>
                    <td>
                        <input type="radio" name="id" value="${item.getId()}">
                    </td>
                    <td>${item.getName()}</td>
                    <td>${item.getParty()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <input type="submit" value="VOTE">
</form>

	</div>
      

</body>
</html>