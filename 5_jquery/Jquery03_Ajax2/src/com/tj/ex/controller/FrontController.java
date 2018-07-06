package com.tj.ex.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.service.GetStockService;
import com.tj.ex.service.IdConfirmService;
import com.tj.ex.service.SearchEmpService;
import com.tj.ex.service.Service;


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
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String comDo = uri.substring(conPath.length());
		
		Service service = null;
		String viewPage = null;
		
		if (comDo.equals("/idConfirmView.do")) {
			
			viewPage = "idconfirm/ex02get.html";
			
		} else if (comDo.equals("/idConfirm.do")){ 
			
			service = new IdConfirmService();
			service.excute(request, response);
			viewPage = "idconfirm/confirmid.jsp";
			
		} else if (comDo.equals("/getStock.do")){ 
			
			service = new GetStockService();
			service.excute(request, response);
			viewPage = "goods/getStock.jsp";
			
		} else if (comDo.equals("/searchEmp.do")){ 
			
			service = new SearchEmpService();
			service.excute(request, response);
			viewPage = "emp/searchEmp.jsp";
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
