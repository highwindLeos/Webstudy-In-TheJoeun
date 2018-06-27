
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>
<c:set var="conPath" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Error 404</title>
	<link rel="stylesheet" href="${conPath }/css/board.css">
	<script>
		
	</script>
</head>
<body>
<c:import url="${conPath }/member/head.jsp" />
	<br />
	<br />
	<h1>404 Not Found</h1>
	<br />
	<br />
	<div id="error">
		<img src="https://media.giphy.com/media/9BDr3O37VMLhS/giphy.gif" alt="nisekoi" />
	</div>
	<br />
	<br />
	<h2>이 페이지는 공사중입니다.</h2>
	<br />
	<br />
<c:import url="${conPath }/member/footer.jsp" />
</body>
</html>