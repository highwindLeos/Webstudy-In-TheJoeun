<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Core4</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<%--  방문횟수에 따른 다른 인사말 출력 --%>
<form action="">
	<p>방문횟수 : <input type="number" name="countNum" autofocus="autofocus" required="required" /></p>
	<p><input type="submit" value="입력" /></p>
</form>
<c:set var="count" value="${ param.countNum }" />
<c:choose>
	<c:when test="${ count == 0 }">
		<h2>첫방문감사합니다.</h2>
	</c:when>
	<c:when test="${ count == 1 }">
		<h2>두번째 방문감사합니다.</h2>
	</c:when>
	<c:when test="${ count >= 2 }">
		<h2>${ count }번째 방문감사합니다.</h2>
	</c:when>
	<c:otherwise>
		<h2>재대로 된 방문 횟수를 입력받지 못했습니다. 다시 입력해주세요.</h2>
	</c:otherwise>
</c:choose>
</body>
</html>