
<%@page import="com.tj.dto.CustomerDto"%>
<%@page import="com.tj.dto.FileBoardDto"%>
<%@page import="com.tj.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<%
	if(session.getAttribute("loginOk") == null){
		response.sendRedirect("loginForm.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>fileboardRegister</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<jsp:include page="../main/head.jsp" />
<%
	int fnum = 0, fref = 0, freStep = 0, freLevel = 0; // 원글 - 초기화
	
	String pageNum = request.getParameter("pageNum");
	if (pageNum == null) {
		pageNum = "1";
	}
	
	FileBoardDto fdto = new  FileBoardDto();
	
	if (request.getParameter("fnum") != null) { //답변글인 경우
		
		fnum = Integer.parseInt(request.getParameter("fnum"));
		FileBoardDao fileBoardDao = FileBoardDao.getInstance();
		fdto = fileBoardDao.getFileBoardOneLine(fnum); // 원글의 번호
		
		fref = fdto.getFref(); // 원글의 ref 
		freStep = fdto.getFrestep(); // 원글의 freStep 
		freLevel = fdto.getFrelevel(); // 원글의 freLevel
	}

	CustomerDto cdto = (CustomerDto)session.getAttribute("cdto");
	
	String cid = (String)session.getAttribute("cid");
	String cname = (String)session.getAttribute("cname");
	String cemail = (String)session.getAttribute("cemail");
%>
<div id="wrap">
	<form action="fileboardRegisteProcess.jsp" method="POST" enctype="multipart/form-data" >
		<input type="hidden" name="pageNum" value="<%= pageNum %>" />
		<input type="hidden" name="fnum" value="<%= fnum %>" />

		<input type="hidden" name="fref" value="<%= fref %>" />
		<input type="hidden" name="frestep" value="<%= freStep %>" />
		<input type="hidden" name="frelevel" value="<%= freLevel %>" />
		
		<input type="hidden" name="cid" value="<%= cid %>" />
		<input type="hidden" name="cname" value="<%= cname %>" />
		<input type="hidden" name="cemail" value="<%= cemail %>" />
		<table>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2"><h2>글쓰기</h2></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="fsubject" required="required" 
					value="<% if(fdto.getFsubject() != null) out.print("[Re]" + fdto.getFsubject()); %>" autofocus="autofocus" /></td>
			</tr>
			<tr>
				<td>글 본문</td>
				<td><textarea name="fcontent" id="fcontent" cols="32" rows="10"></textarea></td>
			</tr>
			<tr>
				<td><label for="ffilename" >첨부 파일</label></td>
				<td><input type="file" id="ffilename" name="ffilename"/></td>
			</tr>
			<tr>
				<td><label for="fpw" >삭제 패스워드</label></td>
				<td><input type="password" id="fpw" name="fpw" size="30" required="required" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="저장" />
					<input type="reset" value="다시설정" />
					<input type="button" value="목록보기" onclick="location.href = 'fileboardList.jsp?pageNum=<%= pageNum %>'" />
				</td>
			</tr>
			<tr>
				<td colspan="2"></td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>