<%@page import="com.tj.ex.PersonInfo"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="pi" class="com.tj.ex.PersonInfo" scope="page" />
<%-- id : 객체이름 class : 풀패키지 포함 scope : 객체가 사용되는 범위 --%>
<%-- 
빈객체의 범위 : page = 생성한 페이지에서만 사용가능.
			request = 객체의 주기와 같다.(새로운 요청이 들어오기 전까지 사용가능)
			session = 세션의 주기와 같다. (브라우저의 닫힐때까지.)
			application : 웹 어플리케이션이 생명주기와 동일
 --%>
<jsp:setProperty name="pi" property="name" value="이데이" />
<jsp:setProperty name="pi" property="age" value="22" />
<jsp:setProperty name="pi" property="gender" value="남자" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Step2</title>
</head>
<body>
	<h2>개인정보</h2>
	<p>이름 : <jsp:getProperty name="pi" property="name" /></p>
	<p>나이 : <jsp:getProperty name="pi" property="age" /></p>
	<p>성별 : <jsp:getProperty name="pi" property="gender" /></p>
</body>
</html>