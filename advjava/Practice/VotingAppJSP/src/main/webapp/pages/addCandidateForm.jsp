<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div style="display: flex; align-items: center; justify-content: center; flex-direction: column;">

 <h2>Add candidate</h2>
 
	<form method="post" action="addcad.jsp">
		Name: <input type="text" name="name"/> <br/><br/>
		Party: <input type="text" name="party"/> <br/><br/>
		
		<input type="submit" value="Add"/>
		<p>
			<a href="index.jsp">Sign in</a>
		</p>
	</form>

</div>
</body>
</html>