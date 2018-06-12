<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modify Result</title>
</head>
<body>
<%
	String name = (String)session.getAttribute("name");
	String id = (String)session.getAttribute("id");
	String phone1 = (String)session.getAttribute("phone1");
	String phone2 = (String)session.getAttribute("phone2");
	String phone3 = (String)session.getAttribute("phone3");
	String gender = (String)session.getAttribute("gender");

	String result = request.getParameter("result");
	if (result.equals("ok")) {
%>
	<h2>ID : <%= id %>님의 성함이 <%= name %> 으로 회원 정보 수정 성공되었습니다.</h2>
	<h3>수정된 연락처는 <%= phone1 +"-"+ phone2+"-"+phone3 %>입니다.</h3>
<% } else { %>
	<h2>회원 정보 수정 처리되지 않았습니다.</h2>
<% } %>
	<hr>
	<button onclick="location.href ='loginResult.jsp'">메인</button>
	<button onclick="location.href ='modify.jsp'">회원정보 수정</button>
	<button onclick="location.href ='logout.jsp'">로그아웃</button>
</body>
</html>