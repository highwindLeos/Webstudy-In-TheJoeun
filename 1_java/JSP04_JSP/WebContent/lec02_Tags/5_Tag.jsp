<%@page import="java.util.Date"%>
<%@page import="java.util.Arrays"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>지시자</title>
	<style>
		section {
			width : 50vw;
			margin: 0 auto;
		}
	</style>
	<script>
	
	</script>
</head>
<body>
	<section>
		<%
			int[] iArr = {10,20,30};
			out.println("<h2>iArr = " + Arrays.toString(iArr) + "</h2>");
			System.out.println("iArr = " + Arrays.toString(iArr)); // 콘솔에도 출력
		%>
		<hr />
		<h2>iArr = <%= Arrays.toString(iArr) %></h2>
		<h2>현제 시간 = <%= new Date() %></h2>
	</section>
	<%@include file="footer.jsp" %>
	<section>
		<hr />
		<h2>다시 5_Tag 페이지로 옴.</h2>
	</section>	
</body>
</html>