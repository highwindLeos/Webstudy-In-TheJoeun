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

import com.leo.dto.GameDto;

public class GameDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;

	private GameDao(){ }
	
	public static GameDao instance = new GameDao();
	
	public static GameDao getInstance() {
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
	
	public ArrayList<GameDto> getGameList(int startRow, int endRow){ // 게시판 리스트 페이징
		ArrayList<GameDto> gdtos = new ArrayList<GameDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT RN, GID, GNAME, GIMAGE, GDES, GPUB, GRDATE, GGRADE, GVOTECNT, GGNO, GRNAME, LOWPOINT, HIPOINT FROM " + 
					 "    (SELECT ROWNUM RN, A.* FROM " + 
					 "    (SELECT GID, GNAME, GIMAGE, GDES, GPUB, GRDATE, GGRADE, GVOTECNT, GA.GGNO, GRNAME, LOWPOINT, HIPOINT " + 
					 "        FROM GAME GA, GGRADE R " + 
					 "        WHERE GGRADE BETWEEN R.LOWPOINT AND R.HIPOINT ORDER BY GRDATE DESC) A) " + 
					 "WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					 String gId = rs.getString("GID");
					 String gName = rs.getString("GNAME");
					 String gImage = rs.getString("GIMAGE");
					 String gDes = rs.getString("GDES");
					 String gPub = rs.getString("GPUB");
					 Date gRdate = rs.getDate("GRDATE");
					 int gGrade = rs.getInt("GGRADE");
					 int gVoteCnt = rs.getInt("GVOTECNT");
					 int gGno = rs.getInt("GGNO");
					 String gRname = rs.getString("GRNAME");
					 int lowPoint = rs.getInt("LOWPOINT");
					 int hiPoint = rs.getInt("HIPOINT");

					 gdtos.add(new GameDto(gId, gName, gImage, gDes, gPub, gRdate, gGrade, gVoteCnt, gGno, gRname, lowPoint, hiPoint));
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
		
		return gdtos;
	}
	
	public ArrayList<GameDto> getGameListNewEightRows(){ // 게임 리스트 최신글 8개
		ArrayList<GameDto> gdtos = new ArrayList<GameDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT RN, GID, GNAME, GIMAGE, GDES, GPUB, GRDATE, GGRADE, GVOTECNT, GGNO, GRNAME, LOWPOINT, HIPOINT FROM " + 
					 "    (SELECT ROWNUM RN, A.* FROM " + 
					 "    (SELECT GID, GNAME, GIMAGE, GDES, GPUB, GRDATE, GGRADE, GVOTECNT, GA.GGNO, GRNAME, LOWPOINT, HIPOINT " + 
					 "        FROM GAME GA, GGRADE R " + 
					 "        WHERE GGRADE BETWEEN R.LOWPOINT AND R.HIPOINT) A) " + 
					 "WHERE RN BETWEEN 1 AND 8";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					 String gId = rs.getString("GID");
					 String gName = rs.getString("GNAME");
					 String gImage = rs.getString("GIMAGE");
					 String gDes = rs.getString("GDES");
					 String gPub = rs.getString("GPUB");
					 Date gRdate = rs.getDate("GRDATE");
					 int gGrade = rs.getInt("GGRADE");
					 int gVoteCnt = rs.getInt("GVOTECNT");
					 int gGno = rs.getInt("GGNO");
					 String gRname = rs.getString("GRNAME");
					 int lowPoint = rs.getInt("LOWPOINT");
					 int hiPoint = rs.getInt("HIPOINT");

					 gdtos.add(new GameDto(gId, gName, gImage, gDes, gPub, gRdate, gGrade, gVoteCnt, gGno, gRname, lowPoint, hiPoint));
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
		
		return gdtos;
	}
	
	public ArrayList<GameDto> getGameListSearch(String gName, String gPub, String gDes){ // 게임 일반 검색 3개 필드 기준
		ArrayList<GameDto> gdtos = new ArrayList<GameDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT GID, GNAME, GIMAGE, GDES, GPUB, GRDATE, GGRADE, GVOTECNT, GA.GGNO, GRNAME, LOWPOINT, HIPOINT, " + 
					 "TRUNC((NVL(GGRADE / DECODE(GVOTECNT, 0, null, GVOTECNT), 0) * 10) / 10, 2) GRADEAVG " + 
					 "FROM GAME GA, GGRADE R " + 
					 "WHERE " + 
					 "GGRADE BETWEEN R.LOWPOINT AND R.HIPOINT " + 
					 "AND UPPER(GNAME) LIKE '%'||?||'%' " + 
					 "AND UPPER(GPUB) LIKE '%'||?||'%' " + 
					 "AND UPPER(GDES) LIKE '%'||?||'%' " + 
					 "ORDER BY GRDATE DESC";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gName);
			pstmt.setString(2, gPub);
			pstmt.setString(3, gDes);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					 String gId = rs.getString("GID");
					 gName = rs.getString("GNAME");
					 String gImage = rs.getString("GIMAGE");
					 gDes = rs.getString("GDES");
					 gPub = rs.getString("GPUB");
					 Date gRdate = rs.getDate("GRDATE");
					 int gGrade = rs.getInt("GGRADE");
					 int gVoteCnt = rs.getInt("GVOTECNT");
					 int gGno = rs.getInt("GGNO");
					 String gRname = rs.getString("GRNAME");
					 int lowPoint = rs.getInt("LOWPOINT");
					 int hiPoint = rs.getInt("HIPOINT");
					 double gradeAvg = rs.getInt("GRADEAVG");

					 gdtos.add(new GameDto(gId, gName, gImage, gDes, gPub, gRdate, gGrade, gVoteCnt, gGno, gRname, lowPoint, hiPoint, gradeAvg));
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
		
		return gdtos;
	}
	
	public ArrayList<GameDto> getGameListDetailSearch(String gName, String gPub, String gDes, int gGno, int gGrade, String gId){ // 게임 상세 검색 6개 필드 기준
		ArrayList<GameDto> gdtos = new ArrayList<GameDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT GID, GNAME, GIMAGE, GDES, GPUB, GRDATE, GGRADE, GVOTECNT, GA.GGNO, GRNAME, LOWPOINT, HIPOINT, " + 
					" TRUNC((NVL(GGRADE / DECODE(GVOTECNT, 0, null, GVOTECNT), 0) * 10) / 10, 2) GRADEAVG " + 
					" FROM GAME GA, GGRADE R " + 
					"	        WHERE " + 
					"	        GGRADE BETWEEN R.LOWPOINT AND R.HIPOINT " + 
					"	        AND UPPER(GNAME) LIKE '%'||?||'%' " + 
					"	        AND UPPER(GPUB)  LIKE '%'||?||'%' " + 
					"	        AND UPPER(GDES) LIKE '%'||?||'%' " + 
					"	        AND GA.GGNO = ? " + 
					"	        AND TRUNC((NVL(GGRADE / DECODE(GVOTECNT, 0, null, GVOTECNT), 0) * 10) / 10, 2) >= ? " + 
					"	        AND UPPER(GID) LIKE ?||'%' " + 
					" ORDER BY GRDATE DESC";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gName);
			pstmt.setString(2, gPub);
			pstmt.setString(3, gDes);
			pstmt.setInt(4, gGno);
			pstmt.setInt(5, gGrade);
			pstmt.setString(6, gId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					 gId = rs.getString("GID");
					 gName = rs.getString("GNAME");
					 String gImage = rs.getString("GIMAGE");
					 gDes = rs.getString("GDES");
					 gPub = rs.getString("GPUB");
					 Date gRdate = rs.getDate("GRDATE");
					 gGrade = rs.getInt("GGRADE");
					 int gVoteCnt = rs.getInt("GVOTECNT");
					 gGno = rs.getInt("GGNO");
					 String gRname = rs.getString("GRNAME");
					 int lowPoint = rs.getInt("LOWPOINT");
					 int hiPoint = rs.getInt("HIPOINT");
					 double gradeAvg = rs.getInt("GRADEAVG");

					 gdtos.add(new GameDto(gId, gName, gImage, gDes, gPub, gRdate, gGrade, gVoteCnt, gGno, gRname, lowPoint, hiPoint, gradeAvg));
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
		
		return gdtos;
	}
	
	public int getGameCnt() { // 게임의 갯수를 구한다.
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) FROM GAME"; 
		
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
	
	
	
	public int writeGame(GameDto dto) { //게임등록 쓰기
		int result = FAIL;
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String insertSql = "INSERT INTO GAME (gId, gName, gImage, gDes, gPub, gRdate, gGrade, gVoteCnt, gGno) " + 
						   "VALUES (?||GAME_SEQ.NEXTVAL, ?, ?, ?, ?, ?, 0, 0, 1)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(insertSql);		
			
			pstmt.setString(1, dto.getgIdTag());
			pstmt.setString(2, dto.getgName());
			pstmt.setString(3, dto.getgImage());
			pstmt.setString(4, dto.getgDes());
			pstmt.setString(5, dto.getgPub());
			pstmt.setDate(6, dto.getgRdate());
			
			int temp = pstmt.executeUpdate();
			
			if(temp > 0) {
				System.out.println("게임 등록 성공");
				result = SUCCESS;
			} else {
				System.out.println("게임 등록 실패");
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
	
	public GameDto gameContentView(String gId) {
		GameDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT GID, GNAME, GIMAGE, GDES, GPUB, GRDATE, GGRADE, GVOTECNT, GA.GGNO, GRNAME, LOWPOINT, HIPOINT, "
				  + " TRUNC((NVL(GGRADE / DECODE(GVOTECNT, 0, null, GVOTECNT), 0) * 10) / 10, 2) GRADEAVG " + 
					" FROM GAME GA, GGRADE R " + 
					" WHERE " + 
					" GGRADE BETWEEN R.LOWPOINT AND R.HIPOINT AND gId LIKE ? " + 
					"ORDER BY GRDATE DESC";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
							
				 gId = rs.getString("GID");
				 String gName = rs.getString("GNAME");
				 String gImage = rs.getString("GIMAGE");
				 String gDes = rs.getString("GDES");
				 String gPub = rs.getString("GPUB");
				 Date gRdate = rs.getDate("GRDATE");
				 int gGrade = rs.getInt("GGRADE");
				 int gVoteCnt = rs.getInt("GVOTECNT");
				 int gGno = rs.getInt("GGNO");
				 String gRname = rs.getString("GRNAME");
				 int lowPoint = rs.getInt("LOWPOINT");
				 int hiPoint = rs.getInt("HIPOINT");
				 double gradeAvg = rs.getDouble("GRADEAVG");
				 
				 dto = new GameDto(gId, gName, gImage, gDes, gPub, gRdate, gGrade, gVoteCnt, gGno, gRname, lowPoint, hiPoint, gradeAvg);
				System.out.println("게임상세보기 정보 성공");
			} else {
				System.out.println("게임상세보기 정보 실패");
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
	
	public int modifyGame(String gName, String gImage, String gDes, String gPub, Date gRdate, String gId) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE GAME SET " + 
					 "            gName = ?, " + 
					 "            gImage = ?, " + 
					 "            gDes = ?, " + 
					 "            gPub = ?, " + 
					 "            gRdate = ? " + 
					 "WHERE gId = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gName);
			pstmt.setString(2, gImage);
			pstmt.setString(3, gDes);
			pstmt.setString(4, gPub);
			pstmt.setDate(5, gRdate);
			
			pstmt.setString(6, gId);
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("게임 정보 수정 성공");
				result = SUCCESS;
			} else {
				System.out.println("게임 정보 수정 실패");
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
	public int modifyGame(GameDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE GAME SET " + 
					 "            gId = ?, " + 
					 "            gName = ?, " + 
					 "            gImage = ?, " + 
					 "            gDes = ?, " + 
					 "            gPub = ?, " + 
					 "            gRdate = ? " + 
					 "WHERE gId = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getgIdTag() + dto.getgId());
			pstmt.setString(2, dto.getgName());
			pstmt.setString(3, dto.getgImage());
			pstmt.setString(4, dto.getgDes());
			pstmt.setString(5, dto.getgPub());
			pstmt.setDate(6, dto.getgRdate());
			
			pstmt.setString(7, dto.getgId());
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("게임 정보 수정 성공");
				result = SUCCESS;
			} else {
				System.out.println("게임 정보 수정 실패");
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

	//글 삭제int deleteGame(bId)
	public int deleteGame(String gId) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM GAME WHERE GID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, gId);

			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("게임 삭제 성공");
				result = SUCCESS;
			} else {
				System.out.println("게임 삭제 실패");
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
	
	public int gameVote (int gGrade, String gId) { // 게임 투표 기능 쿼리
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE GAME SET GGRADE = GGRADE + ?, GVOTECNT = GVOTECNT + 1 " + 
					 "WHERE GID = ?";
		
		String sqlGradeModify = "UPDATE GAME SET Ggno = (SELECT R.GGNO FROM GAME G, GGRADE R " + 
								" WHERE GGRADE BETWEEN R.LOWPOINT AND R.HIPOINT AND GID LIKE '%'||?) " + 
								" WHERE GID LIKE '%'||?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, gGrade);
			pstmt.setString(2, gId);

			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("투표 하기 성공");
				result = SUCCESS;
			} else {
				System.out.println("투표 하기 실패");
				result = FAIL;
			}
			
			pstmt.close(); // 다른 쿼리를 실행하기위해 일단 닫는다.
			pstmt = conn.prepareStatement(sqlGradeModify);
			
			pstmt.setString(1, gId);
			pstmt.setString(2, gId);
			
			temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("등업하기 성공");
				result = SUCCESS;
			} else {				
				System.out.println("등업하기 실패");
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
