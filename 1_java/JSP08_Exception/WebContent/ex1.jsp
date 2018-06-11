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
<%! int num1, num2; %>
<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	
	out.println("<h2> num1 = " + num1 + "num2 = " + num2 +"</h2>");
	out.println("<h2> num1 + num2 = " + (num1 + num2) + "</h2>");
	try{
		out.println("<h2> num1 / num2 = " + (num1 / num2) + "</h2>");
	} catch (Exception e) {
		out.println("<h2>0으로 나누는 부분은 제공되지 않습니다.</h2>"); // 예외가 발생하면 이부분을 실행.
	}
	out.println("<h2> num1 * num2 = " + (num1 * num2) + "</h2>");
	out.println("<h2> num1 - num2 = " + (num1 - num2) + "</h2>");
	out.println("<h2>이상 <h2>");
%>	
	<h2>num1 = <%= num1 %></h2>
	<h2>num2 = <%= num2 %></h2>
	
</body>
</html>