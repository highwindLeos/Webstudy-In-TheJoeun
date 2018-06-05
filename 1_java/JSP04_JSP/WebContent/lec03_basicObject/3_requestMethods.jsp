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
	<%
		out.println("<h3> 컨텍스트 Path = " + request.getContextPath() +"</h3>");
		out.println("<h3> 세션 객체 = " + request.getSession() +"</h3>");
		out.println("<h3> 요청받은 프로토콜 = " + request.getProtocol() +"</h3>");
		out.println("<h3> 요청받은 URL = " + request.getRequestURL()+"</h3>"); // 절대경로
		out.println("<h3> 요청받은 URI = " + request.getRequestURI() +"</h3>"); // 프로젝트기준 상대경로
		out.println("<h3> 서버이름 = " + request.getServerName() +"</h3>");
		out.println("<h3> 포트번호 = " + request.getServerPort() +"</h3>");
	%>
</body>
</html>