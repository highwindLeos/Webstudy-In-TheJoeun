
<%@page import="com.tj.members.MembersDao"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="com.tj.members.MembersDto" scope="page"/>
<jsp:setProperty name="dto" property="*" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>modify OK</title>
</head>
<%
	Timestamp birth = Timestamp.valueOf(request.getParameter("bbirth")+ " 00:00:00");
	dto.setBirth(birth);
	
	String nowPw = request.getParameter("nowPw");
	String sessionPw = (String)session.getAttribute("pw");
	
	if (nowPw.equals(sessionPw)) { // 현제 비번을 맞게 입력하면 update 진행
		// 새 비밀번호를 빈칸으로 넘겼으면 새비번을 현제 비번으로 
		if (dto.getPw().equals("")) {
			dto.setPw(nowPw);
		}
		
		MembersDao dao = MembersDao.getInstance();
		int result = dao.updateMember(dto);
		
		if (result == MembersDao.SUCCESS){ // 회원정보 수정 성공
			System.out.println("회원 정보 수정 성공");
		
			session.setAttribute("name", dto.getName());
			session.setAttribute("pw", dto.getPw());
			session.setAttribute("member", dto); 
%>			
			<script>
				alert('회원 정보 수정 완료되었습니다.');
				location.href = 'main.jsp';
			</script>		
<%	} else { // 회원정보 수정 실패
			System.out.println("회원 정보 수정 실패 1");  %>
			<script>
				alert('회원 정보 수정 실패하였습니다.');
				history.back();
			</script>
<%		}
	} else { // 현 비번을 틀리게 입력하면 다시 modify.jsp 로 보낸다.
		System.out.println("회원 정보 수정 실패 2"); %>
			<script>
				alert('회원 정보 수정 실패하였습니다.');
				history.back();
			</script>
<% } %>
<body>
</body>
</html>