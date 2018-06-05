<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Title</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<%
	int age = Integer.parseInt(request.getParameter("age"));

	if (age >= 20){ // 20 이상이라면 true
		response.sendRedirect("pass.jsp?age="+age);
	} else {
		response.sendRedirect("ng.jsp?age="+age);
	}
%>
<body>
	
</body>
</html>