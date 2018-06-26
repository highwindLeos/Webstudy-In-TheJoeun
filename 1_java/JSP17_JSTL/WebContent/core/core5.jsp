<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Title</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<h3>일반 For 문 스타일</h3>
<c:forEach var="i" begin="1" end="10" step="2" >
	<h4>${ i } : 안녕하세요. </h4>
</c:forEach>
<hr />
<h3>확장 For 문 스타일</h3>
<h3>확장 For 문 스타일 : 스크립트릿 이용</h3>
<% String[] names = {"leos","winds","kazemi"}; 
	for (String nt : names){
		out.println("<h2>" + nt + "</h2>");
	}
%>
<hr />
<h3>확장 For 문 스타일 : 표준태그이용</h3>
<c:set var="names" value="<%= names %>" />
<c:forEach items="${ names }" var="n">
	<h2>${ n }</h2>
</c:forEach>
<hr />
<h3>일반 For 문 스타일 : 일반 for 문식으로 배열 출력</h3>
<c:forEach var="i" begin="0" end="<%= names.length %>">
	<h2>${ names[i] }</h2>
</c:forEach>
</body>
</html>