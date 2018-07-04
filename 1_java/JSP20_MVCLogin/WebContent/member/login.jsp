<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${conPath }/css/board.css" rel="stylesheet">
	<script></script>
	<title>Login</title>
</head>
<c:if test="${loginOk != null}">
	<c:redirect url="${conPath }/main.do" />
</c:if>
<c:if test="${not empty registerResuilt}">
	<script>alert('${registerResuilt}');</script>
</c:if>
<c:if test="${not empty checkResult}">
	<script>alert('${checkResult}');</script>
</c:if>
<c:if test="${not empty deleteResult}">
	<script>alert('${deleteResult}');</script>
</c:if>
<body>
<div id="wrap">
	<form action="${conPath }/login.do" method="POST">
		<table>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2"><h2>로그인</h2></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="mId" required="required" /></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="mPw" required="required" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인" />
					<input type="button" value="회원가입" onclick="location.href = 'registerForm.do'" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><h3>Publising Leo</h3></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>