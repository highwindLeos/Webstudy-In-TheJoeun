package com.leo.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.GameDao;
import com.leo.dto.GameDto;

public class GsearchGameDetailService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String gName = request.getParameter("gName").toUpperCase();
		String gPub = request.getParameter("gPub").toUpperCase();
		String gDes = request.getParameter("gDes").toUpperCase();
		int gGno = Integer.parseInt(request.getParameter("gGrade"));
		int gGrade = Integer.parseInt(request.getParameter("gradeAvg"));
		String gId = request.getParameter("gIdTag").toUpperCase();
		
		GameDao gDao = GameDao.getInstance();
		ArrayList<GameDto> searchDetailList =  gDao.getGameListDetailSearch(gName, gPub, gDes, gGno, gGrade, gId);
		
		request.setAttribute("searchDetailList", searchDetailList);

	}

}
