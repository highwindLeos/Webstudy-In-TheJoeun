<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
<style>
	#content {
		width: 1000px; height:350px;
		margin: 75px auto;
	}
</style>
<script>
	function bookInfo(){
		var bprice = frm.bprice.value;
		if (isNaN(bprice) || Number(bprice)<0 || Number(bprice)>9999999){
			alert('가격은 0~9999999원까지의 정수만 입력 가능');
			frm.bprice.value == '';
			return false;
		}
		var bdiscount = frm.bdiscount.value;
		if (isNaN(bdiscount) || Number(bdiscount)<0 || Number(bdiscount)>100){
			alert('할인율은 0~100%까지의 수만 입력 가능');
			frm.bdiscount.value == '';
			return false;
		}
	}
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"/>
	<div id="content">
	<form action="bookRegisterPro.jsp" method="post"
		enctype="multipart/form-data" name="frm" onsubmit="return bookInfo()">
		<table style="width:50%;">
			<caption>책등록</caption>
			<tr><th>책이름</th>
				<td><input type="text" name="btitle" required="required"
					autofocus="autofocus" size="30"
					maxlength="100">
				</td>
			</tr>
			<tr><th>가격</th>
				<td><input type="text" name="bprice" required="required" size="30">
				</td>
			</tr>
			<tr><th>책이미지1</th>
				<td><input type="file" name="bimage1">
				</td>
			</tr>
			<tr><th>책이미지2</th>
				<td><input type="file" name="bimage2">
				</td>
			</tr>
			<tr><th>책소개</th>
				<td><textarea rows="5" cols="32"
					required="required" name="bcontent"
				></textarea>
				</td>
			</tr>
			<tr><th>할인율</th>
				<td><input type="text" name="bdiscount" required="required"
						value="0"  size="30">
				</td>
			</tr>
			<tr><td colspan="2">
					<input type="submit" value="책등록">
					<input type="reset"  value="다시작성">
					<input type="button" value="책목록보기"
						onclick="location.href='bookList.jsp'">
		</table>
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"/>
</body>
</html>