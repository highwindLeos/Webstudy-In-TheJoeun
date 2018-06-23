
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.tj.dto.BookDto"%>
<%@page import="com.tj.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Book Content</title>
	<link rel="stylesheet" href="../css/board.css" />
</head>
<%
	int bid = Integer.parseInt(request.getParameter("bid"));

	BookDao bookDao = BookDao.getInstance();
	BookDto bookDto = bookDao.getBook(bid);
	
	DecimalFormat df = new DecimalFormat("#,###,##0");
%>
<body>
<div id="wrap">
	<form action="">
		<table>
			<tr>
				<td colspan="6"></td>
			</tr>
			<tr>
				<td colspan="6"><h1><%= bookDto.getBname() %> 책의 내용</h1></td>
			</tr>
			<tr>
				<td colspan="6"><h4><%= bookDto.getBname() %> 책 소개 이미지</h4></td>
			</tr>
			<tr>
				<td colspan="3"><img src="../bookImg/<%= bookDto.getBimage1() %>" alt="book Img 1" /></td>
				<td colspan="3"><img src="../bookImg/<%= bookDto.getBimage2() %>" alt="book Img 2" /></td>
			</tr>
			<tr>
				<td colspan="6"><h2>책 소개</h2></td>
			</tr>
			<tr>
				<td colspan="6" class="high_height"><pre><%= bookDto.getBcontent() %></pre></td>
			</tr>
			<tr>
				<td><b>책 가격</b></td>
				<td><%= df.format(bookDto.getBprice()) %> &#8361;</td>
				<td><b>할인율</b></td>
				<td><%= bookDto.getBdiscount() %> %</td>
				<td><b>할인 적용 가격</b></td>
				<td><%= df.format(Math.round(bookDto.getBprice() - (bookDto.getBprice() * (bookDto.getBdiscount() * 0.01)))) %> &#8361;</td>
			</tr>
			<tr>
				<td colspan="6">
					<input type="button" value="뒤로가기" onclick="location.href = 'bookList.jsp'" />
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<h3>Publising By Leo</h3>
				</td>
			</tr>
		</table>
	</form>
</div>
	
</body>
</html>