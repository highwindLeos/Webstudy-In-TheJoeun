package com.tj.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI(); // /JSP17_MVC/insert.do
		String conPath = request.getContextPath(); // /JSP17_MVC
		String command = uri.substring(conPath.length()); // /insert.do
		String done = "";
		
		Service service;
		
		if (command.equals("/insert.do")) {
			
			System.out.println("Insert command 호출한다");
			done = "Insert command 호출한다";
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<p>URI : "+ uri + "</p>");		
			out.println("<p>conPath : "+ conPath + "</p>");		
			out.println("<p>command : "+ command + "</p>");		
			out.println("<p>요청이 잘들어옴 : FrontController</p>");		
			out.println("<p>요정실행 결과 : "+ done + "</p>");		
			out.println("</body></html>");
			out.close();
			
		} else if (command.equals("/select.do")) {
			
			System.out.println("Select command 호출한다");
			done = "Select command 호출한다";
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<p>URI : "+ uri + "</p>");		
			out.println("<p>conPath : "+ conPath + "</p>");		
			out.println("<p>command : "+ command + "</p>");		
			out.println("<p>요청이 잘들어옴 : FrontController</p>");		
			out.println("<p>요정실행 결과 : "+ done + "</p>");		
			out.println("</body></html>");
			out.close();
			
		} else if (command.equals("/update.do")) {
			
			System.out.println("Update command 호출한다");
			done = "Update command 호출한다";
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<p>URI : "+ uri + "</p>");		
			out.println("<p>conPath : "+ conPath + "</p>");		
			out.println("<p>command : "+ command + "</p>");		
			out.println("<p>요청이 잘들어옴 : FrontController</p>");		
			out.println("<p>요정실행 결과 : "+ done + "</p>");		
			out.println("</body></html>");
			out.close();
			
		} else if (command.equals("/delete.do")) {
			
			System.out.println("Delete command 호출한다");
			done = "Delete command 호출한다";
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<p>URI : "+ uri + "</p>");		
			out.println("<p>conPath : "+ conPath + "</p>");		
			out.println("<p>command : "+ command + "</p>");		
			out.println("<p>요청이 잘들어옴 : FrontController</p>");		
			out.println("<p>요정실행 결과 : "+ done + "</p>");		
			out.println("</body></html>");
			out.println("<html><body>");
			out.close();

			
		} else if (command.equals("/membersAll.do")) {
			System.out.println("membersAll 호출한다");
			service = new MembersAllService();
			ArrayList<MembersDto> members = service.excute(request, response);
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<link rel='stylesheet' href='css/board.css' >");
			out.println("</head>");
			out.println("<body>");
			out.println("<table>");
				out.println("<tr>");
				out.println("<td colspan='7'><h1>MEMBERS TABLE</h1></td>");
				out.println("</tr>");
			out.println("<tr>");
				out.println("<td><h3>아이디</h3></td>");
				out.println("<td><h3>패스워드</h3></td>");
				out.println("<td><h3>회원이름</h3></td>");
				out.println("<td><h3>이메일</h3></td>");
				out.println("<td><h3>생년월일</h3></td>");
				out.println("<td><h3>가입일</h3></td>");
				out.println("<td><h3>주소</h3></td>");
			out.println("</tr>");
			for (MembersDto mt : members) {
			out.println("<tr>");
				out.println("<td>" + mt.getId()  + "</td>");
				out.println("<td>" + mt.getPw()  + "</td>");
				out.println("<td>" + mt.getName()  + "</td>");
				out.println("<td>" + mt.getEmail()  + "</td>");
				out.println("<td>" + mt.getBirth()  + "</td>");
				out.println("<td>" + mt.getrDate()  + "</td>");
				out.println("<td>" + mt.getAddress()  + "</td>");
			out.println("</tr>");
			}
				out.println("<tr>");
				out.println("<td colspan='7'><h3>leo Publising</h3></td>");
				out.println("</tr>");
			out.println("</table>");
			out.println("</body></html>");
			out.close();
			
		} else if (command.equals("/membersJoin.do")) {
			System.out.println("membersJoin 호툴한다");
			done = "membersJoin command 호툴한다";

			service = new JoinMembersService();
			service.excute(request, response);

			int result = (Integer)request.getAttribute("joinResult");
			
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<p>URI : "+ uri + "</p>");		
			out.println("<p>");
			out.println((result == 1) ? "가입성공" : "가입실패" );
			out.println("</p>");
			out.println("<p>command : "+ command + "</p>");		
			out.println("<p>요청이 잘들어옴 : FrontController</p>");		
			out.println("<p>요정실행 결과 : "+ done + "</p>");		
			out.println("</body></html>");
			out.close();
		}
	}
}
