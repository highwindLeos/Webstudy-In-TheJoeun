package com.tj.ex1.selectall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleSelectEx1 {
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		String sql = "SELECT * FROM DEPT";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("부서번호\t 부서명\t\t 지역\t");
			System.out.println("======================================");
			if (rs.next()) {
				do {
					int deptno = rs.getInt("deptno");
					String dname = rs.getString("dname");
					String loc = rs.getString("loc");
					if (dname.length() <= 5) {
						System.out.printf("%d\t %s\t\t %s\t \n", deptno, dname, loc);
					} else {
						System.out.printf("%d\t %s\t %s\t \n", deptno, dname, loc);
					}

				} while (rs.next());
			} else {
				System.out.println("출력할 데이터가 없습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {}
		} // try catch
	}// main()
} // class
