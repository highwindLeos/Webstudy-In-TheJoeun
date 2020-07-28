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
		<script></script>
		<title>Login</title>
	</head>
<body>
<c:if test="${not empty adminOk }">
<script>location.href = 'mainView.do';</script>
</c:if>
<c:if test="${not empty registerResuilt }">
<script>alert('${registerResuilt}');</script>
</c:if>
<jsp:include page="../main/head.jsp"/>
<div id="wrap">
	<form action="${conPath }/adminLogin.do" method="POST">
	<table id="login">
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td colspan="2">
				<h2><i class="fas fa-lock fa-2x"></i> 관리자 Login</h2>
			</td>
		</tr>
		<tr>
			<td>관리자 아이디</td>
			<td><input type="text" id="aId" name="aId" required="required" /></td>
		</tr>
		<tr>
			<td>관리자 패스워드</td>
			<td><input type="password" id="aPw" name="aPw" required="required" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value=" 관리자 Login" />
			</td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="회원 Login" onclick="location.href = 'loginForm.do'"></td>
		</tr>
	</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>