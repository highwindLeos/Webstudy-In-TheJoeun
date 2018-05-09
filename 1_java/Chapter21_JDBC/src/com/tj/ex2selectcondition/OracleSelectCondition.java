package com.tj.ex2selectcondition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OracleSelectCondition {
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 부서 번호는 ? ");
		int deptno = sc.nextInt(); // 10,20,30,40
		
		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO =" + deptno; // 부서 정보
		String sql2 = "SELECT * FROM EMP WHERE DEPTNO =" + deptno; //사원정보 
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			
			if (rs.next()) {
				// 부서정보 출력하고 사원 리스트 
					String dname = rs.getString("dname");
					String loc = rs.getString("loc");
					
					System.out.println(deptno + " 번 부서이름 : " + dname);
					System.out.println(deptno + " 번 부서위치 : " + loc);
					System.out.println("======================================");
					System.out.println(deptno + " 번 부서의 사원리스트는 다음과 같다.");
					System.out.println("======================================");

					rs.close(); // 일단 닫음
					rs = stmt.executeQuery(sql2); // 다시 쿼리를 날림.
					
					if (rs.next()) { // 사원이 있으니 리스트를 반복해서 실행하도록 한다.
						do {
							int empno = rs.getInt("empno");
							String ename = rs.getString("ename");
							System.out.println("[사번] : " + empno + "\t[이름] : " + ename);
						} while (rs.next());			
					} else {
						System.out.println("입력하신 부서번호" + deptno +"번은 없습니다.");
					}
			} else {
				System.out.println("입력하신 부서번호" + deptno +"번은 없습니다.");
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
		sc.close();
	}// main()
} // class
