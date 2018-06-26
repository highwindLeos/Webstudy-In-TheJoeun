<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Core3</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<%
	if (1+2 == 3){
		// 명령1
	} 
	if (1+2 != 3){
		
	}	
%>
<h3>c:if Tag</h3>
	<c:if test="${ 1+2 eq 3 }" var="result1" scope="request" >
		<h3>1+2는 3입니다.</h3>
	</c:if>
	<c:if test="${ 1+2 != 3 }" var="result2" scope="request" >
		<h3>1+2는 3는 이 아닙니다.</h3>
	</c:if>
	<p>조건 1의 결과 : ${ result1 }</p>
	<p>조건 2의 결과 : ${ result2 }</p>
</body>
</html>