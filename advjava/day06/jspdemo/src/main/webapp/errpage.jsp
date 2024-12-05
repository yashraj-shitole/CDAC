<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
	<h2>Error</h2>
	<p>
		Something went wrong. Contact the vendor.
	</p>
	<p>
		Details: <%= exception.getClass().getName() %>:
			<%= exception.getMessage() %>
	</p>
</body>
</html>
