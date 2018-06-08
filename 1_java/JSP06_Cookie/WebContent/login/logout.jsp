<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Log-Out</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for (int i=0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("id")) {
				cookies[i].setMaxAge(0); // 유효값을 0으로 설정하면 삭제됨.
				response.addCookie(cookies[i]);
				out.print("<script>location.reload()</script>");
			}
		}
	}
%>
<jsp:include page="head.jsp" />
	<h1>성공적으로 로그아웃 됨.</h1>
	<hr />
	<button onclick="location.href = 'login.jsp'">로그인 페이지로</button>
</body>
</html>