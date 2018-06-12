<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Logout</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<%
	if (session.getAttribute("id") == null){
		response.sendRedirect("login.jsp");
	}
	
	//session.removeAttribute("id");
	//session.removeAttribute("pw");
	//session.removeAttribute("name");

	session.invalidate();
%>
<body>
	<h2>로그아웃 되었습니다.</h2>
	 <button onclick="location.href = 'login.jsp'">로그인 페이지로</button>
</body>
</html>