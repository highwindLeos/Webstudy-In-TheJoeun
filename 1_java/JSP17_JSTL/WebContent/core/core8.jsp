<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>core8</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
	<c:url var="myUrl" value="core7.jsp" />
	<c:redirect url="${myUrl }" /> <%-- response.sendRedirect()  --%>
</body>
</html>