package com.tj.ex7homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Console2 {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Person> person = new ArrayList<Person>();
		
		String sql2 = "SELECT ROWNUM||'등' RANK, NAME||'('||ID||'번)' NAMEID, JNAME, KOR, ENG, MAT, SUM "
				+ "FROM (SELECT P.*, JNAME, KOR+ENG+MAT SUM FROM PERSON P, JOB J "
				+ "WHERE P.JNO = J.JNO AND JNAME = ? ORDER BY SUM DESC)";
		
		System.out.print("출력할 직업명은 ?");
		String jname = sc.next();
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, jname);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String rank = rs.getString("rank");
				String nameId = rs.getString("nameid");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				
				person.add(new Person(rank, nameId, jname, kor, eng, mat, sum));
			}
			
			System.out.println("등수 \t 이름(ID) \t직업     국어(kor) 영어(eng) 수학(mat) 총점");
			System.out.println("-----------------------------------------------------------");
			if(person.size() != 0) { // 쿼리 응답으로 데이터가 있다면 (size 를 구해와서 0인지 비교)
				for (Person pt : person) {
					System.out.println(pt.toString());
				}
			} else {
				System.out.println("입력한 직업명은 없습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "드라이버");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL");
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) { System.out.println(e.getMessage()); }
		}
		sc.close();
	}

}
