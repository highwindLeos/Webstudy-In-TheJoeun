package com.tj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.tj.dto.EmpDto;

public class EmpDao {
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			conn = dataSource.getConnection();
		} catch (NamingException e) {
			System.out.println(e.getMessage());
		}
		return conn;	
	}
	
	public ArrayList<EmpDto> getEmps(){
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String sql = "SELECT * FROM EMP ORDER BY HIREDATE";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpDto emp = new EmpDto();
				
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				
				dtos.add(emp);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
	
		return dtos;
	}
	
	public ArrayList<EmpDto> getEmpsSearch(String ename, String job){
		ArrayList<EmpDto> dtos = new ArrayList<EmpDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM EMP " + 
				"WHERE ENAME LIKE '%'||?||'%' AND JOB LIKE '%'||?||'%' ORDER BY HIREDATE";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, ename.toUpperCase());
			pstmt.setString(2, job.toUpperCase());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmpDto emp = new EmpDto();
				
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				
				dtos.add(emp);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {}
		}
	
		return dtos;
	}
	
}
