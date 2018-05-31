<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log-in</title>
<style>
	#wrap{
		width : 300px;
		margin : 0 auto;
		text-align: center;
	}
</style>
</head>
<body>
<div id="wrap">
	<form action="loginResult.jsp" method="POST">
		<p>이 름 : <input type="text" id="name" name="name" /></p>
		<p>아이디 : <input type="text" id="id" name="id" /></p>
		<p>패스워드 : <input type="password" id="pw" name="pw" /></p>
		<button>로그인</button>
	</form>
</div>
</body>
</html>