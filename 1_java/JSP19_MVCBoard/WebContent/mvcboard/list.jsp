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
	<title>List Board</title>
	</head>
<body>
<c:if test="${ msg != null }">
	<script>alert('${ msg }')</script>
</c:if>
<div id="wrap">
	<table>
		<tr>
			<td colspan="6"></td>
		</tr>
		<tr>
			<td>글번호</td>
			<td>작성자</td>
			<td>글제목</td>
			<td>조회수</td>
			<td>작성일</td>
			<td>IP</td>
		</tr>
		<c:if test="${totalCnt == 0 }">
		<tr>
			<td colspan="6">표시할 글이 없습니다.</td>
		</tr>
		</c:if>
		<c:if test="${totalCnt != 0 }">
			<c:forEach items="${list }" var="dto">
				<tr>
					<td>${dto.bId }</td>
					<td>${dto.bName }</td>
					<td class="left">
						<c:forEach var="i" begin="1" end="${dto.bIndent }" >
						 <c:if test="${i == dto.bIndent }">
						 	<img id="arrow" src="${conPath }/img/arrow.png" alt="arrow" />
						 </c:if>
						 <c:if test="${i != dto.bIndent }">
						 	&nbsp;&nbsp;
						 </c:if>
						</c:forEach>
						<a href="${conPath }/content_view.do?bId=${dto.bId }&pageNum=${currentPage }">${dto.bTitle }</a>
					</td>
					<td>${dto.bHit }</td>
					<td><fmt:formatDate value="${dto.bDate }" pattern="yyyy-MM-dd" /></td>
					<td>${dto.bIp }</td>
				</tr>
			</c:forEach>
		</c:if>
		<tr>
			<%-- 이전 1 2 3 4 5 6 7 8 9 10 다음 --%>
			<td colspan="6">
				<c:if test="${startPage > BLOCKSIZE }">
					<a href="${conPath }/list.do?pageNum=${startPage - 1 }"><span class="pagingOut">이전</span></a>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<c:if test="${i == currentPage }">
						<span class="pagingOut colorwhite"><b>${ i }</b></span>
					</c:if>
					<c:if test="${i != currentPage }">
						<a href="${conPath }/list.do?pageNum=${i}"><span class="pagingOut"><b>${ i }</b></span></a>
					</c:if>
				</c:forEach>
				<c:if test="${endPage < pageCnt  }">
					<a href="${conPath }/list.do?pageNum=${endPage + 1 }"><span class="pagingOut">다음</span></a>
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="6"><input type="button" value="글쓰기" onclick="location.href='${conPath}/write_view.do'" /></td>
		</tr>
		<tr>
			<td colspan="6">Publising LeoDays</td>
		</tr>
	</table>
</div>
</body>
</html>