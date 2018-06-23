<%@page import="com.tj.ex.dto.FileboardDto"%>
<%@page import="com.tj.ex.dao.FileboardDao"%>
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
		width: 800px; height:415px;
		margin: 50px auto 40px;
	}
</style>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
	<table style="width:100%;">
		<tr><td colspan='7'>&nbsp;
			<%	if(session.getAttribute("ValidCustomer")!=null){%>
				<a href="fboardWriteForm.jsp">글쓰기</a>
			<%} %>&nbsp;
		</td></tr>
		<tr><th>글번호</th><th>작성자</th><td>글제목</td><td>메일</td>
			<th>IP</th><th>작성일</th><th>조회수</th>
		</tr>
	<%	String pageNum = request.getParameter("pageNum");
		if(pageNum==null){ // pageNum이 파라미터로 안 들어왔으면 1page로
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		final int PAGESIZE = 10, BLOCKSIZE=10;
		int startRow = (currentPage-1) * PAGESIZE + 1;
		int endRow   = startRow + PAGESIZE -1;
		//
		FileboardDao fbDao = FileboardDao.getInstance();
		int totCnt = fbDao.getFileboardTotCnt(); // 글갯수 리턴
		if(totCnt==0){
			out.print("<tr><td colspan='7'>데이터가 없습니다</td></tr>");	
		}else{
			ArrayList<FileboardDto> dtos = fbDao.listFileboard(startRow, endRow);
			for(int i=0 ; i<dtos.size() ; i++){
				out.print("<tr><td>"+dtos.get(i).getFnum()+"</td>");
				out.print("<td>"+dtos.get(i).getCname()+"</td>");
				// 글제목은 인기글 icon추가, 글제목을 클릭하면 상세보기 추가
				out.print("<td class='left'>");
				if(dtos.get(i).getFre_step()>0){//들여쓰기하기
					int width = dtos.get(i).getFre_level()*20;
					// 들여쓰기 효과
					out.print("<img src='../img/level.gif' width='"+width+"'"+" height='10'>");
					out.print("<img src='../img/re.gif'>");
				}
				if(dtos.get(i).getFreadcount()>10){
					out.print("<img src='../img/hot.gif'>");
				}
				out.print("<a href='fboardContent.jsp?fnum=");
				out.print(dtos.get(i).getFnum()+"&pageNum="+pageNum+"'>");
				out.print(dtos.get(i).getFsubject()+"</a></td>");
				out.print("<td>"+dtos.get(i).getCemail()+"</td>");
				out.print("<td>"+dtos.get(i).getFip()+"</td>");
				out.print("<td>"+dtos.get(i).getFrdate().toString().substring(0, 10)+"</td>");
				out.print("<td>"+dtos.get(i).getFreadcount()+"</td>");
			}
		}			
	%>
	</table>
	<div>
	<%	// 페이지 갯수(pageCnt)=마지막페이지 / 글갯수(totCnt)
		int pageCnt = (int)Math.ceil((double)totCnt/PAGESIZE);
		int startPage = ((currentPage-1)/BLOCKSIZE)*BLOCKSIZE +1;
		int endPage = startPage + BLOCKSIZE - 1;
		if(endPage>pageCnt){
			endPage = pageCnt;
		}
		if(startPage>BLOCKSIZE){
			out.print(" [ <a href='fboardList.jsp?pageNum="+(startPage-1)+"'>이전</a> ] ");
		}
		for(int i=startPage ; i<=endPage ; i++){
			if(i==currentPage){
				out.print("<font color='red'><b> [ "+i+" ] </b></font>");
			}else{
				out.print(" [ <a href='fboardList.jsp?pageNum="+i+"'>"+i+"</a> ] ");
			}
		}
		if(endPage<pageCnt){
			out.print(" [ <a href='fboardList.jsp?pageNum="+(endPage+1)+"'>다음</a> ] ");
		}
	%>	
	</div>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>