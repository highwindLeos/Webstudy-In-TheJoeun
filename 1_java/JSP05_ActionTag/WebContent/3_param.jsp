<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Param Tag</title>
	<style>
	
	</style>
	<script>
	
	</script>
</head>
<body>
	<h1>3_param.jsp 영역입니다.</h1>
	<hr />
	<jsp:forward page="3_param2.jsp">
		<jsp:param name="id" value="leos" />
		<jsp:param name="pw" value="stdio" /> 
	</jsp:forward><%-- 포워딩 될 때 파라메터를 같이 넘긴다. --%>
	<hr />
	<h1>여기는 3_param.jsp 영역입니다.</h1>
</body>
</html>