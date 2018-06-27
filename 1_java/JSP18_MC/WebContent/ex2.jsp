<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Title</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
	<%
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String jspName = uri.substring(conPath.length());
	%>
	<p>URI : <%= uri %></p>
	<p>conPath : <%= conPath %></p>
	<p>jspName : <%= jspName %></p>
</body>
</html>