
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>
<c:set var="conPath" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Title</title>
	<link rel="stylesheet" href="${conPath }/css/board.css">
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
		<li><a href="${conPath }/index.jsp">홈</a></li>
		<li><a href="${conPath }/joinForm.do">회원가입</a></li>
		<li><a href="${conPath }/member/login.jsp">로그인</a></li>
	</ul>
<% } else { %>
	<ul>
		<li><a href="${conPath }/index.jsp">홈</a></li>
		<li>어서오세요. <%= cname %> 님</li>
		<li><a href="${conPath }/customer/modifyCustomer.jsp">정보수정</a></li>
		<li><a href="${conPath }/customer/logout.jsp">로그아웃</a></li>
	</ul>
<% } %>
</div>
<p class="center"><a href="${conPath }/index.jsp"><img class="logoImg" src="${conPath }/img/logo.jpg" alt="logo" /></a></p>
</body>
</html>