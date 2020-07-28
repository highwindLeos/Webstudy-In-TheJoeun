package com.leo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.GameDao;
import com.leo.dto.GameDto;

public class GVoteService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int gGrade = Integer.parseInt(request.getParameter("star-input"));
		String gId = request.getParameter("gId");
		
		GameDao gDao = GameDao.getInstance();
		int voteResult = gDao.gameVote(gGrade, gId);
		
		if (voteResult == GameDao.SUCCESS) {
			System.out.println("평점주기 성공 : service");
			request.setAttribute("gameVoteResult", "평점을 주었습니다"+ gGrade +"점");
		} else {
			System.out.println("평점주기 성공 : service");
		}
		
	}

}
