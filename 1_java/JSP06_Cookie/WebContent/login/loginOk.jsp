<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>loginOk</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
<%! String id, pw; %>
<%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	
	if ("aaa".equals(id) && "111".equals(pw)){
		// 로그인 성공
		Cookie cookie = new Cookie("id", id);
		cookie.setMaxAge(-1); // 브라우저 닫을 때까지만 유효
		response.addCookie(cookie);
		
		response.sendRedirect("welcome.jsp");
	} else {
		// 로그인 실패
%>
	<script>
		alert('아이디와 비밀번호를 확인하세요.');
		location.href = 'login.html';
	</script>
<% } %>

</body>
</html>