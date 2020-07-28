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
		<title>게임 상세 검색</title>
		<link href="${conPath }/css/game.css" rel="stylesheet">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script>
		$(document).ready(function(){
			 $('#searchBtn').click(function(){
				var sandData = 
				'gName='+$('#gName').val()+'&gPub='+$('#gPub').val()+'&gDes='+$('#gDes').val()
			   +'&gGrade='+$('#gGrade option:selected').val()+'&gradeAvg='+$('#gradeAvg option:selected').val()+'&gIdTag='+$('#gIdTag option:selected').val();
				$.ajax({
					url : '${conPath }/searchGameDetail.do',
					type : 'post',
					data : sandData,
					dataType : 'html',
					success : function(data, status){
						$('#showGame').html(data);
					},
					error : function(){
						$('#showGame').html('');
					}
				 });
			 });
		}); 
		</script>
	</head>
<body>
<jsp:include page="../main/head.jsp" />
<div id="content">
	<table class="center">
		<tr>
			<td colspan="6" class="left"><img class="contentTitle" src="${conPath }/img/contentTitle.png" alt="Title" /> 게임검색 : 세부검색하기</td>
		</tr>
		<tr>
			<td colspan="2">게임명</td>
			<td colspan="4"><input type="text" name="gName" id="gName" /></td>
		</tr>
		<tr>
			<td colspan="2">개발사</td>
			<td colspan="4"><input type="text" name="gPub" id="gPub" /></td>
		</tr>
		<tr>
			<td colspan="2">게임 설명내용</td>
			<td colspan="4"><input type="text" name="gDes" id="gDes" /></td>
		</tr>
		<tr>
			<td>게임 등급</td>
			<td>
				<select name="gGrade" id="gGrade">
					<option value="1">브론즈</option>
					<option value="2">실버</option>
					<option value="3">골드</option>
					<option value="4">플래티넘</option>
					<option value="5">프리미엄</option>
					<option value="6">레전드</option>
				</select>
			</td>
			<td>게임 평점</td>
			<td>
				<select name="gradeAvg" id="gradeAvg">
					<option value="0">0</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
				</select>
				이상
			</td>
			<td>게임 장르</td>
			<td>
				<select name="gIdTag" id="gIdTag">
					<option value="A">아케이드/액션</option>
					<option value="S">슈팅</option>
					<option value="R">RPG</option>
					<option value="M">시뮬레이션</option>
					<option value="P">퍼즐/퀴즈</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="6"><input id="searchBtn" type="button" value="검색하기" /></td>
		</tr>
	</table>
	<div id="showGame"></div>
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>