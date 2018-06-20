
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
	<title>deleteProcess</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<%
	String num = request.getParameter("num");
	String pw = request.getParameter("pw");
	String pageNum = request.getParameter("pageNum");
	
	BoardDao dao = BoardDao.getInstance();
	int result = dao.delectBoard(num, pw);
	
	if(result == BoardDao.SUCCSESS) {
		System.out.println("굴 삭제 성공");
%>
	<script>
		alert('<%= num + "번 글이 삭제되었습니다" %>');
		location.href = 'list.jsp?pageNum=<%= pageNum %>';
	</script>
<% } else { System.out.println("굴 삭제 성공"); %>

	<script>
		alert('<%= num + "번 글이 삭제 실패했습니다." %>');
		//history.back();
		location.href = 'list.jsp?num=<%= num %>&pageNum=<%= pageNum %>';
	</script>
<%  } %>
</body>
</html>