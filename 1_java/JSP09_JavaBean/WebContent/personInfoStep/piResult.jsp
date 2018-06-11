<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Result PI</title>
</head>
<body>
<jsp:useBean id="pi" class="com.tj.ex.PersonInfo" scope="request" />
	<h2>개인정보</h2>
	<p>이름 : <jsp:getProperty name="pi" property="name" /></p>
	<p>나이 : <jsp:getProperty name="pi" property="age" /></p>
	<p>성별 : <jsp:getProperty name="pi" property="gender" /></p>
</body>
</html>