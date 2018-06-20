
<%@page import="com.tj.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="com.tj.dto.BoardDto" />
<jsp:setProperty name="dto" property="*" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>updateProcess</title>
	<script>
		
	</script>	
</head>
<%-- 전달받은 파라메터 : num, writer, subject, content, email, pw --%>
<body>
<%
	BoardDao dao = BoardDao.getInstance();
	dto.setIp(request.getRemoteAddr()); // 시스템의 아이피를 가져와서 dto에  세팅.
	
	int result = dao.updateBoard(dto);
	
	if (result == BoardDao.SUCCSESS) {
		System.out.println("글 수정 성공");
%>
	<script>
		alert('<%= dto.getNum() + "번 글 수정 성공했습니다." %>');
		location.href = 'list.jsp';
	</script>
<% } else { %>
	<script>
		alert('<%= dto.getNum() + "번 글 수정 실패했습니다." %>');
		history.back();;
	</script>
<% 		System.out.println("글 수정 실패");	} %>
</body>
</html>