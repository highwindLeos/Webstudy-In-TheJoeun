<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Core6</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<form action="gugudan.jsp">
	<p>원하는 구구단 단수 : <input type="number" min="1" max="19" name="dansu" required="required"/></p>
	<p><input type="submit" value="구구단 출력"/></p>
</form>	
</body>
</html>