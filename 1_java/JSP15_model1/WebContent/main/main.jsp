
<%@page import="com.tj.dto.CustomerDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Main</title>
	<script>
		
	</script>
</head>
<body>
<jsp:include page="head.jsp" />
<div id="wrap">
<table>
	<tr>
		<td colspan="7"></td>
	</tr>
	<tr>
		<td colspan="7"><h3>회원 명단 List</h3></td>
	</tr>
<%
	CustomerDao dao = CustomerDao.getInstance();
	int totalCnt = dao.customerCnt();
	
	String pageNum = request.getParameter("pageNum");
	
	if (pageNum == null){
		pageNum = "1";
	}
	
	int currentPage = Integer.parseInt(pageNum);
	
	final int PAGESIZE = 5; // 상수 	한페이지에 보여줄 글수
	final int BLOCKSIZE = 10; // 상수 한 블록의 출력수 (이전다음)

	int startRow = (currentPage - 1) * PAGESIZE + 1; // 시작줄
	int endRow = startRow + PAGESIZE - 1; // 끝줄

	if (totalCnt == 0) {
%>
	<tr>
		<td colspan="7"><h3>출력한 회원이 없습니다.</h3></td>
	</tr>
<% } else { 
	ArrayList<CustomerDto> dtos = dao.listCustomer(startRow, endRow); %>
	<tr>
		<td>회원아이디</td>
		<td>패스워드</td>
		<td>이름</td>
		<td>연락처</td>
		<td>이메일</td>
		<td>성별</td>
		<td>주소</td>
	</tr>
<% for (CustomerDto ct : dtos) { %>
	<tr>
		<td><%= ct.getCid() %></td>
		<td><%= ct.getCpw() %></td>
		<td><%= ct.getCname() %></td>
		<td><%= ct.getCtel() != null ? ct.getCtel() : "연락처 없음" %></td>
		<td><%= ct.getCemail() %></td>
		<td><%= ct.getCgender() %></td>
		<td><%= ct.getCaddr() != null ? ct.getCaddr() : "주소 없음" %></td>
	</tr>
	<% } %>
<% } %>
	<%-- [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] [다음] --%>
	<tr>
		<td colspan="7">
		<%
			int pageCnt = (int)Math.ceil(((double)totalCnt / PAGESIZE));
			int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
			int endPage = startPage + BLOCKSIZE - 1;
			
			if (endPage > pageCnt) {
				endPage = pageCnt;
			}
			
			if (startPage > BLOCKSIZE) {
		%>
			<a href="main.jsp?pageNum=<%= startPage - 1 %>"><span class="pagingOut"> 이전 </span></a>
		<% } %>
		<% for (int i = startPage; i <= endPage; i++ ) { %>
		<%	if (i == currentPage){ %>
			<span class="pagingOut"><b><%= i %></b></span>
			<% } else { %>
			<a href="main.jsp?pageNum=<%= i %>"><span class="pagingOut"><%= i %></span></a>
			<% } %>
		<% } // 페이지 표시 반복 %>
		<% if (endPage < pageCnt) { %>
			<a href="list.jsp?pageNum=<%= (endPage + 1) %>" ><span class="pagingOut"> 다음  </span></a>
		<% } // 다음을 출력 %>
		</td>
	</tr>
	<tr>
		<td colspan="7">
			<% if (session.getAttribute("loginOk") != null) { %><a href="../book/bookRegister.jsp"><span class="pagingOut">도서 등록</span></a><% } %>
			<a href="../book/bookList.jsp"><span class="pagingOut">도서 보기</span></a>
		</td>
	</tr>
</table>
</div>
<jsp:include page="footer.jsp" />
</body>
</html>