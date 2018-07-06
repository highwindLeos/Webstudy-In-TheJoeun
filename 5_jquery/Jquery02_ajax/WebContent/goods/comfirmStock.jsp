<%@page import="com.tj.ex.dto.GoodsDto"%>
<%@page import="com.tj.ex.dao.GoodsDao"%>
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
<%
	String gname = request.getParameter("gname");
	GoodsDao gdao = new GoodsDao();
	GoodsDto gdto = gdao.getGoods(gname);
	int stock = gdto.getGstock();
	System.out.println(stock);
	if (gdto != null){
		if (stock > 0){ %>
			<span><%= gdto.getGstock() %> 개 남아있습니다.</span>
	<% 	} else { %>
			<span>재고가 없습니다.</span>
	<%	} %>
<%	} else { %>
		<span>없는 상품 입니다.</span>
<%	} %>
</body>
</html>