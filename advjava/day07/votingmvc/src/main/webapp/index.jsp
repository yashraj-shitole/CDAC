<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<form method="post" action="fc?page=login">
		Email: <input type="text" name="email"/> <br/><br/>
		Password: <input type="password" name="passwd"/> <br/><br/>
		<input type="submit" value="Sign In"/>
		<p>
			<a href="fc?page=newuser">Sign Up</a>
		</p>
	</form>
</body>
</html>