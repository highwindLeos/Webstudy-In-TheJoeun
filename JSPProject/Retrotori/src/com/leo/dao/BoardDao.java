package com.leo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.leo.dto.BoardDto;

public class BoardDao {
	
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;

	private BoardDao(){ }
	
	public static BoardDao instance = new BoardDao();
	
	public static BoardDao getInstance() {
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
	
	public ArrayList<BoardDto> getBoadList(int startRow, int endRow){ // 게시판 리스트 페이징
		ArrayList<BoardDto> bdtos = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM " + 
					 "(SELECT ROWNUM RN, A.* FROM (SELECT B.*, M.MNAME, MPHOTO FROM BOARD b, MEMBER M "
				   + " WHERE M.MID = B.MID ORDER BY BREF DESC, BSTEP) A) " + 
				     " WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					 int bNum = rs.getInt("BNUM");
					 String mId = rs.getString("MID");
					 String bTitle = rs.getString("BTITLE");
					 String bContent = rs.getString("BCONTENT");
					 int bCnt = rs.getInt("BCNT");
					 String bFile1 = rs.getString("BFILE1");
					 int bRef = rs.getInt("BREF");
					 int bStep = rs.getInt("BSTEP");
					 int bLevel = rs.getInt("BLEVEL");
					 int bLike = rs.getInt("BLIKE");
					 String bIp = rs.getString("BIP");
					 Date bRdate = rs.getDate("BRDATE");
					 String mName = rs.getString("MNAME");
					 String mPhoto = rs.getString("MPHOTO");
					
					bdtos.add(new BoardDto(bNum, mId, bTitle, bContent, bCnt, bFile1, bRef, bStep, bLevel, bLike, bIp, bRdate, mName, mPhoto));
				}while (rs.next());
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
		
		return bdtos;
	}
	
	public ArrayList<BoardDto> getBoadListNewFiveRows(){ // 게시판 리스트 최신글 5개
		ArrayList<BoardDto> bdtos = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM " + 
					 "(SELECT ROWNUM RN, A.* FROM (SELECT B.*, M.MNAME, MPHOTO FROM BOARD b, MEMBER M "
				   + " WHERE M.MID = B.MID ORDER BY BREF DESC, BSTEP) A) " + 
				     " WHERE RN BETWEEN 1 AND 5";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					 int bNum = rs.getInt("BNUM");
					 String mId = rs.getString("MID");
					 String bTitle = rs.getString("BTITLE");
					 String bContent = rs.getString("BCONTENT");
					 int bCnt = rs.getInt("BCNT");
					 String bFile1 = rs.getString("BFILE1");
					 int bRef = rs.getInt("BREF");
					 int bStep = rs.getInt("BSTEP");
					 int bLevel = rs.getInt("BLEVEL");
					 int bLike = rs.getInt("BLIKE");
					 String bIp = rs.getString("BIP");
					 Date bRdate = rs.getDate("BRDATE");
					 String mName = rs.getString("MNAME");
					 String mPhoto = rs.getString("MPHOTO");
					
					bdtos.add(new BoardDto(bNum, mId, bTitle, bContent, bCnt, bFile1, bRef, bStep, bLevel, bLike, bIp, bRdate, mName, mPhoto));
				}while (rs.next());
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
		
		return bdtos;
	}
	public ArrayList<BoardDto> getBoadListNewFiveRows(String mId){ // 게시판 리스트 최신글 5개 특정멤버
		ArrayList<BoardDto> bdtos = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM " + 
					 "(SELECT ROWNUM RN, A.* FROM (SELECT B.*, M.MNAME, MPHOTO FROM BOARD b, MEMBER M "
				   + " WHERE M.MID = B.MID ORDER BY BREF DESC, BSTEP) A) " + 
				     " WHERE RN BETWEEN 1 AND 5 AND MID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					 int bNum = rs.getInt("BNUM");
					 mId = rs.getString("MID");
					 String bTitle = rs.getString("BTITLE");
					 String bContent = rs.getString("BCONTENT");
					 int bCnt = rs.getInt("BCNT");
					 String bFile1 = rs.getString("BFILE1");
					 int bRef = rs.getInt("BREF");
					 int bStep = rs.getInt("BSTEP");
					 int bLevel = rs.getInt("BLEVEL");
					 int bLike = rs.getInt("BLIKE");
					 String bIp = rs.getString("BIP");
					 Date bRdate = rs.getDate("BRDATE");
					 String mName = rs.getString("MNAME");
					 String mPhoto = rs.getString("MPHOTO");
					
					bdtos.add(new BoardDto(bNum, mId, bTitle, bContent, bCnt, bFile1, bRef, bStep, bLevel, bLike, bIp, bRdate, mName, mPhoto));
				}while (rs.next());
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
		
		return bdtos;
	}
	
	public int getBoardCnt() { // 글의 갯수를 구한다.
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) FROM BOARD"; 
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
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
	
	public int contentLikeUp(int bNum) { // 글의 좋아요를 증가 한다.
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET BLIKE = BLIKE + 1 WHERE BNUM = ?"; 
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bNum);
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("좋아요 성공");
				result = SUCCESS;
			} else {
				System.out.println("좋아요 실패");
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
	
	public int upReadBoardCnt(int bNum) { // 조회 수 증가
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET BCNT = BCNT + 1 WHERE BNUM = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bNum);
			
			result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("조회수 증가 성공");
				result = SUCCESS;
			} else {				
				System.out.println("조회수 증가 실패");
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
	
	public int writeBoard(BoardDto dto) { //원글 쓰기
		int result = FAIL;
		
		MemberPointUp(dto.getmId()); // 글쓰기 포인트
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String insertSql = "INSERT INTO BOARD (bNum, mId, bTitle, bContent, bCnt, bFile1, bRef, bStep, bLevel, bLike, bIp, bRdate) " + 
						   "VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, 0, ?, BOARD_SEQ.CURRVAL, 0, 0, 0, ?, SYSDATE)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(insertSql);		
			
			pstmt.setString(1, dto.getmId());
			pstmt.setString(2, dto.getbTitle());
			pstmt.setString(3, dto.getbContent());
			pstmt.setString(4, dto.getbFile1());
			pstmt.setString(5, dto.getbIp());
			
			int temp = pstmt.executeUpdate();
			
			if(temp > 0) {
				System.out.println("원글 입력 성공");
				MemberPointUp(dto.getmId()); // 글쓰기 포인트
				result = SUCCESS;
			} else {
				System.out.println("원글 입력 실패");
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
	
	private void preReplyAstep(int bref, int bstep) { // 답변글 쓰기전 스탭작업
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String updateSql = "UPDATE BOARD SET BSTEP = BSTEP + 1 " + 
						   "WHERE BREF = ? AND BSTEP > ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(updateSql);
			
			pstmt.setInt(1, bref);
			pstmt.setInt(2, bstep);
			
			pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
	}
	
	public int reply(String mId, String bTitle, String bContent, String bFile1, int bRef, int bStep, int bLevel, String bIp) {
		int result = FAIL;
		
		MemberPointUp(mId); // 글쓰기 포인트
		preReplyAstep(bRef, bStep); // 답변 전 A step
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO BOARD (bNum, mId, bTitle, bContent, bCnt, bFile1, bRef, bStep, bLevel, bLike, bIp, bRdate) " + 
				     "VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, 0, ?, ?, ?, ?, 0, ?, SYSDATE)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mId);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, bFile1);
			pstmt.setInt(5, bRef);
			pstmt.setInt(6, bStep + 1); // bStep +1
			pstmt.setInt(7, bLevel + 1); //bLevel +1
			pstmt.setString(8, bIp);

			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("답변 달기 성공");
				result = SUCCESS;
			} else {
				System.out.println("답변 달기 실패");
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
	
	public BoardDto boardContentView(int bNum) {
		upReadBoardCnt(bNum);// 조회수 증가
		
		BoardDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT B.*, M.MNAME, M.MPHOTO  FROM BOARD B, MEMBER M WHERE B.MID = M.MID AND BNUM = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);		
			
			pstmt.setInt(1, bNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BoardDto();
				
				dto.setbNum(bNum);
				dto.setmId(rs.getString("MID"));
				dto.setbTitle(rs.getString("BTITLE"));
				dto.setbContent(rs.getString("BCONTENT"));
				dto.setbCnt(rs.getInt("BCNT"));
				dto.setbFile1(rs.getString("BFILE1"));
				dto.setbRef(rs.getInt("BREF"));
				dto.setbStep(rs.getInt("BSTEP"));
				dto.setbLevel(rs.getInt("BLEVEL"));
				dto.setbLike(rs.getInt("BLIKE"));
				dto.setbIp(rs.getString("BIP"));
				dto.setbRdate(rs.getDate("BRDATE"));
				dto.setmName(rs.getString("MNAME"));
				dto.setmPhoto(rs.getString("MPHOTO"));
				
				System.out.println("상세보기 정보 성공");
			} else {
				System.out.println("상세보기 정보 실패");
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
	
	public int modifyBoard(int bNum, String bTitle, String bContent, String bFile1, String bIp) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE BOARD SET  " + 
				"            bTitle = ?,  " + 
				"            bContent = ?,  " + 
				"            bFile1 = ?,  " + 
				"            bIp = ?, " + 
				"            bRdate = SYSDATE " + 
				"WHERE BNUM = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bTitle);
			pstmt.setString(2, bContent);
			pstmt.setString(3, bFile1);
			pstmt.setString(4, bIp);
			
			pstmt.setInt(5, bNum);
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("수정 성공");
				result = SUCCESS;
			} else {
				System.out.println("수정 실패");
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
		
		String sql = "UPDATE BOARD SET  " + 
				"            bTitle = ?,  " + 
				"            bContent = ?,  " + 
				"            bFile1 = ?,  " + 
				"            bIp = ?,  " + 
				"            bRdate = SYSDATE " + 
				"WHERE BNUM =  ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getbTitle());
			pstmt.setString(2, dto.getbContent());
			pstmt.setString(3, dto.getbFile1());
			pstmt.setString(4, dto.getbIp());
			
			pstmt.setInt(5, dto.getbNum());
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("수정성공");
				result = SUCCESS;
			} else {
				System.out.println("수정실패");
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

	//글 삭제int deleteBoard(bId)
	public int deleteBoard(int bNum) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM BOARD WHERE BNUM = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bNum);

			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("삭제 성공");
				result = SUCCESS;
			} else {
				System.out.println("삭제 실패");
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
	
	private int MemberPointUp (String mId) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBER SET MPOINT = MPOINT + 10 WHERE MID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mId);

			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("포인트 업 성공");
				result = SUCCESS;
			} else {
				System.out.println("포인트 업 실패");
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
