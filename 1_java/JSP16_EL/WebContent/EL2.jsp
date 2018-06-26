<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>EL2</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
	<p><%= (1 < 2)? "1 < 2" : "1 >= 2" %></p>
	<p><%= (1 > 2)? "1 < 2" : "1 <= 2" %></p>
	<p><%= (1 == 2)? "1 == 2" : "1 != 2" %></p>
	<p><%= (1 != 2)? "1 != 2" : "1 === 2" %></p>
	<hr>
	<p>${ (1 lt 2)? "1 < 2" : "1 >= 2" }</p>
	<p>${ (1 gt 2)? "1 > 2" : "1 <= 2" }</p>
	<p>${ (1 eq 2)? "1 == 2" : "1 != 2" }</p>
	<p>${ (1 ne 2)? " 1 != 2 " : "1 == 2" }</p>
</body>
</html>