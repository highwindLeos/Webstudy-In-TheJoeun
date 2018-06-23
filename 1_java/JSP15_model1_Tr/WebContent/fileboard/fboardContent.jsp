<%@page import="com.tj.ex.dto.FileboardDto"%>
<%@page import="com.tj.ex.dao.FileboardDao"%>
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
		width: 800px; height:400px;
		margin: 90px auto 10px;
	}
</style>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<div id="content">
<%	String pageNum = request.getParameter("pageNum");
	int fnum = Integer.parseInt(request.getParameter("fnum"));
	FileboardDao fbDao = FileboardDao.getInstance();
	fbDao.readCountUp(fnum);// 조회수 하나 증가
	FileboardDto fbDto = fbDao.getFileboardOneLine(fnum);
%>
	<table>
		<caption>글 상세보기</caption>
		<tr><th>글번호</th><td><%=fbDto.getFnum() %></td></tr>
		<tr><th>제목</th><td><%=fbDto.getFsubject()%></td></tr>
		<tr><th>작성자</th>
			<td><%=fbDto.getCname() %>
				( <a href="mailto:<%=fbDto.getCemail()%>"><%=fbDto.getCemail()%></a> )
			</td></tr>
		<tr><th>첨부파일</th>
			<td><%if(fbDto.getFfilename()==null){
							out.println("첨부파일 없음");
						}else{
							out.println("<a href='../fileboardUpload/"+fbDto.getFfilename()+"' target='_blank'>"+fbDto.getFfilename()+"</a>");
						}			
					%>
			</td>
		</tr>
		<tr><th>본문</th>
			<td><pre><%=fbDto.getFcontent() %></pre></td>
		</tr>
		<tr><th>작성일</th><td><%=fbDto.getFrdate() %></td></tr>
		<tr><th>조회수</th><td><%=fbDto.getFreadcount() %></td></tr>
		<tr><th>IP</th><td><%=fbDto.getFip() %></td></tr>
		<tr><td colspan="2">
			 <button onclick="location.href='fboardList.jsp?pageNum=<%=pageNum%>'">목록</button>
			 <% // 본인이 쓴 글이 아니면 수정버튼 안 나오게 함
			 	String sessionCid = (String)session.getAttribute("cid");
			 	String fbDtoCid = fbDto.getCid();
			 	if(fbDtoCid.equals(sessionCid)){ %>
			 <button 
			 onclick="location.href='fboardUpdateForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">
			 글수정</button>
			 <%	} %>
			 <button
			 onclick="location.href='fboardDeleteForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>'">
			 글삭제</button>
			 <%	// 로그인하지 않으면 답변버튼이 안 나온다
			 	if(session.getAttribute("ValidCustomer")!=null){%>
			 <button
			 onclick="location.href='fboardWriteForm.jsp?fnum=<%=fnum %>&pageNum=<%=pageNum %>'"
			 >답변</button>
			 <%	} %>
			</td>
		</tr>
	</table>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>