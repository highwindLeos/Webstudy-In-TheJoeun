
<%@page import="com.tj.dao.BookDao"%>
<%@page import="com.tj.dto.BookDto"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.File"%>
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
	<title>BookRegisterProcess</title>
	<link rel="stylesheet" href="../css/board.css">
	<script>
		
	</script>
</head>
<body>
<%
	String path = request.getRealPath("bookImg");
	System.out.println(path);
	int maxSize = 1024 * 1024 * 5; //최대 업로드 Size : 5Mbyte
	String[] bImage = {"", ""};
	MultipartRequest mRequest = null;
	
	try{
		mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
		// 서버에 저장된 파일의 이름을 bimage[0], bimage[1] 저장
		Enumeration<String> params = mRequest.getFileNames();
		
		int idx = 0;
		while (params.hasMoreElements()) {
			String paramStr = params.nextElement();
			bImage[idx] = mRequest.getFilesystemName(paramStr);
			
			idx++;
		} 
		// bimage[0] = 파라미터 bImage 로 들어온 파일이름
		// bimage[1] = 파라미터 bImage 로 들어온 파일이름
	} catch (Exception e){
		System.out.println(e.getMessage());
	}
	// 서버에 저장된 파일을 소스 폴더의 bookImg 에 복사
	for (String bimgTemp : bImage){
		if (bimgTemp != null) {
			File file = new File(path + "/" + bimgTemp);
			if(file.exists()) {
				InputStream is = null;
				OutputStream os = null;
				try{
					is = new FileInputStream(file);
					String copyFile = "C:/Users/Leodays/Desktop/Dev/webstudy/1_java/JSP14_fileupload/WebContent/bookImg/" + bimgTemp; // noteBooks 경로
					// String copyFile = "C:/Users/Leos/Desktop/Dev/webstudy/1_java/JSP14_fileupload/WebContent/bookImg/" + bimgTemp; // PC 경로
					os = new FileOutputStream(copyFile);
					
					byte[] bs = new byte[(int)file.length()]; // 파일 단위로 생성해놓는다.
					
					while(true){
						int readByte = is.read(bs);
						if (readByte == -1){
							break;
						}
						os.write(bs, 0, readByte);
					}
					
				}catch (Exception e){
					System.out.println(e.getMessage());
				} finally {
					if (os != null) os.close();
					if (is != null) is.close();
				}
			} // end if
		} // end if
	} // 반복문
	
	// Dto객체를 생성해서 insert할 내용들을 담아서
	String bname = mRequest.getParameter("bname");
	int bprice = Integer.parseInt(mRequest.getParameter("bprice"));
	
	if (bImage[1] == null) { bImage[1] = "nothing.jpg"; }
	if (bImage[0] == null) { bImage[0] = "nothing.jpg"; }
	
	String bImage1 = bImage[1];
	String bImage2 = bImage[0];
	String bcontent = mRequest.getParameter("bcontent");
	int bdiscount = Integer.parseInt(mRequest.getParameter("bdiscount"));

	BookDto dto = new BookDto(0, bname, bprice, bImage1, bImage2, bcontent, bdiscount);
	
	// dao.insertBook(dto) 로 입력
	BookDao dao = BookDao.getInstance();
	System.out.println(dto.toString());
	int result = dao.insertBook(dto);
	
	if(result == BookDao.SUCCESS) {
%>
<div id="wrap">
	<table>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td><h1>등록된 책정보</h1></td>
		</tr>
		<tr>
			<td><h2>제목 : <%=  bname %></h2></td>
		</tr>
		<tr>
			<td><h2>가격 : <%=  bprice %></h2></td>
		</tr>
		<tr>
			<td><h2>그림1 : <img class="imgBook" src="../bookImg/<%= bImage[1] %>" /></h2></td>
		</tr>
		<tr>
			<td><h2>그림1 : <img class="imgBook" src="../bookImg/<%= bImage[0] %>" /></h2></td>
		</tr>
		<tr>
			<td><h3><pre>책 소개 : <%= bcontent %></pre></h3></td>
		</tr>
		<tr>
			<td><h2>할인율 : <%= bdiscount %> %</h2></td>
		</tr>
		<tr>
			<td></td>
		</tr>
	</table>
</div>
<%	} else { %>
<div id="wrap">
	<table>
		<tr><td></td></tr>
		<tr><td><h1>책 정보 등록 실패</h1></td></tr>
		<tr><td><h2>제목 : <%=  bname %></h2></td></tr>
		<tr><td><h2>가격 : <%=  bprice %></h2></td></tr>
		<tr><td><h2>그림1 : <img class="imgBook" src="../bookImg/<%= bImage[1] %>" /></h2></td></tr>
		<tr><td><h2>그림1 : <img class="imgBook" src="../bookImg/<%= bImage[0] %>" /></h2></td></tr>
		<tr><td><h3><pre>책 소개 : <%= bcontent %></pre></h3></td></tr>
		<tr><td><h2>할인율 : <%= bdiscount %> %</h2></td></tr>
		<tr><td></td></tr>
	</table>
</div>
<% } %>	
<div class="center">
	<a class="btn" href="bookList.jsp">책 리스트</a>
	<a class="btn" href="bookListPaging.jsp">책 리스트(paging)</a>
	<a class="btn" href="bookRegister.jsp">책 등록 페이지</a>
</div>
</body>
</html>