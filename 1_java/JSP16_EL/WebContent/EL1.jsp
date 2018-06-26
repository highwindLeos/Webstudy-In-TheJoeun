<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>EL1</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
	<p><%= 10+2 %></p>
	<p><%= 10-2 %></p>
	<p><%= 10*2 %></p>
	<p><%= 10/0.0 %></p><%-- 예외발생 : 0으로 나누기는 할수 없다. --%>
	<p><%= 10%2 %></p>
	<p><%= true %></p>
	<hr></hr>
	<p>${ 10+2 }</p>
	<p>${ 10-2 }</p>
	<p>${ 10*2 }</p>
	<p>${ 10/0 }</p><%-- 예외가 발생하지 않음.--%>
	<p>${ 10%2 }</p>
	<p>${ true }</p>
</body>
</html>