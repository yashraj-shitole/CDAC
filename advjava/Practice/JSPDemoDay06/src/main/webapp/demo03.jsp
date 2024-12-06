<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator</title>
</head>
<body>

<%! int count=0; %>
<% count++; %>
Count: <%= count %>


<br>
<%
if(count%2==0){
	out.print("EVEN");
}else{
	out.print("ODD");
}

%>


<% if(count%2==0){ %>
<h1>EVEN</h1>
<%}else{ %>
<h1>ODD</h1>
<%} %>


</body>
</html>