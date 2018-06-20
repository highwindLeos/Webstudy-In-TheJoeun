
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dto.BookDto"%>
<%@page import="com.tj.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>BookList</title>
	<link rel="stylesheet" href="../css/board.css" />
	<script>

	</script>
</head>

<body>
<div id="wrap">
	<table>
		<tr>
			<td colspan="8"></td>
		</tr>
		<tr>
			<td>책 번호</td>
			<td>책 이미지1</td>
			<td>책 이미지2</td>
			<td>책 이름</td>
			<td>책 가격</td>
			<td>책의 할인율</td>
			<td>책의 할인 적용가격</td>
			<td>책 소개</td>
		</tr>
<%
	BookDao dao = BookDao.getInstance();
	int totalCnt = dao.getTotalCnt(); // 책목록 갯수를 구한다.
	
	if (totalCnt == 0) {
%>
	<tr><td colspan="8">표시할 책이 없습니다.</td></tr>
<% 	} else { // 목록이 존재하니까 출력해준다. 

	ArrayList<BookDto> dtos = dao.listBook();
	for (BookDto btemp : dtos) {
%>
		<tr>
			<td><%= btemp.getBid() %></td>
			<td><img class="imgBook" src="../bookImg/<%= btemp.getBimage1() %>" alt="BookImage1" /></td>
			<td><img class="imgBook" src="../bookImg/<%= btemp.getBimage2() %>" alt="BookImage2" /></td>
			<td><a href="bookContent.jsp?bid=<%= btemp.getBid() %>"><%= btemp.getBname() %></a></td>
			<td><%= btemp.getBprice() %> &#8361;</td>
			<td><%= btemp.getBdiscount() %>%</td>
			<td><%= Math.round(btemp.getBprice() - (btemp.getBprice() * (btemp.getBdiscount() * 0.01))) %> &#8361;</td>
			<td><%= btemp.getBcontent() %></td>
		</tr>
<%	} // end for
} //else end %>
		<tr>
			<td colspan="8">
				<input type="button" value="책등록하기" onclick="location.href = 'bookRegister.jsp'" />
			</td>
		</tr>
		<tr>
			<td colspan="8">Publising By Leos</td>
		</tr>
	</table>
</div>
</body>
</html>