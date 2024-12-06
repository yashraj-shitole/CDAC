<%@page import="com.mysql.cj.protocol.FullReadInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ITEM LIST</title>
</head>
<body>

<%

List<String> items=(List<String>)session.getAttribute("items");
if(items==null){
	items=new ArrayList<>();
	session.setAttribute("items", items);
}


String item=request.getParameter("items");
if(item !=null && !item.isEmpty()){
	items.add(item);
}



%>

</body>
</html>