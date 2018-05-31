<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>
	<%
		Date now1 = new Date();
		GregorianCalendar now2 = new GregorianCalendar();
		Calendar now3 = Calendar.getInstance();
		
		String strNow1 = String.format("%TY년 %Tm월 %Td일 %TH시 %TM분", now1, now1, now1, now1, now1);
		
		String strNow2 = String.format("%1$TY년 %1$Tm월 %1$Td일 %1$TH시 %1$TM분", now2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
		String strNow3 = sdf.format(now3.getTime());
	%>
	
	<h1>지금은 <%= strNow1 %> 입니다.</h1>
	<h1>지금은 <%= strNow2 %> 입니다.</h1>
	<h1>지금은 <%= strNow3 %> 입니다.</h1>
</body>
</html>