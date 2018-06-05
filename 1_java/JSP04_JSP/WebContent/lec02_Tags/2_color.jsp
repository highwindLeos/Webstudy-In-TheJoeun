<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>배경색 변경</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<% 
	String color = request.getParameter("color");
	if(color == null){
		color = "white";
	}
%>
<body bgcolor="<%= color %>">
	
</body>
</html>