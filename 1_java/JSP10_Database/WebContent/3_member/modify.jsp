<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modify</title>
	<link rel="stylesheet" href="../css/register.css" />
	<script>
	
	</script>
</head>
<%! String pw, name, phone1, phone2, phone3, gender; %>
<%
	if (session.getAttribute("id") == null){
		response.sendRedirect("login.jsp");
	}

	String id = (String)session.getAttribute("id");
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	String uid = "leos";
	String upw = "Stonker26";
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = String.format("SELECT * FROM MEMBER WHERE ID = '%s'", id);
	//String sql = "SELECT * FROM MEMBER WHERE ID = ?";

	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, uid, upw);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		if (rs.next()){
			pw = rs.getString("pw");
			name = rs.getString("name");
			phone1 = rs.getString("phone1");
			phone2 = rs.getString("phone2");
			phone3 = rs.getString("phone3");
			gender = rs.getString("gender");
		}
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	} finally {
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
	
%>
<body>
	<form action="../modifyOk" method="POST">
		<table>
			<tr><td colspan="2">회원 정보 수정</td></tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" required="required" placeholder="<%= name %>" /></td>
			</tr>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" required="required" readonly="readonly" value="<%= id %>" /></td>
			</tr>
			<tr>
				<td>현재 PassWord</td>
				<td><input type="password" name="chkPw" required="required" value="<%= pw %>" /></td>
			</tr>
			<tr>
				<td>변경할 PassWord</td>
				<td><input type="password" name="pw" required="required" /></td>
			</tr>
			<tr>
				<td>연락처</td>
				<td>
					<% if ("02".equals(phone1)) { %>
						<select name="phone1" size="1">
							<option></option>
							<option value="02" selected="selected">02</option>
							<option value="010">010</option>
						</select>
					<% } else if ("010".equals(phone1)) { %>
						<select name="phone1" size="1">
							<option></option>
							<option value="02" >02</option>
							<option value="010" selected="selected">010</option>
						</select>
					<% } else { %>
						<select name="phone1" size="1">
							<option></option>
							<option value="02" >02</option>
							<option value="010">010</option>
						</select>
					<% } %>
					-
					<input type="text" id="phone2" name="phone2" size="4" placeholder='<%=phone2!= null? phone2 : "" %>'/>
					-
					<input type="text" id="phone3" name="phone3" size="4" placeholder='<%=phone3!=null? phone3 : "" %>'/>	
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<% if("남자".equals(gender)) { %>
						<input type="radio" id="male" name="gender" value="남자" checked="checked" /><label for="male">남자</label>
						<input type="radio" id="female" name="gender" value="여자" /><label for="female">여자</label>
					<% } else { %>
						<input type="radio" id="male" name="gender" value="남자" /><label for="male">남자</label>
						<input type="radio" id="female" name="gender" value="여자" checked="checked" /><label for="female">여자</label>
					<% } %>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="회원정보수정" />
					<input type="button" value="뒤로가기" onclick="history.go(-1)"/>
					<input type="button" value="로그아웃" onclick="location.href = 'logout.jsp'" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>