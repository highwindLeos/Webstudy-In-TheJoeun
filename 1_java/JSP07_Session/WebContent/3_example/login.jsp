<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%
	if (session.getAttribute("id") != null) { // 세션에 아이디 값이 있다면.
		response.sendRedirect("result.jsp"); // 이 페이지를 로드 하지 않고 특정페이지로 보낸다.
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login</title>
	<link rel="stylesheet" href="css/login.css" />
	<script>
		function chk_register() {
		var id = frm.id.value;
		
			if (str < 4) {
				alert('아이디는 4글자 이상으로 가입해주세요');
				frm.id.focus();
				return false;
			}
			
			if (frm.pw.value != frm.pw2.value) {
				alert('패스워드가 다릅니다.');
				frm.pw.value = "";
				frm.pw2.value = "";
				frm.pw.focus();
				return false;
			}
			return true;
		}
	
	</script>
</head>
<body>
	<div id="wrap">
		<form action="agree.jsp" method="post" id="frm">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" required="required" autofocus="autofocus"/></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" required="required" /></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" name="pw2" required="required" /></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" required="required" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="가입" onclick="return chk_register()"> <input type="reset" value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>