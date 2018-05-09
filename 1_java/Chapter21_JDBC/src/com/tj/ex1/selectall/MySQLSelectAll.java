package com.tj.ex1.selectall;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLSelectAll {

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/leosdatabase";
		
		String query = "select * from personal";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1 드라이버 로드
			Class.forName(driver);
			// 2 DBMS 연결  객체 생성
			conn = DriverManager.getConnection(url, "root", "stonker26");
			// 3 sql 결과를 전송할 객체를 생성.
			stmt = conn.createStatement();
			// 4 sql 문을 전송하고 결과를 받는다.
			rs = stmt.executeQuery(query);
			// 5 결과에 따른 필요한 로직을 수행.
			
			System.out.println("사번\t 이름\t 직책\t\t 관리자사번  입사일\t\t 급여\t 포인트\t 부서번호\t");
			System.out.println("=================================================================================");
			if (rs.next()) { // 결과가 1행이상 있다면
				do {
					int pno = rs.getInt("pno");
					String pname = rs.getString("pname");
					String job = rs.getString("job");
					int manager = rs.getInt("manager");
					Date startdate = rs.getDate("startdate");
					int pay = rs.getInt("pay");
					int bonus = rs.getInt("bonus");
					int dno = rs.getInt("dno");
					
					if(pname.length() >= 7) {
						System.out.printf("%d\t %s %s\t %d\t %TF\t %d\t %d\t %d\t \n",
										   pno, pname, job, manager, startdate, pay, bonus, dno);
					} else {
						System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\t \n",
										   pno, pname, job, manager, startdate, pay, bonus, dno);
					}

				} while (rs.next());
			} else { // 결과가 0행 (없음)
				System.out.println("출력할 데이터가 없습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if(rs != null)
				try {
					if (rs != null) rs.close();
					if (stmt != null) stmt.close();
					if (conn != null) conn.close();
				} catch (SQLException e) { }
		}
	}
}
