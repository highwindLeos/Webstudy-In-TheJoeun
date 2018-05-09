package com.tj.ex2selectcondition;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OracleSelectVarchar {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���ϴ� �μ� �̸��� �Է��ϼ���?");
		
		String dname = sc.nextLine(); // ��ĭ�� �ִٸ� �ʼ��� nextLine() �޼ҵ�.
		dname = dname.toUpperCase(); // �ҹ��ڸ� �Է��ص� �빮�ڷ�.
		
		String dQuery = "SELECT * FROM DEPT WHERE DNAME = '" + dname + "'";
		
		String eQuery = "SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, E.DEPTNO, DNAME, LOC " 
					  + "FROM EMP E, DEPT D " 
					  + "WHERE E.DEPTNO = D.DEPTNO AND DNAME = '" + dname +"'";
		
		dQuery = String.format("SELECT * FROM DEPT WHERE DNAME = '%s'", dname); // ������ ��Ŭ�����̼� �� �ִٸ� String.format() �� ����.
		
		eQuery = String.format("SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, E.DEPTNO, DNAME, LOC "
							 + "FROM EMP E, DEPT D "
							 + "WHERE E.DEPTNO = D.DEPTNO AND DNAME = '%s'", dname);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(dQuery);
			
			if (rs.next()) {
				// �μ� ���� ��� ��� ���� ���
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				
				System.out.println(dname + " �μ��� ��ȣ " + deptno);
				System.out.println(dname + " �μ��� ��ġ " + loc);
				
				// ����� ������ ���.
				rs.close();
				rs = stmt.executeQuery(eQuery);
				
				if (rs.next()) {
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int mgr = rs.getInt("mgr");
						int sal = rs.getInt("sal");
						Date hiredate = rs.getDate("hiredate");
						loc = rs.getString("loc");
						deptno = rs.getInt("deptno");
						String job = rs.getString("job");
						
						System.out.printf("%d\t %s\t %d\t %d\t %TF\t %s\t %d\t %s\t \n", 
										  empno, ename, mgr, sal, hiredate, loc, deptno, job);
					} while (rs.next());
				} else {
					System.out.println(dname + "�μ��� ����� �����ϴ�.");
				}
			} else {
				System.out.println(dname + " �μ��̸��� �������� �ʽ��ϴ�.");
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
			} catch (SQLException e) {}
		}
		sc.close();
	}
}
