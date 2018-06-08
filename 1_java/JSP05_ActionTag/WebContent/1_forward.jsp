<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Forward</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
	<h1>1_forward.jsp 영역 입니다.</h1>
	<%-- <jsp:forward page="sub.jsp" />  단독태그로 보통 사용한다. URL 이 현제 페이지로 남아있고 변한다. --%>
	<%
		response.sendRedirect("sub.jsp");
	%>
</body>
</html>