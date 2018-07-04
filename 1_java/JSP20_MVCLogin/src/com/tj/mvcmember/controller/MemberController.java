package com.tj.mvcmember.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.mvcmember.command.Command;
import com.tj.mvcmember.command.MAllViewCommand;
import com.tj.mvcmember.command.MDeleteCommand;
import com.tj.mvcmember.command.MGetMemberCommand;
import com.tj.mvcmember.command.MLoginCommand;
import com.tj.mvcmember.command.MLogoutCommand;
import com.tj.mvcmember.command.MModifyCommand;
import com.tj.mvcmember.command.MRegisterCommand;


@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberController() {
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
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String comDo = uri.substring(conPath.length());
		
		Command command = null;
		String viewPage = null;
		
		if (comDo.equals("/loginForm.do")) {
			
			viewPage = "member/login.jsp";
			
		}  else if (comDo.equals("/main.do")) {
			
			command = new MGetMemberCommand();
			command.excute(request, response);
			viewPage = "member/main.jsp";
			
		} else if (comDo.equals("/login.do")) {
			
			command = new MLoginCommand();
			command.excute(request, response);
			viewPage = "member/main.jsp";
			
		} else if (comDo.equals("/registerForm.do")) {
			
			viewPage = "member/registerForm.jsp";
			
		} else if (comDo.equals("/register.do")) {
			
			command = new MRegisterCommand();
			command.excute(request, response);
			viewPage = "/loginForm.do";
			
		}  else if (comDo.equals("/logout.do")) {
			
			command = new MLogoutCommand();
			command.excute(request, response);
			viewPage = "/loginForm.do";
			
		} else if (comDo.equals("/modifyForm.do")) {
			
			command = new MGetMemberCommand();
			command.excute(request, response);
			viewPage = "member/modifyForm.jsp";
			
		}  else if (comDo.equals("/modify.do")) {
			
			command = new MModifyCommand();
			command.excute(request, response);
			viewPage = "/main.do";
			
		} else if(comDo.equals("/mAllView.do")) {
			
			command = new MAllViewCommand();
			command.excute(request, response);
			viewPage = "member/mAllView.jsp";
			
		} else if(comDo.equals("/delete.do")) {
			
			command = new MDeleteCommand();
			command.excute(request, response);
			viewPage = "/loginForm.do";
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
