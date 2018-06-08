<%@page import="javafx.scene.AmbientLight"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Application Infomation</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
<%
	String info = application.getServerInfo(); //서버정보
	int majorVersion = application.getMajorVersion();
	int minorVersion = application.getMinorVersion();
%>

	<h2>서버 정보 : <%= info %></h2>
	<h2>서버 버전정보 : <%= majorVersion %>&nbsp;<%= minorVersion %></h2>
</body>
</html>