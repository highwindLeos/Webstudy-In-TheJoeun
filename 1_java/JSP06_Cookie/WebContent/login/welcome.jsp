<%@page import="java.net.URLDecoder"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
	<style>
		button {
			text-align: center;
		}
	</style>
	<script>
	
	</script>
</head>
<% // 쿠키값을 가져와서 비교.
	String idValue = null;
	Cookie[] cookies = request.getCookies();
	if (cookies != null){
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("id")){
				/* idValue = cookies[i].getValue(); */
				idValue = URLDecoder.decode(cookies[i].getValue(), "utf-8");
				break;
			}
		}
	}
	
	if (idValue != null) { // 로그인 후 
%>
<body>
<jsp:include page="head.jsp" />
	<h1><%= idValue %>님 어서오세요.</h1>
<%	
	} else { // 로그인 전
		response.sendRedirect("login.jsp");
	} 
%>
	<hr />
	<button onclick="location.href = 'logout.jsp'">Log-out</button>
</body>
</html>