
<%@page import="com.tj.dao.BookDao"%>
<%@page import="com.tj.dto.BookDto"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
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
	<title>bookRegisterProcess</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<%
	String path = request.getRealPath("bookImg");
	System.out.println(path);
	
	MultipartRequest multipartRequest = null;
	
	int maxSize = 1024 * 1024 * 5; // 5mbyte
	String[] bImage = new String[2];
	try {
		multipartRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		Enumeration<String> params = multipartRequest.getFileNames();
		
		int idx = 0;
		while (params.hasMoreElements()){
			String paramStr = params.nextElement();
			bImage[idx] = multipartRequest.getFilesystemName(paramStr);
			
			idx++;
		}
	// bimage[0] = 파라미터 bImage 로 들어온 파일이름
	// bimage[1] = 파라미터 bImage 로 들어온 파일이름
	} catch (Exception e) {
		System.out.println(e.getMessage());
	} 
	// 서버에 저장된 파일을 소스 폴더의 bookImg 에 복사
	for (String bt : bImage) {
		if (bt != null) {
			File file = new File(path + "/" + bt);
			if (file.exists()){
				InputStream is = null;
				OutputStream os = null;
				
				try {
					is = new FileInputStream(file);
					String copyFile = "C:/Users/Leodays/Desktop/Dev/webstudy/1_java/JSP15_model1/WebContent/bookImg/" + bt;
					os = new FileOutputStream(copyFile);
					
					byte[] bs = new byte[(int)file.length()];
					
					while(true){
						int readByte = is.read(bs);
						if (readByte == -1){
							break;
						}
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
	} // 복사 로직
	
	// Dto객체를 생성해서 insert할 내용들을 담아서
	String bname = multipartRequest.getParameter("bname");
	int bprice = Integer.parseInt(multipartRequest.getParameter("bprice"));
		
	if (bImage[1] == null) { bImage[1] = "nothing.jpg"; }
	if (bImage[0] == null) { bImage[0] = "nothing.jpg"; }
	
	String bImage1 = bImage[1];
	String bImage2 = bImage[0];
	String bcontent = multipartRequest.getParameter("bcontent");
	int bdiscount = Integer.parseInt(multipartRequest.getParameter("bdiscount"));

	BookDto dto = new BookDto(0, bname, bprice, bImage1, bImage2, bcontent, bdiscount);
	
	// dao.insertBook(dto) 로 입력
	BookDao dao = BookDao.getInstance();
	System.out.println(dto.toString());
	int result = dao.insertBook(dto);
	
	if (result == BookDao.SUCCESS) {
%>	
	<script>
		alert('책 정보 입력 성공');
		location.href = 'bookList.jsp';
	</script>
<% } else { %>
	<script>
		alert('책정보 입력 실패');
		history.back();
	</script>
<% } %>
</body>
</html>