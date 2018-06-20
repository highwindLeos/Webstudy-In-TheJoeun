<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>file3Form</title>
	<link rel="stylesheet" href="css/board.css">
	<script>
		
	</script>
</head>
<body>
<div id="wrap">
	<form action="file3Process.jsp" method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" required="required" /></td>
			</tr>
			<tr>
				<td>File1</td>
				<td><input type="file" name="file1" /></td>
			</tr>
			<tr>
				<td>File2</td>
				<td><input type="file" name="file2" /></td>
			</tr>
			<tr>
				<td>File3</td>
				<td><input type="file" name="file3" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="파일 업로드" /></td>
			</tr>
			<tr>
				<td colspan="2">Publising by Leo</td>
			</tr>
		</table>
	</form>
</div>
	
</body>
</html>