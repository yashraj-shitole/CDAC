<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Friend List</title>
</head>
<body>
	<%
		// if "friends" list is in session, access it.
		List<String> friends = (List<String>)session.getAttribute("friends");
		if(friends == null) {
			// otherwise, create new list and add it to session.
			friends = new ArrayList<>();
			session.setAttribute("friends", friends);
		}
	%>
	<%
		// get new friend name from page and add to session "friends" list.
		String friend = request.getParameter("fname");
		if(friend != null && !friend.isEmpty())
			friends.add(friend);
	%>
	<h2>Friends</h2>
	<ol>
		<% for(String frnd : friends) { %>
			<li><%= frnd.toUpperCase() %></li>
		<% } %>	
	</ol>
	<br/>
	<a href="demo06.jsp">Back</a>
</body>
</html>





