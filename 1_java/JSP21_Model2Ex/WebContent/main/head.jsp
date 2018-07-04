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
	<link href="" rel="stylesheet">
	<script></script>
	<title>head</title>
	</head>
<body>
<c:if test="${empty member and empty admin  }"><%-- 로그인 전 메뉴 --%>
	<div id="gnb">
		<ul class="right">
			<li><a href="${conPath }/mainIndex.do">홈</a></li>
			<li><a href="${conPath }/loginForm.do">로그인</a></li>
			<li><a href="${conPath }/registerForm.do">회원가입</a></li>
			<li><a href="${conPath }/list.do">고객센터</a></li>
		</ul>
	</div>
	<div id="Logo">
		<img class="logoImg" src="${conPath }/img/logo.jpg" alt="logo" />
	</div>
	<div id="lnb">
		<ul class="center">
			<li><a href=""><h3>로그인 전 메뉴1</h3></a></li>
			<li><a href=""><h3>로그인 전 메뉴2</h3></a></li>
			<li><a href=""><h3>로그인 전 메뉴3</h3></a></li>
			<li><a href=""><h3>로그인 전 메뉴4</h3></a></li>
		</ul>
	</div>
</c:if>
<c:if test="${not empty member and empty admin }"><%-- 사용자 로그인 메뉴 --%>
	<div id="gnb">
		<ul class="right">
			<li><a href="${conPath }/mainIndex.do">홈</a></li>
			<li><a href="">${member.mName }님 어서오세요</a></li>
			<li><a href="${conPath }/modifyForm.do">회원정보수정</a></li>
			<li><a href="${conPath }/logout.do">로그아웃</a></li>
			<li><a href="${conPath }/list.do">고객센터</a></li>
		</ul>
	</div>
	<div id="Logo">
		<img class="logoImg" src="${conPath }/img/logo.jpg" alt="logo" />
	</div>
	<div id="lnb">
		<ul class="center">
			<li><a href=""><h3>로그인 후 메뉴1</h3></a></li>
			<li><a href=""><h3>로그인 후 메뉴2</h3></a></li>
			<li><a href=""><h3>로그인 후 메뉴3</h3></a></li>
			<li><a href=""><h3>로그인 후 메뉴4</h3></a></li>
		</ul>
	</div>
</c:if>
<c:if test="${empty member and not empty admin }"><%-- 관리자 모드 로그인 --%>
	<div id="gnb">
		<ul class="right">
			<li><a href="${conPath }/mainIndex.do">홈</a></li>
			<li><a href="">${admin.aName } 님 : (관리자로그인)</a></li>
			<li><a href="${conPath }/logout.do">관리자 모드 나가기</a></li>
			<li><a href="${conPath }/list.do">고객센터</a></li>
		</ul>
	</div>
	<div id="Logo">
		<img class="logoImg" src="${conPath }/img/logo.jpg" alt="logo" />
	</div>
	<div id="lnb">
		<ul class="center">
			<li><a href=""><h3>관리자의 메뉴1</h3></a></li>
			<li><a href=""><h3>관리자의 메뉴2</h3></a></li>
			<li><a href=""><h3>관리자의 메뉴3</h3></a></li>
			<li><a href=""><h3>관리자의 메뉴4</h3></a></li>
		</ul>
	</div>
</c:if>
</body>
</html>