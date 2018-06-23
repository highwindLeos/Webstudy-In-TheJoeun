<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("ValidMem")!=null){
		response.sendRedirect("../main/main.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/join.css" rel="stylesheet">
<script>
function infoChk(){
	if(document.frm.cid.value.length==0){
		alert('아이디는 필수입력 사항입니다');
		frm.cid.focus();
		return;
	}
	if(document.frm.cid.value.length<3){
		alert('아이디는 3문자 이상으로 가입하세요');
		frm.cid.focus();
		return;
	}
	if(document.frm.cpw.value.length==0){
		alert('비밀번호는 필수입력 사항입니다');
		frm.cpw.focus();
		return;
	}
	if(document.frm.cpw.value != document.frm.pw_check.value){
		alert('비밀번호를 확인하세요');
		frm.cpw.value = '';
		frm.pw_check.value = '';
		frm.cpw.focus();
		return;
	}
	if(document.frm.cname.value==0){
		alert('이름은 필수입력 사항입니다');
		frm.cname.focus();
		return;
	}
	if(document.frm.cemail.value==0){
		alert('메일주소는 필수입력 사항입니다');
		frm.cemail.focus();
		return;
	}
	if(document.frm.cemail.value.indexOf('@')==-1 ||
			document.frm.cemail.value.indexOf('@')==0 ||
			document.frm.cemail.value.indexOf('@')==(document.frm.cemail.value.length-1)){
		alert('메일형식을 확인해 주세요'); // aa@,   @aa
		frm.cemail.focus();
		return;
	}
	document.frm.submit(); // 강제 submit 이벤트 발생
}
</script>
</head>
<body>
<jsp:include page="../main/header.jsp" />
<div id="joinForm_wrap">
<form action="joinPro.jsp" method="post" name="frm">
<div id="join_title">회원가입</div>
	<table>
		<tr><th>아이디</th>
			<td><input type="text" name="cid" id="cid"></td>
		</tr>
		<tr><th>비밀번호</th>
			<td><input type="password" name="cpw" id="cpw"></td>
		</tr>
		<tr><th>비번확인</th>
			<td><input type="password" name="pw_check" id="pw_check"></td>
		</tr>
		<tr><th>이름</th>
			<td><input type="text" name="cname" id="cname"></td>
		</tr>
		<tr><th>전화</th>
			<td><input type="text" name="ctel" id="ctel"></td>
		</tr>
		<tr><th>메일주소</th>
			<td><input type="text" name="cemail" id="cemail"></td>
		</tr>
		<tr><th>성별</th>
			<td>
			<input type="radio" name="cgender" value="m">남자 &nbsp;
			<input type="radio" name="cgender" value="f">여자
			</td>
		</tr>
		<tr><th>주소</th>
			<td><input type="text" name="caddr" id="caddr"></td>
		</tr>
		<tr><td colspan="2">
				<input type="button" value="회원가입" 
						class="joinBtn_style" onclick="infoChk()">
				<input type="reset" value="취소"
					class="joinBtn_style" onclick="location='loginForm.jsp'"> 
	</table>
</form>
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>