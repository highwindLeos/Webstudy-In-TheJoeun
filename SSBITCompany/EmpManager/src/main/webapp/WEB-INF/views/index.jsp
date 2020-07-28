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
		<link href="${conPath }/css/reset.min.css" rel="stylesheet" type="text/css">
		<link href="${conPath }/css/style.css" rel="stylesheet" type="text/css">
		
		<title>사원 정보</title>
		<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@7.26.28/dist/sweetalert2.all.min.js"></script>
		<script type="text/javascript" src="${conPath }/js/event.js">
		</script>
	</head>
<body>
<c:if test="${not empty modifyMsg }">
<script type="text/javascript">
if(${modifyMsg == '성공'}) {
	swal({
		  type: 'success',
		  title: '성공',
		  text: '사원정보 수정 성공',
		});
} else if (${modifyMsg == '실패'}){
	swal({
		  type: 'error',
		  title: '실패',
		  text: '사원정보 수정 실패',
		});
}
</script>
</c:if>
<c:if test="${not empty writeMsg }">
<script type="text/javascript">
if(${writeMsg == '성공'}) {
	swal({
		  type: 'success',
		  title: '성공',
		  text: '사원정보 입력 성공',
		});
} else if (${writeMsg == '실패'}){
	swal({
		  type: 'error',
		  title: '실패',
		  text: '사원정보 입력 실패',
		});
}
</script>
</c:if>
<div id="wrap">
	<jsp:include page="left.jsp" />
	<div class="box_right">
		<div class="tit f_bold">
			<img alt="icon" src="${conPath }/image/icon.gif"> 사원조회
		</div>
		<div class="float_r main_search">
			<select name="select">
				<option selected>::::: 전체 :::::</option>
			</select> 
			<input name="textfield" type="text" class="input"> <a href="#"><img alt="search" src="${conPath }/image/search.gif"></a>
		</div>
		<div class="float_r main_box">
			<div class="main_tab main_top">
				<img alt="all_icon" src="${conPath }/image/all_icon.gif"> <a href="#" class="modify">수정</a> 
				<img alt="all_icon" src="${conPath }/image/all_icon.gif"> <a href="#">인사기록카드</a> 
				<img alt="all_icon" src="${conPath }/image/all_icon.gif"> <a href="#">경력정보</a> 
				<img alt="all_icon" src="${conPath }/image/all_icon.gif"> <a href="#">근무정보</a>
			</div>
			<!-------------------------  리스트 ------------------------------>
			<table>
				<tr>
					<th width="35px"></th>
					<th width="85px">이름</th>
					<th width="153px">주민번호</th>
					<th width="91px">성별</th>
					<th width="91px">기술등급</th>
					<th width="91px">입사유형</th>
					<th width="94px">근무여부</th>
				</tr>
				<tr><td colspan="7" class="main_bar"></td></tr>
				<c:forEach var="mList" items="${marterList }">
				<tr>
					<td><input type="checkbox" name="user_no" value="${mList.user_No }"></td>
					<td>${mList.kor_Name }</td>
					<td>${mList.jumin_No }</td>
					<td>
						<c:if test="${mList.sex == 1 }">남</c:if>
						<c:if test="${mList.sex == 2 }">여</c:if>
					</td>
					<td>${mList.tech_Grd }</td>
					<td>
						<c:if test="${mList.join_St == 0 }">정규직</c:if>
						<c:if test="${mList.join_St == 1 }">계약직</c:if>
					</td>
					<td>
						<c:if test="${mList.hope_Work == 0 }">SI</c:if>
						<c:if test="${mList.hope_Work == 1 }">SM</c:if>
					</td>
				</tr>
				<tr><td colspan="7" class="main_bar"></td></tr>
				</c:forEach>
			</table>
			<div class="main_paging">
				<c:if test="${paging.startPage > paging.blockSize}">
					<span class="center"><a href="${conPath }/main.do?pageNum=${paging.startPage - 1 }"><img alt="prev" src="${conPath }/image/pre.gif"></a></span>
				</c:if>	
				<a href="#"><img alt="prev_more" src="${conPath }/image/prev.gif"></a>
				<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage }">
					<c:if test="${paging.currentPage == i }"> 
						<span class="center isPage"><b>${i }</b></span>
					</c:if>
					<c:if test="${paging.currentPage != i }">
						<span class="center"><a href="${conPath }/main.do?pageNum=${i }">${i }</a></span>
					</c:if>
				</c:forEach>
				<a href="#"><img alt="next_more" src="${conPath }/image/next_.gif"></a>
				<c:if test="${paging.endPage < paging.pageCnt }">
					<span class="center"><a href="${conPath }/main.do?pageNum=${paging.endPage + 1 }"><img alt="next" src="${conPath }/image/next.gif"></a></span>
				</c:if>
			</div>
			<!-------------------------  리스트 ------------------------------>
			<div class="main_tab main_bottom">
				<img alt="all_icon" src="${conPath }/image/all_icon.gif"> <a href="#" class="modify">수정</a> 
				<img alt="all_icon" src="${conPath }/image/all_icon.gif"> <a href="#">인사기록카드</a> 
				<img alt="all_icon" src="${conPath }/image/all_icon.gif"> <a href="#">경력정보</a> 
				<img alt="all_icon" src="${conPath }/image/all_icon.gif"> <a href="#">근무정보</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>