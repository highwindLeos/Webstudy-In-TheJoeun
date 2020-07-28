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
		<link href="css/reset.min.css" rel="stylesheet" type="text/css">
		<link href="css/style.css" rel="stylesheet" type="text/css">
		<title>사원 수정</title>
		
		<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="${conPath }/js/event.js"></script>
	</head>
<body>
<div id="wrap">
	<jsp:include page="left.jsp" />
	<div class="box_right">
		<div class="tit f_bold">
			<img alt="icon" src="image/icon.gif"> 사원 기본 정보 수정
		</div>
		<div class="page_menu f_bold">
			<ul class="li_left">
				<li><a href="#">교육정보</a></li>
				<li>|</li>
				<li><a href="#">자격증. 보유기술정보</a></li>
				<li>|</li>
				<li><a href="#">프로젝트 정보</a></li>
				<li>|</li>
				<li><a href="#">경력정보</a></li>
				<li>|</li>
				<li><a href="#">근무정보</a></li>
			</ul>
		</div>
		<form action="${conPath }/modify_is_mater.do" method="POST" enctype="multipart/form-data">
			<input type="hidden" name="user_No" value="${ismater.user_No }">
		<div class="page_box">
			<div class="page_in float_h">
				<div class="picture_pr float_l"><img class="sajin_Nm" alt="${ismater.sajin_Nm }" src="${conPath }/image/${ismater.sajin_Nm }"></div>
				<div class="page_mar2 float_l">
					<div class="page_mar1">
						<label class="page4_1">한글이름 : </label>
						<input type="text" name="kor_Name" value="${ismater.kor_Name }">
					</div>
					<div class="page_mar1">
						<label class="page4_1">영문이름 : </label>
						<input type="text" name="eng_Name" value="${ismater.eng_Name }">
					</div>
					<div class="page_mar1">
						<label class="page4_1">한문이름: </label>
						<input type="text" name="han_Name" value="${ismater.han_Name }">
					</div>
					<div class="page_mar1">
						<label class="page4_1">주민등록번호 : </label>
						<input name="jumin_No1" type="text" size="6" maxlength="6" value="${jumin0 }"> - 
						<input name="jumin_No2" type="text" size="7" maxlength="7" value="${jumin1 }">
					</div>
				</div>
			</div>
			<div class="page_in clear_b">
				<div class="page_line page_mar1">
					<label class="page4_1">사진파일명 : </label>
					<input name="sajin_Nm" type="text" size="40" value="${ismater.sajin_Nm }"> 
					<font color="#FF0000"><img src="image/bt_search.gif" width="49" height="18"></font>
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">생년월일 : </label>
					<input name="birth0" type="text" size="8" value="${birth0 }"> 년 
					<input name="birth1" type="text" size="5" value="${birth1 }"> 월 
					<input name="birth2" type="text" size="5" value="${birth2 }"> 일 
					( 
					<c:if test="${ismater.birth_Rn == 1 }">
						<input type="radio" name="birth_Rn" value="1" checked="checked"> 양력 
						<input type="radio" name="birth_Rn" value="2"> 음력
					</c:if> 
					<c:if test="${ismater.birth_Rn == 2 }">
						<input type="radio" name="birth_Rn" value="1"> 양력 
						<input type="radio" name="birth_Rn" value="2" checked="checked"> 음력
					</c:if> )
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">성별 : </label>
					<c:if test="${ismater.sex == 1 }">
						<input type="radio" name="sex" value="1" checked="checked"> 남자 
						<input type="radio" name="sex" value="2"> 여자
					</c:if>
					<c:if test="${ismater.sex == 2 }">
						<input type="radio" name="sex" value="1"> 남자 
						<input type="radio" name="sex" value="2" checked="checked"> 여자
					</c:if>
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">결혼유무 : </label>
					<c:if test="${ismater.marry_Yn == 0 }">
						<input type="radio" name="marry_Yn" value="0" checked="checked"> 미혼 
					<input type="radio" name="marry_Yn" value="1"> 기혼
					</c:if>
					<c:if test="${ismater.marry_Yn == 1 }">
						<input type="radio" name="marry_Yn" value="0"> 미혼 
						<input type="radio" name="marry_Yn" value="1" checked="checked"> 기혼
					</c:if>
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">년차 : </label>
					<input name="work_Year" type="text" size="10" value="${ismater.work_Year }">
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">급여 지급유형 : </label>
					<select name="sal">
						<option>월급</option>
						<option>연봉계약</option>
					</select>
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">희망직무 : </label>
					<select name="hope_Work">
					<c:if test="${ismater.hope_Work == 0}">
						<option value="0" selected="selected">SI</option>
						<option value="1">SM</option>
					</c:if>
					<c:if test="${ismater.hope_Work == 1}">
						<option value="0">SI</option>
						<option value="1" selected="selected">SM</option>
					</c:if>
					</select>
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">입사유형 : </label>
					<select name="join_St">
					<c:if test="${ismater.join_St == 0}">
						<option value="0" selected="selected">정규직</option>
						<option value="1">계약직</option>
					</c:if>
					<c:if test="${ismater.join_St == 1}">
						<option value="0">정규직</option>
						<option value="1" selected="selected">계약직</option>
					</c:if>
					</select>
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">주소 : </label>
					<input name="addr0" type="text" size="10" value="${addr0 }"> 
					<input name="addr1" type="text" size="40" value="${addr1 }">
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">연락처 : </label>
					<input name="tel0" type="text" size="10" value="${tel0 }"> - 
					<input name="tel1" type="text" size="10" value="${tel1 }"> - 
					<input name="tel2" type="text" size="10" value="${tel2 }">
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">이메일 : </label>
					<input name="email" type="email" size="20" value="${ismater.email }">
				</div>
				<div class="page_line page_mar1">
					<label class="page4_1">기술등급 : </label>
					<input name="tech_Grd" type="text" size="20" value="${ismater.tech_Grd }">
				</div>
				<div class="page_mar1">
					<label class="page4_1">주량 : </label>
					<input name="alc_Qt" type="text" size="20" value="${ismater.alc_Qt }"> L
				</div>
			</div>
			<div class="btn_all">
				<button type="submit"><img alt="remove" src="image/bt_remove.gif"></button>
				<button type="reset"><img alt="cancel" src="image/bt_cancel.gif"></button>
				<button class="back" type="button">돌아가기</button>
			</div>
		</div>
		</form>
	</div>
</div>
</body>
</html>