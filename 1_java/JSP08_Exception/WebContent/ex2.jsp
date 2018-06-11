<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%-- <%@page errorPage="error/ex2ErrorPage.jsp" %> --%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
	
	out.println("<h2> num1 = " + num1 + "num2 = " + num2 +"</h2>");
	out.println("<h2> num1 / num2 = " + (num1 / num2) + "</h2>");
	out.println("<h2> num1 + num2 = " + (num1 + num2) + "</h2>");
	out.println("<h2> num1 * num2 = " + (num1 * num2) + "</h2>");
	out.println("<h2> num1 - num2 = " + (num1 - num2) + "</h2>");
	out.println("<h2>이상 <h2>");
%>
</body>
</html>