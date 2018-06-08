<%@page import="java.net.URLEncoder"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>loginOK</title>
</head>
<body>
<%! String id, pw, msg; %>
<%
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	
	if("aaa".equals(id)){ // 아이디 가 맞음
		if ("111".equals(pw)) { // 아이디가 맞고 pw 도 맞는 경우 로그인 성공
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);

			response.sendRedirect("welcome.jsp");
		} else { // 아이디는 맞으나 패스워드가 틀린경우
			msg = URLEncoder.encode("패스워드를 확인하세요.","utf-8");
			response.sendRedirect("login.jsp?msg=" + msg);
		}
	} else {// 아이디가 틀린경우
		msg = URLEncoder.encode("아이디를 확인하세요.","utf-8");
		response.sendRedirect("login.jsp?msg=" + msg);
	}
	
%>
<%-- <script>
	alert('<%= msg %>');
	location.href = 'login.html';
</script> --%>

</body>
</html>