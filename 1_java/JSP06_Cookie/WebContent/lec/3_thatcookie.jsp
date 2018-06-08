<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>특정 쿠키를 찾기</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
<%! String name, value; %>
<%
	name = null; value= null;
	Cookie[] cookies = request.getCookies();
	
	for(int i=0; i < cookies.length; i ++){
		name = cookies[i].getName();
		if(name.equals("CookieN")) {
			value = cookies[i].getValue();
			break;
		}
	}
	
	if(value != null){
		out.println("<h2> 찾은 쿠키의 이름은 : "+ name + "<br></h2>");
		out.println("<h2>찾은 쿠키의 값은 : " + value + "<br></h2>");
	} else {
		out.println("찾는 특정 쿠키(CookieN)가 없습니다.");
	}
%>
	<a href="1_cookieConstruct.jsp">쿠키 생성하기. (CookieN)</a>
	<a href="2_cookieGet.jsp">생성 쿠키들 출력하기</a>	
	<a href="4_cookieDel.jsp">쿠키 삭제하기.</a>

</body>
</html>