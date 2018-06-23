<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Book Register</title>
	<link rel="stylesheet" href="../css/board.css" />
	<style type="text/css">
        .img_wrap {
        	text-align:center;
            width: 300px;
        }
        .img_wrap img {
        	width : 300px;
        	min-width : 100px;
            max-width: 100%;
        }
 
    </style>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" ></script>
    <script type="text/javascript">
        
        var sel_file;
 
        $(document).ready(function() {
            $("#bimage1").on("change", handleImgFileSelect);
            $("#bimage2").on("change", handleImgFileSelect);
        }); 
 
        function handleImgFileSelect(e) {
            var files = e.target.files;
            var filesArr = Array.prototype.slice.call(files);
 
            filesArr.forEach(function(f) {
                if(!f.type.match("image.*")) {
                    alert("확장자는 이미지 확장자만 가능합니다.");
                    return;
                }
 
                sel_file = f;
 
                var reader = new FileReader();
                reader.onload = function(e) {
                    $("#img").attr("src", e.target.result);
                }
                reader.readAsDataURL(f);
            });
        }
 
    </script>
</head>
<body>
<jsp:include page="../main/head.jsp" />
<div id="wrap">
	<form action="bookRegisterProcess.jsp" method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td colspan="2"><h2>책 등록</h2></td>
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
	        	<td colspan="2" class="img_wrap">
	            	<img id="img" />
	        	</td>
    		</tr>
			<tr>
				<td>책 이미지 - 1</td>
				<td><input type="file" id="bimage1" name="bimage1" /></td>
			</tr>
			<tr>
				<td>책 이미지 - 2</td>
				<td><input type="file" id="bimage2" name="bimage2" /></td>
			</tr>
			<tr>
				<td>책 소개</td>
				<td><textarea name="bcontent" id="" cols="32" rows="5" required="required" ></textarea></td>
			</tr>
			<tr>
				<td>할인율</td>
				<td><input type="number" min="0" max="100" name="bdiscount" required="required" value="0" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="책등록" />
					<input type="reset" value="재설정" />
					<input type="button" value="책목록보기" onclick="location.href = 'bookList.jsp'" />
				</td>
			</tr>
			<tr>
				<td colspan="2"></td>
			</tr>
		</table>
	</form>
</div>
<jsp:include page="../main/footer.jsp" />
</body>
</html>