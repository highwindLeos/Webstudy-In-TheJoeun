<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>join</title>
	<link rel="stylesheet" href="../css/register.css" />
	<script>
	
	</script>
</head>
<body>
	<form action="../joinOK" method="POST">
		<table>
			<tr><td colspan="2">회원가입</td></tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" required="required" /></td>
			</tr>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" required="required" /></td>
			</tr>
			<tr>
				<td>PassWord</td>
				<td><input type="password" name="pw" required="required" /></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td>
					<select name="phone1" size="1">
						<option></option>
						<option value="02">02</option>
						<option value="010">010</option>
					</select>
					-
					<input type="text" id="phone2" name="phone2" size="4" />
					-
					<input type="text" id="phone3" name="phone3" size="4" />
					
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<input type="radio" id="male" name="gender" value="남자" checked="checked" /><label for="male">남자</label>
					<input type="radio" id="female" name="gender" value="여자" /><label for="female">여자</label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입하기" />
					<input type="reset" value="취소하기" />
					<input type="button" value="로그인" onclick="location.href = 'login.jsp'" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>