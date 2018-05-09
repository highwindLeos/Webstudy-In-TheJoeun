package com.tj.ex7homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Console1 {

	public static void main(String[] args) { // person 입력 프로그램.
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner sc = new Scanner(System.in);

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql1 = "INSERT INTO PERSON VALUES (SEQ_PERSON.NEXTVAL, ?, ?, ?, ?, ?)";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			pstmt = conn.prepareStatement(sql1);
			System.out.print("입력할 사람이름?");
			pstmt.setString(1, sc.next());
			System.out.print("직업은? (10:배우, 20:가수 30:모델 40:감독)?");
			pstmt.setInt(2, sc.nextInt());
			System.out.print("국어점수는?(0~100)");
			int kor = sc.nextInt();
			if (kor >= 0 && kor <= 100) {
				pstmt.setInt(3, kor);
			} else {
				System.out.println("국어점수를 잘못입력해서 0점 처리합니다");
				pstmt.setInt(3, 0);
			}
			System.out.print("영어점수는?(0~100)");
			pstmt.setInt(4, sc.nextInt());
			System.out.print("수학점수는?(0~100)");
			pstmt.setInt(5, sc.nextInt());
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("입력성공 했습니다.");
			} else {
				System.out.println("입력실패 했습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) { System.out.println(e.getMessage()); }
		} // finally
		sc.close();
	}// main()
}
