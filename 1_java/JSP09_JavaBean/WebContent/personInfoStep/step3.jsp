<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="pi" class="com.tj.ex.PersonInfo" scope="request" />

<jsp:setProperty name="pi" property="name" value="이데이" />
<jsp:setProperty name="pi" property="age" value="22" />
<jsp:setProperty name="pi" property="gender" value="남자" />

<%-- <jsp:forward page="piResult.jsp" /> --%>
<% response.sendRedirect("piResult.jsp"); %> <%-- 아예 다른  요청으로 페이지가 이동되기 때문에 값이 전달되지 않는다. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Step3</title>
</head>
<body>
	
</body>
</html>