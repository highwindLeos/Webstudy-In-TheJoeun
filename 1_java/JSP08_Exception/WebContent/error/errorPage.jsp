<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@page isErrorPage= "true" %> <!-- 에러를 처리하는 페이지라고 지시해야 exception 객체를 사용할수 있다. -->
<% response.setStatus(200);  // 200 - 정상 응답.
	// 403 - 접근이 거부된 페이지
	// 404 - 찾을수 없는 페이지 
	// 405 - 접근을 허용 안하는 페이지
	// 407 - 프록시 인증이 필요한 페이지
	// 500 - Internal server Error (내부 서버에러)
%> <!-- 페이지의 응답을 정상 상태로 강제로 바꾼다. -->

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Error Page</title>
</head>
<body>
	<h1>공사중입니다. 죄송합니다.</h1>
	<%-- <h2><%= exception.getMessage() %></h2>
	<h3>예외 타입 : <%= exception.getClass().getName() %></h3>  이런 에러 메세지는 화면에 출력하지는 않고 콘솔에다가 출력한다.--%>
	<script>
		console.log('에러메세지 : <%= exception.getMessage() %>');
		console.log('에러 타입 : <%= exception.getClass().getName() %>'); //자바스크립트의 콘솔에 출력했다.
	</script>
</body>
</html>