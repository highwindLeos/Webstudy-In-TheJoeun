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
import javax.servlet.http.HttpSession;


@WebServlet("/modifyOk")
public class modifyOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	private String uid = "leos";
	private String upw = "Stonker26";
	
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	
	private String id, pw, chkPw, name, phone1, phone2, phone3, gender;
	
	private HttpSession session;
	private String sessionPw;
	
    public modifyOk() {
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
		
		id = request.getParameter("id");
		chkPw = request.getParameter("chkPw");
		pw = request.getParameter("pw");
		name = request.getParameter("name");
		phone1 = request.getParameter("phone1");
		phone2 = request.getParameter("phone2");
		phone3 = request.getParameter("phone3");
		gender = request.getParameter("gender");
		
		session = request.getSession(); // 세션을 가지고 온다.
		sessionPw = (String)session.getAttribute("pw"); // 로그인된 사용자의 패스워드
		
		if (chkPw.equals(sessionPw)) { // 현제 PW 를 제대로 친경우 데이터베이스 수정
			String updateSql = "UPDATE MEMBER SET NAME = ?, PW = ?, PHONE1 = ?, PHONE2 = ?, PHONE3= ?, GENDER = ? WHERE ID = ?";
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, uid, upw);
				pstmt = conn.prepareStatement(updateSql);
				
				pstmt.setString(1, name);
				pstmt.setString(2, pw);
				pstmt.setString(3, phone1);
				pstmt.setString(4, phone2);
				pstmt.setString(5, phone3);
				pstmt.setString(6, gender);
				pstmt.setString(7, id);
				
				int result = pstmt.executeUpdate(); // 쿼리 성공은 정수 반환으로 온다.
				
				if (result > 0) {
					System.out.println("회원정보 수정 성공");
					
					session.setAttribute("id", id);
					session.setAttribute("name", name);
					session.setAttribute("pw", pw);
					session.setAttribute("phone1", phone1);
					session.setAttribute("phone2", phone2);
					session.setAttribute("phone3", phone3);
					session.setAttribute("gender", gender);
					
					response.sendRedirect("3_member/modifyResult.jsp?result=ok");
				} else {
					System.out.println("회원정보 수정 실패");
					response.sendRedirect("3_member/modifyResult.jsp?result=no");
				}
				
			} catch (Exception e) {
				System.out.println("회원정보 수정 예외 발생" + e.getMessage());
				e.printStackTrace();
				response.sendRedirect("3_member/modifyResult.jsp?result=no");
			} finally {
				try {
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} catch (Exception e) {}
			}
		} else { // 현제 PW 를 제대로 안 쳐서 회원 수정페이지로 다시 보냄.
			response.sendRedirect("3_member/modify.jsp");
		}
	} // actionDo(); END
}
