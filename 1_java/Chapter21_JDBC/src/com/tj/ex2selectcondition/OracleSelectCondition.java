package com.tj.ex2selectcondition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OracleSelectCondition {
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���ϴ� �μ� ��ȣ�� ? ");
		int deptno = sc.nextInt(); // 10,20,30,40
		
		String sql1 = "SELECT * FROM DEPT WHERE DEPTNO =" + deptno; // �μ� ����
		String sql2 = "SELECT * FROM EMP WHERE DEPTNO =" + deptno; //������� 
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			
			if (rs.next()) {
				// �μ����� ����ϰ� ��� ����Ʈ 
					String dname = rs.getString("dname");
					String loc = rs.getString("loc");
					
					System.out.println(deptno + " �� �μ��̸� : " + dname);
					System.out.println(deptno + " �� �μ���ġ : " + loc);
					System.out.println("======================================");
					System.out.println(deptno + " �� �μ��� �������Ʈ�� ������ ����.");
					System.out.println("======================================");

					rs.close(); // �ϴ� ����
					rs = stmt.executeQuery(sql2); // �ٽ� ������ ����.
					
					if (rs.next()) { // ����� ������ ����Ʈ�� �ݺ��ؼ� �����ϵ��� �Ѵ�.
						do {
							int empno = rs.getInt("empno");
							String ename = rs.getString("ename");
							System.out.println("[���] : " + empno + "\t[�̸�] : " + ename);
						} while (rs.next());			
					} else {
						System.out.println("�Է��Ͻ� �μ���ȣ" + deptno +"���� �����ϴ�.");
					}
			} else {
				System.out.println("�Է��Ͻ� �μ���ȣ" + deptno +"���� �����ϴ�.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {}
		} // try catch
		sc.close();
	}// main()
} // class
