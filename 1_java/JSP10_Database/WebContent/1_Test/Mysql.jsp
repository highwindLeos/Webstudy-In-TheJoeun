<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>MySQL</title>
</head>
<%!
	Connection conn;
	Statement stmt;
	ResultSet rs;
%>
<%
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/leosdatabase";
	
	String uid = "root";
	String upw = "stonker26";
	
	String sql = "SELECT * FROM LEOSDATABASE.PERSONAL";

	try {
		
		Class.forName(driver);
		conn = DriverManager.getConnection(url, uid, upw);
		
		out.println("mysql접속 성공");
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()){
		
			int pno = rs.getInt("pno");
			String pname = rs.getString("pname");
			String job = rs.getString("job");
			int pay = rs.getInt("pay");
			int dno = rs.getInt("dno");

			out.println("<h4> [사번] : "+ pno + " [사원명] : "+ pname + " [직책] : "+ job + " [급여] : "+ pay + " [부서번호] : " + dno +"</h4>" );

		}
		
	} catch (Exception e) {
		out.println("예외 메세지" + e.getMessage());
	} finally {
		if (rs != null){ rs.close();}
		if (stmt != null){ stmt.close();}
		if (conn != null){ conn.close();}
	}
	
%>
<body>
	
</body>
</html>