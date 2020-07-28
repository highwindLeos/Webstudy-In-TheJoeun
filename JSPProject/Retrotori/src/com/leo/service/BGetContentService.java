package com.leo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.BoardDao;
import com.leo.dto.BoardDto;

public class BGetContentService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		
		BoardDao bDao = BoardDao.getInstance();
		BoardDto bDto = bDao.boardContentView(bNum);
		
		if (bDto != null) {
			System.out.println("글 가져오기 성공 : service");
			request.setAttribute("bDto", bDto);
		} else {
			System.out.println("글 가져오기 실패 : service");
		}
	}

}
