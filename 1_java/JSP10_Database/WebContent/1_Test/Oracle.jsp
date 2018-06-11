<%@page import="java.util.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Oracle</title>
	<style>
		table {
			background-color: lightblue;
		}
		
		td {
			background-color: #fff;
			padding : 10px;
		}
	</style>
	<script>
	
	</script>
</head>
<body>
	 <table>
<%
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	String uid = "leos";
	String upw = "Stonker26";
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String sql = "SELECT * FROM EMP";
	
	try{
		
		Class.forName(driver);
		conn = DriverManager.getConnection(url, uid, upw);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()){
			
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			Date hiredate = rs.getDate("hiredate");
			int sal = rs.getInt("sal");
			int deptno = rs.getInt("deptno");
%>
	 	<tr>
	 		<td>
	 			<h4>[사번] : <%= empno %></h4>
	 		</td>
	 		<td>
	 			<h4>[사원이름] : <%= ename %></h4>
	 		</td>
	 		<td>
	 			<h4>[직책] : <%= job %></h4>
	 		</td>
	 		<td>
	 			<h4>[입사일] : <%= hiredate %></h4>
	 		</td>
	 		<td>
	 			<h4>[급여] : <%= sal %></h4>
	 		</td>
	 		<td>
	 			<h4>[부서번호] : <%= deptno %></h4>
	 		</td>
	 	</tr>
<%
		}
		
	} catch (Exception e){
		out.println("예외 메세지 : " + e.getMessage());
	} finally {
		if(rs != null) { rs.close(); }
		if(stmt != null) { stmt.close(); }
		if(conn != null) { conn.close(); }
	}
	
%>
</table>
</body>
</html>