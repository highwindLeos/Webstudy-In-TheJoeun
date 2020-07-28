package com.leo.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.BoardDao;
import com.leo.dao.GameDao;
import com.leo.dao.NoticeDao;
import com.leo.dto.BoardDto;
import com.leo.dto.GameDto;
import com.leo.dto.NoticeDto;

public class MainNewListService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		NoticeDao nDao = new NoticeDao();
		ArrayList<NoticeDto> nDtos =  nDao.getListNoticeNewFiveRows();
		
		if (nDtos != null) {
			System.out.println("최신공지 가져오기 : service");
			request.setAttribute("NoticeNewList", nDtos);
		}
		
		BoardDao bDao = BoardDao.getInstance();
		ArrayList<BoardDto> bDtos = bDao.getBoadListNewFiveRows();
		
		if (bDtos != null) {
			System.out.println("최신게시판글 가져오기 : service");
			request.setAttribute("BoardNewList", bDtos);		
		}
		
		GameDao gDao = GameDao.getInstance();
		ArrayList<GameDto> gDtos = gDao.getGameListNewEightRows();
		
		if (gDtos != null) {
			System.out.println("최신 게임 가져오기 : service");
			request.setAttribute("GameNewList", gDtos);
		}
		
		
	}

}
