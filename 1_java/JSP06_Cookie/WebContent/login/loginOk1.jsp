<%@page import="java.net.URLEncoder"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Ok1</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
<%! String id, pw, msg; %>
<%
	request.setCharacterEncoding("utf-8"); // post 한글처리

	id = request.getParameter("id").trim();
	pw = request.getParameter("pw").trim();
	
	if ("aaa".equals(id)) { // 아이디를 맞게 입력한 경우
		if ("111".equals(pw)) { // 패스워드를 맞게 입력한경우.
			// 로그인 성공인 경우
			String encodingId = URLEncoder.encode(id, "utf-8");
			Cookie cookie = new Cookie("id", encodingId);
			cookie.setMaxAge(-1); // 쿠키는 브라우저가 꺼질때 까지만 유효.
			
			response.addCookie(cookie);
			response.sendRedirect("welcome.jsp");
		} else { // 패스워드를 틀린경우
			id = URLEncoder.encode(id, "utf-8");
			msg = URLEncoder.encode("패스워드를 확인 해주세요.", "utf-8");
			response.sendRedirect("login.jsp?id="+ id +"&msg=" + msg);
		}
	} else { // 아이디를 틀린경우.
		msg = URLEncoder.encode("아이디를 확인 해주세요.", "utf-8");
		response.sendRedirect("login.jsp?msg=" + msg);
	}
%>
</body>
</html>