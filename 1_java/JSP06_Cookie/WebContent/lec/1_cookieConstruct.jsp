<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>쿠키생성</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
<%
	Cookie cookie = new Cookie("CookieN", "CookieV"); //  쿠키이름과 값을 설정해서 쿠키생성.
	cookie.setMaxAge(60*60); // 2. 쿠키의 설정 : 유효시간 (1시간 저장)
	
	response.addCookie(cookie); // 응답객체에 쿠키를 담아보낸다.
	
%>	

	<h1>생성된 쿠키의 이름 : <%= cookie.getName() %></h1>
	<h1>생성된 쿠키의 값 : <%= cookie.getValue() %></h1>
	
	<a href="2_cookieGet.jsp">쿠키값들 확인</a>
	<button onclick="location.href = '2_cookieGet.jsp'" >쿠키값들 확인</button>
	<br />
	<a href="3_thatcookie.jsp">특정 쿠키가 있는지 쿠키값을 확인</a>
	<button onclick="location.href = '3_thatcookie.jsp'" >특정 쿠키가 있는지 쿠키값을 확인</button>
	
</body>
</html>