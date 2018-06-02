package com.tj.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex3")
public class Ex3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String encodingUTF8 = "utf-8";

    public Ex3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출됨");
		int endnum = Integer.parseInt(request.getParameter("endnum"));
		
		int sum = 0;
		
		for (int i = 0; i < endnum; i++) {
			sum += i;
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3> 1부터 ~ "+ endnum + "까지의 합은 " + sum + "</h3>");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(encodingUTF8);
		doGet(request, response);
	}

}
