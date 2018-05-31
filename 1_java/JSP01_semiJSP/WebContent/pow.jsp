<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<style>
	span {
		color : lightblue;
	}
</style>
<body>
<% 
	int pow = Integer.parseInt(request.getParameter("pow")); 
	int e = Integer.parseInt(request.getParameter("e"));
%>
	<h2><%= pow %>의 <%= e %> 승은 <span><%= pow(pow, e) %></span>입니다.</h2>
	<a href="powIn.jsp">뒤로가기</a>
	<%! // 선언부는 실행하기전 컴파일을 먼저한다
		private long pow(int a, int b){
			long temp = 1;
			for (int i = 1; i < b; i++){
				temp *= a;
			}
			return temp;
		}
	%>
<%-- JSP 주석 --%>
</body>
</html>