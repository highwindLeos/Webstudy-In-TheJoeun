package com.tj.ex7homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Console3 {

	public static void main(String[] args) {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Person> person = new ArrayList<Person>();
		
		String sql3 = "SELECT ROWNUM||'��' RANK, NAME||'('||ID||'��)' NAMEID, JNAME, KOR, ENG, MAT, SUM " + 
					  "FROM (SELECT P.*, JNAME, KOR+ENG+MAT SUM FROM PERSON P, JOB J WHERE P.JNO = J.JNO ORDER BY SUM DESC)";
				
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection(url, "leos", "Stonker26");
			pstmt = conn.prepareStatement(sql3);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String rank = rs.getString("rank");
				String nameId = rs.getString("nameid");
				String jname = rs.getString("jname");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int sum = rs.getInt("sum");
				
				person.add(new Person(rank, nameId, jname, kor, eng, mat, sum));
			}
			
			System.out.println("��� \t �̸�(ID) \t����     ����(kor) ����(eng) ����(mat) ����");
			System.out.println("-----------------------------------------------------------");
			if(person.size() != 0) { // ���� �������� �����Ͱ� �ִٸ� (size �� ���ؿͼ� 0���� ��)
				for (Person pt : person) {
					System.out.println(pt.toString());
				}
			} else {
				System.out.println("����� �����Ͱ� �����ϴ�.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "����̹�");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL");
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) { System.out.println(e.getMessage()); }
		}
	}

}
