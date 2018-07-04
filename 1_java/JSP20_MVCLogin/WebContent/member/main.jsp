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
	<title>Main</title>
	</head>
<body>
<c:if test="${empty loginOk }"><%-- 로그인 사용자만 접근 --%>
	<c:redirect url="${conPath }/loginForm.do" />
</c:if>
<c:if test="${not empty modifyMsg}">
	<script>alert('${modifyMsg}');</script>
</c:if>
<div id="wrap">
	<form action="${conPath }/modifyForm.do" method="POST" enctype="multipart/form-data">
	<input type="hidden" name="mId" value="${sessionMdto.mId }">
	<table>
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td><h1>${sessionMdto.mName } 님 어서오세요.</h1></td>
			<td><img id="memberImg" src="${conPath }/memberPhoto/${sessionMdto.mPhoto }" alt="memberPhoto" /></td>
		</tr>
		<tr>
			<td colspan="2"><h3>가입일 : <fmt:formatDate value="${sessionMdto.mRdate }" pattern="yyyy.MM.dd"/></h3></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="정보수정" />
				<input type="button" value="로그아웃" onclick="location.href = 'logout.do'" />
				<input type="button" value="전체 회원보기" onclick="location.href = 'mAllView.do'"  />
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