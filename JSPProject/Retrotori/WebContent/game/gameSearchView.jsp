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
		<title>게임 검색</title>
		<link href="${conPath }/css/game.css" rel="stylesheet">
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script>
		$(document).ready(function(){
			 $('#gName,#gPub,#gDes').keyup(function(){
				var sandData = 'gName='+$('#gName').val()+'&gPub='+$('#gPub').val()+'&gDes='+$('#gDes').val();
				$.ajax({
					url : '${conPath }/searchGame.do',
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
			<td colspan="2" class="left"><img class="contentTitle" src="${conPath }/img/contentTitle.png" alt="Title" /> 게임검색</td>
		</tr>
		<tr>
			<td>게임명</td>
			<td><input type="text" name="gName" id="gName" /></td>
			
		</tr>
		<tr>
			<td>개발사</td>
			<td><input type="text" name="gPub" id="gPub" /></td>
		</tr>
		<tr>
			<td>게임 설명내용</td>
			<td><input type="text" name="gDes" id="gDes" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="상세검색" onclick="location.href = '${conPath }/searchDetailView.do'" /></td>
		</tr>
	</table>
	<div id="showGame"></div>
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>