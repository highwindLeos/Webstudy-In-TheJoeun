package com.tj.ex2selectcondition;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OracleSelectVarchar {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 부서 이름을 입력하세요?");
		
		String dname = sc.nextLine(); // 빈칸이 있다면 필수로 nextLine() 메소드.
		dname = dname.toUpperCase(); // 소문자를 입력해도 대문자로.
		
		String dQuery = "SELECT * FROM DEPT WHERE DNAME = '" + dname + "'";
		
		String eQuery = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, E.DEPTNO, DNAME, LOC " 
					  + "FROM EMP E, DEPT D " 
					  + "WHERE E.DEPTNO = D.DEPTNO AND DNAME = '" + dname +"'";
		
		dQuery = String.format("SELECT * FROM DEPT WHERE DNAME = '%s'", dname); // 쿼리에 싱클퀘테이션 이 있다면 String.format() 이 좋다.
		
		eQuery = String.format("SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, E.DEPTNO, DNAME, LOC "
							 + "FROM EMP E, DEPT D "
							 + "WHERE E.DEPTNO = D.DEPTNO AND DNAME = '%s'", dname);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(dQuery);
			
			if (rs.next()) {
				// 부서 정보 출력 사원 정보 출력
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				
				System.out.println(dname + " 부서의 번호 " + deptno);
				System.out.println(dname + " 부서의 위치 " + loc);
				
				// 사원의 정보도 출력.
				rs.close();
				rs = stmt.executeQuery(eQuery);
				
				if (rs.next()) {
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int mgr = rs.getInt("mgr");
						int sal = rs.getInt("sal");
						Date hiredate = rs.getDate("hiredate");
						loc = rs.getString("loc");
						deptno = rs.getInt("deptno");
						String job = rs.getString("job");
						
						System.out.printf("%d\t %s\t %d\t %d\t %TF\t %s\t %d\t %s\t \n", 
										  empno, ename, mgr, sal, hiredate, loc, deptno, job);
					} while (rs.next());
				} else {
					System.out.println(dname + "부서의 사원은 없습니다.");
				}
			} else {
				System.out.println(dname + " 부서이름이 존재하지 않습니다.");
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
			} catch (SQLException e) {}
		}
		sc.close();
	}
}
