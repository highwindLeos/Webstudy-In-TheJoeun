<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Custom Tag</title>
	<link rel="stylesheet" href="">
</head>
<body>
	<custom:line ch="*" size="50" color="blue" />
 	<custom:now />
	<custom:line ch="*" size="50" color="blue" />
</body>
</html>