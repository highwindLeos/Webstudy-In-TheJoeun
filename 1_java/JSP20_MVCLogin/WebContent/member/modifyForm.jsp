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
	<title>Modify Form</title>
	</head>
<body>
<div id="wrap">
	<form action="${conPath }/modify.do" method="POST" enctype="multipart/form-data">
		<input type="hidden" name="dbmPhoto" value="${sessionMdto.mPhoto }" />
		<table>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2"><h2>회원수정</h2></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="mId" value="${sessionMdto.mId }" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="mPw" value="${sessionMdto.mPw }" required="required" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="mName" value="${sessionMdto.mName }" required="required" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="mEmail" value="${sessionMdto.mEmail }" required="required" /></td>
			</tr>
			<tr>
				<td>현제 회원사진</td>
				<td colspan="2"><img src="${conPath }/memberPhoto/${sessionMdto.mPhoto }" alt="memberPhoto" /></td>
			</tr>
			<tr>
				<td>회원사진</td>
				<td><input type="file" name="mPhoto" /></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="mBirth" value="${sessionMdto.mBirth }" required="required" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="mAddress" value="${sessionMdto.mAddress }" required="required" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="회원수정" />
					<input type="button" value="회원탈퇴" onclick="location.href = '${conPath }/delete.do'" />
					<input type="button" value="뒤로가기" onclick="location.href = '${conPath }/main.do'" />
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