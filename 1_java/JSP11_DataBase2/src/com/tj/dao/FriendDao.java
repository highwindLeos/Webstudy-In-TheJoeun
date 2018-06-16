package com.tj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import com.tj.dto.FriendDto;

public class FriendDao {
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private DataSource datasource;
	private static FriendDao instance = null;

	private FriendDao() {
		try {
			Context context = new InitialContext();
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	} // 싱글톤을 위해서 이 클래스에서만 사용하도록 private 한다.

	public static FriendDao getInstance() {
		if (instance == null) {
			instance = new FriendDao();
		}
		return instance;
	} // 생성자 객체를 반환하는 함수를 만들어놓는다.

	public ArrayList<FriendDto> friendDaoSelectAll() {
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		// 데이터 베이스로 부터 SELECT * FROM MEMBER 수행 결과를 dtos에 넣는다.
		String sql = "SELECT * FROM FRIEND ORDER BY NO";

		try {
			conn = datasource.getConnection(); // 커넥션 풀에서 데이터 베이스 연결 객체를 가져온다.
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				do {
					FriendDto dto = new FriendDto();
					dto.setNo(rs.getInt("no"));
					dto.setFname(rs.getString("fname"));
					dto.setTel(rs.getString("tel"));
				
					System.out.println(dto.toString());
					dtos.add(dto);
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
			} catch (Exception e) { } // close 예외 발생시.
		}

		return dtos;
	} // select All 
	
	public ArrayList<FriendDto> friendDaoSelectAll(String fname, String tel) {
		ArrayList<FriendDto> dtos = new ArrayList<FriendDto>();
		
		String sql = "SELECT * FROM FRIEND WHERE FNAME LIKE '%'||?||'%' AND TEL LIKE '%'||?||'%' ORDER BY NO";

		try {
			conn = datasource.getConnection(); // 커넥션 풀에서 데이터 베이스 연결 객체를 가져온다.
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fname);
			pstmt.setString(2, tel);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					FriendDto dto = new FriendDto();
					dto.setNo(rs.getInt("no"));
					dto.setFname(rs.getString("fname"));
					dto.setTel(rs.getString("tel"));

					System.out.println(dto.toString());
					dtos.add(dto);
					
				} while (rs.next());
			} else {
				System.out.println("데이터 베이스의 결과 값이 없습니다.");
			}
		} catch (Exception e) {
			System.out.println("friendDaoSelectAll 예외 발생 : "+ e.getMessage());
		} finally {
			try {
				if (rs != null)	rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) { } // close 예외 발생시.
		}

		return dtos;
	} // 검색기능 함수

	public int friendInsert(FriendDto dto) {
		int result = 0;
		// 데이터 베이스로 부터 INSERT SQL 문을 수행한 결과를 result에 넣는다.

		String insertSql = "INSERT INTO FRIEND VALUES(FRIEND_SEQ.NEXTVAL, ?, ?)";

		try {
			conn = datasource.getConnection();
			pstmt = conn.prepareStatement(insertSql);

			pstmt.setString(1, dto.getFname());
			pstmt.setString(2, dto.getTel());

			result = pstmt.executeUpdate();

			if (result > 0) {
				System.out.println("회원 가입 성공 : Friend Table Insert 완료");
				System.out.println(dto.toString());
			} else {
				System.out.println("회원 가입 실패 : Friend Table Insert 실패");
			}

		} catch (Exception e) {
			System.out.println("회원 가입 실패 : 예외" + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) { }
		}
		
		return result;
	} // 친구 연락처 입력.
}
