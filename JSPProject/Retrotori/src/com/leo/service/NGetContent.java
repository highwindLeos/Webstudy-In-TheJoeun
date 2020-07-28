package com.leo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.NoticeDao;
import com.leo.dto.NoticeDto;

public class NGetContent implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int nNum = Integer.parseInt(request.getParameter("nNum"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		NoticeDao nDao = new NoticeDao();
		NoticeDto ndto  = nDao.getNoticeOneRow(nNum);
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("ndto", ndto);

	}

}
