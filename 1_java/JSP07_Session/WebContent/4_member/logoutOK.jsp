<%@page import="java.net.URLEncoder"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>LoginOK</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	
	session.invalidate();
	
	response.sendRedirect("main.jsp");
%>	
</body>
</html>