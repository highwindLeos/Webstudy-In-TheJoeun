
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Title</title>
	<link rel="stylesheet" href="../css/board.css">
	<script>
		
	</script>
</head>
<% 
	String cname = (String)session.getAttribute("cname");
%>
<body>
<div id="head">
<% if(session.getAttribute("loginOk") == null) { %>
	<ul>
		<li><a href="../index.jsp">홈</a></li>
		<li><a href="../customer/register.jsp">회원가입</a></li>
		<li><a href="../customer/login.jsp">로그인</a></li>
		<li><a href="../fileboard/fileboardList.jsp">고객센터</a></li>
	</ul>
<% } else { %>
	<ul>
		<li><a href="../index.jsp">홈</a></li>
		<li>어서오세요. <%= cname %> 님</li>
		<li><a href="../customer/modifyCustomer.jsp">정보수정</a></li>
		<li><a href="../customer/logout.jsp">로그아웃</a></li>
		<li><a href="../fileboard/fileboardList.jsp">고객센터</a></li>
	</ul>
<% } %>
</div>
<p class="center"><a href="../index.jsp"><img class="logoImg" src="../img/logo.jpg" alt="logo" /></a></p>
</body>
</html>