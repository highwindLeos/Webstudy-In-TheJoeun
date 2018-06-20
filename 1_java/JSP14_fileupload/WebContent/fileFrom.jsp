<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>File</title>
	<link rel="stylesheet" href="css/board.css">
	<script>
		
	</script>
</head>
<body>
<div id="wrap">
	<form action="fileUploadProcess.jsp" method="POST" enctype="multipart/form-data" >
		<table>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name="fileparam" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="파일업로드" /></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>