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
		<title>GameList</title>
		<link rel="stylesheet" type="text/css" href="${conPath }/css/game.css"/>
	</head>
<body>
<jsp:include page="../main/head.jsp" />
<c:if test="${not empty writeGameResult }">
	<script>swal('${writeGameResult }','','success');</script>
</c:if>
<c:if test="${not empty gameDeleteResult }">
	<script>swal('${gameDeleteResult }','','success');</script>
</c:if>
<div id="games">
	 <c:if test="${totalCnt eq 0 }">
	 <figure>
       <img src="${conPath }/img/nothing.png">
       <figcaption>표시한 글이 없습니다.</figcaption>
     </figure>
	 </c:if>
	 <c:if test="${totalCnt != 0 }">
		<c:forEach var="gameDto" items="${gamelist }">
		<figure>
		   <h3 class="gamegName left colorDarkGray"><i class="fas fa-gamepad"></i>
		   <span>${gameDto.gName }</span></h3>
	       <a href="${conPath }/gameContentView.do?gId=${gameDto.gId }">
	       		<img id="gameImage" src="${conPath }/gameImg/${gameDto.gImage }" alt="${gameDto.gImage }">
	       </a>
	       <figcaption>
	       		<p class="gamegPub">${gameDto.gPub }</p>
	       		<p class="gamegRdate"><fmt:formatDate value="${gameDto.gRdate }" pattern="yyyy.MM.dd"/></p>
	       		<p class="gamegRname">${gameDto.gRname }</p>
	       	</figcaption>
	    </figure>
		</c:forEach>
	 </c:if>
</div>
<c:if test="${not empty adminOk }">
 <div class="center">
	<input type="button" value="게임등록" onclick="location.href = '${conPath }/gameWriteForm.do'" >		
 </div>
</c:if>
<br />
<hr />
 <div id="pageBoard" class="center">
	<%-- 이전 1 2 3 4 5 6 7 8 9 10 다음 --%>
	<c:if test="${startPage > BLOCKSIZE }">
		<a href="${conPath }/gameListView.do?pageNum=${startPage - 1 }"><span class="pagingOut">이전</span></a>
	</c:if>
	<c:forEach var="i" begin="${startPage }" end="${endPage }">
		<c:if test="${i == currentPage }">
			<span class="pagingOut boldLightBlue"><b>${ i }</b></span>
		</c:if>
		<c:if test="${i != currentPage }">
			<a href="${conPath }/gameListView.do?pageNum=${i}"><span class="pagingOut"><b>${ i }</b></span></a>
		</c:if>
	</c:forEach>
	<c:if test="${endPage < pageCnt  }">
		<a href="${conPath }/gameListView.do?pageNum=${endPage + 1 }"><span class="pagingOut">다음</span></a>
	</c:if>
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>