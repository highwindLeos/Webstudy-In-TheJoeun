package com.tj.mvcmember.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.mvcmember.dao.MemberDao;
import com.tj.mvcmember.dto.MemberDto;

public class MAllViewCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String pageNum = request.getParameter("pageNum");
		
		if (pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		} // 
		
		int currentPage = Integer.parseInt(pageNum);
		
		int PAGESIZE = 3, BLOCKSIZE = 5;
		
		int startRow = (currentPage - 1) * PAGESIZE + 1; 
		int endRow = startRow + PAGESIZE - 1;
		
		MemberDao mDao = new MemberDao();
		
		ArrayList<MemberDto> list = mDao.getListMember(startRow, endRow);
		request.setAttribute("list", list);
		
		int totalCnt = mDao.getMemberCnt(); //갯수를 가져온다.
		int pageCnt = (int)Math.ceil(((double)totalCnt / PAGESIZE));
		int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		
		if (endPage > pageCnt) {
			endPage = pageCnt;
		}
		
		// 필요한 변수를 request 에 묶어 놓는다.
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalCnt", totalCnt); 
	}

}
