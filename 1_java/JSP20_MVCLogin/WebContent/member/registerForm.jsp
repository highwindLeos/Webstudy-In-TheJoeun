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
	<script src="${conPath }/js/validate.js "></script>
	<title>Register Form</title>
	</head>
<body>
<c:if test="${loginOk != null}">
	<c:redirect url="${conPath }/main.do" />
</c:if>
<div id="wrap">
	<form id="frm_login" action="${conPath }/register.do" method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2"><h2>회원가입</h2></td>
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
				<td>패스워드 확인</td>
				<td><input type="password" name="mPwChk" required="required" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="mName" required="required" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="mEmail" required="required" /></td>
			</tr>
			<tr>
				<td>회원사진</td>
				<td><input type="file" name="mPhoto" required="required" /></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="mBirth" required="required" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="mAddress" required="required" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="회원가입" onclick="return validateForm()" />
					<input type="button" value="로그인" onclick="location.href = 'loginForm.do'" />
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