
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
		<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="${conPath }/js/starvote.js"></script>
		<title>Game Content 보기</title>
	</head>
<body>
<jsp:include page="../main/head.jsp" />
<c:if test="${not empty gameVoteResult }">
	<script>swal('${gameVoteResult }', '', 'success');</script>
</c:if>
<c:if test="${not empty comantWriteResult }">
	<script>swal('${comantWriteResult }', '', 'success');</script>
</c:if>
<c:if test="${not empty comantDeleteResult }">
	<script>swal('${comantDeleteResult }', '', 'success');</script>
</c:if>
<div id="content">
	<table>
		<tr>
			<td>
				<h2><img class="gameTitle" src="${conPath }/img/contentTitle.png" alt="title" />
				${gameContent.gName } [ ${gameContent.gId } ]</h2>
			</td>
		</tr>
		<tr>
			<td>
				<p class="center">
		        	<img class="gameImage" src="${conPath }/gameImg/${gameContent.gImage }" alt="gameImage" />
				</p>
				<hr />
				<table class="center">
					<tr>
						<td>게임이름</td>
						<td>${gameContent.gName }</td>
						<td>제작사</td>
						<td>${gameContent.gPub }</td>
						<td>출시일</td>
						<td>${gameContent.gRdate }</td>
					</tr>
					<tr>
						<td colspan="2">평가치</td>
						<td colspan="1">투표수</td>
						<td colspan="1">평점</td>
						<td colspan="2">게임등급</td>
					</tr>
					<tr>
						<td colspan="2"><h4>${gameContent.gGrade } Point</h4></td>
						<td colspan="1"><h4>${gameContent.gVoteCnt } 명 참여</h4></td>
						<td colspan="1"><h4>${gameContent.gradeAvg } 점</h4></td>
						<td colspan="2">
							<c:if test="${gameContent.gGno == 1 }">
								<img class="gradeImg" src="${conPath }/img/grade/bronze.png" alt="bronze" />
							</c:if>
							<c:if test="${gameContent.gGno == 2 }">
								<img src="${conPath }/img/grade/silver.png" alt="silver" />
							</c:if>
							<c:if test="${gameContent.gGno == 3 }">
								<img src="${conPath }/img/grade/gold.png" alt="gold" />
							</c:if>
							<c:if test="${gameContent.gGno == 4 }">
								<img src="${conPath }/img/grade/platinum.png" alt="platinum" />
							</c:if>
							<c:if test="${gameContent.gGno == 5 }">
								<img src="${conPath }/img/grade/primium.png" alt="primium" />
							</c:if>
							<c:if test="${gameContent.gGno == 6 }">
								<img src="${conPath }/img/grade/legend.png" alt="legend" />
							</c:if>
						</td>
					</tr>
					<c:if test="${not empty loginOk }">
					<tr>
						<td colspan="6">
							<form action="${conPath }/gameVote.do" method="POST">
							<input type="hidden" name="gId" value="${gameContent.gId }"/>
							<span class="star-input">
							  <span class="input">
							    <input type="radio" name="star-input" id="p1" value="1"><label for="p1">1</label>
							    <input type="radio" name="star-input" id="p2" value="2"><label for="p2">2</label>
							    <input type="radio" name="star-input" id="p3" value="3"><label for="p3">3</label>
							    <input type="radio" name="star-input" id="p4" value="4"><label for="p4">4</label>
							    <input type="radio" name="star-input" id="p5" value="5"><label for="p5">5</label>
							    <input type="radio" name="star-input" id="p6" value="6"><label for="p6">6</label>
							    <input type="radio" name="star-input" id="p7" value="7"><label for="p7">7</label>
							    <input type="radio" name="star-input" id="p8" value="8"><label for="p8">8</label>
							    <input type="radio" name="star-input" id="p9" value="9"><label for="p9">9</label>
							    <input type="radio" name="star-input" id="p10" value="10"><label for="p10">10</label>
							  </span>
							  <output for="star-input"><b>0</b>점</output>
							  <br />
							  <br />
							  	<input type="submit" value="평점주기" />
							</span>
							</form>
						</td>
					</tr>
				    </c:if>
					<tr>
						<td colspan="6">
							${gameContent.gDes }
						</td>
					</tr>
					<tr>
						<td colspan="6">
							<h4 class="left">Comment</h4>
							<c:if test="${empty comantList }">
								<p id="comant" class="center"><span class="boldCoral">표시할 코멘트가 없습니다.</span></p>
							</c:if>
							<c:forEach var="comants" items="${comantList }">
								<p id="comant" class="left">
									<span><a class="boldCoral" href="${conPath }/profileView.do?mId=${comants.mId }">${comants.mId }</a></span> : ${comants.comant }
									<c:if test="${sessionMdto.mId == comants.mId or not empty adminOk }">
									<span class="comantDelete">
										<a href="${conPath }/deleteComant.do?cNum=${comants.cNum }&gId=${gameContent.gId }"><i class="fas fa-trash-alt"></a></i>
									</span>
									</c:if>
								</p>
							</c:forEach>
						</td>
					</tr>
					<c:if test="${not empty loginOk }">
					<tr>
						<td colspan="6" class="center">
							<form action="${conPath }/comantWrite.do" method="POST">
								<input type="hidden" name="gId" value="${gameContent.gId}"/>
								<input type="hidden" name="mId" value="${sessionMdto.mId}"/>
								<span><input type="text" name="comant" placeholder="코멘트를 입력해주세요" required="required" /></span>
								<p><input type="submit" value="코멘트달기" /></p>
							</form>
						</td>
					</tr>
					</c:if>
				</table>
			</td>
		</tr>
		<tr>
			<td class="center">
			<c:if test="${not empty adminOk }">
				<input type="button" value="수정하기" onclick="location.href = '${conPath }/gameModifyView.do?gId=${gameContent.gId }'" />
				<input type="button" value="삭제하기" onclick="location.href = '${conPath }/gameDelete.do?gId=${gameContent.gId }'" />
			</c:if>
			</td>
		</tr>
		<tr>
			<td class="center">
				<input type="button" value="게임목록으로가기" onclick="location.href = '${conPath }/gameListView.do'" />
			</td>
		</tr>
	</table>
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>