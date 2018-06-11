<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<jsp:useBean id="st" class="com.tj.ex.Student" scope="request" />

<jsp:setProperty name="st" property="studentNum" value='<%= Integer.parseInt(request.getParameter("studentNum")) %>' />
<jsp:setProperty name="st" property="name" value='<%= request.getParameter("name") %>' />
<jsp:setProperty name="st" property="grade" value='<%= Integer.parseInt(request.getParameter("grade")) %>' />
<jsp:setProperty name="st" property="score" value='<%= Integer.parseInt(request.getParameter("score")) %>' />

<jsp:forward page="stResult.jsp" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>step4</title>
</head>
<body>
	
</body>
</html>