package com.tj.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dao.EmpDao;
import com.tj.dto.EmpDto;

/**
 * Servlet implementation class Emp
 */
@WebServlet("/Emp")
public class Emp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Emp() {
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
		
		EmpDao dao = new EmpDao();
		ArrayList<EmpDto> emps = dao.getEmps();
		
		request.setAttribute("emps", emps);
		RequestDispatcher dispatcher = request.getRequestDispatcher("core/emp.jsp");
		dispatcher.forward(request, response);
		
	}
}
