<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.File"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Application</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
	<% // JSP04_JSP
		String appPath = application.getContextPath(); // ContextPath 경로를 얻어온다. = JSP04_JSP
		String conPath = request.getContextPath(); // ContextPath 경로를 얻어온다. = JSP04_JSP
		
		String absolatePath = application.getRealPath("."); // 절대경로를 얻어온다.
	%>
	<h1>컨텐스트 상대 경로 : <%= appPath %></h1>
	<h1>컨텐스트 상대 경로 : <%= conPath %></h1>
	<h1>컨텐스트 절대 경로 : <%= absolatePath %></h1>
	<hr />
<%	// "infoText/input.txt"
	String filePath = application.getRealPath("infoText/input.txt");
	out.println("읽어올 파일의 절대 경로 : " + filePath + "<br>");
	
	BufferedReader reader = null;
	/* try{ */
		reader = new BufferedReader(new FileReader(filePath)); // 파일을 읽어올 스트림생성
		while (true){
			String temp = reader.readLine(); // 한줄씩 읽어온다.
			if(temp == null) { // 파일의 끝이면 break
				break;
			}
			out.println(temp + "<br>");
		}
	/* } catch(Exception e){
		out.println(filePath + "해당 파일이 없습니다." + e.getMessage());
		System.out.println(filePath + "해당 파일이 없습니다." + e.getMessage());
	} finally {
		if(reader != null) { reader.close();}
	} */
%>
	<h2></h2>	
</body>
</html>