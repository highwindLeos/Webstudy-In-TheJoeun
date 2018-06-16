package com.tj.members;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MembersDao {
	// 아이디 중복체크시 쓸 상수 2개 :  
	public static final int MEMBER_EXISTENT = 1; // 있는 아이디
	public static final int MEMBER_NONEEXISTENT = 0; // 없는 아이디
	// 가입 성공 실패 상수
	public static final int FAIL = 0; //회원 가입 실패
	public static final int SUCCESS = 1; //성공
	// 로그인 결과 반환 상수
	public static final int LOGIN_FAIL_ID = -1; // 로그인 아이디 오류 (id)
	public static final int LOGIN_FAIL_PW = 0; // 로그인 패스워드 오류 (pw)
	public static final int LOGIN_SUCCESS = 1; // 로그인 성공
	
	private static MembersDao instance; // 생성자 객체 변수
	
	public static MembersDao getInstance(){
		if (instance == null) {
			instance = new MembersDao();
		}
		return instance;
	}
	
	private MembersDao() { }
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		//커넥션 풀에 있는 dataSorce 객체 가져와 getConnction() 한다
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println("커넥션 예외"+e.getMessage());
		}
		return conn;
	}// 커넥션 풀에서 데이터 베이스 연결 객체.
	
	// 아이디 중복 체크 함수
	public int confirmId(String id) {
		int result = MEMBER_EXISTENT;
		// DB 에서 아이디 검색해서 결과에 따라서  return 값을 변경.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * MEMBERS WHERE ID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 존재하는 아이디.
				System.out.println("데이터 베이스의 중복 값이 있습니다.");
				result = MEMBER_EXISTENT;
			} else { // 회원가입 가능 아이디.
				System.out.println("데이터 베이스의 값이 없습니다.");
				result = MEMBER_NONEEXISTENT;
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
	
	// 회원 가입 함수
	public int insertMember(MembersDto dto) {
		int result = FAIL;
		// DTO 의 값을 DB 에 insert 하고 결과를  반환 한다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MEMBERS VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setTimestamp(5, dto.getBirth());
			pstmt.setTimestamp(6, dto.getrDate());
			pstmt.setString(7, dto.getAddress());
			
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
	public int loginCheck(String id, String pw) {
		int result = LOGIN_FAIL_ID;
		// id pw 로 db 접속해서 적당한 결과를 result 에 조정
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT *  FROM MEMBERS WHERE ID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("아이디 있음");
				String databasePw = rs.getString("pw");
				
				if (databasePw.equals(pw)) { // 아이디와 패스워드가 모두 같음 : 로그인 성공.					
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
	public MembersDto getMember(String id) {
		MembersDto dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT *  FROM MEMBERS WHERE ID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Timestamp birth = rs.getTimestamp("birth");
				Timestamp rdate = rs.getTimestamp("rdate");
				String address = rs.getString("address");
				
				dto = new MembersDto(id, pw, name, email, birth, rdate, address);

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
	public int updateMember(MembersDto dto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBERS SET PW = ?, NAME = ?, EMAIL= ?, BIRTH = ?, ADDRESS = ? " + 
					 " WHERE ID = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setTimestamp(4, dto.getBirth());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getId());
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("회원정보 수정 성공");
				result = SUCCESS;
			} else {
				System.out.println("회원정보 수정 실패");
				result =  FAIL;				
			}
			
		} catch (Exception e) {
			System.out.println("회원 정보 수정 예외 발생" + e.getMessage());
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		} 
		
		return result;
	}
}
