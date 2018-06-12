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
		
		session = request.getSession(); // ������ ������ �´�.
		sessionPw = (String)session.getAttribute("pw"); // �α��ε� ������� �н�����
		
		if (chkPw.equals(sessionPw)) { // ���� PW �� ����� ģ��� �����ͺ��̽� ����
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
				
				int result = pstmt.executeUpdate(); // ���� ������ ���� ��ȯ���� �´�.
				
				if (result > 0) {
					System.out.println("ȸ������ ���� ����");
					
					session.setAttribute("id", id);
					session.setAttribute("name", name);
					session.setAttribute("pw", pw);
					session.setAttribute("phone1", phone1);
					session.setAttribute("phone2", phone2);
					session.setAttribute("phone3", phone3);
					session.setAttribute("gender", gender);
					
					response.sendRedirect("3_member/modifyResult.jsp?result=ok");
				} else {
					System.out.println("ȸ������ ���� ����");
					response.sendRedirect("3_member/modifyResult.jsp?result=no");
				}
				
			} catch (Exception e) {
				System.out.println("ȸ������ ���� ���� �߻�" + e.getMessage());
				e.printStackTrace();
				response.sendRedirect("3_member/modifyResult.jsp?result=no");
			} finally {
				try {
					if (pstmt != null) pstmt.close();
					if (conn != null) conn.close();
				} catch (Exception e) {}
			}
		} else { // ���� PW �� ����� �� �ļ� ȸ�� ������������ �ٽ� ����.
			response.sendRedirect("3_member/modify.jsp");
		}
	} // actionDo(); END
}
