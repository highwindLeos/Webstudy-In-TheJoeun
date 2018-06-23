<%@page import="com.tj.ex.dao.FileboardDao"%>
<%@page import="com.tj.ex.dto.FileboardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	if(session.getAttribute("ValidCustomer")==null){
		response.sendRedirect("../customer/loginForm.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
<style>
	#content {
		width: 800px; height:350px;
		margin: 0 auto;
	}
</style>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<div id="content">
<%	int fnum=0, fref=0, fre_step=0, fre_level=0; // 원글 - 초기화
	String pageNum = request.getParameter("pageNum");
	if(pageNum==null)
		pageNum = "1";
	FileboardDto fbDto = new FileboardDto();
	if(request.getParameter("fnum")!=null){ //답변글을 쓰려고 온 경우
		fnum = Integer.parseInt(request.getParameter("fnum"));
		FileboardDao fbDao = FileboardDao.getInstance();
		fbDto = fbDao.getFileboardOneLine(fnum);//원글에 대한 정보
		fref = fbDto.getFref(); // 원글의 ref를 넘겨줄 용도
		fre_step = fbDto.getFre_step(); // 원글에 대한 re_step도 넘겨
		fre_level = fbDto.getFre_level(); // 원글에 대한 re_level도 넘겨
	}

%>
	<form action="fboardWritePro.jsp" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pageNum" value="<%=pageNum %>">
		<input type="hidden" name="fnum" value="<%=fnum %>">
		<input type="hidden" name="fref" value="<%=fref%>">
		<input type="hidden" name="fre_step" value="<%=fre_step%>">
		<input type="hidden" name="fre_level" value="<%=fre_level%>">
		<table>
			<caption>글쓰기</caption>
			<tr><th>제목</th>
				<td><input type="text" name="fsubject" size="30"
						required="required" autofocus="autofocus"
						value="<%
							if(fbDto.getFsubject()!=null)
								out.print("[답]"+fbDto.getFsubject().substring(0, 2));
						%>"
						>
				</td>
			</tr>
			<tr><th>첨부파일</th>
				<td><input type="file" name="ffilename"></td>
			</tr>
			<tr><th>본문</th>
				<td><textarea rows="10" cols="32" name="fcontent"
						required="required"></textarea></td>
			</tr>
			<tr><th>삭제비번</th>
				<td><input type="password" name="fpw" size="30"
						required="required"></td>
			</tr>
			<tr><td colspan="2">
					<input type="submit" value="저장">
					<input type="reset"  value="다시">
					<input type="button" value="목록"
						onclick="location.href='fboardList.jsp?pageNum=<%=pageNum%>'">
		</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>