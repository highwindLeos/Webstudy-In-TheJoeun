<%@page import="com.tj.ex.dto.CustomerDto"%>
<%@page import="com.tj.ex.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String cid = request.getParameter("cid");
	String cpw = request.getParameter("cpw");
	CustomerDao cDao = CustomerDao.getInstance();
	int result = cDao.loginCheck(cid, cpw);
	if(result==CustomerDao.LOGIN_SUCCESS){ //로그인 성공
		CustomerDto cDto = cDao.getCustomer(cid);//id로 회원정보를 dto
		session.setAttribute("cid", cid);
		session.setAttribute("cpw", cpw);
		session.setAttribute("cname", cDto.getCname());
		session.setAttribute("ValidCustomer", "yes");
		response.sendRedirect("../main/main.jsp");
	}else if(result == CustomerDao.LOGIN_FAIL_PW){ // pw 오류
%>		<script>
			alert('비밀번호를 확인하세요');
			history.back();
		</script>		
<%	}else if(result == CustomerDao.LOGIN_FAIL_ID){ // id 오류%>
		<script>
			alert('존재하지 않은 ID입니다');
			history.back();
		</script>
<%	}%>
</body>
</html>