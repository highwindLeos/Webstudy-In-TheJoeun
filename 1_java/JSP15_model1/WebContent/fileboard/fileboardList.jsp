
<%@page import="com.tj.dto.FileBoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>fileboardList</title>
	<link rel="stylesheet" href="../css/board.css">
	<script>
		
	</script>
</head>
<body>
<jsp:include page="../main/head.jsp" />
<div id="wrap">
	<table>
		<tr>
			<td colspan="7"></td>
		</tr>
		<tr>
			<td colspan="7"><h3>고객센터 (FileBoard)</h3></td>
		</tr>
		<tr>
			<td><h3>글번호</h3></td>
			<td><h3>작성자</h3></td>
			<td class="width"><h3>제목</h3></td>
			<td><h3>작성자 IP</h3></td>
			<td><h3>작성시간</h3></td>
			<td><h3>조회수</h3></td>
		</tr>
<%
	FileBoardDao fdao = FileBoardDao.getInstance();
	int totalCnt = fdao.getFileBoardCnt(); // 게시물 갯수를 구한다.
	
	String pageNum = request.getParameter("pageNum");
	
	if (pageNum == null) {
		pageNum = "1";
	}
	
	int currentPage = Integer.parseInt(pageNum);
	
	final int PAGESIZE = 5; // 한페이지당 표시된 글 갯수
	final int BLOCKSIZE = 10; // 한페이지당 블록 표시수
	
	int startRow = (currentPage -1) * PAGESIZE + 1;
	int endRow = startRow + PAGESIZE - 1;
	
	if (totalCnt == 0) {
%>
		<tr>
			<td colspan="7"><h3>표시할 게시물이 없습니다.</h3></td>
		</tr>
<% } else {  
	ArrayList<FileBoardDto> dtos = fdao.getFileBoardList(startRow, endRow);
		for (FileBoardDto ft : dtos) { %>
		<tr>
			<td><%= ft.getFnum() %></td>
			<td><%= ft.getCname() %></td>
			<td class="left width">
			<% if (ft.getFrelevel() > 0)  {
				int width = ft.getFrelevel() * 20;
			%>
				<img src='../img/dot.png' height='10' width='"+ width +"'/>
				<img id='arrow' src='../img/arrow.png'/>
			<% } %>
				<a href="fileBoardContent.jsp?fnum=<%= ft.getFnum() %>&pageNum=<%= pageNum %>" >
			<% if (ft.getFreadcount() > 10) { %>
				<img id='icon' src='../img/hot.gif' alt='hot' />
			<% } %><%= ft.getFsubject() %></a>
			</td>
			<td><%= ft.getFip() %></td>
			<td><%= ft.getfRdate() %></td>
			<td><%= ft.getFreadcount() %></td>
		</tr>
		<% } %>
	<% } %>
		<tr>
			<td colspan="7">
			<%
			int pageCnt = (int)Math.ceil(((double) totalCnt / PAGESIZE));
			int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
			int endPage = startPage + BLOCKSIZE - 1;
			
			if (endPage > pageCnt) {
				endPage = pageCnt;
			}
			
			if (startPage > BLOCKSIZE) {
			%>
				<a href="fileboardList.jsp?pageNum=<%= startPage - 1 %>"><span class="pagingOut"> 이전 </span></a>
			<% } %>
			<% for (int i = startPage; i <= endPage; i++ ) { %>
			<%	if (i == currentPage){ %>
				<span class="pagingOut"><b><%= i %></b></span>
				<% } else { %>
				<a href="fileboardList.jsp?pageNum=<%= i %>"><span class="pagingOut"><%= i %></span></a>
				<% } %>
			<% } // 페이지 표시 반복 %>
			<% if (endPage < pageCnt) { %>
				<a href="fileboardList.jsp?pageNum=<%= (endPage + 1) %>" ><span class="pagingOut"> 다음  </span></a>
			<% } // 다음을 출력 %>
			</td>
		</tr>
		<tr>
			<td colspan="7">
				<% if (session.getAttribute("loginOk") != null) { %><a href="fileboardRegister.jsp"><span class="pagingOut">글 등록</span></a><% } %>
			</td>
		</tr>
	</table>
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>