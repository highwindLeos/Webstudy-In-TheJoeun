<%@page import="com.tj.dto.CustomerDto"%>
<%@page import="com.tj.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="cdto" class="com.tj.dto.CustomerDto" scope="page" />
<jsp:setProperty property="*" name="cdto" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>modify Customer</title>
	<link rel="stylesheet" href="">
	<script src="../js/valiedForm.js"></script>
</head>
<%
	if (session.getAttribute("loginOk") == null) {
		response.sendRedirect("login.jsp");
	} // 로그인 한 사용자만 페이지를 보여줌

	String cid = (String)session.getAttribute("cid");
	
	CustomerDao dao = CustomerDao.getInstance();
	CustomerDto dto = dao.getCustomer(cid);
%>
<body>
<jsp:include page="../main/head.jsp" />
<div id="wrap">
<form id="mfrm" action="modifyProcess.jsp" method="POST">
	<table>
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td colspan="2"><h2>회원수정(Modify)</h2></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="cid" readonly="readonly" value="<%= cid %>" /></td>
		</tr>
		<tr>
			<td>현제 패스워드</td>
			<td><input type="password" name="nowCpw" required="required" value="<%= dto.getCpw() %>" /></td>
		</tr>
		<tr>
			<td>수정 패스워드</td>
			<td><input type="password" name="cpw" placeholder="수정 할 패스워드를  입력해주세요." /></td>
		</tr>
		<tr>
			<td>수정 패스워드 확인</td>
			<td><input type="password" name="cpwChk" placeholder="수정 할 패스워드를 재차 입력해주세요." /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="cname" required="required" value="<%= dto.getCname() %>" /></td>
		</tr>
		<tr>
			<td>연락처</td>
			<td><input type="text" name="ctel" required="required" value="<%= dto.getCtel() %>" /></td>
		</tr>
		<tr>
			<td>E-Mail</td>
			<td><input type="email" name="cemail" required="required" value="<%= dto.getCemail() %>" /></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<input type="radio" id="male" name="cgender" value="남자" checked="checked" /><label for="male">남자</label>
				<input type="radio" id="female" name="cgender" value="여자" /><label for="female">여자</label>
			</td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="caddr" required="required" value="<%= dto.getCaddr() %>" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정하기" onclick="return chkmodifyForm()" />
				<input type="button" value="뒤로가기" onclick="history.back()" />
			</td>
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>
	</table>
</form>
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>