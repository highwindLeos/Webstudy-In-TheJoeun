package com.tj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tj.dto.MemberDto;

public class MemberDao_prePool {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";

	private String uid = "leos";
	private String upw = "Stonker26";

	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private static MemberDao_prePool INSTANCE = null;

	private MemberDao_prePool() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	} // 싱글톤을 위해서 이 클래스에서만 사용하도록 private 한다.

	public static MemberDao_prePool getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MemberDao_prePool();
		}

		return INSTANCE;
	} // 생성자 객체를 반환하는 함수를 만들어놓는다.

	public ArrayList<MemberDto> memberSelectAll() {
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		// 데이터 베이스로 부터 SELECT * FROM MEMBER 수행 결과를 dtos 에 넣는다.
		String sql = "SELECT * FROM MEMBER";

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				do {
					MemberDto dto = new MemberDto();
					dto.setId(rs.getString("id"));
					dto.setPw(rs.getString("pw"));
					dto.setName(rs.getString("name"));
					dto.setPhone1(rs.getString("phone1"));
					dto.setPhone2(rs.getString("phone2"));
					dto.setPhone3(rs.getString("phone3"));
					dto.setGender(rs.getString("gender"));
					System.out.println(dto.toString());
					dtos.add(dto);

					/*
					 * String id = rs.getString("id"); String pw = rs.getString("pw"); String name =
					 * rs.getString("name"); String phone1 = rs.getString("phone1"); String phone2 =
					 * rs.getString("phone2"); String phone3 = rs.getString("phone3"); String gender
					 * = rs.getString("gender"); // 모든 값을 반복해서 dtos 에 넣는다. dtos.add(new
					 * MemberDto(id, pw, name, phone1, phone2, phone3, gender));
					 */
				} while (rs.next());
			} else {
				System.out.println("데이터 베이스의 결과 값이 없습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} // close 예외 발생시.
		}

		return dtos;
	}

	public int memberInsert(MemberDto dto) {
		int result = 0;
		// 데이터 베이스로 부터 INSERT SQL 문을 수행한 결과를 result에 넣는다.

		String insertSql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, ?)";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(insertSql);

			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone1());
			pstmt.setString(5, dto.getPhone2());
			pstmt.setString(6, dto.getPhone3());
			pstmt.setString(7, dto.getGender());

			result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("회원 가입 성공 : Member Table Insert 완료");
				System.out.println(dto.toString());

			} else {
				System.out.println("회원 가입 실패 : Member Table Insert 실패");
			}

		} catch (Exception e) {
			System.out.println("회원 가입 실패 : 예외" + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {}
		}
		return result;
	}

}