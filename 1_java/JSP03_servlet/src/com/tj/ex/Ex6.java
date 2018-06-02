package com.tj.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex6")
public class Ex6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String encodingUTF8 = "utf-8";

       
    public Ex6() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출됨");
		String name = request.getParameter("name");
		String address = request.getParameter("address");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>이름은 : " + name + " 주소는 : " + address + "</h3>");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(encodingUTF8); //포스트 방식의 한글이 깨짐을 utf-8 인코딩한다.
		doGet(request, response);
	}

}
