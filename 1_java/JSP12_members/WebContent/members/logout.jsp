<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logout</title>
</head>
<body>
<%	session.invalidate(); %>
<script>
	alert('로그아웃 되었습니다. 서비스를 이용해 주셔서 감사합니다 ');
	location.href = 'login.jsp';
</script>
</body>
</html>