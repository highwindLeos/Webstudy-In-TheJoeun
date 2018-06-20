
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>file3Process</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<%
	String path = request.getRealPath("fileupFolder");
	System.out.println(path);
	int maxSize = 1024 * 1024 * 5; // 최대  업로드 사이즈 : 5Mbyte
	String[] fileName = {"", "", ""}; //첨부가 3개 라서 배열로 받는다.
	String[] orignalFile = new String[3];
	
	try {
		MultipartRequest multipartRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
		Enumeration<String> params = multipartRequest.getFileNames();
		
		int idx = 0;
		while(params.hasMoreElements()) {
			
			String paramStr = params.nextElement();
			fileName[idx] = multipartRequest.getFilesystemName(paramStr);
			orignalFile[idx] = multipartRequest.getOriginalFileName(paramStr);
			
			out.println("<p>" + idx + "번째 파라미터는 " + paramStr + 
							" / 저장된 파일이름 : " + fileName[idx] + 
							" / 원래 파일이름 " + orignalFile[idx] + "</p>");
			
			idx++;
		}
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	// 서버에 올라간 파일을 소스폴더에 복사
	for (String ft : fileName) {
		if (ft != null) {
			
			InputStream is = null;
			OutputStream os = null;
			
			try {
				File upfile = new File(path + "/" + ft);
				is = new FileInputStream(upfile);
				String copyFolder = "C:/Users/Leodays/Desktop/Dev/webstudy/1_java/JSP14_fileupload/WebContent/fileupFolder/" + ft;
				os = new FileOutputStream(copyFolder);
				
				byte[] bs = new byte[(int)upfile.length()];
				
				while (true) {
					int readByte = is.read(bs);
					if (readByte == -1) {
						break;
					}
					os.write(bs, 0, readByte);
				}
				
			} catch (Exception e){
				System.out.println(e.getMessage());
			} finally {
				if (os != null) os.close();
				if (is != null) is.close();
			}
		}
	}

%>	
<h2>File 1</h2>
	<p> File 1 업로드한 원래 이름 : <%= orignalFile[2] %></p>
	<p> File 1 업로드해서 저장 이름 : <%= fileName[2] %></p>
	<p><img src="fileupFolder/<%= fileName[2] %>" alt="file1" /></p>
<h2>File 2</h2>
	<p> File 2 업로드한 원래 이름 : <%= orignalFile[1] %></p>
	<p> File 2 업로드해서 저장 이름 : <%= fileName[1] %></p>
	<p><img src="fileupFolder/<%= fileName[1] %>" alt="file2" /></p>
	
<h2>File 3</h2>
	<p> File 3 업로드한 원래 이름 : <%= orignalFile[0] %></p>
	<p> File 3 업로드해서 저장 이름 : <%= fileName[0] %></p>
	<p><img src="fileupFolder/<%= fileName[0] %>" alt="file3" /></p>
</body>
</html>