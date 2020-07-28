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

import com.leo.dto.MemberDto;

public class MemberDao {
	
	public static final int MEMBER_EXISTENT = 1; 
	public static final int MEMBER_NONEEXISTENT = 0; 
	
	public static final int FAIL = 0; // 실패 값
	public static final int SUCCESS = 1; // 성공 값
	// 로그인에 쓰이는 상수
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
	} // 생성자에서 ConnectionPool 을 이용
	
	public ArrayList<MemberDto> getListMember() { // 회원 리스트 가져오기
		ArrayList<MemberDto> dtos = new ArrayList<MemberDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MEMBER ORDER BY MRDATE";
		
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
				String mTel = rs.getString("mTel");
				String mGender = rs.getString("mGender");
				String mAddr = rs.getString("mAddr");
				String mText = rs.getString("mText");
				Timestamp mBirth = rs.getTimestamp("mbirth");
				Timestamp mRdate = rs.getTimestamp("mrdate");
				int mPoint = rs.getInt("mpoint");
				
				dtos.add(new MemberDto(mId, mPw, mName, mEmail, mPhoto, mTel, mGender, mAddr, mText, mBirth, mRdate, mPoint));
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
		
		String sql = "SELECT * FROM MEMBER WHERE MID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("중복회원 있음");
				result = MEMBER_EXISTENT;
			} else {
				System.out.println("중복 회원 없음");
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
	
	// 멤버 가입
	public int insertMember(MemberDto dto) {
		int result = FAIL;
		// DTO 
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MTEL, MGENDER, MADDR, MTEXT, MBIRTH) " + 
				     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getmId());
			pstmt.setString(2, dto.getmPw());
			pstmt.setString(3, dto.getmName());
			pstmt.setString(4, dto.getmEmail());
			pstmt.setString(5, dto.getmPhoto());
			pstmt.setString(6, dto.getmTel());
			pstmt.setString(7, dto.getmGender());
			pstmt.setString(8, dto.getmAddr());
			pstmt.setString(9, dto.getmText());
			pstmt.setTimestamp(10, dto.getmBirth());
			
			result = pstmt.executeUpdate();
			
			if (result > 0) { // 가입성공
				System.out.println("가입성공");
				result = SUCCESS;
			} else { // 가입실패
				System.out.println("가입실패");
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
	public int loginCheck(String mId, String mPw) {
		int result = LOGIN_FAIL_ID;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MEMBER WHERE MID = ?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("로그인체크");
				String databasePw = rs.getString("mpw");
				
				if (databasePw.equals(mPw)) { // DB의 패스와 입력 패스가 같으면 로그인 성공				
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
	
	// 특정 멤버 가져오기
	public MemberDto getMember(String mId) {
		MemberDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MEMBER WHERE MID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				mId = rs.getString("mid");
				String mPw = rs.getString("mpw");
				String mName = rs.getString("mname");
				String mEmail = rs.getString("memail");
				String mPhoto = rs.getString("mphoto");
				String mTel = rs.getString("mTel");
				String mGender = rs.getString("mGender");
				String mAddr = rs.getString("mAddr");
				String mText = rs.getString("mText");
				Timestamp mBirth = rs.getTimestamp("mbirth");
				Timestamp mRdate = rs.getTimestamp("mrdate");
				int mPoint = rs.getInt("mpoint");
				
				dto = new MemberDto(mId, mPw, mName, mEmail, mPhoto, mTel, mGender, mAddr, mText, mBirth, mRdate, mPoint);
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
	
	// 회원 수정
	public int modifyMember(MemberDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBER SET " + 
				"        mPW = ?," + 
				"        mName = ?, " + 
				"        mPhoto = ?, " + 
				"        mTel = ?, " + 
				"        mGender = ?, " + 
				"        mAddr = ?, " + 
				"        mText = ?, " + 
				"        mBirth = ? " + 
				" WHERE MID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getmPw());
			pstmt.setString(2, dto.getmName());
			pstmt.setString(3, dto.getmPhoto());
			pstmt.setString(4, dto.getmEmail());
			pstmt.setString(5, dto.getmGender());
			pstmt.setString(6, dto.getmAddr());
			pstmt.setString(7, dto.getmText());
			pstmt.setTimestamp(8, dto.getmBirth());
			
			pstmt.setString(9, dto.getmId());
			
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
	public int deleteMember(String mId, String mPw) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE MID = ? AND MPW = ?";
		
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
	// 회원 수 구하기
	public int getMemberCnt() {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) FROM MEMBER";
		
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
