package com.tj.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateOracle {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정을 원하는 부서번호 ?");
		// 입력한 deptno 부서가 있는지 확인. 있으면 아래를 진행.
		// 입력한 deptno 가 없다면 없다는 메세지 출력. 종료.
		
		
		
		int deptno = sc.nextInt();
		System.out.print("수정하고자 하는 부서 이름은");
		String dname = sc.next();
		System.out.print("수정하고자 하는 부서 위치는");
		String loc = sc.next();
		
		//UPDATE DEPT SET DNAME = 'OP', LOC ='JONGRO' WHERE DEPTNO = 99;
		String sql = 
		String.format("UPDATE DEPT SET DNAME = '%s', LOC ='%s' WHERE DEPTNO = %d", 
															  dname, loc, deptno);
		Connection conn = null;
		Statement stmt = null;
				
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			stmt = conn.createStatement();
			
			int resulte = stmt.executeUpdate(sql);
			
			if (resulte > 0) {
				System.out.println(deptno + " 번 부서 수정 성공");
			}else {
				System.out.println(deptno +" 번 부서가 없어서 수정 실패");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null) stmt.close(); 
				if (conn != null) conn.close(); 
			} catch (Exception e) {}
		}
		sc.close();
	}
}
