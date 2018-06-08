<%@page import="com.sun.corba.se.spi.orbutil.fsm.Guard.Result"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Result</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>

<% 
	String result = request.getParameter("result");
	if ("success".equals(result)){
%>
	<h2>가입이 완료되었습니다.</h2>
	<button onclick="location.href = 'login.jsp'">로그인</button>
<% } else if ("fail".equals(result)) { %>
	<h2>가입되지 않았습니다.</h2>
	<button onclick="location.href = 'login.jsp'">로그인</button>
<% } %>
</body>
</html>