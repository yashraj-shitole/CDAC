<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<h1>VOTING</h1>
 
 <h2>Login</h2>
	<form method="post" action="pages/loginImp.jsp">
		Email: <input type="text" name="email"/> <br/><br/>
		Password: <input type="password" name="password"/> <br/><br/>
		<input type="submit" value="Sign In"/>
		<p>
			<a href="signup.jsp">Sign Up</a>
		</p>
	</form>

</body>
</html>