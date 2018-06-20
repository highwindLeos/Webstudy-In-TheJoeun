
<%@page import="sun.security.krb5.internal.PAData"%>
<%@page import="com.tj.dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tj.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>List</title>
	<link rel="stylesheet" href="../css/board.css">
	<script>
		
	</script>
</head>
<body>
<div id="wrap">
	<table>
		<tr><td colspan='7'></td></tr>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th class="width">글제목</th>
			<th>메일</th>
			<th>IP</th>
			<th>작성일</th>
			<th>글 조회수</th>
		</tr>
<%
	BoardDao boardDao = BoardDao.getInstance();
	int totCnt = boardDao.getBoardCnt(); // 글갯수
	
	String pageNum = request.getParameter("pageNum");
	
	if(pageNum == null) {
		pageNum = "1";
	}
	
	int currentPage = Integer.parseInt(pageNum);
	
	final int PAGESIZE = 10; // 상수 	
	final int BLOCKSIZE = 10; // 상수
	
	int startRow = (currentPage - 1) * PAGESIZE + 1; // 시작 줄
	int endRow = startRow + PAGESIZE - 1; // 끝 줄
	
	if (totCnt == 0) {
		out.println("<tr><td colspan='7'>글이 없습니다.</td></tr>");
	} else { // 글이 있으니 글목록을 가져와 for 문으로 뿌려준다.
		// paging 에 필요한 변수들.
		
		ArrayList<BoardDto> dtos = boardDao.listBoard(startRow, endRow);
		for (BoardDto dt : dtos) {
		out.println("<tr>");
			out.println("<td>"+ dt.getNum() +"</td>");
			out.println("<td>"+ dt.getWriter() +"</td>");
			out.println("<td class='left width'>");
			// dt.getRe_level() 값이 0보다 크면 re_level 만큼 들여쓰기 하고 답변 image 를 넣는다.
			if (dt.getReLevel() > 0) {
				 int width = dt.getReLevel() * 20; // 들여쓰기 정도
				 out.println("<img src='../img/dot.png' height='10' width='"+ width +"'/>");
				 out.println("<img id='arrow' src='../img/arrow.png'/>");
			}
			out.println("<a href='content.jsp?num="+ dt.getNum() +"&pageNum="+ pageNum +"' />");
			if (dt.getReadCount() > 10) {
				out.println("<img id='icon' src='../img/hot.gif' alt='hot' />");
			}
			out.println(dt.getSubject() + "</a></td>");
			out.println("<td>");
			out.println(dt.getEmail() != null ? dt.getEmail() : "-");
			out.println("</td>");
			out.println("<td>"+ dt.getIp() +"</td>");
			out.println("<td>"+ dt.getRdate() +"</td>");
			out.println("<td>"+ dt.getReadCount() +"</td>");
		out.println("</tr>");
		}
	}
%>
		<tr><td colspan='7'>Publish by Leo</td></tr>
	</table>
	<%-- [1] [2] [3] [4] [5] [6] [7] [8] [9] [10] [다음] --%>
	<div id="paging">
	<%
		int pageCnt = (int) Math.ceil(((double)totCnt / PAGESIZE));
		int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		
		if (endPage > pageCnt) {
			endPage = pageCnt;
		}
		
		if (startPage > BLOCKSIZE) {
			out.println("[ <a href='list.jsp?pageNum="+ (startPage - 1) +"'>이전</a> ]");
		}// 이전을 출력
		
		for (int i = startPage; i <= endPage; i++ ) {
			
			if (i == currentPage){ // 현제 페이지라면 링크는 없다.
				out.println("<b>[ "+ i +" ]</b>");
			} else {
				out.println("[ <a href='list.jsp?pageNum="+ i +"'>"+ i +"</a> ]");
			}
			
		} // 페이지를 표시하는 반복문.
		
		if (endPage < pageCnt) {
			out.println(" [<a href='list.jsp?pageNum="+ (endPage + 1) +"' > 다음 </a> ] ");
		} // 다음을 출력
	
	%>	
	</div>
	<form action="">
		<p class="right">
			<input type="button" value="글쓰기" onclick="location.href = 'writeForm.jsp'" />
		</p>
	</form>
</div>
</body>
</html>