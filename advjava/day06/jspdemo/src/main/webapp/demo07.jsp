<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Life Cycle</title>
</head>
<body>
	<%!
		public void jspInit() {
			System.out.println("jspInit() called.");
		}
		public void jspDestroy() {
			System.out.println("jspDestroy() called.");
		}
	%>
	<%
		System.out.println("jspService() called.");
	%>
	<h2>JSP Life Cycle</h2>
</body>
</html>



