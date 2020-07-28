package com.leo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.FollowDao;

public class MUnFollowService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String mId = request.getParameter("mId");
		String fId = request.getParameter("fId");
		String mName = request.getParameter("mName");
		
		FollowDao fDao = FollowDao.getInstance();
		int followResult = fDao.UnFollow(mId, fId);
		
		if (followResult == FollowDao.SUCCESS) {
			System.out.println("언팔로우 성공 : service");
			request.setAttribute("unfollolwResult", mName+"님을 언팔로우 했습니다.");
		} else {
			System.out.println("언팔로우 실패 : service");		
		}

	}

}
