
<%@page import="java.io.File"%>
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
	<title>FileBoardDeleteProcess</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<%
	String fnum = request.getParameter("fnum");
	String fpw = request.getParameter("fpw");
	String pageNum = request.getParameter("pageNum");
	
	FileBoardDao fdao = FileBoardDao.getInstance();
	FileBoardDto fdto = fdao.getFileBoardOneLine(fnum);
	
	String filename = fdto.getFfilename();
	
	String path = "C:/Users/Leodays/Desktop/Dev/webstudy/1_java/JSP15_model1/WebContent/upFile/";
	File deleteFile = new File(path + filename);
	
	System.out.println(deleteFile);
	if (deleteFile.delete()) {
		System.out.println("파일삭제 성공" + deleteFile);
	} else {
		System.out.println("파일삭제 실패" + deleteFile);		
	}
	 // 게시물이 삭제될때 첨부파일도 삭제한다. (소스폴더에 삭제되면 TOMCAT 에서도 삭제된다)
	
	int result = fdao.delectFileBoard(fnum, fpw);
	if(result == FileBoardDao.SUCCESS) {
		System.out.println("굴 삭제 성공");
%>
	<script>
		alert('<%= fnum + "번 글이 삭제되었습니다" %>');
		location.href = 'fileboardList.jsp?pageNum=<%=pageNum %>';
	</script>
<% } else { System.out.println("굴 삭제 실패"); %>

	<script>
		alert('<%= fnum + "번 글이 삭제 실패했습니다." %>');
		location.href = 'fileboardDelete.jsp?fnum=<%= fnum %>&pageNum=<%= pageNum %>';
	</script>
<%  } %>
</body>
</html>