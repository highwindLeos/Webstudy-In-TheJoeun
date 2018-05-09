package com.tj.ex6preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementOracle {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// 부서 등록.
		Scanner sc = new Scanner(System.in);
		System.out.print("등록할 부서번호 ?");
		int deptno = sc.nextInt();
		System.out.print("등록할 부서 이름 ?");
		String dname = sc.next();
		System.out.print("등록할 부서 위치 ?");
		sc.nextLine(); // 버퍼 지우는 용도
		String loc = sc.next();
		
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
		String sqlSelect = "SELECT * FROM DEPT";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc); // 쿼리의 ? 인자값을 묶어서 생성해준다. '' 까지 처리해줌.
			
			int resulte = pstmt.executeUpdate();
			System.out.println( resulte > 0 ? "입력성공" : "입력 실패");
			
			pstmt.close();
			pstmt = conn.prepareStatement(sqlSelect);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					deptno = rs.getInt("deptno");
					dname = rs.getString("dname");
					loc = rs.getString("loc");
				
					if (dname.length() <= 5) {
						System.out.printf("[부서번호] : %d [부서명] : %s \t  [부서위치] : %s \n", deptno, dname, loc);
					} else {
						System.out.printf("[부서번호] : %d [부서명] : %s [부서위치] : %s \n", deptno, dname, loc);
					}
				
				} while (rs.next());
			} else {
				System.out.println("부서 테이블에 행이 없습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) { System.out.println(e.getMessage());}
		}
		sc.close();
	}
}
