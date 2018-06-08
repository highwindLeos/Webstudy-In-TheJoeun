<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Param2</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
<%! String id, pw; %>
<%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
%>
	<h1>3_param2.jsp 영역입니다.</h1>
	<h2>넘어온 파라메터 id : <%= id %></h2>
	<h2>넘어온 파라메터 pw : <%= pw %></h2>
</body>
</html>