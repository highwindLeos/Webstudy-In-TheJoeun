<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ page buffer="4kb" autoFlush="true" %>
<%-- 아웃객체의 버퍼의 크기는 16kb로 설정한다. 
	버퍼가 가득차면 response 객체에 보내고 
	버퍼를 지우고 다시 버퍼를 채운다.(autoFlush = true)  --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Out</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
	<%
		out.println("<h1>Test</h1>");
		out.println("<h2>버퍼의 크기 : " + out.getBufferSize() + "</h2>");
		out.println("<h2>버퍼의 남은 크기 : " + out.getRemaining() + "</h2>");
		out.clear(); // 버퍼를 비운다. 버퍼를 비웠기때문에 출력이 없다.
		out.println("<h2>버퍼의 크기 : " + out.getBufferSize() + "</h2>");
		out.println("<h2>autoflush 기능 여부 : " + out.isAutoFlush() +"</h2>");
		for (int i=0; i < 1000; i++) {
			out.println("<h2>버퍼의 남은 크기 : " + out.getRemaining() +"</h2>");
		}
	%>
</body>
</html>