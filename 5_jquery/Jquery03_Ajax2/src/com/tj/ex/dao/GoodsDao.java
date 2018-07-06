package com.tj.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.ex.dto.GoodsDto;

public class GoodsDao {
	
	public GoodsDao() {}
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
			conn = ds.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		
		return conn;
	}
	
	public GoodsDto getGoods(String gname) {
		GoodsDto gdto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM GOODS WHERE GNAME = ?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gname);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				gdto = new GoodsDto();
				gdto.setGcode(rs.getString("gcode"));
				gdto.setGname(rs.getString("gname"));
				gdto.setGprice(rs.getInt("gprice"));
				gdto.setGstock(rs.getInt("gstock"));
			} else {
				System.out.println("가져올 데이터가 없습니다.");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null || pstmt != null || rs != null) {
					rs.close();
					pstmt.close();
					conn.close();
				}
			} catch (Exception e2) {}
		}
		
		return gdto;
	}
	

}
