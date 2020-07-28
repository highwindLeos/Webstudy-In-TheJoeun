package com.leo.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.BoardDao;
import com.leo.dao.NoticeDao;
import com.leo.dto.BoardDto;
import com.leo.dto.NoticeDto;

public class BListService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
				// boardListView.do?pageNum=1 
				// boardListView.do			
				String pageNum = request.getParameter("pageNum");
				
				if (pageNum == null || pageNum.equals("")) {
					pageNum = "1";
				} // 페이지 가없으면 1페이지 
				
				int currentPage = Integer.parseInt(pageNum);
				
				int PAGESIZE = 10, BLOCKSIZE = 5;
				
				int startRow = (currentPage - 1) * PAGESIZE + 1; 
				int endRow = startRow + PAGESIZE - 1;
				
				BoardDao bDao = BoardDao.getInstance();
				
				ArrayList<BoardDto> list = bDao.getBoadList(startRow, endRow);
				request.setAttribute("list", list);
				
				// page 편집
				int totalCnt = bDao.getBoardCnt(); 
				int pageCnt = (int)Math.ceil(((double)totalCnt / PAGESIZE));
				int startPage = ((currentPage - 1) / BLOCKSIZE) * BLOCKSIZE + 1;
				int endPage = startPage + BLOCKSIZE - 1;
				
				if (endPage > pageCnt) {
					endPage = pageCnt;
				}
				// 필요한 변수를 request 에 담는다.
				request.setAttribute("pageCnt", pageCnt);
				request.setAttribute("startPage", startPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("BLOCKSIZE", BLOCKSIZE);
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("totalCnt", totalCnt);

	}

}
