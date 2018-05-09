package com.tj.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteOracle {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���ϴ� �μ� ��ȣ��?");
		String deptno = sc.next();
		
		String sql = String.format("DELETE FROM DEPT WHERE DEPTNO = %s", deptno);
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			stmt = conn.createStatement();
			int resulte = stmt.executeUpdate(sql);
			
			System.out.println( resulte > 0 ? "���� ����" : "���� �μ��� ���� ����");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}
		sc.close();
	}

}
