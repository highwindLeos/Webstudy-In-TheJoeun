
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	request.setCharacterEncoding("utf-8"); %>
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
	<c:set var="CODE" value="80012" scope="request" />
	<c:set var="CODE2" value="80012" scope="request" />
	<c:set var="NAME" value="온도계" scope="request" />
	<c:set var="PRICE" value="10000" scope="request" />
	<jsp:forward page="core2InfoView.jsp" />
</body>
</html>