<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%	response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Error Null Exception</title>
	<script>
		console.log('예외메세지 : ' + '<%= exception.getMessage() %>');
		console.log('예외타입 : ' + '<%= exception.getClass().getName() %>');
	</script>
</head>
<body>
	<h1>NullPointer Exception 예외 페이지</h1>
</body>
</html>