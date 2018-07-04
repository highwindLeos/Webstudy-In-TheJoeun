
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
	<title>writeView</title>
	</head>
<body>
<jsp:include page="../main/head.jsp" />
<div id="wrap">
	<form action="${conPath }/write.do" method="POST">
		<table>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2">글쓰기</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="mId" value="${member.mId }" readonly="readonly" required="required"/></td>
			</tr>
			<tr>
				<td>제 목</td>
				<td><input type="text" name="bTitle" required="required" /></td>
			</tr>
			<tr>
				<td>본 문</td>
				<td>
					<textarea name="bContent" cols="32" rows="10"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글쓰기" />
					<input type="reset" value="재설정" />
					<input type="button" value="목록가기" onclick="location.href='${conPath}/list.do'" />
				</td>
			</tr>
			<tr>
				<td colspan="2"><h3>Publising LeoDays</h3></td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>