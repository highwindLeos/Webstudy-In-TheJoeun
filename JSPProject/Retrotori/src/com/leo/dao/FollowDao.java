package com.leo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.leo.dto.FollowDto;

public class FollowDao {
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;

	private FollowDao(){ }
	
	public static FollowDao instance = new FollowDao();
	
	public static FollowDao getInstance() {
		return instance;
	}
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public ArrayList<FollowDto> getFollowList(String mId) { // 내가 팔로우 하는 사람 가져오기
		ArrayList<FollowDto> fdtos = new ArrayList<FollowDto>();
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT FNUM, F.MID, FID, MNAME, MPHOTO FROM FOLLOW F, MEMBER M WHERE F.FID = M.MID AND F.MID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					int fNum = rs.getInt("FNUM");
					String fId = rs.getString("FID");
					String mName = rs.getString("MNAME");
					String mPhoto = rs.getString("MPHOTO");
					
					fdtos.add(new FollowDto(fNum, mId, fId, mName, mPhoto));
				} while(rs.next());
				System.out.println("Follow 리스트 가져오기 성공");
			} else {
				System.out.println("Follow 리스트 가져오기 실패");
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
				
		return fdtos;
	}
	
	public ArrayList<FollowDto> getFollowerList(String fId) { //나를 팔로우 하는 팔로워 가져오기
		ArrayList<FollowDto> fdtos = new ArrayList<FollowDto>();
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT FNUM, F.MID, FID, MNAME, MPHOTO FROM FOLLOW F, MEMBER M WHERE F.MID = M.MID AND FID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					int fNum = rs.getInt("FNUM");
					String mId = rs.getString("MID");
					String mName = rs.getString("MNAME");
					String mPhoto = rs.getString("MPHOTO");
					
					fdtos.add(new FollowDto(fNum, mId, fId, mName, mPhoto));
				} while(rs.next());
				System.out.println("Follower 리스트 가져오기 성공");
			} else {
				System.out.println("Follower 리스트 가져오기 실패");
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
				
		return fdtos;
	}
	
	public int getFollowCnt(String mID) { //Follow 수 구하기
		int result = 0;
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) FROM FOLLOW WHERE MID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mID);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
				System.out.println("Follow 수 구하기  성공");
			} else {
				System.out.println("Follow 수 구하기  실패");
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
	
	public int getFollowerCnt(String fId) { //Follower 수 구하기
		int result = 0;
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) FROM FOLLOW WHERE FID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
				System.out.println("Follower 수 구하기  성공");
			} else {
				System.out.println("Follower 수 구하기  실패");
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
	
	public int Follow(String mId, String fId) {
		int result = FAIL;
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO FOLLOW (FNUM, MID, FID) VALUES (FOLLOW_SEQ.NEXTVAL, ?, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mId);
			pstmt.setString(2, fId);
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("Follow Success");
				result = SUCCESS;
			} else {
				System.out.println("Follow Fail");
				result = FAIL;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
				
		return result;
	}
	
	public int UnFollow(String mId, String fId) {
		int result = FAIL;
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM FOLLOW WHERE MID = ? AND FID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mId);
			pstmt.setString(2, fId);
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("UnFollow Success");
				result = SUCCESS;
			} else {
				System.out.println("UnFollow Fail");
				result = FAIL;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();				
			} catch (Exception e2) {}
		} 
				
		return result;
	}
	
}
