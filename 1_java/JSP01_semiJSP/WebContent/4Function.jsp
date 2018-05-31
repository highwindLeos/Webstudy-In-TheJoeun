<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>
	<p>2의 3승은? <%= pow(3, 3) %>입니다.</p>

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