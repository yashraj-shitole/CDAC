<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>


<% double num1=Integer.parseInt(request.getParameter("num1")); %>
<% double num2=Integer.parseInt(request.getParameter("num2")); %>
<% String op=request.getParameter("op"); %>


<h1>Result</h1>

<%	
switch(op){
	case "+":
		out.print("Addition = "+(num1+num2));
		break;
	case "-":
		out.print("Subtraction = "+(num1-num2));
	break;
	case "/":
		out.print("Division = "+ (num1/num2));
	break;
	case "*":
		out.print("Multiplication = "+(num1*num2));
	break;
	case "%":
		out.print("Modulus = "+(num1%num2));
	break;

}


%>



</body>
</html>