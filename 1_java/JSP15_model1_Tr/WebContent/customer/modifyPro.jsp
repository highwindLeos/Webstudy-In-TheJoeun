<%@page import="com.tj.ex.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="cDto" class="com.tj.ex.dto.CustomerDto"/>
<jsp:setProperty name="cDto" property="*"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	String hyun_pw = request.getParameter("hyun_pw");
	String session_pw = (String)session.getAttribute("cpw");
	if(hyun_pw.equals(session_pw)){
		// dto.getPw() == null 이러면 새비번을 hyun_pw로 setting
		if(cDto.getCpw()==null || cDto.getCpw().trim().equals("")){
			cDto.setCpw(hyun_pw);
		}
		CustomerDao cDao = CustomerDao.getInstance();
		int result = cDao.updateCustomer(cDto);
		if(result==CustomerDao.SUCCESS){
			session.setAttribute("cname", cDto.getCname());
			session.setAttribute("cpw", cDto.getCpw());
%>			<script>
				alert('정보수정이 완료되었습니다.');
				location.href='../main/main.jsp';	
			</script>
<% 		}else{%>
			<script>
				alert('정보수정이 실패되었습니다. 길이를 확인하세요');
				history.go(-1);
			</script>
<%		}%>
<%	}else{%>
		<script>
			alert('현 비밀번호가 맞지 않아 수정 불가');
			history.back();
		</script>
<%	}%>
</body>
</html>