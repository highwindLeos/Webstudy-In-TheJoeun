<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Title</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
	<form action="ex3.jsp" method="POST"> 
		<p>이름 : <input type="text" name="name" /></p>
		<p>아이디 : <input type="text" name="id" /></p>
		<p>패스워드 : <input type="password" name="pw" /></p>
		<p><input type="submit" value="전송" /></p>
	</form>
</body>
</html>