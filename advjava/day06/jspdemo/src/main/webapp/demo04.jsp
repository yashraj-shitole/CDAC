<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calculator</title>
</head>
<body>
	<h2>Calculator</h2>
	<form method="post" action="demo04res.jsp">
		Num1: <input type="text" name="num1"/> <br/><br/>
		Operation: <select name="op">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
			<option value="%">%</option>
		</select> <br/><br/>
		Num2: <input type="text" name="num2"/> <br/><br/>
		<input type="submit" value="=">
	</form>
	<p>
	Note: Divide by zero to see demo of error pages.
	</p>
</body>
</html>
