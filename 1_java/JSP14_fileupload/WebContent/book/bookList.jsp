
<%@page import="java.text.DecimalFormat"%>
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
<%
	BookDao dao = BookDao.getInstance();
	int totalCnt = dao.getTotalCnt(); // 책목록 갯수를 구한다.
	
	DecimalFormat df = new DecimalFormat("#,###,##0"); // 9,999,990
	
	if (totalCnt == 0) {
%>
	<tr><td colspan="8">표시할 책이 없습니다.</td></tr>
<% 	} else { // 목록이 존재하니까 출력해준다. 
	ArrayList<BookDto> dtos = dao.listBook(); %>
	<tr>
<%	for (int i = 0; i < dtos.size(); i++) { %>
		<td>
			<img class="imgBook" src="../bookImg/<%= dtos.get(i).getBimage1() %>" alt="BookImage1" /><br />
			<a href="bookContent.jsp?bid=<%= dtos.get(i).getBid() %>"><%= dtos.get(i).getBname() %></a><br />
			정가 : <del><%= df.format(dtos.get(i).getBprice()) %> &#8361;</del><br />
			<span class="discount"><%= df.format(Math.round(dtos.get(i).getBprice() - (dtos.get(i).getBprice() * (dtos.get(i).getBdiscount() * 0.01)))) %> &#8361;</span>
			<%= dtos.get(i).getBdiscount() %>% 할인
		</td>
	<% if ( i % 3 == 2){
		out.println("</tr><tr>");	
	} // 3개 출력후 줄바꿈 %>
<%	} // end for %>
	</tr>
<% } //else end %>
		<tr>
			<td colspan="8">
				<input type="button" value="책등록하기" onclick="location.href = 'bookRegister.jsp'" />
			</td>
		</tr>
		<tr>
			<td colspan="8"><h3>Publising By Leos</h3></td>
		</tr>
	</table>
<hr />
	<table>
		<caption><h3>페이징 처리(한 화면 )</h3></caption>
		<tr>
			<td colspan="8"></td>
		</tr>
<%
	String pageNum = request.getParameter("pageNum");
	if (pageNum == null) pageNum = "1";
	
	int currentPage = Integer.parseInt(pageNum);
	
	final int PAGESIZE = 6, BLOCKSIZE = 2;
	
	int startRow = (currentPage -1) * PAGESIZE + 1;
	int endRow = startRow + PAGESIZE - 1;
	
	ArrayList<BookDto> dtos = dao.listBook(startRow, endRow); // page 기능을 구현한 listBook()
	
	if (totalCnt == 0) {
%>
	<tr><td colspan="8">표시할 책이 없습니다.</td></tr>
<% 	} else { // 목록이 존재하니까 출력해준다.  %>
	<tr>
<%	for (int i = 0; i < dtos.size(); i++) { %>
		<td>
			<img class="imgBook" src="../bookImg/<%= dtos.get(i).getBimage1() %>" alt="BookImage1" /><br />
			<a href="bookContent.jsp?bid=<%= dtos.get(i).getBid() %>"><%= dtos.get(i).getBname() %></a><br />
			정가 : <del><%= df.format(dtos.get(i).getBprice()) %> &#8361;</del><br />
			<span class="discount"><%= df.format(Math.round(dtos.get(i).getBprice() - (dtos.get(i).getBprice() * (dtos.get(i).getBdiscount() * 0.01)))) %> &#8361;</span>
			<%= dtos.get(i).getBdiscount() %>% 할인
		</td>
		<% if ( i % 3 == 2){
		out.println("</tr><tr>");	
	} // 3개 출력후 줄바꿈 %>
<%	} // end for %>
	</tr>
<% } //else end %>
		<tr>
			<td colspan="8">
				<input type="button" value="책등록하기" onclick="location.href = 'bookRegister.jsp'" />
			</td>
		</tr>
		<tr>
			<td colspan="8"><h3>Publising By Leos</h3></td>
		</tr>
	</table>
	<div id="paging">
	<%
		int pageCnt = (int)Math.ceil((double)totalCnt/PAGESIZE);
		int startPage = ((currentPage-1)/BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		if (endPage > pageCnt) { endPage = pageCnt; }
		if (startPage > BLOCKSIZE) { %>
		[ <a href="bookList.jsp?pageNum=<%= startPage - 1 %>">이전</a> ]
	<%  } 
		for (int i = startPage; i <= endPage; i++){
			if (i == currentPage){ %>
			[<%= i %>]
		<% } else {%>
			[ <a href="bookList.jsp?pageNum=<%= i %>"><%= i %></a> ]
		<% } %>
	<% } %> 
	<% if (endPage < pageCnt) { %>
		[ <a href="bookList.jsp?pageNum=<%= endPage + 1 %>">다음</a> ]
	<% } %>
	</div>
	
</div>
</body>
</html>