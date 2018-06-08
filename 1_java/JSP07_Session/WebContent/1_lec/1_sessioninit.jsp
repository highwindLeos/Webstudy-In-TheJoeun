<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>session Init</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
	<h2>세션에 데이터 넣기 (name-value)</h2>
	<h3>sessionName, myNum 두개의 세션 데이터 추가</h3>
<%

	session.setAttribute("sessionName", "sessionValue");
	session.setAttribute("myNum", 111); // 알아서 new Integer(111); wrapper 자료형으로 들어간다.
	
%>
	<hr />
	<button onclick="location.href = '2_sessionGet.jsp'">세션 확인하기</button>
	<a href="2_sessionGet.jsp">세션 확인하기.</a>
</body>
</html>