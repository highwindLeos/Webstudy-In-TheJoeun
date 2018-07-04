package com.tj.mvcmember.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.mvcmember.dao.BoardDao;


public class BoardDeleteCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		BoardDao bDao = new BoardDao();
		int deleteResult = bDao.deleteBoard(bId);
		
		if(deleteResult == 1) {
			request.setAttribute("msg", "글 삭제 성공");
		}
	}

}
