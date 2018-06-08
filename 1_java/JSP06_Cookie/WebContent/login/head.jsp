<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<style>
		#wrap {
			width : 100%;
			margin: 0 auto;
		}
		
		a {
			color : #000;
			text-decoration: none;
		}
		
		a:hover {
			color : lightblue;
			font-weight: bold;
		}
		
		ul {
			text-align: right;
			margin-right : 20px;
		}
		
		ul >  li {
			display: inline-block;
			font-size : 1.1em;
			padding : 0 15px;
			cursor: pointer;
		}
		
	</style>
	<script>
	
	</script>
</head>
<%! String idValue; %>
<%
	idValue = null;
	Cookie[] cs = request.getCookies();
	if (cs != null) {
		for (int i =0; i < cs.length; i++) {
			if (cs[i].getName().equals("id")){
				 idValue = cs[i].getValue();
				 break;
			}
		}
	}
%>
<body>
<% 
	if (idValue == null) {
%>
<div id="wrap">
	<ul>
		<li><a href="#">홈</a></li>
		<li><a href="login.jsp">로그인</a></li>
		<li><a href="#">회원가입</a></li>
	</ul>
</div>
<% } else { %>
<div id="wrap">
	<ul>
		<li><a href="#"><%= idValue %> 님 어서오세요.</a></li>
		<li><a href="#">정보수정</a></li>
		<li><a href="logout.jsp">로그아웃</a></li>
	</ul>
</div>
<% } %>
</body>
</html>