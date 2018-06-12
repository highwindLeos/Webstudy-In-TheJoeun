package com.tj.ex;


import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;


@WebServlet("/loginOK")
public class loginOK extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	private String uid = "leos";
	private String upw = "Stonker26";
	
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	private String id, pw, name;
	
    public loginOK() {
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
		pw = request.getParameter("pw");
		
		String selectSql = String.format("SELECT * FROM MEMBER WHERE ID='%s' AND PW='%s'", id, pw) ;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uid, upw);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSql);
			
			if (rs.next()) { // �α��� ���� = �������� + ���������� �̵�
				
				name = rs.getString("name");
				id = rs.getString("id");
				pw = rs.getString("pw");
				
				HttpSession session = request.getSession(); // ������ ����
				session.setAttribute("name", name);
				session.setAttribute("id", id);
				session.setAttribute("pw", pw);
				
				response.sendRedirect("3_member/loginResult.jsp");
				
			} else { // �α��� ����
				String msg = URLEncoder.encode("�α��ο� ���� �Ͽ����ϴ�.���̵� �н����� üũ�ϼ���.", "utf-8");
				response.sendRedirect("3_member/login.jsp?msg=" + msg);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) { }
		}
		
	}

}
