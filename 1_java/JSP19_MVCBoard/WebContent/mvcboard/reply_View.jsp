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
	<title>Reply Form</title>
	</head>
<body>
<div id="wrap">
	<form action="${conPath }/reply.do" method="POST">
		<input type="hidden" name="bId" value="${replyView.bId }" />
		<input type="hidden" name="pageNum" value="${param.pageNum }" />
		
		<input type="hidden" name="bGroup" value="${replyView.bGroup }" />
		<input type="hidden" name="bStep" value="${replyView.bStep }" />
		<input type="hidden" name="bIndent" value="${replyView.bIndent }" />
		
	<table>
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td colspan="2"><h2>${replyView.bId }번 글의 답변</h2></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="bName" value="${replyView.bName }" required="required" /></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="bTitle" value="[re]${replyView.bTitle }" required="required" /></td>
		</tr>
		<tr>
			<td>본문</td>
			<td>
				<textarea name="bContent" cols="32" rows="10" required="required" />${replyView.bContent }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="답변글달기"  />
				<input type="button" value="목록가기" onclick="location.href='${conPath}/list.do?pageNum=${param.pageNum }'" />
				<input type="reset" value="재설정"/>
			</td>
		</tr>
		<tr>
			<td colspan="2"><h3>Publising LeoDays</h3></td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>