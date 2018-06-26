<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Core</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<h3>변수에 관련한 표준태그</h3>
	<c:set var="varName" value="<varValue>"  />
	varName : ${ varName } <br />
	varName : <c:out value="${ varName }" escapeXml="true" /> (특수 문자 포함해서 출력가능.) <br />
	<c:remove var="varName"/>
	varName변수 삭제후 출력하자<br />
	varName : <c:out value="${ varName }" default="변수 없어" escapeXml="true" /><br />
	<hr />
<h3>예외 처리 태그</h3>
	<c:catch var="error">
		<%= 2/0.0 %><br />
	</c:catch>
	<c:out value="${ error }" default="예외발생 안함" />
</body>
</html>