package com.leo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.GameDao;

public class GDeleteService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		String gId = request.getParameter("gId");
		
		GameDao gDao = GameDao.getInstance();
		int deleteResult = gDao.deleteGame(gId);
		
		if (deleteResult == GameDao.SUCCESS) {
			System.out.println("게임삭제 성공 : service");
			request.setAttribute("gameDeleteResult", "게임항목이 삭제 되었습니다." + gId);
		} else {
			System.out.println("게임삭제 성공 : service");
		}

	}

}
