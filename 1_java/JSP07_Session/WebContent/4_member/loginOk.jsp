<%@page import="java.net.URLEncoder"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>LoginOK</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	
	if ("aaa".equals(id)) {
		if ("111".equals(pw)){
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			
			response.sendRedirect("main.jsp");
		} else {
			session.setAttribute("msg", "패스워드가 맞지 않습니다.");
			response.sendRedirect("login.jsp");
		}
	} else {
		session.setAttribute("msg", "아이디가 맞지 않습니다.");
		response.sendRedirect("login.jsp");
	}
%>	
</body>
</html>