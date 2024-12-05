<%@ page errorPage="errpage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<h2>Calculator Result - Java Beans</h2>
	<div>
		<%-- create bean object --%>
		<jsp:useBean id="cb1" class="com.sunbeam.CalcBean"/>
		<%-- set bean field values from req parameters --%>
		<jsp:setProperty name="cb1" property="num1" param="num1" />
		<jsp:setProperty name="cb1" property="num2" param="num2" />
		<jsp:setProperty name="cb1" property="op" param="op" />
		<%-- call business logic --%>
		<% cb1.calculate(); %>
		<%-- get business logic result --%>
		Result: <jsp:getProperty name="cb1" property="result" />
	</div>
	<div>
		<%-- create bean object --%>
		<jsp:useBean id="cb2" class="com.sunbeam.CalcBean" scope="page"/>
		<%-- set bean field values from req parameters --%>
		<jsp:setProperty name="cb2" property="*"/>
		<%-- call business logic --%>
		<% cb2.calculate(); %>
		<%-- get business logic result --%>
		Result: <jsp:getProperty name="cb2" property="result" />
	</div>
</body>
</html>

