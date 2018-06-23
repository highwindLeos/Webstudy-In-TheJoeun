<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Register</title>
	<link rel="stylesheet" href="">
	<script src="../js/valiedForm.js"></script>
</head>
<body>
<jsp:include page="../main/head.jsp" />
<div id="wrap">
<form id="rfrm" action="registerProcess.jsp" method="POST">
	<table>
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td colspan="2"><h2>회원가입(Register)</h2></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="cid" required="required" placeholder="아이디를 입력해주세요." /></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input type="password" name="cpw" required="required" placeholder="패스워드를 입력해주세요." /></td>
		</tr>
		<tr>
			<td>패스워드 확인</td>
			<td><input type="password" name="cpwChk" required="required" placeholder="패스워드를 재차 입력해주세요." /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="cname" required="required" placeholder="이름을 입력해주세요." /></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><input type="text" name="ctel" required="required" placeholder="연락처를 입력해주세요." /></td>
		</tr>
		<tr>
			<td>E-Mail</td>
			<td><input type="email" name="cemail" required="required" placeholder="이메일을 입력해주세요." /></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<input type="radio" id="male" name="cgender" value="남자" checked="checked" /><label for="male">남자</label>
				<input type="radio" id="female" name="cgender" value="여자" /><label for="female">여자</label>
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="caddr" required="required" placeholder="주소를 입력해주세요." /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="회원가입" onclick="return chkRegisterForm()" />
				<input type="button" value="뒤로가기" onclick="history.back()" />
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