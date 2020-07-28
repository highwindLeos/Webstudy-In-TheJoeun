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
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="https://fonts.googleapis.com/css?family=Arvo|Lato|Roboto+Condensed" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css">
		<link href="${conPath }/css/reset.css" rel="stylesheet">
		<link href="${conPath }/css/main.css" rel="stylesheet">
		<title>Login</title>
	</head>
<body>
<c:if test="${not empty loginOk }">
	<script>location.href = 'mainView.do';</script>
</c:if>
<jsp:include page="../main/head.jsp"/>
<c:if test="${not empty registerResuilt }">
	<script>swal('${registerResuilt}', '', 'success');</script>
</c:if>
<div id="wrap">
	<form action="${conPath }/login.do" method="POST">
	<table id="login">
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td colspan="2">
				<h2><i class="fas fa-user-circle fa-2x"></i> Login</h2>
			</td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" id="mId" name="mId" required="required" /></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input type="password" id="mPw" name="mPw" required="required" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Login" />
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" class="adminLoginBtn" value="Admin Login" onclick="location.href = 'adminLoginForm.do'"></td>
		</tr>
	</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>