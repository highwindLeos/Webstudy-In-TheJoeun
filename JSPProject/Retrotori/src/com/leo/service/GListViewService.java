package com.leo.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.GameDao;
import com.leo.dto.GameDto;

public class GListViewService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		// gameListView.do?pageNum=1 
		// gameListView.do			
		String pageNum = request.getParameter("pageNum");
		
		if (pageNum == null || pageNum.equals("")) {
			pageNum = "1";
		} // 페이지 가없으면 1페이지 
		
		int currentPage = Integer.parseInt(pageNum);
		
		int PAGESIZE = 10, BLOCKSIZE = 5;
		
		int startRow = (currentPage - 1) * PAGESIZE + 1; 
		int endRow = startRow + PAGESIZE - 1;
		
		GameDao gDao = GameDao.getInstance();
		
		ArrayList<GameDto> gamelist = gDao.getGameList(startRow, endRow);
		request.setAttribute("gamelist", gamelist);
		
		// page 편집
		int totalCnt = gDao.getGameCnt(); 
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
