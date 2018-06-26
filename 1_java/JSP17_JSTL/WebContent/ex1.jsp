<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<fmt:requestEncoding value="utf-8"/> <!-- 한글로 넘어오는 request 정보를 인코딩해준다. -->
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JSTL</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<form action="">
<h3>인사를 몇번 받을까요?</h3>
	<input type="number" name="num1" min="1" />
<h3>받고 싶은 인사 ?</h3>
	<input type="text" name="greeting" min="1" />
	<input type="submit" value="인사받기" />
</form>
<h1>Core 라이브러리 사용</h1>
	<c:forEach begin="1" end="${ param.num1 }">
		<h2>${ param.greeting }</h2>
	</c:forEach>
<h1>Format 라이브러리</h1>
<h3><fmt:formatNumber value="3.14514" pattern="#,###.00" /></h3><!-- 3.15 반올림 됨 -->
<h1>Function 라이브러리 사용</h1>
	<c:forEach begin="1" end="${ param.num1 }">
		<p>입력한 인사말을 대문자로 전환 : ${ fn:toUpperCase(param.greeting) }</p>
	</c:forEach>
</body>
</html>