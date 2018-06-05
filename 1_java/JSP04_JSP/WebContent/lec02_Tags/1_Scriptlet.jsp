<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Scriptlet</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
<h1>out 객체 이용 방법</h1>
<% 
	int su = 0;
	while(su <= 9 ) {
		su++;
		out.println("<h2>2 * " + su + " = " + (2*su) +"</h2>");
		out.println("<hr>");
	}
%>
<h1>스크립트릿으로 출력 방법</h1>
<%
	int i = 0;
	while (i <= 9) { 
			i++; %>
		<h2>2 * <%= i %> = <%= 2*i %></h2>
		<hr>		
<% 	} %>
</body>
</html>