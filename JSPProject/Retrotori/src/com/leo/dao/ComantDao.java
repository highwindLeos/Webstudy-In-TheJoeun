package com.leo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.leo.dto.ComantDto;

public class ComantDao {
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private ComantDao() {}
	
	public static ComantDao instance = new ComantDao();
	
	public static ComantDao getInstance() {
		return instance;
	}
	
	private Connection getConnetion () throws SQLException {
		Connection conn = null;
		
		try {
			Context ctx = new  InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();					
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public ArrayList<ComantDto> getComantForGameId(String gId) {
		ArrayList<ComantDto> cDtos = new ArrayList<ComantDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM COMANT WHERE GID = ? ORDER BY CNUM DESC";
		
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					int cNum = rs.getInt("CNUM");
					gId = rs.getString("GID");
					String mId = rs.getString("MID");
					String comant = rs.getString("COMANT");
					
					cDtos.add(new ComantDto(cNum, gId, mId, comant));					
				} while (rs.next());
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
				
		return cDtos;
	}
	
	public ArrayList<ComantDto> getComantNewListMemberId(String mId) {
		ArrayList<ComantDto> cDtos = new ArrayList<ComantDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM " + 
					 " (SELECT ROWNUM RN, A.* FROM (SELECT * FROM COMANT ORDER BY CNUM DESC) A) " + 
					 " WHERE RN BETWEEN 1 AND 5 AND MID = ?";
		
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					int cNum = rs.getInt("CNUM");
					String gId = rs.getString("GID");
					mId = rs.getString("MID");
					String comant = rs.getString("COMANT");
					
					cDtos.add(new ComantDto(cNum, gId, mId, comant));					
				} while (rs.next());
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
				
		return cDtos;
	}
	
	private int memberPointUp5Point(String mId) {
		int result = FAIL;
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBER SET MPOINT = MPOINT + 5 WHERE MID = ?";
		
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mId);

			result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("포인트 5점 올리기 성공");
				result = SUCCESS;
			} else {
				System.out.println("포인트 5점 올리기 실패");
				result = FAIL;
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
	
	public int insertComant(String gId, String mId, String comant) { //코멘트 입력
		int result = FAIL;
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO COMANT (CNUM, GID, MID, COMANT) " + 
					 "VALUES (COMANT_SEQ.NEXTVAL, ?, ?, ?)";
		
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gId);
			pstmt.setString(2, mId);
			pstmt.setString(3, comant);
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("코멘트 입력 성공");
				result = SUCCESS;
				memberPointUp5Point(mId);
			} else {
				System.out.println("코멘트 입력 실패");
				result = FAIL;
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
	
	public int deleteComant(int cNum) { //코멘트 삭제
		int result = FAIL;
		
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM COMANT WHERE CNUM = ?";
		
		try {
			conn = getConnetion();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cNum);
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("코멘트 삭제 성공");
				result = SUCCESS;
			} else {
				System.out.println("코멘트삭제 실패");
				result = FAIL;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
		
		return result; 
	}

}
