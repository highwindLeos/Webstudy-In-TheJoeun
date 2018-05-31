<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단을 입력해봅시다.</title>
<style>
button {
		background-color: lightblue;
		color : #fff;
		border : 2px solid darkblue;
		border-radius: 5px;
		padding : 5px;
		margin-top : 5px;
		cursor: pointer;
	}
button:hover{
		color : #000;
	}
</style>
</head>
<body>
	<form action="Gugudan2.jsp" method="POST">
		<p>시작할 단수 : <input type="text" id="startDan" name="startDan"/></p>
		<p>구해질 단수 : <input type="text" id="endDan" name="endDan"/></p>
		<button>구구단 구하기</button>
	</form>	
</body>
</html>