package com.leo.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.smartcardio.CommandAPDU;

import com.leo.dao.ComantDao;
import com.leo.dao.GameDao;
import com.leo.dto.ComantDto;
import com.leo.dto.GameDto;

public class GContentViewService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String gId = request.getParameter("gId");
		
		GameDao gDao = GameDao.getInstance();
		GameDto gDto = gDao.gameContentView(gId);
		
		ComantDao cDao = ComantDao.getInstance();
		ArrayList<ComantDto> comantList =  cDao.getComantForGameId(gId);
		
		if (gDto != null) {
			System.out.println("게임정보 가져오기 성공 : service");
			request.setAttribute("gameContent", gDto);
			request.setAttribute("comantList", comantList);
		} else {
			System.out.println("게임정보 가져오기 실패 : service");
		}
		
	}

}
