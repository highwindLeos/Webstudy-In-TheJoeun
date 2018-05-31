<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Result</title>
<style>
	#wrap{
		width : 300px;
		margin : 0 auto;
		text-align: center;
	}
</style>
</head>
<body>
<%  // 넘어온 파라미터 받기
	request.setCharacterEncoding("utf-8"); // POST 로 넘어온 값의 한글 깨짐을 해결.
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
%>
<div id="wrap">
	<h2>아이디는 <%= id %> 이고</h2>
	<h2>패스워드는 <%= pw %> 입니다.</h2>
	<p></p>
	<h2><%= name %> 님 반갑습니다.</h2>
</div>
</body>
</html>