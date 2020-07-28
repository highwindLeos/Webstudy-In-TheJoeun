<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="" rel="stylesheet">
		<script></script>
		<title>Error 500</title>
	</head>
<body>
<jsp:include page="../main/head.jsp"/>
<div id="wrap" class="center">
	<h3 class="center boldCoral">현제 페이지는 공사중 입니다. 신속한 처리토록 하겠습니다.</h3>
	<br />
	<img src="https://media.giphy.com/media/GC94HIwderL7G/giphy.gif" alt="Error">
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>