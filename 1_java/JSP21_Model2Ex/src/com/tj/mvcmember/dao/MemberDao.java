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

import com.tj.mvcmember.dto.MemberDto;

public class MemberDao {
	
	public static final int MEMBER_EXISTENT = 1; 
	public static final int MEMBER_NONEEXISTENT = 0; 
	
	public static final int FAIL = 0; 
	public static final int SUCCESS = 1; 

	public static final int LOGIN_FAIL_ID = -1; 
	public static final int LOGIN_FAIL_PW = 0; 
	public static final int LOGIN_SUCCESS = 1; 
	
	private DataSource ds;
	
	public MemberDao () {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	} 
	
	public ArrayList<MemberDto> getListMember() {
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
	
	public ArrayList<MemberDto> getListMember(int startRowm, int endRow) {
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM " + 
					 "(SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE) A) " + 
					 "WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);	
			
			pstmt.setInt(1, startRowm);
			pstmt.setInt(2, endRow);
			
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
	
	public int confirmId (String mId) {
		int result = MEMBER_EXISTENT;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("회원있음");
				result = MEMBER_EXISTENT;
			} else {
				System.out.println("회원없음");
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
	
	public int insertMember(MemberDto dto) {
		int result = FAIL;
		// DTO 
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE) " + 
					 " VALUES ( ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getmId());
			pstmt.setString(2, dto.getmPw());
			pstmt.setString(3, dto.getmName());
			pstmt.setString(4, dto.getmEmail());
			pstmt.setString(5, dto.getmPhoto());
			pstmt.setDate(6, dto.getmBirth());
			pstmt.setString(7, dto.getmAddress());
			
			result = pstmt.executeUpdate();
			
			if (result > 0) { 
				System.out.println("회원가입 성공");
				result = SUCCESS;
			} else { 
				System.out.println("회원가입 실패");
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
	
	// 로그인 기능
	public int loginCheck(String mId, String mPw) {
		int result = LOGIN_FAIL_ID;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("");
				String databasePw = rs.getString("mpw");
				
				if (databasePw.equals(mPw)) { //		
					System.out.println("로그인성공");
					result = LOGIN_SUCCESS;
				} else { 
					System.out.println("로그인실패 : 패스워드 틀림");
					result = LOGIN_FAIL_PW;
				}
				
			} else { 
				System.out.println("로그인실패 : 아이디 틀림");
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
	
	// �듅�젙 硫ㅻ쾭 媛��졇�삤湲�
	public MemberDto getMember(String mId) {
		MemberDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MVC_MEMBER WHERE MID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String mPw = rs.getString("mpw");
				String mName = rs.getString("mname");
				String mEmail = rs.getString("memail");
				String mPhoto = rs.getString("mphoto");
				Date mBirth = rs.getDate("mbirth");
				String mAddress = rs.getString("maddress");
				Timestamp mRdate = rs.getTimestamp("mrdate");
				
				dto = new MemberDto(mId, mPw, mName, mEmail, mPhoto, mBirth, mAddress, mRdate);
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
	
	// 수정기능
	public int modifyMember(MemberDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MVC_MEMBER SET " + 
				"            MPW = ?, " + 
				"            MNAME = ?, " + 
				"            MEMAIL = ?, " + 
				"            MPHOTO = ?, " + 
				"            MBIRTH = ?, " + 
				"            MADDRESS = ? " + 
				"	WHERE MID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getmPw());
			pstmt.setString(2, dto.getmName());
			pstmt.setString(3, dto.getmEmail());
			pstmt.setString(4, dto.getmPhoto());
			pstmt.setDate(5, dto.getmBirth());
			pstmt.setString(6, dto.getmAddress());
			
			pstmt.setString(7, dto.getmId());
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("수정 성공");
				result = SUCCESS;
			} else {
				System.out.println("수정 실패");
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
	public int deleteMember(String mId, String mPw) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MVC_MEMBER WHERE MID = ? AND MPW = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mId);
			pstmt.setString(2, mPw);

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

	public int getMemberCnt() {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) FROM MVC_MEMBER";
		
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
