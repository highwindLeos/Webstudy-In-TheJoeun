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
		<link href="${conPath }/css/game.css" rel="stylesheet">
		<title>Search Detail Result</title>
	</head>
<body>
<div id="content">
	<table class="center">
		<tr>
			<td colspan="9" class="left">게임검색 결과</td>
		</tr>
		<tr>
			<td>게임등록아이디</td>
			<td>게임명</td>
			<td>게임이미지</td>
			<td>개발사</td>
			<td>제작년도</td>
			<td>총점</td>
			<td>투표수</td>
			<td>평점</td>
			<td>현재 게임등급</td>
		</tr>
		<c:forEach var="gameList" items="${searchDetailList }" >
		<tr>
			<td><a href="${conPath }/gameContentView.do?gId=${gameList.gId }">${gameList.gId }</a></td>
			<td><a href="${conPath }/gameContentView.do?gId=${gameList.gId }">${gameList.gName }</a></td>
			<td>
				<a href="${conPath }/gameContentView.do?gId=${gameList.gId }">
					<img class="gameSearch" src="${conPath }/gameImg/${gameList.gImage }" alt="gameImg" />
				</a>
			</td>
			<td>${gameList.gPub }</td>
			<td>${gameList.gRdate }</td>
			<td>${gameList.gGrade }</td>
			<td>${gameList.gVoteCnt }</td>
			<td>${gameList.gradeAvg }</td>
			<td>
				<c:if test="${gameList.gGno == 1 }">
					<img class="gradeImg" src="${conPath }/img/grade/bronze.png" alt="bronze" />
				</c:if>
				<c:if test="${gameList.gGno == 2 }">
					<img src="${conPath }/img/grade/silver.png" alt="silver" />
				</c:if>
				<c:if test="${gameList.gGno == 3 }">
					<img src="${conPath }/img/grade/gold.png" alt="gold" />
				</c:if>
				<c:if test="${gameList.gGno == 4 }">
					<img src="${conPath }/img/grade/platinum.png" alt="platinum" />
				</c:if>
				<c:if test="${gameList.gGno == 5 }">
					<img src="${conPath }/img/grade/primium.png" alt="primium" />
				</c:if>
				<c:if test="${gameList.gGno == 6 }">
					<img src="${conPath }/img/grade/legend.png" alt="legend" />
				</c:if>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="9">총 ${searchDetailList.size() } 건 출력 되었습니다.</td>
		</tr>
	</table>
	<c:if test="${searchDetailList == null }">
	<table class="center">
		<tr>
			<td colspan="2" class="left">검색 결과가 없습니다.</td>
		</tr>
	</table>	
	</c:if>
</div>	
</body>
</html>