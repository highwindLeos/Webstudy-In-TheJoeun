<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<style>
	h1{
		color: lightpink;
	}
</style>
<script>
	window.onload = function (){
		var h1 = document.getElementById('head');
		
		h1.onclick = function() {
			h1.style.color = '#666';
		}
		
	}
</script>
</head>
<body>
	<h1 id="head">Hellow world</h1>
	<% //자바소스를 넣을수 있습니다.
		int total = 0;
		for (int i =0; i < 100; i++){
			total += i;
		}
	%>
	
	<h2>1부터 100까지의 합은 <%= total %>입니다.</h2>
</body>
</html>