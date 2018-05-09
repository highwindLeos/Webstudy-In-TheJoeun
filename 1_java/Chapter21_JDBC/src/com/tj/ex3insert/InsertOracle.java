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
		System.out.println("�Է��ϰ��� �ϴ� �μ���ȣ�� ?");
		int deptno = sc.nextInt();
		System.out.print("�� �μ��� �̸��� ? ");
		String dname = sc.next();
		System.out.print("�� �μ��� ��ġ�� ? ");
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
			// select �� ���� : executeQuery(sql��); ����� Resultset ������ ����.
			// insert/delete/update �� ���� : executeUpdate(sql��); ����� int ������ ����.
			
			if (resulte > 0) {
				System.out.println("�Է� ����");
			} else {
				System.out.println("�Է� ����");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "����̹�");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "sql����");
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			}catch (Exception e) {}
		}
		sc.close();
	}
}
