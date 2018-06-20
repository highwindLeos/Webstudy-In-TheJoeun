<%@page import="com.tj.dto.BoardDto"%>
<%@page import="com.tj.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>insert Test</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<%-- 강제로 글 220 개 넣기 -> 221 개 글이 있을 예정 - 23페이지 --%>
<%-- writer subject content email(?) pw ip --%>
<body>
<%
	BoardDao boardDao = BoardDao.getInstance();
	BoardDto dto = new BoardDto();
	
	for (int i = 1; i < 222; i++){
		
		dto.setWriter("이데이" + i);
		dto.setSubject("글 제목" + i);
		dto.setContent("테스트용 본문입니다. \n 점심이 조아요" + i);
		dto.setPw("1234");
		dto.setIp(request.getRemoteAddr());
		dto.setReadCount(i % 12);
		if (i % 2 == 0){
			dto.setEmail("leeday"+ i +"@gmail.com" );
		} else {
			dto.setEmail(null);
		}
		int result = boardDao.insertBoard(dto);
		
		if(result == BoardDao.SUCCSESS){
			System.out.println(i + "번째 글 입력 성공");
		}
	}
	response.sendRedirect("list.jsp");
%>
	
</body>
</html>