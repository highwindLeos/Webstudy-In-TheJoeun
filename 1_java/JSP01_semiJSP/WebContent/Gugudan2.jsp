<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gugudan2</title>
</head>
<style>
	table {
		background-color: lightpink;
	}
	
	caption {
		font-weight: bold;
		padding: 15px;
	}
	
	table tr td {
		width : 150px;
		text-align : center;
		background-color : #fff;
		padding: 10px 5px;
	}
	
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
<script>
	window.onload = function (){
		
		var caption = document.getElementsByTagName('caption')[0];
		caption.onclick = function (){
			caption.style.color = 'lightblue';
		}; // caption 색상 바꾸기
		
		var back = document.getElementById('back');
		back.onclick = function() {
			location.href = 'gugudanIn2.jsp';
		};
		
	};
</script>
<body>
<%--
	JSP 주석은 HTML 에 표시 되지 않는다.
 --%>
<table>
<% 
	int startDan = Integer.parseInt(request.getParameter("startDan"));
	int endDan = Integer.parseInt(request.getParameter("endDan")); 
%>
<caption> <%= startDan %> ~ <%= endDan %> 단 까지 구구단</caption>
<%	
	for (int j = 1; j <= 9; j++){ 
%>
	<tr>
		<% for (int i = startDan; i <= endDan; i++) { %>
		<td> <%= i %> * <%= j %> = <%= i * j %></td>
	<% } %>
	</tr>
<% } %>
</table>
<button id="back">뒤로가기</button>
</body>
</html>