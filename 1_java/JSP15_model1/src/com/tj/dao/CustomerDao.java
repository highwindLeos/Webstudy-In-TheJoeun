package com.tj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tj.dto.CustomerDto;

public class CustomerDao {
	
	public static final int C_EXISTENT = 1;
	public static final int C_NONEEXISTENT = 0;
	
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	
	public static final int LOGIN_FAIL_ID = -1;
	public static final int LOGIN_FAIL_PW = 0;
	public static final int LOGIN_SUCCESS = 1;
	
	private static CustomerDao instance = new CustomerDao();
	
	private CustomerDao(){ }
	
	public static CustomerDao getInstance() {
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
	
	public int confirmId(String cid) {
		int result = C_NONEEXISTENT;
		// DB 에서 아이디 검색해서 결과에 따라서  return 값을 변경.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM CUSTOMER WHERE CID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cid);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 존재하는 아이디.
				System.out.println("데이터 베이스의 중복 값이 있습니다.");
				result = C_EXISTENT;
			} else { // 회원가입 가능 아이디.
				System.out.println("데이터 베이스의 값이 없습니다.");
				result = C_NONEEXISTENT;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		} // 연결 객체 생성
	
		return result;
	}
	// cnt
	public int customerCnt() {
		int totalCnt = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String selectSql = "SELECT COUNT(*) FROM CUSTOMER";
		
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
	
	// 회원 리스트 반환
	public ArrayList<CustomerDto> listCustomer() {
		ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM CUSTOMER ORDER BY CID";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);			
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 존재하는 아이디.
				do {
					String cid = rs.getString("cid");
					String cpw = rs.getString("cpw");
					String cname = rs.getString("cname");
					String ctel = rs.getString("ctel");
					String cemail = rs.getString("cemail");
					String cgender = rs.getString("cgender");
					String caddr = rs.getString("caddr");
					
					dtos.add(new CustomerDto(cid, cpw, cname, ctel, cemail, cgender, caddr));
				} while (rs.next());
			} else { // 회원가입 가능 아이디.
				System.out.println("데이터 베이스의 값이 없습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		} // 연결 객체 생성
		
		return dtos;
	}
	
	// 회원 리스트 반환 : paging
	public ArrayList<CustomerDto> listCustomer(int startRow, int endRow) {
			ArrayList<CustomerDto> dtos = new ArrayList<CustomerDto>();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String selectSql = "SELECT * FROM " + 
					"    (SELECT ROWNUM RN, A.* FROM " + 
					"        (SELECT * FROM CUSTOMER ORDER BY CID) A) " + 
					"    WHERE RN BETWEEN ? AND ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(selectSql);	
				
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				
				rs = pstmt.executeQuery();
				
				if (rs.next()) { // 존재하는 아이디.
					do {
						String cid = rs.getString("cid");
						String cpw = rs.getString("cpw");
						String cname = rs.getString("cname");
						String ctel = rs.getString("ctel");
						String cemail = rs.getString("cemail");
						String cgender = rs.getString("cgender");
						String caddr = rs.getString("caddr");
						
						dtos.add(new CustomerDto(cid, cpw, cname, ctel, cemail, cgender, caddr));
					} while (rs.next());
				} else { // 회원가입 가능 아이디.
					System.out.println("데이터 베이스의 값이 없습니다.");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {}
			} // 연결 객체 생성
			
			return dtos;
		}
	
	public int insertCustomer(CustomerDto dto) {
		int result = FAIL;
		// DTO 의 값을 DB 에 insert 하고 결과를  반환 한다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO CUSTOMER VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getCid());
			pstmt.setString(2, dto.getCpw());
			pstmt.setString(3, dto.getCname());
			pstmt.setString(4, dto.getCtel());
			pstmt.setString(5, dto.getCemail());
			pstmt.setString(6, dto.getCgender());
			pstmt.setString(7, dto.getCaddr());
			
			result = pstmt.executeUpdate();
			
			if (result > 0) { // 입력 성공
				System.out.println("회원 가입성공");
				result = SUCCESS;
			} else { // 입력 실패
				System.out.println("회원 가입실패");
				result = FAIL;
			}
			
		} catch (Exception e) {
			System.out.println("회원가입 예외 발생" + e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		} // 연결 객체 생성
	
		return result;
	}
	
	// 로그인 처리 함수
	public int loginCheck(String cid, String cpw) {
			int result = LOGIN_FAIL_ID;
			// id pw 로 db 접속해서 적당한 결과를 result 에 조정
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT * FROM CUSTOMER WHERE CID = ?";
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, cid);
				
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					System.out.println("아이디 있음");
					String databaseCpw = rs.getString("cpw");
					
					if (databaseCpw.equals(cpw)) { // 아이디와 패스워드가 모두 같음 : 로그인 성공.					
						System.out.println("로그인 성공");
						result = LOGIN_SUCCESS;
					} else { // 패스워드가 틀림
						System.out.println("패스워드 틀림");
						result = LOGIN_FAIL_PW;
					}
					
				} else { // 아이디가 틀림
					System.out.println("아이디 틀림");
					result = LOGIN_FAIL_ID;
				}
				
			} catch (Exception e) {
				System.out.println("로그인 처리 예외 발생" + e.getMessage());
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {}
			} 
			
			return result;
		} 
	
		// id 를 매개 변수로 받아서 members DTO 반환 하는 함수
		public CustomerDto getCustomer(String cid) {
			CustomerDto dto = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT * FROM CUSTOMER WHERE CID = ?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, cid);
				
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					
					String cpw = rs.getString("cpw");
					String cname = rs.getString("cname");
					String ctel = rs.getString("ctel");
					String cemail = rs.getString("cemail");
					String cgender = rs.getString("cgender");
					String caddr = rs.getString("caddr");
					
					dto = new CustomerDto(cid, cpw, cname, ctel, cemail, cgender, caddr);

				}
				
			} catch (Exception e) {
				System.out.println("회원 정보 출력 예외" + e.getMessage());
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {}
			} 
			// 아이디로 가져온 데이터베이스 결과를 dto 에 넣어서 반환.
			return dto; 
		}
		
		//회원정보 수정 함수
		public int updateCustomer(CustomerDto dto) {
			int result = FAIL;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String sql = "UPDATE CUSTOMER SET CPW = ?, CNAME = ?,  CTEL = ?, CEMAIL = ?, CGENDER = ?, CADDR = ? " + 
						 " WHERE CID = ?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getCpw());
				pstmt.setString(2, dto.getCname());
				pstmt.setString(3, dto.getCtel());
				pstmt.setString(4, dto.getCemail());
				pstmt.setString(5, dto.getCgender());
				pstmt.setString(6, dto.getCaddr());
				pstmt.setString(7, dto.getCid());
				
				int temp = pstmt.executeUpdate();
				
				if (temp > 0) {
					System.out.println("고객정보 수정 성공");
					result = SUCCESS;
				} else {
					System.out.println("고객정보 수정 실패");
					result =  FAIL;				
				}
				
			} catch (Exception e) {
				System.out.println("고객정보 수정 예외 발생" + e.getMessage());
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {}
			} 
			
			return result;
		}
		
		//회원정보 삭제 함수
		public int deleteCustomer(String cid, String cpw) {
			int result = FAIL;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			String deleteSql = "DELETE FROM CUSTOMER WHERE CID = ? AND CPW = ?";
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(deleteSql);
				
				pstmt.setString(1, cid);
				pstmt.setString(2, cpw);

				int temp = pstmt.executeUpdate();
				
				if (temp > 0) {
					System.out.println("고객정보 수정 성공");
					result = SUCCESS;
				} else {
					System.out.println("고객정보 수정 실패");
					result =  FAIL;				
				}
				
			} catch (Exception e) {
				System.out.println("고객정보 수정 예외 발생" + e.getMessage());
			} finally {
				try {
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {}
			} 
			
			return result;
		}
	
}
