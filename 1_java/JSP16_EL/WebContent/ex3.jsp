<%@page import="com.tj.ex.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title></title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="member" class="com.tj.ex.MemberInfo" scope="page" />
<jsp:setProperty name="member" property="*"/>
<p>이름 : <jsp:getProperty name="member" property="name" /></p>
<p>아이디 : <jsp:getProperty name="member" property="id" /></p>
<p>패스워드 : <jsp:getProperty name="member" property="pw" /></p>
<hr />
<p>이름 : <%= member.getName() %></p>
<p>아이디 : <%= member.getId() %></p>
<p>패스워드 : <%= member.getPw() %></p>
<hr />
<%-- getter를 호출하는 것임 : member.pw => member.getPw() --%>
<p>이름 : ${ member.name }</p><%-- 빈태그로 생성된 객체는 EL 로 접근 가능. --%>
<p>아이디 : ${ member.id }</p>
<p>패스워드 : ${ member.pw }</p>
<hr />
<p>이름 : ${ member["name"] }</p> 
<p>이름 : ${ member["id"] }</p> 
<p>이름 : ${ member["pw"] }</p> 
<% 
	MemberInfo mi = new MemberInfo();
	mi.setName(request.getParameter("name"));
	mi.setId(request.getParameter("id"));
	mi.setPw(request.getParameter("pw"));
%>
<hr />
<p> 이름 : <%= mi.getName() %> : 나옴</p>
<p> 아이디 : <%= mi.getId() %> : 나옴</p>
<p> 패스워드 : <%= mi.getPw() %> : 나옴</p>
<hr />
<p> 이름 : ${ empty mi ? "null 이네" : "null 이 아니네" } 안나옴</p><%-- 스크립트릿 내에 만든 객체는 EL 로 접근 불가 --%>
<p> 아이디 : ${ mi.id } 안나옴</p><%-- 스크립트릿 내에 만든 객체는 EL 로 접근 불가 --%>
<p> 패스워드 : ${ mi.pw } 안나옴</p><%-- 스크립트릿 내에 만든 객체는 EL 로 접근 불가 --%>
</body>
</html>