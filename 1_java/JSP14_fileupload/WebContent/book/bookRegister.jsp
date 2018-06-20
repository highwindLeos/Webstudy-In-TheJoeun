
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Book Form</title>
	<link rel="stylesheet" href="../css/board.css">
	<script>
		
	</script>
</head>
<body>
<div id="wrap">
	<form action="bookRegisterProcess.jsp" method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2">책 등록</td>
			</tr>
			<tr>
				<td>책 이름</td>
				<td><input type="text" name="bname" required="required" autofocus="autofocus" /></td>
			</tr>
			<tr>
				<td>책 가격</td>
				<td><input type="number" name="bprice" required="required" /></td>
			</tr>
			<tr>
				<td>책 이미지 - 1</td>
				<td><input type="file" name="bimage1" /></td>
			</tr>
			<tr>
				<td>책 이미지 - 2</td>
				<td><input type="file" name="bimage2" /></td>
			</tr>
			<tr>
				<td>책 소개</td>
				<td><textarea name="bcontent" id="" cols="32" rows="5" required="required" ></textarea></td>
			</tr>
			<tr>
				<td>할인율</td>
				<td><input type="number" name="bdiscount" required="required" value="0" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="책등록" />
					<input type="reset" value="재설정" />
				</td>
			</tr>
			<tr>
				<td colspan="2">publising by Leeday</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>