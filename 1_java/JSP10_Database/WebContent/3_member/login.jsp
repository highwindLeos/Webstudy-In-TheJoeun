<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%
	if (session.getAttribute("id") != null){
		response.sendRedirect("loginResult.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="../css/login.css" />
<%
	String msg = request.getParameter("msg");
	if (msg != null) {
%>
	<script>
		alert('<%= msg %>');
	</script>
<% } %>
</head>
<body>
	<div id="login">
		<form action="../loginOK" method="POST">
			<table>
				<tr>
					<td colspan="2"><h2>로그인</h2></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" required="required" /></td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type="password" name="pw" required="required" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="로그인" />
						<input type="button" value="회원가입" onclick="location.href = 'join.jsp'" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>