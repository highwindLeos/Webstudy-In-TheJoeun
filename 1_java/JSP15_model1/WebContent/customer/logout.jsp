<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>logout</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
	<% session.invalidate(); %>
	<script>
		alert('로그아웃되었습니다. 서비스를 이용해주셔서 감사합니다.');
		location.href = '../main/main.jsp';
	</script>
</body>
</html>