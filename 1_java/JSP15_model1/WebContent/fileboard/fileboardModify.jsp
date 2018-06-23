
<%@page import="com.tj.dto.CustomerDto"%>
<%@page import="com.tj.dto.FileBoardDto"%>
<%@page import="com.tj.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>fileboardModify</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<%
	int fnum = Integer.parseInt(request.getParameter("fnum"));
	String pageNum = request.getParameter("pageNum");
	
	FileBoardDao dao = FileBoardDao.getInstance();
	FileBoardDto dto = dao.getFileBoardOneLine(fnum);
	
	CustomerDto cdto = (CustomerDto)session.getAttribute("cdto");
	
	System.out.println(cdto.toString());
	
	String cid = cdto.getCid();
	String cname = cdto.getCname();
	String cemail = cdto.getCemail();
%>
<body>
<jsp:include page="../main/head.jsp" />
<div id="wrap">
	<form action="fileboardModifyProcess.jsp" method="POST" enctype="multipart/form-data" >
		<input type="hidden" name="fnum" value="<%= fnum %>">
		<input type="hidden" name="pageNum" value="<%= pageNum %>">
		<table>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2"><h3><%= dto.getFnum() %>번 글 수정</h3></td>
			</tr>
			<tr>
				<td><label for="fsubject" >새 제목</label></td>
				<td><input type="text" id="fsubject" name="fsubject" size="30" value="<%= dto.getFsubject() %>" required="required" autofocus="autofocus"/></td>
			</tr>
			<tr>
				<td><label for="content" >수정할 본문</label></td>
				<td><textarea id="content" name="fcontent" placeholder="<%= dto.getFcontent() %>" rows="10" cols="31" required="required" ></textarea></td>
			</tr>
			<tr>
				<td><label for="ffilename" >수정해서 올릴 File</label></td>
				<td><input type="file" id="ffilename" name="ffilename" ></td>
			</tr>
			<tr>
				<td><label for="password" >수정할 패스워드</label></td>
				<td><input type="password" id="password" name="fpw" required="required" ></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정하기" />
					<input type="reset" value="다시설정" />
					<input type="button" value="목록보기" onclick="location.href ='fileboardList.jsp'" />
					<input type="button" value="이전으로" onclick="history.back()" />
				</td>
			</tr>
		</table>
	</form>
</div>	
<jsp:include page="../main/footer.jsp" />
</body>
</html>