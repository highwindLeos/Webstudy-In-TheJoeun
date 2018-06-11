<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@page isErrorPage="true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Error Number</title>
	<script></script>
</head>
<body>
	<h1>NumberFormatException</h1>
	<h2>예외 타입 : <%= exception.getClass().getName() %></h2>
	<% System.out.println("에러 메세지 : " + exception.getMessage()); %>
</body>
</html>