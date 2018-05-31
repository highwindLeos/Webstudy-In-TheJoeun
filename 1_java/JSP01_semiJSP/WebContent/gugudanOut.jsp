<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력</title>
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
	int dansu = Integer.parseInt(request.getParameter("dansu"));
%>
<div id="wrap">s
	<h1><%= dansu %>단 구구단 출력</h1>
	<% for (int i = 1; i < dansu; i++){ %>
		<p><%= dansu %> * <%= i %> = <%= i * dansu %></p>	
	<% } %>
	
</div>
</body>
</html>