package com.tj.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.service.MembersAllService;
import com.tj.service.MembersJoinService;
import com.tj.service.Service;


@WebServlet("*.do")
public class MembersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MembersController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

		String uri = request.getRequestURI(); // /JSP18_MVC/***.do
		System.out.println(uri);
		String conPath = request.getContextPath(); // /JSP18_MVC
		System.out.println(conPath);
		String command = uri.substring(conPath.length()); // /***/do
		System.out.println(command);
		
		String viewPage = null; // 보낼 페이지를 저장하는 변수
		Service service = null;
		
		if(command.equals("/joinForm.do")) {
			
			viewPage = "member/join.jsp";
			
		} else if (command.equals("/membersJoin.do")) {
			
			service = new MembersJoinService();
			service.excute(request, response);
			viewPage = "member/joinResult.jsp";
			
		} else if(command.equals("/membersAll.do")) {
			
			service = new MembersAllService();
			service.excute(request, response);
			viewPage = "member/membersView.jsp";
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // 기능이 전달된 것에 따라 보내는 페이지가 달라짐
		dispatcher.forward(request, response);
		
	}

}
