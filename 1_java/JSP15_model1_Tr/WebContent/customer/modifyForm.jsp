<%@page import="com.tj.ex.dto.CustomerDto"%>
<%@page import="com.tj.ex.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/modify.css" rel="stylesheet">
<script>
function updateInfoChk() {
	if(document.frm.hyun_pw.value.length==0){
		alert('현재 비밀번호를 입력하셔야 수정이 가능합니다');
		frm.hyun_pw.focus();
		return;
	}
	if(document.frm.cpw.value != document.frm.pw_check.value){
		alert('비번 체크하세요');
		frm.mpw.value='';
		frm.pw_check.value='';
		frm.pw.focus();
		return;
	}
	/* aa@a (O)  @aa(X)  aa@(X)  aaa(X)*/
	if(document.frm.cemail.value.indexOf('@')==-1 ||
		document.frm.cemail.value.indexOf('@')==0  ||
		document.frm.cemail.value.indexOf('@')==
			(document.frm.cemail.value.length-1)){
		alert('메일형식을 확인하세요');
		frm.cemail.focus();
		return;
	}
	document.frm.submit();
}
</script>
</head>
<body>
<jsp:include page="../main/header.jsp" />
<div id="joinForm_wrap">
<%	String cid = (String)session.getAttribute("cid");
	CustomerDao cDao = CustomerDao.getInstance();
	CustomerDto dto = cDao.getCustomer(cid);
%>
	<form action="../customer/modifyPro.jsp" method="post" name="frm">
	<div id="join_title">회원정보 수정</div>
		<table>
		<tr><th>아이디</th>
			<td><input type="text" name="cid" id="cid" value="<%=dto.getCid()%>" readonly="readonly"></td>
		</tr>
		<tr><th>현 비번</th>
			<td><input type="password" name="hyun_pw" id="hyun_pw"></td>
		</tr>
		<tr><th>새 비번</th>
			<td><input type="password" name="cpw" id="cpw"></td>
		</tr>
		<tr><th>새 비번확인</th>
			<td><input type="password" name="pw_check" id="pw_check"></td>
		</tr>
		<tr><th>이름</th>
			<td><input type="text" name="cname" id="cname" value="<%=dto.getCname()%>"></td>
		</tr>
		<tr><th>전화</th>
			<td><input type="text" name="ctel" id="ctel" value="<%
				if(dto.getCtel()!=null) out.print(dto.getCtel());%>"></td>
		</tr>
		<tr><th>메일주소</th>
			<td><input type="text" name="cemail" id="cemail" value="<%=dto.getCemail()%>"></td>
		</tr>
		<tr><th>성별</th>
			<td><%if("f".equals(dto.getCgender())){%>
					<input type="radio" name="cgender" value="m">남자 &nbsp;
					<input type="radio" name="cgender" value="f"
						checked="checked">여자
				<% }else if("m".equals(dto.getCgender())){%>
					<input type="radio" name="cgender" value="m" 
						checked="checked">남자 &nbsp;
					<input type="radio" name="cgender" value="f">여자
				<% }else{ %>
					<input type="radio" name="cgender" value="m">남자 &nbsp;
					<input type="radio" name="cgender" value="f">여자
			<% } %>
			</td>
		</tr>
		<tr><th>주소</th>
			<td><input type="text" name="caddr" id="caddr" value="<%
				if(dto.getCaddr()!=null) out.print(dto.getCaddr());%>"></td>
		</tr>
		<tr><td colspan="2">
				<input type="button" value="정보수정" 
						class="joinBtn_style" onclick="updateInfoChk()">
				<input type="reset" value="취소"
					class="joinBtn_style" onclick="history.back()"> 
	</table>
	</form>
	</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>