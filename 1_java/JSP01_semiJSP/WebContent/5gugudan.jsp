<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gugudan 2단</title>
</head>
<body>
	<h2>2단 구구단</h2>
	<% for (int i = 1; i < 9 ; i++){ %>
		<p>2 * <%= i %> = <%= 2*i %></p>
	<% } %>
</body>
</html>