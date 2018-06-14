<%@page import="java.net.URLEncoder"%>
<%@page import="com.tj.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="com.tj.dto.MemberDto" scope="page" />
<jsp:setProperty name="dto" property="*" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Join Ok</title>
	<link rel="stylesheet" href="../css/register.css" />
</head>
<body>
<%	MemberDao memberDao = MemberDao.getInstance();
	int result = memberDao.memberInsert(dto);
	
	if (result > 0) {		
%>
	<h2>회원가입이 완료되었습니다.</h2>
<%	
		System.out.println("입력성공");
		response.sendRedirect("friendjoin.jsp");
	} else {
		String msg =  URLEncoder.encode("입력한 데이터를 확인후 가입해주세요.", "utf-8");
		response.sendRedirect("join.jsp?msg=register is not confirm"+msg);
	}
%>
<hr />
<jsp:include page="memberListView.jsp" />
</body>
</html>