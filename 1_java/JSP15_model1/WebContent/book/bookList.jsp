
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.tj.dto.BookDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>BookList</title>
	<link rel="stylesheet" href="../css/board.css" />
	<script>
		
	</script>
</head>
<body>
<%@include file="../main/head.jsp" %>
<div id="wrap">
	<table>
		<tr>
			<td colspan="4"></td>
		</tr>
<%
	BookDao bdao = BookDao.getInstance();
	int totalCntBook = bdao.getTotalCnt(); // 테이블 목록의 갯수 반환
	
	DecimalFormat df = new DecimalFormat("#,###,##0"); // 9,999,990

	String pageNum = request.getParameter("pageNum");
	if (pageNum == null) pageNum = "1";
	
	int currentPage = Integer.parseInt(pageNum);
	
	final int PAGESIZE = 4, BLOCKSIZE = 2;
	
	int startRow = (currentPage -1) * PAGESIZE + 1;
	int endRow = startRow + PAGESIZE - 1;
	
	ArrayList<BookDto> dtos = bdao.listBook(startRow, endRow); // page 기능을 구현한 listBook()
	
	if (totalCntBook == 0) {
%>
		<tr>
			<td colspan="4">표시할 책이 없습니다.</td>
		</tr>
<% } else { %>
	<tr>
	<% for(int i= 0; i < dtos.size(); i++) { %>
		<td>
			<a href="bookContent.jsp?bid=<%= dtos.get(i).getBid() %>"><img class="imgBook" src="../bookImg/<%= dtos.get(i).getBimage1() %>" alt="BookImage1" /><br />
			<%= dtos.get(i).getBtitle() %></a><br />
			정가 : <del><%= df.format(dtos.get(i).getBprice()) %> &#8361;</del><br />
			<span class="discount"><%= df.format(Math.round(dtos.get(i).getBprice() - (dtos.get(i).getBprice() * (dtos.get(i).getBdiscount() * 0.01)))) %> &#8361;</span>
			<%= dtos.get(i).getBdiscount() %>% 할인
		</td>
		<% if (i % 4 == 3) { out.print("<tr></tr>"); } %>
	<% } %>
	</tr>
<% } %>
	<tr>
		<td colspan="4">
		<%
			int pageCnt = (int)Math.ceil(((double)totalCntBook / PAGESIZE));
			int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
			int endPage = startPage + BLOCKSIZE - 1;
			
			if (endPage > pageCnt) {
				endPage = pageCnt;
			}
			
			if (startPage > BLOCKSIZE) {
		%>
			<a href="bookList.jsp?pageNum=<%= startPage - 1 %>"><span class="pagingOut"> 이전  </span></a>
		<% } %>
		<% for (int i = startPage; i <= endPage; i++ ) { %>
		<%	if (i == currentPage){ %>
			<span class="pagingOut"><b><%= i %></b></span>
			<% } else { %>
			<a href="bookList.jsp?pageNum=<%= i %>"><span class="pagingOut"><%= i %></span></a>
			<% } %>
		<% } // 페이지 표시 반복 %>
		<% if (endPage < pageCnt) { %>
			<a href="bookList.jsp?pageNum=<%= (endPage + 1) %>" ><span class="pagingOut"> 다음  </span></a>
		<% } // 다음을 출력 %>
		</td>
	</tr>
	<tr>
		<td colspan="4">
			<% if (session.getAttribute("loginOk") != null) { %><a href="bookRegister.jsp"><span class="pagingOut">도서 등록</span></a><% } %>
			<a href="bookList.jsp"><span class="pagingOut">도서 보기</span></a>
		</td>
	</tr>
	</table>
</div>
<%@include file="../main/footer.jsp" %>
</body>
</html>