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
	<link href="${conPath }/css/board.css" rel="stylesheet">
	<style>
		#content{
			width : 800px;
			height : 400px;
			margin: 100px auto 0;
		}
	</style>
	<script></script>
	<title>main</title>
	</head>
<body>
<jsp:include page="../main/head.jsp" />
 	<div id="content" class="center">
 		<a href="${conPath }/loginForm.do"><img class="roundborder" src="${conPath}/img/user.png" alt="user" /></a>
 		<a href="${conPath }/adminLoginView.do"><img class="roundborder" src="${conPath}/img/admin.png" alt="admin" /></a>
	</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>