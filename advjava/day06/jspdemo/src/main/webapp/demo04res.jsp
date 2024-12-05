<%@ page errorPage="errpage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result</title>
</head>
<body>
	<h2>Calculator Result</h2>
	<%
		int n1 = Integer.parseInt(request.getParameter("num1"));
		int n2 = Integer.parseInt(request.getParameter("num2"));
		String op = request.getParameter("op");
	%>
	<%
		switch(op) {
		case "+":
			out.println("Addition: " + (n1 + n2));
			break;
		case "-":
			out.println("Subtraction: " + (n1 - n2));
			break;
		case "*":
			out.println("Multiplication: " + (n1 * n2));
			break;
		case "/":
			out.println("Division: " + (n1 / n2));
			break;
		case "%":
			out.println("Modulus: " + (n1 % n2));
			break;
		}
	%>
</body>
</html>
