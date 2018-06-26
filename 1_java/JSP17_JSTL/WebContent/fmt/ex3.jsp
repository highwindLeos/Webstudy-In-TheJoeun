
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>ex3</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
	<c:set var="now1" value="<%= new Date(System.currentTimeMillis()) %>" />
	now1 : ${ now1 }
	<hr />
	<c:set var="nowtime" value="<%= new Timestamp(System.currentTimeMillis())  %>" />
	nowtime : ${ nowtime }
	<hr />
	<h2>Date 형의 기본날짜 : ${ now1 }</h2>
	<h3>실행 날짜 (short 형) : <fmt:formatDate value="${now1 }" type="date" dateStyle="short" /></h3>
	<h3>실행 날짜 (medium 형) : <fmt:formatDate value="${now1 }" type="date" dateStyle="medium" /></h3>
	<h3>실행 날짜 (long 형) : <fmt:formatDate value="${now1 }" type="date" dateStyle="long" /></h3>
	<h3>실행 날짜 (full 형) : <fmt:formatDate value="${now1 }" type="date" dateStyle="full" /></h3>
	<hr />
	<h2>Date 형의 기본시간 : ${ now1 }</h2>
	<h3>실행 시간 (short 형) : <fmt:formatDate value="${now1 }" type="time" timeStyle="short" /></h3>
	<h3>실행 시간 (medium 형) : <fmt:formatDate value="${now1 }" type="time" timeStyle="medium" /></h3>
	<h3>실행 시간 (long 형) : <fmt:formatDate value="${now1 }" type="time" timeStyle="long" /></h3>
	<h3>실행 시간 (full 형) : <fmt:formatDate value="${now1 }" type="time" timeStyle="full" /></h3>
	<hr />
	<h3>날짜 시간 다나오는 출력 : <fmt:formatDate value="${now1 }" type="both" dateStyle="medium" timeStyle="long"/></h3>
	<hr />
	<h3>원하는 타입으로 날짜 시간을 출력 : <fmt:formatDate value="${now1 }" type="both" pattern="yyyy/MM/dd (E) hh:mm:ss(a)"/></h3>
	<h3>원하는 타입으로 날짜 시간을 출력 : <fmt:formatDate value="${now1 }" type="both" pattern="yyyy/MM/dd (E) HH:mm:ss"/> 24시간형</h3>
</body>
</html>