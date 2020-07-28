<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>회원 탈퇴</title>
		<style>
			#member {
				height: 350px;
				width : 500px;
				padding: 100px 0;
				margin : 20px auto;
				border: 1px solid #666;
				border-radius : 20px;
				background-color: rgba(140,140,140, .4);
			}
			
			#logoForm{
				width: 300px;
				height: 100px;
			}
		
			input[type="password"] {
				width : 70%;
				height : 30px;
				border : 2px solid #037aab;
				font-weight : bold;
				background-color : rgba(255, 255, 255, 0.6);
				text-align: center;
			}
		</style>
	</head>
<body>
<jsp:include page="../main/head.jsp"/>
<div id="member" class="center">
	<div>
	<form action="${conPath }/delete.do" method="POST">
		<p><img id="logoForm" src="${conPath }/img/logo.png" alt="logo" /></p>
		<br />
		<h1 class="colorRed"><i class="fas fa-times-circle fa-3x"></i></h1>
		<br />
		<h3>삭제할 회원의 비번을 입력해주세요.</h3>
		<hr />
		<input type="hidden" name="mId" value="${sessionMdto.mId }" />
		<br />
		<p><input type="password" name="mPw" required="required" /></p>
		<br />
		<p><input type="submit" value="회원탈퇴" /></p>
	</form>
	</div>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>