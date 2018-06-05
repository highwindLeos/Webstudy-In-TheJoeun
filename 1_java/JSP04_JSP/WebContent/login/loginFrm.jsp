<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Title</title>
	<style>
		h4 {
			color : red;
		}
	</style>
	<script>
	
	</script>
</head>
<body>
	<form action="check.jsp" method="get">
		<p>아이디 : <input type="text" name="id" required="required"/></p>
		<p>비밀번호 : <input type="password" name="pw" required="required"/></p>
		<input type="submit" value="로그인" />
	</form>
	<%
		String msg = request.getParameter("msg");
		if (msg != null){
	%>
	<h4><%= msg %></h4>
	<% } %>
</body>
</html>