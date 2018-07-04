package com.tj.ex.commandcontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.BoardDao;

public class BoardModifyCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BoardDao bDao = new BoardDao();
		int modifyResult = bDao.modifyBoard(bId, bName, bTitle, bContent);
		
		if (modifyResult == 1) {
			request.setAttribute("msg", "수정이 성공되었습니다.");			
		}
		
	}

}
