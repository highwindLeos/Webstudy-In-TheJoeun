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
<%
	request.setCharacterEncoding("utf-8");

	String msg = request.getParameter("msg");

	if (msg != null){
		out.print("<script>");
		out.print("alert('" + msg + "');");
		out.print("</script>");
	} // 아이디와 패스워드가 aaa / 111 인경우 alert 창으로 알려준다.
	
%>
<body>
	<div id="wrap">
		<form action="register.jsp" method="POST">
			<table>
				<tr>
					<td colspan="2"><h1><a href="login.jsp">로그인</a></h1></td>
				</tr>
				<tr>
					<td><label for="id">아 이 디</label></td>
					<td><input type="text" id="id" name="id" placeholder="아이디를 입력해주세요." required="required" /></td>
				</tr>
				<tr>
					<td><label for="pw">비밀번호</label></td>
					<td><input type="password" id="pw" name="pw" placeholder="비밀번호를 입력해주세요." required="required" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="로그인" /></td>
				</tr>
			</table>
		</form>
			<%
				String msgError = request.getParameter("msgError");
		
				if (msgError != null){ %>
					<p id="errorMsg"><%= msgError %></p>
			<% } %>
		<p>아직 회원이 아니신가요? <span id="register"><a href="register.jsp">회원가입</a></span></p>
	</div>
</body>
</html>