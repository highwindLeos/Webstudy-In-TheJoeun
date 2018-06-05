<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>한줄 메모</title>
	<style>
		/* table { border: 1px solid #666;} */
		td {
			text-align: center;
			padding: 5px;	
			border: 1px solid #666;
		}
	</style>
	<script>
	
	</script>
</head>
<%
	String name = request.getParameter("name");
	String memo = request.getParameter("memo");
	String date = new Date().toLocaleString(); // 글쓴시간
	String ip = request.getRemoteAddr(); // 요청한 컴퓨터의 아이피
%>
<body>
	<table>
		<tr>
			<td>작성자</td>
			<td><%= name %></td>
		</tr>
		<tr>
			<td>글내용</td>
			<td><%= memo %></td>
		</tr>
		<tr>
			<td>글쓴시간</td>
			<td><%= date %></td>
		</tr>
		<tr>
			<td>요청자 아이피</td>
			<td><%= ip %></td>
		</tr>
	</table>
</body>
</html>