package com.tj.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertMysql {
	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/leosdatabase";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력하고자 하는 부서 번호는?");
		int dno = sc.nextInt();
		System.out.print("그 부서의 이름은?");
		String dname = sc.next();
		System.out.print("그 부서의 연락처는 ");
		String phone = sc.next();
		System.out.print("그 부서의 위치는");
		String position = sc.next();
		
		String query1 = String.format("INSERT INTO division VALUES (%d, '%s', '%s', '%s')",
															  dno, dname, phone, position);
		
		String query2 = "SELECT * FROM DIVISION";
		
		Connection conn= null;
		Statement stmt = null;
		
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, "root", "stonker26");
			stmt = conn.createStatement();
			
			int resulte = stmt.executeUpdate(query1);
			
			if (resulte > 0) {
				System.out.println("입력성공");
			} else {
				System.out.println("입력실패");
			}
			
			rs = stmt.executeQuery(query2);
			
			if (rs.next()) {
				do {
					dno = rs.getInt("dno");
					dname =  rs.getString("dname");
					phone =  rs.getString("phone");
					position =  rs.getString("position");
					
					System.out.printf("[부서번호] : %d [부서이름] : %s [연락처] : %s [부서위치] : %s \n", dno, dname, phone, position);
				} while (rs.next());
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() +"드라이버 예외");
		} catch (SQLException e) {
			System.out.println(e.getMessage() +"SQL 예외");
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			}catch (Exception e) {}
		}
		sc.close();
	}
}
