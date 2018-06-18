
<%@page import="com.tj.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Test</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<%
	BoardDao bdao = BoardDao.getInstance();
	int totalCnt = bdao.getBoardCnt();
	out.println("<h2>글갯수 가져오기 : "+ totalCnt +" 개 </h2>");
	
	ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
	
	if (totalCnt > 0){
		for (int i = 0; i < dtos.size(); i++){
			out.println(dtos.get(i).toString() + "</br>");
		}
	}
%>
<hr />
<h2>글쓰기</h2>
<%
	BoardDto dto = new BoardDto(0, "이데이", "subject", "content", "lee@gmail.com", 0, "pw", 0, 0, 0, "127.0.0.1", null);
	int result = bdao.insertBoard(dto);
	out.println(result == BoardDao.SUCCSESS ? "글쓰기 성공" : "글쓰기 실패");
%>
<hr />
<h2>글번호 2번인 글의 상세보기 테스트</h2>
<%
	bdao.readCountUp("2");
	out.println(bdao.getBoardOneLine("2").toString() + "</br>");
%>

<hr />
<h2>글 수정 테스트</h2>
<%
	dto = new BoardDto(2, "새이름", "새제목", "새내용", "new@gmail.com", 0, "pw", 0, 0, 0, "192.168.0,123", null);
	result = bdao.updateBoard(dto);
%>
<h2><%=  result == BoardDao.SUCCSESS ? "수정 성공" : "수정 실패" %></h2>

<hr />
<h2>글 수정 테스트</h2>
<%
	result = bdao.delectBoard(9, "pw");
%>
<h2><%=  result == BoardDao.SUCCSESS ? "삭제 성공" : "삭제 실패" %></h2>

</body>
</html>