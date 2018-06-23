<%@page import="com.tj.dto.CustomerDto"%>
<%@page import="com.tj.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="cdto" class="com.tj.dto.CustomerDto" />
<jsp:setProperty property="*" name="cdto"/>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>modify Process</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<%
	CustomerDao cdao = CustomerDao.getInstance();
	System.out.println(cdto);
	int result = cdao.updateCustomer(cdto);
	
	if (result == CustomerDao.SUCCESS) {
		System.out.println("수정 성공");
		
		session.setAttribute("cid", cdto.getCid());
		session.setAttribute("cpw", cdto.getCpw());
		session.setAttribute("cname", cdto.getCname());
		
		session.setAttribute("cdto", cdto);
%>		
	<script>
		alert('수정이 성공했습니다.');
		location.href = '../main/main.jsp';
	</script>
<% 	} else { %>
	<script>
		alert('수정이 실패했습니다.');
		history.back();
	</script>
<% 	} %>
</body>
</html>