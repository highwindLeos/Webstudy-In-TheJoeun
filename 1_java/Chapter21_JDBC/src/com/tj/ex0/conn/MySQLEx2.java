package com.tj.ex0.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLEx2 {

	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/leosdatabase";
		
		Connection conn = null;	
		try {
			Class.forName(driver); // ����̹� �ε�
			conn = DriverManager.getConnection(url, "root", "stonker26"); // ���� ��ü�� �����.
			
			System.out.println("Database ���� ����");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "����̹��� ��ã�ҽ��ϴ�.");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "������ ���� ���߽��ϴ�.");
		} finally {
			try {
				if( conn != null ) conn.close();  // ��ü�� �� �۵��ߴٸ� ����.
			} catch (SQLException e) { } 
		}
		
	} // main()
} // class
