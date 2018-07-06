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
	<link href="" rel="stylesheet">
	<title>Title</title>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<style></style>
	<script></script>
	</head>
<body>
	<% response.sendRedirect("idConfirmView.do"); %>
</body>
</html>