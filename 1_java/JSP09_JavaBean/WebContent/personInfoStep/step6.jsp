<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<jsp:useBean id="pi" class="com.tj.ex.PersonInfo" scope="request" />
<jsp:setProperty name="pi" property="*" /> <!-- 모든 속성값은 모든 파라메터로 받는걸로 폼의 입력 데이터를 입력할수 있다. -->
<jsp:forward page="piResult.jsp" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Step5</title>
</head>
<body>
</body>
</html>