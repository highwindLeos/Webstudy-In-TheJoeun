package com.tj.ex.commandcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.BoardDao;

public class BoardWritCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bIp = request.getRemoteAddr(); // 立加等 矫胶袍狼 IP林家
		
		BoardDao bDao = new BoardDao();
		int result = bDao.writeBoard(bName, bTitle, bContent, bIp);
		
		request.setAttribute("writeResult", result);
	}

}
