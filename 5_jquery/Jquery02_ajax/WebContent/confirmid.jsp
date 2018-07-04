<%@page import="com.tj.ex.dao.MembersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	MembersDao mdao = new MembersDao();
	int result = mdao.confirmId(id);
	if (result == MembersDao.EXISTENCE){ %>
	중복된 아이디 입니다.
<% } else { %>	
	사용 가능한 아이디 입니다.
<% }  %>
</body>
</html>