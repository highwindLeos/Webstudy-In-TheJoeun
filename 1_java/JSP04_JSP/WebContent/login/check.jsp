<%@page import="java.net.URLEncoder"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Title</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id != null && id.equals("aaa") && pw != null && pw.equals("111")) {
		response.sendRedirect("loginCertification.jsp?id="+id+"&"+"pw="+pw);
	} else {
		String msg = URLEncoder.encode("Check the ID and PW 아이디와 패스워드를 체크하세요.", "utf-8");
		response.sendRedirect("loginFrm.jsp?msg=" + msg);
	} %>
</body>
</html>