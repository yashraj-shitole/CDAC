<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Count</title>
</head>
<body>
	<%-- declaration: adds fields & methods into JSP. --%>
	<%! int count = 0; %>
	<% count++; %>
	<p>
		<%
			if(count % 2 == 0)
				out.println("Even Count: " + count);
			else
				out.println("Odd Count: " + count);
		%>
	</p>
	<p>
		<% if(count % 2 == 0) { %>
			Even Count: <%= count %>
		<% } else { %>
			Odd Count: <%= count %> 
		<% } %> 
	</p>
</body>

</html>