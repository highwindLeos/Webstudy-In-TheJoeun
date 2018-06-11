<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Result ST</title>
</head>
<body>
<jsp:useBean id="st" class="com.tj.ex.Student" scope="request" />
	<h2>개인정보</h2>
	<p>학번 : <jsp:getProperty name="st" property="studentNum" /></p>
	<p>이름 : <jsp:getProperty name="st" property="name" /></p>
	<p>등급 : <jsp:getProperty name="st" property="grade" /></p>
	<p>점수 : <jsp:getProperty name="st" property="score" /></p>
	
</body>
</html>