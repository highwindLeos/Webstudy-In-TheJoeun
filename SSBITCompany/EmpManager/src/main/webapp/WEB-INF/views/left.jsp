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
		<script></script>
		<title>Left</title>
	</head>
<body>
<div class="box_left">
		<div class="left_top"></div>
		<div class="left_cont">
			<ul class="left_menu">
				<li><img alt="icon" src="${conPath }/image/left_icon.gif"> 기본정보
					<ul>
						<li><a href="${conPath }/write_is_materForm.do">- 등록</a></li>
					</ul>
				</li>
				<li><img alt="icon" src="${conPath }/image/left_icon.gif"> 직원명부</li>
				<li><img alt="icon" src="${conPath }/image/left_icon.gif"> 퇴직자현황</li>
				<li><img alt="icon" src="${conPath }/image/left_icon.gif"> 예비인력정보</li>
				<li><img alt="icon" src="${conPath }/image/left_icon.gif"> 거래처정보
					<ul>
						<li>- 등록</li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="left_bottom"></div>
		<div class="left_search">
			<label class="left_label"><img alt="icon" src="${conPath }/image/left_icon.gif"> 경력검색</label>
			<input name="textfield" type="text" class="left_flat" size="9" maxlength="14"> 
			<a href="#"><img alt="search" src="${conPath }/image/search.gif"></a>
		</div>
</div> <%--  right Menu --%>
</body>
</html>