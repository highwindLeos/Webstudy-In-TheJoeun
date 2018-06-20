
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
	<title>Modify Form page</title>
	<link rel="stylesheet" href="../css/board.css">
	<script>
		
	</script>
</head>
<%
	int num = Integer.parseInt(request.getParameter("num"));

	BoardDao dao = BoardDao.getInstance();
	BoardDto dto = dao.getBoardOneLine(num);
%>
<body>
<div id="wrap">
	<form action="updateProcess.jsp" method="POST">
		<input type="hidden" name="num" value="<%= num %>">
		<table>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2"><h3><%= dto.getNum() %>번 글 수정</h3></td>
			</tr>
			<tr>
				<td><label for="subject" >새 제목</label></td>
				<td><input type="text" id="subject" name="subject" size="30" value="<%= dto.getSubject() %>" required="required" autofocus="autofocus"/></td>
			</tr>
			<tr>
				<td><label for="writer" >작성자</label></td>
				<td><input type="text" id="writer" name="writer" size="30" value="<%= dto.getWriter() %>" required="required" /></td>
			</tr>
			<tr>
				<td><label for="content" >수정할 본문</label></td>
				<td><textarea id="content" name="content" placeholder="<%= dto.getContent() %>" rows="10" cols="31" required="required" ></textarea></td>
			</tr>
			<tr>
				<td><label for="email" >새 이메일</label></td>
				<td><input type="email" id="email" name="email" value="<%= dto.getEmail() != null ? dto.getEmail() : "" %>" size="30" /></td>
			</tr>
			<tr>
				<td><label for="pw" >새 패스워드</label></td>
				<td><input type="password" id="pw" name="pw" size="30" value="<%= dto.getPw() %>" required="required" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정하기" />
					<input type="reset" value="다시설정" />
					<input type="button" value="목록보기" onclick="location.href ='list.jsp'" />
					<input type="button" value="이전으로" onclick="history.back()" />
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>