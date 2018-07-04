package com.tj.ex.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.glass.events.ViewEvent;
import com.tj.ex.commandcontroller.BoardContentCommand;
import com.tj.ex.commandcontroller.BoardDeleteCommand;
import com.tj.ex.commandcontroller.BoardListCommand;
import com.tj.ex.commandcontroller.BoardModifyCommand;
import com.tj.ex.commandcontroller.BoardReplyCommand;
import com.tj.ex.commandcontroller.BoardReplyViewCommand;
import com.tj.ex.commandcontroller.BoardWritCommand;
import com.tj.ex.commandcontroller.Command;


@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int write_view = 0;
	private int reply_view = 0;
       

    public BoardController() {
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
		// ���� ��û�� Ȯ�� �ϰ� ������ command �� ȣ���ϰ�
		// View �������� Dispatcher �Ѵ�.
		String uri = request.getRequestURI(); // "/JSP19_MVC_Board/list.do"
		String conPath = request.getContextPath(); // "/JSP19_MVC_Board
		String com = uri.substring(conPath.length());
		
		Command command = null;
		String viewPage = null;
				
		if (com.equals("/list.do")) { // /list.do ��û�ϸ� �۸�� 
			command = new BoardListCommand();
			command.excute(request, response);
			viewPage = "mvcboard/list.jsp";
			
		} else if (com.equals("/write_view.do")) {// /write_view.do ��û�ϸ� �۾��� �������� �̵� 
			
			write_view = 1;
			viewPage = "mvcboard/write_View.jsp";
			
		} else if (com.equals("/write.do")) {// /write.do ��û�ϸ� �Ķ������ ���� ������ DB insert 
			if (write_view == 1) {
				command = new BoardWritCommand();
				command.excute(request, response);
				write_view = 0;
			}
			
			viewPage = "/list.do";
			
		} else if (com.equals("/content_view.do")) {// /content_view.do?bId=2&pageNum=1 : ��û�ϸ� �󼼱� ����
			
			command = new BoardContentCommand();
			command.excute(request, response);
			viewPage = "mvcboard/content_view.jsp";
			
		} else if (com.equals("/modify.do")) {// /modify.do ��û�ϸ� �� ����
			
			command = new BoardModifyCommand();
			command.excute(request, response);
			viewPage = "/list.do";
			
			
		} else if (com.equals("/delete.do")) {// /delete.do ��û�ϸ� �� ����
			
			command = new BoardDeleteCommand();
			command.excute(request, response);
			viewPage = "/list.do";
			
		} else if (com.equals("/reply_View.do")) {// /reply_view.do ��û�ϸ� �亯�� ���� �������� �̵�
			
			reply_view = 1;
			command = new BoardReplyViewCommand();
			command.excute(request, response);
			viewPage = "mvcboard/reply_View.jsp";
			
		} else if (com.equals("/reply.do")) {// /reply.do �Ķ���� ������ �亯�� insert
			if (reply_view == 1) {
				command = new BoardReplyCommand();
				command.excute(request, response);
				reply_view = 0;
			}
			
			viewPage = "/list.do";
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
