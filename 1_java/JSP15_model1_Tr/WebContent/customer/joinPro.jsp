<%@page import="com.tj.ex.dao.CustomerDao"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="cDto" class="com.tj.ex.dto.CustomerDto"/>
<jsp:setProperty name="cDto" property="*" />
<%	//현재의 시간 셋팅
	CustomerDao cDao = CustomerDao.getInstance();
	if(cDao.confirmId(cDto.getCid())==CustomerDao.MEMBER_NONEXISTENT){
		int result = cDao.joinCustomer(cDto);// DB에 dto 추가
		if(result==CustomerDao.SUCCESS){
			//회원가입 성공해서 id세션값 추가, 로그인 화면으로 감
			session.setAttribute("cid", cDto.getCid());
%>
			<script>
				alert('회원가입을 감사드립니다');
				location.href = '../customer/loginForm.jsp';
			</script>
<%		}else{%>
			<script>
				alert('회원가입이 실패되었습니다');
				location.href = '../customer/join.jsp';
			</script>
<%		}
	}else{%>
		<script>
			alert('중복된 ID입니다. 다른 ID를 쓰세요');
			history.back();
		</script>
<%}%>
</body>
</html>