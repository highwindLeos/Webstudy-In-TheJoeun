<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>ex5</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<%
	pageContext.setAttribute("page_name", "page_value");
	request.setAttribute("request_name", "request_value");
	session.setAttribute("session_name", "session_value");
	application.setAttribute("application_name", "application_value");
	// EX :  request 객체와 session 객체에 setAttribute 한 값을 그대로 유지
	//response.sendRedirect("ex4view.jsp?name=홍&id=aaa&pw=111");
	RequestDispatcher dispatcher = request.getRequestDispatcher("ex4view.jsp?name=홍&id=aaa&pw=111");
	dispatcher.forward(request, response);
%>
</body>
</html>