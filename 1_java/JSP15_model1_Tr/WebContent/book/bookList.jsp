<%@page import="com.tj.ex.dto.BookDto"%>
<%@page import="com.tj.ex.dao.BookDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
<style>
	#content {
		width: 1000px; height:400px;
		margin: 40px auto;
	}
	#content b {color:red;}
</style>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<div id="content">
	<table style="width:70%; ">
		<tr>
	<%	/* 페이징 처리 시작 */
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null)
			pageNum = "1";
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 3, BLOCKSIZE=3;
		int startRow = (currentPage-1)*PAGESIZE +1;
		int endRow   = startRow + PAGESIZE -1;
		/* 페이징 처리 끝 */
		BookDao bDao = BookDao.getInstance();
		int totCnt = bDao.getTotCnt();
		if(totCnt==0){
			out.print("<tr><td colspan='4'>등록된 책이 없어요</td></tr>");
		}else{
			ArrayList<BookDto> bookList
				= bDao.listBook(startRow, endRow);
			
			for(int i=0;i<bookList.size() ; i++){%>
			<td style="width:30%;">
				<img src="../bookImg/<%=bookList.get(i).getBimage1() %>"><br>
				<%=bookList.get(i).getBtitle()%><br>				
				<del><%=bookList.get(i).getBprice() %></del><br>
				<%=bookList.get(i).getBprice()*(100-bookList.get(i).getBdiscount())/100 %>
				(<%=bookList.get(i).getBdiscount() %>% 할인)
			</td>
	 	<%}
	 }%>
	</table>
	<div class="paging">
	<%
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE+1;
		int endPage = startPage + BLOCKSIZE -1;
		if(endPage>pageCnt){
			endPage = pageCnt;
		}
		if(startPage>BLOCKSIZE){
			out.print("[ <a href='bookList.jsp?pageNum="
						+(startPage-1)+"'> 이전 </a> ]");
		}
		for(int i=startPage ; i<=endPage ; i++){
			if(i==currentPage){
				out.print("<b> [ "+ i +" ] </b>");
			}else{
				out.print(" [ <a href='bookList.jsp?pageNum="+i+"'>"+i+"</a> ] ");
			}
		}
		if(endPage<pageCnt){
			out.print(" [ <a href='bookList.jsp?pageNum="
						+(endPage+1)+"'>다음</a> ] ");
		}
	%>
	</div>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>