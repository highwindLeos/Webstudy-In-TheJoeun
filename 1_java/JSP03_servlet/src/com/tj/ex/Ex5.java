package com.tj.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex5")
public class Ex5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Ex5() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출됨");
		String[] colorSet = {"red", "orange", "yellow", "green", "blue", "navy", "violet"};
		int i; // 배경색은 넘어온 파라미터, 글자색은 colorSet[i] 가 될 예정
		String color = request.getParameter("color");
		
		System.out.println(color);
		
		for (i = 0; i < colorSet.length; i++) {
			if(colorSet[i].equals(color)) {
				break;
			}
		}
		
		if(i == 0) {
			i = 6;
		} else {
			i--;
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>배경색 글자색 변경</title>");
		out.println("<style>");
		out.println("h3 { color : " + colorSet[i] + "; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body bgcolor="+ color +">");
		out.println("<h3>글자색은"+ colorSet[i] + "배경색은 " + color + "입니다.</h3>");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //포스트 방식의 한글이 깨짐을 utf-8 인코딩한다.
		doGet(request, response);
	}

}