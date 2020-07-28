
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
		<link href="${conPath }/css/profile.css" rel="stylesheet">
		<title>프로파일</title>
	</head>
<body>
<c:if test="${empty loginOk }">
	<script>location.href ='${conPath }/loginForm.do'</script>
</c:if>
<jsp:include page="../main/head.jsp" />
<c:if test="${not empty follolwResult }">
	<script>swal('${follolwResult }','','success');</script>
</c:if>
<c:if test="${not empty unfollolwResult }">
	<script>swal('${unfollolwResult }','','success');</script>
</c:if>
<c:if test="${not empty memberModifyResult }">
	<script>swal('${memberModifyResult }','','success');</script>
</c:if>
<div id="wrap">
<table id="profile">
	<tr>
		<td colspan="4" class="center">
		<br />
			<h2 class="colorDarkGrayBlue">${Mdto.mId } (${Mdto.mName }) 님의 프로파일</h2>
		<hr>
		</td>
	</tr>
	<tr>
		<td colspan="1">
			<c:if test="${sessionMdto.mId == Mdto.mId }">
				<a href="#open"><img id="profileLogo" src="${conPath }/memberPhoto/${Mdto.mPhoto }" alt="회원사진" /></a>
			</c:if>
			<c:if test="${sessionMdto.mId != Mdto.mId }">
				<img id="profileLogo" src="${conPath }/memberPhoto/${Mdto.mPhoto }" alt="회원사진" />
			</c:if>
			<br />
			<br />
			<br />
			<br />
			<c:if test="${sessionMdto.mId != Mdto.mId }">
				<c:set var="isFollowing" value="1" />
				<c:set var="loop" value="false" />
				<c:forEach items="${followerDtos }" var="follower">
					<c:if test="${not loop }">
						<c:if test="${follower.mId == sessionMdto.mId }">
							<c:set var="isFollowing" value="0" />
							<c:set var="loop" value="true" />
						</c:if>					
						<c:if test="${follower.mId != sessionMdto.mId }">
							<c:set var="isFollowing" value="1" />
						</c:if>
					</c:if>					
				</c:forEach>
				<c:if test="${not empty loginOk }">
					<c:if test="${isFollowing == 1 }">			
						<button class="btnFollow" onclick="location.href = '${conPath}/Follow.do?mId=${sessionMdto.mId }&fId=${Mdto.mId }&mName=${Mdto.mName }'">
						<i class="fas fa-star"></i> ${Mdto.mName } Follow 하기</button>
					</c:if>
					<c:if test="${isFollowing == 0 }">			
						<button class="btnFollow" onclick="location.href = '${conPath}/UnFollow.do?mId=${sessionMdto.mId }&fId=${Mdto.mId }&mName=${Mdto.mName }'">
						<i class="far fa-star"></i> ${Mdto.mName } UnFollow 하기</button>
					</c:if>
				</c:if>
			</c:if>
		</td>
		<td colspan="3" class="relative">
			<table id="pesonalInfo">
				<tr>
					<td colspan="1"><h3><i class="fas fa-id-card"></i></h3> ID</td>
					<td colspan="3"><h2>${Mdto.mId }</h2></td>
				</tr>
				<tr>
					<td><h3><i class="fas fa-user-circle"></i></h3> Name</td>
					<td><h5>${Mdto.mName }</h5></td>
					<td><h3><i class="fas fa-heart"></i></h3> Follow/팔로우</td>
					<td><h5><fmt:formatNumber value="${followCnt }" pattern="#,###,###" /></h5>명</td>
				</tr>
				<tr>
					<td><h3><i class="fab fa-pinterest-p"></i></h3> Point</td>
					<td><h5>${Mdto.mPoint }</h5>point</td>
					<td><h3><i class="far fa-heart"></i></h3> Follower/팔로워</td>
					<td><h5><fmt:formatNumber value="${followerCnt }" pattern="#,###,###" /></h5>명</td>
				</tr>
				<tr>
					<td colspan="1"><h3><i class="fas fa-comment"></i></h3> 자기소개</td>
					<td colspan="3"><p>${Mdto.mText }</p></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<h4 class="center">팔로우 (Follow List)</h4>
		</td>
		<td class="center">
			<c:if test="${empty followDtos }">
			<h3 class="marginContent">현제 팔로우 하는 회원은 없습니다.</h3>
			</c:if>
			<c:forEach items="${followDtos }" var="fDtos">
				<table class="followTable">
					<tr>
						<td>
							<a class="boldCoral" href="${conPath }/profileView.do?mId=${fDtos.fId }">
								<img class="followPhoto" alt="followPhoto" src="${conPath }/memberPhoto/${fDtos.mPhoto }">
							</a>
						</td>
						<td><h4>${fDtos.fId }</h4></td>
						<td><h4>${fDtos.mName }</h4></td>
					</tr>
				</table>
			</c:forEach>
		</td>
		<td>
			<h4 class="center">팔로워 (Follower List)</h4>			
		</td>
		<td class="center">
			<c:if test="${empty followerDtos }">
				<h3 class="marginContent">현제 팔로워가 없습니다.</h3>
			</c:if>
			<c:forEach items="${followerDtos }" var="ferDtos">
				<table class="followTable">
					<tr>			
						<td>
							<a class="boldCoral" href="${conPath }/profileView.do?mId=${ferDtos.mId }">
								<img class="followPhoto" alt="followerPhoto" src="${conPath }/memberPhoto/${ferDtos.mPhoto }">
							</a>
						</td>
						<td><h4>${ferDtos.mId }</h4></td>
						<td><h4>${ferDtos.mName }</h4></td>		
					</tr>
				</table>
			</c:forEach>
		</td>
	</tr>
	<tr >
		<td colspan="4" class="center">
		<hr>
			<h4>최근의 작성한 글 리스트</h4>
		<hr>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<table id="newList" class="center">
				<tr>
					<th colspan="6"><h3>최근 작성한 자유게시판 글</h3></th>
				</tr>			
				<tr>
					<th>글번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>제목</th>
					<th>조회수</th>
					<th>좋아요 수</th>
				</tr>
			<c:if test="${empty newBoradList }">
				<tr>
					<td colspan="6">작성한 자유게시판 글이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${newBoradList }" var="boardNewList">
				<tr>
					<td>${boardNewList.bNum }</td>
					<td>${boardNewList.mId }</td>
					<td>${boardNewList.mName }</td>
					<td><a href="${conPath }/boardContentView.do?bNum=${boardNewList.bNum }">${boardNewList.bTitle }</a></td>
					<td>${boardNewList.bCnt }</td>
					<td>${boardNewList.bLike }</td>
				</tr>
			</c:forEach>
			</table>
		</td>
		<td colspan="2">
			<table id="newList" class="center">			
				<tr>
					<th colspan="2"><h3>최근 쓴 Game 게시판 Comant</h3></th>
				</tr>
				<tr>
					<td>게임 아이디</td>
					<td>코멘트</td>
				</tr>
			<c:if test="${empty newComantList }">
				<tr>
					<td colspan="6">작성한 게임 코멘트가 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach items="${newComantList }" var="comantNewList">
				<tr>
					<td><a href="${conPath }/gameContentView.do?gId=${comantNewList.gId }">${comantNewList.gId }</a></td>
					<td><a href="${conPath }/gameContentView.do?gId=${comantNewList.gId }">${comantNewList.comant }</a></td>
				</tr>
			</c:forEach>
			</table>
		</td>
	</tr>
</table>
</div>
<jsp:include page="../main/footer.jsp" />
<div class="white_content" id="open">
	<div>
		<ul id="modalMenu" class="center">
			<li><h2>회원 메뉴</h2></li>
			<li><a href="${conPath }/memberModifyForm.do?mId=${sessionMdto.mId }"><h2><i class="fas fa-user-circle"></i> 회원 정보 수정</h2></a></li>
			<li><a href="${conPath }/memberDeleteForm.do"><h2><i class="fas fa-eraser"></i> 회원 탈퇴</h2></a></li>
			<li><a href="#close"><h3><i class="fas fa-times"></i> 메뉴 닫기</h3></a></li>
		</ul>
	</div>
</div>
</body>
</html>