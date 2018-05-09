package com.tj.ex7homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Console1 {

	public static void main(String[] args) { // person �Է� ���α׷�.
		
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
			System.out.print("�Է��� ����̸�?");
			pstmt.setString(1, sc.next());
			System.out.print("������? (10:���, 20:���� 30:�� 40:����)?");
			pstmt.setInt(2, sc.nextInt());
			System.out.print("����������?(0~100)");
			int kor = sc.nextInt();
			if (kor >= 0 && kor <= 100) {
				pstmt.setInt(3, kor);
			} else {
				System.out.println("���������� �߸��Է��ؼ� 0�� ó���մϴ�");
				pstmt.setInt(3, 0);
			}
			System.out.print("����������?(0~100)");
			pstmt.setInt(4, sc.nextInt());
			System.out.print("����������?(0~100)");
			pstmt.setInt(5, sc.nextInt());
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("�Է¼��� �߽��ϴ�.");
			} else {
				System.out.println("�Է½��� �߽��ϴ�.");
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
