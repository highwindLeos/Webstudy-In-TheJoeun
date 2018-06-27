package com.tj.dao;
// membersAll() joinMember()

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.dto.MembersDto;

public class MembersDao {
	
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context context  = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			conn = dataSource.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public ArrayList<MembersDto> getMembersAll(){
		ArrayList<MembersDto> members = new ArrayList<MembersDto>();
		// 회원 의 모든 정보 members 추가
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM MEMBERS ORDER BY RDATE";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date birth = rs.getDate("birth");
				Date rdate = rs.getDate("rdate");
				String address = rs.getString("address");
				
				members.add(new MembersDto(id, pw, name, email, birth, rdate, address));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null || pstmt != null || conn != null) {
					rs.close();
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) { }
		}
			
		return members;
	}
	
	public int joinMembers(MembersDto newMember){
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MEMBERS (ID, PW, NAME, EMAIL, BIRTH, RDATE, ADDRESS) "
				   + " VALUES (?, ?, ?, ?, ?, SYSDATE, ?)";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newMember.getId());
			pstmt.setString(2, newMember.getPw());
			pstmt.setString(3, newMember.getName());
			pstmt.setString(4, newMember.getEmail());
			pstmt.setDate(5, newMember.getBirth());
			pstmt.setString(6, newMember.getAddress());
			
			int temp = pstmt.executeUpdate();
			
			if (temp > 0) {
				System.out.println("회원 입력 성공");
				result = SUCCESS;
			} else {
				System.out.println("회원 입력 실패");
				result = FAIL;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if ( pstmt != null || conn != null) {
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) { }
		}
			
		return result;
	}


}
