<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>include directive</title>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td align="center">
				<%@ include file="header.jsp" %>
			</td>
		</tr>
		<tr height="300px">
			<td>
				Main content
			</td>
		</tr>
		<tr>
			<td align="center">
				<%@ include file="footer.jsp" %>
			</td>
		</tr>
	</table>
</body>
</html>