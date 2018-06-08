<%@page import="java.util.Enumeration"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Session GET</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
	<h1>세션의 값을 출력해봅니다.</h1>
<%
	Object sessionNameObj = session.getAttribute("sessionName");
	String sessionName = (String)sessionNameObj;
	
	int myNum1 = (int)session.getAttribute("myNum");
	Integer myNum2 = (Integer)session.getAttribute("myNum");
	
	Enumeration<String> sessionNames = session.getAttributeNames();
	
	while (sessionNames.hasMoreElements()) {
		String sName = sessionNames.nextElement();
		String sValue = session.getAttribute(sName).toString();
		
		out.println(sName + " : " + sValue + "<br>");
	}

%>
	<hr />
<% // 세션의 아이디, 유효시간
	String sessionId = session.getId();
	int intervalTime = session.getMaxInactiveInterval();
	out.println("세션 ID : " + sessionId +"<br>");
	out.println("세션 유효시간 (Tomcat web.xml) : " + intervalTime +"초<br>");
	out.println("<hr>");
	// 세션의 삭제 (세션 특정 데이터를 삭제, 세션데이터 모두 삭제)
	session.removeAttribute("sessionName"); // 해당 이름의 세션의 데이터 삭제.
	out.print("세션의 데이터 삭제 후 세션들 출력 : ");
	
	sessionNames = session.getAttributeNames();
	
	while (sessionNames.hasMoreElements()) {
		String sName = sessionNames.nextElement();
		String sValue = session.getAttribute(sName).toString();
		
		out.println(sName + " : " + sValue + "<br>");
	}
	
	session.invalidate(); // 세션의 모든 데이터를 삭제한다.
	out.println("<hr>");
	if (request.isRequestedSessionIdValid()) { // 세션에 유효한 데이터가 있는지 확인
		out.println("세션에 유효한 데이터가 있습니다.");
	} else {
		out.println("세션에 유효한 데이터가 없습니다.");
	}
%>
	<hr />
	<h2>세션 값 확인 1 : <%= sessionName %></h2>
	<h2>세션 값 확인 2 int : <%= myNum1 + 9 %></h2>
	<h2>세션 값 확인 3 (Integer) : <%= myNum2 %></h2>
</body>
</html>