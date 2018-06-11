<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<jsp:useBean id="pi" class="com.tj.ex.PersonInfo" scope="request" />
<jsp:setProperty name="pi" property="name" param="name" />
<jsp:setProperty name="pi" property="age" param="age" />
<jsp:setProperty name="pi" property="gender" param="gender" />

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