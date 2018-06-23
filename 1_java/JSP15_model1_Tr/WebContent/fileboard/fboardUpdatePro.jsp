<%@page import="com.tj.ex.dto.FileboardDto"%>
<%@page import="com.tj.ex.dao.FileboardDao"%>
<%@page import="java.io.*"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	String path = request.getRealPath("fileboardUpload");
	int maxSize = 1024*1024*5; // 최대업로드파일 사이즈 : 5M
	String ffilename="";
	MultipartRequest multipartRequest = null;
	try{
		multipartRequest 
		 = new MultipartRequest(request, path, maxSize, "utf-8",
				 new DefaultFileRenamePolicy());
		Enumeration<String> fileparams = multipartRequest.getFileNames();
		String paramStr = fileparams.nextElement();
		ffilename = multipartRequest.getFilesystemName(paramStr);
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	InputStream is = null;
	OutputStream os = null;
	try{
		File serverfile = new File(path+"/"+ffilename);
		if(serverfile.exists()){ // 서버에 올린 파일이 있을 경우 카피
			is = new FileInputStream(serverfile);
			os = new FileOutputStream("D:/mega-IT/source/5_JSP/model1ex/WebContent/fileboardUpload/"+ffilename);
			byte[] bs = new byte[(int)serverfile.length()];
			while(true){
				int nReadbyte = is.read(bs);
				if(nReadbyte==-1) break;
				os.write(bs, 0, nReadbyte);
			}
		}
	}catch(Exception e){
		System.out.println(e.getMessage());
	}finally{
		try{
			if(os!=null) os.close();
			if(is!=null) is.close();
		}catch(Exception ignore){ }
	}
	String pageNum = multipartRequest.getParameter("pageNum");
	// 원래 첨부파일이름을 dbfilename에 받아 놓는다
	String dbfilename = multipartRequest.getParameter("dbfilename");
	if(ffilename==null)
		ffilename = dbfilename;
	out.println(ffilename);
	String fsubject = multipartRequest.getParameter("fsubject");
	String fcontent = multipartRequest.getParameter("fcontent");
	String fpw = multipartRequest.getParameter("fpw");
	String fip = request.getRemoteAddr();
	int fnum = Integer.parseInt(multipartRequest.getParameter("fnum"));
	FileboardDao fbDao = FileboardDao.getInstance();
	FileboardDto fbDto = new FileboardDto();
	fbDto.setFsubject(fsubject);
	fbDto.setFfilename(ffilename);
	fbDto.setFcontent(fcontent);
	fbDto.setFpw(fpw);
	fbDto.setFip(fip);
	fbDto.setFnum(fnum);
	int result = fbDao.updateFileboard(fbDto);
	if(result == FileboardDao.SUCCESS){%>
		<script>
			alert('글수정 성공');
			location.href = 'fboardList.jsp?pageNum=<%=pageNum%>'; // 글수정 후 목록페이지로
			// location.href = 'fboardContent.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>';
		</script>
<% 	}else{%>
		<script>
			alert('글수정 실패');
			//history.back();
			location.href = 'fboardUpdateForm.jsp?fnum=<%=fnum%>&pageNum=<%=pageNum%>';
		</script>
<%	} %>
</body>
</html>