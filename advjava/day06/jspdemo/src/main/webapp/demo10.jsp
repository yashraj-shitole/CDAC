<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forward</title>
</head>
<body>
	<%--
	<jsp:forward page="demo10fwd.jsp"/>
	--%>
	
	<jsp:forward page="demo10fwd.jsp">
		<jsp:param name="sname" value="Nilesh"/>
		<jsp:param name="course" value="PG-DAC"/>
	</jsp:forward>
</body>
</html>
