<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%-- <%@page errorPage= "error/errorPage.jsp" %>  에러가 나면 에러페이지로 가라고 지시자를 만들었다. --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>has Error Page</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
	<%= request.getParameter("name").toUpperCase() %> 님 어서오세요.
</body>
</html>