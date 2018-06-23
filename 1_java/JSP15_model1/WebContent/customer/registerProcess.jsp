
<%@page import="com.tj.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="cdto" class="com.tj.dto.CustomerDto" scope="page" />
<jsp:setProperty name="cdto" property="*" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Register Process</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<%
	CustomerDao cDao = CustomerDao.getInstance();
	// 아이디 중복체크 입력
	if (cDao.confirmId(cdto.getCid()) == CustomerDao.C_NONEEXISTENT) {
		int result = cDao.insertCustomer(cdto);
		
		if (result == CustomerDao.SUCCESS) {
			System.out.println("회원가입 성공");
%>
		<script>
			alert('회원가입 성공했습니다.');
			location.href = 'login.jsp';
		</script>
<%		} else { // 회원가입 실패 
			System.out.println("회원가입 실패");
%>
		<script>
			alert('회원가입 실패했습니다.');
			location.href = 'register.jsp';
		</script>
<% 
		}
	} else { // 아이디가 중복이 있음
%>
		<script>
			alert('아이디가 중복되었습니다. 다른 아이디로 가입해 주세요.');
			history.go(-1);
		</script>
<%	} %>
</body>
</html>