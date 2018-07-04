package com.tj.ex.dao;

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

import com.tj.ex.dto.EmpDto;
import com.tj.ex.dto.GoodsDto;

public class EmpDao {
	
	public EmpDao() {}
	
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
	
	public ArrayList<EmpDto> searchEmpList(String searchEname, String searchjob) {
		ArrayList<EmpDto> edtos = new ArrayList<EmpDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM EMP "
				   + " WHERE ENAME LIKE '%'||?||'%' AND JOB LIKE '%'||?||'%'";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchEname);
			pstmt.setString(2, searchjob);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int mgr = rs.getInt("mgr");
					Date hiredate = rs.getDate("hiredate");
					int sal = rs.getInt("sal");
					int comm = rs.getInt("comm");
					int deptno = rs.getInt("deptno");
					
					edtos.add(new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno));
					
				} while (rs.next());
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
		
		return edtos;
	}
	

}
