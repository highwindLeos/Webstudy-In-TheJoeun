<%@page import="com.tj.mvcmember.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="{pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="">
	<script></script>
	<title>Title</title>
	</head>
<body>
<%
	BoardDao dao = new BoardDao();

	for (int i = 0 ; i < 110; i++){
		String bName = "이데이" + i; 
		String bTitle = "제목" + i; 
		String bContent = "본문" + i; 
		String bIp = "127.0.01"; 
		
		if (dao.writeBoard(bName, bTitle, bContent, bIp) == 1) {
			System.out.println(i+"번째 입력 성공");
		} else {
			System.out.println(i+"번째 입력 성공");
		}
	}

		response.sendRedirect(request.getContextPath()+"/list.do");
%>
	
</body>
</html>