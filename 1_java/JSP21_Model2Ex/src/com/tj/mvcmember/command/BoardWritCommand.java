package com.tj.mvcmember.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.mvcmember.dao.BoardDao;


public class BoardWritCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bIp = request.getRemoteAddr(); // 글쓰는 컴퓨터의 IP
		
		BoardDao bDao = new BoardDao();
		int result = bDao.writeBoard(mId, bTitle, bContent, bIp);
		
		request.setAttribute("writeResult", result);
	}

}
