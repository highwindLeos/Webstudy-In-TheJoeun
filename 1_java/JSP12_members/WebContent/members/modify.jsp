
<%@page import="com.tj.members.MembersDao"%>
<%@page import="com.tj.members.MembersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>join</title>
	<link href="../css/register.css" rel="stylesheet"/>
	<script src="../js/modify.js"></script>
</head>
<body>
<%
	if (session.getAttribute("validMember") == null){ // 로그인 된 사용자만 페이지를 로드
		response.sendRedirect("login.jsp");
	}

	String id = (String)session.getAttribute("id");
	
	MembersDao dao = MembersDao.getInstance();
	MembersDto dto = dao.getMember(id);
	
%>
<div id="wrap">
	<form action="modifyOk.jsp" method="POST" name="modify_frm">
		<table>
			<tr>
				<td colspan="2">회원 정보 수정</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" readonly="readonly" value="<%= dto.getId() %>" ></td>
			</tr>
			<tr>
				<td>현재 패스워드</td>
				<td><input type="password" name="nowPw" value="<%= dto.getPw() %>" ></td>
			</tr>
			<tr>
				<td>새 패스워드</td>
				<td><input type="password" name="pw" ></td>
			</tr>
			<tr>
				<td>새 패스워드확인</td>
				<td><input type="password" name="pwChk" ></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="<%= dto.getName() %>"></td>
			</tr>
			<tr>
				<td>메일</td>
				<td><input type="email" name="email" value="<%= dto.getEmail() %>" ></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="bbirth" value="<%= dto.getBirth().toString().substring(0, 10) %>"></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="address" required="required" value="<%= dto.getAddress() %>"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="회원정보수정" onclick="updateInfoConfirm()" />
					<input type="reset" value="취소" />
					<input type="button" value="뒤로가기" onclick="history.back()" />
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>