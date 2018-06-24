
<%@page import="com.tj.dto.FileBoardDto"%>
<%@page import="com.tj.dao.FileBoardDao"%>
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
	String pageNum = request.getParameter("pageNum");
	int fnum = Integer.parseInt(request.getParameter("fnum"));

	FileBoardDao fDao = FileBoardDao.getInstance();
	fDao.readCountUp(fnum); // 조회수 1증가
	FileBoardDto fdto = fDao.getFileBoardOneLine(fnum);
	
	DecimalFormat df = new DecimalFormat("#,###,##0");
	
	String cid = (String)session.getAttribute("cid");
	if (cid == null) {	cid = ""; }
%>
<body>
<jsp:include page="../main/head.jsp" />
<div id="wrap">
	<form action="">
		<table>
			<tr>
				<td colspan="6"></td>
			</tr>
			<tr>
				<td colspan="6"><h1><%= fdto.getFsubject() %></h1></td>
			</tr>
			<tr>
				<td colspan="2"><h3>작성자</h3></td>
				<td colspan="4"><h4><%= fdto.getCid() %></h4></td>
			</tr>
			<tr>
				<td colspan="6"><h2>글내용</h2></td>
			</tr>
			<tr>
				<td colspan="6" class="high_height"><pre><%= fdto.getFcontent() %></pre></td>
			</tr>
			<tr>
				<td><b>메일</b></td>
				<td><%= fdto.getCemail() %></td>
				<td><b>작성자 ip</b></td>
				<td><%= fdto.getFip() %> %</td>
				<td><b>조회수</b></td>
				<td><%= fdto.getFreadcount() %></td>
			</tr>
			<tr>
				<td colspan="3">첨부 파일(5Mbyte 이하첨부)</td>
				<td colspan="3">
					<% if (fdto.getFfilename() != null) { %>
						<a href="../upFile/<%= fdto.getFfilename() %>"><%= fdto.getFfilename() %></a>
					<% } else { %>
						<span>첨부파일 없음</span>
					<% } %>
				</td>
			</tr> 
			<tr>
				<td colspan="6">
				<% if ( cid.equals(fdto.getCid()) ) { %>
					<input type="button" value="글수정" onclick="location.href ='fileboardModify.jsp?fnum=<%= fnum %>&pageNum=<%= pageNum %>'" />
					<input type="button" value="글삭제" onclick="location.href ='fileboardDelete.jsp?fnum=<%= fnum %>&pageNum=<%= pageNum %>'" />
				<% } %>
				<% if ( session.getAttribute("loginOk") != null) { %>
					<input type="button" value="답변달기" onclick="location.href = 'fileboardRegister.jsp?fnum=<%= fnum %>&pageNum=<%= pageNum %>'" />
				<% } %>
					<input type="button" value="뒤로가기" onclick="location.href ='fileboardList.jsp'" />
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
<jsp:include page="../main/footer.jsp" />	
</body>
</html>