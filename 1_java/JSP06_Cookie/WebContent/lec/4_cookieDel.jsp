<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>쿠키 삭제하기</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
<% // 특정 쿠키 삭제하기. : 특정쿠키 찾고 -> 같은 이름은 0초짜리 쿠키를 삭제 (로그아웃 할때 이용)
	Cookie[] cookies = request.getCookies();
	for (int i = 0; i < cookies.length; i++) {
		if(cookies[i].getName().equals("CookieN")){
			Cookie c  = new Cookie("CookieN","");
			cookies[i].setMaxAge(0); //유효시간 0초 짜리 쿠키로 만든다.
			response.addCookie(cookies[i]);
			out.println("<h2>쿠키 삭제 성공</h2><br>");
		}
	}
%>
	<a href="2_cookieGet.jsp">생성 쿠키들 출력하기</a>	
	<a href="3_thatcookie.jsp">삭제한 특정 쿠키 확인</a>
</body>
</html>