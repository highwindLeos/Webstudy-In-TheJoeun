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
		// �μ� ���.
		Scanner sc = new Scanner(System.in);
		System.out.print("����� �μ���ȣ ?");
		int deptno = sc.nextInt();
		System.out.print("����� �μ� �̸� ?");
		String dname = sc.next();
		System.out.print("����� �μ� ��ġ ?");
		sc.nextLine(); // ���� ����� �뵵
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
			pstmt.setString(3, loc); // ������ ? ���ڰ��� ��� �������ش�. '' ���� ó������.
			
			int resulte = pstmt.executeUpdate();
			System.out.println( resulte > 0 ? "�Է¼���" : "�Է� ����");
			
			pstmt.close();
			pstmt = conn.prepareStatement(sqlSelect);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					deptno = rs.getInt("deptno");
					dname = rs.getString("dname");
					loc = rs.getString("loc");
				
					if (dname.length() <= 5) {
						System.out.printf("[�μ���ȣ] : %d [�μ���] : %s \t  [�μ���ġ] : %s \n", deptno, dname, loc);
					} else {
						System.out.printf("[�μ���ȣ] : %d [�μ���] : %s [�μ���ġ] : %s \n", deptno, dname, loc);
					}
				
				} while (rs.next());
			} else {
				System.out.println("�μ� ���̺� ���� �����ϴ�.");
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
