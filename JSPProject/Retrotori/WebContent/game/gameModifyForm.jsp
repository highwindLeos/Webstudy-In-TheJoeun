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
	<title>Game Modify</title>
	<link href="${conPath }/css/game.css" rel="stylesheet">
	
	<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>
	
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	<script src="${conPath }/js/datapicker.js"></script>
</head>
<body>
<jsp:include page="../main/head.jsp" />
<form action="${conPath }/gameModify.do" method="POST" enctype="multipart/form-data">
<input type="hidden" name="gId" value="${gameDto.gId }"/>
<div id="content">
	<table class="center">
		<tr>
			<td><h3>게임 정보 수정</h3></td>
		</tr>
		<tr>
			<td><h3>게임 제목</h3></td>
		</tr>
		<tr>
			<td><input type="text" name="gName" value="${gameDto.gName }" required="required" /></td>
		</tr>
		<tr>
			<td><h3>현제 게임 메인이미지</h3></td>
		</tr>
		<tr>
			<td>
				<img class="gameImage" src="${conPath }/gameImg/${gameDto.gImage }" alt="${gameDto.gImage }" />
			</td>
		</tr>
		<tr>
			<td><input type="file" name="gImage" /></td>
		</tr>
		<tr>
			<td><h3>게임 장르</h3></td>
		</tr>
		<tr>
			<td>
				<c:if test='${gameDto.gId.indexOf("A") == 0 }'> 
					<select name="gIdTag" id="gIdTag" required="required">
						<option value="">선택해주세요</option>
						<option value="A" selected="selected">아케이드/액션</option>
						<option value="S">슈팅</option>
						<option value="R">RPG</option>
						<option value="M">시뮬레이션</option>
						<option value="P">퍼즐/퀴즈</option>
					</select>
				</c:if>
				<c:if test='${gameDto.gId.indexOf("S") == 0 }'> 
					<select name="gIdTag" id="gIdTag" required="required">
						<option value="">선택해주세요</option>
						<option value="A">아케이드/액션</option>
						<option value="S" selected="selected">슈팅</option>
						<option value="R">RPG</option>
						<option value="M">시뮬레이션</option>
						<option value="P">퍼즐/퀴즈</option>
					</select>
				</c:if>
				<c:if test='${gameDto.gId.indexOf("R") == 0 }'> 
					<select name="gIdTag" id="gIdTag" required="required">
						<option value="">선택해주세요</option>
						<option value="A">아케이드/액션</option>
						<option value="S">슈팅</option>
						<option value="R" selected="selected">RPG</option>
						<option value="M">시뮬레이션</option>
						<option value="P">퍼즐/퀴즈</option>
					</select>
				</c:if>
				<c:if test='${gameDto.gId.indexOf("M") == 0 }'> 
					<select name="gIdTag" id="gIdTag" required="required">
						<option value="">선택해주세요</option>
						<option value="A">아케이드/액션</option>
						<option value="S">슈팅</option>
						<option value="R">RPG</option>
						<option value="M" selected="selected">시뮬레이션</option>
						<option value="P">퍼즐/퀴즈</option>
					</select>
				</c:if>
				<c:if test='${gameDto.gId.indexOf("P") == 0 }'> 
					<select name="gIdTag" id="gIdTag" required="required">
						<option value="">선택해주세요</option>
						<option value="A">아케이드/액션</option>
						<option value="S">슈팅</option>
						<option value="R">RPG</option>
						<option value="M">시뮬레이션</option>
						<option value="P" selected="selected">퍼즐/퀴즈</option>
					</select>
				</c:if>
			</td>
		</tr>
		<tr>
			<td><h3>게임 설명</h3></td>
		</tr>
		<tr>
			<td>
				<textarea id="gDes" name="gDes">${gameDto.gDes }</textarea>
			</td>
		</tr>
		<tr>
			<td><h3>게임 제작사</h3></td>
		</tr>
		<tr>
			<td><input type="text" name="gPub" value="${gameDto.gPub }" required="required" /></td>
		</tr>
		<tr>
			<td><h3>게임 제작일</h3></td>
		</tr>
		<tr>
			<td>
				<div id="datepicker2"></div><span id="dateResult">${gameDto.gRdate }</span>
				<input type="hidden" id="gRdate" name="gRdate"  />
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="게임정보 수정하기" />
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