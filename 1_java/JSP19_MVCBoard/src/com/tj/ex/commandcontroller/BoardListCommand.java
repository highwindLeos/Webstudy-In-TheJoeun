package com.tj.ex.commandcontroller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.BoardDao;
import com.tj.ex.dto.BoardDto;

public class BoardListCommand  implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		// list.do?pageNum=1 -- 2������ ��������
		// list.do			-- 1������ ��������
		
		String pageNum = request.getParameter("pageNum");
		
		if (pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		} // ���� �������� �ε��Ǹ� 1
		
		int currentPage = Integer.parseInt(pageNum);
		
		int PAGESIZE = 10, BLOCKSIZE = 10;
		
		int startRow = (currentPage - 1) * PAGESIZE + 1; 
		int endRow = startRow + PAGESIZE - 1;
		
		BoardDao bDao = new BoardDao();
		
		ArrayList<BoardDto> list = bDao.listBoard(startRow, endRow);
		request.setAttribute("list", list);
		
		// page �� ��� ��� ����
		int totalCnt = bDao.getBoardCnt(); //���� ������ ����
		int pageCnt = (int)Math.ceil(((double)totalCnt / PAGESIZE));
		int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
		int endPage = startPage + BLOCKSIZE - 1;
		
		if (endPage > pageCnt) {
			endPage = pageCnt;
		}
		// ��¿� �ʿ��� �������� request �� ���� ���´�.
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("BLOCKSIZE", BLOCKSIZE);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalCnt", totalCnt); 
		
	}
	
}
