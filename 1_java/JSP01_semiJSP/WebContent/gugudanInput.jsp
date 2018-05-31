<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력</title>
<style>
	#wrap{
		width : 300px;
		margin : 0 auto;
		text-align: center;
	}
</style>
</head>
<body>
<div id="wrap">
	<form action="gugudanOut.jsp" method="GET">
		<p>원하는 단수 : <input type="text" id="dansu" name="dansu" /></p>
		<button >원하는 구구단 출력</button>
	</form>
</div>
</body>
</html>