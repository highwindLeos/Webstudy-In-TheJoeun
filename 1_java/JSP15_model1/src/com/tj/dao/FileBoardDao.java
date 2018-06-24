package com.tj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tj.dto.FileBoardDto;

public class FileBoardDao {
	
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	
	private static FileBoardDao instance = new FileBoardDao();
	
	private FileBoardDao(){ }
	
	public static FileBoardDao getInstance() {
		return instance;
	}
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			conn = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 테이블의 행을 구해오는 기능
	public int getFileBoardCnt() {
		int totalCnt = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String selectSql = "SELECT COUNT(*) FROM FILEBOARD";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(selectSql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				totalCnt = rs.getInt(1);
			} else {
				System.out.println("가져올 데이터가 없습니다.");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}			
		}
		
		return totalCnt;
	}
	
	// 답변글 쓰기 전 ⓐ 단계
	private void preReplyAstep(int ref, int re_step) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String updateSql = "UPDATE FILEBOARD "
				   + " SET FRESTEP = FRESTEP + 1 WHERE FREF = ? AND FRESTEP > ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(updateSql);
			
			pstmt.setInt(1, ref);
			pstmt.setInt(2, re_step);
			
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
	
	// 파일보드 글입력
	public int insertFileBoard(FileBoardDto fdto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		if(fdto.getFnum() != 0) {//답변글의 경우
			
			preReplyAstep(fdto.getFref(), fdto.getFrestep());
			
			//원글의 restep 에 1을 더해 다시 입력해준다.
			fdto.setFrestep(fdto.getFrestep() + 1);
			//원글의 relevel 에 1을 더해 다시 입력해준다.
			fdto.setFrelevel(fdto.getFrelevel() + 1);
		
		String insertSql = "INSERT INTO FILEBOARD VALUES "
				+ "(FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, 0, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(insertSql);
			
			pstmt.setString(1, fdto.getCid());
			pstmt.setString(2, fdto.getFsubject());
			pstmt.setString(3, fdto.getFcontent());
			pstmt.setString(4, fdto.getFfilename());
			pstmt.setString(5, fdto.getFpw());
			pstmt.setInt(6, fdto.getFref());
			pstmt.setInt(7, fdto.getFrestep());
			pstmt.setInt(8, fdto.getFrelevel());
			pstmt.setString(9, fdto.getFip());
			
			result = pstmt.executeUpdate();
			
				if (result == FileBoardDao.SUCCESS) {
					System.out.println("답변글 입력성공");
				} else {
					System.out.println("답변글 입력성공");				
				}
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(pstmt!=null) pstmt.close();
					if(conn!=null)  conn.close();
				}catch (Exception e) {System.out.println(e.getMessage());}
			}
			
		} else { // 원글의 경우
			
			String insertSql = "INSERT INTO FILEBOARD VALUES "
					   + "(FILEBOARD_SEQ.NEXTVAL, ?, ?, ?, ?, 0, ?, "
					   + " FILEBOARD_SEQ.CURRVAL, 0,0,?,SYSDATE)";
				// cid(1), fsubject(2), fcontent(3), ffilename(4),
				// freadcount, fpw(5),
				// fref, fre_step,fre_level,fip(6)
				try {
					conn = getConnection();
					pstmt = conn.prepareStatement(insertSql);
					
					pstmt.setString(1, fdto.getCid());
					pstmt.setString(2, fdto.getFsubject());
					pstmt.setString(3, fdto.getFcontent());
					pstmt.setString(4, fdto.getFfilename());
					pstmt.setString(5, fdto.getFpw());
					pstmt.setString(6, fdto.getFip());
					
					result = pstmt.executeUpdate();
					
					if (result == FileBoardDao.SUCCESS) {
						System.out.println("원글 입력성공");
					} else {
						System.out.println("원글 입력성공");				
					}
					
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}finally {
					try {
						if(pstmt!=null) pstmt.close();
						if(conn!=null)  conn.close();
					}catch (Exception e) {System.out.println(e.getMessage());}
				}
		}
		return result;
	}
	// 게시물의 리스트를 가져온다 (All)
	public ArrayList<FileBoardDto> getFileBoardList() {
		ArrayList<FileBoardDto> dtos = new ArrayList<FileBoardDto>();
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C "
		           + " WHERE F.CID = C.CID ORDER BY FNUM DESC";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					int fnum = rs.getInt("fnum");
					String cid = rs.getString("cid");
					String cname = rs.getString("cname");
					String cemail = rs.getString("cemail");
					String fsubject = rs.getString("fsubject");
					String fcontent = rs.getString("fcontent");
					String ffilename = rs.getString("ffilename");
					int freadcount = rs.getInt("freadcount");
					String fpw = rs.getString("fpw");
					int fref = rs.getInt("fref");
					int frestep = rs.getInt("frestep");
					int frelevel = rs.getInt("frelevel");
					String fip = rs.getString("fip");
					Timestamp rdate = rs.getTimestamp("rdate");
					
					dtos.add(new FileBoardDto(fnum, cid, cname, cemail, fsubject, fcontent, ffilename, freadcount, fpw, fref, frestep, frelevel, fip, rdate));
				} while(rs.next());
			} else {
				System.out.println("가져올 테이블 데이터가 없습니다. : fileboard");
			}
			
		} catch (SQLException e) {
			System.out.println("읽어오기 예외 발생" + e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}		
		}
		
		return dtos;
	}
	// 게시물의 리스트를 가져온다 (페이징 적용)
	public ArrayList<FileBoardDto> getFileBoardList(int startRow, int endRow) {
		ArrayList<FileBoardDto> dtos = new ArrayList<FileBoardDto>();
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " SELECT * FROM " + 
					 " (SELECT ROWNUM RN, A.* FROM (SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C " +
					 " WHERE F.CID = C.CID ORDER BY FREF DESC, FRESTEP ASC) A) " + 
					 " WHERE RN BETWEEN ? AND ?"; // top-n 구문
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					int fnum = rs.getInt("fnum");
					String cid = rs.getString("cid");
					String cname = rs.getString("cname");
					String cemail = rs.getString("cemail");
					String fsubject = rs.getString("fsubject");
					String fcontent = rs.getString("fcontent");
					String ffilename = rs.getString("ffilename");
					int freadcount = rs.getInt("freadcount");
					String fpw = rs.getString("fpw");
					int fref = rs.getInt("fref");
					int frestep = rs.getInt("frestep");
					int frelevel = rs.getInt("frelevel");
					String fip = rs.getString("fip");
					Timestamp frdate = rs.getTimestamp("frdate");
					
					dtos.add(new FileBoardDto(fnum, cid, cname, cemail, fsubject, fcontent, ffilename, freadcount, fpw, fref, frestep, frelevel, fip, frdate));
				} while(rs.next());
			} else {
				System.out.println("가져올 테이블 데이터가 없습니다. : fileboard");
			}
			
		} catch (SQLException e) {
			System.out.println("읽어오기 예외 발생" + e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}		
		}
		
		return dtos;
	}
	
	// 조회수 증가 함수. (상새보기전에 호출해서 조회수를 올림)
	public void readCountUp(int fnum) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String updateSql = "UPDATE FILEBOARD SET FREADCOUNT = FREADCOUNT + 1 WHERE FNUM = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(updateSql);
			
			pstmt.setInt(1, fnum);
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("조회수 1 증가");
			} else {
				System.out.println("조회수 증가 실패");
			}
			
		} catch (Exception e) {
			System.out.println("조회수 올리기 예외" + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}	
	}// readCountUp(int num)
	public void readCountUp(String fnum) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String updateSql = "UPDATE FILEBOARD SET FREADCOUNT = FREADCOUNT + 1 WHERE FNUM = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(updateSql);
			
			pstmt.setString(1, fnum);
			int temp = pstmt.executeUpdate();
			
			if(temp > 0) {
				System.out.println("조회수 1증가");
			} else {
				System.out.println("조회수 증가 실패");				
			}
			
		} catch (Exception e) {
			System.out.println("조회수 올리기 예외" + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}	
	} // readCountUp(String num)
	
	// 특정 글 번호의  상세 내용을 보여주는 DTO 
	public FileBoardDto getFileBoardOneLine(int fnum) {
		FileBoardDto fdto =  null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String selectSql = "SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C " 
						+  " WHERE F.CID = C.CID AND F.FNUM = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(selectSql);
			
			pstmt.setInt(1, fnum);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				String cid = rs.getString("cid");
				String cname = rs.getString("cname");
				String cemail = rs.getString("cemail");
				String fsubject = rs.getString("fsubject");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				int freadcount = rs.getInt("freadcount");
				String fpw = rs.getString("fpw");
				int fref = rs.getInt("fref");
				int frestep = rs.getInt("frestep");
				int frelevel = rs.getInt("frelevel");
				String fip = rs.getString("fip");
				Timestamp frdate = rs.getTimestamp("frdate");
				
				fdto = new FileBoardDto(fnum, cid, cname, cemail, fsubject, fcontent, ffilename, freadcount, fpw, fref, frestep, frelevel, fip, frdate);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}
		
		return fdto;
	}
	//
	public FileBoardDto getFileBoardOneLine(String fnum) {
		FileBoardDto fdto =  null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String selectSql = "SELECT F.*, C.CNAME, C.CEMAIL FROM FILEBOARD F, CUSTOMER C " + 
					 " WHERE F.CID = C.CID AND F.FNUM = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(selectSql);
			
			pstmt.setString(1, fnum);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				String cid = rs.getString("cid");
				String cname = rs.getString("cname");
				String cemail = rs.getString("cemail");
				String fsubject = rs.getString("fsubject");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");
				int freadcount = rs.getInt("freadcount");
				String fpw = rs.getString("fpw");
				int fref = rs.getInt("fref");
				int frestep = rs.getInt("frestep");
				int frelevel = rs.getInt("frelevel");
				String fip = rs.getString("fip");
				Timestamp frdate = rs.getTimestamp("frdate");
				
				fdto = new FileBoardDto(Integer.parseInt(fnum), cid, cname, cemail, fsubject, fcontent, ffilename, freadcount, fpw, fref, frestep, frelevel, fip, frdate);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}
		
		return fdto;
	}
	
	public int updateFileBoard(FileBoardDto dto) {
		int result = FAIL;
		// DTO 내용을 update 하고 결과를 result 에 넣는다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String updateSql = "UPDATE FILEBOARD SET " + 
							" FSUBJECT = ?, " + 
							" FFILENAME = ?, " + 
							" FCONTENT = ?, " + 
							" FPW = ?, " + 
							" FIP = ? " + 
							" WHERE FNUM = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(updateSql);
			
			pstmt.setString(1, dto.getFsubject());
			pstmt.setString(2, dto.getFfilename());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(4, dto.getFpw());
			pstmt.setString(5, dto.getFip());
			pstmt.setInt(6, dto.getFnum());
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("정보수정 성공");
				result = SUCCESS;
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
	
	// 삭제 기능
	public int delectFileBoard(int fnum, String fpw) {
		int result = FAIL;
		// 해당 글 번호와 pw 가 일치할때만 삭제한다. 
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String deleteSql = "DELETE FROM FILEBOARD WHERE FNUM = ? AND FPW = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(deleteSql);
			
			pstmt.setInt(1, fnum);
			pstmt.setString(2, fpw);
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("정보삭제 성공");
				result = SUCCESS;
			} else {
				System.out.println("정보삭제 실패");
				result = FAIL;				
			}
			
		} catch (Exception e) {
			System.out.println("정보삭제 예외 : " + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}
		
		return result;
	}// int delectBoard(int num, String pw)
	
	public int delectFileBoard(String fnum, String fpw) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String deleteSql = "DELETE FROM FILEBOARD WHERE FNUM = ? AND FPW = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(deleteSql);
			
			pstmt.setString(1, fnum);
			pstmt.setString(2, fpw);
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("정보삭제 성공");
				result = SUCCESS;
			} else {
				System.out.println("정보삭제 실패");
				result = FAIL;				
			}
			
		} catch (Exception e) {
			System.out.println("정보삭제예외 : " + e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {	}
		}
		return result;
	}
}
