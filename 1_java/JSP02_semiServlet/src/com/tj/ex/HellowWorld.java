package com.tj.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/HW") //WEB-INF web.xml  mapping 을 시켜준다.
public class HellowWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HellowWorld() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hellow world - GET 방식 요청");
		response.setContentType("text/html; charset = utf-8"); // 한글이 깨지기 때문에 utf-8
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet문서 작성</title>");
		out.println("<style> h1 { color : lightblue; }</style>");
		out.println("</head>");
		out.println("<body><h1>안녕 자바 세상</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hellow World - POST 방식 요청");
	}

}
