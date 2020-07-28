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
	<title>Game Write</title>
	<link href="${conPath }/css/game.css" rel="stylesheet">
	
	<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>

	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	<script src="${conPath }/js/datapicker.js"></script>
</head>
<body>
<jsp:include page="../main/head.jsp" />
<form action="${conPath }/gameWrite.do" method="POST" enctype="multipart/form-data">
<div id="content">
	<table class="center">
		<tr>
			<td class="left"><h3>게임 등록</h3></td>
		</tr>
		<tr>
			<td><h3>게임 제목</h3></td>
		</tr>
		<tr>
			<td><input type="text" name="gName" required="required" /></td>
		</tr>
		<tr>
			<td><h3>게임 제작사</h3></td>
		</tr>
		<tr>
			<td><input type="text" name="gPub" required="required" /></td>
		</tr>
		<tr>
			<td><h3>게임 메인이미지</h3></td>
		</tr>
		<tr>
			<td><input type="file" name="gImage" /></td>
		</tr>
		<tr>
			<td><h3>게임 장르</h3></td>
		</tr>
		<tr>
			<td>
				<select name="gIdTag" id="gIdTag" required="required">
					<option value="">선택해주세요</option>
					<option value="A">아케이드/액션</option>
					<option value="S">슈팅</option>
					<option value="R">RPG</option>
					<option value="M">시뮬레이션</option>
					<option value="P">퍼즐/퀴즈</option>
				</select>
			</td>
		</tr>
		<tr>
			<td><h3>게임 설명</h3></td>
		</tr>
		<tr>
			<td><textarea name="gDes" id="gDes" cols="30" rows="10"></textarea></td>
		</tr>
		<tr>
			<td><h3>게임 제작일</h3></td>
		</tr>
		<tr>
			<td>
				<div id="datepicker2"></div><span id="dateResult"></span>
				<input type="hidden" id="gRdate" name="gRdate"  />
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="게임등록하기" />
			</td>
		</tr>
		<tr>
			<td>
				<input type="reset" value="입력리셋" />
				<input type="button" value="게임 리스트보기" onclick="location.href = '${conPath }/gameListView.do'" />
			</td>
		</tr>
	</table>
</div>
</form>
<jsp:include page="../main/footer.jsp" />
<script>
	CKEDITOR.replace( 'gDes' );
</script>
</body>
</html>