<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>logout</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
<% 
	String id = (String)session.getAttribute("id");
	if ( id != null){
		session.removeAttribute("id");
		session.removeAttribute("pw");
		session.invalidate();
	  %>	
<h3>로그아웃 되었습니다.</h3>
<button onclick="location.href = 'login.jsp'">로그인 페이지로</button>
<button onclick="location.href = 'sessionTest.jsp'">세션 들여다보기</button>
<% } else { %>
<h3>로그인 상태가 아닙니다.</h3>
<button onclick="location.href = 'login.jsp'">로그인 페이지로</button>
<% } %>
</body>
</html>