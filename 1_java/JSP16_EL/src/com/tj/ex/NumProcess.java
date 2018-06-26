package com.tj.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/numProcess")
public class NumProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NumProcess() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		int sum = 0;
		
		for (int i = 0; i < num; i++) {
			sum += i;
		}
		
		request.setAttribute("sum", sum);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("dispatcher/numView.jsp");
		dispatcher.forward(request, response);
		// response.sendRedirect("dipatcher/numView.jsp"); 값을 같이 넘기지 못하기 때문에 해당 요청은 의미가 없다.
	}

}
