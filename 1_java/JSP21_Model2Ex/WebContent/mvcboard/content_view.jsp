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
	<title>Content Form</title>
	</head>
<body>
<jsp:include page="../main/head.jsp" />
<div id="wrap">
	<form action="${conPath }/Bmodify.do" method="POST">
		<input type="hidden" name="bId" value="${content_view.bId  }" />
		<input type="hidden" name="pageNum" value="${param.pageNum  }" />		
	<table>
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td colspan="2"><h2>${content_view.bId }번 글의 내용</h2></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="bName" value="${content_view.mId }" readonly="readonly" /></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" name="bTitle" value="${content_view.bTitle }" required="required" /></td>
		</tr>
		<tr>
			<td>본문</td>
			<td>
				<textarea name="bContent" cols="32" rows="10" required="required" />${content_view.bContent }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<c:if test="${member.mId == content_view.mId }">
				<input type="submit" value="글수정"/>
				<input type="button" value="글삭제" onclick="location.href='${conPath}/delete.do?bId=${content_view.bId }&pageNum=${param.pageNum }'" />
			</c:if>
			<c:if test="${not empty member}">
				<input type="button" value="답변글" onclick="location.href='${conPath}/reply_View.do?bId=${content_view.bId }&pageNum=${param.pageNum }'" />
			</c:if>
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
<jsp:include page="../main/footer.jsp" />
</body>
</html>