<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="../css/style.css" rel="stylesheet">
<style>
	#content {
		width: 800px; height:350px;
		margin: 80px auto;
	}
	#content form { padding:100px;}
</style>
</head>
<body>
<jsp:include page="../main/header.jsp"/>
<div id="content">
<%String pageNum = request.getParameter("pageNum");
	String fnum = request.getParameter("fnum");
%>
	<table>
		<caption>글삭제</caption>
		<tr><td>
			<fieldset>
				<legend>암호가 맞아야 삭제 가능</legend>
				<form action="fboardDeletePro.jsp" method="post">
					<input type="hidden" name="pageNum"
							value="<%=pageNum%>">
					<input type="hidden" name="fnum" 
							value="<%=fnum %>">
					<p>암호 <input type="password" name="fpw">
					<input type="submit" value="글삭제">
					<input type="reset" value="삭제취소"
						onclick="history.back()"></p>
				</form>
			</fieldset>
		</td></tr>
	</table>
</div>
<jsp:include page="../main/footer.jsp"/>
</body>
</html>