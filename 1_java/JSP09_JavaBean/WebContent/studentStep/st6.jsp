<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<jsp:useBean id="st" class="com.tj.ex.Student" scope="request" />

<jsp:setProperty name="st" property="*" />

<jsp:forward page="stResult.jsp" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>step6</title>
</head>
<body>
	
</body>
</html>