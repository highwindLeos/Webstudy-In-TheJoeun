<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Title</title>
</head>
<style>
	body {
		text-align: center;
	}
	#msg {
		color : red;
		font-weight: bold;
		text-align: center;
	}
	
	button {
		width: 150px;
		height: 150px;
		color :  #fff;
		border : 1px solid lightpink;
		background-color: lightcoral; 
		border-radius : 20px;
		cursor: pointer;
	}
</style>
<script>
	function btn(num) {
		location.href = 'yabaCertificaton.jsp?num='+num;
	}
</script>
<body>
	<h2>코인이 들어있는 박스를 선택해보세요. </h2>
	<button onclick="btn(1)">1번</button>
	<button onclick="btn(2)">2번</button>
	<button onclick="btn(3)">3번</button>
	<br />
	<% 
		String msg = request.getParameter("msg");
	
		if (msg != null){
			out.println("<hr />");
			out.println("<div id=\"msg\">" + msg + "</div>");
		} 
	%>
	
</body>
</html>