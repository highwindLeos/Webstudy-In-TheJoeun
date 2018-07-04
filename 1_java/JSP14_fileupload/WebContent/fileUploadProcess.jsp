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
	<title>fileUploadProcess</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<%
	String path = request.getRealPath("fileupFolder");
	int maxSize = 1024 * 1024 * 10; // 첨부할 파일의 최대 용량 10 Mbyte
	
	String paramStr = "";
	String filename = "";
	String orignalname = "";
	
	MultipartRequest multipartRequest = null;
	
;	try {
		// cos 라이브러리에 있는 클래스.
		multipartRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy()); 
		// 중복된 파일 이름을 rename 처리하게됨.
		Enumeration<String> fileParams = multipartRequest.getFileNames(); // 파일이름들을 가져옴.
		
		while(fileParams.hasMoreElements()) {
			paramStr = fileParams.nextElement(); // 파일과 연결된 파라메터
			filename = multipartRequest.getFilesystemName(paramStr); // 파라미터의 파일 이름을 가져온다
			orignalname = multipartRequest.getOriginalFileName(paramStr); // 파일의 원래이름을 담는다.
		}
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}

	// 서버에 올라간 첨부 파일을 소스파일에 copy 하는 작업
	InputStream is = null;
	OutputStream os = null;
	
	try {
		File upFile = new File(path + "/" + filename); //서버에 올라간 파일
		if(upFile.exists()) { // 파일이 존재하는 경우만 copy
			is = new FileInputStream(upFile);
		
			String copyFolder = "C:/Users/Leodays/Desktop/Dev/webstudy/1_java/JSP14_fileupload/WebContent/fileupFolder/" + filename;
			os = new FileOutputStream(copyFolder); // 복사한 파일이 저장된 경로로 객체 생성
			
			byte[] bs = new byte[(int)upFile.length()]; // 파일의 용량만큼의 배열 생성.
			while (true){
				int nreadByte = is.read(bs); // 읽어들이기
				if (nreadByte == -1) {
					break;
				}
				os.write(bs, 0, nreadByte); // 복사작업
			}
		}
		
	} catch (Exception e){
		System.out.println(e.getMessage());
	} finally {
		if (os != null) os.close();
		if (is != null) is.close();
	}
	// 올라간 이름 받아오기. (파라미터 변수 : name)
	String name = multipartRequest.getParameter("name");
%>
	<h2>실행되는 폴더 <%= path %></h2>
	<h3>파라미터 이름 : <%= paramStr %></h3>
	<h3>서버에 올라간 파일이름 : <%= filename %></h3>
	<h3>첨부한 파일의 원래의 이름 : <%= orignalname %></h3>
<hr />
	<h2>넘어온 이름 : <%= name %></h2>
	<img src="fileupFolder/<%= filename %>" alt="서버에 올린 그림파일" />
</body>
</html>