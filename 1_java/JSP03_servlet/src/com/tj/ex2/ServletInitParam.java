package com.tj.ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = {"/ServletInitParam"},
//	initParams= {@WebInitParam(name="id", value="root"), 
//				@WebInitParam(name="pw",value="mysql"),
//				@WebInitParam(name ="jdbcDriver", value = "com.mysql.jdbc.Driver")})

public class ServletInitParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletInitParam() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String id = getInitParameter("id");
//		String pw = getInitParameter("pw");
//		String jdbcDriver = getInitParameter("jdbcdriver");
		
		String cId = getServletContext().getInitParameter("cId"); // 공유 파라미터 가져오기 : getContextParam()
		String cPw = getServletContext().getInitParameter("cPw");
		String cPath = getServletContext().getInitParameter("cPath");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
//		out.println("<h2> id : " + id + "</h2>");
//		out.println("<h2> pw : " + pw + "</h2>");
//		out.println("<h2> jdbcDriver : " + jdbcDriver + "</h2>");
		
		out.println("<h2> cId : " + cId + "</h2>");
		out.println("<h2> cPw : " + cPw + "</h2>");
		out.println("<h2> cPath : " + cPath + "</h2>");
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
