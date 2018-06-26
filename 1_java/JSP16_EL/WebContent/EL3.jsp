<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>EL3</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
	<p><%= (1 < 2)? "1 < 2" : "1 >= 2" %></p>
	<p><%= (1 > 2)? "1 < 2" : "1 <= 2" %></p>
	<p><%= (1 == 2)? "1 == 2" : "1 != 2" %></p>
	<p><%= (1 != 2)? "1 != 2" : "1 === 2" %></p>
	<p><% if (session.getAttribute("id") != null ){
		out.println("로그인 했네");	
	} else if (session.getAttribute("id") == null) {
		out.println("로그인 안 했네");
	} %></p>
	<hr>
	<p>${ (1 lt 2)? "1 < 2" : "1 >= 2" }</p>
	<p>${ (1 gt 2)? "1 > 2" : "1 <= 2" }</p>
	<p>${ (1 eq 2)? "1 == 2" : "1 != 2" }</p>
	<p>${ (1 ne 2)? " 1 != 2 " : "1 == 2" }</p>
	<p>${ id != null ? "로그인 했네" : "로그인 안했네" }</p>
	<p>${ not empty sessionScope.id ? "로그인 했네" : "로그인 안했네" }</p> <%-- 위의 행과 같은 표현식 --%>
	<p>${ id == null ? "로그인 안했네" : "로그인 했네" }</p>
	<p>${ empty sessionScope.id ? "로그인 안했네" : "로그인 했네" }</p> <%-- 위의 행과 같은 표현식 --%>
</body>
</html>