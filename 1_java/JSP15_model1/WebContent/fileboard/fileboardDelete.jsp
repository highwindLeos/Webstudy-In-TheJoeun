<%@page import="com.tj.dto.FileBoardDto"%>
<%@page import="com.tj.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>fileboardDelete</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<%
	int fnum = Integer.parseInt(request.getParameter("fnum"));
	String pageNum = request.getParameter("pageNum");

	FileBoardDao dao = FileBoardDao.getInstance();
	FileBoardDto dto = dao.getFileBoardOneLine(fnum);
%>
<body>
<jsp:include page="../main/head.jsp" />
<div id="wrap">
	<form action="fileboardDeleteProcess.jsp" method="post">
		
		<table>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2"><h2><%= dto.getFnum() %>번 글을 삭제 합니다. 패스워드를 입력해주세요.</h2></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td>
					<input type="hidden" name="fnum" value="<%=fnum %>">
					<input type="hidden" name="pageNum" value="<%=pageNum %>">
					<input type="password" name="fpw" required="required" />
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
<jsp:include page="../main/footer.jsp" />
</body>
</html>