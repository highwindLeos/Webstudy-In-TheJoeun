<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.Random"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Coin Game</title>
	<style>
		p:nth-child(2) {
			color : red;
		}
	</style>
	<script>
	
	</script>
</head>
<%
	String strNum = request.getParameter("num");
	int num  = Integer.parseInt(strNum);
	
	Random random = new Random();
	
	int ramdomInt = random.nextInt(3)+1; // 1 ~ 3
	System.out.println(ramdomInt);
	
	if (num != ramdomInt){
		String msg = "Wrong! Try Again!<br>(틀렸어! 다시 해봐!)";
		msg = URLEncoder.encode(msg, "utf-8"); // 한글이 깨지지 않게 utf-8 인코딩해서 넘긴다.
		response.sendRedirect("coin.jsp?msg="+msg);
	} else {
%>
<body>
	<p>찍은 곳은 <%= num %>번이고 <br />랜덤으로 선택된 동전이 있는곳도 <%= ramdomInt %>번 </p>
	<p>정답</p>
<% } %>
	<button onclick="history.back()">뒤로가기</button>
</body>
</html>