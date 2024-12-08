<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup</title>
</head>
<body>
	<div style="display: flex; align-items: center; justify-content: center; flex-direction: column;">

 <h2>Signup</h2>
	<form method="post" action="pages/signupImp.jsp" style="display: flex;">
		First Name: <input type="text" name="firstName"/> <br/><br/>
		Last Name: <input type="text" name="lastName"/> <br/><br/>
		Email: <input type="email" name="email"/> <br/><br/>
		Date of birth: <input type="date" name="birth"/> <br/><br/>
		Password: <input type="password" name="password"/> <br/><br/>
		<input type="submit" value="Sign up"/>
		<p>
			<a href="index.jsp">Sign in</a>
		</p>
	</form>
	</div>
</body>
</html>