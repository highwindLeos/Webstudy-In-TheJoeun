<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>core9</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<h2>core9 영역</h2>
<hr />
<c:import url="gugudan.jsp">
	<c:param name="dansu" value="8" />
</c:import>
<hr />
<h2>다시 core9 영역</h2>
</body>
</html>