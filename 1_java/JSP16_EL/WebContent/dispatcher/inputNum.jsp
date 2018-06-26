<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>inputNum</title>
	<style>
		p{
			text-align: center;
		}
	</style>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
	<% int a = 5; %>
	<%= a %>
	<%= 5 %>
	${ 5 }
	${ a } <!-- 이 변수는 출력 안됨. -->
	<hr />
	<form action="../numProcess" >
		<p>누적을 원하는 수 <input type="number" min="1" name="num" /></p>
		<p><input type="submit" value="전송" /></p>
	</form>
</body>
</html>