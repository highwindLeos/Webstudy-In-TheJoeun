package com.tj.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex7")
public class Ex7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex7() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출됨");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String description = request.getParameter("description");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("table { background-color : lightblue; }");
		out.println("table tr td { background-color : #fff; text-align : center; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr><td colspan='2'><h2>반갑습니다."+ author +" 님</h2></td></tr>");
		out.println("<tr><td>글제목</td><td>"+ title +"</td></tr>");
		out.println("<tr><td>글내용</td><td>"+ description +"</td></tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //포스트 방식의 한글이 깨짐을 utf-8 인코딩한다.
		doGet(request, response);
	}

}
