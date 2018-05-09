package com.tj.ex2selectcondition;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MySQLSelectCondition2 {
	public static void main(String[] args) {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/leosdatabase";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���ϴ� �μ� ��ȣ�� ? ");
		String dno = sc.next(); // 10,20,30,40 : ���ڿ��� �Է¹���.
		
		/*		
		 *  SELECT * FROM DIVISION WHERE DNO = 10;
		 *  SELECT PNO, PNAME, MANAGER, STARTDATE FROM PERSONAL WHERE DNO = 10;
		 */
		String dQuery = "SELECT * FROM DIVISION WHERE DNO =" + dno; // �μ� ����
		String pQuery = "SELECT PNO, PNAME, MANAGER, STARTDATE FROM PERSONAL WHERE DNO =" + dno; //������� 
		
		pQuery = String.format("SELECT PNO, PNAME, MANAGER, STARTDATE, PAY FROM PERSONAL WHERE DNO = %s", dno);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, "leos", "stonker26");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(dQuery);
			
			if (rs.next()) {
				// �μ����� ����ϰ� ��� ����Ʈ 
					String dname = rs.getString("dname");
					String phone = rs.getString("phone");
					String position = rs.getString("position");
					
					System.out.println(dno + " �� �μ��̸� : " + dname);
					System.out.println(dno + " �� �μ�����ó : " + phone);
					System.out.println(dno + " �� �μ���ġ : " + position);
					
					System.out.println("======================================");
					System.out.println(dno + " �� �μ��� �������Ʈ�� ������ ����.");
					System.out.println("======================================");

					rs.close(); // �ϴ� ����
					rs = stmt.executeQuery(pQuery); // �ٽ� ������ ����.
					
					if (rs.next()) { // ����� ������ ����Ʈ�� �ݺ��ؼ� �����ϵ��� �Ѵ�.
						do {
							int pno = rs.getInt("pno");
							String pname = rs.getString("pname");
							Date startdate = rs.getDate("startdate");
							int pay = rs.getInt("pay");
							
							System.out.println("[���] : " + pno + "\t[�̸�] : " + pname + "\t[�Ի���] : " + startdate + "\t[�޿�] : " + pay);
						} while (rs.next()); // �ݺ��ؼ� ������� �����ͼ� ����Ѵ�.	
					} else { // �μ� ��ȣ�� ������ personal ���� ���� �� ����.
						System.out.println("�Է��Ͻ� �μ���ȣ " + dno + "���� ������ �����ϴ�.");
					}
			} else {
				System.out.println("�Է��Ͻ� �μ���ȣ" + dno + "���� �����ϴ�.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "���ῡ ���� �߽��ϴ�.");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "�������࿡ �����߽��ϴ�.");
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		} // try catch
		sc.close();
	}// main()
} // class
