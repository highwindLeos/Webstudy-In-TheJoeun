package com.leo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.BoardDao;
import com.leo.dto.BoardDto;

public class BReplyViewService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		
		BoardDao bDao = BoardDao.getInstance();
		BoardDto replyView =  bDao.boardContentView(bNum);

		request.setAttribute("replyView", replyView);

	}

}
