package com.tj.mvcmember.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.mvcmember.dao.BoardDao;


public class BoardModifyCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BoardDao bDao = new BoardDao();
		int modifyResult = bDao.modifyBoard(bId, bName, bTitle, bContent);
		
		if (modifyResult == BoardDao.SUCCESS) {
			request.setAttribute("msg", "글 수정 성공했습니다.");			
		}
		
	}

}
