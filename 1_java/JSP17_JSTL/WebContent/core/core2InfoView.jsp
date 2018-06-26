<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>core2InfoView</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
	<h3>상품정보</h3>
	<h4>${ CODE }</h4>
	<h4>${ CODE2 }</h4>
	<h4>${ CODE + CODE2 }</h4>
	<h4>${ NAME }</h4>
	<h4>${ PRICE } (scope를 벗어나서 안나올 예정)</h4>
</body>
</html>