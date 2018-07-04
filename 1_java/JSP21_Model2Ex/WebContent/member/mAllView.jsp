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
	<title>List Member</title>
	</head>
<body>
<c:if test="${not empty adminLoginResult }">
	<script>alert('${adminLoginResult}');</script>
</c:if>

<jsp:include page="../main/head.jsp" />
<div id="wrap">
	<table>
		<tr>
			<td colspan="8"></td>
		</tr>
	
		<tr>
			<c:forEach items="${list }" var="mt" >
				<td>
					<img class="imgBook" src="${conPath }/memberPhoto/${mt.mPhoto }" alt="memberPhoto" /><br />
					<b>${mt.mName }</b><br />
					<u>(${mt.mId })</u><br />
					<fmt:formatDate value="${mt.mRdate }" pattern="yyyy.MM.dd" /> <br />
				</td>
			</c:forEach>
		</tr>
		<tr>
			<td colspan="3">
				<c:if test="${startPage > BLOCKSIZE }">
					<a href="${conPath }/mAllView.do?pageNum=${startPage - 1 }"><span class="pagingOut">이전</span></a>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }">
					<c:if test="${i == currentPage }">
						<span class="pagingOut colorwhite"><b>${ i }</b></span>
					</c:if>
					<c:if test="${i != currentPage }">
						<a href="${conPath }/mAllView.do?pageNum=${i}"><span class="pagingOut"><b>${ i }</b></span></a>
					</c:if>
				</c:forEach>
				<c:if test="${endPage < pageCnt  }">
					<a href="${conPath }/mAllView.do?pageNum=${endPage + 1 }"><span class="pagingOut">다음</span></a>
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="3"><h3>Publising Leo</h3></td>
		</tr>
	</table>
</div>	
<jsp:include page="../main/footer.jsp" />
</body>
</html>