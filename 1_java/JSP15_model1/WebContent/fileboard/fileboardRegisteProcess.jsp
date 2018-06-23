
<%@page import="java.sql.Timestamp"%>
<%@page import="com.tj.dto.FileBoardDto"%>
<%@page import="com.tj.dto.CustomerDto"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.tj.dao.FileBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>fileboardRegisteProcess</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<%
	String path = request.getRealPath("upFile");
	int maxSize = 1024 * 1024 * 5; //최대 업로드 Size : 5Mbyte
	String files = "";

	MultipartRequest mRequest = null;
	
	try {
		mRequest 
		= new MultipartRequest(request, path, maxSize, "utf-8",
				new DefaultFileRenamePolicy());
	
		Enumeration<String> params = mRequest.getFileNames();
		
		while (params.hasMoreElements()) {
			String paramStr = params.nextElement();
			files = mRequest.getFilesystemName(paramStr);
		}
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	} 
	// 서버에 저장될 파일을 복사
		if (files != null){
			File f = new File(path + "/" + files);
			if (f.exists()) {
				InputStream is= null;
				OutputStream os =null;
				try {
					is = new FileInputStream(f);
					String copyFile = "C:/Users/Leodays/Desktop/Dev/webstudy/1_java/JSP15_model1/WebContent/upFile/" + files;
					os = new FileOutputStream(copyFile);
					
					byte[] bs = new byte[(int)f.length()];
					
					while (true) {
						int readByte = is.read(bs);
						if (readByte == -1) break;
						os.write(bs, 0, readByte);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				} finally {
					if (os != null) os.close();
					if (is != null) is.close();
				}
			}
		}
	//
	String pageNum = mRequest.getParameter("pageNum");
	int fnum = Integer.parseInt(mRequest.getParameter("fnum"));

	String cid = mRequest.getParameter("cid");
	String fsubject = mRequest.getParameter("fsubject");
	String fcontent = mRequest.getParameter("fcontent");	
	int freadCount = 0;
	String cname = mRequest.getParameter("cname");
	String cemail = mRequest.getParameter("cemail");
	String ffilename = files;
	String fpw = mRequest.getParameter("fpw");
	int fref = Integer.parseInt(mRequest.getParameter("fref"));
	int frestep = Integer.parseInt(mRequest.getParameter("frestep"));
	int frelevel = Integer.parseInt(mRequest.getParameter("frelevel"));
	String fIp = request.getRemoteAddr();
	
	FileBoardDto fdto = 
		new FileBoardDto(fnum, cid, null, null, fsubject, fcontent, ffilename, freadCount, fpw, 
				fref, frestep, frelevel, fIp, null);
	System.out.println("셋팅 글정보 : " + fdto.toString());
	
	FileBoardDao fDao = FileBoardDao.getInstance();
	int result = fDao.insertFileBoard(fdto);
	
	if (result == FileBoardDao.SUCCESS) {
		System.out.println("글쓰기 완료");
%>	
	<script>
		alert('글쓰기 성공했습니다');
		location.href = 'fileboardList.jsp?pageNum=<%= pageNum %>';
	</script>
<% } else { System.out.println("글쓰기  실패"); %>
	<script>
		alert('글쓰기 실패했습니다.');
		history.back();
	</script>
<%	} %>
</body>
</html>