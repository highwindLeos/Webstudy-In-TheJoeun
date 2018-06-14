<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Result</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<%
	String name = (String)session.getAttribute("name");
	String id = (String)session.getAttribute("id");
	
	if (id == null){ // 로그인 한 사용자만 보여지는 페이지
		response.sendRedirect("login.jsp");
	}
%>
<body>
	<h2><%= name %>(<%= id %>) 님 안녕하세요.</h2>
	<button onclick="location.href = 'modify.jsp'">회원정보 수정</button>
	<button onclick="location.href = 'logout.jsp'">로그아웃</button>
</body>
</html>