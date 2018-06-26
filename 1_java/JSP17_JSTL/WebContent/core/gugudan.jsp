<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>gugudan</title>
	<link rel="stylesheet" href="">
	<style>
		td{
			padding : 5px;
		}
	</style>
	<script>
		
	</script>
</head>
<body>
<c:set var="dansu" value="${ param.dansu }"></c:set>
<table>
<c:forEach var="j" begin="1" end="9" >
	<tr>
		<c:forEach var="i" begin="2" end="9">
			<td><h3>${ i } * ${ j } = ${ i * j }&nbsp;&nbsp;</h3></td>
		</c:forEach>
	</tr>
</c:forEach>
</table>
</body>
</html>