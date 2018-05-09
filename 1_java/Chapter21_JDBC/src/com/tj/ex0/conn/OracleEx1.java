package com.tj.ex0.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleEx1 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //������ xe �� orcl
		
		Connection conn = null;
		
		try {
			Class.forName(driver); // ����̹� �ε�
			conn = DriverManager.getConnection(url, "leos", "Stonker26"); // ���� ��ü�� �����.
			
			System.out.println("Database ���� ����");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "����̹��� ��ã�ҽ��ϴ�.");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "������ ���� ���߽��ϴ�.");
		} finally {
			try {
				if( conn != null ) conn.close();  // ��ü�� ���۵��ߴٸ� ����.
			} catch (SQLException e) { } 
		}
	}
}
