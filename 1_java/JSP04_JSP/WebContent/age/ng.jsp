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
	int age = Integer.parseInt(request.getParameter("age"));
%>
<body>
	<h3>사용자의 나이는 <%= age %> 세이고 20세 이하입니다. 주류 판매가 불가합니다.</h3>
	<button onclick="history.back()">뒤로가기</button>
</body>
</html>