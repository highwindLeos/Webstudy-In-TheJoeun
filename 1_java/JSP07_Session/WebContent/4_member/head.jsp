<%@page import="java.net.URLEncoder"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Head</title>
	<link rel="stylesheet" href="css/head.css" />
	</head>
<%!String idValue;%>
<%
	idValue = null;
	String idValue = (String)session.getAttribute("id");
%>
<body>
	<%
		if (idValue == null) {
	%>
	<div id="wrap">
		<ul>
			<li><a href="main.jsp">홈</a></li>
			<li><a href="login.jsp">로그인</a></li>
			<li><a href="join.jsp">회원가입</a></li>
		</ul>
	</div>
	<%
		} else {
	%>
	<div id="wrap">
		<ul>
			<li><a href="#"><%= idValue %> 님 어서오세요.</a></li>
			<li><a href="join.jsp">정보수정</a></li>
			<li><a href="logoutOK.jsp">로그아웃</a></li>
		</ul>
	</div>
	<%
		}
	%>
</body>
</html>