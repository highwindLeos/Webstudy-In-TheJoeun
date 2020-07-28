package com.leo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.leo.dto.NoticeDto;

public class NoticeDao {
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	
	private DataSource ds;
	
	public NoticeDao () {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
	} // 생성자에서 ConnectionPool 을 이용
	
	public int getCountNotice() { // 공지사항 리스트 가져오기 : 페이징
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) FROM NOTICE";
		
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
	
	public ArrayList<NoticeDto> getListNotice(int startRow, int endRow) { // 공지사항 리스트 가져오기 : 페이징
		ArrayList<NoticeDto> dtos = new ArrayList<NoticeDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM " + 
				"(SELECT ROWNUM RN, A.* FROM " + 
				"(SELECT * FROM NOTICE ORDER BY NRDATE DESC) A) " + 
				"WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);	
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					 int nNum = rs.getInt("NNUM");
					 String nTitle = rs.getString("NTITLE");
					 String nContent = rs.getString("NCONTENT");
					 String nAuthor = rs.getString("NAUTHOR");
					 Date nRdate = rs.getDate("NRDATE");
			
				dtos.add(new NoticeDto(nNum, nTitle, nContent, nAuthor, nRdate) );
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
	
	public ArrayList<NoticeDto> getListNoticeNewFiveRows() { // 공지사항 리스트 최신 5건
		ArrayList<NoticeDto> dtos = new ArrayList<NoticeDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM " + 
				"(SELECT ROWNUM RN, A.* FROM " + 
				"(SELECT * FROM NOTICE ORDER BY NRDATE DESC) A) " + 
				"WHERE RN BETWEEN 1 AND 5";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);		
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					 int nNum = rs.getInt("NNUM");
					 String nTitle = rs.getString("NTITLE");
					 String nContent = rs.getString("NCONTENT");
					 String nAuthor = rs.getString("NAUTHOR");
					 Date nRdate = rs.getDate("NRDATE");
			
				dtos.add(new NoticeDto(nNum, nTitle, nContent, nAuthor, nRdate) );
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
	
	public NoticeDto getNoticeOneRow(int nNum) {
		NoticeDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM NOTICE WHERE NNUM = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);	
			
			pstmt.setInt(1, nNum);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					 
					 String nTitle = rs.getString("NTITLE");
					 String nContent = rs.getString("NCONTENT");
					 String nAuthor = rs.getString("NAUTHOR");
					 Date nRdate = rs.getDate("NRDATE");
			
				 dto = new NoticeDto(nNum, nTitle, nContent, nAuthor, nRdate);
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
		
		return dto;
	}
	
	public int insertNotice(NoticeDto ndto) { // 공지사항 입력
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO NOTICE (NNUM, NTITLE, NCONTENT, NAUTHOR) " + 
				"VALUES (NOTICE_SEQ.NEXTVAL, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			System.out.println(ndto.toString());
			
			pstmt.setString(1, ndto.getnTitle());
			pstmt.setString(2, ndto.getnContent());
			pstmt.setString(3, ndto.getnAuthor());
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("공지사항 쓰기 성공");
				result = SUCCESS;
			} else {
				System.out.println("공지사항 쓰기 실패");
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
	
	public int modifyNotice(NoticeDto dto) { // 공지 사항 수정
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE NOTICE SET " + 
				"            NTITLE = ?, " + 
				"            NCONTENT = ?," + 
				"            NAUTHOR = ? " + 
				"WHERE NNUM = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getnTitle());
			pstmt.setString(2, dto.getnContent());
			pstmt.setString(3, dto.getnAuthor());
			
			pstmt.setInt(4, dto.getnNum());
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("공지사항 수정 성공");
				result = SUCCESS;
			} else {
				System.out.println("공지사항 수정 실패");
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
	
	public int deleteNotice(int nNum) { // 공지사항 삭제
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM NOTICE WHERE NNUM = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nNum);
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("공지사항 삭제 성공");
				result = SUCCESS;
			} else {
				System.out.println("공지사항 삭제 실패");
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

}
