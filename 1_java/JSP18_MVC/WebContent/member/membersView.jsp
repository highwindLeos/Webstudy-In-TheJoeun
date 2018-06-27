<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>
<c:set var="conPath" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Members All</title>
	<link rel="stylesheet" href="${conPath }/css/board.css">
	<script>
		
	</script>
</head>
<body>
<c:import url="head.jsp" />
<div id="wrap">
	<table>
		<tr>
			<td colspan="8"></td>
		</tr>
		<tr>
			<td colspan="8"><h1>Members Table List</h1></td>
		</tr>
		<c:set var="i" value="1" />
		<c:forEach var="mt" items="${membersAll }" >
		<tr>
			<td>${i }</td>
			<td>${mt.id }</td>
			<td>${mt.pw }</td>
			<td>${mt.name }</td>
			<td>${mt.email }</td>
			<td>${mt.birth }</td>
			<td>${mt.rDate }</td>
			<td>${mt.address }</td>
			<c:set var="i" value="${i+1 }" />
		</tr>
		</c:forEach>
		<tr>
			<td colspan="8"><input type="button" onclick="location.href='joinForm.do'" value="회원가입"></td>
		</tr>
		<tr>
			<td colspan="8"><h3>Leo Publising</h3></td>
		</tr>
	</table>
</div>
<c:import url="footer.jsp" />
</body>
</html>