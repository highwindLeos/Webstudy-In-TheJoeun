
<%@page import="java.sql.Timestamp"%>
<%@page import="com.tj.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="com.tj.dto.BoardDto" scope="page" />
<jsp:setProperty name="dto" property="*" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>writeProcess</title>
	<script>
		
	</script>
</head>
<body>
<%
	BoardDao boardDao = BoardDao.getInstance();
	dto.setIp(request.getRemoteAddr()); // 시스템의 ip 를 가져와서 dto 에 넣어준다.
	// dto.setReadCount(0);
	// dto.setRdate(new Timestamp(System.currentTimeMillis()));
	int result = boardDao.insertBoard(dto);
	
	if (result == BoardDao.SUCCSESS) {
		System.out.println("글쓰기 완료");
%>
	<script>
		alert('글쓰기 성공했습니다');
		location.href = 'list.jsp';
	</script>
<% } else { %>
	<script>
		alert('글쓰기 실패했습니다.');
		history.back();
	</script>
<%
		System.out.println("글쓰기  실패");
	}
%>
</body>
</html>