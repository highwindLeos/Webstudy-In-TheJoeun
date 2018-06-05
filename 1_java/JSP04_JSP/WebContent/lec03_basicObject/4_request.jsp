<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>requestMethod</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
	<% // url(http://localhost:8081/JSP04_JSP/lec03_basicObject/4_request.jsp)
	   // uri(lec03_basicObject/4_request.jsp)
	   
		String uri = request.getRequestURI();
		String conPath = request.getContextPath(); // JSP04_JSP
		String command = uri.substring(conPath.length()+1); // 문자열을 잘
	%>
	
	<h2>요청하신 작업은 <%= command %> 입니다.</h2>
</body>
</html>