<%@page import="com.tj.dto.CustomerDto"%>
<%@page import="com.tj.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>login Process</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<%
	String cid = request.getParameter("cid");
	String cpw = request.getParameter("cpw");
	
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.loginCheck(cid, cpw);
	
	if (result == CustomerDao.LOGIN_SUCCESS){
		CustomerDto cdto = cDao.getCustomer(cid);
		
		session.setAttribute("loginOk", "ok");
		session.setAttribute("cid", cid);
		session.setAttribute("cpw", cpw);
		session.setAttribute("cname", cdto.getCname());
		session.setAttribute("cemail", cdto.getCemail());
		
		session.setAttribute("cdto", cdto); // 세션의 로그인된 객체 자체를 세션에 넣는다.
		
		response.sendRedirect("../main/main.jsp");
	} else if (result == CustomerDao.LOGIN_FAIL_ID) { %>
		<script>
			alert('존재하지 않는 아이디입니다.');
			history.back();
		</script>
<% } else if (result == CustomerDao.LOGIN_FAIL_PW) { %>
		<script>
			alert('패스워드가 틀립니다.');
			history.back();
		</script>
<% } %>
</body>
</html>