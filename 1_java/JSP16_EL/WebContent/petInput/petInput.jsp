<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>petInput</title>
	<link rel="stylesheet" href="">
	<script>
		
	</script>
</head>
<body>
	<form action="petsView.jsp">
		<p>ID : <input type="text" name="id" /></p>
		<p>다음 중 회원님이 키우고 있는 애완동물을 선택하세요</p>
		<p>
			<input type="checkbox" name="pets" value="개" />개
			<input type="checkbox" name="pets" value="고양이" />고양이
			<input type="checkbox" name="pets" value="금붕어" />금붕어
		</p>
		<p><input type="submit" value="확인" /></p>
	</form>
</body>
</html>