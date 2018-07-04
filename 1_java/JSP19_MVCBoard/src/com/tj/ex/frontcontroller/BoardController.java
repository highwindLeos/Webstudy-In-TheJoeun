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
		// 들어온 요청을 확인 하고 적절한 command 를 호출하고
		// View 페이지로 Dispatcher 한다.
		String uri = request.getRequestURI(); // "/JSP19_MVC_Board/list.do"
		String conPath = request.getContextPath(); // "/JSP19_MVC_Board
		String com = uri.substring(conPath.length());
		
		Command command = null;
		String viewPage = null;
				
		if (com.equals("/list.do")) { // /list.do 요청하면 글목록 
			command = new BoardListCommand();
			command.excute(request, response);
			viewPage = "mvcboard/list.jsp";
			
		} else if (com.equals("/write_view.do")) {// /write_view.do 요청하면 글쓰기 페이지로 이동 
			
			write_view = 1;
			viewPage = "mvcboard/write_View.jsp";
			
		} else if (com.equals("/write.do")) {// /write.do 요청하면 파라미터의 값을 가지고 DB insert 
			if (write_view == 1) {
				command = new BoardWritCommand();
				command.excute(request, response);
				write_view = 0;
			}
			
			viewPage = "/list.do";
			
		} else if (com.equals("/content_view.do")) {// /content_view.do?bId=2&pageNum=1 : 요청하면 상세글 보기
			
			command = new BoardContentCommand();
			command.excute(request, response);
			viewPage = "mvcboard/content_view.jsp";
			
		} else if (com.equals("/modify.do")) {// /modify.do 요청하면 글 수정
			
			command = new BoardModifyCommand();
			command.excute(request, response);
			viewPage = "/list.do";
			
			
		} else if (com.equals("/delete.do")) {// /delete.do 요청하면 글 삭제
			
			command = new BoardDeleteCommand();
			command.excute(request, response);
			viewPage = "/list.do";
			
		} else if (com.equals("/reply_View.do")) {// /reply_view.do 요청하면 답변글 쓰기 페이지로 이동
			
			reply_view = 1;
			command = new BoardReplyViewCommand();
			command.excute(request, response);
			viewPage = "mvcboard/reply_View.jsp";
			
		} else if (com.equals("/reply.do")) {// /reply.do 파라미터 값으로 답변글 insert
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
