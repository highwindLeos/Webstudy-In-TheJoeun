
<%@page import="com.tj.dao.BoardDao"%>
<%@page import="com.tj.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Delete</title>
	<link rel="stylesheet" href="../css/board.css">
	<script>
		
	</script>
</head>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");

	BoardDao dao = BoardDao.getInstance();
	BoardDto dto = dao.getBoardOneLine(num);
%>
<body>
<div id="wrap">
	<form action="deleteProcess.jsp" method="GET">
		
		<table>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2"><h2><%= dto.getNum() %>번 글을 삭제 합니다. 패스워드를 입력해주세요.</h2></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td>
					<input type="hidden" name="num" value="<%= num %>">
					<input type="hidden" name="pageNum" value="<%= pageNum %>">
					<input type="password" name="pw" required="required" />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="삭제하기" />
					<input type="button" value="뒤로가기" onclick="history.back()" />
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>