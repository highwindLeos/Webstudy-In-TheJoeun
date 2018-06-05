<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %><!-- @ : 지시자 @page @include @taglib  -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Title</title>
	<style>
	
	</style>
	<script>
		function chk() {
			var num = frm.num.value.trim(); // 좌우 스페이스 없애기
			if (!num){
				alert('필드를 반드시 입력해주세요.');
				frm.num.focus();
				return false;
			}
			
			if (num == '' || isNaN(num) || Number(num) < 0 || num.indexOf('.') != -1){
				alert('자연수를 입력해주세요.');
				frm.num.focus();
				return false;
			}
			return true;
		}
	</script>
</head>
<%! int num, sum; %>
<% 
	num = 0; sum =0;
	String strNum = request.getParameter("num");
	
	if (strNum != null){
		num = Integer.parseInt(strNum.trim());
	} else {
		// strNUM 이 null 인 경우는 "num" 파라미터가 들어오지 않은 경우
	}

	for (int i = 0; i <= num; i++){
		sum += i;
	} //누적합하기
	
%>
<body>

	<form action="" method="GET" id="frm">
		<fieldset>
		<legend>누적하기</legend>
			<p>숫자 : <input type="text" id="num" name="num" autofocus="autofocus" value="<% if (strNum != null) out.print(strNum); %>" />
					  <input type="submit" value="누적하기" onclick="return chk()" /></p>
		</fieldset>
	</form>
	<% if(strNum != null) { %>
		<h2>1부터 <%= num %> 까지의 누적 합 : <%= sum %></h2>
	<% } %>
</body>
</html>