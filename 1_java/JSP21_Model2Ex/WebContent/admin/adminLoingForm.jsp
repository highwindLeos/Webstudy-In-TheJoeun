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
	<script></script>
	<title>adminLogin</title>
</head>
<c:if test="${not empty admin }">
	<script>location.href = '${conPath }/mAllView.do'</script>
</c:if>
<c:if test="${not empty member }">
	<script>location.href = '${conPath }/list.do'</script>
</c:if>
<body>
<jsp:include page="../main/head.jsp" />
<div id="wrap">
	<form action="${conPath }/adminLogin.do" method="POST">
		<table>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2"><h2>관리자 로그인</h2></td>
			</tr>
			<tr>
				<td>관리자 아이디 (admin)</td>
				<td><input type="text" name="aId" required="required" /></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="aPw" required="required" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="관리자 로그인" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><h3>Publising Leo</h3></td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>