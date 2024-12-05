<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL</title>
</head>
<body>
	<h2>JSTL</h2>
	<div>
	JSTL components
	<ul>
		<li>Core (c) - Variables, Programming constructs, Redirection, ...</li>
		<li>Format (fmt) - Formatting numbers, currency, date-time, ...</li>
		<li>Functions (fn) - Utility functions of Strings, ...</li>
		<li>Sql (sql) - Execute SQL queries on database, ...</li>
		<li>XML (xml) - XML parsing & DOM tags</li>
	</ul>
	</div>
	<%--
	<c:redirect url="www.google.com"/>
	--%>
	<%-- add a variable in given scope --%>
	<c:if test="${count == null}">
		<c:set var="count" value="0" scope="session"/>
	</c:if>
	<%-- reassign value to variable --%>
	<c:set var="count" value="${count + 1}" scope="session"/>
	<%-- choose-when statement to implement if-else ladder --%>
	<c:choose>
		<c:when test="${count % 2 == 0}">
			Even Count: ${count}
		</c:when>
		<c:otherwise>
			Odd Count: ${count}
		</c:otherwise>
	</c:choose>
</body>
</html>


