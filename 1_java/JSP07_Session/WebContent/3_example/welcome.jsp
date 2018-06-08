<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="com.sun.org.apache.xalan.internal.xsltc.trax.OutputSettings"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.PrintWriter"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String agree =request.getParameter("agree");
	
	System.out.println(agree);
	String result = null;

	if ("동의".equals(agree) && session.getAttribute("id") != null){
		
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		String name = (String)session.getAttribute("name");
	
		PrintWriter writer = null;
		InputStream is = null;
		OutputStream os = null;
		
		try{
			String file = application.getRealPath("/WEB-INF/" + id + ".txt");
			
			System.out.println(file);
			writer = new PrintWriter(file);
			
			writer.println("DB 대신 파일에 넣었습니다.");
			writer.println("아이디 : " + id);
			writer.println("패스워드 : " + pw);
			writer.println("이 름 : " + name);
			writer.close();
			// 톰캣의 실팽 폴더의 WEB-INF 밑에 text 파일을 생성 -> 파일 복사
			String copyFile = "C:/Users/Leodays/Desktop/Dev/webstudy/1_java/JSP07_Session/WebContent/WEB-INF/" + id +".txt";
			
			File tomcatFile = new File(file);
			is = new FileInputStream(file);
			os = new FileOutputStream(copyFile);
			
			byte[] bs = new byte[(int)tomcatFile.length()];
			
			while (true) {
				int count = is.read(bs);
				if (count == -1){
					break;
				}
				os.write(bs, 0, count);
			}
		
			result = "success";
		
		} catch (Exception e) {
			result = "fail";
		} finally {
			if (os != null){ os.close(); }
			if (is != null){ is.close(); }
			if (writer != null){ writer.close(); }
		}
		
	} else {
		result = "fail";		
	}
	
/* 	session.removeAttribute("id");
	session.removeAttribute("pw");
	session.removeAttribute("name"); */
/* 	session.invalidate(); */
	response.sendRedirect("result.jsp?result=" + result);

%>
</body>
</html>