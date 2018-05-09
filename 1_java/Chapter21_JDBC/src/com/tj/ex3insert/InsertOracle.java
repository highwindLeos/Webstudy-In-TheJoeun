package com.tj.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertOracle {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("입력하고자 하는 부서번호는 ?");
		int deptno = sc.nextInt();
		System.out.print("그 부서의 이름은 ? ");
		String dname = sc.next();
		System.out.print("그 부서의 위치는 ? ");
		String loc = sc.next();
		
		String query =  "INSERT INTO DEPT VALUES ("+ deptno +", '" + dname +"', '" + loc +"')";
		
		query = String.format("INSERT INTO DEPT VALUES ( %d, '%s', '%s')",
													  deptno, dname, loc);
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			stmt = conn.createStatement();
			
			int resulte = stmt.executeUpdate(query);
			// select 문 전송 : executeQuery(sql문); 결과를 Resultset 변수에 받음.
			// insert/delete/update 문 전송 : executeUpdate(sql문); 결과를 int 변수에 받음.
			
			if (resulte > 0) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "드라이버");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql예외");
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			}catch (Exception e) {}
		}
		sc.close();
	}
}
