package com.leo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.leo.dto.AdminDto;

public class AdminDao {
	
	public static final int ADMIN_EXISTENT = 1; 
	public static final int ADMIN_NONEEXISTENT = 0; 
	
	public static final int FAIL = 0; // 실패 값
	public static final int SUCCESS = 1; // 성공 값
	// 로그인에 쓰이는 상수
	public static final int LOGIN_FAIL_ID = -1; 
	public static final int LOGIN_FAIL_PW = 0; 
	public static final int LOGIN_SUCCESS = 1; 
	
	
	private DataSource ds;
	
	public AdminDao () {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	} // 생성자에서 ConnectionPool 을 이용
	
	public ArrayList<AdminDto> getListAdmin() { // 관리자 리스트 가져오기
		ArrayList<AdminDto> dtos = new ArrayList<AdminDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM ADMIN";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					
				int aNum = rs.getInt("ANUM");
				String aId = rs.getString("AID");
				String aPw = rs.getString("APW");
				String aName = rs.getString("ANAME");
				
				dtos.add(new AdminDto(aNum, aId, aPw, aName));
				}while(rs.next());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
		
		return dtos;
	}
	
	
	public int confirmId(String aId) {
		int result = ADMIN_EXISTENT;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM ADMIN WHERE AID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("중복회원 있음");
				result = ADMIN_EXISTENT;
			} else {
				System.out.println("중복 회원 없음");
				result = ADMIN_NONEEXISTENT;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
		
		return result;
	}
	
	// 멤버 가입
	public int insertAdmin(AdminDto dto) {
		int result = FAIL;
		// DTO 
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO ADMIN (ANUM, AID, APW, ANAME) " + 
					 "VALUES (ADMIN_SEQ.NEXTVAL, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getaId());
			pstmt.setString(2, dto.getaPw());
			pstmt.setString(3, dto.getaName());

			
			result = pstmt.executeUpdate();
			
			if (result > 0) { // 가입성공
				System.out.println("관리자 가입성공");
				result = SUCCESS;
			} else { // 가입실패
				System.out.println("관리자 가입실패");
				result = FAIL;
			}
			
		} catch (Exception e) {
			System.out.println( e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		} 
	
		return result;
	}
	
	// 로그인 체크 기능
	public int adminLoginCheck(String aId, String aPw) {
		int result = LOGIN_FAIL_ID;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM ADMIN WHERE AID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, aId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("로그인체크");
				String databasePw = rs.getString("apw");
				
				if (databasePw.equals(aPw)) { // DB의 패스와 입력 패스가 같으면 로그인 성공				
					System.out.println("로그인 성공");
					result = LOGIN_SUCCESS;
				} else { 
					System.out.println("로그인 실패 : 패스워드 틀림");
					result = LOGIN_FAIL_PW;
				}
				
			} else { 
				System.out.println("로그인 실패 : 아이디 틀림");
				result = LOGIN_FAIL_ID;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		} 
		
		return result;
	} 
	
	// 특정 관리자 정보 가져오기
	public AdminDto getAdmin(String aId) {
		
		AdminDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM ADMIN WHERE AID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, aId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				int aNum = rs.getInt("anum");
				aId = rs.getString("aid");
				String aPw = rs.getString("apw");
				String aName = rs.getString("aname");
				
				
				dto = new AdminDto(aNum, aId, aPw, aName);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
	
		return dto;
	}
	
	// 관리자 계정 정보 수정
	public int modifyAdmin(AdminDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE ADMIN SET " + 
				"            APW = ?, " + 
				"            ANAME = ? " + 
				"WHERE AID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getaPw());
			pstmt.setString(2, dto.getaName());

			pstmt.setString(3, dto.getaId());
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("회원 수정 성공");
				result = SUCCESS;
			} else {
				System.out.println("회원 수정 실패");
				result =  FAIL;				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		} 
		
		return result;
	}
	
	// 회원 삭제 
	public int deleteAdmin(String aId, String aPw) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM ADMIN WHERE AID = ? AND APW = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, aId);
			pstmt.setString(2, aPw);

			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("회원 탈퇴 성공");
				result = SUCCESS;
			} else {
				System.out.println("회원 탈퇴 실패");
				result =  FAIL;				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		} 
		
		return result;
	}
	// 회원 수 구하기
	public int getAdminCnt() {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) FROM ADMIN";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
		
		return result;
	}

}
