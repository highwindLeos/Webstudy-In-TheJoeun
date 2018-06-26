<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>initParam</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
<p>ContextId : <%= getServletContext().getInitParameter("contextId") %></p>
<p>ContextPw : <%= getServletContext().getInitParameter("contextPw") %></p>
<p>ContextPath : <%= getServletContext().getInitParameter("contextPath") %></p>
<hr />
<p>ContextId : ${ initParam.contextId }</p>
<p>ContextPw : ${ initParam.contextPw }</p>
<p>ContextPath : ${ initParam.contextPath }</p>
</body>
</html>