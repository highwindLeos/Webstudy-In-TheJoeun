<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@page isErrorPage="true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ex2 Error Page</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
<script>
	console.log('에러 메세지 : <%= exception.getMessage() %>');
	console.log('에러 메세지 : <%= exception.getClass().getName() %>');
</script>
<h1>0으로 나누는 부분은 확장 공사 중 입니다.</h1>
</body>
</html>