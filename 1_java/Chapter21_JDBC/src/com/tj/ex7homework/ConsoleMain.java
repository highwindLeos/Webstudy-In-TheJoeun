package com.tj.ex7homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleMain {
	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Person> person = new ArrayList<Person>();
		
		String fn = "";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			
			do {
				// ���ϴ� ��� ��ȣ�� �Է¹޾� �Է� ������ ��� ��� ���
				System.out.print("���ϴ� ��ɹ�ȣ�� �Է��ϼ��� (1:�Է� , 2:������ ���, 3:��ü��� �׿�: ����) ");
				fn = sc.next();
				
				switch(fn) {
					case "1" : // �Է�
						System.out.print("�Է��� ����̸�?");
						String name = sc.next();
						System.out.print("������ȣ ?(10:��� 20:���� 30:��)");
						int jno = sc.nextInt();
						System.out.print("���� ����?");
						int kor = sc.nextInt();
						System.out.print("���� ����?");
						int eng = sc.nextInt();
						System.out.print("���� ����?");
						int mat = sc.nextInt();
						
						String sql1 = "INSERT INTO PERSON VALUES (SEQ_PERSON.NEXTVAL, ?, ?, ?, ?, ?)";
						
						pstmt = conn.prepareStatement(sql1);
						
						pstmt.setString(1, name);
						pstmt.setInt(2, jno);
						pstmt.setInt(3, kor);
						pstmt.setInt(4, eng);
						pstmt.setInt(5, mat);
						
						int resulte = pstmt.executeUpdate();
						
						if (resulte > 0) {
							System.out.println(name + "�Է� ����");
						} else {
							System.out.println(name + "�Է� ����");
						}
						
						pstmt.close();
						break;
					
					case "2" : // �μ��� ���
						System.out.println("����� ���ϴ� �������� �Է��ϼ���.");
						String jname = sc.next();
						
						String sql2 = "SELECT ROWNUM||'��' RANK, NAME||'('||ID||'��)' NAMEID, JNAME, KOR, ENG, MAT, SUM "
								+ "FROM (SELECT P.*, JNAME, KOR+ENG+MAT SUM FROM PERSON P, JOB J "
								+ "WHERE P.JNO = J.JNO AND JNAME = ? ORDER BY SUM DESC)";
						
						pstmt = conn.prepareStatement(sql2);
						pstmt.setString(1, jname);
						rs = pstmt.executeQuery();
						person.clear();
						
						while (rs.next()) {
							String rank = rs.getString("rank");
							String nameId = rs.getString("nameid");
							kor = rs.getInt("kor");
							eng = rs.getInt("eng");
							mat = rs.getInt("mat");
							int sum = rs.getInt("sum");
							
							person.add(new Person(rank, nameId, jname, kor, eng, mat, sum));
						}
						System.out.println("��� \t �̸�(ID) \t����     ����(kor) ����(eng) ����(mat) ����");
						System.out.println("-----------------------------------------------------------");
						
						if (person.size() != 0) {
							for (Person pt : person) {
								System.out.println(pt.toString());
							}
						} else {
							System.out.println("�ش� �������� �����Ͱ� �����ϴ�.");
						}
						
						rs.close();
						pstmt.close();
						
						break;
						
					case "3" : // ���̺� ��ü���
						String sql3 = "SELECT ROWNUM||'��' RANK, NAME||'('||ID||'��)' NAMEID, JNAME, KOR, ENG, MAT, SUM " + 
							  	  "FROM (SELECT P.*, JNAME, KOR+ENG+MAT SUM FROM PERSON P, JOB J WHERE P.JNO = J.JNO ORDER BY SUM DESC)";
						
						System.out.println("��ä ���̺��� ������ ����մϴ�.");
						stmt = conn.createStatement();
						rs = stmt.executeQuery(sql3);
						
						person.clear();
						

						while (rs.next()) {
							Person p = new Person();
							
							p.setRank(rs.getString("rank"));
							p.setNameId(rs.getString("nameid"));
							p.setJname(rs.getString("jname"));
							p.setKor(rs.getInt("kor"));
							p.setEng(rs.getInt("eng"));
							p.setMat(rs.getInt("mat"));
							p.setSum(rs.getInt("sum"));
							
							person.add(p);
						}
						
						System.out.println("��� \t �̸�(ID) \t����     ����(kor) ����(eng) ����(mat) ����");
						System.out.println("-----------------------------------------------------------");
						if (person.size() != 0) {
							for (Person pt : person) {
								System.out.println(pt.toString());
							}
						} else {
							System.out.println("�����Ͱ� �����ϴ�.");
						}
						
						rs.close();
						stmt.close();
						break;
				}
			
			} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
			
			System.out.println("���α׷��� �����մϴ�.");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (SQLException e) {
			 System.out.println(e.getMessage());
			}
		}
	}
}
