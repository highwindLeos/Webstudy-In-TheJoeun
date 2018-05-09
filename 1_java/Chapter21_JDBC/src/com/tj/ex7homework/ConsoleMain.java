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
				// 원하는 기능 번호를 입력받아 입력 직업별 출력 모두 출력
				System.out.print("원하는 기능번호를 입력하세요 (1:입력 , 2:직업명별 출력, 3:전체출력 그외: 종료) ");
				fn = sc.next();
				
				switch(fn) {
					case "1" : // 입력
						System.out.print("입력할 사람이름?");
						String name = sc.next();
						System.out.print("직업번호 ?(10:배우 20:가수 30:모델)");
						int jno = sc.nextInt();
						System.out.print("국어 점수?");
						int kor = sc.nextInt();
						System.out.print("영어 점수?");
						int eng = sc.nextInt();
						System.out.print("수학 점수?");
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
							System.out.println(name + "입력 성공");
						} else {
							System.out.println(name + "입력 실패");
						}
						
						pstmt.close();
						break;
					
					case "2" : // 부서별 출력
						System.out.println("출력을 원하는 직업명을 입력하세요.");
						String jname = sc.next();
						
						String sql2 = "SELECT ROWNUM||'등' RANK, NAME||'('||ID||'번)' NAMEID, JNAME, KOR, ENG, MAT, SUM "
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
						System.out.println("등수 \t 이름(ID) \t직업     국어(kor) 영어(eng) 수학(mat) 총점");
						System.out.println("-----------------------------------------------------------");
						
						if (person.size() != 0) {
							for (Person pt : person) {
								System.out.println(pt.toString());
							}
						} else {
							System.out.println("해당 직업군의 데이터가 없습니다.");
						}
						
						rs.close();
						pstmt.close();
						
						break;
						
					case "3" : // 테이블 전체출력
						String sql3 = "SELECT ROWNUM||'등' RANK, NAME||'('||ID||'번)' NAMEID, JNAME, KOR, ENG, MAT, SUM " + 
							  	  "FROM (SELECT P.*, JNAME, KOR+ENG+MAT SUM FROM PERSON P, JOB J WHERE P.JNO = J.JNO ORDER BY SUM DESC)";
						
						System.out.println("전채 테이블의 내용을 출력합니다.");
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
						
						System.out.println("등수 \t 이름(ID) \t직업     국어(kor) 영어(eng) 수학(mat) 총점");
						System.out.println("-----------------------------------------------------------");
						if (person.size() != 0) {
							for (Person pt : person) {
								System.out.println(pt.toString());
							}
						} else {
							System.out.println("데이터가 없습니다.");
						}
						
						rs.close();
						stmt.close();
						break;
				}
			
			} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
			
			System.out.println("프로그램을 종료합니다.");
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
