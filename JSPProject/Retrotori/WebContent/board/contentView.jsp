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
		<title>게시글 보기</title>
	</head>
<body>
<jsp:include page="../main/head.jsp" />
<c:if test="${not empty LikeResult }">
	<script>swal('${LikeResult}', '', 'success');</script>
</c:if>
<div id="wrap">
<table id="content">
	<tr>
		<td class="backgroundDarkGray"><img class="contentTitle" src="${conPath }/img/contentTitle.png" alt="Title" /><b class="boldWhite">${bDto.bTitle }</b></td>
	</tr>
	<tr>
		<td class="relative">
			<p class="inlineBlock" >
				<img class="memberPhoto" src="${conPath }/memberPhoto/${bDto.mPhoto }" alt="memberPhoto" />
			</p>
			<table class="inlineBlock userInfo">
				<tr>
					<td>작성번호 : <span class="boldLightBlue">${bDto.bNum }</span></td>
				</tr>
				<tr>
					<td>작성자 아이디 : <span class="boldCoral">${bDto.mId }</span></td>
				</tr>
				<tr>
					<td>작성자 : <span class="boldCoral">${bDto.mName }</span></td>
				</tr>
			</table>
			<c:if test="${not empty loginOk }">
				<button  class="boardLike" onclick="location.href = '${conPath }/BoardLikeService.do?bNum=${bDto.bNum }'" >좋아요</button>
			</c:if>
			<table class="boardCount">
				<tr>
					<td>조회수 <span class="boldCoral">${bDto.bCnt }</span> 좋아요 수 <span class="boldCoral">${bDto.bLike }</span></td>
				</tr>
			</table>
			<table class="boardDate">
				<tr>
					<td>작성일 : <span class="boldCoral">${bDto.bRdate }</span> 작성시 IP :<span class="boldCoral">${bDto.bIp }</span> </td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>${bDto.bContent }</td>
	</tr>
	<tr>
		<td>첨부 화일 : <span class="boldLightBlue"><c:if test="${empty bDto.bFile1 }">첨부화일 없음</c:if>
			<a class="boldLightBlue" href="${conPath }/freeboardFile/${bDto.bFile1 }">${bDto.bFile1 }</a></span>
		</td>
	</tr>
	<tr>
		<td class="center">
		<c:if test="${bDto.mId == sessionMdto.mId or not empty adminOk }"><%-- 로그인 하고 자기글과  관리자는  보임--%>
			<input type="button" value="글수정" onclick="location.href = 'boardModifyForm.do?bNum=${bDto.bNum}&pageNum=${currentPage }'" />
			<input type="button" value="글삭제" onclick="location.href = 'boardDelete.do?bNum=${bDto.bNum}&pageNum=${currentPage }'" />
		</c:if>
		<c:if test="${not empty loginOk }">
			<input type="button" value="답글달기" onclick="location.href = 'boardReplyForm.do?bNum=${bDto.bNum}&pageNum=${currentPage }'" />
		</c:if>
			<input type="button" value="게시판 리스트" onclick="location.href = 'boardListView.do'" />
		</td>
	</tr>
</table>
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>