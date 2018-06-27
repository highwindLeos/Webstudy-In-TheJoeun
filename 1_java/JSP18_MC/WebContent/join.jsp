
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>join</title>
	<link href="${conPath }/css/register.css" rel="stylesheet"/>
	<script type="text/javascript" src="${conPath }/js/join.js"></script>
</head>
<%
	if (session.getAttribute("validMember") != null) { // 로그인 했다면 이 페이지를 보이지 않는다.
		response.sendRedirect("main.jsp");
	}
%>
<body>
<div id="wrap">
	<form action="${conPath }/membersJoin.do" method="POST" name="join_frm">
		<table>
			<tr>
				<td colspan="2">회원가입</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" required="required"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr>
				<td>패스워드  확인</td>
				<td><input type="password" name="pwChk" required="required"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" required="required"></td>
			</tr>
			<tr>
				<td>메일</td>
				<td><input type="email" name="email" ></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="birth" ></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" required="required" ></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="회원가입" onclick="infoConfirm()" />
					<input type="reset" value="취소" />
					<input type="button" value="로그인" onclick="location.href = 'login.jsp'" />
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>