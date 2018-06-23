package com.tj.ex.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.tj.ex.dto.FileboardDto;
public class FileboardDao {
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	private static FileboardDao instance= new FileboardDao();
	private FileboardDao() {}
	public static FileboardDao getInstance() {
		return instance;
	}
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)
					ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	//글 갯수를 가져오기
	public int getFileboardTotCnt() {
		int totCnt = 0;
		Connection conn = null;
		Statement  stmt = null;
		ResultSet  rs   = null;
		String sql = "SELECT COUNT(*) TOTCNT FROM FILEBOARD";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			totCnt = rs.getInt("totCnt");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return totCnt;
	}
	//글 목록 출력하기(startRow부터 endRow까지)
	public ArrayList<FileboardDto> listFileboard(int startRow, int endRow){
		ArrayList<FileboardDto> dtos = new ArrayList<FileboardDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM "
				+ "(SELECT ROWNUM RN, A.* FROM "
					+ "(SELECT F.*, C.CNAME, C.CEMAIL FROM "
						+ "FILEBOARD F, CUSTOMER C WHERE F.CID=C.CID "
						+ "ORDER BY fref DESC, FRE_STEP) A) "
				+ "WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int fnum = rs.getInt("fnum");
				String cid = rs.getString("cid");
				String cname = rs.getString("cname");
				String cemail = rs.getString("cemail");
				String fsubject = rs.getString("fsubject");
				String fcontent = rs.getString("fcontent");
				String ffilename = rs.getString("ffilename");;
				int freadcount = rs.getInt("freadcount");
				String fpw = rs.getString("fpw");
				int fref = rs.getInt("fref");
				int fre_step = rs.getInt("fre_step");
				int fre_level = rs.getInt("fre_level");
				String fip = rs.getString("fip");
				Timestamp frdate = rs.getTimestamp("frdate");
				dtos.add(new FileboardDto(fnum, cid, cname, cemail, fsubject, fcontent, ffilename, freadcount, fpw, fref, fre_step, fre_level, fip, frdate));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null)    rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return dtos;
	}
	// 답변글 쓰기 전 ⓐ 단계
	private void preReplyAstep(int ref, int re_step) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD "
			+ "SET FRE_STEP = FRE_STEP+1 WHERE FREF=? AND FRE_STEP>?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
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
	//글쓰기
	public int insertFileboard(FileboardDto dto) {
	// fnum, fref, fre_step, fre_level = 원글(0), 답변글(원글의 정보)
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if(dto.getFnum()!=0) {//답변글의 경우
			preReplyAstep(dto.getFref(), dto.getFre_step());
			dto.setFre_step(dto.getFre_step()+1);
			dto.setFre_level(dto.getFre_level() + 1);
			String sql = "INSERT INTO FILEBOARD VALUES "
				+ "(FILEBOARD_SEQ.NEXTVAL, ?,?,?,?,0,?,?,?,?,?,SYSDATE)";
			// cid(1), fsubject(2), fcontent(3), ffilename(4),freadcount 
			// fpw(5),fref(6), fre_step(7),fre_level(8),fip(9)
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getCid());
				pstmt.setString(2, dto.getFsubject());
				pstmt.setString(3, dto.getFcontent());
				pstmt.setString(4, dto.getFfilename());
				pstmt.setString(5, dto.getFpw());
				pstmt.setInt(6, dto.getFref());
				pstmt.setInt(7, dto.getFre_step());
				pstmt.setInt(8, dto.getFre_level());
				pstmt.setString(9, dto.getFip());
				pstmt.executeUpdate();
				result = SUCCESS;
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(pstmt!=null) pstmt.close();
					if(conn!=null)  conn.close();
				}catch (Exception e) {System.out.println(e.getMessage());}
			}
		}else { // 원글의 경우
			String sql = "INSERT INTO FILEBOARD VALUES "
					+ "(FILEBOARD_SEQ.NEXTVAL, ?,?,?,?,0,?,"
					+ "fileboard_seq.CURRVAL, 0,0,?,SYSDATE)";
				// cid(1), fsubject(2), fcontent(3), ffilename(4),
				// freadcount, fpw(5),
				// fref, fre_step,fre_level,fip(6)
				try {
					conn = getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, dto.getCid());
					pstmt.setString(2, dto.getFsubject());
					pstmt.setString(3, dto.getFcontent());
					pstmt.setString(4, dto.getFfilename());
					pstmt.setString(5, dto.getFpw());
					pstmt.setString(6, dto.getFip());
					pstmt.executeUpdate();
					result = SUCCESS;
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
	//조회수를 하나 올리는 void readCountUp(int fnum)
	public void readCountUp(int fnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD SET FREADCOUNT = FREADCOUNT + 1 "
				+ "WHERE FNUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}
	//글내용 상세보기 할 DTO getFileboardOneLine(int fnum)
	public FileboardDto getFileboardOneLine(int fnum) {
		FileboardDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT F.*, C.CNAME, C.CEMAIL "
				+ "FROM FILEBOARD F, CUSTOMER C "
				+ "WHERE F.CID=C.CID AND F.FNUM=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new FileboardDto();
				dto.setFnum(fnum);
				dto.setCid(rs.getString("cid"));
				dto.setCname(rs.getString("cname"));
				dto.setCemail(rs.getString("cemail"));
				dto.setFsubject(rs.getString("fsubject"));
				dto.setFcontent(rs.getString("fcontent"));
				dto.setFfilename(rs.getString("ffilename"));
				dto.setFreadcount(rs.getInt("freadcount"));
				dto.setFpw(rs.getString("fpw"));
				dto.setFref(rs.getInt("fref"));
				dto.setFre_step(rs.getInt("fre_step"));
				dto.setFre_level(rs.getInt("fre_level"));
				dto.setFip(rs.getString("fip"));
				dto.setFrdate(rs.getTimestamp("frdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)    rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null)  conn.close();
			} catch (Exception e) { }
		}
		return dto;
	}
	//글수정 할 int updateFileboard(dto);
	public int updateFileboard(FileboardDto dto) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE FILEBOARD "
				+ "SET FSUBJECT = ?, "
					+ "FCONTENT = ?, "
					+ "FFILENAME = ?, "
					+ "FPW = ?, "
					+ "FIP = ? "
				+ "WHERE FNUM = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getFsubject());
			pstmt.setString(3, dto.getFcontent());
			pstmt.setString(2, dto.getFfilename());
			pstmt.setString(4, dto.getFpw());
			pstmt.setString(5, dto.getFip());
			pstmt.setInt(6, dto.getFnum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return result;
	}
	//글삭제하기 - 삭제시 글번호와 비번이 맞아야 함
	public int deleteFileboard(int fnum, String fpw) {
		int result = FAIL;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM FILEBOARD WHERE FNUM=? AND FPW=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fnum);
			pstmt.setString(2, fpw);
			int tempResult = pstmt.executeUpdate();
			if(tempResult>0) result = SUCCESS;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return result;
	};
}