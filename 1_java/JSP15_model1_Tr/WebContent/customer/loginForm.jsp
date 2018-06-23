<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("ValidCustomer") != null) {
		response.sendRedirect("../main/main.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/login.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="../main/header.jsp" />
	<div id="loginForm_wrap">
		<form action="../customer/loginPro.jsp" method="post">
			<div id="login_title">로그인</div>
			<table>
				<tr>
					<th><label for="mid">아이디</label></th>
					<td><input type="text" name="cid" id="cid"
					value="<%if(session.getAttribute("cid")!=null)
					out.println(session.getAttribute("cid"));%>"
					 required="required"></td>
				</tr>
				<tr>
					<th><label for="mpw">비밀번호</label></th>
					<td><input type="password" name="cpw" id="cpw"
						required="required"></td>
				</tr>
				<tr>
					<td colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="로그인"
						class="loginBtn_style"
						style="width: 100%; height: 120%; padding: 3px;">
				</tr>
			</table>
			<p id="login_join">
				아직 회원이 아니신가요? <a href="joinForm.jsp">회원가입</a>
			</p>
		</form>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>