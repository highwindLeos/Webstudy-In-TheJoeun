package com.tj.ex;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/joinOK")
public class joinOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	private String uid = "leos";
	private String upw = "Stonker26";
	
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	
	private String name, id, pw, phone1, phone2, phone3, gender;
       

    public joinOK() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}


	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		name = request.getParameter("name");
		id = request.getParameter("id");
		pw = request.getParameter("pw");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");
		
		/* String InsertSql = String.format("INSERT INTO MEMBER VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s')", 
										id, pw, name, phone1, phone2, phone3, gender);  */
										
		String sql = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, ?)";
										
		try {
			
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone1);
			pstmt.setString(5, phone2);
			pstmt.setString(6, phone3);
			pstmt.setString(7, gender);
			
			int result = pstmt.executeUpdate(); // update insert delete 문 전송시 사용하는 메소드
			
			if (result > 0) {
				System.out.println("회원가입 성공");
				response.sendRedirect("3_member/joinResult.jsp?result=ok");
			} else {
				System.out.println("회원가입 실패");
				response.sendRedirect("3_member/joinResult.jsp?result=no");
			}
		
		} catch (Exception e) {
			System.out.println("회원가입 실패했음. 예외 메세지" + e.getMessage());
			e.printStackTrace();
			response.sendRedirect("3_member/joinResult.jsp?result=no");
		} finally {
			try {
				if(pstmt != null) { pstmt.close();}		
				if(conn != null) { conn.close(); }	
			}catch (Exception e) {}
		}
		
	}

}
