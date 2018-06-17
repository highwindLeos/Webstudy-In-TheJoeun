
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="com.tj.members.MembersDao"%>
<%	request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="com.tj.members.MembersDto" scope="page" />
<jsp:setProperty name="dto" property="*" />
<%
	Timestamp birth = Timestamp.valueOf(request.getParameter("bbirth") + " 00:00:00");
	dto.setBirth(birth); // timestemp 를 쓴다면 자바빈에 바로 들어가지 않는다.

	dto.setrDate(new Timestamp(System.currentTimeMillis())); // 시스템의 현제 시간을 DTO에 바인딩한다.
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JoinOK</title>
</head>
<body>
<%
		MembersDao mdao = MembersDao.getInstance();
		// 아이디 중복 체크 후 입력.
		if (mdao.confirmId(dto.getId()) != MembersDao.MEMBER_NONEEXISTENT) {
			int result = mdao.insertMember(dto);

			if (result == MembersDao.SUCCESS) { // 회원가입 성공
				System.out.println("회원가입 성공");
%>
		<script>
			alert('회원가입 성공했습니다.');
			location.href = 'login.jsp';
		</script>
<%			} else { // 회원가입 실패
				System.out.println("회원가입 실패");
%>
		<script>
			alert('회원가입 실패했습니다.');
			location.href = 'join.jsp';
		</script>
<%
			}
		} else { // 아이디가 중복되서 가입 처리 불가.
%>
		<script>
			alert('아이디가 중복되었습니다. 다른 아이디로 가입해 주세요.');
			history.go(-1);
		</script>
<% 		} %>
</body>
</html>