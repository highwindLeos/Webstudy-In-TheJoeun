package com.leo.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.GameDao;
import com.leo.dto.GameDto;

public class GsearchGameService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String gName = request.getParameter("gName").toUpperCase();
		String gPub = request.getParameter("gPub").toUpperCase();
		String gDes = request.getParameter("gDes").toUpperCase();
		
		GameDao gDao = GameDao.getInstance();
		ArrayList<GameDto> searchList =  gDao.getGameListSearch(gName, gPub, gDes);
		
		request.setAttribute("searchList", searchList);
		
	}

}
