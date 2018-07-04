package com.tj.ex.commandcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.BoardDao;

public class BoardDeleteCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		BoardDao bDao = new BoardDao();
		int deleteResult = bDao.deleteBoard(bId);
		
		if(deleteResult == 1) {
			request.setAttribute("msg", "삭제가 성공되었습니다.");
		}
	}

}
