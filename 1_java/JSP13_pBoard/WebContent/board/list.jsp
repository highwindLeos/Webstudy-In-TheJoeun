
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
	<title>List</title>
	<link rel="stylesheet" href="../css/board.css">
	<script>
		
	</script>
</head>
<body>
<div id="wrap">
	<table>
		<tr><td colspan='7'>Board</td></tr>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>글제목</th>
			<th>메일</th>
			<th>IP</th>
			<th>작성일</th>
			<th>글 조회수</th>
		</tr>
<%
	BoardDao boardDao = BoardDao.getInstance();
	int totCnt = boardDao.getBoardCnt(); // 글갯수
	
	if (totCnt == 0) {
		out.println("<tr><td colspan='7'>글이 없습니다.</td></tr>");
	} else { // 글이 있으니 글목록을 가져와 for 문으로 뿌려준다.
		ArrayList<BoardDto> dtos = boardDao.listBoard();
		for (BoardDto dt : dtos) {
		out.println("<tr>");
			out.println("<td>"+ dt.getNum() +"</td>");
			out.println("<td>"+ dt.getWriter() +"</td>");
			out.println("<td class='left'>");
			out.println("<a href='content.jsp?num="+ dt.getNum() +"' />");
			if (dt.getReadCount() > 10) {
				out.println("<img id='icon' src='../img/hot.gif' alt='hot' />");
			}
			out.println(dt.getSubject() + "</a></td>");
			out.println("<td>");
			out.println(dt.getEmail() != null ? dt.getEmail() : "-");
			out.println("</td>");
			out.println("<td>"+ dt.getIp() +"</td>");
			out.println("<td>"+ dt.getRdate() +"</td>");
			out.println("<td>"+ dt.getReadCount() +"</td>");
		out.println("</tr>");
		}
	}
%>
		<tr><td colspan='7'>Publish by Leo</td></tr>
	</table>
	<hr />
	<form action="">
		<p class="right">
			<input type="button" value="글쓰기" onclick="location.href = 'writeForm.jsp'" />
		</p>
	</form>
</div>
</body>
</html>