<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cookie GET</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
<% 
	Cookie[] cookies = request.getCookies(); // 배열로 쿠키들을 반환한다.
	if (cookies == null) {
		out.println("<h2>생성된 쿠키가 하나도 없습니다.</h2>");
	} else {
		for (int i= 0; i < cookies.length; i++) {
			String name = cookies[i].getName();
			String value = cookies[i].getValue();
			
			out.println("<h2>쿠키이름은 : " + name + "</h2>");
			out.println("<h2>쿠키 값은 : " + value + "</h2>");
			out.println("<hr>");
		}
	}
%>
</body>
</html>