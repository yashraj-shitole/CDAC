<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP EL</title>
</head>
<body>
	<h2>Expression Language</h2>
	<p> 
		Arbitrary calculations: e.g. ${2 + 3 * 4 mod 5}, ${22 div 7}
	<p>
	<p>
		<jsp:useBean id="now" class="java.util.Date" scope="request"/>
		Access scoped beans/objects: e.g. ${requestScope.now} <br/>
		${now}
	</p>
	<p>
		<jsp:useBean id="cb" class="com.sunbeam.CalcBean"/>
		<jsp:setProperty name="cb" property="num1" value="22" />
		<jsp:setProperty name="cb" property="num2" value="7" />
		<jsp:setProperty name="cb" property="op" value="*" />
		Access fields/methods of beans/objects: e.g. ${pageScope.cb} <br/>
		Execute method ${cb.calculate()} <br/>
		Result (internally calls cb.getResult()): ${cb.result}
	</p>
	<p>
		EL Implicit Objects <br/>
		* initParam (to access context param): ${initParam.appTitle} <br/>
		* cookie (to access cookie value): ${cookie.uname} <br/>
		* param (to access req param): ${param.roll} <br/>
		* paramValues (to access req param e.g. checkboxes): ${paramValues.course} <br/>
		* header (to access req header): ${header.host} <br/>
		* headerValues (to access req header with multiple values): <br/>
		* pageContext
	</p>
</body>
</html>

