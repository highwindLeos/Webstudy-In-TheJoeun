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
		} // 없는 페이지로 로딩되면 1
		
		int currentPage = Integer.parseInt(pageNum);
		
		int PAGESIZE = 3, BLOCKSIZE = 5;
		
		int startRow = (currentPage - 1) * PAGESIZE + 1; 
		int endRow = startRow + PAGESIZE - 1;
		
		MemberDao bDao = new MemberDao();
		
		ArrayList<MemberDto> list = bDao.getListMember(startRow, endRow);
		request.setAttribute("list", list);
		
		// page 수 출력 담당 로직
		int totalCnt = bDao.getBoardCnt(); //글의 갯수를 구함
		int pageCnt = (int)Math.ceil(((double)totalCnt / PAGESIZE));
		int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		
		if (endPage > pageCnt) {
			endPage = pageCnt;
		}
		// 출력에 필요한 변수들을 request 에 묶어 놓는다.
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalCnt", totalCnt); 
	}

}
