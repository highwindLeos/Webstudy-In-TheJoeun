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
		<link href="" rel="stylesheet">
		<script></script>
		<title>공지사항</title>
	</head>
<body>
<jsp:include page="../main/head.jsp" />
<div id="wrap">
	<form id="frm_notice" action="${conPath }/noticeWrite.do" method="POST">
	<input type="hidden" name="nAuthor" value="${Adto.aName }" />
	<table id="notice">
		<tr>
			<td colspan="2">
				<h2>공지사항 작성</h2>
			</td>
		</tr>
		<tr>
			<td>공지 사항 제목</td>
			<td><input type="text" id="nTitle" name="nTitle" required="required" /></td>
		</tr>
		<tr>
			<td>공지 사항 내용</td>
			<td>
				<textarea name="nContent" rows="12" cols="40"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="공지사항 등록"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="reset" value="재설정" />
				<input type="button" value="공지사항보기" onclick="location.href = 'notice.do'" />
			</td>
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>
	</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>