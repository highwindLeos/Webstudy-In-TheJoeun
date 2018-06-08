<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%
	if (session.getAttribute("id") != null) { // 세션에 아이디 값이 있다면.
		response.sendRedirect("welcome.jsp"); // 이 페이지를 로드 하지 않고 특정페이지로 보낸다.
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="css/login.css" />
	<script>
	
	</script>
</head>
<%
	String msg = request.getParameter("msg");
%>
<body>
	<div id="wrap">
		<form action="loginOk.jsp" method="post">
			<table>
				<caption>로그인 화면</caption>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="id" required="required" autofocus="autofocus"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="pw" required="required"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="로그인" /></td>
				</tr>
				<tr><td colspan="2"><h2><% if(msg != null) out.print(msg); %></h2></td></tr>
			</table>
		</form>
	</div>
</body>
</html>