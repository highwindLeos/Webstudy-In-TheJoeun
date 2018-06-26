<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form action="" method="get">
		<p> 
			<input type="number" name="num1" value="<%= (int)(Math.random() * 9) + 1 %>" />
			* 
			<input type="number" name="num2" value="<%= (int)(Math.random() * 9) + 1 %>" /> 
			= 
			<input type="number" name= "result" />
		</p>
		<p><input type="submit" value="확인" /></p>	
	</form>
	
	<p>
		정답 여부 : ${ param.num1 } * ${ param.num2 } = ${ param.result } 는
		${ not empty param.result ? (param.num1 * param.num2 eq param.result ? "정답입니다" : "오답입니다.") : "" }
	</p>
</body>
</html>