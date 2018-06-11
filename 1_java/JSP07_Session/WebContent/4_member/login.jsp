<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("id") != null) {
		response.sendRedirect("main.jsp"); // 이 페이지를 로드 하지 않고 특정페이지로 보낸다.
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/login.css" />
</head>
<jsp:include page="head.jsp" />
<body>
	<div id="login">
		<form action="loginOk.jsp" method="POST">
			<table>
				<tr>
					<td colspan="2"><h1>
							<a href="login.jsp">로그인</a>
						</h1></td>
				</tr>
				<tr>
					<td><label for="id">아 이 디</label></td>
					<td><input type="text" id="id" name="id"
						placeholder="아이디를 입력해주세요." required="required" /></td>
				</tr>
				<tr>
					<td><label for="pw">비밀번호</label></td>
					<td><input type="password" id="pw" name="pw"
						placeholder="비밀번호를 입력해주세요." required="required" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="로그인" /></td>
				</tr>
			</table>
		</form>
		<%
			String msgError = request.getParameter("msgError");

			if (msgError != null) {
		%>
		<p id="errorMsg"><%=msgError%></p>
		<%
			}
		%>
		<p>
			<%
				if (session.getAttribute("msg") != null) {
					out.print(session.getAttribute("msg"));
					session.removeAttribute("msg");
				}
			%>
		</p>
		<p>
			아직 회원이 아니신가요? <span id="register"><a href="join.jsp">회원가입</a></span>
		</p>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>