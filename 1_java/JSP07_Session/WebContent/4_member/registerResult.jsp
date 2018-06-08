<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Register Result</title>
	<link rel="stylesheet" href="./css/registerResult.css" />
	<script>
	
	</script>
</head>
<% 
	String utf8Encoding = "utf-8";
	request.setCharacterEncoding(utf8Encoding); // 한글을 인코딩
	
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String birthDay = request.getParameter("birth");
	String[] hobby = request.getParameterValues("hobby");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	String[] mailring = request.getParameterValues("mailring");
	
	String hiddenvalue =  request.getParameter("hiddenParam");
	
%>
<body>
	<div id="wrap">
		<table>
			<tr>
				<td colspan="2"><h3>회원 가입 정보</h3></td>
			</tr>
			<tr>
				<td><h4>이 름</h4></td>
				<td><h4><%= name %></h4></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><h4><%= id %></h4></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><h4><% 
					for(int i =0; i < password.length() ; i++) {
						out.println("*");
					} %></h4></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><h4><%= birthDay %></h4></td>
			</tr>
			<tr>
				<td>취 미</td>
				<td><h4><% 
				if(hobby != null){
					for (int i = 0; i < hobby.length; i++){
						if (i == hobby.length -1){
							out.print(hobby[i]);
						} else {
							out.print(hobby[i] + ", ");
						}
					}
				} %></h4></td>
				
			</tr>
			<tr>
				<td>성 별</td>
				<td><h4><%= gender %></h4></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><h4><%= email %></h4></td>
			</tr>
			<tr>
				<td>메일링수신여부</td>
				<td><h4>
				<%
					if (mailring == null){
						out.print("메일링 수신 모두 거부.");
					} else { // 메일링 수신 동의 있다면.
						for(int i = 0; i < mailring.length; i++){
							if (i == mailring.length -1){
								out.print( mailring[i] );
							} else {
								out.print(mailring[i] + ", ");
							}
						}
					}
				%>
				</h4></td>
			</tr>
			<tr>
				<td colspan="2"><h3>Register Result : <%= hiddenvalue %></h3></td>
			</tr>
			<tr>
				<td colspan="2"><button onclick="location.href ='register.jsp'">뒤로가기</button></td>
			</tr>
		</table>
	</div>
</body>
</html>