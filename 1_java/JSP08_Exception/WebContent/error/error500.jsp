<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@page isErrorPage="true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>500 Error Meassage</title>
	<script>
		console.log('에러메세지 : <%= exception.getMessage() %>');
		console.log('에러타입 : <%= exception.getClass().getName() %>');
	</script>
</head>
<body>
	<h1>500 에러 페이지</h1>
	<h2>공사중입니다.</h2>
</body>
</html>