package com.tj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tj.dto.BookDto;

public class BookDao {
	
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	
	private static BookDao instance = new BookDao();
	
	private BookDao(){ }
	
	public static BookDao getInstance() {
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
	
	// 책 등록하기 int insertBook(dto) {
	public int insertBook (BookDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String insertSql = "INSERT INTO BOOK VALUES (BOOK_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		// INSERT INTO BOOK VALUES (BOOK_SEQ.NEXTVAL, 'JSP PROGRAMING', 20000, 'NOTHING.JPG', 'NOTHING.JPG', '', 0)
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(insertSql);
			
			pstmt.setString(1, dto.getBtitle());
			pstmt.setInt(2, dto.getBprice());
			pstmt.setString(3, dto.getBimage1());
			pstmt.setString(4, dto.getBimage2());
			pstmt.setString(5, dto.getBcontent());
			pstmt.setInt(6, dto.getBdiscount());
			
			result = pstmt.executeUpdate();
			
			if (result == BookDao.SUCCESS) {
				System.out.println("책 정보 입력 성공");
				result = SUCCESS;
			} else if (result == BookDao.FAIL) {
				System.out.println("책 정보 입력 실패");
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
	
	// 책 목록 ArrayList<BookDto> listBook()
		public ArrayList<BookDto> listBook() {
			ArrayList<BookDto> dtos = new ArrayList<BookDto>();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String selectSql = "SELECT * FROM BOOK ORDER BY BID DESC";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(selectSql);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					do {
						int bid = rs.getInt("bid");
						String btitle = rs.getString("btitle");
						int bprice = rs.getInt("bprice");
						String bimage1 = rs.getString("bimage1");
						String bimage2 = rs.getString("bimage2");
						String bcontent = rs.getString("bcontent");
						int bdiscount = rs.getInt("bdiscount");
						
						dtos.add(new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount));
					} while (rs.next());
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
			
			return dtos;
		}
		
		// 책 목록 (패이징) ArrayList<BookDto> listBook(int startRow, int endRow)
		public ArrayList<BookDto> listBook(int startRow, int endRow) {
			ArrayList<BookDto> dtos = new ArrayList<BookDto>();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String selectSql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM " + 
							   " (SELECT * FROM BOOK ORDER BY bID DESC) A) " + 
							   " WHERE RN BETWEEN ? AND ?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(selectSql);
				
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rs = pstmt.executeQuery();

				if (rs.next()) {
					do {
						int bid = rs.getInt("bid");
						String btitle = rs.getString("btitle");
						int bprice = rs.getInt("bprice");
						String bimage1 = rs.getString("bimage1");
						String bimage2 = rs.getString("bimage2");
						String bcontent = rs.getString("bcontent");
						int bdiscount = rs.getInt("bdiscount");
						
						dtos.add(new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount));
					} while (rs.next());
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
			
			return dtos;
		}
		
		// 등록된 책 수 구해오기 : int getTotalCnt() 
		public int getTotalCnt() {
			int totalCnt = FAIL;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String selectSql = "SELECT COUNT(*) FROM BOOK";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(selectSql);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					totalCnt = rs.getInt(1); // 출력된 열의 1번을 가져온다.
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
		
		// 특정 책의 상세보기 : BookDto getBook(int bid) BookDto getBook(String bid)
		public BookDto getBook(int bid) {
			BookDto dto = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String selectSql = "SELECT * FROM BOOK WHERE BID = ?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(selectSql);
				
				pstmt.setInt(1, bid);
				
				rs = pstmt.executeQuery();

				if (rs.next()) {
					String btitle = rs.getString("btitle");
					int bprice = rs.getInt("bprice");
					String bimage1 = rs.getString("bimage1");
					String bimage2 = rs.getString("bimage2");
					String bcontent = rs.getString("bcontent");
					int bdiscount = rs.getInt("bdiscount");
					
					dto = new BookDto(bid, btitle, bprice, bimage1, bimage2, bcontent, bdiscount);
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
			
			return dto;
		}
		// 특정 아이디의 책의 상세보기
		public BookDto getBook(String bid) {
			BookDto dto = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String selectSql = "SELECT * FROM BOOK WHERE BID = ?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(selectSql);
				
				pstmt.setString(1, bid);
				
				rs = pstmt.executeQuery();

				if (rs.next()) {
					/*String bname = rs.getString("bname");
					int bprice = rs.getInt("bprice");
					String bimage1 = rs.getString("bimage1");
					String bimage2 = rs.getString("bimage2");
					String bcontent = rs.getString("bcontent");
					int bdiscount = rs.getInt("bdiscount");
					
					dto = new BookDto(Integer.parseInt(bid), bname, bprice, bimage1, bimage2, bcontent, bdiscount);*/
					dto = new BookDto();
					
					dto.setBid(rs.getInt("bid"));
					dto.setBtitle(rs.getString("btitle"));
					dto.setBprice(rs.getInt("bprice"));
					dto.setBimage1(rs.getString("bimage1"));
					dto.setBimage2(rs.getString("bimage2"));
					dto.setBcontent(rs.getString("bcontent"));
					dto.setBdiscount(rs.getInt("bdiscount"));	
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
			return dto;
		}
	
}
