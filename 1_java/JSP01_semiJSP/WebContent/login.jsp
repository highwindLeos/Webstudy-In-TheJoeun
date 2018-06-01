<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log-in</title>
<style>
	#wrap{
		width : 300px;
		margin : 0 auto;
		text-align: center;
	}
</style>
<script>
	window.onload = function (){
		var submit = document.querySelector("form > input[type=submit]"); // Submit 버튼
		submit.onclick = function () {
			return validateForm();
		}; // 클릭했을때 검증 함수 호출.
	};
	
	function validateForm() {
		
		if (!frm.name.value){
			alert('이름은 빈 칸일수 없습니다.');
			frm.name.focus();
			return false;
		}
		
		if (!frm.id.value){
			alert('아이디는 빈 칸일수 없습니다.');
			frm.id.focus();
			return false;
		}
		
		if (!frm.pw.value){
			alert('패스워드는 빈 칸일수 없습니다.');
			frm.pw.focus();
			return false;
		}
		return true;
		
	}
</script>
</head>
<body>
<div id="wrap">
	<form action="loginResult.jsp" method="POST" id="frm">
		<p>이 름 : <input type="text" id="name" name="name" /></p>
		<p>아이디 : <input type="text" id="id" name="id" /></p>
		<p>패스워드 : <input type="password" id="pw" name="pw" /></p>
		<input type="submit" value="로그인"/>
	</form>
</div>
</body>
</html>