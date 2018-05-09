package com.tj.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateOracle2 {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정을 원하는 부서번호 ?");
		int deptno = sc.nextInt();
		// 입력한 deptno 부서가 있는지 확인. 있으면 아래를 진행.
		// 입력한 deptno 가 없다면 없다는 메세지 출력. 종료.
		String sqlSelect = String.format("SELECT * FROM DEPT WHERE DEPTNO = %d", deptno);
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlSelect);
			
			if (rs.next()) {
				//  수정 가능
				System.out.print("수정하고자 하는 부서 이름은");
				String dname = sc.next();
				System.out.print("수정하고자 하는 부서 위치는");
				String loc = sc.next();
				
				//UPDATE DEPT SET DNAME = 'OP', LOC ='JONGRO' WHERE DEPTNO = 99;
				String sql = 
				String.format("UPDATE DEPT SET DNAME = '%s', LOC ='%s' WHERE DEPTNO = %d", 
																	  dname, loc, deptno);
				int resulte = stmt.executeUpdate(sql);
				
				System.out.println(resulte > 0 ? "수정 성공" : "수정 실패");
				
			} else {
				System.out.println("입력한 부서번호가 없어서 수정 불가");
			}
			
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close(); 
				if (stmt != null) stmt.close(); 
				if (conn != null) conn.close(); 
			} catch (Exception e) {}
		}
		sc.close();
	}
}
