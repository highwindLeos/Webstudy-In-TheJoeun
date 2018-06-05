<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Register</title>
	<link rel="stylesheet" href="css/join.css" />
	<script src="js/validateJoin.js"></script>
</head>
<%
	request.setCharacterEncoding("utf-8");

	request.
%>
<body>
	<form action="" method="POST" id="frm">
		<table>
				<tr><td colspan="2">회원가입</td></tr>
				<tr>
					<td><label for="name">이 름</label></td>
					<td><input type="text" name="name" id="name" required="required" placeholder="이름을 입력해주세요" autofocus="autofocus"/></td>
				</tr>
				<tr>
					<td><label for="id">아이디</label></td>
					<td><input type="text" name="id" id="id" required="required" placeholder="아이디를 입력해주세요"/></td>
				</tr>
				<tr>
					<td><label for="password">비밀번호</label></td>
					<td><input type="password" name="password" id="password" required="required" placeholder="비밀번호를 입력해주세요"/></td>
				</tr>
				<tr>
					<td><label for="password2">비밀번호 확인</label></td>
					<td><input type="password" name="password2" id="password2" required="required" placeholder="비밀번호를 다시 입력해주세요"/></td>
				</tr>
				<tr>
					<td><label for="birth">생년월일</label></td>
					<td><input type="date" name="birth" id="birth" required="required" /></td>
				</tr>
				<tr>
					<td><label for="hobby">취 미</label></td>
					<td>
						<input type="checkbox" id="book" name="hobby" value="독서" /><label for="book">독서</label>
						<input type="checkbox" id="cook" name="hobby" value="요리" /><label for="cook">요리</label>
						<input type="checkbox" id="sport" name="hobby" value="운동" /><label for="sport">운동</label>
						<input type="checkbox" id="sleep" name="hobby" value="취침" /><label for="sleep">취침</label>
					</td>
				</tr>
				<tr>
					<td><label for="gender">성 별</label></td>
					<td>
						<input type="radio" id="male" name="gender" value="남자" checked="checked"/><label for="male">남자</label>
						<input type="radio" id="female" name="gender" value="여자" /><label for="female">여자</label>
					</td>
				</tr>
				<tr>
					<td><label for="email">이메일</label></td>
					<td><input type="email" name="email" id="email" required="required" placeholder="이메일을 입력하세요."/></td>
				</tr>
				<tr>
					<td>메일수신</td>
					<td>
						<select name="mailring" multiple="multiple" size="3" >
						  <option value="광고">광 고</option>
						  <option value="배송">배 송</option>
						  <option value="공지" selected="selected">공 지</option>
						</select>
						<input type="hidden" name="hiddenParam" value="xx" />
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="글전송" onclick="return vlidateJoinInfo()" /><input type="reset" value="다시하기" /><input type="button" value="뒤로가기" onclick="history.back()" /></td>
				</tr>
		</table>
	</form>
</body>
</html>