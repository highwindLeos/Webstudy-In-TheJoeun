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
		<title>자유게시판 답변  - ReplyWrite</title>
	</head>
<body>
<jsp:include page="../main/head.jsp" />
<div id="WriteForm">
	<form action="${conPath }/boardReply.do" method="POST" enctype="multipart/form-data" >
		<input type="hidden" name="bNum" value="${replyView.bNum }" />
		<input type="hidden" name="mId" value="${Mdto.mId }" />
		<input type="hidden" name="pageNum" value="${param.pageNum }" />
		
		<input type="hidden" name="bRef" value="${replyView.bRef }" />
		<input type="hidden" name="bStep" value="${replyView.bStep }" />
		<input type="hidden" name="bLevel" value="${replyView.bLevel }" />
		
	<table>
		<tr>
			<td colspan="2"><h2>${replyView.bNum }번 글의 답변</h2></td>
		</tr>
		<tr>
			<td>원글 작성자</td>
		</tr>
		<tr>
			<td>
				<img class="memberPhoto" src="${conPath }/memberPhoto/${replyView.mPhoto }" alt="" /><br />
				<input type="text" name="bName" value="${replyView.mName }" readonly="readonly" />
			</td>
		</tr>
		<tr>
			<td>제목</td>
		</tr>
		<tr>
			<td><input type="text" name="bTitle" value="[re]${replyView.bTitle }" required="required" /></td>
		</tr>
		<tr>
			<td>본문</td>
		</tr>
		<tr>
			<td>
				<textarea name="bContent" cols="32" rows="10" required="required" />[re]${replyView.bContent }</textarea>
			</td>
		</tr>
		<tr>
			<td>첨부파일</td>
		</tr>
		<tr>
			<td><input type="file" name="bFile1" /></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="답변글 달기"  />
			</td>
		</tr>
		<tr>
			<td>
				<input type="reset" value="재설정"/>
				<input type="button" value="목록가기" onclick="location.href='${conPath}/boardListView.do?pageNum=${param.pageNum }'" />
			</td>
		</tr>
	</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>