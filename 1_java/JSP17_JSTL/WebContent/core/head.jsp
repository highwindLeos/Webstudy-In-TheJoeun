<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>header</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<c:if test="${ empty Member && empty Admin }"><!-- 로그인 전  -->
<ul>
	<li><a href="">회원가입</a></li>
	<li><a href="">로그인</a></li>
	<li></li>
</ul>
</c:if>
<c:if test="${ not empty Member }"><!-- Member 로그인  -->
<ul>
	<li><a href="">님 어서오세요.</a></li>
	<li><a href="">로그아웃</a></li>
	<li></li>
</ul>
</c:if>
<c:if test="${ not empty Admin }"><!-- Admin 로그인   -->
<ul>
	<li><a href="">관리자 로그인</a></li>
	<li><a href="">로그아웃</a></li>
	<li></li>
</ul>
</c:if>
</body>
</html>