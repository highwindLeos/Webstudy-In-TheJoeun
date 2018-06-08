<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
</head>
<style>
	#login {
		width: 800px;
		margin: 0 auto;
		text-align: center;
	}
	
	table {
		width: 500px;
		border: 1px dashed #666;
		border-radius : 20px;
		padding: 15px;
		margin: 0 auto;
	}
	

	td {
		text-align: center;
		padding: 5px 0;
	}
	
	table tr td:nth-child(1) {
		width: 150px;
	}
	
	table tr td:nth-child(2) {
		width: 350px; 
	}
	
		table tr  td:nth-child(2) input {
			width: 350px;
		}
		
	table tr td input[type=submit] {
			width: 500px;
			margin : 15px;
			background-color: 
	}
	
</style>
<body>
<jsp:include page="head.jsp" />
<% 
	String msg = request.getParameter("msg"); 
	String id = request.getParameter("id");
%>
<div id="login">
	<form action="loginOk1.jsp" method="post">
		<table>
			<tr><td colspan="2"><h1><a href="login.jsp">로그인</a></h1></td></tr>
			<tr>
				<td>아 이 디</td>
				<td><input type="text" name="id" autofocus="autofocus" required="required" value="<% if(id != null) out.print(id); %>"></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="text" name="pw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>
	<% if(msg != null) { %>
		<h2><%= msg %></h2>
	<% } %>
</div>
</body>
</html>