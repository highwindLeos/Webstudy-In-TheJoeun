package com.tj.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ArrayParameter")
public class ArrayParameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String encodingUTF8 = "utf-8";

    public ArrayParameter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출됨");
		String[] menu = request.getParameterValues("menu");
		String[] rest = request.getParameterValues("rest");
		String nation = request.getParameter("nation");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("</body>");
		out.println("<h2>선택한 메뉴는");
		for (String m : menu) {
			out.println(m + " ");
		}
		out.println("</h2>");
		out.println("<h2>선택한 식당은 ");
		for (String r : rest) {
			out.println(r + " ");
		}
		out.println("</h2>");
		out.println("<h2>선택한 국적은 " + nation + "</h2>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPOST() 호출됨.");
		request.setCharacterEncoding(encodingUTF8);
		doGet(request, response);
	}

}
