package com.leo.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.BoardDao;
import com.leo.dao.ComantDao;
import com.leo.dao.FollowDao;
import com.leo.dao.GameDao;
import com.leo.dao.MemberDao;
import com.leo.dto.BoardDto;
import com.leo.dto.ComantDto;
import com.leo.dto.FollowDto;
import com.leo.dto.MemberDto;

public class ProFileViewService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String mId = request.getParameter("mId");
		String fId = mId;

		MemberDao mDao = new MemberDao();
		FollowDao fDao = FollowDao.getInstance();
		BoardDao bDao = BoardDao.getInstance();
		ComantDao cDao = ComantDao.getInstance();
		
		MemberDto Mdto =  mDao.getMember(mId);
		
		int followCnt = fDao.getFollowCnt(mId);
		ArrayList<FollowDto> followDtos = fDao.getFollowList(mId);
		
		int followerCnt = fDao.getFollowerCnt(fId);
		ArrayList<FollowDto> followerDtos = fDao.getFollowerList(fId);
		
		ArrayList<BoardDto> newBoradList = bDao.getBoadListNewFiveRows(mId);
		
		ArrayList<ComantDto> newComantList = cDao.getComantNewListMemberId(mId);
		
		request.setAttribute("followCnt", followCnt);
		request.setAttribute("followerCnt", followerCnt);
		
		request.setAttribute("followDtos", followDtos);
		request.setAttribute("followerDtos", followerDtos);

		request.setAttribute("Mdto", Mdto);
		request.setAttribute("newBoradList", newBoradList);
		request.setAttribute("newComantList", newComantList);
	}

}
