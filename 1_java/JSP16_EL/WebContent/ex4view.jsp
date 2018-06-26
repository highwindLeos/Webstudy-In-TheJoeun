<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>ex4view</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
	<%-- <p>이름 <%= request.getParameter("name") %></p> --%>
	<%-- <p>아이디 <%= request.getParameter("id") %></p> --%>
	<%-- <p>패스워드 <%= request.getParameter("pw") %></p> --%>
	<p>이름 ${ param.name }</p>
	<p>아이디 ${ param.id }</p>
	<p>패스워드 ${ param.pw }</p>
	<hr />
	<p>pageScope : ${ page_name }</p>
	<p>requestScope : ${ request_name }</p>
	<p>sessionScope : ${ session_name }</p>
	<p>applicationScope : ${ application_name }</p>
</body>
</html>