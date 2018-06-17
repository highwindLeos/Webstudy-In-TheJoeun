
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>login</title>
	<link href="../css/register.css" rel="stylesheet"/>
</head>
<%
	if (session.getAttribute("validMember") != null) { // 로그인 했다면 이 페이지를 보이지 않는다.
		response.sendRedirect("main.jsp");
	}
%>
<body>
<div id="wrap">
	<form action="loginOk.jsp" method="POST" name="login_frm">
		<table>
			<tr>
				<td colspan="2">로그인</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" required="required" value="<% if (session.getAttribute("id") != null) 
																					out.println(session.getAttribute("id")); %>"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="pw" required="required"></td>
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