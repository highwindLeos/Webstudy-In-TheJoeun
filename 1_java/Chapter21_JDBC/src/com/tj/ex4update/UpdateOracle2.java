package com.tj.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateOracle2 {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���ϴ� �μ���ȣ ?");
		int deptno = sc.nextInt();
		// �Է��� deptno �μ��� �ִ��� Ȯ��. ������ �Ʒ��� ����.
		// �Է��� deptno �� ���ٸ� ���ٴ� �޼��� ���. ����.
		String sqlSelect = String.format("SELECT * FROM DEPT WHERE DEPTNO = %d", deptno);
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlSelect);
			
			if (rs.next()) {
				//  ���� ����
				System.out.print("�����ϰ��� �ϴ� �μ� �̸���");
				String dname = sc.next();
				System.out.print("�����ϰ��� �ϴ� �μ� ��ġ��");
				String loc = sc.next();
				
				//UPDATE DEPT SET DNAME = 'OP', LOC ='JONGRO' WHERE DEPTNO = 99;
				String sql = 
				String.format("UPDATE DEPT SET DNAME = '%s', LOC ='%s' WHERE DEPTNO = %d", 
																	  dname, loc, deptno);
				int resulte = stmt.executeUpdate(sql);
				
				System.out.println(resulte > 0 ? "���� ����" : "���� ����");
				
			} else {
				System.out.println("�Է��� �μ���ȣ�� ��� ���� �Ұ�");
			}
			
		} catch (ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close(); 
				if (stmt != null) stmt.close(); 
				if (conn != null) conn.close(); 
			} catch (Exception e) {}
		}
		sc.close();
	}
}
