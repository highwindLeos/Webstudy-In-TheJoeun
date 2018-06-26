<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>numberFormating</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
	<p>
		첫번째 숫자는 세자리마다.
		두번째 숫자는 소숫점 2자리 (소수점 1자리까지 있으면 한자리만)
		세번째 숫자는 소숫점 2자리 (소수점 2자리까지 있으면 꼭 출력)
	</p>
<c:set var="num1" value="1234567" />
<fmt:formatNumber value="${num1 }" groupingUsed="true" />
<hr />
<c:set var="num2" value="1234.5" />
<fmt:formatNumber value="${num2 }" pattern="#,###.##" />
<hr />
<c:set var="num3" value="${num2 }" />
<fmt:formatNumber value="${num2 }" pattern="#,###.00" />
</body>
</html>