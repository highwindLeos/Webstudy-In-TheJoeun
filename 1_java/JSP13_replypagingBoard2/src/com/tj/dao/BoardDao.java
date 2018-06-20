package com.tj.dao;

// 글 갯수를 가져오는 int getBoardTotalCnt()
// 글 목록 출력할 ArrayList<DTO> listboard()
// 글 쓰기할 int insertBoard(dto)
// 글 상세보기 : 조회수 하나 올리는 void readCountUp(int num)
// 			조회수 하나 올리는 void readCountUp(String num)
// 글 내용 을 보여주는 DTO getBoardOneLine(int num) , DTO getBoardOneLine(String num)
// 글 수정 하는 기능 : int updateBoard(dto)
// 글 삭제 하는 기능 : int delectBoard(int num, String pw)
// 				int delectBoard(String num, String pw)

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

import com.tj.dto.BoardDto;

public class BoardDao {
	
	public static final int FAIL = 0; //실패
	public static final int SUCCSESS = 1; //성공
		
	private static BoardDao instance;
	
	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	
	private BoardDao() {}
	
	private Connection getConnnection() throws SQLException {
		Connection conn = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			conn = dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 글 갯수를 가져오는 int getBoardTotalCnt()
	public int getBoardCnt() {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT COUNT(*) FROM BOARD";
		
		try {
			conn = getConnnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("게시판 글 수 가져오기 성공");
				result = rs.getInt(1); // 성공 : 첫번째 열의 값을 반환
			} else {
				System.out.println("게시판 글 수 가져오기 실패");
				result = FAIL;
			}
		} catch (Exception e) {
			System.out.println("게시판 글 수 가져오기 예외 : " + e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}
		
		return result;
	}
	
	// 글 목록 출력할 ArrayList<DTO> listBoard()
	public ArrayList<BoardDto> listBoard() {
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM BOARD ORDER BY REF DESC";
		
		try {
			conn = getConnnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					BoardDto dto = new BoardDto();
					
					dto.setNum(rs.getInt("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setEmail(rs.getString("email"));
					dto.setReadCount(rs.getInt("readcount"));
					dto.setPw(rs.getString("pw"));
					dto.setRef(rs.getInt("ref"));
					dto.setReStep(rs.getInt("re_step"));
					dto.setReLevel(rs.getInt("re_level"));
					dto.setIp(rs.getString("ip"));
					dto.setRdate(rs.getTimestamp("rdate"));
					
					dtos.add(dto); // 한줄씩 추가
				} while(rs.next());
			} else {
				System.out.println("가져올 데이터가 없습니다.");
			}
		} catch (Exception e) {
			System.out.println("게시판 가져오기 예외 : " + e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}
		
		return dtos;
	}
	
	// 글 목록 출력할 ArrayList<DTO> listBoard() : 시작 줄과 끝줄까지 만 
	public ArrayList<BoardDto> listBoard(int startRow, int endRow) {
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP ASC) A) " 
		           + " WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = getConnnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					BoardDto dto = new BoardDto();
					
					dto.setNum(rs.getInt("num"));
					dto.setWriter(rs.getString("writer"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setEmail(rs.getString("email"));
					dto.setReadCount(rs.getInt("readcount"));
					dto.setPw(rs.getString("pw"));
					dto.setRef(rs.getInt("ref"));
					dto.setReStep(rs.getInt("re_step"));
					dto.setReLevel(rs.getInt("re_level"));
					dto.setIp(rs.getString("ip"));
					dto.setRdate(rs.getTimestamp("rdate"));
					
					dtos.add(dto); // 한줄씩 추가
				} while(rs.next());
			} else {
				System.out.println("가져올 데이터가 없습니다.");
			}
		} catch (Exception e) {
			System.out.println("게시판 가져오기 예외 : " + e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}
		
		return dtos;
	}
	
	// 글 쓰기 할 int insertBoard(dto)
	public int insertBoard(BoardDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnnection();
			
			if (dto.getNum() != 0) { // 원글이 아닐때만 수정해야 하는 사항.
				
				String reStepSql = "UPDATE BOARD SET RE_STEP = RE_STEP + 1 " 
						 		 + " WHERE REF = ? AND RE_STEP > ?";
				
				pstmt = conn.prepareStatement(reStepSql);
				pstmt.setInt(1, dto.getRef());
				pstmt.setInt(2, dto.getReStep());
				pstmt.executeUpdate();
				
				pstmt.close();	
				
				dto.setReStep(dto.getReStep() + 1); // 원글보다 1 많게 설정
				dto.setReLevel(dto.getReLevel() + 1); // 원글보다 1 많게 설정
				System.out.println(dto.toString());
			}
			
			String selectSql = "SELECT NVL(MAX(NUM), 0) + 1 NUMCOUNT FROM BOARD";
			
			pstmt = conn.prepareStatement(selectSql);
			rs = pstmt.executeQuery();
			
			rs.next();
			int num = rs.getInt(1); // 1번째 열의 값을 가져옴 : 추가할 글의 번호
			
			rs.close();  // 쿼리를 재차 날리기 전에 객체를 일단 닫아줌
			pstmt.close();
			
			String insertSql = "INSERT INTO BOARD VALUES "
			   		 + " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
			// 글번호, 글쓴이, 제목, 글내용, 이메일, 조회수, 패스워드, REF, 그룹출력순, 그룹 들여쓰기정도, IP, 작성시간
			
			pstmt = conn.prepareStatement(insertSql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getEmail());
			pstmt.setInt(6, dto.getReadCount());
			pstmt.setString(7, dto.getPw());
			
			if(dto.getRef() == 0) { // 원글의 경우 ref = num
				dto.setRef(num);				
			} // 답글의 경우 ref = 원글의 ref
			
			pstmt.setInt(8, dto.getRef());
			pstmt.setInt(9, dto.getReStep());
			pstmt.setInt(10, dto.getReLevel());
			pstmt.setString(11, dto.getIp());
		
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("글 입력 성공");
				result = SUCCSESS;
			} else {
				System.out.println("글 입력 실패");
				result = FAIL;
			}
			
		} catch (Exception e) {
			System.out.println("글 입력 예외 : " + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}
		
		return result;
	}

	// 조회 수 올리기 void readCountUp(int num)
	// 조회 수 올리기 void readCountUp(String num)
	public void readCountUp(int num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String updateSql = "UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM = ?";
		
		try {
			conn = getConnnection();
			pstmt = conn.prepareStatement(updateSql);
			
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("조회수 올리기 예외" + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}	
	}// readCountUp(int num)
	public void readCountUp(String num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String updateSql = "UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM = ?";
		
		try {
			conn = getConnnection();
			pstmt = conn.prepareStatement(updateSql);
			
			pstmt.setString(1, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("조회수 올리기 예외" + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}	
	} // readCountUp(String num)
	
	// 글 내용 을 보여주는 DTO getBoardOneLine(int num) , DTO getBoardOneLine(String num)
	public BoardDto getBoardOneLine(int num) {
		BoardDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String selectSql = "SELECT * FROM BOARD WHERE NUM = ?";
		
		try {
			conn = getConnnection();
			pstmt = conn.prepareStatement(selectSql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				/*dto = new BoardDto();
				
				dto.setNumber(num);
				dto.setWriter(rs.getString("writer"));
				dto.setContent(rs.getString("content"));
				dto.setEmail(rs.getString("email"));
				dto.setReadCount(rs.getInt("readcount"));
				dto.setPw(rs.getString("pw"));
				dto.setRef(rs.getInt("ref"));
				dto.setReStep(rs.getInt("re_step"));
				dto.setReLevel(rs.getInt("re_level"));
				dto.setIp(rs.getString("ip"));
				dto.setRdate(rs.getTimestamp("rdate"));*/
				
				String writer = rs.getString("writer");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String email = rs.getString("email");
				int readCount = rs.getInt("readcount");
				String pw = rs.getString("pw");
				int ref = rs.getInt("ref");
				int reStep = rs.getInt("re_step");
				int reLevel = rs.getInt("re_level");
				String ip = rs.getString("ip");
				Timestamp rdate = rs.getTimestamp("rdate");
				
				dto = new BoardDto(num, writer, subject, content, email, readCount, pw, ref, reStep, reLevel, ip, rdate);
			}
		
		} catch (Exception e) {
			System.out.println("글 상세 조회 예외 : " + e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}
		
		return dto;
	}// DTO getBoardOneLine(int num)
	
	public BoardDto getBoardOneLine(String num) {
		BoardDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String selectSql = "SELECT * FROM BOARD WHERE NUM = ?";
		
		try {
			conn = getConnnection();
			pstmt = conn.prepareStatement(selectSql);
			
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new BoardDto();
				
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setEmail(rs.getString("email"));
				dto.setReadCount(rs.getInt("readcount"));
				dto.setPw(rs.getString("pw"));
				dto.setRef(rs.getInt("ref"));
				dto.setReStep(rs.getInt("re_step"));
				dto.setReLevel(rs.getInt("re_level"));
				dto.setIp(rs.getString("ip"));
				dto.setRdate(rs.getTimestamp("rdate"));
								
			}
		
		} catch (Exception e) {
			System.out.println("글 상세 조회 예외 : " + e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}
		
		return dto;
	} // DTO getBoardOneLine(String num)
	
	// 글 수정 하는 기능 : int updateBoard(dto)
	public int updateBoard(BoardDto dto) {
		int result = FAIL;
		// DTO 내용을 update 하고 결과를 result 에 넣는다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String updateSql = "UPDATE BOARD SET "
						 + " WRITER = ?, SUBJECT = ?, CONTENT = ?, EMAIL = ?, "
						 + " PW = ?, IP = ? "
						 + " WHERE NUM = ?";
		
		try {
			conn = getConnnection();
			pstmt = conn.prepareStatement(updateSql);
			
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPw());
			pstmt.setString(6, dto.getIp());
			pstmt.setInt(7, dto.getNum());
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("정보수정 성공");
				result = SUCCSESS;
			} else {
				System.out.println("정보수정 실패");
				result = FAIL;				
			}
			
		} catch (Exception e) {
			System.out.println("정보 수정 예외 : " + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}
		
		
		return result;
	} // int updateBoard(dto);
	
	// 글 삭제 하는 기능 : int delectBoard(int num, String pw)
	//	 			int delectBoard(String num, String pw)
	public int delectBoard(int num, String pw) {
		int result = FAIL;
		// 해당 글 번호와 pw 가 일치할때만 삭제한다. 
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String deleteSql = "DELETE FROM BOARD WHERE NUM = ? AND PW = ?";
		
		try {
			conn = getConnnection();
			pstmt = conn.prepareStatement(deleteSql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, pw);
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("정보수정 성공");
				result = SUCCSESS;
			} else {
				System.out.println("정보수정 실패");
				result = FAIL;				
			}
			
		} catch (Exception e) {
			System.out.println("정보 수정 예외 : " + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}
		
		return result;
	}// int delectBoard(int num, String pw)
	
	public int delectBoard(String num, String pw) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String deleteSql = "DELETE FROM BOARD WHERE NUM = ? AND PW = ?";
		
		try {
			conn = getConnnection();
			pstmt = conn.prepareStatement(deleteSql);
			
			pstmt.setString(1, num);
			pstmt.setString(2, pw);
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("정보수정 성공");
				result = SUCCSESS;
			} else {
				System.out.println("정보수정 실패");
				result = FAIL;				
			}
			
		} catch (Exception e) {
			System.out.println("정보 수정 예외 : " + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}
		
		return result;
	} // int delectBoard(String num, String pw)
	
}
