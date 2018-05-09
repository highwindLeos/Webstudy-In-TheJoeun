package com.tj.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateOracle {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���ϴ� �μ���ȣ ?");
		// �Է��� deptno �μ��� �ִ��� Ȯ��. ������ �Ʒ��� ����.
		// �Է��� deptno �� ���ٸ� ���ٴ� �޼��� ���. ����.
		
		
		
		int deptno = sc.nextInt();
		System.out.print("�����ϰ��� �ϴ� �μ� �̸���");
		String dname = sc.next();
		System.out.print("�����ϰ��� �ϴ� �μ� ��ġ��");
		String loc = sc.next();
		
		//UPDATE DEPT SET DNAME = 'OP', LOC ='JONGRO' WHERE DEPTNO = 99;
		String sql = 
		String.format("UPDATE DEPT SET DNAME = '%s', LOC ='%s' WHERE DEPTNO = %d", 
															  dname, loc, deptno);
		Connection conn = null;
		Statement stmt = null;
				
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			stmt = conn.createStatement();
			
			int resulte = stmt.executeUpdate(sql);
			
			if (resulte > 0) {
				System.out.println(deptno + " �� �μ� ���� ����");
			}else {
				System.out.println(deptno +" �� �μ��� ��� ���� ����");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (stmt != null) stmt.close(); 
				if (conn != null) conn.close(); 
			} catch (Exception e) {}
		}
		sc.close();
	}
}
