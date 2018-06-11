<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<jsp:useBean id="st" class="com.tj.ex.Student" scope="request" />

<jsp:setProperty name="st" property="studentNum" param="studentNum" />
<jsp:setProperty name="st" property="name" param="name" />
<jsp:setProperty name="st" property="grade" param="grade" />
<jsp:setProperty name="st" property="score" param="score" />

<jsp:forward page="stResult.jsp" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>step5</title>
</head>
<body>
	
</body>
</html>