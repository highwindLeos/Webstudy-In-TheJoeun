package com.tj.mvcmember.command;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.mvcmember.dao.BoardDao;



public class BoardReplyCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int bid = Integer.parseInt(request.getParameter("bId"));
		String mId = request.getParameter("mId");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bGroup= request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");
		String bIp = request.getRemoteAddr();
		
		BoardDao bDao = new BoardDao();
		int replyResult = bDao.reply(bGroup, bStep, bIndent, mId, bTitle, bContent, bIp);
		
		if (replyResult == BoardDao.SUCCESS) {
			request.setAttribute("msg", "답변글이 달렸습니다");			
		}
	
	}

}
