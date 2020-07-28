package com.leo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.MemberDao;
import com.leo.dto.MemberDto;

public class MMemberGetService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String mId = request.getParameter("mId");
		
		MemberDao mDao = new MemberDao();
		MemberDto mDto = mDao.getMember(mId);
		
		if (mDto != null) {
			System.out.println("멤버 가져오기 성공 : service");
			request.setAttribute("modifyMember", mDto);
		} else {
			System.out.println("멤버 가져오기 실패 : service");
		}

	}

}
