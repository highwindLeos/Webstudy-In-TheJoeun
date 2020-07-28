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
		<title>공지사항</title>
		<link rel="stylesheet" href="${conPath }/css/notice.css" />
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script>
		  $( function() {
		    $('#accordion').accordion();
		  } );
		</script>
	</head>
<body>
<jsp:include page="../main/head.jsp" />
<c:if test="${not empty nDeleteResult }">
	<script>swal('${nDeleteResult }', '성공','success');</script>
</c:if>
<c:if test="${not empty nModifyResult }">
	<script>swal('${nModifyResult }', '성공','success');</script>
</c:if>
<div class="notice">
	<h2 class="center">공지 사항</h2>
	<div id="accordion">
	  <c:if test="${totalCnt == 0 }">
	  	<h3>표시할 글이 없습니다.</h3>
	  </c:if>
	  <c:if test="${totalCnt != 0 }">
		  <c:forEach items="${list }" var="dto">
			  <h4 class="nTitle">${dto.nTitle } 
			  	<span class="nRdate">${dto.nRdate }</span>
			  	<span class="nAuthor">작성자 : ${dto.nAuthor }</span>
			  </h4>
			  <div>
			    <p class="nContent">
			    	${dto.nContent }
			    	<c:if test="${not empty adminOk }">
					  	<a class="btnModify" href="${conPath }/noticeModifyForm.do?nNum=${dto.nNum }&pageNum=${currentPage }">수정</a>
					  	<a class="btnDel" href="${conPath }/noticeDelete.do?nNum=${dto.nNum }&pageNum=${currentPage }">삭제</a>
				  	</c:if>
			    </p>
			 </div>
		</c:forEach>
	  </c:if>
	</div>
	<%-- 공지 사항 쓰기 --%>
	<c:if test="${not empty adminOk }">
	<div class="admin center">
		<input type="button" value="공지사항 쓰기" onclick="location.href = 'noticeWriteForm.do'">
	</div>
	</c:if>
	<%-- 이전 1 2 3 4 5 6 7 8 9 10 다음 --%>
	<div id="page" class="center">
	<c:if test="${startPage > BLOCKSIZE }">
		<a href="${conPath }/notice.do?pageNum=${startPage - 1 }"><span class="pagingOut">이전</span></a>
	</c:if>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:if test="${i == currentPage }">
			<span class="pagingOut boldLightBlue"><b>${ i }</b></span>
		</c:if>
		<c:if test="${i != currentPage }">
			<a href="${conPath }/notice.do?pageNum=${i}"><span class="pagingOut"><b>${ i }</b></span></a>
		</c:if>
	</c:forEach>
	<c:if test="${endPage < pageCnt  }">
		<a href="${conPath }/notice.do?pageNum=${endPage + 1 }"><span class="pagingOut">다음</span></a>
	</c:if>
	</div>
	
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>