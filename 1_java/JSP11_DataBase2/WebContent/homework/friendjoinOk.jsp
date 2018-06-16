<%@page import="java.net.URLEncoder"%>
<%@page import="com.tj.dao.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="com.tj.dto.FriendDto" scope="page" />
<jsp:setProperty name="dto" property="*" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Friend JoinOK</title>
</head>
<%
	FriendDao friendDao = FriendDao.getInstance();
	int result = friendDao.friendInsert(dto);
	
	if (result > 0) {
		System.out.println("친구 리스트 테이블에 입력됨");	
		response.sendRedirect("friendjoin.jsp");
	} else {
		String msg = URLEncoder.encode("입력한 데이터를 확인후 추가해주세요.", "utf-8");
		response.sendRedirect("friendjoin.jsp?msg=" + msg);
	}
%>
<body>

</body>
</html>