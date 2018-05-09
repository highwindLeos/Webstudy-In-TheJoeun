package com.tj.ex1.selectall;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleSelectAll {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// String url = "jdbc:oracle:thin:@localhost:1521:orcl"; 정식버전
		
		String query = "SELECT * FROM EMP";
		
		Connection conn = null; // DBMS 와 연결하는 객체가 될예정
		Statement stmt = null; // SQL 문을 전송하는 객체
		ResultSet rs = null; // select 문의 대한 결과를 받을 객체
		
		try {
			// 1 드라이버 로드
			Class.forName(driver); 
			// 2 DBMS 연결  객체 생성
			conn = DriverManager.getConnection(url, "leos", "Stonker26"); 
			// 3 sql 결과를 전송할 객체를 생성.
			stmt = conn.createStatement();
			// 4 sql 문을 전송하고 결과를 받는다.
			rs = stmt.executeQuery(query);
			// 5 결과에 따른 필요한 로직을 수행.
			System.out.println("사번 \t  이름\t  직책\t\t  급여\t  입사일\t\t  부서번호\t");
			if(rs.next()) {
				do {
					int empno = rs.getInt("empno"); // 번호로 필드명을 넣으면 테이블의 필드의 순서대로 가져온다. 
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int sal = rs.getInt("sal");
					Date hiredate = rs.getDate("hiredate");
					int deptno = rs.getInt("deptno");
					
					if (job.length() <= 5) {
						System.out.printf("%d\t %s\t %s\t\t %d\t %TF\t %d\t \n", 
									  	empno, ename, job, sal, hiredate, deptno);
					} else {
						System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t \n", 
								  		empno, ename, job, sal, hiredate, deptno);
					}
					
				} while (rs.next());
			} else {
				System.out.println("출력 데이터가 없습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "드라이버 로드 실패");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "연결 실패");
		} finally {
			try { // 연결해제
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch(Exception e) { }
		}
		
	}

}
