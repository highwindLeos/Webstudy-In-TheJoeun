package com.tj.ex.commandcontroller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.commandcontroller.Command;
import com.tj.ex.dao.BoardDao;

public class BoardReplyCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int bid = Integer.parseInt(request.getParameter("bId"));
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bGroup= request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");
		String bIp = request.getRemoteAddr();
		
		BoardDao bDao = new BoardDao();
		int replyResult = bDao.reply(bGroup, bStep, bIndent, bName, bTitle, bContent, bIp);
		
		if (replyResult == 1) {
			request.setAttribute("msg", "답변글 달기 성공했습니다.");			
		}
	
	}

}
