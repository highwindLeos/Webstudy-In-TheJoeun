package com.tj.mvcmember.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.mvcmember.dto.AdminDto;
import com.tj.mvcmember.dto.MemberDto;

public class AdminDao {
	
	public static final int MEMBER_EXISTENT = 1; 
	public static final int MEMBER_NONEEXISTENT = 0; 
	
	public static final int FAIL = 0; 
	public static final int SUCCESS = 1; 
	//
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
	} // Ŀ�ؼ� Ǯ
	
	public ArrayList<MemberDto> getListAdmin() {
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MVC_MEMBER ORDER BY MRDATE";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					
				String mId = rs.getString("mid");
				String mPw = rs.getString("mpw");
				String mName = rs.getString("mname");
				String mEmail = rs.getString("memail");
				String mPhoto = rs.getString("mphoto");
				Date mBirth = rs.getDate("mbirth");
				String mAddress = rs.getString("maddress");
				Timestamp mRdate = rs.getTimestamp("mrdate");
				
				dtos.add(new MemberDto(mId, mPw, mName, mEmail, mPhoto, mBirth, mAddress, mRdate));
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
	
	
	public int confirmId (String aId) {
		int result = MEMBER_EXISTENT;
		
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
				System.out.println("중복 아이디 존재");
				result = MEMBER_EXISTENT;
			} else {
				System.out.println("중복 아이디 없음");
				result = MEMBER_NONEEXISTENT;
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
	
	// 멤버 
	public int insertAdmin(AdminDto dto) {
		int result = FAIL;
		// DTO 
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO ADMIN (AID, APW, ANAME) " + 
					 " VALUES (?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getaId());
			pstmt.setString(2, dto.getaPw());
			pstmt.setString(3, dto.getaName());

			result = pstmt.executeUpdate();
			
			if (result > 0) { // 
				System.out.println("관리자 가입 성공");
				result = SUCCESS;
			} else { // 
				System.out.println("관리자 가입 실패");
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
	
	// 로그인 체크
	public int loginCheck(String aId, String aPw) {
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
				System.out.println("");
				String databasePw = rs.getString("apw");
				
				if (databasePw.equals(aPw)) { // DB			
					System.out.println("로그인 성공");
					result = LOGIN_SUCCESS;
				} else { 
					System.out.println("패스워드 틀림");
					result = LOGIN_FAIL_PW;
				}
				
			} else { 
				System.out.println("아이디 틀림");
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
	
	//
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
				String aPw = rs.getString("aPw");
				String aName = rs.getString("aName");
				
				
				dto = new AdminDto(aId, aPw, aName);
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
	
	// 
	public int modifyAdmin(AdminDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE ADMIN SET " + 
				"            APW  = ?, " + 
				"            ANAME = ?" + 
				"WHERE AID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getaPw());
			pstmt.setString(2, dto.getaName());
			
			pstmt.setString(3, dto.getaId());

			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("관리자 정보 수정 성공");
				result = SUCCESS;
			} else {
				System.out.println("관리자 정보 수정 실패");
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
	
	// ������ ����
	public int deleteAdmin(String aId) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM ADMIN WHERE AID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, aId);

			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("관리자 삭제 성공");
				result = SUCCESS;
			} else {
				System.out.println("관리자 삭제 실패");
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
