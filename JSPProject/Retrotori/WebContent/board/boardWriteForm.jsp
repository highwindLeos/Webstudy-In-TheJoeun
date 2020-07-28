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
		<link href="${conPath }/css/board.css" rel="stylesheet">
		<title>자유게시판 글쓰기 - Write</title>
	</head>
<body>
<jsp:include page="../main/head.jsp" />
<div id="WriteForm">
	<form action="${conPath }/boardWrite.do" method="POST" enctype="multipart/form-data">
	<input type="hidden" name="mId" value="${sessionMdto.mId }" />
	<table>
		<tr>
			<td>글 제목</td>
		</tr>
		<tr>
			<td><input type="text" name="bTitle" required="required" ></td>
		</tr>
		<tr>
			<td>글 본문</td>
		</tr>
		<tr>
			<td><textarea name="bContent" id="bContent" cols="30" rows="10"></textarea></td>
		</tr>
		<tr>
			<td>첨부 파일</td>
		</tr>
		<tr>
			<td><input type="file" name="bFile1"></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="글쓰기">
			</td>
		</tr>
		<tr>
			<td>
				<input type="reset" value="재설정">
				<input type="button" value="자유게시판 목록" onclick="location.href = 'boardListView.do'" >
			</td>
		</tr>
	</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>