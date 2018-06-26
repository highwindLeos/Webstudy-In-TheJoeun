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
<%
	String id = request.getParameter("id");
	String[] pets = request.getParameterValues("pets");
%>	
<p>아이디 : <%= id %></p>
<p>선택한 동물 : 
<% if (pets != null){ %>
	<% for (String pt : pets) { %>
		<%= pt %> &nbsp;
	<% } %>
<% } else { %>
	<p>선택한 동물이 없습니다.</p>
<% } %>
<hr />
<h2>EL 표기법으로 표현</h2>
<p>아이디 : ${ param.id }</p>
<p>
선택한 동물 :  ${ paramValues.pets[0] }
		  ${ paramValues.pets[1] }
		  ${ paramValues.pets[2] } 
</p>
</p>
</body>
</html>