<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>ex4</title>
	<style>
		p {
			text-align: center;
		}
	</style>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
	<form action="ex4view.jsp">
		<p>이름<input type="text" name="name" /></p>
		<p>아이디<input type="text" name="id" /></p>
		<p>패스워드<input type="password" name="pw" /></p>
		<p><input type="submit" value="전송"/></p>
	</form>
<hr />
<%
	pageContext.setAttribute("page_name", "page_value");
	request.setAttribute("request_name", "request_value");
	session.setAttribute("session_name", "session_value");
	application.setAttribute("application_name", "application_value");
	// EX : 
%>

<h2>스크립트릿 표현식</h2>
<p>page 객체 속성 정보 : <%= pageContext.getAttribute("page_name") %></p>
<p>request 객체 속성 정보 : <%= request.getAttribute("request_name") %></p>
<p>session 객체 속성 정보 : <%= session.getAttribute("session_name") %></p>
<p>application 객체 속성 정보 : <%= application.getAttribute("application_name") %></p>
<hr />
<h2>EL 표현식</h2>
<p>page 객체 속성 정보 : ${ pageScope["page_name"] }</p>
<p>request 객체 속성 정보 : ${ requestScope["request_name"] }</p>
<p>session 객체 속성 정보 : ${ sessionScope["session_name"] }</p>
<p>application 객체 속성 정보 : ${ applicationScope["application_name"] }</p>
<hr />
<p>page 객체 속성 정보 : ${ pageScope.page_name }</p>
<p>request 객체 속성 정보 : ${ requestScope.request_name }</p>
<p>session 객체 속성 정보 : ${ sessionScope.session_name }</p>
<p>application 객체 속성 정보 : ${ applicationScope.application_name }</p>
<hr />
<h2>Scope 객체에 대한 값은 생략해서 값만 쓸수 있다.</h2>
<p>page 객체 속성 정보 : ${ page_name }</p>
<p>request 객체 속성 정보 : ${ request_name }</p>
<p>session 객체 속성 정보 : ${ session_name }</p>
<p>application 객체 속성 정보 : ${ application_name }</p>
</body>
</html>