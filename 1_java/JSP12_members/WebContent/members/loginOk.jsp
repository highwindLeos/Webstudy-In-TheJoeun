
<%@page import="com.tj.members.MembersDto"%>
<%@page import="com.tj.members.MembersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>	
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>loginOK</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MembersDao dao = MembersDao.getInstance();
	int result = dao.loginCheck(id, pw);
	
	if (result == MembersDao.LOGIN_SUCCESS) { // 로그인 성공의 경우 
		MembersDto dto = dao.getMember(id);
	
		session.setAttribute("validMember", "ok");
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		session.setAttribute("name", dto.getName());
		
		session.setAttribute("member", dto); // 세션의 로그인된 객체데이터를 넣어놓는다.
	
		response.sendRedirect("main.jsp");
	} else if (result == MembersDao.LOGIN_FAIL_ID){ %>
	<script>
		alert('존재하지 않는 ID 입니다.');
		history.back();
	</script>
<% 	} else if (result == MembersDao.LOGIN_FAIL_PW){ %>
	<script>
		alert('패스워드가 틀렸습니다.');
		history.back();
	</script>
<%	} %>
</body>
</html>