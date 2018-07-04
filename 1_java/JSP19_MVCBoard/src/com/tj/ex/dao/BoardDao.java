package com.tj.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.sun.org.apache.bcel.internal.generic.FALOAD;
import com.tj.ex.dto.BoardDto;

public class BoardDao {
	
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	
	private DataSource ds;
	
	public BoardDao () {

		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		
	} // 생성자에서 ConnectionPool 을 이용
	

	// 글목록 출력 ArrayList<BoardDto> listBoard(startRow, endRow)
	public ArrayList<BoardDto> listBoard(int startRow, int endRow) {
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM " + 
					"(SELECT ROWNUM RN, A.* FROM (SELECT * FROM MVC_BOARD ORDER BY BGROUP DESC, BSTEP ASC) A) " + 
					"WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			if (rs.next() ) {
				do {
					BoardDto dto = new BoardDto();
					
					dto.setbId(rs.getInt("bid"));
					dto.setbName(rs.getString("bname"));
					dto.setbTitle(rs.getString("btitle"));
					dto.setbContent(rs.getString("bcontent"));
					dto.setbHit(rs.getInt("bHit"));
					dto.setbDate(rs.getTimestamp("bdate"));
					dto.setbGroup(rs.getInt("bgroup"));
					dto.setbStep(rs.getInt("bstep"));
					dto.setbIndent(rs.getInt("bindent"));
					dto.setbIp(rs.getString("bip"));

					dtos.add(dto);
				} while(rs.next());
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null || pstmt != null || conn != null ) {
					rs.close();
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return dtos;
	}
	
	// 전체 글 갯수를 반환하는 함수 int getBoardCnt()
	public int getBoardCnt() {
		int totalCnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) FROM MVC_BOARD";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("글 갯수 반환 성공");
				totalCnt = rs.getInt(1);
			} else {
				System.out.println("글 갯수 반환 실패");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null || pstmt != null || conn != null ) {
					rs.close();
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return totalCnt;
	}
	
	//원글쓰기 int writeBoard(bName, bTitle, bContent, bIp)
	public int writeBoard(String bName, String bTitle, String bContent, String bIp) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String insertSql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) " + 
					 	   " VALUES ( MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, MVC_BOARD_SEQ.CURRVAL, 0, 0, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(insertSql);		
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, bIp);
			
			int temp = pstmt.executeUpdate();
			
			if(temp > 0) {
				System.out.println("글 쓰기 성공");
				result = SUCCESS;
			} else {
				System.out.println("글 쓰기 실패");
				result = FAIL;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if( pstmt != null || conn != null ) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return result;
	}

	//원글쓰기 int writeBoard(dto)
	public int writeBoard(BoardDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String insertSql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) " + 
					 	   " VALUES ( MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, MVC_BOARD_SEQ.CURRVAL, 0, 0, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(insertSql);		
			
			pstmt.setString(1, dto.getbName());
			pstmt.setString(2, dto.getbTitle());
			pstmt.setString(3, dto.getbContent());
			pstmt.setString(4, dto.getbIp());
			
			int temp = pstmt.executeUpdate();
			
			if(temp > 0) {
				System.out.println("글 쓰기 성공");
				result = SUCCESS;
			} else {
				System.out.println("글 쓰기 실패");
				result = FAIL;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if( pstmt != null || conn != null ) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return result;
	}
	
	// 특정글 보기 : BoardDto contentView(bId)
	public BoardDto contentView(int bId) {
		upHit(bId); // 조회수를 1증가
		
		BoardDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MVC_BOARD WHERE BID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);		
			
			pstmt.setInt(1, bId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDto();
				
				dto.setbId(bId);
				dto.setbName(rs.getString("bname"));
				dto.setbTitle(rs.getString("btitle"));
				dto.setbContent(rs.getString("bcontent"));
				dto.setbDate(rs.getTimestamp("bdate"));
				dto.setbGroup(rs.getInt("bgroup"));
				dto.setbStep(rs.getInt("bstep"));
				dto.setbIndent(rs.getInt("bindent"));
				dto.setbIp(rs.getString("bip"));
				
				System.out.println("글 갯수 반환 성공");
			} else {
				System.out.println("글 갯수 반환 실패");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null || pstmt != null || conn != null ) {
					rs.close();
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
	
		return dto;
	}
	
	private void upHit(int bId) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String insertSql = "UPDATE MVC_BOARD SET BHIT = BHIT + 1 WHERE BID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(insertSql);	
			
			pstmt.setInt(1, bId);
			
			int temp = pstmt.executeUpdate();
			
			if(temp > 0) {
				System.out.println("조회수 성공");
			} else {
				System.out.println("조회수 실패");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if( pstmt != null || conn != null ) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
	}


	// 특정 글수정 (작성자 제목 본문) int modifyBoard(bId, bName, bContent)
	public int modifyBoard(int bId, String bName, String bTitle, String bContent) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MVC_BOARD SET BNAME = ?, " + 
					 "                     BTITLE = ?, " + 
					 "                     BCONTENT = ? " + 
					 "           WHERE BID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, bId);
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("글수정 성공");
				result = SUCCESS;
			} else {
				System.out.println("글수정 실패");
				result = FAIL;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null || conn != null) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return result;
	}
	public int modifyBoard(BoardDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MVC_BOARD SET BNAME = ?, " + 
					 "                     BTITLE = ?, " + 
					 "                     BCONTENT = ? " + 
					 "           WHERE BID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getbName());
			pstmt.setString(2, dto.getbTitle());
			pstmt.setString(3, dto.getbContent());
			pstmt.setInt(4, dto.getbId());
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("글수정 성공");
				result = SUCCESS;
			} else {
				System.out.println("글수정 실패");
				result = FAIL;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null || conn != null) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return result;
	}

	// 특정 글삭제 int deleteBoard(bId)
	public int deleteBoard(int bId) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MVC_BOARD WHERE BID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bId);

			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("글삭제 성공");
				result = SUCCESS;
			} else {
				System.out.println("글삭제 실패");
				result = FAIL;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null || conn != null) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return result;
	}
	
	// 답변글쓰기전 A 작업 : void replayAstep(bGroupp, bStep)
	private void replayAstep(String bGroup, String bStep) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MVC_BOARD SET  BSTEP = BSTEP + 1 " + 
					 " WHERE BGROUP = ? AND BSTEP > ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(bGroup));
			pstmt.setInt(2, Integer.parseInt(bStep));

			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("쿼리 성공");
			} else {
				System.out.println("쿼리 실패");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null || conn != null) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
	}
	// 답변글 쓰기하기전 원글의 정보를 가져오는 함수 BoardDto replyView(bid)
	public BoardDto replyView(int bId) {
		BoardDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MVC_BOARD WHERE BID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);		
			
			pstmt.setInt(1, bId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDto();
				
				dto.setbId(rs.getInt("bid"));
				dto.setbName(rs.getString("bname"));
				dto.setbTitle(rs.getString("btitle"));
				dto.setbContent(rs.getString("bcontent"));
				dto.setbDate(rs.getTimestamp("bdate"));
				dto.setbGroup(rs.getInt("bgroup"));
				dto.setbStep(rs.getInt("bstep"));
				dto.setbIndent(rs.getInt("bindent"));
				dto.setbIp(rs.getString("bip"));
				
				System.out.println("글 반환 성공");
			} else {
				System.out.println("글 반환 실패");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null || pstmt != null || conn != null ) {
					rs.close();
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
	
		return dto;		
	}
	
	// 답변글 저장 int reply(bGroup, bStep, bIndent, bName, bTitle, bContent , bIp)
		// 답변시 필요한 원글의 정보 :  bGroup, bStep, bIndent
		// 답글의 본문들 : bName, bTitle, bContent , bIp
	public int reply(String bGroup, String bStep, String bIndent, String bName, String bTitle, String bContent , String bIp) {
		
		replayAstep(bGroup, bStep); // 댓글을 쓰기전 step 과 indent 전처리
		
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MVC_BOARD (BID, BNAME, BTITLE, BCONTENT, BGROUP, BSTEP, BINDENT, BIP) " + 
					 " VALUES ( MVC_BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bGroup));
			pstmt.setInt(5, Integer.parseInt(bStep) + 1); //답변글의 bStep : 원글의 bStep +1
			pstmt.setInt(6, Integer.parseInt(bIndent) + 1); //답변글의 bIndent : 원글의 bIndent +1
			pstmt.setString(7, bIp);

			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("답변글 성공");
				result = SUCCESS;
			} else {
				System.out.println("답변글 실패");
				result = FAIL;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (pstmt != null || conn != null) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return result;
	}
	
}
