<%@page import="com.tj.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Member list View</title>
	<link rel="stylesheet" href="../css/registerResult.css" />
</head>
<body>
<%
	MemberDao memberDao = MemberDao.getInstance();
	ArrayList<MemberDto> dtos = memberDao.memberSelectAll();
%>
<table>
	<tr>
		<td colspan="5">회원 테이블 정보</td>
	</tr>
	<tr>
		<td>ID</td>
		<td>PW</td>
		<td>이름</td>
		<td>연락처</td>
		<td>성별</td>
	</tr>
	<% for (MemberDto dto : dtos) { %>
		<tr>
			<td><%= dto.getId() %></td>
			<td><%= dto.getPw() %></td>
			<td><%= dto.getName() %></td>
		<% if (dto.getPhone1() != null && dto.getPhone2() != null && dto.getPhone3() != null ) { %>
			<td><%= dto.getPhone1() %>-<%= dto.getPhone2() %>-<%= dto.getPhone3() %></td>
		<% } else { %>
			<td>연락처 없음</td>
		<% } %>
			<td><%= dto.getGender() %></td>
		</tr>	
	<% } %>
	<tr>
		<td colspan="5">Member Table</td>
	</tr>
</table>
</body>
</html>