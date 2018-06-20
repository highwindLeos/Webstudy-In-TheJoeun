
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
	<title>Content</title>
	<link rel="stylesheet" href="../css/board.css">
	<script>
		
	</script>
</head>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");

	BoardDao boardDao = BoardDao.getInstance();
	boardDao.readCountUp(num); // 조회수 1 증가.
	BoardDto dto = boardDao.getBoardOneLine(num);
%>
<body>
<div id="wrap">
	<form action="">
		<table>
			<tr>
				<td colspan="6"></td>
			</tr>
			<tr>
				<td colspan="6"><h3><%= dto.getNum() %> 번 게시물 내용</h3></td>
			</tr>
			<tr>
				<td colspan="3"><b>글쓴이</b></td>
				<td colspan="3"><%= dto.getWriter() %></td>
			</tr>
			<tr>
				<td colspan="3"><b>글제목</b></td>
				<td colspan="3"><%= dto.getSubject() %></td>
			</tr>
			<tr>
				<td colspan="6"><b>내 용</b></td>
			</tr>
			<tr>
				<td colspan="6" class="high_height"><pre><%= dto.getContent() %></pre></td>
			</tr>
			<tr>
				<td><b>조회수</b></td>
				<td><%= dto.getReadCount() %></td>
				<td><b>작성자 이메일</b></td>
				<td><%= dto.getEmail() != null ? dto.getEmail() : "-" %></td>
				<td><b>작성자 IP</b></td>
				<td><%= dto.getIp() %></td>
			</tr>
			<tr>
				<td colspan="3">작성시간</td>
				<td colspan="3"><%= dto.getRdate() %></td>
			</tr>
			<tr>
				<td colspan="6">
					<input type="button" value="글수정" onclick="location.href = 'updateForm.jsp?num=<%= num %>&pageNum=<%= pageNum %>'" />
					<input type="button" value="글삭제" onclick="location.href = 'deleteForm.jsp?num=<%= num %>&pageNum=<%= pageNum %>'" />
					<input type="button" value="답변달기" onclick="location.href = 'writeForm.jsp?num=<%= num %>&pageNum=<%= pageNum %>'" />
					<input type="button" value="뒤로가기" onclick="location.href = 'list.jsp'" />
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>