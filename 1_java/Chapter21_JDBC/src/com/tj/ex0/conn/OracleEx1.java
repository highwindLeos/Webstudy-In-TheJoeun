package com.tj.ex0.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleEx1 {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //정식은 xe 가 orcl
		
		Connection conn = null;
		
		try {
			Class.forName(driver); // 드라이버 로드
			conn = DriverManager.getConnection(url, "leos", "Stonker26"); // 연결 객체를 만든다.
			
			System.out.println("Database 연결 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "드라이버를 못찾았습니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "연결이 되지 못했습니다.");
		} finally {
			try {
				if( conn != null ) conn.close();  // 객체가 잘작동했다면 닫음.
			} catch (SQLException e) { } 
		}
	}
}
