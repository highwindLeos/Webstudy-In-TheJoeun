<%@page import="java.util.Arrays"%>
<%@page import="java.util.Enumeration"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Title</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<% // request 객체의 header 정보와 parameter 정보들을 출력
	request.setCharacterEncoding("utf-8"); // POST 방식의 한글 깨짐을 변환
	// header 정보들
	Enumeration<String> headerNames = request.getHeaderNames();
	
	while (headerNames.hasMoreElements()){
		
		String headerName = headerNames.nextElement();
		String headerValue = request.getHeader(headerName);
		out.println("<h4>" + headerName  + " : " + headerValue + "</h4>");
		
	}
	out.println("<hr>");
	
	//parameter 정보들
	Enumeration<String> paramNames = request.getParameterNames();
	
	while (paramNames.hasMoreElements()){
		
		String paramName = paramNames.nextElement();
		String paramValue;
		
		if(!paramName.equals("hobby") && !paramName.equals("mailring")){
			paramValue = request.getParameter(paramName);
			out.println("<h4>" + paramName + " : " + paramValue + "</h4>");
		} else {
			String[] paramValueArr = request.getParameterValues(paramName);
			out.println("<h4>" + paramName + " : " + Arrays.toString(paramValueArr) + "</h4>");
		}
	}
%>

<body>
</body>
</html>