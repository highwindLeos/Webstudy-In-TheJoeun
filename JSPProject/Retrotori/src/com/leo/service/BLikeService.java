package com.leo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.BoardDao;

public class BLikeService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		
		BoardDao bDao = BoardDao.getInstance();
		int likeResult = bDao.contentLikeUp(bNum);
		
		if (likeResult == BoardDao.SUCCESS) {
			System.out.println("좋아요 성공 : service");
			request.setAttribute("LikeResult", "좋아요를 했습니다.");
		} else {
			System.out.println("좋아요 실패 : service");
			
		}
	}

}
