package com.tj.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MembersDao {
	
	public static final int NONEEXISTENCE = 0;
	public static final int EXISTENCE = 1;
	
	
	public MembersDao() {}

	private Connection getConnection() {
		Connection conn = null;
	
		try	{
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
		return conn;
	}
	
	// public int confirmId() {id}
	public int confirmId(String id) {
		int result = NONEEXISTENCE;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs  = null;
		
		String sql = "SELECT * FROM MEMBERS WHERE ID = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = EXISTENCE; // 존재하는 경우
			} else {
				result = NONEEXISTENCE; // 없는 아이디
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {}
		}
		
		return result;
	}
}
