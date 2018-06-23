<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#content {
		width: 800px; height:450px;
		margin: 50px auto 0px;
	}
	#content h2 {text-align: center; color: #003300;}
</style>
<script>
	setInterval(function(){location.href='../main/main.jsp';}, 3000); 
</script>
</head>
<body>
	<%session.invalidate();%>
	<jsp:include page="../main/header.jsp" />
	<div id="content">
		<h2>로그아웃되었습니다. 3초후 메인페이지로 이동합니다</h2>
	</div>
	<jsp:include page="../main/footer.jsp" />
</body>
</html>