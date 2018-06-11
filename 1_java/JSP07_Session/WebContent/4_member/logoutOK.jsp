<%@page import="java.net.URLEncoder"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogoutOK</title>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	session.invalidate();
	%>
	<script>alert('로그아웃 되었습니다.');</script>
	<%  response.sendRedirect("main.jsp"); %>
</body>
</html>