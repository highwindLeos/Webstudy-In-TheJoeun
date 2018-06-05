<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Title</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>

<body>
	<% i = 0; %>
	<h2>i = <%= i %></h2>
	<h2>5+6 = <%= sum(5,6) %></h2>
	<%! // 선언부 : 문서를 읽을때 가장 먼저 한번만 실행됨.
		
		int i; // 전역변수 (선언부에 선언된 변수는 0으로 초기화됨)	
		
		int sum(int a, int b){
			return a + b;
		}
	%>
	<hr>
	<%
		out.println("<h2> i = " + ( ++i ) + "</h2>");
		out.println("<h2> 5 + 6 = " +  sum(5,6) + "</h2>");
	%>
	<form action="" method="GET">
		<fieldset>
		<legend>누적하기</legend>
		<p>숫자 : <input type="text" name="num" /><input type="submit" value="누적하기" /></p>
		</fieldset>
	</form>
</body>
</html>