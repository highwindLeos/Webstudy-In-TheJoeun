<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>core7</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<c:set var="guest" value="토끼-거북이--사슴"/>
<c:set var="i" value="1" />
<c:forTokens var="animal" items="${guest }" delims="-">
	${i } : ${animal } <br />
	<c:set var="i" value="${i+1 }"></c:set>
</c:forTokens>
</body>
</html>