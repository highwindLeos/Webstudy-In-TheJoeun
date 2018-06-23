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
import com.tj.ex.dto.BookDto;
public class BookDao {
	public static final int SUCCESS = 1;
	public static final int FAIL = 0;
	private static BookDao instance = new BookDao();
	private BookDao() {}
	public static BookDao getInstance() {
		return instance;
	}
	private Connection getConnection() throws SQLException {
		Connection conn=null;
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
	// 책등록 int insertBook(dto)
	public int insertBook(BookDto dto) {
		int result = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO BOOK VALUES (BOOK_SEQ.NEXTVAL, ?,?,?,?,?,?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBtitle());
			pstmt.setInt(2, dto.getBprice());
			pstmt.setString(3, dto.getBimage1());
			pstmt.setString(4, dto.getBimage2());
			pstmt.setString(5, dto.getBcontent());
			pstmt.setInt(6, dto.getBdiscount());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		
		return result;
	}
	// 책목록 ArrayList<BookDto> listBook()
	public ArrayList<BookDto> listBook(){
		ArrayList<BookDto> dtos = new ArrayList<BookDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM BOOK ORDER BY BID DESC";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				int bprice = rs.getInt("bprice");
				String bimage1 = rs.getString("bimage1");
				String bimage2 = rs.getString("bimage2");
				String bcontent = rs.getString("bcontent");
				int bdiscount = rs.getInt("bdiscount");
				dtos.add(new BookDto(bid, btitle, bprice, bimage1, 
						bimage2, bcontent, bdiscount));
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
	// 책목록(페이징) ArrayList<BookDto> listBook(startRow, endRow)
	public ArrayList<BookDto> listBook(int startRow, int endRow){
		ArrayList<BookDto> dtos = new ArrayList<BookDto>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM " + 
				"     (SELECT * FROM BOOK ORDER BY bID DESC) A) " + 
				"    WHERE RN BETWEEN ? AND ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				int bprice = rs.getInt("bprice");
				String bimage1 = rs.getString("bimage1");
				String bimage2 = rs.getString("bimage2");
				String bcontent = rs.getString("bcontent");
				int bdiscount = rs.getInt("bdiscount");
				dtos.add(new BookDto(bid, btitle, bprice, bimage1, 
						bimage2, bcontent, bdiscount));
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
	// 등록된책갯수 int getTotCnt()
	public int getTotCnt() {
		int totCnt = 0;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT COUNT(*) FROM BOOK";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totCnt = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs!=null)    rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null)  conn.close();
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		return totCnt;
	}
	// 특정책의 상세보기 BookDto getBook(int bid)
	public BookDto getBook(int bid) {
		BookDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM BOOK WHERE BID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String btitle = rs.getString("btitle");
				int bprice = rs.getInt("bprice");
				String bimage1 = rs.getString("bimage1");
				String bimage2 = rs.getString("bimage2");
				String bcontent = rs.getString("bcontent");
				int bdiscount = rs.getInt("bdiscount");
				dto = new BookDto(bid, btitle, bprice, bimage1, 
						bimage2, bcontent, bdiscount);
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
		
		return dto;
	}
	// 특정책의 상세보기 BookDto getBook(String bid)
	public BookDto getBook(String bid) {
		BookDto dto = null;
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		String sql = "SELECT * FROM BOOK WHERE BID=?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new BookDto();
				dto.setBid(rs.getInt("bid"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBprice(rs.getInt("bprice"));
				dto.setBimage1(rs.getString("bimage1"));
				dto.setBimage2(rs.getString("bimage2"));
				dto.setBcontent(rs.getString("bcontent"));
				dto.setBdiscount(rs.getInt("bdiscount"));
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
		return dto;
	}
}