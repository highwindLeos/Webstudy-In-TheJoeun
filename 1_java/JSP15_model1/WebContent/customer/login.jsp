<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Log in</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<jsp:include page="../main/head.jsp" />
<div id="wrap">
<form action="loginProcess.jsp" method="POST">
	<table>
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td colspan="2"><h2>Log-In</h2></td>
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
			<td colspan="2">
				<input type="submit" value="로그인" />
				<input type="button" value="뒤로가기" onclick="location.href = '../main/main.jsp'" />
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