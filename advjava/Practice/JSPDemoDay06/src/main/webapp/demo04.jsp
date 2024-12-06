<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator</title>
</head>
<body>

<form method="post" action="demo04res.jsp" style="display: flex;flex-direction: column; width: 300px">

Num1: <input type="number" name="num1">

Operation: <select name="op">
				
				<option value="+">+</option>
				<option value="-">-</option>
				<option value="/">/</option>
				<option value="*">*</option>
				<option value="%">%</option>

			</select>

Num2: <input type="number" name="num2">

<input type="submit" value="Answer">

</form>

</body>
</html>