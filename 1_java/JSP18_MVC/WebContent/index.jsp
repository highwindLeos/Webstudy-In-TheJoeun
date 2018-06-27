
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
	<title>Index</title>
	<link rel="stylesheet" href="${conPath }/css/board.css">
	<script>
		
	</script>
</head>
<body>
<c:import url="member/head.jsp" />
<div id="wrap">]
	<table>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td><h1><a href="${conPath }/membersAll.do">회원리스트</a></h1></td>
		</tr>
		<tr>
			<td><h1><a href="${conPath }/joinForm.do">회원가입</a></h1></td>
		</tr>
		<tr>
			<td></td>
		</tr>
	</table>
</div>
<c:import url="member/footer.jsp" />
</body>
</html>