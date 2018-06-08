<%@page import="java.util.Enumeration"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<%-- <%
	Enumeration<String> names = session.getAttributeNames();
	while (names.hasMoreElements()){
		String sName = names.nextElement();
		if(sName.equals("id")){ // 로그인 했음
			out.println(session.getAttribute(sName) + "님 안녕하세요.<br>");
			out.println("<button coclick=\"location.href = 'logout.jsp'\">로그아웃</button>");
		}
	}
%> --%>

<%	if (session.getAttribute("id") != null) { // 로그인 후 %>
	<h3><%= session.getAttribute("id") %> 님 안녕하세요.</h3>
	<button onclick="location.href = 'logout.jsp'">로그아웃</button>
	<button onclick="location.href = 'sessionTest.jsp'">세션 보기</button>
<%	} else { // 로그인 전  %>
	<h3>로그인 상태가 아닙니다.</h3>
	<button onclick="location.href = 'login.jsp'">로그인 페이지로</button>
<% } %>
<body>
	
</body>
</html>