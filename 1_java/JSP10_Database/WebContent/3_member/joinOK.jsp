<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JoinOK</title>
	<style>
	
	</style>
</head>
<body>
<%
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	String uid = "leos";
	String upw = "Stonker26";
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	
	String name, id, pw, phone1, phone2, phone3, gender;
	request.setCharacterEncoding("utf-8"); // post 방식으로 한글 넘어올경우
	
	name = request.getParameter("name");
	id = request.getParameter("id");
	pw = request.getParameter("pw");
	phone1 = request.getParameter("phone1");
	phone2 = request.getParameter("phone2");
	phone3 = request.getParameter("phone3");
	gender = request.getParameter("gender");
	
	/* String InsertSql = String.format("INSERT INTO MEMBER VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s')", 
									id, pw, name, phone1, phone2, phone3, gender);  */
									
	String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, ?)";
									
	try {
		
		Class.forName(driver);
		conn = DriverManager.getConnection(url, uid, upw);
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, name);
		pstmt.setString(4, phone1);
		pstmt.setString(5, phone2);
		pstmt.setString(6, phone3);
		pstmt.setString(7, gender);
		
		int result = pstmt.executeUpdate(); // update insert delete 문 전송시 사용하는 메소드
		
		if (result > 0) {
			System.out.println("회원가입 성공");
			response.sendRedirect("joinResult.jsp?result=ok");
		} else {
			System.out.println("회원가입 실패");
			response.sendRedirect("joinResult.jsp?result=no");
		}
	
	} catch (Exception e) {
		System.out.println("회원가입 실패했음. 예외 메세지" + e.getMessage());
		e.printStackTrace();
		response.sendRedirect("joinResult.jsp?result=no");
	} finally {
		if(pstmt != null) pstmt.close();		
		if(conn != null) conn.close();		
	}
	
%>
</body>
</html>