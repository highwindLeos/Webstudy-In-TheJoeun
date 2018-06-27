<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>
<c:set var="conPath" value="${ pageContext.request.contextPath }" /> <%-- 프로젝트 콘텍스트 경로 --%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Title</title>
	<link rel="stylesheet" href="${conPath }/css/board.css">
	<script>
		
	</script>
</head>
<body>
	<h1><a href="${conPath }/insert.do">INSERT</a></h1>
	<h1><a href="${conPath }/select.do">SELECT</a></h1>
	<h1><a href="${conPath }/update.do">UPDATE</a></h1>
	<h1><a href="${conPath }/delete.do">DELETE</a></h1>
</body>
</html>