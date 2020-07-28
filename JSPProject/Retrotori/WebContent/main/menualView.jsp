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
		<link href="" rel="stylesheet">
		<title>이용안내</title>
	</head>
<body>
<jsp:include page="head.jsp" />
<div id="menual">
	<table>
		<tr>
			<td>
				<h2 class="center">Retrotory 이용안내</h2>
			</td>
		</tr>
		<tr>
			<td>
				<ul class="center">
					<li>
						<hr>
							<h3><i class="fas fa-registered"></i> 회원 가입</h3>
						<hr>
					</li>
					<li>
						<pre class="left">
						서비스를 이용할 고객은 서비스에 회원 가입을 한 후 해당 아이디로 로그인 후
						자유게시판과 게임 정보 서비스를 이용할수 있습니다.
						</pre>
						<hr>
						<pre class="left">
						회원가입 후 자유게시판에 글을 쓰거나 답글을 남길수 있고
						개인 프로필 페이지가 생기게 됩니다.
						
						자유게시판에 글쓰기 : 포인트 10점.
						게임 평가 게시판의 짧은 코멘트 : 5점.
						
						의 포인트를 누적해서 계산해 줍니다.
						
						개인 프로필 페이지는 여러가지 사용자에게 필요한 정보를
						출력합니다. 또한 사용자는 다른 사람의 프로필 페이지로 가서
						상대방의 정보를 볼수 있습니다.
						</pre>
					</li>
					<li>
						<hr>
							<h3><i class="fas fa-lock"></i> 관리자 계정</h3>
						<hr>
					</li>
					<li>
						<pre class="left">
						기본 관리자가 존재하고 최고 관리자는 다른 관리자 아이디를 생성할수 있다.
						</pre>
						<hr>
						<pre class="left">
						관리자는 게임 평가 게시판에 글을 작성하여 게임을 올릴수 있으며
						자유게시판의 글을 작성 회원의 관계없이 수정과 삭제가 가능합니다.
						
						관리자는 게임 평가와 코멘트에는 관여할수 없지만 코멘트의 불량 글들을 삭제할수 있는 권한이 있습니다.
						
						코멘트 역시 자신이 작성한 코멘트만 삭제하고 재등록 할수 있습니다.
						짧은 코멘트의 특성상 수정은 하지 않고 삭제와 등록만으로 이용합니다.
						
						관리자 계정만이 공지사항의 글들을 등록 수정 삭제가 가능하고
						일반 회원들은 글을 조회만 가능합니다.
						
						</pre>
					</li>
					<li>
						<hr>
							<h3><i class="fas fa-clipboard-check"></i> 게임 평가 게시판</h3>
						<hr>
					</li>
					<li>
						<pre class="left">
						서비스를 이용할 고객은 서비스에 회원 가입을 한 후 해당 아이디로 로그인 후
						자유게시판과 게임 정보 서비스를 이용할수 있습니다.
						</pre>
						<hr>
						<pre class="left">
						로그인 후 게임 게시판에 접근하여 관리자가 올린 게임의 리스트를 보고 평가투표를 할 수 있으며
						게임 평점과 총점에 기여하게 됩니다.
						해당 게임들은 평가투표에 따라서 
						
							- 브론즈
							- 실버
							- 골드
							- 플래티넘
							- 프리미엄
							- 레전드
						
						등급으로 표시 됩니다. 	
						</pre>
					</li>
					<li>
						<hr>
							<h3><i class="fas fa-keyboard"></i> 자유 게시판</h3>
						<hr>
					</li>
					<li>
						<pre class="left">
						자유로운 주제로 해당 사이트의 정보 교환을 할 수 있습니다.
						</pre>
						<hr>
						<pre class="left">
						해당 게시판은 5Mbyte 이내의 파일 첨부 업로드가 가능하며
						답글을 남겨서 서로 커뮤니케이션 합니다.
						
						출력되어 있는 아이디와 회원이름을 통해서 상대방의 프로필 페이지로
						접근할수 있습니다.
						</pre>
					</li>
					<li>
						<hr>
							<h3><i class="fas fa-exclamation-circle"></i> 공지사항 페이지</h3>
						<hr>
					</li>
					<li>
						<pre class="left">
						사이트의 공지들을 등록하고 관리하는 페이지.
						</pre>
						<hr>
						<pre class="left">
						해당 게시판은 관리자 계정만이 등록 수정 삭제가 가능하며
						아코디언 출력 방식으로 게시글을 바로 한 화면에서 출력해줍니다.
						
						출력순서는 최신글 순서이며 해당 공지는 메인화면에서도 최신글 5개가 확인 가능합니다.
						</pre>
					</li>
					<li>
						<hr>
							<h3><i class="fas fa-user"></i> 프로필 페이지</h3>
						<hr>
					</li>
					<li>
						<pre class="left">
						개인 회원의 기본 정보 및 팔로우 회원, 팔로워 회원을 출력하는 페이지 입니다.
						</pre>
						<hr>
						<pre class="left">
						프로필페이지에서는 아래의 정보들을 출력해준다.
						
						- 개인 회원간의 개인 정보와 자기소개, 현제 회원 포인트
						- 팔로우 하고 있는 회원 
						- 팔로워 들의 리스트
						
						를 출력하고 있으며 해당 리스트들을 통해 상대방의 프로필 페이지로 갈 수 있습니다. 
						
						자신의 프로필 페이지가 아닌
						타인의 프로필 페이지라면 해당 페이지에서
						팔로우 버튼이 출력되며 회원을 팔로우 하고 있을 시에는
						언팔로우로 표기되고 해당 버튼의 기능은 팔로우 회원을 삭제하고 등록하는
						기능을 가지고 있습니다.
						</pre>
					</li>
				</ul>
			</td>
		</tr>
		<tr>
			<td></td>
		</tr>
	</table>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>