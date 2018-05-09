package com.tj.ex1.selectall;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLSelectAll {

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/leosdatabase";
		
		String query = "select * from personal";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1 ����̹� �ε�
			Class.forName(driver);
			// 2 DBMS ����  ��ü ����
			conn = DriverManager.getConnection(url, "root", "stonker26");
			// 3 sql ����� ������ ��ü�� ����.
			stmt = conn.createStatement();
			// 4 sql ���� �����ϰ� ����� �޴´�.
			rs = stmt.executeQuery(query);
			// 5 ����� ���� �ʿ��� ������ ����.
			
			System.out.println("���\t �̸�\t ��å\t\t �����ڻ��  �Ի���\t\t �޿�\t ����Ʈ\t �μ���ȣ\t");
			System.out.println("=================================================================================");
			if (rs.next()) { // ����� 1���̻� �ִٸ�
				do {
					int pno = rs.getInt("pno");
					String pname = rs.getString("pname");
					String job = rs.getString("job");
					int manager = rs.getInt("manager");
					Date startdate = rs.getDate("startdate");
					int pay = rs.getInt("pay");
					int bonus = rs.getInt("bonus");
					int dno = rs.getInt("dno");
					
					if(pname.length() >= 7) {
						System.out.printf("%d\t %s %s\t %d\t %TF\t %d\t %d\t %d\t \n",
										   pno, pname, job, manager, startdate, pay, bonus, dno);
					} else {
						System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\t \n",
										   pno, pname, job, manager, startdate, pay, bonus, dno);
					}

				} while (rs.next());
			} else { // ����� 0�� (����)
				System.out.println("����� �����Ͱ� �����ϴ�.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if(rs != null)
				try {
					if (rs != null) rs.close();
					if (stmt != null) stmt.close();
					if (conn != null) conn.close();
				} catch (SQLException e) { }
		}
	}
}
