package com.tj.ex1.selectall;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleSelectAll {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// String url = "jdbc:oracle:thin:@localhost:1521:orcl"; ���Ĺ���
		
		String query = "SELECT * FROM EMP";
		
		Connection conn = null; // DBMS �� �����ϴ� ��ü�� �ɿ���
		Statement stmt = null; // SQL ���� �����ϴ� ��ü
		ResultSet rs = null; // select ���� ���� ����� ���� ��ü
		
		try {
			// 1 ����̹� �ε�
			Class.forName(driver); 
			// 2 DBMS ����  ��ü ����
			conn = DriverManager.getConnection(url, "leos", "Stonker26"); 
			// 3 sql ����� ������ ��ü�� ����.
			stmt = conn.createStatement();
			// 4 sql ���� �����ϰ� ����� �޴´�.
			rs = stmt.executeQuery(query);
			// 5 ����� ���� �ʿ��� ������ ����.
			System.out.println("��� \t  �̸�\t  ��å\t\t  �޿�\t  �Ի���\t\t  �μ���ȣ\t");
			if(rs.next()) {
				do {
					int empno = rs.getInt("empno"); // ��ȣ�� �ʵ���� ������ ���̺��� �ʵ��� ������� �����´�. 
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int sal = rs.getInt("sal");
					Date hiredate = rs.getDate("hiredate");
					int deptno = rs.getInt("deptno");
					
					if (job.length() <= 5) {
						System.out.printf("%d\t %s\t %s\t\t %d\t %TF\t %d\t \n", 
									  	empno, ename, job, sal, hiredate, deptno);
					} else {
						System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t \n", 
								  		empno, ename, job, sal, hiredate, deptno);
					}
					
				} while (rs.next());
			} else {
				System.out.println("��� �����Ͱ� �����ϴ�.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "���� ����");
		} finally {
			try { // ��������
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch(Exception e) { }
		}
		
	}

}
