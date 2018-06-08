<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>login</title>
	<link rel="stylesheet" href="css/login.css" />
	<script>
	
	</script>
</head>
<%
	request.setCharacterEncoding("utf-8");
	
	String id =	request.getParameter("id");
	String pw =	request.getParameter("pw");
	String name = request.getParameter("name");
	
	session.setAttribute("id", id);
	session.setAttribute("pw", pw);
	session.setAttribute("name", name);

%>
<body>
	<div id="wrap">
			<div><h3><%= name %> 님 약관에 동의하십니까?</h3></div>
			<hr />
			<div>
				<p>1.회원 정보는 웹사이트의 운영을 위해서만 사용됩니다.</p>
			</div>	
			<div>
				<p>2.웹사이트의 정상적인 운영을 방해하는 회원은 탈퇴 처리합니다.</p>
			</div>
			<hr />
			<form action="welcome.jsp" method="post">
				<input type="radio" id="agree" name="agree" value="동의" /><label for="agree">동의</label>
				<input type="radio" id="disagree" name="agree" value="거부" checked="checked" /><label for="disagree">거부</label>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" value="확인"/>
			</form>
	</div>
</body>
</html>