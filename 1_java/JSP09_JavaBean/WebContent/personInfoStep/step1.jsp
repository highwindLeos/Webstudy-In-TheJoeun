<%@page import="com.tj.ex.PersonInfo"%>
<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Step1</title>

</head>
<%
	PersonInfo pi = new PersonInfo();

	pi.setName("이데이");
	pi.setAge(22);
	pi.setGender("남자");
	
	String name = pi.getName();
	int age = pi.getAge();
	String gengder = pi.getGender();
%>
<body>
	<h2>개인정보</h2>
	<p>이름 : <%= name %></p>
	<p>나이 : <%= age %>살</p>
	<p>성별 : <%= gengder %></p>
	<hr />
	<h2>개인정보</h2>
	<p>이름 : <%= pi.getName() %></p>
	<p>나이 : <%= pi.getAge() %>살</p>
	<p>성별 : <%= pi.getGender() %></p>
</body>
</html>