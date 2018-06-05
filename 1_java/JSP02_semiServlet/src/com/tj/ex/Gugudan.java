package com.tj.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex2gugu")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Gugudan() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gugu = Integer.parseInt(request.getParameter("gugu"));
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>구구단</title>");
		out.println("<style> h1 { color : lightblue; }</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>출력할 단수는 " + gugu + " 단</h1>");
			for (int i = 1; i <= 9; i++) {
				out.printf("<h2> %d * %d = %d</h2> \n", gugu, i, gugu * i);
			}
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
