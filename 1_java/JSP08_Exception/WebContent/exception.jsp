<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Exception</title>
	<style>
		p {
			text-align: center;
		}
	</style>
	<script>
	
	</script>
</head>
<body>
	<a href="xxx.jsp">없는 페이지로</a>
	<form action="ex2.jsp">
		<p>수 1 : <input type="number" name="num1" required="required" /></p>
		<p>수 2 : <input type="number" name="num2" required="required" /></p>
		<p><input type="submit" value="사칙연산 출력" /></p>
	</form>
</body>
</html>