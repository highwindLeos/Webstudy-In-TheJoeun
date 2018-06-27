package com.tj.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.dao.MembersDao;
import com.tj.dto.MembersDto;

public class MembersAllService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		MembersDao mDao = new MembersDao();
		ArrayList<MembersDto> members = mDao.getMembersAll();
		request.setAttribute("membersAll", members);
		
	}

}
