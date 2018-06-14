<%@page import="com.tj.dto.FriendDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.FriendDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>join</title>
	<style>
		#wrap, #outwrap{
			width : 35%;
			margin: 0 auto;
			text-align: center;
		}
	</style>
	<script>
		var fname = document.getElementById("fname").value;
		var tel = document.getElementById("tel").value;
		
		function serachFriend() {
			location.href = 'friendJoinSerach.jsp?fname='+ fname +"&tel="+ tel;
		}
	</script>
</head>
<%
	FriendDao friendDao = FriendDao.getInstance();
	ArrayList<FriendDto> dtos = friendDao.friendDaoSelectAll();
%>
<body>
	<div id="wrap">
		<form action="friendjoinOk.jsp" method="POST">
			<table>
				<tr>
					<td>친구이름</td>
					<td><input type="text" id="fname" name="fname" ></td>
					<td>전화</td>
					<td><input type="text" id="tel" name="tel" ></td>
					<td><input type="submit" value="친구추가"></td>
					<td><input type="button" value="검색" onclick="serachFriend()"></td>
				</tr>
			</table>
		</form>
		<hr>
		<div id="outwrap">
			<table>
				<tr>
					<td>번호</td>
					<td>이름</td>
					<td>전화</td>
				</tr>
				<%	for (FriendDto dtemp : dtos) { %>
				<tr>
					<td><%= dtemp.getNo() %></td>
					<td><%= dtemp.getFname() %></td>
					<td><%= dtemp.getTel() %></td>
				</tr>
				<% } %>
			</table>
		</div>
	</div>
</body>
</html>