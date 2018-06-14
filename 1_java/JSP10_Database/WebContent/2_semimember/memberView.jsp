<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";

	String uid = "leos";
	String upw = "Stonker26";

	Connection conn;
	Statement stmt;
	ResultSet rs;

	String sql = "SELECT ID, PW, NAME, NVL(PHONE, '연락처 없음') PHONE FROM MEMBER";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Member view</title>
	<style>
		table {
			background-color: #bbb;
		}
		
		td {
			background-color: #fff;
			padding: 8px;
		}
	</style>
</head>
<body>
	<%
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			out.println("<table>");
			out.println("<tr><th>ID</th><th>PW</th><th>이름</th><th>연락처</th></tr>");

			if (rs.next()) { // 멤버 테이블에 데이터가 하나 이상 있는 경우

				do {
					String id = rs.getString("id");
					String pw = rs.getString("pw");
					String name = rs.getString("name");
					String phone = rs.getString("phone");

					out.println("<tr><td>" + id + "</td><td>" + pw + "</td><td>" + name + "</td><td>" + phone + "</td></tr>");
				} while (rs.next());

			} else { // 멤버 테이블에 데이터가 하나도 없는 경우
				out.println("<tr><td colspan='4'>가입한 회원이 없어요.<td></tr>");
			}

			out.println("</table>");

		} catch (Exception e) {
			out.println("예외 메세지 : " + e.getMessage());
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	%>

</body>
</html>