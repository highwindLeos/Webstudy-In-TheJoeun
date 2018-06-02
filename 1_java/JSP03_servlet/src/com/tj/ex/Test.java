package com.tj.ex;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.media.sound.RealTimeSequencerProvider;

@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Test() {
        super();
    }

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service 호출 됨");
//		
//		String parameter = request.getParameter("parameter");
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter write = response.getWriter();
//		write.println("<html>");
//		write.println("<head>");
//		write.println("<title>GET Page</title>");
//		write.println("</head>");
//		write.println("<body>");
//		write.println("<h1>Service요청으로 받았습니다 (" + parameter + ")</h1>");
//		write.println("</body>");
//		write.println("</html>");
//		write.close();
//	} // service() 가 있다면 요청이 무조건 이쪽으로 오게 된다. 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 호출 됨");
		
		String parameter = request.getParameter("parameter");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter write = response.getWriter();
		write.println("<html>");
		write.println("<head>");
		write.println("<title>GET Page</title>");
		write.println("</head>");
		write.println("<body>");
		write.println("<h1>GET 방식으로 요청 받았습니다 (" + parameter + ")</h1>");
		write.println("</body>");
		write.println("</html>");
		write.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //포스트 방식의 한글이 깨짐을 utf-8 인코딩한다.
		doGet(request, response);
	} // 포스트로 넘어와도  doGet(); 쪽으로 넘겨준다. 처리는 항상 doGet() 으로.

}
