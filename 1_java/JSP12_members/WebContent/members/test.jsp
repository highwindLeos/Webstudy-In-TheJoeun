<%@page import="java.sql.Timestamp"%>
<%@page import="com.tj.members.MembersDto"%>
<%@page import="com.tj.members.MembersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test</title>
</head>
<%
	MembersDao dao = MembersDao.getInstance();
	MembersDto dto = new MembersDto("aaa","111","이데이", "lee@gmail.com", Timestamp.valueOf("2018-06-15 13:00:00"), new Timestamp(System.currentTimeMillis()), "서울 종로");
	
	out.println("<h2>ID 중복 테스트</h2>");
	int result = dao.confirmId("aaa");
	if (result == MembersDao.MEMBER_EXISTENT) {
		out.println("<h2>아이디 중복 테스트 : aaa는 중복된 id입니다.");
	} else {
		out.println("<h2>아이디 중복 테스트 : aaa는  데이터 베이스에 없습니다.");
	}
	out.println("<hr>");
	
	out.println("<h2>회원 가입 테스트 : ");
	result = dao.insertMember(dto);
	out.println(result == MembersDao.SUCCESS ? "가입성공</h2>" : "가입실패</h2>");
	out.println("<hr>");
	
	out.println("<h2>로그인 테스트</h2>");
	result = dao.loginCheck("aaa", "111");
	if (result == MembersDao.LOGIN_FAIL_ID){
		out.println("<h2>로그인 테스트 : 아이디 오류</h2>");
	} else if (result == MembersDao.LOGIN_FAIL_PW) {
		out.println("<h2>로그인 테스트 : 패스워드 오류</h2>");
	} else if (result == MembersDao.LOGIN_SUCCESS) {
		out.println("<h2>로그인 테스트 : 로그인 성공</h2>");
	}
	out.println("<hr>");
	
	out.println("<h2>특정 아이디로 DTO 가져오기 테스트</h2>");
	dto = dao.getMember("aaa");
	if (dto != null) {
		out.println("<h2>"+ dto.toString() +"</h2>");
	}
	out.println("<hr>");
	out.println("<h2>회원 정보 수정 테스트</h2>");
	MembersDto modiftyDto = new MembersDto("aaa", "xxx", "박데이", "park@gmail.com", Timestamp.valueOf("2018-06-15 14:35:00"), null, "서울 강남");
	
	result = dao.updateMember(modiftyDto);
	
	if (result == MembersDao.SUCCESS) {
		out.println("<h2>회원 정보 수정 성공</h2>");
		out.println("<h4> 수정된 내용 : " + dao.getMember("aaa").toString() + "</h4>");
	}

%>
<body>
	
</body>
</html>