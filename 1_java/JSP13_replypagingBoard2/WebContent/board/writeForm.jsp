
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
	<title>글쓰기</title>
	<link rel="stylesheet" href="../css/board.css">
	<script>
		
	</script>
</head>
<body>
<%  
	int num = 0 , ref = 0, reStep = 0, reLevel = 0;
	BoardDto dto = new BoardDto();
	
	String pageNum = null;
	
	if (request.getParameter("num") != null) { 
		
		num = Integer.parseInt(request.getParameter("num"));
		pageNum = request.getParameter("pageNum");
	// 답변글 달려고 들어옴. 원글의 정보를 가져온다.
		
		BoardDao boardDao = BoardDao.getInstance();
		dto = boardDao.getBoardOneLine(num); // 원글의 대한 정보
		
		ref = dto.getRef();
		reStep = dto.getReStep();
		reLevel = dto.getReLevel();
	}
	
	if (pageNum == null) {
		pageNum = "1";
	}
%>
<div id="wrap">
	<form action="writeProcess.jsp" method="POST">
		<input type="hidden" name="num" value="<%= num %>" />
		<input type="hidden" name="pageNum" value="<%= pageNum %>" />
		<input type="hidden" name="ref" value="<%= ref %>" />
		<input type="hidden" name="reStep" value="<%= reStep %>" />
		<input type="hidden" name="reLevel" value="<%= reLevel %>" />
		<table>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2"><h3>글쓰기</h3></td>
			</tr>
			<tr>
				<td><label for="subject" >제목</label></td>
				<td><input type="text" id="subject" name="subject" size="30" required="required" autofocus="autofocus" 
					value='<% if (num > 0) out.println("[Re]" + dto.getSubject()); %>'/></td>
			</tr>
			<tr>
				<td><label for="writer" >작성자</label></td>
				<td><input type="text" id="writer" name="writer" size="30" required="required" /></td>
			</tr>
			<tr>
				<td><label for="content" >글본문</label></td>
				<td><textarea id="content" name="content" rows="10" cols="31" required="required" ></textarea></td>
			</tr>
			<tr>
				<td><label for="email" >이메일</label></td>
				<td><input type="email" id="email" name="email" size="30" /></td>
			</tr>
			<tr>
				<td><label for="pw" >삭제 패스워드</label></td>
				<td><input type="password" id="pw" name="pw" size="30" required="required" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="저장" />
					<input type="reset" value="다시설정" />
					<input type="button" value="목록보기" onclick="location.href = 'list.jsp?pageNum=<%= pageNum %>'" />
				</td>
			</tr>
			<tr>
				<td colspan="2"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>