<%@page import="java.util.Enumeration"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Title</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
%>
<body>
	<p>아이디는 <%= id %> 이고</p>
	<p>패스워드는 <%= pw %>입니다.</p>
	<br />
	<p>반갑습니다.</p>
	<button onclick="history.back()">뒤로가기</button>
</body>
</html>