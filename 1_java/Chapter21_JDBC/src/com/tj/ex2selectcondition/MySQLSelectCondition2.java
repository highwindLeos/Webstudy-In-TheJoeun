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
		System.out.print("원하는 부서 번호는 ? ");
		String dno = sc.next(); // 10,20,30,40 : 문자열로 입력받음.
		
		/*		
		 *  SELECT * FROM DIVISION WHERE DNO = 10;
		 *  SELECT PNO, PNAME, MANAGER, STARTDATE FROM PERSONAL WHERE DNO = 10;
		 */
		String dQuery = "SELECT * FROM DIVISION WHERE DNO =" + dno; // 부서 정보
		String pQuery = "SELECT PNO, PNAME, MANAGER, STARTDATE FROM PERSONAL WHERE DNO =" + dno; //사원정보 
		
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
				// 부서정보 출력하고 사원 리스트 
					String dname = rs.getString("dname");
					String phone = rs.getString("phone");
					String position = rs.getString("position");
					
					System.out.println(dno + " 번 부서이름 : " + dname);
					System.out.println(dno + " 번 부서연락처 : " + phone);
					System.out.println(dno + " 번 부서위치 : " + position);
					
					System.out.println("======================================");
					System.out.println(dno + " 번 부서의 사원리스트는 다음과 같다.");
					System.out.println("======================================");

					rs.close(); // 일단 닫음
					rs = stmt.executeQuery(pQuery); // 다시 쿼리를 날림.
					
					if (rs.next()) { // 사원이 있으니 리스트를 반복해서 실행하도록 한다.
						do {
							int pno = rs.getInt("pno");
							String pname = rs.getString("pname");
							Date startdate = rs.getDate("startdate");
							int pay = rs.getInt("pay");
							
							System.out.println("[사번] : " + pno + "\t[이름] : " + pname + "\t[입사일] : " + startdate + "\t[급여] : " + pay);
						} while (rs.next()); // 반복해서 끝행까지 가져와서 출력한다.	
					} else { // 부서 번호는 있지만 personal 에는 직원 이 없다.
						System.out.println("입력하신 부서번호 " + dno + "번의 직원은 없습니다.");
					}
			} else {
				System.out.println("입력하신 부서번호" + dno + "번은 없습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "연결에 실패 했습니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "쿼리실행에 실패했습니다.");
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
