<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="css/login.css" />
	<script>

	</script>
</head>
<body>
	<div id="wrap">
		<form action="register.jsp" method="POST">
			<table>
				<tr>
					<td colspan="2"><h1>로그인</h1></td>
				</tr>
				<tr>
					<td>아 이 디</td>
					<td><input type="text" name="id" placeholder="아이디를 입력해주세요." required="required" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="pw" placeholder="비밀번호를 입력해주세요." required="required" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="로그인" /></td>
				</tr>
			</table>
		</form>
		<p>아직 회원이 아니신가요? <span id="register"><a href="register.jsp">회원가입</a></span></p>
	</div>
</body>
</html>