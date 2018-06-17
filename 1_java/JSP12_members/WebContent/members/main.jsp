
<%@page import="com.tj.members.MembersDao"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.tj.members.MembersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Main</title>
	<link href="../css/register.css" rel="stylesheet"/>
</head>
<%
	if (session.getAttribute("validMember") == null) {
		response.sendRedirect("login.jsp");
	} // 로그인 한 사용자만 페이지를 보여줌
	
	String id = (String)session.getAttribute("id");
	String name = (String)session.getAttribute("name");
	
	MembersDto dto = (MembersDto)session.getAttribute("member");
	MembersDao dao = MembersDao.getInstance();
	MembersDto dto2 = dao.getMember(id); // 로그인 한 사용자의 데이터
%>
<body>
<div id="wrap">
	<h1>메인 페이지</h1>
	<h2><%= name %> (<%= id %>) 님  어서오세요.</h2>
	<h3>이메일 : <%= dto.getEmail() %></h3>
	<h3><%= name %> 님의 생일은 (<%= dto.getBirth().toString().substring(0, 10) %>) 입니다.</h3>
	<h3><%= name %> 님의 가입일은 (<%= dto2.getrDate().toString().substring(0, 10) %>) 입니다.</h3>
	<h3><%= name %> 님의 주소는 (<%= dto.getAddress().toString().trim() %>) 입니다.</h3>
	<hr>
	<form action="modify.jsp">
		<input type="submit" value="정보수정"/>
		<input type="button" value="로그아웃" onclick="location.href = 'logout.jsp'" />
	</form>
</div>
</body>
</html>