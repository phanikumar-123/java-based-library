<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%
request.getSession(false);
String name=(String)session.getAttribute("name");
String author=(String)session.getAttribute("author");
String published=(String)session.getAttribute("published");
String pages=(String)session.getAttribute("pages");
%>

<html>
<head>

<title>SearchBook</title>
</head>
<body bgcolor=green text=white>
<form action="Update.com" method="post">
<h1>NAME:<input type="text" name="NAME1" value=<%=name%>></h1>
<h1>AUTHOR:<input type="text" name="AUTHOR1" value=<%=author%>></h1>
<h1>PUBLISHED:<input type="text" name="PUBLISHED1" value=<%=published%>></h1>
<h1>PAGES:<input type="text" name="PAGES1" value=<%=pages%>></h1>

<input type="submit" value="update">
</form>
</body>
</html>