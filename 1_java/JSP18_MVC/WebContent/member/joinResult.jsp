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
	<title>Join Result</title>
	<link rel="stylesheet" href="${conPath }/css/board.css">
	<script>
		
	</script>
</head>
<body>
<c:import url="head.jsp" />
<div id="wrap">
	<table>
		<tr>
			<td colspan="2"><h1>${joinResult } : 새 회원 정보</h1></td>
		</tr>
		<tr>
			<td><h4>아이디</h4></td>
			<td>${newMember.id }</td>
		</tr>
		<tr>
			<td><h4>패스워드</h4></td>
			<td>${newMember.pw }</td>
		</tr>
		<tr>
			<td><h4>이름</h4></td>
			<td>${newMember.name }</td>
		</tr>
		<tr>
			<td><h4>생년월일</h4></td>
			<td>${newMember.birth }</td>
		</tr>
		<tr>
			<td><h4>가입일</h4></td>
			<td>${newMember.rDate }</td>
		</tr>
		<tr>
			<td><h4>주소</h4></td>
			<td>${newMember.address }</td>
		</tr>
		<tr>
			<td colspan="2"><h4><input type="button" value="전체 회원 리스트" onclick="location.href = 'membersAll.do'" /></h4></td>
		</tr>
		<tr>
			<td colspan="2"><h3>Leos Publising</h3></td>
		</tr>
	</table>
</div>
<c:import url="footer.jsp" />
</body>
</html>