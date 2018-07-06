package com.tj.ex.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.EmpDao;
import com.tj.ex.dto.EmpDto;

public class SearchEmpService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String searchEname = request.getParameter("searchEname").toUpperCase();	
		String searchJob = request.getParameter("searchJob").toUpperCase();	

		EmpDao edao = EmpDao.getInstance();
		ArrayList<EmpDto> emps = edao.searchEmpList(searchEname, searchJob);
		
		request.setAttribute("emps", emps);
		
	}

}
