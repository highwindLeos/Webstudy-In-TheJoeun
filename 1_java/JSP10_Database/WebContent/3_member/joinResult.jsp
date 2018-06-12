<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Join Result</title>
	<link rel="stylesheet" href="../css/register.css" />
	<script>
	
	</script>
</head>
<body>
<%
	String result = request.getParameter("result");

	if (result.equals("ok")) {
		out.println("<h2>회원가입이 성공되었습니다. 반갑습니다.</h2>");
		out.println("<hr>");
		out.println("<button onclick=\"location.href ='login.jsp'\">로그인</button>");
	} else {
		out.println("<h2>회원가입이  처리되지 않았습니다.</h2>");
		out.println("<hr>");
		out.println("<button onclick=\"location.href ='join.jsp'\">회원가입</button>");
		out.println("<button onclick=\"location.href ='login.jsp'\">로그인</button>");
	}
%>
</body>
</html>