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
		<link href="https://fonts.googleapis.com/css?family=Arvo|Lato|Roboto+Condensed" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css">
		<link href="${conPath }/css/reset.css" rel="stylesheet">
		<link href="${conPath }/css/main.css" rel="stylesheet">
		<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
		<script src="${conPath }/js/datapicker.js"></script>
		<script src="${conPath }/js/validateJoin.js"></script>
		<title>회원 수정</title>
	</head>
<body>
<jsp:include page="../main/head.jsp" />
<div id="wrap">
	<form id="frm_modify" action="${conPath }/modify.do" method="POST" enctype="multipart/form-data" >
	<table id="join">
		<tr>
			<td colspan="2">
				<h2>회원정보 수정</h2>
			</td>
		</tr>
		<tr>
			<td>아이디 * (변경불가)</td>
			<td><input type="text" id="mId" name="mId" value="${sessionMdto.mId }" readonly="readonly" /></td>
		</tr>
		<tr>
			<td>기존  패스워드</td>
			<td><input type="password" id="mPw" name="mPw" value="${sessionMdto.mPw }" readonly="readonly" /></td>
		</tr>
		<tr>
			<td>기존  패스워드 확인</td>
			<td><input type="password" id="mPwChk" name="mPwChk" required="required" /></td>
		</tr>
		<tr>
			<td>새로운 패스워드*</td>
			<td><input type="password" id="newPw" name="newPw" /></td>
		</tr>
		<tr>
			<td>이름 *</td>
			<td><input type="text" id="mName" name="mName" value="${sessionMdto.mName }" required="required" /></td>
		</tr>
		<tr>
			<td>이메일 *</td>
			<td><input type="email" id="mEmail" name="mEmail" value="${sessionMdto.mEmail }" required="required" /></td>
		</tr>
		<tr>
			<td>현제 회원사진</td>
			<td><img src="${conPath }/memberPhoto/${sessionMdto.mPhoto }" alt="${sessionMdto.mPhoto }" /></td>
		</tr>
		<tr>
			<td>수정할 회원사진</td>
			<td><input type="file" id="mPhoto" name="mPhoto" /></td>
		</tr>
		<tr>
			<td>연락처 *</td>
			<td><input type="text" id="mTel" name="mTel" value="${sessionMdto.mTel }" required="required" /></td>
		</tr>
		<tr>
			<td>성별 *</td>
			<td>
			<c:if test="${sessionMdto.mGender == '남자' }">
				<input type="radio" id="mMale" name="mGender" value="남자" checked="checked" /><label for="mMale">남자</label>
				<input type="radio" id="mFemale" name="mGender" value="여자" /><label for="mFemale">여자</label>
			</c:if>
			<c:if test="${sessionMdto.mGender == '여자' }">
				<input type="radio" id="mMale" name="mGender" value="남자"  /><label for="mMale">남자</label>
				<input type="radio" id="mFemale" name="mGender" value="여자" checked="checked"/><label for="mFemale">여자</label>
			</c:if>
			</td>
		</tr>
		<tr>
			<td>주소 *</td>
			<td><input type="text" id="mAddr" name="mAddr" value="${sessionMdto.mAddr }" required="required" /></td>
		</tr>
		<tr>
			<td>회원소개</td>
			<td>
				<textarea name="mText" rows="12" cols="40">${sessionMdto.mText }</textarea>
			</td>
		</tr>
		<tr>
			<td>생년월일 *</td>
			<td>
				<div id="datepicker"></div><span id="dateResult"></span>
				<input type="hidden" id="mBirth" name="mBirth" value="${sessionMdto.mBirth }"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="회원수정" onclick="return modifyValidateForm()" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="reset" value="재설정" />
				<input type="button" value="메인으로가기" onclick="location.href = 'mainView.do'" />
			</td>
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>
	</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>