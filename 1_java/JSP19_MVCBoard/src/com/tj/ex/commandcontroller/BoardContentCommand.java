package com.tj.ex.commandcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.BoardDao;
import com.tj.ex.dto.BoardDto;

public class BoardContentCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		BoardDao bDao = new BoardDao();
		BoardDto content_view = bDao.contentView(bId);
		request.setAttribute("content_view", content_view);
	}

}