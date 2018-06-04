package com.tj.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletInitParam2")
public class ServletInitParam2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletInitParam2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cId = getServletContext().getInitParameter("cId"); // 공유 파라미터 가져오기 : ContextParam()
		String cPw = getServletContext().getInitParameter("cPw");
		String cPath = getServletContext().getInitParameter("cPath");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h2> cId : " + cId + "</h2>");
		out.println("<h2> cPw : " + cPw + "</h2>");
		out.println("<h2> cPath : " + cPath + "</h2>");
		out.close();
		
		System.out.println("cId : " + cId);
		System.out.println("cPw : " + cPw);
		System.out.println("cPath : " + cPath);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
