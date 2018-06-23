<%@page import="com.tj.ex.dao.BookDao, com.tj.ex.dto.BookDto"%>
<%@page import="java.io.*, java.util.Enumeration"%>
<%@page import=""%>
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
<%	String path = request.getRealPath("bookImg");
	int maxSize = 1024*1024; //1M
	String[] filename = {"",""};
	MultipartRequest multipartRequest = null;
	try{
		multipartRequest 
		 = new MultipartRequest(request, path, maxSize, "utf-8",
				 new DefaultFileRenamePolicy());
		Enumeration files = multipartRequest.getFileNames();
		int idx = 0;
		while(files.hasMoreElements()){
			String paramStr = (String)files.nextElement();
			filename[idx] 
				= multipartRequest.getFilesystemName(paramStr);
			idx++;
		}
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	for(String f : filename){
		InputStream is = null;
		OutputStream os = null;
		try{
			File serverfile = new File(path+"/"+f);
			if(serverfile.exists()){ // 서버에 올린 파일이 있을 경우 카피
				is = new FileInputStream(serverfile);
				os = new FileOutputStream("D:/mega-IT/source/5_JSP/model1ex/WebContent/bookImg/"+f);
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
	}
	// DB에 입력할 내용을 dto에 넣고 dao한테 insert 시킴
	
	String btitle = multipartRequest.getParameter("btitle");
	int bprice = 
		Integer.parseInt(multipartRequest.getParameter("bprice"));
	if(filename[0]==null)
		filename[0] = "nothing.jpg";
	if(filename[1]==null)
		filename[1] = "nothing.jpg";
	String bimage1=filename[1]; // bookRegisterOk.jsp에서 수정
	String bimage2=filename[0]; //
	String bcontent = multipartRequest.getParameter("bcontent");
	int bdiscount =
	Integer.parseInt(multipartRequest.getParameter("bdiscount"));
	BookDto book = new BookDto(0, btitle, bprice, bimage1,
			bimage2, bcontent, bdiscount);
	BookDao bDao = BookDao.getInstance();
	int result = bDao.insertBook(book); // DB에 책 등록
	if(result == BookDao.SUCCESS){ // 책등록 성공
%>		<script>
			alert('책등록 성공');
			location.href = 'bookList.jsp';
		</script>
<%	}else{ //책등록실패 %>
		<script>
			alert('책등록 실패');
			history.go(-1);
		</script>
<%	} %>
</body>
</html>