<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<%
	Cookie hangulCookie = new Cookie("id", URLEncoder.encode("이데이", "utf-8"));
	hangulCookie.setMaxAge(-1);
	response.addCookie(hangulCookie);
%>

<body>
	<h2>생성된 쿠키 이름 : <%= hangulCookie.getName() %></h2>
	<h2>생성된 쿠키 값 : <%= hangulCookie.getValue() %></h2>
	<h2>생성된 쿠키값을 디코딩함 : <%= URLDecoder.decode(hangulCookie.getValue(), "utf-8") %></h2>
</body>
</html>